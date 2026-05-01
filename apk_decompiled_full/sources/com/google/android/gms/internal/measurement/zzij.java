package com.google.android.gms.internal.measurement;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzij implements Serializable, zzii {
    final zzii zza;
    volatile transient boolean zzb;

    @CheckForNull
    transient Object zzc;

    public zzij(zzii zziiVar) {
        zziiVar.getClass();
        this.zza = zziiVar;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (this.zzb) {
            obj = "<supplier that returned " + this.zzc + Operator.Operation.GREATER_THAN;
        } else {
            obj = this.zza;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzii
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    Object zza = this.zza.zza();
                    this.zzc = zza;
                    this.zzb = true;
                    return zza;
                }
            }
        }
        return this.zzc;
    }
}
