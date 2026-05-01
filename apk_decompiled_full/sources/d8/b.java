package d8;

import com.umeng.analytics.pro.bt;
import t9.g;
import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f12702a;

    /* renamed from: b, reason: collision with root package name */
    public String f12703b;

    /* renamed from: c, reason: collision with root package name */
    public String f12704c;

    /* renamed from: d, reason: collision with root package name */
    public String f12705d;

    /* renamed from: e, reason: collision with root package name */
    public String f12706e;

    /* renamed from: f, reason: collision with root package name */
    public String f12707f;

    /* renamed from: g, reason: collision with root package name */
    public String f12708g;

    /* renamed from: h, reason: collision with root package name */
    public String f12709h;

    /* renamed from: i, reason: collision with root package name */
    public String f12710i;

    /* renamed from: j, reason: collision with root package name */
    public String f12711j;

    public b(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.h(str, "type");
        i.h(str2, "codec");
        i.h(str3, "frame_rate");
        i.h(str4, "pixel_format");
        i.h(str5, bt.f10065z);
        i.h(str6, "lang");
        i.h(str7, IjkMediaMeta.IJKM_KEY_CHANNELS);
        i.h(str8, IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
        i.h(str9, "bit_depth");
        this.f12702a = i10;
        this.f12703b = str;
        this.f12704c = str2;
        this.f12705d = str3;
        this.f12706e = str4;
        this.f12707f = str5;
        this.f12708g = str6;
        this.f12709h = str7;
        this.f12710i = str8;
        this.f12711j = str9;
    }

    public final String a() {
        return this.f12704c;
    }

    public final int b() {
        return this.f12702a;
    }

    public final String c() {
        return this.f12708g;
    }

    public final String d() {
        return this.f12703b;
    }

    public final void e(String str) {
        i.h(str, "<set-?>");
        this.f12709h = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!(this.f12702a == bVar.f12702a) || !i.b(this.f12703b, bVar.f12703b) || !i.b(this.f12704c, bVar.f12704c) || !i.b(this.f12705d, bVar.f12705d) || !i.b(this.f12706e, bVar.f12706e) || !i.b(this.f12707f, bVar.f12707f) || !i.b(this.f12708g, bVar.f12708g) || !i.b(this.f12709h, bVar.f12709h) || !i.b(this.f12710i, bVar.f12710i) || !i.b(this.f12711j, bVar.f12711j)) {
                }
            }
            return false;
        }
        return true;
    }

    public final void f(String str) {
        i.h(str, "<set-?>");
        this.f12704c = str;
    }

    public final void g(String str) {
        i.h(str, "<set-?>");
        this.f12705d = str;
    }

    public final void h(int i10) {
        this.f12702a = i10;
    }

    public int hashCode() {
        int i10 = this.f12702a * 31;
        String str = this.f12703b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12704c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12705d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f12706e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f12707f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f12708g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f12709h;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f12710i;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f12711j;
        return hashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public final void i(String str) {
        i.h(str, "<set-?>");
        this.f12708g = str;
    }

    public final void j(String str) {
        i.h(str, "<set-?>");
        this.f12706e = str;
    }

    public final void k(String str) {
        i.h(str, "<set-?>");
        this.f12707f = str;
    }

    public final void l(String str) {
        i.h(str, "<set-?>");
        this.f12710i = str;
    }

    public final void m(String str) {
        i.h(str, "<set-?>");
        this.f12703b = str;
    }

    public String toString() {
        return "MultiTrackInfo(id=" + this.f12702a + ", type=" + this.f12703b + ", codec=" + this.f12704c + ", frame_rate=" + this.f12705d + ", pixel_format=" + this.f12706e + ", resolution=" + this.f12707f + ", lang=" + this.f12708g + ", channels=" + this.f12709h + ", sample_rate=" + this.f12710i + ", bit_depth=" + this.f12711j + ")";
    }

    public /* synthetic */ b(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, g gVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? "" : str3, (i11 & 16) != 0 ? "" : str4, (i11 & 32) != 0 ? "" : str5, (i11 & 64) != 0 ? "" : str6, (i11 & 128) != 0 ? "" : str7, (i11 & 256) != 0 ? "" : str8, (i11 & 512) == 0 ? str9 : "");
    }
}
