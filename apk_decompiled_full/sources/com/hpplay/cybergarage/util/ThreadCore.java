package com.hpplay.cybergarage.util;

/* loaded from: classes2.dex */
public class ThreadCore implements Runnable {
    private Thread mThreadObject = null;

    public Thread getThreadObject() {
        return this.mThreadObject;
    }

    public boolean isRunnable() {
        return Thread.currentThread() == getThreadObject();
    }

    public void restart() {
        stop();
        start();
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    public void setThreadObject(Thread thread) {
        this.mThreadObject = thread;
    }

    public void start() {
        if (getThreadObject() == null) {
            Thread thread = new Thread(this, "Cyber.ThreadCore");
            setThreadObject(thread);
            thread.start();
        }
    }

    public void stop() {
        Thread threadObject = getThreadObject();
        if (threadObject != null) {
            threadObject.interrupt();
            setThreadObject(null);
        }
    }
}
