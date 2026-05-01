package com.umeng.message.proguard;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.common.UPLog;

/* loaded from: classes3.dex */
public final class at extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private View.OnClickListener f11561a;

    /* renamed from: b, reason: collision with root package name */
    private final ap f11562b;

    public at(Context context, ap apVar) {
        super(context);
        setLayerType(1, null);
        this.f11562b = apVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean bool;
        if (this.f11561a != null) {
            if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                View.OnClickListener onClickListener = this.f11561a;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            UPLog.i("Pop", "attach", this.f11562b.f11535a.getMsgId());
            UTrack.getInstance().trackInAppNotifyShow(this.f11562b.f11535a);
            UPushInAppMessageCallback inAppMessageCallback = v.a().getInAppMessageCallback();
            if (inAppMessageCallback != null) {
                inAppMessageCallback.onShow(y.a(), this.f11562b.f11535a);
            }
        } catch (Throwable th) {
            UPLog.e("Pop", "onAttachedToWindow", th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            UPLog.i("Pop", "detach", this.f11562b.f11535a.getMsgId());
            UPushInAppMessageCallback inAppMessageCallback = v.a().getInAppMessageCallback();
            if (inAppMessageCallback != null) {
                inAppMessageCallback.onDismiss(y.a(), this.f11562b.f11535a);
            }
        } catch (Throwable th) {
            UPLog.e("Pop", "onDetachedFromWindow", th);
        }
    }

    public final void setDismissListener(View.OnClickListener onClickListener) {
        this.f11561a = onClickListener;
    }
}
