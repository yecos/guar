package com.hpplay.sdk.source.browse.api;

import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.VideoFrameBean;

/* loaded from: classes3.dex */
public class OptionCentral {
    public static int NOTIFICATION_PID = 0;
    public static boolean RC_CONTROL_NO_FILTER = false;
    public static boolean SET_DLNA_CUSTOM_IDS = true;
    public static String disPlayName = null;
    private static boolean isEnableExternalAudio = false;
    private static boolean isExternalVideo = false;
    public static boolean isOptBitrate = false;
    public static boolean isOptionalCapture = false;
    private static boolean isRegisterSinkKeyEvent = false;
    private static boolean isRegisterSinkTouchEvent = false;
    private static int mHeight;
    private static OnVideoUpdateListener mVideoListener;
    private static int mWidth;
    private static OnExternalAudioStateChangedListener onExternalAudioStateChangedListener;
    private static OnPCMUpdateListener onPCMUpdateListener;
    private static OnSinkKeyEventRegisterListener onSinkKeyEventRegisterListener;
    private static OnSinkTouchEventRegisterListener onSinkTouchEventRegisterListener;

    public interface OnExternalAudioStateChangedListener {
        void onStateChanged(boolean z10);
    }

    public interface OnPCMUpdateListener {
        void onAudioUpdate(byte[] bArr, AudioFrameBean audioFrameBean);
    }

    public interface OnSinkKeyEventRegisterListener {
        void onRegister();

        void onUnregister();
    }

    public interface OnSinkTouchEventRegisterListener {
        void onRegister();

        void onUnregister();
    }

    public interface OnVideoUpdateListener {
        void onVideoUpdate(byte[] bArr, VideoFrameBean videoFrameBean);
    }

    public static void changeExternalAudioState(boolean z10) {
        isEnableExternalAudio = z10;
        OnExternalAudioStateChangedListener onExternalAudioStateChangedListener2 = onExternalAudioStateChangedListener;
        if (onExternalAudioStateChangedListener2 != null) {
            onExternalAudioStateChangedListener2.onStateChanged(z10);
        }
    }

    public static int[] getResolution() {
        return new int[]{mWidth, mHeight};
    }

    public static boolean isEnableExternalAudio() {
        return isEnableExternalAudio;
    }

    public static boolean isExternalVideo() {
        return isExternalVideo;
    }

    public static boolean isRegistSinkTouchEvent() {
        return isRegisterSinkTouchEvent;
    }

    public static boolean isRegisterSinkKeyEvent() {
        return isRegisterSinkKeyEvent;
    }

    public static void registerOrUnregisterSinkKeyEvent(boolean z10) {
        isRegisterSinkKeyEvent = z10;
        OnSinkKeyEventRegisterListener onSinkKeyEventRegisterListener2 = onSinkKeyEventRegisterListener;
        if (onSinkKeyEventRegisterListener2 != null) {
            if (z10) {
                onSinkKeyEventRegisterListener2.onRegister();
            } else {
                onSinkKeyEventRegisterListener2.onUnregister();
            }
        }
    }

    public static void registerOrUnregisterSinkTouchEvent(boolean z10) {
        isRegisterSinkTouchEvent = z10;
        OnSinkTouchEventRegisterListener onSinkTouchEventRegisterListener2 = onSinkTouchEventRegisterListener;
        if (onSinkTouchEventRegisterListener2 != null) {
            if (z10) {
                onSinkTouchEventRegisterListener2.onRegister();
            } else {
                onSinkTouchEventRegisterListener2.onUnregister();
            }
        }
    }

    public static void setExternalVideo(boolean z10) {
        isExternalVideo = z10;
    }

    public static void setOnExternalAudioStateChangedListener(OnExternalAudioStateChangedListener onExternalAudioStateChangedListener2) {
        onExternalAudioStateChangedListener = onExternalAudioStateChangedListener2;
    }

    public static void setOnPCMUpdateListener(OnPCMUpdateListener onPCMUpdateListener2) {
        onPCMUpdateListener = onPCMUpdateListener2;
    }

    public static void setOnSinkKeyEventRegisterListener(OnSinkKeyEventRegisterListener onSinkKeyEventRegisterListener2) {
        onSinkKeyEventRegisterListener = onSinkKeyEventRegisterListener2;
    }

    public static void setOnSinkTouchEventRegisterListener(OnSinkTouchEventRegisterListener onSinkTouchEventRegisterListener2) {
        onSinkTouchEventRegisterListener = onSinkTouchEventRegisterListener2;
    }

    public static void setOnVideoUpdateListener(OnVideoUpdateListener onVideoUpdateListener) {
        mVideoListener = onVideoUpdateListener;
    }

    public static void setResolution(int i10, int i11) {
        mWidth = i10;
        mHeight = i11;
    }

    public static void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        OnPCMUpdateListener onPCMUpdateListener2 = onPCMUpdateListener;
        if (onPCMUpdateListener2 != null) {
            onPCMUpdateListener2.onAudioUpdate(bArr, audioFrameBean);
        }
    }

    public static void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        OnVideoUpdateListener onVideoUpdateListener = mVideoListener;
        if (onVideoUpdateListener != null) {
            onVideoUpdateListener.onVideoUpdate(bArr, videoFrameBean);
        }
    }
}
