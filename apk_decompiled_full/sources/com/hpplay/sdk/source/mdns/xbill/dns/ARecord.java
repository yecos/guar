package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public class ARecord extends Record {
    private static final long serialVersionUID = -2172609200849142323L;
    private int addr;

    public ARecord() {
    }

    private static final int fromArray(byte[] bArr) {
        return (bArr[3] & UnsignedBytes.MAX_VALUE) | ((bArr[0] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    private static final byte[] toArray(int i10) {
        return new byte[]{(byte) ((i10 >>> 24) & 255), (byte) ((i10 >>> 16) & 255), (byte) ((i10 >>> 8) & 255), (byte) (i10 & 255)};
    }

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            return name == null ? InetAddress.getByAddress(toArray(this.addr)) : InetAddress.getByAddress(name.toString(), toArray(this.addr));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new ARecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.addr = fromArray(tokenizer.getAddressBytes(1));
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.addr = fromArray(dNSInput.readByteArray(4));
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        return Address.toDottedQuad(toArray(this.addr));
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeU32(this.addr & 4294967295L);
    }

    public ARecord(Name name, int i10, long j10, InetAddress inetAddress) {
        super(name, 1, i10, j10);
        if (Address.familyOf(inetAddress) != 1) {
            throw new IllegalArgumentException("invalid IPv4 address");
        }
        this.addr = fromArray(inetAddress.getAddress());
    }
}
