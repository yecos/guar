package s1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdInfoWrapper;
import com.advertlib.bean.AdReportBean;
import com.advertlib.bean.AdReportBeanWrapper;
import com.advertlib.bean.AdReportRequest;
import com.advertlib.bean.AdvertBean;
import com.advertlib.bean.AdvertPosition;
import com.advertlib.bean.AdvertResult;
import com.advertlib.bean.ReportResult;
import com.advertlib.bean.TimeInfoBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taobao.accs.utl.BaseMonitor;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
import okhttp3.Interceptor;
import s1.m;
import s2.d;
import v1.c;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static TimeInfoBean f18688c;

    /* renamed from: d, reason: collision with root package name */
    public static TimeInfoBean f18689d;

    /* renamed from: f, reason: collision with root package name */
    public static Disposable f18691f;

    /* renamed from: o, reason: collision with root package name */
    public static String f18700o;

    /* renamed from: p, reason: collision with root package name */
    public static String f18701p;

    /* renamed from: q, reason: collision with root package name */
    public static Dns f18702q;

    /* renamed from: r, reason: collision with root package name */
    public static Interceptor f18703r;

    /* renamed from: s, reason: collision with root package name */
    public static HashMap f18704s;

    /* renamed from: t, reason: collision with root package name */
    public static HashMap f18705t;

    /* renamed from: u, reason: collision with root package name */
    public static f f18706u;

    /* renamed from: v, reason: collision with root package name */
    public static final h9.g f18707v;

    /* renamed from: w, reason: collision with root package name */
    public static final h9.g f18708w;

    /* renamed from: x, reason: collision with root package name */
    public static AdvertResult f18709x;

    /* renamed from: a, reason: collision with root package name */
    public static final m f18686a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final String f18687b = q.class.getSimpleName();

    /* renamed from: e, reason: collision with root package name */
    public static final long f18690e = 15;

    /* renamed from: g, reason: collision with root package name */
    public static v1.c f18692g = new v1.d();

    /* renamed from: h, reason: collision with root package name */
    public static v1.e f18693h = new v1.e();

    /* renamed from: i, reason: collision with root package name */
    public static final String f18694i = "ad_exist_status";

    /* renamed from: j, reason: collision with root package name */
    public static final String f18695j = "apk_booting";

    /* renamed from: k, reason: collision with root package name */
    public static final ScheduledThreadPoolExecutor f18696k = s2.d.c();

    /* renamed from: l, reason: collision with root package name */
    public static HashMap f18697l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public static final ArrayList f18698m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public static Handler f18699n = new Handler(Looper.getMainLooper());

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f18710a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x1.d invoke() {
            m mVar = m.f18686a;
            return new x1.d(mVar.L(), mVar.N());
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v1.f f18711a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v1.f fVar) {
            super(1);
            this.f18711a = fVar;
        }

        public final void b(AdInfoWrapper adInfoWrapper) {
            this.f18711a.a(adInfoWrapper);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AdInfoWrapper) obj);
            return t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v1.f f18712a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v1.f fVar) {
            super(1);
            this.f18712a = fVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
            this.f18712a.a(new AdInfoWrapper(null, ""));
        }
    }

    public static final class d extends TypeToken<List<AdInfo>> {
    }

    public static final class e extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final e f18713a = new e();

        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HashMap invoke() {
            HashMap hashMap = new HashMap();
            hashMap.put("picture", new w1.c());
            hashMap.put("video", new w1.f(m.f18686a.G()));
            return hashMap;
        }
    }

    public static final class f implements v1.a {
        @Override // v1.a
        public void a(String str) {
            t9.i.g(str, "mediaType");
            m.f18704s.put(str, Boolean.TRUE);
            ArrayList arrayList = (ArrayList) m.f18705t.remove(str);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((v1.a) it.next()).a(str);
                }
            }
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f18714a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(List list) {
            super(1);
            this.f18714a = list;
        }

        public final void b(ReportResult reportResult) {
            q.f18727a.d(this.f18714a);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ReportResult) obj);
            return t.f14242a;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f18715a = new h();

        public h() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18716a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18717b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v1.b f18718c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context, boolean z10, v1.b bVar) {
            super(1);
            this.f18716a = context;
            this.f18717b = z10;
            this.f18718c = bVar;
        }

        public static final void d(v1.b bVar) {
            if (bVar != null) {
                bVar.b(true);
            }
        }

        public final void c(AdvertResult advertResult) {
            m.f18709x = advertResult;
            y1.e.f19725a.c(this.f18716a, m.f18695j, "");
            HashMap hashMap = new HashMap();
            List<AdvertPosition> ad_positions = advertResult.getAd_positions();
            if (ad_positions != null) {
                Context context = this.f18716a;
                boolean z10 = this.f18717b;
                for (AdvertPosition advertPosition : ad_positions) {
                    String ad_type = advertPosition.getAd_type();
                    boolean z11 = false;
                    if (!(ad_type == null || ad_type.length() == 0)) {
                        List<AdInfo> ads = advertPosition.getAds();
                        if (ads != null && !ads.isEmpty()) {
                            z11 = true;
                        }
                        if (z11) {
                            String ad_type2 = advertPosition.getAd_type();
                            t9.i.d(ad_type2);
                            List<AdInfo> ads2 = advertPosition.getAds();
                            t9.i.d(ads2);
                            hashMap.put(ad_type2, ads2);
                            String ad_type3 = advertPosition.getAd_type();
                            if (t9.i.b(m.f18695j, ad_type3)) {
                                Gson gson = new Gson();
                                List<AdInfo> ads3 = advertPosition.getAds();
                                t9.i.d(ads3);
                                y1.e.f19725a.c(context, m.f18695j, gson.toJson(ads3));
                            }
                            if (z10) {
                                m mVar = m.f18686a;
                                t9.i.d(ad_type3);
                                List<AdInfo> ads4 = advertPosition.getAds();
                                t9.i.d(ads4);
                                mVar.y(context, ad_type3, ads4);
                            }
                        }
                    }
                }
            }
            m.f18697l = hashMap;
            Handler P = m.f18686a.P();
            final v1.b bVar = this.f18718c;
            P.post(new Runnable() { // from class: s1.n
                @Override // java.lang.Runnable
                public final void run() {
                    m.i.d(v1.b.this);
                }
            });
            if (!hashMap.isEmpty()) {
                Context context2 = this.f18716a;
                v1.b bVar2 = this.f18718c;
                for (Map.Entry entry : hashMap.entrySet()) {
                    for (AdInfo adInfo : (Iterable) entry.getValue()) {
                        w1.a aVar = (w1.a) m.f18686a.O().get(adInfo.getMedia_type());
                        if (aVar != null) {
                            aVar.a(context2, (String) entry.getKey(), adInfo, bVar2);
                        }
                    }
                }
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((AdvertResult) obj);
            return t.f14242a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18719a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Context context) {
            super(1);
            this.f18719a = context;
        }

        public final void b(AdvertResult advertResult) {
            m mVar = m.f18686a;
            mVar.M().a("picture");
            Long timestamp = advertResult.getTimestamp();
            m.f18688c = new TimeInfoBean(timestamp != null ? timestamp.longValue() : System.currentTimeMillis(), SystemClock.elapsedRealtime());
            q.f18727a.c();
            Context applicationContext = this.f18719a.getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            mVar.k0(applicationContext, advertResult.getReporting_interval() != null ? r7.intValue() : m.f18690e);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AdvertResult) obj);
            return t.f14242a;
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v1.b f18720a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f18721b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(v1.b bVar, Context context) {
            super(1);
            this.f18720a = bVar;
            this.f18721b = context;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            v1.b bVar = this.f18720a;
            if (bVar != null) {
                bVar.b(false);
            }
            m.f18686a.U(this.f18721b);
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18722a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Context context) {
            super(1);
            this.f18722a = context;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f14242a;
        }

        public final void invoke(Long l10) {
            m.f18686a.U(this.f18722a);
        }
    }

    static {
        Dns dns = Dns.SYSTEM;
        t9.i.f(dns, "SYSTEM");
        f18702q = dns;
        f18704s = new HashMap();
        f18705t = new HashMap();
        f18706u = new f();
        f18707v = h9.h.b(e.f18713a);
        f18708w = h9.h.b(a.f18710a);
    }

    public static final void D(Context context, String str, String str2, boolean z10, String str3, ObservableEmitter observableEmitter) {
        t9.i.g(context, "$context");
        t9.i.g(str, "$adType");
        t9.i.g(str2, "$userIdentity");
        t9.i.g(str3, "$hasPay");
        t9.i.g(observableEmitter, "it");
        y1.f fVar = y1.f.f19726a;
        List z11 = f18686a.z(str);
        TimeInfoBean timeInfoBean = f18688c;
        int i10 = 1;
        ArrayList c10 = fVar.c(context, str, z11, str2, timeInfoBean != null ? TimeInfoBean.getCurrTime$default(timeInfoBean, 0L, 1, null) : 0L, z10, str3);
        if (c10 == null || c10.isEmpty()) {
            observableEmitter.onNext(new AdInfoWrapper(null, ""));
            observableEmitter.onComplete();
            return;
        }
        int size = c10.size();
        if (1 <= size) {
            while (true) {
                AdInfo a10 = c.a.a(f18692g, str, c10, null, 4, null);
                if (a10 != null) {
                    w1.a aVar = (w1.a) f18686a.O().get(a10.getMedia_type());
                    File b10 = aVar != null ? aVar.b(context, str, a10) : null;
                    if (b10 != null) {
                        String absolutePath = b10.getAbsolutePath();
                        t9.i.f(absolutePath, "cacheFile.absolutePath");
                        observableEmitter.onNext(new AdInfoWrapper(a10, absolutePath));
                        observableEmitter.onComplete();
                        return;
                    }
                }
                if (i10 == size) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        observableEmitter.onNext(new AdInfoWrapper(null, ""));
        observableEmitter.onComplete();
    }

    public static final void E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ AdInfo J(m mVar, Context context, String str, String str2, String str3, boolean z10, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = "picture";
        }
        return mVar.I(context, str, str2, str3, (i10 & 16) != 0 ? false : z10, str4);
    }

    public static /* synthetic */ void T(m mVar, v1.a aVar, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "picture";
        }
        mVar.S(aVar, str);
    }

    public static final void V(Context context) {
        t9.i.g(context, "$context");
        List<AdReportBeanWrapper> f10 = q.f18727a.f(context);
        ArrayList arrayList = new ArrayList();
        if (f10 == null || f10.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AdReportBeanWrapper adReportBeanWrapper : f10) {
            arrayList.add(Integer.valueOf(adReportBeanWrapper.getId()));
            if (!t9.i.b(adReportBeanWrapper.getBean().getAd_id(), "0") || adReportBeanWrapper.getBean().getGame_stay_time() <= 0) {
                String str = adReportBeanWrapper.getBean().getAd_id() + adReportBeanWrapper.getBean().getUser_name() + adReportBeanWrapper.getBean().getAd_type();
                AdReportBean adReportBean = (AdReportBean) linkedHashMap.get(str);
                if (adReportBean == null) {
                    AdReportBean bean = adReportBeanWrapper.getBean();
                    String str2 = f18700o;
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                    bean.setSn(str2);
                    AdReportBean bean2 = adReportBeanWrapper.getBean();
                    String str3 = f18701p;
                    bean2.setUser_id(str3 != null ? str3 : "unknown");
                    AdReportBean bean3 = adReportBeanWrapper.getBean();
                    String packageName = context.getPackageName();
                    t9.i.f(packageName, "context.packageName");
                    bean3.setApp_id(packageName);
                    linkedHashMap.put(str, adReportBeanWrapper.getBean());
                    arrayList2.add(adReportBeanWrapper.getBean());
                } else {
                    adReportBean.setDisplay_times(adReportBean.getDisplay_times() + adReportBeanWrapper.getBean().getDisplay_times());
                    adReportBean.setClick_times(adReportBean.getClick_times() + adReportBeanWrapper.getBean().getClick_times());
                    if (adReportBeanWrapper.getBean().getLast_update_timestamp() > adReportBean.getLast_update_timestamp()) {
                        adReportBean.setLast_update_timestamp(adReportBeanWrapper.getBean().getLast_update_timestamp());
                    }
                }
            } else {
                AdReportBean bean4 = adReportBeanWrapper.getBean();
                String str4 = f18700o;
                if (str4 == null) {
                    str4 = "unknown";
                }
                bean4.setSn(str4);
                AdReportBean bean5 = adReportBeanWrapper.getBean();
                String str5 = f18701p;
                bean5.setUser_id(str5 != null ? str5 : "unknown");
                AdReportBean bean6 = adReportBeanWrapper.getBean();
                String packageName2 = context.getPackageName();
                t9.i.f(packageName2, "context.packageName");
                bean6.setApp_id(packageName2);
                arrayList2.add(adReportBeanWrapper.getBean());
            }
        }
        Observable subscribeOn = f18686a.G().k(new AdReportRequest(arrayList2)).subscribeOn(Schedulers.io());
        final g gVar = new g(arrayList);
        Consumer consumer = new Consumer() { // from class: s1.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.W(s9.l.this, obj);
            }
        };
        final h hVar = h.f18715a;
        subscribeOn.subscribe(consumer, new Consumer() { // from class: s1.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.X(s9.l.this, obj);
            }
        });
    }

    public static final void W(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void X(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void a0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void b0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void c0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void i0(final Context context, String str, final AdInfo adInfo, final ImageView imageView, final Integer num, final s9.l lVar, final Integer num2, final boolean z10, final int i10) {
        t9.i.g(context, "$context");
        t9.i.g(str, "$adType");
        t9.i.g(imageView, "$iv");
        w1.a aVar = (w1.a) f18686a.O().get("picture");
        final File b10 = aVar != null ? aVar.b(context, str, adInfo) : null;
        f18699n.post(new Runnable() { // from class: s1.g
            @Override // java.lang.Runnable
            public final void run() {
                m.j0(context, imageView, adInfo, b10, num, lVar, num2, z10, i10);
            }
        });
    }

    public static final void j0(Context context, ImageView imageView, AdInfo adInfo, File file, Integer num, s9.l lVar, Integer num2, boolean z10, int i10) {
        t9.i.g(context, "$context");
        t9.i.g(imageView, "$iv");
        r1.a aVar = r1.a.f18290a;
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        aVar.h(context, imageView, url, file, num, lVar, num2, z10, i10);
    }

    public static final void l0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final List A(Context context, String str, String str2, boolean z10, String str3) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str2, "userIdentity");
        t9.i.g(str3, "hasPay");
        if (str == null) {
            return null;
        }
        y1.f fVar = y1.f.f19726a;
        List list = (List) f18697l.get(str);
        TimeInfoBean timeInfoBean = f18688c;
        return fVar.c(context, str, list, str2, timeInfoBean != null ? TimeInfoBean.getCurrTime$default(timeInfoBean, 0L, 1, null) : 0L, z10, str3);
    }

    public final void B(final Context context, final String str, v1.f fVar, final String str2, final boolean z10, final String str3) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        t9.i.g(fVar, "callback");
        t9.i.g(str2, "userIdentity");
        t9.i.g(str3, "hasPay");
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: s1.i
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m.D(context, str, str2, z10, str3, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final b bVar = new b(fVar);
        Consumer consumer = new Consumer() { // from class: s1.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.E(s9.l.this, obj);
            }
        };
        final c cVar = new c(fVar);
        observeOn.subscribe(consumer, new Consumer() { // from class: s1.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.F(s9.l.this, obj);
            }
        });
    }

    public final x1.d G() {
        return (x1.d) f18708w.getValue();
    }

    public final AdInfo H(Context context, String str, String str2, String str3, boolean z10, String str4) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        t9.i.g(str2, "mediaType");
        t9.i.g(str3, "userIdentity");
        t9.i.g(str4, "hasPay");
        List list = (List) f18697l.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        v1.e eVar = f18693h;
        TimeInfoBean timeInfoBean = f18688c;
        return eVar.a(context, str, list, str2, str3, timeInfoBean != null ? TimeInfoBean.getCurrTime$default(timeInfoBean, 0L, 1, null) : 0L, z10, str4);
    }

    public final AdInfo I(Context context, String str, String str2, String str3, boolean z10, String str4) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        t9.i.g(str2, "userIdentity");
        t9.i.g(str3, "mediaType");
        t9.i.g(str4, "hasPay");
        List<AdInfo> list = (List) f18697l.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (AdInfo adInfo : list) {
            if (t9.i.b(adInfo.getMedia_type(), str3)) {
                y1.f fVar = y1.f.f19726a;
                TimeInfoBean timeInfoBean = f18688c;
                AdInfo a10 = fVar.a(context, str, adInfo, str2, timeInfoBean != null ? TimeInfoBean.getCurrTime$default(timeInfoBean, 0L, 1, null) : 0L, z10, str4);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }

    public final AdInfo K(Context context, String str) {
        List list;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        y1.e eVar = y1.e.f19725a;
        String str2 = f18695j;
        String str3 = (String) eVar.a(context, str2, "");
        if (!(str3.length() > 0) || (list = (List) new Gson().fromJson(str3, new d().getType())) == null || list.isEmpty()) {
            return null;
        }
        return f18692g.a(str2, list, str);
    }

    public final Dns L() {
        return f18702q;
    }

    public final v1.a M() {
        return f18706u;
    }

    public final Interceptor N() {
        return f18703r;
    }

    public final HashMap O() {
        return (HashMap) f18707v.getValue();
    }

    public final Handler P() {
        return f18699n;
    }

    public final ScheduledThreadPoolExecutor Q() {
        return f18696k;
    }

    public final TimeInfoBean R() {
        TimeInfoBean timeInfoBean = f18688c;
        return timeInfoBean != null ? timeInfoBean : f18689d;
    }

    public final void S(v1.a aVar, String str) {
        t9.i.g(aVar, "callback");
        t9.i.g(str, "mediaType");
        if (t9.i.b(f18704s.get(str), Boolean.TRUE)) {
            aVar.a(str);
            return;
        }
        ArrayList arrayList = (ArrayList) f18705t.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            f18705t.put(str, arrayList);
        }
        arrayList.add(aVar);
    }

    public final void U(final Context context) {
        f18696k.execute(new d.e("report ad", new Runnable() { // from class: s1.h
            @Override // java.lang.Runnable
            public final void run() {
                m.V(context);
            }
        }, false));
    }

    public final void Y(Context context, String str, String str2, Dns dns, v1.b bVar, String str3, boolean z10, Interceptor interceptor) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        t9.i.g(str3, "ad_version");
        String str4 = Build.VERSION.RELEASE;
        t9.i.f(str4, "RELEASE");
        String str5 = str == null ? "" : str;
        String language = Locale.getDefault().getLanguage();
        t9.i.f(language, "getDefault().language");
        String packageName = context.getPackageName();
        t9.i.f(packageName, "context.packageName");
        AdvertBean advertBean = new AdvertBean("android", str4, str3, str5, language, "jpg/png/bmp", "mp4/rmvb/flv", packageName, String.valueOf(y1.f.f19726a.b(context)));
        f18700o = str;
        f18701p = str2;
        f18702q = dns;
        f18703r = interceptor;
        Observable subscribeOn = G().g(advertBean).subscribeOn(Schedulers.io());
        final i iVar = new i(context, z10, bVar);
        Observable observeOn = subscribeOn.doOnNext(new Consumer() { // from class: s1.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.a0(s9.l.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final j jVar = new j(context);
        Consumer consumer = new Consumer() { // from class: s1.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.b0(s9.l.this, obj);
            }
        };
        final k kVar = new k(bVar, context);
        observeOn.subscribe(consumer, new Consumer() { // from class: s1.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.c0(s9.l.this, obj);
            }
        });
    }

    public final void d0(Context context, String str, String str2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "ad_type");
        t9.i.g(str2, "ad_id");
        y1.e eVar = y1.e.f19725a;
        TimeInfoBean timeInfoBean = f18688c;
        eVar.d(context, str, str2, Long.valueOf(timeInfoBean != null ? TimeInfoBean.getCurrTime$default(timeInfoBean, 0L, 1, null) : 0L));
    }

    public final void e0(String str, String str2) {
        f18700o = str;
        f18701p = str2;
    }

    public final void f0(Long l10) {
        if (l10 != null) {
            f18689d = new TimeInfoBean(l10.longValue(), SystemClock.elapsedRealtime());
            q.f18727a.c();
        }
    }

    public final void g0(final Context context, final ImageView imageView, final String str, final AdInfo adInfo, final Integer num, final s9.l lVar, final Integer num2, final boolean z10, final int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(imageView, "iv");
        t9.i.g(str, "adType");
        if (adInfo == null || r1.a.f18290a.b(context)) {
            return;
        }
        s2.d.b("showAdGetCache", new Runnable() { // from class: s1.a
            @Override // java.lang.Runnable
            public final void run() {
                m.i0(context, str, adInfo, imageView, num, lVar, num2, z10, i10);
            }
        }, false);
    }

    public final void k0(Context context, long j10) {
        Disposable disposable;
        Disposable disposable2 = f18691f;
        if (!(disposable2 != null ? disposable2.isDisposed() : true) && (disposable = f18691f) != null) {
            disposable.dispose();
        }
        Observable<Long> interval = Observable.interval(0L, j10, TimeUnit.MINUTES);
        final l lVar = new l(context);
        f18691f = interval.subscribe(new Consumer() { // from class: s1.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.l0(s9.l.this, obj);
            }
        });
    }

    public final void y(Context context, String str, List list) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences.getAll().isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Map<String, ?> all = sharedPreferences.getAll();
        t9.i.f(all, "sp.all");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (t9.i.b(entry.getKey(), ((AdInfo) it.next()).getAd_id())) {
                        break;
                    }
                } else {
                    edit.remove(entry.getKey());
                    break;
                }
            }
        }
        edit.apply();
    }

    public final List z(String str) {
        if (str == null) {
            return null;
        }
        return (List) f18697l.get(str);
    }
}
