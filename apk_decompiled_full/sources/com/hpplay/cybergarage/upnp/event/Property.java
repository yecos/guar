package com.hpplay.cybergarage.upnp.event;

/* loaded from: classes2.dex */
public class Property {
    private String name = "";
    private String value = "";

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        if (str == null) {
            str = "";
        }
        this.name = str;
    }

    public void setValue(String str) {
        if (str == null) {
            str = "";
        }
        this.value = str;
    }
}
