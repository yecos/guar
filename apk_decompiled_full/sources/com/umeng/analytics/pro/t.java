package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10560a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f10561b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10562c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10563d = 3;

    /* renamed from: e, reason: collision with root package name */
    private final long f10564e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final t f10565a = new t();

        private a() {
        }
    }

    public static t a() {
        return a.f10565a;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", aa.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(f.f10334p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public void b(JSONObject jSONObject, Context context) {
        int a10 = a(context);
        if (a10 == 1) {
            if (jSONObject.has(f.L)) {
                jSONObject.remove(f.L);
            }
            if (jSONObject.has(f.f10332n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(f.f10332n);
                    int length = jSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        if (jSONObject2.has(f.aA)) {
                            jSONObject2.remove(f.aA);
                        }
                        if (jSONObject2.has(f.aB)) {
                            jSONObject2.remove(f.aB);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            k.a(context).a(false, true);
            return;
        }
        if (a10 == 2) {
            if (jSONObject.has(f.L)) {
                jSONObject.remove(f.L);
            }
            if (jSONObject.has(f.f10332n)) {
                jSONObject.remove(f.f10332n);
            }
            try {
                jSONObject.put(f.f10332n, c());
            } catch (Exception unused2) {
            }
            k.a(context).a(false, true);
            return;
        }
        if (a10 == 3) {
            if (jSONObject.has(f.L)) {
                jSONObject.remove(f.L);
            }
            jSONObject.remove(f.f10332n);
            k.a(context).a(false, true);
        }
    }

    private t() {
        this.f10564e = 60000L;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z10) {
        if (!z10 && jSONObject.has(f.f10332n)) {
            jSONObject.remove(f.f10332n);
        }
        if (jSONObject.has(f.L)) {
            jSONObject.remove(f.L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(f.Z)) {
            jSONObject.remove(f.Z);
        }
        if (jSONObject.has(f.L)) {
            jSONObject.remove(f.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int a10 = a(context);
        if (a10 == 1) {
            a(jSONObject, true);
            k.a(context).b(false, true);
        } else {
            if (a10 == 2) {
                jSONObject.remove(f.f10332n);
                try {
                    jSONObject.put(f.f10332n, b());
                } catch (Exception unused) {
                }
                a(jSONObject, true);
                k.a(context).b(false, true);
                return;
            }
            if (a10 == 3) {
                a(jSONObject, false);
                k.a(context).b(false, true);
            }
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", aa.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(f.f10334p, currentTimeMillis);
            jSONObject.put(f.f10335q, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
