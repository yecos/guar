package com.loopj.android.http;

import android.os.Looper;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest asyncHttpRequest) {
        this.request = new WeakReference<>(asyncHttpRequest);
    }

    public boolean cancel(final boolean z10) {
        final AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return asyncHttpRequest.cancel(z10);
        }
        new Thread(new Runnable() { // from class: com.loopj.android.http.RequestHandle.1
            @Override // java.lang.Runnable
            public void run() {
                asyncHttpRequest.cancel(z10);
            }
        }).start();
        return true;
    }

    public Object getTag() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null) {
            return null;
        }
        return asyncHttpRequest.getTag();
    }

    public boolean isCancelled() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isCancelled();
    }

    public boolean isFinished() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isDone();
    }

    public RequestHandle setTag(Object obj) {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest != null) {
            asyncHttpRequest.setRequestTag(obj);
        }
        return this;
    }

    public boolean shouldBeGarbageCollected() {
        boolean z10 = isCancelled() || isFinished();
        if (z10) {
            this.request.clear();
        }
        return z10;
    }
}
