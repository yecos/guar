package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.y;
import androidx.lifecycle.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2176a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2177b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f2178c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f2179d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2180e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2181f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2182g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2183h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f2184i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2185j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f2186k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2187l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2188m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2189n;

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

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f2436c.size();
        this.f2176a = new int[size * 5];
        if (!aVar.f2442i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2177b = new ArrayList(size);
        this.f2178c = new int[size];
        this.f2179d = new int[size];
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            y.a aVar2 = (y.a) aVar.f2436c.get(i10);
            int i12 = i11 + 1;
            this.f2176a[i11] = aVar2.f2453a;
            ArrayList arrayList = this.f2177b;
            Fragment fragment = aVar2.f2454b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f2176a;
            int i13 = i12 + 1;
            iArr[i12] = aVar2.f2455c;
            int i14 = i13 + 1;
            iArr[i13] = aVar2.f2456d;
            int i15 = i14 + 1;
            iArr[i14] = aVar2.f2457e;
            iArr[i15] = aVar2.f2458f;
            this.f2178c[i10] = aVar2.f2459g.ordinal();
            this.f2179d[i10] = aVar2.f2460h.ordinal();
            i10++;
            i11 = i15 + 1;
        }
        this.f2180e = aVar.f2441h;
        this.f2181f = aVar.f2444k;
        this.f2182g = aVar.f2175v;
        this.f2183h = aVar.f2445l;
        this.f2184i = aVar.f2446m;
        this.f2185j = aVar.f2447n;
        this.f2186k = aVar.f2448o;
        this.f2187l = aVar.f2449p;
        this.f2188m = aVar.f2450q;
        this.f2189n = aVar.f2451r;
    }

    public androidx.fragment.app.a a(o oVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(oVar);
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.f2176a.length) {
            y.a aVar2 = new y.a();
            int i12 = i10 + 1;
            aVar2.f2453a = this.f2176a[i10];
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(aVar);
                sb.append(" op #");
                sb.append(i11);
                sb.append(" base fragment #");
                sb.append(this.f2176a[i12]);
            }
            String str = (String) this.f2177b.get(i11);
            if (str != null) {
                aVar2.f2454b = oVar.f0(str);
            } else {
                aVar2.f2454b = null;
            }
            aVar2.f2459g = d.c.values()[this.f2178c[i11]];
            aVar2.f2460h = d.c.values()[this.f2179d[i11]];
            int[] iArr = this.f2176a;
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            aVar2.f2455c = i14;
            int i15 = i13 + 1;
            int i16 = iArr[i13];
            aVar2.f2456d = i16;
            int i17 = i15 + 1;
            int i18 = iArr[i15];
            aVar2.f2457e = i18;
            int i19 = iArr[i17];
            aVar2.f2458f = i19;
            aVar.f2437d = i14;
            aVar.f2438e = i16;
            aVar.f2439f = i18;
            aVar.f2440g = i19;
            aVar.f(aVar2);
            i11++;
            i10 = i17 + 1;
        }
        aVar.f2441h = this.f2180e;
        aVar.f2444k = this.f2181f;
        aVar.f2175v = this.f2182g;
        aVar.f2442i = true;
        aVar.f2445l = this.f2183h;
        aVar.f2446m = this.f2184i;
        aVar.f2447n = this.f2185j;
        aVar.f2448o = this.f2186k;
        aVar.f2449p = this.f2187l;
        aVar.f2450q = this.f2188m;
        aVar.f2451r = this.f2189n;
        aVar.v(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f2176a);
        parcel.writeStringList(this.f2177b);
        parcel.writeIntArray(this.f2178c);
        parcel.writeIntArray(this.f2179d);
        parcel.writeInt(this.f2180e);
        parcel.writeString(this.f2181f);
        parcel.writeInt(this.f2182g);
        parcel.writeInt(this.f2183h);
        TextUtils.writeToParcel(this.f2184i, parcel, 0);
        parcel.writeInt(this.f2185j);
        TextUtils.writeToParcel(this.f2186k, parcel, 0);
        parcel.writeStringList(this.f2187l);
        parcel.writeStringList(this.f2188m);
        parcel.writeInt(this.f2189n ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f2176a = parcel.createIntArray();
        this.f2177b = parcel.createStringArrayList();
        this.f2178c = parcel.createIntArray();
        this.f2179d = parcel.createIntArray();
        this.f2180e = parcel.readInt();
        this.f2181f = parcel.readString();
        this.f2182g = parcel.readInt();
        this.f2183h = parcel.readInt();
        this.f2184i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2185j = parcel.readInt();
        this.f2186k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2187l = parcel.createStringArrayList();
        this.f2188m = parcel.createStringArrayList();
        this.f2189n = parcel.readInt() != 0;
    }
}
