package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SinkKeyEventBean extends BaseBean {
    private static final String TAG = "SinkKeyEventBean";
    public final int action;
    public final int keyCode;

    private SinkKeyEventBean(int i10, int i11, int i12) {
        this.manifestVer = i10;
        this.keyCode = i11;
        this.action = i12;
    }

    public static SinkKeyEventBean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new SinkKeyEventBean(jSONObject.optInt("manifestVer"), jSONObject.optInt("keyCode"), jSONObject.optInt("action"));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("keyCode", this.keyCode);
            jSONObject.put("action", this.action);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
