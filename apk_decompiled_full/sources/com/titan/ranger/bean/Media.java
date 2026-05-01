package com.titan.ranger.bean;

import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class Media {
    private String format;
    private String lang;
    private String license;
    private String name;
    private String quality;
    private String vcodec;

    public Media(String str, String str2, String str3, String str4, String str5, String str6) {
        i.h(str, "name");
        i.h(str2, "license");
        i.h(str3, "lang");
        i.h(str4, "quality");
        i.h(str5, "vcodec");
        i.h(str6, IjkMediaMeta.IJKM_KEY_FORMAT);
        this.name = str;
        this.license = str2;
        this.lang = str3;
        this.quality = str4;
        this.vcodec = str5;
        this.format = str6;
    }

    public static /* synthetic */ Media copy$default(Media media, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = media.name;
        }
        if ((i10 & 2) != 0) {
            str2 = media.license;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = media.lang;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = media.quality;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = media.vcodec;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = media.format;
        }
        return media.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.license;
    }

    public final String component3() {
        return this.lang;
    }

    public final String component4() {
        return this.quality;
    }

    public final String component5() {
        return this.vcodec;
    }

    public final String component6() {
        return this.format;
    }

    public final Media copy(String str, String str2, String str3, String str4, String str5, String str6) {
        i.h(str, "name");
        i.h(str2, "license");
        i.h(str3, "lang");
        i.h(str4, "quality");
        i.h(str5, "vcodec");
        i.h(str6, IjkMediaMeta.IJKM_KEY_FORMAT);
        return new Media(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media media = (Media) obj;
        return i.b(this.name, media.name) && i.b(this.license, media.license) && i.b(this.lang, media.lang) && i.b(this.quality, media.quality) && i.b(this.vcodec, media.vcodec) && i.b(this.format, media.format);
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getName() {
        return this.name;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getVcodec() {
        return this.vcodec;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.license;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lang;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.quality;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.vcodec;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.format;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setFormat(String str) {
        i.h(str, "<set-?>");
        this.format = str;
    }

    public final void setLang(String str) {
        i.h(str, "<set-?>");
        this.lang = str;
    }

    public final void setLicense(String str) {
        i.h(str, "<set-?>");
        this.license = str;
    }

    public final void setName(String str) {
        i.h(str, "<set-?>");
        this.name = str;
    }

    public final void setQuality(String str) {
        i.h(str, "<set-?>");
        this.quality = str;
    }

    public final void setVcodec(String str) {
        i.h(str, "<set-?>");
        this.vcodec = str;
    }

    public String toString() {
        return "Media(name=" + this.name + ", license=" + this.license + ", lang=" + this.lang + ", quality=" + this.quality + ", vcodec=" + this.vcodec + ", format=" + this.format + ")";
    }
}
