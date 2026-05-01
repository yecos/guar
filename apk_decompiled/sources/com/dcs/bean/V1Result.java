package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class V1Result {
    private String log;

    public V1Result(String str) {
        i.g(str, "log");
        this.log = str;
    }

    public static /* synthetic */ V1Result copy$default(V1Result v1Result, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = v1Result.log;
        }
        return v1Result.copy(str);
    }

    public final String component1() {
        return this.log;
    }

    public final V1Result copy(String str) {
        i.g(str, "log");
        return new V1Result(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof V1Result) && i.b(this.log, ((V1Result) obj).log);
    }

    public final String getLog() {
        return this.log;
    }

    public int hashCode() {
        return this.log.hashCode();
    }

    public final void setLog(String str) {
        i.g(str, "<set-?>");
        this.log = str;
    }

    public String toString() {
        return "V1Result(log=" + this.log + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
