package com.titans.entity;

import t9.i;

/* loaded from: classes3.dex */
public enum RangerPlayTag {
    LIVE("live"),
    VOD("vod"),
    RECORD("record");

    private String value;

    RangerPlayTag(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        i.g(str, "<set-?>");
        this.value = str;
    }
}
