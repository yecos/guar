package com.hpplay.sdk.source.bean;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PassSinkAuthBean {
    public boolean cm;
    public boolean enterprise;

    public PassSinkAuthBean(JSONObject jSONObject) {
        decode(jSONObject);
    }

    public void decode(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("enterprise");
        int optInt2 = jSONObject.optInt("cm");
        this.enterprise = optInt == 1;
        this.cm = optInt2 == 1;
    }
}
