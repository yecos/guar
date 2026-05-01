package m;

import java.util.ArrayList;
import m.e;

/* loaded from: classes.dex */
public class f {

    /* renamed from: u0, reason: collision with root package name */
    public static float f16509u0 = 0.5f;
    public e B;
    public e[] C;
    public ArrayList D;
    public b[] E;
    public f F;
    public int G;
    public int H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public float Z;

    /* renamed from: a0, reason: collision with root package name */
    public float f16511a0;

    /* renamed from: b0, reason: collision with root package name */
    public Object f16513b0;

    /* renamed from: c, reason: collision with root package name */
    public n f16514c;

    /* renamed from: c0, reason: collision with root package name */
    public int f16515c0;

    /* renamed from: d, reason: collision with root package name */
    public n f16516d;

    /* renamed from: d0, reason: collision with root package name */
    public int f16517d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f16519e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f16521f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f16523g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f16525h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f16527i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f16529j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f16531k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f16533l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f16535m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16536n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f16537n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16538o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f16539o0;

    /* renamed from: p0, reason: collision with root package name */
    public float[] f16541p0;

    /* renamed from: q0, reason: collision with root package name */
    public f[] f16543q0;

    /* renamed from: r0, reason: collision with root package name */
    public f[] f16545r0;

    /* renamed from: s0, reason: collision with root package name */
    public f f16547s0;

    /* renamed from: t0, reason: collision with root package name */
    public f f16549t0;

    /* renamed from: a, reason: collision with root package name */
    public int f16510a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f16512b = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f16518e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f16520f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int[] f16522g = new int[2];

    /* renamed from: h, reason: collision with root package name */
    public int f16524h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f16526i = 0;

    /* renamed from: j, reason: collision with root package name */
    public float f16528j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public int f16530k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f16532l = 0;

    /* renamed from: m, reason: collision with root package name */
    public float f16534m = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    public int f16540p = -1;

    /* renamed from: q, reason: collision with root package name */
    public float f16542q = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    public h f16544r = null;

    /* renamed from: s, reason: collision with root package name */
    public int[] f16546s = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: t, reason: collision with root package name */
    public float f16548t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    public e f16550u = new e(this, e.d.LEFT);

    /* renamed from: v, reason: collision with root package name */
    public e f16551v = new e(this, e.d.TOP);

    /* renamed from: w, reason: collision with root package name */
    public e f16552w = new e(this, e.d.RIGHT);

    /* renamed from: x, reason: collision with root package name */
    public e f16553x = new e(this, e.d.BOTTOM);

    /* renamed from: y, reason: collision with root package name */
    public e f16554y = new e(this, e.d.BASELINE);

    /* renamed from: z, reason: collision with root package name */
    public e f16555z = new e(this, e.d.CENTER_X);
    public e A = new e(this, e.d.CENTER_Y);

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16556a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16557b;

