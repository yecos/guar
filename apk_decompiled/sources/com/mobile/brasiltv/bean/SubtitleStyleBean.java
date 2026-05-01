package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class SubtitleStyleBean {
    private int backgrounrd;
    private int color;

    public SubtitleStyleBean(int i10, int i11) {
        this.color = i10;
        this.backgrounrd = i11;
    }

    public static /* synthetic */ SubtitleStyleBean copy$default(SubtitleStyleBean subtitleStyleBean, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = subtitleStyleBean.color;
        }
        if ((i12 & 2) != 0) {
            i11 = subtitleStyleBean.backgrounrd;
        }
        return subtitleStyleBean.copy(i10, i11);
    }

    public final int component1() {
        return this.color;
    }

    public final int component2() {
        return this.backgrounrd;
    }

    public final SubtitleStyleBean copy(int i10, int i11) {
        return new SubtitleStyleBean(i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleStyleBean)) {
            return false;
        }
        SubtitleStyleBean subtitleStyleBean = (SubtitleStyleBean) obj;
        return this.color == subtitleStyleBean.color && this.backgrounrd == subtitleStyleBean.backgrounrd;
    }

    public final int getBackgrounrd() {
        return this.backgrounrd;
    }

    public final int getColor() {
        return this.color;
    }

    public int hashCode() {
        return (this.color * 31) + this.backgrounrd;
    }

    public final void setBackgrounrd(int i10) {
        this.backgrounrd = i10;
    }

    public final void setColor(int i10) {
        this.color = i10;
    }

    public String toString() {
        return "SubtitleStyleBean(color=" + this.color + ", backgrounrd=" + this.backgrounrd + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
