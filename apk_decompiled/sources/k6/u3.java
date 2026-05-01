package k6;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.EmailResetPwdResult;
import w6.i;

/* loaded from: classes3.dex */
public final class u3 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15573a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.r0 f15574b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15576b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15577c;

        /* renamed from: k6.u3$a$a, reason: collision with other inner class name */
        public static final class C0259a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15578a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u3 f15579b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0259a(String str, u3 u3Var) {
                super(1);
                this.f15578a = str;
                this.f15579b = u3Var;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f15578a, null, null, 6, null);
                if (t9.i.b(yVar.c(this.f15578a), "no_report_type") && t9.i.b(this.f15578a, "portal100060")) {
                    p10 = this.f15579b.i().getResources().getString(R.string.frequent_operation);
                    t9.i.f(p10, "context.resources.getStr…tring.frequent_operation)");
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public a(int i10, String str) {
            this.f15576b = i10;
            this.f15577c = str;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            u3.this.j().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            u3.this.j().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                String string = u3.this.i().getResources().getString(R.string.verification_invalid);
                t9.i.f(string, "context.resources.getStr…ing.verification_invalid)");
                com.mobile.brasiltv.utils.f1.f8649a.x(string);
            } else {
                if (TextUtils.equals("aaa100077", str)) {
                    u3.this.j().j();
                }
                com.mobile.brasiltv.utils.x.f8754a.w(u3.this.i(), new C0259a(str, u3.this));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            com.mobile.brasiltv.utils.b0.U(this, "绑定或者换绑邮箱成功 type：" + this.f15576b);
            u3.this.j().showLoading(false);
            u3.this.j().g2();
            if (d6.b.f12660a.r()) {
                com.mobile.brasiltv.utils.n0.f8733a.j(u3.this.i(), "first_bind_email", this.f15577c);
            }
        }
    }

    public static final class b extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15581a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15581a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15581a, null, null, 6, null));
            }
        }

        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(EmailResetPwdResult emailResetPwdResult) {
            t9.i.g(emailResetPwdResult, "t");
            com.mobile.brasiltv.utils.b0.U(this, "忘记密码发送重置邮件成功");
            u3.this.j().showLoading(false);
            u3.this.j().g2();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            u3.this.j().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            u3.this.j().showLoading(false);
            com.mobile.brasiltv.utils.b0.U(this, "忘记密码发送重置邮件失败 returnCode:" + str);
            com.mobile.brasiltv.utils.x.f8754a.w(u3.this.i(), new a(str));
        }
    }

    public u3(f5.c cVar, i6.r0 r0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(r0Var, "view");
        this.f15573a = cVar;
        this.f15574b = r0Var;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void h(String str, int i10) {
        t9.i.g(str, Scopes.EMAIL);
        i.c cVar = w6.i.f19214g;
        cVar.b().Q0(new BindEmailV2Bean(str, "" + i10, "", cVar.J(), cVar.H())).compose(this.f15573a.O1()).subscribe(new a(i10, str));
    }

    public final f5.c i() {
        return this.f15573a;
    }

    public final i6.r0 j() {
        return this.f15574b;
    }

    public void k(String str) {
        t9.i.g(str, Scopes.EMAIL);
        w6.i.f19214g.b().Z0(str).compose(this.f15573a.O1()).subscribe(new b());
    }
}
