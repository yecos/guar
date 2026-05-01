package k0;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public e f14726a;

    public d(String str, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f14726a = new i(str, i10, i11);
        } else {
            this.f14726a = new j(str, i10, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.f14726a.equals(((d) obj).f14726a);
        }
        return false;
    }

    public int hashCode() {
        return this.f14726a.hashCode();
    }

    public d(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f14726a = new i(remoteUserInfo);
    }
}
