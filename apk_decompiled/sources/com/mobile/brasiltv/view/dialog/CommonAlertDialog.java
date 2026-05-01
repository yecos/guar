package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class CommonAlertDialog extends CommonDialog {
    private String alertContent;
    private String cancelText;
    private String confirmText;
    private ICommonAlertCallback mCommonAlertCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAlertDialog(Context context, String str, String str2, String str3) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "alertContent");
        t9.i.g(str2, "cancelText");
        t9.i.g(str3, "confirmText");
        this.alertContent = str;
        this.cancelText = str2;
        this.confirmText = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(CommonAlertDialog commonAlertDialog, View view) {
        t9.i.g(commonAlertDialog, "this$0");
        ICommonAlertCallback iCommonAlertCallback = commonAlertDialog.mCommonAlertCallback;
        if (iCommonAlertCallback != null) {
            iCommonAlertCallback.onCancel(commonAlertDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(CommonAlertDialog commonAlertDialog, View view) {
        t9.i.g(commonAlertDialog, "this$0");
        ICommonAlertCallback iCommonAlertCallback = commonAlertDialog.mCommonAlertCallback;
        if (iCommonAlertCallback != null) {
            iCommonAlertCallback.onConfirm(commonAlertDialog);
        }
    }

    public final String getAlertContent() {
        return this.alertContent;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final String getConfirmText() {
        return this.confirmText;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 360;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 560;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_common_alert;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonAlertDialog.initListener$lambda$0(CommonAlertDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonAlertDialog.initListener$lambda$1(CommonAlertDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((TextView) findViewById(R$id.mTvAlertContent)).setText(this.alertContent);
        ((TextView) findViewById(R$id.mTvCancel)).setText(this.cancelText);
        ((TextView) findViewById(R$id.mTvConfirm)).setText(this.confirmText);
    }

    public final void setAlertContent(String str) {
        t9.i.g(str, "<set-?>");
        this.alertContent = str;
    }

    public final void setCancelText(String str) {
        t9.i.g(str, "<set-?>");
        this.cancelText = str;
    }

    public final CommonAlertDialog setCommonAlertCallback(ICommonAlertCallback iCommonAlertCallback) {
        t9.i.g(iCommonAlertCallback, "callback");
        this.mCommonAlertCallback = iCommonAlertCallback;
        return this;
    }

    public final void setConfirmText(String str) {
        t9.i.g(str, "<set-?>");
        this.confirmText = str;
    }
}
