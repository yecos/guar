package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public class PTRRecord extends SingleCompressedNameBase {
    private static final long serialVersionUID = -8321636610425434192L;

    public PTRRecord() {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new PTRRecord();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public PTRRecord(Name name, int i10, long j10, Name name2) {
        super(name, 12, i10, j10, name2, "target");
    }
}
