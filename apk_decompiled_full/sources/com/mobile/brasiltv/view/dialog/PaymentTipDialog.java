package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class PaymentTipDialog extends CommonDialog {
    private s9.l onContinueCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentTipDialog(Context context, s9.l lVar) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(lVar, "onContinueCallback");
        this.onContinueCallback = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(PaymentTipDialog paymentTipDialog, View view) {
        t9.i.g(paymentTipDialog, "this$0");
        paymentTipDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(PaymentTipDialog paymentTipDialog, View view) {
        t9.i.g(paymentTipDialog, "this$0");
        paymentTipDialog.onContinueCallback.invoke(paymentTipDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$2(PaymentTipDialog paymentTipDialog, View view) {
        t9.i.g(paymentTipDialog, "this$0");
        paymentTipDialog.dismiss();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 570;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_payment_tip;
    }

    public final s9.l getOnContinueCallback() {
        return this.onContinueCallback;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentTipDialog.initListener$lambda$0(PaymentTipDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mKbContinue)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentTipDialog.initListener$lambda$1(PaymentTipDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mKbCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentTipDialog.initListener$lambda$2(PaymentTipDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
    }

    public final void setOnContinueCallback(s9.l lVar) {
        t9.i.g(lVar, "<set-?>");
        this.onContinueCallback = lVar;
    }
}
