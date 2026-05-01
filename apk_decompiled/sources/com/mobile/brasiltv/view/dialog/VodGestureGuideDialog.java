package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class VodGestureGuideDialog extends Dialog {
    private s9.a mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodGestureGuideDialog(Context context) {
        super(context, R.style.guideDialgTheme);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void fullScreenImmersive(View view) {
        view.setSystemUiVisibility(5894);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(VodGestureGuideDialog vodGestureGuideDialog, DialogInterface dialogInterface) {
        t9.i.g(vodGestureGuideDialog, "this$0");
        GuideDialog.Companion.setMIsShowing(false);
        s9.a aVar = vodGestureGuideDialog.mListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(VodGestureGuideDialog vodGestureGuideDialog, View view) {
        t9.i.g(vodGestureGuideDialog, "this$0");
        vodGestureGuideDialog.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_guide_vod_gesture);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobile.brasiltv.view.dialog.l1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VodGestureGuideDialog.onCreate$lambda$0(VodGestureGuideDialog.this, dialogInterface);
            }
        });
        int i10 = R$id.ivGuide;
        ((ImageView) findViewById(i10)).setImageResource(R.drawable.intro_vod_full_screen);
        ((ImageView) findViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodGestureGuideDialog.onCreate$lambda$1(VodGestureGuideDialog.this, view);
            }
        });
    }

    public final void setOnButtonClickListener(s9.a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = aVar;
    }

    @Override // android.app.Dialog
    public void show() {
        View decorView;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8);
        }
        super.show();
        GuideDialog.Companion.setMIsShowing(true);
        Window window2 = getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            fullScreenImmersive(decorView);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.clearFlags(8);
        }
    }
}
