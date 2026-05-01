package c3;

import c3.h;
import c3.k;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes.dex */
public class f extends t {

    /* renamed from: j, reason: collision with root package name */
    public static final int f5411j = a.c();

    /* renamed from: k, reason: collision with root package name */
    public static final int f5412k = k.a.a();

    /* renamed from: l, reason: collision with root package name */
    public static final int f5413l = h.b.a();

    /* renamed from: m, reason: collision with root package name */
    public static final q f5414m = j3.e.f14648h;

    /* renamed from: a, reason: collision with root package name */
    public final transient h3.c f5415a;

    /* renamed from: b, reason: collision with root package name */
    public final transient h3.a f5416b;

    /* renamed from: c, reason: collision with root package name */
    public int f5417c;

    /* renamed from: d, reason: collision with root package name */
    public int f5418d;

    /* renamed from: e, reason: collision with root package name */
    public int f5419e;

    /* renamed from: f, reason: collision with root package name */
    public o f5420f;

    /* renamed from: g, reason: collision with root package name */
    public q f5421g;

    /* renamed from: h, reason: collision with root package name */
    public int f5422h;

    /* renamed from: i, reason: collision with root package name */
    public final char f5423i;

    public enum a implements j3.h {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f5429a;

        a(boolean z10) {
            this.f5429a = z10;
        }

        public static int c() {
            int i10 = 0;
            for (a aVar : values()) {
                if (aVar.a()) {
                    i10 |= aVar.b();
                }
            }
            return i10;
        }

        @Override // j3.h
        public boolean a() {
            return this.f5429a;
        }

        @Override // j3.h
        public int b() {
            return 1 << ordinal();
        }

        public boolean d(int i10) {
            return (i10 & b()) != 0;
        }
    }

    public f() {
        this(null);
    }

    public f3.c a(Object obj, boolean z10) {
        return new f3.c(i(), obj, z10);
    }

    public h b(Writer writer, f3.c cVar) {
        g3.h hVar = new g3.h(cVar, this.f5419e, this.f5420f, writer, this.f5423i);
        int i10 = this.f5422h;
        if (i10 > 0) {
            hVar.E(i10);
        }
        q qVar = this.f5421g;
        if (qVar != f5414m) {
            hVar.L(qVar);
        }
        return hVar;
    }

    public k c(Reader reader, f3.c cVar) {
        return new g3.f(cVar, this.f5418d, reader, this.f5420f, this.f5415a.m(this.f5417c));
    }

    public h d(OutputStream outputStream, f3.c cVar) {
        g3.g gVar = new g3.g(cVar, this.f5419e, this.f5420f, outputStream, this.f5423i);
        int i10 = this.f5422h;
        if (i10 > 0) {
            gVar.E(i10);
        }
        q qVar = this.f5421g;
        if (qVar != f5414m) {
            gVar.L(qVar);
        }
        return gVar;
    }

    public Writer e(OutputStream outputStream, e eVar, f3.c cVar) {
        return eVar == e.UTF8 ? new f3.j(cVar, outputStream) : new OutputStreamWriter(outputStream, eVar.a());
    }

    public final OutputStream f(OutputStream outputStream, f3.c cVar) {
        return outputStream;
    }

    public final Reader g(Reader reader, f3.c cVar) {
        return reader;
    }

    public final Writer h(Writer writer, f3.c cVar) {
        return writer;
    }

    public j3.a i() {
        return a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.d(this.f5417c) ? j3.b.a() : new j3.a();
    }

    public final f j(k.a aVar, boolean z10) {
        return z10 ? o(aVar) : n(aVar);
    }

    public h k(OutputStream outputStream, e eVar) {
        f3.c a10 = a(outputStream, false);
        a10.q(eVar);
        return eVar == e.UTF8 ? d(f(outputStream, a10), a10) : b(h(e(outputStream, eVar, a10), a10), a10);
    }

    public h l(Writer writer) {
        f3.c a10 = a(writer, false);
        return b(h(writer, a10), a10);
    }

    public k m(Reader reader) {
        f3.c a10 = a(reader, false);
        return c(g(reader, a10), a10);
    }

    public f n(k.a aVar) {
        this.f5418d = (aVar.d() ^ (-1)) & this.f5418d;
        return this;
    }

    public f o(k.a aVar) {
        this.f5418d = aVar.d() | this.f5418d;
        return this;
    }

    public o p() {
        return this.f5420f;
    }

    public boolean q() {
        return false;
    }

    public f r(o oVar) {
        this.f5420f = oVar;
        return this;
    }

    public f(o oVar) {
        this.f5415a = h3.c.i();
        this.f5416b = h3.a.c();
        this.f5417c = f5411j;
        this.f5418d = f5412k;
        this.f5419e = f5413l;
        this.f5421g = f5414m;
        this.f5420f = oVar;
        this.f5423i = '\"';
    }
}
