package com.alibaba.sdk.android.httpdns;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes.dex */
class g {

    /* renamed from: b, reason: collision with root package name */
    private int f5905b;

    /* renamed from: e, reason: collision with root package name */
    private String f5906e;

    public g(int i10, String str) {
        this.f5905b = i10;
        this.f5906e = new JSONObject(str).getString(Constants.KEY_HTTP_CODE);
    }

    public String b() {
        return this.f5906e;
    }

    public int getErrorCode() {
        return this.f5905b;
    }
}
