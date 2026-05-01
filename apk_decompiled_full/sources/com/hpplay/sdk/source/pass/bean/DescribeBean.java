package com.hpplay.sdk.source.pass.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DescribeBean extends BaseBean {
    private static final String TAG = "DescribeBean";
    public String cuid;
    public int handler;
    public String id;
    public int manifestType;
    public String sessionID;
    public int subscribe;
    public String uid;
    public int ver = 1;

    public static DescribeBean formJson(String str) {
        try {
            DescribeBean describeBean = new DescribeBean();
            JSONObject jSONObject = new JSONObject(str);
            describeBean.manifestType = jSONObject.optInt("manifestType");
            describeBean.ver = jSONObject.optInt(BrowserInfo.KEY_VER);
            describeBean.id = jSONObject.optString("id");
            describeBean.handler = jSONObject.optInt("handler");
            describeBean.subscribe = jSONObject.optInt("subscribe");
            describeBean.sessionID = jSONObject.optString("sessionID");
            describeBean.cuid = jSONObject.optString("cuid");
            describeBean.uid = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID);
            return describeBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestType", this.manifestType);
            jSONObject.put(BrowserInfo.KEY_VER, this.ver);
            jSONObject.put("id", this.id);
            jSONObject.put("handler", this.handler);
            jSONObject.put("subscribe", this.subscribe);
            jSONObject.put("sessionID", this.sessionID);
            jSONObject.put("cuid", this.cuid);
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, this.uid);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toString() {
        return "DescribeBean{ver=" + this.ver + ", handler=" + this.handler + ", subscribe=" + this.subscribe + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
