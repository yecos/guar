package com.efs.sdk.base.core.d;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* loaded from: classes.dex */
public abstract class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public ControllerCenter f6177a;

    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    public abstract void a();

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
