package com.mobile.brasiltv.mine.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.EmailManagerAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CancelFreezeAtyEvent;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.bean.event.RefreshAccountEvent;
import com.mobile.brasiltv.mine.activity.AccountAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.k;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.dialog.CommonAlertDialog;
import com.mobile.brasiltv.view.dialog.ICommonAlertCallback;
import com.mobile.brasiltv.view.dialog.InputPwdDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import h9.t;
import i6.e;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.f;
import mobile.com.requestframe.utils.response.UserBindData;
import mobile.com.requestframe.utils.response.UserBindResult;
import org.greenrobot.eventbus.ThreadMode;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

/* loaded from: classes.dex */
public final class AccountAty extends f5.d implements e, z7.a {

    /* renamed from: q, reason: collision with root package name */
    public static final a f8279q = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public boolean f8280l;

    /* renamed from: m, reason: collision with root package name */
    public z7.b f8281m;

    /* renamed from: n, reason: collision with root package name */
    public InputPwdDialog f8282n;

    /* renamed from: o, reason: collision with root package name */
    public f f8283o;

    /* renamed from: p, reason: collision with root package name */
    public Map f8284p = new LinkedHashMap();

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements ICommonAlertCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.dialog.ICommonAlertCallback
        public void onCancel(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
        }

        @Override // com.mobile.brasiltv.view.dialog.ICommonAlertCallback
        public void onConfirm(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
            b0.c0(AccountAty.this, EmailAty.class);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m57invoke();
            return t.f14242a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m57invoke() {
            b0.F(AccountAty.this);
            InputPwdDialog inputPwdDialog = AccountAty.this.f8282n;
            if (j1.f(inputPwdDialog != null ? inputPwdDialog.getPwd() : null)) {
                AccountAty.this.A3();
            } else {
                AccountAty.this.r2(R.string.password_format_incorrect);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements ICommonAlertCallback {
        public d() {
        }

        @Override // com.mobile.brasiltv.view.dialog.ICommonAlertCallback
        public void onCancel(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
        }

        @Override // com.mobile.brasiltv.view.dialog.ICommonAlertCallback
        public void onConfirm(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
            AccountAty.this.u3();
        }
    }

    public static final void g3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        accountAty.n3();
    }

    public static final void h3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        b0.c0(accountAty, ChangePwdAty.class);
    }

    public static final void i3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        if (b0.T(w6.i.f19214g.i(), "1")) {
            accountAty.z3();
        } else {
            accountAty.f3();
        }
    }

