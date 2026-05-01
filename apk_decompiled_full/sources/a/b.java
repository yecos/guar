package a;

import a.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f67a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f68b = null;

    /* renamed from: c, reason: collision with root package name */
    public a.a f69c;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    /* renamed from: a.b$b, reason: collision with other inner class name */
    public class BinderC0002b extends a.AbstractBinderC0000a {
        public BinderC0002b() {
        }

        @Override // a.a
        public void c(int i10, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f68b;
            if (handler != null) {
                handler.post(bVar.new c(i10, bundle));
            } else {
                bVar.a(i10, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f71a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f72b;

        public c(int i10, Bundle bundle) {
            this.f71a = i10;
            this.f72b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f71a, this.f72b);
        }
    }

    public b(Parcel parcel) {
        this.f69c = a.AbstractBinderC0000a.i0(parcel.readStrongBinder());
    }

    public void a(int i10, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f69c == null) {
                this.f69c = new BinderC0002b();
            }
            parcel.writeStrongBinder(this.f69c.asBinder());
        }
    }
}
