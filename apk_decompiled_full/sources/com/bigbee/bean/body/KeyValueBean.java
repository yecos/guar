package com.bigbee.bean.body;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class KeyValueBean {
    private String name;
    private Object value;

    public KeyValueBean() {
    }

    public KeyValueBean(String str, Object obj) {
        this.name = str;
        this.value = obj;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        return "KeyValueBean{name='" + this.name + "', value='" + this.value + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
