package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class BackButtonHandler {
    private View.OnClickListener listener;
    private ViewGroup viewGroup;

    public BackButtonHandler(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.viewGroup = viewGroup;
        this.listener = onClickListener;
    }

    public Boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        View.OnClickListener onClickListener = this.listener;
        if (onClickListener == null) {
            return Boolean.FALSE;
        }
        onClickListener.onClick(this.viewGroup);
        return Boolean.TRUE;
    }
}
