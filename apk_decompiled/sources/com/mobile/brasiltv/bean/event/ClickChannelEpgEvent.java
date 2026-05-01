package com.mobile.brasiltv.bean.event;

import t9.i;

/* loaded from: classes3.dex */
public final class ClickChannelEpgEvent {
    private String channelAlias;
    private String channelCode;
    private String channelName;
    private int columnId;

    public ClickChannelEpgEvent(String str, String str2, int i10, String str3) {
        i.g(str, "channelCode");
        i.g(str2, "channelName");
        i.g(str3, "channelAlias");
        this.channelCode = str;
        this.channelName = str2;
        this.columnId = i10;
        this.channelAlias = str3;
    }

    public final String getChannelAlias() {
        return this.channelAlias;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getColumnId() {
        return this.columnId;
    }

    public final void setChannelAlias(String str) {
        i.g(str, "<set-?>");
        this.channelAlias = str;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setChannelName(String str) {
        i.g(str, "<set-?>");
        this.channelName = str;
    }

    public final void setColumnId(int i10) {
        this.columnId = i10;
    }
}
