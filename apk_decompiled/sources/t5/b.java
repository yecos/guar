package t5;

import mobile.com.requestframe.utils.response.BaseResult;
import w6.i;

/* loaded from: classes3.dex */
public final class b implements t5.a {

    /* renamed from: a, reason: collision with root package name */
    public s5.b f18851a;

    public static final class a extends ha.a {
        public a() {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            s5.b bVar = b.this.f18851a;
            if (bVar != null) {
                bVar.q0("1");
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            k7.f.e("登出成功", new Object[0]);
            s5.b bVar = b.this.f18851a;
            if (bVar != null) {
                bVar.q0("0");
            }
        }
    }

    @Override // t5.a
    public void a(u8.a aVar, s5.e eVar) {
        t9.i.g(aVar, "activity");
        t9.i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f18851a;
        if (bVar != null) {
            bVar.f1();
        }
        s5.b bVar2 = this.f18851a;
        if (bVar2 != null) {
            bVar2.q0("1");
        }
    }

    @Override // t5.a
    public void b(t5.a aVar) {
        t9.i.g(aVar, "logOutMethod");
    }

    @Override // t5.a
    public void c(u8.a aVar, s5.e eVar) {
        t9.i.g(aVar, "activity");
        t9.i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f18851a;
        if (bVar != null) {
            bVar.f1();
        }
        i.c cVar = w6.i.f19214g;
        if (!(cVar.H().length() == 0)) {
            if (!(cVar.J().length() == 0)) {
                cVar.b().b2().compose(aVar.O1()).subscribe(new a());
                return;
            }
        }
        s5.b bVar2 = this.f18851a;
        if (bVar2 != null) {
            bVar2.q0("0");
        }
    }

    @Override // t5.a
    public void d(s5.b bVar) {
        t9.i.g(bVar, "callback");
        this.f18851a = bVar;
    }
}
