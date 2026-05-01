package o3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f17517a;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f17518b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f17519c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f17520d;

    /* renamed from: e, reason: collision with root package name */
    public final d4.y[] f17521e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final k3.j f17522a;

        /* renamed from: b, reason: collision with root package name */
        public final List f17523b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final Map f17524c = new HashMap();

        public a(k3.j jVar) {
            this.f17522a = jVar;
        }

        public final void a(String str, Integer num) {
            Object obj = this.f17524c.get(str);
            if (obj == null) {
                this.f17524c.put(str, num);
                return;
            }
            if (obj instanceof List) {
                ((List) obj).add(num);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(obj);
            linkedList.add(num);
            this.f17524c.put(str, linkedList);
        }

        public void b(n3.t tVar, w3.e eVar) {
            Integer valueOf = Integer.valueOf(this.f17523b.size());
            this.f17523b.add(new b(tVar, eVar));
            a(tVar.getName(), valueOf);
            a(eVar.i(), valueOf);
        }

        public g c(c cVar) {
            int size = this.f17523b.size();
            b[] bVarArr = new b[size];
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = (b) this.f17523b.get(i10);
                n3.t k10 = cVar.k(bVar.d());
                if (k10 != null) {
                    bVar.g(k10);
                }
                bVarArr[i10] = bVar;
            }
            return new g(this.f17522a, bVarArr, this.f17524c, null, null);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final n3.t f17525a;

        /* renamed from: b, reason: collision with root package name */
        public final w3.e f17526b;

        /* renamed from: c, reason: collision with root package name */
        public final String f17527c;

        /* renamed from: d, reason: collision with root package name */
        public n3.t f17528d;

        public b(n3.t tVar, w3.e eVar) {
            this.f17525a = tVar;
            this.f17526b = eVar;
            this.f17527c = eVar.i();
        }

        public String a() {
            Class h10 = this.f17526b.h();
            if (h10 == null) {
                return null;
            }
            return this.f17526b.j().d(null, h10);
        }

        public n3.t b() {
            return this.f17525a;
        }

        public n3.t c() {
            return this.f17528d;
        }

        public String d() {
            return this.f17527c;
        }

        public boolean e() {
            return this.f17526b.l();
        }

        public boolean f(String str) {
            return str.equals(this.f17527c);
        }

        public void g(n3.t tVar) {
            this.f17528d = tVar;
        }
    }

    public g(k3.j jVar, b[] bVarArr, Map map, String[] strArr, d4.y[] yVarArr) {
        this.f17517a = jVar;
        this.f17518b = bVarArr;
        this.f17519c = map;
        this.f17520d = strArr;
        this.f17521e = yVarArr;
    }

    public static a d(k3.j jVar) {
        return new a(jVar);
    }

    public final Object a(c3.k kVar, k3.g gVar, int i10, String str) {
        c3.k S0 = this.f17521e[i10].S0(kVar);
        if (S0.s0() == c3.n.VALUE_NULL) {
            return null;
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.s0();
        yVar.z0(str);
        yVar.V0(S0);
        yVar.V();
        c3.k S02 = yVar.S0(kVar);
        S02.s0();
        return this.f17518b[i10].b().k(S02, gVar);
    }

    public final void b(c3.k kVar, k3.g gVar, Object obj, int i10, String str) {
        if (str == null) {
            gVar.y0(this.f17517a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
        }
        c3.k S0 = this.f17521e[i10].S0(kVar);
        if (S0.s0() == c3.n.VALUE_NULL) {
            this.f17518b[i10].b().C(obj, null);
            return;
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.s0();
        yVar.z0(str);
        yVar.V0(S0);
        yVar.V();
        c3.k S02 = yVar.S0(kVar);
        S02.s0();
        this.f17518b[i10].b().l(S02, gVar, obj);
    }

    public final boolean c(c3.k kVar, k3.g gVar, String str, Object obj, String str2, int i10) {
        boolean z10 = false;
        if (!this.f17518b[i10].f(str)) {
            return false;
        }
        if (obj != null && this.f17521e[i10] != null) {
            z10 = true;
        }
        if (z10) {
            b(kVar, gVar, obj, i10, str2);
            this.f17521e[i10] = null;
        } else {
            this.f17520d[i10] = str2;
        }
        return true;
    }

    public Object e(c3.k kVar, k3.g gVar, Object obj) {
        int length = this.f17518b.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = this.f17520d[i10];
            b bVar = this.f17518b[i10];
            if (str == null) {
                d4.y yVar = this.f17521e[i10];
                if (yVar != null) {
                    if (yVar.X0().e()) {
                        c3.k S0 = yVar.S0(kVar);
                        S0.s0();
                        n3.t b10 = bVar.b();
                        Object b11 = w3.e.b(S0, gVar, b10.getType());
                        if (b11 != null) {
                            b10.C(obj, b11);
                        }
                    }
                    if (bVar.e()) {
                        str = bVar.a();
                        if (str == null) {
                            gVar.B0(this.f17517a, bVar.b().getName(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", bVar.d());
                        }
                    } else {
                        gVar.B0(this.f17517a, bVar.b().getName(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", bVar.d());
                    }
                }
            } else if (this.f17521e[i10] == null) {
                n3.t b12 = bVar.b();
                if (b12.f() || gVar.n0(k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                    gVar.A0(obj.getClass(), b12.getName(), "Missing property '%s' for external type id '%s'", b12.getName(), bVar.d());
                }
                return obj;
            }
            b(kVar, gVar, obj, i10, str);
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        if (r13.n0(k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object f(c3.k kVar, k3.g gVar, y yVar, v vVar) {
        String str;
        int length = this.f17518b.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = this.f17520d[i10];
            b bVar = this.f17518b[i10];
            if (str2 == null) {
                d4.y yVar2 = this.f17521e[i10];
                if (yVar2 != null && yVar2.X0() != c3.n.VALUE_NULL) {
                    if (bVar.e()) {
                        str = bVar.a();
                    } else {
                        gVar.B0(this.f17517a, bVar.b().getName(), "Missing external type id property '%s'", bVar.d());
                        str = str2;
                    }
                }
            } else {
                str = str2;
                if (this.f17521e[i10] == null) {
                    n3.t b10 = bVar.b();
                    if (!b10.f()) {
                        str = str2;
                    }
                    gVar.B0(this.f17517a, b10.getName(), "Missing property '%s' for external type id '%s'", b10.getName(), this.f17518b[i10].d());
                    str = str2;
                }
            }
            if (this.f17521e[i10] != null) {
                objArr[i10] = a(kVar, gVar, i10, str);
            }
            n3.t b11 = bVar.b();
            if (b11.p() >= 0) {
                yVar.b(b11, objArr[i10]);
                n3.t c10 = bVar.c();
                if (c10 != null && c10.p() >= 0) {
                    Object obj = str;
                    if (!c10.getType().y(String.class)) {
                        d4.y yVar3 = new d4.y(kVar, gVar);
                        yVar3.z0(str);
                        Object deserialize = c10.u().deserialize(yVar3.U0(), gVar);
                        yVar3.close();
                        obj = deserialize;
                    }
                    yVar.b(c10, obj);
                }
            }
        }
        Object a10 = vVar.a(gVar, yVar);
        for (int i11 = 0; i11 < length; i11++) {
            n3.t b12 = this.f17518b[i11].b();
            if (b12.p() < 0) {
                b12.C(a10, objArr[i11]);
            }
        }
        return a10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        if (r10.f17521e[r0] != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        if (r10.f17520d[r0] != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(c3.k kVar, k3.g gVar, String str, Object obj) {
        Object obj2 = this.f17519c.get(str);
        boolean z10 = false;
        if (obj2 == null) {
            return false;
        }
        if (obj2 instanceof List) {
            Iterator it = ((List) obj2).iterator();
            Integer num = (Integer) it.next();
            if (this.f17518b[num.intValue()].f(str)) {
                String Y = kVar.Y();
                kVar.D0();
                this.f17520d[num.intValue()] = Y;
                while (it.hasNext()) {
                    this.f17520d[((Integer) it.next()).intValue()] = Y;
                }
            } else {
                d4.y yVar = new d4.y(kVar, gVar);
                yVar.V0(kVar);
                this.f17521e[num.intValue()] = yVar;
                while (it.hasNext()) {
                    this.f17521e[((Integer) it.next()).intValue()] = yVar;
                }
            }
            return true;
        }
        int intValue = ((Integer) obj2).intValue();
        if (!this.f17518b[intValue].f(str)) {
            d4.y yVar2 = new d4.y(kVar, gVar);
            yVar2.V0(kVar);
            this.f17521e[intValue] = yVar2;
            if (obj != null) {
            }
            if (z10) {
            }
            return true;
        }
        this.f17520d[intValue] = kVar.g0();
        kVar.D0();
        if (obj != null) {
        }
        if (z10) {
            String[] strArr = this.f17520d;
            String str2 = strArr[intValue];
            strArr[intValue] = null;
            b(kVar, gVar, obj, intValue, str2);
            this.f17521e[intValue] = null;
        }
        return true;
    }

    public boolean h(c3.k kVar, k3.g gVar, String str, Object obj) {
        Object obj2 = this.f17519c.get(str);
        boolean z10 = false;
        if (obj2 == null) {
            return false;
        }
        String Y = kVar.Y();
        if (!(obj2 instanceof List)) {
            return c(kVar, gVar, str, obj, Y, ((Integer) obj2).intValue());
        }
        Iterator it = ((List) obj2).iterator();
        while (it.hasNext()) {
            if (c(kVar, gVar, str, obj, Y, ((Integer) it.next()).intValue())) {
                z10 = true;
            }
        }
        return z10;
    }

    public g i() {
        return new g(this);
    }

    public g(g gVar) {
        this.f17517a = gVar.f17517a;
        b[] bVarArr = gVar.f17518b;
        this.f17518b = bVarArr;
        this.f17519c = gVar.f17519c;
        int length = bVarArr.length;
        this.f17520d = new String[length];
        this.f17521e = new d4.y[length];
    }
}
