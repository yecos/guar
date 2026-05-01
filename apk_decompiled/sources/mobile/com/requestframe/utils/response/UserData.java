package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class UserData {
    private String accountType;
    private String activeTime;
    private String appModel;
    private String areaCode;
    private String areaFlag;
    private List<AuthInfo> authInfoList;
    private int availableTime;
    private String bindGoogle;
    private String bindGoogleEmail;
    private String bindMail;
    private String bindMobile;
    private String cacheTime;
    private String childLockPwd;
    private String customer;
    private String email;
    private Integer expRemainingDays;
    private String getFreeAuthDays;
    private String getFreeAuthFlag;
    private String googleEmail;
    private String googleNickName;
    private String googlePhotoUrl;
    private String hasFreeAuth;
    private String hasPay;
    private String hasPwd;
    private String heartBeatTime;
    private String inviteCode;
    private String invitedStatus;

    /* renamed from: mobile, reason: collision with root package name */
    private String f16875mobile;
    private String nowTime;
    private String payCoreAddress;
    private String playlistUrl;
    private List<PortalCodeList> portalCodeList;
    private String pwdTip;
    private String qrcodeDisplay;
    private String qrcodeMessage;
    private Integer remainingDays;
    private String renewFlag;
    private String restrictedStatus;
    private String showFlag;
    private String showType;
    private String tips;
    private String type;
    private String userId;
    private String userIdentity;
    private String userToken;
    private String userType;
    private String verificationToken;

    public UserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, Integer num, Integer num2, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, List<AuthInfo> list, String str34, String str35, String str36, String str37, int i10, String str38, String str39, String str40, String str41, List<PortalCodeList> list2, String str42) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str6, "hasPay");
        i.g(str7, "restrictedStatus");
        i.g(str8, "hasPwd");
        i.g(str10, "userIdentity");
        i.g(str11, "bindGoogleEmail");
        i.g(str12, "googleEmail");
        i.g(str13, "appModel");
        this.userId = str;
        this.userToken = str2;
        this.customer = str3;
        this.bindMail = str4;
        this.email = str5;
        this.hasPay = str6;
        this.restrictedStatus = str7;
        this.hasPwd = str8;
        this.childLockPwd = str9;
        this.userIdentity = str10;
        this.bindGoogleEmail = str11;
        this.googleEmail = str12;
        this.appModel = str13;
        this.accountType = str14;
        this.areaCode = str15;
        this.f16875mobile = str16;
        this.bindMobile = str17;
        this.cacheTime = str18;
        this.heartBeatTime = str19;
        this.nowTime = str20;
        this.tips = str21;
        this.type = str22;
        this.remainingDays = num;
        this.expRemainingDays = num2;
        this.qrcodeMessage = str23;
        this.qrcodeDisplay = str24;
        this.payCoreAddress = str25;
        this.userType = str26;
        this.getFreeAuthFlag = str27;
        this.getFreeAuthDays = str28;
        this.hasFreeAuth = str29;
        this.showFlag = str30;
        this.showType = str31;
        this.renewFlag = str32;
        this.areaFlag = str33;
        this.authInfoList = list;
        this.verificationToken = str34;
        this.googleNickName = str35;
        this.googlePhotoUrl = str36;
        this.bindGoogle = str37;
        this.availableTime = i10;
        this.activeTime = str38;
        this.inviteCode = str39;
        this.invitedStatus = str40;
        this.playlistUrl = str41;
        this.portalCodeList = list2;
        this.pwdTip = str42;
    }

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.userIdentity;
    }

    public final String component11() {
        return this.bindGoogleEmail;
    }

    public final String component12() {
        return this.googleEmail;
    }

    public final String component13() {
        return this.appModel;
    }

    public final String component14() {
        return this.accountType;
    }

    public final String component15() {
        return this.areaCode;
    }

    public final String component16() {
        return this.f16875mobile;
    }

    public final String component17() {
        return this.bindMobile;
    }

    public final String component18() {
        return this.cacheTime;
    }

    public final String component19() {
        return this.heartBeatTime;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component20() {
        return this.nowTime;
    }

    public final String component21() {
        return this.tips;
    }

    public final String component22() {
        return this.type;
    }

    public final Integer component23() {
        return this.remainingDays;
    }

    public final Integer component24() {
        return this.expRemainingDays;
    }

    public final String component25() {
        return this.qrcodeMessage;
    }

    public final String component26() {
        return this.qrcodeDisplay;
    }

    public final String component27() {
        return this.payCoreAddress;
    }

    public final String component28() {
        return this.userType;
    }

    public final String component29() {
        return this.getFreeAuthFlag;
    }

    public final String component3() {
        return this.customer;
    }

    public final String component30() {
        return this.getFreeAuthDays;
    }

    public final String component31() {
        return this.hasFreeAuth;
    }

    public final String component32() {
        return this.showFlag;
    }

    public final String component33() {
        return this.showType;
    }

    public final String component34() {
        return this.renewFlag;
    }

    public final String component35() {
        return this.areaFlag;
    }

    public final List<AuthInfo> component36() {
        return this.authInfoList;
    }

    public final String component37() {
        return this.verificationToken;
    }

    public final String component38() {
        return this.googleNickName;
    }

    public final String component39() {
        return this.googlePhotoUrl;
    }

    public final String component4() {
        return this.bindMail;
    }

    public final String component40() {
        return this.bindGoogle;
    }

    public final int component41() {
        return this.availableTime;
    }

    public final String component42() {
        return this.activeTime;
    }

    public final String component43() {
        return this.inviteCode;
    }

    public final String component44() {
        return this.invitedStatus;
    }

    public final String component45() {
        return this.playlistUrl;
    }

    public final List<PortalCodeList> component46() {
        return this.portalCodeList;
    }

    public final String component47() {
        return this.pwdTip;
    }

    public final String component5() {
        return this.email;
    }

    public final String component6() {
        return this.hasPay;
    }

    public final String component7() {
        return this.restrictedStatus;
    }

    public final String component8() {
        return this.hasPwd;
    }

    public final String component9() {
        return this.childLockPwd;
    }

    public final UserData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, Integer num, Integer num2, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, List<AuthInfo> list, String str34, String str35, String str36, String str37, int i10, String str38, String str39, String str40, String str41, List<PortalCodeList> list2, String str42) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str6, "hasPay");
        i.g(str7, "restrictedStatus");
        i.g(str8, "hasPwd");
        i.g(str10, "userIdentity");
        i.g(str11, "bindGoogleEmail");
        i.g(str12, "googleEmail");
        i.g(str13, "appModel");
        return new UserData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num, num2, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, list, str34, str35, str36, str37, i10, str38, str39, str40, str41, list2, str42);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserData)) {
            return false;
        }
        UserData userData = (UserData) obj;
        return i.b(this.userId, userData.userId) && i.b(this.userToken, userData.userToken) && i.b(this.customer, userData.customer) && i.b(this.bindMail, userData.bindMail) && i.b(this.email, userData.email) && i.b(this.hasPay, userData.hasPay) && i.b(this.restrictedStatus, userData.restrictedStatus) && i.b(this.hasPwd, userData.hasPwd) && i.b(this.childLockPwd, userData.childLockPwd) && i.b(this.userIdentity, userData.userIdentity) && i.b(this.bindGoogleEmail, userData.bindGoogleEmail) && i.b(this.googleEmail, userData.googleEmail) && i.b(this.appModel, userData.appModel) && i.b(this.accountType, userData.accountType) && i.b(this.areaCode, userData.areaCode) && i.b(this.f16875mobile, userData.f16875mobile) && i.b(this.bindMobile, userData.bindMobile) && i.b(this.cacheTime, userData.cacheTime) && i.b(this.heartBeatTime, userData.heartBeatTime) && i.b(this.nowTime, userData.nowTime) && i.b(this.tips, userData.tips) && i.b(this.type, userData.type) && i.b(this.remainingDays, userData.remainingDays) && i.b(this.expRemainingDays, userData.expRemainingDays) && i.b(this.qrcodeMessage, userData.qrcodeMessage) && i.b(this.qrcodeDisplay, userData.qrcodeDisplay) && i.b(this.payCoreAddress, userData.payCoreAddress) && i.b(this.userType, userData.userType) && i.b(this.getFreeAuthFlag, userData.getFreeAuthFlag) && i.b(this.getFreeAuthDays, userData.getFreeAuthDays) && i.b(this.hasFreeAuth, userData.hasFreeAuth) && i.b(this.showFlag, userData.showFlag) && i.b(this.showType, userData.showType) && i.b(this.renewFlag, userData.renewFlag) && i.b(this.areaFlag, userData.areaFlag) && i.b(this.authInfoList, userData.authInfoList) && i.b(this.verificationToken, userData.verificationToken) && i.b(this.googleNickName, userData.googleNickName) && i.b(this.googlePhotoUrl, userData.googlePhotoUrl) && i.b(this.bindGoogle, userData.bindGoogle) && this.availableTime == userData.availableTime && i.b(this.activeTime, userData.activeTime) && i.b(this.inviteCode, userData.inviteCode) && i.b(this.invitedStatus, userData.invitedStatus) && i.b(this.playlistUrl, userData.playlistUrl) && i.b(this.portalCodeList, userData.portalCodeList) && i.b(this.pwdTip, userData.pwdTip);
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getActiveTime() {
        return this.activeTime;
    }

    public final String getAppModel() {
        return this.appModel;
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getAreaFlag() {
        return this.areaFlag;
    }

    public final List<AuthInfo> getAuthInfoList() {
        return this.authInfoList;
    }

    public final int getAvailableTime() {
        return this.availableTime;
    }

    public final String getBindGoogle() {
        return this.bindGoogle;
    }

    public final String getBindGoogleEmail() {
        return this.bindGoogleEmail;
    }

    public final String getBindMail() {
        return this.bindMail;
    }

    public final String getBindMobile() {
        return this.bindMobile;
    }

    public final String getCacheTime() {
        return this.cacheTime;
    }

    public final String getChildLockPwd() {
        return this.childLockPwd;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Integer getExpRemainingDays() {
        return this.expRemainingDays;
    }

    public final String getGetFreeAuthDays() {
        return this.getFreeAuthDays;
    }

    public final String getGetFreeAuthFlag() {
        return this.getFreeAuthFlag;
    }

    public final String getGoogleEmail() {
        return this.googleEmail;
    }

    public final String getGoogleNickName() {
        return this.googleNickName;
    }

    public final String getGooglePhotoUrl() {
        return this.googlePhotoUrl;
    }

    public final String getHasFreeAuth() {
        return this.hasFreeAuth;
    }

    public final String getHasPay() {
        return this.hasPay;
    }

    public final String getHasPwd() {
        return this.hasPwd;
    }

    public final String getHeartBeatTime() {
        return this.heartBeatTime;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final String getInvitedStatus() {
        return this.invitedStatus;
    }

    public final String getMobile() {
        return this.f16875mobile;
    }

    public final String getNowTime() {
        return this.nowTime;
    }

    public final String getPayCoreAddress() {
        return this.payCoreAddress;
    }

    public final String getPlaylistUrl() {
        return this.playlistUrl;
    }

    public final List<PortalCodeList> getPortalCodeList() {
        return this.portalCodeList;
    }

    public final String getPwdTip() {
        return this.pwdTip;
    }

    public final String getQrcodeDisplay() {
        return this.qrcodeDisplay;
    }

    public final String getQrcodeMessage() {
        return this.qrcodeMessage;
    }

    public final Integer getRemainingDays() {
        return this.remainingDays;
    }

    public final String getRenewFlag() {
        return this.renewFlag;
    }

    public final String getRestrictedStatus() {
        return this.restrictedStatus;
    }

    public final String getShowFlag() {
        return this.showFlag;
    }

    public final String getShowType() {
        return this.showType;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserIdentity() {
        return this.userIdentity;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final String getVerificationToken() {
        return this.verificationToken;
    }

    public int hashCode() {
        int hashCode = ((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31;
        String str = this.customer;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bindMail;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode4 = (((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.hasPay.hashCode()) * 31) + this.restrictedStatus.hashCode()) * 31) + this.hasPwd.hashCode()) * 31;
        String str4 = this.childLockPwd;
        int hashCode5 = (((((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.userIdentity.hashCode()) * 31) + this.bindGoogleEmail.hashCode()) * 31) + this.googleEmail.hashCode()) * 31) + this.appModel.hashCode()) * 31;
        String str5 = this.accountType;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.areaCode;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f16875mobile;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.bindMobile;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.cacheTime;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.heartBeatTime;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.nowTime;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.tips;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.type;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num = this.remainingDays;
        int hashCode15 = (hashCode14 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.expRemainingDays;
        int hashCode16 = (hashCode15 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str14 = this.qrcodeMessage;
        int hashCode17 = (hashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.qrcodeDisplay;
        int hashCode18 = (hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.payCoreAddress;
        int hashCode19 = (hashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.userType;
        int hashCode20 = (hashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.getFreeAuthFlag;
        int hashCode21 = (hashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.getFreeAuthDays;
        int hashCode22 = (hashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.hasFreeAuth;
        int hashCode23 = (hashCode22 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.showFlag;
        int hashCode24 = (hashCode23 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.showType;
        int hashCode25 = (hashCode24 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.renewFlag;
        int hashCode26 = (hashCode25 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.areaFlag;
        int hashCode27 = (hashCode26 + (str24 == null ? 0 : str24.hashCode())) * 31;
        List<AuthInfo> list = this.authInfoList;
        int hashCode28 = (hashCode27 + (list == null ? 0 : list.hashCode())) * 31;
        String str25 = this.verificationToken;
        int hashCode29 = (hashCode28 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.googleNickName;
        int hashCode30 = (hashCode29 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.googlePhotoUrl;
        int hashCode31 = (hashCode30 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.bindGoogle;
        int hashCode32 = (((hashCode31 + (str28 == null ? 0 : str28.hashCode())) * 31) + this.availableTime) * 31;
        String str29 = this.activeTime;
        int hashCode33 = (hashCode32 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.inviteCode;
        int hashCode34 = (hashCode33 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.invitedStatus;
        int hashCode35 = (hashCode34 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.playlistUrl;
        int hashCode36 = (hashCode35 + (str32 == null ? 0 : str32.hashCode())) * 31;
        List<PortalCodeList> list2 = this.portalCodeList;
        int hashCode37 = (hashCode36 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str33 = this.pwdTip;
        return hashCode37 + (str33 != null ? str33.hashCode() : 0);
    }

    public final void setAccountType(String str) {
        this.accountType = str;
    }

    public final void setActiveTime(String str) {
        this.activeTime = str;
    }

    public final void setAppModel(String str) {
        i.g(str, "<set-?>");
        this.appModel = str;
    }

    public final void setAreaCode(String str) {
        this.areaCode = str;
    }

    public final void setAreaFlag(String str) {
        this.areaFlag = str;
    }

    public final void setAuthInfoList(List<AuthInfo> list) {
        this.authInfoList = list;
    }

    public final void setAvailableTime(int i10) {
        this.availableTime = i10;
    }

    public final void setBindGoogle(String str) {
        this.bindGoogle = str;
    }

    public final void setBindGoogleEmail(String str) {
        i.g(str, "<set-?>");
        this.bindGoogleEmail = str;
    }

    public final void setBindMail(String str) {
        this.bindMail = str;
    }

    public final void setBindMobile(String str) {
        this.bindMobile = str;
    }

    public final void setCacheTime(String str) {
        this.cacheTime = str;
    }

    public final void setChildLockPwd(String str) {
        this.childLockPwd = str;
    }

    public final void setCustomer(String str) {
        this.customer = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setExpRemainingDays(Integer num) {
        this.expRemainingDays = num;
    }

    public final void setGetFreeAuthDays(String str) {
        this.getFreeAuthDays = str;
    }

    public final void setGetFreeAuthFlag(String str) {
        this.getFreeAuthFlag = str;
    }

    public final void setGoogleEmail(String str) {
        i.g(str, "<set-?>");
        this.googleEmail = str;
    }

    public final void setGoogleNickName(String str) {
        this.googleNickName = str;
    }

    public final void setGooglePhotoUrl(String str) {
        this.googlePhotoUrl = str;
    }

    public final void setHasFreeAuth(String str) {
        this.hasFreeAuth = str;
    }

    public final void setHasPay(String str) {
        i.g(str, "<set-?>");
        this.hasPay = str;
    }

    public final void setHasPwd(String str) {
        i.g(str, "<set-?>");
        this.hasPwd = str;
    }

    public final void setHeartBeatTime(String str) {
        this.heartBeatTime = str;
    }

    public final void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public final void setInvitedStatus(String str) {
        this.invitedStatus = str;
    }

    public final void setMobile(String str) {
        this.f16875mobile = str;
    }

    public final void setNowTime(String str) {
        this.nowTime = str;
    }

    public final void setPayCoreAddress(String str) {
        this.payCoreAddress = str;
    }

    public final void setPlaylistUrl(String str) {
        this.playlistUrl = str;
    }

    public final void setPortalCodeList(List<PortalCodeList> list) {
        this.portalCodeList = list;
    }

    public final void setPwdTip(String str) {
        this.pwdTip = str;
    }

    public final void setQrcodeDisplay(String str) {
        this.qrcodeDisplay = str;
    }

    public final void setQrcodeMessage(String str) {
        this.qrcodeMessage = str;
    }

    public final void setRemainingDays(Integer num) {
        this.remainingDays = num;
    }

    public final void setRenewFlag(String str) {
        this.renewFlag = str;
    }

    public final void setRestrictedStatus(String str) {
        i.g(str, "<set-?>");
        this.restrictedStatus = str;
    }

    public final void setShowFlag(String str) {
        this.showFlag = str;
    }

    public final void setShowType(String str) {
        this.showType = str;
    }

    public final void setTips(String str) {
        this.tips = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserIdentity(String str) {
        i.g(str, "<set-?>");
        this.userIdentity = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public final void setVerificationToken(String str) {
        this.verificationToken = str;
    }

    public String toString() {
        return "UserData(userId=" + this.userId + ", userToken=" + this.userToken + ", customer=" + this.customer + ", bindMail=" + this.bindMail + ", email=" + this.email + ", hasPay=" + this.hasPay + ", restrictedStatus=" + this.restrictedStatus + ", hasPwd=" + this.hasPwd + ", childLockPwd=" + this.childLockPwd + ", userIdentity=" + this.userIdentity + ", bindGoogleEmail=" + this.bindGoogleEmail + ", googleEmail=" + this.googleEmail + ", appModel=" + this.appModel + ", accountType=" + this.accountType + ", areaCode=" + this.areaCode + ", mobile=" + this.f16875mobile + ", bindMobile=" + this.bindMobile + ", cacheTime=" + this.cacheTime + ", heartBeatTime=" + this.heartBeatTime + ", nowTime=" + this.nowTime + ", tips=" + this.tips + ", type=" + this.type + ", remainingDays=" + this.remainingDays + ", expRemainingDays=" + this.expRemainingDays + ", qrcodeMessage=" + this.qrcodeMessage + ", qrcodeDisplay=" + this.qrcodeDisplay + ", payCoreAddress=" + this.payCoreAddress + ", userType=" + this.userType + ", getFreeAuthFlag=" + this.getFreeAuthFlag + ", getFreeAuthDays=" + this.getFreeAuthDays + ", hasFreeAuth=" + this.hasFreeAuth + ", showFlag=" + this.showFlag + ", showType=" + this.showType + ", renewFlag=" + this.renewFlag + ", areaFlag=" + this.areaFlag + ", authInfoList=" + this.authInfoList + ", verificationToken=" + this.verificationToken + ", googleNickName=" + this.googleNickName + ", googlePhotoUrl=" + this.googlePhotoUrl + ", bindGoogle=" + this.bindGoogle + ", availableTime=" + this.availableTime + ", activeTime=" + this.activeTime + ", inviteCode=" + this.inviteCode + ", invitedStatus=" + this.invitedStatus + ", playlistUrl=" + this.playlistUrl + ", portalCodeList=" + this.portalCodeList + ", pwdTip=" + this.pwdTip + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
