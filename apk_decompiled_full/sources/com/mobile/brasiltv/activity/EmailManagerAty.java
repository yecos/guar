package com.mobile.brasiltv.activity;

import android.content.DialogInterface;
import android.view.View;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.EmailManagerAty;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.InputPwdDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import f5.d;
import h9.t;
import i6.o;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.x;
import t9.i;
import t9.j;
import xa.c;

/* loaded from: classes3.dex */
public final class EmailManagerAty extends d implements o {

    /* renamed from: l, reason: collision with root package name */
    public InputPwdDialog f7875l;

    /* renamed from: m, reason: collision with root package name */
    public LoadingView f7876m;

    /* renamed from: n, reason: collision with root package name */
    public x f7877n;

    /* renamed from: o, reason: collision with root package name */
    public Map f7878o = new LinkedHashMap();

    public static final class a extends j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m51invoke();
            return t.f14242a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m51invoke() {
            String str;
            b0.F(EmailManagerAty.this);
            InputPwdDialog inputPwdDialog = EmailManagerAty.this.f7875l;
            if (!j1.f(inputPwdDialog != null ? inputPwdDialog.getPwd() : null)) {
                EmailManagerAty.this.R(R.string.password_format_incorrect);
                return;
            }
            x S2 = EmailManagerAty.this.S2();
            InputPwdDialog inputPwdDialog2 = EmailManagerAty.this.f7875l;
            if (inputPwdDialog2 == null || (str = inputPwdDialog2.getPwd()) == null) {
                str = "";
            }
            S2.h(str);
        }
    }

    public static final void b3(EmailManagerAty emailManagerAty, View view) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.finish();
    }

    public static final void c3(EmailManagerAty emailManagerAty, View view) {
        i.g(emailManagerAty, "this$0");
        c.c().j(new GotoHomeTabEvent(2));
        b0.c0(emailManagerAty, MainAty.class);
    }

    public static final void d3(EmailManagerAty emailManagerAty, View view) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.g3();
    }

    public static final void h3(EmailManagerAty emailManagerAty, DialogInterface dialogInterface) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.f7875l = null;
    }

    public static final void i3(EmailManagerAty emailManagerAty, DialogInterface dialogInterface) {
        i.g(emailManagerAty, "this$0");
        emailManagerAty.f7876m = null;
    }

    @Override // i6.o
    public void O0() {
        InputPwdDialog inputPwdDialog = this.f7875l;
        if (inputPwdDialog != null) {
            inputPwdDialog.dismiss();
        }
        b0.c0(this, ChangeEmailAty.class);
    }

    @Override // i6.o
    public void R(int i10) {
        InputPwdDialog inputPwdDialog = this.f7875l;
        if (inputPwdDialog != null) {
            String string = getResources().getString(i10);
            i.f(string, "resources.getString(resId)");
            inputPwdDialog.setErrorHint(string);
        }
    }

    @Override // f5.d
    public void R2() {
        f3(new x(this, this));
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) Z2(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailManagerAty.b3(EmailManagerAty.this, view);
            }
        });
        ((TitleBarView) Z2(i10)).setOnCloseClickListener(new View.OnClickListener() { // from class: f5.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailManagerAty.c3(EmailManagerAty.this, view);
            }
        });
        ((AutoFrameLayout) Z2(R$id.mAflChangeBind)).setOnClickListener(new View.OnClickListener() { // from class: f5.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailManagerAty.d3(EmailManagerAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_email_manager;
    }

    public View Z2(int i10) {
        Map map = this.f7878o;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // f5.d
    /* renamed from: e3, reason: merged with bridge method [inline-methods] */
    public x S2() {
        x xVar = this.f7877n;
        if (xVar != null) {
            return xVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void f3(x xVar) {
        i.g(xVar, "<set-?>");
        this.f7877n = xVar;
    }

    public final void g3() {
        if (this.f7875l == null) {
            InputPwdDialog inputPwdDialog = new InputPwdDialog(this);
            this.f7875l = inputPwdDialog;
            inputPwdDialog.setConfirmCallback(new a());
            InputPwdDialog inputPwdDialog2 = this.f7875l;
            if (inputPwdDialog2 != null) {
                inputPwdDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: f5.j0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        EmailManagerAty.h3(EmailManagerAty.this, dialogInterface);
                    }
                });
            }
        }
        InputPwdDialog inputPwdDialog3 = this.f7875l;
        if (inputPwdDialog3 != null) {
            inputPwdDialog3.show();
        }
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.o
    public void showLoading(boolean z10) {
        if (this.f7876m == null) {
            this.f7876m = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: f5.k0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    EmailManagerAty.i3(EmailManagerAty.this, dialogInterface);
                }
            }, 6, null);
            t tVar = t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f7876m;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f7876m;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
