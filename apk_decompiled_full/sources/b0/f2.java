package b0;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class f2 {

    /* renamed from: b, reason: collision with root package name */
    public static final f2 f4334b;

    /* renamed from: a, reason: collision with root package name */
    public final l f4335a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Field f4336a;

        /* renamed from: b, reason: collision with root package name */
        public static Field f4337b;

        /* renamed from: c, reason: collision with root package name */
        public static Field f4338c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f4339d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4336a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4337b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4338c = declaredField3;
                declaredField3.setAccessible(true);
                f4339d = true;
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets from AttachInfo ");
                sb.append(e10.getMessage());
            }
        }

        public static f2 a(View view) {
            if (f4339d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4336a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4337b.get(obj);
                        Rect rect2 = (Rect) f4338c.get(obj);
                        if (rect != null && rect2 != null) {
                            f2 a10 = new b().b(r.c.c(rect)).c(r.c.c(rect2)).a();
                            a10.q(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to get insets from AttachInfo. ");
                    sb.append(e10.getMessage());
                }
            }
            return null;
        }
    }

    public static class e extends d {
        public e() {
        }

        public e(f2 f2Var) {
            super(f2Var);
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final f2 f4348a;

        /* renamed from: b, reason: collision with root package name */
        public r.c[] f4349b;

        public f() {
            this(new f2((f2) null));
        }

        public final void a() {
            r.c[] cVarArr = this.f4349b;
            if (cVarArr != null) {
                r.c cVar = cVarArr[m.a(1)];
                r.c cVar2 = this.f4349b[m.a(2)];
                if (cVar2 == null) {
                    cVar2 = this.f4348a.f(2);
                }
                if (cVar == null) {
                    cVar = this.f4348a.f(1);
                }
                f(r.c.a(cVar, cVar2));
                r.c cVar3 = this.f4349b[m.a(16)];
                if (cVar3 != null) {
                    e(cVar3);
                }
                r.c cVar4 = this.f4349b[m.a(32)];
                if (cVar4 != null) {
                    c(cVar4);
                }
                r.c cVar5 = this.f4349b[m.a(64)];
                if (cVar5 != null) {
                    g(cVar5);
                }
            }
        }

        public f2 b() {
            a();
            return this.f4348a;
        }

        public void c(r.c cVar) {
        }

        public void d(r.c cVar) {
        }

        public void e(r.c cVar) {
        }

        public void f(r.c cVar) {
        }

        public void g(r.c cVar) {
        }

        public f(f2 f2Var) {
            this.f4348a = f2Var;
        }
    }

    public static class i extends h {
        public i(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
        }

        @Override // b0.f2.l
        public f2 a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f4356c.consumeDisplayCutout();
            return f2.t(consumeDisplayCutout);
        }

        @Override // b0.f2.g, b0.f2.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f4356c, iVar.f4356c) && Objects.equals(this.f4360g, iVar.f4360g);
        }

        @Override // b0.f2.l
        public b0.h f() {
            DisplayCutout displayCutout;
            displayCutout = this.f4356c.getDisplayCutout();
            return b0.h.e(displayCutout);
        }

        @Override // b0.f2.l
        public int hashCode() {
            int hashCode;
            hashCode = this.f4356c.hashCode();
            return hashCode;
        }

        public i(f2 f2Var, i iVar) {
            super(f2Var, iVar);
        }
    }

    public static class k extends j {

        /* renamed from: r, reason: collision with root package name */
        public static final f2 f4365r;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            f4365r = f2.t(windowInsets);
        }

        public k(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
        }

        @Override // b0.f2.g, b0.f2.l
        public final void d(View view) {
        }

        @Override // b0.f2.g, b0.f2.l
        public r.c g(int i10) {
            Insets insets;
            insets = this.f4356c.getInsets(n.a(i10));
            return r.c.d(insets);
        }

        public k(f2 f2Var, k kVar) {
            super(f2Var, kVar);
        }
    }

    public static class l {

        /* renamed from: b, reason: collision with root package name */
        public static final f2 f4366b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        public final f2 f4367a;

        public l(f2 f2Var) {
            this.f4367a = f2Var;
        }

        public f2 a() {
            return this.f4367a;
        }

        public f2 b() {
            return this.f4367a;
        }

        public f2 c() {
            return this.f4367a;
        }

        public void d(View view) {
        }

        public void e(f2 f2Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return n() == lVar.n() && m() == lVar.m() && a0.c.a(k(), lVar.k()) && a0.c.a(i(), lVar.i()) && a0.c.a(f(), lVar.f());
        }

        public b0.h f() {
            return null;
        }

        public r.c g(int i10) {
            return r.c.f18257e;
        }

        public r.c h() {
            return k();
        }

        public int hashCode() {
            return a0.c.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        public r.c i() {
            return r.c.f18257e;
        }

        public r.c j() {
            return k();
        }

        public r.c k() {
            return r.c.f18257e;
        }

        public r.c l() {
            return k();
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o(r.c[] cVarArr) {
        }

        public void p(r.c cVar) {
        }

        public void q(f2 f2Var) {
        }

        public void r(r.c cVar) {
        }
    }

    public static final class m {
        public static int a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }
    }

    public static final class n {
        public static int a(int i10) {
            int statusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= statusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4334b = k.f4365r;
        } else {
            f4334b = l.f4366b;
        }
    }

    public f2(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f4335a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f4335a = new j(this, windowInsets);
            return;
        }
        if (i10 >= 28) {
            this.f4335a = new i(this, windowInsets);
            return;
        }
        if (i10 >= 21) {
            this.f4335a = new h(this, windowInsets);
        } else if (i10 >= 20) {
            this.f4335a = new g(this, windowInsets);
        } else {
            this.f4335a = new l(this);
        }
    }

    public static f2 t(WindowInsets windowInsets) {
        return u(windowInsets, null);
    }

    public static f2 u(WindowInsets windowInsets, View view) {
        f2 f2Var = new f2(e2.a(a0.h.d(windowInsets)));
        if (view != null && view.isAttachedToWindow()) {
            f2Var.q(c1.G(view));
            f2Var.d(view.getRootView());
        }
        return f2Var;
    }

    public f2 a() {
        return this.f4335a.a();
    }

    public f2 b() {
        return this.f4335a.b();
    }

    public f2 c() {
        return this.f4335a.c();
    }

    public void d(View view) {
        this.f4335a.d(view);
    }

    public b0.h e() {
        return this.f4335a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f2) {
            return a0.c.a(this.f4335a, ((f2) obj).f4335a);
        }
        return false;
    }

    public r.c f(int i10) {
        return this.f4335a.g(i10);
    }

    public r.c g() {
        return this.f4335a.i();
    }

    public int h() {
        return this.f4335a.k().f18261d;
    }

    public int hashCode() {
        l lVar = this.f4335a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f4335a.k().f18258a;
    }

    public int j() {
        return this.f4335a.k().f18260c;
    }

    public int k() {
        return this.f4335a.k().f18259b;
    }

    public boolean l() {
        return !this.f4335a.k().equals(r.c.f18257e);
    }

    public boolean m() {
        return this.f4335a.m();
    }

    public f2 n(int i10, int i11, int i12, int i13) {
        return new b(this).c(r.c.b(i10, i11, i12, i13)).a();
    }

    public void o(r.c[] cVarArr) {
        this.f4335a.o(cVarArr);
    }

    public void p(r.c cVar) {
        this.f4335a.p(cVar);
    }

    public void q(f2 f2Var) {
        this.f4335a.q(f2Var);
    }

    public void r(r.c cVar) {
        this.f4335a.r(cVar);
    }

    public WindowInsets s() {
        l lVar = this.f4335a;
        if (lVar instanceof g) {
            return ((g) lVar).f4356c;
        }
        return null;
    }

    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public static Field f4341e = null;

        /* renamed from: f, reason: collision with root package name */
        public static boolean f4342f = false;

        /* renamed from: g, reason: collision with root package name */
        public static Constructor f4343g = null;

        /* renamed from: h, reason: collision with root package name */
        public static boolean f4344h = false;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsets f4345c;

        /* renamed from: d, reason: collision with root package name */
        public r.c f4346d;

        public c() {
            this.f4345c = h();
        }

        private static WindowInsets h() {
            if (!f4342f) {
                try {
                    f4341e = g2.a().getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f4342f = true;
            }
            Field field = f4341e;
            if (field != null) {
                try {
                    WindowInsets a10 = e2.a(field.get(null));
                    if (a10 != null) {
                        return new WindowInsets(a10);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f4344h) {
                try {
                    f4343g = g2.a().getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f4344h = true;
            }
            Constructor constructor = f4343g;
            if (constructor != null) {
                try {
                    return e2.a(constructor.newInstance(new Rect()));
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // b0.f2.f
        public f2 b() {
            a();
            f2 t10 = f2.t(this.f4345c);
            t10.o(this.f4349b);
            t10.r(this.f4346d);
            return t10;
        }

        @Override // b0.f2.f
        public void d(r.c cVar) {
            this.f4346d = cVar;
        }

        @Override // b0.f2.f
        public void f(r.c cVar) {
            WindowInsets replaceSystemWindowInsets;
            WindowInsets windowInsets = this.f4345c;
            if (windowInsets != null) {
                replaceSystemWindowInsets = windowInsets.replaceSystemWindowInsets(cVar.f18258a, cVar.f18259b, cVar.f18260c, cVar.f18261d);
                this.f4345c = replaceSystemWindowInsets;
            }
        }

        public c(f2 f2Var) {
            super(f2Var);
            this.f4345c = f2Var.s();
        }
    }

    public static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f4347c;

        public d() {
            this.f4347c = new WindowInsets.Builder();
        }

        @Override // b0.f2.f
        public f2 b() {
            WindowInsets build;
            a();
            build = this.f4347c.build();
            f2 t10 = f2.t(build);
            t10.o(this.f4349b);
            return t10;
        }

        @Override // b0.f2.f
        public void c(r.c cVar) {
            this.f4347c.setMandatorySystemGestureInsets(cVar.e());
        }

        @Override // b0.f2.f
        public void d(r.c cVar) {
            this.f4347c.setStableInsets(cVar.e());
        }

        @Override // b0.f2.f
        public void e(r.c cVar) {
            this.f4347c.setSystemGestureInsets(cVar.e());
        }

        @Override // b0.f2.f
        public void f(r.c cVar) {
            this.f4347c.setSystemWindowInsets(cVar.e());
        }

        @Override // b0.f2.f
        public void g(r.c cVar) {
            this.f4347c.setTappableElementInsets(cVar.e());
        }

        public d(f2 f2Var) {
            super(f2Var);
            WindowInsets.Builder builder;
            WindowInsets s10 = f2Var.s();
            if (s10 != null) {
                builder = new WindowInsets.Builder(s10);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f4347c = builder;
        }
    }

    public static class h extends g {

        /* renamed from: n, reason: collision with root package name */
        public r.c f4361n;

        public h(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
            this.f4361n = null;
        }

        @Override // b0.f2.l
        public f2 b() {
            WindowInsets consumeStableInsets;
            consumeStableInsets = this.f4356c.consumeStableInsets();
            return f2.t(consumeStableInsets);
        }

        @Override // b0.f2.l
        public f2 c() {
            WindowInsets consumeSystemWindowInsets;
            consumeSystemWindowInsets = this.f4356c.consumeSystemWindowInsets();
            return f2.t(consumeSystemWindowInsets);
        }

        @Override // b0.f2.l
        public final r.c i() {
            int stableInsetLeft;
            int stableInsetTop;
            int stableInsetRight;
            int stableInsetBottom;
            if (this.f4361n == null) {
                stableInsetLeft = this.f4356c.getStableInsetLeft();
                stableInsetTop = this.f4356c.getStableInsetTop();
                stableInsetRight = this.f4356c.getStableInsetRight();
                stableInsetBottom = this.f4356c.getStableInsetBottom();
                this.f4361n = r.c.b(stableInsetLeft, stableInsetTop, stableInsetRight, stableInsetBottom);
            }
            return this.f4361n;
        }

        @Override // b0.f2.l
        public boolean m() {
            boolean isConsumed;
            isConsumed = this.f4356c.isConsumed();
            return isConsumed;
        }

        @Override // b0.f2.l
        public void r(r.c cVar) {
            this.f4361n = cVar;
        }

        public h(f2 f2Var, h hVar) {
            super(f2Var, hVar);
            this.f4361n = null;
            this.f4361n = hVar.f4361n;
        }
    }

    public static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        public static boolean f4350h = false;

        /* renamed from: i, reason: collision with root package name */
        public static Method f4351i;

        /* renamed from: j, reason: collision with root package name */
        public static Class f4352j;

        /* renamed from: k, reason: collision with root package name */
        public static Class f4353k;

        /* renamed from: l, reason: collision with root package name */
        public static Field f4354l;

        /* renamed from: m, reason: collision with root package name */
        public static Field f4355m;

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f4356c;

        /* renamed from: d, reason: collision with root package name */
        public r.c[] f4357d;

        /* renamed from: e, reason: collision with root package name */
        public r.c f4358e;

        /* renamed from: f, reason: collision with root package name */
        public f2 f4359f;

        /* renamed from: g, reason: collision with root package name */
        public r.c f4360g;

        public g(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var);
            this.f4358e = null;
            this.f4356c = windowInsets;
        }

        private r.c s(int i10, boolean z10) {
            r.c cVar = r.c.f18257e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    cVar = r.c.a(cVar, t(i11, z10));
                }
            }
            return cVar;
        }

        private r.c u() {
            f2 f2Var = this.f4359f;
            return f2Var != null ? f2Var.g() : r.c.f18257e;
        }

        private r.c v(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f4350h) {
                w();
            }
            Method method = f4351i;
            if (method != null && f4353k != null && f4354l != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        return null;
                    }
                    Rect rect = (Rect) f4354l.get(f4355m.get(invoke));
                    if (rect != null) {
                        return r.c.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        private static void w() {
            try {
                f4351i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f4352j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4353k = cls;
                f4354l = cls.getDeclaredField("mVisibleInsets");
                f4355m = f4352j.getDeclaredField("mAttachInfo");
                f4354l.setAccessible(true);
                f4355m.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f4350h = true;
        }

        @Override // b0.f2.l
        public void d(View view) {
            r.c v10 = v(view);
            if (v10 == null) {
                v10 = r.c.f18257e;
            }
            p(v10);
        }

        @Override // b0.f2.l
        public void e(f2 f2Var) {
            f2Var.q(this.f4359f);
            f2Var.p(this.f4360g);
        }

        @Override // b0.f2.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f4360g, ((g) obj).f4360g);
            }
            return false;
        }

        @Override // b0.f2.l
        public r.c g(int i10) {
            return s(i10, false);
        }

        @Override // b0.f2.l
        public final r.c k() {
            int systemWindowInsetLeft;
            int systemWindowInsetTop;
            int systemWindowInsetRight;
            int systemWindowInsetBottom;
            if (this.f4358e == null) {
                systemWindowInsetLeft = this.f4356c.getSystemWindowInsetLeft();
                systemWindowInsetTop = this.f4356c.getSystemWindowInsetTop();
                systemWindowInsetRight = this.f4356c.getSystemWindowInsetRight();
                systemWindowInsetBottom = this.f4356c.getSystemWindowInsetBottom();
                this.f4358e = r.c.b(systemWindowInsetLeft, systemWindowInsetTop, systemWindowInsetRight, systemWindowInsetBottom);
            }
            return this.f4358e;
        }

        @Override // b0.f2.l
        public boolean n() {
            boolean isRound;
            isRound = this.f4356c.isRound();
            return isRound;
        }

        @Override // b0.f2.l
        public void o(r.c[] cVarArr) {
            this.f4357d = cVarArr;
        }

        @Override // b0.f2.l
        public void p(r.c cVar) {
            this.f4360g = cVar;
        }

        @Override // b0.f2.l
        public void q(f2 f2Var) {
            this.f4359f = f2Var;
        }

        public r.c t(int i10, boolean z10) {
            r.c g10;
            int i11;
            if (i10 == 1) {
                return z10 ? r.c.b(0, Math.max(u().f18259b, k().f18259b), 0, 0) : r.c.b(0, k().f18259b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    r.c u10 = u();
                    r.c i12 = i();
                    return r.c.b(Math.max(u10.f18258a, i12.f18258a), 0, Math.max(u10.f18260c, i12.f18260c), Math.max(u10.f18261d, i12.f18261d));
                }
                r.c k10 = k();
                f2 f2Var = this.f4359f;
                g10 = f2Var != null ? f2Var.g() : null;
                int i13 = k10.f18261d;
                if (g10 != null) {
                    i13 = Math.min(i13, g10.f18261d);
                }
                return r.c.b(k10.f18258a, 0, k10.f18260c, i13);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return j();
                }
                if (i10 == 32) {
                    return h();
                }
                if (i10 == 64) {
                    return l();
                }
                if (i10 != 128) {
                    return r.c.f18257e;
                }
                f2 f2Var2 = this.f4359f;
                b0.h e10 = f2Var2 != null ? f2Var2.e() : f();
                return e10 != null ? r.c.b(e10.b(), e10.d(), e10.c(), e10.a()) : r.c.f18257e;
            }
            r.c[] cVarArr = this.f4357d;
            g10 = cVarArr != null ? cVarArr[m.a(8)] : null;
            if (g10 != null) {
                return g10;
            }
            r.c k11 = k();
            r.c u11 = u();
            int i14 = k11.f18261d;
            if (i14 > u11.f18261d) {
                return r.c.b(0, 0, 0, i14);
            }
            r.c cVar = this.f4360g;
            return (cVar == null || cVar.equals(r.c.f18257e) || (i11 = this.f4360g.f18261d) <= u11.f18261d) ? r.c.f18257e : r.c.b(0, 0, 0, i11);
        }

        public g(f2 f2Var, g gVar) {
            this(f2Var, new WindowInsets(gVar.f4356c));
        }
    }

    public static class j extends i {

        /* renamed from: o, reason: collision with root package name */
        public r.c f4362o;

        /* renamed from: p, reason: collision with root package name */
        public r.c f4363p;

        /* renamed from: q, reason: collision with root package name */
        public r.c f4364q;

        public j(f2 f2Var, WindowInsets windowInsets) {
            super(f2Var, windowInsets);
            this.f4362o = null;
            this.f4363p = null;
            this.f4364q = null;
        }

        @Override // b0.f2.l
        public r.c h() {
            Insets mandatorySystemGestureInsets;
            if (this.f4363p == null) {
                mandatorySystemGestureInsets = this.f4356c.getMandatorySystemGestureInsets();
                this.f4363p = r.c.d(mandatorySystemGestureInsets);
            }
            return this.f4363p;
        }

        @Override // b0.f2.l
        public r.c j() {
            Insets systemGestureInsets;
            if (this.f4362o == null) {
                systemGestureInsets = this.f4356c.getSystemGestureInsets();
                this.f4362o = r.c.d(systemGestureInsets);
            }
            return this.f4362o;
        }

        @Override // b0.f2.l
        public r.c l() {
            Insets tappableElementInsets;
            if (this.f4364q == null) {
                tappableElementInsets = this.f4356c.getTappableElementInsets();
                this.f4364q = r.c.d(tappableElementInsets);
            }
            return this.f4364q;
        }

        @Override // b0.f2.h, b0.f2.l
        public void r(r.c cVar) {
        }

        public j(f2 f2Var, j jVar) {
            super(f2Var, jVar);
            this.f4362o = null;
            this.f4363p = null;
            this.f4364q = null;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final f f4340a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f4340a = new e();
                return;
            }
            if (i10 >= 29) {
                this.f4340a = new d();
            } else if (i10 >= 20) {
                this.f4340a = new c();
            } else {
                this.f4340a = new f();
            }
        }

        public f2 a() {
            return this.f4340a.b();
        }

        public b b(r.c cVar) {
            this.f4340a.d(cVar);
            return this;
        }

        public b c(r.c cVar) {
            this.f4340a.f(cVar);
            return this;
        }

        public b(f2 f2Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f4340a = new e(f2Var);
                return;
            }
            if (i10 >= 29) {
                this.f4340a = new d(f2Var);
            } else if (i10 >= 20) {
                this.f4340a = new c(f2Var);
            } else {
                this.f4340a = new f(f2Var);
            }
        }
    }

    public f2(f2 f2Var) {
        if (f2Var != null) {
            l lVar = f2Var.f4335a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f4335a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f4335a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f4335a = new i(this, (i) lVar);
            } else if (i10 >= 21 && (lVar instanceof h)) {
                this.f4335a = new h(this, (h) lVar);
            } else if (i10 >= 20 && (lVar instanceof g)) {
                this.f4335a = new g(this, (g) lVar);
            } else {
                this.f4335a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f4335a = new l(this);
    }
}
