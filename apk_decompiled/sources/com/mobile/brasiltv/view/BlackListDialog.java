package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.SetLoginAtySelectTabEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class BlackListDialog extends Dialog {
    private boolean mNeedManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListDialog(final Context context, String str, boolean z10) {
        super(context, R.style.OptionDialog);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "userId");
        this.mNeedManager = z10;
        setContentView(R.layout.dialog_black_list);
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
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) findViewById(R.id.tv_id);
            textView.setVisibility(0);
            textView.setText(context.getString(R.string.black_list_id, str));
        }
        ((KoocanButton) findViewById(R.id.kb_login_other)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlackListDialog._init_$lambda$1(context, view);
            }
        });
        setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Context context, View view) {
        t9.i.g(context, "$context");
        if (t9.i.b("LoginAty", ma.b.f16848a.c().getClass().getSimpleName())) {
            xa.c.c().j(new SetLoginAtySelectTabEvent(1));
        }
        context.startActivity(new Intent(context, (Class<?>) LoginAty.class));
    }

    public final boolean getMNeedManager() {
        return this.mNeedManager;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void loginSuccess(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        if (this.mNeedManager) {
            com.mobile.brasiltv.utils.b0.j(this);
        } else {
            dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xa.c.c().o(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xa.c.c().r(this);
    }

    public final void setMNeedManager(boolean z10) {
        this.mNeedManager = z10;
    }
}
