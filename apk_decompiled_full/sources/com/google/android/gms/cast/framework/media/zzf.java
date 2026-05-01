package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzf extends com.google.android.gms.internal.cast.zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } else if (i10 == 2) {
            IObjectWrapper zze = zze();
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, zze);
        } else if (i10 == 3) {
            List<NotificationAction> zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeTypedList(zzf);
        } else {
            if (i10 != 4) {
                return false;
            }
            int[] zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeIntArray(zzg);
        }
        return true;
    }
}
