package j3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes.dex */
public class e implements c3.p, f, Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final f3.i f14648h = new f3.i(" ");

    /* renamed from: a, reason: collision with root package name */
    public b f14649a;

    /* renamed from: b, reason: collision with root package name */
    public b f14650b;

    /* renamed from: c, reason: collision with root package name */
    public final c3.q f14651c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14652d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f14653e;

    /* renamed from: f, reason: collision with root package name */
    public n f14654f;

    /* renamed from: g, reason: collision with root package name */
    public String f14655g;

    public static class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f14656b = new a();

        @Override // j3.e.c, j3.e.b
        public void a(c3.h hVar, int i10) {
            hVar.m0(' ');
        }

        @Override // j3.e.c, j3.e.b
        public boolean isInline() {
            return true;
        }
    }

    public interface b {
        void a(c3.h hVar, int i10);

        boolean isInline();
    }

    public static class c implements b, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final c f14657a = new c();

        @Override // j3.e.b
        public void a(c3.h hVar, int i10) {
        }

        @Override // j3.e.b
        public boolean isInline() {
            return true;
        }
    }

    public e() {
        this(f14648h);
    }

    @Override // c3.p
    public void a(c3.h hVar) {
        hVar.m0(this.f14654f.c());
        this.f14650b.a(hVar, this.f14653e);
    }

    @Override // c3.p
    public void b(c3.h hVar) {
        if (!this.f14649a.isInline()) {
            this.f14653e++;
        }
        hVar.m0('[');
    }

    @Override // c3.p
    public void c(c3.h hVar) {
        this.f14649a.a(hVar, this.f14653e);
    }

    @Override // c3.p
    public void d(c3.h hVar, int i10) {
        if (!this.f14649a.isInline()) {
            this.f14653e--;
        }
        if (i10 > 0) {
            this.f14649a.a(hVar, this.f14653e);
        } else {
            hVar.m0(' ');
        }
        hVar.m0(']');
    }

    @Override // c3.p
    public void e(c3.h hVar) {
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        if (this.f14650b.isInline()) {
            return;
        }
        this.f14653e++;
    }

    @Override // c3.p
    public void g(c3.h hVar) {
        hVar.m0(this.f14654f.b());
        this.f14649a.a(hVar, this.f14653e);
    }

    @Override // c3.p
    public void h(c3.h hVar) {
        if (this.f14652d) {
            hVar.o0(this.f14655g);
        } else {
            hVar.m0(this.f14654f.d());
        }
    }

    @Override // c3.p
    public void i(c3.h hVar, int i10) {
        if (!this.f14650b.isInline()) {
            this.f14653e--;
        }
        if (i10 > 0) {
            this.f14650b.a(hVar, this.f14653e);
        } else {
            hVar.m0(' ');
        }
        hVar.m0(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    @Override // c3.p
    public void j(c3.h hVar) {
        c3.q qVar = this.f14651c;
        if (qVar != null) {
            hVar.n0(qVar);
        }
    }

    @Override // c3.p
    public void k(c3.h hVar) {
        this.f14650b.a(hVar, this.f14653e);
    }

    @Override // j3.f
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e f() {
        if (getClass() == e.class) {
            return new e(this);
        }
        throw new IllegalStateException("Failed `createInstance()`: " + getClass().getName() + " does not override method; it has to");
    }

    public e m(n nVar) {
        this.f14654f = nVar;
        this.f14655g = " " + nVar.d() + " ";
        return this;
    }

    public e(c3.q qVar) {
        this.f14649a = a.f14656b;
        this.f14650b = d.f14644f;
        this.f14652d = true;
        this.f14651c = qVar;
        m(c3.p.R);
    }

    public e(e eVar) {
        this(eVar, eVar.f14651c);
    }

    public e(e eVar, c3.q qVar) {
        this.f14649a = a.f14656b;
        this.f14650b = d.f14644f;
        this.f14652d = true;
        this.f14649a = eVar.f14649a;
        this.f14650b = eVar.f14650b;
        this.f14652d = eVar.f14652d;
        this.f14653e = eVar.f14653e;
        this.f14654f = eVar.f14654f;
        this.f14655g = eVar.f14655g;
        this.f14651c = qVar;
    }
}
