package com.google.android.gms.cast;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class zzbp extends GoogleApi<Cast.CastOptions> implements zzr {
    public static final /* synthetic */ int zzf = 0;
    private static final Logger zzg = new Logger("CastClient");
    private static final Api.AbstractClientBuilder<com.google.android.gms.cast.internal.zzx, Cast.CastOptions> zzh;
    private static final Api<Cast.CastOptions> zzi;
    final zzbo zza;
    TaskCompletionSource<Cast.ApplicationConnectionResult> zzb;
    TaskCompletionSource<Status> zzc;
    final Map<Long, TaskCompletionSource<Void>> zzd;
    final Map<String, Cast.MessageReceivedCallback> zze;
    private Handler zzj;
    private boolean zzk;
    private boolean zzl;
    private final AtomicLong zzm;
    private final Object zzn;
    private final Object zzo;
    private ApplicationMetadata zzp;
    private String zzq;
    private double zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private zzar zzv;
    private final CastDevice zzw;
    private final Cast.Listener zzx;
    private final List<zzq> zzy;
    private int zzz;

    static {
        zzbg zzbgVar = new zzbg();
        zzh = zzbgVar;
        zzi = new Api<>("Cast.API_CXLESS", zzbgVar, com.google.android.gms.cast.internal.zzai.zzb);
    }

    public zzbp(Context context, Cast.CastOptions castOptions) {
        super(context, zzi, castOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zza = new zzbo(this);
        this.zzn = new Object();
        this.zzo = new Object();
        this.zzy = Collections.synchronizedList(new ArrayList());
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(castOptions, "CastOptions cannot be null");
        this.zzx = castOptions.zzb;
        this.zzw = castOptions.zza;
        this.zzd = new HashMap();
        this.zze = new HashMap();
        this.zzm = new AtomicLong(0L);
        this.zzz = 1;
        zzm();
    }

    public static /* bridge */ /* synthetic */ void zzC(zzbp zzbpVar, Cast.ApplicationConnectionResult applicationConnectionResult) {
        synchronized (zzbpVar.zzn) {
            TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource = zzbpVar.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(applicationConnectionResult);
            }
            zzbpVar.zzb = null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzD(zzbp zzbpVar, long j10, int i10) {
        TaskCompletionSource<Void> taskCompletionSource;
        synchronized (zzbpVar.zzd) {
            Map<Long, TaskCompletionSource<Void>> map = zzbpVar.zzd;
            Long valueOf = Long.valueOf(j10);
            taskCompletionSource = map.get(valueOf);
            zzbpVar.zzd.remove(valueOf);
        }
        if (taskCompletionSource != null) {
            if (i10 == 0) {
                taskCompletionSource.setResult(null);
            } else {
                taskCompletionSource.setException(zzO(i10));
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zzE(zzbp zzbpVar, int i10) {
        synchronized (zzbpVar.zzo) {
            TaskCompletionSource<Status> taskCompletionSource = zzbpVar.zzc;
            if (taskCompletionSource == null) {
                return;
            }
            if (i10 == 0) {
                taskCompletionSource.setResult(new Status(0));
            } else {
                taskCompletionSource.setException(zzO(i10));
            }
            zzbpVar.zzc = null;
        }
    }

    private static ApiException zzO(int i10) {
        return ApiExceptionUtil.fromStatus(new Status(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Task<Boolean> zzP(com.google.android.gms.cast.internal.zzag zzagVar) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListener(zzagVar, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null"), 8415);
    }

    private final void zzQ() {
        Preconditions.checkState(this.zzz == 2, "Not connected to device");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzR() {
        zzg.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
        }
    }

    private final void zzS(TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource) {
        synchronized (this.zzn) {
            if (this.zzb != null) {
                zzT(2477);
            }
            this.zzb = taskCompletionSource;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzT(int i10) {
        synchronized (this.zzn) {
            TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource = this.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setException(zzO(i10));
            }
            this.zzb = null;
        }
    }

    private final void zzU() {
        Preconditions.checkState(this.zzz != 1, "Not active connection");
    }

    public static /* bridge */ /* synthetic */ Handler zzn(zzbp zzbpVar) {
        if (zzbpVar.zzj == null) {
            zzbpVar.zzj = new com.google.android.gms.internal.cast.zzco(zzbpVar.getLooper());
        }
        return zzbpVar.zzj;
    }

    public static /* bridge */ /* synthetic */ void zzx(zzbp zzbpVar) {
        zzbpVar.zzt = -1;
        zzbpVar.zzu = -1;
        zzbpVar.zzp = null;
        zzbpVar.zzq = null;
        zzbpVar.zzr = 0.0d;
        zzbpVar.zzm();
        zzbpVar.zzs = false;
        zzbpVar.zzv = null;
    }

    public static /* bridge */ /* synthetic */ void zzy(zzbp zzbpVar, com.google.android.gms.cast.internal.zza zzaVar) {
        boolean z10;
        String zza = zzaVar.zza();
        if (CastUtils.zzh(zza, zzbpVar.zzq)) {
            z10 = false;
        } else {
            zzbpVar.zzq = zza;
            z10 = true;
        }
        zzg.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzbpVar.zzl));
        Cast.Listener listener = zzbpVar.zzx;
        if (listener != null && (z10 || zzbpVar.zzl)) {
            listener.onApplicationStatusChanged();
        }
        zzbpVar.zzl = false;
    }

    public static /* bridge */ /* synthetic */ void zzz(zzbp zzbpVar, com.google.android.gms.cast.internal.zzy zzyVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        ApplicationMetadata zze = zzyVar.zze();
        if (!CastUtils.zzh(zze, zzbpVar.zzp)) {
            zzbpVar.zzp = zze;
            zzbpVar.zzx.onApplicationMetadataChanged(zze);
        }
        double zzb = zzyVar.zzb();
        if (Double.isNaN(zzb) || Math.abs(zzb - zzbpVar.zzr) <= 1.0E-7d) {
            z10 = false;
        } else {
            zzbpVar.zzr = zzb;
            z10 = true;
        }
        boolean zzg2 = zzyVar.zzg();
        if (zzg2 != zzbpVar.zzs) {
            zzbpVar.zzs = zzg2;
            z10 = true;
        }
        Logger logger = zzg;
        logger.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzbpVar.zzk));
        Cast.Listener listener = zzbpVar.zzx;
        if (listener != null && (z10 || zzbpVar.zzk)) {
            listener.onVolumeChanged();
        }
        Double.isNaN(zzyVar.zza());
        int zzc = zzyVar.zzc();
        if (zzc != zzbpVar.zzt) {
            zzbpVar.zzt = zzc;
            z11 = true;
        } else {
            z11 = false;
        }
        logger.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(zzbpVar.zzk));
        Cast.Listener listener2 = zzbpVar.zzx;
        if (listener2 != null && (z11 || zzbpVar.zzk)) {
            listener2.onActiveInputStateChanged(zzbpVar.zzt);
        }
        int zzd = zzyVar.zzd();
        if (zzd != zzbpVar.zzu) {
            zzbpVar.zzu = zzd;
            z12 = true;
        } else {
            z12 = false;
        }
        logger.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(zzbpVar.zzk));
        Cast.Listener listener3 = zzbpVar.zzx;
        if (listener3 != null && (z12 || zzbpVar.zzk)) {
            listener3.onStandbyStateChanged(zzbpVar.zzu);
        }
        if (!CastUtils.zzh(zzbpVar.zzv, zzyVar.zzf())) {
            zzbpVar.zzv = zzyVar.zzf();
        }
        zzbpVar.zzk = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzF(String str, String str2, zzbq zzbqVar, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzQ();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzg(str, str2, null);
        zzS(taskCompletionSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzG(String str, LaunchOptions launchOptions, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzQ();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzh(str, launchOptions);
        zzS(taskCompletionSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzH(Cast.MessageReceivedCallback messageReceivedCallback, String str, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzU();
        if (messageReceivedCallback != null) {
            ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzr(str);
        }
        taskCompletionSource.setResult(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzI(String str, String str2, String str3, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        long incrementAndGet = this.zzm.incrementAndGet();
        zzQ();
        try {
            this.zzd.put(Long.valueOf(incrementAndGet), taskCompletionSource);
            ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzm(str2, str3, incrementAndGet);
        } catch (RemoteException e10) {
            this.zzd.remove(Long.valueOf(incrementAndGet));
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzJ(String str, Cast.MessageReceivedCallback messageReceivedCallback, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzU();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzr(str);
        if (messageReceivedCallback != null) {
            ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzk(str);
        }
        taskCompletionSource.setResult(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzK(boolean z10, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzn(z10, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzL(double d10, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzo(d10, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzM(String str, com.google.android.gms.cast.internal.zzx zzxVar, TaskCompletionSource taskCompletionSource) {
        zzQ();
        ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzp(str);
        synchronized (this.zzo) {
            if (this.zzc != null) {
                taskCompletionSource.setException(zzO(CastStatusCodes.INVALID_REQUEST));
            } else {
                this.zzc = taskCompletionSource;
            }
        }
    }

    @Override // com.google.android.gms.cast.zzr
    public final double zza() {
        zzQ();
        return this.zzr;
    }

    @Override // com.google.android.gms.cast.zzr
    public final int zzb() {
        zzQ();
        return this.zzt;
    }

    @Override // com.google.android.gms.cast.zzr
    public final int zzc() {
        zzQ();
        return this.zzu;
    }

    @Override // com.google.android.gms.cast.zzr
    public final ApplicationMetadata zzd() {
        zzQ();
        return this.zzp;
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task<Void> zze() {
        Object registerListener = registerListener(this.zza, "castDeviceControllerListenerKey");
        RegistrationMethods.Builder builder = RegistrationMethods.builder();
        return doRegisterEventListener(builder.withHolder(registerListener).register(new RemoteCall() { // from class: com.google.android.gms.cast.zzay
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) obj;
                ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zzj(zzbp.this.zza);
                ((com.google.android.gms.cast.internal.zzae) zzxVar.getService()).zze();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.cast.zzav
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i10 = zzbp.zzf;
                ((com.google.android.gms.cast.internal.zzae) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzq();
                ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
            }
        }).setFeatures(zzat.zzb).setMethodKey(8428).build());
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task<Void> zzf() {
        Task doWrite = doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzaw
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i10 = zzbp.zzf;
                ((com.google.android.gms.cast.internal.zzae) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzf();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).setMethodKey(8403).build());
        zzR();
        zzP(this.zza);
        return doWrite;
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task<Void> zzg(final String str) {
        final Cast.MessageReceivedCallback remove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zze) {
            remove = this.zze.remove(str);
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzba
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbp.this.zzH(remove, str, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8414).build());
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task<Void> zzh(final String str, final String str2) {
        CastUtils.throwIfInvalidNamespace(str);
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() <= 524288) {
            final String str3 = null;
            return doWrite(TaskApiCall.builder().run(new RemoteCall(str3, str, str2) { // from class: com.google.android.gms.cast.zzbf
                public final /* synthetic */ String zzb;
                public final /* synthetic */ String zzc;

                {
                    this.zzb = str;
                    this.zzc = str2;
                }

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzbp.this.zzI(null, this.zzb, this.zzc, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(8405).build());
        }
        zzg.w("Message send failed. Message exceeds maximum size", new Object[0]);
        throw new IllegalArgumentException("Message exceeds maximum size524288");
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task<Void> zzi(final String str, final Cast.MessageReceivedCallback messageReceivedCallback) {
        CastUtils.throwIfInvalidNamespace(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zze) {
                this.zze.put(str, messageReceivedCallback);
            }
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbp.this.zzJ(str, messageReceivedCallback, (com.google.android.gms.cast.internal.zzx) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(8413).build());
    }

    @Override // com.google.android.gms.cast.zzr
    public final String zzj() {
        zzQ();
        return this.zzq;
    }

    @Override // com.google.android.gms.cast.zzr
    public final void zzk(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        this.zzy.add(zzqVar);
    }

    @Override // com.google.android.gms.cast.zzr
    public final boolean zzl() {
        zzQ();
        return this.zzs;
    }

    public final double zzm() {
        if (this.zzw.hasCapability(2048)) {
            return 0.02d;
        }
        return (!this.zzw.hasCapability(4) || this.zzw.hasCapability(1) || "Chromecast Audio".equals(this.zzw.getModelName())) ? 0.05d : 0.02d;
    }
}
