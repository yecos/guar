package com.hpplay.component.protocol.mirror;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class VideoDataSendStrategy extends Thread {
    private static final int MAX_DATA_CUMULATION = 60;
    private static final String TAG = "VideoDataSender";
    private boolean isQuit;
    private final AutoStrategy mAutoStrategy;
    private IMirrorStateListener mStrategyListener;
    private final BlockingQueue<ByteBuffer> mVideoDataQueue = new LinkedBlockingQueue(120);
    private VideoSender mVideoSender;
    private volatile long mWriteDataTimeMillis;

    public VideoDataSendStrategy(VideoSender videoSender, IMirrorStateListener iMirrorStateListener, int i10) {
        setName(TAG);
        this.mVideoSender = videoSender;
        this.mStrategyListener = iMirrorStateListener;
        videoSender.setMirrorStateListener(iMirrorStateListener);
        this.mAutoStrategy = new AutoStrategy(iMirrorStateListener, i10);
    }

    public int getWritTimeout() {
        if (this.mVideoDataQueue.size() > 0) {
            return (int) (System.currentTimeMillis() - this.mWriteDataTimeMillis);
        }
        return 0;
    }

    public boolean isQuit() {
        return this.isQuit;
    }

    public boolean isWriteTimeout() {
        return this.mVideoDataQueue.size() > 0 && System.currentTimeMillis() - this.mWriteDataTimeMillis > NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
    }

    public void putVideoData(ByteBuffer byteBuffer) {
        try {
            if (this.isQuit) {
                return;
            }
            this.mVideoDataQueue.offer(byteBuffer);
            AutoStrategy autoStrategy = this.mAutoStrategy;
            if (autoStrategy != null) {
                autoStrategy.videoBufferSizeCheck(this.mVideoDataQueue.size(), 60);
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.mWriteDataTimeMillis = System.currentTimeMillis();
            while (!this.isQuit) {
                ByteBuffer take = this.mVideoDataQueue.take();
                take.get(127);
                take.rewind();
                this.mWriteDataTimeMillis = System.currentTimeMillis();
                this.mVideoSender.sendData(take);
                try {
                    if (this.mAutoStrategy != null && this.mVideoSender.getSendType() == 2) {
                        this.mAutoStrategy.writeDelayCheck(this.mVideoDataQueue.size());
                    }
                } catch (Exception e10) {
                    CLog.w(TAG, e10);
                }
            }
        } catch (Exception e11) {
            CLog.w(TAG, e11);
            IMirrorStateListener iMirrorStateListener = this.mStrategyListener;
            if (iMirrorStateListener != null && !this.isQuit) {
                iMirrorStateListener.onBroken();
            }
        }
        stopTask();
    }

    public void setAutoBitrate(boolean z10) {
        AutoStrategy autoStrategy = this.mAutoStrategy;
        if (autoStrategy != null) {
            autoStrategy.setAutoBitrate(z10);
        }
    }

    public void stopTask() {
        interrupt();
        this.isQuit = true;
        CLog.i(TAG, "  send data  ------------>  stopTask ");
        this.mStrategyListener = null;
        this.mVideoSender = null;
        this.mVideoDataQueue.clear();
    }
}
