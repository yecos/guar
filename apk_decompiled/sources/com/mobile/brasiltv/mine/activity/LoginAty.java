package com.mobile.brasiltv.mine.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.activity.SelectNationAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.bean.event.SetLoginAtySelectTabEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.BlackListDialog;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.MaxHeightLinearLayout;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.mobile.brasiltv.view.login.AccountEditView;
import com.mobile.brasiltv.view.login.AccountLoginPanel;
import com.mobile.brasiltv.view.login.IAccountEditCallback;
import com.mobile.brasiltv.view.login.IAccountLoginCallback;
import com.mobile.brasiltv.view.login.ILoginPanel;
import com.mobile.brasiltv.view.login.IMobileLoginCallback;
import com.mobile.brasiltv.view.login.IPwdEditCallback;
import com.mobile.brasiltv.view.login.IQuickLoginCallback;
import com.mobile.brasiltv.view.login.ISmsLoginCallback;
import com.mobile.brasiltv.view.login.MobileLoginPanel;
import com.mobile.brasiltv.view.login.PasswordEditView;
import com.mobile.brasiltv.view.login.QuickLoginPanel;
import com.mobile.brasiltv.view.login.SmsLoginPanel;
import com.mobile.brasiltv.view.login.dialog.CreateNewAccountDialog;
import com.mobile.brasiltv.view.login.dialog.GoogleEmailRegisteredDialog;
import com.mobile.brasiltv.view.login.dialog.IBindThirdPartCallback;
import com.mobile.brasiltv.view.login.dialog.ICreateNewAccountCallback;
import com.mobile.brasiltv.view.login.dialog.ISetPasswordCallback;
import com.mobile.brasiltv.view.login.dialog.LoginTpFailDialog;
import com.mobile.brasiltv.view.login.dialog.TpSetPwdDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import g5.c;
import i6.s;
import i6.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.j0;
import s9.l;
import t9.j;
import t9.z;

/* loaded from: classes.dex */
public final class LoginAty extends f5.d implements t, IAccountLoginCallback, IMobileLoginCallback, ISmsLoginCallback, z7.a, IBindThirdPartCallback, ICreateNewAccountCallback, IQuickLoginCallback, ISetPasswordCallback {
    public static final a C = new a(null);
    public static boolean D;
    public j0 A;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8359m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8360n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8361o;

    /* renamed from: r, reason: collision with root package name */
    public LoadingView f8364r;

    /* renamed from: s, reason: collision with root package name */
    public ILoginPanel f8365s;

    /* renamed from: t, reason: collision with root package name */
    public z7.b f8366t;

    /* renamed from: w, reason: collision with root package name */
    public String f8369w;

    /* renamed from: x, reason: collision with root package name */
    public String f8370x;

    /* renamed from: z, reason: collision with root package name */
    public IAccountLoginCallback f8372z;
    public Map B = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public boolean f8358l = true;

    /* renamed from: p, reason: collision with root package name */
    public String f8362p = "Brasil";

    /* renamed from: q, reason: collision with root package name */
    public String f8363q = "55";

    /* renamed from: u, reason: collision with root package name */
    public final h9.g f8367u = h9.h.b(new g());

    /* renamed from: v, reason: collision with root package name */
    public String f8368v = "@gmail.com";

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f8371y = new ArrayList();

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: com.mobile.brasiltv.mine.activity.LoginAty$a$a, reason: collision with other inner class name */
        public static final class C0166a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f8373a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f8374b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0166a(boolean z10, boolean z11) {
                super(1);
                this.f8373a = z10;
                this.f8374b = z11;
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("can_back", this.f8373a);
                Intent putExtra = intent.putExtra("success_to_main", this.f8374b);
                t9.i.f(putExtra, "it.putExtra(SUCCESS_TO_MAIN, successToMain)");
                return putExtra;
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f8375a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f8376b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ SwitchAccountBean f8377c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(boolean z10, boolean z11, SwitchAccountBean switchAccountBean) {
                super(1);
                this.f8375a = z10;
                this.f8376b = z11;
                this.f8377c = switchAccountBean;
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("can_back", this.f8375a);
                intent.putExtra("success_to_main", this.f8376b);
                Intent putExtra = intent.putExtra("extra_fill_account", this.f8377c);
                t9.i.f(putExtra, "it.putExtra(EXTRA_FILL_ACCOUNT, account)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final void a(f5.c cVar, boolean z10, boolean z11) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, LoginAty.class, new C0166a(z10, z11));
        }

        public final void b(f5.c cVar, boolean z10, boolean z11, SwitchAccountBean switchAccountBean) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, LoginAty.class, new b(z10, z11, switchAccountBean));
        }

