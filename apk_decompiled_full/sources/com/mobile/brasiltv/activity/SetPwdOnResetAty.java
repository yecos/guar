package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SetPwdOnResetAty;
import com.mobile.brasiltv.bean.event.CloseResetPageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.input.AccountInputView;
import com.mobile.brasiltv.view.input.IAccountInputCallback;
import com.msandroid.mobile.R;
import f5.d;
import i6.u0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.x3;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class SetPwdOnResetAty extends d implements u0 {

    /* renamed from: t, reason: collision with root package name */
    public static final a f8141t = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public boolean f8142l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8143m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8144n;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8147q;

    /* renamed from: r, reason: collision with root package name */
    public x3 f8148r;

    /* renamed from: s, reason: collision with root package name */
    public Map f8149s = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    public String f8145o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f8146p = "";

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.SetPwdOnResetAty$a$a, reason: collision with other inner class name */
        public static final class C0163a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8150a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f8151b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f8152c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f8153d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f8154e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0163a(String str, boolean z10, String str2, boolean z11, boolean z12) {
                super(1);
                this.f8150a = str;
                this.f8151b = z10;
                this.f8152c = str2;
                this.f8153d = z11;
                this.f8154e = z12;
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                intent.putExtra("extra_email", this.f8150a);
                intent.putExtra("extra_from_login", this.f8151b);
                intent.putExtra("extra_verify_code", this.f8152c);
                intent.putExtra("extra_need_auto_login", this.f8153d);
                Intent putExtra = intent.putExtra("is_force", this.f8154e);
                i.f(putExtra, "it.putExtra(ResetAty.IS_FORCE,mIsForce)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(f5.c cVar, String str, String str2, boolean z10, boolean z11, boolean z12) {
            i.g(cVar, "activity");
            i.g(str, Scopes.EMAIL);
            i.g(str2, "verifyCode");
            b0.d0(cVar, SetPwdOnResetAty.class, new C0163a(str, z10, str2, z11, z12));
        }
    }

    public static final class b implements IAccountInputCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onInputFocused() {
            SetPwdOnResetAty.this.g3();
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onTextChanged(boolean z10) {
            SetPwdOnResetAty.this.f8143m = z10;
            SetPwdOnResetAty.this.i3();
        }
    }

    public static final class c implements IAccountInputCallback {
        public c() {
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onInputFocused() {
            SetPwdOnResetAty.this.g3();
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onTextChanged(boolean z10) {
            SetPwdOnResetAty.this.f8144n = z10;
            SetPwdOnResetAty.this.i3();
        }
    }

    public static final void c3(SetPwdOnResetAty setPwdOnResetAty, View view) {
        i.g(setPwdOnResetAty, "this$0");
        setPwdOnResetAty.finish();
    }

    public static final void d3(SetPwdOnResetAty setPwdOnResetAty, View view) {
        i.g(setPwdOnResetAty, "this$0");
        if (setPwdOnResetAty.f8147q) {
            xa.c.c().j(new CloseResetPageEvent());
            setPwdOnResetAty.finish();
        } else if (setPwdOnResetAty.f8142l) {
            xa.c.c().j(new CloseResetPageEvent());
            setPwdOnResetAty.finish();
        } else {
            xa.c.c().j(new GotoHomeTabEvent(2));
            b0.c0(setPwdOnResetAty, MainAty.class);
        }
    }

    public static final void e3(SetPwdOnResetAty setPwdOnResetAty, View view) {
        i.g(setPwdOnResetAty, "this$0");
        b0.F(setPwdOnResetAty);
        setPwdOnResetAty.S2().l(setPwdOnResetAty.f8145o, ((AccountInputView) setPwdOnResetAty.X2(R$id.mAivPwd)).getInputText(), ((AccountInputView) setPwdOnResetAty.X2(R$id.mAivRepeatPwd)).getInputText(), setPwdOnResetAty.f8146p, setPwdOnResetAty.getIntent().getBooleanExtra("extra_need_auto_login", true));
    }

    @Override // f5.d
    public void R2() {
        h3(new x3(this, this));
        String stringExtra = getIntent().getStringExtra("extra_email");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f8145o = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("extra_verify_code");
        this.f8146p = stringExtra2 != null ? stringExtra2 : "";
        this.f8147q = getIntent().getBooleanExtra("extra_from_login", false);
        this.f8142l = getIntent().getBooleanExtra("is_force", false);
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) X2(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.p4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdOnResetAty.c3(SetPwdOnResetAty.this, view);
            }
        });
        ((TitleBarView) X2(i10)).setOnCloseClickListener(new View.OnClickListener() { // from class: f5.q4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdOnResetAty.d3(SetPwdOnResetAty.this, view);
            }
        });
        int i11 = R$id.mAivPwd;
        AccountInputView accountInputView = (AccountInputView) X2(i11);
        PasswordTransformationMethod passwordTransformationMethod = PasswordTransformationMethod.getInstance();
        i.f(passwordTransformationMethod, "getInstance()");
        accountInputView.setTransformationMethod(passwordTransformationMethod);
        int i12 = R$id.mAivRepeatPwd;
        AccountInputView accountInputView2 = (AccountInputView) X2(i12);
        PasswordTransformationMethod passwordTransformationMethod2 = PasswordTransformationMethod.getInstance();
        i.f(passwordTransformationMethod2, "getInstance()");
        accountInputView2.setTransformationMethod(passwordTransformationMethod2);
        ((AccountInputView) X2(i11)).setAccountInputCallback(new b());
        ((AccountInputView) X2(i12)).setAccountInputCallback(new c());
        ((TextView) X2(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: f5.r4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdOnResetAty.e3(SetPwdOnResetAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_set_pwd_on_reset;
    }

    public View X2(int i10) {
        Map map = this.f8149s;
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

    @Override // i6.u0
    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) X2(i11)).setVisibility(0);
        ((TextView) X2(i11)).setText(getResources().getString(i10));
    }

    @Override // f5.d
    /* renamed from: f3, reason: merged with bridge method [inline-methods] */
    public x3 S2() {
        x3 x3Var = this.f8148r;
        if (x3Var != null) {
            return x3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void g3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) X2(i10)).setVisibility(8);
        ((TextView) X2(i10)).setText("");
    }

    public void h3(x3 x3Var) {
        i.g(x3Var, "<set-?>");
        this.f8148r = x3Var;
    }

    public final void i3() {
        ((TextView) X2(R$id.mTvConfirm)).setEnabled(this.f8143m && this.f8144n);
    }

    @Override // i6.u0
    public void j1(boolean z10) {
        ResetPwdSucAty.f8059q.a(this, z10);
        xa.c.c().j(new CloseResetPageEvent());
        finish();
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.u0
    public void showLoading(boolean z10) {
        O2(z10);
    }

    @Override // i6.u0
    public void x() {
        xa.c.c().j(new CloseResetPageEvent());
        finish();
    }
}
