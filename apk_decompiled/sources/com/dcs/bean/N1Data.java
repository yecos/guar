package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class N1Data {
    private String apk;
    private String apk_ver;
    private String auth_version;
    private String gateway_mac;
    private String pre_code;
    private String reserve1;
    private String sn;
    private String spkg_ver;
    private String user_id;
    private String user_identity;

    public N1Data(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        i.g(str, "sn");
        i.g(str3, "auth_version");
        i.g(str4, "apk");
        i.g(str5, "apk_ver");
        i.g(str7, "gateway_mac");
        i.g(str8, "reserve1");
        this.sn = str;
        this.pre_code = str2;
        this.auth_version = str3;
        this.apk = str4;
        this.apk_ver = str5;
        this.spkg_ver = str6;
        this.gateway_mac = str7;
        this.reserve1 = str8;
        this.user_id = str9;
        this.user_identity = str10;
    }

    public final String component1() {
        return this.sn;
    }

    public final String component10() {
        return this.user_identity;
    }

    public final String component2() {
        return this.pre_code;
    }

    public final String component3() {
        return this.auth_version;
    }

    public final String component4() {
        return this.apk;
    }

    public final String component5() {
        return this.apk_ver;
    }

    public final String component6() {
        return this.spkg_ver;
    }

    public final String component7() {
        return this.gateway_mac;
    }

    public final String component8() {
        return this.reserve1;
    }

    public final String component9() {
        return this.user_id;
    }

    public final N1Data copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        i.g(str, "sn");
        i.g(str3, "auth_version");
        i.g(str4, "apk");
        i.g(str5, "apk_ver");
        i.g(str7, "gateway_mac");
        i.g(str8, "reserve1");
        return new N1Data(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N1Data)) {
            return false;
        }
        N1Data n1Data = (N1Data) obj;
        return i.b(this.sn, n1Data.sn) && i.b(this.pre_code, n1Data.pre_code) && i.b(this.auth_version, n1Data.auth_version) && i.b(this.apk, n1Data.apk) && i.b(this.apk_ver, n1Data.apk_ver) && i.b(this.spkg_ver, n1Data.spkg_ver) && i.b(this.gateway_mac, n1Data.gateway_mac) && i.b(this.reserve1, n1Data.reserve1) && i.b(this.user_id, n1Data.user_id) && i.b(this.user_identity, n1Data.user_identity);
    }

    public final String getApk() {
        return this.apk;
    }

    public final String getApk_ver() {
        return this.apk_ver;
    }

    public final String getAuth_version() {
        return this.auth_version;
    }

    public final String getGateway_mac() {
        return this.gateway_mac;
    }

    public final String getPre_code() {
        return this.pre_code;
    }

    public final String getReserve1() {
        return this.reserve1;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getSpkg_ver() {
        return this.spkg_ver;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final String getUser_identity() {
        return this.user_identity;
    }

    public int hashCode() {
        int hashCode = this.sn.hashCode() * 31;
        String str = this.pre_code;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.auth_version.hashCode()) * 31) + this.apk.hashCode()) * 31) + this.apk_ver.hashCode()) * 31;
        String str2 = this.spkg_ver;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.gateway_mac.hashCode()) * 31) + this.reserve1.hashCode()) * 31;
        String str3 = this.user_id;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.user_identity;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setApk(String str) {
        i.g(str, "<set-?>");
        this.apk = str;
    }

    public final void setApk_ver(String str) {
        i.g(str, "<set-?>");
        this.apk_ver = str;
    }

    public final void setAuth_version(String str) {
        i.g(str, "<set-?>");
        this.auth_version = str;
    }

    public final void setGateway_mac(String str) {
        i.g(str, "<set-?>");
        this.gateway_mac = str;
    }

    public final void setPre_code(String str) {
        this.pre_code = str;
    }

    public final void setReserve1(String str) {
        i.g(str, "<set-?>");
        this.reserve1 = str;
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
    }

    public final void setSpkg_ver(String str) {
        this.spkg_ver = str;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final void setUser_identity(String str) {
        this.user_identity = str;
    }

    public String toString() {
        return "N1Data(sn=" + this.sn + ", pre_code=" + this.pre_code + ", auth_version=" + this.auth_version + ", apk=" + this.apk + ", apk_ver=" + this.apk_ver + ", spkg_ver=" + this.spkg_ver + ", gateway_mac=" + this.gateway_mac + ", reserve1=" + this.reserve1 + ", user_id=" + this.user_id + ", user_identity=" + this.user_identity + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
