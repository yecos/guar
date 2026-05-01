package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
class EmptyRecord extends Record {
    private static final long serialVersionUID = 3601852050646429582L;

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new EmptyRecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        return "";
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
    }
}
