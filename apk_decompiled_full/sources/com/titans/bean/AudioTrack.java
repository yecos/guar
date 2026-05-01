package com.titans.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class AudioTrack {
    private String lang;
    private int trackId;

    public AudioTrack(int i10, String str) {
        i.g(str, "lang");
        this.trackId = i10;
        this.lang = str;
    }

    public static /* synthetic */ AudioTrack copy$default(AudioTrack audioTrack, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = audioTrack.trackId;
        }
        if ((i11 & 2) != 0) {
            str = audioTrack.lang;
        }
        return audioTrack.copy(i10, str);
    }

    public final int component1() {
        return this.trackId;
    }

    public final String component2() {
        return this.lang;
    }

    public final AudioTrack copy(int i10, String str) {
        i.g(str, "lang");
        return new AudioTrack(i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioTrack)) {
            return false;
        }
        AudioTrack audioTrack = (AudioTrack) obj;
        return this.trackId == audioTrack.trackId && i.b(this.lang, audioTrack.lang);
    }

    public final String getLang() {
        return this.lang;
    }

    public final int getTrackId() {
        return this.trackId;
    }

    public int hashCode() {
        return (this.trackId * 31) + this.lang.hashCode();
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setTrackId(int i10) {
        this.trackId = i10;
    }

    public String toString() {
        return "AudioTrack(trackId=" + this.trackId + ", lang=" + this.lang + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
