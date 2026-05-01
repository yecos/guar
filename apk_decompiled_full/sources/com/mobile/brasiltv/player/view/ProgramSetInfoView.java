package com.mobile.brasiltv.player.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.PlaySetIndexEvent;
import com.mobile.brasiltv.bean.event.RequestAuthEvent;
import com.mobile.brasiltv.bean.event.SelectedSeason;
import com.mobile.brasiltv.db.Links;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.player.view.ProgramSetInfoView;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.HorizontalDecoration;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g7.l;
import h9.g;
import h9.h;
import i9.j;
import i9.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.ProgramSeason;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import t9.i;
import t9.z;

/* loaded from: classes.dex */
public final class ProgramSetInfoView extends AutoRelativeLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final a f8572j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public AssetData f8573a;

    /* renamed from: b, reason: collision with root package name */
    public int f8574b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8575c;

    /* renamed from: d, reason: collision with root package name */
    public final g f8576d;

    /* renamed from: e, reason: collision with root package name */
    public l f8577e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8578f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8579g;

    /* renamed from: h, reason: collision with root package name */
    public int f8580h;

    /* renamed from: i, reason: collision with root package name */
    public Map f8581i = new LinkedHashMap();

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            i.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i10);
            if (ProgramSetInfoView.this.f8579g) {
                ProgramSetInfoView.this.f8579g = false;
                ProgramSetInfoView programSetInfoView = ProgramSetInfoView.this;
                programSetInfoView.x(programSetInfoView.f8580h);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            i.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i10, i11);
            ProgramSetInfoView programSetInfoView = ProgramSetInfoView.this;
            int i12 = R$id.mSeekBarProgram;
            if (((SeekBar) programSetInfoView._$_findCachedViewById(i12)).getVisibility() == 0) {
                ProgramSetInfoView programSetInfoView2 = ProgramSetInfoView.this;
                int i13 = R$id.mRecyclerSelectInfo;
                ((SeekBar) ProgramSetInfoView.this._$_findCachedViewById(i12)).setProgress((((SeekBar) ProgramSetInfoView.this._$_findCachedViewById(i12)).getMax() * recyclerView.computeHorizontalScrollOffset()) / (((RecyclerView) programSetInfoView2._$_findCachedViewById(i13)).computeHorizontalScrollRange() - ((RecyclerView) ProgramSetInfoView.this._$_findCachedViewById(i13)).getWidth()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        public c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            i.g(seekBar, "seekBar");
            if (z10) {
                ProgramSetInfoView programSetInfoView = ProgramSetInfoView.this;
                int i11 = R$id.mRecyclerSelectInfo;
                ((RecyclerView) ProgramSetInfoView.this._$_findCachedViewById(i11)).scrollBy((((((RecyclerView) programSetInfoView._$_findCachedViewById(i11)).computeHorizontalScrollRange() - ((RecyclerView) ProgramSetInfoView.this._$_findCachedViewById(i11)).getWidth()) * i10) / seekBar.getMax()) - ((RecyclerView) ProgramSetInfoView.this._$_findCachedViewById(i11)).computeHorizontalScrollOffset(), 0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            i.g(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            i.g(seekBar, "seekBar");
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements l.b {
        public d() {
        }

        @Override // g7.l.b
        public void a(int i10, ProgramSeason programSeason) {
            i.g(programSeason, "data");
            xa.c.c().j(new SelectedSeason(programSeason));
            l lVar = ProgramSetInfoView.this.f8577e;
            i.d(lVar);
            lVar.dismiss();
        }
    }

    public ProgramSetInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8576d = h.b(r6.i.f18556a);
        this.f8578f = 100;
        m();
        this.f8580h = -1;
        LayoutInflater.from(context).inflate(R.layout.layout_program_set_info_view, (ViewGroup) this, true);
        j();
    }

    private final int getSelectedSeason() {
        AssetData assetData = this.f8573a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        List<ProgramSeason> sameSeasonSeriesList = assetData.getSameSeasonSeriesList();
        i.d(sameSeasonSeriesList);
        int i10 = 0;
        for (Object obj : sameSeasonSeriesList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                j.j();
            }
            String contentId = ((ProgramSeason) obj).getContentId();
            AssetData assetData2 = this.f8573a;
            if (assetData2 == null) {
                i.w("data");
                assetData2 = null;
            }
            if (i.b(contentId, assetData2.getContentId())) {
                return i10;
            }
            i10 = i11;
        }
        return 0;
    }

    private final n6.a getSetInfoAdapter() {
        return (n6.a) this.f8576d.getValue();
    }

    public static /* synthetic */ void l(ProgramSetInfoView programSetInfoView, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        programSetInfoView.k(i10);
    }

    public static /* synthetic */ void p(ProgramSetInfoView programSetInfoView, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        programSetInfoView.o(i10, z10, z11);
    }

    public static final void t(ProgramSetInfoView programSetInfoView, View view) {
        i.g(programSetInfoView, "this$0");
        if (programSetInfoView.f8577e == null) {
            Context context = programSetInfoView.getContext();
            i.e(context, "null cannot be cast to non-null type android.app.Activity");
            l lVar = new l((Activity) context);
            programSetInfoView.f8577e = lVar;
            i.d(lVar);
            lVar.j(programSetInfoView.new d());
        }
        l lVar2 = programSetInfoView.f8577e;
        if (lVar2 != null) {
            lVar2.c(false);
        }
        l lVar3 = programSetInfoView.f8577e;
        if (lVar3 != null) {
            AssetData assetData = programSetInfoView.f8573a;
            if (assetData == null) {
                i.w("data");
                assetData = null;
            }
            List<ProgramSeason> sameSeasonSeriesList = assetData.getSameSeasonSeriesList();
            i.d(sameSeasonSeriesList);
            List G = r.G(sameSeasonSeriesList);
            i.e(G, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.ProgramSeason>");
            lVar3.k((ArrayList) G, programSetInfoView.getSelectedSeason());
        }
    }

    public static final void v(ProgramSetInfoView programSetInfoView, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(programSetInfoView, "this$0");
        if (programSetInfoView.getSetInfoAdapter().a() != i10) {
            p(programSetInfoView, i10, false, false, 6, null);
        }
        programSetInfoView.f8580h = i10;
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f8581i;
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

    public final void h() {
        l lVar;
        l lVar2 = this.f8577e;
        boolean z10 = false;
        if (lVar2 != null && lVar2.isShowing()) {
            z10 = true;
        }
        if (!z10 || (lVar = this.f8577e) == null) {
            return;
        }
        lVar.dismiss();
    }

    @xa.j
    public final void handleSelectEvent(PlaySetIndexEvent playSetIndexEvent) {
        i.g(playSetIndexEvent, "event");
        if (this.f8575c || playSetIndexEvent.isCast()) {
            b0.U(this, "收到请求开始鉴权");
            AssetData assetData = this.f8573a;
            if (assetData == null) {
                i.w("data");
                assetData = null;
            }
            n(assetData.getSimpleProgramList().get(playSetIndexEvent.getPlaySetIndex()), playSetIndexEvent.getPlaySetIndex(), playSetIndexEvent.isCast(), playSetIndexEvent.isVideoStop());
            if (getSetInfoAdapter().getData().size() > 0) {
                getSetInfoAdapter().c(playSetIndexEvent.getPlaySetIndex());
            }
        }
    }

    public final void i(String str) {
        AssetData assetData = this.f8573a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        if (i.b("movie", assetData.getProgramType())) {
            setVisibility(8);
            return;
        }
        if (i.b(str, "1")) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        w();
        q();
        u();
    }

    public final void j() {
        int i10 = R$id.mRecyclerSelectInfo;
        ((RecyclerView) _$_findCachedViewById(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getContext(), 0, false));
        ((RecyclerView) _$_findCachedViewById(i10)).addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(20)));
        ((RecyclerView) _$_findCachedViewById(i10)).setItemAnimator(null);
        ((RecyclerView) _$_findCachedViewById(i10)).addOnScrollListener(new b());
        ((SeekBar) _$_findCachedViewById(R$id.mSeekBarProgram)).setOnSeekBarChangeListener(new c());
    }

    public final void k(int i10) {
        this.f8574b = i10;
        this.f8580h = i10;
        AssetData assetData = this.f8573a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        assetData.getSimpleProgramList().get(i10).setPlayed(true);
    }

    public final void m() {
        if (xa.c.c().h(this)) {
            return;
        }
        xa.c.c().o(this);
    }

    public final void n(SimpleProgramList simpleProgramList, int i10, boolean z10, boolean z11) {
        xa.c.c().j(new RequestAuthEvent(i10, simpleProgramList, z10, z11));
    }

    public final void o(int i10, boolean z10, boolean z11) {
        xa.c.c().j(new PlaySetIndexEvent(i10, z10, z11));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xa.c.c().r(this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = R$id.mRecyclerSelectInfo;
        if (((RecyclerView) _$_findCachedViewById(i14)).getAdapter() != null) {
            ((RecyclerView) _$_findCachedViewById(i14)).scrollToPosition(this.f8580h);
        }
    }

    public final void q() {
        AssetData assetData = this.f8573a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        List<ProgramSeason> sameSeasonSeriesList = assetData.getSameSeasonSeriesList();
        if ((sameSeasonSeriesList == null || sameSeasonSeriesList.isEmpty()) || sameSeasonSeriesList.size() == 1) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlSeason)).setVisibility(8);
            return;
        }
        int i10 = R$id.mLlSeason;
        ((AutoLinearLayout) _$_findCachedViewById(i10)).setVisibility(0);
        ((AutoLinearLayout) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: r6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgramSetInfoView.t(ProgramSetInfoView.this, view);
            }
        });
        AssetData assetData2 = this.f8573a;
        if (assetData2 == null) {
            i.w("data");
            assetData2 = null;
        }
        List<ProgramSeason> sameSeasonSeriesList2 = assetData2.getSameSeasonSeriesList();
        i.d(sameSeasonSeriesList2);
        int i11 = 0;
        for (Object obj : sameSeasonSeriesList2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                j.j();
            }
            ProgramSeason programSeason = (ProgramSeason) obj;
            String contentId = programSeason.getContentId();
            AssetData assetData3 = this.f8573a;
            if (assetData3 == null) {
                i.w("data");
                assetData3 = null;
            }
            if (i.b(contentId, assetData3.getContentId())) {
                ((TextView) _$_findCachedViewById(R$id.mTvSeasonSelect)).setText(getContext().getString(R.string.vod_season, Integer.valueOf(programSeason.getSeasonNumber())));
            }
            i11 = i12;
        }
    }

    public final void r(VodDao vodDao, AssetData assetData, String str, boolean z10, boolean z11) {
        i.g(vodDao, "vodDao");
        i.g(assetData, "program");
        i.g(str, "vodType");
        this.f8573a = assetData;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        if (assetData.getSimpleProgramList().isEmpty()) {
            setVisibility(8);
            return;
        }
        AssetData assetData2 = this.f8573a;
        if (assetData2 == null) {
            i.w("data");
            assetData2 = null;
        }
        if (i.b("movie", assetData2.getProgramType())) {
            p(this, 0, z10, z11, 1, null);
        } else {
            AssetData assetData3 = this.f8573a;
            if (assetData3 == null) {
                i.w("data");
                assetData3 = null;
            }
            Links queryRecordByContentId$default = VodDao.queryRecordByContentId$default(vodDao, assetData3.getContentId(), 0, 2, null);
            int position = queryRecordByContentId$default != null ? queryRecordByContentId$default.getPosition() : 0;
            if (position >= 0) {
                AssetData assetData4 = this.f8573a;
                if (assetData4 == null) {
                    i.w("data");
                    assetData4 = null;
                }
                if (position < assetData4.getSimpleProgramList().size()) {
                    o(position, z10, z11);
                    k(position);
                }
            }
            p(this, 0, z10, z11, 1, null);
            l(this, 0, 1, null);
        }
        i(str);
    }

    public final void setIsResumed(boolean z10) {
        this.f8575c = z10;
    }

    public final void u() {
        int i10 = R$id.mRecyclerSelectInfo;
        ((RecyclerView) _$_findCachedViewById(i10)).setAdapter(getSetInfoAdapter());
        getSetInfoAdapter().b(this.f8574b);
        n6.a setInfoAdapter = getSetInfoAdapter();
        AssetData assetData = this.f8573a;
        AssetData assetData2 = null;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        setInfoAdapter.setNewData(assetData.getSimpleProgramList());
        getSetInfoAdapter().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: r6.g
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ProgramSetInfoView.v(ProgramSetInfoView.this, baseQuickAdapter, view, i11);
            }
        });
        AssetData assetData3 = this.f8573a;
        if (assetData3 == null) {
            i.w("data");
        } else {
            assetData2 = assetData3;
        }
        if (assetData2.getSimpleProgramList().size() >= this.f8578f) {
            ((SeekBar) _$_findCachedViewById(R$id.mSeekBarProgram)).setVisibility(0);
        } else {
            ((SeekBar) _$_findCachedViewById(R$id.mSeekBarProgram)).setVisibility(8);
        }
        ((RecyclerView) _$_findCachedViewById(i10)).scrollToPosition(this.f8574b);
    }

    public final void w() {
        String format;
        int i10 = R$id.mTextSetNumber;
        TextView textView = (TextView) _$_findCachedViewById(i10);
        AssetData assetData = this.f8573a;
        AssetData assetData2 = null;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        int updateCount = assetData.getUpdateCount();
        AssetData assetData3 = this.f8573a;
        if (assetData3 == null) {
            i.w("data");
            assetData3 = null;
        }
        if (updateCount == assetData3.getVolumnCount()) {
            z zVar = z.f18964a;
            String string = getResources().getString(R.string.recommend_episodes_all);
            i.f(string, "resources.getString(R.st…g.recommend_episodes_all)");
            Object[] objArr = new Object[1];
            AssetData assetData4 = this.f8573a;
            if (assetData4 == null) {
                i.w("data");
                assetData4 = null;
            }
            objArr[0] = Integer.valueOf(assetData4.getVolumnCount());
            format = String.format(string, Arrays.copyOf(objArr, 1));
            i.f(format, "format(format, *args)");
        } else {
            z zVar2 = z.f18964a;
            String string2 = getResources().getString(R.string.recommend_episodes);
            i.f(string2, "resources.getString(R.string.recommend_episodes)");
            Object[] objArr2 = new Object[1];
            AssetData assetData5 = this.f8573a;
            if (assetData5 == null) {
                i.w("data");
                assetData5 = null;
            }
            objArr2[0] = Integer.valueOf(assetData5.getUpdateCount());
            format = String.format(string2, Arrays.copyOf(objArr2, 1));
            i.f(format, "format(format, *args)");
        }
        textView.setText(format);
        AssetData assetData6 = this.f8573a;
        if (assetData6 == null) {
            i.w("data");
        } else {
            assetData2 = assetData6;
        }
        List<ProgramSeason> sameSeasonSeriesList = assetData2.getSameSeasonSeriesList();
        if (sameSeasonSeriesList == null || sameSeasonSeriesList.isEmpty()) {
            ((TextView) _$_findCachedViewById(i10)).setGravity(19);
        } else {
            ((TextView) _$_findCachedViewById(i10)).setGravity(21);
        }
    }

    public final void x(int i10) {
        int i11 = R$id.mRecyclerSelectInfo;
        int childLayoutPosition = ((RecyclerView) _$_findCachedViewById(i11)).getChildLayoutPosition(((RecyclerView) _$_findCachedViewById(i11)).getChildAt(0));
        int childLayoutPosition2 = ((RecyclerView) _$_findCachedViewById(i11)).getChildLayoutPosition(((RecyclerView) _$_findCachedViewById(i11)).getChildAt(((RecyclerView) _$_findCachedViewById(i11)).getChildCount() - 1));
        if (i10 < childLayoutPosition) {
            ((RecyclerView) _$_findCachedViewById(i11)).smoothScrollToPosition(i10);
            return;
        }
        if (i10 > childLayoutPosition2) {
            ((RecyclerView) _$_findCachedViewById(i11)).smoothScrollToPosition(i10);
            this.f8580h = i10;
            this.f8579g = true;
        } else {
            int i12 = i10 - childLayoutPosition;
            if (i12 < 0 || i12 >= ((RecyclerView) _$_findCachedViewById(i11)).getChildCount()) {
                return;
            }
            ((RecyclerView) _$_findCachedViewById(i11)).smoothScrollBy(((RecyclerView) _$_findCachedViewById(i11)).getChildAt(i12).getLeft(), 0);
        }
    }
}
