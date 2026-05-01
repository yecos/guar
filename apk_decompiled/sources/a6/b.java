package a6;

import ba.t;
import w6.i;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f248a = new b();

    public final String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (t.o(str, "_Recommended", false, 2, null)) {
            return i.f19214g.v() + "_1";
        }
        if (t.o(str, "_movies", false, 2, null)) {
            return i.f19214g.v() + "_2";
        }
        if (t.o(str, "_series", false, 2, null)) {
            return i.f19214g.v() + "_3";
        }
        if (t.o(str, "_kids", false, 2, null)) {
            return i.f19214g.v() + "_4";
        }
        if (!t.o(str, "_animes", false, 2, null)) {
            return "";
        }
        return i.f19214g.v() + "_5";
    }
}
