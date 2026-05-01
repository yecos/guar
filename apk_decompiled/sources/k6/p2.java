package k6;

import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.db.VodDao;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class p2 implements i6.h0 {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15475a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.i0 f15476b;

    /* renamed from: c, reason: collision with root package name */
    public VodDao f15477c;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            t9.i.g(obj, "it");
            if (!(obj instanceof Album)) {
                return Boolean.FALSE;
            }
            Album album = (Album) obj;
            if (album.isSelect()) {
                VodDao w10 = p2.this.w();
                String contentId = album.getContentId();
                if (contentId == null) {
                    contentId = "";
                }
                w10.deleteByAlbum(contentId, album.getTypeId());
            }
            return Boolean.valueOf(!album.isSelect());
        }
    }

    public static final class b extends t9.j implements s9.p {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15479a = new b();

        public b() {
            super(2);
        }

        public final void b(ArrayList arrayList, Object obj) {
            t9.i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.db.Album");
            arrayList.add((Album) obj);
        }

        @Override // s9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, obj2);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return h9.t.f14242a;
        }

        public final void invoke(ArrayList arrayList) {
            k7.f.c("删除历史数据成功!", new Object[0]);
            p2.this.v().z2();
            t9.i.f(arrayList, "it");
            if (!arrayList.isEmpty()) {
                p2.this.v().F(arrayList);
            } else {
                p2.this.v().l();
            }
        }
    }

    public static final class d extends t9.j implements s9.l {
        public d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除历史数据失败!", new Object[0]);
            th.printStackTrace();
            p2.this.v().p2();
        }
    }

    public static final class e extends t9.j implements s9.l {
        public e() {
            super(1);
        }

        public final void b(List list) {
            t9.i.f(list, "it");
            if (!list.isEmpty()) {
                p2.this.v().F(list);
            } else {
                k7.f.c("无历史记录，不展示", new Object[0]);
                p2.this.v().l();
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f14242a;
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f15483a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("查询历史数据失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class g implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return j9.a.a(((Album) obj2).getSaveTime(), ((Album) obj).getSaveTime());
        }
    }

    public p2(f5.c cVar, i6.i0 i0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(i0Var, "view");
        this.f15475a = cVar;
        this.f15476b = i0Var;
        i0Var.Y0(this);
        this.f15477c = new VodDao(cVar);
    }

    public static final void A(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ArrayList r() {
        return new ArrayList();
    }

    public static final void s(s9.p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final void t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(p2 p2Var, ObservableEmitter observableEmitter) {
        t9.i.g(p2Var, "this$0");
        t9.i.g(observableEmitter, "it");
        List<Album> queryAllRecord = p2Var.f15477c.queryAllRecord();
        List C = i9.r.C(queryAllRecord, new g());
        if (!C.isEmpty()) {
            queryAllRecord = new ArrayList<>(C);
        }
        observableEmitter.onNext(queryAllRecord);
    }

    public static final void z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void p(ArrayList arrayList) {
        t9.i.g(arrayList, "dataList");
        if (arrayList.isEmpty()) {
            return;
        }
        Observable fromIterable = Observable.fromIterable(arrayList);
        final a aVar = new a();
        Observable filter = fromIterable.filter(new Predicate() { // from class: k6.h2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean q10;
                q10 = p2.q(s9.l.this, obj);
                return q10;
            }
        });
        Callable callable = new Callable() { // from class: k6.i2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ArrayList r10;
                r10 = p2.r();
                return r10;
            }
        };
        final b bVar = b.f15479a;
        Single observeOn = filter.collect(callable, new BiConsumer() { // from class: k6.j2
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                p2.s(s9.p.this, obj, obj2);
            }
        }).compose(this.f15475a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final c cVar = new c();
        Consumer consumer = new Consumer() { // from class: k6.k2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p2.t(s9.l.this, obj);
            }
        };
        final d dVar = new d();
        observeOn.subscribe(consumer, new Consumer() { // from class: k6.l2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p2.u(s9.l.this, obj);
            }
        });
    }

    public final i6.i0 v() {
        return this.f15476b;
    }

    public final VodDao w() {
        return this.f15477c;
    }

    public void x() {
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: k6.m2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                p2.y(p2.this, observableEmitter);
            }
        }).compose(this.f15475a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final e eVar = new e();
        Consumer consumer = new Consumer() { // from class: k6.n2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p2.z(s9.l.this, obj);
            }
        };
        final f fVar = f.f15483a;
        observeOn.subscribe(consumer, new Consumer() { // from class: k6.o2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                p2.A(s9.l.this, obj);
            }
        });
    }
}
