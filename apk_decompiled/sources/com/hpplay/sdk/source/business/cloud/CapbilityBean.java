package com.hpplay.sdk.source.business.cloud;

import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CapbilityBean {
    private final String TAG = "CapbilityBean";
    public String fe;
    public String localip;
    public String localport;
    public String name;
    public String pol;
    public String ver;

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BrowserInfo.KEY_POL, this.pol);
            jSONObject.put("localip", this.localip);
            jSONObject.put("localport", this.localport);
            jSONObject.put("name", this.name);
            jSONObject.put(BrowserInfo.KEY_FE, this.fe);
            jSONObject.put(BrowserInfo.KEY_VER, "1.3");
        } catch (Exception e10) {
            SourceLog.w("CapbilityBean", e10);
        }
        return jSONObject;
    }
}
