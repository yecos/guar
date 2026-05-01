package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "CastMediaOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class CastMediaOptions extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getMediaIntentReceiverClassName", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getExpandedControllerActivityClassName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getImagePickerAsBinder", id = 4, type = "android.os.IBinder")
    private final zzd zzd;

    @SafeParcelable.Field(getter = "getNotificationOptions", id = 5)
    private final NotificationOptions zze;

    @SafeParcelable.Field(getter = "getDisableRemoteControlNotification", id = 6)
    private final boolean zzf;

    @SafeParcelable.Field(getter = "getMediaSessionEnabled", id = 7)
    private final boolean zzg;
    private static final Logger zza = new Logger("CastMediaOptions");

    @RecentlyNonNull
    public static final Parcelable.Creator<CastMediaOptions> CREATOR = new zza();

    public static final class Builder {
        private String zzb;
        private ImagePicker zzc;
        private String zza = "com.google.android.gms.cast.framework.media.MediaIntentReceiver";
        private NotificationOptions zzd = new NotificationOptions.Builder().build();
        private boolean zze = true;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.os.IBinder] */
        @RecentlyNonNull
        public CastMediaOptions build() {
            ImagePicker imagePicker = this.zzc;
            return new CastMediaOptions(this.zza, this.zzb, imagePicker == null ? null : imagePicker.zza(), this.zzd, false, this.zze);
        }

        @RecentlyNonNull
        public Builder setExpandedControllerActivityClassName(@RecentlyNonNull String str) {
            this.zzb = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setImagePicker(ImagePicker imagePicker) {
            this.zzc = imagePicker;
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaIntentReceiverClassName(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaSessionEnabled(boolean z10) {
            this.zze = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setNotificationOptions(NotificationOptions notificationOptions) {
            this.zzd = notificationOptions;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CastMediaOptions(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) NotificationOptions notificationOptions, @SafeParcelable.Param(id = 6) boolean z10, @SafeParcelable.Param(id = 7) boolean z11) {
        zzd zzbVar;
        this.zzb = str;
        this.zzc = str2;
        if (iBinder == null) {
            zzbVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            zzbVar = queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new zzb(iBinder);
        }
        this.zzd = zzbVar;
        this.zze = notificationOptions;
        this.zzf = z10;
        this.zzg = z11;
    }

    @RecentlyNonNull
    public String getExpandedControllerActivityClassName() {
        return this.zzc;
    }

    @RecentlyNullable
    public ImagePicker getImagePicker() {
        zzd zzdVar = this.zzd;
        if (zzdVar == null) {
            return null;
        }
        try {
            return (ImagePicker) ObjectWrapper.unwrap(zzdVar.zzg());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "getWrappedClientObject", zzd.class.getSimpleName());
            return null;
        }
    }

    @RecentlyNonNull
    public String getMediaIntentReceiverClassName() {
        return this.zzb;
    }

    public boolean getMediaSessionEnabled() {
        return this.zzg;
    }

    @RecentlyNullable
    public NotificationOptions getNotificationOptions() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getMediaIntentReceiverClassName(), false);
        SafeParcelWriter.writeString(parcel, 3, getExpandedControllerActivityClassName(), false);
        zzd zzdVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 4, zzdVar == null ? null : zzdVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getNotificationOptions(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 7, getMediaSessionEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final boolean zza() {
        return this.zzf;
    }
}
