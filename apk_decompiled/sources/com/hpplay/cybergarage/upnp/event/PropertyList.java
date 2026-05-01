package com.hpplay.cybergarage.upnp.event;

import java.util.Vector;

/* loaded from: classes2.dex */
public class PropertyList extends Vector {
    public static final String ELEM_NAME = "PropertyList";

    /* JADX WARN: Multi-variable type inference failed */
    public Property getProperty(int i10) {
        return (Property) get(i10);
    }
}
