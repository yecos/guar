package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.b;

/* loaded from: classes3.dex */
public interface c extends IInterface {

    public static class a implements c {
        @Override // com.umeng.analytics.pro.c
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.c
        public void b(com.umeng.analytics.pro.b bVar) {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(com.umeng.analytics.pro.b bVar) {
        }
    }

    void a(int i10, long j10, boolean z10, float f10, double d10, String str);

    void a(com.umeng.analytics.pro.b bVar);

    void b(com.umeng.analytics.pro.b bVar);

    public static abstract class b extends Binder implements c {

        /* renamed from: a, reason: collision with root package name */
        static final int f10148a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f10149b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f10150c = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final String f10151d = "com.hihonor.cloudservice.oaid.IOAIDService";

        public static class a implements c {

            /* renamed from: a, reason: collision with root package name */
            public static c f10152a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f10153b;

            public a(IBinder iBinder) {
                this.f10153b = iBinder;
            }

            public String a() {
                return b.f10151d;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10153b;
            }

            @Override // com.umeng.analytics.pro.c
            public void b(com.umeng.analytics.pro.b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10151d);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f10153b.transact(3, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                    } else {
                        b.a().b(bVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.c
            public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10151d);
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
                    if (this.f10153b.transact(1, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.a().a(i10, j10, z10, f10, d10, str);
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

            @Override // com.umeng.analytics.pro.c
            public void a(com.umeng.analytics.pro.b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10151d);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (!this.f10153b.transact(2, obtain, obtain2, 0) && b.a() != null) {
                        b.a().a(bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f10151d);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f10151d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(f10151d);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f10151d);
                a(b.AbstractBinderC0171b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f10151d);
                return true;
            }
            parcel.enforceInterface(f10151d);
            b(b.AbstractBinderC0171b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static boolean a(c cVar) {
            if (a.f10152a != null || cVar == null) {
                return false;
            }
            a.f10152a = cVar;
            return true;
        }

        public static c a() {
            return a.f10152a;
        }
    }
}
