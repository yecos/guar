package com.mobile.brasiltv.bean.event;

import java.util.ArrayList;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;

/* loaded from: classes3.dex */
public final class ReadyPlayFavEvent {
    private ArrayList<Channel> listChannel;
    private int position;
    private int previousColumnIndex;

    public ReadyPlayFavEvent(ArrayList<Channel> arrayList, int i10, int i11) {
        i.g(arrayList, "listChannel");
        this.listChannel = arrayList;
        this.position = i10;
        this.previousColumnIndex = i11;
    }

    public final ArrayList<Channel> getListChannel() {
        return this.listChannel;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPreviousColumnIndex() {
        return this.previousColumnIndex;
    }

    public final void setListChannel(ArrayList<Channel> arrayList) {
        i.g(arrayList, "<set-?>");
        this.listChannel = arrayList;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }

    public final void setPreviousColumnIndex(int i10) {
        this.previousColumnIndex = i10;
    }
}
