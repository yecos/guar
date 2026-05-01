package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SetPwdOnBeAty;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.input.AccountInputView;
import com.mobile.brasiltv.view.input.IAccountInputCallback;
import com.msandroid.mobile.R;
import f5.d;
import i6.t0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.w3;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class SetPwdOnBeAty extends d implements t0 {

    /* renamed from: q, reason: collision with root package name */
    public static final a f8132q = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public boolean f8133l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8134m;

    /* renamed from: o, reason: collision with root package name */
    public w3 f8136o;

    /* renamed from: p, reason: collision with root package name */
    public Map f8137p = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    public String f8135n = "";

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.SetPwdOnBeAty$a$a, reason: collision with other inner class name */
        public static final class C0162a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8138a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0162a(String str) {
                super(1);
                this.f8138a = str;
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                Intent putExtra = intent.putExtra("extra_email", this.f8138a);
                i.f(putExtra, "it.putExtra(EXTRA_EMAIL, email)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(f5.c cVar, String str) {
            i.g(cVar, "activity");
            i.g(str, Scopes.EMAIL);
            b0.d0(cVar, SetPwdOnBeAty.class, new C0162a(str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements IAccountInputCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onInputFocused() {
            SetPwdOnBeAty.this.g3();
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onTextChanged(boolean z10) {
            SetPwdOnBeAty.this.f8133l = z10;
            SetPwdOnBeAty.this.i3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements IAccountInputCallback {
        public c() {
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onInputFocused() {
            SetPwdOnBeAty.this.g3();
        }

        @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
        public void onTextChanged(boolean z10) {
            SetPwdOnBeAty.this.f8134m = z10;
            SetPwdOnBeAty.this.i3();
        }
    }

    public static final void c3(SetPwdOnBeAty setPwdOnBeAty, View view) {
        i.g(setPwdOnBeAty, "this$0");
        setPwdOnBeAty.finish();
    }

    public static final void d3(SetPwdOnBeAty setPwdOnBeAty, View view) {
        i.g(setPwdOnBeAty, "this$0");
        xa.c.c().j(new GotoHomeTabEvent(2));
        b0.c0(setPwdOnBeAty, MainAty.class);
    }

    public static final void e3(SetPwdOnBeAty setPwdOnBeAty, View view) {
        i.g(setPwdOnBeAty, "this$0");
        b0.F(setPwdOnBeAty);
        setPwdOnBeAty.S2().l(setPwdOnBeAty.f8135n, ((AccountInputView) setPwdOnBeAty.X2(R$id.mAivPwd)).getInputText(), ((AccountInputView) setPwdOnBeAty.X2(R$id.mAivRepeatPwd)).getInputText());
    }

    @Override // i6.t0
    public void E1(boolean z10) {
        w6.i.f19214g.q0("1");
        xa.c.c().m(new UpdateRestrictEvent("1", false, 2, null));
        xa.c.c().j(new CloseForceBindEvent());
        BindEmailSucAty.f7807r.c(this, true, this.f8135n, z10, !z10);
    }

    @Override // f5.d
    public void R2() {
        h3(new w3(this, this));
        String stringExtra = getIntent().getStringExtra("extra_email");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f8135n = stringExtra;
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) X2(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.m4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdOnBeAty.c3(SetPwdOnBeAty.this, view);
            }
        });
        ((TitleBarView) X2(i10)).setOnCloseClickListener(new View.OnClickListener() { // from class: f5.n4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdOnBeAty.d3(SetPwdOnBeAty.this, view);
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
        ((TextView) X2(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: f5.o4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdOnBeAty.e3(SetPwdOnBeAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_set_pwd_on_be;
    }

    public View X2(int i10) {
        Map map = this.f8137p;
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

    @xa.j
    public final void closePage(CloseBindEmailSucEvent closeBindEmailSucEvent) {
        i.g(closeBindEmailSucEvent, "event");
        finish();
    }

    @Override // i6.t0
    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) X2(i11)).setVisibility(0);
        ((TextView) X2(i11)).setText(getResources().getString(i10));
    }

    @Override // f5.d
    /* renamed from: f3, reason: merged with bridge method [inline-methods] */
    public w3 S2() {
        w3 w3Var = this.f8136o;
        if (w3Var != null) {
            return w3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void g3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) X2(i10)).setVisibility(8);
        ((TextView) X2(i10)).setText("");
    }

    public void h3(w3 w3Var) {
        i.g(w3Var, "<set-?>");
        this.f8136o = w3Var;
    }

    public final void i3() {
        ((TextView) X2(R$id.mTvConfirm)).setEnabled(this.f8133l && this.f8134m);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.t0
    public void showLoading(boolean z10) {
        O2(z10);
    }
}
