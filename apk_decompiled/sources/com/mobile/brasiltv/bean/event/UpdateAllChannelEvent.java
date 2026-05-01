package com.mobile.brasiltv.bean.event;

import java.util.List;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateAllChannelEvent {
    private List<Channel> allChannelList;

    public UpdateAllChannelEvent(List<Channel> list) {
        i.g(list, "allChannelList");
        this.allChannelList = list;
    }

    public final List<Channel> getAllChannelList() {
        return this.allChannelList;
    }

    public final void setAllChannelList(List<Channel> list) {
        i.g(list, "<set-?>");
        this.allChannelList = list;
    }
}
