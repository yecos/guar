package b6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.Msg;

/* loaded from: classes3.dex */
public final class m3 extends e<l6.k2> implements i6.z0, SwipeRefreshLayout.j, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: i, reason: collision with root package name */
    public l6.k2 f4804i;

    /* renamed from: l, reason: collision with root package name */
    public g5.r3 f4807l;

    /* renamed from: m, reason: collision with root package name */
    public f5.t0 f4808m;

    /* renamed from: n, reason: collision with root package name */
    public Map f4809n = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final int f4805j = 10;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4806k = true;

    public static final void k3(m3 m3Var, View view) {
        t9.i.g(m3Var, "this$0");
        m3Var.q3();
    }

    public static final void l3(m3 m3Var, View view) {
        t9.i.g(m3Var, "this$0");
        m3Var.q3();
    }

    public static final void o3(m3 m3Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(m3Var, "this$0");
        g5.r3 r3Var = m3Var.f4807l;
        Msg msg = r3Var != null ? (Msg) r3Var.getItem(i10) : null;
        String type = msg != null ? msg.getType() : null;
        w5.m mVar = w5.m.f19178a;
        if (t9.i.b(type, mVar.E())) {
            MyBenefitsAty.a aVar = MyBenefitsAty.f8389r;
            Context context = m3Var.getContext();
            t9.i.d(context);
            MyBenefitsAty.a.b(aVar, context, 0, false, 6, null);
            return;
        }
        if (t9.i.b(type, mVar.I()) ? true : t9.i.b(type, mVar.H())) {
            com.mobile.brasiltv.utils.b0.a0(m3Var, OrderAty.class);
            return;
        }
        if (t9.i.b(type, mVar.F()) ? true : t9.i.b(type, mVar.G())) {
            com.mobile.brasiltv.utils.b0.D(m3Var);
        }
    }

    @Override // i6.z0
    public void A(ArrayList arrayList, boolean z10) {
        t9.i.g(arrayList, "datas");
        com.mobile.brasiltv.utils.b0.U(this, "find data result:" + arrayList.size() + " freshData: " + z10);
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(0);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(8);
        if (z10) {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
            g5.r3 r3Var = this.f4807l;
            if (r3Var != null) {
                r3Var.setEnableLoadMore(true);
            }
            g5.r3 r3Var2 = this.f4807l;
            if (r3Var2 != null) {
                r3Var2.setNewData(arrayList);
            }
        } else {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
            if (arrayList.size() == this.f4805j) {
                g5.r3 r3Var3 = this.f4807l;
                if (r3Var3 != null) {
                    r3Var3.loadMoreComplete();
                }
            } else {
                g5.r3 r3Var4 = this.f4807l;
                if (r3Var4 != null) {
                    r3Var4.loadMoreEnd();
                }
            }
            g5.r3 r3Var5 = this.f4807l;
            if (r3Var5 != null) {
                r3Var5.addData((Collection) arrayList);
            }
        }
        f5.t0 t0Var = this.f4808m;
        if (t0Var != null) {
            t0Var.c1(0);
        }
    }

    @Override // i6.z0
    public void D() {
        com.mobile.brasiltv.utils.b0.U(this, "empty data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null) {
            r3Var.setEnableLoadMore(true);
        }
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(8);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(0);
        f5.t0 t0Var = this.f4808m;
        if (t0Var != null) {
            t0Var.T(0);
        }
    }

    @Override // i6.z0
    public void E() {
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null) {
            r3Var.loadMoreComplete();
        }
    }

    @Override // k5.a
    public void T2() {
        List data;
        com.mobile.brasiltv.utils.b0.U(this, "system msg frag");
        if (this.f4806k) {
            this.f4806k = false;
            a3().p();
            q3();
            return;
        }
        com.mobile.brasiltv.utils.b0.U(this, "system msg frag: " + this.f4806k);
        g5.r3 r3Var = this.f4807l;
        if (((r3Var == null || (data = r3Var.getData()) == null) ? 0 : data.size()) > 0) {
            f5.t0 t0Var = this.f4808m;
            if (t0Var != null) {
                t0Var.c1(0);
                return;
            }
            return;
        }
        f5.t0 t0Var2 = this.f4808m;
        if (t0Var2 != null) {
            t0Var2.T(0);
        }
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4809n.clear();
    }

    @Override // b6.e
    public void Y2() {
        ((ImageView) i3(R$id.mIvMsgEmpty)).setOnClickListener(new View.OnClickListener() { // from class: b6.j3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m3.k3(m3.this, view);
            }
        });
        ((TextView) i3(R$id.mTvMsgEmpty)).setOnClickListener(new View.OnClickListener() { // from class: b6.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m3.l3(m3.this, view);
            }
        });
        p3();
        n3();
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_system_msg;
    }

    public View i3(int i10) {
        View findViewById;
        Map map = this.f4809n;
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

    public final void j3() {
        List data;
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null && (data = r3Var.getData()) != null) {
            data.clear();
        }
        g5.r3 r3Var2 = this.f4807l;
        if (r3Var2 != null) {
            r3Var2.notifyDataSetChanged();
        }
        D();
    }

    @Override // b6.e
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public l6.k2 a3() {
        l6.k2 k2Var = this.f4804i;
        if (k2Var != null) {
            return k2Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void n3() {
        this.f4807l = new g5.r3();
        int i10 = R$id.mRvContent;
        ((RecyclerView) i3(i10)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) i3(i10)).setAdapter(this.f4807l);
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null) {
            r3Var.setOnLoadMoreListener(this, (RecyclerView) i3(i10));
        }
        g5.r3 r3Var2 = this.f4807l;
        if (r3Var2 != null) {
            r3Var2.setLoadMoreView(new RecyclerLoadMoreView());
        }
        g5.r3 r3Var3 = this.f4807l;
        if (r3Var3 != null) {
            r3Var3.disableLoadMoreIfNotFullPage();
        }
        g5.r3 r3Var4 = this.f4807l;
        if (r3Var4 == null) {
            return;
        }
        r3Var4.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: b6.l3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                m3.o3(m3.this, baseQuickAdapter, view, i11);
            }
        });
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r3(new l6.k2(this, this));
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        List data;
        com.mobile.brasiltv.utils.b0.U(this, "load more requested");
        g5.r3 r3Var = this.f4807l;
        int size = (r3Var == null || (data = r3Var.getData()) == null) ? 0 : data.size();
        if (size != 0 && size % this.f4805j == 0) {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(false);
            a3().o();
        } else {
            g5.r3 r3Var2 = this.f4807l;
            if (r3Var2 != null) {
                r3Var2.loadMoreEnd();
            }
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        com.mobile.brasiltv.utils.b0.U(this, "refresh requested");
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null) {
            r3Var.setEnableLoadMore(false);
        }
        a3().l();
    }

    public final void p3() {
        int i10 = R$id.mSrlRefresh;
        ((SwipeRefreshLayout) i3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) i3(i10)).setOnRefreshListener(this);
    }

    public final void q3() {
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(true);
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null) {
            r3Var.setEnableLoadMore(false);
        }
        a3().l();
    }

    public void r3(l6.k2 k2Var) {
        t9.i.g(k2Var, "<set-?>");
        this.f4804i = k2Var;
    }

    public final void s3(f5.t0 t0Var) {
        this.f4808m = t0Var;
    }

    @Override // i6.z0
    public void w() {
        com.mobile.brasiltv.utils.b0.U(this, "no more data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        g5.r3 r3Var = this.f4807l;
        if (r3Var != null) {
            r3Var.loadMoreEnd();
        }
    }
}
