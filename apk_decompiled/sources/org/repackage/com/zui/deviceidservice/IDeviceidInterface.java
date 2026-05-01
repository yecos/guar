package org.repackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IDeviceidInterface extends IInterface {
    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();

    boolean c(String str);

    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a, reason: collision with root package name */
        static final int f17973a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f17974b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f17975c = 3;

        /* renamed from: d, reason: collision with root package name */
        static final int f17976d = 4;

        /* renamed from: e, reason: collision with root package name */
        static final int f17977e = 5;

        /* renamed from: f, reason: collision with root package name */
        static final int f17978f = 6;

        /* renamed from: g, reason: collision with root package name */
        private static final String f17979g = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        public Stub() {
            attachInterface(this, f17979g);
        }

        public static IDeviceidInterface a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f17979g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(f17979g);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f17979g);
                    String a10 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a10);
                    return true;
                case 2:
                    parcel.enforceInterface(f17979g);
                    String b10 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b10);
                    return true;
                case 3:
                    parcel.enforceInterface(f17979g);
                    boolean c10 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c10 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f17979g);
                    String a11 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a11);
                    return true;
                case 5:
                    parcel.enforceInterface(f17979g);
                    String b11 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b11);
                    return true;
                case 6:
                    parcel.enforceInterface(f17979g);
                    boolean c11 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c11 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        public static class Proxy implements IDeviceidInterface {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f17980a;

            public Proxy(IBinder iBinder) {
                this.f17980a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f17979g);
                    this.f17980a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17980a;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f17979g);
                    this.f17980a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f17979g);
                    this.f17980a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() {
                return Stub.f17979g;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f17979g);
                    obtain.writeString(str);
                    this.f17980a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f17979g);
                    obtain.writeString(str);
                    this.f17980a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f17979g);
                    obtain.writeString(str);
                    this.f17980a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
