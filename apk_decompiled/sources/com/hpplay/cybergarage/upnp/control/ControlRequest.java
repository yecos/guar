package com.hpplay.cybergarage.upnp.control;

import android.text.TextUtils;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.soap.SOAPRequest;
import com.hpplay.cybergarage.upnp.Service;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes2.dex */
public class ControlRequest extends SOAPRequest {
    public ControlRequest() {
    }

    public boolean isActionControl() {
        return !isQueryControl();
    }

    public boolean isQueryControl() {
        return isSOAPAction(Control.QUERY_SOAPACTION);
    }

    public void setRequestHost(Service service) {
        String controlURL = service.getControlURL();
        String uRLBase = service.getRootDevice().getURLBase();
        if (uRLBase != null && uRLBase.length() > 0) {
            try {
                String path = new URL(uRLBase).getPath();
                int length = path.length();
                if (length > 0 && (1 < length || path.charAt(0) != '/')) {
                    controlURL = path + controlURL;
                }
            } catch (MalformedURLException unused) {
            }
        }
        setURI(controlURL, true);
        if (!HTTP.isAbsoluteURL(controlURL)) {
            controlURL = "";
        }
        if (controlURL == null || controlURL.length() <= 0) {
            controlURL = service.getRootDevice().getURLBase();
        }
        String location = service.getRootDevice().getLocation();
        if (controlURL == null || controlURL.length() <= 0) {
            controlURL = service.getRootDevice().getLocation();
        }
        String host = HTTP.getHost(controlURL);
        int port = HTTP.getPort(controlURL);
        String host2 = HTTP.getHost(location);
        int port2 = HTTP.getPort(location);
        if (!TextUtils.equals(host, host2) || port2 != port) {
            port = port2;
            host = host2;
        }
        setHost(host, port);
        setRequestHost(host);
        setRequestPort(port);
    }

    public ControlRequest(HTTPRequest hTTPRequest) {
        set(hTTPRequest);
    }
}
