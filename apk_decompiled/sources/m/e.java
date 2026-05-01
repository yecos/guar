package m;

import com.hpplay.cybergarage.soap.SOAP;
import l.i;

/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public final f f16482b;

    /* renamed from: c, reason: collision with root package name */
    public final d f16483c;

    /* renamed from: d, reason: collision with root package name */
    public e f16484d;

    /* renamed from: j, reason: collision with root package name */
    public l.i f16490j;

    /* renamed from: a, reason: collision with root package name */
    public m f16481a = new m(this);

    /* renamed from: e, reason: collision with root package name */
    public int f16485e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f16486f = -1;

    /* renamed from: g, reason: collision with root package name */
    public c f16487g = c.NONE;

    /* renamed from: h, reason: collision with root package name */
    public b f16488h = b.RELAXED;

    /* renamed from: i, reason: collision with root package name */
    public int f16489i = 0;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16491a;

        static {
            int[] iArr = new int[d.values().length];
            f16491a = iArr;
            try {
                iArr[d.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16491a[d.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16491a[d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16491a[d.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16491a[d.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16491a[d.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16491a[d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16491a[d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16491a[d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        RELAXED,
        STRICT
    }

    public enum c {
        NONE,
        STRONG,
        WEAK
    }

    public enum d {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, d dVar) {
        this.f16482b = fVar;
        this.f16483c = dVar;
    }

    public boolean a(e eVar, int i10, int i11, c cVar, int i12, boolean z10) {
        if (eVar == null) {
            this.f16484d = null;
            this.f16485e = 0;
            this.f16486f = -1;
            this.f16487g = c.NONE;
            this.f16489i = 2;
            return true;
        }
        if (!z10 && !l(eVar)) {
            return false;
        }
        this.f16484d = eVar;
        if (i10 > 0) {
            this.f16485e = i10;
        } else {
            this.f16485e = 0;
        }
        this.f16486f = i11;
        this.f16487g = cVar;
        this.f16489i = i12;
        return true;
    }

    public boolean b(e eVar, int i10, c cVar, int i11) {
        return a(eVar, i10, -1, cVar, i11, false);
    }

    public int c() {
        return this.f16489i;
    }

    public int d() {
        e eVar;
        if (this.f16482b.C() == 8) {
            return 0;
        }
        return (this.f16486f <= -1 || (eVar = this.f16484d) == null || eVar.f16482b.C() != 8) ? this.f16485e : this.f16486f;
    }

    public f e() {
        return this.f16482b;
    }

    public m f() {
        return this.f16481a;
    }

    public l.i g() {
        return this.f16490j;
    }

    public c h() {
        return this.f16487g;
    }

    public e i() {
        return this.f16484d;
    }

    public d j() {
        return this.f16483c;
    }

    public boolean k() {
        return this.f16484d != null;
    }

    public boolean l(e eVar) {
        if (eVar == null) {
            return false;
        }
        d j10 = eVar.j();
        d dVar = this.f16483c;
        if (j10 == dVar) {
            return dVar != d.BASELINE || (eVar.e().I() && e().I());
        }
        switch (a.f16491a[dVar.ordinal()]) {
            case 1:
                return (j10 == d.BASELINE || j10 == d.CENTER_X || j10 == d.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z10 = j10 == d.LEFT || j10 == d.RIGHT;
                if (eVar.e() instanceof i) {
                    return z10 || j10 == d.CENTER_X;
                }
                return z10;
            case 4:
            case 5:
                boolean z11 = j10 == d.TOP || j10 == d.BOTTOM;
                if (eVar.e() instanceof i) {
                    return z11 || j10 == d.CENTER_Y;
                }
                return z11;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f16483c.name());
        }
    }

    public void m() {
        this.f16484d = null;
        this.f16485e = 0;
        this.f16486f = -1;
        this.f16487g = c.STRONG;
        this.f16489i = 0;
        this.f16488h = b.RELAXED;
        this.f16481a.e();
    }

    public void n(l.c cVar) {
        l.i iVar = this.f16490j;
        if (iVar == null) {
            this.f16490j = new l.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f16482b.n() + SOAP.DELIM + this.f16483c.toString();
    }
}
