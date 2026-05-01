package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.PhoneAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i0;
import com.mobile.brasiltv.utils.z0;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.bt;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import i6.e0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.n1;
import na.f;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class PhoneAty extends d implements e0 {

    /* renamed from: l, reason: collision with root package name */
    public boolean f7971l;

    /* renamed from: t, reason: collision with root package name */
    public n1 f7979t;

    /* renamed from: u, reason: collision with root package name */
    public Map f7980u = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name */
    public Handler f7972m = new Handler();

    /* renamed from: n, reason: collision with root package name */
    public int f7973n = 180;

    /* renamed from: o, reason: collision with root package name */
    public String f7974o = "Brazil";

    /* renamed from: p, reason: collision with root package name */
    public String f7975p = "55";

    /* renamed from: q, reason: collision with root package name */
    public String f7976q = "1";

    /* renamed from: r, reason: collision with root package name */
    public Runnable f7977r = new b();

    /* renamed from: s, reason: collision with root package name */
    public Runnable f7978s = new Runnable() { // from class: f5.m2
        @Override // java.lang.Runnable
        public final void run() {
            PhoneAty.j3(PhoneAty.this);
        }
    };

    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            i0 i0Var = i0.f8719a;
            EditText editText = (EditText) PhoneAty.this.Y2(R$id.phoneNum);
            i.f(editText, "phoneNum");
            i0Var.a(editText, this, PhoneAty.this.f7974o);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhoneAty phoneAty = PhoneAty.this;
            int i10 = R$id.sendMsgBt;
            ((CheckBox) phoneAty.Y2(i10)).setText(PhoneAty.this.getResources().getString(R.string.retrive_super) + ' ' + PhoneAty.this.f7973n + 's');
            PhoneAty phoneAty2 = PhoneAty.this;
            phoneAty2.f7973n = phoneAty2.f7973n - 1;
            if (PhoneAty.this.f7973n != 0) {
                PhoneAty.this.f7972m.postDelayed(this, 1000L);
                return;
            }
            PhoneAty.this.f7972m.removeCallbacks(this);
            ((CheckBox) PhoneAty.this.Y2(i10)).setChecked(false);
            ((CheckBox) PhoneAty.this.Y2(i10)).setEnabled(true);
            ((CheckBox) PhoneAty.this.Y2(i10)).setText(PhoneAty.this.getResources().getString(R.string.sending));
            PhoneAty.this.f7973n = 180;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7984b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.f7984b = str;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("user_area_code", PhoneAty.this.f7975p);
            intent.putExtra("user_verfication", t.W(((EditText) PhoneAty.this.Y2(R$id.verificationEdit)).getText().toString()).toString());
            Intent putExtra = intent.putExtra("user_phone", this.f7984b);
            i.f(putExtra, "intent.putExtra(Constant.USER_PHONE, phoneNumber)");
            return putExtra;
        }
    }

    public static final void e3(PhoneAty phoneAty, View view) {
        i.g(phoneAty, "this$0");
        b0.e0(phoneAty, SelectNationAty.class, 1002);
    }

    public static final void f3(PhoneAty phoneAty, CompoundButton compoundButton, boolean z10) {
        i.g(phoneAty, "this$0");
        if (!z10) {
            int i10 = R$id.sendMsgBt;
            ((CheckBox) phoneAty.Y2(i10)).setTextColor(phoneAty.getResources().getColor(R.color.color_important));
            ((CheckBox) phoneAty.Y2(i10)).setEnabled(true);
            return;
        }
        int i11 = R$id.phoneNum;
        if (TextUtils.isEmpty(t.W(((EditText) phoneAty.Y2(i11)).getText().toString()).toString())) {
            ((CheckBox) phoneAty.Y2(R$id.sendMsgBt)).setChecked(false);
            int i12 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i12)).setText(phoneAty.getResources().getString(R.string.empty_phone));
            ((TextView) phoneAty.Y2(i12)).setVisibility(0);
            phoneAty.h3();
            return;
        }
        i0 i0Var = i0.f8719a;
        EditText editText = (EditText) phoneAty.Y2(i11);
        i.f(editText, "phoneNum");
        String b10 = i0Var.b(editText, phoneAty.f7974o);
        if (!TextUtils.isEmpty(b10) && z0.a(b10, phoneAty.f7974o)) {
            ((CheckBox) phoneAty.Y2(R$id.sendMsgBt)).setEnabled(false);
            phoneAty.S2().l(b10, phoneAty.f7975p, phoneAty.f7976q);
            return;
        }
        ((CheckBox) phoneAty.Y2(R$id.sendMsgBt)).setChecked(false);
        int i13 = R$id.errorTx;
        ((TextView) phoneAty.Y2(i13)).setText(phoneAty.getResources().getString(R.string.invalid_phone_number));
        ((TextView) phoneAty.Y2(i13)).setVisibility(0);
        phoneAty.h3();
    }

    public static final void g3(PhoneAty phoneAty, View view) {
        i.g(phoneAty, "this$0");
        phoneAty.h3();
        i0 i0Var = i0.f8719a;
        int i10 = R$id.phoneNum;
        EditText editText = (EditText) phoneAty.Y2(i10);
        i.f(editText, "phoneNum");
        String b10 = i0Var.b(editText, phoneAty.f7974o);
        if (TextUtils.isEmpty(t.W(((EditText) phoneAty.Y2(i10)).getText().toString()).toString())) {
            int i11 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i11)).setVisibility(0);
            ((TextView) phoneAty.Y2(i11)).setText(phoneAty.getResources().getString(R.string.empty_phone));
            return;
        }
        int i12 = R$id.verificationEdit;
        if (TextUtils.isEmpty(t.W(((EditText) phoneAty.Y2(i12)).getText().toString()).toString())) {
            int i13 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i13)).setVisibility(0);
            ((TextView) phoneAty.Y2(i13)).setText(phoneAty.getResources().getString(R.string.empty_verification_code));
        } else if (t.W(((EditText) phoneAty.Y2(i12)).getText().toString()).toString().length() != 6) {
            int i14 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i14)).setVisibility(0);
            ((TextView) phoneAty.Y2(i14)).setText(phoneAty.getResources().getString(R.string.verification_invalid));
        } else if (!TextUtils.isEmpty(b10) && z0.a(b10, phoneAty.f7974o)) {
            phoneAty.k3();
            phoneAty.S2().i(b10, phoneAty.f7975p, t.W(((EditText) phoneAty.Y2(i12)).getText().toString()).toString(), "1");
        } else {
            int i15 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i15)).setVisibility(0);
            ((TextView) phoneAty.Y2(i15)).setText(phoneAty.getResources().getString(R.string.invalid_phone_number));
        }
    }

    public static final void j3(PhoneAty phoneAty) {
        i.g(phoneAty, "this$0");
        TextView textView = (TextView) phoneAty.Y2(R$id.errorTx);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // i6.e0
    public void H() {
        b0.c0(this, PhoneBindSuccessAty.class);
        finish();
    }

    @Override // i6.e0
    public void P() {
        ((CheckBox) Y2(R$id.sendMsgBt)).setTextColor(getResources().getColor(R.color.color_f7bd46));
        this.f7972m.post(this.f7977r);
    }

    @Override // f5.d
    public void R2() {
        l3(new n1(this, this));
        ((AutoRelativeLayout) Y2(R$id.chooseCountry)).setOnClickListener(new View.OnClickListener() { // from class: f5.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneAty.e3(PhoneAty.this, view);
            }
        });
        int i10 = R$id.sendMsgBt;
        ((CheckBox) Y2(i10)).setEnabled(true);
        ((CheckBox) Y2(i10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: f5.o2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                PhoneAty.f3(PhoneAty.this, compoundButton, z10);
            }
        });
        ((EditText) Y2(R$id.phoneNum)).addTextChangedListener(new a());
        int i11 = R$id.title_view;
        ((TitleView) Y2(i11)).setTitle(getResources().getString(R.string.phone_binding));
        ((TitleView) Y2(i11)).setXVisible(8);
        ((TextView) Y2(R$id.mTextLogOther)).setOnClickListener(new View.OnClickListener() { // from class: f5.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneAty.g3(PhoneAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_phone;
    }

    @Override // i6.e0
    public void X0() {
        i0 i0Var = i0.f8719a;
        EditText editText = (EditText) Y2(R$id.phoneNum);
        i.f(editText, "phoneNum");
        String b10 = i0Var.b(editText, this.f7974o);
        if (i.b(w6.i.f19214g.s(), "1")) {
            S2().h(b10, this.f7975p, t.W(((EditText) Y2(R$id.verificationEdit)).getText().toString()).toString(), null);
        } else {
            b0.d0(this, SetPassWordAty.class, new c(b10));
            finish();
        }
    }

    public View Y2(int i10) {
        Map map = this.f7980u;
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

    public final void h3() {
        k3();
        this.f7972m.postDelayed(this.f7978s, 5000L);
    }

    @Override // i6.e0
    public void i2() {
        int i10 = R$id.sendMsgBt;
        ((CheckBox) Y2(i10)).setChecked(false);
        ((CheckBox) Y2(i10)).setEnabled(true);
    }

    @Override // f5.d
    /* renamed from: i3, reason: merged with bridge method [inline-methods] */
    public n1 S2() {
        n1 n1Var = this.f7979t;
        if (n1Var != null) {
            return n1Var;
        }
        i.w("mPresenter");
        return null;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k3() {
        this.f7972m.removeCallbacks(this.f7978s);
    }

    public void l3(n1 n1Var) {
        i.g(n1Var, "<set-?>");
        this.f7979t = n1Var;
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        try {
            if (i11 == SelectNationAty.f8104p.a() && i10 == 1002) {
                String stringExtra = intent != null ? intent.getStringExtra("register_nation") : null;
                if (stringExtra == null) {
                    stringExtra = "";
                }
                this.f7974o = stringExtra;
                String stringExtra2 = intent != null ? intent.getStringExtra("register_code") : null;
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                this.f7975p = stringExtra2;
                f.k(this, "login_area_code", stringExtra2);
                ((TextView) Y2(R$id.countryName)).setText(this.f7974o);
                ((TextView) Y2(R$id.areNum)).setText('+' + this.f7975p);
                ((EditText) Y2(R$id.phoneNum)).setText("");
                this.f7971l = true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f7972m.removeCallbacks(this.f7977r);
        this.f7972m.removeCallbacks(this.f7978s);
    }

    @Override // i6.e0
    public void showLoading(boolean z10) {
    }

    @Override // i6.e0
    public void v(String str, String str2) {
        i.g(str, "areaCode");
        i.g(str2, bt.O);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f7971l || !TextUtils.isEmpty(t.W(((EditText) Y2(R$id.phoneNum)).getText().toString()).toString())) {
            return;
        }
        this.f7975p = str;
        this.f7974o = str2;
        ((TextView) Y2(R$id.countryName)).setText(this.f7974o);
        ((TextView) Y2(R$id.areNum)).setText('+' + this.f7975p);
    }
}
