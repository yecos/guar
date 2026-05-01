package g3;

import c3.k;
import c3.n;
import c3.o;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import j3.i;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

/* loaded from: classes.dex */
public class f extends d3.b {

    /* renamed from: j0, reason: collision with root package name */
    public static final int f13599j0 = k.a.ALLOW_TRAILING_COMMA.d();

    /* renamed from: k0, reason: collision with root package name */
    public static final int f13600k0 = k.a.ALLOW_NUMERIC_LEADING_ZEROS.d();

    /* renamed from: l0, reason: collision with root package name */
    public static final int f13601l0 = k.a.ALLOW_NON_NUMERIC_NUMBERS.d();

    /* renamed from: m0, reason: collision with root package name */
    public static final int f13602m0 = k.a.ALLOW_MISSING_VALUES.d();

    /* renamed from: n0, reason: collision with root package name */
    public static final int f13603n0 = k.a.ALLOW_SINGLE_QUOTES.d();

    /* renamed from: o0, reason: collision with root package name */
    public static final int f13604o0 = k.a.ALLOW_UNQUOTED_FIELD_NAMES.d();

    /* renamed from: p0, reason: collision with root package name */
    public static final int f13605p0 = k.a.ALLOW_COMMENTS.d();

    /* renamed from: q0, reason: collision with root package name */
    public static final int f13606q0 = k.a.ALLOW_YAML_COMMENTS.d();

    /* renamed from: r0, reason: collision with root package name */
    public static final int[] f13607r0 = f3.a.g();
    public Reader S;
    public char[] V;
    public boolean W;
    public o X;
    public final h3.c Y;
    public final int Z;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f13608f0;

    /* renamed from: g0, reason: collision with root package name */
    public long f13609g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f13610h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f13611i0;

    public f(f3.c cVar, int i10, Reader reader, o oVar, h3.c cVar2) {
        super(cVar, i10);
        this.S = reader;
        this.V = cVar.g();
        this.f12483q = 0;
        this.f12484r = 0;
        this.X = oVar;
        this.Y = cVar2;
        this.Z = cVar2.l();
        this.W = true;
    }

