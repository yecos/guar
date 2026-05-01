package com.hpplay.cybergarage.xml;

/* loaded from: classes2.dex */
public class Attribute {
    private String name;
    private String value;

    public Attribute() {
        this.name = new String();
        this.value = new String();
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void set(Attribute attribute) {
        setName(attribute.getName());
        setValue(attribute.getValue());
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Attribute(String str, String str2) {
        this();
        setName(str);
        setValue(str2);
    }

    public Attribute(Attribute attribute) {
        this();
        set(attribute);
    }
}
