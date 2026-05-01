package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.Toast;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public class SessionManager {
    private static final Logger zza = new Logger("SessionManager");
    private final zzal zzb;
    private final Context zzc;

    public SessionManager(zzal zzalVar, Context context) {
        this.zzb = zzalVar;
        this.zzc = context;
    }

    public void addSessionManagerListener(@RecentlyNonNull SessionManagerListener<Session> sessionManagerListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        addSessionManagerListener(sessionManagerListener, Session.class);
    }

    public void endCurrentSession(boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            zza.i("End session for %s", this.zzc.getPackageName());
            this.zzb.zzj(true, z10);
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "endCurrentSession", zzal.class.getSimpleName());
        }
    }

    @RecentlyNullable
    public CastSession getCurrentCastSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Session currentSession = getCurrentSession();
        if (currentSession == null || !(currentSession instanceof CastSession)) {
            return null;
        }
        return (CastSession) currentSession;
    }

    @RecentlyNullable
    public Session getCurrentSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return (Session) ObjectWrapper.unwrap(this.zzb.zzf());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "getWrappedCurrentSession", zzal.class.getSimpleName());
            return null;
        }
    }

    public void removeSessionManagerListener(@RecentlyNonNull SessionManagerListener<Session> sessionManagerListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        removeSessionManagerListener(sessionManagerListener, Session.class);
    }

    public void startSession(@RecentlyNonNull Intent intent) {
        try {
            zza.i("Start session for %s", this.zzc.getPackageName());
            Bundle extras = intent.getExtras();
            if (extras != null && extras.getString("CAST_INTENT_TO_CAST_ROUTE_ID_KEY") != null) {
                String string = extras.getString("CAST_INTENT_TO_CAST_DEVICE_NAME_KEY");
                if (!extras.getBoolean("CAST_INTENT_TO_CAST_NO_TOAST_KEY")) {
                    Toast.makeText(this.zzc, this.zzc.getString(R.string.cast_connecting_to_device, string), 0).show();
                }
                this.zzb.zzm(new Bundle(extras));
                intent.removeExtra("CAST_INTENT_TO_CAST_ROUTE_ID_KEY");
            }
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "startSession", zzal.class.getSimpleName());
        }
    }

    public final int zza() {
        try {
            return this.zzb.zze();
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "addCastStateListener", zzal.class.getSimpleName());
            return 1;
        }
    }

    @RecentlyNullable
    public final IObjectWrapper zzb() {
        try {
            return this.zzb.zzg();
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "getWrappedThis", zzal.class.getSimpleName());
            return null;
        }
    }

    public final void zzc(CastStateListener castStateListener) {
        Preconditions.checkNotNull(castStateListener);
        try {
            this.zzb.zzh(new zzq(castStateListener));
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "addCastStateListener", zzal.class.getSimpleName());
        }
    }

    public final void zzd(CastStateListener castStateListener) {
        try {
            this.zzb.zzk(new zzq(castStateListener));
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "removeCastStateListener", zzal.class.getSimpleName());
        }
    }

    public <T extends Session> void addSessionManagerListener(@RecentlyNonNull SessionManagerListener<T> sessionManagerListener, @RecentlyNonNull Class<T> cls) {
        if (sessionManagerListener != null) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkMainThread("Must be called from the main thread.");
            try {
                this.zzb.zzi(new zzaw(sessionManagerListener, cls));
                return;
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "addSessionManagerListener", zzal.class.getSimpleName());
                return;
            }
        }
        throw new NullPointerException("SessionManagerListener can't be null");
    }

    public <T extends Session> void removeSessionManagerListener(@RecentlyNonNull SessionManagerListener<T> sessionManagerListener, @RecentlyNonNull Class cls) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sessionManagerListener == null) {
            return;
        }
        try {
            this.zzb.zzl(new zzaw(sessionManagerListener, cls));
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "removeSessionManagerListener", zzal.class.getSimpleName());
        }
    }
}
