package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
abstract class TXTBase extends Record {
    private static final long serialVersionUID = -4319510507246305931L;
    protected List strings;

    public TXTBase() {
    }

    public List getStrings() {
        ArrayList arrayList = new ArrayList(this.strings.size());
        for (int i10 = 0; i10 < this.strings.size(); i10++) {
            arrayList.add(Record.byteArrayToString((byte[]) this.strings.get(i10), false));
        }
        return arrayList;
    }

    public List getStringsAsByteArrays() {
        return this.strings;
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.strings = new ArrayList(2);
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            } else {
                try {
                    this.strings.add(Record.byteArrayFromString(token.value));
                } catch (Exception e10) {
                    throw tokenizer.exception(e10.getMessage());
                }
            }
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.strings = new ArrayList(2);
        while (dNSInput.remaining() > 0) {
            this.strings.add(dNSInput.readCountedString());
        }
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.strings.iterator();
        while (it.hasNext()) {
            stringBuffer.append(Record.byteArrayToString((byte[]) it.next(), true));
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.hpplay.sdk.source.mdns.xbill.dns.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        Iterator it = this.strings.iterator();
        while (it.hasNext()) {
            dNSOutput.writeCountedString((byte[]) it.next());
        }
    }

    public TXTBase(Name name, int i10, int i11, long j10) {
        super(name, i10, i11, j10);
    }

    public TXTBase(Name name, int i10, int i11, long j10, List list) {
        super(name, i10, i11, j10);
        if (list != null) {
            this.strings = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.strings.add(Record.byteArrayFromString((String) it.next()));
                } catch (Exception e10) {
                    throw new IllegalArgumentException(e10.getMessage());
                }
            }
            return;
        }
        throw new IllegalArgumentException("strings must not be null");
    }

    public TXTBase(Name name, int i10, int i11, long j10, String str) {
        this(name, i10, i11, j10, Collections.singletonList(str));
    }
}
