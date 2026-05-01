package ca;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5793a;

    /* renamed from: b, reason: collision with root package name */
    public final h f5794b;

    /* renamed from: c, reason: collision with root package name */
    public final s9.l f5795c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5796d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f5797e;

    public r(Object obj, h hVar, s9.l lVar, Object obj2, Throwable th) {
        this.f5793a = obj;
        this.f5794b = hVar;
        this.f5795c = lVar;
        this.f5796d = obj2;
        this.f5797e = th;
    }

    public static /* synthetic */ r b(r rVar, Object obj, h hVar, s9.l lVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = rVar.f5793a;
        }
        if ((i10 & 2) != 0) {
            hVar = rVar.f5794b;
        }
        h hVar2 = hVar;
        if ((i10 & 4) != 0) {
            lVar = rVar.f5795c;
        }
        s9.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = rVar.f5796d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = rVar.f5797e;
        }
        return rVar.a(obj, hVar2, lVar2, obj4, th);
    }

    public final r a(Object obj, h hVar, s9.l lVar, Object obj2, Throwable th) {
        return new r(obj, hVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f5797e != null;
    }

    public final void d(k kVar, Throwable th) {
        h hVar = this.f5794b;
        if (hVar != null) {
            kVar.i(hVar, th);
        }
        s9.l lVar = this.f5795c;
        if (lVar != null) {
            kVar.k(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return t9.i.b(this.f5793a, rVar.f5793a) && t9.i.b(this.f5794b, rVar.f5794b) && t9.i.b(this.f5795c, rVar.f5795c) && t9.i.b(this.f5796d, rVar.f5796d) && t9.i.b(this.f5797e, rVar.f5797e);
    }

    public int hashCode() {
        Object obj = this.f5793a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        h hVar = this.f5794b;
        int hashCode2 = (hashCode + (hVar == null ? 0 : hVar.hashCode())) * 31;
        s9.l lVar = this.f5795c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f5796d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f5797e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f5793a + ", cancelHandler=" + this.f5794b + ", onCancellation=" + this.f5795c + ", idempotentResume=" + this.f5796d + ", cancelCause=" + this.f5797e + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ r(Object obj, h hVar, s9.l lVar, Object obj2, Throwable th, int i10, t9.g gVar) {
        this(obj, (i10 & 2) != 0 ? null : hVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
