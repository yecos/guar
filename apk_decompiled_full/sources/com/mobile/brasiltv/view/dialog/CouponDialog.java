package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class CouponDialog extends BaseDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponDialog(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(CouponDialog couponDialog, View view) {
        t9.i.g(couponDialog, "this$0");
        couponDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(CouponDialog couponDialog, View view) {
        t9.i.g(couponDialog, "this$0");
        if (t9.i.b(w6.i.f19214g.I(), "1")) {
            couponDialog.getContext().startActivity(new Intent(couponDialog.getContext(), (Class<?>) AccountBindAty.class));
            couponDialog.dismiss();
        } else {
            MyBenefitsAty.a aVar = MyBenefitsAty.f8389r;
            Context context = couponDialog.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            MyBenefitsAty.a.b(aVar, context, 1, false, 4, null);
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_coupon);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            attributes.height = AutoUtils.getPercentWidthSize(450);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        ((TextView) findViewById(R$id.mTvOff)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponDialog.onCreate$lambda$1(CouponDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvUse)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponDialog.onCreate$lambda$2(CouponDialog.this, view);
            }
        });
        setCancelable(false);
    }
}
