package com.google.android.gms.cast.framework.media.widget;

import android.view.View;
import android.widget.TextView;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* loaded from: classes.dex */
final class zzi implements View.OnClickListener {
    final /* synthetic */ ExpandedControllerActivity zza;

    public zzi(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r1 = r0.zza.zzl();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        TextView textView;
        RemoteMediaClient zzl;
        textView = this.zza.zzG;
        if (!textView.isClickable() || zzl == null) {
            return;
        }
        zzl.skipAd();
    }
}
