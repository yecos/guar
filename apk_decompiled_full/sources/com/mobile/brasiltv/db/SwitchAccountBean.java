package com.mobile.brasiltv.db;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.titans.entity.CdnType;
import java.io.Serializable;
import sa.a;
import sa.e;
import t9.i;

@e(name = "switch_account")
/* loaded from: classes3.dex */
public final class SwitchAccountBean implements Serializable {

    @a(column = "id")
    private int id;
    private boolean isLogged;
    private String accountType = "";
    private String areaCode = "";
    private String userName = "";
    private String nickName = "";
    private String password = "";
    private String userId = "";
    private String email = "";
    private String phone = "";
    private String qrAuthCode = "";
    private String verificationToken = "";
    private String authCode = "";

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getAuthCode() {
        return this.authCode;
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getQrAuthCode() {
        return this.qrAuthCode;
    }

    public final String getShowName() {
        if (i.b(this.accountType, "3") || i.b(this.accountType, "4") || i.b(this.accountType, CdnType.DIGITAL_TYPE_PCDN)) {
            return '+' + this.areaCode + ' ' + this.userName;
        }
        if (i.b(this.accountType, "google")) {
            if (this.nickName.length() > 0) {
                if (!(this.userName.length() > 0)) {
                    return this.nickName;
                }
                return this.nickName + ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + this.userName + ASCIIPropertyListParser.ARRAY_END_TOKEN;
            }
        }
        return this.userName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getVerificationToken() {
        return this.verificationToken;
    }

    public final boolean isLogged() {
        return this.isLogged;
    }

    public final void setAccountType(String str) {
        i.g(str, "<set-?>");
        this.accountType = str;
    }

    public final void setAreaCode(String str) {
        i.g(str, "<set-?>");
        this.areaCode = str;
    }

    public final void setAuthCode(String str) {
        i.g(str, "<set-?>");
        this.authCode = str;
    }

    public final void setEmail(String str) {
        i.g(str, "<set-?>");
        this.email = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setLogged(boolean z10) {
        this.isLogged = z10;
    }

    public final void setNickName(String str) {
        i.g(str, "<set-?>");
        this.nickName = str;
    }

    public final void setPassword(String str) {
        i.g(str, "<set-?>");
        this.password = str;
    }

    public final void setPhone(String str) {
        i.g(str, "<set-?>");
        this.phone = str;
    }

    public final void setQrAuthCode(String str) {
        i.g(str, "<set-?>");
        this.qrAuthCode = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserName(String str) {
        i.g(str, "<set-?>");
        this.userName = str;
    }

    public final void setVerificationToken(String str) {
        i.g(str, "<set-?>");
        this.verificationToken = str;
    }
}
