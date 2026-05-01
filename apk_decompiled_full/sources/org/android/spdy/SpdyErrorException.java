package org.android.spdy;

/* loaded from: classes.dex */
public class SpdyErrorException extends RuntimeException {
    private static final long serialVersionUID = 4422888579699220045L;
    private int error;

    public SpdyErrorException(int i10) {
        this.error = i10;
    }

    public int SpdyErrorGetCode() {
        return this.error;
    }

    public SpdyErrorException(String str, int i10) {
        super(str);
        this.error = i10;
    }

    public SpdyErrorException(String str, Throwable th, int i10) {
        super(str, th);
        this.error = i10;
    }

    public SpdyErrorException(Throwable th, int i10) {
        super(th);
        this.error = i10;
    }
}
