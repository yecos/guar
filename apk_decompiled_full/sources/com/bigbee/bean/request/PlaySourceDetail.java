package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t1.a;
import t9.i;

/* loaded from: classes.dex */
public final class PlaySourceDetail {
    private String data;
    private String event;
    private String from;
    private long st;

    public PlaySourceDetail(long j10, String str, String str2, String str3) {
        i.g(str, "event");
        i.g(str2, "data");
        this.st = j10;
        this.event = str;
        this.data = str2;
        this.from = str3;
    }

    public static /* synthetic */ PlaySourceDetail copy$default(PlaySourceDetail playSourceDetail, long j10, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = playSourceDetail.st;
        }
        long j11 = j10;
        if ((i10 & 2) != 0) {
            str = playSourceDetail.event;
        }
        String str4 = str;
        if ((i10 & 4) != 0) {
            str2 = playSourceDetail.data;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            str3 = playSourceDetail.from;
        }
        return playSourceDetail.copy(j11, str4, str5, str3);
    }

    public final long component1() {
        return this.st;
    }

    public final String component2() {
        return this.event;
    }

    public final String component3() {
        return this.data;
    }

    public final String component4() {
        return this.from;
    }

    public final PlaySourceDetail copy(long j10, String str, String str2, String str3) {
        i.g(str, "event");
        i.g(str2, "data");
        return new PlaySourceDetail(j10, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaySourceDetail)) {
            return false;
        }
        PlaySourceDetail playSourceDetail = (PlaySourceDetail) obj;
        return this.st == playSourceDetail.st && i.b(this.event, playSourceDetail.event) && i.b(this.data, playSourceDetail.data) && i.b(this.from, playSourceDetail.from);
    }

    public final String getData() {
        return this.data;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getFrom() {
        return this.from;
    }

    public final long getSt() {
        return this.st;
    }

    public int hashCode() {
        int a10 = ((((a.a(this.st) * 31) + this.event.hashCode()) * 31) + this.data.hashCode()) * 31;
        String str = this.from;
        return a10 + (str == null ? 0 : str.hashCode());
    }

    public final void setData(String str) {
        i.g(str, "<set-?>");
        this.data = str;
    }

    public final void setEvent(String str) {
        i.g(str, "<set-?>");
        this.event = str;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final void setSt(long j10) {
        this.st = j10;
    }

    public String toString() {
        return "PlaySourceDetail(st=" + this.st + ", event=" + this.event + ", data=" + this.data + ", from=" + this.from + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
