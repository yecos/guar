package com.titan.ranger.bean;

import com.taobao.accs.common.Constants;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class Entry {
    private List<String> auths;
    private String buss;
    private int enable;
    private String gslb_params;
    private String main_addr;
    private String main_addr_code;
    private String name;
    private int priority;
    private String redirect;
    private String sign_type;
    private String spare_addr;
    private String spare_addr_code;
    private String strategy;
    private String tag;

    public Entry(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, int i11, List<String> list, String str11) {
        i.h(str, "name");
        i.h(str2, "buss");
        i.h(str3, Constants.KEY_STRATEGY);
        i.h(str4, "main_addr");
        i.h(str5, "main_addr_code");
        i.h(str6, "spare_addr");
        i.h(str7, "spare_addr_code");
        i.h(str8, "redirect");
        i.h(str9, "tag");
        i.h(str10, "sign_type");
        i.h(list, "auths");
        i.h(str11, "gslb_params");
        this.name = str;
        this.buss = str2;
        this.strategy = str3;
        this.main_addr = str4;
        this.main_addr_code = str5;
        this.spare_addr = str6;
        this.spare_addr_code = str7;
        this.redirect = str8;
        this.tag = str9;
        this.sign_type = str10;
        this.priority = i10;
        this.enable = i11;
        this.auths = list;
        this.gslb_params = str11;
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.sign_type;
    }

    public final int component11() {
        return this.priority;
    }

    public final int component12() {
        return this.enable;
    }

    public final List<String> component13() {
        return this.auths;
    }

    public final String component14() {
        return this.gslb_params;
    }

    public final String component2() {
        return this.buss;
    }

    public final String component3() {
        return this.strategy;
    }

    public final String component4() {
        return this.main_addr;
    }

    public final String component5() {
        return this.main_addr_code;
    }

    public final String component6() {
        return this.spare_addr;
    }

    public final String component7() {
        return this.spare_addr_code;
    }

    public final String component8() {
        return this.redirect;
    }

    public final String component9() {
        return this.tag;
    }

    public final Entry copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, int i11, List<String> list, String str11) {
        i.h(str, "name");
        i.h(str2, "buss");
        i.h(str3, Constants.KEY_STRATEGY);
        i.h(str4, "main_addr");
        i.h(str5, "main_addr_code");
        i.h(str6, "spare_addr");
        i.h(str7, "spare_addr_code");
        i.h(str8, "redirect");
        i.h(str9, "tag");
        i.h(str10, "sign_type");
        i.h(list, "auths");
        i.h(str11, "gslb_params");
        return new Entry(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i10, i11, list, str11);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                if (i.b(this.name, entry.name) && i.b(this.buss, entry.buss) && i.b(this.strategy, entry.strategy) && i.b(this.main_addr, entry.main_addr) && i.b(this.main_addr_code, entry.main_addr_code) && i.b(this.spare_addr, entry.spare_addr) && i.b(this.spare_addr_code, entry.spare_addr_code) && i.b(this.redirect, entry.redirect) && i.b(this.tag, entry.tag) && i.b(this.sign_type, entry.sign_type)) {
                    if (this.priority == entry.priority) {
                        if (!(this.enable == entry.enable) || !i.b(this.auths, entry.auths) || !i.b(this.gslb_params, entry.gslb_params)) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final List<String> getAuths() {
        return this.auths;
    }

    public final String getBuss() {
        return this.buss;
    }

    public final int getEnable() {
        return this.enable;
    }

    public final String getGslb_params() {
        return this.gslb_params;
    }

    public final String getMain_addr() {
        return this.main_addr;
    }

    public final String getMain_addr_code() {
        return this.main_addr_code;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getRedirect() {
        return this.redirect;
    }

    public final String getSign_type() {
        return this.sign_type;
    }

    public final String getSpare_addr() {
        return this.spare_addr;
    }

    public final String getSpare_addr_code() {
        return this.spare_addr_code;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.buss;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.strategy;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.main_addr;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.main_addr_code;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.spare_addr;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.spare_addr_code;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.redirect;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.tag;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.sign_type;
        int hashCode10 = (((((hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31) + this.priority) * 31) + this.enable) * 31;
        List<String> list = this.auths;
        int hashCode11 = (hashCode10 + (list != null ? list.hashCode() : 0)) * 31;
        String str11 = this.gslb_params;
        return hashCode11 + (str11 != null ? str11.hashCode() : 0);
    }

    public final void setAuths(List<String> list) {
        i.h(list, "<set-?>");
        this.auths = list;
    }

    public final void setBuss(String str) {
        i.h(str, "<set-?>");
        this.buss = str;
    }

    public final void setEnable(int i10) {
        this.enable = i10;
    }

    public final void setGslb_params(String str) {
        i.h(str, "<set-?>");
        this.gslb_params = str;
    }

    public final void setMain_addr(String str) {
        i.h(str, "<set-?>");
        this.main_addr = str;
    }

    public final void setMain_addr_code(String str) {
        i.h(str, "<set-?>");
        this.main_addr_code = str;
    }

    public final void setName(String str) {
        i.h(str, "<set-?>");
        this.name = str;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setRedirect(String str) {
        i.h(str, "<set-?>");
        this.redirect = str;
    }

    public final void setSign_type(String str) {
        i.h(str, "<set-?>");
        this.sign_type = str;
    }

    public final void setSpare_addr(String str) {
        i.h(str, "<set-?>");
        this.spare_addr = str;
    }

    public final void setSpare_addr_code(String str) {
        i.h(str, "<set-?>");
        this.spare_addr_code = str;
    }

    public final void setStrategy(String str) {
        i.h(str, "<set-?>");
        this.strategy = str;
    }

    public final void setTag(String str) {
        i.h(str, "<set-?>");
        this.tag = str;
    }

    public String toString() {
        return "Entry(name=" + this.name + ", buss=" + this.buss + ", strategy=" + this.strategy + ", main_addr=" + this.main_addr + ", main_addr_code=" + this.main_addr_code + ", spare_addr=" + this.spare_addr + ", spare_addr_code=" + this.spare_addr_code + ", redirect=" + this.redirect + ", tag=" + this.tag + ", sign_type=" + this.sign_type + ", priority=" + this.priority + ", enable=" + this.enable + ", auths=" + this.auths + ", gslb_params=" + this.gslb_params + ")";
    }
}
