package com.efs.sdk.memoryinfo;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    final EfsReporter f6301a;

    /* renamed from: b, reason: collision with root package name */
    boolean f6302b = false;
    final Context mContext;

    public b(Context context, EfsReporter efsReporter) {
        this.mContext = context.getApplicationContext();
        this.f6301a = efsReporter;
    }

    public static /* synthetic */ void a(b bVar, e eVar, String str) {
        c cVar = new c(bVar.mContext);
        EfsJSONLog efsJSONLog = new EfsJSONLog("memperf");
        efsJSONLog.put("w_pgid", str);
        efsJSONLog.put("crver", "0.0.4.umeng");
        efsJSONLog.put("k_st", cVar.bg);
        efsJSONLog.put("w_url", cVar.activity);
        efsJSONLog.put("wl_tpss", Long.valueOf(cVar.f6317n));
        efsJSONLog.put("wl_jpss", Long.valueOf(cVar.f6318o));
        efsJSONLog.put("wl_npss", Long.valueOf(cVar.f6319p));
        efsJSONLog.put("wl_heap", Long.valueOf(cVar.f6320q));
        efsJSONLog.put("wf_heap_used_rate", Float.valueOf(cVar.f6321r));
        efsJSONLog.put("wl_graphics", Long.valueOf(cVar.f6322s));
        efsJSONLog.put("wl_vmsize", Long.valueOf(cVar.f6323t));
        synchronized (e.class) {
            if (eVar.C) {
                eVar.a(efsJSONLog);
            } else {
                eVar.B.add(efsJSONLog);
            }
        }
    }
}
