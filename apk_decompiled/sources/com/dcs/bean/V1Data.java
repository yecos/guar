package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t9.i;

/* loaded from: classes.dex */
public final class V1Data {
    private String apk;
    private String apk_ver;
    private String approve_code;
    private String auth_version;
    private String code;
    private String entry_type;
    private String open_num;
    private String reserve1;
    private String sn;
    private String spkg_ver;
    private int type;
    private String user_id;
    private String user_identity;

    public V1Data(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, String str11, String str12) {
        i.g(str, "entry_type");
        i.g(str2, "sn");
        i.g(str3, Constants.KEY_HTTP_CODE);
        i.g(str4, "auth_version");
        i.g(str7, "apk");
        i.g(str8, "apk_ver");
        i.g(str9, "spkg_ver");
        i.g(str10, "reserve1");
        this.entry_type = str;
        this.sn = str2;
        this.code = str3;
        this.auth_version = str4;
        this.approve_code = str5;
        this.open_num = str6;
        this.apk = str7;
        this.apk_ver = str8;
        this.spkg_ver = str9;
        this.reserve1 = str10;
        this.type = i10;
        this.user_id = str11;
        this.user_identity = str12;
    }

    public final String component1() {
        return this.entry_type;
    }

    public final String component10() {
        return this.reserve1;
    }

    public final int component11() {
        return this.type;
    }

    public final String component12() {
        return this.user_id;
    }

    public final String component13() {
        return this.user_identity;
    }

    public final String component2() {
        return this.sn;
    }

    public final String component3() {
        return this.code;
    }

    public final String component4() {
        return this.auth_version;
    }

    public final String component5() {
        return this.approve_code;
    }

    public final String component6() {
        return this.open_num;
    }

    public final String component7() {
        return this.apk;
    }

    public final String component8() {
        return this.apk_ver;
    }

    public final String component9() {
        return this.spkg_ver;
    }

    public final V1Data copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, String str11, String str12) {
        i.g(str, "entry_type");
        i.g(str2, "sn");
        i.g(str3, Constants.KEY_HTTP_CODE);
        i.g(str4, "auth_version");
        i.g(str7, "apk");
        i.g(str8, "apk_ver");
        i.g(str9, "spkg_ver");
        i.g(str10, "reserve1");
        return new V1Data(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V1Data)) {
            return false;
        }
        V1Data v1Data = (V1Data) obj;
        return i.b(this.entry_type, v1Data.entry_type) && i.b(this.sn, v1Data.sn) && i.b(this.code, v1Data.code) && i.b(this.auth_version, v1Data.auth_version) && i.b(this.approve_code, v1Data.approve_code) && i.b(this.open_num, v1Data.open_num) && i.b(this.apk, v1Data.apk) && i.b(this.apk_ver, v1Data.apk_ver) && i.b(this.spkg_ver, v1Data.spkg_ver) && i.b(this.reserve1, v1Data.reserve1) && this.type == v1Data.type && i.b(this.user_id, v1Data.user_id) && i.b(this.user_identity, v1Data.user_identity);
    }

    public final String getApk() {
        return this.apk;
    }

    public final String getApk_ver() {
        return this.apk_ver;
    }

    public final String getApprove_code() {
        return this.approve_code;
    }

    public final String getAuth_version() {
        return this.auth_version;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEntry_type() {
        return this.entry_type;
    }

    public final String getOpen_num() {
        return this.open_num;
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

    public final int getType() {
        return this.type;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final String getUser_identity() {
        return this.user_identity;
    }

    public int hashCode() {
        int hashCode = ((((((this.entry_type.hashCode() * 31) + this.sn.hashCode()) * 31) + this.code.hashCode()) * 31) + this.auth_version.hashCode()) * 31;
        String str = this.approve_code;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.open_num;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.apk.hashCode()) * 31) + this.apk_ver.hashCode()) * 31) + this.spkg_ver.hashCode()) * 31) + this.reserve1.hashCode()) * 31) + this.type) * 31;
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

    public final void setApprove_code(String str) {
        this.approve_code = str;
    }

    public final void setAuth_version(String str) {
        i.g(str, "<set-?>");
        this.auth_version = str;
    }

    public final void setCode(String str) {
        i.g(str, "<set-?>");
        this.code = str;
    }

    public final void setEntry_type(String str) {
        i.g(str, "<set-?>");
        this.entry_type = str;
    }

    public final void setOpen_num(String str) {
        this.open_num = str;
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
        i.g(str, "<set-?>");
        this.spkg_ver = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final void setUser_identity(String str) {
        this.user_identity = str;
    }

    public String toString() {
        return "V1Data(entry_type=" + this.entry_type + ", sn=" + this.sn + ", code=" + this.code + ", auth_version=" + this.auth_version + ", approve_code=" + this.approve_code + ", open_num=" + this.open_num + ", apk=" + this.apk + ", apk_ver=" + this.apk_ver + ", spkg_ver=" + this.spkg_ver + ", reserve1=" + this.reserve1 + ", type=" + this.type + ", user_id=" + this.user_id + ", user_identity=" + this.user_identity + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
