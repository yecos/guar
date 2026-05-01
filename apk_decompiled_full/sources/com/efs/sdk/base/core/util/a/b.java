package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<HttpResponse> {

    /* renamed from: a, reason: collision with root package name */
    String f6227a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, String> f6228b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f6229c;

    /* renamed from: d, reason: collision with root package name */
    public File f6230d;

    /* renamed from: e, reason: collision with root package name */
    public String f6231e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f6232f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6233g = false;

    @Override // com.efs.sdk.base.core.util.concurrent.c
    public final /* synthetic */ HttpResponse a() {
        String str = this.f6231e;
        str.hashCode();
        if (str.equals("get")) {
            return HttpEnv.getInstance().getHttpUtil().get(this.f6227a, this.f6228b);
        }
        if (str.equals("post")) {
            byte[] bArr = this.f6229c;
            return (bArr == null || bArr.length <= 0) ? HttpEnv.getInstance().getHttpUtil().post(this.f6227a, this.f6228b, this.f6230d) : this.f6233g ? HttpEnv.getInstance().getHttpUtil().postAsFile(this.f6227a, this.f6228b, this.f6229c) : HttpEnv.getInstance().getHttpUtil().post(this.f6227a, this.f6228b, this.f6229c);
        }
        Log.e("efs.util.http", "request not support method '" + this.f6231e + "'");
        return null;
    }
}
