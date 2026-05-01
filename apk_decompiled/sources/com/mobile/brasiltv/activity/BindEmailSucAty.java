package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.BindEmailSucAty;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.mine.activity.AccountAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.msandroid.mobile.R;
import d6.b;
import f5.d;
import i6.i;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.p;
import s9.l;
import t9.g;
import t9.j;
import xa.c;

/* loaded from: classes3.dex */
public final class BindEmailSucAty extends d implements i {

    /* renamed from: r, reason: collision with root package name */
    public static final a f7807r = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public p f7812p;

    /* renamed from: q, reason: collision with root package name */
    public Map f7813q = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final Handler f7808l = new Handler();

    /* renamed from: m, reason: collision with root package name */
    public Runnable f7809m = new Runnable() { // from class: f5.g
        @Override // java.lang.Runnable
        public final void run() {
            BindEmailSucAty.g3(BindEmailSucAty.this);
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public Runnable f7810n = new Runnable() { // from class: f5.h
        @Override // java.lang.Runnable
        public final void run() {
            BindEmailSucAty.e3(BindEmailSucAty.this);
        }
    };

    /* renamed from: o, reason: collision with root package name */
    public Runnable f7811o = new Runnable() { // from class: f5.i
        @Override // java.lang.Runnable
        public final void run() {
            BindEmailSucAty.f3(BindEmailSucAty.this);
        }
    };

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.BindEmailSucAty$a$a, reason: collision with other inner class name */
        public static final class C0160a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0160a f7814a = new C0160a();

            public C0160a() {
                super(1);
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("extra_show_email", false);
                intent.putExtra("extra_email", "");
                intent.putExtra("extra_return_account_page", false);
                intent.putExtra("extra_return_home_page", false);
                Intent putExtra = intent.putExtra("extra_change_email", false);
                t9.i.f(putExtra, "it.putExtra(EXTRA_CHANGE_EMAIL, false)");
                return putExtra;
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public static final b f7815a = new b();

            public b() {
                super(1);
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("extra_show_email", false);
                intent.putExtra("extra_email", "");
                intent.putExtra("extra_return_account_page", false);
                intent.putExtra("extra_return_home_page", false);
                Intent putExtra = intent.putExtra("extra_change_email", true);
                t9.i.f(putExtra, "it.putExtra(EXTRA_CHANGE_EMAIL, true)");
                return putExtra;
            }
        }

        public static final class c extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f7816a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f7817b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f7818c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f7819d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(boolean z10, String str, boolean z11, boolean z12) {
                super(1);
                this.f7816a = z10;
                this.f7817b = str;
                this.f7818c = z11;
                this.f7819d = z12;
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("extra_show_email", this.f7816a);
                intent.putExtra("extra_email", this.f7817b);
                intent.putExtra("extra_return_account_page", this.f7818c);
                intent.putExtra("extra_return_home_page", this.f7819d);
                Intent putExtra = intent.putExtra("extra_change_email", false);
                t9.i.f(putExtra, "it.putExtra(EXTRA_CHANGE_EMAIL, false)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(f5.c cVar) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, BindEmailSucAty.class, C0160a.f7814a);
        }

        public final void b(f5.c cVar) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, BindEmailSucAty.class, b.f7815a);
        }

        public final void c(f5.c cVar, boolean z10, String str, boolean z11, boolean z12) {
            t9.i.g(cVar, "activity");
            t9.i.g(str, Scopes.EMAIL);
            b0.d0(cVar, BindEmailSucAty.class, new c(z10, str, z11, z12));
        }
    }

    public static final void b3(BindEmailSucAty bindEmailSucAty, View view) {
        t9.i.g(bindEmailSucAty, "this$0");
        bindEmailSucAty.a3();
    }

    public static final void c3(BindEmailSucAty bindEmailSucAty, View view) {
        t9.i.g(bindEmailSucAty, "this$0");
        c.c().j(new GotoHomeTabEvent(2));
        b0.c0(bindEmailSucAty, MainAty.class);
    }

