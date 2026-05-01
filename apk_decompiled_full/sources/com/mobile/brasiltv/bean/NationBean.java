package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class NationBean implements Serializable {
    private String code;
    private String country;
    private boolean isFirstSZM;
    private String szm;

    public final String getCode() {
        return this.code;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getSzm() {
        return this.szm;
    }

    public final boolean isFirstSZM() {
        return this.isFirstSZM;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setFirstSZM(boolean z10) {
        this.isFirstSZM = z10;
    }

    public final void setSzm(String str) {
        this.szm = str;
    }

    public String toString() {
        return "NationBean{country='" + this.country + "', code='" + this.code + "', szm='" + this.szm + "', isFirstSZM=" + this.isFirstSZM + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
