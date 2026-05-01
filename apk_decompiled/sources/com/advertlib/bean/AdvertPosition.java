package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes.dex */
public final class AdvertPosition {
    private String ad_type;
    private List<AdInfo> ads;
    private String max;
    private String mode;
    private String update_time;

    public AdvertPosition(String str, String str2, String str3, String str4, List<AdInfo> list) {
        i.g(str4, "update_time");
        this.ad_type = str;
        this.max = str2;
        this.mode = str3;
        this.update_time = str4;
        this.ads = list;
    }

    public static /* synthetic */ AdvertPosition copy$default(AdvertPosition advertPosition, String str, String str2, String str3, String str4, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = advertPosition.ad_type;
        }
        if ((i10 & 2) != 0) {
            str2 = advertPosition.max;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = advertPosition.mode;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            str4 = advertPosition.update_time;
        }
        String str7 = str4;
        if ((i10 & 16) != 0) {
            list = advertPosition.ads;
        }
        return advertPosition.copy(str, str5, str6, str7, list);
    }

    public final String component1() {
        return this.ad_type;
    }

    public final String component2() {
        return this.max;
    }

    public final String component3() {
        return this.mode;
    }

    public final String component4() {
        return this.update_time;
    }

    public final List<AdInfo> component5() {
        return this.ads;
    }

    public final AdvertPosition copy(String str, String str2, String str3, String str4, List<AdInfo> list) {
        i.g(str4, "update_time");
        return new AdvertPosition(str, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertPosition)) {
            return false;
        }
        AdvertPosition advertPosition = (AdvertPosition) obj;
        return i.b(this.ad_type, advertPosition.ad_type) && i.b(this.max, advertPosition.max) && i.b(this.mode, advertPosition.mode) && i.b(this.update_time, advertPosition.update_time) && i.b(this.ads, advertPosition.ads);
    }

    public final String getAd_type() {
        return this.ad_type;
    }

    public final List<AdInfo> getAds() {
        return this.ads;
    }

    public final String getMax() {
        return this.max;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getUpdate_time() {
        return this.update_time;
    }

    public int hashCode() {
        String str = this.ad_type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.max;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mode;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.update_time.hashCode()) * 31;
        List<AdInfo> list = this.ads;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public final void setAd_type(String str) {
        this.ad_type = str;
    }

    public final void setAds(List<AdInfo> list) {
        this.ads = list;
    }

    public final void setMax(String str) {
        this.max = str;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final void setUpdate_time(String str) {
        i.g(str, "<set-?>");
        this.update_time = str;
    }

    public String toString() {
        return "AdvertPosition(ad_type=" + this.ad_type + ", max=" + this.max + ", mode=" + this.mode + ", update_time=" + this.update_time + ", ads=" + this.ads + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
