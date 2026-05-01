package com.titan.ranger.bean;

import com.google.firebase.messaging.Constants;
import t9.i;

/* loaded from: classes3.dex */
public final class MediaFile {
    private String buss;
    private String from;
    private String media;
    private String program;
    private String title;
    private String uri;

    public MediaFile(String str, String str2, String str3, String str4, String str5, String str6) {
        i.h(str, "program");
        i.h(str2, "media");
        i.h(str3, "title");
        i.h(str4, "buss");
        i.h(str5, Constants.MessagePayloadKeys.FROM);
        i.h(str6, "uri");
        this.program = str;
        this.media = str2;
        this.title = str3;
        this.buss = str4;
        this.from = str5;
        this.uri = str6;
    }

    public static /* synthetic */ MediaFile copy$default(MediaFile mediaFile, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mediaFile.program;
        }
        if ((i10 & 2) != 0) {
            str2 = mediaFile.media;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = mediaFile.title;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = mediaFile.buss;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = mediaFile.from;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = mediaFile.uri;
        }
        return mediaFile.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.program;
    }

    public final String component2() {
        return this.media;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.buss;
    }

    public final String component5() {
        return this.from;
    }

    public final String component6() {
        return this.uri;
    }

    public final MediaFile copy(String str, String str2, String str3, String str4, String str5, String str6) {
        i.h(str, "program");
        i.h(str2, "media");
        i.h(str3, "title");
        i.h(str4, "buss");
        i.h(str5, Constants.MessagePayloadKeys.FROM);
        i.h(str6, "uri");
        return new MediaFile(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaFile)) {
            return false;
        }
        MediaFile mediaFile = (MediaFile) obj;
        return i.b(this.program, mediaFile.program) && i.b(this.media, mediaFile.media) && i.b(this.title, mediaFile.title) && i.b(this.buss, mediaFile.buss) && i.b(this.from, mediaFile.from) && i.b(this.uri, mediaFile.uri);
    }

    public final String getBuss() {
        return this.buss;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getMedia() {
        return this.media;
    }

    public final String getProgram() {
        return this.program;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        String str = this.program;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.media;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.buss;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.from;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.uri;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setBuss(String str) {
        i.h(str, "<set-?>");
        this.buss = str;
    }

    public final void setFrom(String str) {
        i.h(str, "<set-?>");
        this.from = str;
    }

    public final void setMedia(String str) {
        i.h(str, "<set-?>");
        this.media = str;
    }

    public final void setProgram(String str) {
        i.h(str, "<set-?>");
        this.program = str;
    }

    public final void setTitle(String str) {
        i.h(str, "<set-?>");
        this.title = str;
    }

    public final void setUri(String str) {
        i.h(str, "<set-?>");
        this.uri = str;
    }

    public String toString() {
        return "MediaFile(program=" + this.program + ", media=" + this.media + ", title=" + this.title + ", buss=" + this.buss + ", from=" + this.from + ", uri=" + this.uri + ")";
    }
}
