package b6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b6.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.ClickChannelEpgEvent;
import com.mobile.brasiltv.bean.event.ReadyPlayFavEvent;
import com.mobile.brasiltv.bean.event.UpdateChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.bean.event.UpdateHighLightEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.Favorite;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class w extends f {

    /* renamed from: f, reason: collision with root package name */
    public LinearLayoutManagerWrapper f5026f;

    /* renamed from: k, reason: collision with root package name */
    public Map f5031k = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final h9.g f5025e = h9.h.b(new b());

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f5027g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f5028h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f5029i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f5030j = h9.h.b(a.f5032a);

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5032a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            z.a aVar = z.f5049u;
            int i10 = 0;
            if (com.mobile.brasiltv.utils.b0.I(aVar.d())) {
                ArrayList d10 = aVar.d();
                t9.i.d(d10);
                i10 = ((ChildColumnList) d10.get(0)).getId();
            }
            return Integer.valueOf(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.l0 invoke() {
            Context context = w.this.getContext();
            t9.i.d(context);
            g5.l0 l0Var = new g5.l0(context);
            l0Var.d(true);
            return l0Var;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        public final void b(Integer num) {
            w.this.j3().getData().clear();
            w.this.j3().getData().addAll(w.this.f5028h);
            w.this.j3().notifyDataSetChanged();
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f5035a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final void n3(w wVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(wVar, "this$0");
        int id = view.getId();
        if (id == R.id.mFavWrapper) {
            wVar.k3(i10);
            return;
        }
        if (id == R.id.mImageEpg) {
            xa.c c10 = xa.c.c();
            String alias = ((Channel) wVar.f5028h.get(i10)).getAlias();
            c10.m(alias != null ? new ClickChannelEpgEvent(((Channel) wVar.f5028h.get(i10)).getChannelCode(), ((Channel) wVar.f5028h.get(i10)).getName(), wVar.i3(), alias) : null);
        } else if (id == R.id.mLayoutProgram && wVar.f5028h.size() > 0 && i10 <= wVar.f5028h.size() - 1) {
            wVar.f3(i10, ((Channel) wVar.f5028h.get(i10)).getChannelCode());
        }
    }

    public static final void r3(w wVar, ObservableEmitter observableEmitter) {
        t9.i.g(wVar, "this$0");
        t9.i.g(observableEmitter, "it");
        wVar.f5027g.clear();
        wVar.f5027g.addAll(d6.a.f12650a.i());
        wVar.h3();
        wVar.g3();
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

    @Override // k5.a
    public void T2() {
    }

    @Override // b6.f
    public void X2() {
        this.f5031k.clear();
    }

    @xa.j
    public final void alreadyQueryFav(AlreadyQueryFavEvent alreadyQueryFavEvent) {
        t9.i.g(alreadyQueryFavEvent, "event");
        q3();
    }

    public View c3(int i10) {
        View findViewById;
        Map map = this.f5031k;
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

    public final void f3(int i10, String str) {
        String f10 = z.f5049u.f();
        if (f10 == null) {
            f10 = "";
        }
        k7.f.e("clickItem position: " + i10 + " + channelCode: " + str + " + lastChannelCode " + f10, new Object[0]);
        if ((str.length() == 0) || t9.i.b(str, f10)) {
            com.mobile.brasiltv.utils.b0.U(this, "不播放，当前curPlayIndex：" + i10);
            return;
        }
        com.mobile.brasiltv.utils.b0.U(this, "换台 position: " + i10 + ", channelCode: " + str);
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        int d10 = n0Var.d(activity, "live_last_play_column_index", 0);
        androidx.fragment.app.e activity2 = getActivity();
        t9.i.d(activity2);
        n0Var.i(activity2, "live_last_play_column_index", -1);
        j3().c(i10);
        j3().notifyDataSetChanged();
        p3(this.f5028h, i10);
        this.f5029i.clear();
        this.f5029i.addAll(this.f5028h);
        xa.c.c().j(new ReadyPlayFavEvent(this.f5029i, i10, d10));
    }

    public final void g3() {
        String f10 = z.f5049u.f();
        if (f10 == null) {
            f10 = "";
        }
        int i10 = 0;
        for (Object obj : this.f5028h) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            if (t9.i.b(f10, ((Channel) obj).getChannelCode())) {
                j3().c(i10);
                return;
            }
            i10 = i11;
        }
        j3().c(-1);
    }

    public final void h3() {
        w wVar = this;
        wVar.f5028h.clear();
        if (wVar.f5027g.size() > 0) {
            for (Favorite favorite : wVar.f5027g) {
                ArrayList arrayList = wVar.f5028h;
                String contentId = favorite.getContentId();
                t9.i.d(contentId);
                String name = favorite.getName();
                t9.i.d(name);
                arrayList.add(new Channel(contentId, name, favorite.getAlias(), 0, favorite.getPosterUrl(), null, "0", null, null, null, null));
                wVar = this;
            }
        }
    }

    public final int i3() {
        return ((Number) this.f5030j.getValue()).intValue();
    }

    public final g5.l0 j3() {
        return (g5.l0) this.f5025e.getValue();
    }

    public final void k3(int i10) {
        if (i10 >= this.f5028h.size()) {
            return;
        }
        Object obj = this.f5028h.get(i10);
        t9.i.f(obj, "channelList[pos]");
        Channel channel = (Channel) obj;
        d6.a aVar = d6.a.f12650a;
        if (aVar.l(channel.getChannelCode())) {
            return;
        }
        aVar.f(channel.getChannelCode());
        j3().g(channel.getChannelCode(), i10);
        aVar.h(channel);
    }

    public final void l3() {
        d6.a aVar = d6.a.f12650a;
        if (aVar.j() == 3 && (!aVar.i().isEmpty())) {
            q3();
        } else if (aVar.j() == 1) {
            aVar.m();
        }
    }

    public final void m3() {
        j3().setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: b6.s
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                w.n3(w.this, baseQuickAdapter, view, i10);
            }
        });
    }

    public final void o3() {
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(com.mobile.brasiltv.utils.s0.a(getActivity(), 1.0f), 0, true);
        this.f5026f = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewLiveInfo;
        RecyclerView recyclerView = (RecyclerView) c3(i10);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = this.f5026f;
        if (linearLayoutManagerWrapper == null) {
            t9.i.w("layoutManager");
            linearLayoutManagerWrapper = null;
        }
        recyclerView.setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) c3(i10)).addItemDecoration(linerItemDecoration);
        ((RecyclerView) c3(i10)).setAdapter(j3());
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (xa.c.c().h(this)) {
            return;
        }
        xa.c.c().o(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t9.i.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_live_fav, viewGroup, false);
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    @Override // b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            return;
        }
        j3().notifyDataSetChanged();
    }

    @Override // k5.a, u8.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        o3();
        m3();
        l3();
    }

    public final void p3(List list, int i10) {
        t9.i.g(list, "listChannel");
        if (list.size() <= i10 || i10 < 0) {
            return;
        }
        z.a aVar = z.f5049u;
        aVar.n(((Channel) list.get(i10)).getChannelCode());
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        Context context = getContext();
        t9.i.d(context);
        n0Var.j(context, "live_last_play_chanel", aVar.f());
    }

    public final void q3() {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: b6.t
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                w.r3(w.this, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.a());
        final c cVar = new c();
        Consumer consumer = new Consumer() { // from class: b6.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                w.s3(s9.l.this, obj);
            }
        };
        final d dVar = d.f5035a;
        compose.subscribe(consumer, new Consumer() { // from class: b6.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                w.t3(s9.l.this, obj);
            }
        });
    }

    @xa.j
    public final void readyHighLightItem(UpdateHighLightEvent updateHighLightEvent) {
        t9.i.g(updateHighLightEvent, "event");
        k7.f.e("从全屏返回 LiveFavFrag 刷新页面", new Object[0]);
        g3();
        j3().notifyDataSetChanged();
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        t9.i.g(updateFavStatusEvent, "event");
        q3();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void userLogOut(UserIdentityChangeEvent userIdentityChangeEvent) {
        t9.i.g(userIdentityChangeEvent, "event");
        if (!t9.i.b(w6.i.f19214g.I(), "1")) {
            l3();
            return;
        }
        this.f5027g.clear();
        this.f5028h.clear();
        j3().getData().clear();
        j3().notifyDataSetChanged();
    }

    @xa.j
    public final void whenLiveItemClickPlay(UpdateChannelEvent updateChannelEvent) {
        t9.i.g(updateChannelEvent, "event");
        k7.f.e("LiveItem点击播放 LiveFavFrag 刷新页面", new Object[0]);
        g3();
        j3().notifyDataSetChanged();
    }
}
