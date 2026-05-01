package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class CreativeData {
    private int height;
    private String type;
    private String url;
    private int width;

    public CreativeData(String str, int i10, int i11, String str2) {
        i.g(str, "type");
        i.g(str2, "url");
        this.type = str;
        this.width = i10;
        this.height = i11;
        this.url = str2;
    }

    public static /* synthetic */ CreativeData copy$default(CreativeData creativeData, String str, int i10, int i11, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = creativeData.type;
        }
        if ((i12 & 2) != 0) {
            i10 = creativeData.width;
        }
        if ((i12 & 4) != 0) {
            i11 = creativeData.height;
        }
        if ((i12 & 8) != 0) {
            str2 = creativeData.url;
        }
        return creativeData.copy(str, i10, i11, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final String component4() {
        return this.url;
    }

    public final CreativeData copy(String str, int i10, int i11, String str2) {
        i.g(str, "type");
        i.g(str2, "url");
        return new CreativeData(str, i10, i11, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreativeData)) {
            return false;
        }
        CreativeData creativeData = (CreativeData) obj;
        return i.b(this.type, creativeData.type) && this.width == creativeData.width && this.height == creativeData.height && i.b(this.url, creativeData.url);
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.width) * 31) + this.height) * 31) + this.url.hashCode();
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUrl(String str) {
        i.g(str, "<set-?>");
        this.url = str;
    }

    public final void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        return "CreativeData(type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", url=" + this.url + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
