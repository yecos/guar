package com.google.android.gms.cast;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface HlsSegmentFormat {

    @RecentlyNonNull
    public static final String AAC = "aac";

    @RecentlyNonNull
    public static final String AC3 = "ac3";

    @RecentlyNonNull
    public static final String E_AC3 = "e-ac3";

    @RecentlyNonNull
    public static final String FMP4 = "fmp4";

    @RecentlyNonNull
    public static final String MP3 = "mp3";

    @RecentlyNonNull
    public static final String TS = "ts";

    @RecentlyNonNull
    public static final String TS_AAC = "ts_aac";
}
