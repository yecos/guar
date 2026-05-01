package com.hpplay.sdk.source.transceiver.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RemoteServerBean {
    public int height;
    public int port;
    public int width;

    public static RemoteServerBean formJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            RemoteServerBean remoteServerBean = new RemoteServerBean();
            remoteServerBean.port = jSONObject.optInt("port");
            remoteServerBean.width = jSONObject.optInt("width");
            remoteServerBean.height = jSONObject.optInt("height");
            return remoteServerBean;
        } catch (Exception e10) {
            SourceLog.w("RemoteServerBean", e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("port", this.port);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w("RemoteServerBean", e10);
            return null;
        }
    }
}
