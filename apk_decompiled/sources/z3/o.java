package z3;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class o extends c3.m {

    /* renamed from: c, reason: collision with root package name */
    public final o f20201c;

    /* renamed from: d, reason: collision with root package name */
    public String f20202d;

    /* renamed from: e, reason: collision with root package name */
    public Object f20203e;

    public static final class a extends o {

        /* renamed from: f, reason: collision with root package name */
        public Iterator f20204f;

        /* renamed from: g, reason: collision with root package name */
        public k3.m f20205g;

        public a(k3.m mVar, o oVar) {
            super(1, oVar);
            this.f20204f = mVar.l();
        }

        @Override // c3.m
        public /* bridge */ /* synthetic */ c3.m e() {
            return super.l();
        }

        @Override // z3.o
        public k3.m k() {
            return this.f20205g;
        }

        @Override // z3.o
        public c3.n m() {
            if (!this.f20204f.hasNext()) {
                this.f20205g = null;
                return c3.n.END_ARRAY;
            }
            this.f5484b++;
            k3.m mVar = (k3.m) this.f20204f.next();
            this.f20205g = mVar;
            return mVar.b();
        }

        @Override // z3.o
        public o n() {
            return new a(this.f20205g, this);
        }

        @Override // z3.o
        public o o() {
            return new b(this.f20205g, this);
        }
    }

    public static final class b extends o {

        /* renamed from: f, reason: collision with root package name */
        public Iterator f20206f;

        /* renamed from: g, reason: collision with root package name */
        public Map.Entry f20207g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20208h;

        public b(k3.m mVar, o oVar) {
            super(2, oVar);
            this.f20206f = ((r) mVar).m();
            this.f20208h = true;
        }

        @Override // c3.m
        public /* bridge */ /* synthetic */ c3.m e() {
            return super.l();
        }

        @Override // z3.o
        public k3.m k() {
            Map.Entry entry = this.f20207g;
            if (entry == null) {
                return null;
            }
            return (k3.m) entry.getValue();
        }

        @Override // z3.o
        public c3.n m() {
            if (!this.f20208h) {
                this.f20208h = true;
                return ((k3.m) this.f20207g.getValue()).b();
            }
            if (!this.f20206f.hasNext()) {
                this.f20202d = null;
                this.f20207g = null;
                return c3.n.END_OBJECT;
            }
            this.f5484b++;
            this.f20208h = false;
            Map.Entry entry = (Map.Entry) this.f20206f.next();
            this.f20207g = entry;
            this.f20202d = entry != null ? (String) entry.getKey() : null;
            return c3.n.FIELD_NAME;
        }

        @Override // z3.o
        public o n() {
            return new a(k(), this);
        }

        @Override // z3.o
        public o o() {
            return new b(k(), this);
        }
    }

    public static final class c extends o {

        /* renamed from: f, reason: collision with root package name */
        public k3.m f20209f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f20210g;

        public c(k3.m mVar, o oVar) {
            super(0, oVar);
            this.f20210g = false;
            this.f20209f = mVar;
        }

        @Override // c3.m
        public /* bridge */ /* synthetic */ c3.m e() {
            return super.l();
        }

        @Override // z3.o
        public k3.m k() {
            if (this.f20210g) {
                return this.f20209f;
            }
            return null;
        }

        @Override // z3.o
        public c3.n m() {
            if (this.f20210g) {
                this.f20209f = null;
                return null;
            }
            this.f5484b++;
            this.f20210g = true;
            return this.f20209f.b();
        }

        @Override // z3.o
        public o n() {
            return new a(this.f20209f, this);
        }

        @Override // z3.o
        public o o() {
            return new b(this.f20209f, this);
        }
    }

    public o(int i10, o oVar) {
        this.f5483a = i10;
        this.f5484b = -1;
        this.f20201c = oVar;
    }

    @Override // c3.m
    public final String b() {
        return this.f20202d;
    }

    @Override // c3.m
    public Object c() {
        return this.f20203e;
    }

    @Override // c3.m
    public void i(Object obj) {
        this.f20203e = obj;
    }

    public abstract k3.m k();

    public final o l() {
        return this.f20201c;
    }

    public abstract c3.n m();

    public abstract o n();

    public abstract o o();
}
