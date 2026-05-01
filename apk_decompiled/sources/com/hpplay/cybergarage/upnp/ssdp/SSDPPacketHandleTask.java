package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.upnp.ControlPoint;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class SSDPPacketHandleTask extends Thread {
    private static final int MAX_POOL_SIZE = 5;
    private static final String TAG = "SSDPPacketHandleTask";
    private ControlPoint mControlPoint;
    private LocationCacheHandleTask mLocationCacheHandleTask;
    private ThreadPoolExecutor mThreadPoolExecutor;
    private BlockingQueue<SSDPPacket> ssdpPackets = new LinkedBlockingQueue(20);
    private AtomicBoolean isQuit = new AtomicBoolean();

    public SSDPPacketHandleTask(ControlPoint controlPoint) {
        this.mControlPoint = controlPoint;
        LocationCacheHandleTask locationCacheHandleTask = new LocationCacheHandleTask(controlPoint);
        this.mLocationCacheHandleTask = locationCacheHandleTask;
        locationCacheHandleTask.start();
        this.mThreadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public boolean isQuit() {
        return this.isQuit.get();
    }

    public void release() {
        CLog.i(TAG, "  SSDPPacketHandleTask release " + hashCode());
        this.isQuit.set(true);
        interrupt();
        this.mControlPoint = null;
        this.ssdpPackets.clear();
        this.mThreadPoolExecutor.shutdownNow();
        LocationCacheHandleTask locationCacheHandleTask = this.mLocationCacheHandleTask;
        if (locationCacheHandleTask != null) {
            locationCacheHandleTask.release();
            this.mLocationCacheHandleTask = null;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.isQuit.set(false);
        CLog.w(TAG, " start ssdp packet handle " + hashCode());
        while (!this.isQuit.get() && !isInterrupted()) {
            try {
                SSDPPacket take = this.ssdpPackets.take();
                if (take.isRootDevice()) {
                    this.mThreadPoolExecutor.execute(new DescHandler(take, this.mControlPoint));
                }
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        CLog.i(TAG, "  SSDPPacketHandleTask exit");
        this.isQuit.set(true);
    }

    public synchronized void updateSSDPPacket(SSDPPacket sSDPPacket) {
        CLog.w(TAG, " updateSSDPPacket " + hashCode());
        this.ssdpPackets.offer(sSDPPacket);
    }
}
