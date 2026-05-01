package k6;

import com.mobile.brasiltv.bean.MemberInfo;
import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.response.PwdCheckResult;

/* loaded from: classes3.dex */
public final class x implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15630a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.o f15631b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15633b;

        /* renamed from: k6.x$a$a, reason: collision with other inner class name */
        public static final class C0262a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15634a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0262a(String str) {
                super(1);
                this.f15634a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15634a, null, null, 6, null));
            }
        }

        public a(String str) {
            this.f15633b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(PwdCheckResult pwdCheckResult) {
            t9.i.g(pwdCheckResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = ma.m.e(this.f15633b);
            t9.i.f(e10, "md5(pwd)");
            memberInfo.putPassword(e10, false);
            x.this.j().showLoading(false);
            x.this.j().O0();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            x.this.j().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            x.this.j().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "aaa100012")) {
                x.this.j().R(R.string.pwd_wrong);
                return;
            }
            if (com.mobile.brasiltv.utils.b0.T(str, "50010") || com.mobile.brasiltv.utils.b0.T(str, "50011") || com.mobile.brasiltv.utils.b0.T(str, "50012") || com.mobile.brasiltv.utils.b0.T(str, "50014")) {
                x.this.j().R(R.string.pi_connect_timeout);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(x.this.i(), new C0262a(str));
            }
        }
    }

    public x(f5.c cVar, i6.o oVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(oVar, "view");
        this.f15630a = cVar;
        this.f15631b = oVar;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void h(String str) {
        t9.i.g(str, "pwd");
        w6.i b10 = w6.i.f19214g.b();
        String e10 = ma.m.e(str);
        t9.i.f(e10, "md5(pwd)");
        b10.d2(e10).compose(this.f15630a.O1()).subscribe(new a(str));
    }

    public final f5.c i() {
        return this.f15630a;
    }

    public final i6.o j() {
        return this.f15631b;
    }
}
