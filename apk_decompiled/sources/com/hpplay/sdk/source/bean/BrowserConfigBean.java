package com.hpplay.sdk.source.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BrowserConfigBean {
    public String encryptNumberId;
    public String numberId;
    public boolean useLelink = true;
    public boolean useDlna = true;
    public boolean useBLE = false;
    public boolean useHistory = false;

    @Deprecated
    public boolean useSonic = false;

    public static BrowserConfigBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            BrowserConfigBean browserConfigBean = new BrowserConfigBean();
            browserConfigBean.useLelink = jSONObject.optBoolean("useLelink");
            browserConfigBean.useDlna = jSONObject.optBoolean("useDlna");
            browserConfigBean.useBLE = jSONObject.optBoolean("useBLE");
            browserConfigBean.useSonic = jSONObject.optBoolean("useSonic");
            browserConfigBean.useHistory = jSONObject.optBoolean("useHistory");
            browserConfigBean.encryptNumberId = jSONObject.optString("encryptNumberId");
            browserConfigBean.numberId = jSONObject.optString("numberId");
            return browserConfigBean;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String toJSON() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("useLelink", this.useLelink);
            jSONObject.put("useDlna", this.useDlna);
            jSONObject.put("useBLE", this.useBLE);
            jSONObject.put("useSonic", this.useSonic);
            jSONObject.put("useHistory", this.useHistory);
            jSONObject.put("encryptNumberId", this.encryptNumberId);
            jSONObject.put("numberId", this.numberId);
            return jSONObject.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "BrowserConfigBean{useLelink=" + this.useLelink + ", useDlna=" + this.useDlna + ", useBLE=" + this.useBLE + ", useHistory=" + this.useHistory + ", encryptNumberId='" + this.encryptNumberId + "', numberId='" + this.numberId + "', useSonic=" + this.useSonic + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
