package com.hpplay.cybergarage.upnp.event;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPResponse;
import com.hpplay.cybergarage.upnp.UPnP;

/* loaded from: classes2.dex */
public class SubscriptionResponse extends HTTPResponse {
    public SubscriptionResponse() {
        setServer(UPnP.getServerName());
    }

    public String getSID() {
        return Subscription.getSID(getHeaderValue(HTTP.SID));
    }

    public long getTimeout() {
        return Subscription.getTimeout(getHeaderValue(HTTP.TIMEOUT));
    }

    public void setErrorResponse(int i10) {
        setStatusCode(i10);
        setContentLength(0L);
    }

    public void setResponse(int i10) {
        setStatusCode(i10);
        setContentLength(0L);
    }

    public void setSID(String str) {
        setHeader(HTTP.SID, Subscription.toSIDHeaderString(str));
    }

    public void setTimeout(long j10) {
        setHeader(HTTP.TIMEOUT, Subscription.toTimeoutHeaderString(j10));
    }

    public SubscriptionResponse(HTTPResponse hTTPResponse) {
        super(hTTPResponse);
    }
}
