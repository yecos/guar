package com.mobile.brasiltv.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.t;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ColumnListAty;
import com.mobile.brasiltv.activity.TopTenActivity;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import g5.n2;
import h9.h;
import i6.a1;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.o4;
import mobile.com.requestframe.utils.response.ShelveAsset;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class TopTenActivity extends f5.d implements a1, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: v, reason: collision with root package name */
    public static final a f8214v = new a(null);

    /* renamed from: w, reason: collision with root package name */
    public static final String f8215w = "recommend_name";

    /* renamed from: x, reason: collision with root package name */
    public static final String f8216x = "recommend_alias";

    /* renamed from: y, reason: collision with root package name */
    public static final String f8217y = "recommend_columnId";

    /* renamed from: n, reason: collision with root package name */
    public int f8220n;

    /* renamed from: s, reason: collision with root package name */
    public o4 f8225s;

    /* renamed from: u, reason: collision with root package name */
    public Map f8227u = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public int f8218l = 21;

    /* renamed from: m, reason: collision with root package name */
    public int f8219m = 1;

    /* renamed from: o, reason: collision with root package name */
    public final h9.g f8221o = h.b(new g());

    /* renamed from: p, reason: collision with root package name */
    public final h9.g f8222p = h.b(new e());

    /* renamed from: q, reason: collision with root package name */
    public final h9.g f8223q = h.b(new f());

    /* renamed from: r, reason: collision with root package name */
    public final h9.g f8224r = h.b(new c());

    /* renamed from: t, reason: collision with root package name */
    public final h9.g f8226t = h.b(new b());

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return TopTenActivity.f8216x;
        }

        public final String b() {
            return TopTenActivity.f8217y;
        }

        public final String c() {
            return TopTenActivity.f8215w;
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(TopTenActivity.this));
        }
    }

    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n2 invoke() {
            return new n2(TopTenActivity.this);
        }
    }

    public static final class d implements KoocanEmptyView.ReloadListener {
        public d() {
        }

        @Override // com.mobile.brasiltv.view.KoocanEmptyView.ReloadListener
        public void onClick() {
            TopTenActivity.this.S2().l(TopTenActivity.this.j3(), TopTenActivity.this.f8218l, TopTenActivity.this.f8219m);
        }
    }

    public static final class e extends j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            String stringExtra = TopTenActivity.this.getIntent().getStringExtra(TopTenActivity.f8214v.a());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final class f extends j implements s9.a {
        public f() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(TopTenActivity.this.getIntent().getIntExtra(TopTenActivity.f8214v.b(), 0));
        }
    }

    public static final class g extends j implements s9.a {
        public g() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            String stringExtra = TopTenActivity.this.getIntent().getStringExtra(TopTenActivity.f8214v.c());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final void m3(TopTenActivity topTenActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(topTenActivity, "this$0");
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(((ShelveAsset) topTenActivity.g3().getData().get(i10)).getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        String type = ((ShelveAsset) topTenActivity.g3().getData().get(i10)).getType();
        String programType = ((ShelveAsset) topTenActivity.g3().getData().get(i10)).getProgramType();
        String contentId = ((ShelveAsset) topTenActivity.g3().getData().get(i10)).getContentId();
        EnterType enterType = EnterType.CATEGORY;
        String c10 = b0.c(t.W(((ShelveAsset) topTenActivity.g3().getData().get(i10)).getAlias()).toString(), t.W(((ShelveAsset) topTenActivity.g3().getData().get(i10)).getName()).toString());
        ColumnListAty.a aVar = ColumnListAty.f7853t;
        b0.r(topTenActivity, type, programType, contentId, enterType, c10, aVar.e(), aVar.b(), topTenActivity.j3(), topTenActivity.i3(), str);
    }

    public static final void p3(TopTenActivity topTenActivity, View view) {
        i.g(topTenActivity, "this$0");
        topTenActivity.finish();
    }

    public static final void q3(TopTenActivity topTenActivity, View view) {
        i.g(topTenActivity, "this$0");
        int i10 = R$id.mRvContent;
        if (((RecyclerView) topTenActivity.Y2(i10)).getAdapter() != null) {
            RecyclerView.g adapter = ((RecyclerView) topTenActivity.Y2(i10)).getAdapter();
            i.d(adapter);
            if (adapter.getItemCount() == 0) {
                return;
            }
            ((RecyclerView) topTenActivity.Y2(i10)).smoothScrollToPosition(0);
        }
    }

    public static final void r3(TopTenActivity topTenActivity, View view) {
        i.g(topTenActivity, "this$0");
        b0.c0(topTenActivity, SearchAty.class);
    }

    @Override // f5.d
    public void R2() {
        s3(new o4(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Y2(R$id.mRlTop)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, f3(), 0, 0);
        ((TextView) Y2(R$id.mTvTitle)).setText(b0.e(i3(), k3()));
        l3();
        o3();
        n3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_single_column;
    }

    public View Y2(int i10) {
        Map map = this.f8227u;
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

    @Override // i6.a1
    public void a() {
        ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(0);
    }

    @Override // i6.a1
    public void b() {
        g3().loadMoreEnd();
        if (g3().getData().size() == 0) {
            int i10 = R$id.column_loadingView;
            ((KoocanEmptyView) Y2(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) Y2(i10)).setVisibility(0);
        }
    }

    public final int f3() {
        return ((Number) this.f8226t.getValue()).intValue();
    }

    @Override // i6.a1
    public void g(List list, int i10) {
        i.g(list, "data");
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(R$id.column_loadingView)).setVisibility(8);
            g3().addData((Collection) list);
            g3().setEnableLoadMore(true);
        } else if (i10 == 2) {
            if (list.size() < this.f8218l) {
                g3().loadMoreEnd();
            } else {
                g3().loadMoreComplete();
            }
            g3().addData((Collection) list);
        }
        if (g3().getData().size() == 0) {
            g3().setEmptyView(new KoocanEmptyView(Q1(), KoocanEmptyView.Type.NO_CONTENT));
        }
        this.f8220n = list.size();
        g3().notifyDataSetChanged();
    }

    public final n2 g3() {
        return (n2) this.f8224r.getValue();
    }

    @Override // f5.d
    /* renamed from: h3, reason: merged with bridge method [inline-methods] */
    public o4 S2() {
        o4 o4Var = this.f8225s;
        if (o4Var != null) {
            return o4Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final String i3() {
        return (String) this.f8222p.getValue();
    }

    public final int j3() {
        return ((Number) this.f8223q.getValue()).intValue();
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final String k3() {
        return (String) this.f8221o.getValue();
    }

    public final void l3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        int i10 = R$id.mRvContent;
        ((RecyclerView) Y2(i10)).setLayoutManager(gridLayoutManager);
        g3().setOnLoadMoreListener(this, (RecyclerView) Y2(i10));
        g3().setLoadMoreView(new RecyclerLoadMoreView());
        g3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) Y2(i10)).setAdapter(g3());
        g3().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: f5.y5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                TopTenActivity.m3(TopTenActivity.this, baseQuickAdapter, view, i11);
            }
        });
    }

    public final void n3() {
        S2().l(j3(), this.f8218l, this.f8219m);
    }

    public final void o3() {
        ((ImageView) Y2(R$id.mIvBack)).setOnClickListener(new View.OnClickListener() { // from class: f5.z5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopTenActivity.p3(TopTenActivity.this, view);
            }
        });
        ((AutoRelativeLayout) Y2(R$id.mRlTop)).setOnClickListener(new View.OnClickListener() { // from class: f5.a6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopTenActivity.q3(TopTenActivity.this, view);
            }
        });
        ((ImageView) Y2(R$id.mIvSearch)).setOnClickListener(new View.OnClickListener() { // from class: f5.b6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopTenActivity.r3(TopTenActivity.this, view);
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.f8219m++;
        int size = g3().getData().size();
        int i10 = this.f8218l;
        if (size < i10) {
            g3().loadMoreEnd(false);
        } else if (this.f8220n < i10) {
            g3().loadMoreEnd(false);
        } else {
            S2().k(j3(), this.f8218l, this.f8219m);
        }
    }

    @Override // i6.a1
    public void p(String str, int i10) {
        i.g(str, "errorCode");
        int i11 = R$id.column_loadingView;
        ((KoocanEmptyView) Y2(i11)).setVisibility(8);
        j1.h(this, str);
        if (i10 == 0) {
            ((KoocanEmptyView) Y2(i11)).setReloadListener(new d());
            ((KoocanEmptyView) Y2(i11)).setVisibility(0);
            ((KoocanEmptyView) Y2(i11)).changeType(KoocanEmptyView.Type.NO_WIFI);
        } else {
            if (i10 != 2) {
                return;
            }
            this.f8219m--;
            g3().loadMoreFail();
        }
    }

    public void s3(o4 o4Var) {
        i.g(o4Var, "<set-?>");
        this.f8225s = o4Var;
    }
}
