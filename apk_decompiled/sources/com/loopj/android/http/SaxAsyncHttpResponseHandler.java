package com.loopj.android.http;

import org.apache.http.Header;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes3.dex */
public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "SaxAsyncHttpRH";
    private T handler;

    public SaxAsyncHttpResponseHandler(T t10) {
        this.handler = null;
        if (t10 == null) {
            throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
        }
        this.handler = t10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r4 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r4 == null) goto L35;
     */
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] getResponseData(org.apache.http.HttpEntity r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getResponseData exception"
            java.lang.String r1 = "SaxAsyncHttpRH"
            r2 = 0
            if (r7 == 0) goto L61
            java.io.InputStream r7 = r7.getContent()
            if (r7 == 0) goto L61
            javax.xml.parsers.SAXParserFactory r3 = javax.xml.parsers.SAXParserFactory.newInstance()     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            javax.xml.parsers.SAXParser r3 = r3.newSAXParser()     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            org.xml.sax.XMLReader r3 = r3.getXMLReader()     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            T extends org.xml.sax.helpers.DefaultHandler r4 = r6.handler     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            r3.setContentHandler(r4)     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            java.lang.String r5 = r6.getCharset()     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            r4.<init>(r7, r5)     // Catch: java.lang.Throwable -> L3a javax.xml.parsers.ParserConfigurationException -> L3c org.xml.sax.SAXException -> L49
            org.xml.sax.InputSource r5 = new org.xml.sax.InputSource     // Catch: javax.xml.parsers.ParserConfigurationException -> L36 org.xml.sax.SAXException -> L38 java.lang.Throwable -> L56
            r5.<init>(r4)     // Catch: javax.xml.parsers.ParserConfigurationException -> L36 org.xml.sax.SAXException -> L38 java.lang.Throwable -> L56
            r3.parse(r5)     // Catch: javax.xml.parsers.ParserConfigurationException -> L36 org.xml.sax.SAXException -> L38 java.lang.Throwable -> L56
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
        L32:
            r4.close()     // Catch: java.io.IOException -> L61
            goto L61
        L36:
            r3 = move-exception
            goto L3e
        L38:
            r3 = move-exception
            goto L4b
        L3a:
            r0 = move-exception
            goto L58
        L3c:
            r3 = move-exception
            r4 = r2
        L3e:
            com.loopj.android.http.LogInterface r5 = com.loopj.android.http.AsyncHttpClient.log     // Catch: java.lang.Throwable -> L56
            r5.e(r1, r0, r3)     // Catch: java.lang.Throwable -> L56
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
            if (r4 == 0) goto L61
            goto L32
        L49:
            r3 = move-exception
            r4 = r2
        L4b:
            com.loopj.android.http.LogInterface r5 = com.loopj.android.http.AsyncHttpClient.log     // Catch: java.lang.Throwable -> L56
            r5.e(r1, r0, r3)     // Catch: java.lang.Throwable -> L56
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
            if (r4 == 0) goto L61
            goto L32
        L56:
            r0 = move-exception
            r2 = r4
        L58:
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r7)
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L60
        L60:
            throw r0
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.SaxAsyncHttpResponseHandler.getResponseData(org.apache.http.HttpEntity):byte[]");
    }

    public abstract void onFailure(int i10, Header[] headerArr, T t10);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i10, headerArr, this.handler);
    }

    public abstract void onSuccess(int i10, Header[] headerArr, T t10);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int i10, Header[] headerArr, byte[] bArr) {
        onSuccess(i10, headerArr, (Header[]) this.handler);
    }
}
