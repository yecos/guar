package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* loaded from: classes.dex */
public abstract class zzcv {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j10);

    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new Choreographer.FrameCallback() { // from class: com.google.android.gms.internal.cast.zzct
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    zzcv.this.zza(j10);
                }
            };
        }
        return this.zzb;
    }

    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new Runnable() { // from class: com.google.android.gms.internal.cast.zzcu
                @Override // java.lang.Runnable
                public final void run() {
                    zzcv.this.zza(System.nanoTime());
                }
            };
        }
        return this.zza;
    }
}
