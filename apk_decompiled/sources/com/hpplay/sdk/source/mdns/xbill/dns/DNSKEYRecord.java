package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.DNSSEC;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public class DNSKEYRecord extends KEYBase {
    private static final long serialVersionUID = -8679800040426675002L;

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getFlags() {
        return super.getFlags();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ byte[] getKey() {
        return super.getKey();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new DNSKEYRecord();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ int getProtocol() {
        return super.getProtocol();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.KEYBase
    public /* bridge */ /* synthetic */ PublicKey getPublicKey() {
        return super.getPublicKey();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.flags = tokenizer.getUInt16();
        this.proto = tokenizer.getUInt8();
        String string = tokenizer.getString();
        int value = DNSSEC.Algorithm.value(string);
        this.alg = value;
        if (value >= 0) {
            this.key = tokenizer.getBase64();
            return;
        }
        throw tokenizer.exception("Invalid algorithm: " + string);
    }
}
