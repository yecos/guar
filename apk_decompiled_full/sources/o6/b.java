package o6;

import t9.i;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f17599a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17600b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17601c;

    public b(String str, String str2, boolean z10) {
        i.g(str, "displayQuality");
        i.g(str2, "qualityValue");
        this.f17599a = str;
        this.f17600b = str2;
        this.f17601c = z10;
    }

    public final String a() {
        return this.f17599a;
    }

    public final int b() {
        String str = this.f17599a;
        int hashCode = str.hashCode();
        if (hashCode != 1604516) {
            return hashCode != 1688123 ? (hashCode == 46737881 && str.equals("1080P")) ? 3 : 1 : !str.equals("720P") ? 1 : 2;
        }
        str.equals("480P");
        return 1;
    }

    public final String c() {
        return this.f17600b;
    }

    public final boolean d() {
        return this.f17601c;
    }
}
