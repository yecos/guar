package d7;

import android.hardware.Camera;
import android.os.Handler;

/* loaded from: classes3.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: a, reason: collision with root package name */
    public Handler f12664a;

    /* renamed from: b, reason: collision with root package name */
    public int f12665b;

    public void a(Handler handler, int i10) {
        this.f12664a = handler;
        this.f12665b = i10;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z10, Camera camera) {
        Handler handler = this.f12664a;
        if (handler != null) {
            this.f12664a.sendMessageDelayed(handler.obtainMessage(this.f12665b, Boolean.valueOf(z10)), 1500L);
            this.f12664a = null;
        }
    }
}
