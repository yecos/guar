package com.google.android.gms.cast.framework;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.List;

/* loaded from: classes.dex */
public interface OptionsProvider {
    @RecentlyNullable
    List<SessionProvider> getAdditionalSessionProviders(@RecentlyNonNull Context context);

    @RecentlyNonNull
    CastOptions getCastOptions(@RecentlyNonNull Context context);
}
