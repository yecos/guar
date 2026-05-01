package com.google.android.gms.cast.framework;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: classes.dex */
public class CastReasonCodes {
    public static final int APPLICATION_LAUNCH_ERROR = 10;
    public static final int CASTING_ROUTE_CHANGED = 9;
    public static final int CASTING_STOPPED = 2;
    public static final int CAST_INTERNAL_ERROR = 1;
    public static final int CAST_SOCKET_ERROR = 6;
    public static final int CAST_TIMEOUT = 7;
    public static final int NETWORK_ERROR = 8;
    public static final int RECEIVER_APP_NOT_RUNNING = 3;
    public static final int SESSION_RESUME_FAILED = 5;
    public static final int SESSION_START_FAILED = 4;
    public static final int UNKNOWN_REASON = 0;
    private final Map<Integer, Integer> zza;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CastReasonType {
    }

    public CastReasonCodes(@RecentlyNonNull Bundle bundle) {
        this.zza = com.google.android.gms.internal.cast.zzn.zza(bundle, "com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES");
    }

    public final int zza(int i10) {
        Integer num;
        Map<Integer, Integer> map = this.zza;
        if (map != null) {
            Integer valueOf = Integer.valueOf(i10);
            if (map.containsKey(valueOf) && (num = this.zza.get(valueOf)) != null) {
                return num.intValue();
            }
        }
        return 0;
    }
}
