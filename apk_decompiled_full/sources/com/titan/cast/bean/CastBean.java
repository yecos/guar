package com.titan.cast.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CastBean {
    private String app;
    private String app_ver;
    private String dev_id;
    private String params;
    private String user_id;

    public CastBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "app");
        i.g(str2, "app_ver");
        i.g(str3, "user_id");
        i.g(str4, "dev_id");
        i.g(str5, "params");
        this.app = str;
        this.app_ver = str2;
        this.user_id = str3;
        this.dev_id = str4;
        this.params = str5;
    }

    public static /* synthetic */ CastBean copy$default(CastBean castBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = castBean.app;
        }
        if ((i10 & 2) != 0) {
            str2 = castBean.app_ver;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = castBean.user_id;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = castBean.dev_id;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = castBean.params;
        }
        return castBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.app;
    }

    public final String component2() {
        return this.app_ver;
    }

    public final String component3() {
        return this.user_id;
    }

    public final String component4() {
        return this.dev_id;
    }

    public final String component5() {
        return this.params;
    }

    public final CastBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "app");
        i.g(str2, "app_ver");
        i.g(str3, "user_id");
        i.g(str4, "dev_id");
        i.g(str5, "params");
        return new CastBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CastBean)) {
            return false;
        }
        CastBean castBean = (CastBean) obj;
        return i.b(this.app, castBean.app) && i.b(this.app_ver, castBean.app_ver) && i.b(this.user_id, castBean.user_id) && i.b(this.dev_id, castBean.dev_id) && i.b(this.params, castBean.params);
    }

    public final String getApp() {
        return this.app;
    }

    public final String getApp_ver() {
        return this.app_ver;
    }

    public final String getDev_id() {
        return this.dev_id;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        return (((((((this.app.hashCode() * 31) + this.app_ver.hashCode()) * 31) + this.user_id.hashCode()) * 31) + this.dev_id.hashCode()) * 31) + this.params.hashCode();
    }

    public final void setApp(String str) {
        i.g(str, "<set-?>");
        this.app = str;
    }

    public final void setApp_ver(String str) {
        i.g(str, "<set-?>");
        this.app_ver = str;
    }

    public final void setDev_id(String str) {
        i.g(str, "<set-?>");
        this.dev_id = str;
    }

    public final void setParams(String str) {
        i.g(str, "<set-?>");
        this.params = str;
    }

    public final void setUser_id(String str) {
        i.g(str, "<set-?>");
        this.user_id = str;
    }

    public String toString() {
        return "CastBean(app=" + this.app + ", app_ver=" + this.app_ver + ", user_id=" + this.user_id + ", dev_id=" + this.dev_id + ", params=" + this.params + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
