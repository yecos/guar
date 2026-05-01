package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import n0.s0;

/* loaded from: classes.dex */
public class d extends androidx.fragment.app.d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2842a = false;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f2843b;

    /* renamed from: c, reason: collision with root package name */
    public s0 f2844c;

    public d() {
        setCancelable(true);
    }

    public final void Q2() {
        if (this.f2844c == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f2844c = s0.d(arguments.getBundle("selector"));
            }
            if (this.f2844c == null) {
                this.f2844c = s0.f17005c;
            }
        }
    }

    public c R2(Context context, Bundle bundle) {
        return new c(context);
    }

    public h S2(Context context) {
        return new h(context);
    }

    public void T2(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Q2();
        if (this.f2844c.equals(s0Var)) {
            return;
        }
        this.f2844c = s0Var;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle("selector", s0Var.a());
        setArguments(arguments);
        Dialog dialog = this.f2843b;
        if (dialog == null || !this.f2842a) {
            return;
        }
        ((h) dialog).j(s0Var);
    }

    public void U2(boolean z10) {
        if (this.f2843b != null) {
            throw new IllegalStateException("This must be called before creating dialog");
        }
        this.f2842a = z10;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f2843b;
        if (dialog != null) {
            if (this.f2842a) {
                ((h) dialog).l();
            } else {
                ((c) dialog).A();
            }
        }
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2842a) {
            h S2 = S2(getContext());
            this.f2843b = S2;
            S2.j(this.f2844c);
        } else {
            this.f2843b = R2(getContext(), bundle);
        }
        return this.f2843b;
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2843b;
        if (dialog == null || this.f2842a) {
            return;
        }
        ((c) dialog).e(false);
    }
}
