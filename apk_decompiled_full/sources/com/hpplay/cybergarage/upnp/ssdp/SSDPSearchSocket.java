package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.device.SearchListener;
import com.hpplay.cybergarage.util.ListenerList;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* loaded from: classes2.dex */
public class SSDPSearchSocket extends HTTPMUSocket implements Runnable {
    private ListenerList deviceSearchListenerList = new ListenerList();
    private Thread deviceSearchThread = null;
    private boolean useIPv6Address;

    public SSDPSearchSocket(String str, int i10, String str2) {
        open(str, str2);
    }

    public void addSearchListener(SearchListener searchListener) {
        this.deviceSearchListenerList.add(searchListener);
    }

    public boolean open(Inet4Address inet4Address) {
        this.useIPv6Address = false;
        return open(SSDP.ADDRESS, SSDP.PORT, inet4Address);
    }

    public void performSearchListener(SSDPPacket sSDPPacket) {
        int size = this.deviceSearchListenerList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((SearchListener) this.deviceSearchListenerList.get(i10)).deviceSearchReceived(sSDPPacket);
        }
    }

    public void removeSearchListener(SearchListener searchListener) {
        this.deviceSearchListenerList.remove(searchListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (this.deviceSearchThread == currentThread) {
            Thread.yield();
            try {
                SSDPPacket receive = receive();
                if (receive != null && receive.isDiscover()) {
                    performSearchListener(receive);
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public void start() {
        StringBuffer stringBuffer = new StringBuffer("Cyber.SSDPSearchSocket/");
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
        this.deviceSearchThread = thread;
        thread.start();
    }

    public void stop() {
        close();
        this.deviceSearchThread = null;
    }

    public boolean open(Inet6Address inet6Address) {
        this.useIPv6Address = true;
        return open(SSDP.getIPv6Address(), SSDP.PORT, inet6Address);
    }

    public SSDPSearchSocket(InetAddress inetAddress) {
        if (inetAddress.getAddress().length != 4) {
            open((Inet6Address) inetAddress);
        } else {
            open((Inet4Address) inetAddress);
        }
    }

    public boolean open(String str, String str2) {
        if (HostInterface.isIPv6Address(str) && HostInterface.isIPv6Address(str2)) {
            this.useIPv6Address = true;
        } else if (HostInterface.isIPv4Address(str) && HostInterface.isIPv4Address(str2)) {
            this.useIPv6Address = false;
        } else {
            throw new IllegalArgumentException("Cannot open a UDP Socket for IPv6 address on IPv4 interface or viceversa");
        }
        return open(str2, SSDP.PORT, str);
    }

    public boolean open(String str) {
        String str2;
        this.useIPv6Address = false;
        if (HostInterface.isIPv6Address(str)) {
            str2 = SSDP.getIPv6Address();
            this.useIPv6Address = true;
        } else {
            str2 = SSDP.ADDRESS;
        }
        return open(str2, SSDP.PORT, str);
    }
}
