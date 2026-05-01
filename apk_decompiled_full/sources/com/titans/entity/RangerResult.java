package com.titans.entity;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t9.i;

/* loaded from: classes3.dex */
public final class RangerResult {
    private int err;
    private String res;

    public RangerResult(int i10, String str) {
        i.g(str, Constants.SEND_TYPE_RES);
        this.err = i10;
        this.res = str;
    }

    public static /* synthetic */ RangerResult copy$default(RangerResult rangerResult, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = rangerResult.err;
        }
        if ((i11 & 2) != 0) {
            str = rangerResult.res;
        }
        return rangerResult.copy(i10, str);
    }

    public final int component1() {
        return this.err;
    }

    public final String component2() {
        return this.res;
    }

    public final RangerResult copy(int i10, String str) {
        i.g(str, Constants.SEND_TYPE_RES);
        return new RangerResult(i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangerResult)) {
            return false;
        }
        RangerResult rangerResult = (RangerResult) obj;
        return this.err == rangerResult.err && i.b(this.res, rangerResult.res);
    }

    public final int getErr() {
        return this.err;
    }

    public final String getRes() {
        return this.res;
    }

    public int hashCode() {
        return (this.err * 31) + this.res.hashCode();
    }

    public final void setErr(int i10) {
        this.err = i10;
    }

    public final void setRes(String str) {
        i.g(str, "<set-?>");
        this.res = str;
    }

    public String toString() {
        return "RangerResult(err=" + this.err + ", res=" + this.res + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
