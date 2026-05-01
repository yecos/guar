package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.PhoneBindAty;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.k;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.input.EmailPrefixInputView;
import com.mobile.brasiltv.view.input.IEmailPrefixInputCallback;
import com.mobile.brasiltv.view.login.IVerifyCodeCallback;
import com.mobile.brasiltv.view.login.VerifyCodeView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.bt;
import com.zhy.autolayout.AutoLinearLayout;
import h9.g;
import h9.h;
import i6.c0;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.i1;
import na.f;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class PhoneBindAty extends f5.d implements c0 {

    /* renamed from: l, reason: collision with root package name */
    public boolean f7985l;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7991r;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7994u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7995v;

    /* renamed from: z, reason: collision with root package name */
    public i1 f7999z;
    public Map A = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name */
    public String f7986m = "Brazil";

    /* renamed from: n, reason: collision with root package name */
    public String f7987n = "55";

    /* renamed from: o, reason: collision with root package name */
    public String f7988o = "1";

    /* renamed from: p, reason: collision with root package name */
    public int f7989p = 1;

    /* renamed from: q, reason: collision with root package name */
    public Handler f7990q = new Handler();

    /* renamed from: s, reason: collision with root package name */
    public String f7992s = "1";

    /* renamed from: t, reason: collision with root package name */
    public int f7993t = 180;

    /* renamed from: w, reason: collision with root package name */
    public final g f7996w = h.b(new d());

    /* renamed from: x, reason: collision with root package name */
    public Runnable f7997x = new c();

    /* renamed from: y, reason: collision with root package name */
    public Runnable f7998y = new Runnable() { // from class: f5.q2
        @Override // java.lang.Runnable
        public final void run() {
            PhoneBindAty.i3(PhoneBindAty.this);
        }
    };

    /* loaded from: classes3.dex */
    public static final class a implements IEmailPrefixInputCallback {
        public a() {
        }

        @Override // com.mobile.brasiltv.view.input.IEmailPrefixInputCallback
        public void onInputFocused() {
            PhoneBindAty.this.f3();
        }

        @Override // com.mobile.brasiltv.view.input.IEmailPrefixInputCallback
        public void onTextChanged(boolean z10) {
            PhoneBindAty.this.f7994u = z10;
            ((VerifyCodeView) PhoneBindAty.this.W2(R$id.mVcvVerifyCode)).setSendEnabled(PhoneBindAty.this.f7994u);
            PhoneBindAty.this.m3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements IVerifyCodeCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
        public void onSendSms() {
            ((TextView) PhoneBindAty.this.W2(R$id.mTvConfirm)).requestFocus();
            b0.F(PhoneBindAty.this);
            PhoneBindAty.this.S2().o(((EmailPrefixInputView) PhoneBindAty.this.W2(R$id.mEpiEmail)).getFullEmailText());
        }

        @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
        public void onVerifyCodeChanged(String str) {
            i.g(str, "content");
            PhoneBindAty.this.f7995v = b0.K(str);
            PhoneBindAty.this.m3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Serializable invoke() {
            return PhoneBindAty.this.getIntent().getSerializableExtra("type");
        }
    }

    public static final void d3(PhoneBindAty phoneBindAty, View view) {
        i.g(phoneBindAty, "this$0");
        phoneBindAty.f3();
        phoneBindAty.S2().k(((EmailPrefixInputView) phoneBindAty.W2(R$id.mEpiEmail)).getFullEmailText(), ((VerifyCodeView) phoneBindAty.W2(R$id.mVcvVerifyCode)).getVerifyCode());
    }

    public static final void i3(PhoneBindAty phoneBindAty) {
        i.g(phoneBindAty, "this$0");
        TextView textView = (TextView) phoneBindAty.W2(R$id.errorTx);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // i6.c0
    public void B() {
        BindEmailSucAty.f7807r.a(this);
    }

    @Override // i6.c0
    public void K() {
        SetPwdOnBeAty.f8132q.a(this, ((EmailPrefixInputView) W2(R$id.mEpiEmail)).getFullEmailText());
    }

    @Override // f5.d
    public void R2() {
        j3(new i1(this, this));
        g3();
        h3();
        this.f7991r = getIntent().getBooleanExtra("toLogin", false);
        int i10 = R$id.mEpiEmail;
        ((EmailPrefixInputView) W2(i10)).setInputFilter(new b7.a());
        ((EmailPrefixInputView) W2(i10)).setEmailSuffixList(i9.j.c("@gmail.com"));
        ((EmailPrefixInputView) W2(i10)).setEmailPrefixInputCallback(new a());
        ((VerifyCodeView) W2(R$id.mVcvVerifyCode)).setVerifyCodeCallback(new b());
        ((TextView) W2(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: f5.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindAty.d3(PhoneBindAty.this, view);
            }
        });
        k3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_phonebind;
    }

    public View W2(int i10) {
        Map map = this.A;
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

    public final void c3(String str) {
        int i10 = R$id.errorTx;
        ((TextView) W2(i10)).setVisibility(8);
        if (i.b(str, "1")) {
            this.f7989p = 1;
            ((AutoLinearLayout) W2(R$id.mailBindPage)).setVisibility(8);
            ((TextView) W2(i10)).setVisibility(8);
        } else if (i.b(str, "2")) {
            this.f7989p = 2;
            ((TextView) W2(i10)).setVisibility(8);
            ((AutoLinearLayout) W2(R$id.mailBindPage)).setVisibility(0);
        }
    }

    @xa.j
    public final void closePage(CloseBindEmailSucEvent closeBindEmailSucEvent) {
        i.g(closeBindEmailSucEvent, "event");
        finish();
    }

    @Override // i6.c0
    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) W2(i11)).setVisibility(0);
        ((TextView) W2(i11)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) W2(i11)).setText(getResources().getString(i10));
    }

    @Override // i6.c0
    public void e(List list) {
        i.g(list, "emailSuffixList");
        ((EmailPrefixInputView) W2(R$id.mEpiEmail)).setEmailSuffixList(list);
    }

    @Override // f5.d
    /* renamed from: e3, reason: merged with bridge method [inline-methods] */
    public i1 S2() {
        i1 i1Var = this.f7999z;
        if (i1Var != null) {
            return i1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void f3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) W2(i10)).setVisibility(4);
        ((TextView) W2(i10)).setText("");
    }

    public final void g3() {
        String stringExtra = getIntent().getStringExtra("bind_from");
        if (stringExtra == null) {
            stringExtra = "1";
        }
        this.f7988o = stringExtra;
        c3("2");
    }

    public final void h3() {
        int i10 = R$id.titleView;
        ((TitleView) W2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) W2(i10)).getSettingView().setVisibility(8);
        ((TitleView) W2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) W2(i10)).setIvMenuSrc(0);
        ((TitleView) W2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) W2(i10)).setTvMenuText("");
    }

    @Override // i6.c0
    public void i() {
        l3();
        k.f8726a.c("key_verifycode_bind_time", System.currentTimeMillis());
        VerifyCodeView verifyCodeView = (VerifyCodeView) W2(R$id.mVcvVerifyCode);
        i.f(verifyCodeView, "mVcvVerifyCode");
        VerifyCodeView.startCountDown$default(verifyCodeView, 0L, 1, null);
    }

    public void j3(i1 i1Var) {
        i.g(i1Var, "<set-?>");
        this.f7999z = i1Var;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k3() {
        long currentTimeMillis = 180 - ((System.currentTimeMillis() - k.f8726a.b("key_verifycode_bind_time")) / 1000);
        if (currentTimeMillis > 0) {
            ((VerifyCodeView) W2(R$id.mVcvVerifyCode)).startCountDown(currentTimeMillis);
        }
    }

    public final void l3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) W2(i10)).setVisibility(0);
        ((TextView) W2(i10)).setTextColor(getResources().getColor(R.color.color_ffffff));
        ((TextView) W2(i10)).setText(Html.fromHtml(getResources().getString(R.string.be_goto_email_and_view, "<font color=\"#3cd977\">" + ((EmailPrefixInputView) W2(R$id.mEpiEmail)).getFullEmailText() + "</font>")));
    }

    public final void m3() {
        ((TextView) W2(R$id.mTvConfirm)).setEnabled(this.f7994u && this.f7995v);
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == SelectNationAty.f8104p.a() && i10 == 1002) {
            String stringExtra = intent != null ? intent.getStringExtra("register_nation") : null;
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.f7986m = stringExtra;
            String stringExtra2 = intent != null ? intent.getStringExtra("register_code") : null;
            String str = stringExtra2 != null ? stringExtra2 : "";
            this.f7987n = str;
            f.k(this, "login_area_code", str);
            this.f7985l = true;
        }
    }

    @Override // f5.d, f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S2().i();
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f7990q.removeCallbacks(this.f7997x);
        this.f7990q.removeCallbacks(this.f7998y);
    }

    @Override // i6.c0
    public void showLoading(boolean z10) {
        ((ProgressBar) W2(R$id.mLoadingPbar)).setVisibility(z10 ? 0 : 8);
    }

    @Override // i6.c0
    public void v(String str, String str2) {
        i.g(str, "areaCode");
        i.g(str2, bt.O);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f7985l) {
            return;
        }
        this.f7987n = str;
        this.f7986m = str2;
    }
}
