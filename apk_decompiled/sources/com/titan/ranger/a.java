package com.titan.ranger;

import com.hpplay.component.protocol.push.IPushHandler;
import com.umeng.analytics.pro.bd;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes3.dex */
public abstract class a {
    public static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("entries", str);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bd.f9974a, str);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String c(int i10, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("name", str);
            jSONObject.put("data", str2);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String d(int i10, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("event", str);
            jSONObject.put("data", str2);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String e(int i10, long j10, long j11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("progress", j10);
            jSONObject.put("buffer", j11);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String f(int i10, String str, int i11, int i12, long j10, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("event", str);
            jSONObject.put("err", i11);
            jSONObject.put("extra", i12);
            jSONObject.put("data", j10);
            jSONObject.put(IPushHandler.REASON, str2);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String g(int i10, String str, String str2, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("operation", str);
            jSONObject.put("data", str2);
            jSONObject.put("err", i11);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String h(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("object", str);
            jSONObject.put("type", str2);
            jSONObject.put("event", str3);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String i(int i10, String str, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("player", str);
            jSONObject.put("err", i11);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String j(int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("name", str);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String k(int i10, String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("name", str);
            jSONObject.put("program", str2);
            jSONObject.put("extra", str3);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String l(int i10, String str, long j10, long j11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("name", str);
            jSONObject.put("moment", j10);
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, j11);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String m(int i10, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instance", i10);
            jSONObject.put("name", str);
            jSONObject.put("media", str2);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
