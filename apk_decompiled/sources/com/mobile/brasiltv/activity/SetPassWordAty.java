package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ba.s;
import ba.t;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SetPassWordAty;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import i6.s0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.v3;
import ma.m;
import t9.i;
import xa.c;

/* loaded from: classes3.dex */
public final class SetPassWordAty extends d implements s0 {

    /* renamed from: l, reason: collision with root package name */
    public Boolean f8122l;

    /* renamed from: m, reason: collision with root package name */
    public String f8123m;

    /* renamed from: n, reason: collision with root package name */
    public String f8124n;

    /* renamed from: o, reason: collision with root package name */
    public String f8125o;

    /* renamed from: p, reason: collision with root package name */
    public String f8126p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8127q;

    /* renamed from: r, reason: collision with root package name */
    public v3 f8128r;

    /* renamed from: s, reason: collision with root package name */
    public Map f8129s = new LinkedHashMap();

    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) SetPassWordAty.this.X2(R$id.confirmBt);
            SetPassWordAty setPassWordAty = SetPassWordAty.this;
            EditText editText = (EditText) setPassWordAty.X2(R$id.pwdFirst);
            i.f(editText, "pwdFirst");
            if (!setPassWordAty.e3(editText)) {
                SetPassWordAty setPassWordAty2 = SetPassWordAty.this;
                EditText editText2 = (EditText) setPassWordAty2.X2(R$id.pwdSecond);
                i.f(editText2, "pwdSecond");
                if (!setPassWordAty2.e3(editText2)) {
                    z10 = true;
                    textView.setEnabled(z10);
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) SetPassWordAty.this.X2(R$id.confirmBt);
            SetPassWordAty setPassWordAty = SetPassWordAty.this;
            EditText editText = (EditText) setPassWordAty.X2(R$id.pwdFirst);
            i.f(editText, "pwdFirst");
            if (!setPassWordAty.e3(editText)) {
                SetPassWordAty setPassWordAty2 = SetPassWordAty.this;
                EditText editText2 = (EditText) setPassWordAty2.X2(R$id.pwdSecond);
                i.f(editText2, "pwdSecond");
                if (!setPassWordAty2.e3(editText2)) {
                    z10 = true;
                    textView.setEnabled(z10);
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final void a3(SetPassWordAty setPassWordAty, View view) {
        i.g(setPassWordAty, "this$0");
        setPassWordAty.finish();
    }

    public static final void b3(SetPassWordAty setPassWordAty, View view) {
        i.g(setPassWordAty, "this$0");
        setPassWordAty.Z2();
    }

    public static final void c3(SetPassWordAty setPassWordAty, View view) {
        i.g(setPassWordAty, "this$0");
        String obj = t.W(((EditText) setPassWordAty.X2(R$id.pwdFirst)).getText().toString()).toString();
        String obj2 = t.W(((EditText) setPassWordAty.X2(R$id.pwdSecond)).getText().toString()).toString();
        if (!j1.g(obj)) {
            int i10 = R$id.mTextErrorNotify;
            ((TextView) setPassWordAty.X2(i10)).setVisibility(0);
            ((TextView) setPassWordAty.X2(i10)).setText(setPassWordAty.getResources().getString(R.string.password_format_error_tips));
            return;
        }
        if (!j1.g(obj2)) {
            int i11 = R$id.mTextErrorNotify;
            ((TextView) setPassWordAty.X2(i11)).setVisibility(0);
            ((TextView) setPassWordAty.X2(i11)).setText(setPassWordAty.getResources().getString(R.string.password_error_tips));
            return;
        }
        if (!i.b(obj, obj2)) {
            int i12 = R$id.mTextErrorNotify;
            ((TextView) setPassWordAty.X2(i12)).setVisibility(0);
            ((TextView) setPassWordAty.X2(i12)).setText(setPassWordAty.getResources().getString(R.string.not_match_password));
            return;
        }
        ((TextView) setPassWordAty.X2(R$id.mTextErrorNotify)).setVisibility(8);
        if (setPassWordAty.f8127q) {
            v3 S2 = setPassWordAty.S2();
            String str = setPassWordAty.f8123m;
            String str2 = str == null ? "" : str;
            String str3 = setPassWordAty.f8124n;
            String str4 = str3 == null ? "" : str3;
            String str5 = setPassWordAty.f8125o;
            String str6 = str5 == null ? "" : str5;
            String e10 = m.e(obj);
            i.f(e10, "md5(firstPassword)");
            S2.m(str2, str4, str6, "3", e10);
            return;
        }
        v3 S22 = setPassWordAty.S2();
        String str7 = setPassWordAty.f8123m;
        if (str7 == null) {
            str7 = "";
        }
        String str8 = setPassWordAty.f8124n;
        if (str8 == null) {
            str8 = "";
        }
        String str9 = setPassWordAty.f8125o;
        String str10 = str9 != null ? str9 : "";
        String e11 = m.e(obj);
        i.f(e11, "md5(firstPassword)");
        S22.i(str7, str8, str10, e11);
    }

    @Override // i6.s0
    public void H() {
        String str = this.f8126p;
        if (str == null || TextUtils.isEmpty(str) || !s.g(this.f8126p, "ResetAty", false, 2, null)) {
            b0.c0(this, PhoneBindSuccessAty.class);
            finish();
            return;
        }
        ((AutoRelativeLayout) X2(R$id.resetPwdSuccess)).setVisibility(0);
        ((AutoLinearLayout) X2(R$id.resetPwd)).setVisibility(8);
        int i10 = R$id.mTitleView;
        ((TitleView) X2(i10)).setTitle(getResources().getString(R.string.reset_successful));
        ((TitleView) X2(i10)).setXVisible(0);
        b0.F(this);
    }

    @Override // f5.d
    public void R2() {
        int i10 = R$id.confirmBt;
        ((TextView) X2(i10)).setEnabled(false);
        f3(new v3(this, this));
        int i11 = R$id.mTitleView;
        ((TitleView) X2(i11)).setTitle(getResources().getString(R.string.set_pwd));
        ((TitleView) X2(i11)).setXVisible(8);
        this.f8127q = getIntent().getBooleanExtra("is_forget_pwd", false);
        String stringExtra = getIntent().getStringExtra("set_pwd_from");
        this.f8126p = stringExtra;
        if (stringExtra == null) {
            this.f8126p = "";
        }
        String stringExtra2 = getIntent().getStringExtra("user_phone");
        this.f8123m = stringExtra2;
        if (stringExtra2 == null) {
            this.f8123m = "";
        }
        String stringExtra3 = getIntent().getStringExtra("user_area_code");
        this.f8124n = stringExtra3;
        if (stringExtra3 == null) {
            this.f8124n = "";
        }
        String stringExtra4 = getIntent().getStringExtra("user_verfication");
        this.f8125o = stringExtra4;
        if (stringExtra4 == null) {
            this.f8125o = "";
        }
        ((TitleView) X2(i11)).setXClickListener(new View.OnClickListener() { // from class: f5.j4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPassWordAty.a3(SetPassWordAty.this, view);
            }
        });
        ((TitleView) X2(i11)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.k4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPassWordAty.b3(SetPassWordAty.this, view);
            }
        });
        ((TextView) X2(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.l4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPassWordAty.c3(SetPassWordAty.this, view);
            }
        });
        ((EditText) X2(R$id.pwdFirst)).addTextChangedListener(new a());
        ((EditText) X2(R$id.pwdSecond)).addTextChangedListener(new b());
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_setpassword;
    }

    public View X2(int i10) {
        Map map = this.f8129s;
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

    public final void Z2() {
        Boolean bool = this.f8122l;
        if (i.b(bool, Boolean.TRUE)) {
            b0.c0(this, MainAty.class);
        } else if (!i.b(bool, Boolean.FALSE)) {
            finish();
        } else {
            b0.c0(this, LoginAty.class);
            finish();
        }
    }

    @Override // f5.d
    /* renamed from: d3, reason: merged with bridge method [inline-methods] */
    public v3 S2() {
        v3 v3Var = this.f8128r;
        if (v3Var != null) {
            return v3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final boolean e3(EditText editText) {
        String obj = t.W(editText.getText().toString()).toString();
        return obj == null || obj.length() == 0;
    }

    public void f3(v3 v3Var) {
        i.g(v3Var, "<set-?>");
        this.f8128r = v3Var;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.s0
    public void o(String str) {
        i.g(str, Constant.KEY_MSG);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Z2();
    }

    @Override // i6.s0
    public void showLoading(boolean z10) {
    }

    @Override // i6.s0
    public void w0(boolean z10) {
        c.c().j(new ClosePageEvent());
        ((AutoRelativeLayout) X2(R$id.resetPwdSuccess)).setVisibility(0);
        ((AutoLinearLayout) X2(R$id.resetPwd)).setVisibility(8);
        int i10 = R$id.mTitleView;
        ((TitleView) X2(i10)).setTitle(getResources().getString(R.string.reset_successful));
        ((TitleView) X2(i10)).setXVisible(8);
        this.f8122l = Boolean.valueOf(z10);
        b0.F(this);
    }

    @Override // i6.s0
    public void x() {
        c.c().j(new ClosePageEvent());
        finish();
    }
}
