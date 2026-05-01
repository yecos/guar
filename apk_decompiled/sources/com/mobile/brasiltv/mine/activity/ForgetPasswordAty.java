package com.mobile.brasiltv.mine.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.mine.activity.ForgetPasswordAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import h9.g;
import h9.h;
import h9.t;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import k7.f;
import mobile.com.requestframe.utils.response.EmailResetPwdResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import t9.z;
import w6.i;

/* loaded from: classes3.dex */
public final class ForgetPasswordAty extends f5.c {

    /* renamed from: o, reason: collision with root package name */
    public static final a f8348o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static final String f8349p = "HAS_X";

    /* renamed from: m, reason: collision with root package name */
    public long f8352m;

    /* renamed from: n, reason: collision with root package name */
    public Map f8353n = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public final g f8350k = h.b(new b());

    /* renamed from: l, reason: collision with root package name */
    public String f8351l = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return ForgetPasswordAty.f8349p;
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(ForgetPasswordAty.this.getIntent().getBooleanExtra(ForgetPasswordAty.f8348o.a(), false));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f8356b;

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8357a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8357a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8357a, null, null, 6, null));
            }
        }

        public c(w wVar) {
            this.f8356b = wVar;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(EmailResetPwdResult emailResetPwdResult) {
            i.g(emailResetPwdResult, "t");
            f.e("忘记密码发送重置邮件成功", new Object[0]);
            ForgetPasswordAty.this.showLoading(false);
            ((AutoRelativeLayout) ForgetPasswordAty.this.U2(R$id.mLayoutEmailSend)).setVisibility(0);
            ((TextView) ForgetPasswordAty.this.U2(R$id.mTextErrorNotify)).setVisibility(8);
            TextView textView = (TextView) ForgetPasswordAty.this.U2(R$id.mTextSuccessNotify);
            z zVar = z.f18964a;
            String string = ForgetPasswordAty.this.Q1().getResources().getString(R.string.forget_email_send);
            i.f(string, "context.resources.getStr…string.forget_email_send)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f8356b.f18961a}, 1));
            i.f(format, "format(format, *args)");
            textView.setText(format);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            ForgetPasswordAty.this.showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            ForgetPasswordAty.this.showLoading(false);
            f.e("忘记密码发送重置邮件失败 returnCode:" + str, new Object[0]);
            x.f8754a.w(ForgetPasswordAty.this.Q1(), new a(str));
        }
    }

    public static final void Y2(ForgetPasswordAty forgetPasswordAty, View view) {
        i.g(forgetPasswordAty, "this$0");
        b0.c0(forgetPasswordAty, MainAty.class);
    }

    public static final void Z2(ForgetPasswordAty forgetPasswordAty, View view) {
        i.g(forgetPasswordAty, "this$0");
        if (((AutoRelativeLayout) forgetPasswordAty.U2(R$id.mLayoutEmailSend)).getVisibility() == 0) {
            return;
        }
        int i10 = R$id.mEditEmail;
        Editable text = ((EditText) forgetPasswordAty.U2(i10)).getText();
        if (text == null || text.length() == 0) {
            return;
        }
        if (!j1.d(((EditText) forgetPasswordAty.U2(i10)).getText().toString())) {
            int i11 = R$id.mTextErrorNotify;
            ((TextView) forgetPasswordAty.U2(i11)).setVisibility(0);
            ((TextView) forgetPasswordAty.U2(i11)).setText(forgetPasswordAty.getResources().getString(R.string.email_incorrect));
        } else if (i.b(((EditText) forgetPasswordAty.U2(i10)).getText().toString(), forgetPasswordAty.f8351l) && System.currentTimeMillis() - forgetPasswordAty.f8352m <= 60000) {
            int i12 = R$id.mTextErrorNotify;
            ((TextView) forgetPasswordAty.U2(i12)).setVisibility(0);
            ((TextView) forgetPasswordAty.U2(i12)).setText(forgetPasswordAty.getResources().getString(R.string.frequent_operation));
        } else {
            forgetPasswordAty.f8352m = System.currentTimeMillis();
            forgetPasswordAty.f8351l = ((EditText) forgetPasswordAty.U2(i10)).getText().toString();
            ((TextView) forgetPasswordAty.U2(R$id.mTextErrorNotify)).setVisibility(8);
            forgetPasswordAty.c3();
        }
    }

    public static final void a3(ForgetPasswordAty forgetPasswordAty, View view) {
        i.g(forgetPasswordAty, "this$0");
        ((AutoRelativeLayout) forgetPasswordAty.U2(R$id.mLayoutEmailSend)).setVisibility(8);
    }

    public View U2(int i10) {
        Map map = this.f8353n;
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

    public final boolean W2() {
        return ((Boolean) this.f8350k.getValue()).booleanValue();
    }

    public final void X2() {
        ((TitleView) U2(R$id.title_view)).setXClickListener(new View.OnClickListener() { // from class: e6.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgetPasswordAty.Y2(ForgetPasswordAty.this, view);
            }
        });
        ((TextView) U2(R$id.mTextConfirm)).setOnClickListener(new View.OnClickListener() { // from class: e6.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgetPasswordAty.Z2(ForgetPasswordAty.this, view);
            }
        });
        ((ImageView) U2(R$id.mImageClose)).setOnClickListener(new View.OnClickListener() { // from class: e6.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgetPasswordAty.a3(ForgetPasswordAty.this, view);
            }
        });
    }

    public final void b3() {
        if (W2()) {
            ((TitleView) U2(R$id.title_view)).setXVisible(0);
        } else {
            ((TitleView) U2(R$id.title_view)).setXVisible(8);
        }
        i.c cVar = w6.i.f19214g;
        if (TextUtils.isEmpty(cVar.m())) {
            return;
        }
        ((EditText) U2(R$id.mEditEmail)).setText(cVar.m());
    }

    public final void c3() {
        w wVar = new w();
        wVar.f18961a = ((EditText) U2(R$id.mEditEmail)).getText().toString();
        w6.i.f19214g.b().Z0((String) wVar.f18961a).compose(O1()).subscribe(new c(wVar));
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_forget_password);
        b3();
        X2();
    }

    public final void showLoading(boolean z10) {
        ((ProgressBar) U2(R$id.mLoadingPb)).setVisibility(z10 ? 0 : 8);
    }
}
