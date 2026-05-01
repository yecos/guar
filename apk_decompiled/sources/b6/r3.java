package b6;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.RecordsAty;
import com.mobile.brasiltv.activity.SearchAty;
import com.mobile.brasiltv.bean.event.BannerAutoPlayEvent;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.bean.event.GotoCREvent;
import com.mobile.brasiltv.bean.event.MoveToFirst;
import com.mobile.brasiltv.bean.event.ToggleShowTitleBarEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.NoScrollViewPager;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class r3 extends b6.e<l6.p2> implements j6.m {

    /* renamed from: i, reason: collision with root package name */
    public l6.p2 f4988i;

    /* renamed from: p, reason: collision with root package name */
    public Map f4995p = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f4989j = h9.h.b(new a());

    /* renamed from: k, reason: collision with root package name */
    public final h9.g f4990k = h9.h.b(new c());

    /* renamed from: l, reason: collision with root package name */
    public final List f4991l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final List f4992m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f4993n = h9.h.b(d.f5001a);

    /* renamed from: o, reason: collision with root package name */
    public String f4994o = "";

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            n5.a aVar = n5.a.f17268a;
            androidx.fragment.app.e activity = r3.this.getActivity();
            t9.i.d(activity);
            return Integer.valueOf(aVar.a(activity));
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements ViewPager.j {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4997a;

        /* renamed from: b, reason: collision with root package name */
        public int f4998b;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            this.f4997a = i10 < this.f4998b;
            List list = r3.this.f4991l;
            if ((list == null || list.isEmpty()) || this.f4998b > r3.this.f4991l.size() - 1) {
                return;
            }
            AutoFrameLayout.LayoutParams layoutParams = new AutoFrameLayout.LayoutParams(-1, -1);
            if (this.f4997a) {
                if (r3.this.f4991l.get(this.f4998b) instanceof i3) {
                    ((FrameLayout.LayoutParams) layoutParams).topMargin = AutoUtils.getPercentHeightSize((int) ((1 - f10) * 201));
                    ((NoScrollViewPager) r3.this.j3(R$id.mRecommendVp)).setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (r3.this.f4991l.get(this.f4998b) instanceof i3) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = AutoUtils.getPercentHeightSize((int) (f10 * 201));
                ((NoScrollViewPager) r3.this.j3(R$id.mRecommendVp)).setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            this.f4998b = i10;
            r3.this.t3(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.x invoke() {
            List list = r3.this.f4991l;
            List list2 = r3.this.f4992m;
            androidx.fragment.app.o childFragmentManager = r3.this.getChildFragmentManager();
            t9.i.f(childFragmentManager, "childFragmentManager");
            return new g5.x(list, list2, childFragmentManager);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f5001a = new d();

        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final l invoke() {
            return new l();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements KoocanEmptyView.ReloadListener {
        public e() {
        }

        @Override // com.mobile.brasiltv.view.KoocanEmptyView.ReloadListener
        public void onClick() {
            r3.this.a3().n();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements KoocanEmptyView.ReloadListener {
        public f() {
        }

        @Override // com.mobile.brasiltv.view.KoocanEmptyView.ReloadListener
        public void onClick() {
            r3.this.a3().n();
        }
    }

    public static /* synthetic */ void o3(r3 r3Var, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        r3Var.n3(list, z10);
    }

    public static final void v3(r3 r3Var, View view) {
        t9.i.g(r3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(r3Var, SearchAty.class);
    }

    public static final void w3(r3 r3Var, View view) {
        t9.i.g(r3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(r3Var, RecordsAty.class);
    }

    public static final void x3(View view) {
        xa.c.c().j(new MoveToFirst());
    }

    public static final void y3(View view) {
        xa.c.c().j(new MoveToFirst());
    }

    public final void A3() {
        if (Q2()) {
            for (androidx.lifecycle.g gVar : this.f4991l) {
                if (gVar instanceof p) {
                    ((p) gVar).f1(getUserVisibleHint());
                }
            }
        }
    }

    public final void B3(Fragment fragment, ChildColumnList childColumnList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("fragment_bound_key", childColumnList);
        fragment.setArguments(bundle);
    }

    public void C3(l6.p2 p2Var) {
        t9.i.g(p2Var, "<set-?>");
        this.f4988i = p2Var;
    }

    @Override // k5.a
    public void T2() {
        if (Q2() && S2() && !z3() && com.mobile.brasiltv.utils.b0.I(this.f4991l)) {
            xa.c.c().j(new BannerAutoPlayEvent(true));
        }
    }

    @Override // k5.a
    public void U2() {
        super.U2();
        if (Q2() && !z3() && com.mobile.brasiltv.utils.b0.I(this.f4991l)) {
            xa.c.c().j(new BannerAutoPlayEvent(false));
        }
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4995p.clear();
    }

    @Override // b6.e
    public void Y2() {
        ViewGroup.LayoutParams layoutParams = ((TextView) j3(R$id.mCinemaTitle)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams).setMargins(0, p3(), 0, 0);
        ViewGroup.LayoutParams layoutParams2 = ((ImageView) j3(R$id.mVodImageSearch)).getLayoutParams();
        t9.i.e(layoutParams2, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams2).setMargins(0, p3(), 0, 0);
        int i10 = R$id.mRecommendVp;
        ((NoScrollViewPager) j3(i10)).setScrollable(true);
        ((NoScrollViewPager) j3(i10)).setAdapter(q3());
        int i11 = R$id.mRecommendTab;
        ((SlidingTabLayout) j3(i11)).setSnapOnTabClick(true);
        ((SlidingTabLayout) j3(i11)).setViewPager((NoScrollViewPager) j3(i10));
        u3();
        a();
        a3().n();
    }

    public void a() {
        ((KoocanEmptyView) j3(R$id.vod_loadingView)).setVisibility(0);
    }

    @Override // j6.m
    public void b() {
        int i10 = R$id.vod_loadingView;
        ((KoocanEmptyView) j3(i10)).changeType(KoocanEmptyView.Type.NO_WIFI);
        ((KoocanEmptyView) j3(i10)).setVisibility(0);
        ((KoocanEmptyView) j3(i10)).setReloadListener(new e());
    }

    @Override // j6.m
    public void c(String str) {
        t9.i.g(str, "errorCode");
        com.mobile.brasiltv.utils.j1.h(Z2(), str);
        int i10 = R$id.vod_loadingView;
        ((KoocanEmptyView) j3(i10)).changeType(KoocanEmptyView.Type.NO_WIFI);
        ((KoocanEmptyView) j3(i10)).setVisibility(0);
        ((KoocanEmptyView) j3(i10)).setReloadListener(new f());
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_vod;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void gotoCRMessage(GotoCREvent gotoCREvent) {
        t9.i.g(gotoCREvent, "event");
        int size = this.f4991l.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f4991l.get(i10) instanceof l) {
                ((NoScrollViewPager) j3(R$id.mRecommendVp)).setCurrentItem(i10, false);
                return;
            }
        }
    }

    @xa.j
    public final void handleUpdateRestrictEvent(UpdateRestrictEvent updateRestrictEvent) {
        t9.i.g(updateRestrictEvent, "event");
        w6.i.f19214g.q0(updateRestrictEvent.getStatus());
        List r10 = a3().r();
        if (com.mobile.brasiltv.utils.b0.I(r10)) {
            t9.i.d(r10);
            n3(r10, true);
        }
    }

    public View j3(int i10) {
        View findViewById;
        Map map = this.f4995p;
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

    public void k() {
        ((KoocanEmptyView) j3(R$id.vod_loadingView)).setVisibility(8);
    }

    public final void n3(List list, boolean z10) {
        if (!z10) {
            Iterator it = list.iterator();
            int i10 = -1;
            while (it.hasNext()) {
                ChildColumnList childColumnList = (ChildColumnList) it.next();
                if (t9.i.b(childColumnList.getRestricted(), "1")) {
                    i10 = list.indexOf(childColumnList);
                } else {
                    if (t9.i.b(childColumnList.getCode(), w6.i.f19214g.v() + "_short")) {
                        i3 i3Var = new i3();
                        B3(i3Var, childColumnList);
                        this.f4992m.add(com.mobile.brasiltv.utils.b0.e(childColumnList.getAlias(), childColumnList.getName()));
                        this.f4991l.add(i3Var);
                    } else {
                        g3 g3Var = new g3();
                        B3(g3Var, childColumnList);
                        this.f4992m.add(com.mobile.brasiltv.utils.b0.e(childColumnList.getAlias(), childColumnList.getName()));
                        this.f4991l.add(g3Var);
                    }
                }
            }
            if (i10 != -1 && t9.i.b(w6.i.f19214g.A(), "1")) {
                ChildColumnList childColumnList2 = (ChildColumnList) list.get(i10);
                B3(r3(), childColumnList2);
                String c10 = com.mobile.brasiltv.utils.b0.c(childColumnList2.getAlias(), childColumnList2.getName());
                this.f4994o = c10;
                this.f4992m.add(c10);
                this.f4991l.add(r3());
            }
        } else if (t9.i.b(w6.i.f19214g.A(), "1")) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ChildColumnList childColumnList3 = (ChildColumnList) it2.next();
                if (t9.i.b(childColumnList3.getRestricted(), "1")) {
                    if (!r3().isStateSaved()) {
                        B3(r3(), childColumnList3);
                    }
                    String c11 = com.mobile.brasiltv.utils.b0.c(childColumnList3.getAlias(), childColumnList3.getName());
                    this.f4994o = c11;
                    if (!this.f4992m.contains(c11)) {
                        this.f4992m.add(this.f4994o);
                        this.f4991l.add(r3());
                    }
                }
            }
        } else {
            this.f4992m.remove(this.f4994o);
            this.f4991l.remove(r3());
        }
        int i11 = R$id.mRecommendTab;
        if (((SlidingTabLayout) j3(i11)) == null) {
            return;
        }
        ((SlidingTabLayout) j3(i11)).notifyDataSetChanged();
        q3().notifyDataSetChanged();
        ((SlidingTabLayout) j3(i11)).setCurrentTab(0);
        k();
        xa.c.c().j(new CouponQualificationEvent(w6.i.f19214g.M()));
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3(new l6.p2(this, this));
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

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        R2();
    }

    public final int p3() {
        return ((Number) this.f4989j.getValue()).intValue();
    }

    @Override // j6.m
    public void q1(List list) {
        t9.i.g(list, "childColumn");
        o3(this, list, false, 2, null);
        A3();
    }

    public final g5.x q3() {
        return (g5.x) this.f4990k.getValue();
    }

    public final l r3() {
        return (l) this.f4993n.getValue();
    }

    @Override // b6.e
    /* renamed from: s3, reason: merged with bridge method [inline-methods] */
    public l6.p2 a3() {
        l6.p2 p2Var = this.f4988i;
        if (p2Var != null) {
            return p2Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @Override // k5.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        A3();
    }

    public final void t3(int i10) {
        List list = this.f4991l;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f4991l.get(i10) instanceof i3) {
            int i11 = R$id.mLayoutNavigator;
            ((AutoFrameLayout) j3(i11)).setVisibility(8);
            ((AutoFrameLayout) j3(i11)).setBackgroundColor(0);
            ((ImageView) j3(R$id.mIvTitleLine)).setBackgroundColor(0);
            AutoFrameLayout.LayoutParams layoutParams = new AutoFrameLayout.LayoutParams(-1, -1);
            ((FrameLayout.LayoutParams) layoutParams).topMargin = AutoUtils.getPercentHeightSize(0);
            ((NoScrollViewPager) j3(R$id.mRecommendVp)).setLayoutParams(layoutParams);
            return;
        }
        int i12 = R$id.mLayoutNavigator;
        ((AutoFrameLayout) j3(i12)).setVisibility(0);
        ((AutoFrameLayout) j3(i12)).setBackgroundColor(getResources().getColor(R.color.color_191a23));
        ((ImageView) j3(R$id.mIvTitleLine)).setBackgroundColor(getResources().getColor(R.color.color_1f202a));
        AutoFrameLayout.LayoutParams layoutParams2 = new AutoFrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams) layoutParams2).topMargin = AutoUtils.getPercentHeightSize(201);
        ((NoScrollViewPager) j3(R$id.mRecommendVp)).setLayoutParams(layoutParams2);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void toggleShowTitleBar(ToggleShowTitleBarEvent toggleShowTitleBarEvent) {
        t9.i.g(toggleShowTitleBarEvent, "event");
        if (toggleShowTitleBarEvent.getShow()) {
            ((AutoFrameLayout) j3(R$id.mLayoutNavigator)).setVisibility(0);
        } else {
            ((AutoFrameLayout) j3(R$id.mLayoutNavigator)).setVisibility(8);
        }
    }

    public final void u3() {
        ((ImageView) j3(R$id.mVodImageSearch)).setOnClickListener(new View.OnClickListener() { // from class: b6.n3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.v3(r3.this, view);
            }
        });
        ((ImageView) j3(R$id.mVodImageHistory)).setOnClickListener(new View.OnClickListener() { // from class: b6.o3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.w3(r3.this, view);
            }
        });
        ((TextView) j3(R$id.mCinemaTitle)).setOnClickListener(new View.OnClickListener() { // from class: b6.p3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.x3(view);
            }
        });
        ((ImageView) j3(R$id.mVodImageLogo)).setOnClickListener(new View.OnClickListener() { // from class: b6.q3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.y3(view);
            }
        });
        ((NoScrollViewPager) j3(R$id.mRecommendVp)).addOnPageChangeListener(new b());
    }

    public final boolean z3() {
        int i10 = R$id.mRecommendTab;
        return ((SlidingTabLayout) j3(i10)) == null || ((SlidingTabLayout) j3(i10)).getTabCount() < 1;
    }
}
