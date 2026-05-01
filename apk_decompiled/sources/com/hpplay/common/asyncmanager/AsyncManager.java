package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class AsyncManager {
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;
    public static final int RESULT_CANCEL = 2;
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_FILE_DOWNLOADING = 5;
    public static final int RESULT_FILE_DOWNLOAD_CANCEL = 6;
    public static final int RESULT_FILE_DOWNLOAD_ERROR = 7;
    public static final int RESULT_FILE_DOWNLOAD_SUCCESS = 8;
    public static final int RESULT_INVALID_TYPE = 4;
    public static final int RESULT_NULL_URL = 3;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_UPLOAD_STATUS_BUSY = 2;
    public static final int RESULT_UPLOAD_STATUS_FAILED = 3;
    public static final int RESULT_UPLOAD_STATUS_SUCCESS = 1;
    private static final String TAG = "AsyncManager";
    private static AsyncManager instance = new AsyncManager();
    private final int MAX_SEMAPHORE = 15;
    private volatile Semaphore mSemaphore = new Semaphore(15, true);
    private volatile ConcurrentLinkedQueue<AsyncTask> mSemaphoreTaskList = new ConcurrentLinkedQueue<>();
    private volatile ConcurrentLinkedQueue<AsyncTask> mTaskList = new ConcurrentLinkedQueue<>();
    private boolean isDebug = false;
    private Executor executor = Executors.newCachedThreadPool();

    private AsyncManager() {
    }

    private AsyncHttpJob doGetRequest(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener, boolean z10) {
        AsyncHttpJob asyncHttpJob = new AsyncHttpJob(0, asyncHttpParameter, asyncHttpRequestListener) { // from class: com.hpplay.common.asyncmanager.AsyncManager.3
            @Override // com.hpplay.common.asyncmanager.AsyncHttpJob, android.os.AsyncTask
            public void onCancelled() {
                super.onCancelled();
                AsyncManager.this.releaseTask(this);
            }

            @Override // com.hpplay.common.asyncmanager.AsyncHttpJob, android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                AsyncManager.this.releaseTask(this);
            }
        };
        exeTask(asyncHttpJob, z10);
        return asyncHttpJob;
    }

    private AsyncHttpJob doPostRequest(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener, boolean z10) {
        AsyncHttpJob asyncHttpJob = new AsyncHttpJob(1, asyncHttpParameter, asyncHttpRequestListener) { // from class: com.hpplay.common.asyncmanager.AsyncManager.4
            @Override // com.hpplay.common.asyncmanager.AsyncHttpJob, android.os.AsyncTask
            public void onCancelled() {
                super.onCancelled();
                AsyncManager.this.releaseTask(this);
            }

            @Override // com.hpplay.common.asyncmanager.AsyncHttpJob, android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                AsyncManager.this.releaseTask(this);
            }
        };
        exeTask(asyncHttpJob, z10);
        return asyncHttpJob;
    }

    private AsyncFileJob downLoad(AsyncFileParameter asyncFileParameter, AsyncFileRequestListener asyncFileRequestListener, boolean z10) {
        AsyncFileJob asyncFileJob = new AsyncFileJob(asyncFileParameter, asyncFileRequestListener) { // from class: com.hpplay.common.asyncmanager.AsyncManager.5
            @Override // com.hpplay.common.asyncmanager.AsyncFileJob, android.os.AsyncTask
            public void onCancelled() {
                super.onCancelled();
                AsyncManager.this.releaseTask(this);
            }

            @Override // com.hpplay.common.asyncmanager.AsyncFileJob, android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                AsyncManager.this.releaseTask(this);
            }
        };
        exeTask(asyncFileJob, z10);
        return asyncFileJob;
    }

    private void exeTask(AsyncTask asyncTask, boolean z10) {
        if (z10) {
            try {
                asyncTask.executeOnExecutor(this.executor, new Object[0]);
                this.mTaskList.add(asyncTask);
            } catch (Exception e10) {
                LeLog.w(TAG, e10);
            }
        } else if (this.mSemaphore.tryAcquire()) {
            try {
                asyncTask.executeOnExecutor(this.executor, new Object[0]);
                this.mTaskList.add(asyncTask);
            } catch (Exception e11) {
                LeLog.w(TAG, e11);
                this.mSemaphore.release();
            }
        } else {
            LeLog.w(TAG, "exeTask parallel too many,wait amount. mSemaphore: " + this.mSemaphore);
            this.mSemaphoreTaskList.add(asyncTask);
        }
        printTaskDetail();
    }

    public static synchronized AsyncManager getInstance() {
        AsyncManager asyncManager;
        synchronized (AsyncManager.class) {
            asyncManager = instance;
        }
        return asyncManager;
    }

    private void printTaskDetail() {
        if (this.isDebug) {
            LeLog.i(TAG, "printTaskDetail running list zie :" + this.mTaskList.size() + "  waiting task size:" + this.mSemaphoreTaskList.size() + " Semaphore: " + this.mSemaphore.availablePermits());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTask(AsyncTask asyncTask) {
        AsyncTask poll;
        this.mSemaphore.release();
        try {
            if (this.mTaskList.contains(asyncTask)) {
                this.mTaskList.remove(asyncTask);
            }
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
        }
        printTaskDetail();
        if (this.mSemaphoreTaskList.size() <= 0 || this.mSemaphore.availablePermits() <= 0 || (poll = this.mSemaphoreTaskList.poll()) == null) {
            return;
        }
        exeTask(poll, false);
    }

    private AsyncUploadFileJob upload(AsyncUploadFileParameter asyncUploadFileParameter, AsyncUploadFileListener asyncUploadFileListener, boolean z10) {
        AsyncUploadFileJob asyncUploadFileJob = new AsyncUploadFileJob(asyncUploadFileParameter, asyncUploadFileListener) { // from class: com.hpplay.common.asyncmanager.AsyncManager.6
            @Override // com.hpplay.common.asyncmanager.AsyncUploadFileJob, android.os.AsyncTask
            public void onCancelled() {
                super.onCancelled();
                AsyncManager.this.releaseTask(this);
            }

            @Override // com.hpplay.common.asyncmanager.AsyncUploadFileJob, android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                AsyncManager.this.releaseTask(this);
            }
        };
        exeTask(asyncUploadFileJob, z10);
        return asyncUploadFileJob;
    }

    public void cancelAllTask() {
        LeLog.i(TAG, "cancelAllTask");
        try {
            Iterator<AsyncTask> it = this.mTaskList.iterator();
            while (it.hasNext()) {
                AsyncTask next = it.next();
                synchronized (this.mTaskList) {
                    try {
                        next.cancel(true);
                    } catch (Throwable unused) {
                        LeLog.w(TAG, "cancelAllTask waring in cancel asyncTask");
                    }
                }
            }
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
        }
        try {
            this.mSemaphore.release(15);
        } catch (Exception unused2) {
            LeLog.w(TAG, "release semaphore waring in cancel asyncTask");
        }
    }

    public AsyncCallableJob exeCallable(Callable callable, AsyncCallableListener asyncCallableListener) {
        return exeCallable(callable, asyncCallableListener, false);
    }

    public AsyncCallableJob exeCallableWithoutParallel(Callable callable, AsyncCallableListener asyncCallableListener) {
        return exeCallable(callable, asyncCallableListener, true);
    }

    public AsyncFileJob exeFileTask(AsyncFileParameter asyncFileParameter, AsyncFileRequestListener asyncFileRequestListener) {
        return exeFileTask(asyncFileParameter, asyncFileRequestListener, false);
    }

    public AsyncFileJob exeFileTaskWithoutParallel(AsyncFileParameter asyncFileParameter, AsyncFileRequestListener asyncFileRequestListener) {
        return exeFileTask(asyncFileParameter, asyncFileRequestListener, true);
    }

    public AsyncHttpJob exeHttpTask(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener) {
        return exeHttpTask(asyncHttpParameter, asyncHttpRequestListener, false);
    }

    public AsyncHttpJob exeHttpTaskWithoutParallel(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener) {
        return exeHttpTask(asyncHttpParameter, asyncHttpRequestListener, true);
    }

    public AsyncRunnableJob exeRunnable(Runnable runnable, AsyncRunnableListener asyncRunnableListener) {
        return exeRunnable(runnable, asyncRunnableListener, false);
    }

    public AsyncRunnableJob exeRunnableWithoutParallel(Runnable runnable, AsyncRunnableListener asyncRunnableListener) {
        return exeRunnable(runnable, asyncRunnableListener, true);
    }

    public AsyncUploadFileJob exeUploadFileTask(AsyncUploadFileParameter asyncUploadFileParameter, AsyncUploadFileListener asyncUploadFileListener) {
        return exeUploadFileTask(asyncUploadFileParameter, asyncUploadFileListener, false);
    }

    public AsyncUploadFileJob exeUploadFileTaskWithoutParallel(AsyncUploadFileParameter asyncUploadFileParameter, AsyncUploadFileListener asyncUploadFileListener) {
        return exeUploadFileTask(asyncUploadFileParameter, asyncUploadFileListener, true);
    }

    public int getCachedTaskSize() {
        return this.mSemaphoreTaskList.size();
    }

    public int getTaskSize() {
        return this.mTaskList.size();
    }

    public void setDebug(boolean z10) {
        this.isDebug = z10;
    }

    private AsyncCallableJob exeCallable(Callable callable, AsyncCallableListener asyncCallableListener, boolean z10) {
        AsyncCallableJob asyncCallableJob = new AsyncCallableJob(callable, asyncCallableListener) { // from class: com.hpplay.common.asyncmanager.AsyncManager.2
            @Override // com.hpplay.common.asyncmanager.AsyncCallableJob, android.os.AsyncTask
            public void onCancelled() {
                super.onCancelled();
                AsyncManager.this.releaseTask(this);
            }

            @Override // com.hpplay.common.asyncmanager.AsyncCallableJob, android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                AsyncManager.this.releaseTask(this);
            }
        };
        exeTask(asyncCallableJob, z10);
        return asyncCallableJob;
    }

    private AsyncFileJob exeFileTask(AsyncFileParameter asyncFileParameter, AsyncFileRequestListener asyncFileRequestListener, boolean z10) {
        if (asyncFileParameter == null) {
            return null;
        }
        if (!TextUtils.isEmpty(asyncFileParameter.in.fileUrl)) {
            return downLoad(asyncFileParameter, asyncFileRequestListener, z10);
        }
        if (asyncFileRequestListener != null) {
            asyncFileParameter.out.resultType = 3;
            asyncFileRequestListener.onDownloadFinish(asyncFileParameter);
        }
        return null;
    }

    private AsyncHttpJob exeHttpTask(AsyncHttpParameter asyncHttpParameter, AsyncHttpRequestListener asyncHttpRequestListener, boolean z10) {
        if (asyncHttpParameter == null) {
            return null;
        }
        LeLog.i(TAG, "exeHttpTask  url=" + asyncHttpParameter.in.requestUrl);
        if (!TextUtils.isEmpty(asyncHttpParameter.in.requestUrl)) {
            return asyncHttpParameter.in.requestMethod == 1 ? doPostRequest(asyncHttpParameter, asyncHttpRequestListener, z10) : doGetRequest(asyncHttpParameter, asyncHttpRequestListener, z10);
        }
        if (asyncHttpRequestListener != null) {
            asyncHttpParameter.out.resultType = 3;
            asyncHttpRequestListener.onRequestResult(asyncHttpParameter);
        }
        return null;
    }

    private AsyncRunnableJob exeRunnable(Runnable runnable, AsyncRunnableListener asyncRunnableListener, boolean z10) {
        AsyncRunnableJob asyncRunnableJob = new AsyncRunnableJob(runnable, asyncRunnableListener) { // from class: com.hpplay.common.asyncmanager.AsyncManager.1
            @Override // com.hpplay.common.asyncmanager.AsyncRunnableJob, android.os.AsyncTask
            public void onCancelled() {
                super.onCancelled();
                AsyncManager.this.releaseTask(this);
            }

            @Override // com.hpplay.common.asyncmanager.AsyncRunnableJob, android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                AsyncManager.this.releaseTask(this);
            }
        };
        exeTask(asyncRunnableJob, z10);
        return asyncRunnableJob;
    }

    private AsyncUploadFileJob exeUploadFileTask(AsyncUploadFileParameter asyncUploadFileParameter, AsyncUploadFileListener asyncUploadFileListener, boolean z10) {
        if (asyncUploadFileParameter == null) {
            return null;
        }
        LeLog.i(TAG, "exeHttpTask  url=" + asyncUploadFileParameter.in.url);
        if (!TextUtils.isEmpty(asyncUploadFileParameter.in.url)) {
            return upload(asyncUploadFileParameter, asyncUploadFileListener, z10);
        }
        if (asyncUploadFileListener != null) {
            asyncUploadFileParameter.out.resultType = 3;
            asyncUploadFileListener.onRequestResult(asyncUploadFileParameter);
        }
        return null;
    }
}
