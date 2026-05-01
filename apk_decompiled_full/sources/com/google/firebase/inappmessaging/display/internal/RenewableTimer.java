package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class RenewableTimer {
    private CountDownTimer mCountDownTimer;

    public interface Callback {
        void onFinish();
    }

    @Inject
    public RenewableTimer() {
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }

    public void start(final Callback callback, long j10, long j11) {
        this.mCountDownTimer = new CountDownTimer(j10, j11) { // from class: com.google.firebase.inappmessaging.display.internal.RenewableTimer.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                callback.onFinish();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j12) {
            }
        }.start();
    }
}
