package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class SimpleDialog extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDialog(Context context) {
        super(context, R.style.SimpleDialog);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        setContentView(R.layout.dialog_simple);
        ((TextView) findViewById(R$id.mButtonOK)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleDialog._init_$lambda$0(SimpleDialog.this, view);
            }
        });
        setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SimpleDialog simpleDialog, View view) {
        t9.i.g(simpleDialog, "this$0");
        simpleDialog.cancel();
    }

    public final void setMessage(int i10) {
        ((TextView) findViewById(R$id.mTextMessage)).setText(getContext().getResources().getString(i10));
    }
}
