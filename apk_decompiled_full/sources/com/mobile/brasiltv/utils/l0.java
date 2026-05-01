package com.mobile.brasiltv.utils;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public final class l0 implements v9.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8730a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8731b;

    public l0(String str, String str2) {
        t9.i.g(str2, "defaultValue");
        this.f8730a = str;
        this.f8731b = str2;
    }

    @Override // v9.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String b(c cVar, z9.g gVar) {
        t9.i.g(cVar, "thisRef");
        t9.i.g(gVar, "property");
        SharedPreferences e10 = cVar.e();
        String str = this.f8730a;
        if (str == null) {
            str = gVar.getName();
        }
        String string = e10.getString(str, this.f8731b);
        return string == null ? "" : string;
    }

    @Override // v9.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(c cVar, z9.g gVar, String str) {
        t9.i.g(cVar, "thisRef");
        t9.i.g(gVar, "property");
        t9.i.g(str, "value");
        SharedPreferences.Editor edit = cVar.e().edit();
        String str2 = this.f8730a;
        if (str2 == null) {
            str2 = gVar.getName();
        }
        edit.putString(str2, str).apply();
    }
}
