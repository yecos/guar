package com.hpplay.sdk.source.mirror.yim.render;

import com.hpplay.sdk.source.log.SourceLog;
import com.youme.voiceengine.VideoMgr;
import com.youme.voiceengine.video.SurfaceViewRenderer;
import com.youme.voiceengine.video.VideoBaseRenderer;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class b implements VideoMgr.VideoFrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public SurfaceViewRenderer f7731a;

    /* renamed from: b, reason: collision with root package name */
    private int f7732b = 90;

    public b(SurfaceViewRenderer surfaceViewRenderer) {
        this.f7731a = surfaceViewRenderer;
    }

    public int a(int i10, int i11, int i12, int i13, int i14) {
        return 0;
    }

    public void a(String str, byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
        int i14 = i11 / 2;
        int[] iArr = {i11, i14, i14};
        SourceLog.i("onVideoFrameCallback", i11 + " " + i12);
        if (i11 > i12) {
            this.f7732b = 90;
        } else {
            this.f7732b = 0;
        }
        int i15 = i11 * i12;
        int i16 = i15 / 4;
        byte[] bArr2 = new byte[i15];
        byte[] bArr3 = new byte[i16];
        byte[] bArr4 = new byte[i16];
        System.arraycopy(bArr, 0, bArr2, 0, i15);
        System.arraycopy(bArr, i15, bArr3, 0, i16);
        System.arraycopy(bArr, i15 + i16, bArr4, 0, i16);
        this.f7731a.renderFrame(new VideoBaseRenderer.I420Frame(i11, i12, this.f7732b, iArr, new ByteBuffer[]{ByteBuffer.wrap(bArr2), ByteBuffer.wrap(bArr3), ByteBuffer.wrap(bArr4)}));
    }

    public void a(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
        int i14 = i11 / 2;
        int[] iArr = {i11, i14, i14};
        int i15 = i11 * i12;
        int i16 = i15 / 4;
        byte[] bArr2 = new byte[i15];
        byte[] bArr3 = new byte[i16];
        byte[] bArr4 = new byte[i16];
        System.arraycopy(bArr, 0, bArr2, 0, i15);
        System.arraycopy(bArr, i15, bArr3, 0, i16);
        System.arraycopy(bArr, i15 + i16, bArr4, 0, i16);
        this.f7731a.renderFrame(new VideoBaseRenderer.I420Frame(i11, i12, this.f7732b, iArr, new ByteBuffer[]{ByteBuffer.wrap(bArr2), ByteBuffer.wrap(bArr3), ByteBuffer.wrap(bArr4)}));
    }

    public void a(String str, int i10, int i11, float[] fArr, int i12, int i13, long j10) {
        if (this.f7731a != null) {
            VideoBaseRenderer.I420Frame i420Frame = new VideoBaseRenderer.I420Frame(i12, i13, 0, i11, fArr, i10 == 7);
            i420Frame.rotationDegree = this.f7732b;
            this.f7731a.renderFrame(i420Frame);
        }
    }

    public void a(int i10, int i11, float[] fArr, int i12, int i13, long j10) {
        if (this.f7731a != null) {
            VideoBaseRenderer.I420Frame i420Frame = new VideoBaseRenderer.I420Frame(i12, i13, 0, i11, fArr, i10 == 7);
            i420Frame.rotationDegree = this.f7732b;
            this.f7731a.renderFrame(i420Frame);
        }
    }
}
