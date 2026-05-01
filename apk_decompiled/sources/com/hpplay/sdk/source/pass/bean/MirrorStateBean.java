package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MirrorStateBean extends BaseBean {
    private static final String TAG = "MirrorStateBean";
    public final int action;
    public final int actionType;
    public final String uri;

    public MirrorStateBean(int i10, String str, int i11, int i12) {
        this.manifestVer = i10;
        this.uri = str;
        this.actionType = i11;
        this.action = i12;
    }

    public static MirrorStateBean createPauseBean(String str) {
        return new MirrorStateBean(1, str, 1, 0);
    }

    public static MirrorStateBean createResumeBean(String str) {
        return new MirrorStateBean(1, str, 1, 1);
    }

    public static MirrorStateBean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new MirrorStateBean(jSONObject.optInt("manifestVer"), jSONObject.optString("uri"), jSONObject.optInt("actionType"), jSONObject.optInt("action"));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("uri", this.uri);
            jSONObject.put("actionType", this.actionType);
            jSONObject.put("action", this.action);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
