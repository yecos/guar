package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetPerformanceMonitor f9340a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9341b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9342c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9343d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f9344e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Intent f9345f;

    public f(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i10, Intent intent) {
        this.f9340a = netPerformanceMonitor;
        this.f9341b = str;
        this.f9342c = str2;
        this.f9343d = accsDataListener;
        this.f9344e = i10;
        this.f9345f = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo c10;
        NetPerformanceMonitor netPerformanceMonitor = this.f9340a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f9341b)) {
            ALog.e(a.TAG, "onSendData start dataId:" + this.f9342c + " serviceId:" + this.f9341b, new Object[0]);
        }
        AccsDataListener accsDataListener = this.f9343d;
        String str = this.f9341b;
        String str2 = this.f9342c;
        int i10 = this.f9344e;
        c10 = a.c(this.f9345f);
        accsDataListener.onSendData(str, str2, i10, c10);
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f9341b)) {
            ALog.e(a.TAG, "onSendData end dataId:" + this.f9342c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f9340a);
    }
}
