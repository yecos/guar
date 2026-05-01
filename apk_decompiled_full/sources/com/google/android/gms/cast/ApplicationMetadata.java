package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ApplicationMetadataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class ApplicationMetadata extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zzd();

    @SafeParcelable.Field(getter = "getApplicationId", id = 2)
    String zza;

    @SafeParcelable.Field(getter = "getName", id = 3)
    String zzb;

    @SafeParcelable.Field(getter = "getSupportedNamespaces", id = 5)
    List<String> zzc;

    @SafeParcelable.Field(getter = "getSenderAppIdentifier", id = 6)
    String zzd;

    @SafeParcelable.Field(getter = "getSenderAppLaunchUrl", id = 7)
    Uri zze;

    @SafeParcelable.Field(getter = "getIconUrl", id = 8)
    String zzf;

    @SafeParcelable.Field(getter = "getApplicationType", id = 9)
    private String zzg;

    private ApplicationMetadata() {
        this.zzc = new ArrayList();
    }

    public boolean areNamespacesSupported(@RecentlyNonNull List<String> list) {
        List<String> list2 = this.zzc;
        return list2 != null && list2.containsAll(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return CastUtils.zzh(this.zza, applicationMetadata.zza) && CastUtils.zzh(this.zzb, applicationMetadata.zzb) && CastUtils.zzh(this.zzc, applicationMetadata.zzc) && CastUtils.zzh(this.zzd, applicationMetadata.zzd) && CastUtils.zzh(this.zze, applicationMetadata.zze) && CastUtils.zzh(this.zzf, applicationMetadata.zzf) && CastUtils.zzh(this.zzg, applicationMetadata.zzg);
    }

    @RecentlyNonNull
    public String getApplicationId() {
        return this.zza;
    }

    @RecentlyNullable
    public List<WebImage> getImages() {
        return null;
    }

    @RecentlyNonNull
    public String getName() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getSenderAppIdentifier() {
        return this.zzd;
    }

    @RecentlyNonNull
    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzc);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    public boolean isNamespaceSupported(@RecentlyNonNull String str) {
        List<String> list = this.zzc;
        return list != null && list.contains(str);
    }

    @RecentlyNonNull
    public String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        List<String> list = this.zzc;
        int size = list == null ? 0 : list.size();
        String str3 = this.zzd;
        String valueOf = String.valueOf(this.zze);
        String str4 = this.zzf;
        String str5 = this.zzg;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(length + 118 + length2 + length3 + valueOf.length() + String.valueOf(str4).length() + String.valueOf(str5).length());
        sb.append("applicationId: ");
        sb.append(str);
        sb.append(", name: ");
        sb.append(str2);
        sb.append(", namespaces.count: ");
        sb.append(size);
        sb.append(", senderAppIdentifier: ");
        sb.append(str3);
        sb.append(", senderAppLaunchUrl: ");
        sb.append(valueOf);
        sb.append(", iconUrl: ");
        sb.append(str4);
        sb.append(", type: ");
        sb.append(str5);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getApplicationId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getImages(), false);
        SafeParcelWriter.writeStringList(parcel, 5, getSupportedNamespaces(), false);
        SafeParcelWriter.writeString(parcel, 6, getSenderAppIdentifier(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zze, i10, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public ApplicationMetadata(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<WebImage> list, @SafeParcelable.Param(id = 5) List<String> list2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) Uri uri, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) String str5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list2;
        this.zzd = str3;
        this.zze = uri;
        this.zzf = str4;
        this.zzg = str5;
    }
}
