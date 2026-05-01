package com.hpplay.sdk.source.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class DescriptionBean {
    private static final String TAG = "DescriptionBean";
    private String cuid;
    private int handler;
    private String id;
    private int manifestType;
    private int manifestVer;
    private String sessionID;
    private int subscribe;
    private String uid;
    private int ver;

    public DescriptionBean() {
    }

    public void decode(JSONObject jSONObject) {
        this.ver = jSONObject.optInt(BrowserInfo.KEY_VER);
        this.id = jSONObject.optString("id");
        this.manifestType = jSONObject.optInt("manifestType");
        this.manifestVer = jSONObject.optInt("manifestVer");
        this.handler = jSONObject.optInt("handler");
        this.subscribe = jSONObject.optInt("subscribe");
        this.sessionID = jSONObject.optString("sessionID");
        this.cuid = jSONObject.optString("cuid");
        this.uid = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID);
    }

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BrowserInfo.KEY_VER, this.ver);
            jSONObject.put("id", this.id);
            jSONObject.put("manifestType", this.manifestType);
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("handler", this.handler);
            jSONObject.put("subscribe", this.subscribe);
            jSONObject.put("sessionID", this.sessionID);
            jSONObject.put("cuid", this.cuid);
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, this.uid);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public String getCuid() {
        return this.cuid;
    }

    public int getHandler() {
        return this.handler;
    }

    public String getId() {
        return this.id;
    }

    public int getManifestType() {
        return this.manifestType;
    }

    public int getManifestVer() {
        return this.manifestVer;
    }

    public String getSessionId() {
        return this.sessionID;
    }

    public int getSubscribe() {
        return this.subscribe;
    }

    public String getUid() {
        return this.uid;
    }

    public int getVer() {
        return this.ver;
    }

    public void setCuid(String str) {
        this.cuid = str;
    }

    public void setHandler(int i10) {
        this.handler = i10;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setManifestType(int i10) {
        this.manifestType = i10;
    }

    public void setManifestVer(int i10) {
        this.manifestVer = i10;
    }

    public void setSessionId(String str) {
        this.sessionID = str;
    }

    public void setSubscribe(int i10) {
        this.subscribe = i10;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVer(int i10) {
        this.ver = i10;
    }

    public DescriptionBean(JSONObject jSONObject) {
        decode(jSONObject);
    }
}
