package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzaw<T extends Session> extends zzam {
    private final SessionManagerListener<T> zza;
    private final Class<T> zzb;

    public zzaw(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        this.zza = sessionManagerListener;
        this.zzb = cls;
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzc(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionEnded(this.zzb.cast(session), i10);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzd(IObjectWrapper iObjectWrapper) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionEnding(this.zzb.cast(session));
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zze(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionResumeFailed(this.zzb.cast(session), i10);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzf(IObjectWrapper iObjectWrapper, boolean z10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionResumed(this.zzb.cast(session), z10);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzg(IObjectWrapper iObjectWrapper, String str) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionResuming(this.zzb.cast(session), str);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzh(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionStartFailed(this.zzb.cast(session), i10);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzi(IObjectWrapper iObjectWrapper, String str) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionStarted(this.zzb.cast(session), str);
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzj(IObjectWrapper iObjectWrapper) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionStarting(this.zzb.cast(session));
    }

    @Override // com.google.android.gms.cast.framework.zzan
    public final void zzk(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zzb.isInstance(session) || (sessionManagerListener = this.zza) == null) {
            return;
        }
        sessionManagerListener.onSessionSuspended(this.zzb.cast(session), i10);
    }
}
