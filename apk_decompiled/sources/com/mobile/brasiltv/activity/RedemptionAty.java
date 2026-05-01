package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.RedemptionAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.dialog.ExchangeFailedDialog;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import f5.d;
import i6.j0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.q2;
import mobile.com.requestframe.utils.response.ExchangeData;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class RedemptionAty extends d implements j0 {

    /* renamed from: l, reason: collision with root package name */
    public ExchangeFailedDialog f8032l;

    /* renamed from: m, reason: collision with root package name */
    public q2 f8033m;

    /* renamed from: n, reason: collision with root package name */
    public Map f8034n = new LinkedHashMap();

    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            q2 S2 = RedemptionAty.this.S2();
            RedemptionAty redemptionAty = RedemptionAty.this;
            int i10 = R$id.mEtExchangeCode;
            EditText editText = (EditText) redemptionAty.X2(i10);
            i.f(editText, "mEtExchangeCode");
            S2.n(editText, this);
            ((EditText) RedemptionAty.this.X2(i10)).setSelection(((EditText) RedemptionAty.this.X2(i10)).getText().length());
            Editable text = ((EditText) RedemptionAty.this.X2(i10)).getText();
            i.f(text, "mEtExchangeCode.text");
            if (text.length() > 0) {
                ((ImageButton) RedemptionAty.this.X2(R$id.mIbClear)).setVisibility(0);
            } else {
                ((ImageButton) RedemptionAty.this.X2(R$id.mIbClear)).setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class b extends j implements l {
        public b() {
            super(1);
        }

        public final void b(View view) {
            String str;
            String obj;
            i.g(view, "it");
            RedemptionAty.this.d3();
            q2 S2 = RedemptionAty.this.S2();
            Editable text = ((EditText) RedemptionAty.this.X2(R$id.mEtExchangeCode)).getText();
            if (text == null || (obj = text.toString()) == null || (str = t.W(obj).toString()) == null) {
                str = "";
            }
            S2.k(str);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((View) obj);
            return h9.t.f14242a;
        }
    }

    public static final void Z2(RedemptionAty redemptionAty, View view, boolean z10) {
        i.g(redemptionAty, "this$0");
        if (z10) {
            ((TextView) redemptionAty.X2(R$id.mTvRedemptionHint)).setVisibility(8);
        }
    }

    public static final boolean a3(RedemptionAty redemptionAty, View view, int i10, KeyEvent keyEvent) {
        i.g(redemptionAty, "this$0");
        if (i10 == 67) {
            int i11 = R$id.mEtExchangeCode;
            Editable text = ((EditText) redemptionAty.X2(i11)).getText();
            i.f(text, "mEtExchangeCode.text");
            if (t.q(text, Operator.Operation.MINUS, false, 2, null) && ((EditText) redemptionAty.X2(i11)).length() > 1) {
                Editable text2 = ((EditText) redemptionAty.X2(i11)).getText();
                i.f(text2, "mEtExchangeCode.text");
                ((EditText) redemptionAty.X2(i11)).setText(text2.subSequence(0, ((EditText) redemptionAty.X2(i11)).length() - 2).toString());
                return true;
            }
        }
        return false;
    }

    public static final void b3(RedemptionAty redemptionAty, View view) {
        i.g(redemptionAty, "this$0");
        ((EditText) redemptionAty.X2(R$id.mEtExchangeCode)).setText("");
        ((TextView) redemptionAty.X2(R$id.mTvRedemptionHint)).setVisibility(8);
    }

    @Override // f5.c
    public void N2() {
        super.N2();
        S2().j();
    }

    @Override // f5.d
    public void R2() {
        e3(new q2(this, this));
        ((TitleView) X2(R$id.titleView)).getTvMenuView().setVisibility(8);
        int i10 = R$id.mEtExchangeCode;
        ((EditText) X2(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: f5.e3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                RedemptionAty.Z2(RedemptionAty.this, view, z10);
            }
        });
        ((EditText) X2(i10)).addTextChangedListener(new a());
        ((EditText) X2(i10)).setOnKeyListener(new View.OnKeyListener() { // from class: f5.f3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                boolean a32;
                a32 = RedemptionAty.a3(RedemptionAty.this, view, i11, keyEvent);
                return a32;
            }
        });
        KoocanButton koocanButton = (KoocanButton) X2(R$id.mKbConfirm);
        i.f(koocanButton, "mKbConfirm");
        b0.f(koocanButton, new b(), 500L);
        ((ImageButton) X2(R$id.mIbClear)).setOnClickListener(new View.OnClickListener() { // from class: f5.g3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedemptionAty.b3(RedemptionAty.this, view);
            }
        });
    }

    @Override // i6.j0
    public void S1() {
        int i10 = R$id.mTvRedemptionHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_important));
        ((TextView) X2(i10)).setText(getResources().getString(R.string.redemption_success));
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_redemption;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // i6.j0
    public void W(String str, ExchangeData exchangeData, String str2) {
        String assAuthDays;
        String assAuthDays2;
        String assAuthDays3;
        i.g(str, "errorCode");
        i.g(str2, "redeemCode");
        int i10 = R$id.mTvRedemptionHint;
        ((TextView) X2(i10)).setVisibility(8);
        if (exchangeData != null) {
            this.f8032l = new ExchangeFailedDialog(this);
        }
        int hashCode = str.hashCode();
        if (hashCode != 1444) {
            String str3 = "";
            switch (hashCode) {
                case 268950164:
                    if (str.equals("aaa40001")) {
                        ExchangeFailedDialog exchangeFailedDialog = this.f8032l;
                        if (exchangeFailedDialog != null) {
                            exchangeFailedDialog.setRedeemCode(str2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog2 = this.f8032l;
                        if (exchangeFailedDialog2 != null) {
                            String string = getResources().getString(R.string.exchange_status_expired);
                            i.f(string, "resources.getString(R.st….exchange_status_expired)");
                            exchangeFailedDialog2.setStatus(string);
                        }
                        ExchangeFailedDialog exchangeFailedDialog3 = this.f8032l;
                        if (exchangeFailedDialog3 != null) {
                            String e10 = y6.b.e(exchangeData != null ? exchangeData.getCodeInvalidTime() : null, "yyyy-MM-dd HH:mm:SS", "dd/MM/yyyy");
                            i.f(e10, "utc2LocalStr(errorData?.… HH:mm:SS\", \"dd/MM/yyyy\")");
                            exchangeFailedDialog3.setValidUntil(e10);
                        }
                        ExchangeFailedDialog exchangeFailedDialog4 = this.f8032l;
                        if (exchangeFailedDialog4 != null) {
                            exchangeFailedDialog4.show();
                            return;
                        }
                        return;
                    }
                    break;
                case 268950165:
                    if (str.equals("aaa40002")) {
                        ExchangeFailedDialog exchangeFailedDialog5 = this.f8032l;
                        if (exchangeFailedDialog5 != null) {
                            exchangeFailedDialog5.setRedeemCode(str2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog6 = this.f8032l;
                        if (exchangeFailedDialog6 != null) {
                            String string2 = getResources().getString(R.string.exchange_status_used);
                            i.f(string2, "resources.getString(R.string.exchange_status_used)");
                            exchangeFailedDialog6.setStatus(string2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog7 = this.f8032l;
                        if (exchangeFailedDialog7 != null) {
                            String e11 = y6.b.e(exchangeData != null ? exchangeData.getExchangeDate() : null, "yyyy-MM-dd HH:mm:SS", "dd/MM/yyyy HH:mm");
                            i.f(e11, "utc2LocalStr(errorData?.…:SS\", \"dd/MM/yyyy HH:mm\")");
                            exchangeFailedDialog7.setTimeOfUsed(e11);
                        }
                        ExchangeFailedDialog exchangeFailedDialog8 = this.f8032l;
                        if (exchangeFailedDialog8 != null) {
                            String string3 = getResources().getString(R.string.exchange_tips_contact_reseller);
                            i.f(string3, "resources.getString(R.st…ge_tips_contact_reseller)");
                            exchangeFailedDialog8.setErrorHint(string3);
                        }
                        ExchangeFailedDialog exchangeFailedDialog9 = this.f8032l;
                        if (exchangeFailedDialog9 != null) {
                            exchangeFailedDialog9.show();
                            return;
                        }
                        return;
                    }
                    break;
                case 268950166:
                    if (str.equals("aaa40003")) {
                        ExchangeFailedDialog exchangeFailedDialog10 = this.f8032l;
                        if (exchangeFailedDialog10 != null) {
                            exchangeFailedDialog10.setRedeemCode(str2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog11 = this.f8032l;
                        if (exchangeFailedDialog11 != null) {
                            String string4 = getResources().getString(R.string.exchange_status_invalid);
                            i.f(string4, "resources.getString(R.st….exchange_status_invalid)");
                            exchangeFailedDialog11.setStatus(string4);
                        }
                        ExchangeFailedDialog exchangeFailedDialog12 = this.f8032l;
                        if (exchangeFailedDialog12 != null) {
                            String string5 = getResources().getString(R.string.exchange_tips_for_invalid);
                            i.f(string5, "resources.getString(R.st…xchange_tips_for_invalid)");
                            exchangeFailedDialog12.setErrorHint(string5);
                        }
                        ExchangeFailedDialog exchangeFailedDialog13 = this.f8032l;
                        if (exchangeFailedDialog13 != null) {
                            exchangeFailedDialog13.show();
                            return;
                        }
                        return;
                    }
                    break;
                case 268950167:
                    if (str.equals("aaa40004")) {
                        ExchangeFailedDialog exchangeFailedDialog14 = this.f8032l;
                        if (exchangeFailedDialog14 != null) {
                            exchangeFailedDialog14.setRedeemCode(str2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog15 = this.f8032l;
                        if (exchangeFailedDialog15 != null) {
                            String string6 = getResources().getString(R.string.exchange_status_unused);
                            i.f(string6, "resources.getString(R.st…g.exchange_status_unused)");
                            exchangeFailedDialog15.setStatus(string6);
                        }
                        ExchangeFailedDialog exchangeFailedDialog16 = this.f8032l;
                        if (exchangeFailedDialog16 != null) {
                            String e12 = y6.b.e(exchangeData != null ? exchangeData.getCodeInvalidTime() : null, "yyyy-MM-dd HH:mm:SS", "dd/MM/yyyy");
                            i.f(e12, "utc2LocalStr(errorData?.… HH:mm:SS\", \"dd/MM/yyyy\")");
                            exchangeFailedDialog16.setValidUntil(e12);
                        }
                        ExchangeFailedDialog exchangeFailedDialog17 = this.f8032l;
                        if (exchangeFailedDialog17 != null) {
                            if (exchangeData != null && (assAuthDays = exchangeData.getAssAuthDays()) != null) {
                                str3 = assAuthDays;
                            }
                            exchangeFailedDialog17.setServiceDays(str3);
                        }
                        ExchangeFailedDialog exchangeFailedDialog18 = this.f8032l;
                        if (exchangeFailedDialog18 != null) {
                            String string7 = getResources().getString(R.string.exchange_tips_for_vip);
                            i.f(string7, "resources.getString(R.st…ng.exchange_tips_for_vip)");
                            exchangeFailedDialog18.setErrorHint(string7);
                        }
                        ExchangeFailedDialog exchangeFailedDialog19 = this.f8032l;
                        if (exchangeFailedDialog19 != null) {
                            exchangeFailedDialog19.show();
                            return;
                        }
                        return;
                    }
                    break;
                case 268950168:
                    if (str.equals("aaa40005")) {
                        ExchangeFailedDialog exchangeFailedDialog20 = this.f8032l;
                        if (exchangeFailedDialog20 != null) {
                            exchangeFailedDialog20.setRedeemCode(str2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog21 = this.f8032l;
                        if (exchangeFailedDialog21 != null) {
                            String string8 = getResources().getString(R.string.exchange_status_unused);
                            i.f(string8, "resources.getString(R.st…g.exchange_status_unused)");
                            exchangeFailedDialog21.setStatus(string8);
                        }
                        ExchangeFailedDialog exchangeFailedDialog22 = this.f8032l;
                        if (exchangeFailedDialog22 != null) {
                            String e13 = y6.b.e(exchangeData != null ? exchangeData.getCodeInvalidTime() : null, "yyyy-MM-dd HH:mm:SS", "dd/MM/yyyy");
                            i.f(e13, "utc2LocalStr(errorData?.… HH:mm:SS\", \"dd/MM/yyyy\")");
                            exchangeFailedDialog22.setValidUntil(e13);
                        }
                        ExchangeFailedDialog exchangeFailedDialog23 = this.f8032l;
                        if (exchangeFailedDialog23 != null) {
                            if (exchangeData != null && (assAuthDays2 = exchangeData.getAssAuthDays()) != null) {
                                str3 = assAuthDays2;
                            }
                            exchangeFailedDialog23.setServiceDays(str3);
                        }
                        ExchangeFailedDialog exchangeFailedDialog24 = this.f8032l;
                        if (exchangeFailedDialog24 != null) {
                            String string9 = getResources().getString(R.string.exchange_tips_for_tv);
                            i.f(string9, "resources.getString(R.string.exchange_tips_for_tv)");
                            exchangeFailedDialog24.setErrorHint(string9);
                        }
                        ExchangeFailedDialog exchangeFailedDialog25 = this.f8032l;
                        if (exchangeFailedDialog25 != null) {
                            exchangeFailedDialog25.show();
                            return;
                        }
                        return;
                    }
                    break;
                case 268950169:
                    if (str.equals("aaa40006")) {
                        ExchangeFailedDialog exchangeFailedDialog26 = this.f8032l;
                        if (exchangeFailedDialog26 != null) {
                            exchangeFailedDialog26.setRedeemCode(str2);
                        }
                        ExchangeFailedDialog exchangeFailedDialog27 = this.f8032l;
                        if (exchangeFailedDialog27 != null) {
                            String string10 = getResources().getString(R.string.exchange_status_unused);
                            i.f(string10, "resources.getString(R.st…g.exchange_status_unused)");
                            exchangeFailedDialog27.setStatus(string10);
                        }
                        ExchangeFailedDialog exchangeFailedDialog28 = this.f8032l;
                        if (exchangeFailedDialog28 != null) {
                            String e14 = y6.b.e(exchangeData != null ? exchangeData.getCodeInvalidTime() : null, "yyyy-MM-dd HH:mm:SS", "dd/MM/yyyy");
                            i.f(e14, "utc2LocalStr(errorData?.… HH:mm:SS\", \"dd/MM/yyyy\")");
                            exchangeFailedDialog28.setValidUntil(e14);
                        }
                        ExchangeFailedDialog exchangeFailedDialog29 = this.f8032l;
                        if (exchangeFailedDialog29 != null) {
                            if (exchangeData != null && (assAuthDays3 = exchangeData.getAssAuthDays()) != null) {
                                str3 = assAuthDays3;
                            }
                            exchangeFailedDialog29.setServiceDays(str3);
                        }
                        ExchangeFailedDialog exchangeFailedDialog30 = this.f8032l;
                        if (exchangeFailedDialog30 != null) {
                            String string11 = getResources().getString(R.string.exchange_tips_for_special_offers);
                            i.f(string11, "resources.getString(R.st…_tips_for_special_offers)");
                            exchangeFailedDialog30.setErrorHint(string11);
                        }
                        ExchangeFailedDialog exchangeFailedDialog31 = this.f8032l;
                        if (exchangeFailedDialog31 != null) {
                            exchangeFailedDialog31.show();
                            return;
                        }
                        return;
                    }
                    break;
            }
        } else if (str.equals("-1")) {
            ((TextView) X2(i10)).setVisibility(0);
            ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_f23232));
            ((TextView) X2(i10)).setText(getResources().getString(R.string.redemption_network_error));
            return;
        }
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) X2(i10)).setText(getResources().getString(R.string.redemption_network_error));
    }

    public View X2(int i10) {
        Map map = this.f8034n;
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
    /* renamed from: c3, reason: merged with bridge method [inline-methods] */
    public q2 S2() {
        q2 q2Var = this.f8033m;
        if (q2Var != null) {
            return q2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void d3() {
        int i10 = R$id.mEtExchangeCode;
        ViewParent parent = ((EditText) X2(i10)).getParent();
        i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setFocusableInTouchMode(true);
        ((EditText) X2(i10)).clearFocus();
        b0.F(this);
    }

    public void e3(q2 q2Var) {
        i.g(q2Var, "<set-?>");
        this.f8033m = q2Var;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.j0
    public void o2(int i10) {
        int i11 = R$id.mTvRedemptionHint;
        ((TextView) X2(i11)).setVisibility(0);
        ((TextView) X2(i11)).setTextColor(getResources().getColor(R.color.color_f23232));
        ((TextView) X2(i11)).setText(getResources().getString(i10));
    }

    @Override // i6.j0
    public void showLoading(boolean z10) {
        O2(z10);
    }
}
