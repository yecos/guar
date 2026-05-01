package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.r2;
import androidx.appcompat.widget.s1;
import androidx.appcompat.widget.x2;
import androidx.appcompat.widget.y2;
import androidx.lifecycle.d;
import b0.a2;
import b0.b0;
import b0.c1;
import b0.c2;
import b0.f2;
import b0.k;
import g.b;
import g.f;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class h extends androidx.appcompat.app.f implements g.a, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    public static final Map f917j0 = new androidx.collection.a();

    /* renamed from: k0, reason: collision with root package name */
    public static final boolean f918k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f919l0;

    /* renamed from: m0, reason: collision with root package name */
    public static boolean f920m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final boolean f921n0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public p[] G;
    public p H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public boolean Q;
    public boolean S;
    public m V;
    public m W;
    public boolean X;
    public int Y;
    public final Runnable Z;

    /* renamed from: d, reason: collision with root package name */
    public final Object f922d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f923e;

    /* renamed from: f, reason: collision with root package name */
    public Window f924f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f925f0;

    /* renamed from: g, reason: collision with root package name */
    public k f926g;

    /* renamed from: g0, reason: collision with root package name */
    public Rect f927g0;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.appcompat.app.e f928h;

    /* renamed from: h0, reason: collision with root package name */
    public Rect f929h0;

    /* renamed from: i, reason: collision with root package name */
    public androidx.appcompat.app.a f930i;

    /* renamed from: i0, reason: collision with root package name */
    public AppCompatViewInflater f931i0;

    /* renamed from: j, reason: collision with root package name */
    public MenuInflater f932j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f933k;

    /* renamed from: l, reason: collision with root package name */
    public h1 f934l;

    /* renamed from: m, reason: collision with root package name */
    public i f935m;

    /* renamed from: n, reason: collision with root package name */
    public q f936n;

    /* renamed from: o, reason: collision with root package name */
    public g.b f937o;

    /* renamed from: p, reason: collision with root package name */
    public ActionBarContextView f938p;

    /* renamed from: q, reason: collision with root package name */
    public PopupWindow f939q;

    /* renamed from: r, reason: collision with root package name */
    public Runnable f940r;

    /* renamed from: s, reason: collision with root package name */
    public a2 f941s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f942t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f943u;

    /* renamed from: v, reason: collision with root package name */
    public ViewGroup f944v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f945w;

    /* renamed from: x, reason: collision with root package name */
    public View f946x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f947y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f948z;

    public static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f949a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f949a = uncaughtExceptionHandler;
        }

        public final boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f949a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f949a.uncaughtException(thread, notFoundException);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            if ((hVar.Y & 1) != 0) {
                hVar.T(0);
            }
            h hVar2 = h.this;
            if ((hVar2.Y & 4096) != 0) {
                hVar2.T(108);
            }
            h hVar3 = h.this;
            hVar3.X = false;
            hVar3.Y = 0;
        }
    }

    public class c implements b0 {
        public c() {
        }

        @Override // b0.b0
        public f2 onApplyWindowInsets(View view, f2 f2Var) {
            int k10 = f2Var.k();
            int I0 = h.this.I0(k10);
            if (k10 != I0) {
                f2Var = f2Var.n(f2Var.i(), I0, f2Var.j(), f2Var.h());
            }
            return c1.X(view, f2Var);
        }
    }

    public class d implements s1.a {
        public d() {
        }

        @Override // androidx.appcompat.widget.s1.a
        public void a(Rect rect) {
            rect.top = h.this.I0(rect.top);
        }
    }

    public class e implements ContentFrameLayout.a {
        public e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            h.this.R();
        }
    }

    public class f implements Runnable {

        public class a extends c2 {
            public a() {
            }

            @Override // b0.b2
            public void b(View view) {
                h.this.f938p.setAlpha(1.0f);
                h.this.f941s.f(null);
                h.this.f941s = null;
            }

            @Override // b0.c2, b0.b2
            public void c(View view) {
                h.this.f938p.setVisibility(0);
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f939q.showAtLocation(hVar.f938p, 55, 0, 0);
            h.this.U();
            if (!h.this.B0()) {
                h.this.f938p.setAlpha(1.0f);
                h.this.f938p.setVisibility(0);
            } else {
                h.this.f938p.setAlpha(0.0f);
                h hVar2 = h.this;
                hVar2.f941s = c1.c(hVar2.f938p).a(1.0f);
                h.this.f941s.f(new a());
            }
        }
    }

    public class g extends c2 {
        public g() {
        }

        @Override // b0.b2
        public void b(View view) {
            h.this.f938p.setAlpha(1.0f);
            h.this.f941s.f(null);
            h.this.f941s = null;
        }

        @Override // b0.c2, b0.b2
        public void c(View view) {
            h.this.f938p.setVisibility(0);
            h.this.f938p.sendAccessibilityEvent(32);
            if (h.this.f938p.getParent() instanceof View) {
                c1.h0((View) h.this.f938p.getParent());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.h$h, reason: collision with other inner class name */
    public class C0016h implements androidx.appcompat.app.b {
        public C0016h() {
        }
    }

    public final class i implements m.a {
        public i() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback d02 = h.this.d0();
            if (d02 == null) {
                return true;
            }
            d02.onMenuOpened(108, gVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            h.this.L(gVar);
        }
    }

    public class j implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public b.a f959a;

        public class a extends c2 {
            public a() {
            }

            @Override // b0.b2
            public void b(View view) {
                h.this.f938p.setVisibility(8);
                h hVar = h.this;
                PopupWindow popupWindow = hVar.f939q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (hVar.f938p.getParent() instanceof View) {
                    c1.h0((View) h.this.f938p.getParent());
                }
                h.this.f938p.removeAllViews();
                h.this.f941s.f(null);
                h.this.f941s = null;
            }
        }

        public j(b.a aVar) {
            this.f959a = aVar;
        }

        @Override // g.b.a
        public boolean a(g.b bVar, MenuItem menuItem) {
            return this.f959a.a(bVar, menuItem);
        }

        @Override // g.b.a
        public void b(g.b bVar) {
            this.f959a.b(bVar);
            h hVar = h.this;
            if (hVar.f939q != null) {
                hVar.f924f.getDecorView().removeCallbacks(h.this.f940r);
            }
            h hVar2 = h.this;
            if (hVar2.f938p != null) {
                hVar2.U();
                h hVar3 = h.this;
                hVar3.f941s = c1.c(hVar3.f938p).a(0.0f);
                h.this.f941s.f(new a());
            }
            h hVar4 = h.this;
            androidx.appcompat.app.e eVar = hVar4.f928h;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(hVar4.f937o);
            }
            h.this.f937o = null;
        }

        @Override // g.b.a
        public boolean c(g.b bVar, Menu menu) {
            return this.f959a.c(bVar, menu);
        }

        @Override // g.b.a
        public boolean d(g.b bVar, Menu menu) {
            return this.f959a.d(bVar, menu);
        }
    }

    public class l extends m {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f963c;

        public l(Context context) {
            super();
            this.f963c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.h.m
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.h.m
        public int c() {
            boolean isPowerSaveMode;
            if (Build.VERSION.SDK_INT < 21) {
                return 1;
            }
            isPowerSaveMode = this.f963c.isPowerSaveMode();
            return isPowerSaveMode ? 2 : 1;
        }

        @Override // androidx.appcompat.app.h.m
        public void d() {
            h.this.F();
        }
    }

    public abstract class m {

        /* renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f965a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                m.this.d();
            }
        }

        public m() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f965a;
            if (broadcastReceiver != null) {
                try {
                    h.this.f923e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f965a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b10 = b();
            if (b10 == null || b10.countActions() == 0) {
                return;
            }
            if (this.f965a == null) {
                this.f965a = new a();
            }
            h.this.f923e.registerReceiver(this.f965a, b10);
        }
    }

    public class n extends m {

        /* renamed from: c, reason: collision with root package name */
        public final androidx.appcompat.app.p f968c;

        public n(androidx.appcompat.app.p pVar) {
            super();
            this.f968c = pVar;
        }

        @Override // androidx.appcompat.app.h.m
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.h.m
        public int c() {
            return this.f968c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.h.m
        public void d() {
            h.this.F();
        }
    }

    public class o extends ContentFrameLayout {
        public o(Context context) {
            super(context);
        }

        public final boolean c(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return h.this.S(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            h.this.N(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(d.b.d(getContext(), i10));
        }
    }

    public static final class p {

        /* renamed from: a, reason: collision with root package name */
        public int f971a;

        /* renamed from: b, reason: collision with root package name */
        public int f972b;

        /* renamed from: c, reason: collision with root package name */
        public int f973c;

        /* renamed from: d, reason: collision with root package name */
        public int f974d;

        /* renamed from: e, reason: collision with root package name */
        public int f975e;

        /* renamed from: f, reason: collision with root package name */
        public int f976f;

        /* renamed from: g, reason: collision with root package name */
        public ViewGroup f977g;

        /* renamed from: h, reason: collision with root package name */
        public View f978h;

        /* renamed from: i, reason: collision with root package name */
        public View f979i;

        /* renamed from: j, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f980j;

        /* renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f981k;

        /* renamed from: l, reason: collision with root package name */
        public Context f982l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f983m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f984n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f985o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f986p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f987q = false;

        /* renamed from: r, reason: collision with root package name */
        public boolean f988r;

        /* renamed from: s, reason: collision with root package name */
        public Bundle f989s;

        public p(int i10) {
            this.f971a = i10;
        }

        public androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f980j == null) {
                return null;
            }
            if (this.f981k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f982l, R$layout.abc_list_menu_item_layout);
                this.f981k = eVar;
                eVar.setCallback(aVar);
                this.f980j.addMenuPresenter(this.f981k);
            }
            return this.f981k.b(this.f977g);
        }

        public boolean b() {
            if (this.f978h == null) {
                return false;
            }
            return this.f979i != null || this.f981k.a().getCount() > 0;
        }

        public void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f980j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.removeMenuPresenter(this.f981k);
            }
            this.f980j = gVar;
            if (gVar == null || (eVar = this.f981k) == null) {
                return;
            }
            gVar.addMenuPresenter(eVar);
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            g.d dVar = new g.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f982l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.f817o);
            this.f972b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f976f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final class q implements m.a {
        public q() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback d02;
            if (gVar != null) {
                return true;
            }
            h hVar = h.this;
            if (!hVar.A || (d02 = hVar.d0()) == null || h.this.M) {
                return true;
            }
            d02.onMenuOpened(108, gVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            androidx.appcompat.view.menu.g rootMenu = gVar.getRootMenu();
            boolean z11 = rootMenu != gVar;
            h hVar = h.this;
            if (z11) {
                gVar = rootMenu;
            }
            p X = hVar.X(gVar);
            if (X != null) {
                if (!z11) {
                    h.this.O(X, z10);
                } else {
                    h.this.K(X.f971a, X, rootMenu);
                    h.this.O(X, true);
                }
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        boolean z11 = i10 < 21;
        f918k0 = z11;
        f919l0 = new int[]{R.attr.windowBackground};
        if (i10 >= 21 && i10 <= 25) {
            z10 = true;
        }
        f921n0 = z10;
        if (!z11 || f920m0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f920m0 = true;
    }

    public h(Activity activity, androidx.appcompat.app.e eVar) {
        this(activity, null, eVar, activity);
    }

    @Override // androidx.appcompat.app.f
    public void A(View view, ViewGroup.LayoutParams layoutParams) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.f944v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f926g.a().onContentChanged();
    }

    public final int A0(int i10) {
        if (i10 == 8) {
            return 108;
        }
        if (i10 == 9) {
            return 109;
        }
        return i10;
    }

    @Override // androidx.appcompat.app.f
    public void B(Toolbar toolbar) {
        if (this.f922d instanceof Activity) {
            androidx.appcompat.app.a j10 = j();
            if (j10 instanceof androidx.appcompat.app.q) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f932j = null;
            if (j10 != null) {
                j10.n();
            }
            if (toolbar != null) {
                androidx.appcompat.app.n nVar = new androidx.appcompat.app.n(toolbar, c0(), this.f926g);
                this.f930i = nVar;
                this.f924f.setCallback(nVar.A());
            } else {
                this.f930i = null;
                this.f924f.setCallback(this.f926g);
            }
            l();
        }
    }

    public final boolean B0() {
        ViewGroup viewGroup;
        return this.f943u && (viewGroup = this.f944v) != null && c1.Q(viewGroup);
    }

    @Override // androidx.appcompat.app.f
    public void C(int i10) {
        this.O = i10;
    }

    public final boolean C0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f924f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || c1.P((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.f
    public final void D(CharSequence charSequence) {
        this.f933k = charSequence;
        h1 h1Var = this.f934l;
        if (h1Var != null) {
            h1Var.setWindowTitle(charSequence);
            return;
        }
        if (w0() != null) {
            w0().x(charSequence);
            return;
        }
        TextView textView = this.f945w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g.b D0(g.b.a r8) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.D0(g.b$a):g.b");
    }

    @Override // androidx.appcompat.app.f
    public g.b E(b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        g.b bVar = this.f937o;
        if (bVar != null) {
            bVar.a();
        }
        j jVar = new j(aVar);
        androidx.appcompat.app.a j10 = j();
        if (j10 != null) {
            g.b y10 = j10.y(jVar);
            this.f937o = y10;
            if (y10 != null && (eVar = this.f928h) != null) {
                eVar.onSupportActionModeStarted(y10);
            }
        }
        if (this.f937o == null) {
            this.f937o = D0(jVar);
        }
        return this.f937o;
    }

    public final void E0() {
        if (this.f943u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public boolean F() {
        return G(true);
    }

    public final androidx.appcompat.app.d F0() {
        for (Context context = this.f923e; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.d) {
                return (androidx.appcompat.app.d) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public final boolean G(boolean z10) {
        if (this.M) {
            return false;
        }
        int J = J();
        boolean G0 = G0(l0(J), z10);
        if (J == 0) {
            a0().e();
        } else {
            m mVar = this.V;
            if (mVar != null) {
                mVar.a();
            }
        }
        if (J == 3) {
            Z().e();
        } else {
            m mVar2 = this.W;
            if (mVar2 != null) {
                mVar2.a();
            }
        }
        return G0;
    }

    public final boolean G0(int i10, boolean z10) {
        int i11 = this.f923e.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z11 = true;
        int i12 = i10 != 1 ? i10 != 2 ? i11 : 32 : 16;
        boolean j02 = j0();
        boolean z12 = false;
        if ((f921n0 || i12 != i11) && !j02 && !this.J && (this.f922d instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i12;
            try {
                ((ContextThemeWrapper) this.f922d).applyOverrideConfiguration(configuration);
                z12 = true;
            } catch (IllegalStateException e10) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e10);
            }
        }
        int i13 = this.f923e.getResources().getConfiguration().uiMode & 48;
        if (!z12 && i13 != i12 && z10 && !j02 && this.J) {
            Object obj = this.f922d;
            if (obj instanceof Activity) {
                o.h.e((Activity) obj);
                z12 = true;
            }
        }
        if (z12 || i13 == i12) {
            z11 = z12;
        } else {
            H0(i12, j02);
        }
        if (z11) {
            Object obj2 = this.f922d;
            if (obj2 instanceof androidx.appcompat.app.d) {
                ((androidx.appcompat.app.d) obj2).onNightModeChanged(i10);
            }
        }
        return z11;
    }

    public final void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f944v.findViewById(R.id.content);
        View decorView = this.f924f.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f923e.obtainStyledAttributes(R$styleable.f817o);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H0(int i10, boolean z10) {
        Resources resources = this.f923e.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            androidx.appcompat.app.l.a(resources);
        }
        int i12 = this.O;
        if (i12 != 0) {
            this.f923e.setTheme(i12);
            if (i11 >= 23) {
                this.f923e.getTheme().applyStyle(this.O, true);
            }
        }
        if (z10) {
            Object obj = this.f922d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (((androidx.lifecycle.g) activity).getLifecycle().b().a(d.c.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.L) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    public final void I(Window window) {
        if (this.f924f != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof k) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        k kVar = new k(callback);
        this.f926g = kVar;
        window.setCallback(kVar);
        r2 t10 = r2.t(this.f923e, null, f919l0);
        Drawable h10 = t10.h(0);
        if (h10 != null) {
            window.setBackgroundDrawable(h10);
        }
        t10.v();
        this.f924f = window;
    }

    public int I0(int i10) {
        boolean z10;
        boolean z11;
        ActionBarContextView actionBarContextView = this.f938p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f938p.getLayoutParams();
            if (this.f938p.isShown()) {
                if (this.f927g0 == null) {
                    this.f927g0 = new Rect();
                    this.f929h0 = new Rect();
                }
                Rect rect = this.f927g0;
                Rect rect2 = this.f929h0;
                rect.set(0, i10, 0, 0);
                y2.a(this.f944v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i10 : 0)) {
                    marginLayoutParams.topMargin = i10;
                    View view = this.f946x;
                    if (view == null) {
                        View view2 = new View(this.f923e);
                        this.f946x = view2;
                        view2.setBackgroundColor(this.f923e.getResources().getColor(R$color.abc_input_method_navigation_guard));
                        this.f944v.addView(this.f946x, -1, new ViewGroup.LayoutParams(-1, i10));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i10) {
                            layoutParams.height = i10;
                            this.f946x.setLayoutParams(layoutParams);
                        }
                    }
                    z11 = true;
                } else {
                    z11 = false;
                }
                r3 = this.f946x != null;
                if (!this.C && r3) {
                    i10 = 0;
                }
                boolean z12 = r3;
                r3 = z11;
                z10 = z12;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                r3 = false;
            }
            if (r3) {
                this.f938p.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f946x;
        if (view3 != null) {
            view3.setVisibility(z10 ? 0 : 8);
        }
        return i10;
    }

    public final int J() {
        int i10 = this.N;
        return i10 != -100 ? i10 : androidx.appcompat.app.f.f();
    }

    public void K(int i10, p pVar, Menu menu) {
        if (menu == null) {
            if (pVar == null && i10 >= 0) {
                p[] pVarArr = this.G;
                if (i10 < pVarArr.length) {
                    pVar = pVarArr[i10];
                }
            }
            if (pVar != null) {
                menu = pVar.f980j;
            }
        }
        if ((pVar == null || pVar.f985o) && !this.M) {
            this.f926g.a().onPanelClosed(i10, menu);
        }
    }

    public void L(androidx.appcompat.view.menu.g gVar) {
        if (this.F) {
            return;
        }
        this.F = true;
        this.f934l.i();
        Window.Callback d02 = d0();
        if (d02 != null && !this.M) {
            d02.onPanelClosed(108, gVar);
        }
        this.F = false;
    }

    public final void M() {
        m mVar = this.V;
        if (mVar != null) {
            mVar.a();
        }
        m mVar2 = this.W;
        if (mVar2 != null) {
            mVar2.a();
        }
    }

    public void N(int i10) {
        O(b0(i10, true), true);
    }

    public void O(p pVar, boolean z10) {
        ViewGroup viewGroup;
        h1 h1Var;
        if (z10 && pVar.f971a == 0 && (h1Var = this.f934l) != null && h1Var.e()) {
            L(pVar.f980j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f923e.getSystemService("window");
        if (windowManager != null && pVar.f985o && (viewGroup = pVar.f977g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                K(pVar.f971a, pVar, null);
            }
        }
        pVar.f983m = false;
        pVar.f984n = false;
        pVar.f985o = false;
        pVar.f978h = null;
        pVar.f987q = true;
        if (this.H == pVar) {
            this.H = null;
        }
    }

    public final ViewGroup P() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f923e.obtainStyledAttributes(R$styleable.f817o);
        int i10 = R$styleable.AppCompatTheme_windowActionBar;
        if (!obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            x(1);
        } else if (obtainStyledAttributes.getBoolean(i10, false)) {
            x(108);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            x(109);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            x(10);
        }
        this.D = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        W();
        this.f924f.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f923e);
        if (this.E) {
            viewGroup = this.C ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                c1.y0(viewGroup, new c());
            } else {
                ((s1) viewGroup).setOnFitSystemWindowsListener(new d());
            }
        } else if (this.D) {
            viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.B = false;
            this.A = false;
        } else if (this.A) {
            TypedValue typedValue = new TypedValue();
            this.f923e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new g.d(this.f923e, typedValue.resourceId) : this.f923e).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            h1 h1Var = (h1) viewGroup.findViewById(R$id.decor_content_parent);
            this.f934l = h1Var;
            h1Var.setWindowCallback(d0());
            if (this.B) {
                this.f934l.h(109);
            }
            if (this.f947y) {
                this.f934l.h(2);
            }
            if (this.f948z) {
                this.f934l.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.A + ", windowActionBarOverlay: " + this.B + ", android:windowIsFloating: " + this.D + ", windowActionModeOverlay: " + this.C + ", windowNoTitle: " + this.E + " }");
        }
        if (this.f934l == null) {
            this.f945w = (TextView) viewGroup.findViewById(R$id.title);
        }
        y2.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f924f.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f924f.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View Q(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        boolean z11 = false;
        if (this.f931i0 == null) {
            String string = this.f923e.obtainStyledAttributes(R$styleable.f817o).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f931i0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f931i0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    this.f931i0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z12 = f918k0;
        if (z12) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z11 = C0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z11 = true;
            }
            z10 = z11;
        } else {
            z10 = false;
        }
        return this.f931i0.createView(view, str, context, attributeSet, z10, z12, true, x2.b());
    }

    public void R() {
        androidx.appcompat.view.menu.g gVar;
        h1 h1Var = this.f934l;
        if (h1Var != null) {
            h1Var.i();
        }
        if (this.f939q != null) {
            this.f924f.getDecorView().removeCallbacks(this.f940r);
            if (this.f939q.isShowing()) {
                try {
                    this.f939q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f939q = null;
        }
        U();
        p b02 = b0(0, false);
        if (b02 == null || (gVar = b02.f980j) == null) {
            return;
        }
        gVar.close();
    }

    public boolean S(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f922d;
        if (((obj instanceof k.a) || (obj instanceof androidx.appcompat.app.j)) && (decorView = this.f924f.getDecorView()) != null && b0.k.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f926g.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? n0(keyCode, keyEvent) : q0(keyCode, keyEvent);
    }

    public void T(int i10) {
        p b02;
        p b03 = b0(i10, true);
        if (b03.f980j != null) {
            Bundle bundle = new Bundle();
            b03.f980j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                b03.f989s = bundle;
            }
            b03.f980j.stopDispatchingItemsChanged();
            b03.f980j.clear();
        }
        b03.f988r = true;
        b03.f987q = true;
        if ((i10 != 108 && i10 != 0) || this.f934l == null || (b02 = b0(0, false)) == null) {
            return;
        }
        b02.f983m = false;
        y0(b02, null);
    }

    public void U() {
        a2 a2Var = this.f941s;
        if (a2Var != null) {
            a2Var.b();
        }
    }

    public final void V() {
        if (this.f943u) {
            return;
        }
        this.f944v = P();
        CharSequence c02 = c0();
        if (!TextUtils.isEmpty(c02)) {
            h1 h1Var = this.f934l;
            if (h1Var != null) {
                h1Var.setWindowTitle(c02);
            } else if (w0() != null) {
                w0().x(c02);
            } else {
                TextView textView = this.f945w;
                if (textView != null) {
                    textView.setText(c02);
                }
            }
        }
        H();
        u0(this.f944v);
        this.f943u = true;
        p b02 = b0(0, false);
        if (this.M) {
            return;
        }
        if (b02 == null || b02.f980j == null) {
            i0(108);
        }
    }

    public final void W() {
        if (this.f924f == null) {
            Object obj = this.f922d;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f924f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public p X(Menu menu) {
        p[] pVarArr = this.G;
        int length = pVarArr != null ? pVarArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            p pVar = pVarArr[i10];
            if (pVar != null && pVar.f980j == menu) {
                return pVar;
            }
        }
        return null;
    }

    public final Context Y() {
        androidx.appcompat.app.a j10 = j();
        Context k10 = j10 != null ? j10.k() : null;
        return k10 == null ? this.f923e : k10;
    }

    public final m Z() {
        if (this.W == null) {
            this.W = new l(this.f923e);
        }
        return this.W;
    }

    @Override // androidx.appcompat.app.f
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        V();
        ((ViewGroup) this.f944v.findViewById(R.id.content)).addView(view, layoutParams);
        this.f926g.a().onContentChanged();
    }

    public final m a0() {
        if (this.V == null) {
            this.V = new n(androidx.appcompat.app.p.a(this.f923e));
        }
        return this.V;
    }

    @Override // androidx.appcompat.app.f
    public void b(Context context) {
        G(false);
        this.J = true;
    }

    public p b0(int i10, boolean z10) {
        p[] pVarArr = this.G;
        if (pVarArr == null || pVarArr.length <= i10) {
            p[] pVarArr2 = new p[i10 + 1];
            if (pVarArr != null) {
                System.arraycopy(pVarArr, 0, pVarArr2, 0, pVarArr.length);
            }
            this.G = pVarArr2;
            pVarArr = pVarArr2;
        }
        p pVar = pVarArr[i10];
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(i10);
        pVarArr[i10] = pVar2;
        return pVar2;
    }

    public final CharSequence c0() {
        Object obj = this.f922d;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f933k;
    }

    public final Window.Callback d0() {
        return this.f924f.getCallback();
    }

    @Override // androidx.appcompat.app.f
    public View e(int i10) {
        V();
        return this.f924f.findViewById(i10);
    }

    public final void e0() {
        V();
        if (this.A && this.f930i == null) {
            Object obj = this.f922d;
            if (obj instanceof Activity) {
                this.f930i = new androidx.appcompat.app.q((Activity) this.f922d, this.B);
            } else if (obj instanceof Dialog) {
                this.f930i = new androidx.appcompat.app.q((Dialog) this.f922d);
            }
            androidx.appcompat.app.a aVar = this.f930i;
            if (aVar != null) {
                aVar.r(this.f925f0);
            }
        }
    }

    public final boolean f0(p pVar) {
        View view = pVar.f979i;
        if (view != null) {
            pVar.f978h = view;
            return true;
        }
        if (pVar.f980j == null) {
            return false;
        }
        if (this.f936n == null) {
            this.f936n = new q();
        }
        View view2 = (View) pVar.a(this.f936n);
        pVar.f978h = view2;
        return view2 != null;
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b g() {
        return new C0016h();
    }

    public final boolean g0(p pVar) {
        pVar.d(Y());
        pVar.f977g = new o(pVar.f982l);
        pVar.f973c = 81;
        return true;
    }

    @Override // androidx.appcompat.app.f
    public int h() {
        return this.N;
    }

    public final boolean h0(p pVar) {
        Resources.Theme theme;
        Context context = this.f923e;
        int i10 = pVar.f971a;
        if ((i10 == 0 || i10 == 108) && this.f934l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                g.d dVar = new g.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.setCallback(this);
        pVar.c(gVar);
        return true;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater i() {
        if (this.f932j == null) {
            e0();
            androidx.appcompat.app.a aVar = this.f930i;
            this.f932j = new g.g(aVar != null ? aVar.k() : this.f923e);
        }
        return this.f932j;
    }

    public final void i0(int i10) {
        this.Y = (1 << i10) | this.Y;
        if (this.X) {
            return;
        }
        c1.c0(this.f924f.getDecorView(), this.Z);
        this.X = true;
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a j() {
        e0();
        return this.f930i;
    }

    public final boolean j0() {
        if (!this.S && (this.f922d instanceof Activity)) {
            PackageManager packageManager = this.f923e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f923e, this.f922d.getClass()), 0);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.Q = false;
            }
        }
        this.S = true;
        return this.Q;
    }

    @Override // androidx.appcompat.app.f
    public void k() {
        LayoutInflater from = LayoutInflater.from(this.f923e);
        if (from.getFactory() == null) {
            b0.l.b(from, this);
        } else {
            boolean z10 = from.getFactory2() instanceof h;
        }
    }

    public boolean k0() {
        return this.f942t;
    }

    @Override // androidx.appcompat.app.f
    public void l() {
        androidx.appcompat.app.a j10 = j();
        if (j10 == null || !j10.l()) {
            i0(0);
        }
    }

    public int l0(int i10) {
        Object systemService;
        if (i10 == -100) {
            return -1;
        }
        if (i10 == -1) {
            return i10;
        }
        if (i10 == 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                systemService = this.f923e.getSystemService((Class<Object>) UiModeManager.class);
                if (((UiModeManager) systemService).getNightMode() == 0) {
                    return -1;
                }
            }
            return a0().c();
        }
        if (i10 == 1 || i10 == 2) {
            return i10;
        }
        if (i10 == 3) {
            return Z().c();
        }
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    }

    public boolean m0() {
        g.b bVar = this.f937o;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        androidx.appcompat.app.a j10 = j();
        return j10 != null && j10.h();
    }

    public boolean n0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.I = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            o0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void o(Configuration configuration) {
        androidx.appcompat.app.a j10;
        if (this.A && this.f943u && (j10 = j()) != null) {
            j10.m(configuration);
        }
        androidx.appcompat.widget.k.b().g(this.f923e);
        G(false);
    }

    public final boolean o0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p b02 = b0(i10, true);
        if (b02.f985o) {
            return false;
        }
        return y0(b02, keyEvent);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return Q(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        p X;
        Window.Callback d02 = d0();
        if (d02 == null || this.M || (X = X(gVar.getRootMenu())) == null) {
            return false;
        }
        return d02.onMenuItemSelected(X.f971a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
        z0(gVar, true);
    }

    @Override // androidx.appcompat.app.f
    public void p(Bundle bundle) {
        String str;
        this.J = true;
        G(false);
        W();
        Object obj = this.f922d;
        if (obj instanceof Activity) {
            try {
                str = o.q.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                androidx.appcompat.app.a w02 = w0();
                if (w02 == null) {
                    this.f925f0 = true;
                } else {
                    w02.r(true);
                }
            }
        }
        this.K = true;
    }

    public boolean p0(int i10, KeyEvent keyEvent) {
        androidx.appcompat.app.a j10 = j();
        if (j10 != null && j10.o(i10, keyEvent)) {
            return true;
        }
        p pVar = this.H;
        if (pVar != null && x0(pVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            p pVar2 = this.H;
            if (pVar2 != null) {
                pVar2.f984n = true;
            }
            return true;
        }
        if (this.H == null) {
            p b02 = b0(0, true);
            y0(b02, keyEvent);
            boolean x02 = x0(b02, keyEvent.getKeyCode(), keyEvent, 1);
            b02.f983m = false;
            if (x02) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void q() {
        androidx.appcompat.app.f.n(this);
        if (this.X) {
            this.f924f.getDecorView().removeCallbacks(this.Z);
        }
        this.L = false;
        this.M = true;
        androidx.appcompat.app.a aVar = this.f930i;
        if (aVar != null) {
            aVar.n();
        }
        M();
    }

    public boolean q0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.I;
            this.I = false;
            p b02 = b0(0, false);
            if (b02 != null && b02.f985o) {
                if (!z10) {
                    O(b02, true);
                }
                return true;
            }
            if (m0()) {
                return true;
            }
        } else if (i10 == 82) {
            r0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void r(Bundle bundle) {
        V();
    }

    public final boolean r0(int i10, KeyEvent keyEvent) {
        boolean z10;
        AudioManager audioManager;
        h1 h1Var;
        if (this.f937o != null) {
            return false;
        }
        boolean z11 = true;
        p b02 = b0(i10, true);
        if (i10 != 0 || (h1Var = this.f934l) == null || !h1Var.a() || ViewConfiguration.get(this.f923e).hasPermanentMenuKey()) {
            boolean z12 = b02.f985o;
            if (z12 || b02.f984n) {
                O(b02, true);
                z11 = z12;
            } else {
                if (b02.f983m) {
                    if (b02.f988r) {
                        b02.f983m = false;
                        z10 = y0(b02, keyEvent);
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        v0(b02, keyEvent);
                    }
                }
                z11 = false;
            }
        } else if (this.f934l.e()) {
            z11 = this.f934l.b();
        } else {
            if (!this.M && y0(b02, keyEvent)) {
                z11 = this.f934l.c();
            }
            z11 = false;
        }
        if (z11 && (audioManager = (AudioManager) this.f923e.getSystemService("audio")) != null) {
            audioManager.playSoundEffect(0);
        }
        return z11;
    }

    @Override // androidx.appcompat.app.f
    public void s() {
        androidx.appcompat.app.a j10 = j();
        if (j10 != null) {
            j10.u(true);
        }
    }

    public void s0(int i10) {
        androidx.appcompat.app.a j10;
        if (i10 != 108 || (j10 = j()) == null) {
            return;
        }
        j10.i(true);
    }

    @Override // androidx.appcompat.app.f
    public void t(Bundle bundle) {
        if (this.N != -100) {
            f917j0.put(this.f922d.getClass(), Integer.valueOf(this.N));
        }
    }

    public void t0(int i10) {
        if (i10 == 108) {
            androidx.appcompat.app.a j10 = j();
            if (j10 != null) {
                j10.i(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            p b02 = b0(i10, true);
            if (b02.f985o) {
                O(b02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public void u() {
        this.L = true;
        F();
        androidx.appcompat.app.f.m(this);
    }

    public void u0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.f
    public void v() {
        this.L = false;
        androidx.appcompat.app.f.n(this);
        androidx.appcompat.app.a j10 = j();
        if (j10 != null) {
            j10.u(false);
        }
        if (this.f922d instanceof Dialog) {
            M();
        }
    }

    public final void v0(p pVar, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (pVar.f985o || this.M) {
            return;
        }
        if (pVar.f971a == 0) {
            if ((this.f923e.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback d02 = d0();
        if (d02 != null && !d02.onMenuOpened(pVar.f971a, pVar.f980j)) {
            O(pVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f923e.getSystemService("window");
        if (windowManager != null && y0(pVar, keyEvent)) {
            ViewGroup viewGroup = pVar.f977g;
            if (viewGroup == null || pVar.f987q) {
                if (viewGroup == null) {
                    if (!g0(pVar) || pVar.f977g == null) {
                        return;
                    }
                } else if (pVar.f987q && viewGroup.getChildCount() > 0) {
                    pVar.f977g.removeAllViews();
                }
                if (!f0(pVar) || !pVar.b()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = pVar.f978h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                pVar.f977g.setBackgroundResource(pVar.f972b);
                ViewParent parent = pVar.f978h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(pVar.f978h);
                }
                pVar.f977g.addView(pVar.f978h, layoutParams2);
                if (!pVar.f978h.hasFocus()) {
                    pVar.f978h.requestFocus();
                }
            } else {
                View view = pVar.f979i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i10 = -1;
                    pVar.f984n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i10, -2, pVar.f974d, pVar.f975e, 1002, 8519680, -3);
                    layoutParams3.gravity = pVar.f973c;
                    layoutParams3.windowAnimations = pVar.f976f;
                    windowManager.addView(pVar.f977g, layoutParams3);
                    pVar.f985o = true;
                }
            }
            i10 = -2;
            pVar.f984n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i10, -2, pVar.f974d, pVar.f975e, 1002, 8519680, -3);
            layoutParams32.gravity = pVar.f973c;
            layoutParams32.windowAnimations = pVar.f976f;
            windowManager.addView(pVar.f977g, layoutParams32);
            pVar.f985o = true;
        }
    }

    public final androidx.appcompat.app.a w0() {
        return this.f930i;
    }

    @Override // androidx.appcompat.app.f
    public boolean x(int i10) {
        int A0 = A0(i10);
        if (this.E && A0 == 108) {
            return false;
        }
        if (this.A && A0 == 1) {
            this.A = false;
        }
        if (A0 == 1) {
            E0();
            this.E = true;
            return true;
        }
        if (A0 == 2) {
            E0();
            this.f947y = true;
            return true;
        }
        if (A0 == 5) {
            E0();
            this.f948z = true;
            return true;
        }
        if (A0 == 10) {
            E0();
            this.C = true;
            return true;
        }
        if (A0 == 108) {
            E0();
            this.A = true;
            return true;
        }
        if (A0 != 109) {
            return this.f924f.requestFeature(A0);
        }
        E0();
        this.B = true;
        return true;
    }

    public final boolean x0(p pVar, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.g gVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((pVar.f983m || y0(pVar, keyEvent)) && (gVar = pVar.f980j) != null) {
            z10 = gVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f934l == null) {
            O(pVar, true);
        }
        return z10;
    }

    @Override // androidx.appcompat.app.f
    public void y(int i10) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.f944v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f923e).inflate(i10, viewGroup);
        this.f926g.a().onContentChanged();
    }

    public final boolean y0(p pVar, KeyEvent keyEvent) {
        h1 h1Var;
        h1 h1Var2;
        h1 h1Var3;
        if (this.M) {
            return false;
        }
        if (pVar.f983m) {
            return true;
        }
        p pVar2 = this.H;
        if (pVar2 != null && pVar2 != pVar) {
            O(pVar2, false);
        }
        Window.Callback d02 = d0();
        if (d02 != null) {
            pVar.f979i = d02.onCreatePanelView(pVar.f971a);
        }
        int i10 = pVar.f971a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (h1Var3 = this.f934l) != null) {
            h1Var3.f();
        }
        if (pVar.f979i == null && (!z10 || !(w0() instanceof androidx.appcompat.app.n))) {
            androidx.appcompat.view.menu.g gVar = pVar.f980j;
            if (gVar == null || pVar.f988r) {
                if (gVar == null && (!h0(pVar) || pVar.f980j == null)) {
                    return false;
                }
                if (z10 && this.f934l != null) {
                    if (this.f935m == null) {
                        this.f935m = new i();
                    }
                    this.f934l.d(pVar.f980j, this.f935m);
                }
                pVar.f980j.stopDispatchingItemsChanged();
                if (!d02.onCreatePanelMenu(pVar.f971a, pVar.f980j)) {
                    pVar.c(null);
                    if (z10 && (h1Var = this.f934l) != null) {
                        h1Var.d(null, this.f935m);
                    }
                    return false;
                }
                pVar.f988r = false;
            }
            pVar.f980j.stopDispatchingItemsChanged();
            Bundle bundle = pVar.f989s;
            if (bundle != null) {
                pVar.f980j.restoreActionViewStates(bundle);
                pVar.f989s = null;
            }
            if (!d02.onPreparePanel(0, pVar.f979i, pVar.f980j)) {
                if (z10 && (h1Var2 = this.f934l) != null) {
                    h1Var2.d(null, this.f935m);
                }
                pVar.f980j.startDispatchingItemsChanged();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            pVar.f986p = z11;
            pVar.f980j.setQwertyMode(z11);
            pVar.f980j.startDispatchingItemsChanged();
        }
        pVar.f983m = true;
        pVar.f984n = false;
        this.H = pVar;
        return true;
    }

    @Override // androidx.appcompat.app.f
    public void z(View view) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.f944v.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f926g.a().onContentChanged();
    }

    public final void z0(androidx.appcompat.view.menu.g gVar, boolean z10) {
        h1 h1Var = this.f934l;
        if (h1Var == null || !h1Var.a() || (ViewConfiguration.get(this.f923e).hasPermanentMenuKey() && !this.f934l.g())) {
            p b02 = b0(0, true);
            b02.f987q = true;
            O(b02, false);
            v0(b02, null);
            return;
        }
        Window.Callback d02 = d0();
        if (this.f934l.e() && z10) {
            this.f934l.b();
            if (this.M) {
                return;
            }
            d02.onPanelClosed(108, b0(0, true).f980j);
            return;
        }
        if (d02 == null || this.M) {
            return;
        }
        if (this.X && (this.Y & 1) != 0) {
            this.f924f.getDecorView().removeCallbacks(this.Z);
            this.Z.run();
        }
        p b03 = b0(0, true);
        androidx.appcompat.view.menu.g gVar2 = b03.f980j;
        if (gVar2 == null || b03.f988r || !d02.onPreparePanel(0, b03.f979i, gVar2)) {
            return;
        }
        d02.onMenuOpened(108, b03.f980j);
        this.f934l.c();
    }

    public h(Dialog dialog, androidx.appcompat.app.e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public h(Context context, Window window, androidx.appcompat.app.e eVar, Object obj) {
        androidx.appcompat.app.d F0;
        this.f941s = null;
        this.f942t = true;
        this.N = -100;
        this.Z = new b();
        this.f923e = context;
        this.f928h = eVar;
        this.f922d = obj;
        if (this.N == -100 && (obj instanceof Dialog) && (F0 = F0()) != null) {
            this.N = F0.getDelegate().h();
        }
        if (this.N == -100) {
            Map map = f917j0;
            Integer num = (Integer) map.get(obj.getClass());
            if (num != null) {
                this.N = num.intValue();
                map.remove(obj.getClass());
            }
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.k.h();
    }

    public class k extends g.m {
        public k(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(h.this.f923e, callback);
            g.b E = h.this.E(aVar);
            if (E != null) {
                return aVar.e(E);
            }
            return null;
        }

        @Override // g.m, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return h.this.S(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // g.m, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || h.this.p0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // g.m, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // g.m, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // g.m, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            h.this.s0(i10);
            return true;
        }

        @Override // g.m, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            super.onPanelClosed(i10, menu);
            h.this.t0(i10);
        }

        @Override // g.m, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i10 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i10, view, menu);
            if (gVar != null) {
                gVar.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @Override // g.m, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
            androidx.appcompat.view.menu.g gVar;
            p b02 = h.this.b0(0, true);
            if (b02 == null || (gVar = b02.f980j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i10);
            }
        }

        @Override // g.m, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return h.this.k0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // g.m, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (h.this.k0() && i10 == 0) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback, i10);
        }
    }
}
