package g3;

import c3.h;
import c3.o;
import c3.q;
import j3.i;

/* loaded from: classes.dex */
public abstract class b extends d3.a {

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f13564p = f3.a.e();

    /* renamed from: q, reason: collision with root package name */
    public static final i f13565q = c3.h.f5432c;

    /* renamed from: k, reason: collision with root package name */
    public final f3.c f13566k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f13567l;

    /* renamed from: m, reason: collision with root package name */
    public int f13568m;

    /* renamed from: n, reason: collision with root package name */
    public q f13569n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13570o;

    public b(f3.c cVar, int i10, o oVar) {
        super(i10, oVar);
        this.f13567l = f13564p;
        this.f13569n = j3.e.f14648h;
        this.f13566k = cVar;
        if (h.b.ESCAPE_NON_ASCII.c(i10)) {
            this.f13568m = 127;
        }
        this.f13570o = !h.b.QUOTE_FIELD_NAMES.c(i10);
    }

    @Override // c3.h
    public c3.h E(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f13568m = i10;
        return this;
    }

    @Override // d3.a
    public void G0(int i10, int i11) {
        super.G0(i10, i11);
        this.f13570o = !h.b.QUOTE_FIELD_NAMES.c(i10);
    }

    public void J0(String str) {
        a(String.format("Can not %s, expecting field name (context: %s)", str, this.f12479h.j()));
    }

    public void K0(String str, int i10) {
        if (i10 == 0) {
            if (this.f12479h.f()) {
                this.f5434a.c(this);
                return;
            } else {
                if (this.f12479h.g()) {
                    this.f5434a.k(this);
                    return;
                }
                return;
            }
        }
        if (i10 == 1) {
            this.f5434a.g(this);
            return;
        }
        if (i10 == 2) {
            this.f5434a.h(this);
            return;
        }
        if (i10 == 3) {
            this.f5434a.j(this);
        } else if (i10 != 5) {
            b();
        } else {
            J0(str);
        }
    }

    @Override // c3.h
    public c3.h L(q qVar) {
        this.f13569n = qVar;
        return this;
    }

    @Override // d3.a, c3.h
    public c3.h q(h.b bVar) {
        super.q(bVar);
        if (bVar == h.b.QUOTE_FIELD_NAMES) {
            this.f13570o = true;
        }
        return this;
    }
}
