package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.upnp.UPnP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.Enumeration;

/* loaded from: classes2.dex */
public class HTTPMUSocket {
    private static final String TAG = "hpplay-HTTPMUSocket";
    private InetSocketAddress ssdpMultiGroup = null;
    private MulticastSocket ssdpMultiSock = null;
    private NetworkInterface ssdpMultiIf = null;

    public HTTPMUSocket() {
    }

    public synchronized boolean close() {
        MulticastSocket multicastSocket = this.ssdpMultiSock;
        if (multicastSocket == null) {
            return true;
        }
        try {
            multicastSocket.leaveGroup(this.ssdpMultiGroup, this.ssdpMultiIf);
            this.ssdpMultiSock.close();
            this.ssdpMultiSock = null;
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public void finalize() {
    }

    public String getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.ssdpMultiGroup;
        if (inetSocketAddress != null && this.ssdpMultiIf != null) {
            InetAddress address = inetSocketAddress.getAddress();
            Enumeration<InetAddress> inetAddresses = this.ssdpMultiIf.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if ((address instanceof Inet6Address) && (nextElement instanceof Inet6Address)) {
                    return nextElement.getHostAddress();
                }
                if ((address instanceof Inet4Address) && (nextElement instanceof Inet4Address)) {
                    return nextElement.getHostAddress();
                }
            }
        }
        return "";
    }

    public int getLocalPort() {
        return this.ssdpMultiSock.getLocalPort();
    }

    public String getMulticastAddress() {
        return getMulticastInetAddress() != null ? getMulticastInetAddress().getHostAddress() : "";
    }

    public InetAddress getMulticastInetAddress() {
        try {
            return this.ssdpMultiGroup.getAddress();
        } catch (Exception unused) {
            return null;
        }
    }

    public int getMulticastPort() {
        return this.ssdpMultiGroup.getPort();
    }

    public MulticastSocket getSocket() {
        return this.ssdpMultiSock;
    }

    public boolean open(String str, int i10, InetAddress inetAddress) {
        try {
            MulticastSocket multicastSocket = new MulticastSocket((SocketAddress) null);
            this.ssdpMultiSock = multicastSocket;
            multicastSocket.setReuseAddress(true);
            this.ssdpMultiSock.bind(new InetSocketAddress(i10));
            this.ssdpMultiGroup = new InetSocketAddress(InetAddress.getByName(str), i10);
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
            this.ssdpMultiIf = byInetAddress;
            this.ssdpMultiSock.joinGroup(this.ssdpMultiGroup, byInetAddress);
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public boolean post(HTTPRequest hTTPRequest, String str, int i10) {
        return send(hTTPRequest.toString(), str, i10);
    }

    public SSDPPacket receive() {
        SSDPPacket sSDPPacket = new SSDPPacket(new byte[1024], 1024);
        sSDPPacket.setLocalAddress(getLocalAddress());
        if (this.ssdpMultiSock == null) {
            throw new IOException("Multicast socket has already been closed.");
        }
        DatagramPacket datagramPacket = sSDPPacket.getDatagramPacket();
        if (datagramPacket != null) {
            try {
                this.ssdpMultiSock.receive(datagramPacket);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        sSDPPacket.setTimeStamp(System.currentTimeMillis());
        return sSDPPacket;
    }

    public boolean send(String str, String str2, int i10) {
        MulticastSocket multicastSocket;
        try {
            if (str2 == null || i10 <= 0) {
                multicastSocket = new MulticastSocket();
            } else {
                multicastSocket = new MulticastSocket((SocketAddress) null);
                multicastSocket.bind(new InetSocketAddress(str2, i10));
            }
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.length(), this.ssdpMultiGroup);
            multicastSocket.setTimeToLive(UPnP.getTimeToLive());
            multicastSocket.send(datagramPacket);
            multicastSocket.close();
            return true;
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public boolean post(HTTPRequest hTTPRequest) {
        return send(hTTPRequest.toString(), null, -1);
    }

    public HTTPMUSocket(String str, int i10, String str2) {
        open(str, i10, str2);
    }

    public boolean open(String str, int i10, String str2) {
        try {
            return open(str, i10, InetAddress.getByName(str2));
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return false;
        }
    }

    public boolean send(String str) {
        return send(str, null, -1);
    }
}
