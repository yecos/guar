package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.ReceiverProperties;

/* loaded from: classes3.dex */
public interface q extends IInterface {

    public static abstract class a extends Binder implements q {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIReceiverPropertiesCallback";
        static final int TRANSACTION_callback = 1;

        /* renamed from: com.hpplay.sdk.source.q$a$a, reason: collision with other inner class name */
        public static class C0147a implements q {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7736a;

            public C0147a(IBinder iBinder) {
                this.f7736a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7736a;
            }

            @Override // com.hpplay.sdk.source.q
            public void callback(ReceiverProperties receiverProperties) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (receiverProperties != null) {
                        obtain.writeInt(1);
                        receiverProperties.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7736a.transact(1, obtain, obtain2, 0);
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

        public static q asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof q)) ? new C0147a(iBinder) : (q) queryLocalInterface;
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
            callback(parcel.readInt() != 0 ? ReceiverProperties.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void callback(ReceiverProperties receiverProperties);
}
