package com.efs.sdk.memoryinfo;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class e {
    final List<EfsJSONLog> B = new ArrayList();
    volatile boolean C;

    /* renamed from: a, reason: collision with root package name */
    private final EfsReporter f6330a;

    public e(final Context context, EfsReporter efsReporter) {
        this.f6330a = efsReporter;
        String uMId = UMUtils.getUMId(context);
        this.C = !TextUtils.isEmpty(uMId);
        if (!this.C) {
            ImprintHandler.getImprintService(context).registImprintCallback(bt.f10046g, new UMImprintChangeCallback() { // from class: com.efs.sdk.memoryinfo.e.1
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public final void onImprintValueChanged(String str, String str2) {
                    try {
                        if (bt.f10046g.equals(str)) {
                            HashMap hashMap = new HashMap(1);
                            hashMap.put(UMCrash.KEY_HEADER_UMID, str2);
                            e.this.f6330a.addPublicParams(hashMap);
                            synchronized (e.class) {
                                e.b(e.this);
                            }
                            Iterator it = e.this.B.iterator();
                            while (it.hasNext()) {
                                e.this.a((EfsJSONLog) it.next());
                            }
                            new StringBuilder("send cache:").append(e.this.B.size());
                            boolean z10 = a.DEBUG;
                            e.this.B.clear();
                            ImprintHandler.getImprintService(context).unregistImprintCallback(bt.f10046g, this);
                        }
                    } catch (Throwable th) {
                        f.a("umid ", th);
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(UMCrash.KEY_HEADER_UMID, uMId);
        efsReporter.addPublicParams(hashMap);
    }

    public static /* synthetic */ boolean b(e eVar) {
        eVar.C = true;
        return true;
    }

    public final void a(EfsJSONLog efsJSONLog) {
        try {
            this.f6330a.send(efsJSONLog);
        } catch (Throwable th) {
            f.a("send", th);
        }
    }
}
