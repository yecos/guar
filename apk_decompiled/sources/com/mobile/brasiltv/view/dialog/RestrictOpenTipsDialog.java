package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.GotoCREvent;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class RestrictOpenTipsDialog extends BaseDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestrictOpenTipsDialog(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(RestrictOpenTipsDialog restrictOpenTipsDialog, View view) {
        t9.i.g(restrictOpenTipsDialog, "this$0");
        restrictOpenTipsDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(RestrictOpenTipsDialog restrictOpenTipsDialog, View view) {
        t9.i.g(restrictOpenTipsDialog, "this$0");
        xa.c.c().j(new GotoCREvent());
        restrictOpenTipsDialog.dismiss();
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_restrict_open_tips);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        ((TextView) findViewById(R$id.tvCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestrictOpenTipsDialog.onCreate$lambda$1(RestrictOpenTipsDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.tvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestrictOpenTipsDialog.onCreate$lambda$2(RestrictOpenTipsDialog.this, view);
            }
        });
    }
}
