package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
abstract class SingleNameBase extends Record {
    private static final long serialVersionUID = -18595042501413L;
    protected Name singleName;

    public SingleNameBase() {
    }

    public Name getSingleName() {
        return this.singleName;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.singleName = tokenizer.getName(name);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.singleName = new Name(dNSInput);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        return this.singleName.toString();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        this.singleName.toWire(dNSOutput, null, z10);
    }

    public SingleNameBase(Name name, int i10, int i11, long j10, Name name2, String str) {
        super(name, i10, i11, j10);
        this.singleName = Record.checkName(str, name2);
    }
}
