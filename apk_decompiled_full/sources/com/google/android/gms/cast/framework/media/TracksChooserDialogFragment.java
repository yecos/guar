package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.d;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TracksChooserDialogFragment extends d {
    boolean zza;
    List<MediaTrack> zzb;
    List<MediaTrack> zzc;
    private long[] zzd;
    private Dialog zze;
    private RemoteMediaClient zzf;
    private MediaInfo zzg;
    private long[] zzh;

    @Deprecated
    public TracksChooserDialogFragment() {
    }

    @RecentlyNonNull
    public static TracksChooserDialogFragment newInstance() {
        return new TracksChooserDialogFragment();
    }

    public static /* bridge */ /* synthetic */ void zzc(TracksChooserDialogFragment tracksChooserDialogFragment, zzbv zzbvVar, zzbv zzbvVar2) {
        if (!tracksChooserDialogFragment.zza) {
            tracksChooserDialogFragment.zzf();
            return;
        }
        RemoteMediaClient remoteMediaClient = (RemoteMediaClient) Preconditions.checkNotNull(tracksChooserDialogFragment.zzf);
        if (!remoteMediaClient.hasMediaSession()) {
            tracksChooserDialogFragment.zzf();
            return;
        }
        ArrayList arrayList = new ArrayList();
        MediaTrack zza = zzbvVar.zza();
        if (zza != null && zza.getId() != -1) {
            arrayList.add(Long.valueOf(zza.getId()));
        }
        MediaTrack zza2 = zzbvVar2.zza();
        if (zza2 != null) {
            arrayList.add(Long.valueOf(zza2.getId()));
        }
        long[] jArr = tracksChooserDialogFragment.zzd;
        if (jArr != null && jArr.length > 0) {
            HashSet hashSet = new HashSet();
            Iterator<MediaTrack> it = tracksChooserDialogFragment.zzc.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(it.next().getId()));
            }
            Iterator<MediaTrack> it2 = tracksChooserDialogFragment.zzb.iterator();
            while (it2.hasNext()) {
                hashSet.add(Long.valueOf(it2.next().getId()));
            }
            for (long j10 : jArr) {
                Long valueOf = Long.valueOf(j10);
                if (!hashSet.contains(valueOf)) {
                    arrayList.add(valueOf);
                }
            }
        }
        long[] jArr2 = new long[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            jArr2[i10] = ((Long) arrayList.get(i10)).longValue();
        }
        Arrays.sort(jArr2);
        remoteMediaClient.setActiveMediaTracks(jArr2);
        tracksChooserDialogFragment.zzf();
    }

    private static int zzd(List<MediaTrack> list, long[] jArr, int i10) {
        if (jArr != null && list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                for (long j10 : jArr) {
                    if (j10 == list.get(i11).getId()) {
                        return i11;
                    }
                }
            }
        }
        return i10;
    }

    private static ArrayList<MediaTrack> zze(List<MediaTrack> list, int i10) {
        ArrayList<MediaTrack> arrayList = new ArrayList<>();
        for (MediaTrack mediaTrack : list) {
            if (mediaTrack.getType() == i10) {
                arrayList.add(mediaTrack);
            }
        }
        return arrayList;
    }

    private final void zzf() {
        Dialog dialog = this.zze;
        if (dialog != null) {
            dialog.cancel();
            this.zze = null;
        }
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = true;
        this.zzc = new ArrayList();
        this.zzb = new ArrayList();
        this.zzd = new long[0];
        CastSession currentCastSession = CastContext.getSharedInstance(getContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            this.zza = false;
            return;
        }
        RemoteMediaClient remoteMediaClient = currentCastSession.getRemoteMediaClient();
        this.zzf = remoteMediaClient;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || this.zzf.getMediaInfo() == null) {
            this.zza = false;
            return;
        }
        RemoteMediaClient remoteMediaClient2 = this.zzf;
        long[] jArr = this.zzh;
        if (jArr != null) {
            this.zzd = jArr;
        } else {
            MediaStatus mediaStatus = remoteMediaClient2.getMediaStatus();
            if (mediaStatus != null) {
                this.zzd = mediaStatus.getActiveTrackIds();
            }
        }
        MediaInfo mediaInfo = this.zzg;
        if (mediaInfo == null) {
            mediaInfo = remoteMediaClient2.getMediaInfo();
        }
        if (mediaInfo == null) {
            this.zza = false;
            return;
        }
        List<MediaTrack> mediaTracks = mediaInfo.getMediaTracks();
        if (mediaTracks == null) {
            this.zza = false;
            return;
        }
        this.zzc = zze(mediaTracks, 2);
        ArrayList<MediaTrack> zze = zze(mediaTracks, 1);
        this.zzb = zze;
        if (zze.isEmpty()) {
            return;
        }
        List<MediaTrack> list = this.zzb;
        MediaTrack.Builder builder = new MediaTrack.Builder(-1L, 1);
        builder.setName(getActivity().getString(R.string.cast_tracks_chooser_dialog_none));
        builder.setSubtype(2);
        builder.setContentId("");
        list.add(0, builder.build());
    }

    @Override // androidx.fragment.app.d
    @RecentlyNonNull
    public Dialog onCreateDialog(Bundle bundle) {
        int zzd = zzd(this.zzb, this.zzd, 0);
        int zzd2 = zzd(this.zzc, this.zzd, -1);
        zzbv zzbvVar = new zzbv(getActivity(), this.zzb, zzd);
        zzbv zzbvVar2 = new zzbv(getActivity(), this.zzc, zzd2);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.cast_tracks_chooser_dialog_layout, (ViewGroup) null);
        int i10 = R.id.text_list_view;
        ListView listView = (ListView) inflate.findViewById(i10);
        int i11 = R.id.audio_list_view;
        ListView listView2 = (ListView) inflate.findViewById(i11);
        TabHost tabHost = (TabHost) inflate.findViewById(R.id.tab_host);
        tabHost.setup();
        if (zzbvVar.getCount() == 0) {
            listView.setVisibility(4);
        } else {
            listView.setAdapter((ListAdapter) zzbvVar);
            TabHost.TabSpec newTabSpec = tabHost.newTabSpec("textTab");
            newTabSpec.setContent(i10);
            newTabSpec.setIndicator(getActivity().getString(R.string.cast_tracks_chooser_dialog_subtitles));
            tabHost.addTab(newTabSpec);
        }
        if (zzbvVar2.getCount() <= 1) {
            listView2.setVisibility(4);
        } else {
            listView2.setAdapter((ListAdapter) zzbvVar2);
            TabHost.TabSpec newTabSpec2 = tabHost.newTabSpec("audioTab");
            newTabSpec2.setContent(i11);
            newTabSpec2.setIndicator(getActivity().getString(R.string.cast_tracks_chooser_dialog_audio));
            tabHost.addTab(newTabSpec2);
        }
        builder.setView(inflate).setPositiveButton(getActivity().getString(R.string.cast_tracks_chooser_dialog_ok), new zzbs(this, zzbvVar, zzbvVar2)).setNegativeButton(R.string.cast_tracks_chooser_dialog_cancel, new zzbr(this));
        Dialog dialog = this.zze;
        if (dialog != null) {
            dialog.cancel();
            this.zze = null;
        }
        AlertDialog create = builder.create();
        this.zze = create;
        return create;
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private TracksChooserDialogFragment(MediaInfo mediaInfo, long[] jArr) {
        this.zzg = mediaInfo;
        this.zzh = jArr;
    }

    @RecentlyNonNull
    @Deprecated
    public static TracksChooserDialogFragment newInstance(@RecentlyNonNull MediaInfo mediaInfo, @RecentlyNonNull long[] jArr) {
        return new TracksChooserDialogFragment(mediaInfo, jArr);
    }
}
