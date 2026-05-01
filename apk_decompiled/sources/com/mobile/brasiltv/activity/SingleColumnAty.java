package com.mobile.brasiltv.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SingleColumnAty;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import g5.w;
import h9.g;
import h9.h;
import i6.w0;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.b4;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.ShelveAsset;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class SingleColumnAty extends f5.d implements w0, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: t, reason: collision with root package name */
    public static final a f8160t = new a(null);

    /* renamed from: u, reason: collision with root package name */
    public static final String f8161u = "home_recommend";

    /* renamed from: n, reason: collision with root package name */
    public int f8164n;

    /* renamed from: q, reason: collision with root package name */
    public b4 f8167q;

    /* renamed from: s, reason: collision with root package name */
    public Map f8169s = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public int f8162l = 21;

    /* renamed from: m, reason: collision with root package name */
    public int f8163m = 1;

    /* renamed from: o, reason: collision with root package name */
    public final g f8165o = h.b(new c());

    /* renamed from: p, reason: collision with root package name */
    public final g f8166p = h.b(new d());

    /* renamed from: r, reason: collision with root package name */
    public final g f8168r = h.b(new b());

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return SingleColumnAty.f8161u;
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(SingleColumnAty.this));
        }
    }

    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomeRecommend invoke() {
            Serializable serializableExtra = SingleColumnAty.this.getIntent().getSerializableExtra(SingleColumnAty.f8160t.a());
            i.e(serializableExtra, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.HomeRecommend");
            return (HomeRecommend) serializableExtra;
        }
    }

    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final w invoke() {
            return new w(SingleColumnAty.this);
        }
    }

    public static final class e implements KoocanEmptyView.ReloadListener {
        public e() {
        }

        @Override // com.mobile.brasiltv.view.KoocanEmptyView.ReloadListener
        public void onClick() {
            Integer columnId = SingleColumnAty.this.e3().getColumnId();
            if (columnId != null) {
                SingleColumnAty singleColumnAty = SingleColumnAty.this;
                singleColumnAty.S2().m(columnId.intValue(), singleColumnAty.f8162l, singleColumnAty.f8163m);
            }
        }
    }

    public static final void i3(SingleColumnAty singleColumnAty, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(singleColumnAty, "this$0");
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        Integer columnId = singleColumnAty.e3().getColumnId();
        if (columnId != null) {
            int intValue = columnId.intValue();
            String alias = singleColumnAty.e3().getAlias();
            if (alias != null) {
                b0.r(singleColumnAty, ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getType(), ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getProgramType(), ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getContentId(), EnterType.CATEGORY, ((ShelveAsset) singleColumnAty.f3().getData().get(i10)).getName(), false, ColumnListAty.f7853t.b(), intValue, alias, str);
            }
        }
    }

    public static final void l3(SingleColumnAty singleColumnAty, View view) {
        i.g(singleColumnAty, "this$0");
        singleColumnAty.finish();
    }

    public static final void m3(SingleColumnAty singleColumnAty, View view) {
        i.g(singleColumnAty, "this$0");
        int i10 = R$id.mRvContent;
        if (((RecyclerView) singleColumnAty.Y2(i10)).getAdapter() != null) {
            RecyclerView.g adapter = ((RecyclerView) singleColumnAty.Y2(i10)).getAdapter();
            i.d(adapter);
            if (adapter.getItemCount() == 0) {
                return;
            }
            ((RecyclerView) singleColumnAty.Y2(i10)).smoothScrollToPosition(0);
        }
    }

    public static final void n3(SingleColumnAty singleColumnAty, View view) {
        i.g(singleColumnAty, "this$0");
        b0.c0(singleColumnAty, SearchAty.class);
    }

    @Override // f5.d
    public void R2() {
        o3(new b4(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Y2(R$id.mRlTop)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, d3(), 0, 0);
        ((TextView) Y2(R$id.mTvTitle)).setText(b0.e(e3().getAlias(), e3().getName()));
        h3();
        k3();
        j3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_single_column;
    }

    public View Y2(int i10) {
        Map map = this.f8169s;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // i6.w0
    public void a() {
        ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(0);
    }

    @Override // i6.w0
    public void b() {
        f3().loadMoreEnd();
        if (f3().getData().size() == 0) {
            int i10 = R$id.column_loadingView;
            ((KoocanEmptyView) Y2(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) Y2(i10)).setVisibility(0);
        }
    }

    public final int d3() {
        return ((Number) this.f8168r.getValue()).intValue();
    }

    public final HomeRecommend e3() {
        return (HomeRecommend) this.f8165o.getValue();
    }

    public final w f3() {
        return (w) this.f8166p.getValue();
    }

    @Override // i6.w0
    public void g(List list, int i10) {
        i.g(list, "data");
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(8);
            f3().addData((Collection) list);
            f3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            if (list.size() < this.f8162l) {
                f3().loadMoreEnd();
            } else {
                f3().loadMoreComplete();
            }
            f3().addData((Collection) list);
        }
        if (f3().getData().size() == 0) {
            f3().setEmptyView(new KoocanEmptyView(Q1(), KoocanEmptyView.Type.NO_CONTENT));
        }
        this.f8164n = list.size();
        f3().notifyDataSetChanged();
    }

    @Override // f5.d
    /* renamed from: g3, reason: merged with bridge method [inline-methods] */
    public b4 S2() {
        b4 b4Var = this.f8167q;
        if (b4Var != null) {
            return b4Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void h3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        int i10 = R$id.mRvContent;
        ((RecyclerView) Y2(i10)).setLayoutManager(gridLayoutManager);
        f3().setOnLoadMoreListener(this, (RecyclerView) Y2(i10));
        f3().setLoadMoreView(new RecyclerLoadMoreView());
        f3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) Y2(i10)).setAdapter(f3());
        f3().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: f5.t4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SingleColumnAty.i3(SingleColumnAty.this, baseQuickAdapter, view, i11);
            }
        });
    }

    public final void j3() {
        Integer columnId = e3().getColumnId();
        if (columnId != null) {
            S2().m(columnId.intValue(), this.f8162l, this.f8163m);
        }
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k3() {
        ((ImageView) Y2(R$id.mIvBack)).setOnClickListener(new View.OnClickListener() { // from class: f5.u4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleColumnAty.l3(SingleColumnAty.this, view);
            }
        });
        ((AutoRelativeLayout) Y2(R$id.mRlTop)).setOnClickListener(new View.OnClickListener() { // from class: f5.v4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleColumnAty.m3(SingleColumnAty.this, view);
            }
        });
        ((ImageView) Y2(R$id.mIvSearch)).setOnClickListener(new View.OnClickListener() { // from class: f5.w4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleColumnAty.n3(SingleColumnAty.this, view);
            }
        });
    }

    public void o3(b4 b4Var) {
        i.g(b4Var, "<set-?>");
        this.f8167q = b4Var;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.f8163m++;
        int size = f3().getData().size();
        int i10 = this.f8162l;
        if (size < i10) {
            f3().loadMoreEnd(false);
            return;
        }
        if (this.f8164n < i10) {
            f3().loadMoreEnd(false);
            return;
        }
        Integer columnId = e3().getColumnId();
        if (columnId != null) {
            S2().l(columnId.intValue(), this.f8162l, this.f8163m);
        }
    }

    @Override // i6.w0
    public void p(String str, int i10) {
        i.g(str, "errorCode");
        int i11 = R$id.column_loadingView;
        ((KoocanEmptyView) Y2(i11)).setVisibility(8);
        j1.h(this, str);
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(i11)).setReloadListener(new e());
            ((KoocanEmptyView) Y2(i11)).setVisibility(0);
            ((KoocanEmptyView) Y2(i11)).changeType(KoocanEmptyView.Type.NO_WIFI);
        } else {
            if (i10 != 2) {
                return;
            }
            this.f8163m--;
            f3().loadMoreFail();
        }
    }
}
