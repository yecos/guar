package b6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.LiveTabEpgNotificationEvent;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.mobile.brasiltv.view.LoadingDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import g5.k0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class r extends f implements k0.a, g5.g0 {

    /* renamed from: j, reason: collision with root package name */
    public static final a f4860j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static String f4861k = "";

    /* renamed from: l, reason: collision with root package name */
    public static String f4862l = "";

    /* renamed from: m, reason: collision with root package name */
    public static int f4863m = -1;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayoutManagerWrapper f4865f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayoutManagerWrapper f4866g;

    /* renamed from: i, reason: collision with root package name */
    public Map f4868i = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final h9.g f4864e = h9.h.b(new c());

    /* renamed from: h, reason: collision with root package name */
    public final h9.g f4867h = h9.h.b(new b());

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return r.f4862l;
        }

        public final String b() {
            return r.f4861k;
        }

        public final int c() {
            return r.f4863m;
        }

        public final void d(String str) {
            t9.i.g(str, "<set-?>");
            r.f4862l = str;
        }

        public final void e(String str) {
            t9.i.g(str, "<set-?>");
            r.f4861k = str;
        }

        public final void f(int i10) {
            r.f4863m = i10;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.k0 invoke() {
            androidx.fragment.app.e activity = r.this.getActivity();
            t9.i.d(activity);
            return new g5.k0(activity, r.this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            Bundle arguments = r.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("fragment_live_tab_index", 0) : 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (com.mobile.brasiltv.utils.b0.I(r4) == true) goto L8;
     */
    @Override // g5.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P0(List list) {
        f3().getData().clear();
        showLoading(false);
        boolean z10 = list != null;
        if (!z10) {
            AutoLinearLayout autoLinearLayout = (AutoLinearLayout) Y2(R$id.mLlNoData);
            if (autoLinearLayout == null) {
                return;
            }
            autoLinearLayout.setVisibility(0);
            return;
        }
        RecyclerView recyclerView = (RecyclerView) Y2(R$id.mRecyclerViewEpg);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        f3().getData().addAll(list);
        f3().notifyDataSetChanged();
        AutoLinearLayout autoLinearLayout2 = (AutoLinearLayout) Y2(R$id.mLlNoData);
        if (autoLinearLayout2 == null) {
            return;
        }
        autoLinearLayout2.setVisibility(8);
    }

    @Override // k5.a
    public void T2() {
    }

    @Override // b6.f
    public void X2() {
        this.f4868i.clear();
    }

    public View Y2(int i10) {
        View findViewById;
        Map map = this.f4868i;
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

    public final g5.k0 f3() {
        return (g5.k0) this.f4867h.getValue();
    }

    public final void g3() {
        this.f4865f = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(com.mobile.brasiltv.utils.s0.a(getActivity(), 1.0f), 0, true);
        this.f4866g = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewEpg;
        RecyclerView recyclerView = (RecyclerView) Y2(i10);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f4866g);
        }
        RecyclerView recyclerView2 = (RecyclerView) Y2(i10);
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(linerItemDecoration);
        }
        RecyclerView recyclerView3 = (RecyclerView) Y2(i10);
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(f3());
    }

    @xa.j
    public final void liveTabEpgNotificationEvent(LiveTabEpgNotificationEvent liveTabEpgNotificationEvent) {
        t9.i.g(liveTabEpgNotificationEvent, "event");
        showLoading(true);
        RecyclerView recyclerView = (RecyclerView) Y2(R$id.mRecyclerViewEpg);
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) Y2(R$id.mLlNoData);
        if (autoLinearLayout == null) {
            return;
        }
        autoLinearLayout.setVisibility(8);
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
        return layoutInflater.inflate(R.layout.frag_live_epg, viewGroup, false);
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    @Override // b6.f, u8.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        X2();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        showLoading(false);
    }

    @Override // k5.a, u8.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        g3();
    }

    public final void showLoading(boolean z10) {
        if (!z10) {
            LoadingDialog.Companion.hidden();
            return;
        }
        LoadingDialog.Companion companion = LoadingDialog.Companion;
        androidx.fragment.app.e activity = getActivity();
        companion.show(activity != null ? activity.getFragmentManager() : null);
    }
}
