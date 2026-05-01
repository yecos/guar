package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

/* loaded from: classes3.dex */
public interface v extends IInterface {

    public static abstract class a extends Binder implements v {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIServiceInfoParseListener";
        static final int TRANSACTION_onParseResult = 1;

        /* renamed from: com.hpplay.sdk.source.v$a$a, reason: collision with other inner class name */
        public static class C0152a implements v {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7741a;

            public C0152a(IBinder iBinder) {
                this.f7741a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7741a;
            }

            @Override // com.hpplay.sdk.source.v
            public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7741a.transact(1, obtain, obtain2, 0);
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

        public static v asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof v)) ? new C0152a(iBinder) : (v) queryLocalInterface;
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
            onParseResult(parcel.readInt(), parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo);
}
