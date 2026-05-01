package com.hpplay.sdk.source.mdns.net;

import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: classes3.dex */
public class DatagramProcessor extends NetworkProcessor {
    private static final String TAG = "DatagramProcessor";
    protected boolean isMulticast;
    private long lastPacket;
    protected boolean loopbackModeDisabled;
    protected int maxPayloadSize;
    protected boolean reuseAddress;
    protected DatagramSocket socket;
    protected int ttl;

    public DatagramProcessor(InetAddress inetAddress, InetAddress inetAddress2, int i10, PacketListener packetListener) {
        super(inetAddress, inetAddress2, i10, packetListener);
        int mtu;
        InetAddress inetAddress3;
        this.maxPayloadSize = 512;
        this.isMulticast = false;
        this.loopbackModeDisabled = false;
        this.reuseAddress = true;
        this.ttl = 255;
        if (inetAddress2 != null) {
            this.isMulticast = inetAddress2.isMulticastAddress();
        }
        if (this.isMulticast) {
            MulticastSocket multicastSocket = new MulticastSocket(i10);
            String value = Options.value("mdns_multicast_loopback");
            if (value != null && value.length() > 0) {
                this.loopbackModeDisabled = "true".equalsIgnoreCase(value) || "t".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) || "y".equalsIgnoreCase(value);
            }
            String value2 = Options.value("mdns_socket_ttl");
            if (value2 != null && value2.length() > 0) {
                try {
                    this.ttl = Integer.valueOf(value2).intValue();
                } catch (Exception unused) {
                }
            }
            this.reuseAddress = true;
            multicastSocket.setLoopbackMode(this.loopbackModeDisabled);
            multicastSocket.setReuseAddress(this.reuseAddress);
            multicastSocket.setTimeToLive(this.ttl);
            multicastSocket.joinGroup(inetAddress2);
            this.socket = multicastSocket;
        } else {
            this.socket = new DatagramSocket(new InetSocketAddress(inetAddress, i10));
        }
        NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
        if (byInetAddress == null && (byInetAddress = NetworkInterface.getByInetAddress(this.socket.getLocalAddress())) == null && (inetAddress3 = this.socket.getInetAddress()) != null) {
            byInetAddress = NetworkInterface.getByInetAddress(inetAddress3);
        }
        if (byInetAddress != null) {
            try {
                this.mtu = byInetAddress.getMTU();
            } catch (SocketException unused2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error getting MTU from nw Interface ");
                sb.append((Object) null);
                sb.append(". Using default MTU.");
                byInetAddress = null;
            }
        }
        if (byInetAddress == null) {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 1500;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback() && !nextElement.isVirtual() && nextElement.isUp() && (mtu = nextElement.getMTU()) < i11) {
                    i11 = mtu;
                }
            }
            this.mtu = i11;
        }
        this.maxPayloadSize = (this.mtu - 40) - 8;
    }

    @Override // com.hpplay.sdk.source.mdns.net.NetworkProcessor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.isMulticast) {
            try {
                ((MulticastSocket) this.socket).leaveGroup(this.address);
            } catch (Exception unused) {
            }
        }
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public int getMaxPayloadSize() {
        return this.maxPayloadSize;
    }

    public int getTTL() {
        return this.ttl;
    }

    public boolean isLoopbackModeDisabled() {
        return this.loopbackModeDisabled;
    }

    public boolean isMulticast() {
        return this.isMulticast;
    }

    @Override // com.hpplay.sdk.source.mdns.net.NetworkProcessor
    public boolean isOperational() {
        return super.isOperational() && this.socket.isBound() && !this.socket.isClosed() && this.lastPacket <= System.currentTimeMillis() + 120000;
    }

    public boolean isReuseAddress() {
        return this.reuseAddress;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lastPacket = System.currentTimeMillis();
        DNSParserThread dNSParserThread = new DNSParserThread(this.listener);
        dNSParserThread.start();
        while (!this.exit && !this.isClose) {
            try {
                int i10 = this.mtu;
                DatagramPacket datagramPacket = new DatagramPacket(new byte[i10], i10);
                this.socket.receive(datagramPacket);
                this.lastPacket = System.currentTimeMillis();
                if (datagramPacket.getLength() > 0) {
                    dNSParserThread.updateReceiveData(new Packet(datagramPacket));
                }
            } catch (Exception unused) {
            }
        }
        dNSParserThread.release();
    }

    @Override // com.hpplay.sdk.source.mdns.net.NetworkProcessor
    public void send(byte[] bArr) {
        if (this.exit) {
            return;
        }
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.address, this.port);
        try {
            if (this.isMulticast) {
                ((MulticastSocket) this.socket).setTimeToLive(255);
            }
            this.socket.send(datagramPacket);
        } catch (IOException e10) {
            if ("no route to host".equalsIgnoreCase(e10.getMessage())) {
                close();
            }
            IOException iOException = new IOException("Exception \"" + e10.getMessage() + "\" occured while sending datagram to \"" + datagramPacket.getSocketAddress() + "\".", e10);
            iOException.setStackTrace(e10.getStackTrace());
            throw iOException;
        }
    }
}
