package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f697a;

    /* renamed from: b, reason: collision with root package name */
    public int f698b;

    /* renamed from: c, reason: collision with root package name */
    public int f699c;

    /* renamed from: d, reason: collision with root package name */
    public int f700d;

    /* renamed from: e, reason: collision with root package name */
    public int f701e;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(int i10, int i11, int i12, int i13, int i14) {
        this.f697a = i10;
        this.f698b = i11;
        this.f699c = i12;
        this.f700d = i13;
        this.f701e = i14;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f697a);
        parcel.writeInt(this.f699c);
        parcel.writeInt(this.f700d);
        parcel.writeInt(this.f701e);
        parcel.writeInt(this.f698b);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f697a = parcel.readInt();
        this.f699c = parcel.readInt();
        this.f700d = parcel.readInt();
        this.f701e = parcel.readInt();
        this.f698b = parcel.readInt();
    }
}