    public final void A2() {
        this.f13608f0 = false;
        int i10 = this.f12483q;
        int i11 = this.f12484r;
        char[] cArr = this.V;
        while (true) {
            if (i10 >= i11) {
                this.f12483q = i10;
                if (!Y1()) {
                    Q0(": was expecting closing quote for a string value", n.VALUE_STRING);
                }
                i10 = this.f12483q;
                i11 = this.f12484r;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    this.f12483q = i12;
                    l1();
                    i10 = this.f12483q;
                    i11 = this.f12484r;
                } else if (c10 <= '\"') {
                    if (c10 == '\"') {
                        this.f12483q = i12;
                        return;
                    } else if (c10 < ' ') {
                        this.f12483q = i12;
                        y1(c10, "string value");
                    }
                }
            }
            i10 = i12;
        }
    }

    public final int B2() {
        if (this.f12483q >= this.f12484r && !Y1()) {
            return m1();
        }
        char[] cArr = this.V;
        int i10 = this.f12483q;
        int i11 = i10 + 1;
        this.f12483q = i11;
        char c10 = cArr[i10];
        if (c10 > ' ') {
            if (c10 != '/' && c10 != '#') {
                return c10;
            }
            this.f12483q = i11 - 1;
            return C2();
        }
        if (c10 != ' ') {
            if (c10 == '\n') {
                this.f12486t++;
                this.f12487u = i11;
            } else if (c10 == '\r') {
                u2();
            } else if (c10 != '\t') {
                V0(c10);
            }
        }
        while (true) {
            int i12 = this.f12483q;
            if (i12 >= this.f12484r) {
                return C2();
            }
            char[] cArr2 = this.V;
            int i13 = i12 + 1;
            this.f12483q = i13;
            char c11 = cArr2[i12];
            if (c11 > ' ') {
                if (c11 != '/' && c11 != '#') {
                    return c11;
                }
                this.f12483q = i13 - 1;
                return C2();
            }
            if (c11 != ' ') {
                if (c11 == '\n') {
                    this.f12486t++;
                    this.f12487u = i13;
                } else if (c11 == '\r') {
                    u2();
                } else if (c11 != '\t') {
                    V0(c11);
                }
            }
        }
    }

    public final int C2() {
        char c10;
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                return m1();
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            int i11 = i10 + 1;
            this.f12483q = i11;
            c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    y2();
                } else if (c10 != '#' || !D2()) {
                    break;
                }
            } else if (c10 != ' ') {
                if (c10 == '\n') {
                    this.f12486t++;
                    this.f12487u = i11;
                } else if (c10 == '\r') {
                    u2();
                } else if (c10 != '\t') {
                    V0(c10);
                }
            }
        }
        return c10;
    }

    public final boolean D2() {
        if ((this.f5456a & f13606q0) == 0) {
            return false;
        }
        z2();
        return true;
    }

    public final void E2() {
        int i10 = this.f12483q;
        this.f12488v = this.f12485s + i10;
        this.f12489w = this.f12486t;
        this.f12490x = i10 - this.f12487u;
    }

    public final void F2() {
        int i10 = this.f12483q;
        this.f13609g0 = i10;
        this.f13610h0 = this.f12486t;
        this.f13611i0 = i10 - this.f12487u;
    }

    public final char G2() {
        char c10;
        if ((this.f12483q >= this.f12484r && !Y1()) || (c10 = this.V[this.f12483q]) < '0' || c10 > '9') {
            return '0';
        }
        if ((this.f5456a & f13600k0) == 0) {
            a1("Leading zeroes not allowed");
        }
        this.f12483q++;
        if (c10 == '0') {
            do {
                if (this.f12483q >= this.f12484r && !Y1()) {
                    break;
                }
                char[] cArr = this.V;
                int i10 = this.f12483q;
                c10 = cArr[i10];
                if (c10 < '0' || c10 > '9') {
                    return '0';
                }
                this.f12483q = i10 + 1;
            } while (c10 == '0');
        }
        return c10;
    }

    public final char H2() {
        char c10;
        int i10 = this.f12483q;
        if (i10 >= this.f12484r || ((c10 = this.V[i10]) >= '0' && c10 <= '9')) {
            return G2();
        }
        return '0';
    }

    public final void I2(int i10) {
        int i11 = this.f12483q + 1;
        this.f12483q = i11;
        if (i10 != 9) {
            if (i10 == 10) {
                this.f12486t++;
                this.f12487u = i11;
            } else if (i10 == 13) {
                u2();
            } else if (i10 != 32) {
                S0(i10);
            }
        }
    }

    public char J2(String str) {
        return K2(str, null);
    }

    public char K2(String str, n nVar) {
        if (this.f12483q >= this.f12484r && !Y1()) {
            Q0(str, nVar);
        }
        char[] cArr = this.V;
        int i10 = this.f12483q;
        this.f12483q = i10 + 1;
        return cArr[i10];
    }

    public final void N1(String str, int i10, int i11) {
        if (Character.isJavaIdentifierPart((char) i11)) {
            q2(str.substring(0, i10));
        }
    }

    public final void O1(int i10) {
        if (i10 == 93) {
            E2();
            if (!this.f12491y.f()) {
                w1(i10, ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
            }
            this.f12491y = this.f12491y.l();
            this.f12503c = n.END_ARRAY;
        }
        if (i10 == 125) {
            E2();
            if (!this.f12491y.g()) {
                w1(i10, ']');
            }
            this.f12491y = this.f12491y.l();
            this.f12503c = n.END_OBJECT;
        }
    }

    public byte[] P1(c3.a aVar) {
        j3.c n12 = n1();
        while (true) {
            if (this.f12483q >= this.f12484r) {
                Z1();
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            this.f12483q = i10 + 1;
            char c10 = cArr[i10];
            if (c10 > ' ') {
                int g10 = aVar.g(c10);
                if (g10 < 0) {
                    if (c10 == '\"') {
                        return n12.v();
                    }
                    g10 = k1(aVar, c10, 0);
                    if (g10 < 0) {
                        continue;
                    }
                }
                if (this.f12483q >= this.f12484r) {
                    Z1();
                }
                char[] cArr2 = this.V;
                int i11 = this.f12483q;
                this.f12483q = i11 + 1;
                char c11 = cArr2[i11];
                int g11 = aVar.g(c11);
                if (g11 < 0) {
                    g11 = k1(aVar, c11, 1);
                }
                int i12 = (g10 << 6) | g11;
                if (this.f12483q >= this.f12484r) {
                    Z1();
                }
                char[] cArr3 = this.V;
                int i13 = this.f12483q;
                this.f12483q = i13 + 1;
                char c12 = cArr3[i13];
                int g12 = aVar.g(c12);
                if (g12 < 0) {
                    if (g12 != -2) {
                        if (c12 == '\"') {
                            n12.b(i12 >> 4);
                            if (aVar.v()) {
                                this.f12483q--;
                                p1(aVar);
                            }
                            return n12.v();
                        }
                        g12 = k1(aVar, c12, 2);
                    }
                    if (g12 == -2) {
                        if (this.f12483q >= this.f12484r) {
                            Z1();
                        }
                        char[] cArr4 = this.V;
                        int i14 = this.f12483q;
                        this.f12483q = i14 + 1;
                        char c13 = cArr4[i14];
                        if (!aVar.w(c13) && k1(aVar, c13, 3) != -2) {
                            throw I1(aVar, c13, 3, "expected padding character '" + aVar.r() + "'");
                        }
                        n12.b(i12 >> 4);
                    }
                }
                int i15 = (i12 << 6) | g12;
                if (this.f12483q >= this.f12484r) {
                    Z1();
                }
                char[] cArr5 = this.V;
                int i16 = this.f12483q;
                this.f12483q = i16 + 1;
                char c14 = cArr5[i16];
                int g13 = aVar.g(c14);
                if (g13 < 0) {
                    if (g13 != -2) {
                        if (c14 == '\"') {
                            n12.e(i15 >> 2);
                            if (aVar.v()) {
                                this.f12483q--;
                                p1(aVar);
                            }
                            return n12.v();
                        }
                        g13 = k1(aVar, c14, 3);
                    }
                    if (g13 == -2) {
                        n12.e(i15 >> 2);
                    }
                }
                n12.c((i15 << 6) | g13);
            }
        }
    }

    public final void Q1() {
        int i10 = this.f12483q;
        int i11 = this.f12484r;
        if (i10 < i11) {
            int[] iArr = f13607r0;
            int length = iArr.length;
            while (true) {
                char[] cArr = this.V;
                char c10 = cArr[i10];
                if (c10 >= length || iArr[c10] == 0) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                } else if (c10 == '\"') {
                    j3.o oVar = this.A;
                    int i12 = this.f12483q;
                    oVar.w(cArr, i12, i10 - i12);
                    this.f12483q = i10 + 1;
                    return;
                }
            }
        }
        j3.o oVar2 = this.A;
        char[] cArr2 = this.V;
        int i13 = this.f12483q;
        oVar2.v(cArr2, i13, i10 - i13);
        this.f12483q = i10;
        R1();
    }

    public void R1() {
        char[] q10 = this.A.q();
        int r10 = this.A.r();
        int[] iArr = f13607r0;
        int length = iArr.length;
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                Q0(": was expecting closing quote for a string value", n.VALUE_STRING);
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            this.f12483q = i10 + 1;
            char c10 = cArr[i10];
            if (c10 < length && iArr[c10] != 0) {
                if (c10 == '\"') {
                    this.A.z(r10);
                    return;
                } else if (c10 == '\\') {
                    c10 = l1();
                } else if (c10 < ' ') {
                    y1(c10, "string value");
                }
            }
            if (r10 >= q10.length) {
                q10 = this.A.o();
                r10 = 0;
            }
            q10[r10] = c10;
            r10++;
        }
    }

    public final String S1(n nVar) {
        if (nVar == null) {
            return null;
        }
        int c10 = nVar.c();
        return c10 != 5 ? (c10 == 6 || c10 == 7 || c10 == 8) ? this.A.l() : nVar.b() : this.f12491y.b();
    }

    public n T1() {
        char[] m10 = this.A.m();
        int r10 = this.A.r();
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                Q0(": was expecting closing quote for a string value", n.VALUE_STRING);
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            this.f12483q = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    c10 = l1();
                } else if (c10 <= '\'') {
                    if (c10 == '\'') {
                        this.A.z(r10);
                        return n.VALUE_STRING;
                    }
                    if (c10 < ' ') {
                        y1(c10, "string value");
                    }
                }
            }
            if (r10 >= m10.length) {
                m10 = this.A.o();
                r10 = 0;
            }
            m10[r10] = c10;
            r10++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public c3.n U1(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    public String V1(int i10) {
        if (i10 == 39 && (this.f5456a & f13603n0) != 0) {
            return h2();
        }
        if ((this.f5456a & f13604o0) == 0) {
            T0(i10, "was expecting double-quote to start field name");
        }
        int[] h10 = f3.a.h();
        int length = h10.length;
        if (!(i10 < length ? h10[i10] == 0 : Character.isJavaIdentifierPart((char) i10))) {
            T0(i10, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i11 = this.f12483q;
        int i12 = this.Z;
        int i13 = this.f12484r;
        if (i11 < i13) {
            do {
                char[] cArr = this.V;
                char c10 = cArr[i11];
                if (c10 < length) {
                    if (h10[c10] != 0) {
                        int i14 = this.f12483q - 1;
                        this.f12483q = i11;
                        return this.Y.k(cArr, i14, i11 - i14, i12);
                    }
                } else if (!Character.isJavaIdentifierPart(c10)) {
                    int i15 = this.f12483q - 1;
                    this.f12483q = i11;
                    return this.Y.k(this.V, i15, i11 - i15, i12);
                }
                i12 = (i12 * 33) + c10;
                i11++;
            } while (i11 < i13);
        }
        int i16 = this.f12483q - 1;
        this.f12483q = i11;
        return W1(i16, i12, h10);
    }

    @Override // c3.k
    public i W() {
        return d3.b.Q;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String W1(int i10, int i11, int[] iArr) {
        int i12;
        this.A.w(this.V, i10, this.f12483q - i10);
        char[] q10 = this.A.q();
        int r10 = this.A.r();
        int length = iArr.length;
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                break;
            }
            char c10 = this.V[this.f12483q];
            if (c10 < length) {
                if (iArr[c10] != 0) {
                    break;
                }
                this.f12483q++;
                i11 = (i11 * 33) + c10;
                i12 = r10 + 1;
                q10[r10] = c10;
                if (i12 < q10.length) {
                    q10 = this.A.o();
                    r10 = 0;
                } else {
                    r10 = i12;
                }
            } else {
                if (!Character.isJavaIdentifierPart(c10)) {
                    break;
                }
                this.f12483q++;
                i11 = (i11 * 33) + c10;
                i12 = r10 + 1;
                q10[r10] = c10;
                if (i12 < q10.length) {
                }
            }
        }
        this.A.z(r10);
        j3.o oVar = this.A;
        return this.Y.k(oVar.s(), oVar.t(), oVar.A(), i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r4 != 44) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r3.f12491y.h() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if ((r3.f5456a & g3.f.f13602m0) == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        r3.f12483q--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        return c3.n.VALUE_NULL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
    
        if (r3.f12491y.f() == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n X1(int i10) {
        if (i10 != 39) {
            if (i10 == 73) {
                c2("Infinity", 1);
                if ((this.f5456a & f13601l0) != 0) {
                    return K1("Infinity", Double.POSITIVE_INFINITY);
                }
                L0("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i10 == 78) {
                c2("NaN", 1);
                if ((this.f5456a & f13601l0) != 0) {
                    return K1("NaN", Double.NaN);
                }
                L0("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i10 != 93) {
                if (i10 == 43) {
                    if (this.f12483q >= this.f12484r && !Y1()) {
                        R0(n.VALUE_NUMBER_INT);
                    }
                    char[] cArr = this.V;
                    int i11 = this.f12483q;
                    this.f12483q = i11 + 1;
                    return U1(cArr[i11], false);
                }
            }
        } else if ((this.f5456a & f13603n0) != 0) {
            return T1();
        }
        if (Character.isJavaIdentifierStart(i10)) {
            r2("" + ((char) i10), z1());
        }
        T0(i10, "expected a valid value " + A1());
        return null;
    }

    @Override // d3.c, c3.k
    public final String Y() {
        n nVar = this.f12503c;
        if (nVar != n.VALUE_STRING) {
            return S1(nVar);
        }
        if (this.f13608f0) {
            this.f13608f0 = false;
            Q1();
        }
        return this.A.l();
    }

    public boolean Y1() {
        Reader reader = this.S;
        if (reader != null) {
            char[] cArr = this.V;
            int read = reader.read(cArr, 0, cArr.length);
            if (read > 0) {
                int i10 = this.f12484r;
                long j10 = i10;
                this.f12485s += j10;
                this.f12487u -= i10;
                this.f13609g0 -= j10;
                this.f12483q = 0;
                this.f12484r = read;
                return true;
            }
            j1();
            if (read == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.f12484r);
            }
        }
        return false;
    }

    @Override // c3.k
    public final char[] Z() {
        n nVar = this.f12503c;
        if (nVar == null) {
            return null;
        }
        int c10 = nVar.c();
        if (c10 != 5) {
            if (c10 != 6) {
                if (c10 != 7 && c10 != 8) {
                    return this.f12503c.a();
                }
            } else if (this.f13608f0) {
                this.f13608f0 = false;
                Q1();
            }
            return this.A.s();
        }
        if (!this.C) {
            String b10 = this.f12491y.b();
            int length = b10.length();
            char[] cArr = this.B;
            if (cArr == null) {
                this.B = this.f12481o.f(length);
            } else if (cArr.length < length) {
                this.B = new char[length];
            }
            b10.getChars(0, length, this.B, 0);
            this.C = true;
        }
        return this.B;
    }

    @Override // d3.c
    public final String Z0(String str) {
        n nVar = this.f12503c;
        if (nVar != n.VALUE_STRING) {
            return nVar == n.FIELD_NAME ? E() : super.Z0(str);
        }
        if (this.f13608f0) {
            this.f13608f0 = false;
            Q1();
        }
        return this.A.l();
    }

    public void Z1() {
        if (Y1()) {
            return;
        }
        P0();
    }

    @Override // c3.k
    public final int a0() {
        n nVar = this.f12503c;
        if (nVar == null) {
            return 0;
        }
        int c10 = nVar.c();
        if (c10 == 5) {
            return this.f12491y.b().length();
        }
        if (c10 != 6) {
            if (c10 != 7 && c10 != 8) {
                return this.f12503c.a().length;
            }
        } else if (this.f13608f0) {
            this.f13608f0 = false;
            Q1();
        }
        return this.A.A();
    }

    public final void a2() {
        int i10;
        char c10;
        int i11 = this.f12483q;
        if (i11 + 4 < this.f12484r) {
            char[] cArr = this.V;
            if (cArr[i11] == 'a') {
                int i12 = i11 + 1;
                if (cArr[i12] == 'l') {
                    int i13 = i12 + 1;
                    if (cArr[i13] == 's') {
                        int i14 = i13 + 1;
                        if (cArr[i14] == 'e' && ((c10 = cArr[(i10 = i14 + 1)]) < '0' || c10 == ']' || c10 == '}')) {
                            this.f12483q = i10;
                            return;
                        }
                    }
                }
            }
        }
        c2("false", 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // c3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b0() {
        n nVar = this.f12503c;
        if (nVar != null) {
            int c10 = nVar.c();
            if (c10 != 6) {
                if (c10 != 7) {
                }
            } else if (this.f13608f0) {
                this.f13608f0 = false;
                Q1();
            }
            return this.A.t();
        }
        return 0;
    }

    public final void b2() {
        int i10;
        char c10;
        int i11 = this.f12483q;
        if (i11 + 3 < this.f12484r) {
            char[] cArr = this.V;
            if (cArr[i11] == 'u') {
                int i12 = i11 + 1;
                if (cArr[i12] == 'l') {
                    int i13 = i12 + 1;
                    if (cArr[i13] == 'l' && ((c10 = cArr[(i10 = i13 + 1)]) < '0' || c10 == ']' || c10 == '}')) {
                        this.f12483q = i10;
                        return;
                    }
                }
            }
        }
        c2("null", 1);
    }

    @Override // c3.k
    public c3.i c0() {
        if (this.f12503c != n.FIELD_NAME) {
            return new c3.i(o1(), -1L, this.f12488v - 1, this.f12489w, this.f12490x);
        }
        return new c3.i(o1(), -1L, this.f12485s + (this.f13609g0 - 1), this.f13610h0, this.f13611i0);
    }

    public final void c2(String str, int i10) {
        int i11;
        int length = str.length();
        if (this.f12483q + length >= this.f12484r) {
            d2(str, i10);
            return;
        }
        do {
            if (this.V[this.f12483q] != str.charAt(i10)) {
                q2(str.substring(0, i10));
            }
            i11 = this.f12483q + 1;
            this.f12483q = i11;
            i10++;
        } while (i10 < length);
        char c10 = this.V[i11];
        if (c10 < '0' || c10 == ']' || c10 == '}') {
            return;
        }
        N1(str, i10, c10);
    }

    public final void d2(String str, int i10) {
        int i11;
        char c10;
        int length = str.length();
        do {
            if ((this.f12483q >= this.f12484r && !Y1()) || this.V[this.f12483q] != str.charAt(i10)) {
                q2(str.substring(0, i10));
            }
            i11 = this.f12483q + 1;
            this.f12483q = i11;
            i10++;
        } while (i10 < length);
        if ((i11 < this.f12484r || Y1()) && (c10 = this.V[this.f12483q]) >= '0' && c10 != ']' && c10 != '}') {
            N1(str, i10, c10);
        }
    }

    public final void e2() {
        int i10;
        char c10;
        int i11 = this.f12483q;
        if (i11 + 3 < this.f12484r) {
            char[] cArr = this.V;
            if (cArr[i11] == 'r') {
                int i12 = i11 + 1;
                if (cArr[i12] == 'u') {
                    int i13 = i12 + 1;
                    if (cArr[i13] == 'e' && ((c10 = cArr[(i10 = i13 + 1)]) < '0' || c10 == ']' || c10 == '}')) {
                        this.f12483q = i10;
                        return;
                    }
                }
            }
        }
        c2("true", 1);
    }

    public final n f2() {
        this.C = false;
        n nVar = this.f12492z;
        this.f12492z = null;
        if (nVar == n.START_ARRAY) {
            this.f12491y = this.f12491y.m(this.f12489w, this.f12490x);
        } else if (nVar == n.START_OBJECT) {
            this.f12491y = this.f12491y.n(this.f12489w, this.f12490x);
        }
        this.f12503c = nVar;
        return nVar;
    }

    @Override // d3.c, c3.k
    public final String g0() {
        n nVar = this.f12503c;
        if (nVar != n.VALUE_STRING) {
            return nVar == n.FIELD_NAME ? E() : super.Z0(null);
        }
        if (this.f13608f0) {
            this.f13608f0 = false;
            Q1();
        }
        return this.A.l();
    }

    public final n g2(int i10) {
        if (i10 == 34) {
            this.f13608f0 = true;
            n nVar = n.VALUE_STRING;
            this.f12503c = nVar;
            return nVar;
        }
        if (i10 == 91) {
            this.f12491y = this.f12491y.m(this.f12489w, this.f12490x);
            n nVar2 = n.START_ARRAY;
            this.f12503c = nVar2;
            return nVar2;
        }
        if (i10 == 102) {
            c2("false", 1);
            n nVar3 = n.VALUE_FALSE;
            this.f12503c = nVar3;
            return nVar3;
        }
        if (i10 == 110) {
            c2("null", 1);
            n nVar4 = n.VALUE_NULL;
            this.f12503c = nVar4;
            return nVar4;
        }
        if (i10 == 116) {
            c2("true", 1);
            n nVar5 = n.VALUE_TRUE;
            this.f12503c = nVar5;
            return nVar5;
        }
        if (i10 == 123) {
            this.f12491y = this.f12491y.n(this.f12489w, this.f12490x);
            n nVar6 = n.START_OBJECT;
            this.f12503c = nVar6;
            return nVar6;
        }
        switch (i10) {
            case 44:
                if (!this.f12491y.h() && (this.f5456a & f13602m0) != 0) {
                    this.f12483q--;
                    n nVar7 = n.VALUE_NULL;
                    this.f12503c = nVar7;
                    return nVar7;
                }
                break;
            case 45:
                n m22 = m2();
                this.f12503c = m22;
                return m22;
            case 46:
                n j22 = j2();
                this.f12503c = j22;
                return j22;
            default:
                switch (i10) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        n o22 = o2(i10);
                        this.f12503c = o22;
                        return o22;
                }
        }
        n X1 = X1(i10);
        this.f12503c = X1;
        return X1;
    }

    public String h2() {
        int i10 = this.f12483q;
        int i11 = this.Z;
        int i12 = this.f12484r;
        if (i10 < i12) {
            int[] iArr = f13607r0;
            int length = iArr.length;
            do {
                char[] cArr = this.V;
                char c10 = cArr[i10];
                if (c10 != '\'') {
                    if (c10 < length && iArr[c10] != 0) {
                        break;
                    }
                    i11 = (i11 * 33) + c10;
                    i10++;
                } else {
                    int i13 = this.f12483q;
                    this.f12483q = i10 + 1;
                    return this.Y.k(cArr, i13, i10 - i13, i11);
                }
            } while (i10 < i12);
        }
        int i14 = this.f12483q;
        this.f12483q = i10;
        return l2(i14, i11, 39);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v18 ??, r9v12 ??, r9v5 ??, r9v3 ??, r9v9 ??, r9v7 ??, r9v10 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x006e -> B:32:0x0050). Please report as a decompilation issue!!! */
    public final c3.n i2(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v18 ??, r9v12 ??, r9v5 ??, r9v3 ??, r9v9 ??, r9v7 ??, r9v10 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    @Override // d3.b
    public void j1() {
        if (this.S != null) {
            if (this.f12481o.k() || l0(k.a.AUTO_CLOSE_SOURCE)) {
                this.S.close();
            }
            this.S = null;
        }
    }

    public final n j2() {
        if (!l0(d.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.c())) {
            return X1(46);
        }
        int i10 = this.f12483q;
        return i2(46, i10 - 1, i10, false, 0);
    }

    public final String k2() {
        int i10 = this.f12483q;
        int i11 = this.Z;
        int[] iArr = f13607r0;
        while (true) {
            if (i10 >= this.f12484r) {
                break;
            }
            char[] cArr = this.V;
            char c10 = cArr[i10];
            if (c10 >= iArr.length || iArr[c10] == 0) {
                i11 = (i11 * 33) + c10;
                i10++;
            } else if (c10 == '\"') {
                int i12 = this.f12483q;
                this.f12483q = i10 + 1;
                return this.Y.k(cArr, i12, i10 - i12, i11);
            }
        }
        int i13 = this.f12483q;
        this.f12483q = i10;
        return l2(i13, i11, 34);
    }

    @Override // d3.b
    public char l1() {
        if (this.f12483q >= this.f12484r && !Y1()) {
            Q0(" in character escape sequence", n.VALUE_STRING);
        }
        char[] cArr = this.V;
        int i10 = this.f12483q;
        this.f12483q = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == '\"' || c10 == '/' || c10 == '\\') {
            return c10;
        }
        if (c10 == 'b') {
            return '\b';
        }
        if (c10 == 'f') {
            return '\f';
        }
        if (c10 == 'n') {
            return '\n';
        }
        if (c10 == 'r') {
            return ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN;
        }
        if (c10 == 't') {
            return '\t';
        }
        if (c10 != 'u') {
            return q1(c10);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                Q0(" in character escape sequence", n.VALUE_STRING);
            }
            char[] cArr2 = this.V;
            int i13 = this.f12483q;
            this.f12483q = i13 + 1;
            char c11 = cArr2[i13];
            int b10 = f3.a.b(c11);
            if (b10 < 0) {
                T0(c11, "expected a hex-digit for character escape sequence");
            }
            i11 = (i11 << 4) | b10;
        }
        return (char) i11;
    }

    public final String l2(int i10, int i11, int i12) {
        this.A.w(this.V, i10, this.f12483q - i10);
        char[] q10 = this.A.q();
        int r10 = this.A.r();
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                Q0(" in field name", n.FIELD_NAME);
            }
            char[] cArr = this.V;
            int i13 = this.f12483q;
            this.f12483q = i13 + 1;
            char c10 = cArr[i13];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    c10 = l1();
                } else if (c10 <= i12) {
                    if (c10 == i12) {
                        this.A.z(r10);
                        j3.o oVar = this.A;
                        return this.Y.k(oVar.s(), oVar.t(), oVar.A(), i11);
                    }
                    if (c10 < ' ') {
                        y1(c10, "name");
                    }
                }
            }
            i11 = (i11 * 33) + c10;
            int i14 = r10 + 1;
            q10[r10] = c10;
            if (i14 >= q10.length) {
                q10 = this.A.o();
                r10 = 0;
            } else {
                r10 = i14;
            }
        }
    }

    public final n m2() {
        int i10 = this.f12483q;
        int i11 = i10 - 1;
        int i12 = this.f12484r;
        if (i10 >= i12) {
            return n2(true, i11);
        }
        int i13 = i10 + 1;
        char c10 = this.V[i10];
        if (c10 > '9' || c10 < '0') {
            this.f12483q = i13;
            return U1(c10, true);
        }
        if (c10 == '0') {
            return n2(true, i11);
        }
        int i14 = 1;
        while (i13 < i12) {
            int i15 = i13 + 1;
            char c11 = this.V[i13];
            if (c11 < '0' || c11 > '9') {
                if (c11 == '.' || c11 == 'e' || c11 == 'E') {
                    this.f12483q = i15;
                    return i2(c11, i11, i15, true, i14);
                }
                int i16 = i15 - 1;
                this.f12483q = i16;
                if (this.f12491y.h()) {
                    I2(c11);
                }
                this.A.w(this.V, i11, i16 - i11);
                return M1(true, i14);
            }
            i14++;
            i13 = i15;
        }
        return n2(true, i11);
    }

    public final n n2(boolean z10, int i10) {
        int i11;
        char K2;
        boolean z11;
        int i12;
        char J2;
        if (z10) {
            i10++;
        }
        this.f12483q = i10;
        char[] m10 = this.A.m();
        int i13 = 0;
        if (z10) {
            m10[0] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i14 = this.f12483q;
        if (i14 < this.f12484r) {
            char[] cArr = this.V;
            this.f12483q = i14 + 1;
            K2 = cArr[i14];
        } else {
            K2 = K2("No digit following minus sign", n.VALUE_NUMBER_INT);
        }
        if (K2 == '0') {
            K2 = H2();
        }
        int i15 = 0;
        while (K2 >= '0' && K2 <= '9') {
            i15++;
            if (i11 >= m10.length) {
                m10 = this.A.o();
                i11 = 0;
            }
            int i16 = i11 + 1;
            m10[i11] = K2;
            if (this.f12483q >= this.f12484r && !Y1()) {
                i11 = i16;
                K2 = 0;
                z11 = true;
                break;
            }
            char[] cArr2 = this.V;
            int i17 = this.f12483q;
            this.f12483q = i17 + 1;
            K2 = cArr2[i17];
            i11 = i16;
        }
        z11 = false;
        if (i15 == 0) {
            return U1(K2, z10);
        }
        if (K2 == '.') {
            if (i11 >= m10.length) {
                m10 = this.A.o();
                i11 = 0;
            }
            m10[i11] = K2;
            i11++;
            i12 = 0;
            while (true) {
                if (this.f12483q >= this.f12484r && !Y1()) {
                    z11 = true;
                    break;
                }
                char[] cArr3 = this.V;
                int i18 = this.f12483q;
                this.f12483q = i18 + 1;
                K2 = cArr3[i18];
                if (K2 < '0' || K2 > '9') {
                    break;
                }
                i12++;
                if (i11 >= m10.length) {
                    m10 = this.A.o();
                    i11 = 0;
                }
                m10[i11] = K2;
                i11++;
            }
            if (i12 == 0) {
                h1(K2, "Decimal point not followed by a digit");
            }
        } else {
            i12 = 0;
        }
        if (K2 == 'e' || K2 == 'E') {
            if (i11 >= m10.length) {
                m10 = this.A.o();
                i11 = 0;
            }
            int i19 = i11 + 1;
            m10[i11] = K2;
            int i20 = this.f12483q;
            if (i20 < this.f12484r) {
                char[] cArr4 = this.V;
                this.f12483q = i20 + 1;
                J2 = cArr4[i20];
            } else {
                J2 = J2("expected a digit for number exponent");
            }
            if (J2 == '-' || J2 == '+') {
                if (i19 >= m10.length) {
                    m10 = this.A.o();
                    i19 = 0;
                }
                int i21 = i19 + 1;
                m10[i19] = J2;
                int i22 = this.f12483q;
                if (i22 < this.f12484r) {
                    char[] cArr5 = this.V;
                    this.f12483q = i22 + 1;
                    J2 = cArr5[i22];
                } else {
                    J2 = J2("expected a digit for number exponent");
                }
                i19 = i21;
            }
            K2 = J2;
            int i23 = 0;
            while (K2 <= '9' && K2 >= '0') {
                i23++;
                if (i19 >= m10.length) {
                    m10 = this.A.o();
                    i19 = 0;
                }
                i11 = i19 + 1;
                m10[i19] = K2;
                if (this.f12483q >= this.f12484r && !Y1()) {
                    i13 = i23;
                    z11 = true;
                    break;
                }
                char[] cArr6 = this.V;
                int i24 = this.f12483q;
                this.f12483q = i24 + 1;
                K2 = cArr6[i24];
                i19 = i11;
            }
            i13 = i23;
            i11 = i19;
            if (i13 == 0) {
                h1(K2, "Exponent indicator not followed by a digit");
            }
        }
        if (!z11) {
            this.f12483q--;
            if (this.f12491y.h()) {
                I2(K2);
            }
        }
        this.A.z(i11);
        return J1(z10, i15, i12, i13);
    }

    public final n o2(int i10) {
        int i11 = this.f12483q;
        int i12 = i11 - 1;
        int i13 = this.f12484r;
        if (i10 == 48) {
            return n2(false, i12);
        }
        int i14 = 1;
        while (i11 < i13) {
            int i15 = i11 + 1;
            char c10 = this.V[i11];
            if (c10 < '0' || c10 > '9') {
                if (c10 == '.' || c10 == 'e' || c10 == 'E') {
                    this.f12483q = i15;
                    return i2(c10, i12, i15, false, i14);
                }
                int i16 = i15 - 1;
                this.f12483q = i16;
                if (this.f12491y.h()) {
                    I2(c10);
                }
                this.A.w(this.V, i12, i16 - i12);
                return M1(false, i14);
            }
            i14++;
            i11 = i15;
        }
        this.f12483q = i12;
        return n2(false, i12);
    }

    public int p2(c3.a aVar, OutputStream outputStream, byte[] bArr) {
        int i10 = 3;
        int length = bArr.length - 3;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (this.f12483q >= this.f12484r) {
                Z1();
            }
            char[] cArr = this.V;
            int i13 = this.f12483q;
            this.f12483q = i13 + 1;
            char c10 = cArr[i13];
            if (c10 > ' ') {
                int g10 = aVar.g(c10);
                if (g10 < 0) {
                    if (c10 == '\"') {
                        break;
                    }
                    g10 = k1(aVar, c10, 0);
                    if (g10 < 0) {
                    }
                }
                if (i11 > length) {
                    i12 += i11;
                    outputStream.write(bArr, 0, i11);
                    i11 = 0;
                }
                if (this.f12483q >= this.f12484r) {
                    Z1();
                }
                char[] cArr2 = this.V;
                int i14 = this.f12483q;
                this.f12483q = i14 + 1;
                char c11 = cArr2[i14];
                int g11 = aVar.g(c11);
                if (g11 < 0) {
                    g11 = k1(aVar, c11, 1);
                }
                int i15 = (g10 << 6) | g11;
                if (this.f12483q >= this.f12484r) {
                    Z1();
                }
                char[] cArr3 = this.V;
                int i16 = this.f12483q;
                this.f12483q = i16 + 1;
                char c12 = cArr3[i16];
                int g12 = aVar.g(c12);
                if (g12 < 0) {
                    if (g12 != -2) {
                        if (c12 == '\"') {
                            int i17 = i11 + 1;
                            bArr[i11] = (byte) (i15 >> 4);
                            if (aVar.v()) {
                                this.f12483q--;
                                p1(aVar);
                            }
                            i11 = i17;
                        } else {
                            g12 = k1(aVar, c12, 2);
                        }
                    }
                    if (g12 == -2) {
                        if (this.f12483q >= this.f12484r) {
                            Z1();
                        }
                        char[] cArr4 = this.V;
                        int i18 = this.f12483q;
                        this.f12483q = i18 + 1;
                        char c13 = cArr4[i18];
                        if (!aVar.w(c13) && k1(aVar, c13, i10) != -2) {
                            throw I1(aVar, c13, i10, "expected padding character '" + aVar.r() + "'");
                        }
                        bArr[i11] = (byte) (i15 >> 4);
                        i11++;
                    }
                }
                int i19 = (i15 << 6) | g12;
                if (this.f12483q >= this.f12484r) {
                    Z1();
                }
                char[] cArr5 = this.V;
                int i20 = this.f12483q;
                this.f12483q = i20 + 1;
                char c14 = cArr5[i20];
                int g13 = aVar.g(c14);
                if (g13 < 0) {
                    if (g13 != -2) {
                        if (c14 == '\"') {
                            int i21 = i19 >> 2;
                            int i22 = i11 + 1;
                            bArr[i11] = (byte) (i21 >> 8);
                            i11 = i22 + 1;
                            bArr[i22] = (byte) i21;
                            if (aVar.v()) {
                                this.f12483q--;
                                p1(aVar);
                            }
                        } else {
                            g13 = k1(aVar, c14, 3);
                        }
                    }
                    if (g13 == -2) {
                        int i23 = i19 >> 2;
                        int i24 = i11 + 1;
                        bArr[i11] = (byte) (i23 >> 8);
                        i11 = i24 + 1;
                        bArr[i24] = (byte) i23;
                        i10 = 3;
                    }
                }
                int i25 = (i19 << 6) | g13;
                int i26 = i11 + 1;
                bArr[i11] = (byte) (i25 >> 16);
                int i27 = i26 + 1;
                bArr[i26] = (byte) (i25 >> 8);
                bArr[i27] = (byte) i25;
                i11 = i27 + 1;
                i10 = 3;
            }
            i10 = 3;
        }
        this.f13608f0 = false;
        if (i11 <= 0) {
            return i12;
        }
        int i28 = i12 + i11;
        outputStream.write(bArr, 0, i11);
        return i28;
    }

    @Override // c3.k
    public String q0() {
        n m22;
        this.F = 0;
        n nVar = this.f12503c;
        n nVar2 = n.FIELD_NAME;
        if (nVar == nVar2) {
            f2();
            return null;
        }
        if (this.f13608f0) {
            A2();
        }
        int B2 = B2();
        if (B2 < 0) {
            close();
            this.f12503c = null;
            return null;
        }
        this.E = null;
        if (B2 == 93 || B2 == 125) {
            O1(B2);
            return null;
        }
        if (this.f12491y.p()) {
            B2 = x2(B2);
            if ((this.f5456a & f13599j0) != 0 && (B2 == 93 || B2 == 125)) {
                O1(B2);
                return null;
            }
        }
        if (!this.f12491y.g()) {
            E2();
            g2(B2);
            return null;
        }
        F2();
        String k22 = B2 == 34 ? k2() : V1(B2);
        this.f12491y.u(k22);
        this.f12503c = nVar2;
        int v22 = v2();
        E2();
        if (v22 == 34) {
            this.f13608f0 = true;
            this.f12492z = n.VALUE_STRING;
            return k22;
        }
        if (v22 == 45) {
            m22 = m2();
        } else if (v22 == 46) {
            m22 = j2();
        } else if (v22 == 91) {
            m22 = n.START_ARRAY;
        } else if (v22 == 102) {
            a2();
            m22 = n.VALUE_FALSE;
        } else if (v22 == 110) {
            b2();
            m22 = n.VALUE_NULL;
        } else if (v22 == 116) {
            e2();
            m22 = n.VALUE_TRUE;
        } else if (v22 != 123) {
            switch (v22) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    m22 = o2(v22);
                    break;
                default:
                    m22 = X1(v22);
                    break;
            }
        } else {
            m22 = n.START_OBJECT;
        }
        this.f12492z = m22;
        return k22;
    }

    public void q2(String str) {
        r2(str, z1());
    }

    @Override // c3.k
    public final String r0() {
        if (this.f12503c != n.FIELD_NAME) {
            if (s0() == n.VALUE_STRING) {
                return Y();
            }
            return null;
        }
        this.C = false;
        n nVar = this.f12492z;
        this.f12492z = null;
        this.f12503c = nVar;
        if (nVar == n.VALUE_STRING) {
            if (this.f13608f0) {
                this.f13608f0 = false;
                Q1();
            }
            return this.A.l();
        }
        if (nVar == n.START_ARRAY) {
            this.f12491y = this.f12491y.m(this.f12489w, this.f12490x);
        } else if (nVar == n.START_OBJECT) {
            this.f12491y = this.f12491y.n(this.f12489w, this.f12490x);
        }
        return null;
    }

    public void r2(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                break;
            }
            char c10 = this.V[this.f12483q];
            if (!Character.isJavaIdentifierPart(c10)) {
                break;
            }
            this.f12483q++;
            sb.append(c10);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        N0("Unrecognized token '%s': was expecting %s", sb, str2);
    }

    @Override // d3.c, c3.k
    public final n s0() {
        n nVar;
        n nVar2 = this.f12503c;
        n nVar3 = n.FIELD_NAME;
        if (nVar2 == nVar3) {
            return f2();
        }
        this.F = 0;
        if (this.f13608f0) {
            A2();
        }
        int B2 = B2();
        if (B2 < 0) {
            close();
            this.f12503c = null;
            return null;
        }
        this.E = null;
        if (B2 == 93 || B2 == 125) {
            O1(B2);
            return this.f12503c;
        }
        if (this.f12491y.p()) {
            B2 = x2(B2);
            if ((this.f5456a & f13599j0) != 0 && (B2 == 93 || B2 == 125)) {
                O1(B2);
                return this.f12503c;
            }
        }
        boolean g10 = this.f12491y.g();
        if (g10) {
            F2();
            this.f12491y.u(B2 == 34 ? k2() : V1(B2));
            this.f12503c = nVar3;
            B2 = v2();
        }
        E2();
        if (B2 == 34) {
            this.f13608f0 = true;
            nVar = n.VALUE_STRING;
        } else if (B2 == 91) {
            if (!g10) {
                this.f12491y = this.f12491y.m(this.f12489w, this.f12490x);
            }
            nVar = n.START_ARRAY;
        } else if (B2 == 102) {
            a2();
            nVar = n.VALUE_FALSE;
        } else if (B2 != 110) {
            if (B2 != 116) {
                if (B2 == 123) {
                    if (!g10) {
                        this.f12491y = this.f12491y.n(this.f12489w, this.f12490x);
                    }
                    nVar = n.START_OBJECT;
                } else if (B2 == 125) {
                    T0(B2, "expected a value");
                } else if (B2 == 45) {
                    nVar = m2();
                } else if (B2 != 46) {
                    switch (B2) {
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            nVar = o2(B2);
                            break;
                        default:
                            nVar = X1(B2);
                            break;
                    }
                } else {
                    nVar = j2();
                }
            }
            e2();
            nVar = n.VALUE_TRUE;
        } else {
            b2();
            nVar = n.VALUE_NULL;
        }
        if (g10) {
            this.f12492z = nVar;
            return this.f12503c;
        }
        this.f12503c = nVar;
        return nVar;
    }

    public final int s2() {
        char c10;
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                throw b("Unexpected end-of-input within/between " + this.f12491y.j() + " entries");
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            int i11 = i10 + 1;
            this.f12483q = i11;
            c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    y2();
                } else if (c10 != '#' || !D2()) {
                    break;
                }
            } else if (c10 < ' ') {
                if (c10 == '\n') {
                    this.f12486t++;
                    this.f12487u = i11;
                } else if (c10 == '\r') {
                    u2();
                } else if (c10 != '\t') {
                    V0(c10);
                }
            }
        }
        return c10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
    
        Q0(" in a comment", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t2() {
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                break;
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            int i11 = i10 + 1;
            this.f12483q = i11;
            char c10 = cArr[i10];
            if (c10 <= '*') {
                if (c10 == '*') {
                    if (i11 >= this.f12484r && !Y1()) {
                        break;
                    }
                    char[] cArr2 = this.V;
                    int i12 = this.f12483q;
                    if (cArr2[i12] == '/') {
                        this.f12483q = i12 + 1;
                        return;
                    }
                } else if (c10 < ' ') {
                    if (c10 == '\n') {
                        this.f12486t++;
                        this.f12487u = i11;
                    } else if (c10 == '\r') {
                        u2();
                    } else if (c10 != '\t') {
                        V0(c10);
                    }
                }
            }
        }
    }

    public final void u2() {
        if (this.f12483q < this.f12484r || Y1()) {
            char[] cArr = this.V;
            int i10 = this.f12483q;
            if (cArr[i10] == '\n') {
                this.f12483q = i10 + 1;
            }
        }
        this.f12486t++;
        this.f12487u = this.f12483q;
    }

    @Override // c3.k
    public byte[] v(c3.a aVar) {
        byte[] bArr;
        n nVar = this.f12503c;
        if (nVar == n.VALUE_EMBEDDED_OBJECT && (bArr = this.E) != null) {
            return bArr;
        }
        if (nVar != n.VALUE_STRING) {
            L0("Current token (" + this.f12503c + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.f13608f0) {
            try {
                this.E = P1(aVar);
                this.f13608f0 = false;
            } catch (IllegalArgumentException e10) {
                throw b("Failed to decode VALUE_STRING as base64 (" + aVar + "): " + e10.getMessage());
            }
        } else if (this.E == null) {
            j3.c n12 = n1();
            F0(Y(), n12, aVar);
            this.E = n12.v();
        }
        return this.E;
    }

    @Override // d3.b
    public void v1() {
        char[] cArr;
        super.v1();
        this.Y.q();
        if (!this.W || (cArr = this.V) == null) {
            return;
        }
        this.V = null;
        this.f12481o.o(cArr);
    }

    public final int v2() {
        int i10 = this.f12483q;
        if (i10 + 4 >= this.f12484r) {
            return w2(false);
        }
        char[] cArr = this.V;
        char c10 = cArr[i10];
        if (c10 == ':') {
            int i11 = i10 + 1;
            this.f12483q = i11;
            char c11 = cArr[i11];
            if (c11 > ' ') {
                if (c11 == '/' || c11 == '#') {
                    return w2(true);
                }
                this.f12483q = i11 + 1;
                return c11;
            }
            if (c11 == ' ' || c11 == '\t') {
                int i12 = i11 + 1;
                this.f12483q = i12;
                char c12 = cArr[i12];
                if (c12 > ' ') {
                    if (c12 == '/' || c12 == '#') {
                        return w2(true);
                    }
                    this.f12483q = i12 + 1;
                    return c12;
                }
            }
            return w2(true);
        }
        if (c10 == ' ' || c10 == '\t') {
            int i13 = i10 + 1;
            this.f12483q = i13;
            c10 = cArr[i13];
        }
        if (c10 != ':') {
            return w2(false);
        }
        int i14 = this.f12483q + 1;
        this.f12483q = i14;
        char c13 = cArr[i14];
        if (c13 > ' ') {
            if (c13 == '/' || c13 == '#') {
                return w2(true);
            }
            this.f12483q = i14 + 1;
            return c13;
        }
        if (c13 == ' ' || c13 == '\t') {
            int i15 = i14 + 1;
            this.f12483q = i15;
            char c14 = cArr[i15];
            if (c14 > ' ') {
                if (c14 == '/' || c14 == '#') {
                    return w2(true);
                }
                this.f12483q = i15 + 1;
                return c14;
            }
        }
        return w2(true);
    }

    @Override // c3.k
    public int w0(c3.a aVar, OutputStream outputStream) {
        if (!this.f13608f0 || this.f12503c != n.VALUE_STRING) {
            byte[] v10 = v(aVar);
            outputStream.write(v10);
            return v10.length;
        }
        byte[] d10 = this.f12481o.d();
        try {
            return p2(aVar, outputStream, d10);
        } finally {
            this.f12481o.l(d10);
        }
    }

    public final int w2(boolean z10) {
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                Q0(" within/between " + this.f12491y.j() + " entries", null);
                return -1;
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            int i11 = i10 + 1;
            this.f12483q = i11;
            char c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    y2();
                } else if (c10 != '#' || !D2()) {
                    if (z10) {
                        return c10;
                    }
                    if (c10 != ':') {
                        T0(c10, "was expecting a colon to separate field name and value");
                    }
                    z10 = true;
                }
            } else if (c10 < ' ') {
                if (c10 == '\n') {
                    this.f12486t++;
                    this.f12487u = i11;
                } else if (c10 == '\r') {
                    u2();
                } else if (c10 != '\t') {
                    V0(c10);
                }
            }
        }
    }

    public final int x2(int i10) {
        if (i10 != 44) {
            T0(i10, "was expecting comma to separate " + this.f12491y.j() + " entries");
        }
        while (true) {
            int i11 = this.f12483q;
            if (i11 >= this.f12484r) {
                return s2();
            }
            char[] cArr = this.V;
            int i12 = i11 + 1;
            this.f12483q = i12;
            char c10 = cArr[i11];
            if (c10 > ' ') {
                if (c10 != '/' && c10 != '#') {
                    return c10;
                }
                this.f12483q = i12 - 1;
                return s2();
            }
            if (c10 < ' ') {
                if (c10 == '\n') {
                    this.f12486t++;
                    this.f12487u = i12;
                } else if (c10 == '\r') {
                    u2();
                } else if (c10 != '\t') {
                    V0(c10);
                }
            }
        }
    }

    @Override // c3.k
    public o y() {
        return this.X;
    }

    public final void y2() {
        if ((this.f5456a & f13605p0) == 0) {
            T0(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f12483q >= this.f12484r && !Y1()) {
            Q0(" in a comment", null);
        }
        char[] cArr = this.V;
        int i10 = this.f12483q;
        this.f12483q = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == '/') {
            z2();
        } else if (c10 == '*') {
            t2();
        } else {
            T0(c10, "was expecting either '*' or '/' for a comment");
        }
    }

    @Override // c3.k
    public c3.i z() {
        return new c3.i(o1(), -1L, this.f12485s + this.f12483q, this.f12486t, (this.f12483q - this.f12487u) + 1);
    }

    public final void z2() {
        while (true) {
            if (this.f12483q >= this.f12484r && !Y1()) {
                return;
            }
            char[] cArr = this.V;
            int i10 = this.f12483q;
            int i11 = i10 + 1;
            this.f12483q = i11;
            char c10 = cArr[i10];
            if (c10 < ' ') {
                if (c10 == '\n') {
                    this.f12486t++;
                    this.f12487u = i11;
                    return;
                } else if (c10 == '\r') {
                    u2();
                    return;
                } else if (c10 != '\t') {
                    V0(c10);
                }
            }
        }
    }
}
