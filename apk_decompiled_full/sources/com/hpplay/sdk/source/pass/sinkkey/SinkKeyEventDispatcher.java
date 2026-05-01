package com.hpplay.sdk.source.pass.sinkkey;

import android.os.SystemClock;
import android.view.KeyEvent;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.browse.api.OptionCentral;

/* loaded from: classes3.dex */
public class SinkKeyEventDispatcher {
    private static final String TAG = "SinkKeyEventDispatcher";
    private static SinkKeyEventDispatcher sInstance;
    private long mDownTime = 0;
    private long mPreAction = 1;
    private int mRepeat = 0;
    private ISinkKeyEventListener mSinkKeyEventListener;

    private SinkKeyEventDispatcher() {
    }

    public static synchronized SinkKeyEventDispatcher getInstance() {
        SinkKeyEventDispatcher sinkKeyEventDispatcher;
        synchronized (SinkKeyEventDispatcher.class) {
            if (sInstance == null) {
                synchronized (SinkKeyEventDispatcher.class) {
                    if (sInstance == null) {
                        sInstance = new SinkKeyEventDispatcher();
                    }
                }
            }
            sinkKeyEventDispatcher = sInstance;
        }
        return sinkKeyEventDispatcher;
    }

    private boolean isNotRepeatUpAction(int i10) {
        return (this.mPreAction == 1 && i10 == 1) ? false : true;
    }

    private boolean isValidAction(int i10) {
        return (this.mPreAction == 0 && i10 == 0) ? false : true;
    }

    public void handleEvent(int i10, int i11) {
        long j10 = this.mPreAction;
        boolean z10 = false;
        if (j10 == 1 && i11 == 0) {
            this.mDownTime = SystemClock.uptimeMillis();
            this.mRepeat = 0;
        } else if (j10 == 0 && i11 == 0) {
            this.mRepeat++;
        }
        if (OptionCentral.RC_CONTROL_NO_FILTER || (isNotRepeatUpAction(i11) && isValidAction(i11))) {
            z10 = true;
        }
        if (this.mSinkKeyEventListener != null && z10) {
            this.mSinkKeyEventListener.onKeyEvent(i11 == 1 ? new KeyEvent(i11, i10) : new KeyEvent(this.mDownTime, SystemClock.uptimeMillis(), i11, i10, this.mRepeat));
        }
        this.mPreAction = i11;
    }

    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        this.mSinkKeyEventListener = iSinkKeyEventListener;
    }
}
