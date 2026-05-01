package com.google.android.gms.cast.framework.media;

import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.util.PlatformVersion;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Locale;

/* loaded from: classes.dex */
public class MediaUtils {
    private MediaUtils() {
    }

    @RecentlyNullable
    public static Uri getImageUri(MediaInfo mediaInfo, int i10) {
        MediaMetadata metadata;
        if (mediaInfo == null || (metadata = mediaInfo.getMetadata()) == null || metadata.getImages() == null || metadata.getImages().size() <= i10) {
            return null;
        }
        return metadata.getImages().get(i10).getUrl();
    }

    @RecentlyNullable
    public static String getImageUrl(MediaInfo mediaInfo, int i10) {
        Uri imageUri = getImageUri(mediaInfo, i10);
        if (imageUri == null) {
            return null;
        }
        return imageUri.toString();
    }

    @RecentlyNullable
    @Deprecated
    public static Locale getTrackLanguage(@RecentlyNonNull MediaTrack mediaTrack) {
        Locale forLanguageTag;
        String language = mediaTrack.getLanguage();
        if (language == null) {
            return null;
        }
        if (PlatformVersion.isAtLeastLollipop()) {
            forLanguageTag = Locale.forLanguageTag(language);
            return forLanguageTag;
        }
        String[] split = language.split(Operator.Operation.MINUS);
        return split.length == 1 ? new Locale(split[0]) : new Locale(split[0], split[1]);
    }
}
