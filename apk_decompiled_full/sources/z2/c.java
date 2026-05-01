package z2;

import com.dcs.bean.DomainInfo;
import com.dcs.bean.V1Data;
import com.dcs.bean.V1Result;
import h9.h;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import retrofit2.HttpException;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final b f20149d = new b(null);

    /* renamed from: e, reason: collision with root package name */
    public static final h9.g f20150e = h.b(a.f20154a);

    /* renamed from: a, reason: collision with root package name */
    public final String f20151a = c.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final h9.g f20152b = h.b(C0352c.f20155a);

    /* renamed from: c, reason: collision with root package name */
    public final h9.g f20153c = h.b(new d());

    public static final class a extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f20154a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c invoke() {
            return new c();
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final c a() {
            return b();
        }

        public final c b() {
            return (c) c.f20150e.getValue();
        }
    }

    /* renamed from: z2.c$c, reason: collision with other inner class name */
    public static final class C0352c extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0352c f20155a = new C0352c();

        public C0352c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DomainInfo invoke() {
            return t2.a.f18798a.c();
        }
    }

    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x2.a invoke() {
            return new x2.a("https://" + c.this.e().getFirst(), "https://" + c.this.e().getSecond());
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f20157a = new e();

        public e() {
            super(1);
        }

        public final void b(V1Result v1Result) {
            t2.a aVar = t2.a.f18798a;
            i.f(v1Result, "it");
            aVar.s(v1Result);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((V1Result) obj);
            return t.f14242a;
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f20158a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(V1Result v1Result) {
            i.g(v1Result, "it");
            String i10 = t2.a.f18798a.i();
            return i10 == null ? "" : i10;
        }
    }

    public static final class g extends u2.a {
        public g() {
        }

        @Override // u2.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            Observable error;
            i.g(th, "it");
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (ba.t.o("304,500,404,400,506,401", String.valueOf(httpException.code()), false, 2, null)) {
                    if (httpException.code() == 304) {
                        String i10 = t2.a.f18798a.i();
                        if (i10 == null) {
                            i10 = "";
                        }
                        error = Observable.just(i10);
                    } else {
                        error = Observable.error(th);
                    }
                    i.f(error, "{\n                    if…      }\n                }");
                    return error;
                }
            }
            t2.a.f18798a.r(c.this.e().getFirst(), c.this.e().getSecond(), c.this.e().getDomainType());
            Observable error2 = Observable.error(th);
            i.f(error2, "{\n                    Do…ror(it)\n                }");
            return error2;
        }
    }

    public static final void h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final String i(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (String) lVar.invoke(obj);
    }

    public final DomainInfo e() {
        return (DomainInfo) this.f20152b.getValue();
    }

    public final x2.a f() {
        return (x2.a) this.f20153c.getValue();
    }

    public final Observable g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, String str9, String str10) {
        i.g(str, "sn");
        i.g(str2, "authCode");
        i.g(str3, "authVersion");
        i.g(str6, "appId");
        i.g(str7, "spkgVer");
        i.g(str8, "reserve1");
        Observable c10 = f().c(new V1Data("all", str, str2, str3, str4, str5, str6, String.valueOf(a3.j.f170a.a()), str7, str8, i10, str9, str10));
        final e eVar = e.f20157a;
        Observable doOnNext = c10.doOnNext(new Consumer() { // from class: z2.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                c.h(l.this, obj);
            }
        });
        final f fVar = f.f20158a;
        Observable observeOn = doOnNext.map(new Function() { // from class: z2.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String i11;
                i11 = c.i(l.this, obj);
                return i11;
            }
        }).onErrorResumeNext(new g()).observeOn(AndroidSchedulers.mainThread());
        i.f(observeOn, "fun v1(sn: String, authC…lers.mainThread())\n\n    }");
        return observeOn;
    }
}
