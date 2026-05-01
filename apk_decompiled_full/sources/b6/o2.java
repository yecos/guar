package b6;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b6.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.LiveTabEntity;
import com.mobile.brasiltv.bean.event.ClickSearchChannelEvent;
import com.mobile.brasiltv.bean.event.RefreshChannelEPGEvent;
import com.mobile.brasiltv.bean.event.UpdateHighLightEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.view.CenterLayoutManager;
import com.msandroid.mobile.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import w6.i;

/* loaded from: classes.dex */
public final class o2 extends e<l6.d1> implements i6.r {

    /* renamed from: k, reason: collision with root package name */
    public LiveTabEntity f4840k;

    /* renamed from: l, reason: collision with root package name */
    public l6.d1 f4841l;

    /* renamed from: p, reason: collision with root package name */
    public Map f4845p = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    public final List f4838i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final List f4839j = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final h9.g f4842m = h9.h.b(new d());

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f4843n = h9.h.b(new a());

    /* renamed from: o, reason: collision with root package name */
    public final h9.g f4844o = h9.h.b(b.f4847a);

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.w0 invoke() {
            return new g5.w0(o2.this.getChildFragmentManager(), o2.this.f4838i);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f4847a = new b();

        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            ArrayList arrayList = new ArrayList();
            z.a aVar = z.f5049u;
            if (com.mobile.brasiltv.utils.b0.I(aVar.d())) {
                ArrayList d10 = aVar.d();
                t9.i.d(d10);
                Iterator it = d10.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((ChildColumnList) it.next()).getId()));
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ViewPager.j {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            o2.this.r3(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.v0 invoke() {
            androidx.fragment.app.e activity = o2.this.getActivity();
            if (activity != null) {
                return new g5.v0(activity);
            }
            return null;
        }
    }

    public static final void k3(o2 o2Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(o2Var, "this$0");
        ((ViewPager) o2Var.h3(R$id.liveViewPager)).setCurrentItem(i10);
        o2Var.r3(i10);
    }

    public static final void s3(RecyclerView.o oVar, o2 o2Var, int i10) {
        t9.i.g(o2Var, "this$0");
        oVar.smoothScrollToPosition((RecyclerView) o2Var.h3(R$id.recyclerView), new RecyclerView.a0(), i10);
    }

    @Override // i6.r
    public void G(List list, int i10) {
        t9.i.g(list, "list");
        z.f5049u.g().put(i10, list);
    }

    @Override // k5.a
    public void T2() {
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4845p.clear();
    }

    @Override // b6.e
    public void Y2() {
        z.a aVar = z.f5049u;
        if (com.mobile.brasiltv.utils.b0.I(aVar.d())) {
            ArrayList d10 = aVar.d();
            t9.i.d(d10);
            Iterator it = d10.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList = (ChildColumnList) next;
                if (!com.mobile.brasiltv.utils.f0.b()) {
                    String alias = childColumnList.getAlias();
                    if (!(alias == null || alias.length() == 0)) {
                        List list = this.f4838i;
                        String alias2 = childColumnList.getAlias();
                        t9.i.d(alias2);
                        list.add(alias2);
                        List list2 = this.f4839j;
                        String alias3 = childColumnList.getAlias();
                        list2.add(new LiveTabEntity(alias3 != null ? alias3 : "", i10 == 0, i10));
                        i10 = i11;
                    }
                }
                List list3 = this.f4838i;
                String alias4 = childColumnList.getAlias();
                t9.i.d(alias4);
                list3.add(alias4);
                List list4 = this.f4839j;
                String alias5 = childColumnList.getAlias();
                list4.add(new LiveTabEntity(alias5 != null ? alias5 : "", i10 == 0, i10));
                i10 = i11;
            }
            this.f4840k = (LiveTabEntity) this.f4839j.get(0);
            int i12 = R$id.liveViewPager;
            if (((ViewPager) h3(i12)) != null) {
                ((ViewPager) h3(i12)).setAdapter(l3());
                ((ViewPager) h3(i12)).addOnPageChangeListener(new c());
            }
            CenterLayoutManager centerLayoutManager = new CenterLayoutManager(getActivity(), 0, false);
            int i13 = R$id.recyclerView;
            ((RecyclerView) h3(i13)).setHasFixedSize(true);
            ((RecyclerView) h3(i13)).setLayoutManager(centerLayoutManager);
            ((RecyclerView) h3(i13)).setAdapter(p3());
            g5.v0 p32 = p3();
            if (p32 != null) {
                p32.setNewData(this.f4839j);
            }
            g5.v0 p33 = p3();
            if (p33 != null) {
                p33.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: b6.n2
                    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i14) {
                        o2.k3(o2.this, baseQuickAdapter, view, i14);
                    }
                });
            }
            int o32 = o3();
            if (!m3().isEmpty()) {
                ((ViewPager) h3(i12)).setCurrentItem(o32);
                r3(o32);
            }
            z.a aVar2 = z.f5049u;
            if (aVar2.e() != null) {
                l6.d1 a32 = a3();
                ChildColumnList e10 = aVar2.e();
                t9.i.d(e10);
                a32.n(e10.getId(), true);
            }
        }
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_live_tab;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    @xa.j(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void clickSearchChannel(ClickSearchChannelEvent clickSearchChannelEvent) {
        boolean z10;
        t9.i.g(clickSearchChannelEvent, "event");
        z.a aVar = z.f5049u;
        aVar.n(clickSearchChannelEvent.getChannel().getChannelCode());
        if (aVar.e() != null) {
            i.c cVar = w6.i.f19214g;
            if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                SparseArray g10 = aVar.g();
                ChildColumnList e10 = aVar.e();
                t9.i.d(e10);
                List list = (List) g10.get(e10.getId());
                if (list != null) {
                    Iterator it = list.iterator();
                    z10 = false;
                    while (it.hasNext()) {
                        if (TextUtils.equals(clickSearchChannelEvent.getChannel().getChannelCode(), ((Channel) it.next()).getChannelCode())) {
                            z10 = true;
                        }
                    }
                    if (z10) {
                        ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(0);
                        return;
                    } else {
                        ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(1);
                        return;
                    }
                }
            }
        }
        z10 = false;
        if (z10) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xa.j(sticky = true)
    public final void getCurEpg(RefreshChannelEPGEvent refreshChannelEPGEvent) {
        t9.i.g(refreshChannelEPGEvent, "event");
        List<Fragment> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if ((fragment instanceof g5.h0) && fragment.isVisible()) {
                ((g5.h0) fragment).V0();
            }
        }
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f4845p;
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

    public final boolean j3() {
        Context context = getContext();
        Boolean valueOf = context != null ? Boolean.valueOf(com.mobile.brasiltv.utils.n0.c(com.mobile.brasiltv.utils.n0.f8733a, context, "live_first_play_free_column", false, 4, null)) : null;
        i.c cVar = w6.i.f19214g;
        return (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2")) && t9.i.b(cVar.e(), "1") && t9.i.b(valueOf, Boolean.TRUE);
    }

    public final g5.w0 l3() {
        return (g5.w0) this.f4843n.getValue();
    }

    public final ArrayList m3() {
        return (ArrayList) this.f4844o.getValue();
    }

    @Override // b6.e
    /* renamed from: n3, reason: merged with bridge method [inline-methods] */
    public l6.d1 a3() {
        l6.d1 d1Var = this.f4841l;
        if (d1Var != null) {
            return d1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final int o3() {
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        Context context = getContext();
        t9.i.d(context);
        int d10 = n0Var.d(context, "live_last_play_column_index", 0);
        if (j3() && q3() != -1) {
            d10 = q3();
        }
        if (d10 == -1) {
            return 0;
        }
        return d10;
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t3(new l6.d1(this, this));
        if (xa.c.c().h(this)) {
            return;
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10 || getContext() == null) {
            return;
        }
        int o32 = o3();
        if (!m3().isEmpty()) {
            ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(o32);
            r3(o32);
        }
        List<Fragment> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if ((fragment instanceof g5.h0) && fragment.isVisible()) {
                ((g5.h0) fragment).k2();
            }
        }
    }

    public final g5.v0 p3() {
        return (g5.v0) this.f4842m.getValue();
    }

    @Override // i6.r
    public void q2() {
        xa.c.c().m(new RefreshChannelEPGEvent());
    }

    public final int q3() {
        int i10 = -1;
        if (!m3().isEmpty() && z.f5049u.e() != null) {
            int i11 = 0;
            for (Object obj : m3()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                int intValue = ((Number) obj).intValue();
                ChildColumnList e10 = z.f5049u.e();
                t9.i.d(e10);
                if (e10.getId() == intValue) {
                    i10 = i11;
                }
                i11 = i12;
            }
        }
        return i10;
    }

    public final void r3(final int i10) {
        g5.v0 p32 = p3();
        LiveTabEntity liveTabEntity = p32 != null ? (LiveTabEntity) p32.getItem(i10) : null;
        if (t9.i.b(liveTabEntity, this.f4840k)) {
            return;
        }
        if (liveTabEntity != null) {
            liveTabEntity.setSelected(true);
        }
        LiveTabEntity liveTabEntity2 = this.f4840k;
        if (liveTabEntity2 != null) {
            if (liveTabEntity2 != null) {
                liveTabEntity2.setSelected(false);
            }
            g5.v0 p33 = p3();
            if (p33 != null) {
                p33.notifyDataSetChanged();
            }
        }
        this.f4840k = liveTabEntity;
        int i11 = R$id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) h3(i11);
        final RecyclerView.o layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            ((RecyclerView) h3(i11)).postDelayed(new Runnable() { // from class: b6.m2
                @Override // java.lang.Runnable
                public final void run() {
                    o2.s3(RecyclerView.o.this, this, i10);
                }
            }, 100L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xa.j
    public final void readyHighLightItem(UpdateHighLightEvent updateHighLightEvent) {
        t9.i.g(updateHighLightEvent, "event");
        androidx.fragment.app.e activity = getActivity();
        int d10 = activity != null ? com.mobile.brasiltv.utils.n0.f8733a.d(activity, "live_last_play_column_index", 0) : 0;
        k7.f.e("从全屏返回 channelCode：" + updateHighLightEvent.getCode() + ", columnPosition: " + d10, new Object[0]);
        if (d10 >= 0) {
            Log.e("currentItem", String.valueOf(d10));
            ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(d10, false);
        } else {
            ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(0, false);
        }
        List<Fragment> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if ((fragment instanceof g5.h0) && fragment.isVisible()) {
                ((g5.h0) fragment).c1();
            }
        }
    }

    public void t3(l6.d1 d1Var) {
        t9.i.g(d1Var, "<set-?>");
        this.f4841l = d1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
    
        if (r11.contains(r1) == false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc  */
    @xa.j(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateRestrict(UpdateRestrictEvent updateRestrictEvent) {
        String name;
        Object obj;
        t9.i.g(updateRestrictEvent, "event");
        z.a aVar = z.f5049u;
        if (aVar.d() == null) {
            return;
        }
        boolean z10 = true;
        if (!com.mobile.brasiltv.utils.f0.b()) {
            ChildColumnList a10 = aVar.a();
            t9.i.d(a10);
            String alias = a10.getAlias();
            if (!(alias == null || alias.length() == 0)) {
                ChildColumnList a11 = aVar.a();
                t9.i.d(a11);
                name = a11.getAlias();
                t9.i.d(name);
                String str = name;
                if (t9.i.b(updateRestrictEvent.getStatus(), "0")) {
                    ArrayList d10 = aVar.d();
                    if (d10 != null) {
                        ChildColumnList a12 = aVar.a();
                        t9.i.d(a12);
                    }
                    z10 = false;
                    if (z10) {
                        ArrayList d11 = aVar.d();
                        if (d11 != null) {
                            ChildColumnList a13 = aVar.a();
                            t9.i.d(a13);
                            d11.add(a13);
                        }
                        ArrayList m32 = m3();
                        ChildColumnList a14 = aVar.a();
                        t9.i.d(a14);
                        m32.add(Integer.valueOf(a14.getId()));
                        List list = this.f4838i;
                        if (list != null) {
                            list.add(str);
                        }
                        this.f4839j.add(new LiveTabEntity(str, false, 0, 6, null));
                    }
                    l3().notifyDataSetChanged();
                    g5.v0 p32 = p3();
                    if (p32 != null) {
                        p32.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                ArrayList d12 = aVar.d();
                if (d12 != null) {
                    ChildColumnList a15 = aVar.a();
                    t9.i.d(a15);
                    d12.remove(a15);
                }
                ArrayList m33 = m3();
                ChildColumnList a16 = aVar.a();
                t9.i.d(a16);
                m33.remove(Integer.valueOf(a16.getId()));
                List list2 = this.f4838i;
                if (list2 != null) {
                    list2.remove(str);
                }
                Iterator it = this.f4839j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (t9.i.b(((LiveTabEntity) obj).getName(), str)) {
                            break;
                        }
                    }
                }
                if (((LiveTabEntity) obj) != null) {
                    this.f4839j.remove(obj);
                }
                l3().notifyDataSetChanged();
                g5.v0 p33 = p3();
                if (p33 != null) {
                    p33.notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
        ChildColumnList a17 = aVar.a();
        t9.i.d(a17);
        name = a17.getName();
        String str2 = name;
        if (t9.i.b(updateRestrictEvent.getStatus(), "0")) {
        }
    }

    @xa.j
    public final void userIdentityChange(UserIdentityChangeEvent userIdentityChangeEvent) {
        t9.i.g(userIdentityChangeEvent, "event");
        r0.A.f("");
        List<androidx.lifecycle.g> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (androidx.lifecycle.g gVar : s02) {
            if (gVar instanceof g5.h0) {
                ((g5.h0) gVar).S0(Boolean.TRUE);
            }
        }
        if (w6.i.f19214g.H().length() == 0) {
            return;
        }
        d6.a.f12650a.m();
    }
}
