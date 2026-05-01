package com.hpplay.sdk.source.mdns.xbill.dns;

import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class OPTRecord extends Record {
    private static final long serialVersionUID = -6254521894809367938L;
    private List options;

    public OPTRecord() {
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public boolean equals(Object obj) {
        return super.equals(obj) && this.ttl == ((OPTRecord) obj).ttl;
    }

    public int getExtendedRcode() {
        return (int) (this.ttl >>> 24);
    }

    public int getFlags() {
        return (int) (this.ttl & 65535);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public Record getObject() {
        return new OPTRecord();
    }

    public List getOptions() {
        List list = this.options;
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    public int getPayloadSize() {
        return this.dclass;
    }

    public int getVersion() {
        return (int) ((this.ttl >>> 16) & 255);
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        throw tokenizer.exception("no text format defined for OPT");
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        if (dNSInput.remaining() > 0) {
            this.options = new ArrayList();
        }
        while (dNSInput.remaining() > 0) {
            this.options.add(EDNSOption.fromWire(dNSInput));
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        List list = this.options;
        if (list != null) {
            stringBuffer.append(list);
            stringBuffer.append(" ");
        }
        stringBuffer.append(" ; payload ");
        stringBuffer.append(getPayloadSize());
        stringBuffer.append(", xrcode ");
        stringBuffer.append(getExtendedRcode());
        stringBuffer.append(", version ");
        stringBuffer.append(getVersion());
        stringBuffer.append(", flags ");
        stringBuffer.append(getFlags());
        return stringBuffer.toString();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        List list = this.options;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((EDNSOption) it.next()).toWire(dNSOutput);
        }
    }

    public OPTRecord(int i10, int i11, int i12, int i13, List list) {
        super(Name.root, 41, i10, 0L);
        Record.checkU16("payloadSize", i10);
        Record.checkU8("xrcode", i11);
        Record.checkU8("version", i12);
        Record.checkU16(Constants.KEY_FLAGS, i13);
        this.ttl = (i11 << 24) + (i12 << 16) + i13;
        if (list != null) {
            this.options = new ArrayList(list);
        }
    }

    public List getOptions(int i10) {
        List<EDNSOption> list = this.options;
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        List list2 = Collections.EMPTY_LIST;
        for (EDNSOption eDNSOption : list) {
            if (eDNSOption.getCode() == i10) {
                if (list2 == Collections.EMPTY_LIST) {
                    list2 = new ArrayList();
                }
                list2.add(eDNSOption);
            }
        }
        return list2;
    }

    public OPTRecord(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, null);
    }

    public OPTRecord(int i10, int i11, int i12) {
        this(i10, i11, i12, 0, null);
    }
}
