package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;

/* loaded from: classes3.dex */
public final class PlaySetIndexEvent {
    private boolean isCast;
    private boolean isVideoStop;
    private int playSetIndex;

    public PlaySetIndexEvent(int i10, boolean z10, boolean z11) {
        this.playSetIndex = i10;
        this.isCast = z10;
        this.isVideoStop = z11;
    }

    public static /* synthetic */ PlaySetIndexEvent copy$default(PlaySetIndexEvent playSetIndexEvent, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = playSetIndexEvent.playSetIndex;
        }
        if ((i11 & 2) != 0) {
            z10 = playSetIndexEvent.isCast;
        }
        if ((i11 & 4) != 0) {
            z11 = playSetIndexEvent.isVideoStop;
        }
        return playSetIndexEvent.copy(i10, z10, z11);
    }

    public final int component1() {
        return this.playSetIndex;
    }

    public final boolean component2() {
        return this.isCast;
    }

    public final boolean component3() {
        return this.isVideoStop;
    }

    public final PlaySetIndexEvent copy(int i10, boolean z10, boolean z11) {
        return new PlaySetIndexEvent(i10, z10, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaySetIndexEvent)) {
            return false;
        }
        PlaySetIndexEvent playSetIndexEvent = (PlaySetIndexEvent) obj;
        return this.playSetIndex == playSetIndexEvent.playSetIndex && this.isCast == playSetIndexEvent.isCast && this.isVideoStop == playSetIndexEvent.isVideoStop;
    }

    public final int getPlaySetIndex() {
        return this.playSetIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i10 = this.playSetIndex * 31;
        boolean z10 = this.isCast;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z11 = this.isVideoStop;
        return i12 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isCast() {
        return this.isCast;
    }

    public final boolean isVideoStop() {
        return this.isVideoStop;
    }

    public final void setCast(boolean z10) {
        this.isCast = z10;
    }

    public final void setPlaySetIndex(int i10) {
        this.playSetIndex = i10;
    }

    public final void setVideoStop(boolean z10) {
        this.isVideoStop = z10;
    }

    public String toString() {
        return "PlaySetIndexEvent(playSetIndex=" + this.playSetIndex + ", isCast=" + this.isCast + ", isVideoStop=" + this.isVideoStop + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ PlaySetIndexEvent(int i10, boolean z10, boolean z11, int i11, g gVar) {
        this(i10, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? false : z11);
    }
}
