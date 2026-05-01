package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

/* loaded from: classes3.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIConnectStatusListener";
        static final int TRANSACTION_onConnect = 1;
        static final int TRANSACTION_onDisconnect = 2;

        /* renamed from: com.hpplay.sdk.source.e$a$a, reason: collision with other inner class name */
        public static class C0130a implements e {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7672a;

            public C0130a(IBinder iBinder) {
                this.f7672a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7672a;
            }

            @Override // com.hpplay.sdk.source.e
            public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    this.f7672a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.e
            public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f7672a.transact(2, obtain, obtain2, 0);
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

        public static e asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0130a(iBinder) : (e) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onConnect(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
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
            onDisconnect(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10);

    void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11);
}
