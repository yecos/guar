package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AICreatePinCodeListener";
        static final int TRANSACTION_onCreatePinCode = 1;

        /* renamed from: com.hpplay.sdk.source.f$a$a, reason: collision with other inner class name */
        public static class C0133a implements f {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7673a;

            public C0133a(IBinder iBinder) {
                this.f7673a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7673a;
            }

            @Override // com.hpplay.sdk.source.f
            public void onCreatePinCode(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f7673a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static f asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0133a(iBinder) : (f) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onCreatePinCode(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onCreatePinCode(String str);
}
