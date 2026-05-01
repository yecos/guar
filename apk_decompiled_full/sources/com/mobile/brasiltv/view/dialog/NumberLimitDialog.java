package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class NumberLimitDialog extends BaseDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberLimitDialog(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(NumberLimitDialog numberLimitDialog, View view) {
        t9.i.g(numberLimitDialog, "this$0");
        numberLimitDialog.dismiss();
        Intent intent = new Intent(numberLimitDialog.getContext(), (Class<?>) LoginAty.class);
        intent.putExtra("can_back", false);
        numberLimitDialog.getContext().startActivity(intent);
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_number_limit);
        setCancelable(false);
        ((TextView) findViewById(R$id.mReLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumberLimitDialog.onCreate$lambda$0(NumberLimitDialog.this, view);
            }
        });
    }
}
