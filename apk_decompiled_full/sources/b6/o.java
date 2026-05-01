package b6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ColumnListAty;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.mobile.brasiltv.view.adView.AdaptiveAdContainer;
import com.mobile.brasiltv.view.adView.AdaptiveAdView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ShelveAsset;
import w6.i;

/* loaded from: classes3.dex */
public final class o extends b6.e<l6.l> implements i6.m, SwipeRefreshLayout.j, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: v, reason: collision with root package name */
    public static final a f4814v = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public int f4815i;

    /* renamed from: o, reason: collision with root package name */
    public l6.l f4821o;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4825s;

    /* renamed from: t, reason: collision with root package name */
    public int f4826t;

    /* renamed from: u, reason: collision with root package name */
    public Map f4827u = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f4816j = h9.h.b(new f());

    /* renamed from: k, reason: collision with root package name */
    public final h9.g f4817k = h9.h.b(new e());

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f4818l = h9.h.b(new b());

    /* renamed from: m, reason: collision with root package name */
    public final h9.g f4819m = h9.h.b(new i());

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f4820n = h9.h.b(new c());

    /* renamed from: p, reason: collision with root package name */
    public final h9.g f4822p = h9.h.b(new g());

    /* renamed from: q, reason: collision with root package name */
    public int f4823q = 21;

    /* renamed from: r, reason: collision with root package name */
    public int f4824r = 1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            Bundle arguments = o.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("columnId") : 0);
        }
    }

    public static final class c extends t9.j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            Bundle arguments = o.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("iscr") : false);
        }
    }

    public static final class d implements AdaptiveAdView.AdaptiveAdCallback {
        public d() {
        }

        @Override // com.mobile.brasiltv.view.adView.AdaptiveAdView.AdaptiveAdCallback
        public void onAdFailedToLoad() {
            ((TextView) o.this.h3(R$id.mTvNoAd)).setVisibility(8);
        }

        @Override // com.mobile.brasiltv.view.adView.AdaptiveAdView.AdaptiveAdCallback
        public void onAdLoaded() {
            ((TextView) o.this.h3(R$id.mTvNoAd)).setVisibility(0);
        }
    }

    public static final class e extends t9.j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            Bundle arguments = o.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("COLUMN_FREE") : false);
        }
    }

    public static final class f extends t9.j implements s9.a {
        public f() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            Bundle arguments = o.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("COLUMN_INDEX") : 0);
        }
    }

    public static final class g extends t9.j implements s9.a {
        public g() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.w invoke() {
            return new g5.w(o.this.Z2());
        }
    }

    public static final class h implements KoocanEmptyView.ReloadListener {
        public h() {
        }

        @Override // com.mobile.brasiltv.view.KoocanEmptyView.ReloadListener
        public void onClick() {
            o.this.a3().m(o.this.i3(), o.this.o3(), o.this.n3());
        }
    }

    public static final class i extends t9.j implements s9.a {
        public i() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            String string;
            Bundle arguments = o.this.getArguments();
            return (arguments == null || (string = arguments.getString("tdc_from")) == null) ? "" : string;
        }
    }

    public static final void q3(o oVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(oVar, "this$0");
        a7.d dVar = a7.d.f279a;
        ShelveAsset shelveAsset = (ShelveAsset) oVar.l3().getData().get(i10);
        String o10 = dVar.o(shelveAsset != null ? shelveAsset.getPosterList() : null, dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        Activity Z2 = oVar.Z2();
        t9.i.e(Z2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.r((f5.c) Z2, ((ShelveAsset) oVar.l3().getData().get(i10)).getType(), ((ShelveAsset) oVar.l3().getData().get(i10)).getProgramType(), ((ShelveAsset) oVar.l3().getData().get(i10)).getContentId(), EnterType.CATEGORY, com.mobile.brasiltv.utils.b0.c(ba.t.W(((ShelveAsset) oVar.l3().getData().get(i10)).getAlias()).toString(), ba.t.W(((ShelveAsset) oVar.l3().getData().get(i10)).getName()).toString()), oVar.r3(), ColumnListAty.f7853t.b(), oVar.i3(), oVar.Z0(), str);
    }

    public static final void t3(o oVar, View view) {
        Context context;
        t9.i.g(oVar, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("beVipUrl:");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.g());
        com.mobile.brasiltv.utils.b0.U(oVar, sb.toString());
        if (!(cVar.g().length() > 0) || (context = oVar.getContext()) == null) {
            return;
        }
        com.mobile.brasiltv.utils.b0.j0(context, cVar.g(), false, true, false, false, 24, null);
    }

    @Override // k5.a
    public void T2() {
        if (l3().getData().size() == 0) {
            a3().m(i3(), this.f4823q, this.f4824r);
        }
    }

    @Override // k5.a
    public void U2() {
        super.U2();
        if (Q2()) {
            int i10 = R$id.mRefreshLayout;
            if (((SwipeRefreshLayout) h3(i10)) != null && ((SwipeRefreshLayout) h3(i10)).isRefreshing()) {
                ((SwipeRefreshLayout) h3(i10)).setRefreshing(false);
                this.f4825s = false;
            }
        }
        if (Q2() && l3().isLoading()) {
            l3().loadMoreComplete();
        }
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4827u.clear();
    }

    @Override // b6.e
    public void Y2() {
        int i10 = R$id.mRefreshLayout;
        ((SwipeRefreshLayout) h3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) h3(i10)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) h3(i10)).setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        p3();
        s3();
    }

    public final String Z0() {
        return (String) this.f4819m.getValue();
    }

    @Override // i6.m
    public void a() {
        int i10 = R$id.frag_column_loadingView;
        if (((KoocanEmptyView) h3(i10)) == null) {
            return;
        }
        if (l3().getData().size() != 0) {
            ((KoocanEmptyView) h3(i10)).setVisibility(8);
        } else {
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
            l3().setEnableLoadMore(false);
        }
    }

    @Override // i6.m
    public void b() {
        l3().loadMoreEnd();
        ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setEnabled(true);
        if (l3().getData().size() == 0) {
            int i10 = R$id.frag_column_loadingView;
            ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
        }
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_column_list;
    }

    @Override // i6.m
    public void g(List list, int i10) {
        t9.i.g(list, "data");
        if (i10 == 0) {
            ((KoocanEmptyView) h3(R$id.frag_column_loadingView)).setVisibility(8);
            l3().addData((Collection) list);
            l3().setEnableLoadMore(true);
        } else if (i10 == 1) {
            l3().getData().clear();
            l3().setNewData(list);
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setRefreshing(false);
            l3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            if (list.size() < this.f4823q) {
                l3().loadMoreEnd();
            } else {
                l3().loadMoreComplete();
            }
            l3().addData((Collection) list);
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setEnabled(true);
        }
        if (l3().getData().size() == 0) {
            l3().setEmptyView(new KoocanEmptyView(getContext(), KoocanEmptyView.Type.NO_CONTENT));
        }
        this.f4826t = list.size();
        l3().notifyDataSetChanged();
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f4827u;
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

    public int i3() {
        return ((Number) this.f4818l.getValue()).intValue();
    }

    public final boolean j3() {
        return ((Boolean) this.f4817k.getValue()).booleanValue();
    }

    public final int k3() {
        return ((Number) this.f4816j.getValue()).intValue();
    }

    public final g5.w l3() {
        return (g5.w) this.f4822p.getValue();
    }

    @Override // b6.e
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public l6.l a3() {
        l6.l lVar = this.f4821o;
        if (lVar != null) {
            return lVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final int n3() {
        return this.f4824r;
    }

    public final int o3() {
        return this.f4823q;
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v3(new l6.l(this, this));
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.f4825s = false;
        this.f4824r++;
        int i10 = R$id.mRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) h3(i10);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
        int size = l3().getData().size();
        int i11 = this.f4823q;
        if (size < i11) {
            l3().loadMoreEnd(false);
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) h3(i10);
            if (swipeRefreshLayout2 == null) {
                return;
            }
            swipeRefreshLayout2.setEnabled(true);
            return;
        }
        if (this.f4826t >= i11) {
            a3().l(i3(), this.f4823q, this.f4824r);
            return;
        }
        SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) h3(i10);
        if (swipeRefreshLayout3 != null) {
            swipeRefreshLayout3.setEnabled(true);
        }
        l3().loadMoreEnd(false);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        this.f4824r = 1;
        l3().setEnableLoadMore(false);
        this.f4825s = true;
        a3().n(i3(), this.f4823q, this.f4824r);
    }

    @Override // b6.e, k5.a, u8.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AdaptiveAdContainer adaptiveAdContainer;
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        if (Q2() && getUserVisibleHint() && (adaptiveAdContainer = (AdaptiveAdContainer) h3(R$id.mAavContainer)) != null) {
            adaptiveAdContainer.hostVisibilityChange(true, true);
        }
    }

    @Override // i6.m
    public void p(String str, int i10) {
        t9.i.g(str, "errorCode");
        int i11 = R$id.frag_column_loadingView;
        ((KoocanEmptyView) h3(i11)).setVisibility(8);
        com.mobile.brasiltv.utils.j1.h(Z2(), str);
        if (i10 == 0) {
            ((KoocanEmptyView) h3(i11)).setReloadListener(new h());
            ((KoocanEmptyView) h3(i11)).setVisibility(0);
            ((KoocanEmptyView) h3(i11)).changeType(KoocanEmptyView.Type.NO_WIFI);
        } else if (i10 == 1) {
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setRefreshing(false);
            l3().setEnableLoadMore(true);
        } else {
            if (i10 != 2) {
                return;
            }
            this.f4824r--;
            ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).setEnabled(true);
            l3().loadMoreFail();
        }
    }

    public final void p3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Z2(), 3);
        int i10 = R$id.columnListRv;
        ((RecyclerView) h3(i10)).setLayoutManager(gridLayoutManager);
        l3().setOnLoadMoreListener(this, (RecyclerView) h3(i10));
        l3().setLoadMoreView(new RecyclerLoadMoreView());
        l3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) h3(i10)).setAdapter(l3());
        this.f4815i = l3().getData().size();
        l3().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: b6.m
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                o.q3(o.this, baseQuickAdapter, view, i11);
            }
        });
    }

    public final boolean r3() {
        return ((Boolean) this.f4820n.getValue()).booleanValue();
    }

    public final void s3() {
        g5.f3 f3Var;
        if (j3()) {
            if (k3() == 0) {
                Context context = getContext();
                t9.i.d(context);
                String string = context.getString(R.string.free_movie_list_ad_id);
                t9.i.f(string, "context!!.getString(R.st…ng.free_movie_list_ad_id)");
                f3Var = new g5.f3(string, a6.a.f228a.f(), true);
            } else {
                f3Var = null;
            }
            if (f3Var == null) {
                return;
            }
            int i10 = R$id.mAavContainer;
            AdaptiveAdContainer adaptiveAdContainer = (AdaptiveAdContainer) h3(i10);
            t9.i.f(adaptiveAdContainer, "mAavContainer");
            AdaptiveAdContainer.loadAd$default(adaptiveAdContainer, f3Var, false, 2, null);
            ((AdaptiveAdContainer) h3(i10)).setAdaptiveAdCallback(new d());
            ((TextView) h3(R$id.mTvNoAd)).setOnClickListener(new View.OnClickListener() { // from class: b6.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.t3(o.this, view);
                }
            });
        }
    }

    @Override // k5.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        AdaptiveAdContainer adaptiveAdContainer;
        super.setUserVisibleHint(z10);
        if (j3() && Q2() && (adaptiveAdContainer = (AdaptiveAdContainer) h3(R$id.mAavContainer)) != null) {
            adaptiveAdContainer.hostVisibilityChange(getUserVisibleHint(), true);
        }
    }

    public final void u3() {
        int i10 = R$id.columnListRv;
        if (((RecyclerView) h3(i10)) == null || ((RecyclerView) h3(i10)).getAdapter() == null) {
            return;
        }
        RecyclerView.g adapter = ((RecyclerView) h3(i10)).getAdapter();
        t9.i.d(adapter);
        if (adapter.getItemCount() == 0) {
            return;
        }
        ((RecyclerView) h3(i10)).smoothScrollToPosition(0);
    }

    public void v3(l6.l lVar) {
        t9.i.g(lVar, "<set-?>");
        this.f4821o = lVar;
    }
}
