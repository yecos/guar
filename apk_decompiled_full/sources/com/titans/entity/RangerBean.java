package com.titans.entity;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class RangerBean {
    private String advertising_id;
    private String android_id;
    private String app;
    private String app_version;
    private String ca_info;
    private String communication_key;
    private String dev_id;
    private String params;
    private String player;
    private String sn;
    private String user_id;

    public RangerBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        i.g(str, "android_id");
        i.g(str2, "advertising_id");
        i.g(str3, "user_id");
        i.g(str4, "dev_id");
        i.g(str5, "player");
        i.g(str6, "sn");
        i.g(str7, "app");
        i.g(str8, "app_version");
        i.g(str9, "ca_info");
        i.g(str10, "communication_key");
        i.g(str11, "params");
        this.android_id = str;
        this.advertising_id = str2;
        this.user_id = str3;
        this.dev_id = str4;
        this.player = str5;
        this.sn = str6;
        this.app = str7;
        this.app_version = str8;
        this.ca_info = str9;
        this.communication_key = str10;
        this.params = str11;
    }

    public final String component1() {
        return this.android_id;
    }

    public final String component10() {
        return this.communication_key;
    }

    public final String component11() {
        return this.params;
    }

    public final String component2() {
        return this.advertising_id;
    }

    public final String component3() {
        return this.user_id;
    }

    public final String component4() {
        return this.dev_id;
    }

    public final String component5() {
        return this.player;
    }

    public final String component6() {
        return this.sn;
    }

    public final String component7() {
        return this.app;
    }

    public final String component8() {
        return this.app_version;
    }

    public final String component9() {
        return this.ca_info;
    }

    public final RangerBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        i.g(str, "android_id");
        i.g(str2, "advertising_id");
        i.g(str3, "user_id");
        i.g(str4, "dev_id");
        i.g(str5, "player");
        i.g(str6, "sn");
        i.g(str7, "app");
        i.g(str8, "app_version");
        i.g(str9, "ca_info");
        i.g(str10, "communication_key");
        i.g(str11, "params");
        return new RangerBean(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangerBean)) {
            return false;
        }
        RangerBean rangerBean = (RangerBean) obj;
        return i.b(this.android_id, rangerBean.android_id) && i.b(this.advertising_id, rangerBean.advertising_id) && i.b(this.user_id, rangerBean.user_id) && i.b(this.dev_id, rangerBean.dev_id) && i.b(this.player, rangerBean.player) && i.b(this.sn, rangerBean.sn) && i.b(this.app, rangerBean.app) && i.b(this.app_version, rangerBean.app_version) && i.b(this.ca_info, rangerBean.ca_info) && i.b(this.communication_key, rangerBean.communication_key) && i.b(this.params, rangerBean.params);
    }

    public final String getAdvertising_id() {
        return this.advertising_id;
    }

    public final String getAndroid_id() {
        return this.android_id;
    }

    public final String getApp() {
        return this.app;
    }

    public final String getApp_version() {
        return this.app_version;
    }

    public final String getCa_info() {
        return this.ca_info;
    }

    public final String getCommunication_key() {
        return this.communication_key;
    }

    public final String getDev_id() {
        return this.dev_id;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getPlayer() {
        return this.player;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        return (((((((((((((((((((this.android_id.hashCode() * 31) + this.advertising_id.hashCode()) * 31) + this.user_id.hashCode()) * 31) + this.dev_id.hashCode()) * 31) + this.player.hashCode()) * 31) + this.sn.hashCode()) * 31) + this.app.hashCode()) * 31) + this.app_version.hashCode()) * 31) + this.ca_info.hashCode()) * 31) + this.communication_key.hashCode()) * 31) + this.params.hashCode();
    }

    public final void setAdvertising_id(String str) {
        i.g(str, "<set-?>");
        this.advertising_id = str;
    }

    public final void setAndroid_id(String str) {
        i.g(str, "<set-?>");
        this.android_id = str;
    }

    public final void setApp(String str) {
        i.g(str, "<set-?>");
        this.app = str;
    }

    public final void setApp_version(String str) {
        i.g(str, "<set-?>");
        this.app_version = str;
    }

    public final void setCa_info(String str) {
        i.g(str, "<set-?>");
        this.ca_info = str;
    }

    public final void setCommunication_key(String str) {
        i.g(str, "<set-?>");
        this.communication_key = str;
    }

    public final void setDev_id(String str) {
        i.g(str, "<set-?>");
        this.dev_id = str;
    }

    public final void setParams(String str) {
        i.g(str, "<set-?>");
        this.params = str;
    }

    public final void setPlayer(String str) {
        i.g(str, "<set-?>");
        this.player = str;
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
    }

    public final void setUser_id(String str) {
        i.g(str, "<set-?>");
        this.user_id = str;
    }

    public String toString() {
        return "RangerBean(android_id=" + this.android_id + ", advertising_id=" + this.advertising_id + ", user_id=" + this.user_id + ", dev_id=" + this.dev_id + ", player=" + this.player + ", sn=" + this.sn + ", app=" + this.app + ", app_version=" + this.app_version + ", ca_info=" + this.ca_info + ", communication_key=" + this.communication_key + ", params=" + this.params + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
