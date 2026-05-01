package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final h f2596a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f2597b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    public a f2598c;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final h f2599a;

        /* renamed from: b, reason: collision with root package name */
        public final d.b f2600b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2601c = false;

        public a(h hVar, d.b bVar) {
            this.f2599a = hVar;
            this.f2600b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2601c) {
                return;
            }
            this.f2599a.h(this.f2600b);
            this.f2601c = true;
        }
    }

    public u(g gVar) {
        this.f2596a = new h(gVar);
    }

    public d a() {
        return this.f2596a;
    }

    public void b() {
        f(d.b.ON_START);
    }

    public void c() {
        f(d.b.ON_CREATE);
    }

    public void d() {
        f(d.b.ON_STOP);
        f(d.b.ON_DESTROY);
    }

    public void e() {
        f(d.b.ON_START);
    }

    public final void f(d.b bVar) {
        a aVar = this.f2598c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f2596a, bVar);
        this.f2598c = aVar2;
        this.f2597b.postAtFrontOfQueue(aVar2);
    }
}
