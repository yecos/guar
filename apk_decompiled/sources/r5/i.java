package r5;

import android.content.Context;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.d0;
import h9.t;
import i9.n;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.CdnListBeanResult;
import mobile.com.requestframe.utils.response.CdnUrl;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResult;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData;
import org.json.JSONObject;
import r5.i;
import s9.l;
import w6.i;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18524b;

    /* renamed from: c, reason: collision with root package name */
    public static long f18525c;

    /* renamed from: e, reason: collision with root package name */
    public static Context f18527e;

    /* renamed from: f, reason: collision with root package name */
    public static GetSlbInfoBeanResultData f18528f;

    /* renamed from: j, reason: collision with root package name */
    public static Disposable f18532j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f18533k;

    /* renamed from: a, reason: collision with root package name */
    public static final i f18523a = new i();

    /* renamed from: d, reason: collision with root package name */
    public static long f18526d = 1800;

    /* renamed from: g, reason: collision with root package name */
    public static androidx.collection.a f18529g = new androidx.collection.a();

    /* renamed from: h, reason: collision with root package name */
    public static androidx.collection.a f18530h = new androidx.collection.a();

    /* renamed from: i, reason: collision with root package name */
    public static HashMap f18531i = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public static String f18534l = "";

    public static final class a extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f18535a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(Long l10) {
            t9.i.g(l10, "it");
            Context context = i.f18527e;
            String str = null;
            if (context != null) {
                String g10 = na.f.g(context, "deviceTag");
                t9.i.f(g10, "deviceTag");
                if (g10.length() > 0) {
                    str = new JSONObject().put("deviceTag", g10).toString();
                }
            }
            i.c cVar = w6.i.f19214g;
            return cVar.b().R1(i9.j.c(cVar.v() + "_live"), str);
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f18536a = new b();

        public b() {
            super(1);
        }

        public final void b(GetSlbInfoBeanResult getSlbInfoBeanResult) {
            i iVar = i.f18523a;
            b0.U(iVar, "fetch slb success and handle result");
            t9.i.f(getSlbInfoBeanResult, "it");
            iVar.C(getSlbInfoBeanResult);
            iVar.D(getSlbInfoBeanResult);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetSlbInfoBeanResult) obj);
            return t.f14242a;
        }
    }

    public static final class c extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f18537a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0073 A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:3:0x000e, B:6:0x0018, B:12:0x006d, B:14:0x0073, B:21:0x007c, B:22:0x0031, B:32:0x004b, B:39:0x005e, B:42:0x0063, B:44:0x0067, B:45:0x0057, B:46:0x0051), top: B:2:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #0 {Exception -> 0x0080, blocks: (B:3:0x000e, B:6:0x0018, B:12:0x006d, B:14:0x0073, B:21:0x007c, B:22:0x0031, B:32:0x004b, B:39:0x005e, B:42:0x0063, B:44:0x0067, B:45:0x0057, B:46:0x0051), top: B:2:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void invoke(java.lang.Throwable r11) {
            /*
                r10 = this;
                r5.i r0 = r5.i.f18523a
                java.lang.String r1 = "fetch slb occur exception"
                com.mobile.brasiltv.utils.b0.U(r0, r1)
                r11.printStackTrace()
                r1 = 1
                r0.K(r1)
                boolean r2 = r11 instanceof retrofit2.HttpException     // Catch: java.lang.Exception -> L80
                java.lang.String r3 = ""
                java.lang.String r4 = "20900"
                java.lang.String r5 = "25500"
                if (r2 == 0) goto L4b
                r2 = r11
                retrofit2.HttpException r2 = (retrofit2.HttpException) r2     // Catch: java.lang.Exception -> L80
                int r2 = r2.code()     // Catch: java.lang.Exception -> L80
                r6 = 503(0x1f7, float:7.05E-43)
                r7 = 500(0x1f4, float:7.0E-43)
                r8 = 401(0x191, float:5.62E-43)
                r9 = 400(0x190, float:5.6E-43)
                if (r2 == r9) goto L31
                if (r2 == r8) goto L31
                if (r2 == r7) goto L31
                if (r2 == r6) goto L31
            L2f:
                r3 = r5
                goto L6d
            L31:
                retrofit2.HttpException r11 = (retrofit2.HttpException) r11     // Catch: java.lang.Exception -> L80
                int r11 = r11.code()     // Catch: java.lang.Exception -> L80
                if (r11 == r9) goto L48
                if (r11 == r8) goto L45
                if (r11 == r7) goto L42
                if (r11 == r6) goto L40
                goto L6d
            L40:
                r3 = r4
                goto L6d
            L42:
                java.lang.String r3 = "20700"
                goto L6d
            L45:
                java.lang.String r3 = "20800"
                goto L6d
            L48:
                java.lang.String r3 = "20600"
                goto L6d
            L4b:
                boolean r2 = r11 instanceof java.net.ConnectException     // Catch: java.lang.Exception -> L80
                if (r2 == 0) goto L51
                r2 = 1
                goto L53
            L51:
                boolean r2 = r11 instanceof java.net.SocketTimeoutException     // Catch: java.lang.Exception -> L80
            L53:
                if (r2 == 0) goto L57
                r2 = 1
                goto L59
            L57:
                boolean r2 = r11 instanceof java.util.concurrent.TimeoutException     // Catch: java.lang.Exception -> L80
            L59:
                if (r2 == 0) goto L5e
                java.lang.String r3 = "25100"
                goto L6d
            L5e:
                boolean r2 = r11 instanceof java.text.ParseException     // Catch: java.lang.Exception -> L80
                if (r2 == 0) goto L63
                goto L2f
            L63:
                boolean r2 = r11 instanceof mobile.com.requestframe.utils.bean.ResultException     // Catch: java.lang.Exception -> L80
                if (r2 == 0) goto L6d
                mobile.com.requestframe.utils.bean.ResultException r11 = (mobile.com.requestframe.utils.bean.ResultException) r11     // Catch: java.lang.Exception -> L80
                java.lang.String r3 = r11.getReturnCode()     // Catch: java.lang.Exception -> L80
            L6d:
                boolean r11 = android.text.TextUtils.isDigitsOnly(r3)     // Catch: java.lang.Exception -> L80
                if (r11 == 0) goto L7c
                java.lang.String r11 = "errCode"
                t9.i.f(r3, r11)     // Catch: java.lang.Exception -> L80
                r0.L(r3)     // Catch: java.lang.Exception -> L80
                goto L84
            L7c:
                r0.L(r4)     // Catch: java.lang.Exception -> L80
                goto L84
            L80:
                r11 = move-exception
                r11.printStackTrace()
            L84:
                boolean r11 = r5.i.i()
                if (r11 != 0) goto L99
                r5.i r11 = r5.i.f18523a
                java.lang.String r0 = "slb 请求失败重试"
                com.mobile.brasiltv.utils.b0.U(r11, r0)
                r2 = 300(0x12c, double:1.48E-321)
                r5.i.q(r2)
                r5.i.o(r11)
            L99:
                r5.i.p(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r5.i.c.invoke(java.lang.Throwable):void");
        }
    }

    public static final class d extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f18538a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "it");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CdnListBeanResult cdnListBeanResult = (CdnListBeanResult) it.next();
                String tag = cdnListBeanResult.getTag();
                if (t9.i.b(tag, k.LIVE.b())) {
                    arrayList.add(cdnListBeanResult);
                } else if (t9.i.b(tag, k.VOD.b())) {
                    arrayList2.add(cdnListBeanResult);
                } else if (t9.i.b(tag, k.RECORD.b())) {
                    arrayList3.add(cdnListBeanResult);
                }
            }
            return Observable.fromArray(arrayList, arrayList2, arrayList3);
        }
    }

    public static final class e extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f18539a = new e();

        public e() {
            super(1);
        }

        public static final int d(CdnListBeanResult cdnListBeanResult, CdnListBeanResult cdnListBeanResult2) {
            return t9.i.i(cdnListBeanResult.getSerial_number(), cdnListBeanResult2.getSerial_number());
        }

        @Override // s9.l
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "it");
            n.m(arrayList, new Comparator() { // from class: r5.j
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int d10;
                    d10 = i.e.d((CdnListBeanResult) obj, (CdnListBeanResult) obj2);
                    return d10;
                }
            });
            return arrayList;
        }
    }

    public static final class f extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f18540a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f14242a;
        }

        public final void invoke(ArrayList arrayList) {
            if (b0.G(arrayList)) {
                return;
            }
            String tag = ((CdnListBeanResult) arrayList.get(0)).getTag();
            b0.U(i.f18523a, "cdn type is " + tag + " and size is " + arrayList.size());
            i.f18529g.put(tag, arrayList);
            if (b0.I(((CdnListBeanResult) arrayList.get(0)).getUrl_list())) {
                ArrayList arrayList2 = new ArrayList();
                List<CdnUrl> url_list = ((CdnListBeanResult) arrayList.get(0)).getUrl_list();
                t9.i.d(url_list);
                for (CdnUrl cdnUrl : url_list) {
                    if (b0.H(cdnUrl.getUrl())) {
                        arrayList2.add(cdnUrl.getTag());
                    }
                }
                i.f18530h.put(tag, arrayList2);
                b0.U(i.f18523a, "cdn type is " + tag + " and tags is " + arrayList2);
            }
        }
    }

    public static final class g extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f18541a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
            i iVar = i.f18523a;
            b0.U(iVar, "update slb info occur exception");
            iVar.K(true);
        }
    }

    public static final ObservableSource F(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void G(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void N() {
        i iVar = f18523a;
        iVar.r(k.LIVE);
        iVar.r(k.VOD);
        b0.U(iVar, "update slb info finished");
        f18533k = true;
    }

    public static final ObservableSource O(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final ArrayList P(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ArrayList) lVar.invoke(obj);
    }

    public static final void Q(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void R(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final GetSlbInfoBeanResultData A() {
        return f18528f;
    }

    public final h9.k B() {
        GetSlbInfoBeanResultData getSlbInfoBeanResultData = f18528f;
        if (!b0.H(getSlbInfoBeanResultData != null ? getSlbInfoBeanResultData.getPlay_params() : null)) {
            return new h9.k("", "");
        }
        GetSlbInfoBeanResultData getSlbInfoBeanResultData2 = f18528f;
        t9.i.d(getSlbInfoBeanResultData2);
        String a10 = d0.a(getSlbInfoBeanResultData2.getPlay_params(), "svs_address");
        GetSlbInfoBeanResultData getSlbInfoBeanResultData3 = f18528f;
        t9.i.d(getSlbInfoBeanResultData3);
        return new h9.k(a10, d0.a(getSlbInfoBeanResultData3.getPlay_params(), "svs_address_spare"));
    }

    public final void C(GetSlbInfoBeanResult getSlbInfoBeanResult) {
        GetSlbInfoBeanResultData data = getSlbInfoBeanResult.getData();
        if (b0.J(data != null ? data.getInvalidTime() : null)) {
            return;
        }
        GetSlbInfoBeanResultData data2 = getSlbInfoBeanResult.getData();
        long Z = b0.Z(data2 != null ? data2.getInvalidTime() : null) - 600;
        f18525c = Z;
        f18524b = false;
        if (Z < 600) {
            f18525c = 600L;
        }
        t();
        E();
    }

    public final void D(GetSlbInfoBeanResult getSlbInfoBeanResult) {
        GetSlbInfoBeanResultData data = getSlbInfoBeanResult.getData();
        if (b0.Y(data != null ? data.getError_code() : null, 0) == 0) {
            GetSlbInfoBeanResultData data2 = getSlbInfoBeanResult.getData();
            List<CdnListBeanResult> cdn_list = data2 != null ? data2.getCdn_list() : null;
            if (!(cdn_list == null || cdn_list.isEmpty())) {
                GetSlbInfoBeanResultData data3 = getSlbInfoBeanResult.getData();
                t9.i.d(data3);
                M(data3);
                return;
            }
        }
        f18533k = true;
    }

    public final void E() {
        Observable<Long> timer = Observable.timer(f18525c, TimeUnit.SECONDS);
        final a aVar = a.f18535a;
        Observable<R> flatMap = timer.flatMap(new Function() { // from class: r5.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource F;
                F = i.F(l.this, obj);
                return F;
            }
        });
        final b bVar = b.f18536a;
        Consumer consumer = new Consumer() { // from class: r5.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i.G(l.this, obj);
            }
        };
        final c cVar = c.f18537a;
        f18532j = flatMap.subscribe(consumer, new Consumer() { // from class: r5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i.H(l.this, obj);
            }
        });
    }

    public final boolean I() {
        return f18533k;
    }

    public final void J() {
        f18526d = 1800L;
        f18525c = 0L;
        f18533k = false;
        f18529g.clear();
        f18531i.clear();
        f18530h.clear();
        t();
        f18527e = null;
        f18528f = null;
    }

    public final void K(boolean z10) {
        f18533k = z10;
    }

    public final void L(String str) {
        t9.i.g(str, "<set-?>");
        f18534l = str;
    }

    public final void M(GetSlbInfoBeanResultData getSlbInfoBeanResultData) {
        f18528f = getSlbInfoBeanResultData;
        f18529g.clear();
        f18531i.clear();
        f18530h.clear();
        q6.a aVar = q6.a.f18234a;
        Context context = f18527e;
        t9.i.d(context);
        aVar.b(context, getSlbInfoBeanResultData.getPlay_params());
        aVar.a();
        GetSlbInfoBeanResultData getSlbInfoBeanResultData2 = f18528f;
        t9.i.d(getSlbInfoBeanResultData2);
        Observable just = Observable.just(getSlbInfoBeanResultData2.getCdn_list());
        final d dVar = d.f18538a;
        Observable flatMap = just.flatMap(new Function() { // from class: r5.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource O;
                O = i.O(l.this, obj);
                return O;
            }
        });
        final e eVar = e.f18539a;
        Observable map = flatMap.map(new Function() { // from class: r5.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ArrayList P;
                P = i.P(l.this, obj);
                return P;
            }
        });
        final f fVar = f.f18540a;
        Consumer consumer = new Consumer() { // from class: r5.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i.Q(l.this, obj);
            }
        };
        final g gVar = g.f18541a;
        map.subscribe(consumer, new Consumer() { // from class: r5.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i.R(l.this, obj);
            }
        }, new Action() { // from class: r5.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                i.N();
            }
        });
    }

    public final void r(k kVar) {
        List<CdnListBeanResult> w10 = w(kVar);
        if (w10 == null || w10.isEmpty()) {
            return;
        }
        for (CdnListBeanResult cdnListBeanResult : w10) {
            if (b0.K(cdnListBeanResult.getMain_addr())) {
                HashMap hashMap = f18531i;
                String main_addr = cdnListBeanResult.getMain_addr();
                t9.i.d(main_addr);
                String main_addr_mark = cdnListBeanResult.getMain_addr_mark();
                if (main_addr_mark == null) {
                    main_addr_mark = "";
                }
                hashMap.put(main_addr, main_addr_mark);
                b0.U(f18523a, "assemble live main server mark and server is " + cdnListBeanResult.getMain_addr() + " and server mark is " + cdnListBeanResult.getMain_addr_mark());
            }
            if (b0.K(cdnListBeanResult.getSpared_addr())) {
                HashMap hashMap2 = f18531i;
                String spared_addr = cdnListBeanResult.getSpared_addr();
                t9.i.d(spared_addr);
                String spared_addr_mark = cdnListBeanResult.getSpared_addr_mark();
                hashMap2.put(spared_addr, spared_addr_mark != null ? spared_addr_mark : "");
                b0.U(f18523a, "assemble live backup server mark and server is " + cdnListBeanResult.getSpared_addr() + " and server mark is " + cdnListBeanResult.getSpared_addr_mark());
            }
        }
    }

    public final void s(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        f18527e = context.getApplicationContext();
    }

    public final void t() {
        Disposable disposable;
        Disposable disposable2 = f18532j;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = f18532j) != null) {
            disposable.dispose();
        }
        f18532j = null;
    }

    public final void u() {
        f18529g.clear();
        f18531i.clear();
        f18530h.clear();
    }

    public final void v() {
        f18525c = 0L;
        f18526d = 1800L;
        f18533k = false;
        f18524b = false;
        t();
        E();
    }

    public final List w(k kVar) {
        t9.i.g(kVar, "cdnType");
        return (List) f18529g.get(kVar.b());
    }

    public final List x(k kVar) {
        t9.i.g(kVar, "cdnType");
        return (List) f18530h.get(kVar.b());
    }

    public final String y(String str) {
        t9.i.g(str, "server");
        String str2 = (String) f18531i.get(str);
        return str2 == null ? "" : str2;
    }

    public final String z() {
        return f18534l;
    }
}
