package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* loaded from: classes3.dex */
final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9348a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9349b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9350c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f9351d;

    public h(AccsDataListener accsDataListener, String str, boolean z10, boolean z11) {
        this.f9348a = accsDataListener;
        this.f9349b = str;
        this.f9350c = z10;
        this.f9351d = z11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9348a.onConnected(new TaoBaseService.ConnectInfo(this.f9349b, this.f9350c, this.f9351d));
    }
}
