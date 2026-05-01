package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import java.util.Map;

/* loaded from: classes3.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9102a;

    public c(a aVar) {
        this.f9102a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        String str;
        Map map;
        String str2;
        int i11;
        synchronized (this.f9102a) {
            i10 = this.f9102a.f9098f;
            if (i10 == 0) {
                str = this.f9102a.f9094b;
                ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, str);
                this.f9102a.f9098f = 1;
                map = this.f9102a.f9100h;
                map.clear();
                str2 = this.f9102a.f9094b;
                i11 = this.f9102a.f9098f;
                AppMonitor.getInstance().commitStat(new AssembleMonitor(str2, String.valueOf(i11)));
            }
        }
    }
}
