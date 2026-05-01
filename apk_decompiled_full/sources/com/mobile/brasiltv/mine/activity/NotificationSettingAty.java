package com.mobile.brasiltv.mine.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.NotificationSettingAty;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import i6.a0;
import i6.b0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.h1;
import t9.i;

/* loaded from: classes3.dex */
public final class NotificationSettingAty extends d implements b0 {

    /* renamed from: l, reason: collision with root package name */
    public h1 f8396l;

    /* renamed from: m, reason: collision with root package name */
    public Map f8397m = new LinkedHashMap();

    public static final void W2(NotificationSettingAty notificationSettingAty, View view) {
        i.g(notificationSettingAty, "this$0");
        notificationSettingAty.S2().h();
    }

    @Override // f5.d
    public void R2() {
        Y2(new h1(this, this));
        ((AutoRelativeLayout) V2(R$id.mLayoutNotify)).setOnClickListener(new View.OnClickListener() { // from class: e6.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationSettingAty.W2(NotificationSettingAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_notification_setting;
    }

    public View V2(int i10) {
        Map map = this.f8397m;
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
    /* renamed from: X2, reason: merged with bridge method [inline-methods] */
    public h1 S2() {
        h1 h1Var = this.f8396l;
        if (h1Var != null) {
            return h1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void Y2(h1 h1Var) {
        i.g(h1Var, "<set-?>");
        this.f8396l = h1Var;
    }

    @Override // m5.a
    /* renamed from: Z2, reason: merged with bridge method [inline-methods] */
    public void Y0(a0 a0Var) {
        i.g(a0Var, "presenter");
    }

    @Override // i6.b0
    public void e2() {
        ((TextView) V2(R$id.mTvMenuName)).setText(getString(R.string.msg_notify_status_off));
        ((TextView) V2(R$id.mTvSubMenuName)).setText(getString(R.string.msg_notify_go_to_open));
        int i10 = R$id.mTvMenuInfo;
        ((TextView) V2(i10)).setText(getString(R.string.msg_notify_off));
        ((TextView) V2(i10)).setVisibility(8);
        ((ImageView) V2(R$id.mIvMenuRightIcon)).setVisibility(0);
        ((AutoRelativeLayout) V2(R$id.mLayoutNotify)).setClickable(true);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        S2().i();
    }

    @Override // i6.b0
    public void y1() {
        ((TextView) V2(R$id.mTvMenuName)).setText(getString(R.string.msg_notify_status_on));
        ((TextView) V2(R$id.mTvSubMenuName)).setText(getString(R.string.msg_notify_go_to_close));
        int i10 = R$id.mTvMenuInfo;
        ((TextView) V2(i10)).setText(getString(R.string.msg_notify_on));
        ((TextView) V2(i10)).setVisibility(0);
        ((ImageView) V2(R$id.mIvMenuRightIcon)).setVisibility(8);
        ((AutoRelativeLayout) V2(R$id.mLayoutNotify)).setClickable(false);
    }
}
