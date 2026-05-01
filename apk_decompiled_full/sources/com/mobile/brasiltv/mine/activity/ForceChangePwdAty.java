package com.mobile.brasiltv.mine.activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import b6.z;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.m;
import mobile.com.requestframe.utils.response.UpdatePwdResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

/* loaded from: classes.dex */
public final class ForceChangePwdAty extends f5.c implements s5.b {

    /* renamed from: l, reason: collision with root package name */
    public s5.d f8336l;

    /* renamed from: m, reason: collision with root package name */
    public long f8337m;

    /* renamed from: n, reason: collision with root package name */
    public Map f8338n = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public final s5.a f8335k = new s5.a();

    /* loaded from: classes3.dex */
    public static final class a extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8339a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
            Intent putExtra = intent.putExtra("is_force", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_FORCE,true)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8340a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 1);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
            Intent putExtra = intent.putExtra("is_force", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_FORCE,true)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f8341a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", true);
            Intent putExtra = intent.putExtra("is_force", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_FORCE,true)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) ForceChangePwdAty.this.U2(R$id.mTextConfirm);
            ForceChangePwdAty forceChangePwdAty = ForceChangePwdAty.this;
            EditText editText = (EditText) forceChangePwdAty.U2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!forceChangePwdAty.d3(editText)) {
                ForceChangePwdAty forceChangePwdAty2 = ForceChangePwdAty.this;
                EditText editText2 = (EditText) forceChangePwdAty2.U2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!forceChangePwdAty2.d3(editText2)) {
                    ForceChangePwdAty forceChangePwdAty3 = ForceChangePwdAty.this;
                    EditText editText3 = (EditText) forceChangePwdAty3.U2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!forceChangePwdAty3.d3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
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

    /* loaded from: classes3.dex */
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) ForceChangePwdAty.this.U2(R$id.mTextConfirm);
            ForceChangePwdAty forceChangePwdAty = ForceChangePwdAty.this;
            EditText editText = (EditText) forceChangePwdAty.U2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!forceChangePwdAty.d3(editText)) {
                ForceChangePwdAty forceChangePwdAty2 = ForceChangePwdAty.this;
                EditText editText2 = (EditText) forceChangePwdAty2.U2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!forceChangePwdAty2.d3(editText2)) {
                    ForceChangePwdAty forceChangePwdAty3 = ForceChangePwdAty.this;
                    EditText editText3 = (EditText) forceChangePwdAty3.U2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!forceChangePwdAty3.d3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
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

    /* loaded from: classes3.dex */
    public static final class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) ForceChangePwdAty.this.U2(R$id.mTextConfirm);
            ForceChangePwdAty forceChangePwdAty = ForceChangePwdAty.this;
            EditText editText = (EditText) forceChangePwdAty.U2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!forceChangePwdAty.d3(editText)) {
                ForceChangePwdAty forceChangePwdAty2 = ForceChangePwdAty.this;
                EditText editText2 = (EditText) forceChangePwdAty2.U2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!forceChangePwdAty2.d3(editText2)) {
                    ForceChangePwdAty forceChangePwdAty3 = ForceChangePwdAty.this;
                    EditText editText3 = (EditText) forceChangePwdAty3.U2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!forceChangePwdAty3.d3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
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

    /* loaded from: classes3.dex */
    public static final class g extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f8345a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f8347b;

        public h(w wVar) {
            this.f8347b = wVar;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(UpdatePwdResult updatePwdResult) {
            i.g(updatePwdResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            Object obj = this.f8347b.f18961a;
            i.f(obj, "enNewPwd");
            memberInfo.putPassword((String) obj, false);
            ForceChangePwdAty.this.X2();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            ((ProgressBar) ForceChangePwdAty.this.U2(R$id.mLoadingPbar)).setVisibility(8);
            String p10 = y.p(y.f8771a, str, null, null, 6, null);
            if (i.b(str, "aaa100022")) {
                p10 = ForceChangePwdAty.this.getResources().getString(R.string.origin_password_error_tips);
                i.f(p10, "resources.getString(R.st…igin_password_error_tips)");
            }
            f1.a.f(f1.f8649a, ForceChangePwdAty.this, p10, false, 0, 8, null);
        }
    }

    public static final void a3(ForceChangePwdAty forceChangePwdAty, View view) {
        i.g(forceChangePwdAty, "this$0");
        int i10 = R$id.mEditNewPassword;
        if (j1.g(((EditText) forceChangePwdAty.U2(i10)).getText().toString())) {
            int i11 = R$id.mEditPasswordAgain;
            if (!j1.g(((EditText) forceChangePwdAty.U2(i11)).getText().toString())) {
                f1.a aVar = f1.f8649a;
                String string = forceChangePwdAty.getResources().getString(R.string.password_error_tips);
                i.f(string, "this.resources.getString…ring.password_error_tips)");
                f1.a.f(aVar, forceChangePwdAty, string, false, 0, 8, null);
            } else if (i.b(((EditText) forceChangePwdAty.U2(i10)).getText().toString(), ((EditText) forceChangePwdAty.U2(i11)).getText().toString())) {
                forceChangePwdAty.e3();
            } else {
                f1.a aVar2 = f1.f8649a;
                String string2 = forceChangePwdAty.getResources().getString(R.string.not_match_password);
                i.f(string2, "this.resources.getString…tring.not_match_password)");
                f1.a.f(aVar2, forceChangePwdAty, string2, false, 0, 8, null);
            }
        } else {
            f1.a aVar3 = f1.f8649a;
            String string3 = forceChangePwdAty.getResources().getString(R.string.password_format_error_tips);
            i.f(string3, "this.resources.getString…ssword_format_error_tips)");
            f1.a.f(aVar3, forceChangePwdAty, string3, false, 0, 8, null);
        }
        Context Q1 = forceChangePwdAty.Q1();
        i.e(Q1, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.F((f5.c) Q1);
    }

    public static final void b3(ForceChangePwdAty forceChangePwdAty, View view) {
        i.g(forceChangePwdAty, "this$0");
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.h(), "1")) {
            b0.d0(forceChangePwdAty, ResetAty.class, a.f8339a);
        } else if (t9.i.b(cVar.j(), "1")) {
            b0.d0(forceChangePwdAty, ResetAty.class, b.f8340a);
        } else {
            b0.d0(forceChangePwdAty, ResetAty.class, c.f8341a);
        }
    }

    public static final void c3(ForceChangePwdAty forceChangePwdAty, View view) {
        t9.i.g(forceChangePwdAty, "this$0");
        LoginAty.C.c(true);
        b0.c0(forceChangePwdAty, LoginAty.class);
    }

    public View U2(int i10) {
        Map map = this.f8338n;
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
        s5.d dVar = this.f8336l;
        if (dVar != null) {
            SwitchAccountBean f10 = dVar.f();
            if (f10 != null) {
                f10.setPassword(MemberInfo.INSTANCE.getLastPassword());
            }
            dVar.l(MemberInfo.INSTANCE.getLastPassword());
            dVar.k(false);
            s5.e.f18766a.m(dVar);
        }
        this.f8335k.a(this, s5.e.f18766a, this);
    }

    public final void Y2() {
        if (System.currentTimeMillis() - this.f8337m > 2000) {
            f1.f8649a.w(R.string.twice_end_koocan);
            this.f8337m = System.currentTimeMillis();
            return;
        }
        Object systemService = Q1().getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        q8.e.a("stop");
        c2.i.f5350q.a().h();
        z.f5049u.g().clear();
        finish();
        ma.h.f16853a.d(Q1(), "");
    }

    public final void Z2() {
        int i10 = R$id.mTextConfirm;
        ((TextView) U2(i10)).setEnabled(false);
        ((AutoRelativeLayout) U2(R$id.mLayoutChange)).setVisibility(0);
        ((AutoLinearLayout) U2(R$id.mLayoutSuccess)).setVisibility(8);
        int i11 = R$id.mTextForgetPassword;
        ((TextView) U2(i11)).getPaint().setFlags(8);
        int i12 = R$id.mTextForgetAccount;
        ((TextView) U2(i12)).getPaint().setFlags(8);
        int i13 = R$id.mEditOldPassword;
        ((EditText) U2(i13)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        int i14 = R$id.mEditNewPassword;
        ((EditText) U2(i14)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        int i15 = R$id.mEditPasswordAgain;
        ((EditText) U2(i15)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        SpannableString spannableString = new SpannableString(getString(R.string.login_forget_pwd));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        ((TextView) U2(i11)).setText(spannableString);
        ((TextView) U2(i10)).setOnClickListener(new View.OnClickListener() { // from class: e6.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceChangePwdAty.a3(ForceChangePwdAty.this, view);
            }
        });
        ((TextView) U2(i11)).setOnClickListener(new View.OnClickListener() { // from class: e6.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceChangePwdAty.b3(ForceChangePwdAty.this, view);
            }
        });
        ((EditText) U2(i13)).addTextChangedListener(new d());
        ((EditText) U2(i14)).addTextChangedListener(new e());
        ((EditText) U2(i15)).addTextChangedListener(new f());
        ((TextView) U2(i12)).setOnClickListener(new View.OnClickListener() { // from class: e6.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceChangePwdAty.c3(ForceChangePwdAty.this, view);
            }
        });
        this.f8336l = s5.e.f18766a.l();
    }

    public final boolean d3(EditText editText) {
        String obj = t.W(editText.getText().toString()).toString();
        return obj == null || obj.length() == 0;
    }

    public final void e3() {
        String e10 = m.e(((EditText) U2(R$id.mEditOldPassword)).getText().toString());
        String obj = t.W(((EditText) U2(R$id.mEditNewPassword)).getText().toString()).toString();
        w wVar = new w();
        wVar.f18961a = m.e(obj);
        ((ProgressBar) U2(R$id.mLoadingPbar)).setVisibility(0);
        w6.i b10 = w6.i.f19214g.b();
        t9.i.f(e10, "oldPwd");
        Object obj2 = wVar.f18961a;
        t9.i.f(obj2, "enNewPwd");
        b10.p2(e10, (String) obj2).compose(O1()).subscribe(new h(wVar));
    }

    @Override // s5.b
    public void f1() {
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Y2();
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_force_change_password);
        Z2();
    }

    @xa.j
    public final void onEventMainThread(CloseForcePageEvent closeForcePageEvent) {
        t9.i.g(closeForcePageEvent, "closePageEvent");
        finish();
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f8336l = s5.e.f18766a.l();
    }

    @Override // s5.b
    public void q0(String str) {
        t9.i.g(str, "loginStatus");
        ((ProgressBar) U2(R$id.mLoadingPbar)).setVisibility(8);
        if (t9.i.b(str, "0")) {
            s5.e.f18766a.a();
            b0.c0(this, MainAty.class);
            finish();
        } else {
            s5.e.f18766a.a();
            b0.d0(this, LoginAty.class, g.f8345a);
            finish();
        }
    }
}
