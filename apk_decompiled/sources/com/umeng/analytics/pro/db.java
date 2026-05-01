package com.umeng.analytics.pro;

import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class db {

    /* renamed from: a, reason: collision with root package name */
    public final String f10262a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10263b;

    /* renamed from: c, reason: collision with root package name */
    public final short f10264c;

    public db() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(db dbVar) {
        return this.f10263b == dbVar.f10263b && this.f10264c == dbVar.f10264c;
    }

    public String toString() {
        return "<TField name:'" + this.f10262a + "' type:" + ((int) this.f10263b) + " field-id:" + ((int) this.f10264c) + Operator.Operation.GREATER_THAN;
    }

    public db(String str, byte b10, short s10) {
        this.f10262a = str;
        this.f10263b = b10;
        this.f10264c = s10;
    }
}
