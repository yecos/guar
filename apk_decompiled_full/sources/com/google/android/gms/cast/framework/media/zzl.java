package com.google.android.gms.cast.framework.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzcn;
import o.l1;

/* loaded from: classes.dex */
final class zzl extends BroadcastReceiver {
    final /* synthetic */ MediaNotificationService zza;

    public zzl(MediaNotificationService mediaNotificationService) {
        this.zza = mediaNotificationService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        CastContext castContext;
        PendingIntent e10;
        Logger logger;
        ComponentName componentName = (ComponentName) Preconditions.checkNotNull((ComponentName) intent.getParcelableExtra("targetActivity"));
        Intent intent2 = new Intent();
        intent2.setComponent(componentName);
        castContext = this.zza.zzq;
        if (castContext.zzf()) {
            intent2.setFlags(603979776);
            e10 = zzcn.zza(context, 1, intent2, zzcn.zza | 134217728);
        } else {
            l1 d10 = l1.d(this.zza);
            d10.c(componentName);
            d10.a(intent2);
            e10 = d10.e(1, zzcn.zza | 134217728);
        }
        try {
            ((PendingIntent) Preconditions.checkNotNull(e10)).send(context, 1, new Intent().setFlags(268435456));
        } catch (PendingIntent.CanceledException e11) {
            logger = MediaNotificationService.zza;
            logger.d(e11, "Sending PendingIntent failed", new Object[0]);
        }
    }
}
