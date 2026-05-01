package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class AsyncRunnableJob extends AsyncTask {
    private final String TAG = "AsyncRunnableJob";
    private Runnable runnable;
    private AsyncRunnableListener runnableListener;

    public AsyncRunnableJob(Runnable runnable, AsyncRunnableListener asyncRunnableListener) {
        this.runnable = runnable;
        this.runnableListener = asyncRunnableListener;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        try {
            this.runnable.run();
            return null;
        } catch (Exception e10) {
            LeLog.w("AsyncRunnableJob", e10);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        AsyncRunnableListener asyncRunnableListener = this.runnableListener;
        if (asyncRunnableListener != null) {
            asyncRunnableListener.onRunResult(2);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncRunnableListener asyncRunnableListener = this.runnableListener;
        if (asyncRunnableListener != null) {
            asyncRunnableListener.onRunResult(0);
        }
    }
}
