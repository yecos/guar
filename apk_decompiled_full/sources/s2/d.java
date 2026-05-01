package s2;

import android.os.Process;
import android.text.TextUtils;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public abstract class d {

    public static final class b extends ScheduledThreadPoolExecutor {
        public b(int i10, int i11, long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            super(i10, threadFactory);
            setMaximumPoolSize(i11);
            setKeepAliveTime(j10, timeUnit);
        }
    }

    public static final class c extends AtomicLong implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final String f18732a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18733b;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f18732a + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + incrementAndGet());
            thread.setPriority(this.f18733b);
            thread.setDaemon(true);
            return thread;
        }

        public c(String str) {
            this(str, 5);
        }

        public c(String str, int i10) {
            this.f18732a = str;
            this.f18733b = i10;
        }
    }

    /* renamed from: s2.d$d, reason: collision with other inner class name */
    public static final class C0318d {

        /* renamed from: a, reason: collision with root package name */
        public static final ScheduledThreadPoolExecutor f18734a = new b(4, 512, 1, TimeUnit.SECONDS, new c("base-io"));
    }

    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f18735a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18736b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f18737c;

        public e(String str, Runnable runnable, boolean z10) {
            this(str, runnable, z10 ? -2 : 10);
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(this.f18735a);
            if (this.f18737c != null) {
                if (!TextUtils.isEmpty(this.f18736b)) {
                    Thread.currentThread().setName(this.f18736b);
                }
                try {
                    this.f18737c.run();
                } catch (Exception e10) {
                    m2.a.a(e10, "thread pool manager");
                }
            }
        }

        public e(String str, Runnable runnable, int i10) {
            this.f18735a = i10;
            this.f18736b = str;
            this.f18737c = runnable;
        }
    }

    public static Runnable a(String str, Runnable runnable, boolean z10) {
        return new e(str, runnable, z10);
    }

    public static void b(String str, Runnable runnable, boolean z10) {
        C0318d.f18734a.execute(a(str, runnable, z10));
    }

    public static ScheduledThreadPoolExecutor c() {
        return C0318d.f18734a;
    }
}
