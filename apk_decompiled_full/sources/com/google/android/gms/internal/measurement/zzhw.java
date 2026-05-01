package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class zzhw extends zzib {
    public zzhw(zzhy zzhyVar, String str, Double d10, boolean z10) {
        super(zzhyVar, "measurement.test.double_flag", d10, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    @Nullable
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid double value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
