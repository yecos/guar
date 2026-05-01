package com.google.android.gms.internal.cast;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.gms.cast.framework.CastOptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import n0.o1;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public final class zzaj extends zzr {
    private final t0 zza;
    private final Map<s0, Set<t0.b>> zzb = new HashMap();
    private zzar zzc;

    public zzaj(t0 t0Var, CastOptions castOptions) {
        this.zza = t0Var;
        if (Build.VERSION.SDK_INT > 30) {
            boolean zzc = castOptions.zzc();
            boolean zzd = castOptions.zzd();
            t0Var.v(new o1.a().b(zzc).c(zzd).a());
            if (zzc) {
                zzl.zzd(zzju.CAST_OUTPUT_SWITCHER_ENABLED);
            }
            if (zzd) {
                this.zzc = new zzar();
                t0Var.u(new zzag(this.zzc));
                zzl.zzd(zzju.CAST_TRANSFER_TO_LOCAL_ENABLED);
            }
        }
    }

    private final void zzr(s0 s0Var, int i10) {
        Iterator<t0.b> it = this.zzb.get(s0Var).iterator();
        while (it.hasNext()) {
            this.zza.b(s0Var, it.next(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public final void zzp(s0 s0Var) {
        Iterator<t0.b> it = this.zzb.get(s0Var).iterator();
        while (it.hasNext()) {
            this.zza.q(it.next());
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final Bundle zzb(String str) {
        for (t0.i iVar : this.zza.l()) {
            if (iVar.k().equals(str)) {
                return iVar.i();
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final String zzc() {
        return this.zza.m().k();
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzd(Bundle bundle, final int i10) {
        final s0 d10 = s0.d(bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzr(d10, i10);
        } else {
            new zzco(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzai
                @Override // java.lang.Runnable
                public final void run() {
                    zzaj.this.zzo(d10, i10);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zze(Bundle bundle, zzu zzuVar) {
        s0 d10 = s0.d(bundle);
        if (!this.zzb.containsKey(d10)) {
            this.zzb.put(d10, new HashSet());
        }
        this.zzb.get(d10).add(new zzae(zzuVar));
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzf() {
        Iterator<Set<t0.b>> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            Iterator<t0.b> it2 = it.next().iterator();
            while (it2.hasNext()) {
                this.zza.q(it2.next());
            }
        }
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzg(Bundle bundle) {
        final s0 d10 = s0.d(bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzp(d10);
        } else {
            new zzco(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzah
                @Override // java.lang.Runnable
                public final void run() {
                    zzaj.this.zzp(d10);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzh() {
        t0 t0Var = this.zza;
        t0Var.s(t0Var.g());
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzi(String str) {
        for (t0.i iVar : this.zza.l()) {
            if (iVar.k().equals(str)) {
                this.zza.s(iVar);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final void zzj(int i10) {
        this.zza.x(i10);
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final boolean zzk() {
        t0.i f10 = this.zza.f();
        return f10 != null && this.zza.m().k().equals(f10.k());
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final boolean zzl() {
        t0.i g10 = this.zza.g();
        return g10 != null && this.zza.m().k().equals(g10.k());
    }

    @Override // com.google.android.gms.internal.cast.zzs
    public final boolean zzm(Bundle bundle, int i10) {
        return this.zza.o(s0.d(bundle), i10);
    }

    public final zzar zzn() {
        return this.zzc;
    }

    public final /* synthetic */ void zzo(s0 s0Var, int i10) {
        synchronized (this.zzb) {
            zzr(s0Var, i10);
        }
    }

    public final void zzq(MediaSessionCompat mediaSessionCompat) {
        this.zza.t(mediaSessionCompat);
    }
}
