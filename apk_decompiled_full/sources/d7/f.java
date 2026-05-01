package d7;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* loaded from: classes3.dex */
public final class f implements Camera.PreviewCallback {

    /* renamed from: a, reason: collision with root package name */
    public final b f12691a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12692b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f12693c;

    /* renamed from: d, reason: collision with root package name */
    public int f12694d;

    public f(b bVar, boolean z10) {
        this.f12691a = bVar;
        this.f12692b = z10;
    }

    public void a(Handler handler, int i10) {
        this.f12693c = handler;
        this.f12694d = i10;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point c10 = this.f12691a.c();
        if (!this.f12692b) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.f12693c;
        if (handler != null) {
            handler.obtainMessage(this.f12694d, c10.x, c10.y, bArr).sendToTarget();
            this.f12693c = null;
        }
    }
}
