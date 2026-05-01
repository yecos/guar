package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import t1.a;
import t9.i;

/* loaded from: classes.dex */
public final class CustomizeEventBean implements Serializable {
    private String appVer;
    private String eid;
    private long et;
    private ArrayList<EventNameValueBean> parameter;
    private long st;
    private String sysVer;

    public CustomizeEventBean(String str, String str2, String str3, long j10, long j11, ArrayList<EventNameValueBean> arrayList) {
        i.g(str, "eid");
        i.g(str2, "appVer");
        this.eid = str;
        this.appVer = str2;
        this.sysVer = str3;
        this.st = j10;
        this.et = j11;
        this.parameter = arrayList;
    }

    public final String component1() {
        return this.eid;
    }

    public final String component2() {
        return this.appVer;
    }

    public final String component3() {
        return this.sysVer;
    }

    public final long component4() {
        return this.st;
    }

    public final long component5() {
        return this.et;
    }

    public final ArrayList<EventNameValueBean> component6() {
        return this.parameter;
    }

    public final CustomizeEventBean copy(String str, String str2, String str3, long j10, long j11, ArrayList<EventNameValueBean> arrayList) {
        i.g(str, "eid");
        i.g(str2, "appVer");
        return new CustomizeEventBean(str, str2, str3, j10, j11, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomizeEventBean)) {
            return false;
        }
        CustomizeEventBean customizeEventBean = (CustomizeEventBean) obj;
        return i.b(this.eid, customizeEventBean.eid) && i.b(this.appVer, customizeEventBean.appVer) && i.b(this.sysVer, customizeEventBean.sysVer) && this.st == customizeEventBean.st && this.et == customizeEventBean.et && i.b(this.parameter, customizeEventBean.parameter);
    }

    public final String getAppVer() {
        return this.appVer;
    }

    public final String getEid() {
        return this.eid;
    }

    public final long getEt() {
        return this.et;
    }

    public final ArrayList<EventNameValueBean> getParameter() {
        return this.parameter;
    }

    public final long getSt() {
        return this.st;
    }

    public final String getSysVer() {
        return this.sysVer;
    }

    public int hashCode() {
        int hashCode = ((this.eid.hashCode() * 31) + this.appVer.hashCode()) * 31;
        String str = this.sysVer;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.st)) * 31) + a.a(this.et)) * 31;
        ArrayList<EventNameValueBean> arrayList = this.parameter;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAppVer(String str) {
        i.g(str, "<set-?>");
        this.appVer = str;
    }

    public final void setEid(String str) {
        i.g(str, "<set-?>");
        this.eid = str;
    }

    public final void setEt(long j10) {
        this.et = j10;
    }

    public final void setParameter(ArrayList<EventNameValueBean> arrayList) {
        this.parameter = arrayList;
    }

    public final void setSt(long j10) {
        this.st = j10;
    }

    public final void setSysVer(String str) {
        this.sysVer = str;
    }

    public String toString() {
        return "CustomizeEventBean(eid=" + this.eid + ", appVer=" + this.appVer + ", sysVer=" + this.sysVer + ", st=" + this.st + ", et=" + this.et + ", parameter=" + this.parameter + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
