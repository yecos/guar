package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public interface zzd extends IInterface {
    WebImage zze(MediaMetadata mediaMetadata, int i10);

    WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints);

    IObjectWrapper zzg();
}
