package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class PaymentResultDialog extends CommonDialog {
    private String paymentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentResultDialog(Context context, String str) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "paymentResult");
        this.paymentResult = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(PaymentResultDialog paymentResultDialog, View view) {
        t9.i.g(paymentResultDialog, "this$0");
        paymentResultDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(PaymentResultDialog paymentResultDialog, View view) {
        t9.i.g(paymentResultDialog, "this$0");
        paymentResultDialog.dismiss();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 460;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_payment_result;
    }

    public final String getPaymentResult() {
        return this.paymentResult;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentResultDialog.initListener$lambda$0(PaymentResultDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mKbOk)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentResultDialog.initListener$lambda$1(PaymentResultDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((TextView) findViewById(R$id.mTvContent)).setText(this.paymentResult);
    }

    public final void setPaymentResult(String str) {
        t9.i.g(str, "<set-?>");
        this.paymentResult = str;
    }
}
