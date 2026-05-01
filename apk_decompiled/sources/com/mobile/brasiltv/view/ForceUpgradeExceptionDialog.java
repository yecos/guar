package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.bean.UpdateBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import w6.i;

/* loaded from: classes3.dex */
public class ForceUpgradeExceptionDialog extends Dialog {
    public ForceUpgradeExceptionDialog(Context context, UpdateBean updateBean) {
        super(context, R.style.OptionDialog);
        setContentView(R.layout.dialog_force_upgrade_exception);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(600);
            window.setAttributes(attributes);
        }
        TextView textView = (TextView) findViewById(R.id.dialog_content);
        KoocanButton koocanButton = (KoocanButton) findViewById(R.id.dialog_cancel);
        KoocanButton koocanButton2 = (KoocanButton) findViewById(R.id.dialog_submit);
        TextView textView2 = (TextView) findViewById(R.id.mTvContract);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(updateBean.getNote());
        i.c cVar = w6.i.f19214g;
        if (cVar.k().isEmpty()) {
            textView2.setText(context.getResources().getString(R.string.version_forbidden_upgrade_contract, context.getResources().getString(R.string.service_email_address)));
        } else {
            textView2.setText(context.getResources().getString(R.string.version_forbidden_upgrade_contract, cVar.k()));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        koocanButton.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceUpgradeExceptionDialog.lambda$new$0(view);
            }
        });
        koocanButton2.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceUpgradeExceptionDialog.this.lambda$new$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(View view) {
        com.mobile.brasiltv.utils.a.b().e();
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        dismiss();
    }
}
