package com.google.android.gms.cast.framework.media;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;

/* loaded from: classes.dex */
public class ImagePicker {
    public static final int IMAGE_TYPE_EXPANDED_CONTROLLER_BACKGROUND = 4;
    public static final int IMAGE_TYPE_LOCK_SCREEN_BACKGROUND = 3;
    public static final int IMAGE_TYPE_MEDIA_ROUTE_CONTROLLER_DIALOG_BACKGROUND = 0;
    public static final int IMAGE_TYPE_MINI_CONTROLLER_THUMBNAIL = 2;
    public static final int IMAGE_TYPE_NOTIFICATION_THUMBNAIL = 1;
    public static final int IMAGE_TYPE_UNKNOWN = -1;
    private final zzd zza = new zzj(this, null);

    @RecentlyNullable
    @Deprecated
    public WebImage onPickImage(@RecentlyNonNull MediaMetadata mediaMetadata, int i10) {
        if (mediaMetadata == null || !mediaMetadata.hasImages()) {
            return null;
        }
        return mediaMetadata.getImages().get(0);
    }

    public final zzd zza() {
        return this.zza;
    }

    @RecentlyNullable
    public WebImage onPickImage(@RecentlyNonNull MediaMetadata mediaMetadata, @RecentlyNonNull ImageHints imageHints) {
        return onPickImage(mediaMetadata, imageHints.getType());
    }
}
