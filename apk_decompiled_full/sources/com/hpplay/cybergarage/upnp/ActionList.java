package com.hpplay.cybergarage.upnp;

import java.util.Vector;

/* loaded from: classes2.dex */
public class ActionList extends Vector {
    public static final String ELEM_NAME = "actionList";

    /* JADX WARN: Multi-variable type inference failed */
    public Action getAction(int i10) {
        return (Action) get(i10);
    }
}
