package com.hpplay.cybergarage.upnp.device;

/* loaded from: classes2.dex */
public class USN {
    public static final String ROOTDEVICE = "upnp:rootdevice";

    public static final String getUDN(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf("::");
        return indexOf < 0 ? str.trim() : new String(str.getBytes(), 0, indexOf).trim();
    }

    public static final boolean isRootDevice(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith("upnp:rootdevice");
    }
}
