package com.hpplay.sdk.source.business.cloud;

import com.hpplay.common.utils.Encode;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AuthSDKBean {
    private static final String TAG = "AuthSDKBean";
    public DataEntity data;
    public int status;

    public static class DataEntity {
        public String dmr_name;
        public int expire_time;
        public String hid;
        public String prot_ver;
        public long reg_time;
        public int scan_time;
        public ServListEntity serv_list;
        public long server_time;
        public SwitchEntity switch_conf;
        public int tid;
        public String token;
        public String uid;

        public static class ServListEntity {
            public List<UrlListEntity> url_list;
            public int ver;

            public static class UrlListEntity {
                public String name;
                public String url;

                public UrlListEntity(JSONObject jSONObject) {
                    decode(jSONObject);
                }

                public void decode(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        SourceLog.i(AuthSDKBean.TAG, "decode UrlListEntity is emtpy");
                    } else {
                        this.name = jSONObject.optString("name");
                        this.url = jSONObject.optString("url");
                    }
                }
            }
        }

        public static class SwitchEntity {
            public SwitchBean switchBean;
            public int ver;

            public static class SwitchBean {
                int sl;

                public SwitchBean(String str) {
                    decode(str);
                }

                private void decode(String str) {
                    try {
                        String decode = Encode.decode(str, Session.getInstance().appSecret);
                        SourceLog.i(AuthSDKBean.TAG, "decode SwitchEntity:" + decode);
                        JSONObject jSONObject = new JSONObject(decode);
                        if (jSONObject.has("sl")) {
                            this.sl = jSONObject.optInt("sl");
                        }
                    } catch (Exception e10) {
                        SourceLog.w(AuthSDKBean.TAG, e10);
                    }
                }
            }
        }

        public void decode(JSONObject jSONObject) {
            if (jSONObject == null) {
                SourceLog.i(AuthSDKBean.TAG, "decode DataEntity is emtpy");
                return;
            }
            this.server_time = jSONObject.optLong("server_time");
            this.dmr_name = jSONObject.optString("dmr_name");
            this.tid = jSONObject.optInt("tid");
            this.token = jSONObject.optString(ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
            this.prot_ver = jSONObject.optString("prot_ver");
            this.scan_time = jSONObject.optInt("scan_time");
            this.expire_time = jSONObject.optInt("expire_time");
            this.uid = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID);
            this.hid = jSONObject.optString(ParamsMap.DeviceParams.KEY_HID);
            this.reg_time = jSONObject.optLong("reg_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("serv_list");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                ServListEntity servListEntity = new ServListEntity();
                this.serv_list = servListEntity;
                servListEntity.ver = optJSONObject.optInt(BrowserInfo.KEY_VER);
                JSONArray optJSONArray = optJSONObject.optJSONArray("url_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.serv_list.url_list = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        ServListEntity.UrlListEntity urlListEntity = new ServListEntity.UrlListEntity(optJSONArray.optJSONObject(i10));
                        urlListEntity.decode(optJSONArray.optJSONObject(i10));
                        this.serv_list.url_list.add(urlListEntity);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("switch");
            if (optJSONObject2 != null) {
                SwitchEntity switchEntity = new SwitchEntity();
                this.switch_conf = switchEntity;
                switchEntity.ver = optJSONObject2.optInt(BrowserInfo.KEY_VER);
                String optString = optJSONObject2.optString("sw_list");
                if (optString == null || optString.length() <= 0) {
                    return;
                }
                this.switch_conf.switchBean = new SwitchEntity.SwitchBean(optString);
            }
        }
    }

    public AuthSDKBean(JSONObject jSONObject) {
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
