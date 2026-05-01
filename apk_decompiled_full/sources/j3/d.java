package j3;

import j3.e;

/* loaded from: classes.dex */
public class d extends e.c {

    /* renamed from: e, reason: collision with root package name */
    public static final String f14643e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f14644f;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f14645b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14646c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14647d;

    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (Throwable unused) {
            str = "\n";
        }
        f14643e = str;
        f14644f = new d("  ", str);
    }

    public d(String str, String str2) {
        this.f14646c = str.length();
        this.f14645b = new char[str.length() * 16];
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            str.getChars(0, str.length(), this.f14645b, i10);
            i10 += str.length();
        }
        this.f14647d = str2;
    }

    @Override // j3.e.c, j3.e.b
    public void a(c3.h hVar, int i10) {
        hVar.o0(this.f14647d);
        if (i10 <= 0) {
            return;
        }
        int i11 = i10 * this.f14646c;
        while (true) {
            char[] cArr = this.f14645b;
            if (i11 <= cArr.length) {
                hVar.p0(cArr, 0, i11);
                return;
            } else {
                hVar.p0(cArr, 0, cArr.length);
                i11 -= this.f14645b.length;
            }
        }
    }

    @Override // j3.e.c, j3.e.b
    public boolean isInline() {
        return false;
    }
}
