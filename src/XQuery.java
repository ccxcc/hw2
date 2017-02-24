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

public class XQuery {
    public static void main(String[] args) {
        try {
            String fn = "j_caesar.xml";
            //Document doc = utils.read(fn);

            //System.out.println(fn);
            String query1 = "<result>{  for $a in (for $s in doc(\"j_caesar.xml\")//ACT \n" +
                    "return $s), \n" +
                    "       $sc in (for $t in $a/SCENE \n" +
                    "return $t),\n" +
                    "$sp in (for $d in $sc/SPEECH \n" +
                    " return $d)\n" +
                    "  where $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\"\n" +
                    "     return <who>{$sp/SPEAKER/text()}</who>,\n" +
                    "<when>{\n" +
                    "<act>{$a/TITLE/text()}</act>,\n" +
                    "<scene>{$sc/TITLE/text()}</scene>\n" +
                    "}</when>\n" +
                    "}\n" +
                    "</result>\n";

//            String query = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE \n";
//            String query1 = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE \n";
            ANTLRInputStream input = new ANTLRInputStream(query1);
            XQueryLexer lexer = new XQueryLexer(input);

//            XPathLexer lexer = new XPathLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XQueryParser parser = new XQueryParser(tokens);
//            XPathParser parser = new XPathParser(tokens);
            parser.removeParseListeners();
            ParseTree tree = parser.xq();
            EvalXQuery eva = new EvalXQuery();
            ArrayList<Node> rstNodes = eva.visit(tree);

            File writename = new File("output.txt"); // rp
            writename.createNewFile(); // create
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));

            for (int i = 0; i < rstNodes.size(); i++) {
                System.out.println(output(rstNodes.get(i), 0));
                out.write(output(rstNodes.get(i), 0));
            }
            out.flush(); // out
            out.close(); // close
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
}