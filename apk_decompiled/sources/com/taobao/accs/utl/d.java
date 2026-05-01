package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9326a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9327b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f9328c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f9329d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f9330e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f9331f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f9332g;

    public d(String str, String str2, int i10, AccsDataListener accsDataListener, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        this.f9326a = str;
        this.f9327b = str2;
        this.f9328c = i10;
        this.f9329d = accsDataListener;
        this.f9330e = str3;
        this.f9331f = bArr;
        this.f9332g = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f9326a)) {
            ALog.e(a.TAG, "onData start", Constants.KEY_DATA_ID, this.f9327b, Constants.KEY_SERVICE_ID, this.f9326a, "command", Integer.valueOf(this.f9328c), "className", this.f9329d.getClass().getName());
        }
        this.f9329d.onData(this.f9326a, this.f9330e, this.f9327b, this.f9331f, this.f9332g);
        if (ALog.isPrintLog(level) || "accs-impaas".equals(this.f9326a)) {
            ALog.e(a.TAG, "onData end", Constants.KEY_DATA_ID, this.f9327b);
        }
    }
}
