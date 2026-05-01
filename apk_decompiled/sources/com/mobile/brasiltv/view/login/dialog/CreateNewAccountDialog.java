package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class CreateNewAccountDialog extends CommonDialog {
    private ICreateNewAccountCallback mCreateNewAccountCallback;
    private x7.a socialInfo;
    private String thirdPartType;
    private String tpSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateNewAccountDialog(Context context, String str, String str2, x7.a aVar) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "thirdPartType");
        t9.i.g(str2, "tpSource");
        t9.i.g(aVar, "socialInfo");
        this.thirdPartType = str;
        this.tpSource = str2;
        this.socialInfo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(CreateNewAccountDialog createNewAccountDialog, View view) {
        t9.i.g(createNewAccountDialog, "this$0");
        ICreateNewAccountCallback iCreateNewAccountCallback = createNewAccountDialog.mCreateNewAccountCallback;
        if (iCreateNewAccountCallback != null) {
            iCreateNewAccountCallback.dialogRevokeAccessGoogle();
        }
        createNewAccountDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(CreateNewAccountDialog createNewAccountDialog, View view) {
        t9.i.g(createNewAccountDialog, "this$0");
        ICreateNewAccountCallback iCreateNewAccountCallback = createNewAccountDialog.mCreateNewAccountCallback;
        if (iCreateNewAccountCallback != null) {
            iCreateNewAccountCallback.onCreateNewAccount(createNewAccountDialog.thirdPartType, createNewAccountDialog.tpSource, createNewAccountDialog.socialInfo);
        }
        createNewAccountDialog.dismiss();
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
        return R.layout.dialog_create_new_account;
    }

    public final x7.a getSocialInfo() {
        return this.socialInfo;
    }

    public final String getThirdPartType() {
        return this.thirdPartType;
    }

    public final String getTpSource() {
        return this.tpSource;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateNewAccountDialog.initListener$lambda$0(CreateNewAccountDialog.this, view);
            }
        });
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateNewAccountDialog.initListener$lambda$1(CreateNewAccountDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((TextView) findViewById(R$id.mTvHint)).setText(getContext().getResources().getString(R.string.create_new_account_for_you));
        setCancelable(false);
    }

    public final CreateNewAccountDialog setCreateNewAccountCallback(ICreateNewAccountCallback iCreateNewAccountCallback) {
        t9.i.g(iCreateNewAccountCallback, "callback");
        this.mCreateNewAccountCallback = iCreateNewAccountCallback;
        return this;
    }

    public final void setSocialInfo(x7.a aVar) {
        t9.i.g(aVar, "<set-?>");
        this.socialInfo = aVar;
    }

    public final void setThirdPartType(String str) {
        t9.i.g(str, "<set-?>");
        this.thirdPartType = str;
    }

    public final void setTpSource(String str) {
        t9.i.g(str, "<set-?>");
        this.tpSource = str;
    }
}
