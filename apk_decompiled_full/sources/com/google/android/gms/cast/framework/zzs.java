package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* loaded from: classes.dex */
public abstract class zzs extends com.google.android.gms.internal.cast.zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            zzc(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
        } else if (i10 == 2) {
            zzd(parcel.readString(), (LaunchOptions) com.google.android.gms.internal.cast.zzc.zza(parcel, LaunchOptions.CREATOR));
            parcel2.writeNoException();
        } else if (i10 == 3) {
            zze(parcel.readString());
            parcel2.writeNoException();
        } else if (i10 == 4) {
            zzb(parcel.readInt());
            parcel2.writeNoException();
        } else {
            if (i10 != 5) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
