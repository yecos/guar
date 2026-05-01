package com.loopj.android.http;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* loaded from: classes3.dex */
public interface ResponseHandlerInterface {
    Header[] getRequestHeaders();

    URI getRequestURI();

    Object getTag();

    boolean getUsePoolThread();

    boolean getUseSynchronousMode();

    void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse);

    void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse);

    void sendCancelMessage();

    void sendFailureMessage(int i10, Header[] headerArr, byte[] bArr, Throwable th);

    void sendFinishMessage();

    void sendProgressMessage(long j10, long j11);

    void sendResponseMessage(HttpResponse httpResponse);

    void sendRetryMessage(int i10);

    void sendStartMessage();

    void sendSuccessMessage(int i10, Header[] headerArr, byte[] bArr);

    void setRequestHeaders(Header[] headerArr);

    void setRequestURI(URI uri);

    void setTag(Object obj);

    void setUsePoolThread(boolean z10);

    void setUseSynchronousMode(boolean z10);
}
