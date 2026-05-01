package com.bigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

/* loaded from: classes.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WheelView f6034a;

    public a(WheelView wheelView) {
        this.f6034a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1000) {
            this.f6034a.invalidate();
        } else if (i10 == 2000) {
            this.f6034a.h(WheelView.a.FLING);
        } else {
            if (i10 != 3000) {
                return;
            }
            this.f6034a.e();
        }
    }
}
