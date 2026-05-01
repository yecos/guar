package com.hpplay.sdk.source.transceiver.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NotifyMirrorBean {
    public String ip;
    public String name;
    public int port;
    public String uid;

    public static NotifyMirrorBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            NotifyMirrorBean notifyMirrorBean = new NotifyMirrorBean();
            notifyMirrorBean.uid = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID);
            notifyMirrorBean.ip = jSONObject.optString("ip");
            notifyMirrorBean.port = jSONObject.optInt("port");
            notifyMirrorBean.name = jSONObject.optString("name");
            return notifyMirrorBean;
        } catch (Exception e10) {
            SourceLog.w("SinkNotifyMirrorBean", e10);
            return null;
        }
    }

    public String toJSON() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, this.uid);
            jSONObject.put("ip", this.ip);
            jSONObject.put("port", this.port);
            jSONObject.put("name", this.name);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w("SinkNotifyMirrorBean", e10);
            return "";
        }
    }
}
