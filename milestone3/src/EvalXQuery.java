/**
 * Created by cc on 2017/2/22.
 */
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Stack;
import java.io.StringWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class EvalXQuery extends XQueryBaseVisitor<ArrayList<Node>>{

    private boolean hasAtt = false;
    private Document inputDoc = null;
    Document outputDoc = null;
    private HashMap<String, ArrayList<Node>> cache = new HashMap();
    private Stack<HashMap<String, ArrayList<Node>>> stack = new Stack();
    private ArrayList<Node> curr = new ArrayList();


   // Join
    @Override
    public ArrayList<Node> visitXqJoin(XQueryParser.XqJoinContext ctx) {
        ArrayList<Node> xq_visit = visit(ctx.joinClause().xq(0));
        //System.out.print(xq_visit.size());
        int vlistSize = ctx.joinClause().attlist(0).ID().size();
        System.out.println("the vlistsize is "+vlistSize);
        ArrayList<Node> result_sum = new ArrayList<>();
        ArrayList<HashMap<String, ArrayList<Node>>> tempmap = new ArrayList<>();

        for (int i=0; i<vlistSize; ++i){
            ArrayList<Node> alternative;
            HashMap<String, ArrayList<Node>> map = new HashMap<>();
            String varName = ctx.joinClause().attlist(0).ID(i).getText();


            for (int j=0;i<xq_visit.size();i++){
                Node node=xq_visit.get(j);
                String a = nodeToString(((Element) node).getElementsByTagName(varName).item(0));
                int first=2+varName.length();
                int last=a.length()-3-varName.length();
                String key = a.substring(first, last);
               // System.out.println(key);
                if (map.containsKey(key)) {
                    alternative = map.get(key);
                   // System.out.println(replaceValue);
                    alternative.add(node.cloneNode(true));
                    //System.out.println(replaceValue);
                    map.put(key,alternative); // our
                }else {
                    ArrayList<Node> tempadd = new ArrayList<>();
                    tempadd.add(node.cloneNode(true));
                    map.put(key, tempadd);
                }
            }
            tempmap.add(i, map);
            System.out.println(tempmap);
        }
        return getresult(ctx, vlistSize,tempmap);
    }

    //join
    public ArrayList<Node> getresult(XQueryParser.XqJoinContext ctx, int leng,ArrayList<HashMap<String, ArrayList<Node>>> tempmap){
        ArrayList<Node> result_sum = new ArrayList<>();

        ArrayList<Node> xq_right = visit(ctx.joinClause().xq(1));
        System.out.println("2the size is "+xq_right.size());
        ArrayList<Node> templist1 = new ArrayList<>();
        for (int m=0;m<xq_right.size(); m++){
            Node node=xq_right.get(m);
            for(int i=0; i<leng; i++){
                String varName = ctx.joinClause().attlist(1).ID(i).getText();
                String a = nodeToString(((Element) node).getElementsByTagName(varName).item(0));
                String tempvar = nodeToString(((Element) node).getElementsByTagName(varName).item(0)).substring(2+varName.length(), a.length()-3-varName.length());

                if (!tempmap.get(i).containsKey(tempvar)){
                    templist1.clear();
                    break;
                } else if (tempmap.get(i).containsKey(tempvar)){
                    if(templist1.isEmpty()) {
                        templist1.addAll(tempmap.get(i).get(tempvar));
                        System.out.println("the compare list is "+templist1);
                    }else {
                        ArrayList<Node> remainList = new ArrayList<>();
                        ArrayList<Node> lateget = tempmap.get(i).get(tempvar);
                        HashSet<String> compareListStr = new HashSet<>();
                        for (Node r : templist1){
                            String rString = nodeToString(r);
                            compareListStr.add(rString);
                        }
                        for (Node m : lateget) {
                            String mString = nodeToString(m);
                            if (compareListStr.contains(mString)) {
                                remainList.add(m.cloneNode(true));
                            }
                        }
                        templist1 = remainList;
                        //System.out.println("the compare list is "+compareList);
                    }
                }
            }
            if (!templist1.isEmpty()){
                int nodeNum = node.getChildNodes().getLength();
                Node tempNode;
                for (Node node1 : templist1) {
                    for (int w = 0; w < nodeNum; w++) {
                        tempNode = node1.getChildNodes().item(w).cloneNode(true);
                        node1.appendChild(tempNode);
                    }
                }
                result_sum.addAll(templist1);
                templist1.clear();
            }
        }


        return result_sum;
    }




    private String nodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            te.printStackTrace();
        }
        return sw.toString();
    }

    private Node createNode(String s, ArrayList<Node> nodes) {
        if(outputDoc == null) {
            System.out.print("null doc");
        }
        Element rst = outputDoc.createElement(s);
        for (Object n : nodes) {
            Node t = (Node)n;
            if (t != null) {

                Node tmp = outputDoc.importNode(t,true);
//                System.out.println(tmp.getNodeName());
                rst.appendChild(tmp);
            }
        }

        return rst;
    }

    private Node makeText(String s) {

        return this.inputDoc.createTextNode(s);
    }
    @Override
    public ArrayList<Node> visitVariable(XQueryParser.VariableContext ctx) {
        ArrayList<Node> rst = new ArrayList<>(cache.get(ctx.getText()));
        return rst;
    }
    @Override
    public ArrayList<Node> visitStringConst(XQueryParser.StringConstContext ctx) {
        String s = ctx.StringConstant().getText();
       // System.out.println(s);
        Node n = makeText(s.substring(1,s.length()-1));
        //System.out.println("cons:" +n.getTextContent());

        ArrayList<Node> rst = new ArrayList<Node>();
        rst.add(n);
        return rst;
    }
    @Override
    public ArrayList<Node> visitXqAp(XQueryParser.XqApContext ctx) {
//       //System.out.println("visitXpAp" + ctx.ap().getText());
        return visit(ctx.ap());
    }
    @Override
    public ArrayList<Node> visitXqBracket(XQueryParser.XqBracketContext ctx) {
        return visit(ctx.xq());
    }
    @Override
    public ArrayList<Node> visitXqComma(XQueryParser.XqCommaContext ctx) {
        ArrayList<Node> rst1 = new ArrayList<>();
        ArrayList<Node> rst2 = new ArrayList<>();

        rst1.addAll(visit(ctx.xq(0)));
        rst2.addAll(visit(ctx.xq(1)));

        rst1.addAll(rst2);

        return rst1;
    }
    @Override public ArrayList<Node> visitXqSlash(XQueryParser.XqSlashContext ctx) {
        //xp result
        curr = visit(ctx.xq());
        //rp
        return visit(ctx.rp());

    }
    @Override public ArrayList<Node> visitXqTwoSlash(XQueryParser.XqTwoSlashContext ctx) {
        ArrayList xprst = visit(ctx.xq());
        ArrayList rst = new ArrayList();
        LinkedList list = new LinkedList();
        rst.addAll(xprst);
        list.addAll(xprst);
        while (!list.isEmpty()) {
            Node tmp = (Node) list.poll();
            ArrayList children  = utils.descendants(tmp);
            rst.addAll(children);
            list.addAll(children);
        }
        curr = rst;

        return visit(ctx.rp());

    }
    @Override
    public ArrayList<Node> visitXqResult(XQueryParser.XqResultContext ctx) {
        if(outputDoc == null) {
            try {
                DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
                DocumentBuilder docB = docBF.newDocumentBuilder();
                outputDoc = docB.newDocument();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
        ArrayList rst = new ArrayList();
        ArrayList<Node> xqRst = visit(ctx.xq());

//       for (Object n : xqRst) {
//            Node t = (Node)n;
//        }
//        System.out.print(ctx.ID(0).getText());
        rst.add(createNode(ctx.ID(0).getText(), xqRst));


//         System.out.println("result size: " + rst.size());
        return rst;
    }
    @Override
    public ArrayList<Node> visitXqFLWR(XQueryParser.XqFLWRContext ctx) {
        ArrayList<Node> rst = new ArrayList();
        HashMap<String, ArrayList<Node>> oldCache = new HashMap<>(cache);
        //this.contextStack.push(contextMapOld);
        flower(ctx, 0, rst);
        cache = oldCache;
//        System.out.println(rst.size());
//        for (int i = 0; i < rst.size();i++) {
//            System.out.println(output(rst.get(i),0));
//        }
        return rst;
    }
    public void flower(XQueryParser.XqFLWRContext ctx, int k, ArrayList<Node> rst){
        if (k == ctx.forClause().var().size()){
            HashMap<String, ArrayList<Node>> contextMapOld = new HashMap<>(cache);
            if (ctx.letClause() != null) {
                visit(ctx.letClause());
            }
            if (ctx.whereClause() != null) {
                if(visit(ctx.whereClause()).size()==0){
                    return;
                }
            }
            ArrayList<Node> c = visit(ctx.returnClause());
//            System.out.println("returnSize: " + c.size());
            if (c != null) {
                rst.addAll(visit(ctx.returnClause()));
            }
            cache = contextMapOld;

        }
        else {
            String var = ctx.forClause().var(k).getText();
            ArrayList<Node> varNodes = visit(ctx.forClause().xq(k));
            for (Node temp : varNodes){
                cache.remove(var);
                ArrayList<Node> nList = new ArrayList<>();
                nList.add(temp);
                cache.put(var, nList);
                flower(ctx, k + 1, rst);
            }

        }
    }


    @Override
    public ArrayList<Node> visitXqLet(XQueryParser.XqLetContext ctx) {
        HashMap oldCache = new HashMap(cache);
        visit(ctx.letClause());
        ArrayList<Node> rst = new ArrayList<>(visit(ctx.xq()));
        cache = oldCache;
        return rst;
    }
    @Override
    public ArrayList<Node> visitLetClause(XQueryParser.LetClauseContext ctx) {
        for(int i = 0; i < ctx.var().size(); ++i) {
            cache.put(ctx.var(i).getText(), visit(ctx.xq(i)));
        }
            return new ArrayList<>();

    }
    @Override public ArrayList<Node> visitForClause(XQueryParser.ForClauseContext ctx) {
        ArrayList<Node> result = new ArrayList<>();
        result.addAll(getItems(0, ctx));
        return result;
    }
    private ArrayList<Node> getItems (int v, XQueryParser.ForClauseContext context) {
        ArrayList<Node> result = new ArrayList<>();
        ArrayList<Node> tempList = visit(context.xq(v));
        if(context.xq().size() == 1) {
            for(Node temp: tempList) {
                ArrayList<Node> tempList2 = new ArrayList<>();
                tempList2.add(temp);
                cache.put(context.var(v).getText(), tempList2);
                result.add(temp);
            }
            return result;
        }
        else {
            for(Node temp: tempList) {
                HashMap<String, ArrayList<Node>> contextMapOld = new HashMap<>(cache);
                ArrayList<Node> tempList2 = new ArrayList<>();
                tempList2.add(temp);
                cache.put(context.var(v).getText(), tempList2);
                result.addAll(getItems(v + 1, context));
                cache = contextMapOld;
            }
            return result;
        }
    }

    @Override
    public ArrayList<Node> visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        return visit(ctx.cond());
    }
    @Override
    public ArrayList<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        return visit(ctx.xq());
    }

    @Override
    public ArrayList<Node> visitCondEq(XQueryParser.CondEqContext ctx) {
        ArrayList<Node> res = new ArrayList<Node>();
        ArrayList<Node> tmp = new ArrayList<Node>(curr);
        ArrayList<Node> left = new ArrayList<Node>(visit(ctx.xq(0)));
        curr = tmp;
        ArrayList<Node> right = new ArrayList<Node>(visit(ctx.xq(1)));
        for (Node p: left) {
            for (Node q: right) {
                if (p.isEqualNode(q)) {
                    //System.out.println("ss");
                    res.add(p);
                    return res;
                }
            }
        }
        return res;
    }

    @Override
    public ArrayList<Node> visitCondIs(XQueryParser.CondIsContext ctx) {
        ArrayList<Node> tempList = curr;
        ArrayList<Node> left = visit(ctx.xq(0));
        curr = tempList;
        ArrayList<Node> right = visit(ctx.xq(1));
        curr = tempList;
        ArrayList<Node> result = new ArrayList<>();
        for (Node i : left) {
            for (Node j : right) {
                if (i == j) {
                    result.add(i);
                    return result;
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitCondEmp(XQueryParser.CondEmpContext ctx) {
        ArrayList<Node> xqResult = visit(ctx.xq());
        ArrayList<Node> result = new ArrayList<>();
        if (xqResult.isEmpty()){
            Node dummy = inputDoc.createElement("dummy");
            result.add(dummy);
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitCondSomeSatisfy(XQueryParser.CondSomeSatisfyContext ctx) {
        int size = ctx.var().size();
        HashMap<String, ArrayList<Node>> varsCur = new HashMap<String, ArrayList<Node>>(cache);
        for(int i = 0; i < size; i++)
        {
            String name = ctx.var(i).getText();
            HashMap<String, ArrayList<Node>> varsOld = new HashMap<String, ArrayList<Node>>(cache);
            ArrayList<Node> tmp = visit(ctx.xq(i));
            cache = varsOld;
            cache.remove(name);
            cache.put(name, tmp);
        }
        ArrayList<Node> res = visit(ctx.cond());
        cache = varsCur;
        return res;

    }



    @Override
    public ArrayList<Node> visitCondBracket(XQueryParser.CondBracketContext ctx) {
        return visit(ctx.cond());
    }

    @Override
    public ArrayList<Node> visitCondAnd(XQueryParser.CondAndContext ctx) {
        ArrayList<Node> left = visit(ctx.cond(0));
        ArrayList<Node> right = visit(ctx.cond(1));
        if (!left.isEmpty() && !right.isEmpty()){
            //System.out.println("and");
            return left;
        }
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Node> visitCondOr(XQueryParser.CondOrContext ctx) {
        ArrayList<Node> left = visit(ctx.cond(0));
        if (!left.isEmpty()){
            return left;
        }
        ArrayList<Node> right = visit(ctx.cond(1));
        if (!right.isEmpty()){
            return right;
        }
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Node> visitCondNot(XQueryParser.CondNotContext ctx) {
        ArrayList<Node> notList = visit(ctx.cond());
        ArrayList<Node> result = new ArrayList<>();
        if (notList.isEmpty()){
            Node dummy = inputDoc.createElement("dummy");
            result.add(dummy);
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitApSlash(XQueryParser.ApSlashContext ctx) {
        //visit filepath
        //System.out.println("xpathap");
        visit(ctx.filePath());
        //visit rp
        ArrayList<Node> rst = visit(ctx.rp());
        //store to current
        curr = rst;
        return rst;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public ArrayList<Node> visitApTwoSlash(XQueryParser.ApTwoSlashContext ctx) {
        // all descendants
        ArrayList<Node> rst = new ArrayList<>();
        LinkedList<Node> currList = new LinkedList<>();

        visit(ctx.filePath());
        //root node
        rst.addAll(curr);
        currList.addAll(curr);

        while (!currList.isEmpty()) {
            Node tmp = currList.poll();
            rst.addAll(utils.descendants(tmp));
            currList.addAll(utils.descendants(tmp));
        }
        curr = rst;
        return visit(ctx.rp());
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public ArrayList<Node> visitFilePath(XQueryParser.FilePathContext ctx) {
        String fn= ctx.fileName().getText();
        //System.out.println(fn);
        //root nodeftvb
        inputDoc = utils.read(fn);

        ArrayList<Node> res = new ArrayList<>();
        res.add(inputDoc);
        curr = res;
        return res;

    }

    @Override
    public ArrayList<Node> visitRpTagName(XQueryParser.RpTagNameContext ctx) {
        ArrayList<Node> rst = new ArrayList<>();
        String tName = ctx.getText();
        //children with the tagname
        for (Node tmp : curr) {
            ArrayList<Node> nodeList = utils.descendants(tmp);
            for (Node n : nodeList) {
                if (n.getNodeName().equals(tName)) {
                    rst.add(n);
                }
            }
        }
        curr = rst;
        return rst;
    }

    @Override
    public ArrayList<Node> visitRpChildren(XQueryParser.RpChildrenContext ctx) {
        ArrayList<Node> rst = new ArrayList<>();
        // get children
        for (Node tmp : curr) {
            rst.addAll(utils.descendants(tmp));
        }

        curr = rst;
        return rst;
    }

    @Override
    public ArrayList<Node> visitRpCurrent(XQueryParser.RpCurrentContext ctx) {
        return curr;
    }
    //get current
    @Override
    public ArrayList<Node> visitRpParent(XQueryParser.RpParentContext ctx) {

        ArrayList<Node> rst = new ArrayList<>();
        for (Node temp : curr) {
            if (!rst.contains(temp.getParentNode())) {
                rst.add(temp.getParentNode());
            }
        }
        curr = rst;
        return rst;
    }

    @Override
    public ArrayList<Node> visitRpText(XQueryParser.RpTextContext ctx) {
        ArrayList<Node> rst = new ArrayList<Node>();

        for (Node temp : curr) {
            for (int i = 0; i < temp.getChildNodes().getLength(); i++) {
                if (temp.getChildNodes().item(i).getNodeType() == javax.xml.soap.Node.TEXT_NODE && !temp.getChildNodes().item(i).getTextContent().equals("\n")) {
                    rst.add(temp.getChildNodes().item(i));
                    /// /check for text node, and return text if no null
                   // System.out.println(temp.getChildNodes().item(i).getTextContent());
                }
            }
        }
        curr = rst;
        return rst;
    }

    @Override
    public ArrayList<Node> visitRpAttName(XQueryParser.RpAttNameContext ctx) {

        ArrayList<Node> rst = new ArrayList<>();
        hasAtt = true;
        for (Node temp : curr) {
            Element e = (Element) temp;
            //return node with such attribute
            String attValue = e.getAttribute(ctx.attName().getText());
            if (!attValue.equals("")) {
                rst.add(temp);
            }
        }
        curr = rst;
        return rst;
    }
    @Override public ArrayList<Node> visitRpBracket(XQueryParser.RpBracketContext ctx) {
        return visit(ctx.rp());
    }


    @Override public ArrayList<Node> visitRpSlash(XQueryParser.RpSlashContext ctx) {

        visit(ctx.rp(0));
        ArrayList<Node> res = visit(ctx.rp(1));
        curr = res;
        return res;
    }

    @Override public ArrayList<Node>  visitRpDoubleSlash(XQueryParser.RpDoubleSlashContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        LinkedList<Node> ll = new LinkedList<>();
        visit(ctx.rp(0));
        res.addAll(curr);
        ll.addAll(curr);
        while (!ll.isEmpty()) {
            Node temp = ll.poll();
            res.addAll(utils.descendants(temp));
            ll.addAll(utils.descendants(temp));
        }
        curr = res;
        //System.out.println("//," +res.size());
        return visit(ctx.rp(1));

    }

    @Override public ArrayList<Node> visitRpFilter(XQueryParser.RpFilterContext ctx) {
        ArrayList<Node> res = visit(ctx.rp());
        ArrayList<Node> filter= visit(ctx.pathFilter());
        if (hasAtt) {
            curr = filter;
            hasAtt = false;
            return filter;
        }
        else if (filter.isEmpty()) {
            return new ArrayList<>();
        }
        else return res;

    }


    @Override public ArrayList<Node> visitRpComma(XQueryParser.RpCommaContext ctx) {

        ArrayList<Node> res1 = new ArrayList<>();
        ArrayList<Node> res2 = new ArrayList<>();
        ArrayList<Node> tempList = new ArrayList<>(curr);
        res1.addAll(visit(ctx.rp(0)));
        curr = tempList;
        res2.addAll(visit(ctx.rp(1)));
        res1.addAll(res2);

        curr = res1;
        return res1;



    }

    @Override public ArrayList<Node> visitPfRp(XQueryParser.PfRpContext ctx) {

        ArrayList<Node> tempList = curr;
        ArrayList<Node> res = visit(ctx.rp());
        curr = tempList;
        return res;

    }



    @Override public ArrayList<Node> visitPfIs(XQueryParser.PfIsContext ctx) {

        ArrayList<Node> tempList = curr;
        ArrayList<Node> left = visit(ctx.rp(0));
        curr = tempList;
        ArrayList<Node> right = visit(ctx.rp(1));
        curr = tempList;
        for (Node i : left) {
            for (Node j : right) {
                if (i == j) {
                    return tempList;
                }
            }
        }
        return new ArrayList<>();
    }


    @Override public ArrayList<Node> visitPfEq(XQueryParser.PfEqContext ctx) {
        ArrayList<Node> tempList = curr;
        ArrayList<Node> left = visit(ctx.rp(0));
        curr = tempList;
        ArrayList<Node> right = visit(ctx.rp(1));
        curr = tempList;
        for (Node i : left) {
            for (Node j : right) {
                if (i.isEqualNode(j)) {
                    return tempList;
                }
            }
        }
        return new ArrayList<>();

    }

    @Override public ArrayList<Node> visitPfBracket(XQueryParser.PfBracketContext ctx) {
        return visit(ctx.pathFilter());
    }

    @Override public ArrayList<Node> visitPfAnd(XQueryParser.PfAndContext ctx) {

        ArrayList<Node> left = visit(ctx.pathFilter(0));
        ArrayList<Node> right = visit(ctx.pathFilter(1));
        if (!left.isEmpty() && !right.isEmpty()) {
            return left;
        }
        else return new ArrayList<>();
    }


    @Override public ArrayList<Node> visitPfOr(XQueryParser.PfOrContext ctx) {

        ArrayList<Node> left = visit(ctx.pathFilter(0));
        ArrayList<Node> right = visit(ctx.pathFilter(1));
        if (!left.isEmpty() || !right.isEmpty()) {
            return curr;
        }
        else return new ArrayList<>();
    }

    @Override public ArrayList<Node>  visitPfNot(XQueryParser.PfNotContext ctx) {

        ArrayList<Node> res = visit(ctx.pathFilter());
        if (!res.isEmpty()) {
            return curr;
        }
        else return new ArrayList<>();

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
    private static void writeToXML(ArrayList<Node> nodes, String filepath)
    {
        File output = new File(filepath);
        if(output.exists())
            output.delete();
        try
        {
            FileOutputStream os = new FileOutputStream(filepath,true);
            for(Node n : nodes) {
                try {
                    Transformer t = TransformerFactory.newInstance().newTransformer();
                    t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                    t.setOutputProperty(OutputKeys.INDENT, "yes");
                    t.transform(new DOMSource(n), new StreamResult(os));
                } catch (TransformerException te) {
                    System.out.println("nodeToString Transformer Exception");
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Wrong Output Path!");
        }
    }


}

