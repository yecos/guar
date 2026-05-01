package com.hpplay.cybergarage.upnp;

import java.util.Vector;

/* loaded from: classes2.dex */
public class DeviceList extends Vector {
    public static final String ELEM_NAME = "deviceList";

    /* JADX WARN: Multi-variable type inference failed */
    public Device getDevice(int i10) {
        return (Device) get(i10);
    }
}
