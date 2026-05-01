package com.mobile.brasiltv.bean.event;

import mobile.com.requestframe.utils.response.Channel;
import t9.i;

/* loaded from: classes3.dex */
public final class ClickSearchChannelEvent {
    private Channel channel;

    public ClickSearchChannelEvent(Channel channel) {
        i.g(channel, "channel");
        this.channel = channel;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final void setChannel(Channel channel) {
        i.g(channel, "<set-?>");
        this.channel = channel;
    }
}
