package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.f;
import t1.a;
import t9.i;

/* loaded from: classes3.dex */
public final class DataCollectApkPlayBean {
    private String action;
    private String apk_id;
    private String apk_version;
    private int caton_number;
    private long current_time;
    private String deadtime;
    private int kcp_status;
    private String media_code;
    private Long number_operations;
    private int play_time;
    private int play_url_time;
    private String provider;
    private String server_ip;
    private String sn;
    private long startup_report_time;
    private String title;
    private String trans_id;
    private String user_id;

    public DataCollectApkPlayBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, int i12, String str8, String str9, int i13, String str10, String str11, long j10, Long l10, long j11) {
        i.g(str, "trans_id");
        i.g(str2, "sn");
        i.g(str3, "user_id");
        i.g(str7, "action");
        i.g(str8, "apk_id");
        i.g(str9, "apk_version");
        i.g(str10, f.M);
        this.trans_id = str;
        this.sn = str2;
        this.user_id = str3;
        this.media_code = str4;
        this.title = str5;
        this.server_ip = str6;
        this.action = str7;
        this.caton_number = i10;
        this.play_url_time = i11;
        this.play_time = i12;
        this.apk_id = str8;
        this.apk_version = str9;
        this.kcp_status = i13;
        this.provider = str10;
        this.deadtime = str11;
        this.startup_report_time = j10;
        this.number_operations = l10;
        this.current_time = j11;
    }

    public final String component1() {
        return this.trans_id;
    }

    public final int component10() {
        return this.play_time;
    }

    public final String component11() {
        return this.apk_id;
    }

    public final String component12() {
        return this.apk_version;
    }

    public final int component13() {
        return this.kcp_status;
    }

    public final String component14() {
        return this.provider;
    }

    public final String component15() {
        return this.deadtime;
    }

    public final long component16() {
        return this.startup_report_time;
    }

    public final Long component17() {
        return this.number_operations;
    }

    public final long component18() {
        return this.current_time;
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
        return this.server_ip;
    }

    public final String component7() {
        return this.action;
    }

    public final int component8() {
        return this.caton_number;
    }

    public final int component9() {
        return this.play_url_time;
    }

    public final DataCollectApkPlayBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, int i12, String str8, String str9, int i13, String str10, String str11, long j10, Long l10, long j11) {
        i.g(str, "trans_id");
        i.g(str2, "sn");
        i.g(str3, "user_id");
        i.g(str7, "action");
        i.g(str8, "apk_id");
        i.g(str9, "apk_version");
        i.g(str10, f.M);
        return new DataCollectApkPlayBean(str, str2, str3, str4, str5, str6, str7, i10, i11, i12, str8, str9, i13, str10, str11, j10, l10, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectApkPlayBean)) {
            return false;
        }
        DataCollectApkPlayBean dataCollectApkPlayBean = (DataCollectApkPlayBean) obj;
        return i.b(this.trans_id, dataCollectApkPlayBean.trans_id) && i.b(this.sn, dataCollectApkPlayBean.sn) && i.b(this.user_id, dataCollectApkPlayBean.user_id) && i.b(this.media_code, dataCollectApkPlayBean.media_code) && i.b(this.title, dataCollectApkPlayBean.title) && i.b(this.server_ip, dataCollectApkPlayBean.server_ip) && i.b(this.action, dataCollectApkPlayBean.action) && this.caton_number == dataCollectApkPlayBean.caton_number && this.play_url_time == dataCollectApkPlayBean.play_url_time && this.play_time == dataCollectApkPlayBean.play_time && i.b(this.apk_id, dataCollectApkPlayBean.apk_id) && i.b(this.apk_version, dataCollectApkPlayBean.apk_version) && this.kcp_status == dataCollectApkPlayBean.kcp_status && i.b(this.provider, dataCollectApkPlayBean.provider) && i.b(this.deadtime, dataCollectApkPlayBean.deadtime) && this.startup_report_time == dataCollectApkPlayBean.startup_report_time && i.b(this.number_operations, dataCollectApkPlayBean.number_operations) && this.current_time == dataCollectApkPlayBean.current_time;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getApk_id() {
        return this.apk_id;
    }

    public final String getApk_version() {
        return this.apk_version;
    }

    public final int getCaton_number() {
        return this.caton_number;
    }

    public final long getCurrent_time() {
        return this.current_time;
    }

    public final String getDeadtime() {
        return this.deadtime;
    }

    public final int getKcp_status() {
        return this.kcp_status;
    }

    public final String getMedia_code() {
        return this.media_code;
    }

    public final Long getNumber_operations() {
        return this.number_operations;
    }

    public final int getPlay_time() {
        return this.play_time;
    }

    public final int getPlay_url_time() {
        return this.play_url_time;
    }

    public final String getProvider() {
        return this.provider;
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

    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        int hashCode = ((((this.trans_id.hashCode() * 31) + this.sn.hashCode()) * 31) + this.user_id.hashCode()) * 31;
        String str = this.media_code;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.server_ip;
        int hashCode4 = (((((((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.action.hashCode()) * 31) + this.caton_number) * 31) + this.play_url_time) * 31) + this.play_time) * 31) + this.apk_id.hashCode()) * 31) + this.apk_version.hashCode()) * 31) + this.kcp_status) * 31) + this.provider.hashCode()) * 31;
        String str4 = this.deadtime;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + a.a(this.startup_report_time)) * 31;
        Long l10 = this.number_operations;
        return ((hashCode5 + (l10 != null ? l10.hashCode() : 0)) * 31) + a.a(this.current_time);
    }

    public final void setAction(String str) {
        i.g(str, "<set-?>");
        this.action = str;
    }

    public final void setApk_id(String str) {
        i.g(str, "<set-?>");
        this.apk_id = str;
    }

    public final void setApk_version(String str) {
        i.g(str, "<set-?>");
        this.apk_version = str;
    }

    public final void setCaton_number(int i10) {
        this.caton_number = i10;
    }

    public final void setCurrent_time(long j10) {
        this.current_time = j10;
    }

    public final void setDeadtime(String str) {
        this.deadtime = str;
    }

    public final void setKcp_status(int i10) {
        this.kcp_status = i10;
    }

    public final void setMedia_code(String str) {
        this.media_code = str;
    }

    public final void setNumber_operations(Long l10) {
        this.number_operations = l10;
    }

    public final void setPlay_time(int i10) {
        this.play_time = i10;
    }

    public final void setPlay_url_time(int i10) {
        this.play_url_time = i10;
    }

    public final void setProvider(String str) {
        i.g(str, "<set-?>");
        this.provider = str;
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

    public final void setUser_id(String str) {
        i.g(str, "<set-?>");
        this.user_id = str;
    }

    public String toString() {
        return "DataCollectApkPlayBean(trans_id=" + this.trans_id + ", sn=" + this.sn + ", user_id=" + this.user_id + ", media_code=" + this.media_code + ", title=" + this.title + ", server_ip=" + this.server_ip + ", action=" + this.action + ", caton_number=" + this.caton_number + ", play_url_time=" + this.play_url_time + ", play_time=" + this.play_time + ", apk_id=" + this.apk_id + ", apk_version=" + this.apk_version + ", kcp_status=" + this.kcp_status + ", provider=" + this.provider + ", deadtime=" + this.deadtime + ", startup_report_time=" + this.startup_report_time + ", number_operations=" + this.number_operations + ", current_time=" + this.current_time + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
