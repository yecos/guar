package com.hpplay.sdk.source.mdns.net;

import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;

/* loaded from: classes3.dex */
public abstract class NetworkProcessor implements Closeable, Runnable {
    public static final int AVERAGE_QUEUE_THRESHOLD = 2;
    public static final int DEFAULT_MTU = 1500;
    public static final int MAX_QUEUE_THRESHOLD = 10;
    public static final int PACKET_MONITOR_NO_PACKET_RECEIVED_TIMEOUT = 100000;
    public static final String TAG = "NetworkProcessor";
    protected InetAddress address;
    protected InetAddress ifaceAddress;
    protected boolean ipv6;
    protected PacketListener listener;
    protected int port;
    protected int mtu = 1500;
    protected transient boolean exit = false;
    protected NetworkReadThread networkReadThread = null;
    protected boolean isClose = false;
    protected boolean threadMonitoring = Options.check("mdns_network_thread_monitor");

    public NetworkProcessor(InetAddress inetAddress, InetAddress inetAddress2, int i10, PacketListener packetListener) {
        setInterfaceAddress(inetAddress);
        this.address = inetAddress2;
        setPort(i10);
        if (inetAddress.getAddress().length != inetAddress2.getAddress().length) {
            throw new IOException("Interface Address and bind address bust be the same IP specifciation!");
        }
        this.ipv6 = inetAddress2.getAddress().length > 4;
        this.listener = packetListener;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.exit = true;
        this.isClose = true;
        NetworkReadThread networkReadThread = this.networkReadThread;
        if (networkReadThread != null) {
            networkReadThread.interrupt();
        }
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public InetAddress getInterfaceAddress() {
        return this.ifaceAddress;
    }

    public int getMTU() {
        return this.mtu;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isIPv4() {
        return !this.ipv6;
    }

    public boolean isIPv6() {
        return this.ipv6;
    }

    public boolean isOperational() {
        return !this.exit;
    }

    public abstract void send(byte[] bArr);

    public void setInterfaceAddress(InetAddress inetAddress) {
        this.ifaceAddress = inetAddress;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public synchronized void start() {
        this.exit = false;
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------ > >>> >>> NetworkProcessor   run");
        sb.append(this.threadMonitoring);
        NetworkReadThread networkReadThread = new NetworkReadThread(this);
        this.networkReadThread = networkReadThread;
        networkReadThread.start();
    }
}
