package com.mobile.brasiltv.mine.activity;

import android.view.View;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.RedemptionAty;
import com.mobile.brasiltv.mine.activity.VIPMemberActivity;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import i6.b1;
import i6.c1;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.p4;
import t9.g;
import t9.i;
import w6.i;

/* loaded from: classes3.dex */
public final class VIPMemberActivity extends d implements c1 {

    /* renamed from: n, reason: collision with root package name */
    public static final a f8449n = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public static final String f8450o = "bundle_title";

    /* renamed from: l, reason: collision with root package name */
    public p4 f8451l;

    /* renamed from: m, reason: collision with root package name */
    public Map f8452m = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final void X2(VIPMemberActivity vIPMemberActivity, View view) {
        i.g(vIPMemberActivity, "this$0");
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.I(), "1")) {
            f1.a.j(f1.f8649a, vIPMemberActivity.Q1(), R.string.mine_please_login, 0, 4, null);
        } else {
            i1.m(vIPMemberActivity.Q1(), cVar.H());
            b0.c0(vIPMemberActivity, RedemptionAty.class);
        }
    }

    public static final void Y2(VIPMemberActivity vIPMemberActivity, View view) {
        t9.i.g(vIPMemberActivity, "this$0");
        if (vIPMemberActivity.a3()) {
            f1.f8649a.w(R.string.mine_please_bind);
            return;
        }
        i.c cVar = w6.i.f19214g;
        if (cVar.g().length() > 0) {
            b0.j0(vIPMemberActivity.Q1(), cVar.g(), false, true, false, false, 24, null);
        }
        b0.U(vIPMemberActivity, "beVipUrl:" + cVar.g());
    }

    @Override // f5.d
    public void R2() {
        b3(new p4(this, this));
        String stringExtra = getIntent().getStringExtra(f8450o);
        if (stringExtra != null) {
            ((TitleView) W2(R$id.title_view)).setTitle(stringExtra);
        }
        ((AutoRelativeLayout) W2(R$id.rlExchangeCode)).setOnClickListener(new View.OnClickListener() { // from class: e6.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPMemberActivity.X2(VIPMemberActivity.this, view);
            }
        });
        ((AutoRelativeLayout) W2(R$id.rlBuyingOnline)).setOnClickListener(new View.OnClickListener() { // from class: e6.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPMemberActivity.Y2(VIPMemberActivity.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_vip_member;
    }

    public View W2(int i10) {
        Map map = this.f8452m;
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
    public p4 S2() {
        p4 p4Var = this.f8451l;
        if (p4Var != null) {
            return p4Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final boolean a3() {
        i.c cVar = w6.i.f19214g;
        return (!t9.i.b(cVar.c(), "1") || t9.i.b(cVar.h(), "1") || t9.i.b(cVar.j(), "1")) ? false : true;
    }

    public void b3(p4 p4Var) {
        t9.i.g(p4Var, "<set-?>");
        this.f8451l = p4Var;
    }

    @Override // m5.a
    /* renamed from: c3, reason: merged with bridge method [inline-methods] */
    public void Y0(b1 b1Var) {
        t9.i.g(b1Var, "presenter");
    }
}
