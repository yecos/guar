package d8;

import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f12695a;

    /* renamed from: b, reason: collision with root package name */
    public String f12696b;

    /* renamed from: c, reason: collision with root package name */
    public String f12697c;

    /* renamed from: d, reason: collision with root package name */
    public String f12698d;

    /* renamed from: e, reason: collision with root package name */
    public float f12699e;

    /* renamed from: f, reason: collision with root package name */
    public long f12700f;

    /* renamed from: g, reason: collision with root package name */
    public long f12701g;

    public a(int i10, String str, String str2, String str3, float f10, long j10, long j11) {
        i.h(str, "codec");
        i.h(str2, "decoder");
        i.h(str3, "lang");
        this.f12695a = i10;
        this.f12696b = str;
        this.f12697c = str2;
        this.f12698d = str3;
        this.f12699e = f10;
        this.f12700f = j10;
        this.f12701g = j11;
    }

    public final int a() {
        return this.f12695a;
    }

    public final void b(long j10) {
        this.f12701g = j10;
    }

    public final void c(long j10) {
        this.f12700f = j10;
    }

    public final void d(String str) {
        i.h(str, "<set-?>");
        this.f12696b = str;
    }

    public final void e(String str) {
        i.h(str, "<set-?>");
        this.f12697c = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if ((this.f12695a == aVar.f12695a) && i.b(this.f12696b, aVar.f12696b) && i.b(this.f12697c, aVar.f12697c) && i.b(this.f12698d, aVar.f12698d) && Float.compare(this.f12699e, aVar.f12699e) == 0) {
                    if (this.f12700f == aVar.f12700f) {
                        if (this.f12701g == aVar.f12701g) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void f(float f10) {
        this.f12699e = f10;
    }

    public final void g(int i10) {
        this.f12695a = i10;
    }

    public final void h(String str) {
        i.h(str, "<set-?>");
        this.f12698d = str;
    }

    public int hashCode() {
        int i10 = this.f12695a * 31;
        String str = this.f12696b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12697c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12698d;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f12699e)) * 31;
        long j10 = this.f12700f;
        int i11 = (hashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f12701g;
        return i11 + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "AudioTrackInfo(id=" + this.f12695a + ", codec=" + this.f12696b + ", decoder=" + this.f12697c + ", lang=" + this.f12698d + ", delay=" + this.f12699e + ", bufferTime=" + this.f12700f + ", bufferLength=" + this.f12701g + ")";
    }

    public /* synthetic */ a(int i10, String str, String str2, String str3, float f10, long j10, long j11, int i11, g gVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? "" : str2, (i11 & 8) == 0 ? str3 : "", (i11 & 16) != 0 ? 0.0f : f10, (i11 & 32) != 0 ? 0L : j10, (i11 & 64) == 0 ? j11 : 0L);
    }
}
