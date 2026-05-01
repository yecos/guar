package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.net.HostInterface;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class SSDPSearchRequest extends SSDPRequest {
    public SSDPSearchRequest(String str, int i10, String str2) {
        setMethod(HTTP.M_SEARCH);
        setURI(Operator.Operation.MULTIPLY);
        setHeader(HTTP.ST, str);
        setHeader(HTTP.MX, Integer.toString(i10));
        setHeader(HTTP.MAN, "\"ssdp:discover\"");
        setHeader("User-Agent", String.format(Locale.getDefault(), "DMP/2.5.8, UPnP/1.0, %s", str2));
    }

    public void setLocalAddress(String str) {
        setHost(HostInterface.isIPv6Address(str) ? SSDP.getIPv6Address() : SSDP.ADDRESS, SSDP.PORT);
    }

    public SSDPSearchRequest(String str) {
        this(str, 3, "");
    }

    public SSDPSearchRequest() {
        this("upnp:rootdevice");
    }
}
