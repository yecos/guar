package com.titan.ranger;

import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.titan.ranger.bean.RangerResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JniHandler {

    /* renamed from: a, reason: collision with root package name */
    public static a[] f9455a = new a[2];

    public interface a {
        int getInstance();

        int m(String str, String str2, long j10);

        int n(int i10, String str, String str2, String str3);

        int o(String str, String str2, int i10);

        int p(int i10, String str, Object obj, long j10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003d, code lost:
    
        if (r14.equals("OnPrepareEvent") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String Callback(String str, String str2) {
        char c10 = 0;
        RangerResult rangerResult = new RangerResult(0, "");
        str.hashCode();
        switch (str.hashCode()) {
            case -1086793358:
                break;
            case 1241495447:
                if (str.equals("SetPlayerUI")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 1528533011:
                if (str.equals("OnReport")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 2046860249:
                if (str.equals("OnPrefetchAd")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        rangerResult = b(jSONObject.getInt("instance"), jSONObject.getString("event"), (Status) m8.a.a().fromJson(jSONObject.getString(Constant.KEY_STATUS), Status.class), jSONObject.getLong("err"));
                        break;
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                        rangerResult.setErr(22);
                        break;
                    }
                } else {
                    rangerResult.setErr(22);
                    break;
                }
            case 1:
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        rangerResult = e(jSONObject2.getInt("instance"), jSONObject2.getString("object"), jSONObject2.getString("action"), jSONObject2.getInt("data"));
                        break;
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                        rangerResult.setErr(22);
                        break;
                    }
                } else {
                    rangerResult.setErr(22);
                    break;
                }
            case 2:
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str2);
                        rangerResult = c(jSONObject3.getInt("instance"), jSONObject3.getString("event"), jSONObject3.getString("data"), jSONObject3.getString("extra"));
                        break;
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        rangerResult.setErr(22);
                        break;
                    }
                } else {
                    rangerResult.setErr(22);
                    break;
                }
            case 3:
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(str2);
                        rangerResult = a(jSONObject4.getString("name"), jSONObject4.getString("path"), jSONObject4.getInt("err"));
                        break;
                    } catch (Exception e13) {
                        e13.printStackTrace();
                        rangerResult.setErr(22);
                        break;
                    }
                } else {
                    rangerResult.setErr(22);
                    break;
                }
            default:
                rangerResult.setErr(2);
                break;
        }
        return m8.a.a().toJson(rangerResult);
    }

    public static void d(int i10, a aVar) {
        f9455a[i10] = aVar;
    }

    public final RangerResult a(String str, String str2, long j10) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f9455a[0];
            if (aVar != null) {
                rangerResult.setErr(aVar.m(str, str2, j10));
            }
        }
        return rangerResult;
    }

    public final RangerResult b(int i10, String str, Object obj, long j10) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (obj instanceof Status) {
            a aVar = f9455a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.p(i10, str, (Status) obj, j10));
            }
        } else {
            rangerResult.setErr(22);
        }
        return rangerResult;
    }

    public final RangerResult c(int i10, String str, String str2, String str3) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f9455a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.n(i10, str, str2, str3));
            }
        }
        return rangerResult;
    }

    public final RangerResult e(int i10, String str, String str2, int i11) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f9455a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.o(str, str2, i11));
            }
        }
        return rangerResult;
    }
}
