package m;

import java.util.ArrayList;
import m.e;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public int f16603a;

    /* renamed from: b, reason: collision with root package name */
    public int f16604b;

    /* renamed from: c, reason: collision with root package name */
    public int f16605c;

    /* renamed from: d, reason: collision with root package name */
    public int f16606d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f16607e = new ArrayList();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public e f16608a;

        /* renamed from: b, reason: collision with root package name */
        public e f16609b;

        /* renamed from: c, reason: collision with root package name */
        public int f16610c;

        /* renamed from: d, reason: collision with root package name */
        public e.c f16611d;

        /* renamed from: e, reason: collision with root package name */
        public int f16612e;

        public a(e eVar) {
            this.f16608a = eVar;
            this.f16609b = eVar.i();
            this.f16610c = eVar.d();
            this.f16611d = eVar.h();
            this.f16612e = eVar.c();
        }

        public void a(f fVar) {
            fVar.h(this.f16608a.j()).b(this.f16609b, this.f16610c, this.f16611d, this.f16612e);
        }

        public void b(f fVar) {
            e h10 = fVar.h(this.f16608a.j());
            this.f16608a = h10;
            if (h10 != null) {
                this.f16609b = h10.i();
                this.f16610c = this.f16608a.d();
                this.f16611d = this.f16608a.h();
                this.f16612e = this.f16608a.c();
                return;
            }
            this.f16609b = null;
            this.f16610c = 0;
            this.f16611d = e.c.STRONG;
            this.f16612e = 0;
        }
    }

    public p(f fVar) {
        this.f16603a = fVar.G();
        this.f16604b = fVar.H();
        this.f16605c = fVar.D();
        this.f16606d = fVar.r();
        ArrayList i10 = fVar.i();
        int size = i10.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f16607e.add(new a((e) i10.get(i11)));
        }
    }

    public void a(f fVar) {
        fVar.C0(this.f16603a);
        fVar.D0(this.f16604b);
        fVar.y0(this.f16605c);
        fVar.b0(this.f16606d);
        int size = this.f16607e.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((a) this.f16607e.get(i10)).a(fVar);
        }
    }

    public void b(f fVar) {
        this.f16603a = fVar.G();
        this.f16604b = fVar.H();
        this.f16605c = fVar.D();
        this.f16606d = fVar.r();
        int size = this.f16607e.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((a) this.f16607e.get(i10)).b(fVar);
        }
    }
}
