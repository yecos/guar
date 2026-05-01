package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class zzbo implements com.google.android.gms.cast.internal.zzam {
    final /* synthetic */ RemoteMediaClient zza;

    public /* synthetic */ zzbo(RemoteMediaClient remoteMediaClient, zzbn zzbnVar) {
        this.zza = remoteMediaClient;
    }

    private final void zzn() {
        RemoteMediaClient.ParseAdsInfoCallback parseAdsInfoCallback;
        MediaStatus mediaStatus;
        RemoteMediaClient.ParseAdsInfoCallback parseAdsInfoCallback2;
        RemoteMediaClient.ParseAdsInfoCallback parseAdsInfoCallback3;
        parseAdsInfoCallback = this.zza.zzk;
        if (parseAdsInfoCallback == null || (mediaStatus = this.zza.getMediaStatus()) == null) {
            return;
        }
        MediaStatus.Writer writer = mediaStatus.getWriter();
        parseAdsInfoCallback2 = this.zza.zzk;
        writer.setIsPlayingAd(parseAdsInfoCallback2.parseIsPlayingAdFromMediaStatus(mediaStatus));
        parseAdsInfoCallback3 = this.zza.zzk;
        List<AdBreakInfo> parseAdBreaksFromMediaStatus = parseAdsInfoCallback3.parseAdBreaksFromMediaStatus(mediaStatus);
        MediaInfo mediaInfo = this.zza.getMediaInfo();
        if (mediaInfo != null) {
            mediaInfo.getWriter().setAdBreaks(parseAdBreaksFromMediaStatus);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zza() {
        List list;
        list = this.zza.zzh;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onAdBreakStatusUpdated();
        }
        Iterator<RemoteMediaClient.Callback> it2 = this.zza.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onAdBreakStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzb(MediaError mediaError) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().onMediaError(mediaError);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzc() {
        List list;
        zzn();
        list = this.zza.zzh;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onMetadataUpdated();
        }
        Iterator<RemoteMediaClient.Callback> it2 = this.zza.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onMetadataUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzd() {
        List list;
        list = this.zza.zzh;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onPreloadStatusUpdated();
        }
        Iterator<RemoteMediaClient.Callback> it2 = this.zza.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zze(int[] iArr) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zza(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzf(int[] iArr, int i10) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zzb(iArr, i10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzg(MediaQueueItem[] mediaQueueItemArr) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zzc(mediaQueueItemArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzh(int[] iArr) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zzd(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzi(List<Integer> list, List<Integer> list2, int i10) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zze(list, list2, i10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzj(int[] iArr) {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zzf(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzk() {
        List list;
        list = this.zza.zzh;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onQueueStatusUpdated();
        }
        Iterator<RemoteMediaClient.Callback> it2 = this.zza.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onQueueStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzl() {
        Iterator<RemoteMediaClient.Callback> it = this.zza.zza.iterator();
        while (it.hasNext()) {
            it.next().zzg();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzam
    public final void zzm() {
        List list;
        zzn();
        RemoteMediaClient.zzl(this.zza);
        list = this.zza.zzh;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onStatusUpdated();
        }
        Iterator<RemoteMediaClient.Callback> it2 = this.zza.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onStatusUpdated();
        }
    }
}
