package l6;

import android.content.Context;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import w6.i;

/* loaded from: classes3.dex */
public final class l implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16089a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.m f16090b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f16091a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(ShelveDataBean shelveDataBean) {
            t9.i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class b extends t9.j implements s9.l {
        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            if (list.isEmpty()) {
                l.this.k().b();
            }
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16094b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16095a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16095a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f16095a, yVar.k(), null, 4, null));
            }
        }

        public c(int i10) {
            this.f16094b = i10;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            l.this.k().g(list, this.f16094b);
            com.mobile.brasiltv.utils.b0.U(this, "ColumnListFragPresenter:onNext");
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            l.this.k().p(str, this.f16094b);
            Context context = l.this.j().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public l(b6.f fVar, i6.m mVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(mVar, "view");
        this.f16089a = fVar;
        this.f16090b = mVar;
    }

    public static final List p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final b6.f j() {
        return this.f16089a;
    }

    public final i6.m k() {
        return this.f16090b;
    }

    public void l(int i10, int i11, int i12) {
        o(i10, i11, i12, 2);
    }

    public void m(int i10, int i11, int i12) {
        this.f16090b.a();
        o(i10, i11, i12, 0);
    }

    public void n(int i10, int i11, int i12) {
        o(i10, i11, i12, 1);
    }

    public final void o(int i10, int i11, int i12, int i13) {
        i.c cVar = w6.i.f19214g;
        Observable compose = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", i11, i12, null, null)).compose(this.f16089a.O2());
        final a aVar = a.f16091a;
        Observable map = compose.map(new Function() { // from class: l6.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List p10;
                p10 = l.p(s9.l.this, obj);
                return p10;
            }
        });
        final b bVar = new b();
        map.filter(new Predicate() { // from class: l6.k
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean q10;
                q10 = l.q(s9.l.this, obj);
                return q10;
            }
        }).subscribe(new c(i13));
    }
}
