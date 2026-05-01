package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class LoginTpFailDialog extends CommonDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginTpFailDialog(Context context) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(LoginTpFailDialog loginTpFailDialog, View view) {
        t9.i.g(loginTpFailDialog, "this$0");
        loginTpFailDialog.dismiss();
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
        return R.layout.dialog_login_tp_fail;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginTpFailDialog.initListener$lambda$0(LoginTpFailDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        setCancelable(false);
    }
}
