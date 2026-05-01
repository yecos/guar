package com.taobao.accs.utl;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class p {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        JSONObject f9377a = new JSONObject();

        public a a(String str, String str2) {
            if (str2 != null && str != null) {
                try {
                    this.f9377a.put(str, str2);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        public a a(String str, Integer num) {
            if (num == null) {
                return this;
            }
            try {
                this.f9377a.put(str, num);
            } catch (JSONException unused) {
            }
            return this;
        }

        public a a(String str, Long l10) {
            if (l10 == null) {
                return this;
            }
            try {
                this.f9377a.put(str, l10);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JSONObject a() {
            return this.f9377a;
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        return jSONObject == null ? str2 : jSONObject.has(str) ? jSONObject.getString(str) : str2;
    }
}
