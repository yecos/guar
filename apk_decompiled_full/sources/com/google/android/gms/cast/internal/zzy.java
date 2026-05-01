package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceStatusCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();

    @SafeParcelable.Field(getter = "getVolume", id = 2)
    private double zza;

    @SafeParcelable.Field(getter = "getMuteState", id = 3)
    private boolean zzb;

    @SafeParcelable.Field(getter = "getActiveInputState", id = 4)
    private int zzc;

    @SafeParcelable.Field(getter = "getApplicationMetadata", id = 5)
    private ApplicationMetadata zzd;

    @SafeParcelable.Field(getter = "getStandbyState", id = 6)
    private int zze;

    @SafeParcelable.Field(getter = "getEqualizerSettings", id = 7)
    private com.google.android.gms.cast.zzar zzf;

    @SafeParcelable.Field(getter = "getStepInterval", id = 8)
    private double zzg;

    public zzy() {
        this(Double.NaN, false, -1, null, -1, null, Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy zzyVar = (zzy) obj;
        if (this.zza == zzyVar.zza && this.zzb == zzyVar.zzb && this.zzc == zzyVar.zzc && CastUtils.zzh(this.zzd, zzyVar.zzd) && this.zze == zzyVar.zze) {
            com.google.android.gms.cast.zzar zzarVar = this.zzf;
            if (CastUtils.zzh(zzarVar, zzarVar) && this.zzg == zzyVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Double.valueOf(this.zza), Boolean.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, Integer.valueOf(this.zze), this.zzf, Double.valueOf(this.zzg));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDouble(parcel, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i10, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzf, i10, false);
        SafeParcelWriter.writeDouble(parcel, 8, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final double zza() {
        return this.zzg;
    }

    public final double zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zze;
    }

    public final ApplicationMetadata zze() {
        return this.zzd;
    }

    public final com.google.android.gms.cast.zzar zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzb;
    }

    @SafeParcelable.Constructor
    public zzy(@SafeParcelable.Param(id = 2) double d10, @SafeParcelable.Param(id = 3) boolean z10, @SafeParcelable.Param(id = 4) int i10, @SafeParcelable.Param(id = 5) ApplicationMetadata applicationMetadata, @SafeParcelable.Param(id = 6) int i11, @SafeParcelable.Param(id = 7) com.google.android.gms.cast.zzar zzarVar, @SafeParcelable.Param(id = 8) double d11) {
        this.zza = d10;
        this.zzb = z10;
        this.zzc = i10;
        this.zzd = applicationMetadata;
        this.zze = i11;
        this.zzf = zzarVar;
        this.zzg = d11;
    }
}
