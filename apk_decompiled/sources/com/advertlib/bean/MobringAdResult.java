package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes.dex */
public final class MobringAdResult {
    private int code;
    private List<MobringAd> data;

    public MobringAdResult(int i10, List<MobringAd> list) {
        this.code = i10;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobringAdResult copy$default(MobringAdResult mobringAdResult, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = mobringAdResult.code;
        }
        if ((i11 & 2) != 0) {
            list = mobringAdResult.data;
        }
        return mobringAdResult.copy(i10, list);
    }

    public final int component1() {
        return this.code;
    }

    public final List<MobringAd> component2() {
        return this.data;
    }

    public final MobringAdResult copy(int i10, List<MobringAd> list) {
        return new MobringAdResult(i10, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MobringAdResult)) {
            return false;
        }
        MobringAdResult mobringAdResult = (MobringAdResult) obj;
        return this.code == mobringAdResult.code && i.b(this.data, mobringAdResult.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<MobringAd> getData() {
        return this.data;
    }

    public int hashCode() {
        int i10 = this.code * 31;
        List<MobringAd> list = this.data;
        return i10 + (list == null ? 0 : list.hashCode());
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setData(List<MobringAd> list) {
        this.data = list;
    }

    public String toString() {
        return "MobringAdResult(code=" + this.code + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
