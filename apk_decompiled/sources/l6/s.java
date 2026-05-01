package l6;

import java.util.Comparator;
import java.util.List;
import mobile.com.requestframe.utils.response.ExchangeCodeItem;
import mobile.com.requestframe.utils.response.ExchangeCodeResult;

/* loaded from: classes3.dex */
public final class s implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16167a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.c f16168b;

    public static final class a extends ha.a {
        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ExchangeCodeResult exchangeCodeResult) {
            t9.i.g(exchangeCodeResult, "t");
            s.this.k().h2(s.this.n(exchangeCodeResult.getData()));
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            s.this.k().C();
        }
    }

    public s(b6.f fVar, j6.c cVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(cVar, "view");
        this.f16167a = fVar;
        this.f16168b = cVar;
    }

    public static final int o(s sVar, ExchangeCodeItem exchangeCodeItem, ExchangeCodeItem exchangeCodeItem2) {
        t9.i.g(sVar, "this$0");
        t9.i.f(exchangeCodeItem, "o1");
        if (sVar.l(exchangeCodeItem)) {
            t9.i.f(exchangeCodeItem2, "o2");
            if (sVar.m(exchangeCodeItem2)) {
                return -1;
            }
        }
        if (sVar.m(exchangeCodeItem)) {
            t9.i.f(exchangeCodeItem2, "o2");
            if (sVar.l(exchangeCodeItem2)) {
                return 1;
            }
        }
        if (com.mobile.brasiltv.utils.b0.T(exchangeCodeItem.getRecordDate(), exchangeCodeItem2.getRecordDate())) {
            return 0;
        }
        return exchangeCodeItem.getRecordDate().compareTo(exchangeCodeItem2.getRecordDate()) < 0 ? -1 : 1;
    }

    @Override // l5.a
    public void e() {
        j();
    }

    @Override // l5.a
    public void g() {
    }

    public void j() {
        this.f16168b.h();
        w6.i.f19214g.b().s1().compose(this.f16167a.O2()).subscribe(new a());
    }

    public final j6.c k() {
        return this.f16168b;
    }

    public final boolean l(ExchangeCodeItem exchangeCodeItem) {
        return com.mobile.brasiltv.utils.b0.T(exchangeCodeItem.getStatus(), "1") || com.mobile.brasiltv.utils.b0.T(exchangeCodeItem.getStatus(), "3");
    }

    public final boolean m(ExchangeCodeItem exchangeCodeItem) {
        return com.mobile.brasiltv.utils.b0.T(exchangeCodeItem.getStatus(), "0") || com.mobile.brasiltv.utils.b0.T(exchangeCodeItem.getStatus(), "2");
    }

    public final List n(List list) {
        return (list == null || list.isEmpty()) ? list : i9.r.I(i9.r.C(list, new Comparator() { // from class: l6.r
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o10;
                o10 = s.o(s.this, (ExchangeCodeItem) obj, (ExchangeCodeItem) obj2);
                return o10;
            }
        }));
    }
}
