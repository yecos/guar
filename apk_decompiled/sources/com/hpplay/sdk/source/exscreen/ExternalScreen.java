package com.hpplay.sdk.source.exscreen;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class ExternalScreen extends Presentation {
    private static final String TAG = "ExternalScreen";
    public Activity mActivity;
    private IExternalScreenLifecycleListener mExternalScreenLifecycleListener;

    public interface IExternalScreenLifecycleListener {
        void onDestroy();

        void onResume();

        void onStop();
    }

    public ExternalScreen(Context context, Display display) {
        super(context, display);
        this.mActivity = (Activity) context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        if (isShowing()) {
            dismiss();
        }
        IExternalScreenLifecycleListener iExternalScreenLifecycleListener = this.mExternalScreenLifecycleListener;
        if (iExternalScreenLifecycleListener != null) {
            iExternalScreenLifecycleListener.onDestroy();
        }
    }

    @Override // android.app.Presentation
    public void onDisplayRemoved() {
        super.onDisplayRemoved();
        this.mActivity = null;
        SourceLog.i(TAG, "------- onDisplayRemoved ---- ");
    }

    public void onResume() {
        IExternalScreenLifecycleListener iExternalScreenLifecycleListener;
        Activity activity;
        if (!isShowing() && (activity = this.mActivity) != null && !activity.isFinishing() && !this.mActivity.isDestroyed()) {
            show();
        }
        if (Build.VERSION.SDK_INT >= 26 || (iExternalScreenLifecycleListener = this.mExternalScreenLifecycleListener) == null) {
            return;
        }
        iExternalScreenLifecycleListener.onResume();
    }

    @Override // android.app.Presentation, android.app.Dialog
    public void onStop() {
        if (Build.VERSION.SDK_INT < 26) {
            IExternalScreenLifecycleListener iExternalScreenLifecycleListener = this.mExternalScreenLifecycleListener;
            if (iExternalScreenLifecycleListener != null) {
                iExternalScreenLifecycleListener.onStop();
            }
            if (isShowing()) {
                dismiss();
            }
        }
    }

    public void setExternalScreenLifecycleListener(IExternalScreenLifecycleListener iExternalScreenLifecycleListener) {
        this.mExternalScreenLifecycleListener = iExternalScreenLifecycleListener;
    }

    public ExternalScreen(Context context, Display display, int i10) {
        super(context, display, i10);
        this.mActivity = (Activity) context;
    }
}
