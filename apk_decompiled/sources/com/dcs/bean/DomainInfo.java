package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class DomainInfo {
    private final int domainType;
    private final String first;
    private final String second;

    public DomainInfo(String str, String str2, int i10) {
        i.g(str, "first");
        i.g(str2, "second");
        this.first = str;
        this.second = str2;
        this.domainType = i10;
    }

    public static /* synthetic */ DomainInfo copy$default(DomainInfo domainInfo, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = domainInfo.first;
        }
        if ((i11 & 2) != 0) {
            str2 = domainInfo.second;
        }
        if ((i11 & 4) != 0) {
            i10 = domainInfo.domainType;
        }
        return domainInfo.copy(str, str2, i10);
    }

    public final String component1() {
        return this.first;
    }

    public final String component2() {
        return this.second;
    }

    public final int component3() {
        return this.domainType;
    }

    public final DomainInfo copy(String str, String str2, int i10) {
        i.g(str, "first");
        i.g(str2, "second");
        return new DomainInfo(str, str2, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DomainInfo)) {
            return false;
        }
        DomainInfo domainInfo = (DomainInfo) obj;
        return i.b(this.first, domainInfo.first) && i.b(this.second, domainInfo.second) && this.domainType == domainInfo.domainType;
    }

    public final int getDomainType() {
        return this.domainType;
    }

    public final String getFirst() {
        return this.first;
    }

    public final String getSecond() {
        return this.second;
    }

    public int hashCode() {
        return (((this.first.hashCode() * 31) + this.second.hashCode()) * 31) + this.domainType;
    }

    public String toString() {
        return "DomainInfo(first=" + this.first + ", second=" + this.second + ", domainType=" + this.domainType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
