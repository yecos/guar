package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.view.BottomDecoration;
import com.mobile.brasiltv.view.adView.AdaptiveAdContainer;
import com.mobile.brasiltv.view.adView.IAdView;
import com.mobile.brasiltv.view.adView.SmallAdNativeContainer;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.Recommend;
import mobile.com.requestframe.utils.response.RecommendContentList;

/* loaded from: classes3.dex */
public final class k extends j5.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13733a;

    /* renamed from: b, reason: collision with root package name */
    public ChildColumnList f13734b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13735c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13736d;

    /* renamed from: e, reason: collision with root package name */
    public final List f13737e;

    /* renamed from: f, reason: collision with root package name */
    public BGABanner f13738f;

    /* renamed from: g, reason: collision with root package name */
    public c f13739g;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f13741b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(1);
            this.f13741b = view;
        }

        public final void b(PosterList posterList) {
            a7.e eVar = a7.e.f288a;
            Context context = k.this.f13733a;
            String fileUrl = posterList.getFileUrl();
            View view = this.f13741b;
            t9.i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
            eVar.b(context, fileUrl, (ImageView) view, R.drawable.column_image_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13742a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(1);
            this.f13742a = view;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            View view = this.f13742a;
            t9.i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) view).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    public static final class c extends ViewPager.n {

        /* renamed from: a, reason: collision with root package name */
        public String f13743a = "";

        /* renamed from: b, reason: collision with root package name */
        public List f13744b;

        public c() {
        }

        public final void a(List list) {
            this.f13744b = list;
        }

        public final void b(String str) {
            t9.i.g(str, "<set-?>");
            this.f13743a = str;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            List list = this.f13744b;
            if (list != null) {
                k kVar = k.this;
                if ((list != null ? list.size() : 0) > 0 && kVar.w() && kVar.x()) {
                    List list2 = this.f13744b;
                    int size = i10 % (list2 != null ? list2.size() : 0);
                    if (size < 0 || size >= list.size() || !t9.i.b("4", ((RecommendContentList) list.get(size)).getType())) {
                        return;
                    }
                    com.mobile.brasiltv.utils.i1.D(kVar.f13733a, "EVENT_RECOMMEND_AD_SHOW_CR", size + 1);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, ChildColumnList childColumnList) {
        super(i9.j.d());
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(childColumnList, "parentColumn");
        this.f13733a = context;
        this.f13734b = childColumnList;
        this.f13736d = true;
        this.f13737e = new ArrayList();
        a6.d dVar = a6.d.f249a;
        addItemType(dVar.a(), R.layout.item_recommend_banner);
        addItemType(dVar.b(), R.layout.adapter_recommend_item);
        addItemType(dVar.c(), R.layout.adapter_recommend_item);
        addItemType(dVar.h(), R.layout.item_native_ad);
        addItemType(dVar.k(), R.layout.item_smart_ad);
        this.f13739g = new c();
    }

    public static final void k(BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) view).setImageResource(R.drawable.column_image_placeholder);
    }

    public static final void l(k kVar, BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.g(kVar, "this$0");
        a7.d dVar = a7.d.f279a;
        t9.i.e(obj, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.RecommendContentList");
        Observable c10 = dVar.c(((RecommendContentList) obj).getPosterList(), dVar.f());
        final a aVar = kVar.new a(view);
        Consumer consumer = new Consumer() { // from class: g5.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                k.m(s9.l.this, obj2);
            }
        };
        final b bVar = new b(view);
        c10.subscribe(consumer, new Consumer() { // from class: g5.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                k.n(s9.l.this, obj2);
            }
        });
    }

    public static final void m(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void n(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o(t9.w wVar, k kVar, l lVar, t9.w wVar2, BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.g(wVar, "$recommendData");
        t9.i.g(kVar, "this$0");
        t9.i.g(lVar, "$crFragBannerItem");
        t9.i.g(wVar2, "$recommendCode");
        if (com.mobile.brasiltv.utils.b0.I((Collection) wVar.f18961a)) {
            RecommendContentList recommendContentList = (RecommendContentList) ((List) wVar.f18961a).get(i10);
            if (t9.i.b("4", recommendContentList.getType())) {
                String url = recommendContentList.getUrl();
                if (url == null || url.length() == 0) {
                    return;
                }
                com.mobile.brasiltv.utils.i1.D(kVar.f13733a, "EVENT_RECOMMEND_AD_CLICK_CR", i10 + 1);
                com.mobile.brasiltv.utils.b0.j0(kVar.f13733a, recommendContentList.getUrl(), false, true, false, false, 24, null);
                return;
            }
            a7.d dVar = a7.d.f279a;
            String n10 = dVar.n(recommendContentList.getPosterList(), dVar.f());
            String str = n10 == null ? "" : n10;
            Context context = kVar.f13733a;
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            f5.c cVar = (f5.c) context;
            String type = recommendContentList.getType();
            String programType = recommendContentList.getProgramType();
            String contentId = recommendContentList.getContentId();
            EnterType enterType = EnterType.BANNER;
            String name = recommendContentList.getName();
            int b10 = lVar.b();
            StringBuilder sb = new StringBuilder();
            String alias = kVar.f13734b.getAlias();
            if (alias == null) {
                alias = "";
            }
            sb.append(alias);
            sb.append('/');
            String str2 = (String) wVar2.f18961a;
            sb.append(str2 != null ? str2 : "");
            com.mobile.brasiltv.utils.b0.r(cVar, type, programType, contentId, enterType, name, true, false, b10, sb.toString(), str);
        }
    }

    public static final void q(k kVar, View view) {
        t9.i.g(kVar, "this$0");
        Context context = kVar.f13733a;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.k((f5.c) context, kVar.f13734b, 0, true);
    }

    public static final void t(k kVar, n nVar, View view) {
        t9.i.g(kVar, "this$0");
        t9.i.g(nVar, "$crFragNormalItem");
        Context context = kVar.f13733a;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.k((f5.c) context, kVar.f13734b, nVar.b(), true);
    }

    public final void A(boolean z10) {
        this.f13736d = z10;
        y(true);
    }

    public final void i(boolean z10) {
        BGABanner bGABanner = this.f13738f;
        if ((bGABanner != null ? bGABanner.getItemCount() : 0) > 1) {
            if (z10) {
                BGABanner bGABanner2 = this.f13738f;
                if (bGABanner2 != null) {
                    bGABanner2.startAutoPlay();
                    return;
                }
                return;
            }
            BGABanner bGABanner3 = this.f13738f;
            if (bGABanner3 != null) {
                bGABanner3.stopAutoPlay();
            }
        }
    }

    public final void j(BaseViewHolder baseViewHolder, final l lVar) {
        this.f13738f = (BGABanner) baseViewHolder.getView(R.id.mRecommendBanner);
        baseViewHolder.setVisible(R.id.tvCrTips, true);
        if (lVar.c().isEmpty()) {
            BGABanner bGABanner = this.f13738f;
            t9.i.d(bGABanner);
            bGABanner.setAutoPlayAble(false);
            BGABanner bGABanner2 = this.f13738f;
            t9.i.d(bGABanner2);
            bGABanner2.setAdapter(new BGABanner.Adapter() { // from class: g5.e
                @Override // cn.bingoogolapple.bgabanner.BGABanner.Adapter
                public final void fillBannerItem(BGABanner bGABanner3, View view, Object obj, int i10) {
                    k.k(bGABanner3, view, obj, i10);
                }
            });
            BGABanner bGABanner3 = this.f13738f;
            t9.i.d(bGABanner3);
            bGABanner3.setData(i9.i.b(Integer.valueOf(R.drawable.column_image_placeholder)), null);
            return;
        }
        final t9.w wVar = new t9.w();
        wVar.f18961a = ((Recommend) lVar.c().get(0)).getContentList();
        final t9.w wVar2 = new t9.w();
        wVar2.f18961a = ((Recommend) lVar.c().get(0)).getRecommendCode();
        BGABanner bGABanner4 = this.f13738f;
        t9.i.d(bGABanner4);
        bGABanner4.setAutoPlayAble(((List) wVar.f18961a).size() > 1);
        BGABanner bGABanner5 = this.f13738f;
        t9.i.d(bGABanner5);
        bGABanner5.setAdapter(new BGABanner.Adapter() { // from class: g5.f
            @Override // cn.bingoogolapple.bgabanner.BGABanner.Adapter
            public final void fillBannerItem(BGABanner bGABanner6, View view, Object obj, int i10) {
                k.l(k.this, bGABanner6, view, obj, i10);
            }
        });
        BGABanner bGABanner6 = this.f13738f;
        t9.i.d(bGABanner6);
        bGABanner6.setData((List) wVar.f18961a, null);
        BGABanner bGABanner7 = this.f13738f;
        t9.i.d(bGABanner7);
        bGABanner7.setDelegate(new BGABanner.Delegate() { // from class: g5.g
            @Override // cn.bingoogolapple.bgabanner.BGABanner.Delegate
            public final void onBannerItemClick(BGABanner bGABanner8, View view, Object obj, int i10) {
                k.o(t9.w.this, this, lVar, wVar2, bGABanner8, view, obj, i10);
            }
        });
        BGABanner bGABanner8 = this.f13738f;
        t9.i.d(bGABanner8);
        bGABanner8.getViewPager().removeOnPageChangeListener(this.f13739g);
        c cVar = this.f13739g;
        String a10 = lVar.a();
        if (a10 == null) {
            a10 = "";
        }
        cVar.b(a10);
        this.f13739g.a((List) wVar.f18961a);
        BGABanner bGABanner9 = this.f13738f;
        t9.i.d(bGABanner9);
        bGABanner9.getViewPager().addOnPageChangeListener(this.f13739g);
        BGABanner bGABanner10 = this.f13738f;
        t9.i.d(bGABanner10);
        int currentItem = bGABanner10.getViewPager().getCurrentItem() % ((List) wVar.f18961a).size();
        if (currentItem < 0 || currentItem >= ((List) wVar.f18961a).size() || !t9.i.b("4", ((RecommendContentList) ((List) wVar.f18961a).get(currentItem)).getType())) {
            return;
        }
        com.mobile.brasiltv.utils.i1.D(this.f13733a, "EVENT_RECOMMEND_AD_SHOW_CR", currentItem + 1);
    }

    public final void p(BaseViewHolder baseViewHolder, m mVar) {
        ((TextView) baseViewHolder.getView(R.id.mColumnNameTv)).setText(this.f13733a.getResources().getString(R.string.cr_featured_categories));
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new View.OnClickListener() { // from class: g5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.q(k.this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f13733a, 3));
        recyclerView.addItemDecoration(new BottomDecoration(AutoUtils.getPercentHeightSize(9)));
        if (com.mobile.brasiltv.utils.b0.I(mVar.a())) {
            r rVar = new r(this.f13733a, this.f13734b);
            recyclerView.setAdapter(rVar);
            rVar.setNewData(mVar.a());
        }
    }

    public final void r(BaseViewHolder baseViewHolder, e1 e1Var) {
        SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) baseViewHolder.getView(R.id.mSanvNativeContainer);
        if (e1Var.a().isShowAllAd()) {
            smallAdNativeContainer.setKeep(true);
            smallAdNativeContainer.loadAd(e1Var, true);
        } else if (!e1Var.a().isShowOwnAd()) {
            smallAdNativeContainer.hideView(true);
            return;
        } else {
            smallAdNativeContainer.setKeep(true);
            smallAdNativeContainer.loadOwn(e1Var, true);
        }
        if (this.f13737e.contains(smallAdNativeContainer)) {
            return;
        }
        List list = this.f13737e;
        t9.i.f(smallAdNativeContainer, "adView");
        list.add(smallAdNativeContainer);
    }

    public final void s(BaseViewHolder baseViewHolder, final n nVar) {
        String alias;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mColumnNameTv);
        ChildColumnList a10 = nVar.a();
        if (a10 != null) {
            if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new View.OnClickListener() { // from class: g5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.t(k.this, nVar, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13733a, 0, false));
        List c10 = nVar.c();
        String str = "";
        if (c10 == null || c10.isEmpty()) {
            ArrayList arrayList = new ArrayList(10);
            for (int i10 = 0; i10 < 10; i10++) {
                arrayList.add("");
            }
            z1 z1Var = new z1(false, 1, null);
            recyclerView.setAdapter(z1Var);
            z1Var.setNewData(arrayList);
            return;
        }
        Context context = this.f13733a;
        ChildColumnList a11 = nVar.a();
        int id = a11 != null ? a11.getId() : -1;
        StringBuilder sb = new StringBuilder();
        String alias2 = this.f13734b.getAlias();
        if (alias2 == null) {
            alias2 = "";
        }
        sb.append(alias2);
        sb.append('/');
        ChildColumnList a12 = nVar.a();
        if (a12 != null && (alias = a12.getAlias()) != null) {
            str = alias;
        }
        sb.append(str);
        y1 y1Var = new y1(context, id, false, true, true, sb.toString());
        recyclerView.setAdapter(y1Var);
        y1Var.setNewData(nVar.c());
    }

    public final void u(BaseViewHolder baseViewHolder, f3 f3Var) {
        AdaptiveAdContainer adaptiveAdContainer = (AdaptiveAdContainer) baseViewHolder.getView(R.id.mAavSmartContainer);
        if (!a6.a.f228a.s()) {
            adaptiveAdContainer.hideView(true);
            return;
        }
        if (!this.f13737e.contains(adaptiveAdContainer)) {
            List list = this.f13737e;
            t9.i.f(adaptiveAdContainer, "adView");
            list.add(adaptiveAdContainer);
        }
        adaptiveAdContainer.loadAd(f3Var, true);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(multiItemEntity, PlistBuilder.KEY_ITEM);
        int itemType = multiItemEntity.getItemType();
        a6.d dVar = a6.d.f249a;
        if (itemType == dVar.a()) {
            j(baseViewHolder, (l) multiItemEntity);
            return;
        }
        if (itemType == dVar.b()) {
            p(baseViewHolder, (m) multiItemEntity);
            return;
        }
        if (itemType == dVar.c()) {
            s(baseViewHolder, (n) multiItemEntity);
        } else if (itemType == dVar.h()) {
            r(baseViewHolder, (e1) multiItemEntity);
        } else if (itemType == dVar.k()) {
            u(baseViewHolder, (f3) multiItemEntity);
        }
    }

    public final boolean w() {
        return this.f13735c;
    }

    public final boolean x() {
        return this.f13736d;
    }

    public final void y(boolean z10) {
        Iterator it = this.f13737e.iterator();
        while (it.hasNext()) {
            ((IAdView) it.next()).hostVisibilityChange(this.f13735c && this.f13736d, z10);
        }
    }

    public final void z(boolean z10) {
        this.f13735c = z10;
        y(!z10);
    }
}
