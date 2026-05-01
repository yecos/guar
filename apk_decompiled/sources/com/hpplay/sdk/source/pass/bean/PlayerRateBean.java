package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PlayerRateBean extends BaseBean {
    private static final String TAG = "PlayerRateBean";
    public float rate;

    public static PlayerRateBean formJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            PlayerRateBean playerRateBean = new PlayerRateBean();
            playerRateBean.manifestVer = jSONObject.optInt("manifestVer");
            playerRateBean.rate = Float.valueOf(jSONObject.optString("rate")).floatValue();
            return playerRateBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private String makeJson(float f10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("rate", f10);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return "";
        }
    }
}
