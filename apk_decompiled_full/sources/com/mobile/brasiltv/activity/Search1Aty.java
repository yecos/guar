package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.z;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.Search1Aty;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.ClickSearchChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateAllChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.o0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import g5.u2;
import g5.x2;
import h9.g;
import h9.h;
import i6.m0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.h3;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class Search1Aty extends f5.d implements m0 {

    /* renamed from: o, reason: collision with root package name */
    public o0 f8085o;

    /* renamed from: q, reason: collision with root package name */
    public h3 f8087q;

    /* renamed from: r, reason: collision with root package name */
    public Map f8088r = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public u2 f8082l = new u2(this, new ArrayList());

    /* renamed from: m, reason: collision with root package name */
    public x2 f8083m = new x2(this, new ArrayList());

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f8084n = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final g f8086p = h.b(new a());

    /* loaded from: classes3.dex */
    public static final class a extends j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(Search1Aty.this));
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements u2.b {
        public b() {
        }

        @Override // g5.u2.b
        public void a(Channel channel) {
            i.g(channel, "itemData");
            Search1Aty.this.S2().v(channel);
            z.f5049u.l(true);
            xa.c.c().j(new ClickSearchChannelEvent(channel));
            Search1Aty.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements u2.a {
        public c() {
        }

        @Override // g5.u2.a
        public void a(Channel channel, int i10) {
            i.g(channel, "itemData");
            Search1Aty.this.g3(channel, i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements x2.a {
        public d() {
        }

        @Override // g5.x2.a
        public void a(Channel channel) {
            i.g(channel, "itemData");
            z.a aVar = z.f5049u;
            if (!aVar.b().isEmpty()) {
                if (aVar.b().get(channel.getChannelCode()) == null) {
                    f1.f8649a.w(R.string.live_no_channel);
                    return;
                }
                aVar.l(true);
                xa.c.c().j(new ClickSearchChannelEvent(channel));
                Search1Aty.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Search1Aty search1Aty = Search1Aty.this;
            int i10 = R$id.mEditSearch;
            if (TextUtils.isEmpty(((EditText) search1Aty.Z2(i10)).getText())) {
                Search1Aty.this.S2().G();
                return;
            }
            Search1Aty.this.f3().g(new ArrayList());
            Search1Aty.this.S2().K(((EditText) Search1Aty.this.Z2(i10)).getText().toString(), Search1Aty.this.b3());
            Search1Aty.this.e3().g(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final void i3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        search1Aty.finish();
    }

    public static final void j3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        search1Aty.finish();
    }

    public static final void k3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        ((EditText) search1Aty.Z2(R$id.mEditSearch)).getText().clear();
    }

    public static final void l3(Search1Aty search1Aty, View view) {
        i.g(search1Aty, "this$0");
        search1Aty.S2().z();
    }

    public static final void m3(Search1Aty search1Aty) {
        i.g(search1Aty, "this$0");
        int i10 = R$id.mEditSearch;
        if (TextUtils.isEmpty(((EditText) search1Aty.Z2(i10)).getText())) {
            return;
        }
        search1Aty.e3().g(true);
        search1Aty.S2().K(((EditText) search1Aty.Z2(i10)).getText().toString(), search1Aty.f8084n);
    }

    @Override // i6.m0
    public void N() {
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(0);
        e3().g(false);
    }

    @Override // i6.m0
    public void R1(ArrayList arrayList) {
        i.g(arrayList, "data");
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(8);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(0);
        this.f8082l.g(arrayList);
        e3().h(true);
        e3().g(false);
    }

    @Override // f5.d
    public void R2() {
        o3(new h3(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Z2(R$id.mLayoutSearch)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, c3(), 0, 0);
        d6.a aVar = d6.a.f12650a;
        if (aVar.j() == 1) {
            aVar.m();
        }
        n3();
        h3();
        ((EditText) Z2(R$id.mEditSearch)).requestFocus();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_search1;
    }

    public View Z2(int i10) {
        Map map = this.f8088r;
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

    @xa.j
    public final void alreadyQueryFav(AlreadyQueryFavEvent alreadyQueryFavEvent) {
        i.g(alreadyQueryFavEvent, "event");
        if (this.f8082l.getItemCount() > 0) {
            this.f8082l.notifyDataSetChanged();
        }
    }

    public final ArrayList b3() {
        return this.f8084n;
    }

    public final int c3() {
        return ((Number) this.f8086p.getValue()).intValue();
    }

    @Override // f5.d
    /* renamed from: d3, reason: merged with bridge method [inline-methods] */
    public h3 S2() {
        h3 h3Var = this.f8087q;
        if (h3Var != null) {
            return h3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final o0 e3() {
        o0 o0Var = this.f8085o;
        if (o0Var != null) {
            return o0Var;
        }
        i.w("mRecyclerViewUtil");
        return null;
    }

    public final u2 f3() {
        return this.f8082l;
    }

    public final void g3(Channel channel, int i10) {
        d6.a aVar = d6.a.f12650a;
        if (aVar.l(channel.getChannelCode())) {
            return;
        }
        aVar.f(channel.getChannelCode());
        this.f8082l.j(channel.getChannelCode(), i10);
        if (aVar.g(channel)) {
            aVar.h(channel);
        } else {
            aVar.e(channel);
        }
    }

    public final void h3() {
        ((ImageView) Z2(R$id.mIvBack)).setOnClickListener(new View.OnClickListener() { // from class: f5.q3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Search1Aty.i3(Search1Aty.this, view);
            }
        });
        ((TextView) Z2(R$id.mTextCancel)).setOnClickListener(new View.OnClickListener() { // from class: f5.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Search1Aty.j3(Search1Aty.this, view);
            }
        });
        ((ImageView) Z2(R$id.mImageClear)).setOnClickListener(new View.OnClickListener() { // from class: f5.s3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Search1Aty.k3(Search1Aty.this, view);
            }
        });
        ((ImageView) Z2(R$id.mImageDeleteHistory)).setOnClickListener(new View.OnClickListener() { // from class: f5.t3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Search1Aty.l3(Search1Aty.this, view);
            }
        });
        this.f8082l.i(new b());
        this.f8082l.h(new c());
        this.f8083m.f(new d());
        ((EditText) Z2(R$id.mEditSearch)).addTextChangedListener(new e());
        p3(new o0((RecyclerView) Z2(R$id.mRecyclerSearch)));
        e3().i(new o0.b() { // from class: f5.u3
            @Override // com.mobile.brasiltv.utils.o0.b
            public final void a() {
                Search1Aty.m3(Search1Aty.this);
            }
        });
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.m0
    public void l() {
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(8);
        this.f8083m.e(new ArrayList());
    }

    public final void n3() {
        int i10 = R$id.mRecyclerSearch;
        ((RecyclerView) Z2(i10)).setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((RecyclerView) Z2(i10)).setAdapter(this.f8082l);
        ((RecyclerView) Z2(i10)).setVisibility(8);
        int i11 = R$id.mRecyclerHistory;
        ((RecyclerView) Z2(i11)).setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((RecyclerView) Z2(i11)).setAdapter(this.f8083m);
        ((RecyclerView) Z2(i11)).setVisibility(0);
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(0);
    }

    public void o3(h3 h3Var) {
        i.g(h3Var, "<set-?>");
        this.f8087q = h3Var;
    }

    public final void p3(o0 o0Var) {
        i.g(o0Var, "<set-?>");
        this.f8085o = o0Var;
    }

    @Override // i6.m0
    public void showLoading(boolean z10) {
        ((ProgressBar) Z2(R$id.mLoadingPb)).setVisibility(z10 ? 0 : 8);
    }

    @xa.j(sticky = true)
    public final void updateAllChannelList(UpdateAllChannelEvent updateAllChannelEvent) {
        i.g(updateAllChannelEvent, "event");
        this.f8084n.clear();
        this.f8084n.addAll(updateAllChannelEvent.getAllChannelList());
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        i.g(updateFavStatusEvent, "event");
        this.f8082l.k(updateFavStatusEvent.getChannelCode());
    }

    @Override // i6.m0
    public void y2(ArrayList arrayList) {
        i.g(arrayList, "data");
        ((AutoRelativeLayout) Z2(R$id.mLayoutSearchHistoryTitle)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerHistory)).setVisibility(0);
        ((RecyclerView) Z2(R$id.mRecyclerSearch)).setVisibility(8);
        this.f8083m.e(arrayList);
        e3().h(false);
    }
}
