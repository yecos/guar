package com.loopj.android.http;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

/* loaded from: classes3.dex */
public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    private static final String LOG_TAG = "RangeFileAsyncHttpRH";
    private boolean append;
    private long current;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
        this.current = 0L;
        this.append = false;
    }

    @Override // com.loopj.android.http.FileAsyncHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    public byte[] getResponseData(HttpEntity httpEntity) {
        int read;
        if (httpEntity == null) {
            return null;
        }
        InputStream content = httpEntity.getContent();
        long contentLength = httpEntity.getContentLength() + this.current;
        FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
        if (content == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (this.current < contentLength && (read = content.read(bArr)) != -1 && !Thread.currentThread().isInterrupted()) {
                this.current += read;
                fileOutputStream.write(bArr, 0, read);
                sendProgressMessage(this.current, contentLength);
            }
            return null;
        } finally {
            content.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse httpResponse) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine.getStatusCode() == 416) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null);
            return;
        }
        if (statusLine.getStatusCode() >= 300) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
        } else {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            Header firstHeader = httpResponse.getFirstHeader("Content-Range");
            if (firstHeader == null) {
                this.append = false;
                this.current = 0L;
            } else {
                AsyncHttpClient.log.v(LOG_TAG, "Content-Range: " + firstHeader.getValue());
            }
            sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), getResponseData(httpResponse.getEntity()));
        }
    }

    public void updateRequestHeaders(HttpUriRequest httpUriRequest) {
        if (this.file.exists() && this.file.canWrite()) {
            this.current = this.file.length();
        }
        if (this.current > 0) {
            this.append = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.current + Operator.Operation.MINUS);
        }
    }
}
