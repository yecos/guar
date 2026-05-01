package org.android.spdy;

/* loaded from: classes.dex */
public enum SpdySessionKind {
    NONE_SESSION(0),
    WIFI_SESSION(1),
    THREE_G_SESSION(2),
    TWO_G_SESSION(3);

    private int code;

    SpdySessionKind(int i10) {
        this.code = i10;
    }

    public int getint() {
        return this.code;
    }
}
