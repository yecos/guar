package com.google.android.gms.cast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import n0.s0;
import n0.t0;
import o.s;

@Deprecated
/* loaded from: classes.dex */
public abstract class CastRemoteDisplayLocalService extends Service {
    private static final Logger zza = new Logger("CastRDLocalService");
    private static final int zzb = R.id.cast_notification_id;
    private static final Object zzc = new Object();
    private static AtomicBoolean zzd = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zze;
    private String zzf;
    private WeakReference<Callbacks> zzg;
    private zzan zzh;
    private NotificationSettings zzi;
    private Notification zzj;
    private boolean zzk;
    private PendingIntent zzl;
    private CastDevice zzm;
    private Display zzn;
    private Context zzo;
    private ServiceConnection zzp;
    private Handler zzq;
    private t0 zzr;
    private CastRemoteDisplayClient zzt;
    private boolean zzs = false;
    private final t0.b zzu = new zzac(this);
    private final IBinder zzv = new zzak(this);

    public interface Callbacks {
        void onRemoteDisplayMuteStateChanged(boolean z10);

        void onRemoteDisplaySessionEnded(@RecentlyNonNull CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onRemoteDisplaySessionError(@RecentlyNonNull Status status);

        void onRemoteDisplaySessionStarted(@RecentlyNonNull CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(@RecentlyNonNull CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification zza;
        private PendingIntent zzb;
        private String zzc;
        private String zzd;

        public static final class Builder {
            private NotificationSettings zza = new NotificationSettings(null);

            @RecentlyNonNull
            public NotificationSettings build() {
                if (this.zza.zza != null) {
                    if (!TextUtils.isEmpty(this.zza.zzc)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    }
                    if (!TextUtils.isEmpty(this.zza.zzd)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    }
                    if (this.zza.zzb != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zza.zzc) && TextUtils.isEmpty(this.zza.zzd) && this.zza.zzb == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zza;
            }

            @RecentlyNonNull
            public Builder setNotification(@RecentlyNonNull Notification notification) {
                this.zza.zza = notification;
                return this;
            }

            @RecentlyNonNull
            public Builder setNotificationPendingIntent(@RecentlyNonNull PendingIntent pendingIntent) {
                this.zza.zzb = pendingIntent;
                return this;
            }

            @RecentlyNonNull
            public Builder setNotificationText(@RecentlyNonNull String str) {
                this.zza.zzd = str;
                return this;
            }

            @RecentlyNonNull
            public Builder setNotificationTitle(@RecentlyNonNull String str) {
                this.zza.zzc = str;
                return this;
            }
        }

        private NotificationSettings() {
        }

        public /* synthetic */ NotificationSettings(NotificationSettings notificationSettings, zzal zzalVar) {
            this.zza = notificationSettings.zza;
            this.zzb = notificationSettings.zzb;
            this.zzc = notificationSettings.zzc;
            this.zzd = notificationSettings.zzd;
        }

        public /* synthetic */ NotificationSettings(zzal zzalVar) {
        }
    }

    public static class Options {

        @CastRemoteDisplay.Configuration
        int zza = 2;

        @CastRemoteDisplay.Configuration
        public int getConfigPreset() {
            return this.zza;
        }

        public void setConfigPreset(@CastRemoteDisplay.Configuration int i10) {
            this.zza = i10;
        }
    }

    @RecentlyNullable
    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzc) {
            castRemoteDisplayLocalService = zze;
        }
        return castRemoteDisplayLocalService;
    }

    public static void setDebugEnabled() {
        zza.zzb(true);
    }

    public static void startService(@RecentlyNonNull Context context, @RecentlyNonNull Class<? extends CastRemoteDisplayLocalService> cls, @RecentlyNonNull String str, @RecentlyNonNull CastDevice castDevice, @RecentlyNonNull NotificationSettings notificationSettings, @RecentlyNonNull Callbacks callbacks) {
        startServiceWithOptions(context, cls, str, castDevice, new Options(), notificationSettings, callbacks);
    }

    public static void startServiceWithOptions(@RecentlyNonNull Context context, @RecentlyNonNull Class<? extends CastRemoteDisplayLocalService> cls, @RecentlyNonNull String str, @RecentlyNonNull CastDevice castDevice, @RecentlyNonNull Options options, @RecentlyNonNull NotificationSettings notificationSettings, @RecentlyNonNull Callbacks callbacks) {
        Logger logger = zza;
        logger.d("Starting Service", new Object[0]);
        synchronized (zzc) {
            if (zze != null) {
                logger.w("An existing service had not been stopped before starting one", new Object[0]);
                zzw(true);
            }
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
            Preconditions.checkNotNull(context, "activityContext is required.");
            Preconditions.checkNotNull(cls, "serviceClass is required.");
            Preconditions.checkNotNull(str, "applicationId is required.");
            Preconditions.checkNotNull(castDevice, "device is required.");
            Preconditions.checkNotNull(options, "options is required.");
            Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
            Preconditions.checkNotNull(callbacks, "callbacks is required.");
            if (notificationSettings.zza == null && notificationSettings.zzb == null) {
                throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
            }
            if (zzd.getAndSet(true)) {
                logger.e("Service is already being started, startService has been called twice", new Object[0]);
                return;
            }
            Intent intent = new Intent(context, cls);
            context.startService(intent);
            ConnectionTracker.getInstance().bindService(context, intent, new zzae(str, castDevice, options, notificationSettings, context, callbacks), 64);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    public static void stopService() {
        zzw(false);
    }

    public static /* bridge */ /* synthetic */ void zzl(CastRemoteDisplayLocalService castRemoteDisplayLocalService, Display display) {
        if (display == null) {
            zza.e("Cast Remote Display session created without display", new Object[0]);
            return;
        }
        castRemoteDisplayLocalService.zzn = display;
        if (castRemoteDisplayLocalService.zzk) {
            Notification zzu = castRemoteDisplayLocalService.zzu(true);
            castRemoteDisplayLocalService.zzj = zzu;
            castRemoteDisplayLocalService.startForeground(zzb, zzu);
        }
        Callbacks callbacks = castRemoteDisplayLocalService.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionStarted(castRemoteDisplayLocalService);
        }
        Preconditions.checkNotNull(castRemoteDisplayLocalService.zzn, "display is required.");
        castRemoteDisplayLocalService.onCreatePresentation(castRemoteDisplayLocalService.zzn);
    }

    public static /* bridge */ /* synthetic */ void zzo(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        Callbacks callbacks = castRemoteDisplayLocalService.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
        }
        stopService();
    }

    public static /* bridge */ /* synthetic */ void zzq(CastRemoteDisplayLocalService castRemoteDisplayLocalService, NotificationSettings notificationSettings) {
        Preconditions.checkMainThread("updateNotificationSettingsInternal must be called on the main thread");
        if (castRemoteDisplayLocalService.zzi == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!castRemoteDisplayLocalService.zzk) {
            Preconditions.checkNotNull(notificationSettings.zza, "notification is required.");
            Notification notification = notificationSettings.zza;
            castRemoteDisplayLocalService.zzj = notification;
            castRemoteDisplayLocalService.zzi.zza = notification;
        } else {
            if (notificationSettings.zza != null) {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            if (notificationSettings.zzb != null) {
                castRemoteDisplayLocalService.zzi.zzb = notificationSettings.zzb;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzc)) {
                castRemoteDisplayLocalService.zzi.zzc = notificationSettings.zzc;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzd)) {
                castRemoteDisplayLocalService.zzi.zzd = notificationSettings.zzd;
            }
            castRemoteDisplayLocalService.zzj = castRemoteDisplayLocalService.zzu(true);
        }
        castRemoteDisplayLocalService.startForeground(zzb, castRemoteDisplayLocalService.zzj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ boolean zzt(CastRemoteDisplayLocalService castRemoteDisplayLocalService, String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        castRemoteDisplayLocalService.zzv("startRemoteDisplaySession");
        Preconditions.checkMainThread("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzc) {
            if (zze != null) {
                zza.w("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zze = castRemoteDisplayLocalService;
            castRemoteDisplayLocalService.zzg = new WeakReference<>(callbacks);
            castRemoteDisplayLocalService.zzf = str;
            castRemoteDisplayLocalService.zzm = castDevice;
            castRemoteDisplayLocalService.zzo = context;
            castRemoteDisplayLocalService.zzp = serviceConnection;
            if (castRemoteDisplayLocalService.zzr == null) {
                castRemoteDisplayLocalService.zzr = t0.i(castRemoteDisplayLocalService.getApplicationContext());
            }
            Preconditions.checkNotNull(castRemoteDisplayLocalService.zzf, "applicationId is required.");
            s0 d10 = new s0.a().b(CastMediaControlIntent.categoryForCast(castRemoteDisplayLocalService.zzf)).d();
            castRemoteDisplayLocalService.zzv("addMediaRouterCallback");
            castRemoteDisplayLocalService.zzr.b(d10, castRemoteDisplayLocalService.zzu, 4);
            castRemoteDisplayLocalService.zzj = notificationSettings.zza;
            castRemoteDisplayLocalService.zzh = new zzan(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intentFilter.addAction("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
            castRemoteDisplayLocalService.registerReceiver(castRemoteDisplayLocalService.zzh, intentFilter);
            NotificationSettings notificationSettings2 = new NotificationSettings(notificationSettings, 0 == true ? 1 : 0);
            castRemoteDisplayLocalService.zzi = notificationSettings2;
            if (notificationSettings2.zza == null) {
                castRemoteDisplayLocalService.zzk = true;
                castRemoteDisplayLocalService.zzj = castRemoteDisplayLocalService.zzu(false);
            } else {
                castRemoteDisplayLocalService.zzk = false;
                castRemoteDisplayLocalService.zzj = castRemoteDisplayLocalService.zzi.zza;
            }
            castRemoteDisplayLocalService.startForeground(zzb, castRemoteDisplayLocalService.zzj);
            castRemoteDisplayLocalService.zzv("startRemoteDisplay");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
            Preconditions.checkNotNull(castRemoteDisplayLocalService.zzo, "activityContext is required.");
            intent.setPackage(castRemoteDisplayLocalService.zzo.getPackageName());
            PendingIntent zzb2 = com.google.android.gms.internal.cast.zzcn.zzb(castRemoteDisplayLocalService, 0, intent, com.google.android.gms.internal.cast.zzcn.zza);
            zzah zzahVar = new zzah(castRemoteDisplayLocalService);
            Preconditions.checkNotNull(castRemoteDisplayLocalService.zzf, "applicationId is required.");
            castRemoteDisplayLocalService.zzt.zze(castDevice, castRemoteDisplayLocalService.zzf, options.getConfigPreset(), zzb2, zzahVar).addOnCompleteListener(new zzai(castRemoteDisplayLocalService));
            Callbacks callbacks2 = castRemoteDisplayLocalService.zzg.get();
            if (callbacks2 == null) {
                return true;
            }
            callbacks2.onServiceCreated(castRemoteDisplayLocalService);
            return true;
        }
    }

    private final Notification zzu(boolean z10) {
        int i10;
        int i11;
        zzv("createDefaultNotification");
        String str = this.zzi.zzc;
        String str2 = this.zzi.zzd;
        if (z10) {
            i10 = R.string.cast_notification_connected_message;
            i11 = R.drawable.cast_ic_notification_on;
        } else {
            i10 = R.string.cast_notification_connecting_message;
            i11 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(str)) {
            str = (String) getPackageManager().getApplicationLabel(getApplicationInfo());
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(i10, this.zzm.getFriendlyName());
        }
        s.e y10 = new s.e(this, "cast_remote_display_local_service").p(str).o(str2).n(this.zzi.zzb).B(i11).y(true);
        String string = getString(R.string.cast_notification_disconnect);
        if (this.zzl == null) {
            Preconditions.checkNotNull(this.zzo, "activityContext is required.");
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intent.setPackage(this.zzo.getPackageName());
            this.zzl = com.google.android.gms.internal.cast.zzcn.zzb(this, 0, intent, com.google.android.gms.internal.cast.zzcn.zza | 134217728);
        }
        return y10.a(android.R.drawable.ic_menu_close_clear_cancel, string, this.zzl).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str) {
        zza.d("[Instance: %s] %s", this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzw(boolean z10) {
        Logger logger = zza;
        logger.d("Stopping Service", new Object[0]);
        zzd.set(false);
        synchronized (zzc) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zze;
            if (castRemoteDisplayLocalService == null) {
                logger.e("Service is already being stopped", new Object[0]);
                return;
            }
            zze = null;
            if (castRemoteDisplayLocalService.zzq != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    castRemoteDisplayLocalService.zzq.post(new zzaf(castRemoteDisplayLocalService, z10));
                } else {
                    castRemoteDisplayLocalService.zzx(z10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzx(boolean z10) {
        zzv("Stopping Service");
        Preconditions.checkMainThread("stopServiceInstanceInternal must be called on the main thread");
        if (!z10 && this.zzr != null) {
            zzv("Setting default route");
            t0 t0Var = this.zzr;
            t0Var.s(t0Var.g());
        }
        if (this.zzh != null) {
            zzv("Unregistering notification receiver");
            unregisterReceiver(this.zzh);
        }
        zzv("stopRemoteDisplaySession");
        zzv("stopRemoteDisplay");
        this.zzt.stopRemoteDisplay().addOnCompleteListener(new zzaj(this));
        Callbacks callbacks = this.zzg.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionEnded(this);
        }
        onDismissPresentation();
        zzv("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
        if (this.zzr != null) {
            Preconditions.checkMainThread("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzv("removeMediaRouterCallback");
            this.zzr.q(this.zzu);
        }
        Context context = this.zzo;
        ServiceConnection serviceConnection = this.zzp;
        if (context != null && serviceConnection != null) {
            try {
                ConnectionTracker.getInstance().unbindService(context, serviceConnection);
            } catch (IllegalArgumentException unused) {
                zzv("No need to unbind service, already unbound");
            }
        }
        this.zzp = null;
        this.zzo = null;
        this.zzf = null;
        this.zzj = null;
        this.zzn = null;
    }

    @RecentlyNullable
    public Display getCastRemoteDisplay() {
        return this.zzn;
    }

    @Override // android.app.Service
    @RecentlyNonNull
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        zzv("onBind");
        return this.zzv;
    }

    @Override // android.app.Service
    public void onCreate() {
        Object systemService;
        zzv("onCreate");
        super.onCreate();
        com.google.android.gms.internal.cast.zzco zzcoVar = new com.google.android.gms.internal.cast.zzco(getMainLooper());
        this.zzq = zzcoVar;
        zzcoVar.postDelayed(new zzad(this), 100L);
        if (this.zzt == null) {
            this.zzt = CastRemoteDisplay.getClient(this);
        }
        if (PlatformVersion.isAtLeastO()) {
            systemService = getSystemService(NotificationManager.class);
            NotificationChannel notificationChannel = new NotificationChannel("cast_remote_display_local_service", getString(R.string.cast_notification_default_channel_name), 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        }
    }

    public abstract void onCreatePresentation(@RecentlyNonNull Display display);

    public abstract void onDismissPresentation();

    @Override // android.app.Service
    public int onStartCommand(@RecentlyNonNull Intent intent, int i10, int i11) {
        zzv("onStartCommand");
        this.zzs = true;
        return 2;
    }

    public void updateNotificationSettings(@RecentlyNonNull NotificationSettings notificationSettings) {
        Preconditions.checkNotNull(notificationSettings, "notificationSettings is required.");
        Preconditions.checkNotNull(this.zzq, "Service is not ready yet.");
        this.zzq.post(new zzag(this, notificationSettings));
    }
}
