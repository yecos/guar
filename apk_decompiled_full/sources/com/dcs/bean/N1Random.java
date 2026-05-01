package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class N1Random {
    private String random;

    public N1Random(String str) {
        i.g(str, "random");
        this.random = str;
    }

    public static /* synthetic */ N1Random copy$default(N1Random n1Random, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = n1Random.random;
        }
        return n1Random.copy(str);
    }

    public final String component1() {
        return this.random;
    }

    public final N1Random copy(String str) {
        i.g(str, "random");
        return new N1Random(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof N1Random) && i.b(this.random, ((N1Random) obj).random);
    }

    public final String getRandom() {
        return this.random;
    }

    public int hashCode() {
        return this.random.hashCode();
    }

    public final void setRandom(String str) {
        i.g(str, "<set-?>");
        this.random = str;
    }

    public String toString() {
        return "N1Random(random=" + this.random + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
