package db;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public short[] f12768a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f12769b;

    /* renamed from: c, reason: collision with root package name */
    public float f12770c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12771d;

    /* renamed from: e, reason: collision with root package name */
    public String f12772e;

    public l(short[] sArr, byte[] bArr, float f10, boolean z10, String str) {
        this.f12768a = sArr;
        this.f12769b = bArr;
        this.f12770c = f10;
        this.f12771d = z10;
        this.f12772e = str;
    }

    public String a() {
        return this.f12772e;
    }

    public short b(byte b10) {
        return this.f12768a[b10 & UnsignedBytes.MAX_VALUE];
    }

    public byte c(int i10) {
        return this.f12769b[i10];
    }

    public float d() {
        return this.f12770c;
    }
}
