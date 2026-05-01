package com.titan.cast.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t9.i;

/* loaded from: classes3.dex */
public final class CastResult {
    private int err;
    private String res;

    public CastResult(int i10, String str) {
        i.g(str, Constants.SEND_TYPE_RES);
        this.err = i10;
        this.res = str;
    }

    public static /* synthetic */ CastResult copy$default(CastResult castResult, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = castResult.err;
        }
        if ((i11 & 2) != 0) {
            str = castResult.res;
        }
        return castResult.copy(i10, str);
    }

    public final int component1() {
        return this.err;
    }

    public final String component2() {
        return this.res;
    }

    public final CastResult copy(int i10, String str) {
        i.g(str, Constants.SEND_TYPE_RES);
        return new CastResult(i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CastResult)) {
            return false;
        }
        CastResult castResult = (CastResult) obj;
        return this.err == castResult.err && i.b(this.res, castResult.res);
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
        return "CastResult(err=" + this.err + ", res=" + this.res + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
