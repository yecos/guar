package com.hpplay.sdk.source.business.cloud;

import com.hpplay.common.utils.Encode;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SwitchEntity {
    private static final String TAG = "SwitchEntity";
    public SwitchBean switchBean;
    public int ver;

    public static class SwitchBean {
        int sl;

        public SwitchBean(String str) {
            decode(str);
        }

        private void decode(String str) {
            try {
                JSONObject jSONObject = new JSONObject(Encode.decode(str, Session.getInstance().appSecret));
                if (jSONObject.has("sl")) {
                    this.sl = jSONObject.optInt("sl");
                }
            } catch (Exception e10) {
                SourceLog.w(SwitchEntity.TAG, e10);
            }
        }
    }

    public SwitchEntity(JSONObject jSONObject) {
        decode(jSONObject);
    }

    private void decode(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ver = jSONObject.optInt(BrowserInfo.KEY_VER);
            String optString = jSONObject.optString("sw_list");
            if (optString == null || optString.length() <= 0) {
                return;
            }
            this.switchBean = new SwitchBean(optString);
        }
    }
}
