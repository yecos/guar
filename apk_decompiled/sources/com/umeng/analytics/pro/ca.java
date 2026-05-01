package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10154a = "HttpClient";

    /* renamed from: f, reason: collision with root package name */
    private static HostnameVerifier f10155f;

    /* renamed from: b, reason: collision with root package name */
    private String f10156b;

    /* renamed from: c, reason: collision with root package name */
    private a f10157c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f10158d;

    /* renamed from: e, reason: collision with root package name */
    private cb f10159e;

    public enum a {
        POST,
        GET
    }

    public ca(String str, a aVar, Map<String, String> map, cb cbVar) {
        this.f10156b = str;
        this.f10157c = aVar;
        this.f10158d = map;
        this.f10159e = cbVar;
    }

    private static HostnameVerifier a() {
        if (f10155f == null) {
            f10155f = new HostnameVerifier() { // from class: com.umeng.analytics.pro.ca.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return !TextUtils.isEmpty(str) && by.f10131a.equalsIgnoreCase(str);
                }
            };
        }
        return f10155f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ef, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e5, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e0, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        if (r1 == null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ca.a(int, java.lang.String):java.lang.String");
    }
}
