package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ShortMediaBean {
    public String cover;
    public String url;

    public static ShortMediaBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ShortMediaBean shortMediaBean = new ShortMediaBean();
            shortMediaBean.url = jSONObject.optString("url");
            shortMediaBean.cover = jSONObject.optString("cover");
            return shortMediaBean;
        } catch (Exception e10) {
            SourceLog.w("ShortMediaBean", e10);
            return null;
        }
    }

    public static JSONObject toJSON(ShortMediaBean shortMediaBean) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", shortMediaBean.url);
            jSONObject.put("cover", shortMediaBean.cover);
            return jSONObject;
        } catch (Exception e10) {
            SourceLog.w("ShortMediaBean", e10);
            return null;
        }
    }
}
