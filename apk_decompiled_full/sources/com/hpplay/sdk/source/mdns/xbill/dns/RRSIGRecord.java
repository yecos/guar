package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Date;

/* loaded from: classes3.dex */
public class RRSIGRecord extends SIGBase {
    private static final long serialVersionUID = -2609150673537226317L;

    public RRSIGRecord() {
    }

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
        return new RRSIGRecord();
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

    public RRSIGRecord(Name name, int i10, long j10, int i11, int i12, long j11, Date date, Date date2, int i13, Name name2, byte[] bArr) {
        super(name, 46, i10, j10, i11, i12, j11, date, date2, i13, name2, bArr);
    }
}
