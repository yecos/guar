package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetPwdSucAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.msandroid.mobile.R;
import f5.c;
import f5.d;
import i6.l0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.s2;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class ResetPwdSucAty extends d implements l0 {

    /* renamed from: q, reason: collision with root package name */
    public static final a f8059q = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public s2 f8063o;

    /* renamed from: p, reason: collision with root package name */
    public Map f8064p = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public boolean f8060l = true;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f8061m = new Handler();

    /* renamed from: n, reason: collision with root package name */
    public final Runnable f8062n = new Runnable() { // from class: f5.p3
        @Override // java.lang.Runnable
        public final void run() {
            ResetPwdSucAty.a3(ResetPwdSucAty.this);
        }
    };

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.ResetPwdSucAty$a$a, reason: collision with other inner class name */
        public static final class C0161a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f8065a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0161a(boolean z10) {
                super(1);
                this.f8065a = z10;
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                Intent putExtra = intent.putExtra("extra_login_status", this.f8065a);
                i.f(putExtra, "it.putExtra(EXTRA_LOGIN_STATUS, isLogin)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(c cVar, boolean z10) {
            i.g(cVar, "activity");
            b0.d0(cVar, ResetPwdSucAty.class, new C0161a(z10));
        }
    }

    public static final void Y2(ResetPwdSucAty resetPwdSucAty, View view) {
        i.g(resetPwdSucAty, "this$0");
        resetPwdSucAty.X2();
    }

    public static final void a3(ResetPwdSucAty resetPwdSucAty) {
        i.g(resetPwdSucAty, "this$0");
        resetPwdSucAty.X2();
    }

    @Override // f5.d
    public void R2() {
        b3(new s2(this, this));
        this.f8060l = getIntent().getBooleanExtra("extra_login_status", true);
        int i10 = R$id.mTbvTitle;
        TitleBarView titleBarView = (TitleBarView) W2(i10);
        String string = getString(R.string.reset_successful);
        i.f(string, "getString(R.string.reset_successful)");
        titleBarView.setTitleText(string);
        ((TitleBarView) W2(i10)).isShowClose(false);
        ((TextView) W2(R$id.mTvHint)).setText(getString(R.string.pwd_reset_ok));
        ((TitleBarView) W2(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.o3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetPwdSucAty.Y2(ResetPwdSucAty.this, view);
            }
        });
        this.f8061m.postDelayed(this.f8062n, 5000L);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_reset_pwd_suc;
    }

    public View W2(int i10) {
        Map map = this.f8064p;
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

    public final void X2() {
        if (this.f8060l) {
            b0.c0(this, MainAty.class);
        } else {
            b0.c0(this, LoginAty.class);
            finish();
        }
    }

    @Override // f5.d
    /* renamed from: Z2, reason: merged with bridge method [inline-methods] */
    public s2 S2() {
        s2 s2Var = this.f8063o;
        if (s2Var != null) {
            return s2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void b3(s2 s2Var) {
        i.g(s2Var, "<set-?>");
        this.f8063o = s2Var;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        X2();
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        this.f8061m.removeCallbacks(this.f8062n);
        super.onDestroy();
    }
}
