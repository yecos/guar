package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.TransferCallback;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import n0.t0;

/* loaded from: classes.dex */
public final class zzar {
    private static final Logger zza = new Logger("TransferController");
    private final Set<TransferCallback> zzb = new HashSet();
    private int zzc = 0;
    private SessionManager zzd;
    private zzno<Void> zze;
    private SessionState zzf;

    public static /* synthetic */ void zza(zzar zzarVar, Exception exc) {
        zza.w(exc, "Error storing session", new Object[0]);
        zzno<Void> zznoVar = zzarVar.zze;
        if (zznoVar != null) {
            zznoVar.cancel(false);
        }
    }

    public static /* synthetic */ void zzb(zzar zzarVar, SessionState sessionState) {
        if (sessionState == null) {
            return;
        }
        zzarVar.zzf = sessionState;
        zzno<Void> zznoVar = zzarVar.zze;
        if (zznoVar != null) {
            zznoVar.zzj(null);
        }
    }

    private final void zzf() {
        CastSession currentCastSession;
        SessionManager sessionManager = this.zzd;
        if (sessionManager == null || (currentCastSession = sessionManager.getCurrentCastSession()) == null) {
            return;
        }
        currentCastSession.zzi(null);
    }

    public final void zzc(SessionManager sessionManager) {
        this.zzd = sessionManager;
    }

    public final void zzd() {
        SessionState sessionState;
        int i10 = this.zzc;
        if (i10 == 0 || (sessionState = this.zzf) == null) {
            return;
        }
        zza.d("notify transferred with type = %d, sessionState = %s", Integer.valueOf(i10), this.zzf);
        Iterator it = new HashSet(this.zzb).iterator();
        while (it.hasNext()) {
            ((TransferCallback) it.next()).onTransfer(this.zzc, sessionState);
        }
        this.zzc = 0;
        this.zzf = null;
        zzf();
    }

    public final void zze(t0.i iVar, t0.i iVar2, zzno<Void> zznoVar) {
        CastSession currentCastSession;
        if (new HashSet(this.zzb).isEmpty()) {
            zza.d("No need to prepare transfer without any callback", new Object[0]);
            zznoVar.zzj(null);
            return;
        }
        if (iVar.o() != 1 || iVar2.o() != 0) {
            zza.d("No need to prepare transfer for non cast-to-phone case", new Object[0]);
            zznoVar.zzj(null);
            return;
        }
        SessionManager sessionManager = this.zzd;
        if (sessionManager == null) {
            currentCastSession = null;
        } else {
            currentCastSession = sessionManager.getCurrentCastSession();
            if (currentCastSession != null) {
                currentCastSession.zzi(this);
            }
        }
        if (currentCastSession == null) {
            zza.d("No need to prepare transfer when there is no Cast session", new Object[0]);
            zznoVar.zzj(null);
            return;
        }
        RemoteMediaClient remoteMediaClient = currentCastSession.getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            zza.d("No need to prepare transfer when there is no media session", new Object[0]);
            zzf();
            zznoVar.zzj(null);
        } else {
            zza.d("Prepare route transfer for changing endpoint", new Object[0]);
            this.zzf = null;
            this.zzc = 1;
            this.zze = zznoVar;
            remoteMediaClient.zzi(null).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.internal.cast.zzaq
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    zzar.zzb(zzar.this, (SessionState) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.cast.zzap
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    zzar.zza(zzar.this, exc);
                }
            });
            zzl.zzd(zzju.CAST_TRANSFER_TO_LOCAL_USED);
        }
    }
}
