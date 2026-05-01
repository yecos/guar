package com.hpplay.sdk.source.pass.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SinkTouchEventInfoBean extends BaseBean {
    public static final int STATUS_FAILED = -1;
    public static final int STATUS_SUCCESS = 0;
    private static final String TAG = "SinkTouchEventBean";
    public String ip;
    public final int status;
    public final int tcpChannelPort;
    public final int touchEventType;
    public final int udpChannelPort;

    private SinkTouchEventInfoBean(int i10, int i11, int i12, int i13, String str, int i14) {
        this.status = i11;
        this.manifestVer = i10;
        this.tcpChannelPort = i12;
        this.udpChannelPort = i13;
        this.ip = str;
        this.touchEventType = i14;
    }

    public static SinkTouchEventInfoBean createSendBean() {
        return new SinkTouchEventInfoBean(1, 0, 0, 0, "", 0);
    }

    public static SinkTouchEventInfoBean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new SinkTouchEventInfoBean(jSONObject.optInt("manifestVer"), jSONObject.optInt(Constant.KEY_STATUS), jSONObject.optInt("tcpChannelPort"), jSONObject.optInt("udpChannelPort"), jSONObject.optString("ip"), jSONObject.optInt("touchEventType"));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put(Constant.KEY_STATUS, this.status);
            jSONObject.put("tcpChannelPort", this.tcpChannelPort);
            jSONObject.put("udpChannelPort", this.udpChannelPort);
            jSONObject.put("ip", this.ip);
            jSONObject.put("touchEventType", this.touchEventType);
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String toString() {
        return "SinkTouchEventInfoBean{status=" + this.status + ", tcpChannelPort=" + this.tcpChannelPort + ", udpChannelPort=" + this.udpChannelPort + ", ip='" + this.ip + "', touchEventType=" + this.touchEventType + ", manifestVer=" + this.manifestVer + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
