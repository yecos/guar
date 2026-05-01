package o3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f17571a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.w f17572b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f17573c;

    /* renamed from: d, reason: collision with root package name */
    public final n3.t[] f17574d;

    public static class a extends HashMap {

        /* renamed from: a, reason: collision with root package name */
        public final Locale f17575a;

        public a(Locale locale) {
            this.f17575a = locale;
        }

        public static a a(Locale locale) {
            return new a(locale);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n3.t get(Object obj) {
            return (n3.t) super.get(((String) obj).toLowerCase(this.f17575a));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public n3.t put(String str, n3.t tVar) {
            return (n3.t) super.put(str.toLowerCase(this.f17575a), tVar);
        }
    }

    public v(k3.g gVar, n3.w wVar, n3.t[] tVarArr, boolean z10, boolean z11) {
        this.f17572b = wVar;
        if (z10) {
            this.f17573c = a.a(gVar.k().v());
        } else {
            this.f17573c = new HashMap();
        }
        int length = tVarArr.length;
        this.f17571a = length;
        this.f17574d = new n3.t[length];
        if (z11) {
            k3.f k10 = gVar.k();
            for (n3.t tVar : tVarArr) {
                if (!tVar.z()) {
                    List e10 = tVar.e(k10);
                    if (!e10.isEmpty()) {
                        Iterator it = e10.iterator();
                        while (it.hasNext()) {
                            this.f17573c.put(((k3.x) it.next()).c(), tVar);
                        }
                    }
                }
            }
        }
        for (int i10 = 0; i10 < length; i10++) {
            n3.t tVar2 = tVarArr[i10];
            this.f17574d[i10] = tVar2;
            if (!tVar2.z()) {
                this.f17573c.put(tVar2.getName(), tVar2);
            }
        }
    }

    public static v b(k3.g gVar, n3.w wVar, n3.t[] tVarArr, c cVar) {
        int length = tVarArr.length;
        n3.t[] tVarArr2 = new n3.t[length];
        for (int i10 = 0; i10 < length; i10++) {
            n3.t tVar = tVarArr[i10];
            if (!tVar.w() && !tVar.A()) {
                tVar = tVar.L(gVar.D(tVar.getType(), tVar));
            }
            tVarArr2[i10] = tVar;
        }
        return new v(gVar, wVar, tVarArr2, cVar.p(), true);
    }

    public static v c(k3.g gVar, n3.w wVar, n3.t[] tVarArr, boolean z10) {
        int length = tVarArr.length;
        n3.t[] tVarArr2 = new n3.t[length];
        for (int i10 = 0; i10 < length; i10++) {
            n3.t tVar = tVarArr[i10];
            if (!tVar.w()) {
                tVar = tVar.L(gVar.D(tVar.getType(), tVar));
            }
            tVarArr2[i10] = tVar;
        }
        return new v(gVar, wVar, tVarArr2, z10, false);
    }

    public Object a(k3.g gVar, y yVar) {
        Object u10 = this.f17572b.u(gVar, this.f17574d, yVar);
        if (u10 != null) {
            u10 = yVar.h(gVar, u10);
            for (x f10 = yVar.f(); f10 != null; f10 = f10.f17576a) {
                f10.a(u10);
            }
        }
        return u10;
    }

    public n3.t d(String str) {
        return (n3.t) this.f17573c.get(str);
    }

    public y e(c3.k kVar, k3.g gVar, s sVar) {
        return new y(kVar, gVar, this.f17571a, sVar);
    }
}
