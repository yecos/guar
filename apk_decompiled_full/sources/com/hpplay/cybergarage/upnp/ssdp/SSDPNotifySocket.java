package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.ControlPoint;
import java.io.IOException;

/* loaded from: classes2.dex */
public class SSDPNotifySocket extends HTTPMUSocket implements Runnable {
    private static final String TAG = "hpplay-SSDPNotifySocket";
    private ControlPoint controlPoint = null;
    private Thread deviceNotifyThread = null;
    private boolean isRuning;
    private boolean useIPv6Address;

    public SSDPNotifySocket(String str) {
        String str2;
        this.useIPv6Address = false;
        if (HostInterface.isIPv6Address(str)) {
            str2 = SSDP.getIPv6Address();
            this.useIPv6Address = true;
        } else {
            str2 = SSDP.ADDRESS;
        }
        open(str2, SSDP.PORT, str);
        setControlPoint(null);
    }

    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    public boolean isRuning() {
        return this.isRuning;
    }

    public boolean post(SSDPNotifyRequest sSDPNotifyRequest) {
        sSDPNotifyRequest.setHost(this.useIPv6Address ? SSDP.getIPv6Address() : SSDP.ADDRESS, SSDP.PORT);
        return post((HTTPRequest) sSDPNotifyRequest);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread currentThread = Thread.currentThread();
            ControlPoint controlPoint = getControlPoint();
            while (this.deviceNotifyThread == currentThread) {
                Thread.yield();
                this.isRuning = true;
                try {
                    SSDPPacket receive = receive();
                    if (receive != null && controlPoint != null) {
                        try {
                            controlPoint.notifyReceived(receive);
                        } catch (Exception e10) {
                            CLog.w(TAG, e10);
                        }
                    }
                } catch (IOException unused) {
                }
            }
        } catch (Exception e11) {
            CLog.w(TAG, e11);
        }
        this.isRuning = false;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    public void start() {
        StringBuffer stringBuffer = new StringBuffer("hpplay.SSDPNotifySocket/");
        String localAddress = getLocalAddress();
        if (localAddress != null && localAddress.length() > 0) {
            stringBuffer.append(getLocalAddress());
            stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            stringBuffer.append(getLocalPort());
            stringBuffer.append(" -> ");
            stringBuffer.append(getMulticastAddress());
            stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            stringBuffer.append(getMulticastPort());
        }
        Thread thread = new Thread(this, stringBuffer.toString());
        this.deviceNotifyThread = thread;
        thread.start();
    }

    public void stop() {
        CLog.i(TAG, " notify stop ...");
        this.isRuning = false;
        close();
        this.deviceNotifyThread = null;
    }
}
