package com.hpplay.sdk.source.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SinkParameterBean {
    public static int CREATE_BY_SINK_APPID_UID = 1;
    public static int CREATE_BY_SINK_DSN = 2;
    public static int CREATE_BY_SINK_SERVER = 3;
    public String appID;
    public int createType = CREATE_BY_SINK_APPID_UID;
    public String dsn;
    public String ip;
    public int port;
    public String uid;

    public static SinkParameterBean formJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SinkParameterBean sinkParameterBean = new SinkParameterBean();
            sinkParameterBean.createType = jSONObject.optInt("createType");
            sinkParameterBean.appID = jSONObject.optString("appID");
            sinkParameterBean.uid = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID);
            sinkParameterBean.dsn = jSONObject.optString("dsn");
            sinkParameterBean.ip = jSONObject.optString("ip");
            sinkParameterBean.port = jSONObject.optInt("port");
            return sinkParameterBean;
        } catch (Exception e10) {
            SourceLog.w("SinkParameterBean", e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appID", this.appID);
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, this.uid);
            jSONObject.put("createType", this.createType);
            jSONObject.put("dsn", this.dsn);
            jSONObject.put("ip", this.ip);
            jSONObject.put("port", this.port);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w("SinkParameterBean", e10);
            return null;
        }
    }
}
