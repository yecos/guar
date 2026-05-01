package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.view.input.AccountInputView;
import com.mobile.brasiltv.view.input.IAccountInputCallback;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class InputPwdDialog extends CommonDialog {
    private s9.a mConfirmCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPwdDialog(Context context) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(InputPwdDialog inputPwdDialog, View view) {
        t9.i.g(inputPwdDialog, "this$0");
        inputPwdDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(InputPwdDialog inputPwdDialog, View view) {
        t9.i.g(inputPwdDialog, "this$0");
        Intent intent = new Intent(inputPwdDialog.getContext(), (Class<?>) ResetAty.class);
        intent.putExtra("need_x_button", true);
        intent.putExtra("bind_from", 2);
        intent.putExtra("bind_Type", "3");
        inputPwdDialog.getContext().startActivity(intent);
        inputPwdDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$2(InputPwdDialog inputPwdDialog, View view) {
        t9.i.g(inputPwdDialog, "this$0");
        s9.a aVar = inputPwdDialog.mConfirmCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 440;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 560;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_input_unbind_pwd;
    }

    public final String getPwd() {
        return ((AccountInputView) findViewById(R$id.mAivPwd)).getInputText();
    }

    public final void hideErrorHint() {
        ((TextView) findViewById(R$id.mTvErrorHint)).setText("");
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPwdDialog.initListener$lambda$0(InputPwdDialog.this, view);
            }
        });
        ((AccountInputView) findViewById(R$id.mAivPwd)).setAccountInputCallback(new IAccountInputCallback() { // from class: com.mobile.brasiltv.view.dialog.InputPwdDialog$initListener$2
            @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
            public void onInputFocused() {
                InputPwdDialog.this.hideErrorHint();
            }

            @Override // com.mobile.brasiltv.view.input.IAccountInputCallback
            public void onTextChanged(boolean z10) {
                ((TextView) InputPwdDialog.this.findViewById(R$id.mTvConfirm)).setEnabled(z10);
            }
        });
        ((TextView) findViewById(R$id.mTvForgetPwd)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPwdDialog.initListener$lambda$1(InputPwdDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPwdDialog.initListener$lambda$2(InputPwdDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        int i10 = R$id.mTvForgetPwd;
        ((TextView) findViewById(i10)).getPaint().setFlags(8);
        ((TextView) findViewById(i10)).getPaint().setAntiAlias(true);
        hideErrorHint();
    }

    public final InputPwdDialog setConfirmCallback(s9.a aVar) {
        t9.i.g(aVar, "callback");
        this.mConfirmCallback = aVar;
        return this;
    }

    public final void setErrorHint(String str) {
        t9.i.g(str, "hint");
        ((TextView) findViewById(R$id.mTvErrorHint)).setText(str);
    }
}
