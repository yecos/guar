package com.taobao.accs.data;

import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Set;

/* loaded from: classes3.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9126a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9127b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Intent f9128c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f9129d;

    public i(g gVar, String str, String str2, Intent intent) {
        this.f9129d = gVar;
        this.f9126a = str;
        this.f9127b = str2;
        this.f9128c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set set;
        Set set2;
        Set set3;
        set = g.f9122a;
        if (set != null) {
            set2 = g.f9122a;
            if (set2.contains(this.f9126a)) {
                ALog.e("MsgDistribute", "routing msg time out, try election", Constants.KEY_DATA_ID, this.f9126a, Constants.KEY_SERVICE_ID, this.f9127b);
                set3 = g.f9122a;
                set3.remove(this.f9126a);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + this.f9128c.getPackage());
            }
        }
    }
}
