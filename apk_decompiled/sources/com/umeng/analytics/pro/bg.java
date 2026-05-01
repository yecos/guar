package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class bg implements be {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10004a = "Coolpad";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10005b = "com.coolpad.deviceidsupport";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10006c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d, reason: collision with root package name */
    private static a f10007d;

    /* renamed from: f, reason: collision with root package name */
    private CountDownLatch f10009f;

    /* renamed from: g, reason: collision with root package name */
    private Context f10010g;

    /* renamed from: e, reason: collision with root package name */
    private String f10008e = "";

    /* renamed from: h, reason: collision with root package name */
    private final ServiceConnection f10011h = new ServiceConnection() { // from class: com.umeng.analytics.pro.bg.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = bg.f10007d = a.b.a(iBinder);
                bg.this.f10008e = bg.f10007d.b(bg.this.f10010g.getPackageName());
                StringBuilder sb = new StringBuilder();
                sb.append("onServiceConnected: oaid = ");
                sb.append(bg.this.f10008e);
            } catch (RemoteException | NullPointerException e10) {
                Log.e(bg.f10004a, "onServiceConnected failed e=" + e10.getMessage());
            }
            bg.this.f10009f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a unused = bg.f10007d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f10005b, f10006c));
            if (context.bindService(intent, this.f10011h, 1)) {
                return;
            }
            Log.e(f10004a, "bindService return false");
        } catch (Throwable th) {
            Log.e(f10004a, "bindService failed. e=" + th.getMessage());
            this.f10009f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f10011h);
        } catch (Throwable th) {
            Log.e(f10004a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f10010g = context.getApplicationContext();
        this.f10009f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f10009f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(f10004a, "getOAID time-out");
            }
            return this.f10008e;
        } catch (InterruptedException e10) {
            Log.e(f10004a, "getOAID interrupted. e=" + e10.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
