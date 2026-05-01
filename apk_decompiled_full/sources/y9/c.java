package y9;

import t9.g;

/* loaded from: classes3.dex */
public final class c extends y9.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20105e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final c f20106f = new c(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f20106f;
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // y9.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i10) {
        return a() <= i10 && i10 <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // y9.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // y9.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // y9.a
    public String toString() {
        return a() + ".." + b();
    }
}
