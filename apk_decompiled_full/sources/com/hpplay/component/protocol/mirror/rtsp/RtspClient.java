package com.hpplay.component.protocol.mirror.rtsp;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.encrypt.MirrorFrameEcrypto;
import com.hpplay.component.protocol.mirror.VideoSender;

/* loaded from: classes2.dex */
public abstract class RtspClient {
    public static final int STATE_ENCRYPT_FAILED = 11;
    public static final int STATE_ERROR_CODE = 0;
    public static final int STATE_NEED_SCREEN_CODE = 10;
    public static final int STATE_SUCCESS_CODE = 1;
    public static final int STATE_UNSUPPORT_FORBIDDEN = 13;
    public static final int STATE_UNSUPPORT_PREEMPT = 12;
    public String mAst;
    public String mErrorMsg;
    public int mHeight;
    public int mIDHeight;
    public int mIDWidth;
    public MirrorFrameEcrypto mMirrorFrameEcrypto;
    public int mTvHeight;
    public int mTvWidth;
    public int mWidth;
    public String mEncodeType = ParamsMap.MirrorParams.ENCODE_TYPE_H264;
    public int mBitrate = 9437184;

    public void adjustScreenSize() {
        int i10 = this.mTvWidth;
        this.mWidth = i10;
        int i11 = this.mTvHeight;
        this.mHeight = i11;
        if (i11 > i10) {
            i10 = i11;
        }
        int i12 = this.mIDHeight;
        int i13 = this.mIDWidth;
        if (i10 > (i13 > i12 ? i13 : i12)) {
            if (i12 > i13) {
                this.mWidth = i12;
                this.mHeight = i13;
            } else {
                this.mWidth = i13;
                this.mHeight = i12;
            }
        } else if (i10 == 1280) {
            this.mWidth = 1280;
            this.mHeight = 720;
        } else if (i10 == 1920) {
            this.mWidth = 1920;
            this.mHeight = 1080;
        } else if (i12 > i13) {
            this.mWidth = i12;
            this.mHeight = i13;
        } else {
            this.mWidth = i13;
            this.mHeight = i12;
        }
        this.mTvWidth = this.mWidth;
        this.mTvHeight = this.mHeight;
    }

    public abstract int exeLelinkRtsp(boolean z10, String... strArr);

    public String getAudioChannelType() {
        return this.mAst;
    }

    public abstract int getAudioPort();

    public abstract String getAudioServerIp();

    public abstract int getBitRate();

    public abstract String getEncodeType();

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public abstract double getRefreshRate();

    public abstract int getSinkHeight();

    public abstract int getSinkWidth();

    public abstract int getTvHeight();

    public abstract int getTvWidth();

    public abstract VideoSender getVideoDataSender();

    public abstract boolean isEncrypt();

    public abstract void release();

    public abstract boolean sendRequestAnnounce();

    public abstract boolean sendRequestAudioSetup();

    public abstract int sendRequestGetMirrorInfo();

    public abstract boolean sendRequestGetMirrorPort();

    public abstract boolean sendRequestGetParamter();

    public abstract boolean sendRequestRecord();

    public abstract boolean sendRequestSetOptions();

    public abstract boolean sendRequestSetParamter();

    public abstract boolean sendRequestSetTeardown();

    public abstract int sendRequestVideoSetup(int i10, int i11);

    public abstract boolean setMirrorMode(String str);

    public abstract void setSinkHeight(int i10);

    public abstract void setSinkWidth(int i10);
}
