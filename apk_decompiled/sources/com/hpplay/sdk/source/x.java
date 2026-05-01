package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public interface x extends IInterface {

    public static abstract class a extends Binder implements x {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AISinkTouchEventListener";
        static final int TRANSACTION_onTouchEvent = 1;

        /* renamed from: com.hpplay.sdk.source.x$a$a, reason: collision with other inner class name */
        public static class C0154a implements x {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7743a;

            public C0154a(IBinder iBinder) {
                this.f7743a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7743a;
            }

            @Override // com.hpplay.sdk.source.x
            public void onTouchEvent(MotionEvent motionEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (motionEvent != null) {
                        obtain.writeInt(1);
                        motionEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7743a.transact(1, obtain, obtain2, 0);
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

        public static x asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof x)) ? new C0154a(iBinder) : (x) queryLocalInterface;
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
            onTouchEvent(parcel.readInt() != 0 ? (MotionEvent) MotionEvent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onTouchEvent(MotionEvent motionEvent);
}
