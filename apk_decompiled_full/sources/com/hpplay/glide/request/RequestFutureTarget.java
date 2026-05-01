package com.hpplay.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.hpplay.glide.request.animation.GlideAnimation;
import com.hpplay.glide.request.target.SizeReadyCallback;
import com.hpplay.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class RequestFutureTarget<T, R> implements FutureTarget<R>, Runnable {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final Handler mainHandler;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    public static class Waiter {
        public void notifyAll(Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(Object obj, long j10) {
            obj.wait(j10);
        }
    }

    public RequestFutureTarget(Handler handler, int i10, int i11) {
        this(handler, i10, i11, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l10) {
        if (this.assertBackgroundThread) {
            Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (this.exceptionReceived) {
            throw new ExecutionException(this.exception);
        }
        if (this.resultReceived) {
            return this.resource;
        }
        if (l10 == null) {
            this.waiter.waitForTimeout(this, 0L);
        } else if (l10.longValue() > 0) {
            this.waiter.waitForTimeout(this, l10.longValue());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.exceptionReceived) {
            throw new ExecutionException(this.exception);
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (!this.resultReceived) {
            throw new TimeoutException();
        }
        return this.resource;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z10) {
        if (this.isCancelled) {
            return true;
        }
        boolean z11 = !isDone();
        if (z11) {
            this.isCancelled = true;
            if (z10) {
                clear();
            }
            this.waiter.notifyAll(this);
        }
        return z11;
    }

    @Override // com.hpplay.glide.request.FutureTarget
    public void clear() {
        this.mainHandler.post(this);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return doGet(null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.hpplay.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.hpplay.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z10;
        if (!this.isCancelled) {
            z10 = this.resultReceived;
        }
        return z10;
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.hpplay.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.hpplay.glide.request.target.Target
    public synchronized void onLoadFailed(Exception exc, Drawable drawable) {
        this.exceptionReceived = true;
        this.exception = exc;
        this.waiter.notifyAll(this);
    }

    @Override // com.hpplay.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.hpplay.glide.request.target.Target
    public synchronized void onResourceReady(R r10, GlideAnimation<? super R> glideAnimation) {
        this.resultReceived = true;
        this.resource = r10;
        this.waiter.notifyAll(this);
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request = this.request;
        if (request != null) {
            request.clear();
            cancel(false);
        }
    }

    @Override // com.hpplay.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }

    public RequestFutureTarget(Handler handler, int i10, int i11, boolean z10, Waiter waiter) {
        this.mainHandler = handler;
        this.width = i10;
        this.height = i11;
        this.assertBackgroundThread = z10;
        this.waiter = waiter;
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, TimeUnit timeUnit) {
        return doGet(Long.valueOf(timeUnit.toMillis(j10)));
    }
}
