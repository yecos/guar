package com.hpplay.sdk.source.mdns.xbill.dns;

import com.taobao.accs.common.Constants;

/* loaded from: classes3.dex */
public class SOARecord extends Record {
    private static final long serialVersionUID = 1049740098229303931L;
    private Name admin;
    private long expire;
    private Name host;
    private long minimum;
    private long refresh;
    private long retry;
    private long serial;

    public SOARecord() {
    }

    public Name getHost() {
        return this.host;
    }

    public long getMinimum() {
        return this.minimum;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new SOARecord();
    }

    public long getSerial() {
        return this.serial;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.host = tokenizer.getName(name);
        this.admin = tokenizer.getName(name);
        this.serial = tokenizer.getUInt32();
        this.refresh = tokenizer.getTTLLike();
        this.retry = tokenizer.getTTLLike();
        this.expire = tokenizer.getTTLLike();
        this.minimum = tokenizer.getTTLLike();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.host = new Name(dNSInput);
        this.admin = new Name(dNSInput);
        this.serial = dNSInput.readU32();
        this.refresh = dNSInput.readU32();
        this.retry = dNSInput.readU32();
        this.expire = dNSInput.readU32();
        this.minimum = dNSInput.readU32();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.host);
        stringBuffer.append(" ");
        stringBuffer.append(this.admin);
        if (Options.check("multiline")) {
            stringBuffer.append(" (\n\t\t\t\t\t");
            stringBuffer.append(this.serial);
            stringBuffer.append("\t; serial\n\t\t\t\t\t");
            stringBuffer.append(this.refresh);
            stringBuffer.append("\t; refresh\n\t\t\t\t\t");
            stringBuffer.append(this.retry);
            stringBuffer.append("\t; retry\n\t\t\t\t\t");
            stringBuffer.append(this.expire);
            stringBuffer.append("\t; expire\n\t\t\t\t\t");
            stringBuffer.append(this.minimum);
            stringBuffer.append(" )\t; minimum");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(this.serial);
            stringBuffer.append(" ");
            stringBuffer.append(this.refresh);
            stringBuffer.append(" ");
            stringBuffer.append(this.retry);
            stringBuffer.append(" ");
            stringBuffer.append(this.expire);
            stringBuffer.append(" ");
            stringBuffer.append(this.minimum);
        }
        return stringBuffer.toString();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        this.host.toWire(dNSOutput, compression, z10);
        this.admin.toWire(dNSOutput, compression, z10);
        dNSOutput.writeU32(this.serial);
        dNSOutput.writeU32(this.refresh);
        dNSOutput.writeU32(this.retry);
        dNSOutput.writeU32(this.expire);
        dNSOutput.writeU32(this.minimum);
    }

    public SOARecord(Name name, int i10, long j10, Name name2, Name name3, long j11, long j12, long j13, long j14, long j15) {
        super(name, 6, i10, j10);
        this.host = Record.checkName(Constants.KEY_HOST, name2);
        this.admin = Record.checkName("admin", name3);
        this.serial = Record.checkU32("serial", j11);
        this.refresh = Record.checkU32("refresh", j12);
        this.retry = Record.checkU32("retry", j13);
        this.expire = Record.checkU32("expire", j14);
        this.minimum = Record.checkU32("minimum", j15);
    }
}
