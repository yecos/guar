package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final b f3274a;

    /* renamed from: b, reason: collision with root package name */
    public a f3275b = new a();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f3276a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f3277b;

        /* renamed from: c, reason: collision with root package name */
        public int f3278c;

        /* renamed from: d, reason: collision with root package name */
        public int f3279d;

        /* renamed from: e, reason: collision with root package name */
        public int f3280e;

        public void a(int i10) {
            this.f3276a = i10 | this.f3276a;
        }

        public boolean b() {
            int i10 = this.f3276a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f3279d, this.f3277b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f3276a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f3279d, this.f3278c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f3276a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f3280e, this.f3277b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f3276a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f3280e, this.f3278c) << 12)) != 0;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void d() {
            this.f3276a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f3277b = i10;
            this.f3278c = i11;
            this.f3279d = i12;
            this.f3280e = i13;
        }
    }

    public interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public s(b bVar) {
        this.f3274a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int c10 = this.f3274a.c();
        int d10 = this.f3274a.d();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View a10 = this.f3274a.a(i10);
            this.f3275b.e(c10, d10, this.f3274a.b(a10), this.f3274a.e(a10));
            if (i12 != 0) {
                this.f3275b.d();
                this.f3275b.a(i12);
                if (this.f3275b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f3275b.d();
                this.f3275b.a(i13);
                if (this.f3275b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean b(View view, int i10) {
        this.f3275b.e(this.f3274a.c(), this.f3274a.d(), this.f3274a.b(view), this.f3274a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f3275b.d();
        this.f3275b.a(i10);
        return this.f3275b.b();
    }
}
