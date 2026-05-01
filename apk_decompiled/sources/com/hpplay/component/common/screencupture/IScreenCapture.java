package com.hpplay.component.common.screencupture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.view.View;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.SourceModule;

/* loaded from: classes2.dex */
public abstract class IScreenCapture implements SourceModule {
    public abstract void disPlayReuse(boolean z10);

    public abstract int getBitrate();

    public abstract int getFps();

    public abstract String getMirrorMode();

    public abstract String getResolution();

    public abstract VirtualDisplay getVirtualDisplay();

    public abstract void hideMirrorScreen(Bitmap bitmap, Bitmap bitmap2);

    public abstract void init(Context context, ParamsMap paramsMap);

    public abstract boolean isRunning();

    public abstract boolean isSupportEncodeType(String str);

    public abstract void isUseGlSurface(boolean z10);

    public abstract void pauseEncoder(boolean z10);

    public abstract void requestKeyFrame();

    public abstract void resetEncoder();

    public abstract void resize();

    public abstract void resize(int i10);

    public abstract void resumeEncoder();

    public abstract void screenRecord(String str);

    public abstract void screenShot(String str, int i10, int i11);

    public abstract void setAudioSwitch(int i10, int i11, boolean z10, boolean z11);

    public abstract void setBitRate(int i10);

    public abstract void setCaptureSource(int i10);

    public abstract void setChannelMode(int i10);

    public abstract void setDisplayDpi(int i10);

    public abstract void setEncodeFormat(int i10);

    public abstract void setExpansionScreenInfo(Activity activity, View view);

    public abstract void setFrameCallbackListener(IScreenCaptureCallbackListener iScreenCaptureCallbackListener);

    public abstract void setFrameInterval(int i10);

    public abstract void setFrameRate(int i10);

    public abstract void setFullScreenMode(boolean z10);

    public abstract void setMirrorMode(String str);

    public abstract void setMirrorType(int i10);

    public abstract void setRenderMode(int i10);

    public abstract void setResolution(int i10, int i11, boolean z10);

    public abstract void setRotation(int i10, boolean z10);

    public abstract void setSampleRate(int i10);

    public abstract void setSecondMirrorView(View view);

    public abstract void setVideoEncodeType(String str);

    public abstract void setWatermarkInfo(Bitmap bitmap, Rect rect, float f10, float f11, int i10);

    public abstract void showMirrorScreen();

    public abstract boolean startCapture(Intent intent);

    public abstract boolean stopCapture();

    public abstract void switchExpansionScreen(boolean z10);

    public abstract void updatePCMData(int i10, int i11, int i12, byte[] bArr, int i13, int i14);

    public abstract void updateVideoData(byte[] bArr, int i10, int i11);

    public abstract void watermarkInvisible();

    public abstract void watermarkVisible();
}
