package com.google.android.gms.internal.cast;

import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class zzdw<E> extends zzdq<E> implements Set<E> {

    @CheckForNull
    private transient zzdu<E> zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzed.zza(this);
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public zzdu<E> zzd() {
        zzdu<E> zzduVar = this.zza;
        if (zzduVar != null) {
            return zzduVar;
        }
        zzdu<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    @Override // com.google.android.gms.internal.cast.zzdq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zze */
    public abstract zzee<E> iterator();

    public zzdu<E> zzh() {
        return zzdu.zzj(toArray());
    }
}
