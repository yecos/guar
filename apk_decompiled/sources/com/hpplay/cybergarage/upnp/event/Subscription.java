package com.hpplay.cybergarage.upnp.event;

import com.hpplay.cybergarage.upnp.UPnP;

/* loaded from: classes2.dex */
public class Subscription {
    public static final String INFINITE_STRING = "infinite";
    public static final int INFINITE_VALUE = -1;
    public static final String SUBSCRIBE_METHOD = "SUBSCRIBE";
    public static final String TIMEOUT_HEADER = "Second-";
    public static final String UNSUBSCRIBE_METHOD = "UNSUBSCRIBE";
    public static final String UUID = "uuid:";
    public static final String XMLNS = "urn:schemas-upnp-org:event-1-0";

    public static final String createSID() {
        return UPnP.createUUID();
    }

    public static final String getSID(String str) {
        return str == null ? "" : !str.startsWith(UUID) ? str : str.substring(5, str.length());
    }

    public static final long getTimeout(String str) {
        try {
            return Long.parseLong(str.substring(str.indexOf(45) + 1, str.length()));
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static final String toSIDHeaderString(String str) {
        return UUID + str;
    }

    public static final String toTimeoutHeaderString(long j10) {
        if (j10 == -1) {
            return INFINITE_STRING;
        }
        return TIMEOUT_HEADER + Long.toString(j10);
    }
}
