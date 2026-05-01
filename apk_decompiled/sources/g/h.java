package g;

import android.view.View;
import android.view.animation.Interpolator;
import b0.a2;
import b0.b2;
import b0.c2;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f13477c;

    /* renamed from: d, reason: collision with root package name */
    public b2 f13478d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13479e;

    /* renamed from: b, reason: collision with root package name */
    public long f13476b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final c2 f13480f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13475a = new ArrayList();

    public class a extends c2 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f13481a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f13482b = 0;

        public a() {
        }

        @Override // b0.b2
        public void b(View view) {
            int i10 = this.f13482b + 1;
            this.f13482b = i10;
            if (i10 == h.this.f13475a.size()) {
                b2 b2Var = h.this.f13478d;
                if (b2Var != null) {
                    b2Var.b(null);
                }
                d();
            }
        }

        @Override // b0.c2, b0.b2
        public void c(View view) {
            if (this.f13481a) {
                return;
            }
            this.f13481a = true;
            b2 b2Var = h.this.f13478d;
            if (b2Var != null) {
                b2Var.c(null);
            }
        }

        public void d() {
            this.f13482b = 0;
            this.f13481a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f13479e) {
            Iterator it = this.f13475a.iterator();
            while (it.hasNext()) {
                ((a2) it.next()).b();
            }
            this.f13479e = false;
        }
    }

    public void b() {
        this.f13479e = false;
    }

    public h c(a2 a2Var) {
        if (!this.f13479e) {
            this.f13475a.add(a2Var);
        }
        return this;
    }

    public h d(a2 a2Var, a2 a2Var2) {
        this.f13475a.add(a2Var);
        a2Var2.h(a2Var.c());
        this.f13475a.add(a2Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f13479e) {
            this.f13476b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f13479e) {
            this.f13477c = interpolator;
        }
        return this;
    }

    public h g(b2 b2Var) {
        if (!this.f13479e) {
            this.f13478d = b2Var;
        }
        return this;
    }

    public void h() {
        if (this.f13479e) {
            return;
        }
        Iterator it = this.f13475a.iterator();
        while (it.hasNext()) {
            a2 a2Var = (a2) it.next();
            long j10 = this.f13476b;
            if (j10 >= 0) {
                a2Var.d(j10);
            }
            Interpolator interpolator = this.f13477c;
            if (interpolator != null) {
                a2Var.e(interpolator);
            }
            if (this.f13478d != null) {
                a2Var.f(this.f13480f);
            }
            a2Var.j();
        }
        this.f13479e = true;
    }
}
