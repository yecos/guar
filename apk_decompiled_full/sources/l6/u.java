package l6;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import l6.u;
import mobile.com.requestframe.utils.response.GetLiveData;
import mobile.com.requestframe.utils.response.GetLiveDataResult;

/* loaded from: classes3.dex */
public final class u implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16175a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.e f16176b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16178b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10) {
            super(1);
            this.f16178b = i10;
        }

        public final void b(GetLiveDataResult getLiveDataResult) {
            GetLiveData data = getLiveDataResult.getData();
            t9.i.d(data);
            if (!TextUtils.isEmpty(data.getDataVersion())) {
                com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
                Context context = u.this.i().getContext();
                t9.i.d(context);
                String str = "DATA_VERSION" + this.f16178b;
                GetLiveData data2 = getLiveDataResult.getData();
                t9.i.d(data2);
                n0Var.j(context, str, data2.getDataVersion());
            }
            GetLiveData data3 = getLiveDataResult.getData();
            t9.i.d(data3);
            if (!TextUtils.isEmpty(data3.getExpireTimeStr())) {
                com.mobile.brasiltv.utils.n0 n0Var2 = com.mobile.brasiltv.utils.n0.f8733a;
                Context context2 = u.this.i().getContext();
                t9.i.d(context2);
                String str2 = "EXPIRE_TIME" + this.f16178b;
                GetLiveData data4 = getLiveDataResult.getData();
                t9.i.d(data4);
                n0Var2.j(context2, str2, data4.getExpireTimeStr());
            }
            String json = new Gson().toJson(getLiveDataResult);
            if (TextUtils.isEmpty(json)) {
                return;
            }
            com.mobile.brasiltv.utils.b0.U(u.this, "请求成功，缓存节目单");
            na.f.m(u.this.i().getContext(), String.valueOf(this.f16178b), String.valueOf(this.f16178b), json);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetLiveDataResult) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16180b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f16181c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f16182a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u f16183b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f16184c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ t9.w f16185d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z10, u uVar, int i10, t9.w wVar) {
                super(1);
                this.f16182a = z10;
                this.f16183b = uVar;
                this.f16184c = i10;
                this.f16185d = wVar;
            }

            public final void b(GetLiveData getLiveData) {
                if (this.f16182a) {
                    this.f16183b.j().G(getLiveData.getChannelList(), this.f16184c);
                } else {
                    this.f16183b.j().g(getLiveData.getChannelList(), this.f16184c);
                }
                Disposable disposable = (Disposable) this.f16185d.f18961a;
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

        /* renamed from: l6.u$b$b, reason: collision with other inner class name */
        public static final class C0281b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0281b f16186a = new C0281b();

            public C0281b() {
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
            public final /* synthetic */ String f16187a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f16187a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16187a, yVar.f(), null, 4, null);
                com.mobile.brasiltv.utils.f1.f8649a.x(p10 + ' ' + w6.i.f19214g.H());
            }
        }

        public static final class d extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t9.w f16188a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(t9.w wVar) {
                super(1);
                this.f16188a = wVar;
            }

            public final void b(Disposable disposable) {
                this.f16188a.f18961a = disposable;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((Disposable) obj);
                return h9.t.f14242a;
            }
        }

        public b(int i10, boolean z10) {
            this.f16180b = i10;
            this.f16181c = z10;
        }

        public static final void l(String str, b bVar, u uVar, int i10, ObservableEmitter observableEmitter) {
            t9.i.g(str, "$returnCode");
            t9.i.g(bVar, "this$0");
            t9.i.g(uVar, "this$1");
            t9.i.g(observableEmitter, "it");
            if (t9.i.b(str, "304")) {
                com.mobile.brasiltv.utils.b0.U(bVar, "节目单有缓存");
                if (uVar.i().getContext() != null) {
                    String h10 = na.f.h(uVar.i().getContext(), String.valueOf(i10), String.valueOf(i10));
                    if (TextUtils.isEmpty(h10)) {
                        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
                        Context context = uVar.i().getContext();
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

        public static final void o(u uVar, String str) {
            t9.i.g(uVar, "this$0");
            t9.i.g(str, "$returnCode");
            Context context = uVar.i().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new c(str));
            }
            uVar.j().onError();
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
                    if (this.f16181c) {
                        j6.e j10 = u.this.j();
                        GetLiveData data2 = getLiveDataResult.getData();
                        t9.i.d(data2);
                        j10.G(data2.getChannelList(), this.f16180b);
                        return;
                    }
                    j6.e j11 = u.this.j();
                    GetLiveData data3 = getLiveDataResult.getData();
                    t9.i.d(data3);
                    j11.g(data3.getChannelList(), this.f16180b);
                    return;
                }
            }
            u.this.j().onError();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            u.this.j().onLoading();
        }

        @Override // ha.a
        public void showErrorHint(final String str) {
            t9.i.g(str, "returnCode");
            t9.w wVar = new t9.w();
            final u uVar = u.this;
            final int i10 = this.f16180b;
            Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: l6.v
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    u.b.l(str, this, uVar, i10, observableEmitter);
                }
            }).compose(com.mobile.brasiltv.utils.p0.b()).compose(u.this.i().O2());
            final a aVar = new a(this.f16181c, u.this, this.f16180b, wVar);
            Consumer consumer = new Consumer() { // from class: l6.w
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    u.b.m(s9.l.this, obj);
                }
            };
            final C0281b c0281b = C0281b.f16186a;
            Consumer<? super Throwable> consumer2 = new Consumer() { // from class: l6.x
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    u.b.n(s9.l.this, obj);
                }
            };
            final u uVar2 = u.this;
            Action action = new Action() { // from class: l6.y
                @Override // io.reactivex.functions.Action
                public final void run() {
                    u.b.o(u.this, str);
                }
            };
            final d dVar = new d(wVar);
            compose.subscribe(consumer, consumer2, action, new Consumer() { // from class: l6.z
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    u.b.p(s9.l.this, obj);
                }
            });
        }
    }

    public u(b6.f fVar, j6.e eVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(eVar, "view");
        this.f16175a = fVar;
        this.f16176b = eVar;
    }

    public static final void l(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final b6.f i() {
        return this.f16175a;
    }

    public final j6.e j() {
        return this.f16176b;
    }

    public void k(int i10, boolean z10) {
        w6.i b10 = w6.i.f19214g.b();
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        Context context = this.f16175a.getContext();
        t9.i.d(context);
        String f10 = com.mobile.brasiltv.utils.n0.f(n0Var, context, "DATA_VERSION" + i10, null, 4, null);
        Context context2 = this.f16175a.getContext();
        t9.i.d(context2);
        Observable compose = b10.z1(i10, f10, com.mobile.brasiltv.utils.n0.f(n0Var, context2, "EXPIRE_TIME" + i10, null, 4, null)).compose(this.f16175a.O2());
        final a aVar = new a(i10);
        compose.doOnNext(new Consumer() { // from class: l6.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                u.l(s9.l.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(i10, z10));
    }
}
