package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class FullScreenEvent {
    private final boolean disable;

    public FullScreenEvent(boolean z10) {
        this.disable = z10;
    }

    public static /* synthetic */ FullScreenEvent copy$default(FullScreenEvent fullScreenEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = fullScreenEvent.disable;
        }
        return fullScreenEvent.copy(z10);
    }

    public final boolean component1() {
        return this.disable;
    }

    public final FullScreenEvent copy(boolean z10) {
        return new FullScreenEvent(z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FullScreenEvent) && this.disable == ((FullScreenEvent) obj).disable;
    }

    public final boolean getDisable() {
        return this.disable;
    }

    public int hashCode() {
        boolean z10 = this.disable;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    public String toString() {
        return "FullScreenEvent(disable=" + this.disable + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