        public final void c(boolean z10) {
            LoginAty.D = z10;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements IPwdEditCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.login.IPwdEditCallback
        public void onTextChanged(String str) {
            t9.i.g(str, "content");
            LoginAty.this.f8370x = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements c.a {
        public c() {
        }

        @Override // g5.c.a
        public void onClick(String str) {
            t9.i.g(str, "mEmailString");
            LoginAty loginAty = LoginAty.this;
            int i10 = R$id.mEtInput;
            ((EditText) loginAty.d3(i10)).setText(str);
            ((EditText) LoginAty.this.d3(i10)).setSelection(str.length());
            ((RecyclerView) LoginAty.this.d3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) LoginAty.this.d3(R$id.mLlRecyEmail)).setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f8380a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            t9.i.f(putExtra, "it.putExtra(WebViewAty.BUNDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements IAccountEditCallback {
        public e() {
        }

        @Override // com.mobile.brasiltv.view.login.IAccountEditCallback
        public void onTextChanged(String str) {
            t9.i.g(str, "content");
            LoginAty.this.f8369w = str;
            LoginAty.this.y3(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends j implements l {
        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            TextView textView = (TextView) LoginAty.this.d3(R$id.tvWebsite);
            z zVar = z.f18964a;
            String string = LoginAty.this.Q1().getString(R.string.redemption_any_question);
            t9.i.f(string, "context.getString(R.stri….redemption_any_question)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            t9.i.f(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends j implements s9.a {
        public g() {
            super(0);
        }

        @Override // s9.a
        public final g5.c invoke() {
            return new g5.c(LoginAty.this.Q1());
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends j implements l {
        public h() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            intent.putExtra("need_x_button", false);
            intent.putExtra("is_form_login", true);
            if (LoginAty.this.f8365s instanceof MobileLoginPanel) {
                intent.putExtra("bind_from", 1);
            } else {
                intent.putExtra("bind_from", 2);
            }
            Intent putExtra = intent.putExtra("bind_Type", "3");
            t9.i.f(putExtra, "it.putExtra(Constant.BIND_TYPE, \"3\")");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements GoogleEmailRegisteredDialog.IBindThirdPartCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8386b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x7.a f8387c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f8388d;

        public i(String str, x7.a aVar, String str2) {
            this.f8386b = str;
            this.f8387c = aVar;
            this.f8388d = str2;
        }

        @Override // com.mobile.brasiltv.view.login.dialog.GoogleEmailRegisteredDialog.IBindThirdPartCallback
        public void dialogRevokeAccessGoogle() {
            LoginAty.this.q();
        }

        @Override // com.mobile.brasiltv.view.login.dialog.GoogleEmailRegisteredDialog.IBindThirdPartCallback
        public void onBindThirdPart() {
            s.a.a(LoginAty.this.S2(), this.f8386b, this.f8387c, "2", this.f8388d, LoginAty.this.f8359m, null, 32, null);
        }
    }

    public static final void C3(LoginAty loginAty, DialogInterface dialogInterface) {
        t9.i.g(loginAty, "this$0");
        loginAty.f8364r = null;
        loginAty.S2().x();
    }

    public static /* synthetic */ void F3(LoginAty loginAty, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        loginAty.E3(str, str2);
    }

    public static /* synthetic */ void I3(LoginAty loginAty, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        loginAty.H3(str, str2);
    }

    public static final void p3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.onBackPressed();
    }

    public static final void q3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.B3(0);
    }

    public static final void r3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.B3(1);
    }

    public static final void s3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        b0.d0(loginAty, WebViewAty.class, d.f8380a);
    }

    public static final void t3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        if (TextUtils.isEmpty(loginAty.f8369w) || TextUtils.isEmpty(loginAty.f8370x)) {
            return;
        }
        b0.F(loginAty);
        j0 S2 = loginAty.S2();
        String str = loginAty.f8369w;
        if (str == null) {
            str = "";
        }
        String str2 = loginAty.f8370x;
        S2.v(str, str2 != null ? str2 : "", loginAty.f8359m);
        IAccountLoginCallback iAccountLoginCallback = loginAty.f8372z;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onAccountLogin(((AccountEditView) loginAty.d3(R$id.mAevAccount)).getAccount(), ((PasswordEditView) loginAty.d3(R$id.mPevPassword)).getPassword());
        }
    }

    public static final void u3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        if (a6.f.f268a.a()) {
            loginAty.m3();
        } else {
            loginAty.n(R.string.try_other_login_method);
        }
    }

    public static final void v3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        loginAty.onForgetPwd();
    }

    public static final void w3(LoginAty loginAty, View view) {
        t9.i.g(loginAty, "this$0");
        b0.M(loginAty);
    }

    public void A3(j0 j0Var) {
        t9.i.g(j0Var, "<set-?>");
        this.A = j0Var;
    }

    public final void B3(int i10) {
        if (i10 == 0) {
            int i11 = R$id.mLayoutTabQuickLogin;
            ((AutoLinearLayout) d3(i11)).setSelected(true);
            int i12 = R$id.mLayoutTabLogin;
            ((AutoLinearLayout) d3(i12)).setSelected(false);
            TextView textView = (TextView) ((AutoLinearLayout) d3(i11)).getChildAt(0);
            if (textView != null) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            TextView textView2 = (TextView) ((AutoLinearLayout) d3(i12)).getChildAt(0);
            if (textView2 != null) {
                textView2.setTypeface(Typeface.DEFAULT);
            }
            d3(R$id.mLoginNew).setVisibility(8);
            G3();
            return;
        }
        if (i10 != 1) {
            return;
        }
        int i13 = R$id.mLayoutTabQuickLogin;
        ((AutoLinearLayout) d3(i13)).setSelected(false);
        int i14 = R$id.mLayoutTabLogin;
        ((AutoLinearLayout) d3(i14)).setSelected(true);
        TextView textView3 = (TextView) ((AutoLinearLayout) d3(i13)).getChildAt(0);
        if (textView3 != null) {
            textView3.setTypeface(Typeface.DEFAULT);
        }
        TextView textView4 = (TextView) ((AutoLinearLayout) d3(i14)).getChildAt(0);
        if (textView4 != null) {
            textView4.setTypeface(Typeface.DEFAULT_BOLD);
        }
        d3(R$id.mLoginNew).setVisibility(0);
        z3();
    }

    public final void D3(boolean z10, String str) {
        z3();
        AccountLoginPanel accountLoginPanel = new AccountLoginPanel(Q1(), null, 0, 6, null);
        accountLoginPanel.setId(R.id.other_login_panel);
        accountLoginPanel.setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        accountLoginPanel.setAccountLoginCallback(this);
        accountLoginPanel.setDeviceId(w6.i.f19214g.l());
        accountLoginPanel.isEmailLogin(z10);
        accountLoginPanel.fillAccount(str);
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(accountLoginPanel);
        this.f8365s = accountLoginPanel;
    }

    public final void E3(String str, String str2) {
        z3();
        MobileLoginPanel mobileLoginPanel = new MobileLoginPanel(Q1(), null, 0, 6, null);
        mobileLoginPanel.setId(R.id.other_login_panel);
        mobileLoginPanel.setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        mobileLoginPanel.setMobileLoginCallback(this);
        mobileLoginPanel.updateAreaInfo(this.f8362p, this.f8363q);
        mobileLoginPanel.fillAccount(str);
        mobileLoginPanel.fillArea(str2);
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(mobileLoginPanel);
        this.f8365s = mobileLoginPanel;
    }

    @Override // i6.t
    public void F2(String str, String str2, String str3, x7.a aVar) {
        t9.i.g(str2, "thirdPartType");
        t9.i.g(str3, "tpSource");
        t9.i.g(aVar, "socialInfo");
        Context Q1 = Q1();
        if (str == null) {
            str = "";
        }
        new GoogleEmailRegisteredDialog(Q1, str).setBindThirdPartCallback(new i(str2, aVar, str3)).show();
    }

    public final void G3() {
        z3();
        QuickLoginPanel quickLoginPanel = new QuickLoginPanel(Q1(), null, 0, 6, null);
        quickLoginPanel.setId(R.id.other_login_panel);
        quickLoginPanel.setAccountLoginCallback(this);
        quickLoginPanel.attachDataToView(S2().G());
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(quickLoginPanel);
        this.f8365s = quickLoginPanel;
    }

    public final void H3(String str, String str2) {
        z3();
        SmsLoginPanel smsLoginPanel = new SmsLoginPanel(Q1(), null, 0, 6, null);
        smsLoginPanel.setId(R.id.other_login_panel);
        smsLoginPanel.setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        smsLoginPanel.setSmsLoginCallback(this);
        smsLoginPanel.updateAreaInfo(this.f8362p, this.f8363q);
        smsLoginPanel.fillAccount(str);
        smsLoginPanel.fillArea(str2);
        ((AutoFrameLayout) d3(R$id.mLoginRoot)).addView(smsLoginPanel);
        this.f8365s = smsLoginPanel;
    }

    @Override // i6.t
    public void M1(String str) {
        t9.i.g(str, "thirdPartType");
        if (b0.T(str, "google")) {
            m3();
        }
    }

    @Override // i6.t
    public void Q() {
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel != null) {
            iLoginPanel.cancelSmsCountDown();
        }
    }

