package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import sa.f;

@e(name = "live_order")
/* loaded from: classes3.dex */
public final class LiveOrder implements Serializable {
    private String arias;
    private String channelCode;
    private String channelName;
    private String contentId;
    private String endTime;

    @a(column = "id")
    private int id;
    private String programName;

    @f
    private final long serialVersionUID = 7234796519009099506L;
    private String startTime;
    private String type;

    public final String getArias() {
        return this.arias;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final int getId() {
        return this.id;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getType() {
        return this.type;
    }

    public final void setArias(String str) {
        this.arias = str;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setProgramName(String str) {
        this.programName = str;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
