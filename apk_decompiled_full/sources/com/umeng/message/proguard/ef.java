package com.umeng.message.proguard;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.umeng.message.proguard.eh;

/* loaded from: classes3.dex */
public final class ef extends eh {

    /* renamed from: a, reason: collision with root package name */
    private View.OnClickListener f12029a;

    public ef(Context context) {
        super(context);
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean bool;
        if (this.f12029a != null) {
            if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                View.OnClickListener onClickListener = this.f12029a;
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

    @Override // com.umeng.message.proguard.eh
    public final eh.a getOnStatusListener() {
        return super.getOnStatusListener();
    }

    public final void setDismissListener(View.OnClickListener onClickListener) {
        this.f12029a = onClickListener;
    }
}
