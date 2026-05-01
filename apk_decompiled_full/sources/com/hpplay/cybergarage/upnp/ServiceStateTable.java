package com.hpplay.cybergarage.upnp;

import java.util.Vector;

/* loaded from: classes2.dex */
public class ServiceStateTable extends Vector {
    public static final String ELEM_NAME = "serviceStateTable";

    /* JADX WARN: Multi-variable type inference failed */
    public StateVariable getStateVariable(int i10) {
        return (StateVariable) get(i10);
    }
}
