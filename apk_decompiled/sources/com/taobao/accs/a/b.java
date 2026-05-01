package com.taobao.accs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;

/* loaded from: classes3.dex */
final class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f9016a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9017b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f9018c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f9019d;

    public b(Intent intent, Context context, Context context2, int i10) {
        this.f9016a = intent;
        this.f9017b = context;
        this.f9018c = context2;
        this.f9019d = i10;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d(a.TAG, "bindService connected", "componentName", componentName.toString());
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable("intent", this.f9016a);
            messenger.send(message);
            try {
                this.f9017b.unbindService(this);
            } catch (Throwable unused) {
            }
            if (!this.f9018c.getPackageName().equals(componentName.getPackageName())) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e(a.TAG, "dispatch intent with exception", th, new Object[0]);
                try {
                    this.f9017b.unbindService(this);
                } catch (Throwable unused2) {
                }
                if (!this.f9018c.getPackageName().equals(componentName.getPackageName())) {
                    return;
                }
            } finally {
            }
        }
        k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d(a.TAG, "bindService on disconnect", "componentName", componentName.toString());
        try {
            this.f9017b.unbindService(this);
        } catch (Throwable unused) {
        }
        if (this.f9018c.getPackageName().equals(componentName.getPackageName())) {
            k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName(), UtilityImpl.a(this.f9019d - 3), "onServiceDisconnected");
        }
    }
}
