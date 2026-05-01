package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.gms.cast.internal.Logger;

/* loaded from: classes.dex */
public final class zzi {
    public String zzb;
    public String zzc;
    public long zzd = zza;
    public int zze = 1;
    public String zzf;
    public int zzg;
    public String zzh;
    public int zzi;
    private static final Logger zzj = new Logger("ApplicationAnalyticsSession");
    public static long zza = System.currentTimeMillis();

    private zzi() {
    }

    public static zzi zza() {
        zzi zziVar = new zzi();
        zza++;
        return zziVar;
    }

    public static zzi zzb(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return null;
        }
        zzi zziVar = new zzi();
        if (!sharedPreferences.contains("application_id")) {
            return null;
        }
        zziVar.zzb = sharedPreferences.getString("application_id", "");
        if (!sharedPreferences.contains("receiver_metrics_id")) {
            return null;
        }
        zziVar.zzc = sharedPreferences.getString("receiver_metrics_id", "");
        if (!sharedPreferences.contains("analytics_session_id")) {
            return null;
        }
        zziVar.zzd = sharedPreferences.getLong("analytics_session_id", 0L);
        if (!sharedPreferences.contains("event_sequence_number")) {
            return null;
        }
        zziVar.zze = sharedPreferences.getInt("event_sequence_number", 0);
        if (!sharedPreferences.contains("receiver_session_id")) {
            return null;
        }
        zziVar.zzf = sharedPreferences.getString("receiver_session_id", "");
        zziVar.zzg = sharedPreferences.getInt("device_capabilities", 0);
        zziVar.zzh = sharedPreferences.getString("device_model_name", "");
        zziVar.zzi = sharedPreferences.getInt("analytics_session_start_type", 0);
        return zziVar;
    }

    public final void zzc(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        zzj.d("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("application_id", this.zzb);
        edit.putString("receiver_metrics_id", this.zzc);
        edit.putLong("analytics_session_id", this.zzd);
        edit.putInt("event_sequence_number", this.zze);
        edit.putString("receiver_session_id", this.zzf);
        edit.putInt("device_capabilities", this.zzg);
        edit.putString("device_model_name", this.zzh);
        edit.putInt("analytics_session_start_type", this.zzi);
        edit.apply();
    }
}
