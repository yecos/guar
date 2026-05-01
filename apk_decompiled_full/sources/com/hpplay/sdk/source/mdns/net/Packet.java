package com.hpplay.sdk.source.mdns.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
public class Packet {
    protected static int sequence;
    private final InetAddress address;
    private final byte[] data;
    protected int id;
    private final int port;

    public Packet(DatagramPacket datagramPacket) {
        this(datagramPacket.getAddress(), datagramPacket.getPort(), datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPort() {
        return this.port;
    }

    public SocketAddress getSocketAddress() {
        return new InetSocketAddress(this.address, this.port);
    }

    public Packet(InetAddress inetAddress, int i10, byte[] bArr, int i11, int i12) {
        int i13 = sequence;
        sequence = i13 + 1;
        this.id = i13;
        this.address = inetAddress;
        this.port = i10;
        byte[] bArr2 = new byte[i12 - i11];
        this.data = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, bArr2.length);
    }
}
