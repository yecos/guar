package ba;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5230a;

    /* renamed from: b, reason: collision with root package name */
    public final y9.c f5231b;

    public e(String str, y9.c cVar) {
        t9.i.g(str, "value");
        t9.i.g(cVar, "range");
        this.f5230a = str;
        this.f5231b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return t9.i.b(this.f5230a, eVar.f5230a) && t9.i.b(this.f5231b, eVar.f5231b);
    }

    public int hashCode() {
        return (this.f5230a.hashCode() * 31) + this.f5231b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f5230a + ", range=" + this.f5231b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