        static {
            int[] iArr = new int[b.values().length];
            f16557b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16557b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16557b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16557b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[e.d.values().length];
            f16556a = iArr2;
            try {
                iArr2[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16556a[e.d.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16556a[e.d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16556a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16556a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16556a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16556a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16556a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f16556a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public f() {
        e eVar = new e(this, e.d.CENTER);
        this.B = eVar;
        this.C = new e[]{this.f16550u, this.f16552w, this.f16551v, this.f16553x, this.f16554y, eVar};
        this.D = new ArrayList();
        b bVar = b.FIXED;
        this.E = new b[]{bVar, bVar};
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f10 = f16509u0;
        this.Z = f10;
        this.f16511a0 = f10;
        this.f16515c0 = 0;
        this.f16517d0 = 0;
        this.f16519e0 = null;
        this.f16521f0 = null;
        this.f16527i0 = false;
        this.f16529j0 = false;
        this.f16531k0 = false;
        this.f16533l0 = 0;
        this.f16535m0 = 0;
        this.f16541p0 = new float[]{-1.0f, -1.0f};
        this.f16543q0 = new f[]{null, null};
        this.f16545r0 = new f[]{null, null};
        this.f16547s0 = null;
        this.f16549t0 = null;
        a();
    }

    public int A() {
        return this.L + this.T;
    }

    public void A0(int i10) {
        this.Y = i10;
    }

    public b B() {
        return this.E[1];
    }

    public void B0(int i10) {
        this.X = i10;
    }

    public int C() {
        return this.f16517d0;
    }

    public void C0(int i10) {
        this.K = i10;
    }

    public int D() {
        if (this.f16517d0 == 8) {
            return 0;
        }
        return this.G;
    }

    public void D0(int i10) {
        this.L = i10;
    }

    public int E() {
        return this.Y;
    }

    public void E0(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.f16540p == -1) {
            if (z12 && !z13) {
                this.f16540p = 0;
            } else if (!z12 && z13) {
                this.f16540p = 1;
                if (this.J == -1) {
                    this.f16542q = 1.0f / this.f16542q;
                }
            }
        }
        if (this.f16540p == 0 && (!this.f16551v.k() || !this.f16553x.k())) {
            this.f16540p = 1;
        } else if (this.f16540p == 1 && (!this.f16550u.k() || !this.f16552w.k())) {
            this.f16540p = 0;
        }
        if (this.f16540p == -1 && (!this.f16551v.k() || !this.f16553x.k() || !this.f16550u.k() || !this.f16552w.k())) {
            if (this.f16551v.k() && this.f16553x.k()) {
                this.f16540p = 0;
            } else if (this.f16550u.k() && this.f16552w.k()) {
                this.f16542q = 1.0f / this.f16542q;
                this.f16540p = 1;
            }
        }
        if (this.f16540p == -1) {
            if (z10 && !z11) {
                this.f16540p = 0;
            } else if (!z10 && z11) {
                this.f16542q = 1.0f / this.f16542q;
                this.f16540p = 1;
            }
        }
        if (this.f16540p == -1) {
            int i10 = this.f16524h;
            if (i10 > 0 && this.f16530k == 0) {
                this.f16540p = 0;
            } else if (i10 == 0 && this.f16530k > 0) {
                this.f16542q = 1.0f / this.f16542q;
                this.f16540p = 1;
            }
        }
        if (this.f16540p == -1 && z10 && z11) {
            this.f16542q = 1.0f / this.f16542q;
            this.f16540p = 1;
        }
    }

    public int F() {
        return this.X;
    }

    public void F0() {
        int i10 = this.K;
        int i11 = this.L;
        int i12 = this.G + i10;
        int i13 = this.H + i11;
        this.O = i10;
        this.P = i11;
        this.Q = i12 - i10;
        this.R = i13 - i11;
    }

    public int G() {
        return this.K;
    }

    public void G0(l.e eVar) {
        int y10 = eVar.y(this.f16550u);
        int y11 = eVar.y(this.f16551v);
        int y12 = eVar.y(this.f16552w);
        int y13 = eVar.y(this.f16553x);
        int i10 = y13 - y11;
        if (y12 - y10 < 0 || i10 < 0 || y10 == Integer.MIN_VALUE || y10 == Integer.MAX_VALUE || y11 == Integer.MIN_VALUE || y11 == Integer.MAX_VALUE || y12 == Integer.MIN_VALUE || y12 == Integer.MAX_VALUE || y13 == Integer.MIN_VALUE || y13 == Integer.MAX_VALUE) {
            y10 = 0;
            y13 = 0;
            y11 = 0;
            y12 = 0;
        }
        a0(y10, y11, y12, y13);
    }

    public int H() {
        return this.L;
    }

    public void H0() {
        for (int i10 = 0; i10 < 6; i10++) {
            this.C[i10].f().q();
        }
    }

    public boolean I() {
        return this.U > 0;
    }

    public void J(e.d dVar, f fVar, e.d dVar2, int i10, int i11) {
        h(dVar).a(fVar.h(dVar2), i10, i11, e.c.STRONG, 0, true);
    }

    public final boolean K(int i10) {
        e eVar;
        e eVar2;
        int i11 = i10 * 2;
        e[] eVarArr = this.C;
        e eVar3 = eVarArr[i11];
        e eVar4 = eVar3.f16484d;
        return (eVar4 == null || eVar4.f16484d == eVar3 || (eVar2 = (eVar = eVarArr[i11 + 1]).f16484d) == null || eVar2.f16484d != eVar) ? false : true;
    }

    public boolean L() {
        return this.f16550u.f().f16602b == 1 && this.f16552w.f().f16602b == 1 && this.f16551v.f().f16602b == 1 && this.f16553x.f().f16602b == 1;
    }

    public boolean M() {
        e eVar = this.f16550u;
        e eVar2 = eVar.f16484d;
        if (eVar2 != null && eVar2.f16484d == eVar) {
            return true;
        }
        e eVar3 = this.f16552w;
        e eVar4 = eVar3.f16484d;
        return eVar4 != null && eVar4.f16484d == eVar3;
    }

    public boolean N() {
        e eVar = this.f16551v;
        e eVar2 = eVar.f16484d;
        if (eVar2 != null && eVar2.f16484d == eVar) {
            return true;
        }
        e eVar3 = this.f16553x;
        e eVar4 = eVar3.f16484d;
        return eVar4 != null && eVar4.f16484d == eVar3;
    }

    public boolean O() {
        return this.f16520f == 0 && this.I == 0.0f && this.f16530k == 0 && this.f16532l == 0 && this.E[1] == b.MATCH_CONSTRAINT;
    }

    public boolean P() {
        return this.f16518e == 0 && this.I == 0.0f && this.f16524h == 0 && this.f16526i == 0 && this.E[0] == b.MATCH_CONSTRAINT;
    }

    public void Q() {
        this.f16550u.m();
        this.f16551v.m();
        this.f16552w.m();
        this.f16553x.m();
        this.f16554y.m();
        this.f16555z.m();
        this.A.m();
        this.B.m();
        this.F = null;
        this.f16548t = 0.0f;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f10 = f16509u0;
        this.Z = f10;
        this.f16511a0 = f10;
        b[] bVarArr = this.E;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f16513b0 = null;
        this.f16515c0 = 0;
        this.f16517d0 = 0;
        this.f16521f0 = null;
        this.f16523g0 = false;
        this.f16525h0 = false;
        this.f16533l0 = 0;
        this.f16535m0 = 0;
        this.f16537n0 = false;
        this.f16539o0 = false;
        float[] fArr = this.f16541p0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f16510a = -1;
        this.f16512b = -1;
        int[] iArr = this.f16546s;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f16518e = 0;
        this.f16520f = 0;
        this.f16528j = 1.0f;
        this.f16534m = 1.0f;
        this.f16526i = Integer.MAX_VALUE;
        this.f16532l = Integer.MAX_VALUE;
        this.f16524h = 0;
        this.f16530k = 0;
        this.f16540p = -1;
        this.f16542q = 1.0f;
        n nVar = this.f16514c;
        if (nVar != null) {
            nVar.e();
        }
        n nVar2 = this.f16516d;
        if (nVar2 != null) {
            nVar2.e();
        }
        this.f16544r = null;
        this.f16527i0 = false;
        this.f16529j0 = false;
        this.f16531k0 = false;
    }

    public void R() {
        f u10 = u();
        if (u10 != null && (u10 instanceof g) && ((g) u()).S0()) {
            return;
        }
        int size = this.D.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) this.D.get(i10)).m();
        }
    }

    public void S() {
        for (int i10 = 0; i10 < 6; i10++) {
            this.C[i10].f().e();
        }
    }

    public void T(l.c cVar) {
        this.f16550u.n(cVar);
        this.f16551v.n(cVar);
        this.f16552w.n(cVar);
        this.f16553x.n(cVar);
        this.f16554y.n(cVar);
        this.B.n(cVar);
        this.f16555z.n(cVar);
        this.A.n(cVar);
    }

    public void U() {
    }

    public void V(int i10) {
        this.U = i10;
    }

    public void W(Object obj) {
        this.f16513b0 = obj;
    }

    public void X(String str) {
        this.f16519e0 = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0087 -> B:31:0x0088). Please report as a decompilation issue!!! */
    public void Y(String str) {
        float f10;
        int i10 = 0;
        if (str == null || str.length() == 0) {
            this.I = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i11 = -1;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            i11 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
            r3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(r3);
            if (substring2.length() > 0) {
                f10 = Float.parseFloat(substring2);
            }
            f10 = 0.0f;
        } else {
            String substring3 = str.substring(r3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f10 = i11 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f10 = 0.0f;
        }
        i10 = (f10 > i10 ? 1 : (f10 == i10 ? 0 : -1));
        if (i10 > 0) {
            this.I = f10;
            this.J = i11;
        }
    }

    public void Z(int i10, int i11, int i12) {
        if (i12 == 0) {
            f0(i10, i11);
        } else if (i12 == 1) {
            t0(i10, i11);
        }
        this.f16529j0 = true;
    }

    public final void a() {
        this.D.add(this.f16550u);
        this.D.add(this.f16551v);
        this.D.add(this.f16552w);
        this.D.add(this.f16553x);
        this.D.add(this.f16555z);
        this.D.add(this.A);
        this.D.add(this.B);
        this.D.add(this.f16554y);
    }

    public void a0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.K = i10;
        this.L = i11;
        if (this.f16517d0 == 8) {
            this.G = 0;
            this.H = 0;
            return;
        }
        b[] bVarArr = this.E;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i16 < (i15 = this.G)) {
            i16 = i15;
        }
        if (bVarArr[1] == bVar2 && i17 < (i14 = this.H)) {
            i17 = i14;
        }
        this.G = i16;
        this.H = i17;
        int i18 = this.W;
        if (i17 < i18) {
            this.H = i18;
        }
        int i19 = this.V;
        if (i16 < i19) {
            this.G = i19;
        }
        this.f16529j0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(l.e r42) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.b(l.e):void");
    }

