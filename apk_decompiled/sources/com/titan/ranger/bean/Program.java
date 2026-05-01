package com.titan.ranger.bean;

import com.google.firebase.messaging.Constants;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class Program {
    private String buss;
    private String cause;
    private String episode;
    private String from;
    private String media;
    private List<Media> medias;
    private String name;
    private long start;
    private String title;

    public Program(String str, String str2, String str3, String str4, String str5, String str6, List<Media> list, String str7, long j10) {
        i.h(str, "name");
        i.h(str2, "buss");
        i.h(str3, "title");
        i.h(str4, "episode");
        i.h(str5, Constants.MessagePayloadKeys.FROM);
        i.h(str6, "cause");
        i.h(list, "medias");
        i.h(str7, "media");
        this.name = str;
        this.buss = str2;
        this.title = str3;
        this.episode = str4;
        this.from = str5;
        this.cause = str6;
        this.medias = list;
        this.media = str7;
        this.start = j10;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.buss;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.episode;
    }

    public final String component5() {
        return this.from;
    }

    public final String component6() {
        return this.cause;
    }

    public final List<Media> component7() {
        return this.medias;
    }

    public final String component8() {
        return this.media;
    }

    public final long component9() {
        return this.start;
    }

    public final Program copy(String str, String str2, String str3, String str4, String str5, String str6, List<Media> list, String str7, long j10) {
        i.h(str, "name");
        i.h(str2, "buss");
        i.h(str3, "title");
        i.h(str4, "episode");
        i.h(str5, Constants.MessagePayloadKeys.FROM);
        i.h(str6, "cause");
        i.h(list, "medias");
        i.h(str7, "media");
        return new Program(str, str2, str3, str4, str5, str6, list, str7, j10);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Program) {
                Program program = (Program) obj;
                if (i.b(this.name, program.name) && i.b(this.buss, program.buss) && i.b(this.title, program.title) && i.b(this.episode, program.episode) && i.b(this.from, program.from) && i.b(this.cause, program.cause) && i.b(this.medias, program.medias) && i.b(this.media, program.media)) {
                    if (this.start == program.start) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String getBuss() {
        return this.buss;
    }

    public final String getCause() {
        return this.cause;
    }

    public final String getEpisode() {
        return this.episode;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getMedia() {
        return this.media;
    }

    public final List<Media> getMedias() {
        return this.medias;
    }

    public final String getName() {
        return this.name;
    }

    public final long getStart() {
        return this.start;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.buss;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.episode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.from;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.cause;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<Media> list = this.medias;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str7 = this.media;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        long j10 = this.start;
        return hashCode8 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final void setBuss(String str) {
        i.h(str, "<set-?>");
        this.buss = str;
    }

    public final void setCause(String str) {
        i.h(str, "<set-?>");
        this.cause = str;
    }

    public final void setEpisode(String str) {
        i.h(str, "<set-?>");
        this.episode = str;
    }

    public final void setFrom(String str) {
        i.h(str, "<set-?>");
        this.from = str;
    }

    public final void setMedia(String str) {
        i.h(str, "<set-?>");
        this.media = str;
    }

    public final void setMedias(List<Media> list) {
        i.h(list, "<set-?>");
        this.medias = list;
    }

    public final void setName(String str) {
        i.h(str, "<set-?>");
        this.name = str;
    }

    public final void setStart(long j10) {
        this.start = j10;
    }

    public final void setTitle(String str) {
        i.h(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "Program(name=" + this.name + ", buss=" + this.buss + ", title=" + this.title + ", episode=" + this.episode + ", from=" + this.from + ", cause=" + this.cause + ", medias=" + this.medias + ", media=" + this.media + ", start=" + this.start + ")";
    }
}
