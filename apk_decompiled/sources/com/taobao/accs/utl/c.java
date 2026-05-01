package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* loaded from: classes3.dex */
final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9322a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9323b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f9324c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f9325d;

    public c(AccsDataListener accsDataListener, String str, int i10, Intent intent) {
        this.f9322a = accsDataListener;
        this.f9323b = str;
        this.f9324c = i10;
        this.f9325d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo c10;
        AccsDataListener accsDataListener = this.f9322a;
        String str = this.f9323b;
        int i10 = this.f9324c;
        c10 = a.c(this.f9325d);
        accsDataListener.onUnbind(str, i10, c10);
    }
}
