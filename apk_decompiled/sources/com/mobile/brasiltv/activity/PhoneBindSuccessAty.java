package com.mobile.brasiltv.activity;

import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.PhoneBindSuccessAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.z0;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import f5.d;
import i6.d0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.m1;
import na.f;
import t9.i;
import w6.i;

/* loaded from: classes3.dex */
public final class PhoneBindSuccessAty extends d implements d0 {

    /* renamed from: l, reason: collision with root package name */
    public boolean f8003l;

    /* renamed from: m, reason: collision with root package name */
    public m1 f8004m;

    /* renamed from: n, reason: collision with root package name */
    public Map f8005n = new LinkedHashMap();

    public static final void X2(PhoneBindSuccessAty phoneBindSuccessAty) {
        i.g(phoneBindSuccessAty, "this$0");
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.I(), "1")) {
            phoneBindSuccessAty.S2().m(cVar.t(), MemberInfo.INSTANCE.getLastPassword(), "3", cVar.f(), cVar.K(), true);
        } else {
            b0.c0(phoneBindSuccessAty, MainAty.class);
        }
    }

    @Override // f5.d
    public void R2() {
        a3(new m1(this, this));
        Z2();
        boolean booleanExtra = getIntent().getBooleanExtra("toLogin", true);
        this.f8003l = booleanExtra;
        if (!booleanExtra) {
            ((TextView) V2(R$id.bindStatus)).setText(getResources().getString(R.string.bind_phone_success));
            ((TextView) V2(R$id.noticeText)).setVisibility(8);
            return;
        }
        ((TitleView) V2(R$id.titleView)).setAtyBackVisible(8);
        ((TextView) V2(R$id.bindStatus)).setText(getResources().getString(R.string.phone_bind_success_notice1, z0.b(w6.i.f19214g.t(), f.e(this, "login_area_code"))));
        ((TextView) V2(R$id.noticeText)).setVisibility(0);
        W2();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_phone_bind_success;
    }

    public View V2(int i10) {
        Map map = this.f8005n;
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

    public final void W2() {
        ((TextView) V2(R$id.bindStatus)).postDelayed(new Runnable() { // from class: f5.s2
            @Override // java.lang.Runnable
            public final void run() {
                PhoneBindSuccessAty.X2(PhoneBindSuccessAty.this);
            }
        }, 2000L);
    }

    @Override // f5.d
    /* renamed from: Y2, reason: merged with bridge method [inline-methods] */
    public m1 S2() {
        m1 m1Var = this.f8004m;
        if (m1Var != null) {
            return m1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void Z2() {
        int i10 = R$id.titleView;
        ((TitleView) V2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) V2(i10)).getSettingView().setVisibility(8);
        ((TitleView) V2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) V2(i10)).setIvMenuSrc(0);
        ((TitleView) V2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) V2(i10)).setTvMenuText("");
    }

    public void a3(m1 m1Var) {
        t9.i.g(m1Var, "<set-?>");
        this.f8004m = m1Var;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
