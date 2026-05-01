package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import com.taobao.accs.common.Constants;
import java.security.PublicKey;

/* loaded from: classes3.dex */
abstract class KEYBase extends Record {
    private static final long serialVersionUID = 3469321722693285454L;
    protected int alg;
    protected int flags;
    protected int footprint;
    protected byte[] key;
    protected int proto;
    protected PublicKey publicKey;

    public KEYBase() {
        this.footprint = -1;
        this.publicKey = null;
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFootprint() {
        int i10;
        int i11;
        int i12 = this.footprint;
        if (i12 >= 0) {
            return i12;
        }
        DNSOutput dNSOutput = new DNSOutput();
        int i13 = 0;
        rrToWire(dNSOutput, null, false);
        byte[] byteArray = dNSOutput.toByteArray();
        if (this.alg == 1) {
            int i14 = byteArray[byteArray.length - 3] & UnsignedBytes.MAX_VALUE;
            i11 = byteArray[byteArray.length - 2] & UnsignedBytes.MAX_VALUE;
            i10 = i14 << 8;
        } else {
            i10 = 0;
            while (i13 < byteArray.length - 1) {
                i10 += ((byteArray[i13] & UnsignedBytes.MAX_VALUE) << 8) + (byteArray[i13 + 1] & UnsignedBytes.MAX_VALUE);
                i13 += 2;
            }
            if (i13 < byteArray.length) {
                i10 += (byteArray[i13] & UnsignedBytes.MAX_VALUE) << 8;
            }
            i11 = (i10 >> 16) & Message.MAXLENGTH;
        }
        int i15 = (i10 + i11) & Message.MAXLENGTH;
        this.footprint = i15;
        return i15;
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getProtocol() {
        return this.proto;
    }

    public PublicKey getPublicKey() {
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return publicKey;
        }
        PublicKey publicKey2 = DNSSEC.toPublicKey(this);
        this.publicKey = publicKey2;
        return publicKey2;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.flags = dNSInput.readU16();
        this.proto = dNSInput.readU8();
        this.alg = dNSInput.readU8();
        if (dNSInput.remaining() > 0) {
            this.key = dNSInput.readByteArray();
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.flags);
        stringBuffer.append(" ");
        stringBuffer.append(this.proto);
        stringBuffer.append(" ");
        stringBuffer.append(this.alg);
        if (this.key != null) {
            if (Options.check("multiline")) {
                stringBuffer.append(" (\n");
                stringBuffer.append(base64.formatString(this.key, 64, HTTP.TAB, true));
                stringBuffer.append(" ; key_tag = ");
                stringBuffer.append(getFootprint());
            } else {
                stringBuffer.append(" ");
                stringBuffer.append(base64.toString(this.key));
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeU16(this.flags);
        dNSOutput.writeU8(this.proto);
        dNSOutput.writeU8(this.alg);
        byte[] bArr = this.key;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    public KEYBase(Name name, int i10, int i11, long j10, int i12, int i13, int i14, byte[] bArr) {
        super(name, i10, i11, j10);
        this.footprint = -1;
        this.publicKey = null;
        this.flags = Record.checkU16(Constants.KEY_FLAGS, i12);
        this.proto = Record.checkU8("proto", i13);
        this.alg = Record.checkU8("alg", i14);
        this.key = bArr;
    }
}
