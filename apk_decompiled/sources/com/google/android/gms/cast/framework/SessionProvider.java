package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public abstract class SessionProvider {
    private final Context zza;
    private final String zzb;
    private final zzay zzc = new zzay(this, null);

    public SessionProvider(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        this.zza = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    @RecentlyNullable
    public abstract Session createSession(@RecentlyNonNull String str);

    @RecentlyNonNull
    public final String getCategory() {
        return this.zzb;
    }

    @RecentlyNonNull
    public final Context getContext() {
        return this.zza;
    }

    public abstract boolean isSessionRecoverable();

    @RecentlyNonNull
    public final IBinder zza() {
        return this.zzc;
    }
}
