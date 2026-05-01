package y9;

import i9.w;
import t9.g;

/* loaded from: classes3.dex */
public class a implements Iterable, u9.a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0347a f20097d = new C0347a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f20098a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20099b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20100c;

    /* renamed from: y9.a$a, reason: collision with other inner class name */
    public static final class C0347a {
        public C0347a() {
        }

        public /* synthetic */ C0347a(g gVar) {
            this();
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20098a = i10;
        this.f20099b = n9.c.b(i10, i11, i12);
        this.f20100c = i12;
    }

    public final int a() {
        return this.f20098a;
    }

    public final int b() {
        return this.f20099b;
    }

    public final int c() {
        return this.f20100c;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public w iterator() {
        return new b(this.f20098a, this.f20099b, this.f20100c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f20098a != aVar.f20098a || this.f20099b != aVar.f20099b || this.f20100c != aVar.f20100c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20098a * 31) + this.f20099b) * 31) + this.f20100c;
    }

    public boolean isEmpty() {
        if (this.f20100c > 0) {
            if (this.f20098a > this.f20099b) {
                return true;
            }
        } else if (this.f20098a < this.f20099b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i10;
        if (this.f20100c > 0) {
            sb = new StringBuilder();
            sb.append(this.f20098a);
            sb.append("..");
            sb.append(this.f20099b);
            sb.append(" step ");
            i10 = this.f20100c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20098a);
            sb.append(" downTo ");
            sb.append(this.f20099b);
            sb.append(" step ");
            i10 = -this.f20100c;
        }
        sb.append(i10);
        return sb.toString();
    }
}
