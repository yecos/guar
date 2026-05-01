package com.hpplay.component.netcore;

import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class LelinkNetCore {
    private int mHeight;
    private IMirrorStateListener mMirrorStateListener;
    private OnNetStateChangeCallback mOnNetStateChangeCallback;
    private int mWidth;

    static {
        System.loadLibrary("netcore");
    }

    public native int close();

    public native int connect(String str, int i10);

    public native int flush();

    public native int getInitBitrate();

    public native int init();

    public int onBitrateCallback(int i10) {
        CLog.i("MirrorDataSender", "callback bitrate " + i10);
        IMirrorStateListener iMirrorStateListener = this.mMirrorStateListener;
        if (iMirrorStateListener == null) {
            return 1;
        }
        iMirrorStateListener.onBitrateCallback(i10);
        return 1;
    }

    public int onEncoderControl(int i10) {
        CLog.i("MirrorDataSender", "onEncoderControl" + i10);
        if (i10 == 0) {
            this.mMirrorStateListener.onPauseEncode();
            return 1;
        }
        this.mMirrorStateListener.resetEncoder();
        return 1;
    }

    public int onFrameCallback(int i10) {
        CLog.i("MirrorDataSender", "callback frameRate " + i10);
        IMirrorStateListener iMirrorStateListener = this.mMirrorStateListener;
        if (iMirrorStateListener == null) {
            return 1;
        }
        iMirrorStateListener.onFrameCallback(i10);
        return 1;
    }

    public int onNetStateCallback(int i10) {
        CLog.i("LelinkNetCore", "onNetStateCallback state " + i10);
        return 1;
    }

    public int onResolutionCallback(int i10, int i11) {
        CLog.i("MirrorDataSender", "onResolutionCallback： " + i10 + "  height： " + i11);
        IMirrorStateListener iMirrorStateListener = this.mMirrorStateListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onResolutionCallback(i10, i11);
            if (this.mWidth > 0 && i10 != i11 && this.mHeight != i11) {
                this.mMirrorStateListener.resetEncoder();
            }
        }
        this.mWidth = i10;
        this.mHeight = i11;
        return 1;
    }

    public native int probeStart(String str, int i10);

    public native int probeStop();

    public native int recv(byte[] bArr, int i10);

    public native int send(byte[] bArr, int i10);

    public void setMirrorStateListener(IMirrorStateListener iMirrorStateListener) {
        this.mMirrorStateListener = iMirrorStateListener;
    }

    public void setNetStateChangeListener(OnNetStateChangeCallback onNetStateChangeCallback) {
        this.mOnNetStateChangeCallback = onNetStateChangeCallback;
    }

    public native int unInit();
}
