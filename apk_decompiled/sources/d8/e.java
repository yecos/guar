package d8;

import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f12729a;

    /* renamed from: b, reason: collision with root package name */
    public String f12730b;

    /* renamed from: c, reason: collision with root package name */
    public String f12731c;

    /* renamed from: d, reason: collision with root package name */
    public float f12732d;

    public e(int i10, String str, String str2, float f10) {
        i.h(str, "codec");
        i.h(str2, "lang");
        this.f12729a = i10;
        this.f12730b = str;
        this.f12731c = str2;
        this.f12732d = f10;
    }

    public final void a(String str) {
        i.h(str, "<set-?>");
        this.f12730b = str;
    }

    public final void b(int i10) {
        this.f12729a = i10;
    }

    public final void c(String str) {
        i.h(str, "<set-?>");
        this.f12731c = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (!(this.f12729a == eVar.f12729a) || !i.b(this.f12730b, eVar.f12730b) || !i.b(this.f12731c, eVar.f12731c) || Float.compare(this.f12732d, eVar.f12732d) != 0) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10 = this.f12729a * 31;
        String str = this.f12730b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12731c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f12732d);
    }

    public String toString() {
        return "SubTitleTrackInfo(id=" + this.f12729a + ", codec=" + this.f12730b + ", lang=" + this.f12731c + ", delay=" + this.f12732d + ")";
    }

    public /* synthetic */ e(int i10, String str, String str2, float f10, int i11, g gVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? 0.0f : f10);
    }
}
