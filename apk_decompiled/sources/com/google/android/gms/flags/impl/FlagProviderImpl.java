package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends com.google.android.gms.flags.zzd {
    private boolean zzu = false;
    private SharedPreferences zzv;

    @Override // com.google.android.gms.flags.zzc
    public boolean getBooleanFlagValue(String str, boolean z10, int i10) {
        return !this.zzu ? z10 : zzb.zza(this.zzv, str, Boolean.valueOf(z10)).booleanValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public int getIntFlagValue(String str, int i10, int i11) {
        return !this.zzu ? i10 : zzd.zza(this.zzv, str, Integer.valueOf(i10)).intValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public long getLongFlagValue(String str, long j10, int i10) {
        return !this.zzu ? j10 : zzf.zza(this.zzv, str, Long.valueOf(j10)).longValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public String getStringFlagValue(String str, String str2, int i10) {
        return !this.zzu ? str2 : zzh.zza(this.zzv, str, str2);
    }

    @Override // com.google.android.gms.flags.zzc
    public void init(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzu) {
            return;
        }
        try {
            this.zzv = zzj.zza(context.createPackageContext("com.google.android.gms", 0));
            this.zzu = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e10) {
            String valueOf = String.valueOf(e10.getMessage());
            if (valueOf.length() != 0) {
                "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf);
            }
        }
    }
}
