package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* loaded from: classes.dex */
class SupportInfo {

    /* renamed from: a, reason: collision with root package name */
    String f17888a;

    /* renamed from: b, reason: collision with root package name */
    Boolean f17889b;

    public void a(boolean z10) {
        this.f17889b = Boolean.valueOf(z10);
    }

    public void b(String str) {
        this.f17888a = str;
    }

    public boolean a() {
        return this.f17889b != null;
    }

    public boolean b() {
        Boolean bool = this.f17889b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f17888a, str);
    }
}
