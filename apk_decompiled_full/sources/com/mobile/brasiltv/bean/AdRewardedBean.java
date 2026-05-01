package com.mobile.brasiltv.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class AdRewardedBean {
    private int count;
    private final String tiem;

    public AdRewardedBean(String str, int i10) {
        i.g(str, "tiem");
        this.tiem = str;
        this.count = i10;
    }

    public static /* synthetic */ AdRewardedBean copy$default(AdRewardedBean adRewardedBean, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = adRewardedBean.tiem;
        }
        if ((i11 & 2) != 0) {
            i10 = adRewardedBean.count;
        }
        return adRewardedBean.copy(str, i10);
    }

    public final String component1() {
        return this.tiem;
    }

    public final int component2() {
        return this.count;
    }

    public final AdRewardedBean copy(String str, int i10) {
        i.g(str, "tiem");
        return new AdRewardedBean(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdRewardedBean)) {
            return false;
        }
        AdRewardedBean adRewardedBean = (AdRewardedBean) obj;
        return i.b(this.tiem, adRewardedBean.tiem) && this.count == adRewardedBean.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getTiem() {
        return this.tiem;
    }

    public int hashCode() {
        return (this.tiem.hashCode() * 31) + this.count;
    }

    public final void setCount(int i10) {
        this.count = i10;
    }

    public String toString() {
        return "AdRewardedBean(tiem=" + this.tiem + ", count=" + this.count + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
