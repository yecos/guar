package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BaseBean {
    private static final String TAG = "BaseBean";
    public int manifestVer;

    public static BaseBean formJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            BaseBean baseBean = new BaseBean();
            baseBean.manifestVer = jSONObject.optInt("manifestVer");
            return baseBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
