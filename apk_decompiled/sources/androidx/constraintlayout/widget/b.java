package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1923b = {0, 4, 8};

    /* renamed from: c, reason: collision with root package name */
    public static SparseIntArray f1924c;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1925a = new HashMap();

    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    public static class C0026b {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1926a;

        /* renamed from: a0, reason: collision with root package name */
        public float f1927a0;

        /* renamed from: b, reason: collision with root package name */
        public int f1928b;

        /* renamed from: b0, reason: collision with root package name */
        public float f1929b0;

        /* renamed from: c, reason: collision with root package name */
        public int f1930c;

        /* renamed from: c0, reason: collision with root package name */
        public float f1931c0;

        /* renamed from: d, reason: collision with root package name */
        public int f1932d;

        /* renamed from: d0, reason: collision with root package name */
        public float f1933d0;

        /* renamed from: e, reason: collision with root package name */
        public int f1934e;

        /* renamed from: e0, reason: collision with root package name */
        public float f1935e0;

        /* renamed from: f, reason: collision with root package name */
        public int f1936f;

        /* renamed from: f0, reason: collision with root package name */
        public float f1937f0;

        /* renamed from: g, reason: collision with root package name */
        public float f1938g;

        /* renamed from: g0, reason: collision with root package name */
        public float f1939g0;

        /* renamed from: h, reason: collision with root package name */
        public int f1940h;

        /* renamed from: h0, reason: collision with root package name */
        public boolean f1941h0;

        /* renamed from: i, reason: collision with root package name */
        public int f1942i;

        /* renamed from: i0, reason: collision with root package name */
        public boolean f1943i0;

        /* renamed from: j, reason: collision with root package name */
        public int f1944j;

        /* renamed from: j0, reason: collision with root package name */
        public int f1945j0;

        /* renamed from: k, reason: collision with root package name */
        public int f1946k;

        /* renamed from: k0, reason: collision with root package name */
        public int f1947k0;

        /* renamed from: l, reason: collision with root package name */
        public int f1948l;

        /* renamed from: l0, reason: collision with root package name */
        public int f1949l0;

        /* renamed from: m, reason: collision with root package name */
        public int f1950m;

        /* renamed from: m0, reason: collision with root package name */
        public int f1951m0;

        /* renamed from: n, reason: collision with root package name */
        public int f1952n;

        /* renamed from: n0, reason: collision with root package name */
        public int f1953n0;

        /* renamed from: o, reason: collision with root package name */
        public int f1954o;

        /* renamed from: o0, reason: collision with root package name */
        public int f1955o0;

        /* renamed from: p, reason: collision with root package name */
        public int f1956p;

        /* renamed from: p0, reason: collision with root package name */
        public float f1957p0;

        /* renamed from: q, reason: collision with root package name */
        public int f1958q;

        /* renamed from: q0, reason: collision with root package name */
        public float f1959q0;

        /* renamed from: r, reason: collision with root package name */
        public int f1960r;

        /* renamed from: r0, reason: collision with root package name */
        public boolean f1961r0;

        /* renamed from: s, reason: collision with root package name */
        public int f1962s;

        /* renamed from: s0, reason: collision with root package name */
        public int f1963s0;

        /* renamed from: t, reason: collision with root package name */
        public int f1964t;

        /* renamed from: t0, reason: collision with root package name */
        public int f1965t0;

        /* renamed from: u, reason: collision with root package name */
        public float f1966u;

        /* renamed from: u0, reason: collision with root package name */
        public int[] f1967u0;

        /* renamed from: v, reason: collision with root package name */
        public float f1968v;

        /* renamed from: v0, reason: collision with root package name */
        public String f1969v0;

        /* renamed from: w, reason: collision with root package name */
        public String f1970w;

        /* renamed from: x, reason: collision with root package name */
        public int f1971x;

        /* renamed from: y, reason: collision with root package name */
        public int f1972y;

        /* renamed from: z, reason: collision with root package name */
        public float f1973z;

        public C0026b() {
            this.f1926a = false;
            this.f1934e = -1;
            this.f1936f = -1;
            this.f1938g = -1.0f;
            this.f1940h = -1;
            this.f1942i = -1;
            this.f1944j = -1;
            this.f1946k = -1;
            this.f1948l = -1;
            this.f1950m = -1;
            this.f1952n = -1;
            this.f1954o = -1;
            this.f1956p = -1;
            this.f1958q = -1;
            this.f1960r = -1;
            this.f1962s = -1;
            this.f1964t = -1;
            this.f1966u = 0.5f;
            this.f1968v = 0.5f;
            this.f1970w = null;
            this.f1971x = -1;
            this.f1972y = 0;
            this.f1973z = 0.0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.f1927a0 = 1.0f;
            this.f1929b0 = 1.0f;
            this.f1931c0 = Float.NaN;
            this.f1933d0 = Float.NaN;
            this.f1935e0 = 0.0f;
            this.f1937f0 = 0.0f;
            this.f1939g0 = 0.0f;
            this.f1941h0 = false;
            this.f1943i0 = false;
            this.f1945j0 = 0;
            this.f1947k0 = 0;
            this.f1949l0 = -1;
            this.f1951m0 = -1;
            this.f1953n0 = -1;
            this.f1955o0 = -1;
            this.f1957p0 = 1.0f;
            this.f1959q0 = 1.0f;
            this.f1961r0 = false;
            this.f1963s0 = -1;
            this.f1965t0 = -1;
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.f1879d = this.f1940h;
            aVar.f1881e = this.f1942i;
            aVar.f1883f = this.f1944j;
            aVar.f1885g = this.f1946k;
            aVar.f1887h = this.f1948l;
            aVar.f1889i = this.f1950m;
            aVar.f1891j = this.f1952n;
            aVar.f1893k = this.f1954o;
            aVar.f1895l = this.f1956p;
            aVar.f1901p = this.f1958q;
            aVar.f1902q = this.f1960r;
            aVar.f1903r = this.f1962s;
            aVar.f1904s = this.f1964t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = this.D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = this.E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = this.F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = this.G;
            aVar.f1909x = this.P;
            aVar.f1910y = this.O;
            aVar.f1911z = this.f1966u;
            aVar.A = this.f1968v;
            aVar.f1897m = this.f1971x;
            aVar.f1899n = this.f1972y;
            aVar.f1900o = this.f1973z;
            aVar.B = this.f1970w;
            aVar.Q = this.A;
            aVar.R = this.B;
            aVar.F = this.Q;
            aVar.E = this.R;
            aVar.H = this.T;
            aVar.G = this.S;
            aVar.T = this.f1941h0;
            aVar.U = this.f1943i0;
            aVar.I = this.f1945j0;
            aVar.J = this.f1947k0;
            aVar.M = this.f1949l0;
            aVar.N = this.f1951m0;
            aVar.K = this.f1953n0;
            aVar.L = this.f1955o0;
            aVar.O = this.f1957p0;
            aVar.P = this.f1959q0;
            aVar.S = this.C;
            aVar.f1877c = this.f1938g;
            aVar.f1873a = this.f1934e;
            aVar.f1875b = this.f1936f;
            ((ViewGroup.MarginLayoutParams) aVar).width = this.f1928b;
            ((ViewGroup.MarginLayoutParams) aVar).height = this.f1930c;
            aVar.setMarginStart(this.I);
            aVar.setMarginEnd(this.H);
            aVar.a();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0026b clone() {
            C0026b c0026b = new C0026b();
            c0026b.f1926a = this.f1926a;
            c0026b.f1928b = this.f1928b;
            c0026b.f1930c = this.f1930c;
            c0026b.f1934e = this.f1934e;
            c0026b.f1936f = this.f1936f;
            c0026b.f1938g = this.f1938g;
            c0026b.f1940h = this.f1940h;
            c0026b.f1942i = this.f1942i;
            c0026b.f1944j = this.f1944j;
            c0026b.f1946k = this.f1946k;
            c0026b.f1948l = this.f1948l;
            c0026b.f1950m = this.f1950m;
            c0026b.f1952n = this.f1952n;
            c0026b.f1954o = this.f1954o;
            c0026b.f1956p = this.f1956p;
            c0026b.f1958q = this.f1958q;
            c0026b.f1960r = this.f1960r;
            c0026b.f1962s = this.f1962s;
            c0026b.f1964t = this.f1964t;
            c0026b.f1966u = this.f1966u;
            c0026b.f1968v = this.f1968v;
            c0026b.f1970w = this.f1970w;
            c0026b.A = this.A;
            c0026b.B = this.B;
            c0026b.f1966u = this.f1966u;
            c0026b.f1966u = this.f1966u;
            c0026b.f1966u = this.f1966u;
            c0026b.f1966u = this.f1966u;
            c0026b.f1966u = this.f1966u;
            c0026b.C = this.C;
            c0026b.D = this.D;
            c0026b.E = this.E;
            c0026b.F = this.F;
            c0026b.G = this.G;
            c0026b.H = this.H;
            c0026b.I = this.I;
            c0026b.J = this.J;
            c0026b.K = this.K;
            c0026b.L = this.L;
            c0026b.M = this.M;
            c0026b.N = this.N;
            c0026b.O = this.O;
            c0026b.P = this.P;
            c0026b.Q = this.Q;
            c0026b.R = this.R;
            c0026b.S = this.S;
            c0026b.T = this.T;
            c0026b.U = this.U;
            c0026b.V = this.V;
            c0026b.W = this.W;
            c0026b.X = this.X;
            c0026b.Y = this.Y;
            c0026b.Z = this.Z;
            c0026b.f1927a0 = this.f1927a0;
            c0026b.f1929b0 = this.f1929b0;
            c0026b.f1931c0 = this.f1931c0;
            c0026b.f1933d0 = this.f1933d0;
            c0026b.f1935e0 = this.f1935e0;
            c0026b.f1937f0 = this.f1937f0;
            c0026b.f1939g0 = this.f1939g0;
            c0026b.f1941h0 = this.f1941h0;
            c0026b.f1943i0 = this.f1943i0;
            c0026b.f1945j0 = this.f1945j0;
            c0026b.f1947k0 = this.f1947k0;
            c0026b.f1949l0 = this.f1949l0;
            c0026b.f1951m0 = this.f1951m0;
            c0026b.f1953n0 = this.f1953n0;
            c0026b.f1955o0 = this.f1955o0;
            c0026b.f1957p0 = this.f1957p0;
            c0026b.f1959q0 = this.f1959q0;
            c0026b.f1963s0 = this.f1963s0;
            c0026b.f1965t0 = this.f1965t0;
            int[] iArr = this.f1967u0;
            if (iArr != null) {
                c0026b.f1967u0 = Arrays.copyOf(iArr, iArr.length);
            }
            c0026b.f1971x = this.f1971x;
            c0026b.f1972y = this.f1972y;
            c0026b.f1973z = this.f1973z;
            c0026b.f1961r0 = this.f1961r0;
            return c0026b;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1924c = sparseIntArray;
        sparseIntArray.append(R$styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1924c.append(R$styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f1924c.append(R$styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f1924c.append(R$styleable.ConstraintSet_android_orientation, 27);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1924c.append(R$styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f1924c.append(R$styleable.ConstraintSet_layout_goneMarginTop, 16);
        f1924c.append(R$styleable.ConstraintSet_layout_goneMarginRight, 14);
        f1924c.append(R$styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f1924c.append(R$styleable.ConstraintSet_layout_goneMarginStart, 15);
        f1924c.append(R$styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintLeft_creator, 75);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintTop_creator, 75);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintRight_creator, 75);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintBottom_creator, 75);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
        f1924c.append(R$styleable.ConstraintSet_android_layout_marginLeft, 24);
        f1924c.append(R$styleable.ConstraintSet_android_layout_marginRight, 28);
        f1924c.append(R$styleable.ConstraintSet_android_layout_marginStart, 31);
        f1924c.append(R$styleable.ConstraintSet_android_layout_marginEnd, 8);
        f1924c.append(R$styleable.ConstraintSet_android_layout_marginTop, 34);
        f1924c.append(R$styleable.ConstraintSet_android_layout_marginBottom, 2);
        f1924c.append(R$styleable.ConstraintSet_android_layout_width, 23);
        f1924c.append(R$styleable.ConstraintSet_android_layout_height, 21);
        f1924c.append(R$styleable.ConstraintSet_android_visibility, 22);
        f1924c.append(R$styleable.ConstraintSet_android_alpha, 43);
        f1924c.append(R$styleable.ConstraintSet_android_elevation, 44);
        f1924c.append(R$styleable.ConstraintSet_android_rotationX, 45);
        f1924c.append(R$styleable.ConstraintSet_android_rotationY, 46);
        f1924c.append(R$styleable.ConstraintSet_android_rotation, 60);
        f1924c.append(R$styleable.ConstraintSet_android_scaleX, 47);
        f1924c.append(R$styleable.ConstraintSet_android_scaleY, 48);
        f1924c.append(R$styleable.ConstraintSet_android_transformPivotX, 49);
        f1924c.append(R$styleable.ConstraintSet_android_transformPivotY, 50);
        f1924c.append(R$styleable.ConstraintSet_android_translationX, 51);
        f1924c.append(R$styleable.ConstraintSet_android_translationY, 52);
        f1924c.append(R$styleable.ConstraintSet_android_translationZ, 53);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintCircle, 61);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f1924c.append(R$styleable.ConstraintSet_android_id, 38);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f1924c.append(R$styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f1924c.append(R$styleable.ConstraintSet_chainUseRtl, 71);
        f1924c.append(R$styleable.ConstraintSet_barrierDirection, 72);
        f1924c.append(R$styleable.ConstraintSet_constraint_referenced_ids, 73);
        f1924c.append(R$styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    public static int e(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1925a.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f1925a.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C0026b c0026b = (C0026b) this.f1925a.get(Integer.valueOf(id));
                if (childAt instanceof n.a) {
                    c0026b.f1965t0 = 1;
                }
                int i11 = c0026b.f1965t0;
                if (i11 != -1 && i11 == 1) {
                    n.a aVar = (n.a) childAt;
                    aVar.setId(id);
                    aVar.setType(c0026b.f1963s0);
                    aVar.setAllowsGoneWidget(c0026b.f1961r0);
                    int[] iArr = c0026b.f1967u0;
                    if (iArr != null) {
                        aVar.setReferencedIds(iArr);
                    } else {
                        String str = c0026b.f1969v0;
                        if (str != null) {
                            int[] b10 = b(aVar, str);
                            c0026b.f1967u0 = b10;
                            aVar.setReferencedIds(b10);
                        }
                    }
                }
                ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                c0026b.a(aVar2);
                childAt.setLayoutParams(aVar2);
                childAt.setVisibility(c0026b.J);
                int i12 = Build.VERSION.SDK_INT;
                childAt.setAlpha(c0026b.U);
                childAt.setRotation(c0026b.X);
                childAt.setRotationX(c0026b.Y);
                childAt.setRotationY(c0026b.Z);
                childAt.setScaleX(c0026b.f1927a0);
                childAt.setScaleY(c0026b.f1929b0);
                if (!Float.isNaN(c0026b.f1931c0)) {
                    childAt.setPivotX(c0026b.f1931c0);
                }
                if (!Float.isNaN(c0026b.f1933d0)) {
                    childAt.setPivotY(c0026b.f1933d0);
                }
                childAt.setTranslationX(c0026b.f1935e0);
                childAt.setTranslationY(c0026b.f1937f0);
                if (i12 >= 21) {
                    childAt.setTranslationZ(c0026b.f1939g0);
                    if (c0026b.V) {
                        childAt.setElevation(c0026b.W);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0026b c0026b2 = (C0026b) this.f1925a.get(num);
            int i13 = c0026b2.f1965t0;
            if (i13 != -1 && i13 == 1) {
                n.a aVar3 = new n.a(constraintLayout.getContext());
                aVar3.setId(num.intValue());
                int[] iArr2 = c0026b2.f1967u0;
                if (iArr2 != null) {
                    aVar3.setReferencedIds(iArr2);
                } else {
                    String str2 = c0026b2.f1969v0;
                    if (str2 != null) {
                        int[] b11 = b(aVar3, str2);
                        c0026b2.f1967u0 = b11;
                        aVar3.setReferencedIds(b11);
                    }
                }
                aVar3.setType(c0026b2.f1963s0);
                ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                aVar3.f();
                c0026b2.a(generateDefaultLayoutParams);
                constraintLayout.addView(aVar3, generateDefaultLayoutParams);
            }
            if (c0026b2.f1926a) {
                View cVar = new c(constraintLayout.getContext());
                cVar.setId(num.intValue());
                ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                c0026b2.a(generateDefaultLayoutParams2);
                constraintLayout.addView(cVar, generateDefaultLayoutParams2);
            }
        }
    }

    public final int[] b(View view, String str) {
        int i10;
        Object c10;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (c10 = ((ConstraintLayout) view.getParent()).c(0, trim)) != null && (c10 instanceof Integer)) {
                i10 = ((Integer) c10).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        return i12 != split.length ? Arrays.copyOf(iArr, i12) : iArr;
    }

    public final C0026b c(Context context, AttributeSet attributeSet) {
        C0026b c0026b = new C0026b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1915c);
        f(c0026b, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return c0026b;
    }

    public void d(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    C0026b c10 = c(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        c10.f1926a = true;
                    }
                    this.f1925a.put(Integer.valueOf(c10.f1932d), c10);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public final void f(C0026b c0026b, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            int i11 = f1924c.get(index);
            switch (i11) {
                case 1:
                    c0026b.f1956p = e(typedArray, index, c0026b.f1956p);
                    break;
                case 2:
                    c0026b.G = typedArray.getDimensionPixelSize(index, c0026b.G);
                    break;
                case 3:
                    c0026b.f1954o = e(typedArray, index, c0026b.f1954o);
                    break;
                case 4:
                    c0026b.f1952n = e(typedArray, index, c0026b.f1952n);
                    break;
                case 5:
                    c0026b.f1970w = typedArray.getString(index);
                    break;
                case 6:
                    c0026b.A = typedArray.getDimensionPixelOffset(index, c0026b.A);
                    break;
                case 7:
                    c0026b.B = typedArray.getDimensionPixelOffset(index, c0026b.B);
                    break;
                case 8:
                    c0026b.H = typedArray.getDimensionPixelSize(index, c0026b.H);
                    break;
                case 9:
                    c0026b.f1964t = e(typedArray, index, c0026b.f1964t);
                    break;
                case 10:
                    c0026b.f1962s = e(typedArray, index, c0026b.f1962s);
                    break;
                case 11:
                    c0026b.N = typedArray.getDimensionPixelSize(index, c0026b.N);
                    break;
                case 12:
                    c0026b.O = typedArray.getDimensionPixelSize(index, c0026b.O);
                    break;
                case 13:
                    c0026b.K = typedArray.getDimensionPixelSize(index, c0026b.K);
                    break;
                case 14:
                    c0026b.M = typedArray.getDimensionPixelSize(index, c0026b.M);
                    break;
                case 15:
                    c0026b.P = typedArray.getDimensionPixelSize(index, c0026b.P);
                    break;
                case 16:
                    c0026b.L = typedArray.getDimensionPixelSize(index, c0026b.L);
                    break;
                case 17:
                    c0026b.f1934e = typedArray.getDimensionPixelOffset(index, c0026b.f1934e);
                    break;
                case 18:
                    c0026b.f1936f = typedArray.getDimensionPixelOffset(index, c0026b.f1936f);
                    break;
                case 19:
                    c0026b.f1938g = typedArray.getFloat(index, c0026b.f1938g);
                    break;
                case 20:
                    c0026b.f1966u = typedArray.getFloat(index, c0026b.f1966u);
                    break;
                case 21:
                    c0026b.f1930c = typedArray.getLayoutDimension(index, c0026b.f1930c);
                    break;
                case 22:
                    c0026b.J = f1923b[typedArray.getInt(index, c0026b.J)];
                    break;
                case 23:
                    c0026b.f1928b = typedArray.getLayoutDimension(index, c0026b.f1928b);
                    break;
                case 24:
                    c0026b.D = typedArray.getDimensionPixelSize(index, c0026b.D);
                    break;
                case 25:
                    c0026b.f1940h = e(typedArray, index, c0026b.f1940h);
                    break;
                case 26:
                    c0026b.f1942i = e(typedArray, index, c0026b.f1942i);
                    break;
                case 27:
                    c0026b.C = typedArray.getInt(index, c0026b.C);
                    break;
                case 28:
                    c0026b.E = typedArray.getDimensionPixelSize(index, c0026b.E);
                    break;
                case 29:
                    c0026b.f1944j = e(typedArray, index, c0026b.f1944j);
                    break;
                case 30:
                    c0026b.f1946k = e(typedArray, index, c0026b.f1946k);
                    break;
                case 31:
                    c0026b.I = typedArray.getDimensionPixelSize(index, c0026b.I);
                    break;
                case 32:
                    c0026b.f1958q = e(typedArray, index, c0026b.f1958q);
                    break;
                case 33:
                    c0026b.f1960r = e(typedArray, index, c0026b.f1960r);
                    break;
                case 34:
                    c0026b.F = typedArray.getDimensionPixelSize(index, c0026b.F);
                    break;
                case 35:
                    c0026b.f1950m = e(typedArray, index, c0026b.f1950m);
                    break;
                case 36:
                    c0026b.f1948l = e(typedArray, index, c0026b.f1948l);
                    break;
                case 37:
                    c0026b.f1968v = typedArray.getFloat(index, c0026b.f1968v);
                    break;
                case 38:
                    c0026b.f1932d = typedArray.getResourceId(index, c0026b.f1932d);
                    break;
                case 39:
                    c0026b.R = typedArray.getFloat(index, c0026b.R);
                    break;
                case 40:
                    c0026b.Q = typedArray.getFloat(index, c0026b.Q);
                    break;
                case 41:
                    c0026b.S = typedArray.getInt(index, c0026b.S);
                    break;
                case 42:
                    c0026b.T = typedArray.getInt(index, c0026b.T);
                    break;
                case 43:
                    c0026b.U = typedArray.getFloat(index, c0026b.U);
                    break;
                case 44:
                    c0026b.V = true;
                    c0026b.W = typedArray.getDimension(index, c0026b.W);
                    break;
                case 45:
                    c0026b.Y = typedArray.getFloat(index, c0026b.Y);
                    break;
                case 46:
                    c0026b.Z = typedArray.getFloat(index, c0026b.Z);
                    break;
                case 47:
                    c0026b.f1927a0 = typedArray.getFloat(index, c0026b.f1927a0);
                    break;
                case 48:
                    c0026b.f1929b0 = typedArray.getFloat(index, c0026b.f1929b0);
                    break;
                case 49:
                    c0026b.f1931c0 = typedArray.getFloat(index, c0026b.f1931c0);
                    break;
                case 50:
                    c0026b.f1933d0 = typedArray.getFloat(index, c0026b.f1933d0);
                    break;
                case 51:
                    c0026b.f1935e0 = typedArray.getDimension(index, c0026b.f1935e0);
                    break;
                case 52:
                    c0026b.f1937f0 = typedArray.getDimension(index, c0026b.f1937f0);
                    break;
                case 53:
                    c0026b.f1939g0 = typedArray.getDimension(index, c0026b.f1939g0);
                    break;
                default:
                    switch (i11) {
                        case 60:
                            c0026b.X = typedArray.getFloat(index, c0026b.X);
                            break;
                        case 61:
                            c0026b.f1971x = e(typedArray, index, c0026b.f1971x);
                            break;
                        case 62:
                            c0026b.f1972y = typedArray.getDimensionPixelSize(index, c0026b.f1972y);
                            break;
                        case 63:
                            c0026b.f1973z = typedArray.getFloat(index, c0026b.f1973z);
                            break;
                        default:
                            switch (i11) {
                                case 69:
                                    c0026b.f1957p0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    c0026b.f1959q0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    c0026b.f1963s0 = typedArray.getInt(index, c0026b.f1963s0);
                                    break;
                                case 73:
                                    c0026b.f1969v0 = typedArray.getString(index);
                                    break;
                                case 74:
                                    c0026b.f1961r0 = typedArray.getBoolean(index, c0026b.f1961r0);
                                    break;
                                case 75:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("unused attribute 0x");
                                    sb.append(Integer.toHexString(index));
                                    sb.append("   ");
                                    sb.append(f1924c.get(index));
                                    break;
                                default:
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Unknown attribute 0x");
                                    sb2.append(Integer.toHexString(index));
                                    sb2.append("   ");
                                    sb2.append(f1924c.get(index));
                                    break;
                            }
                    }
            }
        }
    }
}
