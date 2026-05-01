package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.DaCastBean;

/* loaded from: classes3.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIDaPlayListener";
        static final int TRANSACTION_onLoading = 2;
        static final int TRANSACTION_onResult = 1;
        static final int TRANSACTION_onStart = 3;
        static final int TRANSACTION_onStop = 4;

        /* renamed from: com.hpplay.sdk.source.h$a$a, reason: collision with other inner class name */
        public static class C0135a implements h {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7675a;

            public C0135a(IBinder iBinder) {
                this.f7675a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7675a;
            }

            @Override // com.hpplay.sdk.source.h
            public void onLoading(DaCastBean daCastBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7675a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.h
            public void onResult(DaCastBean daCastBean, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f7675a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.h
            public void onStart(DaCastBean daCastBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7675a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.h
            public void onStop(DaCastBean daCastBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7675a.transact(4, obtain, obtain2, 0);
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

        public static h asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new C0135a(iBinder) : (h) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onResult(parcel.readInt() != 0 ? DaCastBean.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onLoading(parcel.readInt() != 0 ? DaCastBean.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onStart(parcel.readInt() != 0 ? DaCastBean.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 4) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onStop(parcel.readInt() != 0 ? DaCastBean.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onLoading(DaCastBean daCastBean);

    void onResult(DaCastBean daCastBean, boolean z10);

    void onStart(DaCastBean daCastBean);

    void onStop(DaCastBean daCastBean);
}
