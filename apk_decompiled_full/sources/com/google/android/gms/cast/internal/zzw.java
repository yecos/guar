package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbq;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class zzw extends GmsClient<zzae> {
    private static final Logger zze = new Logger("CastClientImpl");
    private static final Object zzf = new Object();
    private static final Object zzg = new Object();
    private Bundle zzA;
    private final Map<Long, BaseImplementation.ResultHolder<Status>> zzB;
    private BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> zzC;
    private BaseImplementation.ResultHolder<Status> zzD;
    private ApplicationMetadata zzh;
    private final CastDevice zzi;
    private final Cast.Listener zzj;
    private final Map<String, Cast.MessageReceivedCallback> zzk;
    private final long zzl;
    private final Bundle zzm;
    private zzv zzn;
    private String zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private double zzt;
    private com.google.android.gms.cast.zzar zzu;
    private int zzv;
    private int zzw;
    private final AtomicLong zzx;
    private String zzy;
    private String zzz;

    public zzw(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j10, Cast.Listener listener, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzi = castDevice;
        this.zzj = listener;
        this.zzl = j10;
        this.zzm = bundle;
        this.zzk = new HashMap();
        this.zzx = new AtomicLong(0L);
        this.zzB = new HashMap();
        zzY();
        zzp();
    }

    public static /* bridge */ /* synthetic */ void zzH(zzw zzwVar, zza zzaVar) {
        boolean z10;
        String zza = zzaVar.zza();
        if (CastUtils.zzh(zza, zzwVar.zzo)) {
            z10 = false;
        } else {
            zzwVar.zzo = zza;
            z10 = true;
        }
        zze.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzwVar.zzq));
        Cast.Listener listener = zzwVar.zzj;
        if (listener != null && (z10 || zzwVar.zzq)) {
            listener.onApplicationStatusChanged();
        }
        zzwVar.zzq = false;
    }

    public static /* bridge */ /* synthetic */ void zzI(zzw zzwVar, zzy zzyVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        ApplicationMetadata zze2 = zzyVar.zze();
        if (!CastUtils.zzh(zze2, zzwVar.zzh)) {
            zzwVar.zzh = zze2;
            zzwVar.zzj.onApplicationMetadataChanged(zze2);
        }
        double zzb = zzyVar.zzb();
        if (Double.isNaN(zzb) || Math.abs(zzb - zzwVar.zzt) <= 1.0E-7d) {
            z10 = false;
        } else {
            zzwVar.zzt = zzb;
            z10 = true;
        }
        boolean zzg2 = zzyVar.zzg();
        if (zzg2 != zzwVar.zzp) {
            zzwVar.zzp = zzg2;
            z10 = true;
        }
        Double.isNaN(zzyVar.zza());
        Logger logger = zze;
        logger.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzwVar.zzr));
        Cast.Listener listener = zzwVar.zzj;
        if (listener != null && (z10 || zzwVar.zzr)) {
            listener.onVolumeChanged();
        }
        int zzc = zzyVar.zzc();
        if (zzc != zzwVar.zzv) {
            zzwVar.zzv = zzc;
            z11 = true;
        } else {
            z11 = false;
        }
        logger.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(zzwVar.zzr));
        Cast.Listener listener2 = zzwVar.zzj;
        if (listener2 != null && (z11 || zzwVar.zzr)) {
            listener2.onActiveInputStateChanged(zzwVar.zzv);
        }
        int zzd = zzyVar.zzd();
        if (zzd != zzwVar.zzw) {
            zzwVar.zzw = zzd;
            z12 = true;
        } else {
            z12 = false;
        }
        logger.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(zzwVar.zzr));
        Cast.Listener listener3 = zzwVar.zzj;
        if (listener3 != null && (z12 || zzwVar.zzr)) {
            listener3.onStandbyStateChanged(zzwVar.zzw);
        }
        if (!CastUtils.zzh(zzwVar.zzu, zzyVar.zzf())) {
            zzwVar.zzu = zzyVar.zzf();
        }
        zzwVar.zzr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzY() {
        this.zzs = false;
        this.zzv = -1;
        this.zzw = -1;
        this.zzh = null;
        this.zzo = null;
        this.zzt = 0.0d;
        zzp();
        this.zzp = false;
        this.zzu = null;
    }

    private final void zzZ() {
        zze.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzk) {
            this.zzk.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(long j10, int i10) {
        BaseImplementation.ResultHolder<Status> remove;
        synchronized (this.zzB) {
            remove = this.zzB.remove(Long.valueOf(j10));
        }
        if (remove != null) {
            remove.setResult(new Status(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzab(int i10) {
        synchronized (zzg) {
            BaseImplementation.ResultHolder<Status> resultHolder = this.zzD;
            if (resultHolder != null) {
                resultHolder.setResult(new Status(i10));
                this.zzD = null;
            }
        }
    }

    private final void zzac(BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder) {
        synchronized (zzf) {
            BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder2 = this.zzC;
            if (resultHolder2 != null) {
                resultHolder2.setResult(new zzq(new Status(2477), null, null, null, false));
            }
            this.zzC = resultHolder;
        }
    }

    private final void zzad(BaseImplementation.ResultHolder<Status> resultHolder) {
        synchronized (zzg) {
            if (this.zzD != null) {
                resultHolder.setResult(new Status(CastStatusCodes.INVALID_REQUEST));
            } else {
                this.zzD = resultHolder;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return queryLocalInterface instanceof zzae ? (zzae) queryLocalInterface : new zzae(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        Logger logger = zze;
        logger.d("disconnect(); ServiceListener=%s, isConnected=%b", this.zzn, Boolean.valueOf(isConnected()));
        zzv zzvVar = this.zzn;
        this.zzn = null;
        if (zzvVar == null || zzvVar.zzq() == null) {
            logger.d("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzZ();
        try {
            try {
                ((zzae) getService()).zzf();
            } finally {
                super.disconnect();
            }
        } catch (RemoteException | IllegalStateException e10) {
            zze.d(e10, "Error while disconnecting the controller interface", new Object[0]);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        Bundle bundle = this.zzA;
        if (bundle == null) {
            return super.getConnectionHint();
        }
        this.zzA = null;
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        zze.d("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzy, this.zzz);
        this.zzi.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzl);
        Bundle bundle2 = this.zzm;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        this.zzn = new zzv(this);
        bundle.putParcelable(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new BinderWrapper(this.zzn));
        String str = this.zzy;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.zzz;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        zzZ();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i10, IBinder iBinder, Bundle bundle, int i11) {
        zze.d("in onPostInitHandler; statusCode=%d", Integer.valueOf(i10));
        if (i10 == 0 || i10 == 2300) {
            this.zzs = true;
            this.zzq = true;
            this.zzr = true;
        } else {
            this.zzs = false;
        }
        if (i10 == 2300) {
            Bundle bundle2 = new Bundle();
            this.zzA = bundle2;
            bundle2.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i10 = 0;
        }
        super.onPostInitHandler(i10, iBinder, bundle, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzL(String str, String str2, zzbq zzbqVar, BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder) {
        zzac(resultHolder);
        zzbq zzbqVar2 = new zzbq();
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzg(str, str2, zzbqVar2);
        } else {
            zzR(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzM(String str, LaunchOptions launchOptions, BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder) {
        zzac(resultHolder);
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzh(str, launchOptions);
        } else {
            zzR(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzN(BaseImplementation.ResultHolder<Status> resultHolder) {
        zzad(resultHolder);
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzi();
        } else {
            zzab(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzO(String str) {
        Cast.MessageReceivedCallback remove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzk) {
            remove = this.zzk.remove(str);
        }
        if (remove != null) {
            try {
                ((zzae) getService()).zzr(str);
            } catch (IllegalStateException e10) {
                zze.d(e10, "Error unregistering namespace (%s)", str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzP() {
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzl();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzQ(String str, String str2, BaseImplementation.ResultHolder<Status> resultHolder) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 524288) {
            zze.w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        CastUtils.throwIfInvalidNamespace(str);
        long incrementAndGet = this.zzx.incrementAndGet();
        try {
            this.zzB.put(Long.valueOf(incrementAndGet), resultHolder);
            zzae zzaeVar = (zzae) getService();
            if (zzW()) {
                zzaeVar.zzm(str, str2, incrementAndGet);
            } else {
                zzaa(incrementAndGet, CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
            }
        } catch (Throwable th) {
            this.zzB.remove(Long.valueOf(incrementAndGet));
            throw th;
        }
    }

    public final void zzR(int i10) {
        synchronized (zzf) {
            BaseImplementation.ResultHolder<Cast.ApplicationConnectionResult> resultHolder = this.zzC;
            if (resultHolder != null) {
                resultHolder.setResult(new zzq(new Status(i10), null, null, null, false));
                this.zzC = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzS(String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        CastUtils.throwIfInvalidNamespace(str);
        zzO(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzk) {
                this.zzk.put(str, messageReceivedCallback);
            }
            zzae zzaeVar = (zzae) getService();
            if (zzW()) {
                zzaeVar.zzk(str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzT(boolean z10) {
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzn(z10, this.zzt, this.zzp);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzU(double d10) {
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d10);
            throw new IllegalArgumentException(sb.toString());
        }
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzo(d10, this.zzt, this.zzp);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzV(String str, BaseImplementation.ResultHolder<Status> resultHolder) {
        zzad(resultHolder);
        zzae zzaeVar = (zzae) getService();
        if (zzW()) {
            zzaeVar.zzp(str);
        } else {
            zzab(CastStatusCodes.DEVICE_CONNECTION_SUSPENDED);
        }
    }

    @VisibleForTesting
    public final boolean zzW() {
        zzv zzvVar;
        return (!this.zzs || (zzvVar = this.zzn) == null || zzvVar.zzr()) ? false : true;
    }

    public final boolean zzX() {
        checkConnected();
        return this.zzp;
    }

    @VisibleForTesting
    public final double zzp() {
        Preconditions.checkNotNull(this.zzi, "device should not be null");
        if (this.zzi.hasCapability(2048)) {
            return 0.02d;
        }
        return (!this.zzi.hasCapability(4) || this.zzi.hasCapability(1) || "Chromecast Audio".equals(this.zzi.getModelName())) ? 0.05d : 0.02d;
    }

    public final double zzq() {
        checkConnected();
        return this.zzt;
    }

    public final int zzr() {
        checkConnected();
        return this.zzv;
    }

    public final int zzs() {
        checkConnected();
        return this.zzw;
    }

    public final ApplicationMetadata zzt() {
        checkConnected();
        return this.zzh;
    }

    public final String zzz() {
        checkConnected();
        return this.zzo;
    }
}
