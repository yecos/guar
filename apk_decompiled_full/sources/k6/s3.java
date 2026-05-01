package k6;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mobile.brasiltv.bean.RootColumnId;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.bean.SearchByNameBean;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.SearchByNameResult;
import mobile.com.requestframe.utils.response.SearchData;
import mobile.com.requestframe.utils.response.SearchItem;
import mobile.com.requestframe.utils.response.SearchShelveItem;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import w6.i;

/* loaded from: classes3.dex */
public final class s3 implements i6.n0 {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15517a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.o0 f15518b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15519c;

    /* renamed from: d, reason: collision with root package name */
    public int f15520d;

    /* renamed from: e, reason: collision with root package name */
    public int f15521e;

    /* renamed from: f, reason: collision with root package name */
    public String f15522f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15523g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15524h;

    /* renamed from: i, reason: collision with root package name */
    public Disposable f15525i;

    /* renamed from: j, reason: collision with root package name */
    public int f15526j;

    /* renamed from: k, reason: collision with root package name */
    public int f15527k;

    /* renamed from: l, reason: collision with root package name */
    public int f15528l;

    /* renamed from: m, reason: collision with root package name */
    public List f15529m;

    /* renamed from: n, reason: collision with root package name */
    public long f15530n;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15531a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            if (data != null) {
                return data.getChildColumnList();
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
                s3.this.H().v2();
            }
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "it");
            String f10 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
            t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            na.f.k(na.a.f17333a, "service_time_hot_search", String.valueOf((i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            na.f.j(na.a.f17333a, "hot_search_column", ((ChildColumnList) list.get(0)).getId());
            i.c cVar = w6.i.f19214g;
            return cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), ((ChildColumnList) list.get(0)).getId(), "2", 100, 1, null, null)).compose(s3.this.z().O1());
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f15534a = new d();

        public d() {
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

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f15535a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list) {
            t9.i.g(list, "it");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (com.mobile.brasiltv.utils.b0.K(((ShelveAsset) obj).getName())) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    public static final class f extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15537a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15537a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15537a, null, null, 6, null));
            }
        }

        public f() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "it");
            super.onNext(list);
            if (list.isEmpty()) {
                s3.this.H().v2();
                return;
            }
            s3.this.f15529m = list;
            s3.this.f15528l = list.size() / s3.this.f15527k;
            s3.this.f15528l += list.size() % s3.this.f15527k == 0 ? 0 : 1;
            if (s3.this.f15528l > 3) {
                s3.this.f15528l = 3;
            }
            s3.this.P();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(s3.this.z(), new a(str));
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f15538a = new g();

        public g() {
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

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f15539a = new h();

        public h() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list) {
            t9.i.g(list, "it");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (com.mobile.brasiltv.utils.b0.K(((ShelveAsset) obj).getName())) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    public static final class i extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15541a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15541a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15541a, null, null, 6, null));
            }
        }

        public i() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "it");
            super.onNext(list);
            if (list.isEmpty()) {
                s3.this.H().v2();
                return;
            }
            s3.this.f15529m = list;
            s3.this.f15528l = list.size() / s3.this.f15527k;
            s3.this.f15528l += list.size() % s3.this.f15527k == 0 ? 0 : 1;
            if (s3.this.f15528l > 3) {
                s3.this.f15528l = 3;
            }
            s3.this.P();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(s3.this.z(), new a(str));
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.u f15543b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(t9.u uVar) {
            super(1);
            this.f15543b = uVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                s3.this.I(this.f15543b.f18959a);
            } else {
                s3.this.A();
            }
        }
    }

    public static final class k extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15545b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15546a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15546a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15546a, null, null, 6, null));
            }
        }

        public k(String str) {
            this.f15545b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(SearchByNameResult searchByNameResult) {
            t9.i.g(searchByNameResult, "t");
            s3.this.H().T0();
            s3.this.O(searchByNameResult, this.f15545b);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onComplete() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            s3.this.W(disposable);
            s3.this.U(true);
            s3.this.H().h();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            s3.this.H().T0();
            s3.this.H().M0(this.f15545b);
            com.mobile.brasiltv.utils.x.f8754a.w(s3.this.z(), new a(str));
        }
    }

    public s3(f5.c cVar, i6.o0 o0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(o0Var, "view");
        this.f15517a = cVar;
        this.f15518b = o0Var;
        this.f15519c = 50;
        this.f15520d = 1;
        this.f15521e = 1;
        this.f15522f = "";
        this.f15526j = -1;
        this.f15527k = 10;
        o0Var.Y0(this);
    }

    public static final List B(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean C(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ObservableSource D(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final List E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List F(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List J(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List K(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void M(t9.u uVar, ObservableEmitter observableEmitter) {
        t9.i.g(uVar, "$cacheId");
        t9.i.g(observableEmitter, "it");
        int d10 = na.f.d(na.a.f17333a, "hot_search_column", 0);
        uVar.f18959a = d10;
        if (d10 == 0) {
            observableEmitter.onNext(Boolean.FALSE);
            return;
        }
        int d11 = na.f.d(na.a.f17333a, "column_cache_time", 0);
        String f10 = na.f.f(na.a.f17333a, "service_time_hot_search", "0");
        t9.i.f(f10, "getStrings(AppHelper.mCo…ICE_TIME_HOT_SEARCH, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(na.a.f17333a, "realtime_dcs", "0");
        t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
        long a10 = (i2.h.f14287a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
        StringBuilder sb = new StringBuilder();
        sb.append("hot column: nowTime: ");
        sb.append(a10);
        sb.append(", lastCacheTime: ");
        sb.append(parseLong);
        sb.append(", cacheTime: ");
        int i10 = 60000 * d11;
        sb.append(i10);
        sb.append(", needRequest= ");
        sb.append(a10 > ((long) i10) + parseLong);
        k7.f.e(sb.toString(), new Object[0]);
        if (parseLong == 0 || d11 == 0 || a10 >= parseLong + (d11 * 60 * 1000)) {
            observableEmitter.onNext(Boolean.FALSE);
        } else {
            observableEmitter.onNext(Boolean.TRUE);
        }
    }

    public static final void N(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void R(s3 s3Var, String str) {
        t9.i.g(s3Var, "this$0");
        t9.i.g(str, "$searchKey");
        com.mobile.brasiltv.utils.q0.d(s3Var.f15517a, str);
    }

    public final void A() {
        Observable compose = w6.i.i1(w6.i.f19214g.b(), RootColumnId.hotSearchId, false, 0, 0, 14, null).compose(this.f15517a.O1());
        final a aVar = a.f15531a;
        Observable map = compose.map(new Function() { // from class: k6.l3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List B;
                B = s3.B(s9.l.this, obj);
                return B;
            }
        });
        final b bVar = new b();
        Observable filter = map.filter(new Predicate() { // from class: k6.m3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean C;
                C = s3.C(s9.l.this, obj);
                return C;
            }
        });
        final c cVar = new c();
        Observable flatMap = filter.flatMap(new Function() { // from class: k6.n3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource D;
                D = s3.D(s9.l.this, obj);
                return D;
            }
        });
        final d dVar = d.f15534a;
        Observable map2 = flatMap.map(new Function() { // from class: k6.o3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List E;
                E = s3.E(s9.l.this, obj);
                return E;
            }
        });
        final e eVar = e.f15535a;
        map2.map(new Function() { // from class: k6.p3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List F;
                F = s3.F(s9.l.this, obj);
                return F;
            }
        }).subscribe(new f());
    }

    public String G() {
        return this.f15522f;
    }

    public final i6.o0 H() {
        return this.f15518b;
    }

    public final void I(int i10) {
        i.c cVar = w6.i.f19214g;
        Observable compose = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", 100, 1, null, null)).compose(this.f15517a.O1());
        final g gVar = g.f15538a;
        Observable map = compose.map(new Function() { // from class: k6.q3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List J;
                J = s3.J(s9.l.this, obj);
                return J;
            }
        });
        final h hVar = h.f15539a;
        map.map(new Function() { // from class: k6.r3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List K;
                K = s3.K(s9.l.this, obj);
                return K;
            }
        }).subscribe(new i());
    }

    public final void L() {
        final t9.u uVar = new t9.u();
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.i3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                s3.M(t9.u.this, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.b());
        final j jVar = new j(uVar);
        compose.subscribe(new Consumer() { // from class: k6.j3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                s3.N(s9.l.this, obj);
            }
        });
    }

    public final void O(SearchByNameResult searchByNameResult, String str) {
        int totalSize;
        if (t9.i.b(str, this.f15518b.X())) {
            if (searchByNameResult.getData() != null) {
                SearchData data = searchByNameResult.getData();
                t9.i.d(data);
                if (com.mobile.brasiltv.utils.b0.I(data.getSearchItemList())) {
                    SearchData data2 = searchByNameResult.getData();
                    t9.i.d(data2);
                    if (data2.getTotalSize() % this.f15519c == 0) {
                        SearchData data3 = searchByNameResult.getData();
                        t9.i.d(data3);
                        totalSize = data3.getTotalSize() / this.f15519c;
                    } else {
                        SearchData data4 = searchByNameResult.getData();
                        t9.i.d(data4);
                        totalSize = (data4.getTotalSize() / this.f15519c) + 1;
                    }
                    this.f15521e = totalSize;
                    ArrayList arrayList = new ArrayList();
                    SearchData data5 = searchByNameResult.getData();
                    t9.i.d(data5);
                    Iterator<T> it = data5.getSearchItemList().iterator();
                    while (it.hasNext()) {
                        List<SearchShelveItem> itemList = ((SearchItem) it.next()).getItemList();
                        t9.i.d(itemList);
                        Iterator<T> it2 = itemList.iterator();
                        while (it2.hasNext()) {
                            arrayList.add((SearchShelveItem) it2.next());
                        }
                    }
                    if (com.mobile.brasiltv.utils.b0.I(arrayList)) {
                        this.f15520d++;
                        this.f15518b.a1(arrayList, str, this.f15524h);
                        return;
                    } else if (this.f15520d != 1) {
                        this.f15518b.j0();
                        return;
                    } else {
                        this.f15518b.h0(8);
                        this.f15518b.C2(str);
                        return;
                    }
                }
            }
            this.f15518b.C2(str);
        }
    }

    public void P() {
        this.f15526j = (this.f15526j + 1) % this.f15528l;
        List list = this.f15529m;
        int size = list != null ? list.size() : 0;
        int i10 = this.f15526j;
        int i11 = this.f15527k;
        int i12 = i10 * i11;
        int i13 = i11 + i12;
        if (size == 0 || i12 >= size) {
            return;
        }
        if (i13 <= size) {
            size = i13;
        }
        i6.o0 o0Var = this.f15518b;
        List list2 = this.f15529m;
        t9.i.d(list2);
        o0Var.F0(i12, list2.subList(i12, size));
    }

    public void Q(final String str) {
        t9.i.g(str, "searchKey");
        if (str.length() == 0) {
            return;
        }
        Schedulers.computation().createWorker().schedule(new Runnable() { // from class: k6.k3
            @Override // java.lang.Runnable
            public final void run() {
                s3.R(s3.this, str);
            }
        });
    }

    public void S(String str) {
        t9.i.g(str, "searchKey");
        if (TextUtils.isEmpty(str)) {
            this.f15518b.x0();
            return;
        }
        if (ba.t.W(str).toString().length() == 0) {
            return;
        }
        if (!y()) {
            this.f15518b.j0();
            return;
        }
        if (!t9.i.b(G(), str)) {
            V(str);
            this.f15524h = true;
            this.f15520d = 1;
            this.f15521e = 1;
            T(str, 1);
            return;
        }
        int i10 = this.f15520d;
        if (i10 > this.f15521e) {
            this.f15518b.j0();
        } else {
            this.f15524h = false;
            T(str, i10);
        }
    }

    public final void T(String str, int i10) {
        Disposable disposable;
        Disposable disposable2 = this.f15525i;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f15525i) != null) {
            disposable.dispose();
        }
        i.c cVar = w6.i.f19214g;
        cVar.b().i2(new SearchByNameBean(cVar.J(), cVar.H(), cVar.v(), null, str, "1", Integer.valueOf(this.f15519c), Integer.valueOf(i10), null)).compose(this.f15517a.O1()).subscribe(new k(str));
        com.mobile.brasiltv.utils.i1.o(this.f15517a, str);
    }

    public final void U(boolean z10) {
        this.f15523g = z10;
    }

    public void V(String str) {
        t9.i.g(str, "<set-?>");
        this.f15522f = str;
    }

    public final void W(Disposable disposable) {
        this.f15525i = disposable;
    }

    @Override // l5.a
    public void e() {
        L();
    }

    @Override // l5.a
    public void g() {
    }

    public final boolean y() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f15530n <= 500) {
            return false;
        }
        this.f15530n = currentTimeMillis;
        return true;
    }

    public final f5.c z() {
        return this.f15517a;
    }
}
