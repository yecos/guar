package b6;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.db.LiveSubProgram;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.mobile.brasiltv.view.LoadingDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import g5.q0;
import g5.s0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c2 extends e<l6.z0> implements j6.h, s0.a {

    /* renamed from: i, reason: collision with root package name */
    public l6.z0 f4665i;

    /* renamed from: m, reason: collision with root package name */
    public Map f4669m = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f4666j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final h9.g f4667k = h9.h.b(new c());

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f4668l = h9.h.b(new b());

    public static final class a implements q0.b {
        public a() {
        }

        @Override // g5.q0.b
        public void a(String str, int i10) {
            t9.i.g(str, "str");
            c2.this.h3(i10);
        }
    }

    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.s0 invoke() {
            androidx.fragment.app.e activity = c2.this.getActivity();
            t9.i.d(activity);
            return new g5.s0(activity, c2.this);
        }
    }

    public static final class c extends t9.j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.q0 invoke() {
            androidx.fragment.app.e activity = c2.this.getActivity();
            t9.i.d(activity);
            return new g5.q0(activity, c2.this.f4666j);
        }
    }

    @Override // j6.h
    public void B2(int i10) {
        i3().getData().remove(i10);
        i3().notifyDataSetChanged();
    }

    @Override // j6.h
    public void J0(boolean z10) {
        ((AutoLinearLayout) f3(R$id.mLlNoData)).setVisibility(z10 ? 0 : 8);
    }

    @Override // g5.s0.a
    public void T(int i10) {
        l6.z0 a32 = a3();
        Object obj = i3().getData().get(i10);
        t9.i.f(obj, "mLiveSubAdapter.data[pos]");
        a32.B((LiveSubProgram) obj, i10);
    }

    @Override // k5.a
    public void T2() {
        com.mobile.brasiltv.utils.b0.U(this, "lazyLoad:");
        a3().q();
        a3().w();
        a3().x(j3().b());
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4669m.clear();
    }

    @Override // b6.e
    public void Y2() {
        m3();
        l3();
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_live_epg;
    }

    public View f3(int i10) {
        View findViewById;
        Map map = this.f4669m;
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

    public final void h3(int i10) {
        j3().f(i10);
        i3().getData().clear();
        i3().notifyDataSetChanged();
        a3().x(j3().b());
    }

    @Override // j6.h
    public void i1(List list) {
        t9.i.g(list, "datas");
        i3().getData().clear();
        i3().getData().addAll(list);
        i3().notifyDataSetChanged();
    }

    public final g5.s0 i3() {
        return (g5.s0) this.f4668l.getValue();
    }

    public final g5.q0 j3() {
        return (g5.q0) this.f4667k.getValue();
    }

    @Override // b6.e
    /* renamed from: k3, reason: merged with bridge method [inline-methods] */
    public l6.z0 a3() {
        l6.z0 z0Var = this.f4665i;
        if (z0Var != null) {
            return z0Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void l3() {
        j3().g(new a());
    }

    public final void m3() {
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewSort;
        ((RecyclerView) f3(i10)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) f3(i10)).setAdapter(j3());
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(com.mobile.brasiltv.utils.s0.a(getActivity(), 1.0f), 0, true);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper2 = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i11 = R$id.mRecyclerViewEpg;
        ((RecyclerView) f3(i11)).setLayoutManager(linearLayoutManagerWrapper2);
        ((RecyclerView) f3(i11)).addItemDecoration(linerItemDecoration);
        ((RecyclerView) f3(i11)).setAdapter(i3());
    }

    public void n3(l6.z0 z0Var) {
        t9.i.g(z0Var, "<set-?>");
        this.f4665i = z0Var;
    }

    @Override // j6.h
    public void o0(ArrayList arrayList) {
        t9.i.g(arrayList, "datas");
        this.f4666j.clear();
        this.f4666j.addAll(arrayList);
        j3().notifyDataSetChanged();
        j3().f(0);
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n3(new l6.z0(this, this));
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // j6.h
    public void showLoading(boolean z10) {
        if (!z10) {
            LoadingDialog.Companion.hidden();
            return;
        }
        LoadingDialog.Companion companion = LoadingDialog.Companion;
        androidx.fragment.app.e activity = getActivity();
        companion.show(activity != null ? activity.getFragmentManager() : null);
    }
}
