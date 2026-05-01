package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public abstract class Flag<T> {
    private final String mKey;
    private final int zze;
    private final T zzf;

    @Deprecated
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i10, String str, Boolean bool) {
            super(i10, str, bool);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.flags.Flag
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final Boolean zza(zzc zzcVar) {
            try {
                return Boolean.valueOf(zzcVar.getBooleanFlagValue(getKey(), zzb().booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return zzb();
            }
        }
    }

    @Deprecated
    @KeepForSdk
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i10, String str, Integer num) {
            super(i10, str, num);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.flags.Flag
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final Integer zza(zzc zzcVar) {
            try {
                return Integer.valueOf(zzcVar.getIntFlagValue(getKey(), zzb().intValue(), getSource()));
            } catch (RemoteException unused) {
                return zzb();
            }
        }
    }

    @Deprecated
    @KeepForSdk
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i10, String str, Long l10) {
            super(i10, str, l10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.flags.Flag
        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public final Long zza(zzc zzcVar) {
            try {
                return Long.valueOf(zzcVar.getLongFlagValue(getKey(), zzb().longValue(), getSource()));
            } catch (RemoteException unused) {
                return zzb();
            }
        }
    }

    @Deprecated
    @KeepForSdk
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i10, String str, String str2) {
            super(i10, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.flags.Flag
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public final String zza(zzc zzcVar) {
            try {
                return zzcVar.getStringFlagValue(getKey(), zzb(), getSource());
            } catch (RemoteException unused) {
                return zzb();
            }
        }
    }

    private Flag(int i10, String str, T t10) {
        this.zze = i10;
        this.mKey = str;
        this.zzf = t10;
        Singletons.flagRegistry().zza(this);
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag define(int i10, String str, Boolean bool) {
        return new BooleanFlag(i10, str, bool);
    }

    @KeepForSdk
    public T get() {
        return (T) Singletons.zzd().zzb(this);
    }

    public final String getKey() {
        return this.mKey;
    }

    @Deprecated
    public final int getSource() {
        return this.zze;
    }

    public abstract T zza(zzc zzcVar);

    public final T zzb() {
        return this.zzf;
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag define(int i10, String str, int i11) {
        return new IntegerFlag(i10, str, Integer.valueOf(i11));
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag define(int i10, String str, long j10) {
        return new LongFlag(i10, str, Long.valueOf(j10));
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag define(int i10, String str, String str2) {
        return new StringFlag(i10, str, str2);
    }
}
