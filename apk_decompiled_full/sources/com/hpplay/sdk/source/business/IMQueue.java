package com.hpplay.sdk.source.business;

import android.os.AsyncTask;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class IMQueue {
    private static final String TAG = "IMQueue";
    private static IMQueue sInstance;
    private ConcurrentLinkedQueue<Bean> mTaskQueue = new ConcurrentLinkedQueue<>();
    private AsyncTask mAsyncTask = null;

    public static class Bean {
        public AsyncHttpRequestListener listener;
        public AsyncHttpParameter parameter;
    }

    private IMQueue() {
    }

    public static synchronized IMQueue getInstance() {
        IMQueue iMQueue;
        synchronized (IMQueue.class) {
            if (sInstance == null) {
                sInstance = new IMQueue();
            }
            iMQueue = sInstance;
        }
        return iMQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trigTask() {
        final Bean poll;
        if (this.mAsyncTask == null && (poll = this.mTaskQueue.poll()) != null) {
            this.mAsyncTask = AsyncManager.getInstance().exeHttpTask(poll.parameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.IMQueue.1
                @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    AsyncHttpRequestListener asyncHttpRequestListener;
                    Bean bean = poll;
                    if (bean != null && (asyncHttpRequestListener = bean.listener) != null) {
                        asyncHttpRequestListener.onRequestResult(asyncHttpParameter);
                    }
                    IMQueue.this.mAsyncTask = null;
                    IMQueue.this.trigTask();
                }
            });
        }
    }

    public Bean addTask(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener) {
        Bean bean = new Bean();
        bean.parameter = asyncHttpParameter;
        bean.listener = asyncHttpRequestListener;
        this.mTaskQueue.offer(bean);
        trigTask();
        return bean;
    }

    public void clearTask() {
        this.mTaskQueue.clear();
        try {
            AsyncTask asyncTask = this.mAsyncTask;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.mAsyncTask = null;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void removeTask(Bean bean) {
        this.mTaskQueue.remove(bean);
    }
}
