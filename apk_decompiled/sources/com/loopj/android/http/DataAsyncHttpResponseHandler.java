package com.loopj.android.http;

import android.os.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

/* loaded from: classes3.dex */
public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "DataAsyncHttpRH";
    protected static final int PROGRESS_DATA_MESSAGE = 7;

    public static byte[] copyOfRange(byte[] bArr, int i10, int i11) {
        if (i10 > i11) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i10 < 0 || i10 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = i11 - i10;
        int min = Math.min(i12, length - i10);
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, min);
        return bArr2;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public byte[] getResponseData(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength > TTL.MAX_VALUE) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (contentLength < 0) {
            contentLength = 4096;
        }
        try {
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) contentLength);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    byteArrayBuffer.append(bArr, 0, read);
                    sendProgressDataMessage(copyOfRange(bArr, 0, read));
                    sendProgressMessage(0, contentLength);
                }
                AsyncHttpClient.silentCloseInputStream(content);
                return byteArrayBuffer.toByteArray();
            } catch (Throwable th) {
                AsyncHttpClient.silentCloseInputStream(content);
                throw th;
            }
        } catch (OutOfMemoryError unused) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
        }
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 7) {
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr == null || objArr.length < 1) {
            AsyncHttpClient.log.e(LOG_TAG, "PROGRESS_DATA_MESSAGE didn't got enough params");
            return;
        }
        try {
            onProgressData((byte[]) objArr[0]);
        } catch (Throwable th) {
            AsyncHttpClient.log.e(LOG_TAG, "custom onProgressData contains an error", th);
        }
    }

    public void onProgressData(byte[] bArr) {
        AsyncHttpClient.log.d(LOG_TAG, "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte[] bArr) {
        sendMessage(obtainMessage(7, new Object[]{bArr}));
    }
}
