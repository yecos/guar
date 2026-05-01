package com.bigbee.bean.request;

import com.bigbee.db.IEventTransport;

/* loaded from: classes.dex */
public abstract class BaseRequestBean implements IEventTransport {
    protected String appVer;
    protected String eventId;
    protected String rangerVer;
    protected long startTime;
    protected String sysVer;

    public BaseRequestBean() {
    }

    public BaseRequestBean(String str, String str2, long j10, String str3, String str4) {
        this.appVer = str;
        this.sysVer = str2;
        this.startTime = j10;
        this.eventId = str3;
        this.rangerVer = str4;
    }
}
