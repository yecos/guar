package com.hpplay.cybergarage.http;

/* loaded from: classes2.dex */
public class Parameter {
    private String name = new String();
    private String value = new String();

    public Parameter() {
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Parameter(String str, String str2) {
        setName(str);
        setValue(str2);
    }
}
