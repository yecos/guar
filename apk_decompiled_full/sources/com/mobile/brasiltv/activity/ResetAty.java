package com.mobile.brasiltv.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import ba.t;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.bean.event.CloseResetPageEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.k;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.MaxHeightLinearLayout;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import g5.c;
import h9.g;
import h9.h;
import i6.k0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.r2;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

/* loaded from: classes.dex */
public final class ResetAty extends f5.d implements k0 {
    public static final a A = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public boolean f8037l;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8043r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8044s;

    /* renamed from: w, reason: collision with root package name */
    public b f8048w;

    /* renamed from: y, reason: collision with root package name */
    public r2 f8050y;

    /* renamed from: z, reason: collision with root package name */
    public Map f8051z = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name */
    public String f8038m = "Brazil";

    /* renamed from: n, reason: collision with root package name */
    public String f8039n = "55";

    /* renamed from: o, reason: collision with root package name */
    public int f8040o = 2;

    /* renamed from: p, reason: collision with root package name */
    public int f8041p = 1;

    /* renamed from: q, reason: collision with root package name */
    public Handler f8042q = new Handler();

    /* renamed from: t, reason: collision with root package name */
    public final g f8045t = h.b(new f());

    /* renamed from: u, reason: collision with root package name */
    public String f8046u = "@gmail.com";

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f8047v = new ArrayList();

    /* renamed from: x, reason: collision with root package name */
    public Runnable f8049x = new Runnable() { // from class: f5.h3
        @Override // java.lang.Runnable
        public final void run() {
            ResetAty.s3(ResetAty.this);
        }
    };

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final void a(Context context) {
            i.g(context, com.umeng.analytics.pro.f.X);
            Intent intent = new Intent(context, (Class<?>) ResetAty.class);
            intent.putExtra("need_x_button", false);
            intent.putExtra("need_auto_login", false);
            intent.putExtra("is_form_login", false);
            intent.putExtra("bind_Type", "3");
            context.startActivity(intent);
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final CheckBox f8052a;

        /* renamed from: b, reason: collision with root package name */
        public int f8053b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResetAty f8054c;

        public b(ResetAty resetAty, CheckBox checkBox, int i10) {
            i.g(checkBox, "countDownView");
            this.f8054c = resetAty;
            this.f8052a = checkBox;
            this.f8053b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CheckBox checkBox = this.f8052a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8053b);
            sb.append('s');
            checkBox.setText(sb.toString());
            int i10 = this.f8053b - 1;
            this.f8053b = i10;
            if (i10 != 0) {
                this.f8054c.f8042q.postDelayed(this, 1000L);
                return;
            }
            this.f8054c.f8042q.removeCallbacks(this);
            this.f8052a.setEnabled(true);
            this.f8053b = 180;
            this.f8052a.setText(this.f8054c.getResources().getString(R.string.sending));
        }

