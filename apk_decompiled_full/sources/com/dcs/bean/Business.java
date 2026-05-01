package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes.dex */
public final class Business {
    private String business_entry;
    private ArrayList<URLInfo> details;

    public Business(String str, ArrayList<URLInfo> arrayList) {
        i.g(str, "business_entry");
        i.g(arrayList, "details");
        this.business_entry = str;
        this.details = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Business copy$default(Business business, String str, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = business.business_entry;
        }
        if ((i10 & 2) != 0) {
            arrayList = business.details;
        }
        return business.copy(str, arrayList);
    }

    public final String component1() {
        return this.business_entry;
    }

    public final ArrayList<URLInfo> component2() {
        return this.details;
    }

    public final Business copy(String str, ArrayList<URLInfo> arrayList) {
        i.g(str, "business_entry");
        i.g(arrayList, "details");
        return new Business(str, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Business)) {
            return false;
        }
        Business business = (Business) obj;
        return i.b(this.business_entry, business.business_entry) && i.b(this.details, business.details);
    }

    public final String getBusiness_entry() {
        return this.business_entry;
    }

    public final ArrayList<URLInfo> getDetails() {
        return this.details;
    }

    public int hashCode() {
        return (this.business_entry.hashCode() * 31) + this.details.hashCode();
    }

    public final void setBusiness_entry(String str) {
        i.g(str, "<set-?>");
        this.business_entry = str;
    }

    public final void setDetails(ArrayList<URLInfo> arrayList) {
        i.g(arrayList, "<set-?>");
        this.details = arrayList;
    }

    public String toString() {
        return "Business(business_entry=" + this.business_entry + ", details=" + this.details + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
