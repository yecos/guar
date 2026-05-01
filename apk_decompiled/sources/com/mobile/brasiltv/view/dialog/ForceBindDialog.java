package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ForceBindDialog extends BaseDialog {
    private final s9.a bindCallback;
    private final Context context;
    private final s9.a loginCallback;
    private long mTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceBindDialog(Context context, s9.a aVar, s9.a aVar2) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(aVar, "loginCallback");
        t9.i.g(aVar2, "bindCallback");
        this.context = context;
        this.loginCallback = aVar;
        this.bindCallback = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ForceBindDialog forceBindDialog, View view) {
        t9.i.g(forceBindDialog, "this$0");
        forceBindDialog.loginCallback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ForceBindDialog forceBindDialog, View view) {
        t9.i.g(forceBindDialog, "this$0");
        forceBindDialog.bindCallback.invoke();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void closeForceBindEvent(CloseForceBindEvent closeForceBindEvent) {
        t9.i.g(closeForceBindEvent, "event");
        com.mobile.brasiltv.utils.b0.j(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.mTime > 2000) {
            com.mobile.brasiltv.utils.f1.f8649a.w(R.string.press_again_to_exits);
            this.mTime = System.currentTimeMillis();
            return;
        }
        Toast c10 = com.mobile.brasiltv.utils.f1.f8649a.c();
        if (c10 != null) {
            c10.cancel();
        }
        ma.l.a("forceBind");
        ma.h hVar = ma.h.f16853a;
        App.a aVar = App.f8263e;
        App a10 = aVar.a();
        String packageName = aVar.a().getPackageName();
        t9.i.f(packageName, "App.instance.getPackageName()");
        hVar.d(a10, packageName);
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_force_bind);
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
        ((TextView) findViewById(R$id.tvContentOne)).setText(Html.fromHtml(this.context.getString(R.string.force_bind_content_one)));
        ((TextView) findViewById(R$id.tvContentTwo)).setText(Html.fromHtml(this.context.getString(R.string.force_bind_content_two)));
        ((TextView) findViewById(R$id.tvLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceBindDialog.onCreate$lambda$1(ForceBindDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.tvBindNow)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceBindDialog.onCreate$lambda$2(ForceBindDialog.this, view);
            }
        });
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        xa.c.c().o(this);
    }
}
