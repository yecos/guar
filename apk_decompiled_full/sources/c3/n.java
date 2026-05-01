package c3;

/* loaded from: classes.dex */
public enum n {
    NOT_AVAILABLE(null, -1),
    START_OBJECT("{", 1),
    END_OBJECT("}", 2),
    START_ARRAY("[", 3),
    END_ARRAY("]", 4),
    FIELD_NAME(null, 5),
    VALUE_EMBEDDED_OBJECT(null, 12),
    VALUE_STRING(null, 6),
    VALUE_NUMBER_INT(null, 7),
    VALUE_NUMBER_FLOAT(null, 8),
    VALUE_TRUE("true", 9),
    VALUE_FALSE("false", 10),
    VALUE_NULL("null", 11);


    /* renamed from: a, reason: collision with root package name */
    public final String f5499a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f5500b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f5501c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5502d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5503e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5504f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5505g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f5506h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5507i;

    n(String str, int i10) {
        boolean z10 = false;
        if (str == null) {
            this.f5499a = null;
            this.f5500b = null;
            this.f5501c = null;
        } else {
            this.f5499a = str;
            char[] charArray = str.toCharArray();
            this.f5500b = charArray;
            int length = charArray.length;
            this.f5501c = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                this.f5501c[i11] = (byte) this.f5500b[i11];
            }
        }
        this.f5502d = i10;
        this.f5506h = i10 == 10 || i10 == 9;
        this.f5505g = i10 == 7 || i10 == 8;
        boolean z11 = i10 == 1 || i10 == 3;
        this.f5503e = z11;
        boolean z12 = i10 == 2 || i10 == 4;
        this.f5504f = z12;
        if (!z11 && !z12 && i10 != 5 && i10 != -1) {
            z10 = true;
        }
        this.f5507i = z10;
    }

    public final char[] a() {
        return this.f5500b;
    }

    public final String b() {
        return this.f5499a;
    }

    public final int c() {
        return this.f5502d;
    }

    public final boolean d() {
        return this.f5505g;
    }

    public final boolean e() {
        return this.f5507i;
    }

    public final boolean f() {
        return this.f5504f;
    }

    public final boolean g() {
        return this.f5503e;
    }
}
