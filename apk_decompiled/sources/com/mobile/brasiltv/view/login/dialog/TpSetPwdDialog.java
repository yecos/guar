package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class TpSetPwdDialog extends CommonDialog {
    private ISetPasswordCallback mSetPasswordCallback;
    private x7.a socialInfo;
    private String thirdPartType;
    private String tpSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TpSetPwdDialog(Context context, String str, String str2, x7.a aVar) {
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
    public static final void initListener$lambda$0(TpSetPwdDialog tpSetPwdDialog, View view) {
        t9.i.g(tpSetPwdDialog, "this$0");
        ISetPasswordCallback iSetPasswordCallback = tpSetPwdDialog.mSetPasswordCallback;
        if (iSetPasswordCallback != null) {
            iSetPasswordCallback.dialogRevokeAccessGoogle();
        }
        tpSetPwdDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(TpSetPwdDialog tpSetPwdDialog, View view) {
        t9.i.g(tpSetPwdDialog, "this$0");
        int i10 = R$id.mEditPassword;
        if (b0.J(((EditText) tpSetPwdDialog.findViewById(i10)).getText())) {
            int i11 = R$id.mTvError;
            ((TextView) tpSetPwdDialog.findViewById(i11)).setVisibility(0);
            ((TextView) tpSetPwdDialog.findViewById(i11)).setText(R.string.enter_password_hint);
        } else if (!j1.f(((EditText) tpSetPwdDialog.findViewById(i10)).getText().toString())) {
            int i12 = R$id.mTvError;
            ((TextView) tpSetPwdDialog.findViewById(i12)).setVisibility(0);
            ((TextView) tpSetPwdDialog.findViewById(i12)).setText(R.string.google_set_password_error);
        } else {
            ISetPasswordCallback iSetPasswordCallback = tpSetPwdDialog.mSetPasswordCallback;
            if (iSetPasswordCallback != null) {
                iSetPasswordCallback.setPasswordAndBind(tpSetPwdDialog.thirdPartType, tpSetPwdDialog.tpSource, tpSetPwdDialog.socialInfo, ((EditText) tpSetPwdDialog.findViewById(i10)).getText().toString());
            }
            tpSetPwdDialog.dismiss();
        }
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
        return R.layout.dialog_tp_set_pwd;
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
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TpSetPwdDialog.initListener$lambda$0(TpSetPwdDialog.this, view);
            }
        });
        ((EditText) findViewById(R$id.mEditPassword)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.login.dialog.TpSetPwdDialog$initListener$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                ((TextView) TpSetPwdDialog.this.findViewById(R$id.mTvError)).setVisibility(8);
            }
        });
        ((KoocanButton) findViewById(R$id.mKbConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TpSetPwdDialog.initListener$lambda$1(TpSetPwdDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        setCancelable(false);
    }

    public final TpSetPwdDialog setSetPasswordCallback(ISetPasswordCallback iSetPasswordCallback) {
        t9.i.g(iSetPasswordCallback, "callback");
        this.mSetPasswordCallback = iSetPasswordCallback;
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
