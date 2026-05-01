package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f795a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f796b;

    /* renamed from: c, reason: collision with root package name */
    public final int f797c;

    /* renamed from: d, reason: collision with root package name */
    public final int f798d;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public IntentSender f799a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f800b;

        /* renamed from: c, reason: collision with root package name */
        public int f801c;

        /* renamed from: d, reason: collision with root package name */
        public int f802d;

        public b(IntentSender intentSender) {
            this.f799a = intentSender;
        }

        public e a() {
            return new e(this.f799a, this.f800b, this.f801c, this.f802d);
        }

        public b b(Intent intent) {
            this.f800b = intent;
            return this;
        }

        public b c(int i10, int i11) {
            this.f802d = i10;
            this.f801c = i11;
            return this;
        }
    }

    public e(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f795a = intentSender;
        this.f796b = intent;
        this.f797c = i10;
        this.f798d = i11;
    }

    public Intent a() {
        return this.f796b;
    }

    public int b() {
        return this.f797c;
    }

    public int c() {
        return this.f798d;
    }

    public IntentSender d() {
        return this.f795a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f795a, i10);
        parcel.writeParcelable(this.f796b, i10);
        parcel.writeInt(this.f797c);
        parcel.writeInt(this.f798d);
    }

    public e(Parcel parcel) {
        this.f795a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f796b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f797c = parcel.readInt();
        this.f798d = parcel.readInt();
    }
}
