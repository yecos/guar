package com.mobile.brasiltv.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ChangeEmailAty;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.MaxHeightLinearLayout;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.input.CustomInputView;
import com.mobile.brasiltv.view.login.IVerifyCodeCallback;
import com.mobile.brasiltv.view.login.VerifyCodeView;
import com.msandroid.mobile.R;
import g5.c;
import h9.g;
import h9.h;
import i6.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.t;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class ChangeEmailAty extends f5.d implements k {

    /* renamed from: l, reason: collision with root package name */
    public boolean f7839l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7840m;

    /* renamed from: n, reason: collision with root package name */
    public LoadingView f7841n;

    /* renamed from: o, reason: collision with root package name */
    public t f7842o;

    /* renamed from: s, reason: collision with root package name */
    public Map f7846s = new LinkedHashMap();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f7843p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public String f7844q = "@gmail.com";

    /* renamed from: r, reason: collision with root package name */
    public final g f7845r = h.b(new e());

    /* loaded from: classes3.dex */
    public static final class a implements CustomInputView.IEmailPrefixInputCallback {
        public a() {
        }

        @Override // com.mobile.brasiltv.view.input.CustomInputView.IEmailPrefixInputCallback
        public void onInputFocused() {
            ChangeEmailAty.this.l3();
        }

        @Override // com.mobile.brasiltv.view.input.CustomInputView.IEmailPrefixInputCallback
        public void onTextChanged(boolean z10) {
            ChangeEmailAty.this.f7839l = z10;
            ((VerifyCodeView) ChangeEmailAty.this.Y2(R$id.mVcvVerifyCode)).setSendEnabled(ChangeEmailAty.this.f7839l);
            ChangeEmailAty.this.r3();
            ChangeEmailAty changeEmailAty = ChangeEmailAty.this;
            changeEmailAty.m3(((CustomInputView) changeEmailAty.Y2(R$id.mEpiEmail)).getInputText());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements IVerifyCodeCallback {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
        public void onSendSms() {
            String str;
            x xVar = x.f8754a;
            ChangeEmailAty changeEmailAty = ChangeEmailAty.this;
            int i10 = R$id.mEpiEmail;
            String p10 = xVar.p(((CustomInputView) changeEmailAty.Y2(i10)).getInputText());
            if (p10 == null || p10.length() == 0) {
                ((CustomInputView) ChangeEmailAty.this.Y2(i10)).setInputText(((CustomInputView) ChangeEmailAty.this.Y2(i10)).getInputText() + ChangeEmailAty.this.i3());
            }
            String inputText = ((CustomInputView) ChangeEmailAty.this.Y2(i10)).getInputText();
            Locale locale = Locale.getDefault();
            i.f(locale, "getDefault()");
            String lowerCase = inputText.toLowerCase(locale);
            i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String v10 = xVar.v(ChangeEmailAty.this.Q1());
            if (v10 != null) {
                Locale locale2 = Locale.getDefault();
                i.f(locale2, "getDefault()");
                str = v10.toLowerCase(locale2);
                i.f(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (i.b(lowerCase, str)) {
                ChangeEmailAty.this.d(R.string.not_service_email_tips);
                return;
            }
            ((TextView) ChangeEmailAty.this.Y2(R$id.mTvConfirm)).requestFocus();
            b0.F(ChangeEmailAty.this);
            ChangeEmailAty.this.S2().r(((CustomInputView) ChangeEmailAty.this.Y2(i10)).getFullEmailText());
        }

        @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
        public void onVerifyCodeChanged(String str) {
            i.g(str, "content");
            ChangeEmailAty.this.f7840m = b0.K(str);
            ChangeEmailAty.this.r3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements c.a {
        public c() {
        }

        @Override // g5.c.a
        public void onClick(String str) {
            i.g(str, "mEmailString");
            ChangeEmailAty changeEmailAty = ChangeEmailAty.this;
            int i10 = R$id.mEpiEmail;
            ((CustomInputView) changeEmailAty.Y2(i10)).setInputText(str);
            ((CustomInputView) ChangeEmailAty.this.Y2(i10)).setInputSelection(str.length());
            ((RecyclerView) ChangeEmailAty.this.Y2(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) ChangeEmailAty.this.Y2(R$id.mLlRecyEmail)).setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements l {

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f7851a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                Intent putExtra = intent.putExtra("can_back", true);
                i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, true)");
                return putExtra;
            }
        }

        public d() {
            super(1);
        }

        public final void b(CommTipsDialog commTipsDialog) {
            i.g(commTipsDialog, "it");
            b0.d0(ChangeEmailAty.this, LoginAty.class, a.f7851a);
            commTipsDialog.dismiss();
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        public final g5.c invoke() {
            return new g5.c(ChangeEmailAty.this.Q1());
        }
    }

    public static final void f3(ChangeEmailAty changeEmailAty, View view) {
        i.g(changeEmailAty, "this$0");
        changeEmailAty.finish();
    }

    public static final void g3(ChangeEmailAty changeEmailAty, View view) {
        i.g(changeEmailAty, "this$0");
        xa.c.c().j(new GotoHomeTabEvent(2));
        b0.c0(changeEmailAty, MainAty.class);
    }

    public static final void h3(ChangeEmailAty changeEmailAty, View view) {
        i.g(changeEmailAty, "this$0");
        changeEmailAty.l3();
        changeEmailAty.S2().n(((CustomInputView) changeEmailAty.Y2(R$id.mEpiEmail)).getFullEmailText(), ((VerifyCodeView) changeEmailAty.Y2(R$id.mVcvVerifyCode)).getVerifyCode());
    }

    public static final void q3(ChangeEmailAty changeEmailAty, DialogInterface dialogInterface) {
        i.g(changeEmailAty, "this$0");
        changeEmailAty.f7841n = null;
    }

    @Override // f5.d
    public void R2() {
        n3(new t(this, this));
        int i10 = R$id.mRvCompleteList;
        ((RecyclerView) Y2(i10)).setLayoutManager(new LinearLayoutManagerWrapper(Q1()));
        ((RecyclerView) Y2(i10)).setAdapter(j3());
        int i11 = R$id.mTbvTitle;
        ((TitleBarView) Y2(i11)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeEmailAty.f3(ChangeEmailAty.this, view);
            }
        });
        ((TitleBarView) Y2(i11)).setOnCloseClickListener(new View.OnClickListener() { // from class: f5.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeEmailAty.g3(ChangeEmailAty.this, view);
            }
        });
        int i12 = R$id.mEpiEmail;
        ((CustomInputView) Y2(i12)).setInputFilter(new b7.a());
        ((CustomInputView) Y2(i12)).setEmailPrefixInputCallback(new a());
        ((VerifyCodeView) Y2(R$id.mVcvVerifyCode)).setVerifyCodeCallback(new b());
        ((TextView) Y2(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: f5.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeEmailAty.h3(ChangeEmailAty.this, view);
            }
        });
        j3().f(new c());
        x.f8754a.v(Q1());
        o3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_change_email;
    }

    public View Y2(int i10) {
        Map map = this.f7846s;
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

    @Override // i6.k
    public void b2() {
        BindEmailSucAty.f7807r.b(this);
    }

    @xa.j
    public final void closePage(CloseBindEmailSucEvent closeBindEmailSucEvent) {
        i.g(closeBindEmailSucEvent, "event");
        finish();
    }

    @Override // i6.k
    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) Y2(i11)).setVisibility(0);
        ((TextView) Y2(i11)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) Y2(i11)).setText(getResources().getString(i10));
    }

    @Override // i6.k
    public void e(List list) {
        i.g(list, "emailSuffixList");
        if (!list.isEmpty()) {
            this.f7843p.addAll(list);
        }
    }

    @Override // i6.k
    public void i() {
        p3();
        com.mobile.brasiltv.utils.k.f8726a.c("key_verifycode_bind_time", System.currentTimeMillis());
        VerifyCodeView verifyCodeView = (VerifyCodeView) Y2(R$id.mVcvVerifyCode);
        i.f(verifyCodeView, "mVcvVerifyCode");
        VerifyCodeView.startCountDown$default(verifyCodeView, 0L, 1, null);
    }

    public final String i3() {
        return this.f7844q;
    }

    @Override // i6.k
    public void j() {
        String string = getString(R.string.email_was_bound_tips);
        i.f(string, "getString(R.string.email_was_bound_tips)");
        new CommTipsDialog(this, string, getString(R.string.input_email_tips), getString(R.string.go_to_log_in), null, null, new d(), null, false, 432, null).show();
    }

    public final g5.c j3() {
        return (g5.c) this.f7845r.getValue();
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // f5.d
    /* renamed from: k3, reason: merged with bridge method [inline-methods] */
    public t S2() {
        t tVar = this.f7842o;
        if (tVar != null) {
            return tVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void l3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) Y2(i10)).setVisibility(4);
        ((TextView) Y2(i10)).setText("");
    }

    public final void m3(String str) {
        if (TextUtils.isEmpty(str) || !ba.t.o(str, "@", false, 2, null) || ba.t.y(str, "@", 0, false, 6, null) != ba.t.D(str, "@", 0, false, 6, null)) {
            ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(8);
            return;
        }
        if (s.e(str, "@", false, 2, null)) {
            g5.c j32 = j3();
            String substring = str.substring(0, str.length() - 1);
            i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            j32.g(substring);
            j3().e(this.f7843p);
            ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(0);
            ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(0);
            return;
        }
        String lowerCase = str.toLowerCase();
        i.f(lowerCase, "this as java.lang.String).toLowerCase()");
        String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, null).toArray(new String[0]);
        String str2 = '@' + strArr[1];
        int size = this.f7843p.size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = this.f7843p.get(i10);
            i.f(obj, "mEmailSuffixList[i]");
            String str3 = (String) obj;
            String lowerCase2 = str3.toLowerCase();
            i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (s.l(lowerCase2, str2, false, 2, null)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(8);
            return;
        }
        j3().g(strArr[0]);
        j3().e(arrayList);
        int i11 = R$id.mRvCompleteList;
        ((RecyclerView) Y2(i11)).setBackgroundDrawable(Q1().getResources().getDrawable(R.drawable.bg_associate_email));
        ((RecyclerView) Y2(i11)).setVisibility(0);
        ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(0);
    }

    public void n3(t tVar) {
        i.g(tVar, "<set-?>");
        this.f7842o = tVar;
    }

    public final void o3() {
        long currentTimeMillis = 180 - ((System.currentTimeMillis() - com.mobile.brasiltv.utils.k.f8726a.b("key_verifycode_bind_time")) / 1000);
        if (currentTimeMillis > 0) {
            ((VerifyCodeView) Y2(R$id.mVcvVerifyCode)).startCountDown(currentTimeMillis);
        }
    }

    public final void p3() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) Y2(i10)).setVisibility(0);
        ((TextView) Y2(i10)).setTextColor(getResources().getColor(R.color.color_ffffff));
        ((TextView) Y2(i10)).setText(Html.fromHtml(getResources().getString(R.string.be_goto_email_and_view, "<font color=\"#3cd977\">" + ((CustomInputView) Y2(R$id.mEpiEmail)).getFullEmailText() + "</font>")));
    }

    public final void r3() {
        ((TextView) Y2(R$id.mTvConfirm)).setEnabled(this.f7839l && this.f7840m);
    }

    @Override // i6.k
    public void showLoading(boolean z10) {
        if (this.f7841n == null) {
            this.f7841n = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: f5.a0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ChangeEmailAty.q3(ChangeEmailAty.this, dialogInterface);
                }
            }, 6, null);
            h9.t tVar = h9.t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f7841n;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f7841n;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
