package org.repackage.com.meizu.flyme.openidsdk;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
class ValueData {

    /* renamed from: a, reason: collision with root package name */
    public String f17890a;

    /* renamed from: b, reason: collision with root package name */
    public int f17891b;

    /* renamed from: c, reason: collision with root package name */
    public long f17892c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i10) {
        this.f17890a = str;
        this.f17891b = i10;
    }

    public String toString() {
        return "ValueData{value='" + this.f17890a + "', code=" + this.f17891b + ", expired=" + this.f17892c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
