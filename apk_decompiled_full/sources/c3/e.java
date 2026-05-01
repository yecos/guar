package c3;

/* loaded from: classes.dex */
public enum e {
    UTF8("UTF-8", false, 8),
    UTF16_BE("UTF-16BE", true, 16),
    UTF16_LE("UTF-16LE", false, 16),
    UTF32_BE("UTF-32BE", true, 32),
    UTF32_LE("UTF-32LE", false, 32);


    /* renamed from: a, reason: collision with root package name */
    public final String f5408a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5409b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5410c;

    e(String str, boolean z10, int i10) {
        this.f5408a = str;
        this.f5409b = z10;
        this.f5410c = i10;
    }

    public String a() {
        return this.f5408a;
    }
}
