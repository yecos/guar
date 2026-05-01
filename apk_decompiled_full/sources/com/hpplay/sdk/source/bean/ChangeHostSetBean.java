package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ChangeHostSetBean {
    public int action;
    public int manifestVer = 1;
    public String tu;
    public int value;

    public static ChangeHostSetBean formJson(String str) {
        try {
            ChangeHostSetBean changeHostSetBean = new ChangeHostSetBean();
            JSONObject jSONObject = new JSONObject(str);
            changeHostSetBean.manifestVer = jSONObject.optInt("manifestVer");
            changeHostSetBean.action = jSONObject.optInt("action");
            changeHostSetBean.value = jSONObject.optInt("value");
            changeHostSetBean.tu = jSONObject.optString("tu");
            return changeHostSetBean;
        } catch (Exception e10) {
            SourceLog.w("ChangeHostSetBean", e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("action", this.action);
            jSONObject.put("value", this.value);
            jSONObject.put("tu", this.tu);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w("ChangeHostSetBean", e10);
            return null;
        }
    }
}
