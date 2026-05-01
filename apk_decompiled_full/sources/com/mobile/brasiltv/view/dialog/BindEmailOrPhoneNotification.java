package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class BindEmailOrPhoneNotification extends CommonDialog {
    private Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindEmailOrPhoneNotification(Context context) {
        super(context, 0, 2, null);
        t9.i.g(context, "mContext");
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(BindEmailOrPhoneNotification bindEmailOrPhoneNotification, View view) {
        t9.i.g(bindEmailOrPhoneNotification, "this$0");
        bindEmailOrPhoneNotification.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(BindEmailOrPhoneNotification bindEmailOrPhoneNotification, View view) {
        t9.i.g(bindEmailOrPhoneNotification, "this$0");
        Context context = bindEmailOrPhoneNotification.mContext;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.c0((f5.c) context, EmailAty.class);
        bindEmailOrPhoneNotification.dismiss();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 460;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_notification_bind_email_or_phone;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindEmailOrPhoneNotification.initListener$lambda$0(BindEmailOrPhoneNotification.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvGotoBind)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindEmailOrPhoneNotification.initListener$lambda$1(BindEmailOrPhoneNotification.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
    }

    public final void setMContext(Context context) {
        t9.i.g(context, "<set-?>");
        this.mContext = context;
    }
}
