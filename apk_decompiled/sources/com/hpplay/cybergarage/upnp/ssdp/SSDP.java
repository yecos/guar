package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes2.dex */
public class SSDP {
    public static final String ADDRESS = "239.255.255.250";
    public static final int DEFAULT_MSEARCH_MX = 3;
    private static String IPV6_ADDRESS = null;
    public static final String IPV6_ADMINISTRATIVE_ADDRESS = "FF04::C";
    public static final String IPV6_GLOBAL_ADDRESS = "FF0E::C";
    public static final String IPV6_LINK_LOCAL_ADDRESS = "FF02::C";
    public static final String IPV6_SITE_LOCAL_ADDRESS = "FF05::C";
    public static final String IPV6_SUBNET_ADDRESS = "FF03::C";
    public static final int PORT = 1900;
    public static final int RECV_MESSAGE_BUFSIZE = 1024;
    private static final String TAG = "Cyber-SSDP";

    static {
        setIPv6Address(IPV6_LINK_LOCAL_ADDRESS);
    }

    public static final String getIPv6Address() {
        return IPV6_ADDRESS;
    }

    public static final int getLeaseTime(String str) {
        int indexOf = str.indexOf(HTTP.MAX_AGE);
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf(44, indexOf);
            if (indexOf2 < 0) {
                indexOf2 = str.length();
            }
            try {
                return Integer.parseInt(str.substring(str.indexOf(Operator.Operation.EQUALS, indexOf) + 1, indexOf2).trim());
            } catch (Exception e10) {
                CLog.d(TAG, null, e10);
            }
        }
        return 0;
    }

    public static final void setIPv6Address(String str) {
        IPV6_ADDRESS = str;
    }
}
