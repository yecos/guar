package com.google.android.gms.cast.framework.media;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.MediaQueue;

/* loaded from: classes.dex */
public abstract class MediaQueueRecyclerViewAdapter<VH extends RecyclerView.d0> extends RecyclerView.g {
    private final MediaQueue zza;
    private final MediaQueue.Callback zzb;

    public MediaQueueRecyclerViewAdapter(@RecentlyNonNull MediaQueue mediaQueue) {
        this.zza = mediaQueue;
        zzx zzxVar = new zzx(this, null);
        this.zzb = zzxVar;
        mediaQueue.registerCallback(zzxVar);
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    @RecentlyNullable
    public MediaQueueItem getItem(int i10) {
        return this.zza.getItemAtIndex(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.zza.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        return this.zza.itemIdAtIndex(i10);
    }

    @RecentlyNonNull
    public MediaQueue getMediaQueue() {
        return this.zza;
    }
}
