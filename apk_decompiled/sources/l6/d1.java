package l6;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import l6.d1;
import mobile.com.requestframe.utils.response.EpgResultData;
import mobile.com.requestframe.utils.response.GetLiveData;
import mobile.com.requestframe.utils.response.GetLiveDataResult;
import mobile.com.requestframe.utils.response.JsonEpgResult;

/* loaded from: classes3.dex */
public final class d1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f15965a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.r f15966b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f15967c;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15969b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10) {
            super(1);
            this.f15969b = i10;
        }

        public final void b(GetLiveDataResult getLiveDataResult) {
            GetLiveData data = getLiveDataResult.getData();
            t9.i.d(data);
            if (!TextUtils.isEmpty(data.getDataVersion())) {
                com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
                Context context = d1.this.l().getContext();
                t9.i.d(context);
                String str = "DATA_VERSION" + this.f15969b;
                GetLiveData data2 = getLiveDataResult.getData();
                t9.i.d(data2);
                n0Var.j(context, str, data2.getDataVersion());
            }
            GetLiveData data3 = getLiveDataResult.getData();
            t9.i.d(data3);
            if (!TextUtils.isEmpty(data3.getExpireTimeStr())) {
                com.mobile.brasiltv.utils.n0 n0Var2 = com.mobile.brasiltv.utils.n0.f8733a;
                Context context2 = d1.this.l().getContext();
                t9.i.d(context2);
                String str2 = "EXPIRE_TIME" + this.f15969b;
                GetLiveData data4 = getLiveDataResult.getData();
                t9.i.d(data4);
                n0Var2.j(context2, str2, data4.getExpireTimeStr());
            }
            String json = new Gson().toJson(getLiveDataResult);
            if (TextUtils.isEmpty(json)) {
                return;
            }
            com.mobile.brasiltv.utils.b0.U(d1.this, "请求成功，缓存节目单");
            na.f.m(d1.this.l().getContext(), String.valueOf(this.f15969b), String.valueOf(this.f15969b), json);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetLiveDataResult) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15971b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f15972c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f15973a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d1 f15974b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f15975c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ t9.w f15976d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z10, d1 d1Var, int i10, t9.w wVar) {
                super(1);
                this.f15973a = z10;
                this.f15974b = d1Var;
                this.f15975c = i10;
                this.f15976d = wVar;
            }

            public final void b(GetLiveData getLiveData) {
                if (this.f15973a) {
                    this.f15974b.m().G(getLiveData.getChannelList(), this.f15975c);
                }
                Disposable disposable = (Disposable) this.f15976d.f18961a;
                if (disposable != null) {
                    disposable.dispose();
                }
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((GetLiveData) obj);
                return h9.t.f14242a;
            }
        }

        /* renamed from: l6.d1$b$b, reason: collision with other inner class name */
        public static final class C0276b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0276b f15977a = new C0276b();

            public C0276b() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return h9.t.f14242a;
            }

            public final void invoke(Throwable th) {
                th.printStackTrace();
            }
        }

        public static final class c extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15978a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f15978a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String p10 = com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15978a, null, null, 6, null);
                com.mobile.brasiltv.utils.f1.f8649a.x(p10 + ' ' + w6.i.f19214g.H());
            }
        }

        public static final class d extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t9.w f15979a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(t9.w wVar) {
                super(1);
                this.f15979a = wVar;
            }

            public final void b(Disposable disposable) {
                this.f15979a.f18961a = disposable;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((Disposable) obj);
                return h9.t.f14242a;
            }
        }

        public b(int i10, boolean z10) {
            this.f15971b = i10;
            this.f15972c = z10;
        }

        public static final void l(String str, b bVar, d1 d1Var, int i10, ObservableEmitter observableEmitter) {
            t9.i.g(str, "$returnCode");
            t9.i.g(bVar, "this$0");
            t9.i.g(d1Var, "this$1");
            t9.i.g(observableEmitter, "it");
            if (t9.i.b(str, "304")) {
                com.mobile.brasiltv.utils.b0.U(bVar, "节目单有缓存");
                if (d1Var.l().getContext() != null) {
                    String h10 = na.f.h(d1Var.l().getContext(), String.valueOf(i10), String.valueOf(i10));
                    if (TextUtils.isEmpty(h10)) {
                        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
                        Context context = d1Var.l().getContext();
                        t9.i.d(context);
                        n0Var.k(context, new String[]{"DATA_VERSION" + i10, "EXPIRE_TIME" + i10}, new String[]{"", ""});
                    } else {
                        GetLiveDataResult getLiveDataResult = (GetLiveDataResult) new Gson().fromJson(h10, GetLiveDataResult.class);
                        if (getLiveDataResult.getData() != null) {
                            GetLiveData data = getLiveDataResult.getData();
                            t9.i.d(data);
                            observableEmitter.onNext(data);
                        }
                    }
                }
            }
            observableEmitter.onComplete();
        }

        public static final void m(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void n(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void o(d1 d1Var, String str) {
            t9.i.g(d1Var, "this$0");
            t9.i.g(str, "$returnCode");
            Context context = d1Var.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new c(str));
            }
        }

        public static final void p(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onNext(GetLiveDataResult getLiveDataResult) {
            t9.i.g(getLiveDataResult, "it");
            if (getLiveDataResult.getData() != null) {
                GetLiveData data = getLiveDataResult.getData();
                t9.i.d(data);
                if (com.mobile.brasiltv.utils.b0.I(data.getChannelList())) {
                    com.mobile.brasiltv.utils.b0.U(this, "节目单无缓存");
                    if (this.f15972c) {
                        i6.r m10 = d1.this.m();
                        GetLiveData data2 = getLiveDataResult.getData();
                        t9.i.d(data2);
                        m10.G(data2.getChannelList(), this.f15971b);
                    }
                }
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }

        @Override // ha.a
        public void showErrorHint(final String str) {
            t9.i.g(str, "returnCode");
            t9.w wVar = new t9.w();
            final d1 d1Var = d1.this;
            final int i10 = this.f15971b;
            Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.e1
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    d1.b.l(str, this, d1Var, i10, observableEmitter);
                }
            }).compose(com.mobile.brasiltv.utils.p0.b()).compose(d1.this.l().O2());
            final a aVar = new a(this.f15972c, d1.this, this.f15971b, wVar);
            Consumer consumer = new Consumer() { // from class: l6.f1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    d1.b.m(s9.l.this, obj);
                }
            };
            final C0276b c0276b = C0276b.f15977a;
            Consumer<? super Throwable> consumer2 = new Consumer() { // from class: l6.g1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    d1.b.n(s9.l.this, obj);
                }
            };
            final d1 d1Var2 = d1.this;
            Action action = new Action() { // from class: l6.h1
                @Override // io.reactivex.functions.Action
                public final void run() {
                    d1.b.o(d1.this, str);
                }
            };
            final d dVar = new d(wVar);
            compose.subscribe(consumer, consumer2, action, new Consumer() { // from class: l6.i1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    d1.b.p(s9.l.this, obj);
                }
            });
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f15980a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(Long l10) {
            t9.i.g(l10, "it");
            return w6.i.f19214g.b().r1().c(s6.a.f18777a.a().g());
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f15981a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return h9.t.f14242a;
        }

        public final void invoke(ArrayList arrayList) {
            b6.r0.A.e().clear();
            t9.i.f(arrayList, "it");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JsonEpgResult jsonEpgResult = (JsonEpgResult) it.next();
                if (com.mobile.brasiltv.utils.b0.I(jsonEpgResult.getContents())) {
                    HashMap e10 = b6.r0.A.e();
                    String channelCode = jsonEpgResult.getChannelCode();
                    ArrayList<EpgResultData> contents = jsonEpgResult.getContents();
                    t9.i.d(contents);
                    e10.put(channelCode, contents);
                } else {
                    b6.r0.A.e().put(jsonEpgResult.getChannelCode(), new ArrayList());
                }
            }
        }
    }

    public static final class e implements Observer {
        public e() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList arrayList) {
            t9.i.g(arrayList, "t");
            d1.this.m().q2();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            d1.this.f15967c = disposable;
        }
    }

    public d1(b6.f fVar, i6.r rVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(rVar, "view");
        this.f15965a = fVar;
        this.f15966b = rVar;
    }

    public static final void o(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void r(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
        p();
    }

    @Override // l5.a
    public void g() {
        Disposable disposable = this.f15967c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final b6.f l() {
        return this.f15965a;
    }

    public final i6.r m() {
        return this.f15966b;
    }

    public void n(int i10, boolean z10) {
        w6.i b10 = w6.i.f19214g.b();
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        Context context = this.f15965a.getContext();
        t9.i.d(context);
        String f10 = com.mobile.brasiltv.utils.n0.f(n0Var, context, "DATA_VERSION" + i10, null, 4, null);
        Context context2 = this.f15965a.getContext();
        t9.i.d(context2);
        Observable compose = b10.z1(i10, f10, com.mobile.brasiltv.utils.n0.f(n0Var, context2, "EXPIRE_TIME" + i10, null, 4, null)).compose(this.f15965a.O2());
        final a aVar = new a(i10);
        compose.doOnNext(new Consumer() { // from class: l6.c1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                d1.o(s9.l.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(i10, z10));
    }

    public final void p() {
        Disposable disposable = this.f15967c;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> interval = Observable.interval(0L, 12L, TimeUnit.HOURS);
        final c cVar = c.f15980a;
        Observable<R> flatMap = interval.flatMap(new Function() { // from class: l6.a1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource q10;
                q10 = d1.q(s9.l.this, obj);
                return q10;
            }
        });
        final d dVar = d.f15981a;
        flatMap.doOnNext(new Consumer() { // from class: l6.b1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                d1.r(s9.l.this, obj);
            }
        }).subscribe(new e());
    }
}
