package androidx.fragment.app;

import java.io.Writer;

/* loaded from: classes.dex */
public final class i0 extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final String f2295a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f2296b = new StringBuilder(128);

    public i0(String str) {
        this.f2295a = str;
    }

    public final void a() {
        if (this.f2296b.length() > 0) {
            this.f2296b.toString();
            StringBuilder sb = this.f2296b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                a();
            } else {
                this.f2296b.append(c10);
            }
        }
    }
}
