package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import java.util.Arrays;
import t9.z;

/* loaded from: classes3.dex */
public final class GoogleEmailRegisteredDialog extends CommonDialog {
    private String email;
    private IBindThirdPartCallback mBindThirdPartCallback;

    public interface IBindThirdPartCallback {
        void dialogRevokeAccessGoogle();

        void onBindThirdPart();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleEmailRegisteredDialog(Context context, String str) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, Scopes.EMAIL);
        this.email = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(GoogleEmailRegisteredDialog googleEmailRegisteredDialog, View view) {
        t9.i.g(googleEmailRegisteredDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = googleEmailRegisteredDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.dialogRevokeAccessGoogle();
        }
        googleEmailRegisteredDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(GoogleEmailRegisteredDialog googleEmailRegisteredDialog, View view) {
        t9.i.g(googleEmailRegisteredDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = googleEmailRegisteredDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.onBindThirdPart();
        }
        googleEmailRegisteredDialog.dismiss();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return -2;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    public final String getEmail() {
        return this.email;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_google_email_registered;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoogleEmailRegisteredDialog.initListener$lambda$0(GoogleEmailRegisteredDialog.this, view);
            }
        });
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoogleEmailRegisteredDialog.initListener$lambda$1(GoogleEmailRegisteredDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        TextView textView = (TextView) findViewById(R$id.mTvContent);
        z zVar = z.f18964a;
        String string = getContext().getResources().getString(R.string.google_email_has_registered);
        t9.i.f(string, "context.resources.getStr…gle_email_has_registered)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.email}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(format);
        setCancelable(false);
    }

    public final GoogleEmailRegisteredDialog setBindThirdPartCallback(IBindThirdPartCallback iBindThirdPartCallback) {
        t9.i.g(iBindThirdPartCallback, "callback");
        this.mBindThirdPartCallback = iBindThirdPartCallback;
        return this;
    }

    public final void setEmail(String str) {
        t9.i.g(str, "<set-?>");
        this.email = str;
    }
}
