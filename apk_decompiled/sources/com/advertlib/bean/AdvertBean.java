package com.advertlib.bean;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.bt;
import t9.i;

/* loaded from: classes.dex */
public final class AdvertBean {
    private String ad_version;
    private String apk_versioncode;
    private String os_version;
    private String osd_language;
    private String pic_suport;
    private String pkg;
    private String platform;
    private String sn;
    private String video_suport;

    public AdvertBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, DispatchConstants.PLATFORM);
        i.g(str2, bt.f10064y);
        i.g(str3, "ad_version");
        i.g(str4, "sn");
        i.g(str5, "osd_language");
        i.g(str6, "pic_suport");
        i.g(str7, "video_suport");
        i.g(str8, "pkg");
        i.g(str9, "apk_versioncode");
        this.platform = str;
        this.os_version = str2;
        this.ad_version = str3;
        this.sn = str4;
        this.osd_language = str5;
        this.pic_suport = str6;
        this.video_suport = str7;
        this.pkg = str8;
        this.apk_versioncode = str9;
    }

    public final String component1() {
        return this.platform;
    }

    public final String component2() {
        return this.os_version;
    }

    public final String component3() {
        return this.ad_version;
    }

    public final String component4() {
        return this.sn;
    }

    public final String component5() {
        return this.osd_language;
    }

    public final String component6() {
        return this.pic_suport;
    }

    public final String component7() {
        return this.video_suport;
    }

    public final String component8() {
        return this.pkg;
    }

    public final String component9() {
        return this.apk_versioncode;
    }

    public final AdvertBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, DispatchConstants.PLATFORM);
        i.g(str2, bt.f10064y);
        i.g(str3, "ad_version");
        i.g(str4, "sn");
        i.g(str5, "osd_language");
        i.g(str6, "pic_suport");
        i.g(str7, "video_suport");
        i.g(str8, "pkg");
        i.g(str9, "apk_versioncode");
        return new AdvertBean(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertBean)) {
            return false;
        }
        AdvertBean advertBean = (AdvertBean) obj;
        return i.b(this.platform, advertBean.platform) && i.b(this.os_version, advertBean.os_version) && i.b(this.ad_version, advertBean.ad_version) && i.b(this.sn, advertBean.sn) && i.b(this.osd_language, advertBean.osd_language) && i.b(this.pic_suport, advertBean.pic_suport) && i.b(this.video_suport, advertBean.video_suport) && i.b(this.pkg, advertBean.pkg) && i.b(this.apk_versioncode, advertBean.apk_versioncode);
    }

    public final String getAd_version() {
        return this.ad_version;
    }

    public final String getApk_versioncode() {
        return this.apk_versioncode;
    }

    public final String getOs_version() {
        return this.os_version;
    }

    public final String getOsd_language() {
        return this.osd_language;
    }

    public final String getPic_suport() {
        return this.pic_suport;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getVideo_suport() {
        return this.video_suport;
    }

    public int hashCode() {
        return (((((((((((((((this.platform.hashCode() * 31) + this.os_version.hashCode()) * 31) + this.ad_version.hashCode()) * 31) + this.sn.hashCode()) * 31) + this.osd_language.hashCode()) * 31) + this.pic_suport.hashCode()) * 31) + this.video_suport.hashCode()) * 31) + this.pkg.hashCode()) * 31) + this.apk_versioncode.hashCode();
    }

    public final void setAd_version(String str) {
        i.g(str, "<set-?>");
        this.ad_version = str;
    }

    public final void setApk_versioncode(String str) {
        i.g(str, "<set-?>");
        this.apk_versioncode = str;
    }

    public final void setOs_version(String str) {
        i.g(str, "<set-?>");
        this.os_version = str;
    }

    public final void setOsd_language(String str) {
        i.g(str, "<set-?>");
        this.osd_language = str;
    }

    public final void setPic_suport(String str) {
        i.g(str, "<set-?>");
        this.pic_suport = str;
    }

    public final void setPkg(String str) {
        i.g(str, "<set-?>");
        this.pkg = str;
    }

    public final void setPlatform(String str) {
        i.g(str, "<set-?>");
        this.platform = str;
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
    }

    public final void setVideo_suport(String str) {
        i.g(str, "<set-?>");
        this.video_suport = str;
    }

    public String toString() {
        return "AdvertBean(platform=" + this.platform + ", os_version=" + this.os_version + ", ad_version=" + this.ad_version + ", sn=" + this.sn + ", osd_language=" + this.osd_language + ", pic_suport=" + this.pic_suport + ", video_suport=" + this.video_suport + ", pkg=" + this.pkg + ", apk_versioncode=" + this.apk_versioncode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
