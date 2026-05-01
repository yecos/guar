package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class ErrorBean {
    private final String TAG = "ErrorBean";
    private String data;
    private String error;
    private int errorCode;
    private int manifestVer;

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("error", this.error);
            jSONObject.put("data", this.data);
        } catch (Exception e10) {
            SourceLog.w("ErrorBean", e10);
        }
        return jSONObject;
    }

    public String getData() {
        return this.data;
    }

    public String getError() {
        return this.error;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getManifestVer() {
        return this.manifestVer;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setManifestVer(int i10) {
        this.manifestVer = i10;
    }
}
