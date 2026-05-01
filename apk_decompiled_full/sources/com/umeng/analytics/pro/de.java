package com.umeng.analytics.pro;

import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public final class de {

    /* renamed from: a, reason: collision with root package name */
    public final String f10270a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10271b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10272c;

    public de() {
        this("", (byte) 0, 0);
    }

    public boolean a(de deVar) {
        return this.f10270a.equals(deVar.f10270a) && this.f10271b == deVar.f10271b && this.f10272c == deVar.f10272c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof de) {
            return a((de) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f10270a + "' type: " + ((int) this.f10271b) + " seqid:" + this.f10272c + Operator.Operation.GREATER_THAN;
    }

    public de(String str, byte b10, int i10) {
        this.f10270a = str;
        this.f10271b = b10;
        this.f10272c = i10;
    }
}
