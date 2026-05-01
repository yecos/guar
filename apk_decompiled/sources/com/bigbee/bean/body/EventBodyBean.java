package com.bigbee.bean.body;

import com.bigbee.bean.request.BaseRequestBean;
import com.bigbee.db.EventDbModel;

/* loaded from: classes.dex */
public class EventBodyBean extends BaseRequestBean {
    private String TAG;
    protected long endTime;
    private String parameter;

    public EventBodyBean() {
        this.TAG = "EventBodyBean";
    }

    @Override // com.bigbee.db.IEventTransport
    public EventDbModel transportEventDbModel(EventDbModel eventDbModel) {
        eventDbModel.eventId = this.eventId;
        eventDbModel.appVer = this.appVer;
        eventDbModel.sysVer = this.sysVer;
        eventDbModel.startTime = this.startTime;
        eventDbModel.endTime = this.endTime;
        eventDbModel.reserveA = this.parameter;
        return eventDbModel;
    }

    public EventBodyBean(String str, String str2, long j10, String str3, String str4, long j11, String str5) {
        super(str, str2, j10, str3, str5);
        this.TAG = "EventBodyBean";
        this.parameter = str4;
        this.endTime = j11;
    }
}
