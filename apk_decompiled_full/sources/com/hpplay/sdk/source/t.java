package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.PassBean;

/* loaded from: classes3.dex */
public interface t extends IInterface {

    public static abstract class a extends Binder implements t {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AISendPassCallback";
        static final int TRANSACTION_onSendPassCallBack = 1;

        /* renamed from: com.hpplay.sdk.source.t$a$a, reason: collision with other inner class name */
        public static class C0150a implements t {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7739a;

            public C0150a(IBinder iBinder) {
                this.f7739a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7739a;
            }

            @Override // com.hpplay.sdk.source.t
            public void onSendPassCallBack(PassBean passBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (passBean != null) {
                        obtain.writeInt(1);
                        passBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7739a.transact(1, obtain, obtain2, 0);
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

        public static t asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new C0150a(iBinder) : (t) queryLocalInterface;
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
            onSendPassCallBack(parcel.readInt() != 0 ? PassBean.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onSendPassCallBack(PassBean passBean);
}
