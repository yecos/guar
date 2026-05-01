package com.mobile.brasiltv.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.player.view.ProgramRecommendInfoView;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.GridLayoutManagerWrapper;
import com.mobile.brasiltv.view.PaddingItemDecoration;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import f5.c;
import g5.w;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ShelveAsset;
import na.e;
import t9.i;

/* loaded from: classes3.dex */
public final class ProgramRecommendInfoView extends AutoLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final int f8565a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8566b;

    /* renamed from: c, reason: collision with root package name */
    public int f8567c;

    /* renamed from: d, reason: collision with root package name */
    public final g f8568d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f8569e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8570f;

    /* renamed from: g, reason: collision with root package name */
    public Map f8571g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgramRecommendInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.g(context, f.X);
        this.f8571g = new LinkedHashMap();
        this.f8565a = 6;
        this.f8566b = 12;
        this.f8568d = h.b(new r6.f(this));
        this.f8569e = new ArrayList();
        LayoutInflater.from(context).inflate(R.layout.layout_program_recommend_view, (ViewGroup) this, true);
        initView();
    }

    public static final void d(ProgramRecommendInfoView programRecommendInfoView, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(programRecommendInfoView, "this$0");
        ShelveAsset shelveAsset = (ShelveAsset) programRecommendInfoView.getAdapter().getItem(i10);
        if (shelveAsset != null) {
            e.f17341a = true;
            Context context = programRecommendInfoView.getContext();
            i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.s((c) context, shelveAsset, "detail/recommend", programRecommendInfoView.f8570f);
        }
    }

    public static final void e(ProgramRecommendInfoView programRecommendInfoView, View view) {
        i.g(programRecommendInfoView, "this$0");
        programRecommendInfoView.g();
    }

    private final w getAdapter() {
        return (w) this.f8568d.getValue();
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f8571g;
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

    public final void c(List list) {
        i.g(list, "recommendList");
        this.f8569e.clear();
        this.f8569e.addAll(list);
        this.f8567c = 0;
        if (list.size() >= this.f8566b) {
            ((ImageView) _$_findCachedViewById(R$id.mImgRefresh)).setVisibility(0);
        }
        if (list.size() < this.f8565a) {
            getAdapter().setNewData(list);
            return;
        }
        w adapter = getAdapter();
        int i10 = this.f8567c;
        adapter.setNewData(list.subList(i10, this.f8565a + i10));
        this.f8567c += this.f8565a;
    }

    public final void f(boolean z10) {
        this.f8570f = z10;
    }

    public final void g() {
        int size = this.f8569e.size();
        int i10 = (this.f8567c + this.f8565a) - 1;
        if (!(i10 >= 0 && i10 < size)) {
            this.f8567c = 0;
        }
        w adapter = getAdapter();
        ArrayList arrayList = this.f8569e;
        int i11 = this.f8567c;
        adapter.setNewData(arrayList.subList(i11, this.f8565a + i11));
        this.f8567c += this.f8565a;
    }

    public final void initView() {
        setOrientation(1);
        int i10 = R$id.mRecyclerChange;
        ((RecyclerView) _$_findCachedViewById(i10)).setLayoutManager(new GridLayoutManagerWrapper(getContext(), 3));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i10);
        Context context = getContext();
        i.f(context, f.X);
        recyclerView.addItemDecoration(new PaddingItemDecoration(context, 1, false, true));
        ((RecyclerView) _$_findCachedViewById(i10)).setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: r6.d
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ProgramRecommendInfoView.d(ProgramRecommendInfoView.this, baseQuickAdapter, view, i11);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mImgRefresh)).setOnClickListener(new View.OnClickListener() { // from class: r6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgramRecommendInfoView.e(ProgramRecommendInfoView.this, view);
            }
        });
    }
}
