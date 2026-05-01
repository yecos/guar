package com.hpplay.common.asyncmanager;

import android.os.AsyncTask;
import com.hpplay.common.asyncmanager.AsyncUploadFileParameter;

/* loaded from: classes2.dex */
public class AsyncUploadFileJob extends AsyncTask {
    private String TAG = "AsyncUploadFileJob";
    public int id;
    private AsyncUploadFileParameter inParameter;
    private AsyncUploadFileListener requestListener;
    private UploadFileRequest uploadFileRequest;

    public AsyncUploadFileJob(AsyncUploadFileParameter asyncUploadFileParameter, AsyncUploadFileListener asyncUploadFileListener) {
        this.inParameter = asyncUploadFileParameter;
        this.requestListener = asyncUploadFileListener;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        AsyncUploadFileParameter.In in = this.inParameter.in;
        UploadFileRequest uploadFileRequest = new UploadFileRequest(in.url, in.localPath, in.headParameter, in.httpMethod);
        this.uploadFileRequest = uploadFileRequest;
        return uploadFileRequest.uploadFile();
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        AsyncUploadFileListener asyncUploadFileListener = this.requestListener;
        if (asyncUploadFileListener != null) {
            if (obj == null) {
                AsyncUploadFileParameter asyncUploadFileParameter = this.inParameter;
                asyncUploadFileParameter.out.resultType = 1;
                asyncUploadFileListener.onRequestResult(asyncUploadFileParameter);
            } else {
                AsyncUploadFileParameter.Out out = this.inParameter.out;
                out.resultType = 0;
                out.setResult(obj);
                this.requestListener.onRequestResult(this.inParameter);
            }
            this.requestListener = null;
        }
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Object[] objArr) {
        super.onProgressUpdate(objArr);
    }
}
