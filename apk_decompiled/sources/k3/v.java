package k3;

import c3.h;
import com.hpplay.cybergarage.upnp.Argument;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* loaded from: classes.dex */
public class v implements Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final c3.p f14980g = new j3.l();

    /* renamed from: a, reason: collision with root package name */
    public final a0 f14981a;

    /* renamed from: b, reason: collision with root package name */
    public final a4.j f14982b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.q f14983c;

    /* renamed from: d, reason: collision with root package name */
    public final c3.f f14984d;

    /* renamed from: e, reason: collision with root package name */
    public final a f14985e;

    /* renamed from: f, reason: collision with root package name */
    public final b f14986f;

    public static final class a implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final a f14987c = new a(null, null, null, null);

        /* renamed from: a, reason: collision with root package name */
        public final c3.p f14988a;

        /* renamed from: b, reason: collision with root package name */
        public final c3.q f14989b;

        public a(c3.p pVar, c3.c cVar, f3.b bVar, c3.q qVar) {
            this.f14988a = pVar;
            this.f14989b = qVar;
        }

        public void a(c3.h hVar) {
            c3.p pVar = this.f14988a;
            if (pVar != null) {
                if (pVar == v.f14980g) {
                    hVar.I(null);
                } else {
                    if (pVar instanceof j3.f) {
                        pVar = (c3.p) ((j3.f) pVar).f();
                    }
                    hVar.I(pVar);
                }
            }
            c3.q qVar = this.f14989b;
            if (qVar != null) {
                hVar.L(qVar);
            }
        }

        public a b(c3.p pVar) {
            if (pVar == null) {
                pVar = v.f14980g;
            }
            return pVar == this.f14988a ? this : new a(pVar, null, null, this.f14989b);
        }
    }

    public static final class b implements Serializable {

        /* renamed from: d, reason: collision with root package name */
        public static final b f14990d = new b(null, null, null);

        /* renamed from: a, reason: collision with root package name */
        public final j f14991a;

        /* renamed from: b, reason: collision with root package name */
        public final o f14992b;

        /* renamed from: c, reason: collision with root package name */
        public final w3.h f14993c;

        public b(j jVar, o oVar, w3.h hVar) {
            this.f14991a = jVar;
            this.f14992b = oVar;
            this.f14993c = hVar;
        }

        public void a(c3.h hVar, Object obj, a4.j jVar) {
            w3.h hVar2 = this.f14993c;
            if (hVar2 != null) {
                jVar.B0(hVar, obj, this.f14991a, this.f14992b, hVar2);
                return;
            }
            o oVar = this.f14992b;
            if (oVar != null) {
                jVar.E0(hVar, obj, this.f14991a, oVar);
                return;
            }
            j jVar2 = this.f14991a;
            if (jVar2 != null) {
                jVar.D0(hVar, obj, jVar2);
            } else {
                jVar.C0(hVar, obj);
            }
        }
    }

    public v(t tVar, a0 a0Var) {
        this.f14981a = a0Var;
        this.f14982b = tVar.f14964h;
        this.f14983c = tVar.f14965i;
        this.f14984d = tVar.f14957a;
        this.f14985e = a.f14987c;
        this.f14986f = b.f14990d;
    }

    public final void a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    public final c3.h b(c3.h hVar) {
        this.f14981a.a0(hVar);
        this.f14985e.a(hVar);
        return hVar;
    }

    public v c(a aVar, b bVar) {
        return (this.f14985e == aVar && this.f14986f == bVar) ? this : new v(this, this.f14981a, aVar, bVar);
    }

    public v d(v vVar, a0 a0Var) {
        return a0Var == this.f14981a ? this : new v(vVar, a0Var);
    }

    public a4.j e() {
        return this.f14982b.A0(this.f14981a, this.f14983c);
    }

    public final void f(c3.h hVar, Object obj) {
        Closeable closeable = (Closeable) obj;
        try {
            this.f14986f.a(hVar, obj, e());
        } catch (Exception e10) {
            e = e10;
        }
        try {
            closeable.close();
            hVar.close();
        } catch (Exception e11) {
            e = e11;
            closeable = null;
            d4.h.j(hVar, closeable, e);
        }
    }

    public final void g(c3.h hVar, Object obj) {
        if (this.f14981a.c0(b0.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            f(hVar, obj);
            return;
        }
        try {
            this.f14986f.a(hVar, obj, e());
            hVar.close();
        } catch (Exception e10) {
            d4.h.k(hVar, e10);
        }
    }

    public c3.h h(OutputStream outputStream, c3.e eVar) {
        a(Argument.OUT, outputStream);
        return b(this.f14984d.k(outputStream, eVar));
    }

    public c3.h i(Writer writer) {
        a(BrowserInfo.KEY_WIDTH, writer);
        return b(this.f14984d.l(writer));
    }

    public v j(c3.p pVar) {
        return c(this.f14985e.b(pVar), this.f14986f);
    }

    public v k() {
        return j(this.f14981a.Y());
    }

    public v l(h.b bVar) {
        return d(this, this.f14981a.d0(bVar));
    }

    public void m(OutputStream outputStream, Object obj) {
        g(h(outputStream, c3.e.UTF8), obj);
    }

    public String n(Object obj) {
        f3.h hVar = new f3.h(this.f14984d.i());
        try {
            g(i(hVar), obj);
            return hVar.a();
        } catch (c3.l e10) {
            throw e10;
        } catch (IOException e11) {
            throw l.l(e11);
        }
    }

    public v(v vVar, a0 a0Var, a aVar, b bVar) {
        this.f14981a = a0Var;
        this.f14982b = vVar.f14982b;
        this.f14983c = vVar.f14983c;
        this.f14984d = vVar.f14984d;
        this.f14985e = aVar;
        this.f14986f = bVar;
    }

    public v(v vVar, a0 a0Var) {
        this.f14981a = a0Var;
        this.f14982b = vVar.f14982b;
        this.f14983c = vVar.f14983c;
        this.f14984d = vVar.f14984d;
        this.f14985e = vVar.f14985e;
        this.f14986f = vVar.f14986f;
    }
}
