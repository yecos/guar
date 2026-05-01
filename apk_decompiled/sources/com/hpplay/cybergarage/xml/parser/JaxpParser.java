package com.hpplay.cybergarage.xml.parser;

import com.hpplay.cybergarage.xml.Node;
import com.hpplay.cybergarage.xml.Parser;
import com.hpplay.cybergarage.xml.ParserException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

/* loaded from: classes2.dex */
public class JaxpParser extends Parser {
    public Node parse(Node node, org.w3c.dom.Node node2, int i10) {
        short nodeType = node2.getNodeType();
        String nodeName = node2.getNodeName();
        String nodeValue = node2.getNodeValue();
        NamedNodeMap attributes = node2.getAttributes();
        if (attributes != null) {
            attributes.getLength();
        }
        if (nodeType == 3) {
            node.addValue(nodeValue);
            return node;
        }
        if (nodeType != 1) {
            return node;
        }
        Node node3 = new Node();
        node3.setName(nodeName);
        node3.setValue(nodeValue);
        if (node != null) {
            node.addNode(node3);
        }
        NamedNodeMap attributes2 = node2.getAttributes();
        if (attributes2 != null) {
            int length = attributes2.getLength();
            for (int i11 = 0; i11 < length; i11++) {
                org.w3c.dom.Node item = attributes2.item(i11);
                node3.setAttribute(item.getNodeName(), item.getNodeValue());
            }
        }
        org.w3c.dom.Node firstChild = node2.getFirstChild();
        if (firstChild == null) {
            node3.setValue("");
            return node3;
        }
        do {
            parse(node3, firstChild, i10 + 1);
            firstChild = firstChild.getNextSibling();
        } while (firstChild != null);
        return node3;
    }

    public Node parse(Node node, org.w3c.dom.Node node2) {
        return parse(node, node2, 0);
    }

    @Override // com.hpplay.cybergarage.xml.Parser
    public Node parse(InputStream inputStream) {
        try {
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputStream)).getDocumentElement();
            if (documentElement != null) {
                return parse((Node) null, documentElement);
            }
            return null;
        } catch (Exception e10) {
            throw new ParserException(e10);
        }
    }
}