    public static final void e3(BindEmailSucAty bindEmailSucAty) {
        t9.i.g(bindEmailSucAty, "this$0");
        c.c().j(new CloseBindEmailSucEvent());
        b0.c0(bindEmailSucAty, AccountAty.class);
        bindEmailSucAty.finish();
    }

    public static final void f3(BindEmailSucAty bindEmailSucAty) {
        t9.i.g(bindEmailSucAty, "this$0");
        b0.c0(bindEmailSucAty, MainAty.class);
        bindEmailSucAty.finish();
    }

    public static final void g3(BindEmailSucAty bindEmailSucAty) {
        t9.i.g(bindEmailSucAty, "this$0");
        c.c().j(new CloseBindEmailSucEvent());
        b bVar = b.f12660a;
        bVar.E(bindEmailSucAty.Q1(), "");
        bVar.I(bindEmailSucAty.Q1(), "", "");
        LoginAty.C.a(bindEmailSucAty, false, true);
        bindEmailSucAty.finish();
    }

    @Override // f5.d
    public void R2() {
        h3(new p(this, this));
        boolean booleanExtra = getIntent().getBooleanExtra("extra_show_email", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("extra_return_account_page", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("extra_return_home_page", false);
        boolean booleanExtra4 = getIntent().getBooleanExtra("extra_change_email", false);
        if (booleanExtra2) {
            this.f7808l.postDelayed(this.f7810n, 5000L);
        } else if (booleanExtra3) {
            this.f7808l.postDelayed(this.f7811o, 5000L);
        } else if (booleanExtra4 && b.f12660a.s(this, "2")) {
            this.f7808l.postDelayed(this.f7809m, 5000L);
        }
        if (booleanExtra) {
            String stringExtra = getIntent().getStringExtra("extra_email");
            if (stringExtra == null) {
                stringExtra = "";
            }
            ((TextView) Z2(R$id.mTvHint)).setText(Html.fromHtml(getResources().getString(R.string.be_bind_suc_and_keep_pwd, "<font color=\"#3cd977\">" + stringExtra + "</font>")));
        } else {
            ((TextView) Z2(R$id.mTvHint)).setText(getResources().getString(R.string.be_bind_suc_and_login));
        }
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) Z2(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindEmailSucAty.b3(BindEmailSucAty.this, view);
            }
        });
        ((TitleBarView) Z2(i10)).setOnCloseClickListener(new View.OnClickListener() { // from class: f5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindEmailSucAty.c3(BindEmailSucAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_bind_email_suc;
    }

    public View Z2(int i10) {
        Map map = this.f7813q;
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

    public final void a3() {
        boolean booleanExtra = getIntent().getBooleanExtra("extra_return_account_page", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("extra_return_home_page", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("extra_change_email", false);
        c.c().j(new CloseBindEmailSucEvent());
        if (booleanExtra) {
            b0.c0(this, AccountAty.class);
        } else if (booleanExtra2) {
            b0.c0(this, MainAty.class);
        } else if (booleanExtra3) {
            b bVar = b.f12660a;
            if (bVar.s(this, "2")) {
                bVar.E(Q1(), "");
                bVar.I(Q1(), "", "");
                LoginAty.C.a(this, false, true);
            }
        }
        finish();
    }

    @Override // f5.d
    /* renamed from: d3, reason: merged with bridge method [inline-methods] */
    public p S2() {
        p pVar = this.f7812p;
        if (pVar != null) {
            return pVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public void h3(p pVar) {
        t9.i.g(pVar, "<set-?>");
        this.f7812p = pVar;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        a3();
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        this.f7808l.removeCallbacks(this.f7810n);
        this.f7808l.removeCallbacks(this.f7811o);
        this.f7808l.removeCallbacks(this.f7809m);
        super.onDestroy();
    }
}
