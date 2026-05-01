package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Iterator;

/* loaded from: classes3.dex */
public class Update extends Message {
    private int dclass;
    private Name origin;

    public Update(Name name, int i10) {
        if (name.isAbsolute()) {
            DClass.check(i10);
            getHeader().setOpcode(5);
            addRecord(Record.newRecord(name, 6, 1), 0);
            this.origin = name;
            this.dclass = i10;
        }
    }

    private void newUpdate(Record record) {
        addRecord(record, 2);
    }

    public void add(Name name, int i10, long j10, String str) {
        newUpdate(Record.fromString(name, i10, this.dclass, j10, str, this.origin));
    }

    public void delete(Name name, int i10) {
        newUpdate(Record.newRecord(name, i10, 255, 0L));
    }

    public void replace(Record record) {
        delete(record.getName(), record.getType());
        add(record);
    }

    public void add(Name name, int i10, long j10, Tokenizer tokenizer) {
        newUpdate(Record.fromString(name, i10, this.dclass, j10, tokenizer, this.origin));
    }

    public void add(Record record) {
        newUpdate(record);
    }

    public void add(Record[] recordArr) {
        for (Record record : recordArr) {
            add(record);
        }
    }

    public void add(RRset rRset) {
        Iterator rrs = rRset.rrs();
        while (rrs.hasNext()) {
            add((Record) rrs.next());
        }
    }

    public Update(Name name) {
        this(name, 1);
    }
}
