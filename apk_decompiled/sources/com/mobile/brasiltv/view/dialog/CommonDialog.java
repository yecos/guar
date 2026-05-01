package com.mobile.brasiltv.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.q;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public abstract class CommonDialog extends Dialog {
    public /* synthetic */ CommonDialog(Context context, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? R.style.OptionDialog : i10);
    }

    public final void fullScreenImmersive(View view) {
        if (view == null) {
            return;
        }
        view.setSystemUiVisibility(5894);
    }

    public abstract int getDialogHeight();

    public abstract int getDialogWidth();

    public int getGravity() {
        return 17;
    }

    public abstract int getLayoutId();

    public final void hideBottomUI(Activity activity) {
        Window window;
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        if (decorView == null) {
            return;
        }
        decorView.setSystemUiVisibility(q.a.f10527g);
    }

    public abstract void initListener();

    public abstract void initView();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = getGravity();
            if (getDialogWidth() >= 0) {
                attributes.width = AutoUtils.getPercentWidthSize(getDialogWidth());
            } else {
                attributes.width = getDialogWidth();
            }
            if (getDialogHeight() >= 0) {
                attributes.height = AutoUtils.getPercentWidthSize(getDialogHeight());
            } else {
                attributes.height = getDialogHeight();
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        initView();
        initListener();
    }

    @Override // android.app.Dialog
    public void show() {
        if (!supportFSImmersive()) {
            super.show();
            return;
        }
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8);
        }
        super.show();
        Window window2 = getWindow();
        fullScreenImmersive(window2 != null ? window2.getDecorView() : null);
        Window window3 = getWindow();
        if (window3 != null) {
            window3.clearFlags(8);
        }
    }

    public boolean supportFSImmersive() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, int i10) {
        super(context, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }
}
