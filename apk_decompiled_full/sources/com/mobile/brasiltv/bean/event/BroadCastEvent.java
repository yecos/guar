package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class BroadCastEvent {
    private String type;

    public BroadCastEvent(String str) {
        i.g(str, "type");
        this.type = str;
    }

    public static /* synthetic */ BroadCastEvent copy$default(BroadCastEvent broadCastEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = broadCastEvent.type;
        }
        return broadCastEvent.copy(str);
    }

    public final String component1() {
        return this.type;
    }

    public final BroadCastEvent copy(String str) {
        i.g(str, "type");
        return new BroadCastEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BroadCastEvent) && i.b(this.type, ((BroadCastEvent) obj).type);
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "BroadCastEvent(type=" + this.type + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
