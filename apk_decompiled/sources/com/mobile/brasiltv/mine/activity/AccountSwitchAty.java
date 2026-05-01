package com.mobile.brasiltv.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.RefreshAccountEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.AccountSwitchAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.dialog.AccountRemoveDialog;
import com.msandroid.mobile.R;
import g5.q3;
import h9.h;
import h9.t;
import i6.f;
import i6.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.o;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class AccountSwitchAty extends f5.d implements g {

    /* renamed from: m, reason: collision with root package name */
    public View f8297m;

    /* renamed from: n, reason: collision with root package name */
    public LoadingView f8298n;

    /* renamed from: o, reason: collision with root package name */
    public int f8299o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8300p;

    /* renamed from: q, reason: collision with root package name */
    public o f8301q;

    /* renamed from: s, reason: collision with root package name */
    public Map f8303s = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f8296l = h.b(new c());

    /* renamed from: r, reason: collision with root package name */
    public final Runnable f8302r = new Runnable() { // from class: e6.n
        @Override // java.lang.Runnable
        public final void run() {
            AccountSwitchAty.i3(AccountSwitchAty.this);
        }
    };

    /* loaded from: classes3.dex */
    public static final class a extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8304a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("extra_login_out", true);
            i.f(putExtra, "it.putExtra(LoginAty.EXTRA_LOGIN_OUT, true)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements q3.a {

        public static final class a extends j implements s9.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AccountSwitchAty f8306a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SwitchAccountBean f8307b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AccountSwitchAty accountSwitchAty, SwitchAccountBean switchAccountBean) {
                super(0);
                this.f8306a = accountSwitchAty;
                this.f8307b = switchAccountBean;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m58invoke() {
                this.f8306a.S2().C(this.f8307b);
            }

            @Override // s9.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m58invoke();
                return t.f14242a;
            }
        }

        public b() {
        }

        @Override // g5.q3.a
        public void a(int i10, SwitchAccountBean switchAccountBean) {
            i.g(switchAccountBean, "bean");
            AccountSwitchAty.this.f8299o = i10;
            AccountSwitchAty.this.S2().z(switchAccountBean);
        }

        @Override // g5.q3.a
        public void b(int i10, String str, SwitchAccountBean switchAccountBean) {
            i.g(str, "account");
            i.g(switchAccountBean, "bean");
            AccountSwitchAty accountSwitchAty = AccountSwitchAty.this;
            new AccountRemoveDialog(accountSwitchAty, str, new a(accountSwitchAty, switchAccountBean), new C0165b(AccountSwitchAty.this)).show();
        }

        @Override // g5.q3.a
        public void onBack() {
            AccountSwitchAty.this.finish();
        }

        /* renamed from: com.mobile.brasiltv.mine.activity.AccountSwitchAty$b$b, reason: collision with other inner class name */
        public static final class C0165b extends j implements s9.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AccountSwitchAty f8308a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0165b(AccountSwitchAty accountSwitchAty) {
                super(0);
                this.f8308a = accountSwitchAty;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m59invoke() {
                this.f8308a.c3().j(!this.f8308a.c3().g());
                this.f8308a.l3();
            }

            @Override // s9.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m59invoke();
                return t.f14242a;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final q3 invoke() {
            return new q3(AccountSwitchAty.this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8310a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.f8310a = str;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        public final void invoke(String str) {
            f1.f8649a.x(y.p(y.f8771a, this.f8310a, null, null, 6, null));
        }
    }

    public static final void f3(AccountSwitchAty accountSwitchAty, View view) {
        i.g(accountSwitchAty, "this$0");
        b0.d0(accountSwitchAty, LoginAty.class, a.f8304a);
    }

    public static final void h3(AccountSwitchAty accountSwitchAty, View view) {
        i.g(accountSwitchAty, "this$0");
        accountSwitchAty.c3().j(!accountSwitchAty.c3().g());
        accountSwitchAty.l3();
    }

    public static final void i3(AccountSwitchAty accountSwitchAty) {
        i.g(accountSwitchAty, "this$0");
        ((TextView) accountSwitchAty.Y2(R$id.mTvError)).setVisibility(8);
        if (accountSwitchAty.f8300p) {
            accountSwitchAty.f8300p = false;
            LoginAty.C.b(accountSwitchAty, true, true, (SwitchAccountBean) accountSwitchAty.c3().d().get(accountSwitchAty.f8299o));
        }
    }

    public static final void m3(AccountSwitchAty accountSwitchAty, DialogInterface dialogInterface) {
        i.g(accountSwitchAty, "this$0");
        accountSwitchAty.f8298n = null;
    }

    @Override // i6.g
    public void B1() {
        LoadingView loadingView = this.f8298n;
        if (loadingView != null) {
            loadingView.dismiss();
        }
        ((TextView) Y2(R$id.mTvError)).setVisibility(8);
    }

    @Override // f5.d
    public void R2() {
        j3(new o(this, this));
        ((ListView) Y2(R$id.mAccountList)).setAdapter((ListAdapter) c3());
        e3();
        g3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_account_switch;
    }

    @Override // i6.g
    public void V1() {
        c3().notifyDataSetChanged();
        n3();
    }

    public View Y2(int i10) {
        Map map = this.f8303s;
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

    @Override // i6.g
    public void Z1(ArrayList arrayList) {
        i.g(arrayList, "accountListData");
        c3().i(arrayList);
        n3();
    }

    public final q3 c3() {
        return (q3) this.f8296l.getValue();
    }

    @Override // f5.d
    /* renamed from: d3, reason: merged with bridge method [inline-methods] */
    public o S2() {
        o oVar = this.f8301q;
        if (oVar != null) {
            return oVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void e3() {
        int i10 = R$id.mAccountList;
        if (((ListView) Y2(i10)).getFooterViewsCount() == 0) {
            this.f8297m = LayoutInflater.from(this).inflate(R.layout.footer_switch_accout, (ViewGroup) null);
            ((ListView) Y2(i10)).addFooterView(this.f8297m);
            View view = this.f8297m;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: e6.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AccountSwitchAty.f3(AccountSwitchAty.this, view2);
                    }
                });
            }
        }
    }

    public final void g3() {
        ((TitleView) Y2(R$id.mTileView)).setTvMenuClickListener(new View.OnClickListener() { // from class: e6.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSwitchAty.h3(AccountSwitchAty.this, view);
            }
        });
        c3().h(new b());
    }

    @Override // i6.g
    public void h() {
        if (this.f8298n == null) {
            this.f8298n = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: e6.q
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AccountSwitchAty.m3(AccountSwitchAty.this, dialogInterface);
                }
            }, 6, null);
            t tVar = t.f14242a;
        }
        LoadingView loadingView = this.f8298n;
        if (loadingView != null) {
            loadingView.setCancelable(false);
        }
        LoadingView loadingView2 = this.f8298n;
        if (loadingView2 != null) {
            loadingView2.show();
        }
        ((TextView) Y2(R$id.mTvError)).setVisibility(8);
    }

    public void j3(o oVar) {
        i.g(oVar, "<set-?>");
        this.f8301q = oVar;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // m5.a
    /* renamed from: k3, reason: merged with bridge method [inline-methods] */
    public void Y0(f fVar) {
        i.g(fVar, "presenter");
    }

    public final void l3() {
        int i10 = R$id.mTileView;
        ((TitleView) Y2(i10)).setTvMenuTextSize(32);
        TitleView titleView = (TitleView) Y2(i10);
        String string = getString(c3().g() ? R.string.switch_account_cancel : R.string.switch_account_remove);
        i.f(string, "getString(if (mAccountLi…ng.switch_account_remove)");
        titleView.setTvMenuText(string);
        c3().notifyDataSetChanged();
    }

    public final void n3() {
        if (!(!c3().d().isEmpty())) {
            ((TitleView) Y2(R$id.mTileView)).setTvMenuText("");
        } else if (c3().d().size() == 1 && ((SwitchAccountBean) c3().d().get(0)).isLogged()) {
            ((TitleView) Y2(R$id.mTileView)).setTvMenuText("");
        } else {
            l3();
        }
    }

    @Override // i6.g
    public void o(String str) {
        i.g(str, "error");
        if (i.b(str, "aaa100012") || i.b(str, "aaa100022") || i.b(str, "aaa100027") || i.b(str, "aaa100028") || i.b(str, "aaa100080") || i.b(str, "aaa100081") || i.b(str, "aaa100091") || i.b(str, "aaa100081") || i.b(str, "aaa100093")) {
            this.f8300p = true;
            ((TextView) Y2(R$id.mTvError)).setText(getString(R.string.switch_account_expired));
        } else if (i.b(na.d.b(str), "EA2")) {
            this.f8300p = false;
            x.f8754a.w(Q1(), new d(str));
            return;
        } else {
            this.f8300p = false;
            ((TextView) Y2(R$id.mTvError)).setText(getString(R.string.scan_login_failed));
        }
        int i10 = R$id.mTvError;
        ((TextView) Y2(i10)).setVisibility(0);
        ((TextView) Y2(i10)).removeCallbacks(this.f8302r);
        ((TextView) Y2(i10)).postDelayed(this.f8302r, 3000L);
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        S2().v();
    }

    @Override // u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        super.onStop();
        ((TextView) Y2(R$id.mTvError)).removeCallbacks(this.f8302r);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void refreshData(RefreshAccountEvent refreshAccountEvent) {
        i.g(refreshAccountEvent, "event");
        S2().v();
        b0.c0(this, MainAty.class);
    }
}
