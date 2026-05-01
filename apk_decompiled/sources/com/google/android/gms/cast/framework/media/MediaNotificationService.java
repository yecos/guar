package com.google.android.gms.cast.framework.media;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzcn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l0.c;
import o.s;

/* loaded from: classes.dex */
public class MediaNotificationService extends Service {

    @RecentlyNonNull
    public static final String ACTION_UPDATE_NOTIFICATION = "com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION";
    private static final Logger zza = new Logger("MediaNotificationService");
    private static Runnable zzb;
    private NotificationOptions zzc;
    private ImagePicker zzd;
    private ComponentName zze;
    private ComponentName zzf;
    private int[] zzh;
    private long zzi;
    private com.google.android.gms.cast.framework.media.internal.zzb zzj;
    private ImageHints zzk;
    private Resources zzl;
    private zzn zzm;
    private zzo zzn;
    private NotificationManager zzo;
    private Notification zzp;
    private CastContext zzq;
    private List<s.a> zzg = new ArrayList();
    private final BroadcastReceiver zzr = new zzl(this);

    public static boolean isNotificationOptionsValid(@RecentlyNonNull CastOptions castOptions) {
        NotificationOptions notificationOptions;
        CastMediaOptions castMediaOptions = castOptions.getCastMediaOptions();
        if (castMediaOptions == null || (notificationOptions = castMediaOptions.getNotificationOptions()) == null) {
            return false;
        }
        zzg zzm = notificationOptions.zzm();
        if (zzm == null) {
            return true;
        }
        List<NotificationAction> zzg = zzg(zzm);
        int[] zzk = zzk(zzm);
        int size = zzg == null ? 0 : zzg.size();
        if (zzg == null || zzg.isEmpty()) {
            zza.e(NotificationActionsProvider.class.getSimpleName().concat(" doesn't provide any action."), new Object[0]);
        } else if (zzg.size() > 5) {
            zza.e(NotificationActionsProvider.class.getSimpleName().concat(" provides more than 5 actions."), new Object[0]);
        } else {
            if (zzk != null && (zzk.length) != 0) {
                for (int i10 : zzk) {
                    if (i10 < 0 || i10 >= size) {
                        zza.e(NotificationActionsProvider.class.getSimpleName().concat("provides a compact view action whose index is out of bounds."), new Object[0]);
                    }
                }
                return true;
            }
            zza.e(NotificationActionsProvider.class.getSimpleName().concat(" doesn't provide any actions for compact view."), new Object[0]);
        }
        return false;
    }

