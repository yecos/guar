package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPRequest;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class SSDPRequest extends HTTPRequest {
    public SSDPRequest() {
        setVersion("1.1");
    }

    public int getBootId() {
        return getIntegerHeaderValue(HTTP.BOOTID_UPNP_ORG);
    }

    public int getLeaseTime() {
        return SSDP.getLeaseTime(getHeaderValue("Cache-Control"));
    }

    public String getLocation() {
        return getHeaderValue("Location");
    }

    public String getNT() {
        return getHeaderValue(HTTP.NT);
    }

    public String getNTS() {
        return getHeaderValue(HTTP.NTS);
    }

    public String getUSN() {
        return getHeaderValue(HTTP.USN);
    }

    public void setBootId(int i10) {
        setHeader(HTTP.BOOTID_UPNP_ORG, i10);
    }

    public void setLeaseTime(int i10) {
        setHeader("Cache-Control", "max-age=" + Integer.toString(i10));
    }

    public void setLocation(String str) {
        setHeader("Location", str);
    }

    public void setNT(String str) {
        setHeader(HTTP.NT, str);
    }

    public void setNTS(String str) {
        setHeader(HTTP.NTS, str);
    }

    public void setUSN(String str) {
        setHeader(HTTP.USN, str);
    }

    public SSDPRequest(InputStream inputStream) {
        super(inputStream);
    }
}
