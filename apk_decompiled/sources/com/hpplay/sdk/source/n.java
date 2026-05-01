package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface n extends IInterface {

    public static abstract class a extends Binder implements n {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIMirrorChangeListener";
        static final int TRANSACTION_onMirrorChange = 1;

        /* renamed from: com.hpplay.sdk.source.n$a$a, reason: collision with other inner class name */
        public static class C0141a implements n {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7733a;

            public C0141a(IBinder iBinder) {
                this.f7733a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7733a;
            }

            @Override // com.hpplay.sdk.source.n
            public void onMirrorChange(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f7733a.transact(1, obtain, obtain2, 0);
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

        public static n asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new C0141a(iBinder) : (n) queryLocalInterface;
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
            onMirrorChange(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onMirrorChange(int i10, int i11);
}
