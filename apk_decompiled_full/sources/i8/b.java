package i8;

import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public enum b {
    IJK("ijk"),
    NATIVE("native"),
    EXO("exo"),
    NONE("none");


    /* renamed from: g, reason: collision with root package name */
    public static final a f14358g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f14359a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a(String str) {
            i.h(str, "property");
            for (b bVar : b.values()) {
                if (i.b(bVar.a(), str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    b(String str) {
        i.h(str, "value");
        this.f14359a = str;
    }

    public final String a() {
        return this.f14359a;
    }
}
