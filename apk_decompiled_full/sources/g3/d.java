package g3;

import c3.k;

/* loaded from: classes.dex */
public enum d implements j3.h {
    ALLOW_JAVA_COMMENTS(false, k.a.ALLOW_COMMENTS),
    ALLOW_YAML_COMMENTS(false, k.a.ALLOW_YAML_COMMENTS),
    ALLOW_SINGLE_QUOTES(false, k.a.ALLOW_SINGLE_QUOTES),
    ALLOW_UNQUOTED_FIELD_NAMES(false, k.a.ALLOW_UNQUOTED_FIELD_NAMES),
    ALLOW_UNESCAPED_CONTROL_CHARS(false, k.a.ALLOW_UNQUOTED_CONTROL_CHARS),
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false, k.a.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER),
    ALLOW_LEADING_ZEROS_FOR_NUMBERS(false, k.a.ALLOW_NUMERIC_LEADING_ZEROS),
    ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false, k.a.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS),
    ALLOW_NON_NUMERIC_NUMBERS(false, k.a.ALLOW_NON_NUMERIC_NUMBERS),
    ALLOW_MISSING_VALUES(false, k.a.ALLOW_MISSING_VALUES),
    ALLOW_TRAILING_COMMA(false, k.a.ALLOW_TRAILING_COMMA);


    /* renamed from: a, reason: collision with root package name */
    public final boolean f13590a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13591b = 1 << ordinal();

    /* renamed from: c, reason: collision with root package name */
    public final k.a f13592c;

    d(boolean z10, k.a aVar) {
        this.f13590a = z10;
        this.f13592c = aVar;
    }

    @Override // j3.h
    public boolean a() {
        return this.f13590a;
    }

    @Override // j3.h
    public int b() {
        return this.f13591b;
    }

    public k.a c() {
        return this.f13592c;
    }
}
