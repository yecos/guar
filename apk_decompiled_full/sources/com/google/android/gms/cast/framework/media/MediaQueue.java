package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.util.SparseIntArray;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzco;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class MediaQueue {
    long zza;
    LruCache<Integer, MediaQueueItem> zzd;
    private final RemoteMediaClient zzh;
    private PendingResult<RemoteMediaClient.MediaChannelResult> zzl;
    private PendingResult<RemoteMediaClient.MediaChannelResult> zzm;
    private Set<Callback> zzn = new HashSet();
    private final Logger zzg = new Logger("MediaQueue");
    private final int zzi = Math.max(20, 1);
    List<Integer> zzb = new ArrayList();
    final SparseIntArray zzc = new SparseIntArray();
    final List<Integer> zze = new ArrayList();
    final Deque<Integer> zzf = new ArrayDeque(20);
    private final Handler zzj = new zzco(Looper.getMainLooper());
    private TimerTask zzk = new zzr(this);

    public static abstract class Callback {
        public void itemsInsertedInRange(int i10, int i11) {
        }

        public void itemsReloaded() {
        }

        public void itemsRemovedAtIndexes(@RecentlyNonNull int[] iArr) {
        }

        public void itemsReorderedAtIndexes(@RecentlyNonNull List<Integer> list, int i10) {
        }

        public void itemsUpdatedAtIndexes(@RecentlyNonNull int[] iArr) {
        }

        public void mediaQueueChanged() {
        }

        public void mediaQueueWillChange() {
        }
    }

    public MediaQueue(RemoteMediaClient remoteMediaClient, int i10, int i11) {
        this.zzh = remoteMediaClient;
        remoteMediaClient.registerCallback(new zzt(this));
        zzt(20);
        this.zza = zzp();
        zzo();
    }

    public static /* bridge */ /* synthetic */ void zze(MediaQueue mediaQueue, int i10, int i11) {
        Iterator<Callback> it = mediaQueue.zzn.iterator();
        while (it.hasNext()) {
            it.next().itemsInsertedInRange(i10, i11);
        }
    }

    public static /* bridge */ /* synthetic */ void zzf(MediaQueue mediaQueue, int[] iArr) {
        Iterator<Callback> it = mediaQueue.zzn.iterator();
        while (it.hasNext()) {
            it.next().itemsRemovedAtIndexes(iArr);
        }
    }

    public static /* bridge */ /* synthetic */ void zzg(MediaQueue mediaQueue, List list, int i10) {
        Iterator<Callback> it = mediaQueue.zzn.iterator();
        while (it.hasNext()) {
            it.next().itemsReorderedAtIndexes(list, i10);
        }
    }

    public static /* bridge */ /* synthetic */ void zzj(final MediaQueue mediaQueue) {
        if (mediaQueue.zzf.isEmpty() || mediaQueue.zzl != null || mediaQueue.zza == 0) {
            return;
        }
        PendingResult<RemoteMediaClient.MediaChannelResult> zzh = mediaQueue.zzh.zzh(CastUtils.zzi(mediaQueue.zzf));
        mediaQueue.zzl = zzh;
        zzh.setResultCallback(new ResultCallback() { // from class: com.google.android.gms.cast.framework.media.zzq
            @Override // com.google.android.gms.common.api.ResultCallback
            public final void onResult(Result result) {
                MediaQueue.this.zzn((RemoteMediaClient.MediaChannelResult) result);
            }
        });
        mediaQueue.zzf.clear();
    }

    public static /* bridge */ /* synthetic */ void zzk(MediaQueue mediaQueue) {
        mediaQueue.zzc.clear();
        for (int i10 = 0; i10 < mediaQueue.zzb.size(); i10++) {
            mediaQueue.zzc.put(mediaQueue.zzb.get(i10).intValue(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzp() {
        MediaStatus mediaStatus = this.zzh.getMediaStatus();
        if (mediaStatus == null || mediaStatus.zzd()) {
            return 0L;
        }
        return mediaStatus.zzb();
    }

    private final void zzq() {
        this.zzj.removeCallbacks(this.zzk);
    }

    private final void zzr() {
        PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult = this.zzm;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzm = null;
        }
    }

    private final void zzs() {
        PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult = this.zzl;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzl = null;
        }
    }

    private final void zzt(int i10) {
        this.zzd = new zzs(this, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        Iterator<Callback> it = this.zzn.iterator();
        while (it.hasNext()) {
            it.next().mediaQueueChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv() {
        Iterator<Callback> it = this.zzn.iterator();
        while (it.hasNext()) {
            it.next().itemsReloaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzw(int[] iArr) {
        Iterator<Callback> it = this.zzn.iterator();
        while (it.hasNext()) {
            it.next().itemsUpdatedAtIndexes(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzx() {
        Iterator<Callback> it = this.zzn.iterator();
        while (it.hasNext()) {
            it.next().mediaQueueWillChange();
        }
    }

    private final void zzy() {
        zzq();
        this.zzj.postDelayed(this.zzk, 500L);
    }

    @RecentlyNonNull
    public PendingResult<RemoteMediaClient.MediaChannelResult> fetchMoreItemsRelativeToIndex(int i10, int i11, int i12) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza == 0) {
            return RemoteMediaClient.zzd(2100, "No active media session");
        }
        int itemIdAtIndex = itemIdAtIndex(i10);
        return itemIdAtIndex == 0 ? RemoteMediaClient.zzd(CastStatusCodes.INVALID_REQUEST, "index out of bound") : this.zzh.zzf(itemIdAtIndex, i11, i12);
    }

    @RecentlyNullable
    public MediaQueueItem getItemAtIndex(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return getItemAtIndex(i10, true);
    }

    public int getItemCount() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzb.size();
    }

    @RecentlyNonNull
    public int[] getItemIds() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return CastUtils.zzi(this.zzb);
    }

    public int indexOfItemWithId(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzc.get(i10, -1);
    }

    public int itemIdAtIndex(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i10 < 0 || i10 >= this.zzb.size()) {
            return 0;
        }
        return this.zzb.get(i10).intValue();
    }

    public void registerCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.add(callback);
    }

    public void setCacheCapacity(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        LruCache<Integer, MediaQueueItem> lruCache = this.zzd;
        ArrayList arrayList = new ArrayList();
        zzt(i10);
        int size = lruCache.size();
        for (Map.Entry<Integer, MediaQueueItem> entry : lruCache.snapshot().entrySet()) {
            if (size > i10) {
                int i11 = this.zzc.get(entry.getKey().intValue(), -1);
                if (i11 != -1) {
                    arrayList.add(Integer.valueOf(i11));
                }
            } else {
                this.zzd.put(entry.getKey(), entry.getValue());
            }
            size--;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Collections.sort(arrayList);
        zzx();
        zzw(CastUtils.zzi(arrayList));
        zzu();
    }

    public void unregisterCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.remove(callback);
    }

    public final void zzl() {
        zzx();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.evictAll();
        this.zze.clear();
        zzq();
        this.zzf.clear();
        zzr();
        zzs();
        zzv();
        zzu();
    }

    public final void zzm(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.w(String.format("Error fetching queue item ids, statusCode=%s, statusMessage=%s", Integer.valueOf(statusCode), status.getStatusMessage()), new Object[0]);
        }
        this.zzm = null;
        if (this.zzf.isEmpty()) {
            return;
        }
        zzy();
    }

    public final void zzn(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.w(String.format("Error fetching queue items, statusCode=%s, statusMessage=%s", Integer.valueOf(statusCode), status.getStatusMessage()), new Object[0]);
        }
        this.zzl = null;
        if (this.zzf.isEmpty()) {
            return;
        }
        zzy();
    }

    public final void zzo() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza != 0 && this.zzm == null) {
            zzr();
            zzs();
            PendingResult<RemoteMediaClient.MediaChannelResult> zzg = this.zzh.zzg();
            this.zzm = zzg;
            zzg.setResultCallback(new ResultCallback() { // from class: com.google.android.gms.cast.framework.media.zzp
                @Override // com.google.android.gms.common.api.ResultCallback
                public final void onResult(Result result) {
                    MediaQueue.this.zzm((RemoteMediaClient.MediaChannelResult) result);
                }
            });
        }
    }

    @RecentlyNullable
    public MediaQueueItem getItemAtIndex(int i10, boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i10 < 0 || i10 >= this.zzb.size()) {
            return null;
        }
        int intValue = this.zzb.get(i10).intValue();
        LruCache<Integer, MediaQueueItem> lruCache = this.zzd;
        Integer valueOf = Integer.valueOf(intValue);
        MediaQueueItem mediaQueueItem = lruCache.get(valueOf);
        if (mediaQueueItem == null && z10 && !this.zzf.contains(valueOf)) {
            while (this.zzf.size() >= this.zzi) {
                this.zzf.removeFirst();
            }
            this.zzf.add(Integer.valueOf(intValue));
            zzy();
        }
        return mediaQueueItem;
    }
}
