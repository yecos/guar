package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ForceBindNormalDialog extends BaseDialog {
    private final s9.a callback;
    private final Context context;
    private int restDays;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceBindNormalDialog(Context context, int i10, s9.a aVar) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(aVar, "callback");
        this.context = context;
        this.restDays = i10;
        this.callback = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ForceBindNormalDialog forceBindNormalDialog, View view) {
        t9.i.g(forceBindNormalDialog, "this$0");
        com.mobile.brasiltv.utils.i1.z(forceBindNormalDialog.context);
        com.mobile.brasiltv.utils.b0.j(forceBindNormalDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ForceBindNormalDialog forceBindNormalDialog, View view) {
        t9.i.g(forceBindNormalDialog, "this$0");
        com.mobile.brasiltv.utils.b0.j(forceBindNormalDialog);
        forceBindNormalDialog.callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(ForceBindNormalDialog forceBindNormalDialog, View view) {
        t9.i.g(forceBindNormalDialog, "this$0");
        com.mobile.brasiltv.utils.b0.j(forceBindNormalDialog);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        com.mobile.brasiltv.utils.b0.j(this);
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_force_bind_normal);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(630);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        TextView textView = (TextView) findViewById(R$id.tvContentOne);
        t9.z zVar = t9.z.f18964a;
        String string = this.context.getString(R.string.force_bind_normal_content_one);
        t9.i.f(string, "context.getString(R.stri…_bind_normal_content_one)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.restDays)}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
        ((TextView) findViewById(R$id.tvContentTwo)).setText(Html.fromHtml(this.context.getString(R.string.force_bind_normal_content_two)));
        ((TextView) findViewById(R$id.tvBindLater)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceBindNormalDialog.onCreate$lambda$1(ForceBindNormalDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.tvBindNow)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceBindNormalDialog.onCreate$lambda$2(ForceBindNormalDialog.this, view);
            }
        });
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceBindNormalDialog.onCreate$lambda$3(ForceBindNormalDialog.this, view);
            }
        });
        setCanceledOnTouchOutside(false);
    }
}
