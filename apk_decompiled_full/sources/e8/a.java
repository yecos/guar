package e8;

import com.hpplay.cybergarage.upnp.Device;
import com.umeng.analytics.pro.bd;
import org.json.JSONException;
import org.json.JSONObject;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12958a = new a();

    public final String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bd.f9974a, str);
            String jSONObject2 = jSONObject.toString();
            i.f(jSONObject2, "`object`.toString()");
            return jSONObject2;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String b(String str, long j10) {
        i.g(str, "session");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session", str);
            jSONObject.put("position", j10);
            String jSONObject2 = jSONObject.toString();
            i.f(jSONObject2, "`object`.toString()");
            return jSONObject2;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String c(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Device.ELEM_NAME, str);
            String jSONObject2 = jSONObject.toString();
            i.f(jSONObject2, "`object`.toString()");
            return jSONObject2;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String d(String str, String str2, String str3) {
        i.g(str, "session");
        i.g(str3, "extra");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session", str);
            jSONObject.put("media", str2);
            jSONObject.put("extra", str3);
            String jSONObject2 = jSONObject.toString();
            i.f(jSONObject2, "`object`.toString()");
            return jSONObject2;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String e(String str) {
        i.g(str, "session");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session", str);
            String jSONObject2 = jSONObject.toString();
            i.f(jSONObject2, "`object`.toString()");
            return jSONObject2;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
