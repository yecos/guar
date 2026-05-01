package com.hpplay.cybergarage.xml;

import java.util.Vector;

/* loaded from: classes2.dex */
public class NodeList extends Vector {
    public synchronized Node getEndsWith(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Node node = getNode(i10);
            String name = node.getName();
            if (name != null && name.endsWith(str)) {
                return node;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node getNode(int i10) {
        return (Node) get(i10);
    }

    public synchronized Node getNode(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Node node = getNode(i10);
            if (str.compareTo(node.getName()) == 0) {
                return node;
            }
        }
        return null;
    }
}
