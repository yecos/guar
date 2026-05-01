package ba;

import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f5213a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f5214b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f5215c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f5216d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f5217e;

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f5218f;

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f5219g;

    static {
        Charset forName = Charset.forName("UTF-8");
        t9.i.f(forName, "forName(\"UTF-8\")");
        f5214b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        t9.i.f(forName2, "forName(\"UTF-16\")");
        f5215c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        t9.i.f(forName3, "forName(\"UTF-16BE\")");
        f5216d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        t9.i.f(forName4, "forName(\"UTF-16LE\")");
        f5217e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        t9.i.f(forName5, "forName(\"US-ASCII\")");
        f5218f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        t9.i.f(forName6, "forName(\"ISO-8859-1\")");
        f5219g = forName6;
    }
}
