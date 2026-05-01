package org.android.spdy;

/* loaded from: classes.dex */
public enum SpdyVersion {
    SPDY2(2),
    SPDY3(3),
    SPDY3DOT1(4);

    private int version;

    SpdyVersion(int i10) {
        this.version = i10;
    }

    public int getInt() {
        return this.version;
    }
}
