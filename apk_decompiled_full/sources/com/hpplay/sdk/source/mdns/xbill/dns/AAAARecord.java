package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public class AAAARecord extends Record {
    private static final long serialVersionUID = -4588601512069748050L;
    private byte[] address;

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            return name == null ? InetAddress.getByAddress(this.address) : InetAddress.getByAddress(name.toString(), this.address);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new AAAARecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.address = tokenizer.getAddressBytes(2);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.address = dNSInput.readByteArray(16);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        try {
            InetAddress byAddress = InetAddress.getByAddress(null, this.address);
            if (byAddress.getAddress().length != 4) {
                return byAddress.getHostAddress();
            }
            StringBuffer stringBuffer = new StringBuffer("0:0:0:0:0:ffff:");
            byte[] bArr = this.address;
            int i10 = ((bArr[12] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[13] & UnsignedBytes.MAX_VALUE);
            int i11 = ((bArr[14] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[15] & UnsignedBytes.MAX_VALUE);
            stringBuffer.append(Integer.toHexString(i10));
            stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            stringBuffer.append(Integer.toHexString(i11));
            return stringBuffer.toString();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeByteArray(this.address);
    }
}
