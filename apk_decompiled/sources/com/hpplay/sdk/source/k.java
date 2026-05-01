package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface k extends IInterface {

    public static abstract class a extends Binder implements k {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIHistoryDeviceListener";
        static final int TRANSACTION_onGetDeviceList = 2;
        static final int TRANSACTION_onRemoveDevice = 1;

        /* renamed from: com.hpplay.sdk.source.k$a$a, reason: collision with other inner class name */
        public static class C0138a implements k {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7678a;

            public C0138a(IBinder iBinder) {
                this.f7678a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7678a;
            }

            @Override // com.hpplay.sdk.source.k
            public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeTypedList(list);
                    this.f7678a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.k
            public void onRemoveDevice(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f7678a.transact(1, obtain, obtain2, 0);
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

        public static k asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new C0138a(iBinder) : (k) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onRemoveDevice(parcel.readInt(), parcel.readInt());
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
            onGetDeviceList(parcel.readInt(), parcel.readInt(), parcel.createTypedArrayList(LelinkServiceInfo.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list);

    void onRemoveDevice(int i10, int i11);
}
