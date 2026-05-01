package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.CommonResultBean;

/* loaded from: classes3.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AICommonListener";
        static final int TRANSACTION_onCallback = 1;

        /* renamed from: com.hpplay.sdk.source.d$a$a, reason: collision with other inner class name */
        public static class C0128a implements d {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7598a;

            public C0128a(IBinder iBinder) {
                this.f7598a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7598a;
            }

            @Override // com.hpplay.sdk.source.d
            public CommonResultBean onCallback(int i10, int i11, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.f7598a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CommonResultBean.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static d asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C0128a(iBinder) : (d) queryLocalInterface;
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
            CommonResultBean onCallback = onCallback(parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            if (onCallback != null) {
                parcel2.writeInt(1);
                onCallback.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    CommonResultBean onCallback(int i10, int i11, String str);
}
