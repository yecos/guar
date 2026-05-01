package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import n0.s0;

/* loaded from: classes.dex */
public class b extends androidx.fragment.app.d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2763a = false;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f2764b;

    /* renamed from: c, reason: collision with root package name */
    public s0 f2765c;

    public b() {
        setCancelable(true);
    }

    public final void Q2() {
        if (this.f2765c == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f2765c = s0.d(arguments.getBundle("selector"));
            }
            if (this.f2765c == null) {
                this.f2765c = s0.f17005c;
            }
        }
    }

    public s0 R2() {
        Q2();
        return this.f2765c;
    }

    public a S2(Context context, Bundle bundle) {
        return new a(context);
    }

    public g T2(Context context) {
        return new g(context);
    }

    public void U2(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Q2();
        if (this.f2765c.equals(s0Var)) {
            return;
        }
        this.f2765c = s0Var;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle("selector", s0Var.a());
        setArguments(arguments);
        Dialog dialog = this.f2764b;
        if (dialog != null) {
            if (this.f2763a) {
                ((g) dialog).d(s0Var);
            } else {
                ((a) dialog).d(s0Var);
            }
        }
    }

    public void V2(boolean z10) {
        if (this.f2764b != null) {
            throw new IllegalStateException("This must be called before creating dialog");
        }
        this.f2763a = z10;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f2764b;
        if (dialog == null) {
            return;
        }
        if (this.f2763a) {
            ((g) dialog).e();
        } else {
            ((a) dialog).e();
        }
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2763a) {
            g T2 = T2(getContext());
            this.f2764b = T2;
            T2.d(R2());
        } else {
            a S2 = S2(getContext(), bundle);
            this.f2764b = S2;
            S2.d(R2());
        }
        return this.f2764b;
    }
}
