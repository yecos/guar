package androidx.loader.content;

import a0.i;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class a extends b {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile androidx.loader.content.a.a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile androidx.loader.content.a.a mTask;
    long mUpdateThrottle;

    /* renamed from: androidx.loader.content.a$a, reason: collision with other inner class name */
    public final class RunnableC0035a extends c implements Runnable {

        /* renamed from: k, reason: collision with root package name */
        public final CountDownLatch f2615k = new CountDownLatch(1);

        /* renamed from: l, reason: collision with root package name */
        public boolean f2616l;

        public RunnableC0035a() {
        }

        @Override // androidx.loader.content.c
        public void g(Object obj) {
            try {
                a.this.dispatchOnCancelled(this, obj);
            } finally {
                this.f2615k.countDown();
            }
        }

        @Override // androidx.loader.content.c
        public void h(Object obj) {
            try {
                a.this.dispatchOnLoadComplete(this, obj);
            } finally {
                this.f2615k.countDown();
            }
        }

        @Override // androidx.loader.content.c
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public Object b(Void... voidArr) {
            return a.this.onLoadInBackground();
        }

        public void n() {
            try {
                this.f2615k.await();
            } catch (InterruptedException unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2616l = false;
            a.this.executePendingTask();
        }
    }

    public a(Context context) {
        this(context, c.f2620h);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(androidx.loader.content.a.a aVar, Object obj) {
        onCanceled(obj);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(androidx.loader.content.a.a aVar, Object obj) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, obj);
            return;
        }
        if (isAbandoned()) {
            onCanceled(obj);
            return;
        }
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(obj);
    }

    @Override // androidx.loader.content.b
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f2616l);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f2616l);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.c(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        if (this.mTask.f2616l) {
            this.mTask.f2616l = false;
            this.mHandler.removeCallbacks(this.mTask);
        }
        if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.c(this.mExecutor, null);
        } else {
            this.mTask.f2616l = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract Object loadInBackground();

    @Override // androidx.loader.content.b
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f2616l) {
                this.mTask.f2616l = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        }
        if (this.mTask.f2616l) {
            this.mTask.f2616l = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        }
        boolean a10 = this.mTask.a(false);
        if (a10) {
            this.mCancellingTask = this.mTask;
            cancelLoadInBackground();
        }
        this.mTask = null;
        return a10;
    }

    public void onCanceled(Object obj) {
    }

    @Override // androidx.loader.content.b
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0035a();
        executePendingTask();
    }

    public Object onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j10) {
        this.mUpdateThrottle = j10;
        if (j10 != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        androidx.loader.content.a.a aVar = this.mTask;
        if (aVar != null) {
            aVar.n();
        }
    }

    public a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }
}
