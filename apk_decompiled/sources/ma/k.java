package ma;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f16861a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16862b;

    public k(String str, String str2) {
        this.f16861a = str;
        this.f16862b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return t9.i.b(this.f16861a, kVar.f16861a) && t9.i.b(this.f16862b, kVar.f16862b);
    }

    public int hashCode() {
        String str = this.f16861a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f16862b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LoginNumberLimitEvent(token=" + this.f16861a + ", userId=" + this.f16862b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
