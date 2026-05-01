package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class DeleteMsgDialog extends CommonDialog {
    private String content;
    private View.OnClickListener mConfirmListener;
    private Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteMsgDialog(Context context, String str) {
        super(context, 0, 2, null);
        t9.i.g(context, "mContext");
        t9.i.g(str, "content");
        this.mContext = context;
        this.content = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(DeleteMsgDialog deleteMsgDialog, View view) {
        t9.i.g(deleteMsgDialog, "this$0");
        deleteMsgDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(DeleteMsgDialog deleteMsgDialog, View view) {
        t9.i.g(deleteMsgDialog, "this$0");
        View.OnClickListener onClickListener = deleteMsgDialog.mConfirmListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        deleteMsgDialog.dismiss();
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return -2;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_delete_msg;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeleteMsgDialog.initListener$lambda$0(DeleteMsgDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeleteMsgDialog.initListener$lambda$1(DeleteMsgDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius(AutoUtils.getPercentWidthSize(16));
        ((TextView) findViewById(R$id.mTvContent)).setText(this.content);
    }

    public final DeleteMsgDialog setConfirmListener(View.OnClickListener onClickListener) {
        t9.i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mConfirmListener = onClickListener;
        return this;
    }

    public final void setContent(String str) {
        t9.i.g(str, "<set-?>");
        this.content = str;
    }

    public final void setMContext(Context context) {
        t9.i.g(context, "<set-?>");
        this.mContext = context;
    }
}
