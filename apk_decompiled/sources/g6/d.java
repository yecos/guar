package g6;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import io.reactivex.disposables.Disposable;
import ma.m;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import mobile.com.requestframe.utils.response.UpdateRestrictResult;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

/* loaded from: classes3.dex */
public final class d extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public Disposable f13988a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13989b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13991b;

        /* renamed from: g6.d$a$a, reason: collision with other inner class name */
        public static final class C0221a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13992a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0221a(String str) {
                super(1);
                this.f13992a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f13992a, null, null, 6, null));
            }
        }

        public a(String str) {
            this.f13991b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(PwdCheckResult pwdCheckResult) {
            i.g(pwdCheckResult, "t");
            d.this.j(false);
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = m.e(this.f13991b);
            i.f(e10, "md5(password)");
            memberInfo.putPassword(e10, false);
            MainAty.A.o(false);
            xa.c.c().j(new CheckPwdSuccessEvent());
            d.this.cancel();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            d.this.j(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            d.this.j(false);
            if (b0.T(str, "aaa100012")) {
                f1.f8649a.w(R.string.pwd_wrong);
                return;
            }
            if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                f1.f8649a.w(R.string.pi_connect_timeout);
                return;
            }
            x xVar = x.f8754a;
            Context context = d.this.getContext();
            i.f(context, com.umeng.analytics.pro.f.X);
            xVar.w(context, new C0221a(str));
        }
    }

    public static final class b extends ha.a {

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13994a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f13994a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f13994a, null, null, 6, null));
            }
        }

        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(UpdateRestrictResult updateRestrictResult) {
            i.g(updateRestrictResult, "t");
            k7.f.e("更新限制级状态成功，发送事件", new Object[0]);
            d.this.j(false);
            MainAty.A.o(false);
            xa.c.c().j(new CheckPwdSuccessEvent());
            xa.c.c().m(new UpdateRestrictEvent("1", true));
            d.this.cancel();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            d.this.i(disposable);
            d.this.j(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            d.this.j(false);
            x xVar = x.f8754a;
            Context context = d.this.getContext();
            i.f(context, com.umeng.analytics.pro.f.X);
            xVar.w(context, new a(str));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, R.style.OptionDialog);
        i.g(context, com.umeng.analytics.pro.f.X);
    }

    public static final void e(d dVar, View view) {
        i.g(dVar, "this$0");
        ((EditText) dVar.findViewById(R$id.mEditPassword)).setText("");
        dVar.cancel();
    }

    public static final void f(d dVar, View view) {
        i.g(dVar, "this$0");
        int i10 = R$id.mEditPassword;
        Editable text = ((EditText) dVar.findViewById(i10)).getText();
        if (text == null || text.length() == 0) {
            return;
        }
        String obj = ba.t.W(((EditText) dVar.findViewById(i10)).getText().toString()).toString();
        if (!j1.f(obj)) {
            int i11 = R$id.mTextErrorNotify;
            ((TextView) dVar.findViewById(i11)).setVisibility(0);
            ((TextView) dVar.findViewById(i11)).setText(dVar.getContext().getResources().getString(R.string.password_format_incorrect));
        } else {
            ((TextView) dVar.findViewById(R$id.mTextErrorNotify)).setVisibility(8);
            dVar.d();
            if (dVar.f13989b) {
                dVar.k(obj);
            } else {
                dVar.l(obj);
            }
        }
    }

    public static final void g(d dVar, View view) {
        i.g(dVar, "this$0");
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.c(), "1") && !t9.i.b(cVar.h(), "1") && !t9.i.b(cVar.j(), "1")) {
            f1.f8649a.w(R.string.mine_please_bind);
            return;
        }
        Intent intent = new Intent(dVar.getContext(), (Class<?>) ResetAty.class);
        if (t9.i.b(cVar.h(), "1")) {
            intent.putExtra("need_x_button", false);
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
        } else if (t9.i.b(cVar.j(), "1")) {
            intent.putExtra("need_x_button", false);
            intent.putExtra("bind_from", 1);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
        } else {
            intent.putExtra("need_x_button", false);
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", true);
        }
        dVar.getContext().startActivity(intent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        Disposable disposable = this.f13988a;
        if (disposable != null) {
            t9.i.d(disposable);
            disposable.dispose();
        }
    }

    public final void d() {
        Object systemService = getContext().getSystemService("input_method");
        t9.i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(0, 2);
    }

    public final void h(boolean z10) {
        this.f13989b = z10;
    }

    public final void i(Disposable disposable) {
        this.f13988a = disposable;
    }

    public final void j(boolean z10) {
        ((ProgressBar) findViewById(R$id.mLoadingPb)).setVisibility(z10 ? 0 : 8);
    }

    public final void k(String str) {
        t9.i.g(str, "password");
        w6.i b10 = w6.i.f19214g.b();
        String e10 = m.e(str);
        t9.i.f(e10, "md5(password)");
        b10.d2(e10).subscribe(new a(str));
    }

    public final void l(String str) {
        t9.i.g(str, "pwd");
        Disposable disposable = this.f13988a;
        if (disposable != null) {
            t9.i.d(disposable);
            if (!disposable.isDisposed()) {
                Disposable disposable2 = this.f13988a;
                t9.i.d(disposable2);
                disposable2.dispose();
            }
        }
        w6.i.f19214g.b().q2(m.e(str), "1").subscribe(new b());
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_input_password);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        ((ImageView) findViewById(R$id.mImageClose)).setOnClickListener(new View.OnClickListener() { // from class: g6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(d.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTextConfirm)).setOnClickListener(new View.OnClickListener() { // from class: g6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(d.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTextForgetPassword)).setOnClickListener(new View.OnClickListener() { // from class: g6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g(d.this, view);
            }
        });
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        ((EditText) findViewById(R$id.mEditPassword)).setText("");
        super.setOnCancelListener(onCancelListener);
    }
}
