package com.titan.thumbnail;

import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class CombineData {
    private long endMoment;
    private String name;
    private long offset;
    private int seq;
    private List<Snapshot> snapshots;
    private long startMoment;

    public CombineData(int i10, String str, long j10, List<Snapshot> list) {
        i.h(str, "name");
        this.seq = i10;
        this.name = str;
        this.offset = j10;
        this.snapshots = list;
    }

    public static /* synthetic */ CombineData copy$default(CombineData combineData, int i10, String str, long j10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = combineData.seq;
        }
        if ((i11 & 2) != 0) {
            str = combineData.name;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            j10 = combineData.offset;
        }
        long j11 = j10;
        if ((i11 & 8) != 0) {
            list = combineData.snapshots;
        }
        return combineData.copy(i10, str2, j11, list);
    }

    public final int component1() {
        return this.seq;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.offset;
    }

    public final List<Snapshot> component4() {
        return this.snapshots;
    }

    public final CombineData copy(int i10, String str, long j10, List<Snapshot> list) {
        i.h(str, "name");
        return new CombineData(i10, str, j10, list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombineData) {
                CombineData combineData = (CombineData) obj;
                if ((this.seq == combineData.seq) && i.b(this.name, combineData.name)) {
                    if (!(this.offset == combineData.offset) || !i.b(this.snapshots, combineData.snapshots)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final long getEndMoment() {
        return this.endMoment;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final int getSeq() {
        return this.seq;
    }

    public final List<Snapshot> getSnapshots() {
        return this.snapshots;
    }

    public final long getStartMoment() {
        return this.startMoment;
    }

    public int hashCode() {
        int i10 = this.seq * 31;
        String str = this.name;
        int hashCode = str != null ? str.hashCode() : 0;
        long j10 = this.offset;
        int i11 = (((i10 + hashCode) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        List<Snapshot> list = this.snapshots;
        return i11 + (list != null ? list.hashCode() : 0);
    }

    public final void setEndMoment(long j10) {
        this.endMoment = j10;
    }

    public final void setName(String str) {
        i.h(str, "<set-?>");
        this.name = str;
    }

    public final void setOffset(long j10) {
        this.offset = j10;
    }

    public final void setSeq(int i10) {
        this.seq = i10;
    }

    public final void setSnapshots(List<Snapshot> list) {
        this.snapshots = list;
    }

    public final void setStartMoment(long j10) {
        this.startMoment = j10;
    }

    public String toString() {
        return "CombineData(seq=" + this.seq + ", name=" + this.name + ", offset=" + this.offset + ", snapshots=" + this.snapshots + ")";
    }
}
