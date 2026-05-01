package com.umeng.message.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class cw extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f11848a;

    public cw(AtomicBoolean atomicBoolean) {
        this.f11848a = atomicBoolean;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.f11848a.set(true);
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f11848a.set(false);
        }
    }
}
