package k6;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import w6.i;

/* loaded from: classes3.dex */
public final class o4 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15465a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.a1 f15466b;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ShelveDataBean shelveDataBean) {
            t9.i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            List<ShelveAsset> assetList = data != null ? data.getAssetList() : null;
            if (assetList == null || assetList.isEmpty()) {
                o4.this.j().b();
            }
            ShelveListData data2 = shelveDataBean.getData();
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(data2 != null ? data2.getAssetList() : null));
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15468a = new b();

        public b() {
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

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15470b;

        public c(int i10) {
            this.f15470b = i10;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            o4.this.j().g(list, this.f15470b);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            o4.this.j().p(str, this.f15470b);
            com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, str, null, null, 6, null));
        }
    }

    public o4(f5.c cVar, i6.a1 a1Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(a1Var, "view");
        this.f15465a = cVar;
        this.f15466b = a1Var;
    }

    public static final boolean n(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List o(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final i6.a1 j() {
        return this.f15466b;
    }

    public void k(int i10, int i11, int i12) {
        m(i10, i11, i12, 2);
    }

    public void l(int i10, int i11, int i12) {
        this.f15466b.a();
        m(i10, i11, i12, 0);
    }

    public final void m(int i10, int i11, int i12, int i13) {
        i.c cVar = w6.i.f19214g;
        Observable compose = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", i11, i12, null, null)).compose(this.f15465a.O1());
        final a aVar = new a();
        Observable filter = compose.filter(new Predicate() { // from class: k6.m4
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean n10;
                n10 = o4.n(s9.l.this, obj);
                return n10;
            }
        });
        final b bVar = b.f15468a;
        filter.map(new Function() { // from class: k6.n4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List o10;
                o10 = o4.o(s9.l.this, obj);
                return o10;
            }
        }).subscribe(new c(i13));
    }
}
