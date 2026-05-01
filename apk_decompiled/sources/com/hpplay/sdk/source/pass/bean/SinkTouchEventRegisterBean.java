package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SinkTouchEventRegisterBean extends BaseBean {
    private static final String TAG = "SinkTouchEventRegisterBean";
    private final int regist;

    private SinkTouchEventRegisterBean(int i10, int i11) {
        this.manifestVer = i10;
        this.regist = i11;
    }

    public static SinkTouchEventRegisterBean createRegisterBean() {
        return new SinkTouchEventRegisterBean(1, 1);
    }

    public static SinkTouchEventRegisterBean createUnregisterBean() {
        return new SinkTouchEventRegisterBean(1, 0);
    }

    public static SinkTouchEventRegisterBean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new SinkTouchEventRegisterBean(jSONObject.optInt("manifestVer"), jSONObject.optInt("regist"));
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
