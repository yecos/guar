package com.hpplay.component.common.protocol;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.SourceModule;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class IMirrorController implements SourceModule {
    public abstract void sendAudioData(byte[] bArr, int i10, int i11);

    public abstract void sendVideoData(ByteBuffer byteBuffer, int i10, long j10);

    public abstract void setAdjustResolution(boolean z10);

    public abstract void setAutoBitrate(boolean z10);

    public abstract void setMirrorMode(String str);

    public abstract void setMirrorProtocolInfos(ParamsMap paramsMap);

    public abstract void setSendDataTimeout(int i10);

    public abstract void startGetSinkInfos(IMirrorStateListener iMirrorStateListener);

    public abstract void stopMirror();

    public abstract void switchWLANChannel(int i10);
}
