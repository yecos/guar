package f3;

import j3.o;
import java.io.Writer;

/* loaded from: classes.dex */
public final class h extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final o f13078a;

    public h(j3.a aVar) {
        this.f13078a = new o(aVar);
    }

    public String a() {
        String l10 = this.f13078a.l();
        this.f13078a.u();
        return l10;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.f13078a.c(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        this.f13078a.c(cArr, i10, i11);
    }

    @Override // java.io.Writer
    public void write(int i10) {
        this.f13078a.a((char) i10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c10) {
        write(c10);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.f13078a.b(str, 0, str.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        this.f13078a.b(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) {
        this.f13078a.b(str, i10, i11);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i10, int i11) {
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        this.f13078a.b(charSequence2, 0, charSequence2.length());
        return this;
    }
}
