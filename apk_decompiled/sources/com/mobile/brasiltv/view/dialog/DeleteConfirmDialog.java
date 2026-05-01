package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class DeleteConfirmDialog extends Dialog {
    private ConfirmCallback callback;
    private int deleteResId;

    public interface ConfirmCallback {
        void onConfirm();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteConfirmDialog(Context context, int i10, ConfirmCallback confirmCallback) {
        super(context, R.style.OptionDialog);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(confirmCallback, "callback");
        this.deleteResId = i10;
        this.callback = confirmCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(DeleteConfirmDialog deleteConfirmDialog, View view) {
        t9.i.g(deleteConfirmDialog, "this$0");
        deleteConfirmDialog.callback.onConfirm();
        deleteConfirmDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(DeleteConfirmDialog deleteConfirmDialog, View view) {
        t9.i.g(deleteConfirmDialog, "this$0");
        deleteConfirmDialog.dismiss();
    }

    public final ConfirmCallback getCallback() {
        return this.callback;
    }

    public final int getDeleteResId() {
        return this.deleteResId;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_delete_confirm);
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
        ((TextView) findViewById(R$id.mTextDetail)).setText(getContext().getString(this.deleteResId));
        ((KoocanButton) findViewById(R$id.mButtonConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeleteConfirmDialog.onCreate$lambda$1(DeleteConfirmDialog.this, view);
            }
        });
        ((KoocanButton) findViewById(R$id.mButtonCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeleteConfirmDialog.onCreate$lambda$2(DeleteConfirmDialog.this, view);
            }
        });
    }

    public final void setCallback(ConfirmCallback confirmCallback) {
        t9.i.g(confirmCallback, "<set-?>");
        this.callback = confirmCallback;
    }

    public final void setDeleteResId(int i10) {
        this.deleteResId = i10;
    }
}
