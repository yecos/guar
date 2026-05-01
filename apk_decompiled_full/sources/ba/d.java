package ba;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class d implements aa.b {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f5220a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5221b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5222c;

    /* renamed from: d, reason: collision with root package name */
    public final s9.p f5223d;

    public static final class a implements Iterator, u9.a {

        /* renamed from: a, reason: collision with root package name */
        public int f5224a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f5225b;

        /* renamed from: c, reason: collision with root package name */
        public int f5226c;

        /* renamed from: d, reason: collision with root package name */
        public y9.c f5227d;

        /* renamed from: e, reason: collision with root package name */
        public int f5228e;

        public a() {
            int d10 = y9.e.d(d.this.f5221b, 0, d.this.f5220a.length());
            this.f5225b = d10;
            this.f5226c = d10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f5229f.f5222c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            if (this.f5226c < 0) {
                this.f5224a = 0;
                this.f5227d = null;
                return;
            }
            if (d.this.f5222c > 0) {
                int i10 = this.f5228e + 1;
                this.f5228e = i10;
            }
            if (this.f5226c <= d.this.f5220a.length()) {
                h9.k kVar = (h9.k) d.this.f5223d.invoke(d.this.f5220a, Integer.valueOf(this.f5226c));
                if (kVar == null) {
                    this.f5227d = new y9.c(this.f5225b, t.s(d.this.f5220a));
                    this.f5226c = -1;
                } else {
                    int intValue = ((Number) kVar.a()).intValue();
                    int intValue2 = ((Number) kVar.b()).intValue();
                    this.f5227d = y9.e.f(this.f5225b, intValue);
                    int i11 = intValue + intValue2;
                    this.f5225b = i11;
                    this.f5226c = i11 + (intValue2 == 0 ? 1 : 0);
                }
                this.f5224a = 1;
            }
            this.f5227d = new y9.c(this.f5225b, t.s(d.this.f5220a));
            this.f5226c = -1;
            this.f5224a = 1;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y9.c next() {
            if (this.f5224a == -1) {
                a();
            }
            if (this.f5224a == 0) {
                throw new NoSuchElementException();
            }
            y9.c cVar = this.f5227d;
            t9.i.e(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f5227d = null;
            this.f5224a = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5224a == -1) {
                a();
            }
            return this.f5224a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence charSequence, int i10, int i11, s9.p pVar) {
        t9.i.g(charSequence, "input");
        t9.i.g(pVar, "getNextMatch");
        this.f5220a = charSequence;
        this.f5221b = i10;
        this.f5222c = i11;
        this.f5223d = pVar;
    }

    @Override // aa.b
    public Iterator iterator() {
        return new a();
    }
}
