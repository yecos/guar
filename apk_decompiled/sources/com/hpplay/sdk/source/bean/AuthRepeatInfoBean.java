package com.hpplay.sdk.source.bean;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AuthRepeatInfoBean {
    private static String TAG = "AuthRepeatInfoBean";
    private String hid;
    private long reg_time;
    private String uid;

    public static String beanToJson(AuthRepeatInfoBean authRepeatInfoBean) {
        if (authRepeatInfoBean == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, authRepeatInfoBean.getUid());
            if (TextUtils.isEmpty(authRepeatInfoBean.getHid()) || authRepeatInfoBean.getHid().startsWith("0")) {
                jSONObject.put(ParamsMap.DeviceParams.KEY_HID, "");
            } else {
                jSONObject.put(ParamsMap.DeviceParams.KEY_HID, authRepeatInfoBean.getHid());
            }
            jSONObject.put("reg_time", authRepeatInfoBean.getRegTime());
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return "";
        }
    }

    public static AuthRepeatInfoBean jsonToBean(String str) {
        AuthRepeatInfoBean authRepeatInfoBean = new AuthRepeatInfoBean();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                authRepeatInfoBean.setUid(jSONObject.optString(ParamsMap.DeviceParams.KEY_UID));
                authRepeatInfoBean.setHid(jSONObject.optString(ParamsMap.DeviceParams.KEY_HID));
                authRepeatInfoBean.setReg_time(jSONObject.optLong("reg_time"));
            } catch (Exception e10) {
                SourceLog.w(TAG, e10.toString());
            }
        }
        return authRepeatInfoBean;
    }

    public String getHid() {
        String str = this.hid;
        return str == null ? "" : str;
    }

    public long getRegTime() {
        return this.reg_time;
    }

    public String getUid() {
        String str = this.uid;
        return str == null ? "" : str;
    }

    public boolean hasRepeatInfo() {
        return (TextUtils.isEmpty(this.uid) && TextUtils.isEmpty(this.hid) && this.reg_time <= 0) ? false : true;
    }

    public void setHid(String str) {
        this.hid = str;
    }

    public void setReg_time(long j10) {
        this.reg_time = j10;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "AuthRepeatInfoBean{uid='" + this.uid + "', hid='" + this.hid + "', reg_time='" + this.reg_time + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
