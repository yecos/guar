package com.alibaba.sdk.android.httpdns;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    private String[] f5930d;
    private boolean enabled;

    public o(String str) {
        this.enabled = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i.d("StartIp Schedule center response:" + jSONObject.toString());
            if (jSONObject.has("service_status")) {
                this.enabled = jSONObject.getString("service_status").equals("disable") ? false : true;
            }
            if (jSONObject.has("service_ip")) {
                JSONArray jSONArray = jSONObject.getJSONArray("service_ip");
                this.f5930d = new String[jSONArray.length()];
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    this.f5930d[i10] = (String) jSONArray.get(i10);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public String[] b() {
        return this.f5930d;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
