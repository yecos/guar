package com.taobao.agoo.a.a;

import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;

/* loaded from: classes3.dex */
public class a extends b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";

    /* renamed from: a, reason: collision with root package name */
    public String f9390a;

    /* renamed from: b, reason: collision with root package name */
    public String f9391b;

    /* renamed from: c, reason: collision with root package name */
    public String f9392c;

    /* renamed from: d, reason: collision with root package name */
    public String f9393d;

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f9390a = str;
        aVar.f9391b = str2;
        aVar.f9393d = str3;
        aVar.f9394e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f9390a = str;
        aVar.f9391b = str2;
        aVar.f9392c = str3;
        aVar.f9394e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public byte[] a() {
        try {
            String jSONObject = new p.a().a(b.JSON_CMD, this.f9394e).a(Constants.KEY_APP_KEY, this.f9390a).a("deviceId", this.f9391b).a("alias", this.f9392c).a(JSON_PUSH_USER_TOKEN, this.f9393d).a().toString();
            ALog.i("AliasDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes(XML.CHARSET_UTF8);
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f9390a = str;
        aVar.f9391b = str2;
        aVar.f9392c = str3;
        aVar.f9394e = JSON_CMD_SETALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2) {
        a aVar = new a();
        aVar.f9390a = str;
        aVar.f9391b = str2;
        aVar.f9394e = JSON_CMD_REMOVEALLALIAS;
        return aVar.a();
    }
}
