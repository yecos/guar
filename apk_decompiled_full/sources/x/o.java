package x;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class o {

    public static class a implements Parcelable.ClassLoaderCreator {

        /* renamed from: a, reason: collision with root package name */
        public final p f19284a;

        public a(p pVar) {
            this.f19284a = pVar;
        }

        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return this.f19284a.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i10) {
            return this.f19284a.newArray(i10);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f19284a.createFromParcel(parcel, classLoader);
        }
    }

    public static Parcelable.Creator a(p pVar) {
        return new a(pVar);
    }
}
