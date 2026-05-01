package com.titan.ranger.bean;

import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class Env {
    private String android_id;
    private String app;
    private String app_ver;
    private String communication_key;
    private String dev_id;
    private String params;
    private int titan_port;
    private String user_id;

    public Env(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, 0, 128, null);
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
        return this.communication_key;
    }

    public final String component6() {
        return this.params;
    }

    public final String component7() {
        return this.android_id;
    }

    public final int component8() {
        return this.titan_port;
    }

    public final Env copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10) {
        i.h(str, "app");
        i.h(str2, "app_ver");
        i.h(str3, "user_id");
        i.h(str4, "dev_id");
        i.h(str5, "communication_key");
        i.h(str6, "params");
        i.h(str7, "android_id");
        return new Env(str, str2, str3, str4, str5, str6, str7, i10);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Env) {
                Env env = (Env) obj;
                if (i.b(this.app, env.app) && i.b(this.app_ver, env.app_ver) && i.b(this.user_id, env.user_id) && i.b(this.dev_id, env.dev_id) && i.b(this.communication_key, env.communication_key) && i.b(this.params, env.params) && i.b(this.android_id, env.android_id)) {
                    if (this.titan_port == env.titan_port) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String getAndroid_id() {
        return this.android_id;
    }

    public final String getApp() {
        return this.app;
    }

    public final String getApp_ver() {
        return this.app_ver;
    }

    public final String getCommunication_key() {
        return this.communication_key;
    }

    public final String getDev_id() {
        return this.dev_id;
    }

    public final String getParams() {
        return this.params;
    }

    public final int getTitan_port() {
        return this.titan_port;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        String str = this.app;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.app_ver;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.user_id;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.dev_id;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.communication_key;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.params;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.android_id;
        return ((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.titan_port;
    }

    public final void setAndroid_id(String str) {
        i.h(str, "<set-?>");
        this.android_id = str;
    }

    public final void setApp(String str) {
        i.h(str, "<set-?>");
        this.app = str;
    }

    public final void setApp_ver(String str) {
        i.h(str, "<set-?>");
        this.app_ver = str;
    }

    public final void setCommunication_key(String str) {
        i.h(str, "<set-?>");
        this.communication_key = str;
    }

    public final void setDev_id(String str) {
        i.h(str, "<set-?>");
        this.dev_id = str;
    }

    public final void setParams(String str) {
        i.h(str, "<set-?>");
        this.params = str;
    }

    public final void setTitan_port(int i10) {
        this.titan_port = i10;
    }

    public final void setUser_id(String str) {
        i.h(str, "<set-?>");
        this.user_id = str;
    }

    public String toString() {
        return "Env(app=" + this.app + ", app_ver=" + this.app_ver + ", user_id=" + this.user_id + ", dev_id=" + this.dev_id + ", communication_key=" + this.communication_key + ", params=" + this.params + ", android_id=" + this.android_id + ", titan_port=" + this.titan_port + ")";
    }

    public Env(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10) {
        i.h(str, "app");
        i.h(str2, "app_ver");
        i.h(str3, "user_id");
        i.h(str4, "dev_id");
        i.h(str5, "communication_key");
        i.h(str6, "params");
        i.h(str7, "android_id");
        this.app = str;
        this.app_ver = str2;
        this.user_id = str3;
        this.dev_id = str4;
        this.communication_key = str5;
        this.params = str6;
        this.android_id = str7;
        this.titan_port = i10;
    }

    public /* synthetic */ Env(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, g gVar) {
        this(str, str2, str3, str4, str5, str6, str7, (i11 & 128) != 0 ? -1 : i10);
    }
}
