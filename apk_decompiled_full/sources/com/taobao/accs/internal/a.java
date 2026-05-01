package com.taobao.accs.internal;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;

/* loaded from: classes3.dex */
class a implements l.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f9147a;

    public a(ACCSManagerImpl aCCSManagerImpl) {
        this.f9147a = aCCSManagerImpl;
    }

    @Override // com.taobao.accs.utl.l.b
    public void a() {
        String str;
        String str2;
        String str3;
        com.taobao.accs.c cVar;
        try {
            str2 = ACCSManagerImpl.f9136c;
            ALog.e(str2, "onForeState", new Object[0]);
            str3 = this.f9147a.f9138b;
            if (AccsClientConfig.getConfigByTag(str3).isForePingEnable()) {
                ACCSManagerImpl aCCSManagerImpl = this.f9147a;
                cVar = aCCSManagerImpl.f9139d;
                aCCSManagerImpl.a(cVar);
            }
        } catch (Exception e10) {
            str = ACCSManagerImpl.f9136c;
            ALog.e(str, "onForeState error, Error:", e10, new Object[0]);
        }
    }

    @Override // com.taobao.accs.utl.l.b
    public void b() {
        String str;
        str = ACCSManagerImpl.f9136c;
        ALog.e(str, "onBackState", new Object[0]);
    }
}
