package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
final class zza extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ zzh zza;

    public zza(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        boolean contains;
        zzg zzgVar;
        OuterHighlightDrawable outerHighlightDrawable;
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        contains = this.zza.zzc.contains(Math.round(x10), Math.round(y10));
        if (contains) {
            outerHighlightDrawable = this.zza.zzd;
            if (outerHighlightDrawable.zzg(x10, y10)) {
                return true;
            }
        }
        zzgVar = this.zza.zzk;
        zzgVar.zza();
        return true;
    }
}
