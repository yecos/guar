package b6;

import android.content.Context;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b6.r;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.LiveTabEntity;
import com.mobile.brasiltv.bean.event.LiveTabEpgNotificationEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.view.CenterLayoutManager;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.AutoLinearLayout;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.GetProgramData;
import mobile.com.requestframe.utils.response.GetProgramResult;
import mobile.com.requestframe.utils.response.Program;

/* loaded from: classes.dex */
public final class l2 extends b6.f {

    /* renamed from: h, reason: collision with root package name */
    public int f4778h;

    /* renamed from: k, reason: collision with root package name */
    public LiveTabEntity f4781k;

    /* renamed from: o, reason: collision with root package name */
    public Map f4785o = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final List f4775e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public LruCache f4776f = new LruCache(24);

    /* renamed from: g, reason: collision with root package name */
    public HashMap f4777g = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f4779i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final List f4780j = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f4782l = h9.h.b(new d());

    /* renamed from: m, reason: collision with root package name */
    public final h9.g f4783m = h9.h.b(new f());

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f4784n = h9.h.b(new a());

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.u0 invoke() {
            return new g5.u0(l2.this.getChildFragmentManager(), l2.this.f4775e);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.l {
        public b() {
            super(1);
        }

        public final void b(Integer num) {
            if (num != null && num.intValue() == 0) {
                ArrayList arrayList = (ArrayList) l2.this.l3().get(l2.this.f4779i.get(l2.this.k3()));
                if (arrayList != null) {
                    l2.this.v3(arrayList);
                    return;
                }
                return;
            }
            if (num != null && num.intValue() == 1) {
                l2.this.v3(null);
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            AutoLinearLayout autoLinearLayout = (AutoLinearLayout) l2.this.g3(R$id.mLlNoData);
            if (autoLinearLayout == null) {
                return;
            }
            autoLinearLayout.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final VodDao invoke() {
            Context context = l2.this.getContext();
            t9.i.d(context);
            return new VodDao(context);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements ViewPager.j {
        public e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            l2.this.C3(i10);
            ArrayList arrayList = (ArrayList) l2.this.l3().get(l2.this.f4779i.get(l2.this.k3()));
            if (arrayList != null) {
                l2.this.v3(arrayList);
            }
            l2.this.A3(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends t9.j implements s9.a {
        public f() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.v0 invoke() {
            androidx.fragment.app.e activity = l2.this.getActivity();
            if (activity != null) {
                return new g5.v0(activity);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f4792a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(GetProgramResult getProgramResult) {
            t9.i.g(getProgramResult, "it");
            return Boolean.valueOf(getProgramResult.getData() != null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f4793a = new h();

        public h() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(GetProgramResult getProgramResult) {
            t9.i.g(getProgramResult, "it");
            GetProgramData data = getProgramResult.getData();
            t9.i.d(data);
            return data.getProgramList();
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends t9.j implements s9.l {
        public i() {
            super(1);
        }

        public final void b(List list) {
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                l2.this.m3().put(r.f4860j.a(), list);
            } else {
                l2.this.m3().put(r.f4860j.a(), new ArrayList());
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f4796a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f4796a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f4796a, null, null, 6, null);
                yVar.c(this.f4796a);
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public j() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            l2.this.q3();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onComplete() {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            AutoLinearLayout autoLinearLayout = (AutoLinearLayout) l2.this.g3(R$id.mLlNoData);
            if (autoLinearLayout != null) {
                autoLinearLayout.setVisibility(0);
            }
            Context context = l2.this.getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final void B3(RecyclerView.o oVar, l2 l2Var, int i10) {
        t9.i.g(l2Var, "this$0");
        oVar.smoothScrollToPosition((RecyclerView) l2Var.g3(R$id.tabRecyclerView), new RecyclerView.a0(), i10);
    }

    public static final void r3(l2 l2Var, t9.w wVar, t9.w wVar2, t9.w wVar3, t9.w wVar4, t9.w wVar5, ObservableEmitter observableEmitter) {
        t9.i.g(l2Var, "this$0");
        t9.i.g(wVar, "$startTime");
        t9.i.g(wVar2, "$endTime");
        t9.i.g(wVar3, "$startDay");
        t9.i.g(wVar4, "$endDay");
        t9.i.g(wVar5, "$curTime");
        t9.i.g(observableEmitter, "it");
        LruCache lruCache = l2Var.f4776f;
        r.a aVar = r.f4860j;
        if (!com.mobile.brasiltv.utils.b0.I((Collection) lruCache.get(aVar.a()))) {
            observableEmitter.onNext(1);
            return;
        }
        Object obj = l2Var.f4776f.get(aVar.a());
        t9.i.f(obj, "mEpgLruCache.get(LiveEpgFrag.mChannelCode)");
        for (Program program : (Iterable) obj) {
            String e10 = y6.b.e(program.getStartTime(), "yyyyMMddHHmmSS", "yyyy/MM/dd HH:mm");
            t9.i.f(e10, "utc2LocalStr(it.startTim…mSS\", \"yyyy/MM/dd HH:mm\")");
            wVar.f18961a = e10;
            String e11 = y6.b.e(program.getEndTime(), "yyyyMMddHHmmSS", "yyyy/MM/dd HH:mm");
            t9.i.f(e11, "utc2LocalStr(it.endTime,…mSS\", \"yyyy/MM/dd HH:mm\")");
            wVar2.f18961a = e11;
            String substring = ((String) wVar.f18961a).substring(0, 10);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            wVar3.f18961a = substring;
            String substring2 = ((String) wVar2.f18961a).substring(0, 10);
            t9.i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            wVar4.f18961a = substring2;
            if (l2Var.f4779i.contains(wVar3.f18961a)) {
                if (!t9.i.b(wVar3.f18961a, wVar4.f18961a)) {
                    Object obj2 = l2Var.f4777g.get(wVar3.f18961a);
                    t9.i.d(obj2);
                    ((ArrayList) obj2).add(new Program(program.getProgramName(), (String) wVar.f18961a, ((String) wVar3.f18961a) + " 23:59", program.getType(), program.getRemark(), false, 32, null));
                    if (l2Var.f4779i.contains(wVar4.f18961a) && !ba.t.o((CharSequence) wVar2.f18961a, "00:00", false, 2, null)) {
                        Program o32 = l2Var.o3(program.getProgramName(), ((String) wVar4.f18961a) + " 00:00", (String) wVar2.f18961a, program.getType(), program.getRemark());
                        Object obj3 = l2Var.f4777g.get(wVar4.f18961a);
                        t9.i.d(obj3);
                        ((ArrayList) obj3).add(o32);
                    }
                } else if (!y6.a.b((String) wVar5.f18961a, (String) wVar2.f18961a)) {
                    Program o33 = l2Var.o3(program.getProgramName(), (String) wVar.f18961a, (String) wVar2.f18961a, program.getType(), program.getRemark());
                    Object obj4 = l2Var.f4777g.get(wVar3.f18961a);
                    t9.i.d(obj4);
                    ((ArrayList) obj4).add(o33);
                }
            }
        }
        observableEmitter.onNext(0);
    }

    public static final void s3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u3(l2 l2Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(l2Var, "this$0");
        ((ViewPager) l2Var.g3(R$id.liveViewPager)).setCurrentItem(i10);
        l2Var.A3(i10);
    }

    public static final boolean x3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void z3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void A3(final int i10) {
        g5.v0 p32 = p3();
        LiveTabEntity liveTabEntity = p32 != null ? (LiveTabEntity) p32.getItem(i10) : null;
        if (t9.i.b(liveTabEntity, this.f4781k)) {
            return;
        }
        if (liveTabEntity != null) {
            liveTabEntity.setSelected(true);
        }
        LiveTabEntity liveTabEntity2 = this.f4781k;
        if (liveTabEntity2 != null) {
            if (liveTabEntity2 != null) {
                liveTabEntity2.setSelected(false);
            }
            g5.v0 p33 = p3();
            if (p33 != null) {
                p33.notifyDataSetChanged();
            }
        }
        this.f4781k = liveTabEntity;
        int i11 = R$id.tabRecyclerView;
        RecyclerView recyclerView = (RecyclerView) g3(i11);
        final RecyclerView.o layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            ((RecyclerView) g3(i11)).postDelayed(new Runnable() { // from class: b6.k2
                @Override // java.lang.Runnable
                public final void run() {
                    l2.B3(RecyclerView.o.this, this, i10);
                }
            }, 100L);
        }
    }

    public final void C3(int i10) {
        this.f4778h = i10;
    }

    @Override // k5.a
    public void T2() {
    }

    @Override // b6.f
    public void X2() {
        this.f4785o.clear();
    }

    public View g3(int i10) {
        View findViewById;
        Map map = this.f4785o;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final g5.u0 j3() {
        return (g5.u0) this.f4784n.getValue();
    }

    public final int k3() {
        return this.f4778h;
    }

    public final HashMap l3() {
        return this.f4777g;
    }

    public final LruCache m3() {
        return this.f4776f;
    }

    public final VodDao n3() {
        return (VodDao) this.f4782l.getValue();
    }

    public final Program o3(String str, String str2, String str3, String str4, String str5) {
        String e10 = ma.m.e(r.f4860j.b() + str + str2 + str3);
        VodDao n32 = n3();
        t9.i.f(e10, "pid");
        return new Program(str, str2, str3, str4, str5, n32.queryLiveSubByPid(e10));
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String j10;
        super.onCreate(bundle);
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i10 = 0;
        while (i10 < 7) {
            String b10 = y6.b.b((i10 * 24 * 60 * 60 * 1000) + currentTimeMillis, "yyyy/MM/dd");
            if (i10 == 0) {
                j10 = getResources().getString(R.string.today);
            } else {
                t9.i.f(b10, "nextDay");
                String substring = b10.substring(5);
                t9.i.f(substring, "this as java.lang.String).substring(startIndex)");
                j10 = ba.s.j(substring, Operator.Operation.DIVISION, Operator.Operation.MINUS, false, 4, null);
            }
            String str = j10;
            List list = this.f4775e;
            t9.i.f(str, "nextDay");
            list.add(str);
            List list2 = this.f4780j;
            t9.i.f(str, "nextDay");
            list2.add(new LiveTabEntity(str, i10 == 0, 0, 4, null));
            i10++;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t9.i.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_live_tab_epg, viewGroup, false);
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    @Override // b6.f, u8.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        X2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            return;
        }
        r.a aVar = r.f4860j;
        if (!(aVar.a().length() > 0) || aVar.c() == -1) {
            return;
        }
        w3();
        xa.c.c().j(new LiveTabEpgNotificationEvent());
    }

    @Override // k5.a, u8.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f4781k = (LiveTabEntity) this.f4780j.get(0);
        int i10 = R$id.liveViewPager;
        if (((ViewPager) g3(i10)) != null) {
            ((ViewPager) g3(i10)).setAdapter(j3());
        }
        ((ViewPager) g3(i10)).addOnPageChangeListener(new e());
        CenterLayoutManager centerLayoutManager = new CenterLayoutManager(getActivity(), 0, false);
        int i11 = R$id.tabRecyclerView;
        ((RecyclerView) g3(i11)).setHasFixedSize(true);
        ((RecyclerView) g3(i11)).setLayoutManager(centerLayoutManager);
        ((RecyclerView) g3(i11)).setAdapter(p3());
        g5.v0 p32 = p3();
        if (p32 != null) {
            p32.setNewData(this.f4780j);
        }
        g5.v0 p33 = p3();
        if (p33 != null) {
            p33.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: b6.d2
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i12) {
                    l2.u3(l2.this, baseQuickAdapter, view2, i12);
                }
            });
        }
        this.f4779i.clear();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i12 = 0; i12 < 7; i12++) {
            this.f4779i.add(y6.b.b((i12 * 24 * 60 * 60 * 1000) + currentTimeMillis, "yyyy/MM/dd"));
        }
        int size = this.f4779i.size();
        for (int i13 = 0; i13 < size; i13++) {
            HashMap hashMap = this.f4777g;
            Object obj = this.f4779i.get(i13);
            t9.i.f(obj, "dateList[i]");
            hashMap.put(obj, new ArrayList());
        }
        w3();
    }

    public final g5.v0 p3() {
        return (g5.v0) this.f4783m.getValue();
    }

    public final void q3() {
        final t9.w wVar = new t9.w();
        wVar.f18961a = y6.a.d("yyyy/MM/dd HH:mm");
        final t9.w wVar2 = new t9.w();
        wVar2.f18961a = "";
        final t9.w wVar3 = new t9.w();
        wVar3.f18961a = "";
        final t9.w wVar4 = new t9.w();
        wVar4.f18961a = "";
        final t9.w wVar5 = new t9.w();
        wVar5.f18961a = "";
        int size = this.f4779i.size();
        for (int i10 = 0; i10 < size; i10++) {
            HashMap hashMap = this.f4777g;
            Object obj = this.f4779i.get(i10);
            t9.i.f(obj, "dateList[i]");
            hashMap.put(obj, new ArrayList());
        }
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: b6.h2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                l2.r3(l2.this, wVar2, wVar3, wVar4, wVar5, wVar, observableEmitter);
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
        final b bVar = new b();
        Consumer consumer = new Consumer() { // from class: b6.i2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                l2.s3(s9.l.this, obj2);
            }
        };
        final c cVar = new c();
        observeOn.subscribe(consumer, new Consumer() { // from class: b6.j2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                l2.t3(s9.l.this, obj2);
            }
        });
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        t9.i.g(updateFavStatusEvent, "event");
    }

    public final void v3(List list) {
        List<androidx.lifecycle.g> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (androidx.lifecycle.g gVar : s02) {
            if (gVar instanceof g5.g0) {
                ((g5.g0) gVar).P0(list);
            }
        }
    }

    public final void w3() {
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) g3(R$id.mLlNoData);
        if (autoLinearLayout != null) {
            autoLinearLayout.setVisibility(8);
        }
        LruCache lruCache = this.f4776f;
        r.a aVar = r.f4860j;
        if (lruCache.get(aVar.a()) != null) {
            q3();
            return;
        }
        Observable compose = w6.i.f19214g.b().F1(aVar.a(), aVar.c()).compose(O2());
        final g gVar = g.f4792a;
        Observable filter = compose.filter(new Predicate() { // from class: b6.e2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean x32;
                x32 = l2.x3(s9.l.this, obj);
                return x32;
            }
        });
        final h hVar = h.f4793a;
        Observable map = filter.map(new Function() { // from class: b6.f2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List y32;
                y32 = l2.y3(s9.l.this, obj);
                return y32;
            }
        });
        final i iVar = new i();
        map.doOnNext(new Consumer() { // from class: b6.g2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                l2.z3(s9.l.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new j());
    }
}
