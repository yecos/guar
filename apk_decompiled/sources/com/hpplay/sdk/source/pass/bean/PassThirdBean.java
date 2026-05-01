package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PassThirdBean extends BaseBean {
    public String appID;
    public Object data;

    public PassThirdBean() {
        this.manifestVer = 1;
    }

    public static PassThirdBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            PassThirdBean passThirdBean = new PassThirdBean();
            passThirdBean.manifestVer = jSONObject.optInt("manifestVer");
            passThirdBean.appID = jSONObject.optString("appID");
            passThirdBean.data = jSONObject.optString("data");
            return passThirdBean;
        } catch (Exception e10) {
            SourceLog.w("PassThirdBean", e10);
            return null;
        }
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("appID", this.appID);
            jSONObject.put("data", this.data.toString());
            return jSONObject;
        } catch (Exception e10) {
            SourceLog.w("PassThirdBean", e10);
            return null;
        }
    }
}
