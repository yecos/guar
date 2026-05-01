package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;

/* loaded from: classes3.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ServiceImpl.AnonymousClass1 f9154a;

    public e(ServiceImpl.AnonymousClass1 anonymousClass1) {
        this.f9154a = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        try {
            context = ServiceImpl.this.f9143c;
            if (context != null) {
                context2 = ServiceImpl.this.f9143c;
                if (UtilityImpl.e(context2)) {
                    Intent intent = new Intent();
                    intent.setAction("org.agoo.android.intent.action.PING_V4");
                    context3 = ServiceImpl.this.f9143c;
                    intent.setClassName(context3.getPackageName(), j.channelService);
                    context4 = ServiceImpl.this.f9143c;
                    context4.startService(intent);
                    UTMini uTMini = UTMini.getInstance();
                    context5 = ServiceImpl.this.f9143c;
                    uTMini.commitEvent(66001, "probeServiceEnabled", UtilityImpl.j(context5));
                    ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........mContext.startService(intent) [probe][successfully]", new Object[0]);
                    ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
                }
            }
            Process.killProcess(Process.myPid());
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
        } catch (Throwable th) {
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao error........e=" + th, new Object[0]);
        }
    }
}
