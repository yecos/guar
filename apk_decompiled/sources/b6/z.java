package b6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b6.r;
import b6.r0;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.Search1Aty;
import com.mobile.brasiltv.bean.event.ClickChannelEpgEvent;
import com.mobile.brasiltv.bean.event.LiveFragVisibleEvent;
import com.mobile.brasiltv.bean.event.StopPlayEvent;
import com.mobile.brasiltv.view.LiveFragmentTabLayout;
import com.mobile.brasiltv.view.RatioFrameLayout;
import com.mobile.brasiltv.view.TabOnClickListener;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class z extends b6.e<l6.n0> implements j6.d {
    public static boolean A;
    public static ChildColumnList B;
    public static ChildColumnList C;
    public static boolean D;

    /* renamed from: u, reason: collision with root package name */
    public static final a f5049u = new a(null);

    /* renamed from: v, reason: collision with root package name */
    public static androidx.collection.a f5050v = new androidx.collection.a();

    /* renamed from: w, reason: collision with root package name */
    public static String f5051w = "";

    /* renamed from: x, reason: collision with root package name */
    public static SparseArray f5052x = new SparseArray();

    /* renamed from: y, reason: collision with root package name */
    public static String f5053y;

    /* renamed from: z, reason: collision with root package name */
    public static ArrayList f5054z;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5055i;

    /* renamed from: n, reason: collision with root package name */
    public l6.n0 f5060n;

    /* renamed from: t, reason: collision with root package name */
    public Map f5066t = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f5056j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f5057k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f5058l = h9.h.b(new b());

    /* renamed from: m, reason: collision with root package name */
    public final h9.g f5059m = h9.h.b(new c());

    /* renamed from: o, reason: collision with root package name */
    public final h9.g f5061o = h9.h.b(e.f5070a);

    /* renamed from: p, reason: collision with root package name */
    public final h9.g f5062p = h9.h.b(f.f5071a);

    /* renamed from: q, reason: collision with root package name */
    public final h9.g f5063q = h9.h.b(i.f5074a);

    /* renamed from: r, reason: collision with root package name */
    public final h9.g f5064r = h9.h.b(h.f5073a);

    /* renamed from: s, reason: collision with root package name */
    public final h9.g f5065s = h9.h.b(g.f5072a);

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final ChildColumnList a() {
            return z.B;
        }

        public final androidx.collection.a b() {
            return z.f5050v;
        }

        public final String c() {
            return z.f5051w;
        }

        public final ArrayList d() {
            return z.f5054z;
        }

        public final ChildColumnList e() {
            return z.C;
        }

        public final String f() {
            return z.f5053y;
        }

        public final SparseArray g() {
            return z.f5052x;
        }

        public final boolean h() {
            return z.D;
        }

        public final void i(ChildColumnList childColumnList) {
            z.B = childColumnList;
        }

        public final void j(String str) {
            t9.i.g(str, "<set-?>");
            z.f5051w = str;
        }

        public final void k(ArrayList arrayList) {
            z.f5054z = arrayList;
        }

        public final void l(boolean z10) {
            z.A = z10;
        }

        public final void m(ChildColumnList childColumnList) {
            z.C = childColumnList;
        }

        public final void n(String str) {
            z.f5053y = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.x0 invoke() {
            androidx.fragment.app.o childFragmentManager = z.this.getChildFragmentManager();
            t9.i.f(childFragmentManager, "childFragmentManager");
            return new g5.x0(childFragmentManager, z.this.E3(), z.this.F3());
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(z.this.getActivity()));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements TabOnClickListener {
        public d() {
        }

        @Override // com.mobile.brasiltv.view.TabOnClickListener
        public void leftTextClick() {
            z.this.M3();
        }

        @Override // com.mobile.brasiltv.view.TabOnClickListener
        public void rightTextClick() {
            z.this.O3();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final e f5070a = new e();

        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final o2 invoke() {
            return new o2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f5071a = new f();

        public f() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final w invoke() {
            return new w();
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final g f5072a = new g();

        public g() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final l2 invoke() {
            return new l2();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final h f5073a = new h();

        public h() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final r1 invoke() {
            return new r1();
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final i f5074a = new i();

        public i() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c2 invoke() {
            return new c2();
        }
    }

    public static final void w3(z zVar, View view) {
        t9.i.g(zVar, "this$0");
        com.mobile.brasiltv.utils.b0.a0(zVar, Search1Aty.class);
    }

    public static final void x3(z zVar, View view) {
        t9.i.g(zVar, "this$0");
        zVar.N3(true);
    }

    public final o2 A3() {
        return (o2) this.f5061o.getValue();
    }

    public final w B3() {
        return (w) this.f5062p.getValue();
    }

    public final l2 C3() {
        return (l2) this.f5065s.getValue();
    }

    public final r1 D3() {
        return (r1) this.f5064r.getValue();
    }

    public final ArrayList E3() {
        return this.f5056j;
    }

    public final ArrayList F3() {
        return this.f5057k;
    }

    @Override // b6.e
    /* renamed from: G3, reason: merged with bridge method [inline-methods] */
    public l6.n0 a3() {
        l6.n0 n0Var = this.f5060n;
        if (n0Var != null) {
            return n0Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final FrameLayout H3() {
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) h3(R$id.livePlayFrg);
        t9.i.f(ratioFrameLayout, "livePlayFrg");
        return ratioFrameLayout;
    }

    public final void I3() {
        D3().w4();
    }

    public final boolean J3() {
        return D3().J4();
    }

    public final void K3(Fragment fragment, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(r0.A.a(), str);
        fragment.setArguments(bundle);
    }

    public void L3(l6.n0 n0Var) {
        t9.i.g(n0Var, "<set-?>");
        this.f5060n = n0Var;
    }

    public final void M3() {
        if (getChildFragmentManager().h0("liveChannelFrag") != null || A3().isAdded()) {
            getChildFragmentManager().m().u(A3()).i();
            if (B3() == null || getChildFragmentManager().h0("liveCollectFrag") == null) {
                return;
            }
            getChildFragmentManager().m().o(B3()).i();
            return;
        }
        getChildFragmentManager().m().c(R.id.channelAndFavoriteFrg, A3(), "liveChannelFrag").i();
        if (B3() == null || getChildFragmentManager().h0("liveCollectFrag") == null) {
            return;
        }
        getChildFragmentManager().m().o(B3()).i();
    }

    public final void N3(boolean z10) {
        androidx.fragment.app.y m10 = getChildFragmentManager().m();
        t9.i.f(m10, "childFragmentManager.beginTransaction()");
        if (z10) {
            ((LiveFragmentTabLayout) h3(R$id.liveFragmentTab)).setVisibility(0);
            ((AutoRelativeLayout) h3(R$id.channelAndFavoriteContent)).setVisibility(0);
            ((AutoLinearLayout) h3(R$id.mLayoutEPGTitle)).setVisibility(8);
            if (C3().isVisible()) {
                m10.o(C3()).i();
            }
            ((AutoRelativeLayout) h3(R$id.mLayoutEpgContent)).setVisibility(8);
            return;
        }
        ((LiveFragmentTabLayout) h3(R$id.liveFragmentTab)).setVisibility(8);
        ((AutoRelativeLayout) h3(R$id.channelAndFavoriteContent)).setVisibility(8);
        ((AutoLinearLayout) h3(R$id.mLayoutEPGTitle)).setVisibility(0);
        ((AutoRelativeLayout) h3(R$id.mLayoutEpgContent)).setVisibility(0);
        ((TextView) h3(R$id.mTextEpgChannel)).setText(r.f4860j.b());
        if (C3().isAdded()) {
            m10.u(C3()).i();
        } else {
            m10.b(R.id.mLayoutEPGFragment, C3()).i();
        }
    }

    public final void O3() {
        if (getChildFragmentManager().h0("liveCollectFrag") != null) {
            getChildFragmentManager().m().u(B3()).i();
            if (A3() == null || getChildFragmentManager().h0("liveChannelFrag") == null) {
                return;
            }
            getChildFragmentManager().m().o(A3()).i();
            return;
        }
        getChildFragmentManager().m().c(R.id.channelAndFavoriteFrg, B3(), "liveCollectFrag").i();
        if (A3() == null || getChildFragmentManager().h0("liveChannelFrag") == null) {
            return;
        }
        getChildFragmentManager().m().o(A3()).i();
    }

    @Override // k5.a
    public void T2() {
        if (y3().getCount() == 0) {
            a3().x();
        }
        d6.a aVar = d6.a.f12650a;
        if (aVar.j() == 1) {
            aVar.m();
        }
        xa.c.c().j(new LiveFragVisibleEvent(true));
    }

    @Override // k5.a
    public void U2() {
        super.U2();
        D = false;
        D3().z4();
        xa.c.c().j(new LiveFragVisibleEvent(false));
    }

    @Override // k5.a
    public void V2() {
        super.V2();
        D = true;
        D3().A4(A);
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f5066t.clear();
    }

    @Override // b6.e
    public void Y2() {
        ViewGroup.LayoutParams layoutParams = ((TextView) h3(R$id.mTextTitle)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams).setMargins(0, z3(), 0, 0);
        int i10 = R$id.mImageSearch;
        ViewGroup.LayoutParams layoutParams2 = ((ImageView) h3(i10)).getLayoutParams();
        t9.i.e(layoutParams2, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams2).setMargins(0, z3(), 0, 0);
        if (S2()) {
            d6.a.f12650a.m();
        }
        getChildFragmentManager().m().q(R.id.livePlayFrg, D3()).i();
        ((LiveFragmentTabLayout) h3(R$id.liveFragmentTab)).setOnClickListener(new d());
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        f5053y = n0Var.e(activity, "live_last_play_chanel", "");
        ((ImageView) h3(i10)).setOnClickListener(new View.OnClickListener() { // from class: b6.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z.w3(z.this, view);
            }
        });
        ((AutoLinearLayout) h3(R$id.mLayoutEPGTitle)).setOnClickListener(new View.OnClickListener() { // from class: b6.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z.x3(z.this, view);
            }
        });
    }

    @Override // j6.d
    public void c(String str) {
        t9.i.g(str, "returnCode");
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_live;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void clickChannelEpg(ClickChannelEpgEvent clickChannelEpgEvent) {
        t9.i.g(clickChannelEpgEvent, "event");
        com.mobile.brasiltv.utils.b0.U(this, "clickChannelEpg: " + clickChannelEpgEvent.getChannelName() + ' ' + clickChannelEpgEvent.getChannelCode() + ' ' + clickChannelEpgEvent.getColumnId());
        r.a aVar = r.f4860j;
        aVar.d(clickChannelEpgEvent.getChannelCode());
        aVar.f(clickChannelEpgEvent.getColumnId());
        if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(clickChannelEpgEvent.getChannelAlias())) {
            aVar.e(clickChannelEpgEvent.getChannelName());
        } else {
            aVar.e(clickChannelEpgEvent.getChannelAlias());
        }
        N3(false);
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f5066t;
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

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.MainAty");
            ((MainAty) activity).r4();
        } else {
            androidx.fragment.app.e activity2 = getActivity();
            t9.i.e(activity2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.MainAty");
            ((MainAty) activity2).V3();
        }
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L3(new l6.n0(this, this));
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

    @Override // j6.d
    public void onLoading() {
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            D = false;
            D3().z4();
        }
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            D = true;
            D3().A4(A);
            A = false;
        }
    }

    @Override // j6.d
    public void s() {
        o2 A3 = A3();
        r0.a aVar = r0.A;
        K3(A3, aVar.b());
        K3(B3(), aVar.c());
        this.f5056j.clear();
        this.f5057k.clear();
        this.f5056j.addAll(i9.j.c(A3(), B3()));
        this.f5057k.addAll(i9.j.c(com.mobile.brasiltv.utils.b0.z(R.string.live_channel), com.mobile.brasiltv.utils.b0.z(R.string.live_fav), com.mobile.brasiltv.utils.b0.z(R.string.live_sub_list)));
        if (this.f5055i) {
            return;
        }
        this.f5055i = true;
        M3();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void stopPlay(StopPlayEvent stopPlayEvent) {
        t9.i.g(stopPlayEvent, "event");
        if (stopPlayEvent.getReason() != StopPlayEvent.Reason.PRESS_HOME) {
            U2();
            r1 D3 = D3();
            if (D3 != null) {
                D3.P5();
            }
        }
    }

    public final g5.x0 y3() {
        return (g5.x0) this.f5058l.getValue();
    }

    public final int z3() {
        return ((Number) this.f5059m.getValue()).intValue();
    }
}
