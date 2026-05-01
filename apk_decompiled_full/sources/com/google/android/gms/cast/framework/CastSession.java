package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.zzbp;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashSet;
import java.util.Set;
import n0.p1;

/* loaded from: classes.dex */
public class CastSession extends Session {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = new Logger("CastSession");
    private final Context zzc;
    private final Set<Cast.Listener> zzd;
    private final zzz zze;
    private final CastOptions zzf;
    private final com.google.android.gms.cast.framework.media.internal.zzp zzg;
    private com.google.android.gms.cast.zzr zzh;
    private RemoteMediaClient zzi;
    private CastDevice zzj;
    private Cast.ApplicationConnectionResult zzk;
    private com.google.android.gms.internal.cast.zzar zzl;
    private final zzf zzm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastSession(Context context, String str, String str2, CastOptions castOptions, com.google.android.gms.cast.framework.media.internal.zzp zzpVar) {
        super(context, str, str2);
        zzf zzfVar = new Object() { // from class: com.google.android.gms.cast.framework.zzf
        };
        this.zzd = new HashSet();
        this.zzc = context.getApplicationContext();
        this.zzf = castOptions;
        this.zzg = zzpVar;
        this.zzm = zzfVar;
        this.zze = com.google.android.gms.internal.cast.zzm.zzb(context, castOptions, zzl(), new zzl(this, null));
    }

    public static /* bridge */ /* synthetic */ void zzg(CastSession castSession, int i10) {
        castSession.zzg.zze(i10);
        com.google.android.gms.cast.zzr zzrVar = castSession.zzh;
        if (zzrVar != null) {
            zzrVar.zzf();
            castSession.zzh = null;
        }
        castSession.zzj = null;
        RemoteMediaClient remoteMediaClient = castSession.zzi;
        if (remoteMediaClient != null) {
            remoteMediaClient.zzo(null);
            castSession.zzi = null;
        }
        castSession.zzk = null;
    }

    public static /* bridge */ /* synthetic */ void zzh(CastSession castSession, String str, Task task) {
        if (castSession.zze == null) {
            return;
        }
        try {
            if (task.isSuccessful()) {
                Cast.ApplicationConnectionResult applicationConnectionResult = (Cast.ApplicationConnectionResult) task.getResult();
                castSession.zzk = applicationConnectionResult;
                if (applicationConnectionResult.getStatus() != null && applicationConnectionResult.getStatus().isSuccess()) {
                    zzb.d("%s() -> success result", str);
                    RemoteMediaClient remoteMediaClient = new RemoteMediaClient(new com.google.android.gms.cast.internal.zzap(null));
                    castSession.zzi = remoteMediaClient;
                    remoteMediaClient.zzo(castSession.zzh);
                    castSession.zzi.zzn();
                    castSession.zzg.zzd(castSession.zzi, castSession.getCastDevice());
                    castSession.zze.zzf((ApplicationMetadata) Preconditions.checkNotNull(applicationConnectionResult.getApplicationMetadata()), applicationConnectionResult.getApplicationStatus(), (String) Preconditions.checkNotNull(applicationConnectionResult.getSessionId()), applicationConnectionResult.getWasLaunched());
                    return;
                }
                if (applicationConnectionResult.getStatus() != null) {
                    zzb.d("%s() -> failure result", str);
                    castSession.zze.zzg(applicationConnectionResult.getStatus().getStatusCode());
                    return;
                }
            } else {
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    castSession.zze.zzg(((ApiException) exception).getStatusCode());
                    return;
                }
            }
            castSession.zze.zzg(2476);
        } catch (RemoteException e10) {
            zzb.d(e10, "Unable to call %s on %s.", "methods", zzz.class.getSimpleName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzm(Bundle bundle) {
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        this.zzj = fromBundle;
        if (fromBundle == null) {
            if (isResuming()) {
                notifyFailedToResumeSession(2153);
                return;
            } else {
                notifyFailedToStartSession(2151);
                return;
            }
        }
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        zzm zzmVar = null;
        Object[] objArr = 0;
        if (zzrVar != null) {
            zzrVar.zzf();
            this.zzh = null;
        }
        zzb.d("Acquiring a connection to Google Play Services for %s", this.zzj);
        CastDevice castDevice = (CastDevice) Preconditions.checkNotNull(this.zzj);
        Bundle bundle2 = new Bundle();
        CastOptions castOptions = this.zzf;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.getCastMediaOptions();
        NotificationOptions notificationOptions = castMediaOptions == null ? null : castMediaOptions.getNotificationOptions();
        boolean z10 = castMediaOptions != null && castMediaOptions.zza();
        Intent intent = new Intent(this.zzc, (Class<?>) p1.class);
        intent.setPackage(this.zzc.getPackageName());
        boolean z11 = !this.zzc.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", notificationOptions != null);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z10);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", z11);
        Cast.CastOptions.Builder builder = new Cast.CastOptions.Builder(castDevice, new zzn(this, zzmVar));
        builder.zzc(bundle2);
        com.google.android.gms.cast.zzr zza2 = Cast.zza(this.zzc, builder.build());
        zza2.zzk(new zzp(this, objArr == true ? 1 : 0));
        this.zzh = zza2;
        zza2.zze();
    }

    public void addCastListener(@RecentlyNonNull Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.add(listener);
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void end(boolean z10) {
        zzz zzzVar = this.zze;
        if (zzzVar != null) {
            try {
                zzzVar.zze(z10, 0);
            } catch (RemoteException e10) {
                zzb.d(e10, "Unable to call %s on %s.", "disconnectFromDevice", zzz.class.getSimpleName());
            }
            notifySessionEnded(0);
            com.google.android.gms.internal.cast.zzar zzarVar = this.zzl;
            if (zzarVar != null) {
                zzarVar.zzd();
            }
        }
    }

    public int getActiveInputState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            return zzrVar.zzb();
        }
        return -1;
    }

