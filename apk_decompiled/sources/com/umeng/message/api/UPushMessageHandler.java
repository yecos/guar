package com.umeng.message.api;

import android.content.Context;
import com.umeng.message.entity.UMessage;

/* loaded from: classes.dex */
public interface UPushMessageHandler {
    void handleMessage(Context context, UMessage uMessage);
}
