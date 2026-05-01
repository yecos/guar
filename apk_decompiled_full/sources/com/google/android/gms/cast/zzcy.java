package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzcy extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, int i11, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = i11;
        this.zzc = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        int zza = RemoteMediaPlayer.zza(this.zzd, this.zza);
        if (zza == -1) {
            setResult((zzcy) new zzdk(this, new Status(0)));
            return;
        }
        int i10 = this.zzb;
        if (i10 < 0) {
            setResult((zzcy) new zzdk(this, new Status(CastStatusCodes.INVALID_REQUEST, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(this.zzb)))));
            return;
        }
        if (zza == i10) {
            setResult((zzcy) new zzdk(this, new Status(0)));
            return;
        }
        MediaStatus mediaStatus = this.zzd.getMediaStatus();
        if (mediaStatus == null) {
            setResult((zzcy) new zzdk(this, new Status(CastStatusCodes.INVALID_REQUEST, String.format(Locale.ROOT, "Invalid request: Invalid MediaStatus", new Object[0]))));
            return;
        }
        int i11 = this.zzb;
        if (i11 > zza) {
            i11++;
        }
        MediaQueueItem queueItem = mediaStatus.getQueueItem(i11);
        int itemId = queueItem != null ? queueItem.getItemId() : 0;
        zzapVar = this.zzd.zzb;
        zzapVar.zzz(zzb(), new int[]{this.zza}, itemId, this.zzc);
    }
}