    public void b0(int i10) {
        this.H = i10;
        int i11 = this.W;
        if (i10 < i11) {
            this.H = i11;
        }
    }

    public boolean c() {
        return this.f16517d0 != 8;
    }

    public void c0(boolean z10) {
        this.f16538o = z10;
    }

    public void d(int i10) {
        k.a(i10, this);
    }

    public void d0(float f10) {
        this.Z = f10;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(l.e r26, boolean r27, l.i r28, l.i r29, m.f.b r30, boolean r31, m.e r32, m.e r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.e(l.e, boolean, l.i, l.i, m.f$b, boolean, m.e, m.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    public void e0(int i10) {
        this.f16533l0 = i10;
    }

    public void f(f fVar, float f10, int i10) {
        e.d dVar = e.d.CENTER;
        J(dVar, fVar, dVar, i10, 0);
        this.f16548t = f10;
    }

    public void f0(int i10, int i11) {
        this.K = i10;
        int i12 = i11 - i10;
        this.G = i12;
        int i13 = this.V;
        if (i12 < i13) {
            this.G = i13;
        }
    }

    public void g(l.e eVar) {
        eVar.r(this.f16550u);
        eVar.r(this.f16551v);
        eVar.r(this.f16552w);
        eVar.r(this.f16553x);
        if (this.U > 0) {
            eVar.r(this.f16554y);
        }
    }

    public void g0(b bVar) {
        this.E[0] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            y0(this.X);
        }
    }

    public e h(e.d dVar) {
        switch (a.f16556a[dVar.ordinal()]) {
            case 1:
                return this.f16550u;
            case 2:
                return this.f16551v;
            case 3:
                return this.f16552w;
            case 4:
                return this.f16553x;
            case 5:
                return this.f16554y;
            case 6:
                return this.B;
            case 7:
                return this.f16555z;
            case 8:
                return this.A;
            case 9:
                return null;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public void h0(int i10, int i11, int i12, float f10) {
        this.f16518e = i10;
        this.f16524h = i11;
        this.f16526i = i12;
        this.f16528j = f10;
        if (f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f16518e = 2;
    }

    public ArrayList i() {
        return this.D;
    }

    public void i0(float f10) {
        this.f16541p0[0] = f10;
    }

    public int j() {
        return this.U;
    }

    public void j0(int i10) {
        this.f16546s[1] = i10;
    }

    public float k(int i10) {
        if (i10 == 0) {
            return this.Z;
        }
        if (i10 == 1) {
            return this.f16511a0;
        }
        return -1.0f;
    }

    public void k0(int i10) {
        this.f16546s[0] = i10;
    }

    public int l() {
        return H() + this.H;
    }

    public void l0(int i10) {
        if (i10 < 0) {
            this.W = 0;
        } else {
            this.W = i10;
        }
    }

    public Object m() {
        return this.f16513b0;
    }

    public void m0(int i10) {
        if (i10 < 0) {
            this.V = 0;
        } else {
            this.V = i10;
        }
    }

    public String n() {
        return this.f16519e0;
    }

    public void n0(int i10, int i11) {
        this.S = i10;
        this.T = i11;
    }

    public b o(int i10) {
        if (i10 == 0) {
            return s();
        }
        if (i10 == 1) {
            return B();
        }
        return null;
    }

    public void o0(int i10, int i11) {
        this.K = i10;
        this.L = i11;
    }

    public int p() {
        return this.O + this.S;
    }

    public void p0(f fVar) {
        this.F = fVar;
    }

    public int q() {
        return this.P + this.T;
    }

    public void q0(int i10, int i11) {
        if (i11 == 0) {
            this.M = i10;
        } else if (i11 == 1) {
            this.N = i10;
        }
    }

    public int r() {
        if (this.f16517d0 == 8) {
            return 0;
        }
        return this.H;
    }

    public void r0(float f10) {
        this.f16511a0 = f10;
    }

    public b s() {
        return this.E[0];
    }

    public void s0(int i10) {
        this.f16535m0 = i10;
    }

    public int t(int i10) {
        if (i10 == 0) {
            return D();
        }
        if (i10 == 1) {
            return r();
        }
        return 0;
    }

    public void t0(int i10, int i11) {
        this.L = i10;
        int i12 = i11 - i10;
        this.H = i12;
        int i13 = this.W;
        if (i12 < i13) {
            this.H = i13;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f16521f0 != null) {
            str = "type: " + this.f16521f0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f16519e0 != null) {
            str2 = "id: " + this.f16519e0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.K);
        sb.append(", ");
        sb.append(this.L);
        sb.append(") - (");
        sb.append(this.G);
        sb.append(" x ");
        sb.append(this.H);
        sb.append(") wrap: (");
        sb.append(this.X);
        sb.append(" x ");
        sb.append(this.Y);
        sb.append(")");
        return sb.toString();
    }

    public f u() {
        return this.F;
    }

    public void u0(b bVar) {
        this.E[1] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            b0(this.Y);
        }
    }

    public int v(int i10) {
        if (i10 == 0) {
            return this.M;
        }
        if (i10 == 1) {
            return this.N;
        }
        return 0;
    }

    public void v0(int i10, int i11, int i12, float f10) {
        this.f16520f = i10;
        this.f16530k = i11;
        this.f16532l = i12;
        this.f16534m = f10;
        if (f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f16520f = 2;
    }

    public n w() {
        if (this.f16516d == null) {
            this.f16516d = new n();
        }
        return this.f16516d;
    }

    public void w0(float f10) {
        this.f16541p0[1] = f10;
    }

    public n x() {
        if (this.f16514c == null) {
            this.f16514c = new n();
        }
        return this.f16514c;
    }

    public void x0(int i10) {
        this.f16517d0 = i10;
    }

    public int y() {
        return G() + this.G;
    }

    public void y0(int i10) {
        this.G = i10;
        int i11 = this.V;
        if (i10 < i11) {
            this.G = i11;
        }
    }

    public int z() {
        return this.K + this.S;
    }

    public void z0(boolean z10) {
        this.f16536n = z10;
    }
}
