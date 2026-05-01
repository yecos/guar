package com.umeng.message.proguard;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* loaded from: classes3.dex */
final class dk {

    /* renamed from: a, reason: collision with root package name */
    final ck f11920a;

    /* renamed from: b, reason: collision with root package name */
    final Bitmap f11921b;

    /* renamed from: c, reason: collision with root package name */
    private final String f11922c;

    public dk(ck ckVar, Bitmap bitmap) {
        this.f11920a = ckVar;
        this.f11922c = ckVar.c();
        this.f11921b = bitmap;
    }

    public final boolean a() {
        return bs.a(this.f11920a.a()) == bs.f11666a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dk)) {
            return false;
        }
        dk dkVar = (dk) obj;
        if (hashCode() != dkVar.hashCode()) {
            return false;
        }
        return TextUtils.equals(this.f11922c, dkVar.f11922c);
    }

    public final int hashCode() {
        String str = this.f11922c;
        return str != null ? str.hashCode() : super.hashCode();
    }
}
