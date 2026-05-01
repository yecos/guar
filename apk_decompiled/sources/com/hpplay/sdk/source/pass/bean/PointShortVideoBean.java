package com.hpplay.sdk.source.pass.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PointShortVideoBean extends BaseBean {
    private static final String TAG = "PointShortVideoBean";
    public int index;
    public String url;

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put(FirebaseAnalytics.Param.INDEX, this.index);
            jSONObject.put("url", this.url);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }
}
