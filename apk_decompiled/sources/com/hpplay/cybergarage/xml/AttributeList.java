package com.hpplay.cybergarage.xml;

import java.util.Vector;

/* loaded from: classes2.dex */
public class AttributeList extends Vector {
    /* JADX WARN: Multi-variable type inference failed */
    public Attribute getAttribute(int i10) {
        return (Attribute) get(i10);
    }

    public Attribute getAttribute(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Attribute attribute = getAttribute(i10);
            if (str.compareTo(attribute.getName()) == 0) {
                return attribute;
            }
        }
        return null;
    }
}
