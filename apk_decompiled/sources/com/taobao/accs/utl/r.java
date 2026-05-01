package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public class r extends ByteArrayOutputStream {
    public r(int i10) {
        super(i10);
    }

    public r a(byte b10) {
        write(b10);
        return this;
    }

    public r() {
    }

    public r a(short s10) {
        write(s10 >> 8);
        write(s10);
        return this;
    }
}
