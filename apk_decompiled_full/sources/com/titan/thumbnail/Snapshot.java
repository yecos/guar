package com.titan.thumbnail;

/* loaded from: classes3.dex */
public final class Snapshot {
    private long moment;
    private int seq;

    public Snapshot(int i10, long j10) {
        this.seq = i10;
        this.moment = j10;
    }

    public static /* synthetic */ Snapshot copy$default(Snapshot snapshot, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = snapshot.seq;
        }
        if ((i11 & 2) != 0) {
            j10 = snapshot.moment;
        }
        return snapshot.copy(i10, j10);
    }

    public final int component1() {
        return this.seq;
    }

    public final long component2() {
        return this.moment;
    }

    public final Snapshot copy(int i10, long j10) {
        return new Snapshot(i10, j10);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Snapshot) {
                Snapshot snapshot = (Snapshot) obj;
                if (this.seq == snapshot.seq) {
                    if (this.moment == snapshot.moment) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final long getMoment() {
        return this.moment;
    }

    public final int getSeq() {
        return this.seq;
    }

    public int hashCode() {
        int i10 = this.seq * 31;
        long j10 = this.moment;
        return i10 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final void setMoment(long j10) {
        this.moment = j10;
    }

    public final void setSeq(int i10) {
        this.seq = i10;
    }

    public String toString() {
        return "Snapshot(seq=" + this.seq + ", moment=" + this.moment + ")";
    }
}
