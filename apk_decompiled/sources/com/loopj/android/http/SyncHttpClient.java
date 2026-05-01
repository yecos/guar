package com.loopj.android.http;

import android.content.Context;
import com.taobao.accs.common.Constants;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
public class SyncHttpClient extends AsyncHttpClient {
    public SyncHttpClient() {
        super(false, 80, Constants.PORT);
    }

    @Override // com.loopj.android.http.AsyncHttpClient
    public RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        responseHandlerInterface.setUseSynchronousMode(true);
        newAsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, str, responseHandlerInterface, context).run();
        return new RequestHandle(null);
    }

    public SyncHttpClient(int i10) {
        super(false, i10, Constants.PORT);
    }

    public SyncHttpClient(int i10, int i11) {
        super(false, i10, i11);
    }

    public SyncHttpClient(boolean z10, int i10, int i11) {
        super(z10, i10, i11);
    }

    public SyncHttpClient(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }
}
