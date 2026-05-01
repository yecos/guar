package com.mobile.brasiltv.bean;

import anet.channel.strategy.dispatch.DispatchConstants;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchBean implements Comparable<SearchBean> {
    private Channel channel;

    /* renamed from: i, reason: collision with root package name */
    private int f8272i;

    public SearchBean(int i10, Channel channel) {
        i.g(channel, "channel");
        this.f8272i = i10;
        this.channel = channel;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final int getI() {
        return this.f8272i;
    }

    public final void setChannel(Channel channel) {
        i.g(channel, "<set-?>");
        this.channel = channel;
    }

    public final void setI(int i10) {
        this.f8272i = i10;
    }

    @Override // java.lang.Comparable
    public int compareTo(SearchBean searchBean) {
        i.g(searchBean, DispatchConstants.OTHER);
        return this.f8272i - searchBean.f8272i;
    }
}
