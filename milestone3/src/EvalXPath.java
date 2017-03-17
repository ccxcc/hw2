


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Created by cc on 1/31/17.
 */
public class EvalXPath extends XPathBaseVisitor<ArrayList<Node>> {
    private ArrayList<Node> curr = new ArrayList<>();
    private boolean hasAtt = false;

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override
    public ArrayList<Node> visitApSlash(XPathParser.ApSlashContext ctx) {
        //visit filepath
        System.out.println("xpathap");
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
    public ArrayList<Node> visitApTwoSlash(XPathParser.ApTwoSlashContext ctx) {
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
    public ArrayList<Node> visitFilePath(XPathParser.FilePathContext ctx) {
        String fn= ctx.fileName().getText();
        System.out.println(fn);
        //root nodeftvb
        Document doc = utils.read(fn);

        ArrayList<Node> res = new ArrayList<>();
        res.add(doc);
        curr = res;
        return res;

    }

    @Override
    public ArrayList<Node> visitRpTagName(XPathParser.RpTagNameContext ctx) {
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
    public ArrayList<Node> visitRpChildren(XPathParser.RpChildrenContext ctx) {
        ArrayList<Node> rst = new ArrayList<>();
        // get children
        for (Node tmp : curr) {
            rst.addAll(utils.descendants(tmp));
        }

        curr = rst;
        return rst;
    }

    @Override
    public ArrayList<Node> visitRpCurrent(XPathParser.RpCurrentContext ctx) {
        return curr;
    }
    //get current
    @Override
    public ArrayList<Node> visitRpParent(XPathParser.RpParentContext ctx) {

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
    public ArrayList<Node> visitRpText(XPathParser.RpTextContext ctx) {
        ArrayList<Node> rst = new ArrayList<Node>();

        for (Node temp : curr) {
            for (int i = 0; i < temp.getChildNodes().getLength(); i++) {
                if (temp.getChildNodes().item(i).getNodeType() == javax.xml.soap.Node.TEXT_NODE && !temp.getChildNodes().item(i).getTextContent().equals("\n")) {
                   //check for text node, and return text if no null
                    rst.add(temp.getChildNodes().item(i));
                }
            }
        }
        curr = rst;
        return rst;

    }

    @Override
    public ArrayList<Node> visitRpAttName(XPathParser.RpAttNameContext ctx) {
        
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
    @Override public ArrayList<Node> visitRpBracket(XPathParser.RpBracketContext ctx) {
        return visit(ctx.rp());
    }


    @Override public ArrayList<Node> visitRpSlash(XPathParser.RpSlashContext ctx) {

        visit(ctx.rp(0));
        ArrayList<Node> res = visit(ctx.rp(1));
        curr = res;
        return res;
    }

    @Override public ArrayList<Node>  visitRpDoubleSlash(XPathParser.RpDoubleSlashContext ctx) {
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
        System.out.println("//," +res.size());
        return visit(ctx.rp(1));

    }

    @Override public ArrayList<Node> visitRpFilter(XPathParser.RpFilterContext ctx) {
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


    @Override public ArrayList<Node> visitRpComma(XPathParser.RpCommaContext ctx) {

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

    @Override public ArrayList<Node> visitPfRp(XPathParser.PfRpContext ctx) {

        ArrayList<Node> tempList = curr;
        ArrayList<Node> res = visit(ctx.rp());
        curr = tempList;
        return res;

    }



    @Override public ArrayList<Node> visitPfIs(XPathParser.PfIsContext ctx) {

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


    @Override public ArrayList<Node> visitPfEq(XPathParser.PfEqContext ctx) {
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

    @Override public ArrayList<Node> visitPfBracket(XPathParser.PfBracketContext ctx) {
        return visit(ctx.pathFilter());
    }

    @Override public ArrayList<Node> visitPfAnd(XPathParser.PfAndContext ctx) {

        ArrayList<Node> left = visit(ctx.pathFilter(0));
        ArrayList<Node> right = visit(ctx.pathFilter(1));
        if (!left.isEmpty() && !right.isEmpty()) {
            return left;
        }
        else return new ArrayList<>();
    }


    @Override public ArrayList<Node> visitPfOr(XPathParser.PfOrContext ctx) {

        ArrayList<Node> left = visit(ctx.pathFilter(0));
        ArrayList<Node> right = visit(ctx.pathFilter(1));
        if (!left.isEmpty() || !right.isEmpty()) {
            return curr;
        }
        else return new ArrayList<>();
    }

    @Override public ArrayList<Node>  visitPfNot(XPathParser.PfNotContext ctx) {

        ArrayList<Node> res = visit(ctx.pathFilter());
        if (!res.isEmpty()) {
            return curr;
        }
        else return new ArrayList<>();

    }

}
