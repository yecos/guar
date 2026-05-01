package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class zzbs implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbv zza;
    final /* synthetic */ zzbv zzb;
    final /* synthetic */ TracksChooserDialogFragment zzc;

    public zzbs(TracksChooserDialogFragment tracksChooserDialogFragment, zzbv zzbvVar, zzbv zzbvVar2) {
        this.zzc = tracksChooserDialogFragment;
        this.zza = zzbvVar;
        this.zzb = zzbvVar2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        TracksChooserDialogFragment.zzc(this.zzc, this.zza, this.zzb);
    }
}
