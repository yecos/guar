package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "CastDeviceCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;

    @RecentlyNonNull
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzs();

    @SafeParcelable.Field(id = 3)
    String zza;

    @SafeParcelable.Field(getter = "getDeviceIdRaw", id = 2)
    private String zzb;
    private InetAddress zzc;

    @SafeParcelable.Field(getter = "getFriendlyName", id = 4)
    private String zzd;

    @SafeParcelable.Field(getter = "getModelName", id = 5)
    private String zze;

    @SafeParcelable.Field(getter = "getDeviceVersion", id = 6)
    private String zzf;

    @SafeParcelable.Field(getter = "getServicePort", id = 7)
    private int zzg;

    @SafeParcelable.Field(getter = "getIcons", id = 8)
    private List<WebImage> zzh;

    @SafeParcelable.Field(getter = "getCapabilities", id = 9)
    private int zzi;

    @SafeParcelable.Field(defaultValue = "-1", getter = "getStatus", id = 10)
    private int zzj;

    @SafeParcelable.Field(getter = "getServiceInstanceName", id = 11)
    private String zzk;

    @SafeParcelable.Field(getter = "getReceiverMetricsId", id = 12)
    private final String zzl;

    @SafeParcelable.Field(getter = "getRcnEnabledStatus", id = 13)
    private int zzm;

    @SafeParcelable.Field(getter = "getHotspotBssid", id = 14)
    private final String zzn;

    @SafeParcelable.Field(getter = "getIpLowestTwoBytes", id = 15)
    private byte[] zzo;

    @SafeParcelable.Field(getter = "getCloudDeviceId", id = 16)
    private final String zzp;

    @SafeParcelable.Field(getter = "isCloudOnlyDevice", id = 17)
    private final boolean zzq;

    @SafeParcelable.Constructor
    public CastDevice(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) int i10, @SafeParcelable.Param(id = 8) List<WebImage> list, @SafeParcelable.Param(id = 9) int i11, @SafeParcelable.Param(id = 10) int i12, @SafeParcelable.Param(id = 11) String str6, @SafeParcelable.Param(id = 12) String str7, @SafeParcelable.Param(id = 13) int i13, @SafeParcelable.Param(id = 14) String str8, @SafeParcelable.Param(id = 15) byte[] bArr, @SafeParcelable.Param(id = 16) String str9, @SafeParcelable.Param(id = 17) boolean z10) {
        this.zzb = zzc(str);
        String zzc = zzc(str2);
        this.zza = zzc;
        if (!TextUtils.isEmpty(zzc)) {
            try {
                this.zzc = InetAddress.getByName(this.zza);
            } catch (UnknownHostException e10) {
                String str10 = this.zza;
                String message = e10.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(str10).length() + 48 + String.valueOf(message).length());
                sb.append("Unable to convert host address (");
                sb.append(str10);
                sb.append(") to ipaddress: ");
                sb.append(message);
            }
        }
        this.zzd = zzc(str3);
        this.zze = zzc(str4);
        this.zzf = zzc(str5);
        this.zzg = i10;
        this.zzh = list != null ? list : new ArrayList<>();
        this.zzi = i11;
        this.zzj = i12;
        this.zzk = zzc(str6);
        this.zzl = str7;
        this.zzm = i13;
        this.zzn = str8;
        this.zzo = bArr;
        this.zzp = str9;
        this.zzq = z10;
    }

    @RecentlyNullable
    public static CastDevice getFromBundle(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzc(String str) {
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        String str = this.zzb;
        return str == null ? castDevice.zzb == null : CastUtils.zzh(str, castDevice.zzb) && CastUtils.zzh(this.zzc, castDevice.zzc) && CastUtils.zzh(this.zze, castDevice.zze) && CastUtils.zzh(this.zzd, castDevice.zzd) && CastUtils.zzh(this.zzf, castDevice.zzf) && this.zzg == castDevice.zzg && CastUtils.zzh(this.zzh, castDevice.zzh) && this.zzi == castDevice.zzi && this.zzj == castDevice.zzj && CastUtils.zzh(this.zzk, castDevice.zzk) && CastUtils.zzh(Integer.valueOf(this.zzm), Integer.valueOf(castDevice.zzm)) && CastUtils.zzh(this.zzn, castDevice.zzn) && CastUtils.zzh(this.zzl, castDevice.zzl) && CastUtils.zzh(this.zzf, castDevice.getDeviceVersion()) && this.zzg == castDevice.getServicePort() && (((bArr = this.zzo) == null && castDevice.zzo == null) || Arrays.equals(bArr, castDevice.zzo)) && CastUtils.zzh(this.zzp, castDevice.zzp) && this.zzq == castDevice.zzq;
    }

    @RecentlyNonNull
    public String getDeviceId() {
        return this.zzb.startsWith("__cast_nearby__") ? this.zzb.substring(16) : this.zzb;
    }

    @RecentlyNonNull
    public String getDeviceVersion() {
        return this.zzf;
    }

    @RecentlyNonNull
    public String getFriendlyName() {
        return this.zzd;
    }

    @RecentlyNullable
    public WebImage getIcon(int i10, int i11) {
        WebImage webImage = null;
        if (this.zzh.isEmpty()) {
            return null;
        }
        if (i10 <= 0 || i11 <= 0) {
            return this.zzh.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzh) {
            int width = webImage3.getWidth();
            int height = webImage3.getHeight();
            if (width < i10 || height < i11) {
                if (width < i10 && height < i11 && (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height))) {
                    webImage2 = webImage3;
                }
            } else if (webImage == null || (webImage.getWidth() > width && webImage.getHeight() > height)) {
                webImage = webImage3;
            }
        }
        return webImage != null ? webImage : webImage2 != null ? webImage2 : this.zzh.get(0);
    }

    @RecentlyNonNull
    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzh);
    }

    @RecentlyNonNull
    public InetAddress getInetAddress() {
        return this.zzc;
    }

    @RecentlyNullable
    @Deprecated
    public Inet4Address getIpAddress() {
        if (hasIPv4Address()) {
            return (Inet4Address) this.zzc;
        }
        return null;
    }

    @RecentlyNonNull
    public String getModelName() {
        return this.zze;
    }

    public int getServicePort() {
        return this.zzg;
    }

    public boolean hasCapabilities(@RecentlyNonNull int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i10 : iArr) {
            if (!hasCapability(i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int i10) {
        return (this.zzi & i10) == i10;
    }

    public boolean hasIPv4Address() {
        return getInetAddress() != null && (getInetAddress() instanceof Inet4Address);
    }

    public boolean hasIPv6Address() {
        return getInetAddress() != null && (getInetAddress() instanceof Inet6Address);
    }

    @VisibleForTesting
    public boolean hasIcons() {
        return !this.zzh.isEmpty();
    }

    public int hashCode() {
        String str = this.zzb;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return (this.zzb.startsWith("__cast_nearby__") || this.zzq) ? false : true;
    }

    @VisibleForTesting
    public boolean isSameDevice(@RecentlyNonNull CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (!TextUtils.isEmpty(getDeviceId()) && !getDeviceId().startsWith("__cast_ble__") && !TextUtils.isEmpty(castDevice.getDeviceId()) && !castDevice.getDeviceId().startsWith("__cast_ble__")) {
            return CastUtils.zzh(getDeviceId(), castDevice.getDeviceId());
        }
        if (TextUtils.isEmpty(this.zzn) || TextUtils.isEmpty(castDevice.zzn)) {
            return false;
        }
        return CastUtils.zzh(this.zzn, castDevice.zzn);
    }

    public void putInBundle(@RecentlyNonNull Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    @RecentlyNonNull
    public String toString() {
        return String.format("\"%s\" (%s)", this.zzd, this.zzb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zza, false);
        SafeParcelWriter.writeString(parcel, 4, getFriendlyName(), false);
        SafeParcelWriter.writeString(parcel, 5, getModelName(), false);
        SafeParcelWriter.writeString(parcel, 6, getDeviceVersion(), false);
        SafeParcelWriter.writeInt(parcel, 7, getServicePort());
        SafeParcelWriter.writeTypedList(parcel, 8, getIcons(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeString(parcel, 11, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeByteArray(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final int zza() {
        return this.zzi;
    }

    @RecentlyNullable
    @ShowFirstParty
    public final String zzb() {
        return this.zzl;
    }
}
