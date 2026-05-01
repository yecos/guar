package com.hpplay.cybergarage.xml.parser;

import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.xml.Node;
import com.hpplay.cybergarage.xml.Parser;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class XmlPullParser extends Parser {
    public Node parse(org.xmlpull.v1.XmlPullParser xmlPullParser, InputStream inputStream) {
        Node node;
        String text;
        Node node2 = null;
        try {
            xmlPullParser.setInput(inputStream, null);
            int eventType = xmlPullParser.getEventType();
            Node node3 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    node = new Node();
                    String prefix = xmlPullParser.getPrefix();
                    String name = xmlPullParser.getName();
                    StringBuffer stringBuffer = new StringBuffer();
                    if (prefix != null && prefix.length() > 0) {
                        stringBuffer.append(prefix);
                        stringBuffer.append(SOAP.DELIM);
                    }
                    if (name != null && name.length() > 0) {
                        stringBuffer.append(name);
                    }
                    node.setName(stringBuffer.toString());
                    int attributeCount = xmlPullParser.getAttributeCount();
                    for (int i10 = 0; i10 < attributeCount; i10++) {
                        node.setAttribute(xmlPullParser.getAttributeName(i10), xmlPullParser.getAttributeValue(i10));
                    }
                    if (node3 != null) {
                        node3.addNode(node);
                    }
                    if (node2 == null) {
                        node2 = node;
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && (text = xmlPullParser.getText()) != null && node3 != null) {
                        node3.setValue(text);
                    }
                    eventType = xmlPullParser.next();
                } else {
                    node = node3.getParentNode();
                }
                node3 = node;
                eventType = xmlPullParser.next();
            }
            return node2;
        } catch (Exception e10) {
            throw new Exception(e10);
        }
    }

    @Override // com.hpplay.cybergarage.xml.Parser
    public Node parse(InputStream inputStream) {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            return parse(newInstance.newPullParser(), inputStream);
        } catch (Exception e10) {
            throw new Exception(e10);
        }
    }
}
