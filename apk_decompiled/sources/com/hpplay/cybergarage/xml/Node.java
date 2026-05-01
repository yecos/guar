package com.hpplay.cybergarage.xml;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Node {
    private AttributeList attrList;
    private String name;
    private NodeList nodeList;
    private Node parentNode;
    private Object userData;
    private String value;

    public Node() {
        this.parentNode = null;
        this.name = new String();
        this.value = new String();
        this.attrList = new AttributeList();
        this.nodeList = new NodeList();
        this.userData = null;
        setUserData(null);
        setParentNode(null);
    }

    public void addAttribute(Attribute attribute) {
        this.attrList.add(attribute);
    }

    public void addNode(Node node) {
        node.setParentNode(this);
        this.nodeList.add(node);
    }

    public void addValue(String str) {
        if (this.value == null) {
            this.value = str;
        } else if (str != null) {
            this.value += str;
        }
    }

    public boolean equals(Node node) {
        if (node == null) {
            return false;
        }
        return toString().equals(node.toString());
    }

    public Attribute getAttribute(int i10) {
        return this.attrList.getAttribute(i10);
    }

    public int getAttributeIntegerValue(String str) {
        try {
            return Integer.parseInt(getAttributeValue(str));
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getAttributeValue(String str) {
        Attribute attribute = getAttribute(str);
        return attribute != null ? attribute.getValue() : "";
    }

    public String getIndentLevelString(int i10) {
        return getIndentLevelString(i10, "   ");
    }

    public int getIndex(String str) {
        Iterator<E> it = this.nodeList.iterator();
        int i10 = -1;
        while (it.hasNext()) {
            i10++;
            if (((Node) it.next()).getName().equals(str)) {
                break;
            }
        }
        return i10;
    }

    public int getNAttributes() {
        return this.attrList.size();
    }

    public int getNNodes() {
        return this.nodeList.size();
    }

    public String getName() {
        return this.name;
    }

    public Node getNode(int i10) {
        return this.nodeList.getNode(i10);
    }

    public Node getNodeEndsWith(String str) {
        return this.nodeList.getEndsWith(str);
    }

    public String getNodeValue(String str) {
        Node node = getNode(str);
        return node != null ? node.getValue() : "";
    }

    public Node getParentNode() {
        return this.parentNode;
    }

    public Node getRootNode() {
        Node node = null;
        for (Node parentNode = getParentNode(); parentNode != null; parentNode = parentNode.getParentNode()) {
            node = parentNode;
        }
        return node;
    }

    public Object getUserData() {
        return this.userData;
    }

    public String getValue() {
        return this.value;
    }

    public boolean hasAttributes() {
        return getNAttributes() > 0;
    }

    public boolean hasNode(String str) {
        return getNode(str) != null;
    }

    public boolean hasNodes() {
        return getNNodes() > 0;
    }

    public void insertAttributeAt(Attribute attribute, int i10) {
        this.attrList.insertElementAt(attribute, i10);
    }

    public void insertNode(Node node, int i10) {
        node.setParentNode(this);
        this.nodeList.insertElementAt(node, i10);
    }

    public boolean isName(String str) {
        return this.name.equals(str);
    }

    public void output(PrintWriter printWriter, int i10, boolean z10) {
        String indentLevelString = getIndentLevelString(i10);
        String name = getName();
        String value = getValue();
        if (hasNodes() && z10) {
            printWriter.print(indentLevelString + Operator.Operation.LESS_THAN + name);
            outputAttributes(printWriter);
            printWriter.println(Operator.Operation.GREATER_THAN);
            int nNodes = getNNodes();
            for (int i11 = 0; i11 < nNodes; i11++) {
                getNode(i11).output(printWriter, i10 + 1, true);
            }
            printWriter.println(indentLevelString + "</" + name + Operator.Operation.GREATER_THAN);
            return;
        }
        printWriter.print(indentLevelString + Operator.Operation.LESS_THAN + name);
        outputAttributes(printWriter);
        if (value == null || value.length() == 0) {
            printWriter.println("></" + name + Operator.Operation.GREATER_THAN);
            return;
        }
        printWriter.println(Operator.Operation.GREATER_THAN + XML.escapeXMLChars(value) + "</" + name + Operator.Operation.GREATER_THAN);
    }

    public void outputAttributes(PrintWriter printWriter) {
        int nAttributes = getNAttributes();
        for (int i10 = 0; i10 < nAttributes; i10++) {
            Attribute attribute = getAttribute(i10);
            printWriter.print(" " + attribute.getName() + "=\"" + XML.escapeXMLChars(attribute.getValue()) + "\"");
        }
    }

    public void print(boolean z10) {
        PrintWriter printWriter = new PrintWriter(System.out);
        output(printWriter, 0, z10);
        printWriter.flush();
    }

    public void removeAllAttributes() {
        this.attrList.clear();
    }

    public void removeAllNodes() {
        this.nodeList.clear();
    }

    public boolean removeAttribute(Attribute attribute) {
        return this.attrList.remove(attribute);
    }

    public boolean removeNode(Node node) {
        node.setParentNode(null);
        return this.nodeList.remove(node);
    }

    public boolean set(Node node) {
        if (node == null) {
            return false;
        }
        setName(node.getName());
        setValue(node.getValue());
        removeAllAttributes();
        int nAttributes = node.getNAttributes();
        for (int i10 = 0; i10 < nAttributes; i10++) {
            addAttribute(new Attribute(node.getAttribute(i10)));
        }
        removeAllNodes();
        int nNodes = node.getNNodes();
        for (int i11 = 0; i11 < nNodes; i11++) {
            Node node2 = node.getNode(i11);
            Node node3 = new Node();
            node3.set(node2);
            addNode(node3);
        }
        return true;
    }

    public void setAttribute(String str, String str2) {
        Attribute attribute = getAttribute(str);
        if (attribute != null) {
            attribute.setValue(str2);
        } else {
            addAttribute(new Attribute(str, str2));
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameSpace(String str, String str2) {
        setAttribute("xmlns:" + str, str2);
    }

    public void setNode(String str) {
        if (hasNode(str)) {
            return;
        }
        addNode(new Node(str));
    }

    public void setParentNode(Node node) {
        this.parentNode = node;
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString(String str, boolean z10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        output(printWriter, 0, z10);
        printWriter.flush();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return byteArrayOutputStream.toString(str);
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return byteArrayOutputStream.toString();
    }

    public String toXMLString(boolean z10) {
        return toString().replaceAll(Operator.Operation.LESS_THAN, "&lt;").replaceAll(Operator.Operation.GREATER_THAN, "&gt;").replaceAll(DispatchConstants.SIGN_SPLIT_SYMBOL, "&amp;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }

    public void addAttribute(String str, String str2) {
        addAttribute(new Attribute(str, str2));
    }

    public Attribute getAttribute(String str) {
        return this.attrList.getAttribute(str);
    }

    public String getIndentLevelString(int i10, String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() * i10);
        for (int i11 = 0; i11 < i10; i11++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public Node getNode(String str) {
        return this.nodeList.getNode(str);
    }

    public boolean removeAttribute(String str) {
        return removeAttribute(getAttribute(str));
    }

    public void setName(String str, String str2) {
        this.name = str + SOAP.DELIM + str2;
    }

    public void setValue(int i10) {
        setValue(Integer.toString(i10));
    }

    public boolean removeNode(String str) {
        return this.nodeList.remove(getNode(str));
    }

    public void print() {
        print(true);
    }

    public void setNode(String str, String str2) {
        Node node = getNode(str);
        if (node == null) {
            node = new Node(str);
            addNode(node);
        }
        node.setValue(str2);
    }

    public void setAttribute(String str, int i10) {
        setAttribute(str, Integer.toString(i10));
    }

    public String toXMLString() {
        return toXMLString(true);
    }

    public String toString() {
        return toString(XML.CHARSET_UTF8, true);
    }

    public Node(String str) {
        this();
        setName(str);
    }

    public Node(String str, String str2) {
        this();
        setName(str, str2);
    }

    public Node(Node node) {
        this();
        set(node);
    }
}
