package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class CastAction {
    private String action;
    private String cast_ver;
    private String session;

    public CastAction(String str, String str2, String str3) {
        i.g(str, "cast_ver");
        i.g(str2, "session");
        i.g(str3, "action");
        this.cast_ver = str;
        this.session = str2;
        this.action = str3;
    }

    public static /* synthetic */ CastAction copy$default(CastAction castAction, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = castAction.cast_ver;
        }
        if ((i10 & 2) != 0) {
            str2 = castAction.session;
        }
        if ((i10 & 4) != 0) {
            str3 = castAction.action;
        }
        return castAction.copy(str, str2, str3);
    }

    public final String component1() {
        return this.cast_ver;
    }

    public final String component2() {
        return this.session;
    }

    public final String component3() {
        return this.action;
    }

    public final CastAction copy(String str, String str2, String str3) {
        i.g(str, "cast_ver");
        i.g(str2, "session");
        i.g(str3, "action");
        return new CastAction(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CastAction)) {
            return false;
        }
        CastAction castAction = (CastAction) obj;
        return i.b(this.cast_ver, castAction.cast_ver) && i.b(this.session, castAction.session) && i.b(this.action, castAction.action);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getCast_ver() {
        return this.cast_ver;
    }

    public final String getSession() {
        return this.session;
    }

    public int hashCode() {
        return (((this.cast_ver.hashCode() * 31) + this.session.hashCode()) * 31) + this.action.hashCode();
    }

    public final void setAction(String str) {
        i.g(str, "<set-?>");
        this.action = str;
    }

    public final void setCast_ver(String str) {
        i.g(str, "<set-?>");
        this.cast_ver = str;
    }

    public final void setSession(String str) {
        i.g(str, "<set-?>");
        this.session = str;
    }

    public String toString() {
        return "CastAction(cast_ver=" + this.cast_ver + ", session=" + this.session + ", action=" + this.action + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
