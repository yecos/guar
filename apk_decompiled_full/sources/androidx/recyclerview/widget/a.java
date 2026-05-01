package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a implements l.a {

    /* renamed from: a, reason: collision with root package name */
    public a0.e f3135a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3136b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3137c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0043a f3138d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f3139e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3140f;

    /* renamed from: g, reason: collision with root package name */
    public final l f3141g;

    /* renamed from: h, reason: collision with root package name */
    public int f3142h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0043a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(b bVar);

        void d(int i10, int i11);

        void e(int i10, int i11, Object obj);

        RecyclerView.d0 f(int i10);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3143a;

        /* renamed from: b, reason: collision with root package name */
        public int f3144b;

        /* renamed from: c, reason: collision with root package name */
        public Object f3145c;

        /* renamed from: d, reason: collision with root package name */
        public int f3146d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f3143a = i10;
            this.f3144b = i11;
            this.f3146d = i12;
            this.f3145c = obj;
        }

        public String a() {
            int i10 = this.f3143a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : com.umeng.analytics.pro.f.R : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f3143a;
            if (i10 != bVar.f3143a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f3146d - this.f3144b) == 1 && this.f3146d == bVar.f3144b && this.f3144b == bVar.f3146d) {
                return true;
            }
            if (this.f3146d != bVar.f3146d || this.f3144b != bVar.f3144b) {
                return false;
            }
            Object obj2 = this.f3145c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f3145c)) {
                    return false;
                }
            } else if (bVar.f3145c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3143a * 31) + this.f3144b) * 31) + this.f3146d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f3144b + "c:" + this.f3146d + ",p:" + this.f3145c + "]";
        }
    }

    public a(InterfaceC0043a interfaceC0043a) {
        this(interfaceC0043a, false);
    }

    @Override // androidx.recyclerview.widget.l.a
    public b a(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f3135a.acquire();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f3143a = i10;
        bVar.f3144b = i11;
        bVar.f3146d = i12;
        bVar.f3145c = obj;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void b(b bVar) {
        if (this.f3140f) {
            return;
        }
        bVar.f3145c = null;
        this.f3135a.release(bVar);
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i10) {
        int size = this.f3136b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f3136b.get(i11);
            int i12 = bVar.f3143a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f3144b;
                    if (i13 <= i10) {
                        int i14 = bVar.f3146d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f3144b;
                    if (i15 == i10) {
                        i10 = bVar.f3146d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f3146d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f3144b <= i10) {
                i10 += bVar.f3146d;
            }
        }
        return i10;
    }

    public final void f(b bVar) {
        boolean z10;
        char c10;
        int i10 = bVar.f3144b;
        int i11 = bVar.f3146d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f3138d.f(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(a(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(a(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f3146d) {
            b(bVar);
            bVar = a(2, i10, i13, null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i10 = bVar.f3144b;
        int i11 = bVar.f3146d + i10;
        int i12 = i10;
        char c10 = 65535;
        int i13 = 0;
        while (i10 < i11) {
            if (this.f3138d.f(i10) != null || h(i10)) {
                if (c10 == 0) {
                    k(a(4, i12, i13, bVar.f3145c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 1;
            } else {
                if (c10 == 1) {
                    v(a(4, i12, i13, bVar.f3145c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != bVar.f3146d) {
            Object obj = bVar.f3145c;
            b(bVar);
            bVar = a(4, i12, i13, obj);
        }
        if (c10 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i10) {
        int size = this.f3137c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f3137c.get(i11);
            int i12 = bVar.f3143a;
            if (i12 == 8) {
                if (n(bVar.f3146d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f3144b;
                int i14 = bVar.f3146d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f3137c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3138d.c((b) this.f3137c.get(i10));
        }
        x(this.f3137c);
        this.f3142h = 0;
    }

    public void j() {
        i();
        int size = this.f3136b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f3136b.get(i10);
            int i11 = bVar.f3143a;
            if (i11 == 1) {
                this.f3138d.c(bVar);
                this.f3138d.g(bVar.f3144b, bVar.f3146d);
            } else if (i11 == 2) {
                this.f3138d.c(bVar);
                this.f3138d.h(bVar.f3144b, bVar.f3146d);
            } else if (i11 == 4) {
                this.f3138d.c(bVar);
                this.f3138d.e(bVar.f3144b, bVar.f3146d, bVar.f3145c);
            } else if (i11 == 8) {
                this.f3138d.c(bVar);
                this.f3138d.a(bVar.f3144b, bVar.f3146d);
            }
            Runnable runnable = this.f3139e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f3136b);
        this.f3142h = 0;
    }

    public final void k(b bVar) {
        int i10;
        int i11 = bVar.f3143a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z10 = z(bVar.f3144b, i11);
        int i12 = bVar.f3144b;
        int i13 = bVar.f3143a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f3146d; i15++) {
            int z11 = z(bVar.f3144b + (i10 * i15), bVar.f3143a);
            int i16 = bVar.f3143a;
            if (i16 == 2 ? z11 == z10 : i16 == 4 && z11 == z10 + 1) {
                i14++;
            } else {
                b a10 = a(i16, z10, i14, bVar.f3145c);
                l(a10, i12);
                b(a10);
                if (bVar.f3143a == 4) {
                    i12 += i14;
                }
                z10 = z11;
                i14 = 1;
            }
        }
        Object obj = bVar.f3145c;
        b(bVar);
        if (i14 > 0) {
            b a11 = a(bVar.f3143a, z10, i14, obj);
            l(a11, i12);
            b(a11);
        }
    }

    public void l(b bVar, int i10) {
        this.f3138d.b(bVar);
        int i11 = bVar.f3143a;
        if (i11 == 2) {
            this.f3138d.h(i10, bVar.f3146d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f3138d.e(i10, bVar.f3146d, bVar.f3145c);
        }
    }

    public int m(int i10) {
        return n(i10, 0);
    }

    public int n(int i10, int i11) {
        int size = this.f3137c.size();
        while (i11 < size) {
            b bVar = (b) this.f3137c.get(i11);
            int i12 = bVar.f3143a;
            if (i12 == 8) {
                int i13 = bVar.f3144b;
                if (i13 == i10) {
                    i10 = bVar.f3146d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f3146d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f3144b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f3146d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f3146d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean o(int i10) {
        return (i10 & this.f3142h) != 0;
    }

    public boolean p() {
        return this.f3136b.size() > 0;
    }

    public boolean q() {
        return (this.f3137c.isEmpty() || this.f3136b.isEmpty()) ? false : true;
    }

    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f3136b.add(a(4, i10, i11, obj));
        this.f3142h |= 4;
        return this.f3136b.size() == 1;
    }

    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f3136b.add(a(1, i10, i11, null));
        this.f3142h |= 1;
        return this.f3136b.size() == 1;
    }

    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f3136b.add(a(8, i10, i11, null));
        this.f3142h |= 8;
        return this.f3136b.size() == 1;
    }

    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f3136b.add(a(2, i10, i11, null));
        this.f3142h |= 2;
        return this.f3136b.size() == 1;
    }

    public final void v(b bVar) {
        this.f3137c.add(bVar);
        int i10 = bVar.f3143a;
        if (i10 == 1) {
            this.f3138d.g(bVar.f3144b, bVar.f3146d);
            return;
        }
        if (i10 == 2) {
            this.f3138d.d(bVar.f3144b, bVar.f3146d);
            return;
        }
        if (i10 == 4) {
            this.f3138d.e(bVar.f3144b, bVar.f3146d, bVar.f3145c);
        } else {
            if (i10 == 8) {
                this.f3138d.a(bVar.f3144b, bVar.f3146d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void w() {
        this.f3141g.b(this.f3136b);
        int size = this.f3136b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f3136b.get(i10);
            int i11 = bVar.f3143a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f3139e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3136b.clear();
    }

    public void x(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            b((b) list.get(i10));
        }
        list.clear();
    }

    public void y() {
        x(this.f3136b);
        x(this.f3137c);
        this.f3142h = 0;
    }

    public final int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f3137c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f3137c.get(size);
            int i14 = bVar.f3143a;
            if (i14 == 8) {
                int i15 = bVar.f3144b;
                int i16 = bVar.f3146d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f3144b = i15 + 1;
                            bVar.f3146d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f3144b = i15 - 1;
                            bVar.f3146d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f3146d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f3146d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f3144b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f3144b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f3144b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f3146d;
                    } else if (i14 == 2) {
                        i10 += bVar.f3146d;
                    }
                } else if (i11 == 1) {
                    bVar.f3144b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f3144b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f3137c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f3137c.get(size2);
            if (bVar2.f3143a == 8) {
                int i18 = bVar2.f3146d;
                if (i18 == bVar2.f3144b || i18 < 0) {
                    this.f3137c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f3146d <= 0) {
                this.f3137c.remove(size2);
                b(bVar2);
            }
        }
        return i10;
    }

    public a(InterfaceC0043a interfaceC0043a, boolean z10) {
        this.f3135a = new a0.f(30);
        this.f3136b = new ArrayList();
        this.f3137c = new ArrayList();
        this.f3142h = 0;
        this.f3138d = interfaceC0043a;
        this.f3140f = z10;
        this.f3141g = new l(this);
    }
}
