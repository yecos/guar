package com.mobile.brasiltv.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import mobile.com.requestframe.utils.response.FeedBackContactData;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackTitleBean implements MultiItemEntity {
    private String logo;
    private String name;

    public FeedBackTitleBean(String str, String str2) {
        i.g(str, "name");
        this.name = str;
        this.logo = str2;
    }

    public static /* synthetic */ FeedBackTitleBean copy$default(FeedBackTitleBean feedBackTitleBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedBackTitleBean.name;
        }
        if ((i10 & 2) != 0) {
            str2 = feedBackTitleBean.logo;
        }
        return feedBackTitleBean.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.logo;
    }

    public final FeedBackTitleBean copy(String str, String str2) {
        i.g(str, "name");
        return new FeedBackTitleBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedBackTitleBean)) {
            return false;
        }
        FeedBackTitleBean feedBackTitleBean = (FeedBackTitleBean) obj;
        return i.b(this.name, feedBackTitleBean.name) && i.b(this.logo, feedBackTitleBean.logo);
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.logo;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "FeedBackTitleBean(name=" + this.name + ", logo=" + this.logo + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedBackTitleBean(FeedBackContactData feedBackContactData) {
        this(feedBackContactData.getName(), feedBackContactData.getLogo());
        i.g(feedBackContactData, "data");
    }
}
