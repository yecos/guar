package androidx.work;

import a1.g;
import a1.i;
import a1.q;
import a1.v;
import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f3620a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f3621b;

    /* renamed from: c, reason: collision with root package name */
    public final v f3622c;

    /* renamed from: d, reason: collision with root package name */
    public final i f3623d;

    /* renamed from: e, reason: collision with root package name */
    public final q f3624e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3625f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3626g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3627h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3628i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3629j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3630k;

    /* renamed from: androidx.work.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0059a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f3631a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3632b;

        public ThreadFactoryC0059a(boolean z10) {
            this.f3632b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.f3632b ? "WM.task-" : "androidx.work-") + this.f3631a.incrementAndGet());
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Executor f3634a;

        /* renamed from: b, reason: collision with root package name */
        public v f3635b;

        /* renamed from: c, reason: collision with root package name */
        public i f3636c;

        /* renamed from: d, reason: collision with root package name */
        public Executor f3637d;

        /* renamed from: e, reason: collision with root package name */
        public q f3638e;

        /* renamed from: f, reason: collision with root package name */
        public String f3639f;

        /* renamed from: g, reason: collision with root package name */
        public int f3640g = 4;

        /* renamed from: h, reason: collision with root package name */
        public int f3641h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f3642i = Integer.MAX_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public int f3643j = 20;

        public a a() {
            return new a(this);
        }
    }

    public a(b bVar) {
        Executor executor = bVar.f3634a;
        if (executor == null) {
            this.f3620a = a(false);
        } else {
            this.f3620a = executor;
        }
        Executor executor2 = bVar.f3637d;
        if (executor2 == null) {
            this.f3630k = true;
            this.f3621b = a(true);
        } else {
            this.f3630k = false;
            this.f3621b = executor2;
        }
        v vVar = bVar.f3635b;
        if (vVar == null) {
            this.f3622c = v.c();
        } else {
            this.f3622c = vVar;
        }
        i iVar = bVar.f3636c;
        if (iVar == null) {
            this.f3623d = i.c();
        } else {
            this.f3623d = iVar;
        }
        q qVar = bVar.f3638e;
        if (qVar == null) {
            this.f3624e = new b1.a();
        } else {
            this.f3624e = qVar;
        }
        this.f3626g = bVar.f3640g;
        this.f3627h = bVar.f3641h;
        this.f3628i = bVar.f3642i;
        this.f3629j = bVar.f3643j;
        this.f3625f = bVar.f3639f;
    }

    public final Executor a(boolean z10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z10));
    }

    public final ThreadFactory b(boolean z10) {
        return new ThreadFactoryC0059a(z10);
    }

    public String c() {
        return this.f3625f;
    }

    public g d() {
        return null;
    }

    public Executor e() {
        return this.f3620a;
    }

    public i f() {
        return this.f3623d;
    }

    public int g() {
        return this.f3628i;
    }

    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.f3629j / 2 : this.f3629j;
    }

    public int i() {
        return this.f3627h;
    }

    public int j() {
        return this.f3626g;
    }

    public q k() {
        return this.f3624e;
    }

    public Executor l() {
        return this.f3621b;
    }

    public v m() {
        return this.f3622c;
    }
}
