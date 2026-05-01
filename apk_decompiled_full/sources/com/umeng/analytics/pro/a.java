package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    public static class C0169a implements a {
        @Override // com.umeng.analytics.pro.a
        public String a(String str) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String c(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String d(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String e(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() {
            return false;
        }

        @Override // com.umeng.analytics.pro.a
        public String b(String str) {
            return null;
        }
    }

    String a(String str);

    boolean a();

    String b();

    String b(String str);

    String c(String str);

    String d(String str);

    String e(String str);

    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        static final int f9824a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f9825b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f9826c = 3;

        /* renamed from: d, reason: collision with root package name */
        static final int f9827d = 4;

        /* renamed from: e, reason: collision with root package name */
        static final int f9828e = 5;

        /* renamed from: f, reason: collision with root package name */
        static final int f9829f = 6;

        /* renamed from: g, reason: collision with root package name */
        static final int f9830g = 7;

        /* renamed from: h, reason: collision with root package name */
        private static final String f9831h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* renamed from: com.umeng.analytics.pro.a$b$a, reason: collision with other inner class name */
        public static class C0170a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f9832a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f9833b;

            public C0170a(IBinder iBinder) {
                this.f9833b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    obtain.writeString(str);
                    if (!this.f9833b.transact(1, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a(str);
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
                return this.f9833b;
            }

            @Override // com.umeng.analytics.pro.a
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    obtain.writeString(str);
                    if (!this.f9833b.transact(2, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return b.f9831h;
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    obtain.writeString(str);
                    if (!this.f9833b.transact(4, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String e(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    obtain.writeString(str);
                    if (!this.f9833b.transact(5, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    obtain.writeString(str);
                    if (!this.f9833b.transact(3, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    if (!this.f9833b.transact(6, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f9831h);
                    if (!this.f9833b.transact(7, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b();
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
            attachInterface(this, f9831h);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f9831h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0170a(iBinder) : (a) queryLocalInterface;
        }

        public static a c() {
            return C0170a.f9832a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(f9831h);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f9831h);
                    String a10 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a10);
                    return true;
                case 2:
                    parcel.enforceInterface(f9831h);
                    String b10 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b10);
                    return true;
                case 3:
                    parcel.enforceInterface(f9831h);
                    String c10 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c10);
                    return true;
                case 4:
                    parcel.enforceInterface(f9831h);
                    String d10 = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(d10);
                    return true;
                case 5:
                    parcel.enforceInterface(f9831h);
                    String e10 = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(e10);
                    return true;
                case 6:
                    parcel.enforceInterface(f9831h);
                    boolean a11 = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a11 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(f9831h);
                    String b11 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b11);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        public static boolean a(a aVar) {
            if (C0170a.f9832a != null || aVar == null) {
                return false;
            }
            C0170a.f9832a = aVar;
            return true;
        }
    }
}
