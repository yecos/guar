package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.hpplay.sdk.source.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0123a extends Binder implements a {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIAuthListener";
        static final int TRANSACTION_onAuthFailed = 2;
        static final int TRANSACTION_onAuthSuccess = 1;

        /* renamed from: com.hpplay.sdk.source.a$a$a, reason: collision with other inner class name */
        public static class C0125a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7426a;

            public C0125a(IBinder iBinder) {
                this.f7426a = iBinder;
            }

            public String a() {
                return AbstractBinderC0123a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7426a;
            }

            @Override // com.hpplay.sdk.source.a
            public void onAuthFailed(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0123a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f7426a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.a
            public void onAuthSuccess(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0123a.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f7426a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0123a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0125a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAuthSuccess(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onAuthFailed(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onAuthFailed(int i10);

    void onAuthSuccess(String str, String str2);
}
