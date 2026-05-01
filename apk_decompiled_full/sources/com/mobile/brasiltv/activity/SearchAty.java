package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SearchAty;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.q0;
import com.mobile.brasiltv.utils.s;
import com.mobile.brasiltv.view.GridLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.RecyclerNoMoreView;
import com.mobile.brasiltv.view.SpaceItemDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.b3;
import g5.f0;
import g5.v2;
import h9.g;
import h9.h;
import h9.t;
import i6.n0;
import i6.o0;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.s3;
import mobile.com.requestframe.utils.response.ShelveAsset;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class SearchAty extends f5.d implements o0, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: p, reason: collision with root package name */
    public s3 f8098p;

    /* renamed from: q, reason: collision with root package name */
    public Map f8099q = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public String f8094l = "";

    /* renamed from: m, reason: collision with root package name */
    public final g f8095m = h.b(new a());

    /* renamed from: n, reason: collision with root package name */
    public final g f8096n = h.b(new c());

    /* renamed from: o, reason: collision with root package name */
    public final g f8097o = h.b(new b());

    public static final class a extends j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final v2 invoke() {
            return new v2(SearchAty.this);
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return new f0(SearchAty.this);
        }
    }

    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b3 invoke() {
            return new b3(SearchAty.this, new ArrayList());
        }
    }

    public static final class d extends j implements l {
        public d() {
            super(1);
        }

        public final void b(Editable editable) {
            Editable text = ((EditText) SearchAty.this.e3(R$id.searchEt)).getText();
            i.f(text, "searchEt.text");
            if (text.length() == 0) {
                ((Button) SearchAty.this.e3(R$id.searchCancel)).setText(SearchAty.this.Q1().getResources().getString(R.string.cancel));
                ((ImageView) SearchAty.this.e3(R$id.searchClear)).setVisibility(8);
            } else {
                ((Button) SearchAty.this.e3(R$id.searchCancel)).setText(SearchAty.this.Q1().getResources().getString(R.string.search_search));
                ((ImageView) SearchAty.this.e3(R$id.searchClear)).setVisibility(0);
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Editable) obj);
            return t.f14242a;
        }
    }

    public static final void h3(SearchAty searchAty, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(searchAty, "this$0");
        Object obj = baseQuickAdapter.getData().get(i10);
        i.e(obj, "null cannot be cast to non-null type kotlin.String");
        searchAty.F3((String) obj);
    }

    public static final void i3(SearchAty searchAty, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(searchAty, "this$0");
        ShelveAsset shelveAsset = (ShelveAsset) searchAty.u3().getData().get(i10);
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(shelveAsset.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        b0.r(searchAty, shelveAsset.getType(), shelveAsset.getProgramType(), shelveAsset.getContentId(), EnterType.SEARCH, b0.c(ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString()), (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? false : false, (r25 & 128) != 0 ? -1 : 0, (r25 & 256) != 0 ? "" : "hotSearch", o10);
    }

    public static final boolean k3(SearchAty searchAty, TextView textView, int i10, KeyEvent keyEvent) {
        i.g(searchAty, "this$0");
        if (i10 != 3) {
            return false;
        }
        searchAty.z3();
        return false;
    }

    public static final boolean l3(SearchAty searchAty, View view, int i10, KeyEvent keyEvent) {
        i.g(searchAty, "this$0");
        if (i10 != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        searchAty.A3();
        return false;
    }

    public static final void m3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void n3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        searchAty.finish();
    }

    public static final void o3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        Editable text = ((EditText) searchAty.e3(R$id.searchEt)).getText();
        i.f(text, "searchEt.text");
        if (text.length() == 0) {
            searchAty.finish();
        } else {
            searchAty.z3();
            searchAty.A3();
        }
    }

    public static final void p3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        ((EditText) searchAty.e3(R$id.searchEt)).setText("");
        searchAty.S2().V("");
        searchAty.f3();
    }

    public static final void q3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        q0.a(searchAty.getApplicationContext());
        searchAty.s3();
    }

    public static final void r3(SearchAty searchAty, View view) {
        i.g(searchAty, "this$0");
        searchAty.S2().P();
        i1.F(searchAty);
    }

    public final void A3() {
        if (getCurrentFocus() != null) {
            Object systemService = getSystemService("input_method");
            i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            View currentFocus = getCurrentFocus();
            i.d(currentFocus);
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        } else {
            Object systemService2 = getSystemService("input_method");
            i.e(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService2).hideSoftInputFromWindow(((EditText) e3(R$id.searchEt)).getWindowToken(), 2);
        }
        int i10 = R$id.searchEt;
        if (((EditText) e3(i10)) != null) {
            S2().S(((EditText) e3(i10)).getText().toString());
        }
    }

    public void B3(s3 s3Var) {
        i.g(s3Var, "<set-?>");
        this.f8098p = s3Var;
    }

    @Override // i6.o0
    public void C2(String str) {
        i.g(str, "searchKey");
        this.f8094l = str;
        ((AutoLinearLayout) e3(R$id.mLlSearchEmpty)).setVisibility(0);
        ((RecyclerView) e3(R$id.searchResultList)).setVisibility(8);
        List data = v3().getData();
        if (data != null) {
            data.clear();
        }
        v3().notifyDataSetChanged();
        v3().setEnableLoadMore(false);
    }

    @Override // m5.a
    /* renamed from: C3, reason: merged with bridge method [inline-methods] */
    public void Y0(n0 n0Var) {
        i.g(n0Var, "presenter");
    }

    public final void D3(int i10) {
        if (u3().getData().isEmpty()) {
            return;
        }
        ((AutoLinearLayout) e3(R$id.hotSearch)).setVisibility(i10);
        if (i10 == 0) {
            y3();
        }
    }

    public final void E3(int i10) {
        ((AutoLinearLayout) e3(R$id.searchHistoryLayout)).setVisibility(i10);
    }

    @Override // i6.o0
    public void F0(int i10, List list) {
        i.g(list, "assetList");
        ((AutoLinearLayout) e3(R$id.hotSearch)).setVisibility(0);
        u3().b(i10);
        u3().setNewData(list);
    }

    public final void F3(String str) {
        S2().S(str);
        int i10 = R$id.searchEt;
        ((EditText) e3(i10)).setText(str);
        Editable text = ((EditText) e3(i10)).getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
    }

    @Override // i6.o0
    public void M0(String str) {
        i.g(str, "searchKey");
        C2(str);
        h0(8);
        v3().loadMoreFail();
    }

    @Override // f5.d
    public void R2() {
        B3(new s3(this, this));
        ((ImageView) e3(R$id.mIvBack)).setOnClickListener(new View.OnClickListener() { // from class: f5.v3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAty.n3(SearchAty.this, view);
            }
        });
        ((Button) e3(R$id.searchCancel)).setOnClickListener(new View.OnClickListener() { // from class: f5.w3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAty.o3(SearchAty.this, view);
            }
        });
        ((ImageView) e3(R$id.searchClear)).setOnClickListener(new View.OnClickListener() { // from class: f5.x3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAty.p3(SearchAty.this, view);
            }
        });
        ((ImageView) e3(R$id.historyDelete)).setOnClickListener(new View.OnClickListener() { // from class: f5.y3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAty.q3(SearchAty.this, view);
            }
        });
        ((ImageView) e3(R$id.mIvHotRefresh)).setOnClickListener(new View.OnClickListener() { // from class: f5.z3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAty.r3(SearchAty.this, view);
            }
        });
        j3();
        g3();
        s3();
        i1.t(this);
    }

    @Override // i6.o0
    public void T0() {
        LoadingDialog.Companion.hidden();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_search;
    }

    @Override // i6.o0
    public String X() {
        Editable text;
        String obj;
        EditText editText = (EditText) e3(R$id.searchEt);
        return (editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null) ? "" : obj;
    }

    @Override // i6.o0
    public void a1(List list, String str, boolean z10) {
        i.g(list, "showResults");
        i.g(str, "searchKey");
        h0(0);
        if (i.b(this.f8094l, str)) {
            v3().addData((Collection) list);
        } else {
            ((RecyclerView) e3(R$id.searchResultList)).scrollToPosition(0);
            v3().i(list, str);
            v3().setEnableLoadMore(true);
            this.f8094l = str;
        }
        v3().loadMoreComplete();
    }

    public View e3(int i10) {
        Map map = this.f8099q;
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

    public final void f3() {
        s3();
        D3(0);
        x3();
    }

    public final void g3() {
        int i10 = R$id.searchHistoryList;
        ((RecyclerView) e3(i10)).setLayoutManager(new GridLayoutManagerWrapper(Q1(), 2));
        ((RecyclerView) e3(i10)).addItemDecoration(new SpaceItemDecoration(AutoUtils.getPercentHeightSize(20), AutoUtils.getPercentWidthSize(17), 2));
        t3().bindToRecyclerView((RecyclerView) e3(i10));
        t3().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: f5.a4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SearchAty.h3(SearchAty.this, baseQuickAdapter, view, i11);
            }
        });
        int i11 = R$id.searchResultList;
        ((RecyclerView) e3(i11)).setLayoutManager(new GridLayoutManagerWrapper(Q1(), 3));
        ((RecyclerView) e3(i11)).addItemDecoration(new SpaceItemDecoration(AutoUtils.getPercentHeightSize(36), AutoUtils.getPercentWidthSize(10), 3));
        v3().setOnLoadMoreListener(this, (RecyclerView) e3(i11));
        v3().setLoadMoreView(new RecyclerNoMoreView());
        v3().disableLoadMoreIfNotFullPage();
        ((RecyclerView) e3(i11)).setAdapter(v3());
        int i12 = R$id.hotSearchList;
        ((RecyclerView) e3(i12)).setLayoutManager(new LinearLayoutManagerWrapper(Q1(), 1, false));
        u3().bindToRecyclerView((RecyclerView) e3(i12));
        u3().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: f5.b4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                SearchAty.i3(SearchAty.this, baseQuickAdapter, view, i13);
            }
        });
    }

    @Override // i6.o0
    public void h() {
        LoadingDialog.Companion.show(getFragmentManager());
    }

    @Override // i6.o0
    public void h0(int i10) {
        ((RecyclerView) e3(R$id.searchResultList)).setVisibility(i10);
        E3(8);
        if (i10 == 8) {
            D3(0);
        } else {
            D3(8);
        }
    }

    @Override // i6.o0
    public void j0() {
        v3().loadMoreEnd();
    }

    public final void j3() {
        int i10 = R$id.searchEt;
        EditText editText = (EditText) e3(i10);
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: f5.c4
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    boolean k32;
                    k32 = SearchAty.k3(SearchAty.this, textView, i11, keyEvent);
                    return k32;
                }
            });
        }
        EditText editText2 = (EditText) e3(i10);
        if (editText2 != null) {
            editText2.setOnKeyListener(new View.OnKeyListener() { // from class: f5.d4
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    boolean l32;
                    l32 = SearchAty.l3(SearchAty.this, view, i11, keyEvent);
                    return l32;
                }
            });
        }
        s sVar = s.f8745a;
        EditText editText3 = (EditText) e3(i10);
        i.f(editText3, "searchEt");
        Observable j10 = sVar.j(editText3);
        final d dVar = new d();
        j10.subscribe(new Consumer() { // from class: f5.e4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchAty.m3(s9.l.this, obj);
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        if (TextUtils.isEmpty(X())) {
            return;
        }
        F3(X());
    }

    public final void s3() {
        ArrayList b10 = q0.b(getApplicationContext());
        if (b10.size() <= 0) {
            E3(8);
        } else {
            t3().setNewData(b10);
            E3(0);
        }
    }

    public final v2 t3() {
        return (v2) this.f8095m.getValue();
    }

    public final f0 u3() {
        return (f0) this.f8097o.getValue();
    }

    @Override // i6.o0
    public void v2() {
    }

    public final b3 v3() {
        return (b3) this.f8096n.getValue();
    }

    @Override // f5.d
    /* renamed from: w3, reason: merged with bridge method [inline-methods] */
    public s3 S2() {
        s3 s3Var = this.f8098p;
        if (s3Var != null) {
            return s3Var;
        }
        i.w("mPresenter");
        return null;
    }

    @Override // i6.o0
    public void x0() {
        int i10 = R$id.searchEt;
        ((EditText) e3(i10)).setHint(b0.A(this, R.string.please_type_search_content));
        ((EditText) e3(i10)).setHintTextColor(b0.y(R.color.color_f23232));
    }

    public final void x3() {
        ((AutoLinearLayout) e3(R$id.mLlSearchEmpty)).setVisibility(8);
    }

    public final void y3() {
        ((RecyclerView) e3(R$id.searchResultList)).setVisibility(8);
    }

    public final void z3() {
        S2().Q(ba.t.W(((EditText) e3(R$id.searchEt)).getText().toString()).toString());
    }
}
