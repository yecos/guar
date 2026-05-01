package org.android.agoo.control;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
class i implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f17854a;

    public i(BaseIntentService baseIntentService) {
        this.f17854a = baseIntentService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
