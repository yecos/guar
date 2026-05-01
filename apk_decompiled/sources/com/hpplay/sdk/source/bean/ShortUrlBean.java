package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.common.global.Constant;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ShortUrlBean {
    public DataEntity data = new DataEntity();
    public int status;

    public static class DataEntity {
        public String shorturl;

        public void decode(JSONObject jSONObject) {
            this.shorturl = jSONObject.optString("shorturl");
        }
    }

    public ShortUrlBean(JSONObject jSONObject) {
        decode(jSONObject);
    }

    public void decode(JSONObject jSONObject) {
        this.status = jSONObject.optInt(Constant.KEY_STATUS);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            DataEntity dataEntity = new DataEntity();
            this.data = dataEntity;
            dataEntity.decode(optJSONObject);
        }
    }
}
