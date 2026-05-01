package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
abstract class SingleCompressedNameBase extends SingleNameBase {
    private static final long serialVersionUID = -236435396815460677L;

    public SingleCompressedNameBase() {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.SingleNameBase, com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        this.singleName.toWire(dNSOutput, compression, z10);
    }

    public SingleCompressedNameBase(Name name, int i10, int i11, long j10, Name name2, String str) {
        super(name, i10, i11, j10, name2, str);
    }
}
