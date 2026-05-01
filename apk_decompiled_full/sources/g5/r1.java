package g5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.advertlib.bean.AdInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.activity.SpecialAty;
import com.mobile.brasiltv.activity.TopTenActivity;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.view.adView.AdaptiveAdContainer;
import com.mobile.brasiltv.view.adView.IAdView;
import com.mobile.brasiltv.view.adView.ReportImageView;
import com.mobile.brasiltv.view.adView.SmallAdNativeContainer;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.Recommend;
import mobile.com.requestframe.utils.response.RecommendContentList;
import mobile.com.requestframe.utils.response.ShelveAsset;
import w6.i;

/* loaded from: classes3.dex */
public final class r1 extends j5.b {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f13857a;

    /* renamed from: b, reason: collision with root package name */
    public ChildColumnList f13858b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13859c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13860d;

    /* renamed from: e, reason: collision with root package name */
    public final List f13861e;

    /* renamed from: f, reason: collision with root package name */
    public BGABanner f13862f;

    /* renamed from: g, reason: collision with root package name */
    public d f13863g;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f13865b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView) {
            super(1);
            this.f13865b = imageView;
        }

        public final void b(PosterList posterList) {
            a7.e eVar = a7.e.f288a;
            Activity K = r1.this.K();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f13865b;
            t9.i.f(imageView, "ivBanner");
            eVar.b(K, fileUrl, imageView, R.drawable.column_image_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f13866a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f13866a = imageView;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13866a.setImageResource(R.drawable.column_image_placeholder);
        }
    }

    public static final class c implements v1.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f13868b;

        public c(List list) {
            this.f13868b = list;
        }

        @Override // v1.a
        public void a(String str) {
            t9.i.g(str, "mediaType");
            s1.m mVar = s1.m.f18686a;
            Activity K = r1.this.K();
            a6.a aVar = a6.a.f228a;
            String h10 = aVar.h();
            i.c cVar = w6.i.f19214g;
            List A = mVar.A(K, h10, cVar.I(), true, cVar.r());
            if (A == null || A.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(i9.r.G(A));
            arrayList.addAll(this.f13868b);
            BGABanner bGABanner = r1.this.f13862f;
            t9.i.d(bGABanner);
            bGABanner.setAutoPlayAble(arrayList.size() > 1);
            BGABanner bGABanner2 = r1.this.f13862f;
            t9.i.d(bGABanner2);
            bGABanner2.setData(R.layout.item_bga_banner_recommend, arrayList, (List<String>) null);
            r1.this.f13863g.b(arrayList);
            r1.this.f13863g.a(aVar.h());
            BGABanner bGABanner3 = r1.this.f13862f;
            t9.i.d(bGABanner3);
            bGABanner3.getViewPager().addOnPageChangeListener(r1.this.f13863g);
            mVar.d0(r1.this.K(), aVar.h(), ((AdInfo) A.get(0)).getAd_id());
        }
    }

    public static final class d extends ViewPager.n {

        /* renamed from: b, reason: collision with root package name */
        public List f13870b;

        /* renamed from: a, reason: collision with root package name */
        public String f13869a = "";

        /* renamed from: c, reason: collision with root package name */
        public String f13871c = "";

        public d() {
        }

        public final void a(String str) {
            t9.i.g(str, "<set-?>");
            this.f13871c = str;
        }

        public final void b(List list) {
            this.f13870b = list;
        }

        public final void c(String str) {
            t9.i.g(str, "<set-?>");
            this.f13869a = str;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            List list = this.f13870b;
            if (list != null) {
                r1 r1Var = r1.this;
                if ((list != null ? list.size() : 0) > 0 && r1Var.L() && r1Var.M()) {
                    List list2 = this.f13870b;
                    int size = i10 % (list2 != null ? list2.size() : 0);
                    if (size < 0 || size >= list.size()) {
                        return;
                    }
                    Object obj = list.get(size);
                    if ((obj instanceof RecommendContentList) && t9.i.b("4", ((RecommendContentList) obj).getType())) {
                        r1Var.P(this.f13869a, size);
                    }
                    if (obj instanceof AdInfo) {
                        s1.m.f18686a.d0(r1Var.K(), this.f13871c, ((AdInfo) obj).getAd_id());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(Activity activity, ChildColumnList childColumnList) {
        super(i9.j.d());
        t9.i.g(activity, com.umeng.analytics.pro.f.X);
        t9.i.g(childColumnList, "parentColumn");
        this.f13857a = activity;
        this.f13858b = childColumnList;
        this.f13860d = true;
        this.f13861e = new ArrayList();
        a6.d dVar = a6.d.f249a;
        addItemType(dVar.i(), R.layout.adapter_recommend_item);
        addItemType(dVar.h(), R.layout.item_native_ad);
        addItemType(dVar.k(), R.layout.item_smart_ad);
        addItemType(dVar.e(), R.layout.item_recommend_banner);
        addItemType(dVar.g(), R.layout.item_home_first_banner);
        addItemType(dVar.f(), R.layout.item_free_entrance);
        addItemType(dVar.l(), R.layout.adapter_recommend_item);
        addItemType(dVar.j(), R.layout.adapter_home_special_new_item);
        addItemType(dVar.d(), R.layout.adapter_home_top_new);
        this.f13863g = new d();
    }

    public static final void C(p2 p2Var, r1 r1Var, View view) {
        String alias;
        String name;
        t9.i.g(p2Var, "$recommendSpecialItem");
        t9.i.g(r1Var, "this$0");
        ChildColumnList a10 = p2Var.a();
        String str = (a10 == null || (name = a10.getName()) == null) ? "" : name;
        ChildColumnList a11 = p2Var.a();
        String str2 = (a11 == null || (alias = a11.getAlias()) == null) ? "" : alias;
        ChildColumnList a12 = p2Var.a();
        HomeRecommend homeRecommend = new HomeRecommend(str, str2, Integer.valueOf(a12 != null ? a12.getId() : 0), "", "", "", "", null, null, null, null);
        Activity activity = r1Var.f13857a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.u((f5.c) activity, homeRecommend);
    }

    public static final void D(r1 r1Var, p2 p2Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        String alias;
        t9.i.g(r1Var, "this$0");
        t9.i.g(p2Var, "$recommendSpecialItem");
        Object obj = baseQuickAdapter.getData().get(i10);
        ShelveAsset shelveAsset = obj instanceof ShelveAsset ? (ShelveAsset) obj : null;
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(shelveAsset != null ? shelveAsset.getPosterList() : null, dVar.g());
        String str = o10 == null ? "" : o10;
        Activity activity = r1Var.f13857a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        f5.c cVar = (f5.c) activity;
        String type = shelveAsset != null ? shelveAsset.getType() : null;
        String programType = shelveAsset != null ? shelveAsset.getProgramType() : null;
        String contentId = shelveAsset != null ? shelveAsset.getContentId() : null;
        EnterType enterType = EnterType.HOME;
        String name = (shelveAsset == null || (alias = shelveAsset.getAlias()) == null) ? shelveAsset != null ? shelveAsset.getName() : null : alias;
        ChildColumnList a10 = p2Var.a();
        int id = a10 != null ? a10.getId() : 0;
        StringBuilder sb = new StringBuilder();
        String alias2 = r1Var.f13858b.getAlias();
        sb.append(alias2 != null ? alias2 : "");
        sb.append('/');
        ChildColumnList a11 = p2Var.a();
        sb.append(a11 != null ? a11.getAlias() : null);
        com.mobile.brasiltv.utils.b0.r(cVar, type, programType, contentId, enterType, name, false, false, id, sb.toString(), str);
    }

    public static final void G(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        if (RootColumnId.specialColumn == null) {
            return;
        }
        Activity activity = r1Var.f13857a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.c0((f5.c) activity, SpecialAty.class);
    }

    public static final void I(r1 r1Var, o2 o2Var, View view) {
        t9.i.g(r1Var, "this$0");
        t9.i.g(o2Var, "$homeFragTopItem");
        Intent intent = new Intent(r1Var.f13857a, (Class<?>) TopTenActivity.class);
        Bundle bundle = new Bundle();
        TopTenActivity.a aVar = TopTenActivity.f8214v;
        String c10 = aVar.c();
        ChildColumnList a10 = o2Var.a();
        bundle.putSerializable(c10, a10 != null ? a10.getName() : null);
        String a11 = aVar.a();
        ChildColumnList a12 = o2Var.a();
        bundle.putSerializable(a11, a12 != null ? a12.getAlias() : null);
        String b10 = aVar.b();
        ChildColumnList a13 = o2Var.a();
        bundle.putSerializable(b10, a13 != null ? Integer.valueOf(a13.getId()) : null);
        intent.putExtras(bundle);
        r1Var.f13857a.startActivity(intent);
    }

    public static final void q(BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) view).setImageResource(R.drawable.column_image_placeholder);
    }

    public static final void r(r1 r1Var, BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.g(r1Var, "this$0");
        ImageView imageView = (ImageView) view.findViewById(R.id.mIvBanner);
        TextView textView = (TextView) view.findViewById(R.id.mTvAdFlag);
        if (obj instanceof RecommendContentList) {
            a7.d dVar = a7.d.f279a;
            Observable c10 = dVar.c(((RecommendContentList) obj).getPosterList(), dVar.f());
            final a aVar = r1Var.new a(imageView);
            Consumer consumer = new Consumer() { // from class: g5.q1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    r1.s(s9.l.this, obj2);
                }
            };
            final b bVar = new b(imageView);
            c10.subscribe(consumer, new Consumer() { // from class: g5.h1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    r1.t(s9.l.this, obj2);
                }
            });
            textView.setVisibility(8);
            return;
        }
        if (!(obj instanceof AdInfo)) {
            imageView.setImageResource(R.drawable.column_image_placeholder);
            textView.setVisibility(8);
            return;
        }
        s1.m mVar = s1.m.f18686a;
        Activity activity = r1Var.f13857a;
        t9.i.f(imageView, "ivBanner");
        AdInfo adInfo = (AdInfo) obj;
        mVar.g0(activity, imageView, adInfo.getMedia_type(), adInfo, (r23 & 16) != 0 ? null : Integer.valueOf(R.drawable.column_image_placeholder), (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
        if (adInfo.isShowFlag()) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    public static final void s(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(r1 r1Var, s1 s1Var, String str, BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.g(r1Var, "this$0");
        t9.i.g(s1Var, "$recommendFragBannerItem");
        if (!(obj instanceof RecommendContentList)) {
            if (obj instanceof AdInfo) {
                AdInfo adInfo = (AdInfo) obj;
                String action = adInfo.getAction();
                if ((action == null || action.length() == 0) || !t9.i.b(adInfo.getAction_type(), "1")) {
                    if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                        com.mobile.brasiltv.utils.b0.m(r1Var.f13857a);
                        return;
                    }
                    return;
                } else {
                    a6.a.u(a6.a.f228a, r1Var.f13857a, adInfo.getAction(), false, 4, null);
                    s1.q qVar = s1.q.f18727a;
                    Activity activity = r1Var.f13857a;
                    qVar.h(activity, d6.b.f12660a.m(activity), adInfo.getMedia_type(), adInfo);
                    return;
                }
            }
            return;
        }
        RecommendContentList recommendContentList = (RecommendContentList) obj;
        if (t9.i.b("4", recommendContentList.getType())) {
            String url = recommendContentList.getUrl();
            if (url == null || url.length() == 0) {
                return;
            }
            r1Var.O(s1Var.a(), i10);
            com.mobile.brasiltv.utils.b0.j0(r1Var.f13857a, recommendContentList.getUrl(), false, true, false, false, 24, null);
            return;
        }
        a7.d dVar = a7.d.f279a;
        String n10 = dVar.n(recommendContentList.getPosterList(), dVar.f());
        String str2 = n10 == null ? "" : n10;
        Activity activity2 = r1Var.f13857a;
        t9.i.e(activity2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        f5.c cVar = (f5.c) activity2;
        String type = recommendContentList.getType();
        String programType = recommendContentList.getProgramType();
        String contentId = recommendContentList.getContentId();
        EnterType enterType = EnterType.BANNER;
        String name = recommendContentList.getName();
        String obj2 = name != null ? ba.t.W(name).toString() : null;
        int b10 = s1Var.b();
        StringBuilder sb = new StringBuilder();
        String alias = r1Var.f13858b.getAlias();
        if (alias == null) {
            alias = "";
        }
        sb.append(alias);
        sb.append('/');
        sb.append(str != null ? str : "");
        com.mobile.brasiltv.utils.b0.r(cVar, type, programType, contentId, enterType, obj2, false, false, b10, sb.toString(), str2);
    }

    public static final void w(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        Activity activity = r1Var.f13857a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.k((f5.c) activity, RootColumnId.freeVodColumn, -1, false);
    }

    public static final void z(t1 t1Var, r1 r1Var, View view) {
        String alias;
        String name;
        t9.i.g(t1Var, "$recommendFragItem");
        t9.i.g(r1Var, "this$0");
        ChildColumnList a10 = t1Var.a();
        String str = (a10 == null || (name = a10.getName()) == null) ? "" : name;
        ChildColumnList a11 = t1Var.a();
        String str2 = (a11 == null || (alias = a11.getAlias()) == null) ? "" : alias;
        ChildColumnList a12 = t1Var.a();
        HomeRecommend homeRecommend = new HomeRecommend(str, str2, Integer.valueOf(a12 != null ? a12.getId() : 0), "", "", "", "", null, null, null, null);
        Activity activity = r1Var.f13857a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.u((f5.c) activity, homeRecommend);
    }

    public final void A(BaseViewHolder baseViewHolder, e1 e1Var) {
        SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) baseViewHolder.getView(R.id.mSanvNativeContainer);
        if (e1Var.a().isShowAllAd()) {
            smallAdNativeContainer.setKeep(true);
            t9.i.f(smallAdNativeContainer, "adView");
            SmallAdNativeContainer.loadAd$default(smallAdNativeContainer, e1Var, false, 2, null);
        } else if (!e1Var.a().isShowOwnAd()) {
            t9.i.f(smallAdNativeContainer, "adView");
            SmallAdNativeContainer.hideView$default(smallAdNativeContainer, false, 1, null);
            return;
        } else {
            smallAdNativeContainer.setKeep(true);
            t9.i.f(smallAdNativeContainer, "adView");
            SmallAdNativeContainer.loadOwn$default(smallAdNativeContainer, e1Var, false, 2, null);
        }
        if (this.f13861e.contains(smallAdNativeContainer)) {
            return;
        }
        this.f13861e.add(smallAdNativeContainer);
    }

    public final void B(BaseViewHolder baseViewHolder, final p2 p2Var) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvColumnName);
        ChildColumnList a10 = p2Var.a();
        if (a10 != null) {
            if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new View.OnClickListener() { // from class: g5.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r1.C(p2.this, this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13857a, 0, false));
        g2 g2Var = new g2(this.f13857a);
        recyclerView.setAdapter(g2Var);
        List b10 = p2Var.b();
        g2Var.setNewData(b10 != null ? i9.r.D(b10, 10) : null);
        g2Var.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: g5.i1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                r1.D(r1.this, p2Var, baseQuickAdapter, view, i10);
            }
        });
    }

    public final void E(BaseViewHolder baseViewHolder, f3 f3Var) {
        AdaptiveAdContainer adaptiveAdContainer = (AdaptiveAdContainer) baseViewHolder.getView(R.id.mAavSmartContainer);
        if (!a6.a.f228a.s()) {
            t9.i.f(adaptiveAdContainer, "adView");
            AdaptiveAdContainer.hideView$default(adaptiveAdContainer, false, 1, null);
            return;
        }
        if (!this.f13861e.contains(adaptiveAdContainer)) {
            List list = this.f13861e;
            t9.i.f(adaptiveAdContainer, "adView");
            list.add(adaptiveAdContainer);
        }
        t9.i.f(adaptiveAdContainer, "adView");
        AdaptiveAdContainer.loadAd$default(adaptiveAdContainer, f3Var, false, 2, null);
    }

    public final void F(BaseViewHolder baseViewHolder, u1 u1Var) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.mColumnNameTv);
        ChildColumnList a10 = u1Var.a();
        if (a10 != null) {
            if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new View.OnClickListener() { // from class: g5.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r1.G(r1.this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13857a, 0, false));
        d2 d2Var = new d2(this.f13857a);
        recyclerView.setAdapter(d2Var);
        List b10 = u1Var.b();
        d2Var.setNewData(b10 != null ? i9.r.D(b10, 10) : null);
    }

    public final void H(BaseViewHolder baseViewHolder, final o2 o2Var) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvColumnName);
        ChildColumnList a10 = o2Var.a();
        if (a10 != null) {
            if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mIvMore)).setOnClickListener(new View.OnClickListener() { // from class: g5.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r1.I(r1.this, o2Var, view);
            }
        });
        List b10 = o2Var.b();
        if (b10 == null || b10.isEmpty()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRvContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13857a, 0, false));
        List b11 = o2Var.b();
        List D = b11 != null ? i9.r.D(b11, 10) : null;
        Activity activity = this.f13857a;
        ChildColumnList a11 = o2Var.a();
        int id = a11 != null ? a11.getId() : 0;
        t9.i.d(D);
        StringBuilder sb = new StringBuilder();
        String alias = this.f13858b.getAlias();
        if (alias == null) {
            alias = "";
        }
        sb.append(alias);
        sb.append('/');
        ChildColumnList a12 = o2Var.a();
        sb.append(a12 != null ? a12.getAlias() : null);
        k2 k2Var = new k2(activity, id, D, sb.toString());
        recyclerView.setAdapter(k2Var);
        k2Var.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(multiItemEntity, PlistBuilder.KEY_ITEM);
        int itemType = multiItemEntity.getItemType();
        a6.d dVar = a6.d.f249a;
        if (itemType == dVar.i()) {
            y(baseViewHolder, (t1) multiItemEntity);
            return;
        }
        if (itemType == dVar.h()) {
            A(baseViewHolder, (e1) multiItemEntity);
            return;
        }
        if (itemType == dVar.k()) {
            E(baseViewHolder, (f3) multiItemEntity);
            return;
        }
        if (itemType == dVar.e()) {
            p(baseViewHolder, (s1) multiItemEntity);
            return;
        }
        if (itemType == dVar.g()) {
            androidx.appcompat.app.m.a(multiItemEntity);
            x(baseViewHolder, null);
            return;
        }
        if (itemType == dVar.f()) {
            v(baseViewHolder, (b0) multiItemEntity);
            return;
        }
        if (itemType == dVar.l()) {
            F(baseViewHolder, (u1) multiItemEntity);
        } else if (itemType == dVar.d()) {
            H(baseViewHolder, (o2) multiItemEntity);
        } else if (itemType == dVar.j()) {
            B(baseViewHolder, (p2) multiItemEntity);
        }
    }

    public final Activity K() {
        return this.f13857a;
    }

    public final boolean L() {
        return this.f13859c;
    }

    public final boolean M() {
        return this.f13860d;
    }

    public final void N(boolean z10) {
        Iterator it = this.f13861e.iterator();
        while (it.hasNext()) {
            ((IAdView) it.next()).hostVisibilityChange(this.f13859c && this.f13860d, z10);
        }
    }

    public final void O(String str, int i10) {
        String str2;
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (t9.i.b(str, sb.toString())) {
            str2 = "EVENT_RECOMMEND_AD_CLICK_MOVIE";
        } else {
            if (t9.i.b(str, cVar.v() + "_series")) {
                str2 = "EVENT_RECOMMEND_AD_CLICK_SERIES";
            } else {
                if (t9.i.b(str, cVar.v() + "_kids")) {
                    str2 = "EVENT_RECOMMEND_AD_CLICK_KIDS";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cVar.v());
                    sb2.append("_animes");
                    str2 = t9.i.b(str, sb2.toString()) ? "EVENT_RECOMMEND_AD_CLICK_ANIME" : "";
                }
            }
        }
        com.mobile.brasiltv.utils.i1.D(this.f13857a, str2, i10 + 1);
    }

    public final void P(String str, int i10) {
        String str2;
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (t9.i.b(str, sb.toString())) {
            str2 = "EVENT_RECOMMEND_AD_SHOW_MOVIE";
        } else {
            if (t9.i.b(str, cVar.v() + "_series")) {
                str2 = "EVENT_RECOMMEND_AD_SHOW_SERIES";
            } else {
                if (t9.i.b(str, cVar.v() + "_kids")) {
                    str2 = "EVENT_RECOMMEND_AD_SHOW_KIDS";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cVar.v());
                    sb2.append("_animes");
                    str2 = t9.i.b(str, sb2.toString()) ? "EVENT_RECOMMEND_AD_SHOW_ANIME" : "";
                }
            }
        }
        com.mobile.brasiltv.utils.i1.D(this.f13857a, str2, i10 + 1);
    }

    public final void Q(boolean z10) {
        this.f13859c = z10;
        N(!z10);
    }

    public final void R(boolean z10) {
        this.f13860d = z10;
        N(true);
    }

    public final void o(boolean z10) {
        BGABanner bGABanner = this.f13862f;
        if ((bGABanner != null ? bGABanner.getItemCount() : 0) > 1) {
            if (z10) {
                BGABanner bGABanner2 = this.f13862f;
                if (bGABanner2 != null) {
                    bGABanner2.startAutoPlay();
                    return;
                }
                return;
            }
            BGABanner bGABanner3 = this.f13862f;
            if (bGABanner3 != null) {
                bGABanner3.stopAutoPlay();
            }
        }
    }

    public final void p(BaseViewHolder baseViewHolder, final s1 s1Var) {
        this.f13862f = (BGABanner) baseViewHolder.getView(R.id.mRecommendBanner);
        boolean z10 = false;
        if (s1Var.c().isEmpty()) {
            BGABanner bGABanner = this.f13862f;
            t9.i.d(bGABanner);
            bGABanner.setAutoPlayAble(false);
            BGABanner bGABanner2 = this.f13862f;
            t9.i.d(bGABanner2);
            bGABanner2.setAdapter(new BGABanner.Adapter() { // from class: g5.k1
                @Override // cn.bingoogolapple.bgabanner.BGABanner.Adapter
                public final void fillBannerItem(BGABanner bGABanner3, View view, Object obj, int i10) {
                    r1.q(bGABanner3, view, obj, i10);
                }
            });
            BGABanner bGABanner3 = this.f13862f;
            t9.i.d(bGABanner3);
            bGABanner3.setData(i9.i.b(Integer.valueOf(R.drawable.column_image_placeholder)), null);
            return;
        }
        List<RecommendContentList> contentList = ((Recommend) s1Var.c().get(0)).getContentList();
        final String recommendCode = ((Recommend) s1Var.c().get(0)).getRecommendCode();
        BGABanner bGABanner4 = this.f13862f;
        t9.i.d(bGABanner4);
        bGABanner4.setAutoPlayAble(contentList.size() > 1);
        BGABanner bGABanner5 = this.f13862f;
        t9.i.d(bGABanner5);
        bGABanner5.setAdapter(new BGABanner.Adapter() { // from class: g5.l1
            @Override // cn.bingoogolapple.bgabanner.BGABanner.Adapter
            public final void fillBannerItem(BGABanner bGABanner6, View view, Object obj, int i10) {
                r1.r(r1.this, bGABanner6, view, obj, i10);
            }
        });
        BGABanner bGABanner6 = this.f13862f;
        t9.i.d(bGABanner6);
        bGABanner6.setData(R.layout.item_bga_banner_recommend, contentList, (List<String>) null);
        BGABanner bGABanner7 = this.f13862f;
        t9.i.d(bGABanner7);
        bGABanner7.setDelegate(new BGABanner.Delegate() { // from class: g5.m1
            @Override // cn.bingoogolapple.bgabanner.BGABanner.Delegate
            public final void onBannerItemClick(BGABanner bGABanner8, View view, Object obj, int i10) {
                r1.u(r1.this, s1Var, recommendCode, bGABanner8, view, obj, i10);
            }
        });
        BGABanner bGABanner8 = this.f13862f;
        t9.i.d(bGABanner8);
        bGABanner8.getViewPager().removeOnPageChangeListener(this.f13863g);
        d dVar = this.f13863g;
        String a10 = s1Var.a();
        if (a10 == null) {
            a10 = "";
        }
        dVar.c(a10);
        this.f13863g.b(contentList);
        BGABanner bGABanner9 = this.f13862f;
        t9.i.d(bGABanner9);
        bGABanner9.getViewPager().addOnPageChangeListener(this.f13863g);
        BGABanner bGABanner10 = this.f13862f;
        t9.i.d(bGABanner10);
        int currentItem = bGABanner10.getViewPager().getCurrentItem() % contentList.size();
        if (currentItem >= 0 && currentItem < contentList.size() && t9.i.b("4", contentList.get(currentItem).getType())) {
            String a11 = s1Var.a();
            P(a11 != null ? a11 : "", currentItem);
        }
        String a12 = s1Var.a();
        if (a12 != null && ba.t.o(a12, "_Recommended", false, 2, null)) {
            z10 = true;
        }
        if (z10) {
            s1.m.T(s1.m.f18686a, new c(contentList), null, 2, null);
        }
    }

    public final void v(BaseViewHolder baseViewHolder, b0 b0Var) {
        ((FrameLayout) baseViewHolder.getView(R.id.llOpenFree)).setOnClickListener(new View.OnClickListener() { // from class: g5.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r1.w(r1.this, view);
            }
        });
    }

    public final void x(BaseViewHolder baseViewHolder, e0 e0Var) {
        ReportImageView reportImageView = (ReportImageView) baseViewHolder.getView(R.id.mIvFirstBannerAd);
        reportImageView.setKeep(true);
        t9.i.f(reportImageView, "ivAd");
        throw null;
    }

    public final void y(BaseViewHolder baseViewHolder, final t1 t1Var) {
        String alias;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mColumnNameTv);
        ChildColumnList a10 = t1Var.a();
        if (a10 != null) {
            if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new View.OnClickListener() { // from class: g5.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r1.z(t1.this, this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13857a, 0, false));
        Activity activity = this.f13857a;
        ChildColumnList a11 = t1Var.a();
        int id = a11 != null ? a11.getId() : -1;
        StringBuilder sb = new StringBuilder();
        String alias2 = this.f13858b.getAlias();
        String str = "";
        if (alias2 == null) {
            alias2 = "";
        }
        sb.append(alias2);
        sb.append('/');
        ChildColumnList a12 = t1Var.a();
        if (a12 != null && (alias = a12.getAlias()) != null) {
            str = alias;
        }
        sb.append(str);
        y1 y1Var = new y1(activity, id, false, true, false, sb.toString(), 16, null);
        recyclerView.setAdapter(y1Var);
        List b10 = t1Var.b();
        y1Var.setNewData(b10 != null ? i9.r.D(b10, 10) : null);
    }
}
