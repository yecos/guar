package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.asyncmanager.AsyncFileParameter;
import com.hpplay.common.asyncmanager.FileRequest;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class AsyncFileJob extends AsyncTask {
    private String TAG = "AsyncFileJob";
    private FileRequest.DownloadListener downloadListener = new FileRequest.DownloadListener() { // from class: com.hpplay.common.asyncmanager.AsyncFileJob.1
        @Override // com.hpplay.common.asyncmanager.FileRequest.DownloadListener
        public void onDownLoad(int i10, long j10, long j11, int i11) {
            if (i11 == 0) {
                AsyncFileJob.this.publishProgress(Long.valueOf(j10), Long.valueOf(j11));
            }
        }
    };
    private AsyncFileParameter fileParameter;
    private FileRequest fileRequest;
    public int id;
    private AsyncFileRequestListener requestListener;

    public AsyncFileJob(AsyncFileParameter asyncFileParameter, AsyncFileRequestListener asyncFileRequestListener) {
        this.fileParameter = asyncFileParameter;
        this.requestListener = asyncFileRequestListener;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        AsyncFileParameter.In in = this.fileParameter.in;
        FileRequest fileRequest = new FileRequest(in.fileUrl, in.savePath);
        this.fileRequest = fileRequest;
        fileRequest.setDownloadListener(this.downloadListener);
        return Boolean.valueOf(this.fileRequest.download());
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        AsyncFileParameter asyncFileParameter;
        super.onCancelled();
        FileRequest fileRequest = this.fileRequest;
        if (fileRequest != null) {
            try {
                fileRequest.shutDown();
            } catch (Exception e10) {
                LeLog.w(this.TAG, e10);
            }
        }
        AsyncFileRequestListener asyncFileRequestListener = this.requestListener;
        if (asyncFileRequestListener == null || (asyncFileParameter = this.fileParameter) == null) {
            return;
        }
        asyncFileParameter.out.resultType = 6;
        asyncFileRequestListener.onDownloadFinish(asyncFileParameter);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        boolean z10;
        AsyncFileParameter asyncFileParameter;
        super.onPostExecute(obj);
        try {
            z10 = ((Boolean) obj).booleanValue();
        } catch (Exception e10) {
            LeLog.w(this.TAG, e10);
            z10 = false;
        }
        AsyncFileRequestListener asyncFileRequestListener = this.requestListener;
        if (asyncFileRequestListener == null || (asyncFileParameter = this.fileParameter) == null) {
            return;
        }
        asyncFileParameter.out.resultType = z10 ? 8 : 7;
        asyncFileRequestListener.onDownloadFinish(asyncFileParameter);
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Object[] objArr) {
        long j10;
        AsyncFileRequestListener asyncFileRequestListener;
        AsyncFileParameter asyncFileParameter;
        super.onProgressUpdate(objArr);
        long j11 = 0;
        try {
            j10 = Long.valueOf(objArr[0].toString()).longValue();
        } catch (Exception e10) {
            e = e10;
            j10 = 0;
        }
        try {
            j11 = Long.valueOf(objArr[1].toString()).longValue();
        } catch (Exception e11) {
            e = e11;
            LeLog.w(this.TAG, e);
            asyncFileRequestListener = this.requestListener;
            if (asyncFileRequestListener != null) {
                return;
            } else {
                return;
            }
        }
        asyncFileRequestListener = this.requestListener;
        if (asyncFileRequestListener != null || (asyncFileParameter = this.fileParameter) == null) {
            return;
        }
        AsyncFileParameter.Out out = asyncFileParameter.out;
        out.resultType = 5;
        out.currentSize = j10;
        out.totalSize = j11;
        asyncFileRequestListener.onDownloadUpdate(j10, j11);
    }
}
