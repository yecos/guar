package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.List;

/* loaded from: classes3.dex */
public class TXTRecord extends TXTBase {
    private static final long serialVersionUID = -5780785764284221342L;

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new TXTRecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.TXTBase
    public /* bridge */ /* synthetic */ List getStrings() {
        return super.getStrings();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.TXTBase
    public /* bridge */ /* synthetic */ List getStringsAsByteArrays() {
        return super.getStringsAsByteArrays();
    }
}
