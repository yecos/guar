package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public abstract class AsyncHttpJob extends AsyncTask {
    private HttpRequest httpRequest;
    public int id;
    private AsyncHttpParameter inParameter;
    private int method;
    private AsyncHttpRequestListener requestListener;
    private final String TAG = "AsyncHttpJob";
    private Runnable mTimeOutRunnable = new Runnable() { // from class: com.hpplay.common.asyncmanager.AsyncHttpJob.1
        @Override // java.lang.Runnable
        public void run() {
            LeLog.w("AsyncHttpJob", "http request timeout");
            AsyncHttpJob.this.onPostExecute(null);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public AsyncHttpJob(int i10, AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener) {
        this.method = i10;
        this.inParameter = asyncHttpParameter;
        this.requestListener = asyncHttpRequestListener;
    }

    public void cancelTimeOut() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mTimeOutRunnable);
            this.mHandler = null;
        }
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        this.httpRequest = new HttpRequest(this.inParameter.in, this);
        Handler handler = this.mHandler;
        Runnable runnable = this.mTimeOutRunnable;
        int i10 = this.inParameter.in.readTimeout;
        handler.postDelayed(runnable, i10 + i10);
        return this.method == 1 ? this.httpRequest.doPost() : this.httpRequest.doGet();
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        LeLog.i("AsyncHttpJob", "onCancelled");
        AsyncHttpRequestListener asyncHttpRequestListener = this.requestListener;
        if (asyncHttpRequestListener != null) {
            AsyncHttpParameter asyncHttpParameter = this.inParameter;
            asyncHttpParameter.out.resultType = 2;
            asyncHttpRequestListener.onRequestResult(asyncHttpParameter);
            this.requestListener = null;
        }
        cancelTimeOut();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncHttpRequestListener asyncHttpRequestListener = this.requestListener;
        if (asyncHttpRequestListener != null) {
            if (obj == null || !(obj instanceof HttpResult)) {
                AsyncHttpParameter asyncHttpParameter = this.inParameter;
                asyncHttpParameter.out.resultType = 1;
                asyncHttpRequestListener.onRequestResult(asyncHttpParameter);
            } else {
                HttpResult httpResult = (HttpResult) obj;
                AsyncHttpParameter.Out out = this.inParameter.out;
                out.resultType = httpResult.resultType;
                out.result = httpResult.result;
                out.responseCode = httpResult.responseCode;
                out.requestTryCount = this.httpRequest.getCount();
                AsyncHttpParameter asyncHttpParameter2 = this.inParameter;
                asyncHttpParameter2.out.headers = httpResult.headers;
                this.requestListener.onRequestResult(asyncHttpParameter2);
            }
            this.requestListener = null;
        }
        cancelTimeOut();
    }
}
