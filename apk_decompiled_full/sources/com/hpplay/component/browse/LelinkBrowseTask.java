package com.hpplay.component.browse;

import com.hpplay.component.common.utils.CLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class LelinkBrowseTask extends LelinkBrowseCore implements Runnable {
    private static final String TAG = "LelinkBrowseTask";
    long releasestart;
    private AtomicBoolean isScaning = new AtomicBoolean();
    private int count = 1;
    private final Object mLock = new Object();

    public boolean isScaning() {
        return this.isScaning.get();
    }

    public void releae() {
        CLog.i(TAG, " releae");
        this.releasestart = System.currentTimeMillis();
        this.isScaning.set(false);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.isScaning.set(true);
        int i10 = 10;
        while (this.isScaning.get()) {
            try {
                sendBrowseData(LelinkBrowseCore.BROWSE_PORT);
                int i11 = this.count;
                if (i11 > 60) {
                    break;
                }
                this.count = i11 + 1;
                if (this.isScaning.get()) {
                    synchronized (this.mLock) {
                        this.mLock.wait(this.count * i10);
                    }
                }
                if (i10 < 1000 && (i10 = i10 + (i10 * 2)) > 1000) {
                    i10 = 1000;
                }
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        closeBrowseBroadCast();
        CLog.i(TAG, " stop time " + (System.currentTimeMillis() - this.releasestart));
        CLog.i(TAG, "exit the search thread");
    }
}
