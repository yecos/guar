package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import java.util.List;

/* loaded from: classes3.dex */
public interface u extends IInterface {

    public static abstract class a extends Binder implements u {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIServiceInfoListParseListener";
        static final int TRANSACTION_onParseResult = 1;

        /* renamed from: com.hpplay.sdk.source.u$a$a, reason: collision with other inner class name */
        public static class C0151a implements u {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7740a;

            public C0151a(IBinder iBinder) {
                this.f7740a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7740a;
            }

            @Override // com.hpplay.sdk.source.u
            public void onParseResult(List<ServiceInfoParseBean> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    this.f7740a.transact(1, obtain, obtain2, 0);
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

        public static u asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new C0151a(iBinder) : (u) queryLocalInterface;
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
            onParseResult(parcel.createTypedArrayList(ServiceInfoParseBean.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    void onParseResult(List<ServiceInfoParseBean> list);
}
