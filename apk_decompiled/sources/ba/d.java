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
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f5226c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f5224a = r1
                r0 = 0
                r6.f5227d = r0
                goto L9e
            Lc:
                ba.d r0 = ba.d.this
                int r0 = ba.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f5228e
                int r0 = r0 + r3
                r6.f5228e = r0
                ba.d r4 = ba.d.this
                int r4 = ba.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f5226c
                ba.d r4 = ba.d.this
                java.lang.CharSequence r4 = ba.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                y9.c r0 = new y9.c
                int r1 = r6.f5225b
                ba.d r4 = ba.d.this
                java.lang.CharSequence r4 = ba.d.b(r4)
                int r4 = ba.t.s(r4)
                r0.<init>(r1, r4)
                r6.f5227d = r0
                r6.f5226c = r2
                goto L9c
            L47:
                ba.d r0 = ba.d.this
                s9.p r0 = ba.d.a(r0)
                ba.d r4 = ba.d.this
                java.lang.CharSequence r4 = ba.d.b(r4)
                int r5 = r6.f5226c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                h9.k r0 = (h9.k) r0
                if (r0 != 0) goto L77
                y9.c r0 = new y9.c
                int r1 = r6.f5225b
                ba.d r4 = ba.d.this
                java.lang.CharSequence r4 = ba.d.b(r4)
                int r4 = ba.t.s(r4)
                r0.<init>(r1, r4)
                r6.f5227d = r0
                r6.f5226c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f5225b
                y9.c r4 = y9.e.f(r4, r2)
                r6.f5227d = r4
                int r2 = r2 + r0
                r6.f5225b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f5226c = r2
            L9c:
                r6.f5224a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ba.d.a.a():void");
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
