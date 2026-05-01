package com.hpplay.sdk.source.bean;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class DebugTimestampBean {
    private ConcurrentHashMap<Integer, DebugTimestampInfoBean> mAudioTSFrames;
    private ConcurrentHashMap<Integer, DebugTimestampInfoBean> mVideoTSFrames;
    public AtomicInteger audioWriteSerial = new AtomicInteger();
    public AtomicInteger videoWriteSerial = new AtomicInteger();
    public AtomicInteger audioReadSerial = new AtomicInteger(1);
    public AtomicInteger videoReadSerial = new AtomicInteger(1);

    public DebugTimestampBean() {
        this.mAudioTSFrames = null;
        this.mVideoTSFrames = null;
        this.mAudioTSFrames = new ConcurrentHashMap<>();
        this.mVideoTSFrames = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Integer, DebugTimestampInfoBean> getAudioTSFrames() {
        return this.mAudioTSFrames;
    }

    public ConcurrentHashMap<Integer, DebugTimestampInfoBean> getVideoTSFrames() {
        return this.mVideoTSFrames;
    }
}
