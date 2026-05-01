package com.hpplay.cybergarage.upnp.event;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.http.HTTPResponse;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.cybergarage.upnp.device.NT;

/* loaded from: classes2.dex */
public class SubscriptionRequest extends HTTPRequest {
    private static final String CALLBACK_END_WITH = ">";
    private static final String CALLBACK_START_WITH = "<";

    public SubscriptionRequest() {
        setContentLength(0L);
    }

    private void setService(Service service) {
        Device rootDevice;
        Device rootDevice2;
        String eventSubURL = service.getEventSubURL();
        setURI(eventSubURL, true);
        Device device = service.getDevice();
        String location = device != null ? device.getLocation() : "";
        if ((location == null || location.length() <= 0) && (rootDevice = service.getRootDevice()) != null) {
            location = rootDevice.getLocation();
        }
        if ((location == null || location.length() <= 0) && (rootDevice2 = service.getRootDevice()) != null) {
            location = rootDevice2.getURLBase();
        }
        if ((location != null && location.length() > 0) || !HTTP.isAbsoluteURL(eventSubURL)) {
            eventSubURL = location;
        }
        String host = HTTP.getHost(eventSubURL);
        int port = HTTP.getPort(eventSubURL);
        setHost(host, port);
        setRequestHost(host);
        setRequestPort(port);
    }

    public String getCallback() {
        return getStringHeaderValue(HTTP.CALLBACK, "<", ">");
    }

    public String getNT() {
        return getHeaderValue(HTTP.NT);
    }

    public String getSID() {
        String sid = Subscription.getSID(getHeaderValue(HTTP.SID));
        return sid == null ? "" : sid;
    }

    public long getTimeout() {
        return Subscription.getTimeout(getHeaderValue(HTTP.TIMEOUT));
    }

    public boolean hasCallback() {
        String callback = getCallback();
        return callback != null && callback.length() > 0;
    }

    public boolean hasNT() {
        String nt = getNT();
        return nt != null && nt.length() > 0;
    }

    public boolean hasSID() {
        String sid = getSID();
        return sid != null && sid.length() > 0;
    }

    public void post(SubscriptionResponse subscriptionResponse) {
        super.post((HTTPResponse) subscriptionResponse);
    }

    public void setCallback(String str) {
        setStringHeader(HTTP.CALLBACK, str, "<", ">");
    }

    public void setNT(String str) {
        setHeader(HTTP.NT, str);
    }

    public void setRenewRequest(Service service, String str, long j10) {
        setMethod("SUBSCRIBE");
        setService(service);
        setSID(str);
        setTimeout(j10);
    }

    public void setSID(String str) {
        setHeader(HTTP.SID, Subscription.toSIDHeaderString(str));
    }

    public void setSubscribeRequest(Service service, String str, long j10) {
        setMethod("SUBSCRIBE");
        setService(service);
        setCallback(str);
        setNT(NT.EVENT);
        setTimeout(j10);
    }

    public final void setTimeout(long j10) {
        setHeader(HTTP.TIMEOUT, Subscription.toTimeoutHeaderString(j10));
    }

    public void setUnsubscribeRequest(Service service) {
        setMethod("UNSUBSCRIBE");
        setService(service);
        setSID(service.getSID());
    }

    public SubscriptionResponse post() {
        return new SubscriptionResponse(post(getRequestHost(), getRequestPort()));
    }

    public SubscriptionRequest(HTTPRequest hTTPRequest) {
        this();
        set(hTTPRequest);
    }
}
