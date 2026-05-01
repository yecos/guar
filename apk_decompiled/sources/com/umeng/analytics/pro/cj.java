package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public class cj extends ByteArrayOutputStream {
    public cj(int i10) {
        super(i10);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public cj() {
    }
}
