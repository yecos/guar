package com.google.android.gms.cast.framework.media;

import android.util.LruCache;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzs extends LruCache<Integer, MediaQueueItem> {
    final /* synthetic */ MediaQueue zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(MediaQueue mediaQueue, int i10) {
        super(i10);
        this.zza = mediaQueue;
    }

    @Override // android.util.LruCache
    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z10, Integer num, MediaQueueItem mediaQueueItem, MediaQueueItem mediaQueueItem2) {
        Integer num2 = num;
        if (z10) {
            Preconditions.checkNotNull(this.zza.zze);
            this.zza.zze.add(num2);
        }
    }
}
