package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public class SubTitleData {
    private boolean isSelected;
    private String language = "";
    private String subUrl = "";
    private String md5 = "";
    private String filePath = "";

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSubUrl() {
        return this.subUrl;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setFilePath(String str) {
        i.g(str, "<set-?>");
        this.filePath = str;
    }

    public final void setLanguage(String str) {
        i.g(str, "<set-?>");
        this.language = str;
    }

    public final void setMd5(String str) {
        i.g(str, "<set-?>");
        this.md5 = str;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public final void setSubUrl(String str) {
        i.g(str, "<set-?>");
        this.subUrl = str;
    }

    public String toString() {
        return "SubTitleData(language='" + this.language + "', subUrl='" + this.subUrl + "', filePath='" + this.filePath + "', isSelected=" + this.isSelected + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
