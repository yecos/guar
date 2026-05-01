package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class u implements Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f2403a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2404b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2405c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2406d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2407e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2408f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2409g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2410h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2411i;

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f2412j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f2413k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2414l;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f2415m;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public u createFromParcel(Parcel parcel) {
            return new u(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u[] newArray(int i10) {
            return new u[i10];
        }
    }

    public u(Fragment fragment) {
        this.f2403a = fragment.getClass().getName();
        this.f2404b = fragment.mWho;
        this.f2405c = fragment.mFromLayout;
        this.f2406d = fragment.mFragmentId;
        this.f2407e = fragment.mContainerId;
        this.f2408f = fragment.mTag;
        this.f2409g = fragment.mRetainInstance;
        this.f2410h = fragment.mRemoving;
        this.f2411i = fragment.mDetached;
        this.f2412j = fragment.mArguments;
        this.f2413k = fragment.mHidden;
        this.f2414l = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2403a);
        sb.append(" (");
        sb.append(this.f2404b);
        sb.append(")}:");
        if (this.f2405c) {
            sb.append(" fromLayout");
        }
        if (this.f2407e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2407e));
        }
        String str = this.f2408f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2408f);
        }
        if (this.f2409g) {
            sb.append(" retainInstance");
        }
        if (this.f2410h) {
            sb.append(" removing");
        }
        if (this.f2411i) {
            sb.append(" detached");
        }
        if (this.f2413k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2403a);
        parcel.writeString(this.f2404b);
        parcel.writeInt(this.f2405c ? 1 : 0);
        parcel.writeInt(this.f2406d);
        parcel.writeInt(this.f2407e);
        parcel.writeString(this.f2408f);
        parcel.writeInt(this.f2409g ? 1 : 0);
        parcel.writeInt(this.f2410h ? 1 : 0);
        parcel.writeInt(this.f2411i ? 1 : 0);
        parcel.writeBundle(this.f2412j);
        parcel.writeInt(this.f2413k ? 1 : 0);
        parcel.writeBundle(this.f2415m);
        parcel.writeInt(this.f2414l);
    }

    public u(Parcel parcel) {
        this.f2403a = parcel.readString();
        this.f2404b = parcel.readString();
        this.f2405c = parcel.readInt() != 0;
        this.f2406d = parcel.readInt();
        this.f2407e = parcel.readInt();
        this.f2408f = parcel.readString();
        this.f2409g = parcel.readInt() != 0;
        this.f2410h = parcel.readInt() != 0;
        this.f2411i = parcel.readInt() != 0;
        this.f2412j = parcel.readBundle();
        this.f2413k = parcel.readInt() != 0;
        this.f2415m = parcel.readBundle();
        this.f2414l = parcel.readInt();
    }
}
