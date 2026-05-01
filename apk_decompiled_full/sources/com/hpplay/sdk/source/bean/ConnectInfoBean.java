package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class ConnectInfoBean {
    private static final String TAG = "ConnectInfoBean";
    private String appID;
    private int manifestVer;
    private String mf;
    private String model;
    private String sm;
    private int plat = 0;
    private int mirror = 0;

    public ConnectInfoBean(JSONObject jSONObject) {
        decode(jSONObject);
    }

    public void decode(JSONObject jSONObject) {
        try {
            this.manifestVer = jSONObject.optInt("manifestVer");
            this.model = jSONObject.optString(Constants.KEY_MODEL);
            this.sm = jSONObject.optString("sm");
            this.mf = jSONObject.optString("mf");
            this.plat = jSONObject.optInt("plat");
            this.appID = jSONObject.optString("appID");
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public String getAppID() {
        return this.appID;
    }

    public int getManifestVer() {
        return this.manifestVer;
    }

    public String getMf() {
        return this.mf;
    }

    public int getMirror() {
        return this.mirror;
    }

    public String getModel() {
        return this.model;
    }

    public int getPlat() {
        return this.plat;
    }

    public String getSm() {
        return this.sm;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setManifestVer(int i10) {
        this.manifestVer = i10;
    }

    public void setMf(String str) {
        this.mf = str;
    }

    public void setMirror(int i10) {
        this.mirror = i10;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setSm(String str) {
        this.sm = str;
    }
}
