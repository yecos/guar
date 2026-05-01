package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class OpenNotifyDialog extends Dialog {
    private final Context mContext;
    private final Handler mHandler;
    private final NotificationListener mListener;

    public interface NotificationListener {
        void onOpen(Dialog dialog);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenNotifyDialog(Context context, NotificationListener notificationListener) {
        super(context, R.style.OptionDialog);
        t9.i.g(context, "mContext");
        t9.i.g(notificationListener, "mListener");
        this.mContext = context;
        this.mListener = notificationListener;
        this.mHandler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.dialog_open_notify);
        ((KoocanButton) findViewById(R$id.mKbTurnedOn)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenNotifyDialog._init_$lambda$0(OpenNotifyDialog.this, view);
            }
        });
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenNotifyDialog._init_$lambda$1(OpenNotifyDialog.this, view);
            }
        });
        setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(OpenNotifyDialog openNotifyDialog, View view) {
        t9.i.g(openNotifyDialog, "this$0");
        q5.i.f18197a.l(openNotifyDialog.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(OpenNotifyDialog openNotifyDialog, View view) {
        t9.i.g(openNotifyDialog, "this$0");
        openNotifyDialog.mListener.onOpen(openNotifyDialog);
        openNotifyDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onWindowFocusChanged$lambda$2(OpenNotifyDialog openNotifyDialog) {
        t9.i.g(openNotifyDialog, "this$0");
        openNotifyDialog.mListener.onOpen(openNotifyDialog);
        openNotifyDialog.dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && q5.i.f18197a.j(this.mContext)) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.mobile.brasiltv.view.b0
                @Override // java.lang.Runnable
                public final void run() {
                    OpenNotifyDialog.onWindowFocusChanged$lambda$2(OpenNotifyDialog.this);
                }
            }, 600L);
        }
    }
}
