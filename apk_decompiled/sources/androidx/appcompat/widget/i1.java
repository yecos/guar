package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
public interface i1 {
    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    void d(Menu menu, m.a aVar);

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int i10);

    void j(CharSequence charSequence);

    Menu k();

    int l();

    b0.a2 m(int i10, long j10);

    ViewGroup n();

    void o(boolean z10);

    void p();

    void q(boolean z10);

    void r();

    void s(j2 j2Var);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i10);

    void u(int i10);

    void v(m.a aVar, g.a aVar2);

    void w(int i10);

    int x();

    void y();
}
