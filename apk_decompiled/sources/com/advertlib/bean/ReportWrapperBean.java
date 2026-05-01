package com.advertlib.bean;

import t9.g;
import t9.i;

/* loaded from: classes.dex */
public final class ReportWrapperBean {
    private final AdInfo adInfo;
    private final String adType;
    private final int appVersion;
    private final long gameStayTime;
    private final boolean isClickEvent;
    private final long localTime;
    private final String pagekegeName;
    private final String userName;

    public ReportWrapperBean(boolean z10, long j10, String str, int i10, String str2, String str3, AdInfo adInfo, long j11) {
        i.g(str, "pagekegeName");
        i.g(str2, "userName");
        i.g(str3, "adType");
        i.g(adInfo, "adInfo");
        this.isClickEvent = z10;
        this.localTime = j10;
        this.pagekegeName = str;
        this.appVersion = i10;
        this.userName = str2;
        this.adType = str3;
        this.adInfo = adInfo;
        this.gameStayTime = j11;
    }

    public final AdInfo getAdInfo() {
        return this.adInfo;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final int getAppVersion() {
        return this.appVersion;
    }

    public final long getGameStayTime() {
        return this.gameStayTime;
    }

    public final long getLocalTime() {
        return this.localTime;
    }

    public final String getPagekegeName() {
        return this.pagekegeName;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean isClickEvent() {
        return this.isClickEvent;
    }

    public /* synthetic */ ReportWrapperBean(boolean z10, long j10, String str, int i10, String str2, String str3, AdInfo adInfo, long j11, int i11, g gVar) {
        this(z10, j10, str, i10, str2, str3, adInfo, (i11 & 128) != 0 ? 0L : j11);
    }
}
