package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.collection.g f3281a = new androidx.collection.g();

    /* renamed from: b, reason: collision with root package name */
    public final androidx.collection.d f3282b = new androidx.collection.d();

    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static a0.e f3283d = new a0.f(20);

        /* renamed from: a, reason: collision with root package name */
        public int f3284a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.l.b f3285b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.l.b f3286c;

        public static void a() {
            while (f3283d.acquire() != null) {
            }
        }

        public static a b() {
            a aVar = (a) f3283d.acquire();
            return aVar == null ? new a() : aVar;
        }

        public static void c(a aVar) {
            aVar.f3284a = 0;
            aVar.f3285b = null;
            aVar.f3286c = null;
            f3283d.release(aVar);
        }
    }

    public interface b {
        void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void b(RecyclerView.d0 d0Var);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    public void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f3281a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3281a.put(d0Var, aVar);
        }
        aVar.f3284a |= 2;
        aVar.f3285b = bVar;
    }

    public void b(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3281a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3281a.put(d0Var, aVar);
        }
        aVar.f3284a |= 1;
    }

    public void c(long j10, RecyclerView.d0 d0Var) {
        this.f3282b.j(j10, d0Var);
    }

    public void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f3281a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3281a.put(d0Var, aVar);
        }
        aVar.f3286c = bVar;
        aVar.f3284a |= 8;
    }

    public void e(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        a aVar = (a) this.f3281a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3281a.put(d0Var, aVar);
        }
        aVar.f3285b = bVar;
        aVar.f3284a |= 4;
    }

    public void f() {
        this.f3281a.clear();
        this.f3282b.b();
    }

    public RecyclerView.d0 g(long j10) {
        return (RecyclerView.d0) this.f3282b.f(j10);
    }

    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3281a.get(d0Var);
        return (aVar == null || (aVar.f3284a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3281a.get(d0Var);
        return (aVar == null || (aVar.f3284a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    public final RecyclerView.l.b l(RecyclerView.d0 d0Var, int i10) {
        a aVar;
        RecyclerView.l.b bVar;
        int indexOfKey = this.f3281a.indexOfKey(d0Var);
        if (indexOfKey >= 0 && (aVar = (a) this.f3281a.valueAt(indexOfKey)) != null) {
            int i11 = aVar.f3284a;
            if ((i11 & i10) != 0) {
                int i12 = (i10 ^ (-1)) & i11;
                aVar.f3284a = i12;
                if (i10 == 4) {
                    bVar = aVar.f3285b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    bVar = aVar.f3286c;
                }
                if ((i12 & 12) == 0) {
                    this.f3281a.removeAt(indexOfKey);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    public RecyclerView.l.b m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    public RecyclerView.l.b n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.f3281a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0Var = (RecyclerView.d0) this.f3281a.keyAt(size);
            a aVar = (a) this.f3281a.removeAt(size);
            int i10 = aVar.f3284a;
            if ((i10 & 3) == 3) {
                bVar.b(d0Var);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.b bVar2 = aVar.f3285b;
                if (bVar2 == null) {
                    bVar.b(d0Var);
                } else {
                    bVar.c(d0Var, bVar2, aVar.f3286c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.a(d0Var, aVar.f3285b, aVar.f3286c);
            } else if ((i10 & 12) == 12) {
                bVar.d(d0Var, aVar.f3285b, aVar.f3286c);
            } else if ((i10 & 4) != 0) {
                bVar.c(d0Var, aVar.f3285b, null);
            } else if ((i10 & 8) != 0) {
                bVar.a(d0Var, aVar.f3285b, aVar.f3286c);
            }
            a.c(aVar);
        }
    }

    public void p(RecyclerView.d0 d0Var) {
        a aVar = (a) this.f3281a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f3284a &= -2;
    }

    public void q(RecyclerView.d0 d0Var) {
        int m10 = this.f3282b.m() - 1;
        while (true) {
            if (m10 < 0) {
                break;
            }
            if (d0Var == this.f3282b.n(m10)) {
                this.f3282b.l(m10);
                break;
            }
            m10--;
        }
        a aVar = (a) this.f3281a.remove(d0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
