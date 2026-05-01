package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class AudioTrackBean {
    private String contentId;
    private boolean isSelected;
    private String lang;
    private int position;
    private String realAudio;

    public AudioTrackBean(String str, String str2, String str3, int i10, boolean z10) {
        i.g(str, "contentId");
        i.g(str2, "lang");
        i.g(str3, "realAudio");
        this.contentId = str;
        this.lang = str2;
        this.realAudio = str3;
        this.position = i10;
        this.isSelected = z10;
    }

    public static /* synthetic */ AudioTrackBean copy$default(AudioTrackBean audioTrackBean, String str, String str2, String str3, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = audioTrackBean.contentId;
        }
        if ((i11 & 2) != 0) {
            str2 = audioTrackBean.lang;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = audioTrackBean.realAudio;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            i10 = audioTrackBean.position;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            z10 = audioTrackBean.isSelected;
        }
        return audioTrackBean.copy(str, str4, str5, i12, z10);
    }

    public final String component1() {
        return this.contentId;
    }

    public final String component2() {
        return this.lang;
    }

    public final String component3() {
        return this.realAudio;
    }

    public final int component4() {
        return this.position;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    public final AudioTrackBean copy(String str, String str2, String str3, int i10, boolean z10) {
        i.g(str, "contentId");
        i.g(str2, "lang");
        i.g(str3, "realAudio");
        return new AudioTrackBean(str, str2, str3, i10, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioTrackBean)) {
            return false;
        }
        AudioTrackBean audioTrackBean = (AudioTrackBean) obj;
        return i.b(this.contentId, audioTrackBean.contentId) && i.b(this.lang, audioTrackBean.lang) && i.b(this.realAudio, audioTrackBean.realAudio) && this.position == audioTrackBean.position && this.isSelected == audioTrackBean.isSelected;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getLang() {
        return this.lang;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getRealAudio() {
        return this.realAudio;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.contentId.hashCode() * 31) + this.lang.hashCode()) * 31) + this.realAudio.hashCode()) * 31) + this.position) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }

    public final void setRealAudio(String str) {
        i.g(str, "<set-?>");
        this.realAudio = str;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public String toString() {
        return "AudioTrackBean(contentId=" + this.contentId + ", lang=" + this.lang + ", realAudio=" + this.realAudio + ", position=" + this.position + ", isSelected=" + this.isSelected + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ AudioTrackBean(String str, String str2, String str3, int i10, boolean z10, int i11, g gVar) {
        this(str, str2, str3, i10, (i11 & 16) != 0 ? false : z10);
    }
}
