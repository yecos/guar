package com.loopj.android.http;

import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.client = (AbstractHttpClient) Utils.notNull(abstractHttpClient, "client");
        this.context = (HttpContext) Utils.notNull(httpContext, f.X);
        this.request = (HttpUriRequest) Utils.notNull(httpUriRequest, "request");
        this.responseHandler = (ResponseHandlerInterface) Utils.notNull(responseHandlerInterface, "responseHandler");
    }

    private void makeRequest() {
        if (isCancelled()) {
            return;
        }
        if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
        ResponseHandlerInterface responseHandlerInterface = this.responseHandler;
        if (responseHandlerInterface instanceof RangeFileAsyncHttpResponseHandler) {
            ((RangeFileAsyncHttpResponseHandler) responseHandlerInterface).updateRequestHeaders(this.request);
        }
        HttpResponse execute = this.client.execute(this.request, this.context);
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface2 = this.responseHandler;
        responseHandlerInterface2.onPreProcessResponse(responseHandlerInterface2, execute);
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendResponseMessage(execute);
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface3 = this.responseHandler;
        responseHandlerInterface3.onPostProcessResponse(responseHandlerInterface3, execute);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0009 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequestWithRetries() {
        IOException iOException;
        boolean retryRequest;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        IOException e10 = null;
        boolean z10 = true;
        while (z10) {
            try {
                try {
                    try {
                        makeRequest();
                        return;
                    } catch (UnknownHostException e11) {
                        iOException = new IOException("UnknownHostException exception: " + e11.getMessage());
                        if (this.executionCount > 0) {
                            int i10 = this.executionCount + 1;
                            this.executionCount = i10;
                            if (httpRequestRetryHandler.retryRequest(e11, i10, this.context)) {
                                retryRequest = true;
                                IOException iOException2 = iOException;
                                z10 = retryRequest;
                                e10 = iOException2;
                                if (!z10) {
                                    this.responseHandler.sendRetryMessage(this.executionCount);
                                }
                            }
                        }
                        retryRequest = false;
                        IOException iOException22 = iOException;
                        z10 = retryRequest;
                        e10 = iOException22;
                        if (!z10) {
                        }
                    }
                } catch (NullPointerException e12) {
                    iOException = new IOException("NPE in HttpClient: " + e12.getMessage());
                    int i11 = this.executionCount + 1;
                    this.executionCount = i11;
                    retryRequest = httpRequestRetryHandler.retryRequest(iOException, i11, this.context);
                    IOException iOException222 = iOException;
                    z10 = retryRequest;
                    e10 = iOException222;
                    if (!z10) {
                    }
                }
            } catch (IOException e13) {
                e10 = e13;
                try {
                    if (isCancelled()) {
                        return;
                    }
                    int i12 = this.executionCount + 1;
                    this.executionCount = i12;
                    z10 = httpRequestRetryHandler.retryRequest(e10, i12, this.context);
                    if (!z10) {
                    }
                } catch (Exception e14) {
                    AsyncHttpClient.log.e("AsyncHttpRequest", "Unhandled exception origin cause", e14);
                    throw new IOException("Unhandled exception: " + e14.getMessage());
                }
            }
        }
    }

    private synchronized void sendCancelNotification() {
        if (!this.isFinished && this.isCancelled.get() && !this.cancelIsNotified) {
            this.cancelIsNotified = true;
            this.responseHandler.sendCancelMessage();
        }
    }

    public boolean cancel(boolean z10) {
        this.isCancelled.set(true);
        this.request.abort();
        return isCancelled();
    }

    public Object getTag() {
        return this.responseHandler.getTag();
    }

    public boolean isCancelled() {
        boolean z10 = this.isCancelled.get();
        if (z10) {
            sendCancelNotification();
        }
        return z10;
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    public void onPostProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    public void onPreProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isCancelled()) {
            return;
        }
        if (!this.isRequestPreProcessed) {
            this.isRequestPreProcessed = true;
            onPreProcessRequest(this);
        }
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendStartMessage();
        if (isCancelled()) {
            return;
        }
        try {
            makeRequestWithRetries();
        } catch (IOException e10) {
            if (isCancelled()) {
                AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", e10);
            } else {
                this.responseHandler.sendFailureMessage(0, null, null, e10);
            }
        }
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendFinishMessage();
        if (isCancelled()) {
            return;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
    }

    public AsyncHttpRequest setRequestTag(Object obj) {
        this.responseHandler.setTag(obj);
        return this;
    }
}
