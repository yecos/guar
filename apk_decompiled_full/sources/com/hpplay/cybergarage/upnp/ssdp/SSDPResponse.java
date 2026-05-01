package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPResponse;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class SSDPResponse extends HTTPResponse {
    public SSDPResponse() {
        setVersion("1.1");
    }

    public int getBootId() {
        return getIntegerHeaderValue(HTTP.BOOTID_UPNP_ORG);
    }

    @Override // com.hpplay.cybergarage.http.HTTPResponse
    public String getHeader() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getStatusLineString());
        stringBuffer.append(getHeaderString());
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }

    public int getLeaseTime() {
        return SSDP.getLeaseTime(getHeaderValue("Cache-Control"));
    }

    public String getLocation() {
        return getHeaderValue("Location");
    }

    public String getMYNAME() {
        return getHeaderValue(HTTP.MYNAME);
    }

    public String getST() {
        return getHeaderValue(HTTP.ST);
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

    public void setMYNAME(String str) {
        setHeader(HTTP.MYNAME, str);
    }

    public void setST(String str) {
        setHeader(HTTP.ST, str);
    }

    public void setUSN(String str) {
        setHeader(HTTP.USN, str);
    }

    public SSDPResponse(InputStream inputStream) {
        super(inputStream);
    }
}
