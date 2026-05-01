package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public class v2 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j, reason: collision with root package name */
    public static v2 f1658j;

    /* renamed from: k, reason: collision with root package name */
    public static v2 f1659k;

    /* renamed from: a, reason: collision with root package name */
    public final View f1660a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f1661b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1662c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f1663d = new a();

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f1664e = new b();

    /* renamed from: f, reason: collision with root package name */
    public int f1665f;

    /* renamed from: g, reason: collision with root package name */
    public int f1666g;

    /* renamed from: h, reason: collision with root package name */
    public w2 f1667h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1668i;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v2.this.g(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v2.this.c();
        }
    }

    public v2(View view, CharSequence charSequence) {
        this.f1660a = view;
        this.f1661b = charSequence;
        this.f1662c = b0.p1.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void e(v2 v2Var) {
        v2 v2Var2 = f1658j;
        if (v2Var2 != null) {
            v2Var2.a();
        }
        f1658j = v2Var;
        if (v2Var != null) {
            v2Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        v2 v2Var = f1658j;
        if (v2Var != null && v2Var.f1660a == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new v2(view, charSequence);
            return;
        }
        v2 v2Var2 = f1659k;
        if (v2Var2 != null && v2Var2.f1660a == view) {
            v2Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void a() {
        this.f1660a.removeCallbacks(this.f1663d);
    }

    public final void b() {
        this.f1665f = Integer.MAX_VALUE;
        this.f1666g = Integer.MAX_VALUE;
    }

    public void c() {
        if (f1659k == this) {
            f1659k = null;
            w2 w2Var = this.f1667h;
            if (w2Var != null) {
                w2Var.c();
                this.f1667h = null;
                b();
                this.f1660a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1658j == this) {
            e(null);
        }
        this.f1660a.removeCallbacks(this.f1664e);
    }

    public final void d() {
        this.f1660a.postDelayed(this.f1663d, ViewConfiguration.getLongPressTimeout());
    }

    public void g(boolean z10) {
        long longPressTimeout;
        long j10;
        long j11;
        if (b0.c1.P(this.f1660a)) {
            e(null);
            v2 v2Var = f1659k;
            if (v2Var != null) {
                v2Var.c();
            }
            f1659k = this;
            this.f1668i = z10;
            w2 w2Var = new w2(this.f1660a.getContext());
            this.f1667h = w2Var;
            w2Var.e(this.f1660a, this.f1665f, this.f1666g, this.f1668i, this.f1661b);
            this.f1660a.addOnAttachStateChangeListener(this);
            if (this.f1668i) {
                j11 = 2500;
            } else {
                if ((b0.c1.J(this.f1660a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 15000;
                }
                j11 = j10 - longPressTimeout;
            }
            this.f1660a.removeCallbacks(this.f1664e);
            this.f1660a.postDelayed(this.f1664e, j11);
        }
    }

    public final boolean h(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (Math.abs(x10 - this.f1665f) <= this.f1662c && Math.abs(y10 - this.f1666g) <= this.f1662c) {
            return false;
        }
        this.f1665f = x10;
        this.f1666g = y10;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1667h != null && this.f1668i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1660a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1660a.isEnabled() && this.f1667h == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1665f = view.getWidth() / 2;
        this.f1666g = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
