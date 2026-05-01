package b6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b6.q;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.BannerAutoPlayEvent;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.bean.event.HomePageAdEvent;
import com.mobile.brasiltv.bean.event.InterstitialEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.MoveToFirst;
import com.mobile.brasiltv.bean.event.VodPageRestartEvent;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.HomeImportantAdDialog;
import com.mobile.brasiltv.view.dialog.InterstitialDialog;
import com.mobile.brasiltv.view.vod.CouponFloatView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import w6.i;

/* loaded from: classes.dex */
public final class g3 extends e<l6.z1> implements j6.j, SwipeRefreshLayout.j, p, q {

    /* renamed from: k, reason: collision with root package name */
    public InterstitialEvent f4715k;

    /* renamed from: l, reason: collision with root package name */
    public HomePageAdEvent f4716l;

    /* renamed from: m, reason: collision with root package name */
    public l6.z1 f4717m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4718n;

    /* renamed from: o, reason: collision with root package name */
    public CouponFloatView f4719o;

    /* renamed from: p, reason: collision with root package name */
    public Disposable f4720p;

    /* renamed from: r, reason: collision with root package name */
    public Map f4722r = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    public final h9.g f4713i = h9.h.b(new a());

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f4714j = h9.h.b(new b());

    /* renamed from: q, reason: collision with root package name */
    public final c f4721q = new c();

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ChildColumnList invoke() {
            Bundle arguments = g3.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("fragment_bound_key") : null;
            t9.i.e(serializable, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.ChildColumnList");
            return (ChildColumnList) serializable;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.r1 invoke() {
            return new g5.r1(g3.this.Z2(), g3.this.l3());
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends RecyclerView.t {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            t9.i.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i10, i11);
            g3.this.p3();
        }
    }

    public static final void q3(g3 g3Var, View view) {
        t9.i.g(g3Var, "this$0");
        g3Var.a3().b0(g3Var.l3());
        ((KoocanEmptyView) g3Var.h3(R$id.mRecommendLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void r3(g3 g3Var, View view) {
        t9.i.g(g3Var, "this$0");
        g3Var.a3().b0(g3Var.l3());
        ((KoocanEmptyView) g3Var.h3(R$id.mRecommendLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    @Override // b6.q
    public CouponFloatView D0() {
        return this.f4719o;
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void InterstitialMessage(InterstitialEvent interstitialEvent) {
        t9.i.g(interstitialEvent, "event");
        if (RootColumnId.recommendHomeId == -1) {
            String code = l3().getCode();
            StringBuilder sb = new StringBuilder();
            i.c cVar = w6.i.f19214g;
            sb.append(cVar.v());
            sb.append("_Recommended");
            if (t9.i.b(code, sb.toString())) {
                if (t9.i.b(l3().getCode(), cVar.v() + "_Recommended")) {
                    xa.c.c().p(interstitialEvent);
                    this.f4715k = interstitialEvent;
                    if (n3().getData().size() > 0) {
                        v3();
                    }
                }
            }
        }
    }

    @Override // b6.q
    public Disposable P1() {
        return this.f4720p;
    }

    @Override // b6.q
    public void Q1(CouponFloatView couponFloatView) {
        this.f4719o = couponFloatView;
    }

    @Override // k5.a
    public void T2() {
        if (n3().getData().size() == 0 && !t9.i.b(w6.i.f19214g.H(), "")) {
            a3().b0(l3());
        } else {
            n3().notifyDataSetChanged();
            n3().o(true);
        }
    }

    @Override // k5.a
    public void U2() {
        super.U2();
        if (Q2()) {
            n3().o(false);
        }
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4722r.clear();
    }

    @Override // b6.e
    public void Y2() {
        int i10 = R$id.mRefreshLayout;
        ((SwipeRefreshLayout) h3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) h3(i10)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) h3(i10)).setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i11 = R$id.mRecommendRV;
        ((RecyclerView) h3(i11)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) h3(i11)).setHasFixedSize(true);
        ((RecyclerView) h3(i11)).setItemViewCacheSize(1);
        n3().bindToRecyclerView((RecyclerView) h3(i11));
        ((RecyclerView) h3(i11)).setOverScrollMode(2);
        ((RecyclerView) h3(i11)).setAdapter(n3());
        ((RecyclerView) h3(i11)).addOnScrollListener(o3());
        n3().Q(getUserVisibleHint());
    }

    @Override // j6.j
    public void a() {
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) == null || ((SwipeRefreshLayout) h3(R$id.mRefreshLayout)).isRefreshing()) {
            return;
        }
        ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.LOADING);
        ((KoocanEmptyView) h3(i10)).setVisibility(0);
    }

    @Override // j6.j
    public void b() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) h3(R$id.mRefreshLayout);
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) != null) {
            ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) h3(i10)).setVisibility(0);
            ((KoocanEmptyView) h3(i10)).setOnClickListener(new View.OnClickListener() { // from class: b6.e3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g3.q3(g3.this, view);
                }
            });
        }
    }

    @Override // j6.j
    public void c(String str) {
        t9.i.g(str, "errorCode");
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) == null) {
            return;
        }
        ((KoocanEmptyView) h3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
        ((KoocanEmptyView) h3(i10)).setVisibility(0);
        ((AutoLinearLayout) ((KoocanEmptyView) h3(i10))._$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new View.OnClickListener() { // from class: b6.f3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g3.r3(g3.this, view);
            }
        });
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_recommend1;
    }

    @Override // j6.j
    public void f(List list) {
        t9.i.g(list, "columnContentList");
        int i10 = R$id.mRecommendRV;
        if (((RecyclerView) h3(i10)) == null) {
            return;
        }
        ((RecyclerView) h3(i10)).removeOnScrollListener(this.f4721q);
        ((RecyclerView) h3(i10)).addOnScrollListener(this.f4721q);
        n3().setNewData(i9.r.G(list));
        k();
        u3();
        v3();
        p3();
    }

    @Override // b6.p
    public void f1(boolean z10) {
        CouponFloatView D0;
        if (Q2()) {
            n3().R(z10);
        }
        if (z10 || (D0 = D0()) == null) {
            return;
        }
        D0.slideOut(0L);
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f4722r;
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

    @xa.j
    public final void handlerMoveToFirst(MoveToFirst moveToFirst) {
        t9.i.g(moveToFirst, "event");
        if (isResumed()) {
            ((RecyclerView) h3(R$id.mRecommendRV)).smoothScrollToPosition(0);
        }
    }

    @Override // j6.j
    public void k() {
        int i10 = R$id.mRecommendLoadingView;
        if (((KoocanEmptyView) h3(i10)) != null) {
            ((KoocanEmptyView) h3(i10)).setVisibility(8);
        }
        int i11 = R$id.mRefreshLayout;
        if (((SwipeRefreshLayout) h3(i11)) == null || !((SwipeRefreshLayout) h3(i11)).isRefreshing()) {
            return;
        }
        ((SwipeRefreshLayout) h3(i11)).setRefreshing(false);
    }

    public void k3(Context context, ViewGroup viewGroup) {
        q.a.a(this, context, viewGroup);
    }

    public final ChildColumnList l3() {
        return (ChildColumnList) this.f4713i.getValue();
    }

    @Override // b6.e
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public l6.z1 a3() {
        l6.z1 z1Var = this.f4717m;
        if (z1Var != null) {
            return z1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final g5.r1 n3() {
        return (g5.r1) this.f4714j.getValue();
    }

    public RecyclerView.t o3() {
        return q.a.b(this);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onBannerAutoPlayEvent(BannerAutoPlayEvent bannerAutoPlayEvent) {
        t9.i.g(bannerAutoPlayEvent, "event");
        if (Q2() && S2()) {
            n3().o(bannerAutoPlayEvent.getAutoPlay());
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onCouponQualificationEvent(CouponQualificationEvent couponQualificationEvent) {
        t9.i.g(couponQualificationEvent, "event");
        if (this.f4718n) {
            if (couponQualificationEvent.isHasCouponQualification()) {
                Activity Z2 = Z2();
                View b32 = b3();
                t9.i.e(b32, "null cannot be cast to non-null type android.view.ViewGroup");
                k3(Z2, (ViewGroup) b32);
            } else {
                s3();
            }
            CouponFloatView couponFloatView = this.f4719o;
            if (couponFloatView != null) {
                Activity Z22 = Z2();
                t9.i.e(Z22, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
                couponFloatView.setActivity((f5.c) Z22);
            }
        }
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t3(new l6.z1(this, this));
        xa.c.c().o(this);
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        xa.c.c().r(this);
        super.onDestroy();
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onLoginEvent(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        com.mobile.brasiltv.utils.k.f8726a.a();
        String code = l3().getCode();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (!t9.i.b(code, sb.toString())) {
            if (t9.i.b(l3().getCode(), cVar.v() + "_series")) {
                n3().notifyDataSetChanged();
                return;
            }
            return;
        }
        if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
            l6.z1 a32 = a3();
            List data = n3().getData();
            t9.i.f(data, "mRecommendFragAdapter.data");
            a32.G(data);
            n3().notifyDataSetChanged();
            return;
        }
        l6.z1 a33 = a3();
        List data2 = n3().getData();
        t9.i.f(data2, "mRecommendFragAdapter.data");
        a33.c0(data2);
        n3().notifyDataSetChanged();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        k();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        a3().b0(l3());
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onRestart(VodPageRestartEvent vodPageRestartEvent) {
        t9.i.g(vodPageRestartEvent, "event");
        if (S2() && n3().getData().size() == 0 && !t9.i.b(w6.i.f19214g.H(), "")) {
            a3().b0(l3());
        }
    }

    public final void p3() {
        int i10 = R$id.mRecommendRV;
        RecyclerView.o layoutManager = ((RecyclerView) h3(i10)).getLayoutManager();
        t9.i.e(layoutManager, "null cannot be cast to non-null type com.mobile.brasiltv.view.LinearLayoutManagerWrapper");
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = (LinearLayoutManagerWrapper) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManagerWrapper.findFirstVisibleItemPosition();
        int childCount = linearLayoutManagerWrapper.getChildCount() + findFirstVisibleItemPosition;
        a3().N(findFirstVisibleItemPosition, childCount);
        if (childCount >= linearLayoutManagerWrapper.getItemCount()) {
            ((RecyclerView) h3(i10)).removeOnScrollListener(this.f4721q);
        }
    }

    @Override // j6.j
    public void r(int i10) {
        n3().notifyItemChanged(i10);
    }

    public void s3() {
        q.a.c(this);
    }

    @Override // b6.q
    public void setDisposable(Disposable disposable) {
        this.f4720p = disposable;
    }

    @Override // k5.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        CouponFloatView D0;
        super.setUserVisibleHint(z10);
        if (Q2()) {
            n3().Q(getUserVisibleHint());
        }
        if (z10 || (D0 = D0()) == null) {
            return;
        }
        D0.slideOut(0L);
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void showHomePageAdEvent(HomePageAdEvent homePageAdEvent) {
        t9.i.g(homePageAdEvent, "event");
        if (RootColumnId.recommendHomeId == -1) {
            if (t9.i.b(l3().getCode(), w6.i.f19214g.v() + "_Recommended")) {
                xa.c.c().p(homePageAdEvent);
                this.f4716l = homePageAdEvent;
                if (n3().getData().size() > 0) {
                    u3();
                }
            }
        }
    }

    public void t3(l6.z1 z1Var) {
        t9.i.g(z1Var, "<set-?>");
        this.f4717m = z1Var;
    }

    public final void u3() {
        if (this.f4716l == null || getContext() == null) {
            return;
        }
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.d(context);
        String i10 = a6.a.f228a.i();
        i.c cVar = w6.i.f19214g;
        AdInfo J = s1.m.J(mVar, context, i10, cVar.I(), null, false, cVar.r(), 24, null);
        if (J != null) {
            Context context2 = getContext();
            t9.i.d(context2);
            com.mobile.brasiltv.utils.b0.S(new HomeImportantAdDialog(context2, J), "ad");
            this.f4716l = null;
        }
    }

    public final void v3() {
        if (this.f4715k == null || getContext() == null) {
            return;
        }
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.d(context);
        String d10 = a6.a.f228a.d();
        i.c cVar = w6.i.f19214g;
        AdInfo J = s1.m.J(mVar, context, d10, cVar.I(), null, false, cVar.r(), 24, null);
        if (J != null) {
            Context context2 = getContext();
            t9.i.d(context2);
            com.mobile.brasiltv.utils.b0.S(new InterstitialDialog(context2, J), "ad");
            this.f4715k = null;
        }
    }
}