        public /* synthetic */ b(ResetAty resetAty, CheckBox checkBox, int i10, int i11, t9.g gVar) {
            this(resetAty, checkBox, (i11 & 2) != 0 ? 180 : i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f8055a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            i.f(putExtra, "intent.putExtra(WebViewA…NDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = t.W(((EditText) ResetAty.this.b3(R$id.mEditEmail)).getText().toString()).toString();
            if (TextUtils.isEmpty(obj)) {
                ((ImageView) ResetAty.this.b3(R$id.mIvClear)).setVisibility(8);
            } else {
                ((ImageView) ResetAty.this.b3(R$id.mIvClear)).setVisibility(0);
            }
            ResetAty.this.t3(obj);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements c.a {
        public e() {
        }

        @Override // g5.c.a
        public void onClick(String str) {
            i.g(str, "mEmailString");
            ResetAty resetAty = ResetAty.this;
            int i10 = R$id.mEditEmail;
            ((EditText) resetAty.b3(i10)).setText(str);
            ((EditText) ResetAty.this.b3(i10)).setSelection(str.length());
            ((RecyclerView) ResetAty.this.b3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) ResetAty.this.b3(R$id.mLlRecyclerViewEmail)).setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends j implements s9.a {
        public f() {
            super(0);
        }

        @Override // s9.a
        public final g5.c invoke() {
            return new g5.c(ResetAty.this.Q1());
        }
    }

    public static final void f3(ResetAty resetAty, CompoundButton compoundButton, boolean z10) {
        String str;
        i.g(resetAty, "this$0");
        boolean z11 = true;
        if (!z10) {
            int i10 = R$id.sendEmailMsgBt;
            ((CheckBox) resetAty.b3(i10)).setTextColor(resetAty.getResources().getColor(R.color.color_important));
            ((CheckBox) resetAty.b3(i10)).setEnabled(true);
            return;
        }
        int i11 = R$id.mEditEmail;
        String obj = t.W(((EditText) resetAty.b3(i11)).getText().toString()).toString();
        x xVar = x.f8754a;
        String p10 = xVar.p(obj);
        if (p10 != null && p10.length() != 0) {
            z11 = false;
        }
        if (z11) {
            ((EditText) resetAty.b3(i11)).setText(obj + resetAty.f8046u);
        }
        if (TextUtils.isEmpty(obj)) {
            ((CheckBox) resetAty.b3(R$id.sendEmailMsgBt)).setChecked(false);
            int i12 = R$id.errorTx;
            ((TextView) resetAty.b3(i12)).setVisibility(0);
            ((TextView) resetAty.b3(i12)).setText(resetAty.getResources().getString(R.string.enter_your_email_notice));
            resetAty.j3();
            return;
        }
        if (!j1.d(obj)) {
            ((CheckBox) resetAty.b3(R$id.sendEmailMsgBt)).setChecked(false);
            int i13 = R$id.errorTx;
            ((TextView) resetAty.b3(i13)).setVisibility(0);
            ((TextView) resetAty.b3(i13)).setText(resetAty.getResources().getString(R.string.email_incorrect));
            resetAty.j3();
            return;
        }
        Locale locale = Locale.getDefault();
        i.f(locale, "getDefault()");
        String lowerCase = obj.toLowerCase(locale);
        i.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String v10 = xVar.v(resetAty.Q1());
        if (v10 != null) {
            Locale locale2 = Locale.getDefault();
            i.f(locale2, "getDefault()");
            str = v10.toLowerCase(locale2);
            i.f(str, "this as java.lang.String).toLowerCase(locale)");
        } else {
            str = null;
        }
        if (!i.b(lowerCase, str)) {
            ((TextView) resetAty.b3(R$id.errorTx)).setVisibility(8);
            resetAty.v3();
            resetAty.S2().l(obj);
            ((CheckBox) resetAty.b3(R$id.sendEmailMsgBt)).setEnabled(false);
            return;
        }
        ((CheckBox) resetAty.b3(R$id.sendEmailMsgBt)).setChecked(false);
        int i14 = R$id.errorTx;
        ((TextView) resetAty.b3(i14)).setVisibility(0);
        ((TextView) resetAty.b3(i14)).setText(resetAty.getResources().getString(R.string.not_service_email_tips));
        resetAty.j3();
    }

    public static final void g3(ResetAty resetAty, View view) {
        i.g(resetAty, "this$0");
        b0.d0(resetAty, WebViewAty.class, c.f8055a);
    }

    public static final void h3(ResetAty resetAty, View view) {
        i.g(resetAty, "this$0");
        ((CheckBox) resetAty.b3(R$id.readCheckBox)).setChecked(!((CheckBox) resetAty.b3(r2)).isChecked());
    }

    public static final void i3(ResetAty resetAty, View view) {
        i.g(resetAty, "this$0");
        resetAty.j3();
        int i10 = R$id.errorTx;
        ((TextView) resetAty.b3(i10)).setVisibility(8);
        String obj = t.W(((EditText) resetAty.b3(R$id.mEditEmail)).getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            ((TextView) resetAty.b3(i10)).setVisibility(0);
            ((TextView) resetAty.b3(i10)).setText(resetAty.getResources().getString(R.string.enter_your_email_notice));
            return;
        }
        String obj2 = t.W(((EditText) resetAty.b3(R$id.mEtEmailverification)).getText().toString()).toString();
        if (TextUtils.isEmpty(obj2)) {
            ((TextView) resetAty.b3(i10)).setVisibility(0);
            ((TextView) resetAty.b3(i10)).setText(resetAty.getResources().getString(R.string.empty_verification_code));
            return;
        }
        if (!j1.d(obj)) {
            ((TextView) resetAty.b3(i10)).setVisibility(0);
            ((TextView) resetAty.b3(i10)).setText(resetAty.getResources().getString(R.string.email_incorrect));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("verificationCode  ");
        sb.append(obj2);
        sb.append("   length ");
        sb.append(obj2.length());
        if (obj2.length() != 6) {
            ((TextView) resetAty.b3(i10)).setText(resetAty.getResources().getString(R.string.verification_invalid));
            ((TextView) resetAty.b3(i10)).setVisibility(0);
        } else {
            resetAty.v3();
            ((TextView) resetAty.b3(i10)).setVisibility(8);
            resetAty.S2().i(obj, obj2);
        }
    }

    public static final void p3(ResetAty resetAty, View view) {
        i.g(resetAty, "this$0");
        ((EditText) resetAty.b3(R$id.mEditEmail)).setText("");
    }

    public static final void r3(ResetAty resetAty, View view) {
        i.g(resetAty, "this$0");
        if (resetAty.f8044s) {
            resetAty.finish();
        } else {
            b0.c0(resetAty, MainAty.class);
        }
    }

    public static final void s3(ResetAty resetAty) {
        i.g(resetAty, "this$0");
        TextView textView = (TextView) resetAty.b3(R$id.errorTx);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // i6.k0
    public void A0() {
        int i10 = R$id.sendEmailMsgBt;
        ((CheckBox) b3(i10)).setTextColor(getResources().getColor(R.color.color_f7bd46));
        CheckBox checkBox = (CheckBox) b3(i10);
        i.f(checkBox, "sendEmailMsgBt");
        b bVar = new b(this, checkBox, 0, 2, null);
        this.f8048w = bVar;
        this.f8042q.post(bVar);
        k.f8726a.c("key_verifycode_bind_time", System.currentTimeMillis());
    }

    @Override // i6.k0
    public void L(String str, String str2) {
        i.g(str, "areaCode");
        i.g(str2, bt.O);
    }

    @Override // f5.d
    public void R2() {
        w3(new r2(this, this));
        n3();
        q3();
        o3();
        boolean booleanExtra = getIntent().getBooleanExtra("need_x_button", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("is_edit_editable", true);
        this.f8043r = getIntent().getBooleanExtra("is_form_login", false);
        this.f8044s = getIntent().getBooleanExtra("is_force", false);
        if (booleanExtra) {
            ((TitleView) b3(R$id.titleView)).setXVisible(0);
        } else {
            ((TitleView) b3(R$id.titleView)).setXVisible(8);
        }
        i.c cVar = w6.i.f19214g;
        if (!TextUtils.isEmpty(cVar.m())) {
            ((EditText) b3(R$id.mEditEmail)).setText(cVar.m());
            ((ImageView) b3(R$id.mIvClear)).setVisibility(8);
        } else if (d6.b.f12660a.y() || t9.i.b(cVar.I(), "")) {
            String f10 = n0.f(n0.f8733a, this, "first_bind_email", null, 4, null);
            if (b0.H(f10)) {
                ((EditText) b3(R$id.mEditEmail)).setText(f10);
            }
        }
        if (!TextUtils.isEmpty(cVar.f())) {
            k3(cVar.f());
        } else if (d6.b.f12660a.y() || t9.i.b(cVar.I(), "")) {
            String f11 = n0.f(n0.f8733a, this, "first_bind_area_code", null, 4, null);
            if (b0.H(f11)) {
                t9.i.d(f11);
                k3(f11);
            }
        }
        int i10 = R$id.mRvCompleteList;
        ((RecyclerView) b3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(Q1()));
        ((RecyclerView) b3(i10)).setAdapter(l3());
        int i11 = R$id.mEditEmail;
        Editable text = ((EditText) b3(i11)).getText();
        if (!(text == null || text.length() == 0)) {
            ((EditText) b3(i11)).setEnabled(booleanExtra2);
            ((ImageView) b3(R$id.mIvClear)).setVisibility(8);
        }
        int i12 = R$id.sendEmailMsgBt;
        ((CheckBox) b3(i12)).setEnabled(true);
        ((CheckBox) b3(i12)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: f5.i3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ResetAty.f3(ResetAty.this, compoundButton, z10);
            }
        });
        ((TextView) b3(R$id.webLink)).setOnClickListener(new View.OnClickListener() { // from class: f5.j3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAty.g3(ResetAty.this, view);
            }
        });
        ((TextView) b3(R$id.chooseCheckBox)).setOnClickListener(new View.OnClickListener() { // from class: f5.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAty.h3(ResetAty.this, view);
            }
        });
        ((TextView) b3(R$id.mTextLogOther)).setOnClickListener(new View.OnClickListener() { // from class: f5.l3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAty.i3(ResetAty.this, view);
            }
        });
        x3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_reset_new;
    }

    @Override // i6.k0
    public void W1(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verificationCode");
        SetPwdOnResetAty.f8141t.a(this, str, str2, this.f8043r, getIntent().getBooleanExtra("need_auto_login", true), true);
    }

    public View b3(int i10) {
        Map map = this.f8051z;
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

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void closePageEvent(CloseResetPageEvent closeResetPageEvent) {
        t9.i.g(closeResetPageEvent, "event");
        finish();
    }

    @Override // i6.k0
    public void e(List list) {
        t9.i.g(list, "emailList");
        if (!list.isEmpty()) {
            this.f8047v.addAll(list);
        }
    }

    public final void e3(int i10) {
        ((TextView) b3(R$id.errorTx)).setVisibility(8);
    }

    @Override // i6.k0
    public void j2() {
        int i10 = R$id.sendEmailMsgBt;
        ((CheckBox) b3(i10)).setChecked(false);
        ((CheckBox) b3(i10)).setEnabled(true);
    }

    public final void j3() {
        v3();
        this.f8042q.postDelayed(this.f8049x, 5000L);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k3(String str) {
        String str2;
        t9.i.g(str, "areaCode");
        int i10 = 0;
        if (str.length() > 0) {
            String[] stringArray = getResources().getStringArray(R.array.nation);
            t9.i.f(stringArray, "resources.getStringArray(R.array.nation)");
            String[] stringArray2 = getResources().getStringArray(R.array.code);
            t9.i.f(stringArray2, "resources.getStringArray(R.array.code)");
            int length = stringArray2.length;
            while (true) {
                if (i10 >= length) {
                    str2 = "";
                    break;
                } else {
                    if (t9.i.b(stringArray2[i10], str)) {
                        str2 = stringArray[i10];
                        t9.i.f(str2, "nationData[i]");
                        break;
                    }
                    i10++;
                }
            }
            this.f8038m = str2;
            this.f8039n = str;
        }
    }

    public final g5.c l3() {
        return (g5.c) this.f8045t.getValue();
    }

    @Override // f5.d
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public r2 S2() {
        r2 r2Var = this.f8050y;
        if (r2Var != null) {
            return r2Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void n3() {
        int intExtra = getIntent().getIntExtra("bind_from", 2);
        this.f8040o = intExtra;
        e3(intExtra);
    }

    @Override // i6.k0
    public void o(String str) {
        t9.i.g(str, Constants.KEY_HTTP_CODE);
        int i10 = R$id.errorTx;
        ((TextView) b3(i10)).setText(str);
        ((TextView) b3(i10)).setVisibility(0);
        j3();
    }

    public final void o3() {
        ((EditText) b3(R$id.mEditEmail)).addTextChangedListener(new d());
        l3().f(new e());
        ((ImageView) b3(R$id.mIvClear)).setOnClickListener(new View.OnClickListener() { // from class: f5.n3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAty.p3(ResetAty.this, view);
            }
        });
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == SelectNationAty.f8104p.a() && i10 == 1002) {
            String stringExtra = intent != null ? intent.getStringExtra("register_nation") : null;
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.f8038m = stringExtra;
            String stringExtra2 = intent != null ? intent.getStringExtra("register_code") : null;
            this.f8039n = stringExtra2 != null ? stringExtra2 : "";
            this.f8037l = true;
            u3();
        }
    }

    @Override // f5.d, f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S2().h();
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f8048w;
        if (bVar != null) {
            this.f8042q.removeCallbacks(bVar);
        }
        this.f8042q.removeCallbacks(this.f8049x);
    }

    @xa.j
    public final void onEventMainThread(ClosePageEvent closePageEvent) {
        t9.i.g(closePageEvent, "closePageEvent");
        finish();
    }

    public final void q3() {
        int i10 = R$id.titleView;
        ((TitleView) b3(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) b3(i10)).getSettingView().setVisibility(8);
        ((TitleView) b3(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) b3(i10)).setIvMenuSrc(0);
        ((TitleView) b3(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) b3(i10)).setTvMenuText("");
        ((TitleView) b3(i10)).setXClickListener(new View.OnClickListener() { // from class: f5.m3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAty.r3(ResetAty.this, view);
            }
        });
    }

    @Override // i6.k0
    public void showLoading(boolean z10) {
        if (z10) {
            ((ProgressBar) b3(R$id.mLoadingPbar)).setVisibility(0);
        } else {
            ((ProgressBar) b3(R$id.mLoadingPbar)).setVisibility(8);
        }
    }

    public final void t3(String str) {
        if (TextUtils.isEmpty(str) || !t.o(str, "@", false, 2, null) || t.y(str, "@", 0, false, 6, null) != t.D(str, "@", 0, false, 6, null)) {
            ((RecyclerView) b3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) b3(R$id.mLlRecyclerViewEmail)).setVisibility(8);
            return;
        }
        if (s.e(str, "@", false, 2, null)) {
            g5.c l32 = l3();
            String substring = str.substring(0, str.length() - 1);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            l32.g(substring);
            l3().e(this.f8047v);
            ((RecyclerView) b3(R$id.mRvCompleteList)).setVisibility(0);
            ((MaxHeightLinearLayout) b3(R$id.mLlRecyclerViewEmail)).setVisibility(0);
            return;
        }
        String lowerCase = str.toLowerCase();
        t9.i.f(lowerCase, "this as java.lang.String).toLowerCase()");
        String[] strArr = (String[]) t.M(lowerCase, new String[]{"@"}, false, 0, 6, null).toArray(new String[0]);
        String str2 = '@' + strArr[1];
        int size = this.f8047v.size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = this.f8047v.get(i10);
            t9.i.f(obj, "mEmailSuffixList[i]");
            String str3 = (String) obj;
            String lowerCase2 = str3.toLowerCase();
            t9.i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (s.l(lowerCase2, str2, false, 2, null)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) b3(R$id.mRvCompleteList)).setVisibility(8);
            ((MaxHeightLinearLayout) b3(R$id.mLlRecyclerViewEmail)).setVisibility(8);
            return;
        }
        l3().g(strArr[0]);
        l3().e(arrayList);
        int i11 = R$id.mRvCompleteList;
        ((RecyclerView) b3(i11)).setBackgroundDrawable(Q1().getResources().getDrawable(R.drawable.bg_associate_email));
        ((RecyclerView) b3(i11)).setVisibility(0);
        ((MaxHeightLinearLayout) b3(R$id.mLlRecyclerViewEmail)).setVisibility(0);
    }

    @Override // i6.k0
    public void u(int i10) {
        String string = getString(i10);
        t9.i.f(string, "getString(strRes)");
        o(string);
    }

    public final void u3() {
    }

    public final void v3() {
        this.f8042q.removeCallbacks(this.f8049x);
    }

    public void w3(r2 r2Var) {
        t9.i.g(r2Var, "<set-?>");
        this.f8050y = r2Var;
    }

    public final void x3() {
        long currentTimeMillis = 180 - ((System.currentTimeMillis() - k.f8726a.b("key_verifycode_bind_time")) / 1000);
        if (currentTimeMillis > 0) {
            int i10 = R$id.sendEmailMsgBt;
            ((CheckBox) b3(i10)).setEnabled(false);
            ((CheckBox) b3(i10)).setBackgroundResource(R.drawable.send_sms_checked);
            ((CheckBox) b3(i10)).setTextColor(getResources().getColor(R.color.color_f7bd46));
            CheckBox checkBox = (CheckBox) b3(i10);
            t9.i.f(checkBox, "sendEmailMsgBt");
            b bVar = new b(this, checkBox, (int) currentTimeMillis);
            this.f8048w = bVar;
            this.f8042q.post(bVar);
        }
    }
}
