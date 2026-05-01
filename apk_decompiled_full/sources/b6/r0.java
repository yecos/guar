package b6;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b6.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.ClickChannelEpgEvent;
import com.mobile.brasiltv.bean.event.ClickSearchChannelEvent;
import com.mobile.brasiltv.bean.event.LiveFragVisibleEvent;
import com.mobile.brasiltv.bean.event.RefreshEPGEvent;
import com.mobile.brasiltv.bean.event.UpdateAllChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateChannelEvent;
import com.mobile.brasiltv.view.KoocanSwipeRefreshLayout;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.mobile.brasiltv.view.SCCustomTextView;
import com.mobile.brasiltv.view.dialog.BindEmailOrPhoneNotification;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.EpgResultData;
import org.greenrobot.eventbus.ThreadMode;
import w6.i;

/* loaded from: classes.dex */
public final class r0 extends b6.e<l6.u> implements j6.e, SwipeRefreshLayout.j, g5.h0 {
    public static final a A = new a(null);
    public static final String B = "bundleLiveType";
    public static final String C = "0";
    public static final String D = "1";
    public static final String E = "2";
    public static HashMap F = new HashMap();
    public static HashMap G = new HashMap();
    public static String H = "";

    /* renamed from: j, reason: collision with root package name */
    public LinearLayoutManagerWrapper f4872j;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4875m;

    /* renamed from: o, reason: collision with root package name */
    public int f4877o;

    /* renamed from: p, reason: collision with root package name */
    public Disposable f4878p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4879q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4880r;

    /* renamed from: w, reason: collision with root package name */
    public g6.d f4885w;

    /* renamed from: y, reason: collision with root package name */
    public l6.u f4887y;

    /* renamed from: z, reason: collision with root package name */
    public Map f4888z = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f4871i = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f4873k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f4874l = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f4876n = -1;

    /* renamed from: s, reason: collision with root package name */
    public final h9.g f4881s = h9.h.b(b.f4889a);

    /* renamed from: t, reason: collision with root package name */
    public final h9.g f4882t = h9.h.b(new r());

    /* renamed from: u, reason: collision with root package name */
    public final h9.g f4883u = h9.h.b(new l());

    /* renamed from: v, reason: collision with root package name */
    public final h9.g f4884v = h9.h.b(new m());

