package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VipAuthResultBean {
    public VipAuthDataEntity data;
    public int status;

    public static class VipAuthDataEntity {
        public List<AuthInfo> authinfo;
        public int code;
        public String sign;
        public String stime;

        public static class AuthInfo {
            public String key;
            public int limitDeviceNum;
            public int limitDeviceStatus;
            public int limitTime = -1;
            public String name;

            public void decode(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.name = jSONObject.optString("name");
                this.key = jSONObject.optString("key");
                this.limitTime = jSONObject.optInt("limitTime", -1);
                this.limitDeviceStatus = jSONObject.optInt("limitDeviceStatus");
                this.limitDeviceNum = jSONObject.optInt("limitDeviceNum");
            }
        }

        public void decode(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.code = jSONObject.optInt(Constants.KEY_HTTP_CODE);
            this.sign = jSONObject.optString("sign");
            this.stime = jSONObject.optString("stime");
            JSONArray optJSONArray = jSONObject.optJSONArray("authinfo");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            this.authinfo = new ArrayList();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                AuthInfo authInfo = new AuthInfo();
                authInfo.decode(optJSONObject);
                this.authinfo.add(authInfo);
            }
        }
    }

    public VipAuthResultBean(JSONObject jSONObject) {
        decode(jSONObject);
    }

    public void decode(JSONObject jSONObject) {
        this.status = jSONObject.optInt(Constant.KEY_STATUS);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            VipAuthDataEntity vipAuthDataEntity = new VipAuthDataEntity();
            this.data = vipAuthDataEntity;
            vipAuthDataEntity.decode(optJSONObject);
        }
    }
}
