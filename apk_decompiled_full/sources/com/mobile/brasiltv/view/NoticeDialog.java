package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class NoticeDialog extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeDialog(Context context, String str) {
        super(context, R.style.OptionDialog);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "noticeInfo");
        setContentView(R.layout.dialog_notice);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(560);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        int i10 = R$id.dialogContent;
        ((TextView) findViewById(i10)).setMovementMethod(ScrollingMovementMethod.getInstance());
        ((TextView) findViewById(i10)).setScrollbarFadingEnabled(false);
        ((TextView) findViewById(i10)).setText(str);
        setCanceledOnTouchOutside(false);
        ((Button) findViewById(R$id.dialogClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoticeDialog._init_$lambda$1(NoticeDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(NoticeDialog noticeDialog, View view) {
        t9.i.g(noticeDialog, "this$0");
        com.mobile.brasiltv.utils.b0.j(noticeDialog);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        com.mobile.brasiltv.utils.b0.j(this);
    }
}
