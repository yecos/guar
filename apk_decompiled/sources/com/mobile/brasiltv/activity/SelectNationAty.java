package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.NationBean;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.SideBar;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import g5.e3;
import h9.g;
import h9.h;
import i6.p0;
import i6.q0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.t3;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class SelectNationAty extends f5.d implements q0 {

    /* renamed from: p, reason: collision with root package name */
    public static final a f8104p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f8105q = 3;

    /* renamed from: n, reason: collision with root package name */
    public t3 f8108n;

    /* renamed from: o, reason: collision with root package name */
    public Map f8109o = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final g f8106l = h.b(new d());

    /* renamed from: m, reason: collision with root package name */
    public final g f8107m = h.b(new b());

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final int a() {
            return SelectNationAty.f8105q;
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e3 invoke() {
            return new e3(SelectNationAty.this.b3());
        }
    }

    public static final class c implements e3.c {
        public c() {
        }

        @Override // g5.e3.c
        public void a(int i10) {
            Intent intent = new Intent();
            NationBean nationBean = (NationBean) SelectNationAty.this.Z2().getItem(i10);
            intent.putExtra("register_nation", nationBean != null ? nationBean.getCountry() : null);
            NationBean nationBean2 = (NationBean) SelectNationAty.this.Z2().getItem(i10);
            intent.putExtra("register_code", nationBean2 != null ? nationBean2.getCode() : null);
            SelectNationAty.this.setResult(SelectNationAty.f8104p.a(), intent);
            SelectNationAty.this.finish();
        }
    }

    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            return SelectNationAty.this.c3();
        }
    }

    @Override // f5.d
    public void R2() {
        e3(new t3(this, this));
        d3();
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(this, 1, false);
        int i10 = R$id.selectNationList;
        ((RecyclerView) U2(i10)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) U2(i10)).setAdapter(Z2());
        Z2().i(new c());
        Z2().h(linearLayoutManagerWrapper);
        e3 Z2 = Z2();
        SideBar sideBar = (SideBar) U2(R$id.selectNationSlideBar);
        i.f(sideBar, "selectNationSlideBar");
        Z2.j(sideBar);
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_select_nation;
    }

    public View U2(int i10) {
        Map map = this.f8109o;
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

    public final e3 Z2() {
        return (e3) this.f8107m.getValue();
    }

    @Override // f5.d
    /* renamed from: a3, reason: merged with bridge method [inline-methods] */
    public t3 S2() {
        t3 t3Var = this.f8108n;
        if (t3Var != null) {
            return t3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final ArrayList b3() {
        return (ArrayList) this.f8106l.getValue();
    }

    public final ArrayList c3() {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = getResources().getStringArray(R.array.nation);
        i.f(stringArray, "resources.getStringArray(R.array.nation)");
        String[] stringArray2 = getResources().getStringArray(R.array.code);
        i.f(stringArray2, "resources.getStringArray(R.array.code)");
        int length = stringArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            NationBean nationBean = new NationBean();
            nationBean.setCode(stringArray2[i10]);
            nationBean.setCountry(stringArray[i10]);
            arrayList.add(nationBean);
        }
        return arrayList;
    }

    public final void d3() {
        int i10 = R$id.titleView;
        ((TitleView) U2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) U2(i10)).getSettingView().setVisibility(8);
        ((TitleView) U2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) U2(i10)).setIvMenuSrc(0);
        ((TitleView) U2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) U2(i10)).setTvMenuText("");
    }

    public void e3(t3 t3Var) {
        i.g(t3Var, "<set-?>");
        this.f8108n = t3Var;
    }

    @Override // m5.a
    /* renamed from: f3, reason: merged with bridge method [inline-methods] */
    public void Y0(p0 p0Var) {
        i.g(p0Var, "presenter");
    }

    @Override // i5.a
    public void k2() {
        n2();
    }
}
