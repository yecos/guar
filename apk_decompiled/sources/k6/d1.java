package k6;

import mobile.com.requestframe.utils.response.BaseResult;

/* loaded from: classes3.dex */
public final class d1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15131a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.w f15132b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15134b;

        /* renamed from: k6.d1$a$a, reason: collision with other inner class name */
        public static final class C0249a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15135a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0249a(String str) {
                super(1);
                this.f15135a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15135a, null, null, 6, null));
            }
        }

        public a(String str) {
            this.f15134b = str;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            d1.this.j().showLoading(false);
            com.mobile.brasiltv.utils.x.f8754a.w(d1.this.i(), new C0249a(str));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            d1.this.j().showLoading(false);
            String str = this.f15134b;
            w5.m mVar = w5.m.f19178a;
            if (t9.i.b(str, mVar.J())) {
                v5.g.f19112a.w(0);
            } else if (t9.i.b(this.f15134b, mVar.D())) {
                v5.g.f19112a.q(0);
            }
            d1.this.j().J1(this.f15134b);
        }
    }

    public d1(f5.c cVar, i6.w wVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(wVar, "view");
        this.f15131a = cVar;
        this.f15132b = wVar;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void h(String str) {
        t9.i.g(str, "messageType");
        this.f15132b.showLoading(true);
        w6.i.f19214g.b().Y0(str).compose(this.f15131a.O1()).subscribe(new a(str));
    }

    public final f5.c i() {
        return this.f15131a;
    }

    public final i6.w j() {
        return this.f15132b;
    }
}
