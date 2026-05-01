package d8;

import java.util.ArrayList;
import java.util.List;
import t9.g;
import t9.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f12712a;

    /* renamed from: b, reason: collision with root package name */
    public String f12713b;

    /* renamed from: c, reason: collision with root package name */
    public String f12714c;

    /* renamed from: d, reason: collision with root package name */
    public String f12715d;

    /* renamed from: e, reason: collision with root package name */
    public String f12716e;

    /* renamed from: f, reason: collision with root package name */
    public String f12717f;

    /* renamed from: g, reason: collision with root package name */
    public List f12718g;

    /* renamed from: h, reason: collision with root package name */
    public long f12719h;

    /* renamed from: i, reason: collision with root package name */
    public String f12720i;

    /* renamed from: j, reason: collision with root package name */
    public String f12721j;

    /* renamed from: k, reason: collision with root package name */
    public f f12722k;

    /* renamed from: l, reason: collision with root package name */
    public a f12723l;

    /* renamed from: m, reason: collision with root package name */
    public e f12724m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12725n;

    public c(long j10, String str, String str2, String str3, String str4, String str5, List list, long j11, String str6, String str7, f fVar, a aVar, e eVar, ArrayList arrayList) {
        i.h(str, "program");
        i.h(str2, "title");
        i.h(str3, "buss");
        i.h(str4, "media");
        i.h(str5, "play_url");
        i.h(str6, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.h(str7, "player");
        this.f12712a = j10;
        this.f12713b = str;
        this.f12714c = str2;
        this.f12715d = str3;
        this.f12716e = str4;
        this.f12717f = str5;
        this.f12718g = list;
        this.f12719h = j11;
        this.f12720i = str6;
        this.f12721j = str7;
        this.f12722k = fVar;
        this.f12723l = aVar;
        this.f12724m = eVar;
        this.f12725n = arrayList;
    }

    public final a a() {
        return this.f12723l;
    }

    public final String b() {
        return this.f12715d;
    }

    public final long c() {
        return this.f12712a;
    }

    public final String d() {
        return this.f12716e;
    }

    public final String e() {
        return this.f12717f;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if ((this.f12712a == cVar.f12712a) && i.b(this.f12713b, cVar.f12713b) && i.b(this.f12714c, cVar.f12714c) && i.b(this.f12715d, cVar.f12715d) && i.b(this.f12716e, cVar.f12716e) && i.b(this.f12717f, cVar.f12717f) && i.b(this.f12718g, cVar.f12718g)) {
                    if (!(this.f12719h == cVar.f12719h) || !i.b(this.f12720i, cVar.f12720i) || !i.b(this.f12721j, cVar.f12721j) || !i.b(this.f12722k, cVar.f12722k) || !i.b(this.f12723l, cVar.f12723l) || !i.b(this.f12724m, cVar.f12724m) || !i.b(this.f12725n, cVar.f12725n)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final ArrayList f() {
        return this.f12725n;
    }

    public final f g() {
        return this.f12722k;
    }

    public final void h(a aVar) {
        this.f12723l = aVar;
    }

    public int hashCode() {
        long j10 = this.f12712a;
        int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
        String str = this.f12713b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12714c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f12715d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f12716e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f12717f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List list = this.f12718g;
        int hashCode6 = list != null ? list.hashCode() : 0;
        long j11 = this.f12719h;
        int i11 = (((hashCode5 + hashCode6) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        String str6 = this.f12720i;
        int hashCode7 = (i11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f12721j;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        f fVar = this.f12722k;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        a aVar = this.f12723l;
        int hashCode10 = (hashCode9 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        e eVar = this.f12724m;
        int hashCode11 = (hashCode10 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        ArrayList arrayList = this.f12725n;
        return hashCode11 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void i(String str) {
        i.h(str, "<set-?>");
        this.f12715d = str;
    }

    public final void j(long j10) {
        this.f12712a = j10;
    }

    public final void k(String str) {
        i.h(str, "<set-?>");
        this.f12720i = str;
    }

    public final void l(long j10) {
        this.f12719h = j10;
    }

    public final void m(List list) {
        this.f12718g = list;
    }

    public final void n(String str) {
        i.h(str, "<set-?>");
        this.f12716e = str;
    }

    public final void o(String str) {
        i.h(str, "<set-?>");
        this.f12717f = str;
    }

    public final void p(String str) {
        i.h(str, "<set-?>");
        this.f12721j = str;
    }

    public final void q(String str) {
        i.h(str, "<set-?>");
        this.f12713b = str;
    }

    public final void r(e eVar) {
        this.f12724m = eVar;
    }

    public final void s(String str) {
        i.h(str, "<set-?>");
        this.f12714c = str;
    }

    public final void t(ArrayList arrayList) {
        this.f12725n = arrayList;
    }

    public String toString() {
        return "PlayStatus(duration=" + this.f12712a + ", program=" + this.f12713b + ", title=" + this.f12714c + ", buss=" + this.f12715d + ", media=" + this.f12716e + ", play_url=" + this.f12717f + ", links=" + this.f12718g + ", latency=" + this.f12719h + ", format=" + this.f12720i + ", player=" + this.f12721j + ", video=" + this.f12722k + ", audio=" + this.f12723l + ", subtitle=" + this.f12724m + ", tracks=" + this.f12725n + ")";
    }

    public final void u(f fVar) {
        this.f12722k = fVar;
    }

    public /* synthetic */ c(long j10, String str, String str2, String str3, String str4, String str5, List list, long j11, String str6, String str7, f fVar, a aVar, e eVar, ArrayList arrayList, int i10, g gVar) {
        this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? "" : str3, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? "" : str5, (i10 & 64) != 0 ? null : list, (i10 & 128) != 0 ? -1L : j11, (i10 & 256) != 0 ? "" : str6, (i10 & 512) == 0 ? str7 : "", (i10 & 1024) != 0 ? null : fVar, (i10 & 2048) != 0 ? null : aVar, (i10 & 4096) != 0 ? null : eVar, (i10 & 8192) != 0 ? null : arrayList);
    }
}
