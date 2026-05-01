package com.umeng.message.api;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ak;
import com.umeng.message.proguard.u;

/* loaded from: classes3.dex */
public class UPushInAppMessageHandler {
    public boolean canShowMessage(Context context, UMessage uMessage) {
        return true;
    }

    public final void dismiss() {
        ak.a().a(u.d());
    }

    public View getView(Context context, UMessage uMessage, FrameLayout.LayoutParams layoutParams) {
        return null;
    }

    public boolean isOnlyShowLatestMessage() {
        return false;
    }

    public void onMessageIgnored(Context context, UMessage uMessage) {
    }
}
