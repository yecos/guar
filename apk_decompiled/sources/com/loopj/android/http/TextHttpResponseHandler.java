package com.loopj.android.http;

import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

/* loaded from: classes3.dex */
public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "TextHttpRH";

    public TextHttpResponseHandler() {
        this("UTF-8");
    }

    public static String getResponseString(byte[] bArr, String str) {
        String str2;
        if (bArr == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(bArr, str);
            } catch (UnsupportedEncodingException e10) {
                AsyncHttpClient.log.e(LOG_TAG, "Encoding response into string failed", e10);
                return null;
            }
        }
        return (str2 == null || !str2.startsWith(AsyncHttpResponseHandler.UTF8_BOM)) ? str2 : str2.substring(1);
    }

    public abstract void onFailure(int i10, Header[] headerArr, String str, Throwable th);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i10, headerArr, getResponseString(bArr, getCharset()), th);
    }

    public abstract void onSuccess(int i10, Header[] headerArr, String str);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int i10, Header[] headerArr, byte[] bArr) {
        onSuccess(i10, headerArr, getResponseString(bArr, getCharset()));
    }

    public TextHttpResponseHandler(String str) {
        setCharset(str);
    }
}
