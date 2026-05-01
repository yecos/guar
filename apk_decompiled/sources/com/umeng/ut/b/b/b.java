package com.umeng.ut.b.b;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class b {

    /* renamed from: d, reason: collision with root package name */
    int f12378d = -1;

    public static boolean a(int i10) {
        return i10 >= 0 && i10 != 10012;
    }

    public static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has(Constants.KEY_HTTP_CODE)) {
                bVar.f12378d = jSONObject2.getInt(Constants.KEY_HTTP_CODE);
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("id") && jSONObject.has("d_ts")) {
                d.a(com.umeng.ut.a.a.a().m69a()).a(jSONObject.getString("id"), jSONObject.getLong("d_ts"));
            }
            com.umeng.ut.a.c.e.m72a("BizResponse", "content", str);
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.m72a("", th.toString());
        }
        return bVar;
    }
}
