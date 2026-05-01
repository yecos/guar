package w3;

import b3.e0;
import c3.n;
import i3.b;
import j3.q;

/* loaded from: classes.dex */
public abstract class h {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19158a;

        static {
            int[] iArr = new int[e0.a.values().length];
            f19158a = iArr;
            try {
                iArr[e0.a.EXISTING_PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19158a[e0.a.EXTERNAL_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19158a[e0.a.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19158a[e0.a.WRAPPER_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19158a[e0.a.WRAPPER_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public abstract h a(k3.d dVar);

    public abstract String b();

    public abstract e0.a c();

    public i3.b d(Object obj, n nVar) {
        i3.b bVar = new i3.b(obj, nVar);
        int i10 = a.f19158a[c().ordinal()];
        if (i10 == 1) {
            bVar.f14302e = b.a.PAYLOAD_PROPERTY;
            bVar.f14301d = b();
        } else if (i10 == 2) {
            bVar.f14302e = b.a.PARENT_PROPERTY;
            bVar.f14301d = b();
        } else if (i10 == 3) {
            bVar.f14302e = b.a.METADATA_PROPERTY;
            bVar.f14301d = b();
        } else if (i10 == 4) {
            bVar.f14302e = b.a.WRAPPER_ARRAY;
        } else if (i10 != 5) {
            q.a();
        } else {
            bVar.f14302e = b.a.WRAPPER_OBJECT;
        }
        return bVar;
    }

    public i3.b e(Object obj, n nVar, Object obj2) {
        i3.b d10 = d(obj, nVar);
        d10.f14300c = obj2;
        return d10;
    }

    public i3.b f(Object obj, Class cls, n nVar) {
        i3.b d10 = d(obj, nVar);
        d10.f14299b = cls;
        return d10;
    }

    public abstract i3.b g(c3.h hVar, i3.b bVar);

    public abstract i3.b h(c3.h hVar, i3.b bVar);
}
