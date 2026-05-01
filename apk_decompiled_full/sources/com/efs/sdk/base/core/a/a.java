package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile long f6046b = -1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6047a;

    /* renamed from: com.efs.sdk.base.core.a.a$a, reason: collision with other inner class name */
    public static class C0092a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f6048a = new a(0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a a() {
        return C0092a.f6048a;
    }

    public static long b() {
        return f6046b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + f6046b;
    }

    private a() {
        this.f6047a = true;
    }

    public final HttpResponse a(String str, c cVar, File file, boolean z10) {
        String b10 = cVar.b();
        String a10 = a(str, cVar);
        if (this.f6047a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(a10)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b10);
        com.efs.sdk.base.core.util.a.d a11 = new com.efs.sdk.base.core.util.a.d(a10).a(hashMap);
        a11.f6235a.f6230d = file;
        com.efs.sdk.base.core.util.a.d a12 = a11.a("type", cVar.f6057h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f6064o);
        return a12.a("size", sb.toString()).a("flow_limit", Boolean.toString(z10)).a(d.a()).a().b();
    }

    public final HttpResponse a(String str, c cVar, byte[] bArr, boolean z10) {
        String b10 = cVar.b();
        String a10 = a(str, cVar);
        if (this.f6047a) {
            Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(a10)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b10);
        com.efs.sdk.base.core.util.a.d a11 = new com.efs.sdk.base.core.util.a.d(a10).a(hashMap);
        com.efs.sdk.base.core.util.a.b bVar = a11.f6235a;
        bVar.f6229c = bArr;
        bVar.f6233g = true;
        com.efs.sdk.base.core.util.a.d a12 = a11.a("type", cVar.f6057h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f6064o);
        return a12.a("size", sb.toString()).a("flow_limit", Boolean.toString(z10)).a(d.a()).a().b();
    }

    private static String a(String str, c cVar) {
        byte b10 = cVar.f6056g;
        return str + (b10 != 1 ? b10 != 2 ? b10 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs");
    }

    public static void a(HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String optString = jSONObject.optString(Constants.KEY_HTTP_CODE, "-1");
            httpResponse.setBizCode(optString);
            if (!"0".equals(optString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j10 = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j10 - b()) > 1500000) {
                f6046b = j10 - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }
}
