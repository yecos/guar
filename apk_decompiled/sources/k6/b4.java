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
public final class b4 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15114a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.w0 f15115b;

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
                b4.this.k().b();
            }
            ShelveListData data2 = shelveDataBean.getData();
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(data2 != null ? data2.getAssetList() : null));
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15117a = new b();

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
        public final /* synthetic */ int f15119b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15120a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15120a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15120a, null, null, 6, null));
            }
        }

        public c(int i10) {
            this.f15119b = i10;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            b4.this.k().g(list, this.f15119b);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b4.this.k().p(str, this.f15119b);
            com.mobile.brasiltv.utils.x.f8754a.w(b4.this.j(), new a(str));
        }
    }

    public b4(f5.c cVar, i6.w0 w0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(w0Var, "view");
        this.f15114a = cVar;
        this.f15115b = w0Var;
    }

    public static final boolean o(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final f5.c j() {
        return this.f15114a;
    }

    public final i6.w0 k() {
        return this.f15115b;
    }

    public void l(int i10, int i11, int i12) {
        n(i10, i11, i12, 2);
    }

    public void m(int i10, int i11, int i12) {
        this.f15115b.a();
        n(i10, i11, i12, 0);
    }

    public final void n(int i10, int i11, int i12, int i13) {
        i.c cVar = w6.i.f19214g;
        Observable compose = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", i11, i12, null, null)).compose(this.f15114a.O1());
        final a aVar = new a();
        Observable filter = compose.filter(new Predicate() { // from class: k6.z3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean o10;
                o10 = b4.o(s9.l.this, obj);
                return o10;
            }
        });
        final b bVar = b.f15117a;
        filter.map(new Function() { // from class: k6.a4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List p10;
                p10 = b4.p(s9.l.this, obj);
                return p10;
            }
        }).subscribe(new c(i13));
    }
}
