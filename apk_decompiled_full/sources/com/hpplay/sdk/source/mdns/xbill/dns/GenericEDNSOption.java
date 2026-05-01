package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.utils.base16;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class GenericEDNSOption extends EDNSOption {
    private byte[] data;

    public GenericEDNSOption(int i10) {
        super(i10);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.EDNSOption
    public void optionFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.EDNSOption
    public String optionToString() {
        return Operator.Operation.LESS_THAN + base16.toString(this.data) + Operator.Operation.GREATER_THAN;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.EDNSOption
    public void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.data);
    }

    public GenericEDNSOption(int i10, byte[] bArr) {
        super(i10);
        this.data = Record.checkByteArrayLength("option data", bArr, Message.MAXLENGTH);
    }
}
