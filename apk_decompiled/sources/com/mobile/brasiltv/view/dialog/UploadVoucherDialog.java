package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class UploadVoucherDialog extends CommonDialog {
    private String uploadVorcherUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadVoucherDialog(Context context, String str) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "uploadVorcherUrl");
        this.uploadVorcherUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(UploadVoucherDialog uploadVoucherDialog, View view) {
        t9.i.g(uploadVoucherDialog, "this$0");
        uploadVoucherDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(UploadVoucherDialog uploadVoucherDialog, View view) {
        t9.i.g(uploadVoucherDialog, "this$0");
        Context context = uploadVoucherDialog.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        com.mobile.brasiltv.utils.b0.j0(context, uploadVoucherDialog.uploadVorcherUrl, false, true, false, false, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$2(UploadVoucherDialog uploadVoucherDialog, View view) {
        t9.i.g(uploadVoucherDialog, "this$0");
        uploadVoucherDialog.dismiss();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 615;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_upload_voucher;
    }

    public final String getUploadVorcherUrl() {
        return this.uploadVorcherUrl;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadVoucherDialog.initListener$lambda$0(UploadVoucherDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mKbUpload)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadVoucherDialog.initListener$lambda$1(UploadVoucherDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mKbCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadVoucherDialog.initListener$lambda$2(UploadVoucherDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
    }

    public final void setUploadVorcherUrl(String str) {
        t9.i.g(str, "<set-?>");
        this.uploadVorcherUrl = str;
    }
}
