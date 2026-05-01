package com.umeng.message.proguard;

import com.hpplay.sdk.source.mdns.Querier;
import com.umeng.message.proguard.cq;
import org.json.JSONObject;

/* loaded from: classes3.dex */
abstract class cp {
    public final void a(ck ckVar, int i10, int i11) {
        a(ckVar, i10, i11, null, null);
    }

    public abstract void a(ck ckVar, int i10, int i11, String str, JSONObject jSONObject);

    public abstract void a(ck ckVar, cq.a aVar);

    public abstract void a(ck ckVar, boolean z10, cq.a aVar);

    public abstract void a(String str, ck ckVar);

    public abstract boolean a(ck ckVar);

    public final void b(ck ckVar, int i10) {
        a(ckVar, 2, i10);
    }

    public final void c(ck ckVar, int i10) {
        a(ckVar, 3, i10);
    }

    public final void a(ck ckVar, int i10, int i11, String str) {
        a(ckVar, i10, i11, str, null);
    }

    public final void a(ck ckVar, int i10) {
        a(ckVar, 1, i10);
    }

    public final void a(boolean z10, ck ckVar, boolean z11, int i10, int i11, long j10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v_play", z11 ? 1 : 0);
            jSONObject.put("v_play_t", i10);
            jSONObject.put("v_duration", i11);
            jSONObject.put("v_view_t", j10);
            a(ckVar, 6, z10 ? Querier.DEFAULT_TIMEOUT : 6001, null, jSONObject);
        } catch (Throwable unused) {
        }
    }
}
