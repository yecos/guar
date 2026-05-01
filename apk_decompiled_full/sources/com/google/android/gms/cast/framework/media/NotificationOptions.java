package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.framework.media.internal.ResourceProvider;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SafeParcelable.Class(creator = "NotificationOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class NotificationOptions extends AbstractSafeParcelable {
    public static final long SKIP_STEP_TEN_SECONDS_IN_MS = 10000;
    public static final long SKIP_STEP_THIRTY_SECONDS_IN_MS = 30000;

    @SafeParcelable.Field(getter = "getForwardTitleResId", id = 26)
    private final int zzA;

    @SafeParcelable.Field(getter = "getForward10TitleResId", id = 27)
    private final int zzB;

    @SafeParcelable.Field(getter = "getForward30TitleResId", id = 28)
    private final int zzC;

    @SafeParcelable.Field(getter = "getRewindTitleResId", id = 29)
    private final int zzD;

    @SafeParcelable.Field(getter = "getRewind10TitleResId", id = 30)
    private final int zzE;

    @SafeParcelable.Field(getter = "getRewind30TitleResId", id = 31)
    private final int zzF;

    @SafeParcelable.Field(getter = "getDisconnectTitleResId", id = 32)
    private final int zzG;

    @SafeParcelable.Field(getter = "getNotificationActionsProviderAsBinder", id = 33, type = "android.os.IBinder")
    private final zzg zzH;

    @SafeParcelable.Field(getter = "getActions", id = 2)
    private final List<String> zzc;

    @SafeParcelable.Field(getter = "getCompatActionIndices", id = 3)
    private final int[] zzd;

    @SafeParcelable.Field(getter = "getSkipStepMs", id = 4)
    private final long zze;

    @SafeParcelable.Field(getter = "getTargetActivityClassName", id = 5)
    private final String zzf;

    @SafeParcelable.Field(getter = "getSmallIconDrawableResId", id = 6)
    private final int zzg;

    @SafeParcelable.Field(getter = "getStopLiveStreamDrawableResId", id = 7)
    private final int zzh;

    @SafeParcelable.Field(getter = "getPauseDrawableResId", id = 8)
    private final int zzi;

    @SafeParcelable.Field(getter = "getPlayDrawableResId", id = 9)
    private final int zzj;

    @SafeParcelable.Field(getter = "getSkipNextDrawableResId", id = 10)
    private final int zzk;

    @SafeParcelable.Field(getter = "getSkipPrevDrawableResId", id = 11)
    private final int zzl;

    @SafeParcelable.Field(getter = "getForwardDrawableResId", id = 12)
    private final int zzm;

    @SafeParcelable.Field(getter = "getForward10DrawableResId", id = 13)
    private final int zzn;

    @SafeParcelable.Field(getter = "getForward30DrawableResId", id = 14)
    private final int zzo;

    @SafeParcelable.Field(getter = "getRewindDrawableResId", id = 15)
    private final int zzp;

    @SafeParcelable.Field(getter = "getRewind10DrawableResId", id = 16)
    private final int zzq;

    @SafeParcelable.Field(getter = "getRewind30DrawableResId", id = 17)
    private final int zzr;

    @SafeParcelable.Field(getter = "getDisconnectDrawableResId", id = 18)
    private final int zzs;

    @SafeParcelable.Field(getter = "getImageSizeDimenResId", id = 19)
    private final int zzt;

    @SafeParcelable.Field(getter = "getCastingToDeviceStringResId", id = 20)
    private final int zzu;

    @SafeParcelable.Field(getter = "getStopLiveStreamTitleResId", id = 21)
    private final int zzv;

    @SafeParcelable.Field(getter = "getPauseTitleResId", id = 22)
    private final int zzw;

    @SafeParcelable.Field(getter = "getPlayTitleResId", id = 23)
    private final int zzx;

    @SafeParcelable.Field(getter = "getSkipNextTitleResId", id = 24)
    private final int zzy;

    @SafeParcelable.Field(getter = "getSkipPrevTitleResId", id = 25)
    private final int zzz;
    private static final List<String> zza = Arrays.asList(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING);
    private static final int[] zzb = {0, 1};

    @RecentlyNonNull
    public static final Parcelable.Creator<NotificationOptions> CREATOR = new zzab();

    public static final class Builder {
        private String zza;
        private NotificationActionsProvider zzc;
        private List<String> zzb = NotificationOptions.zza;
        private int[] zzd = NotificationOptions.zzb;
        private int zze = zza("smallIconDrawableResId");
        private int zzf = zza("stopLiveStreamDrawableResId");
        private int zzg = zza("pauseDrawableResId");
        private int zzh = zza("playDrawableResId");
        private int zzi = zza("skipNextDrawableResId");
        private int zzj = zza("skipPrevDrawableResId");
        private int zzk = zza("forwardDrawableResId");
        private int zzl = zza("forward10DrawableResId");
        private int zzm = zza("forward30DrawableResId");
        private int zzn = zza("rewindDrawableResId");
        private int zzo = zza("rewind10DrawableResId");
        private int zzp = zza("rewind30DrawableResId");
        private int zzq = zza("disconnectDrawableResId");
        private long zzr = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;

        private static int zza(String str) {
            try {
                int i10 = ResourceProvider.f6830a;
                Integer num = (Integer) ResourceProvider.class.getMethod("findResourceByName", String.class).invoke(null, str);
                if (num == null) {
                    return 0;
                }
                return num.intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r35v0, types: [android.os.IBinder] */
        @RecentlyNonNull
        public NotificationOptions build() {
            NotificationActionsProvider notificationActionsProvider = this.zzc;
            return new NotificationOptions(this.zzb, this.zzd, this.zzr, this.zza, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, zza("notificationImageSizeDimenResId"), zza("castingToDeviceStringResId"), zza("stopLiveStreamStringResId"), zza("pauseStringResId"), zza("playStringResId"), zza("skipNextStringResId"), zza("skipPrevStringResId"), zza("forwardStringResId"), zza("forward10StringResId"), zza("forward30StringResId"), zza("rewindStringResId"), zza("rewind10StringResId"), zza("rewind30StringResId"), zza("disconnectStringResId"), notificationActionsProvider == null ? null : notificationActionsProvider.zza());
        }

        @RecentlyNonNull
        public Builder setActions(List<String> list, int[] iArr) {
            if (list == null && iArr != null) {
                throw new IllegalArgumentException("When setting actions to null, you must also set compatActionIndices to null.");
            }
            if (list != null && iArr == null) {
                throw new IllegalArgumentException("When setting compatActionIndices to null, you must also set actions to null.");
            }
            if (list == null || iArr == null) {
                this.zzb = NotificationOptions.zza;
                this.zzd = NotificationOptions.zzb;
            } else {
                int size = list.size();
                int length = iArr.length;
                if (length > size) {
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid number of compat actions: %d > %d.", Integer.valueOf(length), Integer.valueOf(size)));
                }
                for (int i10 : iArr) {
                    if (i10 < 0 || i10 >= size) {
                        throw new IllegalArgumentException(String.format(Locale.ROOT, "Index %d in compatActionIndices out of range: [0, %d]", Integer.valueOf(i10), Integer.valueOf(size - 1)));
                    }
                }
                this.zzb = new ArrayList(list);
                this.zzd = Arrays.copyOf(iArr, iArr.length);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setDisconnectDrawableResId(int i10) {
            this.zzq = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setForward10DrawableResId(int i10) {
            this.zzl = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setForward30DrawableResId(int i10) {
            this.zzm = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setForwardDrawableResId(int i10) {
            this.zzk = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setNotificationActionsProvider(@RecentlyNonNull NotificationActionsProvider notificationActionsProvider) {
            if (notificationActionsProvider == null) {
                throw new IllegalArgumentException("notificationActionsProvider cannot be null.");
            }
            this.zzc = notificationActionsProvider;
            return this;
        }

        @RecentlyNonNull
        public Builder setPauseDrawableResId(int i10) {
            this.zzg = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setPlayDrawableResId(int i10) {
            this.zzh = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setRewind10DrawableResId(int i10) {
            this.zzo = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setRewind30DrawableResId(int i10) {
            this.zzp = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setRewindDrawableResId(int i10) {
            this.zzn = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setSkipNextDrawableResId(int i10) {
            this.zzi = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setSkipPrevDrawableResId(int i10) {
            this.zzj = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setSkipStepMs(long j10) {
            Preconditions.checkArgument(j10 > 0, "skipStepMs must be positive.");
            this.zzr = j10;
            return this;
        }

        @RecentlyNonNull
        public Builder setSmallIconDrawableResId(int i10) {
            this.zze = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setStopLiveStreamDrawableResId(int i10) {
            this.zzf = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setTargetActivityClassName(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public NotificationOptions(@RecentlyNonNull @SafeParcelable.Param(id = 2) List<String> list, @RecentlyNonNull @SafeParcelable.Param(id = 3) int[] iArr, @SafeParcelable.Param(id = 4) long j10, @RecentlyNonNull @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i10, @SafeParcelable.Param(id = 7) int i11, @SafeParcelable.Param(id = 8) int i12, @SafeParcelable.Param(id = 9) int i13, @SafeParcelable.Param(id = 10) int i14, @SafeParcelable.Param(id = 11) int i15, @SafeParcelable.Param(id = 12) int i16, @SafeParcelable.Param(id = 13) int i17, @SafeParcelable.Param(id = 14) int i18, @SafeParcelable.Param(id = 15) int i19, @SafeParcelable.Param(id = 16) int i20, @SafeParcelable.Param(id = 17) int i21, @SafeParcelable.Param(id = 18) int i22, @SafeParcelable.Param(id = 19) int i23, @SafeParcelable.Param(id = 20) int i24, @SafeParcelable.Param(id = 21) int i25, @SafeParcelable.Param(id = 22) int i26, @SafeParcelable.Param(id = 23) int i27, @SafeParcelable.Param(id = 24) int i28, @SafeParcelable.Param(id = 25) int i29, @SafeParcelable.Param(id = 26) int i30, @SafeParcelable.Param(id = 27) int i31, @SafeParcelable.Param(id = 28) int i32, @SafeParcelable.Param(id = 29) int i33, @SafeParcelable.Param(id = 30) int i34, @SafeParcelable.Param(id = 31) int i35, @SafeParcelable.Param(id = 32) int i36, @SafeParcelable.Param(id = 33) IBinder iBinder) {
        this.zzc = new ArrayList(list);
        this.zzd = Arrays.copyOf(iArr, iArr.length);
        this.zze = j10;
        this.zzf = str;
        this.zzg = i10;
        this.zzh = i11;
        this.zzi = i12;
        this.zzj = i13;
        this.zzk = i14;
        this.zzl = i15;
        this.zzm = i16;
        this.zzn = i17;
        this.zzo = i18;
        this.zzp = i19;
        this.zzq = i20;
        this.zzr = i21;
        this.zzs = i22;
        this.zzt = i23;
        this.zzu = i24;
        this.zzv = i25;
        this.zzw = i26;
        this.zzx = i27;
        this.zzy = i28;
        this.zzz = i29;
        this.zzA = i30;
        this.zzB = i31;
        this.zzC = i32;
        this.zzD = i33;
        this.zzE = i34;
        this.zzF = i35;
        this.zzG = i36;
        if (iBinder == null) {
            this.zzH = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            this.zzH = queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zze(iBinder);
        }
    }

    @RecentlyNonNull
    public List<String> getActions() {
        return this.zzc;
    }

    public int getCastingToDeviceStringResId() {
        return this.zzu;
    }

    @RecentlyNonNull
    public int[] getCompatActionIndices() {
        int[] iArr = this.zzd;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDisconnectDrawableResId() {
        return this.zzs;
    }

    public int getForward10DrawableResId() {
        return this.zzn;
    }

    public int getForward30DrawableResId() {
        return this.zzo;
    }

    public int getForwardDrawableResId() {
        return this.zzm;
    }

    public int getPauseDrawableResId() {
        return this.zzi;
    }

    public int getPlayDrawableResId() {
        return this.zzj;
    }

    public int getRewind10DrawableResId() {
        return this.zzq;
    }

    public int getRewind30DrawableResId() {
        return this.zzr;
    }

    public int getRewindDrawableResId() {
        return this.zzp;
    }

    public int getSkipNextDrawableResId() {
        return this.zzk;
    }

    public int getSkipPrevDrawableResId() {
        return this.zzl;
    }

    public long getSkipStepMs() {
        return this.zze;
    }

    public int getSmallIconDrawableResId() {
        return this.zzg;
    }

    public int getStopLiveStreamDrawableResId() {
        return this.zzh;
    }

    public int getStopLiveStreamTitleResId() {
        return this.zzv;
    }

    @RecentlyNonNull
    public String getTargetActivityClassName() {
        return this.zzf;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, getActions(), false);
        SafeParcelWriter.writeIntArray(parcel, 3, getCompatActionIndices(), false);
        SafeParcelWriter.writeLong(parcel, 4, getSkipStepMs());
        SafeParcelWriter.writeString(parcel, 5, getTargetActivityClassName(), false);
        SafeParcelWriter.writeInt(parcel, 6, getSmallIconDrawableResId());
        SafeParcelWriter.writeInt(parcel, 7, getStopLiveStreamDrawableResId());
        SafeParcelWriter.writeInt(parcel, 8, getPauseDrawableResId());
        SafeParcelWriter.writeInt(parcel, 9, getPlayDrawableResId());
        SafeParcelWriter.writeInt(parcel, 10, getSkipNextDrawableResId());
        SafeParcelWriter.writeInt(parcel, 11, getSkipPrevDrawableResId());
        SafeParcelWriter.writeInt(parcel, 12, getForwardDrawableResId());
        SafeParcelWriter.writeInt(parcel, 13, getForward10DrawableResId());
        SafeParcelWriter.writeInt(parcel, 14, getForward30DrawableResId());
        SafeParcelWriter.writeInt(parcel, 15, getRewindDrawableResId());
        SafeParcelWriter.writeInt(parcel, 16, getRewind10DrawableResId());
        SafeParcelWriter.writeInt(parcel, 17, getRewind30DrawableResId());
        SafeParcelWriter.writeInt(parcel, 18, getDisconnectDrawableResId());
        SafeParcelWriter.writeInt(parcel, 19, this.zzt);
        SafeParcelWriter.writeInt(parcel, 20, getCastingToDeviceStringResId());
        SafeParcelWriter.writeInt(parcel, 21, getStopLiveStreamTitleResId());
        SafeParcelWriter.writeInt(parcel, 22, this.zzw);
        SafeParcelWriter.writeInt(parcel, 23, this.zzx);
        SafeParcelWriter.writeInt(parcel, 24, this.zzy);
        SafeParcelWriter.writeInt(parcel, 25, this.zzz);
        SafeParcelWriter.writeInt(parcel, 26, this.zzA);
        SafeParcelWriter.writeInt(parcel, 27, this.zzB);
        SafeParcelWriter.writeInt(parcel, 28, this.zzC);
        SafeParcelWriter.writeInt(parcel, 29, this.zzD);
        SafeParcelWriter.writeInt(parcel, 30, this.zzE);
        SafeParcelWriter.writeInt(parcel, 31, this.zzF);
        SafeParcelWriter.writeInt(parcel, 32, this.zzG);
        zzg zzgVar = this.zzH;
        SafeParcelWriter.writeIBinder(parcel, 33, zzgVar == null ? null : zzgVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzG;
    }

    public final int zzb() {
        return this.zzB;
    }

    public final int zzc() {
        return this.zzC;
    }

    public final int zzd() {
        return this.zzA;
    }

    public final int zze() {
        return this.zzt;
    }

    public final int zzf() {
        return this.zzw;
    }

    public final int zzg() {
        return this.zzx;
    }

    public final int zzh() {
        return this.zzE;
    }

    public final int zzi() {
        return this.zzF;
    }

    public final int zzj() {
        return this.zzD;
    }

    public final int zzk() {
        return this.zzy;
    }

    public final int zzl() {
        return this.zzz;
    }

    public final zzg zzm() {
        return this.zzH;
    }
}
