package org.android.agoo.control;

import android.content.Intent;

/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f17856a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17857b;

    public k(BaseIntentService baseIntentService, Intent intent) {
        this.f17857b = baseIntentService;
        this.f17856a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17857b.onHandleIntent(this.f17856a);
    }
}
