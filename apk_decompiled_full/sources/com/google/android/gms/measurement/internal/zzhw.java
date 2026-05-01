package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import anet.channel.entity.ConnType;

/* loaded from: classes.dex */
final class zzhw implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhx zza;

    public /* synthetic */ zzhw(zzhx zzhxVar, zzhv zzhvVar) {
        this.zza = zzhxVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfr zzfrVar;
        try {
            try {
                this.zza.zzt.zzay().zzj().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    zzfrVar = this.zza.zzt;
                } else {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        this.zza.zzt.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z10 = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? ConnType.PK_AUTO : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z10 = false;
                        }
                        this.zza.zzt.zzaz().zzp(new zzhu(this, z10, data, str, queryParameter));
                        zzfrVar = this.zza.zzt;
                    }
                    zzfrVar = this.zza.zzt;
                }
            } catch (RuntimeException e10) {
                this.zza.zzt.zzay().zzd().zzb("Throwable caught in onActivityCreated", e10);
                zzfrVar = this.zza.zzt;
            }
            zzfrVar.zzs().zzr(activity, bundle);
        } catch (Throwable th) {
            this.zza.zzt.zzs().zzr(activity, bundle);
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzt.zzs().zzs(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzt.zzs().zzt(activity);
        zzkc zzu = this.zza.zzt.zzu();
        zzu.zzt.zzaz().zzp(new zzjv(zzu, zzu.zzt.zzav().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzkc zzu = this.zza.zzt.zzu();
        zzu.zzt.zzaz().zzp(new zzju(zzu, zzu.zzt.zzav().elapsedRealtime()));
        this.zza.zzt.zzs().zzu(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzt.zzs().zzv(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
