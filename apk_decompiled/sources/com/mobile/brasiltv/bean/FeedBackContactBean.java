package com.mobile.brasiltv.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackContactBean implements MultiItemEntity {
    private String contact;
    private String name;

    public FeedBackContactBean(String str, String str2) {
        i.g(str, "contact");
        i.g(str2, "name");
        this.contact = str;
        this.name = str2;
    }

    public static /* synthetic */ FeedBackContactBean copy$default(FeedBackContactBean feedBackContactBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedBackContactBean.contact;
        }
        if ((i10 & 2) != 0) {
            str2 = feedBackContactBean.name;
        }
        return feedBackContactBean.copy(str, str2);
    }

    public final String component1() {
        return this.contact;
    }

    public final String component2() {
        return this.name;
    }

    public final FeedBackContactBean copy(String str, String str2) {
        i.g(str, "contact");
        i.g(str2, "name");
        return new FeedBackContactBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedBackContactBean)) {
            return false;
        }
        FeedBackContactBean feedBackContactBean = (FeedBackContactBean) obj;
        return i.b(this.contact, feedBackContactBean.contact) && i.b(this.name, feedBackContactBean.name);
    }

    public final String getContact() {
        return this.contact;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 2;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.contact.hashCode() * 31) + this.name.hashCode();
    }

    public final void setContact(String str) {
        i.g(str, "<set-?>");
        this.contact = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "FeedBackContactBean(contact=" + this.contact + ", name=" + this.name + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
