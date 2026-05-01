package com.google.android.gms.cast.framework;

import androidx.annotation.RecentlyNonNull;

/* loaded from: classes.dex */
public class MediaNotificationManager {
    private final SessionManager zza;

    public MediaNotificationManager(@RecentlyNonNull SessionManager sessionManager) {
        this.zza = sessionManager;
    }

    public void updateNotification() {
        CastSession currentCastSession = this.zza.getCurrentCastSession();
        if (currentCastSession != null) {
            currentCastSession.zzd().zzg(true);
        }
    }
}
