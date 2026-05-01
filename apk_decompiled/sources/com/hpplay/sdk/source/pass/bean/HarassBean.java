package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HarassBean extends BaseBean {
    private static final String TAG = "HarassBean";
    public String code;
    public int timeout;

    public static HarassBean formJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HarassBean harassBean = new HarassBean();
            harassBean.manifestVer = jSONObject.optInt("manifestVer");
            harassBean.timeout = jSONObject.optInt("timeout");
            harassBean.code = jSONObject.optString(Constants.KEY_HTTP_CODE);
            return harassBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, "case = " + e10.getCause() + ", msg = " + e10.getMessage());
            return null;
        }
    }

    private String makeJson(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("timeout", i10);
            jSONObject.put(Constants.KEY_HTTP_CODE, this.code);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return "";
        }
    }
}
