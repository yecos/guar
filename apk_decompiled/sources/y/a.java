package y;

import android.graphics.Typeface;
import android.os.Handler;
import y.e;
import y.f;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final f.c f19662a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f19663b;

    /* renamed from: y.a$a, reason: collision with other inner class name */
    public class RunnableC0338a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f.c f19664a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f19665b;

        public RunnableC0338a(f.c cVar, Typeface typeface) {
            this.f19664a = cVar;
            this.f19665b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19664a.b(this.f19665b);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f.c f19667a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19668b;

        public b(f.c cVar, int i10) {
            this.f19667a = cVar;
            this.f19668b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19667a.a(this.f19668b);
        }
    }

    public a(f.c cVar, Handler handler) {
        this.f19662a = cVar;
        this.f19663b = handler;
    }

    public final void a(int i10) {
        this.f19663b.post(new b(this.f19662a, i10));
    }

    public void b(e.C0339e c0339e) {
        if (c0339e.a()) {
            c(c0339e.f19691a);
        } else {
            a(c0339e.f19692b);
        }
    }

    public final void c(Typeface typeface) {
        this.f19663b.post(new RunnableC0338a(this.f19662a, typeface));
    }
}
