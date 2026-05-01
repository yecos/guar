package com.hpplay.cybergarage.upnp;

import java.util.Vector;

/* loaded from: classes2.dex */
public class ServiceList extends Vector {
    public static final String ELEM_NAME = "serviceList";

    public Service getService(int i10) {
        Object obj;
        try {
            obj = get(i10);
        } catch (Exception unused) {
            obj = null;
        }
        return (Service) obj;
    }
}
