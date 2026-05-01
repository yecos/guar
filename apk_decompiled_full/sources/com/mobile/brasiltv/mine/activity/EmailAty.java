package com.mobile.brasiltv.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.BindEmailSucAty;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.SetPwdOnBeAty;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.k;
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
import h9.t;
import i6.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.y;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class EmailAty extends f5.d implements n {

    /* renamed from: l, reason: collision with root package name */
    public boolean f8320l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8321m;

    /* renamed from: n, reason: collision with root package name */
    public LoadingView f8322n;

    /* renamed from: o, reason: collision with root package name */
    public y f8323o;

    /* renamed from: s, reason: collision with root package name */
    public Map f8327s = new LinkedHashMap();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f8324p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final g f8325q = h.b(new e());

    /* renamed from: r, reason: collision with root package name */
    public String f8326r = "@gmail.com";

    /* loaded from: classes3.dex */
    public static final class a implements CustomInputView.IEmailPrefixInputCallback {
        public a() {
        }

        @Override // com.mobile.brasiltv.view.input.CustomInputView.IEmailPrefixInputCallback
        public void onInputFocused() {
            EmailAty.this.l3();
        }

        @Override // com.mobile.brasiltv.view.input.CustomInputView.IEmailPrefixInputCallback
        public void onTextChanged(boolean z10) {
            EmailAty.this.f8320l = z10;
            ((VerifyCodeView) EmailAty.this.Y2(R$id.mVcvVerifyCode)).setSendEnabled(EmailAty.this.f8320l);
            EmailAty.this.r3();
            y S2 = EmailAty.this.S2();
            EmailAty emailAty = EmailAty.this;
            int i10 = R$id.mEpiEmail;
            S2.o(((CustomInputView) emailAty.Y2(i10)).getInputText());
            EmailAty emailAty2 = EmailAty.this;
            emailAty2.m3(((CustomInputView) emailAty2.Y2(i10)).getInputText());
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
            EmailAty emailAty = EmailAty.this;
            int i10 = R$id.mEpiEmail;
            String p10 = xVar.p(((CustomInputView) emailAty.Y2(i10)).getInputText());
            if (p10 == null || p10.length() == 0) {
                ((CustomInputView) EmailAty.this.Y2(i10)).setInputText(((CustomInputView) EmailAty.this.Y2(i10)).getInputText() + EmailAty.this.i3());
            }
            String inputText = ((CustomInputView) EmailAty.this.Y2(i10)).getInputText();
            Locale locale = Locale.getDefault();
            i.f(locale, "getDefault()");
            String lowerCase = inputText.toLowerCase(locale);
            i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String v10 = xVar.v(EmailAty.this.Q1());
            if (v10 != null) {
                Locale locale2 = Locale.getDefault();
                i.f(locale2, "getDefault()");
                str = v10.toLowerCase(locale2);
                i.f(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (i.b(lowerCase, str)) {
                EmailAty.this.d(R.string.not_service_email_tips);
                return;
            }
            ((TextView) EmailAty.this.Y2(R$id.mTvNext)).requestFocus();
            b0.F(EmailAty.this);
            EmailAty.this.S2().p(((CustomInputView) EmailAty.this.Y2(i10)).getFullEmailText());
        }

        @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
        public void onVerifyCodeChanged(String str) {
            i.g(str, "content");
            EmailAty.this.f8321m = b0.K(str);
            EmailAty.this.r3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements c.a {
        public c() {
        }

        @Override // g5.c.a
        public void onClick(String str) {
            i.g(str, "mEmailString");
            EmailAty emailAty = EmailAty.this;
            int i10 = R$id.mEpiEmail;
            ((CustomInputView) emailAty.Y2(i10)).setInputText(str);
            ((CustomInputView) EmailAty.this.Y2(i10)).setInputSelection(str.length());
            ((RecyclerView) EmailAty.this.Y2(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) EmailAty.this.Y2(R$id.mLlRecyEmail)).setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements l {

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f8332a = new a();

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
            b0.d0(EmailAty.this, LoginAty.class, a.f8332a);
            commTipsDialog.dismiss();
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        public final g5.c invoke() {
            return new g5.c(EmailAty.this.Q1());
        }
    }

    public static final void f3(EmailAty emailAty, View view) {
        i.g(emailAty, "this$0");
        emailAty.finish();
    }

    public static final void g3(EmailAty emailAty, View view) {
        i.g(emailAty, "this$0");
        xa.c.c().j(new GotoHomeTabEvent(2));
        b0.c0(emailAty, MainAty.class);
    }

    public static final void h3(EmailAty emailAty, View view) {
        i.g(emailAty, "this$0");
        emailAty.l3();
        emailAty.S2().j(((CustomInputView) emailAty.Y2(R$id.mEpiEmail)).getFullEmailText(), ((VerifyCodeView) emailAty.Y2(R$id.mVcvVerifyCode)).getVerifyCode());
    }

    public static final void q3(EmailAty emailAty, DialogInterface dialogInterface) {
        i.g(emailAty, "this$0");
        emailAty.f8322n = null;
    }

    @Override // i6.n
    public void B() {
        xa.c.c().j(new CloseForceBindEvent());
        w6.i.f19214g.q0("1");
        xa.c.c().m(new UpdateRestrictEvent("1", false, 2, null));
        BindEmailSucAty.f7807r.a(this);
    }

    @Override // i6.n
    public void K() {
        SetPwdOnBeAty.f8132q.a(this, ((CustomInputView) Y2(R$id.mEpiEmail)).getFullEmailText());
    }

    @Override // f5.d
    public void R2() {
        n3(new y(this, this));
        int i10 = R$id.mEpiEmail;
        ((CustomInputView) Y2(i10)).setInputFilter(new b7.a());
        int i11 = R$id.mRvCompleteList;
        ((RecyclerView) Y2(i11)).setLayoutManager(new LinearLayoutManagerWrapper(Q1()));
        ((RecyclerView) Y2(i11)).setAdapter(j3());
        String m10 = S2().m();
        ((CustomInputView) Y2(i10)).setInputText(m10);
        this.f8320l = b0.K(m10);
        int i12 = R$id.mVcvVerifyCode;
        ((VerifyCodeView) Y2(i12)).setSendEnabled(this.f8320l);
        int i13 = R$id.mTbvTitle;
        ((TitleBarView) Y2(i13)).setOnBackClickListener(new View.OnClickListener() { // from class: e6.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailAty.f3(EmailAty.this, view);
            }
        });
        ((TitleBarView) Y2(i13)).setOnCloseClickListener(new View.OnClickListener() { // from class: e6.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailAty.g3(EmailAty.this, view);
            }
        });
        ((CustomInputView) Y2(i10)).setEmailPrefixInputCallback(new a());
        ((VerifyCodeView) Y2(i12)).setVerifyCodeCallback(new b());
        ((TextView) Y2(R$id.mTvNext)).setOnClickListener(new View.OnClickListener() { // from class: e6.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailAty.h3(EmailAty.this, view);
            }
        });
        j3().f(new c());
        x.f8754a.v(Q1());
        o3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_email;
    }

    public View Y2(int i10) {
        Map map = this.f8327s;
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

    @Override // i6.n
    public void d(int i10) {
        int i11 = R$id.mTvErrorHint;
        ((TextView) Y2(i11)).setVisibility(0);
        ((TextView) Y2(i11)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) Y2(i11)).setText(getResources().getString(i10));
    }

    @Override // i6.n
    public void e(List list) {
        i.g(list, "emailSuffixList");
        if (!list.isEmpty()) {
            this.f8324p.addAll(list);
        }
    }

    @Override // i6.n
    public void i() {
        p3();
        k.f8726a.c("key_verifycode_bind_time", System.currentTimeMillis());
        VerifyCodeView verifyCodeView = (VerifyCodeView) Y2(R$id.mVcvVerifyCode);
        i.f(verifyCodeView, "mVcvVerifyCode");
        VerifyCodeView.startCountDown$default(verifyCodeView, 0L, 1, null);
    }

    public final String i3() {
        return this.f8326r;
    }

    @Override // i6.n
    public void j() {
        String string = getString(R.string.email_was_bound_tips);
        i.f(string, "getString(R.string.email_was_bound_tips)");
        new CommTipsDialog(this, string, getString(R.string.input_email_tips), getString(R.string.go_to_log_in), null, null, new d(), null, false, 432, null).show();
    }

    public final g5.c j3() {
        return (g5.c) this.f8325q.getValue();
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // f5.d
    /* renamed from: k3, reason: merged with bridge method [inline-methods] */
    public y S2() {
        y yVar = this.f8323o;
        if (yVar != null) {
            return yVar;
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
            j3().e(this.f8324p);
            ((RecyclerView) Y2(R$id.mRvCompleteList)).setVisibility(0);
            ((MaxHeightLinearLayout) Y2(R$id.mLlRecyEmail)).setVisibility(0);
            return;
        }
        String lowerCase = str.toLowerCase();
        i.f(lowerCase, "this as java.lang.String).toLowerCase()");
        String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, null).toArray(new String[0]);
        String str2 = '@' + strArr[1];
        int size = this.f8324p.size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = this.f8324p.get(i10);
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

    public void n3(y yVar) {
        i.g(yVar, "<set-?>");
        this.f8323o = yVar;
    }

    public final void o3() {
        long currentTimeMillis = 180 - ((System.currentTimeMillis() - k.f8726a.b("key_verifycode_bind_time")) / 1000);
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
        ((TextView) Y2(R$id.mTvNext)).setEnabled(this.f8320l && this.f8321m);
    }

    @Override // i6.n
    public void showLoading(boolean z10) {
        if (this.f8322n == null) {
            this.f8322n = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new DialogInterface.OnDismissListener() { // from class: e6.y
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    EmailAty.q3(EmailAty.this, dialogInterface);
                }
            }, 6, null);
            t tVar = t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f8322n;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f8322n;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
