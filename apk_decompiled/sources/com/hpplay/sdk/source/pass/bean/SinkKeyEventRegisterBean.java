package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SinkKeyEventRegisterBean extends BaseBean {
    private static final String TAG = "SinkKeyEventRegistBean";
    private final int regist;

    private SinkKeyEventRegisterBean(int i10, int i11) {
        this.manifestVer = i10;
        this.regist = i11;
    }

    public static SinkKeyEventRegisterBean createRegisterBean() {
        return new SinkKeyEventRegisterBean(1, 1);
    }

    public static SinkKeyEventRegisterBean createUnregisterBean() {
        return new SinkKeyEventRegisterBean(1, 0);
    }

    public static SinkKeyEventRegisterBean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new SinkKeyEventRegisterBean(jSONObject.optInt("manifestVer"), jSONObject.optInt("regist"));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("regist", this.regist);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
