package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    public static final class C0179a {

        /* renamed from: a, reason: collision with root package name */
        private final String f11040a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f11041b;

        public C0179a(String str, boolean z10) {
            this.f11040a = str;
            this.f11041b = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f11040a;
        }

        public boolean a() {
            return this.f11041b;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f11042a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f11043b;

        private b() {
            this.f11042a = false;
            this.f11043b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f11042a) {
                throw new IllegalStateException();
            }
            this.f11042a = true;
            return this.f11043b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f11043b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0179a c10 = c(context);
            if (c10 != null && !c10.a()) {
                return c10.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0179a c10 = c(context);
            if (c10 == null) {
                return null;
            }
            return c10.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0179a c(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper() || com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
            return null;
        }
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                c cVar = new c(bVar.a());
                boolean a10 = cVar.a(true);
                return new C0179a(a10 ? "" : cVar.a(), a10);
            } catch (Exception e10) {
                throw e10;
            }
        } finally {
            context.unbindService(bVar);
        }
    }

    public static final class c implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f11044a;

        public c(IBinder iBinder) {
            this.f11044a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f11044a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f11044a;
        }

        public boolean a(boolean z10) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z10 ? 1 : 0);
                this.f11044a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
