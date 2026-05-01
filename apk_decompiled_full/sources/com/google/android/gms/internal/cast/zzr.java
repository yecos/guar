package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* loaded from: classes.dex */
public abstract class zzr extends zzb implements zzs {
    public zzr() {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        zzu zztVar;
        switch (i10) {
            case 1:
                Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zztVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                    zztVar = queryLocalInterface instanceof zzu ? (zzu) queryLocalInterface : new zzt(readStrongBinder);
                }
                zze(bundle, zztVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzd((Bundle) zzc.zza(parcel, Bundle.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                zzg((Bundle) zzc.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zzm = zzm((Bundle) zzc.zza(parcel, Bundle.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                zzc.zzb(parcel2, zzm);
                return true;
            case 5:
                zzi(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzh();
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzl = zzl();
                parcel2.writeNoException();
                zzc.zzb(parcel2, zzl);
                return true;
            case 8:
                Bundle zzb = zzb(parcel.readString());
                parcel2.writeNoException();
                zzc.zzd(parcel2, zzb);
                return true;
            case 9:
                String zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 10:
                parcel2.writeNoException();
                parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return true;
            case 11:
                zzf();
                parcel2.writeNoException();
                return true;
            case 12:
                boolean zzk = zzk();
                parcel2.writeNoException();
                zzc.zzb(parcel2, zzk);
                return true;
            case 13:
                zzj(parcel.readInt());
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
