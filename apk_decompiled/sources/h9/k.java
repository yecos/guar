package h9;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class k implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14229a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14230b;

    public k(Object obj, Object obj2) {
        this.f14229a = obj;
        this.f14230b = obj2;
    }

    public final Object a() {
        return this.f14229a;
    }

    public final Object b() {
        return this.f14230b;
    }

    public final Object c() {
        return this.f14229a;
    }

    public final Object d() {
        return this.f14230b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return t9.i.b(this.f14229a, kVar.f14229a) && t9.i.b(this.f14230b, kVar.f14230b);
    }

    public int hashCode() {
        Object obj = this.f14229a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f14230b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + this.f14229a + ", " + this.f14230b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
