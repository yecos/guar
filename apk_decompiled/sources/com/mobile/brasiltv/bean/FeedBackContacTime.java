package com.mobile.brasiltv.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import org.android.agoo.common.AgooConstants;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackContacTime implements MultiItemEntity {
    private String time;

    public FeedBackContacTime(String str) {
        i.g(str, AgooConstants.MESSAGE_TIME);
        this.time = str;
    }

    public static /* synthetic */ FeedBackContacTime copy$default(FeedBackContacTime feedBackContacTime, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedBackContacTime.time;
        }
        return feedBackContacTime.copy(str);
    }

    public final String component1() {
        return this.time;
    }

    public final FeedBackContacTime copy(String str) {
        i.g(str, AgooConstants.MESSAGE_TIME);
        return new FeedBackContacTime(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedBackContacTime) && i.b(this.time, ((FeedBackContacTime) obj).time);
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 3;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return this.time.hashCode();
    }

    public final void setTime(String str) {
        i.g(str, "<set-?>");
        this.time = str;
    }

    public String toString() {
        return "FeedBackContacTime(time=" + this.time + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
