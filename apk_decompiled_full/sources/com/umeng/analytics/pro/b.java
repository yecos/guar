package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i10, Bundle bundle) {
        }
    }

    void a(int i10, long j10, boolean z10, float f10, double d10, String str);

    void a(int i10, Bundle bundle);

    /* renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0171b extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        static final int f9948a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f9949b = 2;

        /* renamed from: c, reason: collision with root package name */
        private static final String f9950c = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* renamed from: com.umeng.analytics.pro.b$b$a */
        public static class a implements b {

            /* renamed from: a, reason: collision with root package name */
            public static b f9951a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f9952b;

            public a(IBinder iBinder) {
                this.f9952b = iBinder;
            }

            public String a() {
                return AbstractBinderC0171b.f9950c;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9952b;
            }

            @Override // com.umeng.analytics.pro.b
            public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0171b.f9950c);
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.f9952b.transact(1, obtain, obtain2, 0) || AbstractBinderC0171b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        AbstractBinderC0171b.a().a(i10, j10, z10, f10, d10, str);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.umeng.analytics.pro.b
            public void a(int i10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0171b.f9950c);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f9952b.transact(2, obtain, obtain2, 0) && AbstractBinderC0171b.a() != null) {
                        AbstractBinderC0171b.a().a(i10, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0171b() {
            attachInterface(this, f9950c);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f9950c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(f9950c);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f9950c);
                return true;
            }
            parcel.enforceInterface(f9950c);
            a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        public static boolean a(b bVar) {
            if (a.f9951a != null || bVar == null) {
                return false;
            }
            a.f9951a = bVar;
            return true;
        }

        public static b a() {
            return a.f9951a;
        }
    }
}
