package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.log.LeLog;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class AsyncCallableJob extends AsyncTask {
    private final String TAG = "AsyncCallableJob";
    private Callable callable;
    private AsyncCallableListener callableListener;

    public AsyncCallableJob(Callable callable, AsyncCallableListener asyncCallableListener) {
        this.callable = callable;
        this.callableListener = asyncCallableListener;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        try {
            return this.callable.call();
        } catch (Exception e10) {
            LeLog.w("AsyncCallableJob", e10);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        AsyncCallableListener asyncCallableListener = this.callableListener;
        if (asyncCallableListener != null) {
            asyncCallableListener.onCallResult(2, null);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncCallableListener asyncCallableListener = this.callableListener;
        if (asyncCallableListener != null) {
            if (obj == null) {
                asyncCallableListener.onCallResult(1, null);
            } else {
                asyncCallableListener.onCallResult(0, obj);
            }
        }
    }
}
