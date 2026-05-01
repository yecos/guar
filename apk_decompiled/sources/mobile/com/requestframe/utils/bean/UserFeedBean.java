package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class UserFeedBean {
    private final String appVersion;
    private String customer;
    private final String definition;
    private final String email;

    /* renamed from: mobile, reason: collision with root package name */
    private final String f16873mobile;
    private final String pkg;
    private final String programName;
    private final String questionsId;
    private final String screenType;
    private final String tvModel;
    private final String type;
    private final String typeId;
    private final String userId;
    private final String userName;
    private final String userOperateSys;
    private final String userSug;

    public UserFeedBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        i.g(str, "type");
        i.g(str4, "pkg");
        i.g(str5, "userName");
        i.g(str6, "userId");
        i.g(str7, "programName");
        i.g(str8, "userOperateSys");
        this.type = str;
        this.typeId = str2;
        this.questionsId = str3;
        this.pkg = str4;
        this.userName = str5;
        this.userId = str6;
        this.programName = str7;
        this.userOperateSys = str8;
        this.tvModel = str9;
        this.screenType = str10;
        this.definition = str11;
        this.customer = str12;
        this.userSug = str13;
        this.email = str14;
        this.f16873mobile = str15;
        this.appVersion = str16;
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.screenType;
    }

    public final String component11() {
        return this.definition;
    }

    public final String component12() {
        return this.customer;
    }

    public final String component13() {
        return this.userSug;
    }

    public final String component14() {
        return this.email;
    }

    public final String component15() {
        return this.f16873mobile;
    }

    public final String component16() {
        return this.appVersion;
    }

    public final String component2() {
        return this.typeId;
    }

    public final String component3() {
        return this.questionsId;
    }

    public final String component4() {
        return this.pkg;
    }

    public final String component5() {
        return this.userName;
    }

    public final String component6() {
        return this.userId;
    }

    public final String component7() {
        return this.programName;
    }

    public final String component8() {
        return this.userOperateSys;
    }

    public final String component9() {
        return this.tvModel;
    }

    public final UserFeedBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        i.g(str, "type");
        i.g(str4, "pkg");
        i.g(str5, "userName");
        i.g(str6, "userId");
        i.g(str7, "programName");
        i.g(str8, "userOperateSys");
        return new UserFeedBean(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserFeedBean)) {
            return false;
        }
        UserFeedBean userFeedBean = (UserFeedBean) obj;
        return i.b(this.type, userFeedBean.type) && i.b(this.typeId, userFeedBean.typeId) && i.b(this.questionsId, userFeedBean.questionsId) && i.b(this.pkg, userFeedBean.pkg) && i.b(this.userName, userFeedBean.userName) && i.b(this.userId, userFeedBean.userId) && i.b(this.programName, userFeedBean.programName) && i.b(this.userOperateSys, userFeedBean.userOperateSys) && i.b(this.tvModel, userFeedBean.tvModel) && i.b(this.screenType, userFeedBean.screenType) && i.b(this.definition, userFeedBean.definition) && i.b(this.customer, userFeedBean.customer) && i.b(this.userSug, userFeedBean.userSug) && i.b(this.email, userFeedBean.email) && i.b(this.f16873mobile, userFeedBean.f16873mobile) && i.b(this.appVersion, userFeedBean.appVersion);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final String getDefinition() {
        return this.definition;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getMobile() {
        return this.f16873mobile;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final String getQuestionsId() {
        return this.questionsId;
    }

    public final String getScreenType() {
        return this.screenType;
    }

    public final String getTvModel() {
        return this.tvModel;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTypeId() {
        return this.typeId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserOperateSys() {
        return this.userOperateSys;
    }

    public final String getUserSug() {
        return this.userSug;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.typeId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.questionsId;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.pkg.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.programName.hashCode()) * 31) + this.userOperateSys.hashCode()) * 31;
        String str3 = this.tvModel;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.screenType;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.definition;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.customer;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.userSug;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.email;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f16873mobile;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.appVersion;
        return hashCode10 + (str10 != null ? str10.hashCode() : 0);
    }

    public final void setCustomer(String str) {
        this.customer = str;
    }

    public String toString() {
        return "UserFeedBean(type=" + this.type + ", typeId=" + this.typeId + ", questionsId=" + this.questionsId + ", pkg=" + this.pkg + ", userName=" + this.userName + ", userId=" + this.userId + ", programName=" + this.programName + ", userOperateSys=" + this.userOperateSys + ", tvModel=" + this.tvModel + ", screenType=" + this.screenType + ", definition=" + this.definition + ", customer=" + this.customer + ", userSug=" + this.userSug + ", email=" + this.email + ", mobile=" + this.f16873mobile + ", appVersion=" + this.appVersion + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ UserFeedBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i10, g gVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, str4, str5, str6, str7, (i10 & 128) != 0 ? "phone" : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : str10, (i10 & 1024) != 0 ? null : str11, (i10 & 2048) != 0 ? null : str12, (i10 & 4096) != 0 ? null : str13, (i10 & 8192) != 0 ? null : str14, (i10 & 16384) != 0 ? null : str15, (i10 & 32768) != 0 ? null : str16);
    }
}
