package eb;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public k f13005a;

    /* renamed from: b, reason: collision with root package name */
    public int f13006b;

    /* renamed from: c, reason: collision with root package name */
    public k f13007c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f13008d;

    /* renamed from: e, reason: collision with root package name */
    public String f13009e;

    public m(k kVar, int i10, k kVar2, int[] iArr, String str) {
        this.f13005a = kVar;
        this.f13006b = i10;
        this.f13007c = kVar2;
        this.f13008d = iArr;
        this.f13009e = str;
    }

    public int a(int i10) {
        return this.f13008d[i10];
    }

    public int b(byte b10) {
        return this.f13005a.d(b10 & UnsignedBytes.MAX_VALUE);
    }

    public String c() {
        return this.f13009e;
    }

    public int d(int i10, int i11) {
        return this.f13007c.d((i11 * this.f13006b) + i10);
    }
}
