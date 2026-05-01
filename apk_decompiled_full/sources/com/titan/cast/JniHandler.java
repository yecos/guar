package com.titan.cast;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.hpplay.component.protocol.push.IPushHandler;
import com.titan.cast.bean.CastResult;
import com.titan.cast.bean.Device;
import org.json.JSONException;
import org.json.JSONObject;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class JniHandler {
    public static final a Companion = new a(null);
    private static f8.a mCastCallBack;
    private final Gson mGson = new Gson();
    private final String TAG = "CastJniHandler";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final String Callback(String str, String str2) {
        CastResult castResult = new CastResult(0, "");
        switch (str.hashCode()) {
            case -1864005230:
                if (str.equals("OnActionResult")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            String string = jSONObject.getString("session");
                            String string2 = jSONObject.getString("action");
                            int i10 = jSONObject.getInt("err");
                            i.f(string, "session");
                            i.f(string2, "action");
                            castResult = onActionResult(string, string2, i10);
                            break;
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                            castResult.setErr(22);
                            break;
                        }
                    }
                }
                castResult.setErr(2);
                break;
            case -251523458:
                if (str.equals("OnPlayState")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            String string3 = new JSONObject(str2).getString(IPushHandler.STATE);
                            i.f(string3, IPushHandler.STATE);
                            castResult = onPlayState(string3);
                            break;
                        } catch (JSONException e11) {
                            e11.printStackTrace();
                            castResult.setErr(22);
                            break;
                        }
                    }
                }
                castResult.setErr(2);
                break;
            case 1127897397:
                if (str.equals("OnDevice")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Device device = (Device) this.mGson.fromJson(new JSONObject(str2).getString(com.hpplay.cybergarage.upnp.Device.ELEM_NAME), Device.class);
                            i.f(device, "deviceInfo");
                            castResult = onDevice(device);
                            break;
                        } catch (JSONException e12) {
                            e12.printStackTrace();
                            castResult.setErr(22);
                            break;
                        }
                    } else {
                        castResult.setErr(22);
                        break;
                    }
                }
                castResult.setErr(2);
                break;
            case 1216256072:
                if (str.equals("OnPosition")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            castResult = onPosition(jSONObject2.getLong("duration"), jSONObject2.getLong("position"));
                            break;
                        } catch (JSONException e13) {
                            e13.printStackTrace();
                            castResult.setErr(22);
                            break;
                        }
                    }
                }
                castResult.setErr(2);
                break;
            case 1528533011:
                if (str.equals("OnReport")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(str2);
                            String string4 = jSONObject3.getString("event");
                            String string5 = jSONObject3.getString("data");
                            String string6 = jSONObject3.getString("extra");
                            i.f(string4, "event");
                            i.f(string5, "data");
                            i.f(string6, "extra");
                            castResult = onReport(string4, string5, string6);
                            break;
                        } catch (JSONException e14) {
                            e14.printStackTrace();
                            castResult.setErr(22);
                            break;
                        }
                    }
                }
                castResult.setErr(2);
                break;
            default:
                castResult.setErr(2);
                break;
        }
        String json = this.mGson.toJson(castResult);
        i.f(json, "mGson.toJson(result)");
        return json;
    }

    private final CastResult onActionResult(String str, String str2, int i10) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.b(str, str2, i10);
        }
        return castResult;
    }

    private final CastResult onDevice(Device device) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.d(device);
        }
        return castResult;
    }

    private final CastResult onPlayState(String str) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.a(str);
        }
        return castResult;
    }

    private final CastResult onPosition(long j10, long j11) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.e(j10, j11);
        }
        return castResult;
    }

    private final CastResult onReport(String str, String str2, String str3) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.c(str, str2, str3);
        }
        return castResult;
    }

    public final void setOnCastCallBack(f8.a aVar) {
        mCastCallBack = aVar;
    }
}
