package com.hpplay.cybergarage.upnp;

import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class AllowedValue {
    public static final String ELEM_NAME = "allowedValue";
    private Node allowedValueNode;

    public AllowedValue(Node node) {
        this.allowedValueNode = node;
    }

    public static boolean isAllowedValueNode(Node node) {
        return ELEM_NAME.equals(node.getName());
    }

    public Node getAllowedValueNode() {
        return this.allowedValueNode;
    }

    public String getValue() {
        return getAllowedValueNode().getValue();
    }

    public void setValue(String str) {
        getAllowedValueNode().setValue(str);
    }

    public AllowedValue(String str) {
        this.allowedValueNode = new Node(ELEM_NAME);
        setValue(str);
    }
}
