package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzju;
import com.google.android.gms.internal.cast.zzku;
import com.google.android.gms.internal.cast.zzol;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class CastContext {

    @RecentlyNonNull
    public static final String OPTIONS_PROVIDER_CLASS_NAME_KEY = "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME";
    private static final Logger zza = new Logger("CastContext");
    private static final Object zzb = new Object();
    private static CastContext zzc;
    private final Context zzd;
    private final zzw zze;
    private final SessionManager zzf;
    private final zzr zzg;
    private final PrecacheManager zzh;
    private final MediaNotificationManager zzi;
    private final CastOptions zzj;
    private final com.google.android.gms.internal.cast.zzaj zzk;
    private final List<SessionProvider> zzl;
    private com.google.android.gms.internal.cast.zzo zzm;
    private CastReasonCodes zzn;

    private CastContext(Context context, CastOptions castOptions, List<SessionProvider> list, com.google.android.gms.internal.cast.zzaj zzajVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zzj = castOptions;
        this.zzk = zzajVar;
        this.zzl = list;
        zzi();
        try {
            zzw zza2 = com.google.android.gms.internal.cast.zzm.zza(applicationContext, castOptions, zzajVar, zzh());
            this.zze = zza2;
            try {
                this.zzg = new zzr(zza2.zzf());
                try {
                    SessionManager sessionManager = new SessionManager(zza2.zzg(), applicationContext);
                    this.zzf = sessionManager;
                    this.zzi = new MediaNotificationManager(sessionManager);
                    this.zzh = new PrecacheManager(castOptions, sessionManager, new com.google.android.gms.cast.internal.zzn(applicationContext));
                    com.google.android.gms.internal.cast.zzar zzn = zzajVar.zzn();
                    if (zzn != null) {
                        zzn.zzc(sessionManager);
                    }
                    final com.google.android.gms.cast.internal.zzn zznVar = new com.google.android.gms.cast.internal.zzn(applicationContext);
                    final String[] strArr = {"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"};
                    zznVar.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.internal.zze
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.android.gms.common.api.internal.RemoteCall
                        public final void accept(Object obj, Object obj2) {
                            zzn zznVar2 = zzn.this;
                            String[] strArr2 = strArr;
                            ((zzah) ((zzo) obj).getService()).zzf(new zzk(zznVar2, (TaskCompletionSource) obj2), strArr2);
                        }
                    }).setFeatures(com.google.android.gms.cast.zzat.zzd).setAutoResolveMissingFeatures(false).setMethodKey(8425).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzc
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            CastContext.zzc(CastContext.this, (Bundle) obj);
                        }
                    });
                    final com.google.android.gms.cast.internal.zzn zznVar2 = new com.google.android.gms.cast.internal.zzn(applicationContext);
                    final String[] strArr2 = {"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"};
                    zznVar2.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.internal.zzf
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.android.gms.common.api.internal.RemoteCall
                        public final void accept(Object obj, Object obj2) {
                            zzn zznVar3 = zzn.this;
                            String[] strArr3 = strArr2;
                            ((zzah) ((zzo) obj).getService()).zzg(new zzm(zznVar3, (TaskCompletionSource) obj2), strArr3);
                        }
                    }).setFeatures(com.google.android.gms.cast.zzat.zzh).setAutoResolveMissingFeatures(false).setMethodKey(8427).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzb
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            CastContext.this.zze((Bundle) obj);
                        }
                    });
                } catch (RemoteException e10) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e10);
                }
            } catch (RemoteException e11) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e11);
            }
        } catch (RemoteException e12) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e12);
        }
    }

    @RecentlyNullable
    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return zzc;
    }

    @RecentlyNullable
    public static CastContext zza(@RecentlyNonNull Context context) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return getSharedInstance(context);
        } catch (RuntimeException e10) {
            zza.e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e10);
            return null;
        }
    }

    public static /* synthetic */ void zzc(@RecentlyNonNull final CastContext castContext, @RecentlyNonNull Bundle bundle) {
        boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED");
        boolean z11 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED");
        if (!z10) {
            if (!z11) {
                return;
            } else {
                z11 = true;
            }
        }
        String packageName = castContext.zzd.getPackageName();
        String format = String.format(Locale.ROOT, "%s.%s", castContext.zzd.getPackageName(), "client_cast_analytics_data");
        TransportRuntime.initialize(castContext.zzd);
        Transport transport = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("CAST_SENDER_SDK", zzku.class, new Transformer() { // from class: com.google.android.gms.cast.framework.zza
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                zzku zzkuVar = (zzku) obj;
                try {
                    byte[] bArr = new byte[zzkuVar.zzq()];
                    zzol zzC = zzol.zzC(bArr);
                    zzkuVar.zzB(zzC);
                    zzC.zzD();
                    return bArr;
                } catch (IOException e10) {
                    String name = zzkuVar.getClass().getName();
                    StringBuilder sb = new StringBuilder(name.length() + 72);
                    sb.append("Serializing ");
                    sb.append(name);
                    sb.append(" to a byte array threw an IOException (should never happen).");
                    throw new RuntimeException(sb.toString(), e10);
                }
            }
        });
        long j10 = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE");
        final SharedPreferences sharedPreferences = castContext.zzd.getApplicationContext().getSharedPreferences(format, 0);
        final com.google.android.gms.internal.cast.zzd zza2 = com.google.android.gms.internal.cast.zzd.zza(sharedPreferences, transport, j10);
        if (z10) {
            final com.google.android.gms.cast.internal.zzn zznVar = new com.google.android.gms.cast.internal.zzn(castContext.zzd);
            final String[] strArr = {"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"};
            zznVar.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.internal.zzg
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzn zznVar2 = zzn.this;
                    String[] strArr2 = strArr;
                    ((zzah) ((zzo) obj).getService()).zzh(new zzl(zznVar2, (TaskCompletionSource) obj2), strArr2);
                }
            }).setFeatures(com.google.android.gms.cast.zzat.zzg).setAutoResolveMissingFeatures(false).setMethodKey(8426).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzd
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    CastContext.this.zzd(zza2, sharedPreferences, (Bundle) obj);
                }
            });
        }
        if (z11) {
            Preconditions.checkNotNull(sharedPreferences);
            Preconditions.checkNotNull(zza2);
            com.google.android.gms.internal.cast.zzl.zza(sharedPreferences, zza2, packageName);
            com.google.android.gms.internal.cast.zzl.zzd(zzju.CAST_CONTEXT);
        }
    }

    private static OptionsProvider zzg(Context context) {
        try {
            Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                zza.e("Bundle is null", new Object[0]);
            }
            String string = bundle.getString(OPTIONS_PROVIDER_CLASS_NAME_KEY);
            if (string != null) {
                return (OptionsProvider) Class.forName(string).asSubclass(OptionsProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e10) {
            throw new IllegalStateException("Failed to initialize CastContext.", e10);
        }
    }

    private final Map<String, IBinder> zzh() {
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.cast.zzo zzoVar = this.zzm;
        if (zzoVar != null) {
            hashMap.put(zzoVar.getCategory(), this.zzm.zza());
        }
        List<SessionProvider> list = this.zzl;
        if (list != null) {
            for (SessionProvider sessionProvider : list) {
                Preconditions.checkNotNull(sessionProvider, "Additional SessionProvider must not be null.");
                String checkNotEmpty = Preconditions.checkNotEmpty(sessionProvider.getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!hashMap.containsKey(checkNotEmpty), String.format("SessionProvider for category %s already added", checkNotEmpty));
                hashMap.put(checkNotEmpty, sessionProvider.zza());
            }
        }
        return hashMap;
    }

    private final void zzi() {
        this.zzm = !TextUtils.isEmpty(this.zzj.getReceiverApplicationId()) ? new com.google.android.gms.internal.cast.zzo(this.zzd, this.zzj, this.zzk) : null;
    }

    private static final boolean zzj(CastSession castSession, double d10, boolean z10) {
        if (z10) {
            try {
                double volume = castSession.getVolume() + d10;
                if (volume > 1.0d) {
                    volume = 1.0d;
                }
                castSession.setVolume(volume);
            } catch (IOException | IllegalStateException e10) {
                zza.e("Unable to call CastSession.setVolume(double).", e10);
            }
        }
        return true;
    }

    @Deprecated
    public void addAppVisibilityListener(@RecentlyNonNull AppVisibilityListener appVisibilityListener) {
    }

    public void addCastStateListener(@RecentlyNonNull CastStateListener castStateListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(castStateListener);
        this.zzf.zzc(castStateListener);
    }

    @RecentlyNonNull
    public CastOptions getCastOptions() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public int getCastReasonCodeForCastStatusCode(int i10) {
        CastReasonCodes castReasonCodes = this.zzn;
        if (castReasonCodes != null) {
            return castReasonCodes.zza(i10);
        }
        zza.w("castReasonCodes hasn't been initialized yet", new Object[0]);
        return 0;
    }

    public int getCastState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzf.zza();
    }

    @RecentlyNonNull
    public MediaNotificationManager getMediaNotificationManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    @RecentlyNullable
    public s0 getMergedSelector() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return s0.d(this.zze.zze());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "getMergedSelectorAsBundle", zzw.class.getSimpleName());
            return null;
        }
    }

    @RecentlyNonNull
    public PrecacheManager getPrecacheManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    @RecentlyNonNull
    public SessionManager getSessionManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzf;
    }

    @Deprecated
    public boolean isAppVisible() {
        return false;
    }

    public boolean onDispatchVolumeKeyEventBeforeJellyBean(@RecentlyNonNull KeyEvent keyEvent) {
        CastSession currentCastSession;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (PlatformVersion.isAtLeastJellyBean() || (currentCastSession = this.zzf.getCurrentCastSession()) == null || !currentCastSession.isConnected()) {
            return false;
        }
        double volumeDeltaBeforeIceCreamSandwich = getCastOptions().getVolumeDeltaBeforeIceCreamSandwich();
        boolean z10 = keyEvent.getAction() == 0;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24) {
            zzj(currentCastSession, volumeDeltaBeforeIceCreamSandwich, z10);
            return true;
        }
        if (keyCode != 25) {
            return false;
        }
        zzj(currentCastSession, -volumeDeltaBeforeIceCreamSandwich, z10);
        return true;
    }

    @Deprecated
    public void removeAppVisibilityListener(@RecentlyNonNull AppVisibilityListener appVisibilityListener) {
    }

    public void removeCastStateListener(@RecentlyNonNull CastStateListener castStateListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (castStateListener == null) {
            return;
        }
        this.zzf.zzd(castStateListener);
    }

    public void setLaunchCredentialsData(@RecentlyNonNull CredentialsData credentialsData) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder(this.zzj.getLaunchOptions());
        builder.setCredentialsData(credentialsData);
        this.zzj.zza(builder.build());
        zzi();
    }

    public void setReceiverApplicationId(@RecentlyNonNull String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (TextUtils.equals(str, this.zzj.getReceiverApplicationId())) {
            return;
        }
        this.zzj.zzb(str);
        zzi();
        try {
            this.zze.zzh(str, zzh());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "setReceiverApplicationId", zzw.class.getSimpleName());
        }
        CastButtonFactory.zza(this.zzd);
    }

    @ShowFirstParty
    public final zzr zzb() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg;
    }

    public final /* synthetic */ void zzd(com.google.android.gms.internal.cast.zzd zzdVar, SharedPreferences sharedPreferences, Bundle bundle) {
        Preconditions.checkNotNull(this.zzf);
        String packageName = this.zzd.getPackageName();
        new com.google.android.gms.internal.cast.zzh(sharedPreferences, zzdVar, bundle, packageName).zzn(this.zzf);
    }

    public final /* synthetic */ void zze(Bundle bundle) {
        this.zzn = new CastReasonCodes(bundle);
    }

    public final boolean zzf() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return this.zze.zzi();
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "hasActivityInRecents", zzw.class.getSimpleName());
            return false;
        }
    }

    @RecentlyNonNull
    public static CastContext getSharedInstance(@RecentlyNonNull Context context) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzc == null) {
            synchronized (zzb) {
                if (zzc == null) {
                    OptionsProvider zzg = zzg(context.getApplicationContext());
                    CastOptions castOptions = zzg.getCastOptions(context.getApplicationContext());
                    try {
                        zzc = new CastContext(context, castOptions, zzg.getAdditionalSessionProviders(context.getApplicationContext()), new com.google.android.gms.internal.cast.zzaj(t0.i(context), castOptions));
                    } catch (zzat e10) {
                        throw new RuntimeException(e10);
                    }
                }
            }
        }
        return zzc;
    }
}
