package com.umeng.message.proguard;

import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
final class ay {

    /* renamed from: a, reason: collision with root package name */
    final bd f11613a = new bd(AgooConstants.MESSAGE_NOTIFICATION);

    private long e() {
        return this.f11613a.b("rep_ts", 0L);
    }

    public final boolean a() {
        return this.f11613a.b("e_u", true);
    }

    public final long b() {
        return this.f11613a.b("req_ts", 0L);
    }

    public final boolean c() {
        return Math.abs(System.currentTimeMillis() - e()) < 60000;
    }

    public final String d() {
        String b10 = this.f11613a.b("info", "");
        if (!TextUtils.isEmpty(b10)) {
            try {
                return new String(bf.a(b10));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final void a(boolean z10) {
        this.f11613a.a("e_s", z10);
    }

    public final void b(boolean z10) {
        this.f11613a.a("sync", z10);
    }

    public final void a(long j10) {
        this.f11613a.a("rep_ts", j10);
    }
}
