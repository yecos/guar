package com.hpplay.sdk.source.pass.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ShortVideoListBean {
    public int index;
    public int manifestVer;
    public JSONArray videoList;

    public static String toJSON(ShortVideoListBean shortVideoListBean) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", shortVideoListBean.manifestVer);
            jSONObject.put(FirebaseAnalytics.Param.INDEX, shortVideoListBean.index);
            jSONObject.put("videoList", shortVideoListBean.videoList);
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
