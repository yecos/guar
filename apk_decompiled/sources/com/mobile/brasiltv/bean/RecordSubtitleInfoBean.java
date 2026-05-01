package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class RecordSubtitleInfoBean {
    private String subTitleLanguage;
    private int subtitleIndex;

    public RecordSubtitleInfoBean(int i10, String str) {
        i.g(str, "subTitleLanguage");
        this.subtitleIndex = i10;
        this.subTitleLanguage = str;
    }

    public static /* synthetic */ RecordSubtitleInfoBean copy$default(RecordSubtitleInfoBean recordSubtitleInfoBean, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = recordSubtitleInfoBean.subtitleIndex;
        }
        if ((i11 & 2) != 0) {
            str = recordSubtitleInfoBean.subTitleLanguage;
        }
        return recordSubtitleInfoBean.copy(i10, str);
    }

    public final int component1() {
        return this.subtitleIndex;
    }

    public final String component2() {
        return this.subTitleLanguage;
    }

    public final RecordSubtitleInfoBean copy(int i10, String str) {
        i.g(str, "subTitleLanguage");
        return new RecordSubtitleInfoBean(i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordSubtitleInfoBean)) {
            return false;
        }
        RecordSubtitleInfoBean recordSubtitleInfoBean = (RecordSubtitleInfoBean) obj;
        return this.subtitleIndex == recordSubtitleInfoBean.subtitleIndex && i.b(this.subTitleLanguage, recordSubtitleInfoBean.subTitleLanguage);
    }

    public final String getSubTitleLanguage() {
        return this.subTitleLanguage;
    }

    public final int getSubtitleIndex() {
        return this.subtitleIndex;
    }

    public int hashCode() {
        return (this.subtitleIndex * 31) + this.subTitleLanguage.hashCode();
    }

    public final void setSubTitleLanguage(String str) {
        i.g(str, "<set-?>");
        this.subTitleLanguage = str;
    }

    public final void setSubtitleIndex(int i10) {
        this.subtitleIndex = i10;
    }

    public String toString() {
        return "RecordSubtitleInfoBean(subtitleIndex=" + this.subtitleIndex + ", subTitleLanguage=" + this.subTitleLanguage + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
