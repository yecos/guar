package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public class CNAMERecord extends SingleCompressedNameBase {
    private static final long serialVersionUID = -4020373886892538580L;

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new CNAMERecord();
    }

    public Name getTarget() {
        return getSingleName();
    }
}
