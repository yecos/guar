package k6;

import android.text.TextUtils;
import com.mobile.brasiltv.bean.SearchBean;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SearchLiveHistory;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.Channel;

/* loaded from: classes3.dex */
public final class h3 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15270a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.m0 f15271b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f15272c;

    /* renamed from: d, reason: collision with root package name */
    public final h9.g f15273d;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15274a = new a();

        public a() {
            super(1);
        }

        public final void b(Channel channel) {
            k7.f.e("增加搜索历史记录成功！", new Object[0]);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15275a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("增加搜索历史记录失败！", new Object[0]);
        }
    }

    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            k7.f.c("删除搜索历史记录成功！", new Object[0]);
            h3.this.F().l();
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f15277a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除搜索历史记录失败！", new Object[0]);
        }
    }

    public static final class e extends t9.j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MobileDao invoke() {
            return new MobileDao(h3.this.D());
        }
    }

    public static final class f extends t9.j implements s9.l {
        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return h9.t.f14242a;
        }

        public final void invoke(ArrayList arrayList) {
            t9.i.f(arrayList, "it");
            if (!arrayList.isEmpty()) {
                h3.this.F().y2(arrayList);
            } else {
                k7.f.c("无搜索历史记录，不展示", new Object[0]);
                h3.this.F().l();
            }
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f15280a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("查询搜索历史数据失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15281a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(1);
            this.f15281a = str;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Channel channel) {
            t9.i.g(channel, "it");
            return Boolean.valueOf(this.f15281a.length() <= channel.getName().length());
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15282a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f15283b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, t9.w wVar) {
            super(1);
            this.f15282a = str;
            this.f15283b = wVar;
        }

        public final void b(Channel channel) {
            int y10 = ba.t.y(channel.getName(), this.f15282a, 0, true, 2, null);
            if (y10 != -1) {
                ArrayList arrayList = (ArrayList) this.f15283b.f18961a;
                t9.i.f(channel, "it");
                arrayList.add(new SearchBean(y10, channel));
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f14242a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final j f15284a = new j();

        public j() {
            super(1);
        }

        public final void b(Channel channel) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f14242a;
        }
    }

    public static final class k extends t9.j implements s9.l {
        public k() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("搜索失败", new Object[0]);
            th.printStackTrace();
            h3.this.F().showLoading(false);
            h3.this.F().N();
        }
    }

    public h3(f5.c cVar, i6.m0 m0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(m0Var, "view");
        this.f15270a = cVar;
        this.f15271b = m0Var;
        this.f15273d = h9.h.b(new e());
    }

    public static final void A(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void B(h3 h3Var, ObservableEmitter observableEmitter) {
        t9.i.g(h3Var, "this$0");
        t9.i.g(observableEmitter, "it");
        h3Var.E().deleteAllSearchLiveHistory();
        observableEmitter.onNext("");
    }

    public static final void C(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(h3 h3Var, ObservableEmitter observableEmitter) {
        t9.i.g(h3Var, "this$0");
        t9.i.g(observableEmitter, "it");
        List<SearchLiveHistory> queryAllSearchLiveHistory = h3Var.E().queryAllSearchLiveHistory();
        if (!(!queryAllSearchLiveHistory.isEmpty())) {
            observableEmitter.onNext(new ArrayList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Iterator<SearchLiveHistory> it = queryAllSearchLiveHistory.iterator(); it.hasNext(); it = it) {
            SearchLiveHistory next = it.next();
            arrayList.add(new Channel(next.getChannelCode(), next.getName(), next.getAlias(), 0, null, null, null, null, null, null, null));
        }
        observableEmitter.onNext(arrayList);
    }

    public static final void I(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void J(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean L(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void M(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void N(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void O(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P(t9.w wVar, h3 h3Var) {
        t9.i.g(wVar, "$searchResult");
        t9.i.g(h3Var, "this$0");
        k7.f.d("搜索成功 " + ((ArrayList) wVar.f18961a).size(), new Object[0]);
        h3Var.f15271b.showLoading(false);
        if (!(!((Collection) wVar.f18961a).isEmpty())) {
            h3Var.f15271b.N();
        } else {
            i9.n.l((List) wVar.f18961a);
            h3Var.f15271b.R1((ArrayList) wVar.f18961a);
        }
    }

    public static final void w(Channel channel, h3 h3Var, ObservableEmitter observableEmitter) {
        t9.i.g(channel, "$channel");
        t9.i.g(h3Var, "this$0");
        t9.i.g(observableEmitter, "it");
        SearchLiveHistory searchLiveHistory = new SearchLiveHistory();
        searchLiveHistory.setChannelCode(channel.getChannelCode());
        searchLiveHistory.setName(channel.getName());
        searchLiveHistory.setAlias(channel.getAlias());
        h3Var.E().addSearchLiveHistory(searchLiveHistory);
        observableEmitter.onNext(channel);
    }

    public static final void x(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final f5.c D() {
        return this.f15270a;
    }

    public final MobileDao E() {
        return (MobileDao) this.f15273d.getValue();
    }

    public final i6.m0 F() {
        return this.f15271b;
    }

    public void G() {
        Disposable disposable;
        Disposable disposable2 = this.f15272c;
        boolean z10 = false;
        if (disposable2 != null && disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f15272c) != null) {
            disposable.dispose();
        }
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: k6.t2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                h3.H(h3.this, observableEmitter);
            }
        }).compose(this.f15270a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final f fVar = new f();
        Consumer consumer = new Consumer() { // from class: k6.y2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.I(s9.l.this, obj);
            }
        };
        final g gVar = g.f15280a;
        observeOn.subscribe(consumer, new Consumer() { // from class: k6.z2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.J(s9.l.this, obj);
            }
        });
    }

    public void K(String str, List list) {
        t9.i.g(str, "keyWord");
        t9.i.g(list, "allChannelList");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Disposable disposable = this.f15272c;
        if (disposable != null && disposable.isDisposed()) {
            Disposable disposable2 = this.f15272c;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f15271b.showLoading(false);
        }
        this.f15271b.showLoading(true);
        if (!com.mobile.brasiltv.utils.b0.I(list)) {
            this.f15271b.showLoading(false);
            return;
        }
        final t9.w wVar = new t9.w();
        wVar.f18961a = new ArrayList();
        Observable compose = Observable.fromIterable(list).compose(this.f15270a.O1());
        final h hVar = new h(str);
        Observable filter = compose.filter(new Predicate() { // from class: k6.a3
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean L;
                L = h3.L(s9.l.this, obj);
                return L;
            }
        });
        final i iVar = new i(str, wVar);
        Observable observeOn = filter.doOnNext(new Consumer() { // from class: k6.b3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.M(s9.l.this, obj);
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
        final j jVar = j.f15284a;
        Consumer consumer = new Consumer() { // from class: k6.c3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.N(s9.l.this, obj);
            }
        };
        final k kVar = new k();
        this.f15272c = observeOn.subscribe(consumer, new Consumer() { // from class: k6.d3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.O(s9.l.this, obj);
            }
        }, new Action() { // from class: k6.e3
            @Override // io.reactivex.functions.Action
            public final void run() {
                h3.P(t9.w.this, this);
            }
        });
    }

    @Override // l5.a
    public void e() {
        G();
    }

    @Override // l5.a
    public void g() {
        Disposable disposable;
        Disposable disposable2 = this.f15272c;
        boolean z10 = false;
        if (disposable2 != null && disposable2.isDisposed()) {
            z10 = true;
        }
        if (!z10 || (disposable = this.f15272c) == null) {
            return;
        }
        disposable.dispose();
    }

    public void v(final Channel channel) {
        t9.i.g(channel, "channel");
        Observable subscribeOn = Observable.create(new ObservableOnSubscribe() { // from class: k6.v2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                h3.w(Channel.this, this, observableEmitter);
            }
        }).compose(this.f15270a.O1()).subscribeOn(Schedulers.io());
        final a aVar = a.f15274a;
        Consumer consumer = new Consumer() { // from class: k6.w2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.x(s9.l.this, obj);
            }
        };
        final b bVar = b.f15275a;
        subscribeOn.subscribe(consumer, new Consumer() { // from class: k6.x2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.y(s9.l.this, obj);
            }
        });
    }

    public void z() {
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: k6.f3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                h3.B(h3.this, observableEmitter);
            }
        }).compose(this.f15270a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final c cVar = new c();
        Consumer consumer = new Consumer() { // from class: k6.g3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.C(s9.l.this, obj);
            }
        };
        final d dVar = d.f15277a;
        observeOn.subscribe(consumer, new Consumer() { // from class: k6.u2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                h3.A(s9.l.this, obj);
            }
        });
    }
}
