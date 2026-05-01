package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.VIPMemberActivity;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ServiceExpirationTipDialog extends BaseDialog {
    private String hintContent;
    private int remainingDays;

    public /* synthetic */ ServiceExpirationTipDialog(Context context, int i10, String str, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ServiceExpirationTipDialog serviceExpirationTipDialog, View view) {
        t9.i.g(serviceExpirationTipDialog, "this$0");
        com.mobile.brasiltv.utils.b0.j(serviceExpirationTipDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ServiceExpirationTipDialog serviceExpirationTipDialog, View view) {
        t9.i.g(serviceExpirationTipDialog, "this$0");
        Context context = serviceExpirationTipDialog.getContext();
        if (context != null) {
            context.startActivity(new Intent(serviceExpirationTipDialog.getContext(), (Class<?>) VIPMemberActivity.class));
        }
        com.mobile.brasiltv.utils.b0.j(serviceExpirationTipDialog);
    }

    public final String getHintContent() {
        return this.hintContent;
    }

    public final int getRemainingDays() {
        return this.remainingDays;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        com.mobile.brasiltv.utils.b0.j(this);
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_servie_expiration_tip);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(600);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        if (this.remainingDays == 0) {
            ((TextView) findViewById(R$id.tvContent)).setText(this.hintContent);
            ((TextView) findViewById(R$id.tvConfirm)).setText(R.string.be_a_vip);
        } else {
            TextView textView = (TextView) findViewById(R$id.tvContent);
            t9.z zVar = t9.z.f18964a;
            String format = String.format(this.hintContent, Arrays.copyOf(new Object[]{"<font color=\"#ff3333\">" + this.remainingDays + "</font>"}, 1));
            t9.i.f(format, "format(format, *args)");
            textView.setText(Html.fromHtml(format));
            ((TextView) findViewById(R$id.tvConfirm)).setText(R.string.renewal_now);
        }
        int i10 = R$id.tvCancel;
        ((TextView) findViewById(i10)).setText(R.string.cancel);
        ((TextView) findViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceExpirationTipDialog.onCreate$lambda$1(ServiceExpirationTipDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.tvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceExpirationTipDialog.onCreate$lambda$2(ServiceExpirationTipDialog.this, view);
            }
        });
        setCanceledOnTouchOutside(false);
    }

    public final void setHintContent(String str) {
        t9.i.g(str, "<set-?>");
        this.hintContent = str;
    }

    public final void setRemainingDays(int i10) {
        this.remainingDays = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceExpirationTipDialog(Context context, int i10, String str) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "hintContent");
        this.remainingDays = i10;
        this.hintContent = str;
    }
}
