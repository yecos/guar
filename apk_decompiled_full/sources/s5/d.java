package s5;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.db.SwitchAccountBean;
import t9.i;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18756a;

    /* renamed from: b, reason: collision with root package name */
    public c f18757b;

    /* renamed from: c, reason: collision with root package name */
    public String f18758c;

    /* renamed from: d, reason: collision with root package name */
    public SwitchAccountBean f18759d;

    /* renamed from: e, reason: collision with root package name */
    public String f18760e;

    /* renamed from: f, reason: collision with root package name */
    public String f18761f;

    /* renamed from: g, reason: collision with root package name */
    public x7.a f18762g;

    /* renamed from: h, reason: collision with root package name */
    public String f18763h;

    /* renamed from: i, reason: collision with root package name */
    public String f18764i;

    /* renamed from: j, reason: collision with root package name */
    public String f18765j;

    public d(boolean z10, c cVar, String str, SwitchAccountBean switchAccountBean, String str2, String str3, x7.a aVar, String str4, String str5, String str6) {
        i.g(str, "sQrToken");
        i.g(str3, "sThirdPartType");
        i.g(str4, "sCreateType");
        i.g(str5, "sTpSource");
        this.f18756a = z10;
        this.f18757b = cVar;
        this.f18758c = str;
        this.f18759d = switchAccountBean;
        this.f18760e = str2;
        this.f18761f = str3;
        this.f18762g = aVar;
        this.f18763h = str4;
        this.f18764i = str5;
        this.f18765j = str6;
    }

    public final String a() {
        return this.f18763h;
    }

    public final c b() {
        return this.f18757b;
    }

    public final boolean c() {
        return this.f18756a;
    }

    public final String d() {
        return this.f18758c;
    }

    public final x7.a e() {
        return this.f18762g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f18756a == dVar.f18756a && this.f18757b == dVar.f18757b && i.b(this.f18758c, dVar.f18758c) && i.b(this.f18759d, dVar.f18759d) && i.b(this.f18760e, dVar.f18760e) && i.b(this.f18761f, dVar.f18761f) && i.b(this.f18762g, dVar.f18762g) && i.b(this.f18763h, dVar.f18763h) && i.b(this.f18764i, dVar.f18764i) && i.b(this.f18765j, dVar.f18765j);
    }

    public final SwitchAccountBean f() {
        return this.f18759d;
    }

    public final String g() {
        return this.f18761f;
    }

    public final String h() {
        return this.f18765j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean z10 = this.f18756a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        c cVar = this.f18757b;
        int hashCode = (((i10 + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f18758c.hashCode()) * 31;
        SwitchAccountBean switchAccountBean = this.f18759d;
        int hashCode2 = (hashCode + (switchAccountBean == null ? 0 : switchAccountBean.hashCode())) * 31;
        String str = this.f18760e;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.f18761f.hashCode()) * 31;
        x7.a aVar = this.f18762g;
        int hashCode4 = (((((hashCode3 + (aVar == null ? 0 : aVar.hashCode())) * 31) + this.f18763h.hashCode()) * 31) + this.f18764i.hashCode()) * 31;
        String str2 = this.f18765j;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String i() {
        return this.f18764i;
    }

    public final String j() {
        return this.f18760e;
    }

    public final void k(boolean z10) {
        this.f18756a = z10;
    }

    public final void l(String str) {
        this.f18765j = str;
    }

    public String toString() {
        return "TmpLoginBean(sNeedLogOut=" + this.f18756a + ", sLoginType=" + this.f18757b + ", sQrToken=" + this.f18758c + ", sSwitchAccountBean=" + this.f18759d + ", sVerificationCode=" + this.f18760e + ", sThirdPartType=" + this.f18761f + ", sSocialInfo=" + this.f18762g + ", sCreateType=" + this.f18763h + ", sTpSource=" + this.f18764i + ", sTpPassword=" + this.f18765j + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
