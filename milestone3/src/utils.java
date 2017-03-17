
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by cc on 2/2/17.
 */
public class utils {
    public static ArrayList<Node> descendants(Node root) {
        //return all the children
        ArrayList rst = new ArrayList();

        for(int curr = 0; curr < root.getChildNodes().getLength(); ++curr) {
            rst.add(root.getChildNodes().item(curr));
        }

        return rst;
    }
//    public static void createDoc(Document doc){
//        if(doc == null) {
//            try {
//                DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
//                DocumentBuilder docB = docBF.newDocumentBuilder();
//                doc = docB.newDocument();
//            } catch (ParserConfigurationException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static Document read(String fn){
        File xmlFile =  new File(fn);
       // System.out.println(xmlFile);
        DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docB = null;
        try {
            docBF.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
            docBF.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            docB = docBF.newDocumentBuilder();
        } catch (ParserConfigurationException pE1) {
            pE1.printStackTrace();
        }
        Document doc = null;
        try {
            if (docB != null) {
                doc = docB.parse(xmlFile);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        return doc;
    }
}
