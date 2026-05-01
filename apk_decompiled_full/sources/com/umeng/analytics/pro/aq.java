package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9892a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9893b = "https://cnlogs.umeng.com/ext_event";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9894c = "https://cnlogs.umeng.com/uapp_ekverr_logs";

    /* renamed from: d, reason: collision with root package name */
    private String f9895d;

    /* renamed from: e, reason: collision with root package name */
    private String f9896e;

    /* renamed from: f, reason: collision with root package name */
    private String f9897f;

    public aq(String str, JSONObject jSONObject) {
        this.f9897f = null;
        this.f9895d = str;
        this.f9896e = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f9896e)) {
                return;
            }
            ap.a(this.f9895d, this.f9896e.getBytes(), this.f9897f);
        } catch (Throwable unused) {
        }
    }

    public aq(String str, JSONObject jSONObject, String str2) {
        this.f9897f = null;
        this.f9895d = str;
        this.f9896e = jSONObject.toString();
        this.f9897f = str2;
    }
}
