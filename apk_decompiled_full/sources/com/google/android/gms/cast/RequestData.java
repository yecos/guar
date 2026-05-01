package com.google.android.gms.cast;

import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface RequestData {
    @RecentlyNullable
    JSONObject getCustomData();

    @KeepForSdk
    long getRequestId();
}
