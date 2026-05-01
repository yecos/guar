package com.google.android.gms.cast;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface HlsVideoSegmentFormat {

    @RecentlyNonNull
    public static final String FMP4 = "fmp4";

    @RecentlyNonNull
    public static final String MPEG2_TS = "mpeg2_ts";
}
