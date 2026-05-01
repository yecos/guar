package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateChannelEvent {
    private int categoryCode;
    private ArrayList<Channel> listChannel;
    private String liveType;
    private boolean play;
    private int position;
    private int previousColumnIndex;
    private String tdcFrom;

    public UpdateChannelEvent(ArrayList<Channel> arrayList, int i10, boolean z10, String str, int i11, String str2, int i12) {
        i.g(arrayList, "listChannel");
        i.g(str, "liveType");
        i.g(str2, "tdcFrom");
        this.listChannel = arrayList;
        this.position = i10;
        this.play = z10;
        this.liveType = str;
        this.categoryCode = i11;
        this.tdcFrom = str2;
        this.previousColumnIndex = i12;
    }

    public static /* synthetic */ UpdateChannelEvent copy$default(UpdateChannelEvent updateChannelEvent, ArrayList arrayList, int i10, boolean z10, String str, int i11, String str2, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            arrayList = updateChannelEvent.listChannel;
        }
        if ((i13 & 2) != 0) {
            i10 = updateChannelEvent.position;
        }
        int i14 = i10;
        if ((i13 & 4) != 0) {
            z10 = updateChannelEvent.play;
        }
        boolean z11 = z10;
        if ((i13 & 8) != 0) {
            str = updateChannelEvent.liveType;
        }
        String str3 = str;
        if ((i13 & 16) != 0) {
            i11 = updateChannelEvent.categoryCode;
        }
        int i15 = i11;
        if ((i13 & 32) != 0) {
            str2 = updateChannelEvent.tdcFrom;
        }
        String str4 = str2;
        if ((i13 & 64) != 0) {
            i12 = updateChannelEvent.previousColumnIndex;
        }
        return updateChannelEvent.copy(arrayList, i14, z11, str3, i15, str4, i12);
    }

    public final ArrayList<Channel> component1() {
        return this.listChannel;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.play;
    }

    public final String component4() {
        return this.liveType;
    }

    public final int component5() {
        return this.categoryCode;
    }

    public final String component6() {
        return this.tdcFrom;
    }

    public final int component7() {
        return this.previousColumnIndex;
    }

    public final UpdateChannelEvent copy(ArrayList<Channel> arrayList, int i10, boolean z10, String str, int i11, String str2, int i12) {
        i.g(arrayList, "listChannel");
        i.g(str, "liveType");
        i.g(str2, "tdcFrom");
        return new UpdateChannelEvent(arrayList, i10, z10, str, i11, str2, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateChannelEvent)) {
            return false;
        }
        UpdateChannelEvent updateChannelEvent = (UpdateChannelEvent) obj;
        return i.b(this.listChannel, updateChannelEvent.listChannel) && this.position == updateChannelEvent.position && this.play == updateChannelEvent.play && i.b(this.liveType, updateChannelEvent.liveType) && this.categoryCode == updateChannelEvent.categoryCode && i.b(this.tdcFrom, updateChannelEvent.tdcFrom) && this.previousColumnIndex == updateChannelEvent.previousColumnIndex;
    }

    public final int getCategoryCode() {
        return this.categoryCode;
    }

    public final ArrayList<Channel> getListChannel() {
        return this.listChannel;
    }

    public final String getLiveType() {
        return this.liveType;
    }

    public final boolean getPlay() {
        return this.play;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPreviousColumnIndex() {
        return this.previousColumnIndex;
    }

    public final String getTdcFrom() {
        return this.tdcFrom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.listChannel.hashCode() * 31) + this.position) * 31;
        boolean z10 = this.play;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((((((((hashCode + i10) * 31) + this.liveType.hashCode()) * 31) + this.categoryCode) * 31) + this.tdcFrom.hashCode()) * 31) + this.previousColumnIndex;
    }

    public final void setCategoryCode(int i10) {
        this.categoryCode = i10;
    }

    public final void setListChannel(ArrayList<Channel> arrayList) {
        i.g(arrayList, "<set-?>");
        this.listChannel = arrayList;
    }

    public final void setLiveType(String str) {
        i.g(str, "<set-?>");
        this.liveType = str;
    }

    public final void setPlay(boolean z10) {
        this.play = z10;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }

    public final void setPreviousColumnIndex(int i10) {
        this.previousColumnIndex = i10;
    }

    public final void setTdcFrom(String str) {
        i.g(str, "<set-?>");
        this.tdcFrom = str;
    }

    public String toString() {
        return "UpdateChannelEvent(listChannel=" + this.listChannel + ", position=" + this.position + ", play=" + this.play + ", liveType=" + this.liveType + ", categoryCode=" + this.categoryCode + ", tdcFrom=" + this.tdcFrom + ", previousColumnIndex=" + this.previousColumnIndex + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
