package com.hpplay.component.browse;

import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;

/* loaded from: classes2.dex */
public class DLNABrowse implements Runnable {
    private static final String TAG = "DLNABrowse";
    private boolean isStart;
    private Thread mThread;
    private final Object object = new Object();

    public String getErrorMsg() {
        try {
            Object callMethod = ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_GETERRORMSG, new Object[0]);
            if (callMethod != null) {
                return callMethod.toString();
            }
            return null;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return null;
        }
    }

    public synchronized void release() {
        CLog.i(TAG, hashCode() + " dlna browse  release ");
        this.isStart = false;
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_STOPBROWSE, new Object[0]);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_SETBROWSELISTENER, null);
        } catch (Exception e11) {
            CLog.w(TAG, e11);
        }
        Thread thread = this.mThread;
        if (thread != null) {
            thread.interrupt();
            this.mThread = null;
        }
        try {
            synchronized (this.object) {
                this.object.notify();
            }
        } catch (Exception e12) {
            CLog.w(TAG, e12);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        CLog.i(TAG, "-----------> start ");
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_STARTBROWSE, new Object[0]);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        while (this.isStart) {
            try {
                synchronized (this.object) {
                    try {
                        ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_SEARCH, new Object[0]);
                    } catch (Exception e11) {
                        CLog.w(TAG, e11);
                    }
                    this.object.wait(3000L);
                }
            } catch (InterruptedException e12) {
                CLog.w(TAG, e12);
                return;
            }
        }
    }

    public synchronized void startBrowse(IBrowseResultListener iBrowseResultListener) {
        Thread thread;
        CLog.i(TAG, hashCode() + " dlna  startBrowse ");
        if (this.isStart && (thread = this.mThread) != null && thread.isAlive()) {
            CLog.i(TAG, hashCode() + " mThread.isAlive ");
            release();
        }
        try {
            this.isStart = true;
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_SETBROWSELISTENER, iBrowseResultListener);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        Thread thread2 = new Thread(this);
        this.mThread = thread2;
        thread2.setName(TAG);
        this.mThread.start();
    }
}
