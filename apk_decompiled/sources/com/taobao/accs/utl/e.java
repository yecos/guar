package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetPerformanceMonitor f9333a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9334b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9335c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9336d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f9337e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f9338f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Intent f9339g;

    public e(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i10, byte[] bArr, Intent intent) {
        this.f9333a = netPerformanceMonitor;
        this.f9334b = str;
        this.f9335c = str2;
        this.f9336d = accsDataListener;
        this.f9337e = i10;
        this.f9338f = bArr;
        this.f9339g = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo c10;
        NetPerformanceMonitor netPerformanceMonitor = this.f9333a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f9334b)) {
            ALog.e(a.TAG, "onResponse start dataId:" + this.f9335c + " serviceId:" + this.f9334b, new Object[0]);
        }
        AccsDataListener accsDataListener = this.f9336d;
        String str = this.f9334b;
        String str2 = this.f9335c;
        int i10 = this.f9337e;
        byte[] bArr = this.f9338f;
        c10 = a.c(this.f9339g);
        accsDataListener.onResponse(str, str2, i10, bArr, c10);
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f9334b)) {
            ALog.e(a.TAG, "onResponse end dataId:" + this.f9335c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f9333a);
    }
}
