package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* loaded from: classes3.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9318a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9319b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f9320c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f9321d;

    public b(AccsDataListener accsDataListener, String str, int i10, Intent intent) {
        this.f9318a = accsDataListener;
        this.f9319b = str;
        this.f9320c = i10;
        this.f9321d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo c10;
        AccsDataListener accsDataListener = this.f9318a;
        String str = this.f9319b;
        int i10 = this.f9320c;
        c10 = a.c(this.f9321d);
        accsDataListener.onBind(str, i10, c10);
    }
}
