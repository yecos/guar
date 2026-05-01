package androidx.mediarouter.app;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.appcompat.widget.u2;
import androidx.fragment.app.o;
import androidx.fragment.app.y;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$string;
import androidx.mediarouter.R$styleable;
import b0.c1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n0.o1;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class MediaRouteButton extends View {

    /* renamed from: p, reason: collision with root package name */
    public static a f2693p;

    /* renamed from: q, reason: collision with root package name */
    public static final SparseArray f2694q = new SparseArray(2);

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f2695r = {R.attr.state_checked};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f2696s = {R.attr.state_checkable};

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2697a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2698b;

    /* renamed from: c, reason: collision with root package name */
    public s0 f2699c;

    /* renamed from: d, reason: collision with root package name */
    public e f2700d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2701e;

    /* renamed from: f, reason: collision with root package name */
    public int f2702f;

    /* renamed from: g, reason: collision with root package name */
    public c f2703g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f2704h;

    /* renamed from: i, reason: collision with root package name */
    public int f2705i;

    /* renamed from: j, reason: collision with root package name */
    public int f2706j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f2707k;

    /* renamed from: l, reason: collision with root package name */
    public int f2708l;

    /* renamed from: m, reason: collision with root package name */
    public int f2709m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2710n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2711o;

    public static final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2712a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2713b = true;

        /* renamed from: c, reason: collision with root package name */
        public List f2714c = new ArrayList();

        public a(Context context) {
            this.f2712a = context;
        }

        public boolean a() {
            return this.f2713b;
        }

        public void b(MediaRouteButton mediaRouteButton) {
            if (this.f2714c.size() == 0) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f2712a.registerReceiver(this, intentFilter);
            }
            this.f2714c.add(mediaRouteButton);
        }

        public void c(MediaRouteButton mediaRouteButton) {
            this.f2714c.remove(mediaRouteButton);
            if (this.f2714c.size() == 0) {
                this.f2712a.unregisterReceiver(this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z10;
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || this.f2713b == (!intent.getBooleanExtra("noConnectivity", false))) {
                return;
            }
            this.f2713b = z10;
            Iterator it = this.f2714c.iterator();
            while (it.hasNext()) {
                ((MediaRouteButton) it.next()).c();
            }
        }
    }

    public final class b extends t0.b {
        public b() {
        }

        @Override // n0.t0.b
        public void onProviderAdded(t0 t0Var, t0.h hVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onProviderChanged(t0 t0Var, t0.h hVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onProviderRemoved(t0 t0Var, t0.h hVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        @Override // n0.t0.b
        public void onRouteUnselected(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }
    }

    public final class c extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final int f2716a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f2717b;

        public c(int i10, Context context) {
            this.f2716a = i10;
            this.f2717b = context;
        }

        public final void a(Drawable drawable) {
            if (drawable != null) {
                MediaRouteButton.f2694q.put(this.f2716a, drawable.getConstantState());
            }
            MediaRouteButton.this.f2703g = null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            if (((Drawable.ConstantState) MediaRouteButton.f2694q.get(this.f2716a)) == null) {
                return this.f2717b.getResources().getDrawable(this.f2716a);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Drawable drawable) {
            a(drawable);
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            if (drawable != null) {
                a(drawable);
            } else {
                Drawable.ConstantState constantState = (Drawable.ConstantState) MediaRouteButton.f2694q.get(this.f2716a);
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                MediaRouteButton.this.f2703g = null;
            }
            MediaRouteButton.this.setRemoteIndicatorDrawableInternal(drawable);
        }
    }

    public MediaRouteButton(Context context) {
        this(context, null);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private o getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof androidx.fragment.app.e) {
            return ((androidx.fragment.app.e) activity).getSupportFragmentManager();
        }
        return null;
    }

    public final void a() {
        if (this.f2705i > 0) {
            c cVar = this.f2703g;
            if (cVar != null) {
                cVar.cancel(false);
            }
            c cVar2 = new c(this.f2705i, getContext());
            this.f2703g = cVar2;
            this.f2705i = 0;
            cVar2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public void b() {
        boolean z10;
        t0.i m10 = this.f2697a.m();
        int c10 = !m10.w() && m10.E(this.f2699c) ? m10.c() : 0;
        if (this.f2706j != c10) {
            this.f2706j = c10;
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            g();
            refreshDrawableState();
        }
        if (c10 == 1) {
            a();
        }
        if (this.f2701e) {
            setEnabled(this.f2710n || this.f2697a.o(this.f2699c, 1));
        }
        Drawable drawable = this.f2704h;
        if (drawable == null || !(drawable.getCurrent() instanceof AnimationDrawable)) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f2704h.getCurrent();
        if (this.f2701e) {
            if ((z10 || c10 == 1) && !animationDrawable.isRunning()) {
                animationDrawable.start();
                return;
            }
            return;
        }
        if (c10 == 2) {
            if (animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
            animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
        }
    }

    public void c() {
        super.setVisibility((this.f2702f != 0 || this.f2710n || f2693p.a()) ? this.f2702f : 4);
        Drawable drawable = this.f2704h;
        if (drawable != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    public boolean d() {
        if (!this.f2701e) {
            return false;
        }
        o1 k10 = this.f2697a.k();
        if (k10 == null) {
            return e(1);
        }
        if (k10.c() && t0.n() && f()) {
            return true;
        }
        return e(k10.a());
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2704h != null) {
            this.f2704h.setState(getDrawableState());
            invalidate();
        }
    }

    public final boolean e(int i10) {
        o fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        t0.i m10 = this.f2697a.m();
        if (m10.w() || !m10.E(this.f2699c)) {
            if (fragmentManager.h0("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                return false;
            }
            androidx.mediarouter.app.b b10 = this.f2700d.b();
            b10.U2(this.f2699c);
            if (i10 == 2) {
                b10.V2(true);
            }
            y m11 = fragmentManager.m();
            m11.e(b10, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
            m11.i();
        } else {
            if (fragmentManager.h0("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
                return false;
            }
            d c10 = this.f2700d.c();
            c10.T2(this.f2699c);
            if (i10 == 2) {
                c10.U2(true);
            }
            y m12 = fragmentManager.m();
            m12.e(c10, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
            m12.i();
        }
        return true;
    }

    public final boolean f() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        Intent putExtra = new Intent().setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName()).putExtra("key_media_session_token", this.f2697a.j());
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(putExtra, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & 129) != 0) {
                context.startActivity(putExtra);
                return true;
            }
        }
        return false;
    }

    public final void g() {
        int i10 = this.f2706j;
        String string = getContext().getString(i10 != 1 ? i10 != 2 ? R$string.mr_cast_button_disconnected : R$string.mr_cast_button_connected : R$string.mr_cast_button_connecting);
        setContentDescription(string);
        if (!this.f2711o || TextUtils.isEmpty(string)) {
            string = null;
        }
        u2.a(this, string);
    }

    public e getDialogFactory() {
        return this.f2700d;
    }

    public s0 getRouteSelector() {
        return this.f2699c;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2704h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.f2701e = true;
        if (!this.f2699c.f()) {
            this.f2697a.a(this.f2699c, this.f2698b);
        }
        b();
        f2693p.b(this);
    }

    @Override // android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        t0 t0Var = this.f2697a;
        if (t0Var == null) {
            return onCreateDrawableState;
        }
        o1 k10 = t0Var.k();
        if (k10 != null ? k10.b().getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON") : false) {
            return onCreateDrawableState;
        }
        int i11 = this.f2706j;
        if (i11 == 1) {
            View.mergeDrawableStates(onCreateDrawableState, f2696s);
        } else if (i11 == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f2695r);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f2701e = false;
            if (!this.f2699c.f()) {
                this.f2697a.q(this.f2698b);
            }
            f2693p.c(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2704h != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f2704h.getIntrinsicWidth();
            int intrinsicHeight = this.f2704h.getIntrinsicHeight();
            int i10 = paddingLeft + (((width - paddingLeft) - intrinsicWidth) / 2);
            int i11 = paddingTop + (((height - paddingTop) - intrinsicHeight) / 2);
            this.f2704h.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f2704h.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i12 = this.f2708l;
        Drawable drawable = this.f2704h;
        int max = Math.max(i12, drawable != null ? drawable.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight() : 0);
        int i13 = this.f2709m;
        Drawable drawable2 = this.f2704h;
        int max2 = Math.max(i13, drawable2 != null ? drawable2.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() : 0);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, max);
        } else if (mode != 1073741824) {
            size = max;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, max2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        a();
        return d() || performClick;
    }

    public void setAlwaysVisible(boolean z10) {
        if (z10 != this.f2710n) {
            this.f2710n = z10;
            c();
            b();
        }
    }

    public void setCheatSheetEnabled(boolean z10) {
        if (z10 != this.f2711o) {
            this.f2711o = z10;
            g();
        }
    }

    public void setDialogFactory(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.f2700d = eVar;
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.f2705i = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        Drawable drawable2;
        c cVar = this.f2703g;
        if (cVar != null) {
            cVar.cancel(false);
        }
        Drawable drawable3 = this.f2704h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2704h);
        }
        if (drawable != null) {
            if (this.f2707k != null) {
                drawable = s.h.r(drawable.mutate());
                s.h.o(drawable, this.f2707k);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
        }
        this.f2704h = drawable;
        refreshDrawableState();
        if (this.f2701e && (drawable2 = this.f2704h) != null && (drawable2.getCurrent() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f2704h.getCurrent();
            int i10 = this.f2706j;
            if (i10 == 1) {
                if (animationDrawable.isRunning()) {
                    return;
                }
                animationDrawable.start();
            } else if (i10 == 2) {
                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }
                animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
            }
        }
    }

    public void setRouteSelector(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f2699c.equals(s0Var)) {
            return;
        }
        if (this.f2701e) {
            if (!this.f2699c.f()) {
                this.f2697a.q(this.f2698b);
            }
            if (!s0Var.f()) {
                this.f2697a.a(s0Var, this.f2698b);
            }
        }
        this.f2699c = s0Var;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        this.f2702f = i10;
        c();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2704h;
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.mediaRouteButtonStyle);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i10) {
        super(i.a(context), attributeSet, i10);
        Drawable.ConstantState constantState;
        this.f2699c = s0.f17005c;
        this.f2700d = e.a();
        this.f2702f = 0;
        Context context2 = getContext();
        int[] iArr = R$styleable.A;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        c1.i0(this, context2, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        if (isInEditMode()) {
            this.f2697a = null;
            this.f2698b = null;
            this.f2704h = getResources().getDrawable(obtainStyledAttributes.getResourceId(R$styleable.MediaRouteButton_externalRouteEnabledDrawableStatic, 0));
            return;
        }
        this.f2697a = t0.i(context2);
        this.f2698b = new b();
        if (f2693p == null) {
            f2693p = new a(context2.getApplicationContext());
        }
        this.f2707k = obtainStyledAttributes.getColorStateList(R$styleable.MediaRouteButton_mediaRouteButtonTint);
        this.f2708l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MediaRouteButton_android_minWidth, 0);
        this.f2709m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MediaRouteButton_android_minHeight, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MediaRouteButton_externalRouteEnabledDrawableStatic, 0);
        this.f2705i = obtainStyledAttributes.getResourceId(R$styleable.MediaRouteButton_externalRouteEnabledDrawable, 0);
        obtainStyledAttributes.recycle();
        int i11 = this.f2705i;
        if (i11 != 0 && (constantState = (Drawable.ConstantState) f2694q.get(i11)) != null) {
            setRemoteIndicatorDrawable(constantState.newDrawable());
        }
        if (this.f2704h == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) f2694q.get(resourceId);
                if (constantState2 != null) {
                    setRemoteIndicatorDrawableInternal(constantState2.newDrawable());
                } else {
                    c cVar = new c(resourceId, getContext());
                    this.f2703g = cVar;
                    cVar.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                a();
            }
        }
        g();
        setClickable(true);
    }
}
