package com.hpplay.cybergarage.upnp.device;

/* loaded from: classes2.dex */
public class MAN {
    public static final String DISCOVER = "ssdp:discover";

    public static final boolean isDiscover(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(DISCOVER)) {
            return true;
        }
        return str.equals("\"ssdp:discover\"");
    }
}
