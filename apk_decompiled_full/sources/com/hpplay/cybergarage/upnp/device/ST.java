package com.hpplay.cybergarage.upnp.device;

/* loaded from: classes2.dex */
public class ST {
    public static final String ALL_DEVICE = "ssdp:all";
    public static final String AV_TRANSPORT_1 = "urn:schemas-upnp-org:service:AVTransport:1";
    public static final String MEDIA_RENDER = "urn:schemas-upnp-org:device:MediaRenderer:1";
    public static final String ROOT_DEVICE = "upnp:rootdevice";
    public static final String URN_DEVICE = "urn:schemas-upnp-org:device:";
    public static final String URN_SERVICE = "urn:schemas-upnp-org:service:";
    public static final String UUID_DEVICE = "uuid";

    public static final boolean isAllDevice(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(ALL_DEVICE)) {
            return true;
        }
        return str.equals("\"ssdp:all\"");
    }

    public static final boolean isRootDevice(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("upnp:rootdevice")) {
            return true;
        }
        return str.equals("\"upnp:rootdevice\"");
    }

    public static final boolean isURNDevice(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(URN_DEVICE)) {
            return true;
        }
        return str.startsWith("\"urn:schemas-upnp-org:device:");
    }

    public static final boolean isURNService(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(URN_SERVICE)) {
            return true;
        }
        return str.startsWith("\"urn:schemas-upnp-org:service:");
    }

    public static final boolean isUUIDDevice(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("uuid")) {
            return true;
        }
        return str.startsWith("\"uuid");
    }
}
