package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface d extends IInterface {

    public static class a implements d {
        @Override // com.umeng.analytics.pro.d
        public String a() {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public String b(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public String a(String str) {
            return null;
        }
    }

    String a();

    String a(String str);

    String b(String str);

    public static abstract class b extends Binder implements d {

        /* renamed from: a, reason: collision with root package name */
        static final int f10226a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f10227b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f10228c = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final String f10229d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public static class a implements d {

            /* renamed from: a, reason: collision with root package name */
            public static d f10230a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f10231b;

            public a(IBinder iBinder) {
                this.f10231b = iBinder;
            }

            @Override // com.umeng.analytics.pro.d
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10229d);
                    if (!this.f10231b.transact(1, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10231b;
            }

            public String b() {
                return b.f10229d;
            }

            @Override // com.umeng.analytics.pro.d
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10229d);
                    obtain.writeString(str);
                    if (!this.f10231b.transact(3, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.d
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10229d);
                    obtain.writeString(str);
                    if (!this.f10231b.transact(2, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f10229d);
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f10229d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new a(iBinder) : (d) queryLocalInterface;
        }

        public static d b() {
            return a.f10230a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(f10229d);
                String a10 = a();
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f10229d);
                String a11 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a11);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f10229d);
                return true;
            }
            parcel.enforceInterface(f10229d);
            String b10 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b10);
            return true;
        }

        public static boolean a(d dVar) {
            if (a.f10230a != null || dVar == null) {
                return false;
            }
            a.f10230a = dVar;
            return true;
        }
    }
}
