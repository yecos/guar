package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NetPassBean {
    private static final String TAG = "NetPassBean";
    public String pc;

    public static NetPassBean formJson(String str) {
        try {
            NetPassBean netPassBean = new NetPassBean();
            netPassBean.pc = new JSONObject(str).optString(CastUtil.PLAT_TYPE_PC);
            return netPassBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CastUtil.PLAT_TYPE_PC, this.pc);
            return jSONObject;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
