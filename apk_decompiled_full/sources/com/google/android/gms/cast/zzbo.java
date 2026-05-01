package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class zzbo extends com.google.android.gms.cast.internal.zzaf {
    final /* synthetic */ zzbp zza;

    public zzbo(zzbp zzbpVar) {
        this.zza = zzbpVar;
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        this.zza.zzp = applicationMetadata;
        this.zza.zzq = str;
        zzbp.zzC(this.zza, new com.google.android.gms.cast.internal.zzq(new Status(0), applicationMetadata, str, str2, z10));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzc(int i10) {
        this.zza.zzT(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzd(final int i10) {
        Cast.Listener listener;
        zzbp.zzE(this.zza, i10);
        listener = this.zza.zzx;
        if (listener != null) {
            zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbh
                @Override // java.lang.Runnable
                public final void run() {
                    Cast.Listener listener2;
                    zzbo zzboVar = zzbo.this;
                    int i11 = i10;
                    listener2 = zzboVar.zza.zzx;
                    listener2.onApplicationDisconnected(i11);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zze(int i10) {
        zzbp.zzE(this.zza, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzf(final com.google.android.gms.cast.internal.zza zzaVar) {
        zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbl
            @Override // java.lang.Runnable
            public final void run() {
                zzbo zzboVar = zzbo.this;
                zzbp.zzy(zzboVar.zza, zzaVar);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzg(int i10) {
        zzbp.zzE(this.zza, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzh(String str, byte[] bArr) {
        Logger logger;
        logger = zzbp.zzg;
        logger.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzi(final int i10) {
        zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbi
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                List list3;
                List list4;
                zzbo zzboVar = zzbo.this;
                int i11 = i10;
                if (i11 != 0) {
                    zzboVar.zza.zzz = 1;
                    list = zzboVar.zza.zzy;
                    synchronized (list) {
                        list2 = zzboVar.zza.zzy;
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((zzq) it.next()).zzb(i11);
                        }
                    }
                    zzboVar.zza.zzR();
                    return;
                }
                zzboVar.zza.zzz = 2;
                zzboVar.zza.zzk = true;
                zzboVar.zza.zzl = true;
                list3 = zzboVar.zza.zzy;
                synchronized (list3) {
                    list4 = zzboVar.zza.zzy;
                    Iterator it2 = list4.iterator();
                    while (it2.hasNext()) {
                        ((zzq) it2.next()).zza();
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzj(final com.google.android.gms.cast.internal.zzy zzyVar) {
        zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbm
            @Override // java.lang.Runnable
            public final void run() {
                zzbo zzboVar = zzbo.this;
                zzbp.zzz(zzboVar.zza, zzyVar);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzk(final int i10) {
        zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbj
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                zzbo zzboVar = zzbo.this;
                int i11 = i10;
                zzbp.zzx(zzboVar.zza);
                zzboVar.zza.zzz = 1;
                list = zzboVar.zza.zzy;
                synchronized (list) {
                    list2 = zzboVar.zza.zzy;
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((zzq) it.next()).zzd(i11);
                    }
                }
                zzboVar.zza.zzR();
                zzbp zzbpVar = zzboVar.zza;
                zzbpVar.zzP(zzbpVar.zza);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzl(String str, long j10) {
        zzbp.zzD(this.zza, j10, 0);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzm(String str, long j10, int i10) {
        zzbp.zzD(this.zza, j10, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzn(String str, double d10, boolean z10) {
        Logger logger;
        logger = zzbp.zzg;
        logger.d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzo(final int i10) {
        zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbk
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                zzbo zzboVar = zzbo.this;
                int i11 = i10;
                zzboVar.zza.zzz = 3;
                list = zzboVar.zza.zzy;
                synchronized (list) {
                    list2 = zzboVar.zza.zzy;
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((zzq) it.next()).zzc(i11);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzp(final String str, final String str2) {
        Logger logger;
        logger = zzbp.zzg;
        logger.d("Receive (type=text, ns=%s) %s", str, str2);
        zzbp.zzn(this.zza).post(new Runnable() { // from class: com.google.android.gms.cast.zzbn
            @Override // java.lang.Runnable
            public final void run() {
                Cast.MessageReceivedCallback messageReceivedCallback;
                Logger logger2;
                CastDevice castDevice;
                zzbo zzboVar = zzbo.this;
                String str3 = str;
                String str4 = str2;
                synchronized (zzboVar.zza.zze) {
                    messageReceivedCallback = zzboVar.zza.zze.get(str3);
                }
                if (messageReceivedCallback != null) {
                    castDevice = zzboVar.zza.zzw;
                    messageReceivedCallback.onMessageReceived(castDevice, str3, str4);
                } else {
                    logger2 = zzbp.zzg;
                    logger2.d("Discarded message for unknown namespace '%s'", str3);
                }
            }
        });
    }
}
