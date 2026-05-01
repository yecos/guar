package com.hpplay.cybergarage.util;

import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class Mutex {
    private static final String TAG = "Cyber-Mutex";
    private boolean syncLock = false;

    public synchronized void lock() {
        while (this.syncLock) {
            try {
                wait();
            } catch (Exception e10) {
                CLog.d(TAG, null, e10);
            }
        }
        this.syncLock = true;
    }

    public synchronized void unlock() {
        this.syncLock = false;
        notifyAll();
    }
}
