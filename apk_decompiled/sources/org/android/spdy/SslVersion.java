package org.android.spdy;

/* loaded from: classes.dex */
public enum SslVersion {
    SLIGHT_VERSION_V1(0);

    private int code;

    SslVersion(int i10) {
        this.code = i10;
    }

    public int getint() {
        return this.code;
    }
}
