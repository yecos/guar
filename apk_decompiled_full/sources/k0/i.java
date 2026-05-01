package k0;

import android.media.session.MediaSessionManager;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: d, reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f14727d;

    public i(String str, int i10, int i11) {
        super(str, i10, i11);
        this.f14727d = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(r0, r1, r2);
        String packageName;
        int pid;
        int uid;
        packageName = remoteUserInfo.getPackageName();
        pid = remoteUserInfo.getPid();
        uid = remoteUserInfo.getUid();
        this.f14727d = remoteUserInfo;
    }
}
