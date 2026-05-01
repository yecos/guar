package com.hpplay.sdk.source.pass.sinktouch;

import android.view.MotionEvent;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;

/* loaded from: classes3.dex */
public class SinkTouchEventDispatcher {
    private static SinkTouchEventDispatcher sInstance;
    public ISinkTouchEventListener mListener;

    private SinkTouchEventDispatcher() {
    }

    public static synchronized SinkTouchEventDispatcher getInstance() {
        SinkTouchEventDispatcher sinkTouchEventDispatcher;
        synchronized (SinkTouchEventDispatcher.class) {
            if (sInstance == null) {
                synchronized (SinkTouchEventDispatcher.class) {
                    if (sInstance == null) {
                        sInstance = new SinkTouchEventDispatcher();
                    }
                }
            }
            sinkTouchEventDispatcher = sInstance;
        }
        return sinkTouchEventDispatcher;
    }

    public boolean canNotify() {
        return this.mListener != null;
    }

    public void notifyTouchEvent(MotionEvent motionEvent) {
        if (canNotify()) {
            this.mListener.onTouchEvent(motionEvent);
        }
    }

    public void setSinkTouchEventListener(ISinkTouchEventListener iSinkTouchEventListener) {
        this.mListener = iSinkTouchEventListener;
    }
}
