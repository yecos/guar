package com.mobile.brasiltv.mine.activity;

import a6.f;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.EmailManagerAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.BlackListDialog;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.login.LoginButton;
import com.msandroid.mobile.R;
import f5.d;
import h9.t;
import i6.c;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class AccountBindAty extends d implements c, z7.a {

    /* renamed from: r, reason: collision with root package name */
    public static final a f8288r = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public LoadingView f8290m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8291n;

    /* renamed from: o, reason: collision with root package name */
    public z7.b f8292o;

    /* renamed from: p, reason: collision with root package name */
    public k6.b f8293p;

    /* renamed from: q, reason: collision with root package name */
    public Map f8294q = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public boolean f8289l = true;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8295a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            i.f(putExtra, "it.putExtra(WebViewAty.BUNDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    public static final void d3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        accountBindAty.onBackPressed();
    }

    public static final void e3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        b0.d0(accountBindAty, WebViewAty.class, b.f8295a);
    }

    public static final void f3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        if (f.f268a.a()) {
            accountBindAty.b3();
        } else {
            accountBindAty.n(R.string.try_other_bind_method);
        }
    }

    public static final void g3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        if (b0.T(w6.i.f19214g.h(), "0")) {
            b0.c0(accountBindAty, EmailAty.class);
        } else {
            b0.c0(accountBindAty, EmailManagerAty.class);
        }
    }

    public static final void j3(AccountBindAty accountBindAty, DialogInterface dialogInterface) {
        i.g(accountBindAty, "this$0");
        accountBindAty.f8290m = null;
    }

    @Override // f5.d
    public void R2() {
        i3(new k6.b(this, this));
        h3();
        c3();
    }

    @Override // z7.a
    public void S0(int i10, x7.a aVar) {
        i.g(aVar, "info");
        S2().j(i10 == 1 ? "google" : "facebook", aVar);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_account_bind;
    }

    public View Z2(int i10) {
        Map map = this.f8294q;
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
    /* renamed from: a3, reason: merged with bridge method [inline-methods] */
    public k6.b S2() {
        k6.b bVar = this.f8293p;
        if (bVar != null) {
            return bVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void b3() {
        if (this.f8292o == null) {
            w7.a aVar = w7.a.f19265a;
            String string = getResources().getString(R.string.server_client_id);
            i.f(string, "resources.getString(R.string.server_client_id)");
            z7.b a10 = aVar.a(this, 1, string);
            this.f8292o = a10;
            if (a10 != null) {
                a10.b(this);
            }
        }
        z7.b bVar = this.f8292o;
        if (bVar != null) {
            bVar.d(this);
        }
    }

    public final void c3() {
        ((TitleBarView) Z2(R$id.mTbvTitle)).setOnBackClickListener(new View.OnClickListener() { // from class: e6.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountBindAty.d3(AccountBindAty.this, view);
            }
        });
        ((TextView) Z2(R$id.mTvPrivacyPolicy)).setOnClickListener(new View.OnClickListener() { // from class: e6.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountBindAty.e3(AccountBindAty.this, view);
            }
        });
        ((LoginButton) Z2(R$id.mLbGoogleBind)).setOnClickListener(new View.OnClickListener() { // from class: e6.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountBindAty.f3(AccountBindAty.this, view);
            }
        });
        ((LoginButton) Z2(R$id.mLbEmailBind)).setOnClickListener(new View.OnClickListener() { // from class: e6.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountBindAty.g3(AccountBindAty.this, view);
            }
        });
    }

    public final void h3() {
        this.f8289l = getIntent().getBooleanExtra("can_back", true);
        ((TitleBarView) Z2(R$id.mTbvTitle)).setBackVisibility(this.f8289l ? 0 : 8);
        if (!f.f268a.a()) {
            ((LoginButton) Z2(R$id.mLbGoogleBind)).setVisibility(8);
        }
        String str = i.b(s6.a.f18777a.a().b(), "1") ? "#3cd977" : "#FFFEFE";
        ((TextView) Z2(R$id.mTvPrivacyPolicy)).setText(Html.fromHtml(getResources().getString(R.string.account_bind_privacy_prefix) + " <font color=\"" + str + "\"><u>(" + getResources().getString(R.string.privacy_policy) + ")</u></font>"));
    }

    public void i3(k6.b bVar) {
        i.g(bVar, "<set-?>");
        this.f8293p = bVar;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.c
    public void n(int i10) {
        String string = getResources().getString(i10);
        i.f(string, "resources.getString(resId)");
        z0(string);
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        z7.b bVar = this.f8292o;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.f8289l || this.f8291n) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        BlackListDialog L2 = L2();
        if (L2 != null) {
            L2.dismiss();
        }
        h3();
    }

    @Override // z7.a
    public void p1(int i10, y7.b bVar) {
        i.g(bVar, "exception");
        if (bVar.a()) {
            String string = getResources().getString(R.string.account_bind_timeout);
            i.f(string, "resources.getString(R.string.account_bind_timeout)");
            z0(string);
        } else if (bVar.b()) {
            String string2 = getResources().getString(R.string.g_unsupport_google_service);
            i.f(string2, "resources.getString(R.st…unsupport_google_service)");
            z0(string2);
        }
    }

    @Override // i6.c
    public void q() {
        z7.b bVar = this.f8292o;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    @Override // i6.c
    public void showLoading(boolean z10) {
        if (this.f8290m == null) {
            this.f8290m = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: e6.i
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AccountBindAty.j3(AccountBindAty.this, dialogInterface);
                }
            }, 6, null);
            t tVar = t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f8290m;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f8290m;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }

    @Override // i6.c
    public void t(boolean z10) {
        ((LoginButton) Z2(R$id.mLbGoogleBind)).setClickable(!z10);
        ((LoginButton) Z2(R$id.mLbEmailBind)).setClickable(!z10);
        ((TextView) Z2(R$id.mTvPrivacyPolicy)).setClickable(!z10);
        this.f8291n = z10;
    }
}