    @Override // f5.d
    public void R2() {
        A3(new j0(this, this));
        x3();
        o3();
    }

    @Override // i6.t
    public void S(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        new TpSetPwdDialog(this, str, str2, aVar).setSetPasswordCallback(this).show();
    }

    @Override // z7.a
    public void S0(int i10, x7.a aVar) {
        t9.i.g(aVar, "info");
        s.a.a(S2(), i10 == 1 ? "google" : "facebook", aVar, "0", "2", this.f8359m, null, 32, null);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_login_new;
    }

    @Override // i6.t
    public void U1() {
        new LoginTpFailDialog(this).show();
    }

    @Override // i6.t
    public void c0(String str) {
        t9.i.g(str, "error");
        if (t9.i.b("aaa100094", str)) {
            new NumberLimitDialog(Q1()).show();
            return;
        }
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel instanceof QuickLoginPanel) {
            t9.i.e(iLoginPanel, "null cannot be cast to non-null type com.mobile.brasiltv.view.login.QuickLoginPanel");
            ((QuickLoginPanel) iLoginPanel).showError(str);
        }
    }

    @Override // i6.t
    public void d(int i10) {
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel != null) {
            String string = getResources().getString(i10);
            t9.i.f(string, "resources.getString(strResId)");
            iLoginPanel.showErrorHint(string);
        }
    }

    public View d3(int i10) {
        Map map = this.B;
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

    @Override // com.mobile.brasiltv.view.login.dialog.IBindThirdPartCallback, com.mobile.brasiltv.view.login.dialog.ICreateNewAccountCallback, com.mobile.brasiltv.view.login.dialog.ISetPasswordCallback
    public void dialogRevokeAccessGoogle() {
        q();
    }

    @Override // i6.t
    public void e(List list) {
        t9.i.g(list, "emailList");
        if (!list.isEmpty()) {
            this.f8371y.addAll(list);
        }
    }

    @Override // i6.t
    public void h1(String str, String str2) {
        t9.i.g(str, "areaCode");
        t9.i.g(str2, "area");
        if (b0.K(str) && b0.K(str2) && !this.f8361o) {
            ILoginPanel iLoginPanel = this.f8365s;
            if (b0.J(iLoginPanel != null ? iLoginPanel.getMobile() : null)) {
                this.f8362p = str2;
                this.f8363q = str;
                ILoginPanel iLoginPanel2 = this.f8365s;
                if (iLoginPanel2 != null) {
                    iLoginPanel2.updateAreaInfo(str2, str);
                }
            }
        }
    }

    @Override // i6.t
    public void hideErrorHint(long j10) {
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel != null) {
            iLoginPanel.hideErrorHint(j10);
        }
    }

    @Override // i6.t
    public void i() {
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel != null) {
            iLoginPanel.startSmsCountDown();
        }
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final g5.c k3() {
        return (g5.c) this.f8367u.getValue();
    }

    @Override // f5.d
    /* renamed from: l3, reason: merged with bridge method [inline-methods] */
    public j0 S2() {
        j0 j0Var = this.A;
        if (j0Var != null) {
            return j0Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void m3() {
        if (S2().O("google", this.f8359m)) {
            return;
        }
        if (this.f8366t == null) {
            w7.a aVar = w7.a.f19265a;
            String string = getResources().getString(R.string.server_client_id);
            t9.i.f(string, "resources.getString(R.string.server_client_id)");
            z7.b a10 = aVar.a(this, 1, string);
            this.f8366t = a10;
            if (a10 != null) {
                a10.b(this);
            }
        }
        z7.b bVar = this.f8366t;
        if (bVar != null) {
            bVar.d(this);
        }
    }

    @Override // i6.t
    public void n(int i10) {
        f1.a aVar = f1.f8649a;
        String string = getResources().getString(i10);
        t9.i.f(string, "resources.getString(strResId)");
        aVar.x(string);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void n3() {
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_fill_account");
        if (serializableExtra == null || !(serializableExtra instanceof SwitchAccountBean)) {
            return;
        }
        SwitchAccountBean switchAccountBean = (SwitchAccountBean) serializableExtra;
        String accountType = switchAccountBean.getAccountType();
        int hashCode = accountType.hashCode();
        if (hashCode == -1240244679) {
            if (accountType.equals("google") && a6.f.f268a.a()) {
                m3();
            }
            return;
        }
        switch (hashCode) {
            case 49:
                if (!accountType.equals("1")) {
                }
                D3(false, switchAccountBean.getUserName());
                break;
            case 50:
                if (accountType.equals("2")) {
                    D3(true, switchAccountBean.getUserName());
                    break;
                }
                break;
            case 51:
                if (accountType.equals("3")) {
                    E3(switchAccountBean.getUserName(), switchAccountBean.getAreaCode());
                    break;
                }
                break;
            case 52:
                if (!accountType.equals("4")) {
                }
                H3(switchAccountBean.getUserName(), switchAccountBean.getAreaCode());
                break;
            case 53:
                if (!accountType.equals(CdnType.DIGITAL_TYPE_PCDN)) {
                }
                H3(switchAccountBean.getUserName(), switchAccountBean.getAreaCode());
                break;
            case 54:
                if (!accountType.equals(CdnType.DIGITAL_TYPE_PEERSTAR)) {
                }
                D3(false, switchAccountBean.getUserName());
                break;
            case 55:
                accountType.equals("7");
                break;
        }
    }

    public final void o3() {
        ((TitleBarView) d3(R$id.mTbvBackTitle)).setOnBackClickListener(new View.OnClickListener() { // from class: e6.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.p3(LoginAty.this, view);
            }
        });
        ((AutoLinearLayout) d3(R$id.mLayoutTabQuickLogin)).setOnClickListener(new View.OnClickListener() { // from class: e6.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.q3(LoginAty.this, view);
            }
        });
        ((AutoLinearLayout) d3(R$id.mLayoutTabLogin)).setOnClickListener(new View.OnClickListener() { // from class: e6.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.r3(LoginAty.this, view);
            }
        });
        ((AutoLinearLayout) d3(R$id.mAllPrivacyPolicy)).setOnClickListener(new View.OnClickListener() { // from class: e6.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.s3(LoginAty.this, view);
            }
        });
        ((TextView) d3(R$id.mTvLogin)).setOnClickListener(new View.OnClickListener() { // from class: e6.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.t3(LoginAty.this, view);
            }
        });
        ((AutoLinearLayout) d3(R$id.mLlGoogleLogin)).setOnClickListener(new View.OnClickListener() { // from class: e6.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.u3(LoginAty.this, view);
            }
        });
        ((TextView) d3(R$id.mTvForgetPwd)).setOnClickListener(new View.OnClickListener() { // from class: e6.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.v3(LoginAty.this, view);
            }
        });
        ((TextView) d3(R$id.mTvEncounterProblem)).setOnClickListener(new View.OnClickListener() { // from class: e6.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginAty.w3(LoginAty.this, view);
            }
        });
        ((AccountEditView) d3(R$id.mAevAccount)).setAccountEditCallback(new e());
        ((PasswordEditView) d3(R$id.mPevPassword)).setPwdEditCallback(new b());
        k3().f(new c());
    }

    @Override // com.mobile.brasiltv.view.login.IQuickLoginCallback
    public void onAccountLogin(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        S2().S(switchAccountBean);
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1001 && i11 == SelectNationAty.f8104p.a()) {
            this.f8361o = true;
            String stringExtra = intent != null ? intent.getStringExtra("register_nation") : null;
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.f8362p = stringExtra;
            String stringExtra2 = intent != null ? intent.getStringExtra("register_code") : null;
            String str = stringExtra2 != null ? stringExtra2 : "";
            this.f8363q = str;
            ILoginPanel iLoginPanel = this.f8365s;
            if (iLoginPanel != null) {
                iLoginPanel.updateAreaInfo(this.f8362p, str);
            }
        }
        z7.b bVar = this.f8366t;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel != null && !(iLoginPanel instanceof QuickLoginPanel)) {
            if (iLoginPanel != null) {
                iLoginPanel.closeLoginPanel();
            }
        } else {
            if (this.f8358l) {
                super.onBackPressed();
            }
            if (D) {
                b0.c0(this, ForceChangePwdAty.class);
                D = false;
            }
        }
    }

    @Override // com.mobile.brasiltv.view.login.dialog.IBindThirdPartCallback
    public void onBindThirdPart(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        s.a.a(S2(), str, aVar, "2", str2, this.f8359m, null, 32, null);
    }

    @Override // com.mobile.brasiltv.view.login.dialog.IBindThirdPartCallback
    public void onClickCreateNewAccount(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        new CreateNewAccountDialog(this, str, str2, aVar).setCreateNewAccountCallback(this).show();
    }

    @Override // com.mobile.brasiltv.view.login.IAccountLoginCallback, com.mobile.brasiltv.view.login.IMobileLoginCallback, com.mobile.brasiltv.view.login.ISmsLoginCallback, com.mobile.brasiltv.view.login.IQuickLoginCallback
    public void onClosePanel() {
        if (this.f8365s == null) {
            return;
        }
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) d3(R$id.mLoginRoot);
        Object obj = this.f8365s;
        t9.i.e(obj, "null cannot be cast to non-null type android.view.View");
        autoFrameLayout.removeView((View) obj);
        this.f8365s = null;
    }

    @Override // com.mobile.brasiltv.view.login.dialog.ICreateNewAccountCallback
    public void onCreateNewAccount(String str, String str2, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        s.a.a(S2(), str, aVar, "1", str2, this.f8359m, null, 32, null);
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.mobile.brasiltv.view.login.IAccountLoginCallback, com.mobile.brasiltv.view.login.IMobileLoginCallback
    public void onForgetPwd() {
        b0.d0(this, ResetAty.class, new h());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.mobile.brasiltv.view.login.IQuickLoginCallback
    public void onLoginExpired(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        String accountType = switchAccountBean.getAccountType();
        int hashCode = accountType.hashCode();
        if (hashCode == -1240244679) {
            if (accountType.equals("google") && a6.f.f268a.a()) {
                B3(1);
                d6.b.f12660a.I(Q1(), "", "");
                m3();
            }
            return;
        }
        switch (hashCode) {
            case 49:
                if (!accountType.equals("1")) {
                }
                B3(1);
                D3(false, switchAccountBean.getUserName());
                break;
            case 50:
                if (accountType.equals("2")) {
                    B3(1);
                    D3(true, switchAccountBean.getUserName());
                    break;
                }
                break;
            case 51:
                if (accountType.equals("3")) {
                    B3(1);
                    E3(switchAccountBean.getUserName(), switchAccountBean.getAreaCode());
                    break;
                }
                break;
            case 52:
                if (!accountType.equals("4")) {
                }
                B3(1);
                H3(switchAccountBean.getUserName(), switchAccountBean.getAreaCode());
                break;
            case 53:
                if (!accountType.equals(CdnType.DIGITAL_TYPE_PCDN)) {
                }
                B3(1);
                H3(switchAccountBean.getUserName(), switchAccountBean.getAreaCode());
                break;
            case 54:
                if (!accountType.equals(CdnType.DIGITAL_TYPE_PEERSTAR)) {
                }
                B3(1);
                D3(false, switchAccountBean.getUserName());
                break;
            case 55:
                accountType.equals("7");
                break;
        }
    }

    @Override // com.mobile.brasiltv.view.login.IMobileLoginCallback
    public void onMobileLogin(String str, String str2, String str3, String str4) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "mobile");
        t9.i.g(str4, "password");
        b0.F(this);
        S2().R(str3, str4, str, str2, this.f8359m);
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        BlackListDialog L2 = L2();
        if (L2 != null) {
            L2.dismiss();
        }
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel == null) {
            x3();
        } else if (iLoginPanel != null) {
            iLoginPanel.closeLoginPanel();
        }
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.mobile.brasiltv.view.login.IMobileLoginCallback, com.mobile.brasiltv.view.login.ISmsLoginCallback
    public void onPickArea() {
        b0.e0(this, SelectNationAty.class, 1001);
    }

    @Override // com.mobile.brasiltv.view.login.IQuickLoginCallback
    public void onRemoveAccount(int i10, SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        S2().T(switchAccountBean);
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.mobile.brasiltv.view.login.ISmsLoginCallback
    public void onSendSms(String str, String str2, String str3) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "area");
        t9.i.g(str3, "areaCode");
        b0.F(this);
        S2().C(str, str2, str3);
    }

    @Override // com.mobile.brasiltv.view.login.ISmsLoginCallback
    public void onSmsLogin(String str, String str2, String str3, String str4) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "mobile");
        t9.i.g(str4, "verifyCode");
        b0.F(this);
        S2().b0(str3, str4, str, str2, this.f8359m);
    }

    @Override // com.mobile.brasiltv.view.login.ISmsLoginCallback
    public void onUseMobileLogin() {
        F3(this, null, null, 3, null);
    }

    @Override // com.mobile.brasiltv.view.login.IMobileLoginCallback
    public void onUseSmsLogin() {
        I3(this, null, null, 3, null);
    }

    @Override // z7.a
    public void p1(int i10, y7.b bVar) {
        t9.i.g(bVar, "exception");
        if (bVar.a()) {
            n(R.string.timeout_and_use_other_login);
        } else if (bVar.b()) {
            String string = getResources().getString(R.string.g_unsupport_google_service);
            t9.i.f(string, "resources.getString(R.st…unsupport_google_service)");
            z0(string);
        }
    }

    @Override // i6.t
    public void q() {
        z7.b bVar = this.f8366t;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    @Override // i6.t
    public void r0() {
        if (this.f8360n) {
            S2().Q();
        }
    }

    @xa.j
    public final void receiveSelectTabEvent(SetLoginAtySelectTabEvent setLoginAtySelectTabEvent) {
        t9.i.g(setLoginAtySelectTabEvent, "event");
        B3(setLoginAtySelectTabEvent.getIndex());
    }

    @Override // com.mobile.brasiltv.view.login.dialog.ISetPasswordCallback
    public void setPasswordAndBind(String str, String str2, x7.a aVar, String str3) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        t9.i.g(str3, "password");
        S2().c(str, aVar, "4", str2, this.f8359m, str3);
    }

    @Override // i6.t
    public void showLoading(boolean z10) {
        if (this.f8364r == null) {
            this.f8364r = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: e6.f0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LoginAty.C3(LoginAty.this, dialogInterface);
                }
            }, 6, null);
            h9.t tVar = h9.t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f8364r;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f8364r;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }

    @Override // i6.t
    public void v0(ArrayList arrayList) {
        t9.i.g(arrayList, "list");
        if (!arrayList.isEmpty()) {
            ((AutoLinearLayout) d3(R$id.mLayoutTab)).setVisibility(0);
            B3(0);
        } else {
            ((AutoLinearLayout) d3(R$id.mLayoutTab)).setVisibility(8);
            B3(1);
        }
        ILoginPanel iLoginPanel = this.f8365s;
        if (iLoginPanel instanceof QuickLoginPanel) {
            t9.i.e(iLoginPanel, "null cannot be cast to non-null type com.mobile.brasiltv.view.login.QuickLoginPanel");
            ((QuickLoginPanel) iLoginPanel).attachDataToView(arrayList);
        }
    }

    public final void x3() {
        int i10 = R$id.mRvCompleteList;
        ((RecyclerView) d3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(Q1()));
        ((RecyclerView) d3(i10)).setAdapter(k3());
        x.f8754a.w(Q1(), new f());
        this.f8358l = getIntent().getBooleanExtra("can_back", true);
        this.f8359m = getIntent().getBooleanExtra("success_to_main", false);
        this.f8360n = getIntent().getBooleanExtra("extra_login_out", false);
        ((TitleBarView) d3(R$id.mTbvBackTitle)).setBackVisibility(this.f8358l ? 0 : 8);
        if (!a6.f.f268a.a()) {
            ((AutoLinearLayout) d3(R$id.mLlGoogleLogin)).setVisibility(8);
        }
        if (s6.a.f18777a.a().u()) {
            d6.b bVar = d6.b.f12660a;
            if (b0.K(bVar.l())) {
                bVar.y();
            }
        }
        int i11 = R$id.mTvForgetPwd;
        ((TextView) d3(i11)).getPaint().setFlags(8);
        ((TextView) d3(i11)).getPaint().setAntiAlias(true);
        int i12 = R$id.mTvPrivacyPolicy;
        ((TextView) d3(i12)).getPaint().setFlags(8);
        ((TextView) d3(i12)).getPaint().setAntiAlias(true);
        int i13 = R$id.mTvEncounterProblem;
        ((TextView) d3(i13)).getPaint().setFlags(8);
        ((TextView) d3(i13)).getPaint().setAntiAlias(true);
        TextView textView = (TextView) d3(R$id.mTvDeviceInfo);
        z zVar = z.f18964a;
        String string = getResources().getString(R.string.current_device_id);
        t9.i.f(string, "this.resources.getString…string.current_device_id)");
        String format = String.format(string, Arrays.copyOf(new Object[]{w6.i.f19214g.l()}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
        B3(1);
        n3();
    }

    public final void y3(String str) {
        if (TextUtils.isEmpty(str) || !ba.t.o(str, "@", false, 2, null) || ba.t.y(str, "@", 0, false, 6, null) != ba.t.D(str, "@", 0, false, 6, null)) {
            ((RecyclerView) d3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(8);
            return;
        }
        if (this.f8371y.size() == 0) {
            this.f8371y.add("@gmail.com");
        }
        if (ba.s.e(str, "@", false, 2, null)) {
            g5.c k32 = k3();
            String substring = str.substring(0, str.length() - 1);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            k32.g(substring);
            k3().e(this.f8371y);
            ((RecyclerView) d3(R$id.mRvCompleteList)).setVisibility(0);
            ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(0);
            return;
        }
        String lowerCase = str.toLowerCase();
        t9.i.f(lowerCase, "this as java.lang.String).toLowerCase()");
        String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, null).toArray(new String[0]);
        String str2 = '@' + strArr[1];
        int size = this.f8371y.size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = this.f8371y.get(i10);
            t9.i.f(obj, "mEmailSuffixList[i]");
            String str3 = (String) obj;
            String lowerCase2 = str3.toLowerCase();
            t9.i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (ba.s.l(lowerCase2, str2, false, 2, null)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) d3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(8);
            return;
        }
        k3().g(strArr[0]);
        k3().e(arrayList);
        int i11 = R$id.mRvCompleteList;
        ((RecyclerView) d3(i11)).setBackgroundDrawable(Q1().getResources().getDrawable(R.drawable.bg_associate_email));
        ((RecyclerView) d3(i11)).setVisibility(0);
        ((MaxHeightLinearLayout) d3(R$id.mLlRecyEmail)).setVisibility(0);
    }

    public final void z3() {
        int i10 = R$id.mLoginRoot;
        View findViewById = ((AutoFrameLayout) d3(i10)).findViewById(R.id.other_login_panel);
        if (findViewById != null) {
            ((AutoFrameLayout) d3(i10)).removeView(findViewById);
        }
    }

    @Override // com.mobile.brasiltv.view.login.IAccountLoginCallback
    public void onAccountLogin(String str, String str2) {
        t9.i.g(str, "account");
        t9.i.g(str2, "password");
        b0.F(this);
        S2().v(str, str2, this.f8359m);
    }
}
