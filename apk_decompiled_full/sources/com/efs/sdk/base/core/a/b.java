package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends AbsHttpListener {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f6049a = new b(0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* bridge */ /* synthetic */ void a(com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        a(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(HttpResponse httpResponse) {
        f fVar;
        a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int parseInt = Integer.parseInt(str);
            fVar = f.a.f6196a;
            if (fVar.f6193b == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "config_coverage", fVar.f6192a.f6186c);
            bVar.put("cver", Integer.valueOf(parseInt));
            fVar.f6193b.send(bVar);
        }
    }

    private b() {
    }

    public static b a() {
        return a.f6049a;
    }

    private static void a(HttpResponse httpResponse) {
        f fVar;
        fVar = f.a.f6196a;
        fVar.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }
}
