package com.hpplay.sdk.source.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HistoryConfigBean {
    public String encryptNumberId;
    public boolean isReport;
    public int linkType;
    public String numberId;

    public static HistoryConfigBean formJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HistoryConfigBean historyConfigBean = new HistoryConfigBean();
            historyConfigBean.isReport = jSONObject.optBoolean("isReport");
            historyConfigBean.encryptNumberId = jSONObject.optString("encryptNumberId");
            historyConfigBean.numberId = jSONObject.optString("numberId");
            historyConfigBean.linkType = jSONObject.optInt("linkType");
            return historyConfigBean;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String toJSON() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReport", this.isReport);
            jSONObject.put("numberId", this.numberId);
            jSONObject.put("encryptNumberId", this.encryptNumberId);
            jSONObject.put("linkType", this.linkType);
            return jSONObject.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "HistoryConfigBean{isReport=" + this.isReport + ", numberId='" + this.numberId + "', encryptNumberId='" + this.encryptNumberId + "', linkType=" + this.linkType + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
