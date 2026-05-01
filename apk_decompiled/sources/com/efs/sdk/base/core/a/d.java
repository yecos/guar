package com.efs.sdk.base.core.a;

import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends AbsHttpListener {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f6065a = new d(0);
    }

    public /* synthetic */ d(byte b10) {
        this();
    }

    private static void b(HttpResponse httpResponse) {
        f fVar;
        fVar = f.a.f6196a;
        fVar.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    private static void c(HttpResponse httpResponse) {
        int parseInt;
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (!TextUtils.isEmpty(str) && (parseInt = Integer.parseInt(str)) > com.efs.sdk.base.core.config.remote.b.a().f6151d.mConfigVersion) {
                com.efs.sdk.base.core.config.remote.b.a().a(parseInt);
            }
        }
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* synthetic */ void a(com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.util.a.b bVar = (com.efs.sdk.base.core.util.a.b) cVar;
            ((Map) httpResponse2.extra).putAll(bVar.f6232f);
            bVar.f6232f.clear();
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(HttpResponse httpResponse) {
        a(httpResponse);
        if (httpResponse == null) {
            return;
        }
        b(httpResponse);
        c(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(HttpResponse httpResponse) {
        int i10;
        f fVar;
        if (!((Map) httpResponse.extra).containsKey("flow_limit") || !Boolean.FALSE.toString().equals(((Map) httpResponse.extra).get("flow_limit"))) {
            String str = ((Map) httpResponse.extra).containsKey("type") ? (String) ((Map) httpResponse.extra).get("type") : "";
            if (((Map) httpResponse.extra).containsKey("size")) {
                String str2 = (String) ((Map) httpResponse.extra).get("size");
                if (!TextUtils.isEmpty(str2)) {
                    i10 = Integer.parseInt(str2);
                    com.efs.sdk.base.core.b.c a10 = com.efs.sdk.base.core.b.c.a();
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i10;
                    a10.sendMessage(obtain);
                }
            }
            i10 = 0;
            com.efs.sdk.base.core.b.c a102 = com.efs.sdk.base.core.b.c.a();
            Message obtain2 = Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i10;
            a102.sendMessage(obtain2);
        }
        b(httpResponse);
        fVar = f.a.f6196a;
        fVar.f6194c.f6187b.incrementAndGet();
        c(httpResponse);
        a(httpResponse);
    }

    private d() {
    }

    public static d a() {
        return a.f6065a;
    }

    private static void a(HttpResponse httpResponse) {
        String str;
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (httpResponse == null) {
                str = "upload result : false";
            } else {
                str = "upload result : " + httpResponse.succ + ", resp is " + httpResponse.toString();
            }
            Log.i("efs.px.api", str);
        }
    }
}
