package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f17839a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17840b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f17841c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17842d;

    public b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f17842d = agooFactory;
        this.f17839a = bArr;
        this.f17840b = str;
        this.f17841c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17842d.msgReceiverPreHandler(this.f17839a, this.f17840b, this.f17841c, true);
    }
}
