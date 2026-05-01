package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class l extends g {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f2328a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2329b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f2330c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2331d;

    /* renamed from: e, reason: collision with root package name */
    public final o f2332e;

    public l(e eVar) {
        this(eVar, eVar, new Handler(), 0);
    }

    Activity e() {
        return this.f2328a;
    }

    Context f() {
        return this.f2329b;
    }

    Handler g() {
        return this.f2330c;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object i();

    public abstract LayoutInflater j();

    public void k(Fragment fragment, String[] strArr, int i10) {
    }

    public abstract boolean l(Fragment fragment);

    public abstract boolean m(String str);

    public void n(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        p.a.startActivity(this.f2329b, intent, bundle);
    }

    public void o(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (i10 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        o.h.k(this.f2328a, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public abstract void p();

    public l(Activity activity, Context context, Handler handler, int i10) {
        this.f2332e = new p();
        this.f2328a = activity;
        this.f2329b = (Context) a0.h.e(context, "context == null");
        this.f2330c = (Handler) a0.h.e(handler, "handler == null");
        this.f2331d = i10;
    }
}
