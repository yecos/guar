package z8;

import com.google.android.gms.cast.MediaTrack;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import y8.d0;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f20767f = Logger.getLogger(y8.f.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Object f20768a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final y8.i0 f20769b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection f20770c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20771d;

    /* renamed from: e, reason: collision with root package name */
    public int f20772e;

    public class a extends ArrayDeque {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20773a;

        public a(int i10) {
            this.f20773a = i10;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(y8.d0 d0Var) {
            if (size() == this.f20773a) {
                removeFirst();
            }
            o.a(o.this);
            return super.add(d0Var);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20775a;

        static {
            int[] iArr = new int[d0.b.values().length];
            f20775a = iArr;
            try {
                iArr[d0.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20775a[d0.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(y8.i0 i0Var, int i10, long j10, String str) {
        Preconditions.checkNotNull(str, MediaTrack.ROLE_DESCRIPTION);
        this.f20769b = (y8.i0) Preconditions.checkNotNull(i0Var, "logId");
        if (i10 > 0) {
            this.f20770c = new a(i10);
        } else {
            this.f20770c = null;
        }
        this.f20771d = j10;
        e(new d0.a().b(str + " created").c(d0.b.CT_INFO).e(j10).a());
    }

    public static /* synthetic */ int a(o oVar) {
        int i10 = oVar.f20772e;
        oVar.f20772e = i10 + 1;
        return i10;
    }

    public static void d(y8.i0 i0Var, Level level, String str) {
        Logger logger = f20767f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + i0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public y8.i0 b() {
        return this.f20769b;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f20768a) {
            z10 = this.f20770c != null;
        }
        return z10;
    }

    public void e(y8.d0 d0Var) {
        int i10 = b.f20775a[d0Var.f19829b.ordinal()];
        Level level = i10 != 1 ? i10 != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        f(d0Var);
        d(this.f20769b, level, d0Var.f19828a);
    }

    public void f(y8.d0 d0Var) {
        synchronized (this.f20768a) {
            Collection collection = this.f20770c;
            if (collection != null) {
                collection.add(d0Var);
            }
        }
    }
}