    @RecentlyNullable
    public Cast.ApplicationConnectionResult getApplicationConnectionResult() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    @RecentlyNullable
    public ApplicationMetadata getApplicationMetadata() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            return zzrVar.zzd();
        }
        return null;
    }

    @RecentlyNullable
    public String getApplicationStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            return zzrVar.zzj();
        }
        return null;
    }

    @RecentlyNullable
    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    @RecentlyNullable
    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient = this.zzi;
        if (remoteMediaClient == null) {
            return 0L;
        }
        return remoteMediaClient.getStreamDuration() - this.zzi.getApproximateStreamPosition();
    }

    public int getStandbyState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            return zzrVar.zzc();
        }
        return -1;
    }

    public double getVolume() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            return zzrVar.zza();
        }
        return 0.0d;
    }

    public boolean isMute() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        return zzrVar != null && zzrVar.zzl();
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void onResuming(@RecentlyNonNull Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void onStarting(@RecentlyNonNull Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    public void removeCastListener(@RecentlyNonNull Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.remove(listener);
        }
    }

    public void removeMessageReceivedCallbacks(@RecentlyNonNull String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            zzrVar.zzg(str);
        }
    }

    public void requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            ((zzbp) zzrVar).doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzax
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    int i10 = zzbp.zzf;
                    ((com.google.android.gms.cast.internal.zzae) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzl();
                    ((TaskCompletionSource) obj2).setResult(null);
                }
            }).setMethodKey(8404).build());
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void resume(@RecentlyNonNull Bundle bundle) {
        zzm(bundle);
    }

    @RecentlyNonNull
    public PendingResult<Status> sendMessage(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        return zzrVar == null ? PendingResults.immediatePendingResult(new Status(17)) : com.google.android.gms.internal.cast.zzao.zza(zzrVar.zzh(str, str2), new com.google.android.gms.internal.cast.zzan() { // from class: com.google.android.gms.cast.framework.zzh
        }, new com.google.android.gms.internal.cast.zzan() { // from class: com.google.android.gms.cast.framework.zzg
        });
    }

    public void setMessageReceivedCallbacks(@RecentlyNonNull String str, @RecentlyNonNull Cast.MessageReceivedCallback messageReceivedCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            zzrVar.zzi(str, messageReceivedCallback);
        }
    }

    public void setMute(final boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            final zzbp zzbpVar = (zzbp) zzrVar;
            zzbpVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzau
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzbp.this.zzK(z10, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(8412).build());
        }
    }

    public void setVolume(final double d10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.zzh;
        if (zzrVar != null) {
            if (!Double.isInfinite(d10) && !Double.isNaN(d10)) {
                final zzbp zzbpVar = (zzbp) zzrVar;
                zzbpVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzaz
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        zzbp.this.zzL(d10, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                    }
                }).setMethodKey(8411).build());
            } else {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Volume cannot be ");
                sb.append(d10);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void start(@RecentlyNonNull Bundle bundle) {
        zzm(bundle);
    }

    public final com.google.android.gms.cast.framework.media.internal.zzp zzd() {
        return this.zzg;
    }

    public final void zzi(com.google.android.gms.internal.cast.zzar zzarVar) {
        this.zzl = zzarVar;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public final void zzj(@RecentlyNonNull Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }
}
