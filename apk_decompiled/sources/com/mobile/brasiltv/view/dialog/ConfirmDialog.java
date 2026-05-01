package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public class ConfirmDialog extends CommonDialog {
    private String content;
    private s9.l mConfirmCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmDialog(Context context, String str) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "content");
        this.content = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(ConfirmDialog confirmDialog, View view) {
        t9.i.g(confirmDialog, "this$0");
        s9.l lVar = confirmDialog.mConfirmCallback;
        if (lVar != null) {
            lVar.invoke(confirmDialog);
        }
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 420;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 560;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_confirm;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmDialog.initListener$lambda$0(ConfirmDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((TextView) findViewById(R$id.mTvContent)).setText(this.content);
    }

    public final ConfirmDialog setConfirmCallback(s9.l lVar) {
        t9.i.g(lVar, "callback");
        this.mConfirmCallback = lVar;
        return this;
    }

    public final void setContent(String str) {
        t9.i.g(str, "<set-?>");
        this.content = str;
    }
}
