package b6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.ShortBeforePlayingEvent;
import com.mobile.brasiltv.bean.event.ToggleShowTitleBarEvent;
import com.mobile.brasiltv.view.shortvideo.OnStretchListener;
import com.mobile.brasiltv.view.shortvideo.StretchPager;
import com.msandroid.mobile.R;
import g5.v3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import mobile.com.requestframe.utils.response.ShortAssetData;

/* loaded from: classes.dex */
public final class i3 extends e<l6.c2> implements j6.k, p {

    /* renamed from: i, reason: collision with root package name */
    public l6.c2 f4740i;

    /* renamed from: j, reason: collision with root package name */
    public int f4741j;

    /* renamed from: k, reason: collision with root package name */
    public ShortAssetData f4742k;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4747p;

    /* renamed from: q, reason: collision with root package name */
    public Map f4748q = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f4743l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final h9.g f4744m = h9.h.b(new d());

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f4745n = h9.h.b(c.f4753a);

    /* renamed from: o, reason: collision with root package name */
    public final Runnable f4746o = new Runnable() { // from class: b6.h3
        @Override // java.lang.Runnable
        public final void run() {
            i3.q3(i3.this);
        }
    };

    /* loaded from: classes3.dex */
    public static final class a implements ViewPager.j {

        /* renamed from: a, reason: collision with root package name */
        public int f4749a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4750b;

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 1) {
                this.f4749a = ((StretchPager) i3.this.g3(R$id.mViewPager)).getCurrentItem();
            }
            if (i10 == 0) {
                com.mobile.brasiltv.utils.b0.U(this, "恢复预加载");
            } else {
                com.mobile.brasiltv.utils.b0.U(this, "暂停预加载");
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            int i12 = this.f4749a;
            if (i10 == i12) {
                return;
            }
            this.f4750b = i10 < i12;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            if (i10 == i3.this.f4741j) {
                return;
            }
            i3.this.l2(i10);
            if (i10 == i3.this.f4743l.size() - 2) {
                i3.this.a3().m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements OnStretchListener {
        public b() {
        }

        @Override // com.mobile.brasiltv.view.shortvideo.OnStretchListener
        public void onRefresh(int i10, int i11) {
        }

        @Override // com.mobile.brasiltv.view.shortvideo.OnStretchListener
        public void onRelease(int i10) {
            if (i10 == 16) {
                i3.this.a3().m();
            }
        }

        @Override // com.mobile.brasiltv.view.shortvideo.OnStretchListener
        public void onScrolled(int i10, int i11) {
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f4753a = new c();

        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final u6.b invoke() {
            return new u6.b();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final v3 invoke() {
            return new v3(i3.this.f4743l);
        }
    }

    public static final void q3(i3 i3Var) {
        t9.i.g(i3Var, "this$0");
        TextView textView = (TextView) i3Var.g3(R$id.mTvDataTip);
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // k5.a
    public void T2() {
        if (this.f4743l.isEmpty()) {
            a3().m();
        }
        l3();
    }

    @Override // k5.a
    public void U2() {
        l3();
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4748q.clear();
    }

    @Override // j6.k
    public void Y1(ArrayList arrayList) {
        t9.i.g(arrayList, "shortAssetList");
        this.f4743l.clear();
        this.f4743l.addAll(arrayList);
        k3().notifyDataSetChanged();
        if (this.f4741j == 0 && !a3().o() && (!this.f4743l.isEmpty())) {
            l2(0);
        }
    }

    @Override // b6.e
    public void Y2() {
        n3();
        m3();
        ((StretchPager) g3(R$id.mViewPager)).setCurrentItem(0);
    }

    @Override // j6.k
    public void c(String str) {
        t9.i.g(str, "errorCode");
        com.mobile.brasiltv.utils.j1.h(Z2(), str);
        xa.c.c().j(new ToggleShowTitleBarEvent(true));
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_shortvideo;
    }

    @Override // b6.p
    public void f1(boolean z10) {
        this.f4747p = z10;
        l3();
    }

    public View g3(int i10) {
        View findViewById;
        Map map = this.f4748q;
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

    @Override // b6.e
    /* renamed from: j3, reason: merged with bridge method [inline-methods] */
    public l6.c2 a3() {
        l6.c2 c2Var = this.f4740i;
        if (c2Var != null) {
            return c2Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @Override // j6.k
    public void k1() {
        if (S2()) {
            int i10 = R$id.mTvDataTip;
            ((TextView) g3(i10)).setVisibility(0);
            ((TextView) g3(i10)).removeCallbacks(this.f4746o);
            ((TextView) g3(i10)).postDelayed(this.f4746o, 5000L);
        }
    }

    public final v3 k3() {
        return (v3) this.f4744m.getValue();
    }

    @Override // j6.k
    public void l2(int i10) {
        com.mobile.brasiltv.utils.b0.U(this, "startPlay " + i10);
        int childCount = ((StretchPager) g3(R$id.mViewPager)).getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            v3.a aVar = (v3.a) ((StretchPager) g3(R$id.mViewPager)).getChildAt(i11).getTag();
            if (aVar != null && aVar.c() == i10) {
                Object obj = this.f4743l.get(i10);
                t9.i.f(obj, "mVideoList[position]");
                ShortAssetData shortAssetData = (ShortAssetData) obj;
                String playUrl = shortAssetData.getPlayUrl((String) r5.i.f18523a.B().c());
                this.f4742k = shortAssetData;
                com.mobile.brasiltv.utils.b0.U(this, "startPlay: position: " + i10 + "  url: " + playUrl);
                this.f4741j = i10;
                return;
            }
        }
    }

    public final void l3() {
        if (this.f4747p && getUserVisibleHint() && Q2()) {
            return;
        }
        o3();
    }

    public final void m3() {
    }

    public final void n3() {
        int i10 = R$id.mViewPager;
        ((StretchPager) g3(i10)).setOffscreenPageLimit(4);
        ((StretchPager) g3(i10)).setAdapter(k3());
        ((StretchPager) g3(i10)).setOverScrollMode(2);
        ((StretchPager) g3(i10)).setRefreshView(null, LayoutInflater.from(getContext()).inflate(R.layout.item_pager_bottom, (ViewGroup) null));
        ((StretchPager) g3(i10)).setStretchModel(16);
        ((StretchPager) g3(i10)).setOnPageChangeListener(new a());
        ((StretchPager) g3(i10)).setOnStretchListener(new b());
    }

    public final void o3() {
        Q2();
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p3(new l6.c2(this, this));
        xa.c.c().o(this);
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        xa.c.c().r(this);
        super.onDestroyView();
        ((TextView) g3(R$id.mTvDataTip)).removeCallbacks(this.f4746o);
        X2();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        o3();
    }

    public void p3(l6.c2 c2Var) {
        t9.i.g(c2Var, "<set-?>");
        this.f4740i = c2Var;
    }

    @xa.j
    public final void shortVideoBeforePlaying(ShortBeforePlayingEvent shortBeforePlayingEvent) {
        t9.i.g(shortBeforePlayingEvent, "event");
        if (this.f4747p && getUserVisibleHint()) {
            xa.c.c().j(new ToggleShowTitleBarEvent(false));
        } else {
            o3();
        }
    }
}
