package com.mobile.brasiltv.mine.activity;

import android.view.View;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.SettingAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.setting.MenuItem;
import com.msandroid.mobile.R;
import f5.d;
import h9.t;
import i6.v0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.y3;
import t9.i;

/* loaded from: classes3.dex */
public final class SettingAty extends d implements v0 {

    /* renamed from: l, reason: collision with root package name */
    public LoadingView f8446l;

    /* renamed from: m, reason: collision with root package name */
    public y3 f8447m;

    /* renamed from: n, reason: collision with root package name */
    public Map f8448n = new LinkedHashMap();

    public static final void Z2(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        settingAty.finish();
    }

    public static final void a3(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        b0.c0(settingAty, NotificationSettingAty.class);
    }

    public static final void b3(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        settingAty.S2().i();
    }

    public static final void c3(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        b0.c0(settingAty, AboutAty.class);
    }

    @Override // i6.v0
    public void J(String str) {
        i.g(str, "versionName");
        ((MenuItem) Y2(R$id.mMiUpgrade)).setMenuInfo(str);
    }

    @Override // i6.v0
    public void R0(boolean z10) {
        ((MenuItem) Y2(R$id.mMiUpgrade)).setMenuFlagVisibility(z10 ? 0 : 8);
    }

    @Override // f5.d
    public void R2() {
        e3(new y3(this, this));
        ((TitleBarView) Y2(R$id.mTbvTitle)).setOnBackClickListener(new View.OnClickListener() { // from class: e6.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAty.Z2(SettingAty.this, view);
            }
        });
        ((MenuItem) Y2(R$id.mMiNotify)).setOnClickListener(new View.OnClickListener() { // from class: e6.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAty.a3(SettingAty.this, view);
            }
        });
        ((MenuItem) Y2(R$id.mMiUpgrade)).setOnClickListener(new View.OnClickListener() { // from class: e6.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAty.b3(SettingAty.this, view);
            }
        });
        ((MenuItem) Y2(R$id.mMiAboutUs)).setOnClickListener(new View.OnClickListener() { // from class: e6.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAty.c3(SettingAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_setting;
    }

    public View Y2(int i10) {
        Map map = this.f8448n;
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
    /* renamed from: d3, reason: merged with bridge method [inline-methods] */
    public y3 S2() {
        y3 y3Var = this.f8447m;
        if (y3Var != null) {
            return y3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void e3(y3 y3Var) {
        i.g(y3Var, "<set-?>");
        this.f8447m = y3Var;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // i6.v0
    public void m0(String str) {
        i.g(str, Constant.KEY_STATUS);
        ((MenuItem) Y2(R$id.mMiNotify)).setMenuInfo(str);
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        S2().h();
    }

    @Override // i6.v0
    public void showLoading(boolean z10) {
        if (this.f8446l == null) {
            this.f8446l = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, null, 14, null);
            t tVar = t.f14242a;
        }
        if (z10) {
            LoadingView loadingView = this.f8446l;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f8446l;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