    public static void zze() {
        Runnable runnable = zzb;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final s.a zzf(String str) {
        char c10;
        int pauseDrawableResId;
        int zzf;
        switch (str.hashCode()) {
            case -1699820260:
                if (str.equals(MediaIntentReceiver.ACTION_REWIND)) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -945151566:
                if (str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -945080078:
                if (str.equals(MediaIntentReceiver.ACTION_SKIP_PREV)) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -668151673:
                if (str.equals(MediaIntentReceiver.ACTION_STOP_CASTING)) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case -124479363:
                if (str.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 235550565:
                if (str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK)) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 1362116196:
                if (str.equals(MediaIntentReceiver.ACTION_FORWARD)) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        PendingIntent pendingIntent = null;
        switch (c10) {
            case 0:
                zzn zznVar = this.zzm;
                int i10 = zznVar.zzc;
                boolean z10 = zznVar.zzb;
                if (i10 == 2) {
                    pauseDrawableResId = this.zzc.getStopLiveStreamDrawableResId();
                    zzf = this.zzc.getStopLiveStreamTitleResId();
                } else {
                    pauseDrawableResId = this.zzc.getPauseDrawableResId();
                    zzf = this.zzc.zzf();
                }
                if (!z10) {
                    pauseDrawableResId = this.zzc.getPlayDrawableResId();
                }
                if (!z10) {
                    zzf = this.zzc.zzg();
                }
                Intent intent = new Intent(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                intent.setComponent(this.zze);
                return new s.a.C0298a(pauseDrawableResId, this.zzl.getString(zzf), zzcn.zzb(this, 0, intent, zzcn.zza)).a();
            case 1:
                if (this.zzm.zzf) {
                    Intent intent2 = new Intent(MediaIntentReceiver.ACTION_SKIP_NEXT);
                    intent2.setComponent(this.zze);
                    pendingIntent = zzcn.zzb(this, 0, intent2, zzcn.zza);
                }
                return new s.a.C0298a(this.zzc.getSkipNextDrawableResId(), this.zzl.getString(this.zzc.zzk()), pendingIntent).a();
            case 2:
                if (this.zzm.zzg) {
                    Intent intent3 = new Intent(MediaIntentReceiver.ACTION_SKIP_PREV);
                    intent3.setComponent(this.zze);
                    pendingIntent = zzcn.zzb(this, 0, intent3, zzcn.zza);
                }
                return new s.a.C0298a(this.zzc.getSkipPrevDrawableResId(), this.zzl.getString(this.zzc.zzl()), pendingIntent).a();
            case 3:
                long j10 = this.zzi;
                Intent intent4 = new Intent(MediaIntentReceiver.ACTION_FORWARD);
                intent4.setComponent(this.zze);
                intent4.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j10);
                PendingIntent zzb2 = zzcn.zzb(this, 0, intent4, zzcn.zza | 134217728);
                int forwardDrawableResId = this.zzc.getForwardDrawableResId();
                int zzd = this.zzc.zzd();
                if (j10 == NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    forwardDrawableResId = this.zzc.getForward10DrawableResId();
                    zzd = this.zzc.zzb();
                } else if (j10 == NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                    forwardDrawableResId = this.zzc.getForward30DrawableResId();
                    zzd = this.zzc.zzc();
                }
                return new s.a.C0298a(forwardDrawableResId, this.zzl.getString(zzd), zzb2).a();
            case 4:
                long j11 = this.zzi;
                Intent intent5 = new Intent(MediaIntentReceiver.ACTION_REWIND);
                intent5.setComponent(this.zze);
                intent5.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j11);
                PendingIntent zzb3 = zzcn.zzb(this, 0, intent5, zzcn.zza | 134217728);
                int rewindDrawableResId = this.zzc.getRewindDrawableResId();
                int zzj = this.zzc.zzj();
                if (j11 == NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    rewindDrawableResId = this.zzc.getRewind10DrawableResId();
                    zzj = this.zzc.zzh();
                } else if (j11 == NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                    rewindDrawableResId = this.zzc.getRewind30DrawableResId();
                    zzj = this.zzc.zzi();
                }
                return new s.a.C0298a(rewindDrawableResId, this.zzl.getString(zzj), zzb3).a();
            case 5:
                Intent intent6 = new Intent(MediaIntentReceiver.ACTION_STOP_CASTING);
                intent6.setComponent(this.zze);
                return new s.a.C0298a(this.zzc.getDisconnectDrawableResId(), this.zzl.getString(this.zzc.zza()), zzcn.zzb(this, 0, intent6, zzcn.zza)).a();
            case 6:
                Intent intent7 = new Intent(MediaIntentReceiver.ACTION_DISCONNECT);
                intent7.setComponent(this.zze);
                return new s.a.C0298a(this.zzc.getDisconnectDrawableResId(), this.zzl.getString(this.zzc.zza(), ""), zzcn.zzb(this, 0, intent7, zzcn.zza)).a();
            default:
                zza.e("Action: %s is not a pre-defined action.", str);
                return null;
        }
    }

    private static List<NotificationAction> zzg(zzg zzgVar) {
        try {
            return zzgVar.zzf();
        } catch (RemoteException e10) {
            zza.e(e10, "Unable to call %s on %s.", "getNotificationActions", zzg.class.getSimpleName());
            return null;
        }
    }

    private final void zzh(zzg zzgVar) {
        s.a zzf;
        int[] zzk = zzk(zzgVar);
        this.zzh = zzk == null ? null : (int[]) zzk.clone();
        List<NotificationAction> zzg = zzg(zzgVar);
        this.zzg = new ArrayList();
        if (zzg == null) {
            return;
        }
        for (NotificationAction notificationAction : zzg) {
            String action = notificationAction.getAction();
            if (action.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action.equals(MediaIntentReceiver.ACTION_FORWARD) || action.equals(MediaIntentReceiver.ACTION_REWIND) || action.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                zzf = zzf(notificationAction.getAction());
            } else {
                Intent intent = new Intent(notificationAction.getAction());
                intent.setComponent(this.zze);
                zzf = new s.a.C0298a(notificationAction.getIconResId(), notificationAction.getContentDescription(), zzcn.zzb(this, 0, intent, zzcn.zza)).a();
            }
            if (zzf != null) {
                this.zzg.add(zzf);
            }
        }
    }

    private final void zzi() {
        this.zzg = new ArrayList();
        Iterator<String> it = this.zzc.getActions().iterator();
        while (it.hasNext()) {
            s.a zzf = zzf(it.next());
            if (zzf != null) {
                this.zzg.add(zzf);
            }
        }
        this.zzh = (int[]) this.zzc.getCompatActionIndices().clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj() {
        if (this.zzm == null) {
            return;
        }
        zzo zzoVar = this.zzn;
        PendingIntent pendingIntent = null;
        s.e G = new s.e(this, "cast_media_notification").u(zzoVar == null ? null : zzoVar.zzb).B(this.zzc.getSmallIconDrawableResId()).p(this.zzm.zzd).o(this.zzl.getString(this.zzc.getCastingToDeviceStringResId(), this.zzm.zze)).y(true).A(false).G(1);
        ComponentName componentName = this.zzf;
        if (componentName != null) {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            pendingIntent = zzcn.zzb(this, 1, intent, zzcn.zza | 134217728);
        }
        if (pendingIntent != null) {
            G.n(pendingIntent);
        }
        zzg zzm = this.zzc.zzm();
        if (zzm != null) {
            zza.i("actionsProvider != null", new Object[0]);
            zzh(zzm);
        } else {
            zza.i("actionsProvider == null", new Object[0]);
            zzi();
        }
        Iterator<s.a> it = this.zzg.iterator();
        while (it.hasNext()) {
            G.b(it.next());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            c cVar = new c();
            int[] iArr = this.zzh;
            if (iArr != null) {
                cVar.t(iArr);
            }
            MediaSessionCompat.Token token = this.zzm.zza;
            if (token != null) {
                cVar.s(token);
            }
            G.D(cVar);
        }
        Notification c10 = G.c();
        this.zzp = c10;
        startForeground(1, c10);
    }

    private static int[] zzk(zzg zzgVar) {
        try {
            return zzgVar.zzg();
        } catch (RemoteException e10) {
            zza.e(e10, "Unable to call %s on %s.", "getCompactViewActionIndices", zzg.class.getSimpleName());
            return null;
        }
    }

    @Override // android.app.Service
    @RecentlyNullable
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.zzo = (NotificationManager) getSystemService("notification");
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        this.zzq = sharedInstance;
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(sharedInstance.getCastOptions().getCastMediaOptions());
        this.zzc = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.zzd = castMediaOptions.getImagePicker();
        this.zzl = getResources();
        this.zze = new ComponentName(getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (TextUtils.isEmpty(this.zzc.getTargetActivityClassName())) {
            this.zzf = null;
        } else {
            this.zzf = new ComponentName(getApplicationContext(), this.zzc.getTargetActivityClassName());
        }
        this.zzi = this.zzc.getSkipStepMs();
        int dimensionPixelSize = this.zzl.getDimensionPixelSize(this.zzc.zze());
        this.zzk = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.zzj = new com.google.android.gms.cast.framework.media.internal.zzb(getApplicationContext(), this.zzk);
        ComponentName componentName = this.zzf;
        if (componentName != null) {
            registerReceiver(this.zzr, new IntentFilter(componentName.flattenToString()));
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", "Cast", 2);
            notificationChannel.setShowBadge(false);
            this.zzo.createNotificationChannel(notificationChannel);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.google.android.gms.cast.framework.media.internal.zzb zzbVar = this.zzj;
        if (zzbVar != null) {
            zzbVar.zza();
        }
        if (this.zzf != null) {
            try {
                unregisterReceiver(this.zzr);
            } catch (IllegalArgumentException e10) {
                zza.e(e10, "Unregistering trampoline BroadcastReceiver failed", new Object[0]);
            }
        }
        zzb = null;
        this.zzo.cancel(1);
    }

    @Override // android.app.Service
    public int onStartCommand(@RecentlyNonNull Intent intent, int i10, final int i11) {
        zzn zznVar;
        MediaInfo mediaInfo = (MediaInfo) Preconditions.checkNotNull((MediaInfo) intent.getParcelableExtra("extra_media_info"));
        MediaMetadata mediaMetadata = (MediaMetadata) Preconditions.checkNotNull(mediaInfo.getMetadata());
        zzn zznVar2 = new zzn(intent.getIntExtra("extra_remote_media_client_player_state", 0) == 2, mediaInfo.getStreamType(), mediaMetadata.getString(MediaMetadata.KEY_TITLE), ((CastDevice) Preconditions.checkNotNull((CastDevice) intent.getParcelableExtra("extra_cast_device"))).getFriendlyName(), (MediaSessionCompat.Token) intent.getParcelableExtra("extra_media_session_token"), intent.getBooleanExtra("extra_can_skip_next", false), intent.getBooleanExtra("extra_can_skip_prev", false));
        if (intent.getBooleanExtra("extra_media_notification_force_update", false) || (zznVar = this.zzm) == null || zznVar2.zzb != zznVar.zzb || zznVar2.zzc != zznVar.zzc || !CastUtils.zzh(zznVar2.zzd, zznVar.zzd) || !CastUtils.zzh(zznVar2.zze, zznVar.zze) || zznVar2.zzf != zznVar.zzf || zznVar2.zzg != zznVar.zzg) {
            this.zzm = zznVar2;
            zzj();
        }
        ImagePicker imagePicker = this.zzd;
        zzo zzoVar = new zzo(imagePicker != null ? imagePicker.onPickImage(mediaMetadata, this.zzk) : mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null);
        zzo zzoVar2 = this.zzn;
        if (zzoVar2 == null || !CastUtils.zzh(zzoVar.zza, zzoVar2.zza)) {
            this.zzj.zzc(new zzm(this, zzoVar));
            this.zzj.zzd(zzoVar.zza);
        }
        startForeground(1, this.zzp);
        zzb = new Runnable() { // from class: com.google.android.gms.cast.framework.media.zzk
            @Override // java.lang.Runnable
            public final void run() {
                MediaNotificationService.this.stopSelf(i11);
            }
        };
        return 2;
    }
}
