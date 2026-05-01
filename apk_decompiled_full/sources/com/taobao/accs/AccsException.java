package com.taobao.accs;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class AccsException extends Exception {
    private int mErrorCode;

    public AccsException(int i10) {
        this.mErrorCode = i10;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("errorCode = " + this.mErrorCode);
        super.printStackTrace(printStream);
    }

    public AccsException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("errorCode = " + this.mErrorCode);
        super.printStackTrace(printWriter);
    }

    public AccsException(String str, int i10) {
        super(str);
        this.mErrorCode = i10;
    }

    public AccsException(String str, Throwable th, int i10) {
        super(str, th);
        this.mErrorCode = i10;
    }

    public AccsException(Throwable th, int i10) {
        super(th);
        this.mErrorCode = i10;
    }
}
