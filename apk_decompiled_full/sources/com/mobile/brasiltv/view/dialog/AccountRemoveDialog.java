package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class AccountRemoveDialog extends BaseDialog {
    private final String mAccount;
    private final s9.a mCancelListener;
    private final s9.a mRemoveListener;

    public /* synthetic */ AccountRemoveDialog(Context context, String str, s9.a aVar, s9.a aVar2, int i10, t9.g gVar) {
        this(context, str, (i10 & 4) != 0 ? null : aVar, (i10 & 8) != 0 ? null : aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(AccountRemoveDialog accountRemoveDialog, View view) {
        t9.i.g(accountRemoveDialog, "this$0");
        accountRemoveDialog.dismiss();
        s9.a aVar = accountRemoveDialog.mCancelListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(AccountRemoveDialog accountRemoveDialog, View view) {
        t9.i.g(accountRemoveDialog, "this$0");
        accountRemoveDialog.dismiss();
        s9.a aVar = accountRemoveDialog.mRemoveListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(AccountRemoveDialog accountRemoveDialog, DialogInterface dialogInterface) {
        t9.i.g(accountRemoveDialog, "this$0");
        s9.a aVar = accountRemoveDialog.mCancelListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_account_remove);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountRemoveDialog.onCreate$lambda$0(AccountRemoveDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvAccount)).setText(this.mAccount);
        ((TextView) findViewById(R$id.mTvRemove)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountRemoveDialog.onCreate$lambda$1(AccountRemoveDialog.this, view);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.mobile.brasiltv.view.dialog.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AccountRemoveDialog.onCreate$lambda$2(AccountRemoveDialog.this, dialogInterface);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountRemoveDialog(Context context, String str, s9.a aVar, s9.a aVar2) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "mAccount");
        this.mAccount = str;
        this.mRemoveListener = aVar;
        this.mCancelListener = aVar2;
    }
}
