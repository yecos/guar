package o3;

import b3.k0;
import java.util.BitSet;
import o3.x;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public final c3.k f17582a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.g f17583b;

    /* renamed from: c, reason: collision with root package name */
    public final s f17584c;

    /* renamed from: d, reason: collision with root package name */
    public final Object[] f17585d;

    /* renamed from: e, reason: collision with root package name */
    public int f17586e;

    /* renamed from: f, reason: collision with root package name */
    public int f17587f;

    /* renamed from: g, reason: collision with root package name */
    public final BitSet f17588g;

    /* renamed from: h, reason: collision with root package name */
    public x f17589h;

    /* renamed from: i, reason: collision with root package name */
    public Object f17590i;

    public y(c3.k kVar, k3.g gVar, int i10, s sVar) {
        this.f17582a = kVar;
        this.f17583b = gVar;
        this.f17586e = i10;
        this.f17584c = sVar;
        this.f17585d = new Object[i10];
        if (i10 < 32) {
            this.f17588g = null;
        } else {
            this.f17588g = new BitSet();
        }
    }

    public Object a(n3.t tVar) {
        if (tVar.q() != null) {
            return this.f17583b.E(tVar.q(), tVar, null);
        }
        if (tVar.f()) {
            this.f17583b.x0(tVar, "Missing required creator property '%s' (index %d)", tVar.getName(), Integer.valueOf(tVar.p()));
        }
        if (this.f17583b.n0(k3.h.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            this.f17583b.x0(tVar, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", tVar.getName(), Integer.valueOf(tVar.p()));
        }
        try {
            Object nullValue = tVar.s().getNullValue(this.f17583b);
            return nullValue != null ? nullValue : tVar.u().getNullValue(this.f17583b);
        } catch (k3.l e10) {
            r3.i d10 = tVar.d();
            if (d10 != null) {
                e10.n(d10.k(), tVar.getName());
            }
            throw e10;
        }
    }

    public boolean b(n3.t tVar, Object obj) {
        int p10 = tVar.p();
        this.f17585d[p10] = obj;
        BitSet bitSet = this.f17588g;
        if (bitSet == null) {
            int i10 = this.f17587f;
            int i11 = (1 << p10) | i10;
            if (i10 != i11) {
                this.f17587f = i11;
                int i12 = this.f17586e - 1;
                this.f17586e = i12;
                if (i12 <= 0) {
                    return this.f17584c == null || this.f17590i != null;
                }
            }
        } else if (!bitSet.get(p10)) {
            this.f17588g.set(p10);
            this.f17586e--;
        }
        return false;
    }

    public void c(n3.s sVar, String str, Object obj) {
        this.f17589h = new x.a(this.f17589h, obj, sVar, str);
    }

    public void d(Object obj, Object obj2) {
        this.f17589h = new x.b(this.f17589h, obj2, obj);
    }

    public void e(n3.t tVar, Object obj) {
        this.f17589h = new x.c(this.f17589h, obj, tVar);
    }

    public x f() {
        return this.f17589h;
    }

    public Object[] g(n3.t[] tVarArr) {
        if (this.f17586e > 0) {
            if (this.f17588g != null) {
                int length = this.f17585d.length;
                int i10 = 0;
                while (true) {
                    int nextClearBit = this.f17588g.nextClearBit(i10);
                    if (nextClearBit >= length) {
                        break;
                    }
                    this.f17585d[nextClearBit] = a(tVarArr[nextClearBit]);
                    i10 = nextClearBit + 1;
                }
            } else {
                int i11 = this.f17587f;
                int length2 = this.f17585d.length;
                int i12 = 0;
                while (i12 < length2) {
                    if ((i11 & 1) == 0) {
                        this.f17585d[i12] = a(tVarArr[i12]);
                    }
                    i12++;
                    i11 >>= 1;
                }
            }
        }
        if (this.f17583b.n0(k3.h.FAIL_ON_NULL_CREATOR_PROPERTIES)) {
            for (int i13 = 0; i13 < tVarArr.length; i13++) {
                if (this.f17585d[i13] == null) {
                    n3.t tVar = tVarArr[i13];
                    this.f17583b.x0(tVar, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", tVar.getName(), Integer.valueOf(tVarArr[i13].p()));
                }
            }
        }
        return this.f17585d;
    }

    public Object h(k3.g gVar, Object obj) {
        s sVar = this.f17584c;
        if (sVar != null) {
            Object obj2 = this.f17590i;
            if (obj2 != null) {
                k0 k0Var = sVar.f17564c;
                sVar.getClass();
                gVar.H(obj2, k0Var, null).b(obj);
                n3.t tVar = this.f17584c.f17566e;
                if (tVar != null) {
                    return tVar.D(obj, this.f17590i);
                }
            } else {
                gVar.D0(sVar, obj);
            }
        }
        return obj;
    }

    public boolean i(String str) {
        s sVar = this.f17584c;
        if (sVar == null || !str.equals(sVar.f17563b.c())) {
            return false;
        }
        this.f17590i = this.f17584c.f(this.f17582a, this.f17583b);
        return true;
    }
}
