package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0044b f3147a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3148b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final List f3149c = new ArrayList();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f3150a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f3151b;

        public void a(int i10) {
            if (i10 < 64) {
                this.f3150a &= (1 << i10) ^ (-1);
                return;
            }
            a aVar = this.f3151b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        public int b(int i10) {
            a aVar = this.f3151b;
            return aVar == null ? i10 >= 64 ? Long.bitCount(this.f3150a) : Long.bitCount(this.f3150a & ((1 << i10) - 1)) : i10 < 64 ? Long.bitCount(this.f3150a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f3150a);
        }

        public final void c() {
            if (this.f3151b == null) {
                this.f3151b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 < 64) {
                return (this.f3150a & (1 << i10)) != 0;
            }
            c();
            return this.f3151b.d(i10 - 64);
        }

        public void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f3151b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f3150a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f3150a = ((j10 & (j11 ^ (-1))) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f3151b != null) {
                c();
                this.f3151b.e(0, z11);
            }
        }

        public boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f3151b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f3150a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (j10 ^ (-1));
            this.f3150a = j12;
            long j13 = j10 - 1;
            this.f3150a = (j12 & j13) | Long.rotateRight((j13 ^ (-1)) & j12, 1);
            a aVar = this.f3151b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f3151b.f(0);
            }
            return z10;
        }

        public void g() {
            this.f3150a = 0L;
            a aVar = this.f3151b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i10) {
            if (i10 < 64) {
                this.f3150a |= 1 << i10;
            } else {
                c();
                this.f3151b.h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f3151b == null) {
                return Long.toBinaryString(this.f3150a);
            }
            return this.f3151b.toString() + "xx" + Long.toBinaryString(this.f3150a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0044b {
        View a(int i10);

        void b(View view);

        int c();

        RecyclerView.d0 d(View view);

        void e(int i10);

        void f(View view, int i10);

        void g();

        int h(View view);

        void i(View view);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    public b(InterfaceC0044b interfaceC0044b) {
        this.f3147a = interfaceC0044b;
    }

    public void a(View view, int i10, boolean z10) {
        int c10 = i10 < 0 ? this.f3147a.c() : h(i10);
        this.f3148b.e(c10, z10);
        if (z10) {
            l(view);
        }
        this.f3147a.f(view, c10);
    }

    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int c10 = i10 < 0 ? this.f3147a.c() : h(i10);
        this.f3148b.e(c10, z10);
        if (z10) {
            l(view);
        }
        this.f3147a.k(view, c10, layoutParams);
    }

    public void d(int i10) {
        int h10 = h(i10);
        this.f3148b.f(h10);
        this.f3147a.e(h10);
    }

    public View e(int i10) {
        int size = this.f3149c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f3149c.get(i11);
            RecyclerView.d0 d10 = this.f3147a.d(view);
            if (d10.getLayoutPosition() == i10 && !d10.isInvalid() && !d10.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i10) {
        return this.f3147a.a(h(i10));
    }

    public int g() {
        return this.f3147a.c() - this.f3149c.size();
    }

    public final int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int c10 = this.f3147a.c();
        int i11 = i10;
        while (i11 < c10) {
            int b10 = i10 - (i11 - this.f3148b.b(i11));
            if (b10 == 0) {
                while (this.f3148b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b10;
        }
        return -1;
    }

    public View i(int i10) {
        return this.f3147a.a(i10);
    }

    public int j() {
        return this.f3147a.c();
    }

    public void k(View view) {
        int h10 = this.f3147a.h(view);
        if (h10 >= 0) {
            this.f3148b.h(h10);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f3149c.add(view);
        this.f3147a.b(view);
    }

    public int m(View view) {
        int h10 = this.f3147a.h(view);
        if (h10 == -1 || this.f3148b.d(h10)) {
            return -1;
        }
        return h10 - this.f3148b.b(h10);
    }

    public boolean n(View view) {
        return this.f3149c.contains(view);
    }

    public void o() {
        this.f3148b.g();
        for (int size = this.f3149c.size() - 1; size >= 0; size--) {
            this.f3147a.i((View) this.f3149c.get(size));
            this.f3149c.remove(size);
        }
        this.f3147a.g();
    }

    public void p(View view) {
        int h10 = this.f3147a.h(view);
        if (h10 < 0) {
            return;
        }
        if (this.f3148b.f(h10)) {
            t(view);
        }
        this.f3147a.j(h10);
    }

    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f3147a.a(h10);
        if (a10 == null) {
            return;
        }
        if (this.f3148b.f(h10)) {
            t(a10);
        }
        this.f3147a.j(h10);
    }

    public boolean r(View view) {
        int h10 = this.f3147a.h(view);
        if (h10 == -1) {
            t(view);
            return true;
        }
        if (!this.f3148b.d(h10)) {
            return false;
        }
        this.f3148b.f(h10);
        t(view);
        this.f3147a.j(h10);
        return true;
    }

    public void s(View view) {
        int h10 = this.f3147a.h(view);
        if (h10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f3148b.d(h10)) {
            this.f3148b.a(h10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f3149c.remove(view)) {
            return false;
        }
        this.f3147a.i(view);
        return true;
    }

    public String toString() {
        return this.f3148b.toString() + ", hidden list:" + this.f3149c.size();
    }
}
