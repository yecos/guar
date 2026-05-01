package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class RequestAuthEvent {
    private SimpleProgramList data;
    private final int index;
    private final boolean isCast;
    private boolean isVideoStop;

    public RequestAuthEvent(int i10, SimpleProgramList simpleProgramList, boolean z10, boolean z11) {
        i.g(simpleProgramList, "data");
        this.index = i10;
        this.data = simpleProgramList;
        this.isCast = z10;
        this.isVideoStop = z11;
    }

    public static /* synthetic */ RequestAuthEvent copy$default(RequestAuthEvent requestAuthEvent, int i10, SimpleProgramList simpleProgramList, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = requestAuthEvent.index;
        }
        if ((i11 & 2) != 0) {
            simpleProgramList = requestAuthEvent.data;
        }
        if ((i11 & 4) != 0) {
            z10 = requestAuthEvent.isCast;
        }
        if ((i11 & 8) != 0) {
            z11 = requestAuthEvent.isVideoStop;
        }
        return requestAuthEvent.copy(i10, simpleProgramList, z10, z11);
    }

    public final int component1() {
        return this.index;
    }

    public final SimpleProgramList component2() {
        return this.data;
    }

    public final boolean component3() {
        return this.isCast;
    }

    public final boolean component4() {
        return this.isVideoStop;
    }

    public final RequestAuthEvent copy(int i10, SimpleProgramList simpleProgramList, boolean z10, boolean z11) {
        i.g(simpleProgramList, "data");
        return new RequestAuthEvent(i10, simpleProgramList, z10, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestAuthEvent)) {
            return false;
        }
        RequestAuthEvent requestAuthEvent = (RequestAuthEvent) obj;
        return this.index == requestAuthEvent.index && i.b(this.data, requestAuthEvent.data) && this.isCast == requestAuthEvent.isCast && this.isVideoStop == requestAuthEvent.isVideoStop;
    }

    public final SimpleProgramList getData() {
        return this.data;
    }

    public final int getIndex() {
        return this.index;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.index * 31) + this.data.hashCode()) * 31;
        boolean z10 = this.isCast;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.isVideoStop;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isCast() {
        return this.isCast;
    }

    public final boolean isVideoStop() {
        return this.isVideoStop;
    }

    public final void setData(SimpleProgramList simpleProgramList) {
        i.g(simpleProgramList, "<set-?>");
        this.data = simpleProgramList;
    }

    public final void setVideoStop(boolean z10) {
        this.isVideoStop = z10;
    }

    public String toString() {
        return "RequestAuthEvent(index=" + this.index + ", data=" + this.data + ", isCast=" + this.isCast + ", isVideoStop=" + this.isVideoStop + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ RequestAuthEvent(int i10, SimpleProgramList simpleProgramList, boolean z10, boolean z11, int i11, g gVar) {
        this(i10, simpleProgramList, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11);
    }
}
