package com.hpplay.cybergarage.upnp;

import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes2.dex */
public class AllowedValueList extends Vector {
    public static final String ELEM_NAME = "allowedValueList";

    public AllowedValueList() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AllowedValue getAllowedValue(int i10) {
        return (AllowedValue) get(i10);
    }

    public boolean isAllowed(String str) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (((AllowedValue) it.next()).getValue().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public AllowedValueList(String[] strArr) {
        for (String str : strArr) {
            add(new AllowedValue(str));
        }
    }
}
