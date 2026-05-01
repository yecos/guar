package androidx.mediarouter.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class MediaRouteActionProvider extends b0.b {

    /* renamed from: d, reason: collision with root package name */
    public final t0 f2686d;

    /* renamed from: e, reason: collision with root package name */
    public final a f2687e;

    /* renamed from: f, reason: collision with root package name */
    public s0 f2688f;

    /* renamed from: g, reason: collision with root package name */
    public e f2689g;

    /* renamed from: h, reason: collision with root package name */
    public MediaRouteButton f2690h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2691i;

    public static final class a extends t0.b {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f2692a;

        public a(MediaRouteActionProvider mediaRouteActionProvider) {
            this.f2692a = new WeakReference(mediaRouteActionProvider);
        }

        public final void a(t0 t0Var) {
            MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) this.f2692a.get();
            if (mediaRouteActionProvider != null) {
                mediaRouteActionProvider.n();
            } else {
                t0Var.q(this);
            }
        }

        @Override // n0.t0.b
        public void onProviderAdded(t0 t0Var, t0.h hVar) {
            a(t0Var);
        }

        @Override // n0.t0.b
        public void onProviderChanged(t0 t0Var, t0.h hVar) {
            a(t0Var);
        }

        @Override // n0.t0.b
        public void onProviderRemoved(t0 t0Var, t0.h hVar) {
            a(t0Var);
        }

        @Override // n0.t0.b
        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            a(t0Var);
        }

        @Override // n0.t0.b
        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            a(t0Var);
        }

        @Override // n0.t0.b
        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            a(t0Var);
        }
    }

    public MediaRouteActionProvider(Context context) {
        super(context);
        this.f2688f = s0.f17005c;
        this.f2689g = e.a();
        this.f2686d = t0.i(context);
        this.f2687e = new a(this);
    }

    @Override // b0.b
    public boolean c() {
        return this.f2691i || this.f2686d.o(this.f2688f, 1);
    }

    @Override // b0.b
    public View d() {
        if (this.f2690h != null) {
            Log.e("MRActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
        }
        MediaRouteButton m10 = m();
        this.f2690h = m10;
        m10.setCheatSheetEnabled(true);
        this.f2690h.setRouteSelector(this.f2688f);
        this.f2690h.setAlwaysVisible(this.f2691i);
        this.f2690h.setDialogFactory(this.f2689g);
        this.f2690h.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return this.f2690h;
    }

    @Override // b0.b
    public boolean f() {
        MediaRouteButton mediaRouteButton = this.f2690h;
        if (mediaRouteButton != null) {
            return mediaRouteButton.d();
        }
        return false;
    }

    @Override // b0.b
    public boolean h() {
        return true;
    }

    public MediaRouteButton m() {
        return new MediaRouteButton(a());
    }

    public void n() {
        i();
    }

    public void o(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f2688f.equals(s0Var)) {
            return;
        }
        if (!this.f2688f.f()) {
            this.f2686d.q(this.f2687e);
        }
        if (!s0Var.f()) {
            this.f2686d.a(s0Var, this.f2687e);
        }
        this.f2688f = s0Var;
        n();
        MediaRouteButton mediaRouteButton = this.f2690h;
        if (mediaRouteButton != null) {
            mediaRouteButton.setRouteSelector(s0Var);
        }
    }
}
