package com.hpplay.sdk.source.mdns.xbill.dns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class RRset implements Serializable {
    private static final long serialVersionUID = -3270249290171239695L;
    private short nsigs;
    private short position;
    private List rrs;

    public RRset() {
        this.rrs = new ArrayList(1);
        this.nsigs = (short) 0;
        this.position = (short) 0;
    }

    private synchronized Iterator iterator(boolean z10, boolean z11) {
        int i10;
        int size = this.rrs.size();
        int i11 = z10 ? size - this.nsigs : this.nsigs;
        if (i11 == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z10) {
            i10 = size - this.nsigs;
        } else if (z11) {
            if (this.position >= i11) {
                this.position = (short) 0;
            }
            i10 = this.position;
            this.position = (short) (i10 + 1);
        } else {
            i10 = 0;
        }
        ArrayList arrayList = new ArrayList(i11);
        if (z10) {
            arrayList.addAll(this.rrs.subList(i10, i11));
            if (i10 != 0) {
                arrayList.addAll(this.rrs.subList(0, i10));
            }
        } else {
            arrayList.addAll(this.rrs.subList(i10, size));
        }
        return arrayList.iterator();
    }

    private String iteratorToString(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            Record record = (Record) it.next();
            stringBuffer.append("[");
            stringBuffer.append(record.rdataToString());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private void safeAddRR(Record record) {
        if (record instanceof RRSIGRecord) {
            this.rrs.add(record);
            this.nsigs = (short) (this.nsigs + 1);
        } else if (this.nsigs == 0) {
            this.rrs.add(record);
        } else {
            List list = this.rrs;
            list.add(list.size() - this.nsigs, record);
        }
    }

    public synchronized void addRR(Record record) {
        if (this.rrs.size() == 0) {
            safeAddRR(record);
            return;
        }
        Record first = first();
        if (!record.sameRRset(first)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (record.getTTL() != first.getTTL()) {
            if (record.getTTL() > first.getTTL()) {
                record = record.cloneRecord();
                record.setTTL(first.getTTL());
            } else {
                for (int i10 = 0; i10 < this.rrs.size(); i10++) {
                    Record cloneRecord = ((Record) this.rrs.get(i10)).cloneRecord();
                    cloneRecord.setTTL(record.getTTL());
                    this.rrs.set(i10, cloneRecord);
                }
            }
        }
        if (!this.rrs.contains(record)) {
            safeAddRR(record);
        }
    }

    public synchronized void clear() {
        this.rrs.clear();
        this.position = (short) 0;
        this.nsigs = (short) 0;
    }

    public synchronized void deleteRR(Record record) {
        if (this.rrs.remove(record) && (record instanceof RRSIGRecord)) {
            this.nsigs = (short) (this.nsigs - 1);
        }
    }

    public synchronized Record first() {
        if (this.rrs.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (Record) this.rrs.get(0);
    }

    public int getDClass() {
        return first().getDClass();
    }

    public Name getName() {
        return first().getName();
    }

    public synchronized long getTTL() {
        return first().getTTL();
    }

    public int getType() {
        return first().getRRsetType();
    }

    public void release() {
        List list = this.rrs;
        if (list != null) {
            list.clear();
        }
    }

    public synchronized Iterator rrs(boolean z10) {
        return iterator(true, z10);
    }

    public synchronized Iterator sigs() {
        return iterator(false, false);
    }

    public synchronized int size() {
        return this.rrs.size() - this.nsigs;
    }

    public String toString() {
        if (this.rrs.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(getName() + " ");
        stringBuffer.append(getTTL() + " ");
        stringBuffer.append(DClass.string(getDClass()) + " ");
        stringBuffer.append(Type.string(getType()) + " ");
        stringBuffer.append(iteratorToString(iterator(true, false)));
        if (this.nsigs > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(iteratorToString(iterator(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }

    public synchronized Iterator rrs() {
        return iterator(true, true);
    }

    public RRset(Record record) {
        this();
        safeAddRR(record);
    }

    public RRset(RRset rRset) {
        synchronized (rRset) {
            this.rrs = (List) ((ArrayList) rRset.rrs).clone();
            this.nsigs = rRset.nsigs;
            this.position = rRset.position;
        }
    }
}
