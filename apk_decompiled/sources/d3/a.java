package d3;

import c3.h;
import c3.m;
import c3.o;
import c3.q;
import g3.e;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class a extends h {

    /* renamed from: j, reason: collision with root package name */
    public static final int f12475j = (h.b.WRITE_NUMBERS_AS_STRINGS.d() | h.b.ESCAPE_NON_ASCII.d()) | h.b.STRICT_DUPLICATE_DETECTION.d();

    /* renamed from: e, reason: collision with root package name */
    public o f12476e;

    /* renamed from: f, reason: collision with root package name */
    public int f12477f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12478g;

    /* renamed from: h, reason: collision with root package name */
    public e f12479h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12480i;

    public a(int i10, o oVar) {
        this.f12477f = i10;
        this.f12476e = oVar;
        this.f12479h = e.q(h.b.STRICT_DUPLICATE_DETECTION.c(i10) ? g3.a.e(this) : null);
        this.f12478g = h.b.WRITE_NUMBERS_AS_STRINGS.c(i10);
    }

    public String F0(BigDecimal bigDecimal) {
        if (!h.b.WRITE_BIGDECIMAL_AS_PLAIN.c(this.f12477f)) {
            return bigDecimal.toString();
        }
        int scale = bigDecimal.scale();
        if (scale < -9999 || scale > 9999) {
            a(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(scale), 9999, 9999));
        }
        return bigDecimal.toPlainString();
    }

    public void G0(int i10, int i11) {
        if ((f12475j & i11) == 0) {
            return;
        }
        this.f12478g = h.b.WRITE_NUMBERS_AS_STRINGS.c(i10);
        h.b bVar = h.b.ESCAPE_NON_ASCII;
        if (bVar.c(i11)) {
            if (bVar.c(i10)) {
                E(127);
            } else {
                E(0);
            }
        }
        h.b bVar2 = h.b.STRICT_DUPLICATE_DETECTION;
        if (bVar2.c(i11)) {
            if (!bVar2.c(i10)) {
                this.f12479h = this.f12479h.v(null);
            } else if (this.f12479h.r() == null) {
                this.f12479h = this.f12479h.v(g3.a.e(this));
            }
        }
    }

    public final int H0(int i10, int i11) {
        if (i11 < 56320 || i11 > 57343) {
            a("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(i11));
        }
        return ((i10 - 55296) << 10) + 65536 + (i11 - 56320);
    }

    public abstract void I0(String str);

    @Override // c3.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12480i = true;
    }

    @Override // c3.h
    public h q(h.b bVar) {
        int d10 = bVar.d();
        this.f12477f &= d10 ^ (-1);
        if ((d10 & f12475j) != 0) {
            if (bVar == h.b.WRITE_NUMBERS_AS_STRINGS) {
                this.f12478g = false;
            } else if (bVar == h.b.ESCAPE_NON_ASCII) {
                E(0);
            } else if (bVar == h.b.STRICT_DUPLICATE_DETECTION) {
                this.f12479h = this.f12479h.v(null);
            }
        }
        return this;
    }

    @Override // c3.h
    public void q0(q qVar) {
        I0("write raw value");
        n0(qVar);
    }

    @Override // c3.h
    public void r0(String str) {
        I0("write raw value");
        o0(str);
    }

    @Override // c3.h
    public m s() {
        return this.f12479h;
    }

    @Override // c3.h
    public final boolean v(h.b bVar) {
        return (bVar.d() & this.f12477f) != 0;
    }

    @Override // c3.h
    public h y(int i10, int i11) {
        int i12 = this.f12477f;
        int i13 = (i10 & i11) | ((i11 ^ (-1)) & i12);
        int i14 = i12 ^ i13;
        if (i14 != 0) {
            this.f12477f = i13;
            G0(i13, i14);
        }
        return this;
    }

    @Override // c3.h
    public void z(Object obj) {
        e eVar = this.f12479h;
        if (eVar != null) {
            eVar.i(obj);
        }
    }
}
