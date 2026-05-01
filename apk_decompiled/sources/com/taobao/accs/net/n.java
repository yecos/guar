package com.taobao.accs.net;

import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;

/* loaded from: classes3.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ConnectInfo f9209a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccsConnectStateListener f9210b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f9211c;

    public n(m mVar, TaoBaseService.ConnectInfo connectInfo, AccsConnectStateListener accsConnectStateListener) {
        this.f9211c = mVar;
        this.f9209a = connectInfo;
        this.f9210b = accsConnectStateListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ConnectInfo connectInfo = this.f9209a;
        if (connectInfo.connected) {
            this.f9210b.onConnected(connectInfo);
        } else {
            this.f9210b.onDisconnected(connectInfo);
        }
    }
}
