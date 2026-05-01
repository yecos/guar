package com.hpplay.sdk.source.bean;

/* loaded from: classes3.dex */
public class DebugTimestampInfoBean {
    private long mCaptureTS;
    private long mEncodeTime;
    private long mSendTime;
    private int mSerial;

    public long getCaptureTS() {
        return this.mCaptureTS;
    }

    public long getEncodeTime() {
        return this.mEncodeTime;
    }

    public long getSendTime() {
        return this.mSendTime;
    }

    public int getSerial() {
        return this.mSerial;
    }

    public void setCaptureTS(long j10) {
        this.mCaptureTS = j10;
    }

    public void setEncodeTime(long j10) {
        this.mEncodeTime = j10;
    }

    public void setSendTime(long j10) {
        this.mSendTime = j10;
    }

    public void setSerial(int i10) {
        this.mSerial = i10;
    }
}
