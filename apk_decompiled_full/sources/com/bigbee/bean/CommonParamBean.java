package com.bigbee.bean;

import com.hpplay.component.common.ParamsMap;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import t9.i;

/* loaded from: classes.dex */
public final class CommonParamBean implements Serializable {
    private String appId;
    private String appVer;
    private String macAddr;
    private String model;
    private String rangerVer;
    private String reserve1;
    private String sn;
    private String sysVer;
    private String userId;
    private String userName;

    public CommonParamBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, "sn");
        i.g(str2, "appId");
        i.g(str3, "appVer");
        i.g(str4, "sysVer");
        i.g(str5, Constants.KEY_MODEL);
        i.g(str6, ParamsMap.DeviceParams.KEY_MAC);
        i.g(str7, ParamsMap.DeviceParams.KEY_UID);
        i.g(str8, "uName");
        i.g(str9, "reserve1");
        this.rangerVer = "";
        this.sn = str;
        this.appId = str2;
        this.appVer = str3;
        this.sysVer = str4;
        this.model = str5;
        this.macAddr = str6;
        this.userId = str7;
        this.userName = str8;
        this.reserve1 = str9;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppVer() {
        return this.appVer;
    }

    public final String getMacAddr() {
        return this.macAddr;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getRangerVer() {
        return this.rangerVer;
    }

    public final String getReserve1() {
        return this.reserve1;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getSysVer() {
        return this.sysVer;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setAppId(String str) {
        i.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setAppVer(String str) {
        i.g(str, "<set-?>");
        this.appVer = str;
    }

    public final void setMacAddr(String str) {
        this.macAddr = str;
    }

    public final void setModel(String str) {
        i.g(str, "<set-?>");
        this.model = str;
    }

    public final void setRangerVer(String str) {
        i.g(str, "<set-?>");
        this.rangerVer = str;
    }

    public final void setReserve1(String str) {
        this.reserve1 = str;
    }

    public final void setSn(String str) {
        this.sn = str;
    }

    public final void setSysVer(String str) {
        i.g(str, "<set-?>");
        this.sysVer = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public CommonParamBean(String str, String str2, String str3) {
        i.g(str, "sn");
        i.g(str2, ParamsMap.DeviceParams.KEY_UID);
        i.g(str3, "uName");
        this.appId = "";
        this.appVer = "";
        this.sysVer = "";
        this.model = "";
        this.macAddr = "";
        this.reserve1 = "";
        this.rangerVer = "";
        this.sn = str;
        this.userId = str2;
        this.userName = str3;
    }

    public CommonParamBean(String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str, "appId");
        i.g(str2, "appVer");
        i.g(str3, "sysVer");
        i.g(str4, Constants.KEY_MODEL);
        i.g(str5, ParamsMap.DeviceParams.KEY_MAC);
        i.g(str6, "reserve1");
        this.sn = "";
        this.userId = "";
        this.userName = "";
        this.rangerVer = "";
        this.appId = str;
        this.appVer = str2;
        this.sysVer = str3;
        this.model = str4;
        this.macAddr = str5;
        this.reserve1 = str6;
    }

    public CommonParamBean() {
        this.sn = "";
        this.appId = "";
        this.appVer = "";
        this.sysVer = "";
        this.model = "";
        this.macAddr = "";
        this.userId = "";
        this.userName = "";
        this.reserve1 = "";
        this.rangerVer = "";
    }
}
