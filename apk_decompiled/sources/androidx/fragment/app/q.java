package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f2387a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2388b;

    /* renamed from: c, reason: collision with root package name */
    public b[] f2389c;

    /* renamed from: d, reason: collision with root package name */
    public int f2390d;

    /* renamed from: e, reason: collision with root package name */
    public String f2391e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f2392f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f2393g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f2394h;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i10) {
            return new q[i10];
        }
    }

    public q() {
        this.f2391e = null;
        this.f2392f = new ArrayList();
        this.f2393g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f2387a);
        parcel.writeStringList(this.f2388b);
        parcel.writeTypedArray(this.f2389c, i10);
        parcel.writeInt(this.f2390d);
        parcel.writeString(this.f2391e);
        parcel.writeStringList(this.f2392f);
        parcel.writeTypedList(this.f2393g);
        parcel.writeTypedList(this.f2394h);
    }

    public q(Parcel parcel) {
        this.f2391e = null;
        this.f2392f = new ArrayList();
        this.f2393g = new ArrayList();
        this.f2387a = parcel.createTypedArrayList(u.CREATOR);
        this.f2388b = parcel.createStringArrayList();
        this.f2389c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f2390d = parcel.readInt();
        this.f2391e = parcel.readString();
        this.f2392f = parcel.createStringArrayList();
        this.f2393g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2394h = parcel.createTypedArrayList(o.l.CREATOR);
    }
}
