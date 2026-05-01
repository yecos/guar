package d8;

import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f12733a;

    /* renamed from: b, reason: collision with root package name */
    public String f12734b;

    /* renamed from: c, reason: collision with root package name */
    public String f12735c;

    /* renamed from: d, reason: collision with root package name */
    public float f12736d;

    /* renamed from: e, reason: collision with root package name */
    public long f12737e;

    /* renamed from: f, reason: collision with root package name */
    public long f12738f;

    public f(int i10, String str, String str2, float f10, long j10, long j11) {
        i.h(str, "codec");
        i.h(str2, "decoder");
        this.f12733a = i10;
        this.f12734b = str;
        this.f12735c = str2;
        this.f12736d = f10;
        this.f12737e = j10;
        this.f12738f = j11;
    }

    public final String a() {
        return this.f12735c;
    }

    public final void b(long j10) {
        this.f12738f = j10;
    }

    public final void c(long j10) {
        this.f12737e = j10;
    }

    public final void d(String str) {
        i.h(str, "<set-?>");
        this.f12734b = str;
    }

    public final void e(String str) {
        i.h(str, "<set-?>");
        this.f12735c = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if ((this.f12733a == fVar.f12733a) && i.b(this.f12734b, fVar.f12734b) && i.b(this.f12735c, fVar.f12735c) && Float.compare(this.f12736d, fVar.f12736d) == 0) {
                    if (this.f12737e == fVar.f12737e) {
                        if (this.f12738f == fVar.f12738f) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void f(float f10) {
        this.f12736d = f10;
    }

    public final void g(int i10) {
        this.f12733a = i10;
    }

    public int hashCode() {
        int i10 = this.f12733a * 31;
        String str = this.f12734b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12735c;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f12736d)) * 31;
        long j10 = this.f12737e;
        int i11 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f12738f;
        return i11 + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "VideoTrackInfo(id=" + this.f12733a + ", codec=" + this.f12734b + ", decoder=" + this.f12735c + ", frame_rate=" + this.f12736d + ", buffer_time=" + this.f12737e + ", buffer_length=" + this.f12738f + ")";
    }

    public /* synthetic */ f(int i10, String str, String str2, float f10, long j10, long j11, int i11, g gVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) == 0 ? str2 : "", (i11 & 8) != 0 ? 0.0f : f10, (i11 & 16) != 0 ? 0L : j10, (i11 & 32) == 0 ? j11 : 0L);
    }
}
