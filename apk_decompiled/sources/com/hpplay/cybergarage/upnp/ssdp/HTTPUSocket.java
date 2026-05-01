package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: classes2.dex */
public class HTTPUSocket {
    private static final String TAG = "Cyber-HTTPUSocket";
    private DatagramSocket ssdpUniSock = null;
    private String localAddr = "";

    public HTTPUSocket() {
        open();
    }

    public boolean close() {
        DatagramSocket datagramSocket = this.ssdpUniSock;
        if (datagramSocket == null) {
            return true;
        }
        try {
            datagramSocket.close();
            this.ssdpUniSock = null;
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public void finalize() {
        close();
    }

    public DatagramSocket getDatagramSocket() {
        return this.ssdpUniSock;
    }

    public String getLocalAddress() {
        try {
            return this.localAddr.length() > 0 ? this.localAddr : this.ssdpUniSock.getLocalAddress().getHostAddress();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return "127.0.0.1";
        }
    }

    public DatagramSocket getUDPSocket() {
        return this.ssdpUniSock;
    }

    public boolean open() {
        close();
        try {
            this.ssdpUniSock = new DatagramSocket();
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public boolean post(String str, int i10, String str2) {
        try {
            this.ssdpUniSock.send(new DatagramPacket(str2.getBytes(), str2.length(), InetAddress.getByName(str), i10));
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public SSDPPacket receive() {
        SSDPPacket sSDPPacket = new SSDPPacket(new byte[1024], 1024);
        try {
            sSDPPacket.setLocalAddress(getLocalAddress());
            this.ssdpUniSock.receive(sSDPPacket.getDatagramPacket());
            sSDPPacket.setTimeStamp(System.currentTimeMillis());
            CLog.d(TAG, "========================>>>>>>>>>>>>>> \r\n" + new String(sSDPPacket.getData()));
            return sSDPPacket;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setLocalAddress(String str) {
        this.localAddr = str;
    }

    public boolean open(String str, int i10) {
        close();
        try {
            this.ssdpUniSock = new DatagramSocket(new InetSocketAddress(str, i10));
            setLocalAddress(str);
            return true;
        } catch (BindException e10) {
            CLog.d(TAG, null, e10);
            throw e10;
        } catch (Exception e11) {
            CLog.d(TAG, null, e11);
            return false;
        }
    }

    public HTTPUSocket(String str, int i10) {
        open(str, i10);
    }

    public HTTPUSocket(int i10) {
        open(i10);
    }

    public boolean open(int i10) {
        close();
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(i10);
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.ssdpUniSock = datagramSocket;
            datagramSocket.setReuseAddress(true);
            this.ssdpUniSock.bind(inetSocketAddress);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
