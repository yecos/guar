package b6;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.Msg;
import mobile.com.requestframe.utils.response.pushMsg;

/* loaded from: classes3.dex */
public final class d extends e<l6.a> implements i6.h, SwipeRefreshLayout.j, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: i, reason: collision with root package name */
    public l6.a f4674i;

    /* renamed from: l, reason: collision with root package name */
    public g5.a f4677l;

    /* renamed from: m, reason: collision with root package name */
    public f5.t0 f4678m;

    /* renamed from: n, reason: collision with root package name */
    public Map f4679n = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final int f4675j = 10;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4676k = true;

    public static final void k3(d dVar, View view) {
        t9.i.g(dVar, "this$0");
        dVar.q3();
    }

    public static final void l3(d dVar, View view) {
        t9.i.g(dVar, "this$0");
        dVar.q3();
    }

    public static final void o3(d dVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        pushMsg content;
        pushMsg content2;
        t9.i.g(dVar, "this$0");
        g5.a aVar = dVar.f4677l;
        String str = null;
        Msg msg = aVar != null ? (Msg) aVar.getItem(i10) : null;
        String url = (msg == null || (content2 = msg.getContent()) == null) ? null : content2.getUrl();
        if (!(url == null || url.length() == 0)) {
            if (msg != null && (content = msg.getContent()) != null) {
                str = content.getUrl();
            }
            String str2 = str;
            t9.i.d(str2);
            com.mobile.brasiltv.utils.b0.k0(dVar, str2, false, true, false, 8, null);
        } else if (t9.i.b(w6.i.f19214g.I(), "1")) {
            f1.a.j(com.mobile.brasiltv.utils.f1.f8649a, dVar.getContext(), R.string.vod_please_bind, 0, 4, null);
        } else {
            com.mobile.brasiltv.utils.b0.B(dVar);
        }
        dVar.a3().p(i10, msg);
    }

    @Override // i6.h
    public void A(ArrayList arrayList, boolean z10) {
        t9.i.g(arrayList, "datas");
        com.mobile.brasiltv.utils.b0.U(this, "find data result:" + arrayList.size() + " freshData: " + z10);
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(0);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(8);
        if (z10) {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
            g5.a aVar = this.f4677l;
            if (aVar != null) {
                aVar.setEnableLoadMore(true);
            }
            g5.a aVar2 = this.f4677l;
            if (aVar2 != null) {
                aVar2.setNewData(arrayList);
            }
        } else {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
            if (arrayList.size() == this.f4675j) {
                g5.a aVar3 = this.f4677l;
                if (aVar3 != null) {
                    aVar3.loadMoreComplete();
                }
            } else {
                g5.a aVar4 = this.f4677l;
                if (aVar4 != null) {
                    aVar4.loadMoreEnd();
                }
            }
            g5.a aVar5 = this.f4677l;
            if (aVar5 != null) {
                aVar5.addData((Collection) arrayList);
            }
        }
        f5.t0 t0Var = this.f4678m;
        if (t0Var != null) {
            t0Var.c1(1);
        }
    }

    @Override // i6.h
    public void D() {
        com.mobile.brasiltv.utils.b0.U(this, "empty data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.setEnableLoadMore(true);
        }
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(8);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(0);
        f5.t0 t0Var = this.f4678m;
        if (t0Var != null) {
            t0Var.T(1);
        }
    }

    @Override // i6.h
    public void E() {
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.loadMoreComplete();
        }
    }

    @Override // k5.a
    public void T2() {
        List data;
        com.mobile.brasiltv.utils.b0.L(this, "activity msg frag");
        int i10 = 0;
        if (this.f4676k) {
            this.f4676k = false;
            q3();
            return;
        }
        g5.a aVar = this.f4677l;
        if (aVar != null && (data = aVar.getData()) != null) {
            i10 = data.size();
        }
        if (i10 > 0) {
            f5.t0 t0Var = this.f4678m;
            if (t0Var != null) {
                t0Var.c1(1);
                return;
            }
            return;
        }
        f5.t0 t0Var2 = this.f4678m;
        if (t0Var2 != null) {
            t0Var2.T(1);
        }
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4679n.clear();
    }

    @Override // b6.e
    public void Y2() {
        ((ImageView) i3(R$id.mIvMsgEmpty)).setOnClickListener(new View.OnClickListener() { // from class: b6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.k3(d.this, view);
            }
        });
        ((TextView) i3(R$id.mTvMsgEmpty)).setOnClickListener(new View.OnClickListener() { // from class: b6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.l3(d.this, view);
            }
        });
        p3();
        n3();
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_activity_msg;
    }

    public View i3(int i10) {
        View findViewById;
        Map map = this.f4679n;
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
        g5.a aVar = this.f4677l;
        if (aVar != null && (data = aVar.getData()) != null) {
            data.clear();
        }
        g5.a aVar2 = this.f4677l;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
        D();
    }

    @Override // b6.e
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public l6.a a3() {
        l6.a aVar = this.f4674i;
        if (aVar != null) {
            return aVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @Override // i6.h
    public void n0(int i10) {
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.notifyItemChanged(i10);
        }
    }

    public final void n3() {
        this.f4677l = new g5.a();
        int i10 = R$id.mRvContent;
        ((RecyclerView) i3(i10)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) i3(i10)).setAdapter(this.f4677l);
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.setOnLoadMoreListener(this, (RecyclerView) i3(i10));
        }
        g5.a aVar2 = this.f4677l;
        if (aVar2 != null) {
            aVar2.setLoadMoreView(new RecyclerLoadMoreView());
        }
        g5.a aVar3 = this.f4677l;
        if (aVar3 != null) {
            aVar3.disableLoadMoreIfNotFullPage();
        }
        g5.a aVar4 = this.f4677l;
        if (aVar4 == null) {
            return;
        }
        aVar4.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: b6.c
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                d.o3(d.this, baseQuickAdapter, view, i11);
            }
        });
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r3(new l6.a(this, this));
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
        g5.a aVar = this.f4677l;
        int size = (aVar == null || (data = aVar.getData()) == null) ? 0 : data.size();
        if (size != 0 && size % this.f4675j == 0) {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(false);
            a3().o();
        } else {
            g5.a aVar2 = this.f4677l;
            if (aVar2 != null) {
                aVar2.loadMoreEnd();
            }
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        com.mobile.brasiltv.utils.b0.U(this, "refresh requested");
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.setEnableLoadMore(false);
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
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.setEnableLoadMore(false);
        }
        a3().l();
    }

    public void r3(l6.a aVar) {
        t9.i.g(aVar, "<set-?>");
        this.f4674i = aVar;
    }

    public final void s3(f5.t0 t0Var) {
        this.f4678m = t0Var;
    }

    @Override // i6.h
    public void w() {
        com.mobile.brasiltv.utils.b0.U(this, "no more data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        g5.a aVar = this.f4677l;
        if (aVar != null) {
            aVar.loadMoreEnd();
        }
    }
}
