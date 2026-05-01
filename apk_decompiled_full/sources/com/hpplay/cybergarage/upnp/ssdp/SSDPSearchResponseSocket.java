package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.ControlPoint;
import java.net.DatagramSocket;

/* loaded from: classes2.dex */
public class SSDPSearchResponseSocket extends HTTPUSocket implements Runnable {
    private ControlPoint controlPoint;
    private Thread deviceSearchResponseThread;

    public SSDPSearchResponseSocket() {
        this.controlPoint = null;
        this.deviceSearchResponseThread = null;
        setControlPoint(null);
    }

    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    public boolean post(String str, int i10, SSDPSearchResponse sSDPSearchResponse) {
        return post(str, i10, sSDPSearchResponse.getHeader());
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        ControlPoint controlPoint = getControlPoint();
        while (this.deviceSearchResponseThread == currentThread) {
            Thread.yield();
            SSDPPacket receive = receive();
            if (receive == null) {
                return;
            }
            if (controlPoint != null) {
                controlPoint.searchResponseReceived(receive);
            }
        }
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    public void start() {
        StringBuffer stringBuffer = new StringBuffer("SSDPSearchResponseSocket/");
        DatagramSocket datagramSocket = getDatagramSocket();
        if (datagramSocket.getLocalAddress() != null) {
            stringBuffer.append(datagramSocket.getLocalAddress());
            stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            stringBuffer.append(datagramSocket.getLocalPort());
        }
        Thread thread = new Thread(this, stringBuffer.toString());
        this.deviceSearchResponseThread = thread;
        thread.start();
    }

    public void stop() {
        this.deviceSearchResponseThread = null;
    }

    public boolean post(String str, int i10, SSDPSearchRequest sSDPSearchRequest) {
        return post(str, i10, sSDPSearchRequest.toString());
    }

    public SSDPSearchResponseSocket(String str, int i10) {
        super(str, i10);
        this.controlPoint = null;
        this.deviceSearchResponseThread = null;
        setControlPoint(null);
    }
}
