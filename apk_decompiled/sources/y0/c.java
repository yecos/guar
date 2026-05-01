package y0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f19712d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f19713e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19714f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19715g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19716h;

    /* renamed from: i, reason: collision with root package name */
    public int f19717i;

    /* renamed from: j, reason: collision with root package name */
    public int f19718j;

    /* renamed from: k, reason: collision with root package name */
    public int f19719k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // y0.b
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f19713e.writeInt(-1);
        } else {
            this.f19713e.writeInt(bArr.length);
            this.f19713e.writeByteArray(bArr);
        }
    }

    @Override // y0.b
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f19713e, 0);
    }

    @Override // y0.b
    public void E(int i10) {
        this.f19713e.writeInt(i10);
    }

    @Override // y0.b
    public void G(Parcelable parcelable) {
        this.f19713e.writeParcelable(parcelable, 0);
    }

    @Override // y0.b
    public void I(String str) {
        this.f19713e.writeString(str);
    }

    @Override // y0.b
    public void a() {
        int i10 = this.f19717i;
        if (i10 >= 0) {
            int i11 = this.f19712d.get(i10);
            int dataPosition = this.f19713e.dataPosition();
            this.f19713e.setDataPosition(i11);
            this.f19713e.writeInt(dataPosition - i11);
            this.f19713e.setDataPosition(dataPosition);
        }
    }

    @Override // y0.b
    public b b() {
        Parcel parcel = this.f19713e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f19718j;
        if (i10 == this.f19714f) {
            i10 = this.f19715g;
        }
        return new c(parcel, dataPosition, i10, this.f19716h + "  ", this.f19709a, this.f19710b, this.f19711c);
    }

    @Override // y0.b
    public boolean g() {
        return this.f19713e.readInt() != 0;
    }

    @Override // y0.b
    public byte[] i() {
        int readInt = this.f19713e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f19713e.readByteArray(bArr);
        return bArr;
    }

    @Override // y0.b
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f19713e);
    }

    @Override // y0.b
    public boolean m(int i10) {
        while (this.f19718j < this.f19715g) {
            int i11 = this.f19719k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f19713e.setDataPosition(this.f19718j);
            int readInt = this.f19713e.readInt();
            this.f19719k = this.f19713e.readInt();
            this.f19718j += readInt;
        }
        return this.f19719k == i10;
    }

    @Override // y0.b
    public int o() {
        return this.f19713e.readInt();
    }

    @Override // y0.b
    public Parcelable q() {
        return this.f19713e.readParcelable(getClass().getClassLoader());
    }

    @Override // y0.b
    public String s() {
        return this.f19713e.readString();
    }

    @Override // y0.b
    public void w(int i10) {
        a();
        this.f19717i = i10;
        this.f19712d.put(i10, this.f19713e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // y0.b
    public void y(boolean z10) {
        this.f19713e.writeInt(z10 ? 1 : 0);
    }

    public c(Parcel parcel, int i10, int i11, String str, androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f19712d = new SparseIntArray();
        this.f19717i = -1;
        this.f19719k = -1;
        this.f19713e = parcel;
        this.f19714f = i10;
        this.f19715g = i11;
        this.f19718j = i10;
        this.f19716h = str;
    }
}
