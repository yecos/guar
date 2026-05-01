package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Date;

/* loaded from: classes3.dex */
public class SIGRecord extends SIGBase {
    private static final long serialVersionUID = 4963556060953589058L;

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ Date getExpire() {
        return super.getExpire();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ int getLabels() {
        return super.getLabels();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new SIGRecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ long getOrigTTL() {
        return super.getOrigTTL();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ Name getSigner() {
        return super.getSigner();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ Date getTimeSigned() {
        return super.getTimeSigned();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SIGBase
    public /* bridge */ /* synthetic */ int getTypeCovered() {
        return super.getTypeCovered();
    }
}
