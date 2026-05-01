package com.google.android.gms.cast;

import android.app.Presentation;
import android.content.Context;
import android.view.Display;
import android.view.Window;
import androidx.annotation.RecentlyNonNull;

@Deprecated
/* loaded from: classes.dex */
public abstract class CastPresentation extends Presentation {
    public CastPresentation(@RecentlyNonNull Context context, @RecentlyNonNull Display display) {
        super(context, display);
        zza();
    }

    private final void zza() {
        Window window = getWindow();
        if (window != null) {
            window.setType(2030);
            window.addFlags(268435456);
            window.addFlags(16777216);
            window.addFlags(1024);
        }
    }

    public CastPresentation(@RecentlyNonNull Context context, @RecentlyNonNull Display display, int i10) {
        super(context, display, i10);
        zza();
    }
}