    /* renamed from: x, reason: collision with root package name */
    public final h9.g f4886x = h9.h.b(new n());

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return r0.B;
        }

        public final String b() {
            return r0.C;
        }

        public final String c() {
            return r0.D;
        }

        public final HashMap d() {
            return r0.G;
        }

        public final HashMap e() {
            return r0.F;
        }

        public final void f(String str) {
            t9.i.g(str, "<set-?>");
            r0.H = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f4889a = new b();

        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            ArrayList d10;
            ArrayList arrayList = new ArrayList();
            z.a aVar = z.f5049u;
            if (com.mobile.brasiltv.utils.b0.I(aVar.d()) && (d10 = aVar.d()) != null) {
                Iterator it = d10.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((ChildColumnList) it.next()).getId()));
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f4890a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "list");
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (ba.s.g(z.f5049u.f(), ((Channel) obj).getChannelCode(), false, 2, null)) {
                    return Observable.just(Integer.valueOf(i10));
                }
                i10 = i11;
            }
            return Observable.just(-1);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.l {
        public d() {
            super(1);
        }

        public final void b(Integer num) {
            if (num != null && num.intValue() == -1) {
                return;
            }
            LinearLayoutManagerWrapper linearLayoutManagerWrapper = r0.this.f4872j;
            if (linearLayoutManagerWrapper != null) {
                t9.i.e(num, "null cannot be cast to non-null type kotlin.Int");
                linearLayoutManagerWrapper.scrollToPositionWithOffset(num.intValue(), 0);
            }
            r0 r0Var = r0.this;
            t9.i.f(num, "it");
            r0Var.W3(num.intValue());
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f4892a = new e();

        public e() {
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

    /* loaded from: classes3.dex */
    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f4893a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(t9.w wVar) {
            super(1);
            this.f4893a = wVar;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "list");
            t9.w wVar = this.f4893a;
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (t9.i.b(wVar.f18961a, ((Channel) obj).getChannelCode())) {
                    return Observable.just(Integer.valueOf(i10));
                }
                i10 = i11;
            }
            return Observable.just(-1);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.l {
        public g() {
            super(1);
        }

        public final void b(Integer num) {
            g5.l0 f42 = r0.this.f4();
            if (f42 != null) {
                t9.i.f(num, "it");
                f42.c(num.intValue());
            }
            g5.l0 f43 = r0.this.f4();
            if (f43 != null) {
                f43.notifyDataSetChanged();
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f4895a = new h();

        public h() {
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

    /* loaded from: classes3.dex */
    public static final class i extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final i f4896a = new i();

        public i() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Long l10) {
            String c10 = y6.b.c();
            a aVar = r0.A;
            aVar.d().clear();
            for (Map.Entry entry : aVar.e().entrySet()) {
                for (EpgResultData epgResultData : (Iterable) entry.getValue()) {
                    String date = epgResultData.getDate();
                    t9.i.f(c10, "nowTime");
                    String substring = c10.substring(0, 10);
                    t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (t9.i.b(date, substring)) {
                        String start = epgResultData.getStart();
                        String substring2 = c10.substring(11, 16);
                        t9.i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        if (start.compareTo(substring2) < 0) {
                            String stop = epgResultData.getStop();
                            String substring3 = c10.substring(11, 16);
                            t9.i.f(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            if (stop.compareTo(substring3) > 0) {
                                r0.A.d().put(entry.getKey(), epgResultData);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends t9.j implements s9.l {
        public j() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Long l10) {
            g5.l0 f42 = r0.this.f4();
            if (com.mobile.brasiltv.utils.b0.I(f42 != null ? f42.getData() : null)) {
                g5.l0 f43 = r0.this.f4();
                if (f43 != null) {
                    f43.notifyDataSetChanged();
                }
                xa.c.c().j(new RefreshEPGEvent());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final k f4898a = new k();

        public k() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends t9.j implements s9.a {
        public l() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.l0 invoke() {
            androidx.fragment.app.e activity = r0.this.getActivity();
            if (activity != null) {
                return new g5.l0(activity);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends t9.j implements s9.a {
        public m() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.n0 invoke() {
            ArrayList<ChildColumnList> d10;
            ArrayList arrayList = new ArrayList();
            z.a aVar = z.f5049u;
            if (com.mobile.brasiltv.utils.b0.I(aVar.d()) && (d10 = aVar.d()) != null) {
                for (ChildColumnList childColumnList : d10) {
                    if (!com.mobile.brasiltv.utils.f0.b()) {
                        String alias = childColumnList.getAlias();
                        if (!(alias == null || alias.length() == 0)) {
                            String alias2 = childColumnList.getAlias();
                            if (alias2 == null) {
                                alias2 = "";
                            }
                            arrayList.add(alias2);
                        }
                    }
                    arrayList.add(childColumnList.getName());
                }
            }
            androidx.fragment.app.e activity = r0.this.getActivity();
            if (activity != null) {
                return new g5.n0(activity, arrayList, z.f5049u.d());
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends t9.j implements s9.a {
        public n() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            String string;
            Bundle arguments = r0.this.getArguments();
            return (arguments == null || (string = arguments.getString(r0.A.a())) == null) ? "" : string;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f4902a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(t9.w wVar) {
            super(1);
            this.f4902a = wVar;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Channel channel) {
            t9.i.g(channel, "it");
            return Boolean.valueOf(t9.i.b(this.f4902a.f18961a, channel.getChannelCode()));
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f4904b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(t9.w wVar) {
            super(1);
            this.f4904b = wVar;
        }

        public final void b(Channel channel) {
            r0.this.L3(r0.this.f4871i.indexOf(channel), (String) this.f4904b.f18961a);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final q f4905a = new q();

        public q() {
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

    /* loaded from: classes3.dex */
    public static final class r extends t9.j implements s9.a {
        public r() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            Bundle arguments = r0.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("fragment_live_index", 0) : 0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class s extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final s f4907a = new s();

        public s() {
            super(1);
        }

        public final void b(Channel channel) {
            z.f5049u.b().put(channel.getChannelCode(), channel);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class t extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final t f4908a = new t();

        public t() {
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

    public static final void G4(r0 r0Var, DialogInterface dialogInterface) {
        t9.i.g(r0Var, "this$0");
        r0Var.f4885w = null;
    }

    public static /* synthetic */ void N3(r0 r0Var, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        r0Var.M3(i10, z10);
    }

    public static final void P3(r0 r0Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(r0Var, "this$0");
        if (i10 >= r0Var.f4871i.size()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.mImageEpg) {
            if (id != R.id.mLayoutProgram) {
                return;
            }
            r0Var.L3(i10, ((Channel) r0Var.f4871i.get(i10)).getChannelCode());
            return;
        }
        xa.c c10 = xa.c.c();
        String channelCode = ((Channel) r0Var.f4871i.get(i10)).getChannelCode();
        String name = ((Channel) r0Var.f4871i.get(i10)).getName();
        int i11 = r0Var.f4877o;
        String alias = ((Channel) r0Var.f4871i.get(i10)).getAlias();
        if (alias == null) {
            alias = "";
        }
        c10.m(new ClickChannelEpgEvent(channelCode, name, i11, alias));
    }

    public static final void Q3(r0 r0Var) {
        t9.i.g(r0Var, "this$0");
        g5.l0 f42 = r0Var.f4();
        if (f42 != null) {
            f42.loadMoreEnd(true);
        }
    }

    public static final ObservableSource R3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void S3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void T3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource X3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void Y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Z3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void c4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void d4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean p4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void q4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void A4(l6.u uVar) {
        t9.i.g(uVar, "<set-?>");
        this.f4887y = uVar;
    }

    public final void B4() {
        int i10 = R$id.mEmptyRefreshLayout;
        if (((SwipeRefreshLayout) w3(i10)) == null) {
            return;
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(i10);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(8);
        }
        SCCustomTextView sCCustomTextView = (SCCustomTextView) w3(R$id.mLiveNoNetHintTopTv);
        if (sCCustomTextView != null) {
            sCCustomTextView.setVisibility(8);
        }
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout);
        if (koocanSwipeRefreshLayout == null) {
            return;
        }
        koocanSwipeRefreshLayout.setVisibility(0);
    }

    public final void C4(int i10, int i11) {
        g5.l0 f42;
        g5.l0 f43;
        g5.l0 f44;
        g5.l0 f45 = f4();
        if (f45 != null) {
            f45.c(i11);
        }
        if (i10 != -1 && (f44 = f4()) != null) {
            f44.notifyItemChanged(i10);
        }
        if (i11 != -1 && (f43 = f4()) != null) {
            f43.notifyItemChanged(i11);
        }
        int s42 = s4();
        if (i10 == s42 || s42 == -1 || (f42 = f4()) == null) {
            return;
        }
        f42.notifyItemChanged(s42);
    }

    public final void D4() {
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout);
        if (koocanSwipeRefreshLayout != null) {
            koocanSwipeRefreshLayout.setVisibility(8);
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(R$id.mEmptyRefreshLayout);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(0);
        }
        SCCustomTextView sCCustomTextView = (SCCustomTextView) w3(R$id.mLiveNoNetHintTopTv);
        if (sCCustomTextView != null) {
            sCCustomTextView.setVisibility(0);
        }
        SCCustomTextView sCCustomTextView2 = (SCCustomTextView) w3(R$id.noNetHintTv);
        if (sCCustomTextView2 == null) {
            return;
        }
        sCCustomTextView2.setVisibility(4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (b8.a.f5079a.b(r0) == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E4() {
        if (P2()) {
            androidx.fragment.app.e activity = getActivity();
            boolean z10 = activity != null;
            if (!z10) {
                D4();
                return;
            }
            KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout);
            if (koocanSwipeRefreshLayout != null) {
                koocanSwipeRefreshLayout.setVisibility(8);
            }
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(R$id.mEmptyRefreshLayout);
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setVisibility(0);
            }
            SCCustomTextView sCCustomTextView = (SCCustomTextView) w3(R$id.noNetHintTv);
            if (sCCustomTextView != null) {
                sCCustomTextView.setVisibility(4);
            }
            SCCustomTextView sCCustomTextView2 = (SCCustomTextView) w3(R$id.mLiveNoNetHintTopTv);
            if (sCCustomTextView2 == null) {
                return;
            }
            sCCustomTextView2.setVisibility(0);
        }
    }

    public final boolean F4() {
        if (!MainAty.A.f()) {
            return true;
        }
        if (this.f4885w == null) {
            Context context = getContext();
            g6.d dVar = context != null ? new g6.d(context) : null;
            this.f4885w = dVar;
            if (dVar != null) {
                dVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b6.f0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        r0.G4(r0.this, dialogInterface);
                    }
                });
            }
        }
        g6.d dVar2 = this.f4885w;
        if (dVar2 != null) {
            dVar2.h(true);
        }
        g6.d dVar3 = this.f4885w;
        if (dVar3 == null) {
            return false;
        }
        dVar3.show();
        return false;
    }

    @Override // j6.e
    public void G(List list, int i10) {
        t9.i.g(list, "list");
        z.f5049u.g().put(i10, list);
    }

    public final boolean I3() {
        if (getContext() == null) {
            return false;
        }
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        Context context = getContext();
        t9.i.d(context);
        boolean c10 = com.mobile.brasiltv.utils.n0.c(n0Var, context, "live_first_play_free_column", false, 4, null);
        i.c cVar = w6.i.f19214g;
        return (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2")) && t9.i.b(cVar.e(), "1") && c10;
    }

    public final boolean J3() {
        if (I3() && this.f4871i.size() > 0) {
            z.f5049u.n(((Channel) this.f4871i.get(0)).getChannelCode());
        }
        return t9.i.b(z.f5049u.f(), H);
    }

    public final boolean K3() {
        d6.b bVar = d6.b.f12660a;
        if (bVar.a() && (!bVar.c() || bVar.b() || bVar.d())) {
            return true;
        }
        Context context = getContext();
        if (context == null) {
            return false;
        }
        new BindEmailOrPhoneNotification(context).show();
        return false;
    }

    public final void L3(int i10, String str) {
        String str2;
        ChildColumnList b10;
        androidx.fragment.app.e activity;
        if ((str.length() == 0) || t9.i.b(str, H)) {
            return;
        }
        androidx.fragment.app.e activity2 = getActivity();
        UpdateChannelEvent updateChannelEvent = null;
        Integer valueOf = activity2 != null ? Integer.valueOf(com.mobile.brasiltv.utils.n0.f8733a.d(activity2, "live_last_play_column_index", 0)) : null;
        androidx.fragment.app.e activity3 = getActivity();
        if (activity3 != null) {
            com.mobile.brasiltv.utils.n0.f8733a.i(activity3, "live_last_play_column_index", this.f4876n);
        }
        i.c cVar = w6.i.f19214g;
        if (((t9.i.b(cVar.e(), "1") && t9.i.b(cVar.I(), "1")) || t9.i.b(cVar.I(), "2")) && (activity = getActivity()) != null) {
            com.mobile.brasiltv.utils.n0.f8733a.g(activity, "live_first_play_free_column", false);
        }
        W3(i10);
        y4(this.f4871i, i10);
        H = str;
        xa.c c10 = xa.c.c();
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            ArrayList arrayList = this.f4871i;
            String h42 = h4();
            int i11 = this.f4877o;
            g5.n0 g42 = g4();
            if (g42 == null || (b10 = g42.b()) == null || (str2 = b10.getAlias()) == null) {
                str2 = "";
            }
            updateChannelEvent = new UpdateChannelEvent(arrayList, i10, true, h42, i11, str2, intValue);
        }
        c10.j(updateChannelEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f2, code lost:
    
        if ((r0 != null && r2 == r0.getId()) != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M3(int i10, boolean z10) {
        List data;
        List data2;
        int i11 = 0;
        int i12 = i10 == -1 ? 0 : i10;
        if (com.mobile.brasiltv.utils.b0.G(b4())) {
            return;
        }
        if (i12 >= b4().size()) {
            i12 = 0;
        }
        Object obj = b4().get(i12);
        t9.i.f(obj, "allColumnIdList[index]");
        int intValue = ((Number) obj).intValue();
        this.f4876n = i12;
        this.f4877o = intValue;
        U3(i12);
        g5.l0 f42 = f4();
        if (f42 != null && (data2 = f42.getData()) != null) {
            data2.clear();
        }
        g5.l0 f43 = f4();
        if (f43 != null) {
            f43.notifyDataSetChanged();
        }
        int i13 = R$id.tvTips;
        ((TextView) w3(i13)).setVisibility(8);
        Log.e("LiveItemFrag", String.valueOf(i10));
        z.a aVar = z.f5049u;
        ChildColumnList a10 = aVar.a();
        if (!(a10 != null && intValue == a10.getId()) || (K3() && F4())) {
            if (z10 || aVar.g().indexOfKey(intValue) < 0) {
                a3().k(intValue, false);
                return;
            }
            if (((List) aVar.g().get(intValue)).isEmpty()) {
                D4();
            } else {
                B4();
            }
            g5.l0 f44 = f4();
            if (f44 != null && (data = f44.getData()) != null) {
                Object obj2 = aVar.g().get(intValue);
                t9.i.f(obj2, "LiveFrag.mChannelMap[columnId]");
                data.addAll((Collection) obj2);
            }
            V3();
            TextView textView = (TextView) w3(i13);
            t9.i.f(aVar.g().get(intValue), "LiveFrag.mChannelMap[columnId]");
            if (!((Collection) r0).isEmpty()) {
                ChildColumnList a11 = aVar.a();
            }
            i11 = 8;
            textView.setVisibility(i11);
            this.f4871i.clear();
            this.f4871i.addAll((Collection) aVar.g().get(intValue));
        }
    }

    public final void O3() {
        SwipeRefreshLayout swipeRefreshLayout;
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout;
        FrameLayout frameLayout = (FrameLayout) w3(R$id.mFlLoading);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        if (this.f4875m) {
            this.f4875m = false;
            int i10 = R$id.mRefreshLayout;
            KoocanSwipeRefreshLayout koocanSwipeRefreshLayout2 = (KoocanSwipeRefreshLayout) w3(i10);
            if ((koocanSwipeRefreshLayout2 != null && koocanSwipeRefreshLayout2.isRefreshing()) && (koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(i10)) != null) {
                koocanSwipeRefreshLayout.setRefreshing(false);
            }
            int i11 = R$id.mEmptyRefreshLayout;
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) w3(i11);
            if (!(swipeRefreshLayout2 != null && swipeRefreshLayout2.isRefreshing()) || (swipeRefreshLayout = (SwipeRefreshLayout) w3(i11)) == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // g5.h0
    public /* bridge */ /* synthetic */ void S0(Boolean bool) {
        z4(bool.booleanValue());
    }

    @Override // k5.a
    public void T2() {
        if (getContext() != null) {
            int k42 = k4();
            g5.n0 g42 = g4();
            if (k42 >= (g42 != null ? g42.getItemCount() : 0)) {
                n4();
                k42 = 0;
            }
            N3(this, k42, false, 2, null);
            if (k42 != this.f4876n) {
                N3(this, k42, false, 2, null);
                if (this.f4879q || !J3()) {
                    o4();
                }
            } else if (this.f4880r) {
                o4();
            }
            a4();
            this.f4879q = false;
            this.f4880r = false;
        }
    }

    @Override // k5.a
    public void U2() {
        if (Q2()) {
            O3();
        }
    }

    public final void U3(int i10) {
        g5.n0 g42;
        g5.n0 g43 = g4();
        if ((g43 != null ? g43.getItemCount() : 0) <= i10 || (g42 = g4()) == null) {
            return;
        }
        g42.h(i10);
    }

    @Override // g5.h0
    public void V0() {
        Disposable disposable = this.f4878p;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<R> compose = Observable.interval(5L, 900L, TimeUnit.SECONDS).compose(O2());
        final i iVar = i.f4896a;
        Observable observeOn = compose.doOnNext(new Consumer() { // from class: b6.a0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.c4(s9.l.this, obj);
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
        final j jVar = new j();
        Consumer consumer = new Consumer() { // from class: b6.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.d4(s9.l.this, obj);
            }
        };
        final k kVar = k.f4898a;
        this.f4878p = observeOn.subscribe(consumer, new Consumer() { // from class: b6.j0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.e4(s9.l.this, obj);
            }
        });
    }

    @Override // k5.a
    public void V2() {
        super.V2();
    }

    public final void V3() {
        t9.w wVar = new t9.w();
        String f10 = z.f5049u.f();
        if (f10 == null) {
            f10 = "";
        }
        wVar.f18961a = f10;
        g5.l0 f42 = f4();
        Observable just = Observable.just(f42 != null ? f42.getData() : null);
        final f fVar = new f(wVar);
        Observable compose = just.flatMap(new Function() { // from class: b6.m0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource X3;
                X3 = r0.X3(s9.l.this, obj);
                return X3;
            }
        }).compose(com.mobile.brasiltv.utils.p0.a());
        final g gVar = new g();
        Consumer consumer = new Consumer() { // from class: b6.n0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.Y3(s9.l.this, obj);
            }
        };
        final h hVar = h.f4895a;
        compose.subscribe(consumer, new Consumer() { // from class: b6.o0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.Z3(s9.l.this, obj);
            }
        });
    }

    public final void W3(int i10) {
        int i11 = this.f4874l;
        this.f4873k = i11;
        this.f4874l = i10;
        C4(i11, i10);
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4888z.clear();
    }

    @Override // b6.e
    public void Y2() {
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(com.mobile.brasiltv.utils.s0.a(getActivity(), 1.0f), 0, true);
        this.f4872j = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewLiveInfo;
        RecyclerView recyclerView = (RecyclerView) w3(i10);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f4872j);
        }
        RecyclerView recyclerView2 = (RecyclerView) w3(i10);
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(linerItemDecoration);
        }
        int i11 = R$id.mRefreshLayout;
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(i11);
        if (koocanSwipeRefreshLayout != null) {
            koocanSwipeRefreshLayout.setColorSchemeResources(R.color.color_important);
        }
        int i12 = R$id.mEmptyRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(i12);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(R.color.color_important);
        }
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout2 = (KoocanSwipeRefreshLayout) w3(i11);
        if (koocanSwipeRefreshLayout2 != null) {
            koocanSwipeRefreshLayout2.setOnRefreshListener(this);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) w3(i12);
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setOnRefreshListener(this);
        }
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout3 = (KoocanSwipeRefreshLayout) w3(i11);
        if (koocanSwipeRefreshLayout3 != null) {
            koocanSwipeRefreshLayout3.setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        }
        g5.l0 f42 = f4();
        if (f42 != null) {
            f42.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: b6.k0
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                    r0.P3(r0.this, baseQuickAdapter, view, i13);
                }
            });
        }
        RecyclerView recyclerView3 = (RecyclerView) w3(i10);
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(f4());
        }
        g5.l0 f43 = f4();
        if (f43 != null) {
            f43.bindToRecyclerView((RecyclerView) w3(i10));
        }
        g5.l0 f44 = f4();
        if (f44 != null) {
            f44.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: b6.l0
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                public final void onLoadMoreRequested() {
                    r0.Q3(r0.this);
                }
            });
        }
        g5.l0 f45 = f4();
        if (f45 != null) {
            f45.setLoadMoreView(new RecyclerLoadMoreView());
        }
        m4();
    }

    public final void a4() {
        List data;
        List data2;
        List data3;
        int i10 = 0;
        if (I3() || com.mobile.brasiltv.utils.b0.H(z.f5049u.f())) {
            g5.l0 f42 = f4();
            if (f42 != null && (data = f42.getData()) != null) {
                i10 = data.size();
            }
            if (i10 > 0) {
                c1();
                int j42 = j4();
                if (k4() == j42) {
                    U3(j42);
                    return;
                }
                return;
            }
            return;
        }
        g5.l0 f43 = f4();
        if (((f43 == null || (data3 = f43.getData()) == null) ? 0 : data3.size()) > 0) {
            LinearLayoutManagerWrapper linearLayoutManagerWrapper = this.f4872j;
            if (linearLayoutManagerWrapper != null) {
                linearLayoutManagerWrapper.scrollToPositionWithOffset(0, 0);
            }
            U3(0);
            W3(0);
            g5.l0 f44 = f4();
            if (f44 == null || (data2 = f44.getData()) == null) {
                return;
            }
            y4(data2, this.f4874l);
        }
    }

    public final ArrayList b4() {
        return (ArrayList) this.f4881s.getValue();
    }

    @Override // g5.h0
    public void c1() {
        g5.l0 f42 = f4();
        Observable just = Observable.just(f42 != null ? f42.getData() : null);
        final c cVar = c.f4890a;
        Observable compose = just.flatMap(new Function() { // from class: b6.p0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource R3;
                R3 = r0.R3(s9.l.this, obj);
                return R3;
            }
        }).compose(com.mobile.brasiltv.utils.p0.a());
        final d dVar = new d();
        Consumer consumer = new Consumer() { // from class: b6.q0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.S3(s9.l.this, obj);
            }
        };
        final e eVar = e.f4892a;
        compose.subscribe(consumer, new Consumer() { // from class: b6.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.T3(s9.l.this, obj);
            }
        });
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_live_item;
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        List data;
        g6.d dVar;
        t9.i.g(checkPwdSuccessEvent, "event");
        MainAty.A.o(false);
        z.a aVar = z.f5049u;
        ChildColumnList a10 = aVar.a();
        if (a10 != null && this.f4877o == a10.getId()) {
            g6.d dVar2 = this.f4885w;
            if ((dVar2 != null && dVar2.isShowing()) && (dVar = this.f4885w) != null) {
                dVar.cancel();
            }
            if (aVar.g().indexOfKey(this.f4877o) < 0) {
                k7.f.e("请求当前栏目", new Object[0]);
                a3().k(this.f4877o, false);
                return;
            }
            k7.f.e("直接加载当前栏目", new Object[0]);
            List list = (List) aVar.g().get(this.f4877o);
            if (list != null && list.isEmpty()) {
                D4();
            } else {
                B4();
            }
            g5.l0 f42 = f4();
            if (f42 != null && (data = f42.getData()) != null) {
                Object obj = aVar.g().get(this.f4877o);
                t9.i.f(obj, "LiveFrag.mChannelMap[currentColumnId]");
                data.addAll((Collection) obj);
            }
            V3();
            TextView textView = (TextView) w3(R$id.tvTips);
            Object obj2 = aVar.g().get(this.f4877o);
            t9.i.f(obj2, "LiveFrag.mChannelMap[currentColumnId]");
            textView.setVisibility(true ^ ((Collection) obj2).isEmpty() ? 0 : 8);
            this.f4871i.clear();
            this.f4871i.addAll((Collection) aVar.g().get(this.f4877o));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    @xa.j(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void clickSearchChannel(ClickSearchChannelEvent clickSearchChannelEvent) {
        boolean z10;
        t9.i.g(clickSearchChannelEvent, "event");
        k7.f.e("播放搜索的频道 channelCode: " + clickSearchChannelEvent.getChannel().getChannelCode(), new Object[0]);
        z.a aVar = z.f5049u;
        aVar.n(clickSearchChannelEvent.getChannel().getChannelCode());
        H = "";
        if (aVar.e() != null) {
            i.c cVar = w6.i.f19214g;
            if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                SparseArray g10 = aVar.g();
                ChildColumnList e10 = aVar.e();
                List list = (List) g10.get(e10 != null ? e10.getId() : 0);
                if (list != null) {
                    Iterator it = list.iterator();
                    z10 = false;
                    while (it.hasNext()) {
                        if (TextUtils.equals(clickSearchChannelEvent.getChannel().getChannelCode(), ((Channel) it.next()).getChannelCode())) {
                            z10 = true;
                        }
                    }
                    if (z10) {
                        N3(this, 0, false, 2, null);
                    } else {
                        N3(this, 1, false, 2, null);
                    }
                    o4();
                    c1();
                }
            }
        }
        z10 = false;
        if (z10) {
        }
        o4();
        c1();
    }

    public final g5.l0 f4() {
        return (g5.l0) this.f4883u.getValue();
    }

    @xa.j
    public final void fragVisibleEvent(LiveFragVisibleEvent liveFragVisibleEvent) {
        t9.i.g(liveFragVisibleEvent, "event");
        if (liveFragVisibleEvent.getVisible()) {
            V2();
        } else {
            U2();
        }
    }

    @Override // j6.e
    public void g(List list, int i10) {
        t9.i.g(list, "list");
        O3();
        z.f5049u.g().put(i10, list);
        Integer num = (Integer) b4().get(0);
        if (num != null && num.intValue() == i10) {
            v4(list);
        }
        if (this.f4877o == i10) {
            l4(list);
            this.f4871i.clear();
            this.f4871i.addAll(list);
            o4();
        }
    }

    public final g5.n0 g4() {
        return (g5.n0) this.f4884v.getValue();
    }

    public final void h() {
        FrameLayout frameLayout;
        if (this.f4875m || (frameLayout = (FrameLayout) w3(R$id.mFlLoading)) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    public String h4() {
        return (String) this.f4886x.getValue();
    }

    @Override // b6.e
    /* renamed from: i4, reason: merged with bridge method [inline-methods] */
    public l6.u a3() {
        l6.u uVar = this.f4887y;
        if (uVar != null) {
            return uVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final int j4() {
        if (getContext() == null) {
            return 0;
        }
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f8733a;
        Context context = getContext();
        t9.i.d(context);
        int d10 = n0Var.d(context, "live_last_play_column_index", 0);
        if (I3() && t4() != -1) {
            d10 = t4();
        }
        if (d10 == -1) {
            return 0;
        }
        return d10;
    }

    @Override // g5.h0
    public void k2() {
        T2();
    }

    public final int k4() {
        return ((Number) this.f4882t.getValue()).intValue();
    }

    public final void l4(List list) {
        List data;
        List data2;
        int i10;
        V0();
        TextView textView = (TextView) w3(R$id.tvTips);
        if (textView != null) {
            if (!list.isEmpty()) {
                ChildColumnList a10 = z.f5049u.a();
                if (a10 != null && this.f4877o == a10.getId()) {
                    i10 = 0;
                    textView.setVisibility(i10);
                }
            }
            i10 = 8;
            textView.setVisibility(i10);
        }
        g5.l0 f42 = f4();
        if (f42 != null && (data2 = f42.getData()) != null) {
            data2.clear();
        }
        g5.l0 f43 = f4();
        if (f43 != null && (data = f43.getData()) != null) {
            data.addAll(list);
        }
        g5.l0 f44 = f4();
        if (f44 != null) {
            f44.notifyDataSetChanged();
        }
        if (!list.isEmpty()) {
            B4();
        } else {
            D4();
        }
        if (!this.f4875m) {
            if (H.length() == 0) {
                a4();
            }
        }
        if (H.length() > 0) {
            V3();
        }
    }

    public final void m4() {
        n4();
        this.f4879q = false;
        j4();
    }

    public final void n4() {
        Context context = getContext();
        String e10 = context != null ? com.mobile.brasiltv.utils.n0.f8733a.e(context, "live_last_play_chanel_NORMAL", "") : null;
        if (com.mobile.brasiltv.utils.b0.H(e10)) {
            z.a aVar = z.f5049u;
            if (!t9.i.b(e10, aVar.f())) {
                Context context2 = getContext();
                if (context2 != null) {
                    com.mobile.brasiltv.utils.n0.f8733a.i(context2, "live_last_play_column_index", 0);
                }
                aVar.n(e10);
            }
        }
        this.f4879q = true;
    }

    public final void o4() {
        t9.w wVar = new t9.w();
        String f10 = z.f5049u.f();
        if (f10 == null) {
            f10 = "";
        }
        wVar.f18961a = f10;
        if ((f10.length() == 0) || I3()) {
            if (this.f4871i.size() > 0) {
                L3(0, ((Channel) this.f4871i.get(0)).getChannelCode());
                return;
            }
            return;
        }
        Observable fromIterable = Observable.fromIterable(this.f4871i);
        final o oVar = new o(wVar);
        Observable compose = fromIterable.filter(new Predicate() { // from class: b6.c0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean p42;
                p42 = r0.p4(s9.l.this, obj);
                return p42;
            }
        }).compose(com.mobile.brasiltv.utils.p0.a());
        final p pVar = new p(wVar);
        Consumer consumer = new Consumer() { // from class: b6.d0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.q4(s9.l.this, obj);
            }
        };
        final q qVar = q.f4905a;
        compose.subscribe(consumer, new Consumer() { // from class: b6.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.r4(s9.l.this, obj);
            }
        });
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A4(new l6.u(this, this));
        xa.c.c().o(this);
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f4878p;
        if (disposable != null) {
            disposable.dispose();
        }
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Disposable disposable = this.f4878p;
        if (disposable != null) {
            disposable.dispose();
        }
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        X2();
    }

    @Override // j6.e
    public void onError() {
        O3();
        E4();
    }

    @Override // j6.e
    public void onLoading() {
        String.valueOf(k4());
        h();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        ChildColumnList a10 = z.f5049u.a();
        if ((a10 != null && this.f4877o == a10.getId()) && (!K3() || !F4())) {
            ((KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout)).setRefreshing(false);
            return;
        }
        this.f4875m = true;
        B4();
        u4();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint() && this.f4880r && z.f5049u.h()) {
            o4();
            a4();
            boolean z10 = false;
            this.f4880r = false;
            Disposable disposable = this.f4878p;
            if (disposable != null) {
                if (disposable != null && disposable.isDisposed()) {
                    z10 = true;
                }
                if (z10) {
                    V0();
                }
            }
        }
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FrameLayout frameLayout = (FrameLayout) w3(R$id.mFlLoading);
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public final int s4() {
        z.a aVar = z.f5049u;
        int i10 = -1;
        if (aVar.g().indexOfKey(this.f4877o) >= 0) {
            List list = (List) aVar.g().get(this.f4877o);
            int i11 = 0;
            if ((list == null || list.isEmpty()) ? false : true) {
                List list2 = (List) aVar.g().get(this.f4877o);
                t9.i.f(list2, "channelList");
                for (Object obj : list2) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        i9.j.j();
                    }
                    if (t9.i.b(((Channel) obj).getChannelCode(), H)) {
                        i10 = i11;
                    }
                    i11 = i12;
                }
            }
        }
        return i10;
    }

    public final int t4() {
        int i10 = -1;
        if (!b4().isEmpty() && z.f5049u.e() != null) {
            int i11 = 0;
            for (Object obj : b4()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                int intValue = ((Number) obj).intValue();
                ChildColumnList e10 = z.f5049u.e();
                if (e10 != null && e10.getId() == intValue) {
                    i10 = i11;
                }
                i11 = i12;
            }
        }
        return i10;
    }

    public final void u4() {
        h();
        a3().k(this.f4877o, false);
    }

    public final void v4(List list) {
        t9.i.g(list, "liveProgramBean");
        z.a aVar = z.f5049u;
        aVar.b().clear();
        if (!list.isEmpty()) {
            aVar.j(((Channel) list.get(0)).getChannelCode());
        }
        xa.c.c().m(new UpdateAllChannelEvent(list));
        Observable fromIterable = Observable.fromIterable(list);
        final s sVar = s.f4907a;
        Consumer consumer = new Consumer() { // from class: b6.g0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.w4(s9.l.this, obj);
            }
        };
        final t tVar = t.f4908a;
        fromIterable.subscribe(consumer, new Consumer() { // from class: b6.h0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r0.x4(s9.l.this, obj);
            }
        });
    }

    public View w3(int i10) {
        View findViewById;
        Map map = this.f4888z;
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

    public final void y4(List list, int i10) {
        t9.i.g(list, "listChannel");
        if (list.size() <= i10 || i10 < 0) {
            return;
        }
        z.a aVar = z.f5049u;
        aVar.n(((Channel) list.get(i10)).getChannelCode());
        Context context = getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.n0.f8733a.j(context, "live_last_play_chanel", aVar.f());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z4(boolean z10) {
        i.c cVar;
        g5.n0 g42;
        this.f4880r = z10;
        z.a aVar = z.f5049u;
        if (aVar.d() == null) {
            return;
        }
        String str = null;
        if (!com.mobile.brasiltv.utils.f0.b()) {
            ChildColumnList e10 = aVar.e();
            String alias = e10 != null ? e10.getAlias() : null;
            if (!(alias == null || alias.length() == 0)) {
                ChildColumnList e11 = aVar.e();
                if (e11 != null) {
                    str = e11.getAlias();
                }
                cVar = w6.i.f19214g;
                if (t9.i.b(cVar.e(), "1") || !(t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                    ArrayList b42 = b4();
                    ChildColumnList e12 = aVar.e();
                    b42.remove(Integer.valueOf(e12 != null ? e12.getId() : 0));
                    g42 = g4();
                    if (g42 == null) {
                        if (str == null) {
                            str = "";
                        }
                        g42.g(str);
                        return;
                    }
                    return;
                }
                ArrayList b43 = b4();
                ChildColumnList e13 = aVar.e();
                t9.i.d(e13);
                if (!b43.contains(Integer.valueOf(e13.getId()))) {
                    if (b4().size() > 0) {
                        ArrayList b44 = b4();
                        ChildColumnList e14 = aVar.e();
                        t9.i.d(e14);
                        b44.add(1, Integer.valueOf(e14.getId()));
                    } else {
                        ArrayList b45 = b4();
                        ChildColumnList e15 = aVar.e();
                        t9.i.d(e15);
                        b45.add(Integer.valueOf(e15.getId()));
                    }
                }
                g5.n0 g43 = g4();
                if (g43 != null) {
                    if (str == null) {
                        str = "";
                    }
                    g43.c(1, str);
                    return;
                }
                return;
            }
        }
        ChildColumnList e16 = aVar.e();
        if (e16 != null) {
            str = e16.getName();
        }
        cVar = w6.i.f19214g;
        if (t9.i.b(cVar.e(), "1")) {
        }
        ArrayList b422 = b4();
        ChildColumnList e122 = aVar.e();
        b422.remove(Integer.valueOf(e122 != null ? e122.getId() : 0));
        g42 = g4();
        if (g42 == null) {
        }
    }
}
