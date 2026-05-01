package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.sdk.source.mdns.xbill.dns.DNSSEC;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import java.util.Date;

/* loaded from: classes3.dex */
abstract class SIGBase extends Record {
    private static final long serialVersionUID = -3738444391533812369L;
    protected int alg;
    protected int covered;
    protected Date expire;
    protected int footprint;
    protected int labels;
    protected long origttl;
    protected byte[] signature;
    protected Name signer;
    protected Date timeSigned;

    public SIGBase() {
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public Date getExpire() {
        return this.expire;
    }

    public int getFootprint() {
        return this.footprint;
    }

    public int getLabels() {
        return this.labels;
    }

    public long getOrigTTL() {
        return this.origttl;
    }

    public Name getSigner() {
        return this.signer;
    }

    public Date getTimeSigned() {
        return this.timeSigned;
    }

    public int getTypeCovered() {
        return this.covered;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        String string = tokenizer.getString();
        int value = Type.value(string);
        this.covered = value;
        if (value < 0) {
            throw tokenizer.exception("Invalid type: " + string);
        }
        String string2 = tokenizer.getString();
        int value2 = DNSSEC.Algorithm.value(string2);
        this.alg = value2;
        if (value2 < 0) {
            throw tokenizer.exception("Invalid algorithm: " + string2);
        }
        this.labels = tokenizer.getUInt8();
        this.origttl = tokenizer.getTTL();
        this.expire = FormattedTime.parse(tokenizer.getString());
        this.timeSigned = FormattedTime.parse(tokenizer.getString());
        this.footprint = tokenizer.getUInt16();
        this.signer = tokenizer.getName(name);
        this.signature = tokenizer.getBase64();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.covered = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.labels = dNSInput.readU8();
        this.origttl = dNSInput.readU32();
        this.expire = new Date(dNSInput.readU32() * 1000);
        this.timeSigned = new Date(dNSInput.readU32() * 1000);
        this.footprint = dNSInput.readU16();
        this.signer = new Name(dNSInput);
        this.signature = dNSInput.readByteArray();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Type.string(this.covered));
        stringBuffer.append(" ");
        stringBuffer.append(this.alg);
        stringBuffer.append(" ");
        stringBuffer.append(this.labels);
        stringBuffer.append(" ");
        stringBuffer.append(this.origttl);
        stringBuffer.append(" ");
        if (Options.check("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(FormattedTime.format(this.expire));
        stringBuffer.append(" ");
        stringBuffer.append(FormattedTime.format(this.timeSigned));
        stringBuffer.append(" ");
        stringBuffer.append(this.footprint);
        stringBuffer.append(" ");
        stringBuffer.append(this.signer);
        if (Options.check("multiline")) {
            stringBuffer.append("\n");
            stringBuffer.append(base64.formatString(this.signature, 64, HTTP.TAB, true));
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(base64.toString(this.signature));
        }
        return stringBuffer.toString();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeU16(this.covered);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.labels);
        dNSOutput.writeU32(this.origttl);
        dNSOutput.writeU32(this.expire.getTime() / 1000);
        dNSOutput.writeU32(this.timeSigned.getTime() / 1000);
        dNSOutput.writeU16(this.footprint);
        this.signer.toWire(dNSOutput, null, z10);
        dNSOutput.writeByteArray(this.signature);
    }

    public void setSignature(byte[] bArr) {
        this.signature = bArr;
    }

    public SIGBase(Name name, int i10, int i11, long j10, int i12, int i13, long j11, Date date, Date date2, int i14, Name name2, byte[] bArr) {
        super(name, i10, i11, j10);
        Type.check(i12);
        TTL.check(j11);
        this.covered = i12;
        this.alg = Record.checkU8("alg", i13);
        this.labels = name.labels() - 1;
        if (name.isWild()) {
            this.labels--;
        }
        this.origttl = j11;
        this.expire = date;
        this.timeSigned = date2;
        this.footprint = Record.checkU16("footprint", i14);
        this.signer = Record.checkName("signer", name2);
        this.signature = bArr;
    }
}
