package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes.dex */
public class OpenDeviceId {

    /* renamed from: c, reason: collision with root package name */
    private static String f17987c = "OpenDeviceId library";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f17988d = false;

    /* renamed from: b, reason: collision with root package name */
    private IDeviceidInterface f17990b;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f17991e;

    /* renamed from: a, reason: collision with root package name */
    private Context f17989a = null;

    /* renamed from: f, reason: collision with root package name */
    private CallBack f17992f = null;

    public interface CallBack<T> {
        void a(T t10, OpenDeviceId openDeviceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    public String b() {
        if (this.f17989a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f17990b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.b();
            }
            return null;
        } catch (RemoteException e10) {
            b("getUDID error, RemoteException!");
            e10.printStackTrace();
            return null;
        } catch (Exception e11) {
            b("getUDID error, Exception!");
            e11.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.f17990b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f17990b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f17989a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f17990b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.a(packageName);
            }
            return null;
        } catch (RemoteException e10) {
            b("getVAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f17989a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        String str = null;
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f17990b;
            if (iDeviceidInterface == null) {
                return null;
            }
            str = iDeviceidInterface.b(packageName);
            return ((str == null || "".equals(str)) && this.f17990b.c(packageName)) ? this.f17990b.b(packageName) : str;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return str;
        }
    }

    public void f() {
        try {
            this.f17989a.unbindService(this.f17991e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f17990b = null;
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.f17989a = context;
            this.f17992f = callBack;
            this.f17991e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    OpenDeviceId.this.f17990b = IDeviceidInterface.Stub.a(iBinder);
                    if (OpenDeviceId.this.f17992f != null) {
                        OpenDeviceId.this.f17992f.a("Deviceid Service Connected", OpenDeviceId.this);
                    }
                    OpenDeviceId.this.a("Service onServiceConnected");
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.f17990b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f17989a.bindService(intent, this.f17991e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        if (f17988d) {
            Log.e(f17987c, str);
        }
    }

    public String a() {
        if (this.f17989a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f17990b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e10) {
                b("getOAID error, RemoteException!");
                e10.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z10) {
        f17988d = z10;
    }
}
