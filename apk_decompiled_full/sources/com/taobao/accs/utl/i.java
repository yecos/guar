package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* loaded from: classes3.dex */
final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9352a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9353b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9354c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f9355d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f9356e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f9357f;

    public i(AccsDataListener accsDataListener, String str, boolean z10, boolean z11, int i10, String str2) {
        this.f9352a = accsDataListener;
        this.f9353b = str;
        this.f9354c = z10;
        this.f9355d = z11;
        this.f9356e = i10;
        this.f9357f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9352a.onDisconnected(new TaoBaseService.ConnectInfo(this.f9353b, this.f9354c, this.f9355d, this.f9356e, this.f9357f));
    }
}
