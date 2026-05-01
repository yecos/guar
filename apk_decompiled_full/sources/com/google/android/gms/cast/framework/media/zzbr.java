package com.google.android.gms.cast.framework.media;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
final class zzbr implements DialogInterface.OnClickListener {
    final /* synthetic */ TracksChooserDialogFragment zza;

    public zzbr(TracksChooserDialogFragment tracksChooserDialogFragment) {
        this.zza = tracksChooserDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.zza.zze;
        if (dialog != null) {
            dialog2 = this.zza.zze;
            dialog2.cancel();
            this.zza.zze = null;
        }
    }
}
