package com.hpplay.sdk.source.browser.a;

import com.hpplay.common.log.LeLog;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f7447c = "ResPositionBean";

    /* renamed from: a, reason: collision with root package name */
    public int f7448a;

    /* renamed from: b, reason: collision with root package name */
    public List<a> f7449b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f7450a;

        /* renamed from: b, reason: collision with root package name */
        public String f7451b;

        /* renamed from: c, reason: collision with root package name */
        public String f7452c;

        /* renamed from: d, reason: collision with root package name */
        public int f7453d;

        /* renamed from: e, reason: collision with root package name */
        public int f7454e;

        /* renamed from: f, reason: collision with root package name */
        public int f7455f;

        /* renamed from: g, reason: collision with root package name */
        public int f7456g;

        /* renamed from: h, reason: collision with root package name */
        public String f7457h;

        /* renamed from: i, reason: collision with root package name */
        public String f7458i;

        /* renamed from: j, reason: collision with root package name */
        public String f7459j;
    }

    public static b a(String str) {
        JSONArray optJSONArray;
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f7448a = jSONObject.optInt(Constant.KEY_STATUS);
            optJSONArray = jSONObject.optJSONArray("data");
        } catch (Exception unused) {
            LeLog.w(f7447c, "formJson failed: " + str);
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            bVar.f7449b = new ArrayList();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.f7450a = optJSONObject.optString("sourceId");
                    aVar.f7451b = optJSONObject.optString("button");
                    aVar.f7452c = optJSONObject.optString("imageUrl");
                    aVar.f7453d = optJSONObject.optInt("noadTime");
                    aVar.f7454e = optJSONObject.optInt("adStasecond");
                    aVar.f7455f = optJSONObject.optInt("adEndsecond");
                    aVar.f7456g = optJSONObject.optInt("id");
                    aVar.f7457h = optJSONObject.optString(f.X);
                    aVar.f7458i = optJSONObject.optString("sourceName");
                    aVar.f7459j = optJSONObject.optString("url");
                    bVar.f7449b.add(aVar);
                }
            }
            return bVar;
        }
        return bVar;
    }
}
