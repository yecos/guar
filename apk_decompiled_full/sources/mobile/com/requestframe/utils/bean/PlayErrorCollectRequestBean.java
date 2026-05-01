package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t1.a;
import t9.i;

/* loaded from: classes3.dex */
public final class PlayErrorCollectRequestBean {
    private String apk_id;
    private String apk_version;
    private long current_time;
    private String deadtime;
    private String error_code;
    private String media_code;
    private String module_name;
    private Long number_operations;
    private Integer response_time;
    private String server_ip;
    private String sn;
    private long startup_report_time;
    private String title;
    private String trans_id;
    private String type;
    private String user_id;

    public PlayErrorCollectRequestBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, String str11, long j10, Long l10, long j11, String str12) {
        i.g(str, "trans_id");
        i.g(str2, "sn");
        i.g(str3, "user_id");
        i.g(str6, "module_name");
        i.g(str8, "apk_id");
        i.g(str9, "apk_version");
        i.g(str10, "error_code");
        this.trans_id = str;
        this.sn = str2;
        this.user_id = str3;
        this.media_code = str4;
        this.title = str5;
        this.module_name = str6;
        this.server_ip = str7;
        this.apk_id = str8;
        this.apk_version = str9;
        this.error_code = str10;
        this.response_time = num;
        this.deadtime = str11;
        this.startup_report_time = j10;
        this.number_operations = l10;
        this.current_time = j11;
        this.type = str12;
    }

    public final String component1() {
        return this.trans_id;
    }

    public final String component10() {
        return this.error_code;
    }

    public final Integer component11() {
        return this.response_time;
    }

    public final String component12() {
        return this.deadtime;
    }

    public final long component13() {
        return this.startup_report_time;
    }

    public final Long component14() {
        return this.number_operations;
    }

    public final long component15() {
        return this.current_time;
    }

    public final String component16() {
        return this.type;
    }

    public final String component2() {
        return this.sn;
    }

    public final String component3() {
        return this.user_id;
    }

    public final String component4() {
        return this.media_code;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.module_name;
    }

    public final String component7() {
        return this.server_ip;
    }

    public final String component8() {
        return this.apk_id;
    }

    public final String component9() {
        return this.apk_version;
    }

    public final PlayErrorCollectRequestBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, String str11, long j10, Long l10, long j11, String str12) {
        i.g(str, "trans_id");
        i.g(str2, "sn");
        i.g(str3, "user_id");
        i.g(str6, "module_name");
        i.g(str8, "apk_id");
        i.g(str9, "apk_version");
        i.g(str10, "error_code");
        return new PlayErrorCollectRequestBean(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, num, str11, j10, l10, j11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayErrorCollectRequestBean)) {
            return false;
        }
        PlayErrorCollectRequestBean playErrorCollectRequestBean = (PlayErrorCollectRequestBean) obj;
        return i.b(this.trans_id, playErrorCollectRequestBean.trans_id) && i.b(this.sn, playErrorCollectRequestBean.sn) && i.b(this.user_id, playErrorCollectRequestBean.user_id) && i.b(this.media_code, playErrorCollectRequestBean.media_code) && i.b(this.title, playErrorCollectRequestBean.title) && i.b(this.module_name, playErrorCollectRequestBean.module_name) && i.b(this.server_ip, playErrorCollectRequestBean.server_ip) && i.b(this.apk_id, playErrorCollectRequestBean.apk_id) && i.b(this.apk_version, playErrorCollectRequestBean.apk_version) && i.b(this.error_code, playErrorCollectRequestBean.error_code) && i.b(this.response_time, playErrorCollectRequestBean.response_time) && i.b(this.deadtime, playErrorCollectRequestBean.deadtime) && this.startup_report_time == playErrorCollectRequestBean.startup_report_time && i.b(this.number_operations, playErrorCollectRequestBean.number_operations) && this.current_time == playErrorCollectRequestBean.current_time && i.b(this.type, playErrorCollectRequestBean.type);
    }

    public final String getApk_id() {
        return this.apk_id;
    }

    public final String getApk_version() {
        return this.apk_version;
    }

    public final long getCurrent_time() {
        return this.current_time;
    }

    public final String getDeadtime() {
        return this.deadtime;
    }

    public final String getError_code() {
        return this.error_code;
    }

    public final String getMedia_code() {
        return this.media_code;
    }

    public final String getModule_name() {
        return this.module_name;
    }

    public final Long getNumber_operations() {
        return this.number_operations;
    }

    public final Integer getResponse_time() {
        return this.response_time;
    }

    public final String getServer_ip() {
        return this.server_ip;
    }

    public final String getSn() {
        return this.sn;
    }

    public final long getStartup_report_time() {
        return this.startup_report_time;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTrans_id() {
        return this.trans_id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        int hashCode = ((((this.trans_id.hashCode() * 31) + this.sn.hashCode()) * 31) + this.user_id.hashCode()) * 31;
        String str = this.media_code;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.module_name.hashCode()) * 31;
        String str3 = this.server_ip;
        int hashCode4 = (((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.apk_id.hashCode()) * 31) + this.apk_version.hashCode()) * 31) + this.error_code.hashCode()) * 31;
        Integer num = this.response_time;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.deadtime;
        int hashCode6 = (((hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + a.a(this.startup_report_time)) * 31;
        Long l10 = this.number_operations;
        int hashCode7 = (((hashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31) + a.a(this.current_time)) * 31;
        String str5 = this.type;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setApk_id(String str) {
        i.g(str, "<set-?>");
        this.apk_id = str;
    }

    public final void setApk_version(String str) {
        i.g(str, "<set-?>");
        this.apk_version = str;
    }

    public final void setCurrent_time(long j10) {
        this.current_time = j10;
    }

    public final void setDeadtime(String str) {
        this.deadtime = str;
    }

    public final void setError_code(String str) {
        i.g(str, "<set-?>");
        this.error_code = str;
    }

    public final void setMedia_code(String str) {
        this.media_code = str;
    }

    public final void setModule_name(String str) {
        i.g(str, "<set-?>");
        this.module_name = str;
    }

    public final void setNumber_operations(Long l10) {
        this.number_operations = l10;
    }

    public final void setResponse_time(Integer num) {
        this.response_time = num;
    }

    public final void setServer_ip(String str) {
        this.server_ip = str;
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
    }

    public final void setStartup_report_time(long j10) {
        this.startup_report_time = j10;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTrans_id(String str) {
        i.g(str, "<set-?>");
        this.trans_id = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUser_id(String str) {
        i.g(str, "<set-?>");
        this.user_id = str;
    }

    public String toString() {
        return "PlayErrorCollectRequestBean(trans_id=" + this.trans_id + ", sn=" + this.sn + ", user_id=" + this.user_id + ", media_code=" + this.media_code + ", title=" + this.title + ", module_name=" + this.module_name + ", server_ip=" + this.server_ip + ", apk_id=" + this.apk_id + ", apk_version=" + this.apk_version + ", error_code=" + this.error_code + ", response_time=" + this.response_time + ", deadtime=" + this.deadtime + ", startup_report_time=" + this.startup_report_time + ", number_operations=" + this.number_operations + ", current_time=" + this.current_time + ", type=" + this.type + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
