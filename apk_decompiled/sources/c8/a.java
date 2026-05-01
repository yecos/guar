package c8;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5626a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5627b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5628c;

    public a(String str, boolean z10, boolean z11) {
        this.f5626a = str;
        this.f5627b = z10;
        this.f5628c = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f5627b == aVar.f5627b && this.f5628c == aVar.f5628c) {
            return this.f5626a.equals(aVar.f5626a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5626a.hashCode() * 31) + (this.f5627b ? 1 : 0)) * 31) + (this.f5628c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f5626a + "', granted=" + this.f5627b + ", shouldShowRequestPermissionRationale=" + this.f5628c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
