package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MirrorSinkBean {
    public int frameRate;
    public int height;
    public int width;

    public static MirrorSinkBean formJson(String str) {
        try {
            MirrorSinkBean mirrorSinkBean = new MirrorSinkBean();
            JSONObject jSONObject = new JSONObject(str);
            mirrorSinkBean.frameRate = jSONObject.optInt("frameRate");
            mirrorSinkBean.width = jSONObject.optInt("width");
            mirrorSinkBean.height = jSONObject.optInt("height");
            return mirrorSinkBean;
        } catch (Exception e10) {
            SourceLog.w("MirrorSinkBean", e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frameRate", this.frameRate);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w("MirrorSinkBean", e10);
            return null;
        }
    }
}
