package androidx.work;

import a1.v;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.common.util.concurrent.ListenableFuture;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.UUID;
import java.util.concurrent.Executor;
import l1.c;

/* loaded from: classes.dex */
public abstract class ListenableWorker {

    /* renamed from: a, reason: collision with root package name */
    public Context f3597a;

    /* renamed from: b, reason: collision with root package name */
    public WorkerParameters f3598b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f3599c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3600d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3601e;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a, reason: collision with other inner class name */
        public static final class C0058a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final androidx.work.b f3602a;

            public C0058a() {
                this(androidx.work.b.f3645c);
            }

            public androidx.work.b e() {
                return this.f3602a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0058a.class != obj.getClass()) {
                    return false;
                }
                return this.f3602a.equals(((C0058a) obj).f3602a);
            }

            public int hashCode() {
                return (C0058a.class.getName().hashCode() * 31) + this.f3602a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f3602a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
            }

            public C0058a(androidx.work.b bVar) {
                this.f3602a = bVar;
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name */
            public final androidx.work.b f3603a;

            public c() {
                this(androidx.work.b.f3645c);
            }

            public androidx.work.b e() {
                return this.f3603a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f3603a.equals(((c) obj).f3603a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f3603a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f3603a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
            }

            public c(androidx.work.b bVar) {
                this.f3603a = bVar;
            }
        }

        public static a a() {
            return new C0058a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(androidx.work.b bVar) {
            return new c(bVar);
        }
    }

    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f3597a = context;
        this.f3598b = workerParameters;
    }

    public final Context a() {
        return this.f3597a;
    }

    public Executor c() {
        return this.f3598b.a();
    }

    public ListenableFuture e() {
        c s10 = c.s();
        s10.p(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return s10;
    }

    public final UUID f() {
        return this.f3598b.c();
    }

    public final b g() {
        return this.f3598b.d();
    }

    public m1.a h() {
        return this.f3598b.e();
    }

    public v i() {
        return this.f3598b.f();
    }

    public boolean j() {
        return this.f3601e;
    }

    public final boolean k() {
        return this.f3599c;
    }

    public final boolean l() {
        return this.f3600d;
    }

    public void m() {
    }

    public void n(boolean z10) {
        this.f3601e = z10;
    }

    public final void o() {
        this.f3600d = true;
    }

    public abstract ListenableFuture p();

    public final void q() {
        this.f3599c = true;
        m();
    }
}