    public static final void j3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        b0.c0(accountAty, AccountSwitchAty.class);
    }

    public static final void k3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        if (d6.b.f12660a.t()) {
            b0.c0(accountAty, LoginAty.class);
            return;
        }
        f S2 = accountAty.S2();
        MemberInfo memberInfo = MemberInfo.INSTANCE;
        S2.y(memberInfo.getLastUserName(), memberInfo.getLastPassword(), "0");
    }

    public static final void l3(AccountAty accountAty, View view) {
        i.g(accountAty, "this$0");
        if (accountAty.f8280l) {
            return;
        }
        accountAty.finish();
    }

    public static final void v3(AccountAty accountAty, DialogInterface dialogInterface) {
        i.g(accountAty, "this$0");
        accountAty.f8282n = null;
    }

    public final void A3() {
        String str;
        f S2 = S2();
        InputPwdDialog inputPwdDialog = this.f8282n;
        if (inputPwdDialog == null || (str = inputPwdDialog.getPwd()) == null) {
            str = "";
        }
        S2.z(str);
    }

    public final void B3() {
        String j10 = d6.b.f12660a.j(Q1());
        String lastUserName = MemberInfo.INSTANCE.getLastUserName();
        if (!i.b(j10, CdnType.DIGITAL_TYPE_PEERSTAR)) {
            ((TextView) b3(R$id.mTextAccount)).setText(w6.i.f19214g.H());
            ((TextView) b3(R$id.mTextAccountDesc)).setText("");
            return;
        }
        ((TextView) b3(R$id.mTextAccount)).setText(lastUserName);
        ((TextView) b3(R$id.mTextAccountDesc)).setText(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + w6.i.f19214g.H() + ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    @Override // i6.e
    public void M() {
        x3();
    }

    @Override // i6.e
    public void O() {
        InputPwdDialog inputPwdDialog = this.f8282n;
        if (inputPwdDialog != null) {
            inputPwdDialog.dismiss();
        }
    }

    @Override // f5.d
    public void R2() {
        q3(new f(this, this));
        p3();
        ((AutoRelativeLayout) b3(R$id.mLayoutEmail)).setOnClickListener(new View.OnClickListener() { // from class: e6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountAty.g3(AccountAty.this, view);
            }
        });
        ((AutoRelativeLayout) b3(R$id.mLayoutChangePwd)).setOnClickListener(new View.OnClickListener() { // from class: e6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountAty.h3(AccountAty.this, view);
            }
        });
        ((TextView) b3(R$id.mTvGoogleBindOrUnbind)).setOnClickListener(new View.OnClickListener() { // from class: e6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountAty.i3(AccountAty.this, view);
            }
        });
        ((TextView) b3(R$id.mTvSwitchAccount)).setOnClickListener(new View.OnClickListener() { // from class: e6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountAty.j3(AccountAty.this, view);
            }
        });
        ((TextView) b3(R$id.mTvLoginOrLogout)).setOnClickListener(new View.OnClickListener() { // from class: e6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountAty.k3(AccountAty.this, view);
            }
        });
        ((TitleView) b3(R$id.title_view)).setOnBackClickListener(new View.OnClickListener() { // from class: e6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountAty.l3(AccountAty.this, view);
            }
        });
    }

    @Override // z7.a
    public void S0(int i10, x7.a aVar) {
        i.g(aVar, "info");
        S2().n(i10 == 1 ? "google" : "facebook", aVar);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_account;
    }

    @Override // i6.e
    public void U0() {
        k.f8726a.a();
        ((TextView) b3(R$id.mTvLoginOrLogout)).setText(getResources().getString(R.string.am_login_other_account));
    }

    @Override // i6.e
    public void X1(UserBindResult userBindResult) {
        i.g(userBindResult, "userBindResult");
        UserBindData data = userBindResult.getData();
        if (TextUtils.isEmpty(data != null ? data.getEmail() : null)) {
            ((TextView) b3(R$id.mTextEmail)).setText(getResources().getString(R.string.not_linked));
        } else {
            TextView textView = (TextView) b3(R$id.mTextEmail);
            UserBindData data2 = userBindResult.getData();
            textView.setText(data2 != null ? data2.getEmail() : null);
        }
        t3();
    }

    public View b3(int i10) {
        Map map = this.f8284p;
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

    public final void f3() {
        d6.b bVar = d6.b.f12660a;
        if (bVar.b() || bVar.d()) {
            w3();
        } else {
            s3();
        }
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // f5.d
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public f S2() {
        f fVar = this.f8283o;
        if (fVar != null) {
            return fVar;
        }
        i.w("mPresenter");
        return null;
    }

    @Override // i6.e
    public void n(int i10) {
        String string = getResources().getString(i10);
        i.f(string, "resources.getString(resId)");
        z0(string);
    }

    public final void n3() {
        if (b0.T(w6.i.f19214g.h(), "0")) {
            b0.c0(this, EmailAty.class);
        } else {
            b0.c0(this, EmailManagerAty.class);
        }
    }

    public final void o3() {
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        z7.b bVar = this.f8281m;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f8280l) {
            return;
        }
        super.onBackPressed();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onCancelFreeze(CancelFreezeAtyEvent cancelFreezeAtyEvent) {
        i.g(cancelFreezeAtyEvent, "event");
        J2();
        showLoading(false);
        finish();
    }

    @xa.j
    public final void onEventMainThread(ClosePageEvent closePageEvent) {
        i.g(closePageEvent, "closePageEvent");
        finish();
    }

    @Override // u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onStart() {
        super.onStart();
        S2().o();
    }

    @Override // z7.a
    public void p1(int i10, y7.b bVar) {
        i.g(bVar, "exception");
        if (bVar.a()) {
            String string = getResources().getString(R.string.timeout_and_use_other_login);
            i.f(string, "resources.getString(R.st…eout_and_use_other_login)");
            z0(string);
        } else if (bVar.b()) {
            String string2 = getResources().getString(R.string.g_unsupport_google_service);
            i.f(string2, "resources.getString(R.st…unsupport_google_service)");
            z0(string2);
        }
    }

    public final void p3() {
        String string;
        B3();
        TextView textView = (TextView) b3(R$id.mTextEmail);
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.m(), "")) {
            string = getResources().getString(R.string.not_linked);
        } else {
            StringBuilder sb = new StringBuilder();
            String substring = cVar.m().substring(0, ba.t.y(cVar.m(), "@", 0, false, 6, null) - 3);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("***");
            String substring2 = cVar.m().substring(ba.t.y(cVar.m(), "@", 0, false, 6, null));
            t9.i.f(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            string = sb.toString();
        }
        textView.setText(string);
        if (!a6.f.f268a.a()) {
            ((AutoLinearLayout) b3(R$id.mLayoutGoogle)).setVisibility(8);
        }
        o3();
        t3();
        x3();
        y3();
    }

    @Override // i6.e
    public void q() {
        z7.b bVar = this.f8281m;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    public void q3(f fVar) {
        t9.i.g(fVar, "<set-?>");
        this.f8283o = fVar;
    }

    @Override // i6.e
    public void r2(int i10) {
        InputPwdDialog inputPwdDialog = this.f8282n;
        if (inputPwdDialog != null) {
            String string = getResources().getString(i10);
            t9.i.f(string, "resources.getString(resId)");
            inputPwdDialog.setErrorHint(string);
        }
    }

    @Override // m5.a
    /* renamed from: r3, reason: merged with bridge method [inline-methods] */
    public void Y0(i6.d dVar) {
        t9.i.g(dVar, "presenter");
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void refreshData(RefreshAccountEvent refreshAccountEvent) {
        t9.i.g(refreshAccountEvent, "event");
        p3();
        S2().o();
    }

    public final void s3() {
        String string = getResources().getString(R.string.am_dialog_bind_before_unbind);
        t9.i.f(string, "resources.getString(R.st…ialog_bind_before_unbind)");
        String string2 = getResources().getString(R.string.cancel);
        t9.i.f(string2, "resources.getString(R.string.cancel)");
        String string3 = getResources().getString(R.string.am_dialog_goto_bind);
        t9.i.f(string3, "resources.getString(R.string.am_dialog_goto_bind)");
        new CommonAlertDialog(this, string, string2, string3).setCommonAlertCallback(new b()).show();
    }

    @Override // i6.e
    public void showLoading(boolean z10) {
        ((ProgressBar) b3(R$id.mLoadingPbar)).setVisibility(z10 ? 0 : 8);
    }

    @Override // i6.e
    public void t(boolean z10) {
        ((AutoRelativeLayout) b3(R$id.mLayoutEmail)).setClickable(!z10);
        ((AutoRelativeLayout) b3(R$id.mLayoutChangePwd)).setClickable(!z10);
        ((TextView) b3(R$id.mTvLoginOrLogout)).setClickable(!z10);
        this.f8280l = z10;
    }

    public final void t3() {
        ((AutoRelativeLayout) b3(R$id.mLayoutChangePwd)).setVisibility((d6.b.f12660a.w() || t9.i.b(w6.i.f19214g.s(), "0")) ? 8 : 0);
    }

    @Override // i6.e
    public void u2() {
        i.c cVar = w6.i.f19214g;
        if (!cVar.h().equals("1")) {
            ((TextView) b3(R$id.mTextEmail)).setText(getResources().getString(R.string.not_linked));
            return;
        }
        int i10 = R$id.mTextEmail;
        ((TextView) b3(i10)).setText(cVar.m());
        TextView textView = (TextView) b3(i10);
        StringBuilder sb = new StringBuilder();
        String substring = cVar.m().substring(0, ba.t.y(cVar.m(), "@", 0, false, 6, null) - 3);
        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append("***");
        String substring2 = cVar.m().substring(ba.t.y(cVar.m(), "@", 0, false, 6, null));
        t9.i.f(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        textView.setText(sb.toString());
    }

    public final void u3() {
        if (this.f8282n == null) {
            InputPwdDialog inputPwdDialog = new InputPwdDialog(this);
            this.f8282n = inputPwdDialog;
            inputPwdDialog.setConfirmCallback(new c());
            InputPwdDialog inputPwdDialog2 = this.f8282n;
            if (inputPwdDialog2 != null) {
                inputPwdDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: e6.h
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AccountAty.v3(AccountAty.this, dialogInterface);
                    }
                });
            }
        }
        InputPwdDialog inputPwdDialog3 = this.f8282n;
        if (inputPwdDialog3 != null) {
            inputPwdDialog3.show();
        }
    }

    public final void w3() {
        String string = getResources().getString(R.string.am_dialog_not_login_after_unbind, w6.i.f19214g.p());
        t9.i.f(string, "resources.getString(R.st…alService.googleNickName)");
        String string2 = getResources().getString(R.string.cancel);
        t9.i.f(string2, "resources.getString(R.string.cancel)");
        String string3 = getResources().getString(R.string.am_dialog_confirm_unbind);
        t9.i.f(string3, "resources.getString(R.st…am_dialog_confirm_unbind)");
        new CommonAlertDialog(this, string, string2, string3).setCommonAlertCallback(new d()).show();
    }

    public final void x3() {
        i.c cVar = w6.i.f19214g;
        if (b0.T(cVar.i(), "1")) {
            ((TextView) b3(R$id.mTvGoogleBindOrUnbind)).setText(getResources().getString(R.string.am_to_bind));
            ((TextView) b3(R$id.mTvGoogleNick)).setText("");
            return;
        }
        ((TextView) b3(R$id.mTvGoogleBindOrUnbind)).setText(getResources().getString(R.string.am_to_unbind));
        ((TextView) b3(R$id.mTvGoogleNick)).setText(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + cVar.p() + ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    public final void y3() {
        if (d6.b.f12660a.t()) {
            ((TextView) b3(R$id.mTvLoginOrLogout)).setText(getResources().getString(R.string.am_login_other_account));
        } else {
            ((TextView) b3(R$id.mTvLoginOrLogout)).setText(getResources().getString(R.string.login_out));
        }
    }

    public final void z3() {
        if (!a6.f.f268a.a()) {
            n(R.string.try_other_bind_method);
            return;
        }
        if (this.f8281m == null) {
            w7.a aVar = w7.a.f19265a;
            String string = getResources().getString(R.string.server_client_id);
            t9.i.f(string, "resources.getString(R.string.server_client_id)");
            z7.b a10 = aVar.a(this, 1, string);
            this.f8281m = a10;
            if (a10 != null) {
                a10.b(this);
            }
        }
        z7.b bVar = this.f8281m;
        if (bVar != null) {
            bVar.d(this);
        }
    }
}
