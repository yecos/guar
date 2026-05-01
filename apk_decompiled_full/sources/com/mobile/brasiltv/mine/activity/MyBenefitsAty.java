package com.mobile.brasiltv.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.y;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import h6.b;
import h6.c;
import i6.x;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.e1;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class MyBenefitsAty extends d implements x {

    /* renamed from: r, reason: collision with root package name */
    public static final a f8389r = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public e1 f8390l;

    /* renamed from: m, reason: collision with root package name */
    public c f8391m;

    /* renamed from: n, reason: collision with root package name */
    public b f8392n;

    /* renamed from: q, reason: collision with root package name */
    public Map f8395q = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    public final String f8393o = "tag_exchange";

    /* renamed from: p, reason: collision with root package name */
    public final String f8394p = "tag_coupons";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            aVar.a(context, i10, z10);
        }

        public final void a(Context context, int i10, boolean z10) {
            i.g(context, f.X);
            Intent intent = new Intent(context, (Class<?>) MyBenefitsAty.class);
            intent.putExtra("page_index_key", i10);
            intent.putExtra("isOpenInHome", z10);
            context.startActivity(intent);
        }
    }

    public static final void X2(MyBenefitsAty myBenefitsAty, View view) {
        i.g(myBenefitsAty, "this$0");
        myBenefitsAty.c3(0);
    }

    public static final void Y2(MyBenefitsAty myBenefitsAty, View view) {
        i.g(myBenefitsAty, "this$0");
        myBenefitsAty.c3(1);
        v5.g.f19112a.r();
        myBenefitsAty.W2(R$id.mVCouponDot).setVisibility(8);
    }

    @Override // f5.d
    public void R2() {
        b3(new e1(this, this));
        this.f8391m = (c) getSupportFragmentManager().h0(this.f8393o);
        this.f8392n = (b) getSupportFragmentManager().h0(this.f8394p);
        c3(getIntent().getIntExtra("page_index_key", 0));
        ((TextView) W2(R$id.mTvExchangeCode)).setOnClickListener(new View.OnClickListener() { // from class: e6.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBenefitsAty.X2(MyBenefitsAty.this, view);
            }
        });
        int i10 = R$id.mArlCoupon;
        ((AutoRelativeLayout) W2(i10)).setOnClickListener(new View.OnClickListener() { // from class: e6.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBenefitsAty.Y2(MyBenefitsAty.this, view);
            }
        });
        if (v5.g.f19112a.l() != 0) {
            W2(R$id.mVCouponDot).setVisibility(0);
        }
        if (getIntent().getBooleanExtra("isOpenInHome", false)) {
            ((AutoRelativeLayout) W2(i10)).performClick();
        }
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_my_benefits;
    }

    public View W2(int i10) {
        Map map = this.f8395q;
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

    @Override // f5.d
    /* renamed from: Z2, reason: merged with bridge method [inline-methods] */
    public e1 S2() {
        e1 e1Var = this.f8390l;
        if (e1Var != null) {
            return e1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void a3(y yVar) {
        c cVar = this.f8391m;
        if (cVar != null) {
            yVar.o(cVar);
        }
        b bVar = this.f8392n;
        if (bVar != null) {
            yVar.o(bVar);
        }
    }

    public void b3(e1 e1Var) {
        i.g(e1Var, "<set-?>");
        this.f8390l = e1Var;
    }

    public final void c3(int i10) {
        y m10 = getSupportFragmentManager().m();
        i.f(m10, "supportFragmentManager.beginTransaction()");
        a3(m10);
        if (i10 == 0) {
            ((TextView) W2(R$id.mTvExchangeCode)).setSelected(true);
            ((TextView) W2(R$id.mTvCoupons)).setSelected(false);
            Fragment fragment = this.f8391m;
            if (fragment == null) {
                c cVar = new c();
                this.f8391m = cVar;
                i.d(cVar);
                m10.c(R.id.mFlContent, cVar, this.f8393o);
            } else {
                i.d(fragment);
                m10.u(fragment);
            }
        } else if (i10 == 1) {
            ((TextView) W2(R$id.mTvExchangeCode)).setSelected(false);
            ((TextView) W2(R$id.mTvCoupons)).setSelected(true);
            Fragment fragment2 = this.f8392n;
            if (fragment2 == null) {
                this.f8392n = new b();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isOpenInHome", getIntent().getBooleanExtra("isOpenInHome", false));
                b bVar = this.f8392n;
                i.e(bVar, "null cannot be cast to non-null type com.mobile.brasiltv.fragment.BaseDaggerFrag<*>");
                bVar.setArguments(bundle);
                Fragment fragment3 = this.f8392n;
                i.d(fragment3);
                m10.c(R.id.mFlContent, fragment3, this.f8394p);
            } else {
                i.d(fragment2);
                m10.u(fragment2);
            }
        }
        m10.h();
    }

    @Override // i5.a
    public void k2() {
        n2();
    }
}
