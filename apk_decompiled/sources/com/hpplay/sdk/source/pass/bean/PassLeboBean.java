package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PassLeboBean extends BaseBean {
    public Object data;

    public PassLeboBean() {
        this.manifestVer = 1;
    }

    public static PassLeboBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            PassLeboBean passLeboBean = new PassLeboBean();
            passLeboBean.manifestVer = jSONObject.optInt("manifestVer");
            passLeboBean.data = jSONObject.optString("data");
            return passLeboBean;
        } catch (Exception e10) {
            SourceLog.w("PassThirdBean", e10);
            return null;
        }
    }
}
