package ca;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5803a;

    /* renamed from: b, reason: collision with root package name */
    public final s9.l f5804b;

    public t(Object obj, s9.l lVar) {
        this.f5803a = obj;
        this.f5804b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return t9.i.b(this.f5803a, tVar.f5803a) && t9.i.b(this.f5804b, tVar.f5804b);
    }

    public int hashCode() {
        Object obj = this.f5803a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f5804b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f5803a + ", onCancellation=" + this.f5804b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
