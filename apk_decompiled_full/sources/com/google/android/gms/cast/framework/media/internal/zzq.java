package com.google.android.gms.cast.framework.media.internal;

import com.google.android.gms.cast.MediaMetadata;

/* loaded from: classes.dex */
public final class zzq {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r1 != 4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r4.containsKey(com.google.android.gms.cast.MediaMetadata.KEY_COMPOSER) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String zza(MediaMetadata mediaMetadata) {
        String str = MediaMetadata.KEY_SUBTITLE;
        if (!mediaMetadata.containsKey(MediaMetadata.KEY_SUBTITLE)) {
            int mediaType = mediaMetadata.getMediaType();
            if (mediaType == 1) {
                str = MediaMetadata.KEY_STUDIO;
            } else if (mediaType == 2) {
                str = MediaMetadata.KEY_SERIES_TITLE;
            } else if (mediaType == 3) {
                if (!mediaMetadata.containsKey(MediaMetadata.KEY_ARTIST)) {
                    String str2 = MediaMetadata.KEY_ALBUM_ARTIST;
                    if (!mediaMetadata.containsKey(MediaMetadata.KEY_ALBUM_ARTIST)) {
                        str2 = MediaMetadata.KEY_COMPOSER;
                    }
                    str = str2;
                }
                str = MediaMetadata.KEY_ARTIST;
            }
        }
        return mediaMetadata.getString(str);
    }
}
