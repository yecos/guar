package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzas extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzas(RemoteMediaClient remoteMediaClient, int i10, int i11, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = i10;
        this.zzb = i11;
        this.zzc = jSONObject;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        MediaQueueItem queueItem;
        com.google.android.gms.cast.internal.zzap zzapVar;
        RemoteMediaClient remoteMediaClient = this.zzd;
        int i10 = this.zza;
        Preconditions.checkMainThread("Must be called from the main thread.");
        int indexOfItemWithId = remoteMediaClient.getMediaQueue().indexOfItemWithId(i10);
        int i11 = 0;
        if (indexOfItemWithId == -1) {
            MediaStatus mediaStatus = (MediaStatus) Preconditions.checkNotNull(remoteMediaClient.getMediaStatus());
            indexOfItemWithId = 0;
            while (true) {
                if (indexOfItemWithId >= mediaStatus.getQueueItemCount()) {
                    indexOfItemWithId = -1;
                    break;
                } else if (((MediaQueueItem) Preconditions.checkNotNull(mediaStatus.getQueueItem(indexOfItemWithId))).getItemId() == i10) {
                    break;
                } else {
                    indexOfItemWithId++;
                }
            }
        }
        int i12 = this.zzb;
        if (i12 < 0) {
            setResult(new zzbk(this, new Status(CastStatusCodes.INVALID_REQUEST, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(this.zzb)))));
            return;
        }
        if (indexOfItemWithId == i12) {
            setResult(new zzbk(this, new Status(0)));
            return;
        }
        if (i12 > indexOfItemWithId) {
            i12++;
        }
        RemoteMediaClient remoteMediaClient2 = this.zzd;
        Preconditions.checkMainThread("Must be called from the main thread.");
        int itemIdAtIndex = remoteMediaClient2.getMediaQueue().itemIdAtIndex(i12);
        if (itemIdAtIndex != 0) {
            i11 = itemIdAtIndex;
        } else {
            MediaStatus mediaStatus2 = remoteMediaClient2.getMediaStatus();
            if (mediaStatus2 != null && (queueItem = mediaStatus2.getQueueItem(i12)) != null) {
                i11 = queueItem.getItemId();
            }
        }
        zzapVar = this.zzd.zzd;
        zzapVar.zzz(zzb(), new int[]{this.zza}, i11, this.zzc);
    }
}
