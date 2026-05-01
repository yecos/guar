package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PinCodeBean {
    public DataBean data;
    public String msg;
    public int status;

    public static class DataBean {
        public String code;
        public int codeTime = 1440;
        public int isvip;

        public void decode(JSONObject jSONObject) {
            this.code = jSONObject.optString(Constants.KEY_HTTP_CODE);
            this.codeTime = jSONObject.optInt("codeTime");
            this.isvip = jSONObject.optInt("isvip");
        }
    }

    public PinCodeBean(JSONObject jSONObject) {
        decode(jSONObject);
    }

    public void decode(JSONObject jSONObject) {
        this.status = jSONObject.optInt(Constant.KEY_STATUS);
        this.msg = jSONObject.optString(Constant.KEY_MSG);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            DataBean dataBean = new DataBean();
            this.data = dataBean;
            dataBean.decode(optJSONObject);
        }
    }
}
