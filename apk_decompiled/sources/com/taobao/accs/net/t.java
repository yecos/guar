package com.taobao.accs.net;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9226a;

    public t(k kVar) {
        this.f9226a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            k kVar = this.f9226a;
            if (kVar.f9160d == null || TextUtils.isEmpty(kVar.i())) {
                return;
            }
            ALog.i(this.f9226a.d(), "mTryStartServiceRunable bindapp", new Object[0]);
            this.f9226a.k();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
