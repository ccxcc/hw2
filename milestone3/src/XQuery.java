import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import java.util.Iterator;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class XQuery {
    public static void main(String[] args) {
        try {

            String query1 = "for $a1 in doc(\"j_caesar.xml\")//ACT/..//ACT,\n" +
                    "    $a2 in $a1//ACT/..//ACT,\n" +
                    "    $sc1 in $a1//SCENE,\n" +
                    "    $sc2 in $a2//SCENE,\n" +
                    "    $sp1 in $sc1//SPEAKER/text(),\n" +
                    "    $sp2 in $sc2//SPEAKER,\n" +
                    "    $sl1 in $sc1//LINE,\n" +
                    "    $sl2 in $sc2//LINE\n" +
                    "where $sp1 =\"FLAVIUS\" and $sc1 eq $sc2 and $sl1 eq $sl2\n" +
                    "return\n" +
                    "<result>{\n" +
                    "<title>{$sc1/TITLE/text()}</title>\n" +
                    "}</result>";
            String query2 = "for $tuple in join(\n" +
                    "\tfor $a in doc(\"j_caesar.xml\")//ACT,\n" +
                    "\t$sp in $a//SPEAKER\n" +
                    "\treturn <tuple>{\n" +
                    "\t<a>{$a}</a>,\n" +
                    "\t<sp>{$sp}</sp>\n" +
                    "\t}</tuple>,\n" +
                    "\tfor $s in doc(\"j_caesar.xml\")//SPEAKER,\n" +
                    "\t$stxt in $s/text()\n" +
                    "\twhere $stxt = \"CAESAR\"\n" +
                    "\treturn <tuple>{\n" +
                    "\t<s>{$s}</s>,\n" +
                    "\t<stxt>{$stxt}</stxt>\n" +
                    "\t}</tuple>,\n" +
                    "\t[sp],[s])\n" +
                    "return <act>{\n" +
                    "\t($tuple/a/*/TITLE/text())\n" +
                    "\t}</act>";
            ANTLRInputStream input = new ANTLRInputStream(query1);
            XQueryLexer lexer = new XQueryLexer(input);

//            XPathLexer lexer = new XPathLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XQueryParser parser = new XQueryParser(tokens);
//            XPathParser parser = new XPathParser(tokens);
            parser.removeParseListeners();

            ParseTree tree = parser.xq();
            EvalXQuery eva = new EvalXQuery();
            long startTime = System.currentTimeMillis();
            ArrayList<Node> rstNodes = eva.visit(tree);
            long totalTime = System.currentTimeMillis() - startTime;

            File writename = new File("output.txt"); // rp
            writename.createNewFile(); // create

            BufferedWriter out = new BufferedWriter(new FileWriter(writename));

            for (int i = 0; i < rstNodes.size(); i++) {
                System.out.println(output(rstNodes.get(i), 0));
                out.write(output(rstNodes.get(i), 0));
            }
            out.flush(); // out
            out.close(); // close
            System.out.print("Original version time:");
            System.out.println(totalTime);
            String rewriteXq = rewrite(tree);
//            System.out.println(rewriteXq);

            File rewriteFile = new File("rewrite.txt"); // rp

            if(!rewriteXq.isEmpty()) {
                try {
                    BufferedWriter rewriteOut = new BufferedWriter(new FileWriter(rewriteFile));
                    rewriteOut.write(rewriteXq);
                    rewriteOut.close();
                }
                catch (IOException e)
                {
                    System.out.println("Exception ");
                }
                input = new ANTLRInputStream(rewriteXq);
                lexer = new XQueryLexer(input);
                tokens = new CommonTokenStream(lexer);
                parser = new XQueryParser(tokens);
                tree = parser.xq();
                ArrayList<Node> rst = eva.visit(tree);
                File writename2 = new File("output2.txt"); // rp
                writename2.createNewFile(); // create

                BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));

                for (int i = 0; i < rst.size(); i++) {
                    System.out.println(output(rst.get(i), 0));
                    out2.write(output(rst.get(i), 0));
                }
                out2.flush(); // out
                out2.close(); // close
//                System.out.print("Original version time:");
//                System.out.println(totalTime);
            } else {
                System.out.println("No need to rewrite the query!");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static String output(Node node, int indentNumber) {
        if(node instanceof Attr) {       //check type
            return node.getNodeName() + "=" + node.getNodeValue();
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        if(indentNumber > 0) {
            transformerFactory.setAttribute("indent-number", indentNumber);
        }
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(node), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerConfigurationException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String rewrite(ParseTree tree){
        String result = "for $tuple in ";
        System.out.println(tree.toString());
        ParseTree xq = tree;
        String resultTag = null;
        if (!xq.getChild(0).getText().contains("for")){
            resultTag = xq.getChild(1).getText();
            for (int i=0; i<xq.getChildCount(); ++i){
                if (xq.getChild(i).getText().contains("for")){
                    xq = xq.getChild(i);
                }
            }
        }
        ParseTree forClause = xq.getChild(0);
        ParseTree whereClause = xq.getChild(1);
        ParseTree returnClause = xq.getChild(2);

        LinkedHashMap<String, LinkedHashMap<String, String>> varMap = new LinkedHashMap<>();
        ArrayList<LinkedHashMap<String, String>> joinParts = new ArrayList<>();
        ArrayList<String> wheres = new ArrayList<>();

        for (int i=0; i<forClause.getChildCount(); ++i){
            ParseTree cur = forClause.getChild(i);
            String curText = cur.getText();
            if (curText.matches("^\\$\\w*$")){
                String var = cur.getChild(0).getText() + cur.getChild(1).getText();
                xq = forClause.getChild(i+2); // for var in xq, var has children $ and a
                if (xq.getText().contains("document") || xq.getText().contains("doc")){
                    LinkedHashMap<String, String> partition = new LinkedHashMap<>();
                    partition.put(var, xq.getText());
                    joinParts.add(partition);
                    varMap.put(var, partition);
                    wheres.add("");
                } else {
                    for (LinkedHashMap<String, String> p : joinParts){
                        String pvar = xq.getChild(0).getChild(0).getText();
                        if(p.containsKey(pvar)){
                            p.put(var, xq.getText());
                            varMap.put(var, p);
                        }
                    }
                }
            }
        }
        System.out.println("partitions size: " + joinParts.size());
        if (joinParts.size()<2){
            return "";
        }
        String left = "";
        boolean first = true;
        String condText = whereClause.getChild(1).getText();
        String[] condsArr = condText.split("and");
        ArrayList<String> conds = new ArrayList<>(Arrays.asList(condsArr));

        while (joinParts.size()>1){

            ArrayList<String> leftBracket = new ArrayList<>();
            ArrayList<String> rightBracket = new ArrayList<>();

            ArrayList<String> curConds = new ArrayList<>(conds);
            for (int i=0; i<conds.size(); ++i){
                String c = conds.get(i);
                String[] condVars = c.split("eq|="); // amazing eq|=
                HashMap<String, String> p1 = varMap.get(condVars[0]);
                HashMap<String, String> p2 = varMap.get(condVars[1]);
                if (p1 == p2 || !condVars[0].contains("$") || !condVars[1].contains("$")) {
                    int ind = joinParts.indexOf(p1);
                    if (wheres.get(ind).isEmpty()){
                        wheres.remove(ind);
                        wheres.add(ind, "where " + condVars[0] + " eq " + condVars[1] + " ");
                    } else {
                        String s = wheres.get(ind);
                        wheres.remove(ind);
                        wheres.add(ind, s + "and " + condVars[0] + " eq " + condVars[1] + " ");
                    }
                    curConds.remove(c);
                } else if (p1 != p2 && p1 != null && p2 != null && leftBracket.isEmpty()){
                    leftBracket.add(condVars[0]);
                    rightBracket.add(condVars[1]);
                    curConds.remove(c);
                } else if (p1 == varMap.get(leftBracket.get(0)) && p2 == varMap.get(rightBracket.get(0))){
                    leftBracket.add(condVars[0]);
                    rightBracket.add(condVars[1]);
                    curConds.remove(c);
                } else if (p1 == varMap.get(rightBracket.get(0)) && p2 == varMap.get(leftBracket.get(0))){
                    rightBracket.add(condVars[0]);
                    leftBracket.add(condVars[1]);
                    curConds.remove(c);
                }
            }
            conds = curConds;
            LinkedHashMap<String, String> p1 = varMap.get(leftBracket.get(0));
            LinkedHashMap<String, String> p2 = varMap.get(rightBracket.get(0));
            if (first){
                first = false;
                left += "for ";
                for (String var : p1.keySet()){
                    left += var + " in " + p1.get(var) + ", ";
                }
                left = left.substring(0, left.length()-2);
                String where = wheres.get(joinParts.indexOf(p1));
                if (!where.equals("")){
                    left += "\n\t" + where;
                }
                left += "\n\treturn <tuple>{";
                for (String var : p1.keySet()){
                    left += "<" + var.substring(1, var.length()) + ">{" + var + "}"
                            + "</" + var.substring(1, var.length()) + ">,";
                }
                left = left.substring(0, left.length()-1) + "}</tuple>,";
            }
            left = rewriteToJoin(left, p2, leftBracket, rightBracket, wheres, joinParts);

            for (Map.Entry<String, String> entry : p2.entrySet()){
                p1.put(entry.getKey(), entry.getValue());
                varMap.replace(entry.getKey(), p1);
            }
            wheres.remove(joinParts.indexOf(p2));
            joinParts.remove(p2);
        }
        result += left.substring(0, left.length()-1);
        String returnText = returnClause.getChild(1).getText();
        Pattern pattern = Pattern.compile("\\$\\w+\\d*\\/text\\(\\)");
        Matcher matcher = pattern.matcher(returnText);
        while (matcher.find()){
            String Mat = matcher.group(0);
            String newMat = Mat.replace("/", "//");
            returnText = returnText.replace(Mat, newMat);
        }
        pattern = Pattern.compile("\\$\\w+\\d*\\/[^\\/]");
        matcher = pattern.matcher(returnText);
        while (matcher.find()){
//			returnText = returnText.replace(matcher.group(0), matcher.group(0) + "/*");

            String Mat =  matcher.group(0);
            int Matlen = Mat.length();
            if (matcher.group(0).contains("/")){
                returnText = returnText.replace(Mat, Mat.substring(0, Matlen-2) + "/*"+Mat.substring(Matlen-2, Matlen));
            }
        }
        pattern = Pattern.compile("\\$\\w+\\d*[,|}| |\\t]");
        matcher = pattern.matcher(returnText);
        while (matcher.find()){
            String Mat = matcher.group(0);
            int Matlen = Mat.length();
            returnText = returnText.replace(Mat, Mat.substring(0, Matlen-1) + "/*"+Mat.substring(Matlen-1, Matlen));
        }

        result += "\nreturn " + returnText.replace("$", "$tuple/");
        if (resultTag != null){
            result = "<" + resultTag + ">{\n" + result + "\n}</" + resultTag + ">";
        }
        return result;
    }

    private static String rewriteToJoin(String left, LinkedHashMap<String, String> p2,
                                        ArrayList<String> leftBracket, ArrayList<String> rightBracket,
                                        ArrayList<String> whereString, ArrayList<LinkedHashMap<String, String>> partitions){
        left = "join( " + left;
        left += "\n\tfor ";
        for (String var : p2.keySet()){
            left += var + " in " + p2.get(var) + ", ";
        }
        left = left.substring(0, left.length()-2);
        String where = whereString.get(partitions.indexOf(p2));
        if (!where.equals("")){
            left += "\n\t" + where;
        }
        left += "\n\treturn <tuple>{";
        for (String var : p2.keySet()){
            left += "<" + var.substring(1, var.length()) + ">{" + var + "}"
                    + "</" + var.substring(1, var.length()) + ">,";
        }
        left = left.substring(0, left.length()-1) + "}</tuple>,";
        left += "\n\t[";
        for (String var : leftBracket){
            left += var.substring(1, var.length()) + ",";
        }
        left = left.substring(0, left.length()-1) + "],[";
        for (String var : rightBracket){
            left += var.substring(1, var.length()) + ",";
        }
        left = left.substring(0, left.length()-1) + "]),";
        return left;
    }



}