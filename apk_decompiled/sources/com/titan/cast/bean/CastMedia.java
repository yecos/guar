package com.titan.cast.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t1.a;
import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class CastMedia {
    private String buss;
    private String encode;
    private String episode;
    private String format;
    private String host;
    private String lang;
    private String name;
    private String play_url;
    private String program;
    private String quality;
    private long start_position;
    private String title;
    private boolean url_modified;

    public CastMedia(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j10, String str11, boolean z10) {
        i.g(str, "name");
        i.g(str2, "program");
        i.g(str3, "title");
        i.g(str4, "episode");
        i.g(str5, "buss");
        i.g(str6, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.g(str7, "encode");
        i.g(str8, "quality");
        i.g(str9, "lang");
        i.g(str10, "play_url");
        i.g(str11, Constants.KEY_HOST);
        this.name = str;
        this.program = str2;
        this.title = str3;
        this.episode = str4;
        this.buss = str5;
        this.format = str6;
        this.encode = str7;
        this.quality = str8;
        this.lang = str9;
        this.play_url = str10;
        this.start_position = j10;
        this.host = str11;
        this.url_modified = z10;
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.play_url;
    }

    public final long component11() {
        return this.start_position;
    }

    public final String component12() {
        return this.host;
    }

    public final boolean component13() {
        return this.url_modified;
    }

    public final String component2() {
        return this.program;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.episode;
    }

    public final String component5() {
        return this.buss;
    }

    public final String component6() {
        return this.format;
    }

    public final String component7() {
        return this.encode;
    }

    public final String component8() {
        return this.quality;
    }

    public final String component9() {
        return this.lang;
    }

    public final CastMedia copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j10, String str11, boolean z10) {
        i.g(str, "name");
        i.g(str2, "program");
        i.g(str3, "title");
        i.g(str4, "episode");
        i.g(str5, "buss");
        i.g(str6, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.g(str7, "encode");
        i.g(str8, "quality");
        i.g(str9, "lang");
        i.g(str10, "play_url");
        i.g(str11, Constants.KEY_HOST);
        return new CastMedia(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, j10, str11, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CastMedia)) {
            return false;
        }
        CastMedia castMedia = (CastMedia) obj;
        return i.b(this.name, castMedia.name) && i.b(this.program, castMedia.program) && i.b(this.title, castMedia.title) && i.b(this.episode, castMedia.episode) && i.b(this.buss, castMedia.buss) && i.b(this.format, castMedia.format) && i.b(this.encode, castMedia.encode) && i.b(this.quality, castMedia.quality) && i.b(this.lang, castMedia.lang) && i.b(this.play_url, castMedia.play_url) && this.start_position == castMedia.start_position && i.b(this.host, castMedia.host) && this.url_modified == castMedia.url_modified;
    }

    public final String getBuss() {
        return this.buss;
    }

    public final String getEncode() {
        return this.encode;
    }

    public final String getEpisode() {
        return this.episode;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlay_url() {
        return this.play_url;
    }

    public final String getProgram() {
        return this.program;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final long getStart_position() {
        return this.start_position;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getUrl_modified() {
        return this.url_modified;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.name.hashCode() * 31) + this.program.hashCode()) * 31) + this.title.hashCode()) * 31) + this.episode.hashCode()) * 31) + this.buss.hashCode()) * 31) + this.format.hashCode()) * 31) + this.encode.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.play_url.hashCode()) * 31) + a.a(this.start_position)) * 31) + this.host.hashCode()) * 31;
        boolean z10 = this.url_modified;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setBuss(String str) {
        i.g(str, "<set-?>");
        this.buss = str;
    }

    public final void setEncode(String str) {
        i.g(str, "<set-?>");
        this.encode = str;
    }

    public final void setEpisode(String str) {
        i.g(str, "<set-?>");
        this.episode = str;
    }

    public final void setFormat(String str) {
        i.g(str, "<set-?>");
        this.format = str;
    }

    public final void setHost(String str) {
        i.g(str, "<set-?>");
        this.host = str;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPlay_url(String str) {
        i.g(str, "<set-?>");
        this.play_url = str;
    }

    public final void setProgram(String str) {
        i.g(str, "<set-?>");
        this.program = str;
    }

    public final void setQuality(String str) {
        i.g(str, "<set-?>");
        this.quality = str;
    }

    public final void setStart_position(long j10) {
        this.start_position = j10;
    }

    public final void setTitle(String str) {
        i.g(str, "<set-?>");
        this.title = str;
    }

    public final void setUrl_modified(boolean z10) {
        this.url_modified = z10;
    }

    public String toString() {
        return "CastMedia(name=" + this.name + ", program=" + this.program + ", title=" + this.title + ", episode=" + this.episode + ", buss=" + this.buss + ", format=" + this.format + ", encode=" + this.encode + ", quality=" + this.quality + ", lang=" + this.lang + ", play_url=" + this.play_url + ", start_position=" + this.start_position + ", host=" + this.host + ", url_modified=" + this.url_modified + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
