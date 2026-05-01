package com.google.android.gms.cast.framework;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.RecentlyNonNull;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.e;
import b0.t;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzju;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import n0.s0;

/* loaded from: classes.dex */
public final class CastButtonFactory {
    private static final Logger zza = new Logger("CastButtonFactory");
    private static final List<WeakReference<MenuItem>> zzb = new ArrayList();
    private static final List<WeakReference<MediaRouteButton>> zzc = new ArrayList();

    private CastButtonFactory() {
    }

    @RecentlyNonNull
    public static MenuItem setUpMediaRouteButton(@RecentlyNonNull Context context, @RecentlyNonNull Menu menu, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu);
        MenuItem findItem = menu.findItem(i10);
        if (findItem == null) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu doesn't contain a menu item whose ID is %d.", Integer.valueOf(i10)));
        }
        try {
            zzb(context, findItem, null);
            zzb.add(new WeakReference<>(findItem));
            com.google.android.gms.internal.cast.zzl.zzd(zzju.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
            return findItem;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu item with ID %d doesn't have a MediaRouteActionProvider.", Integer.valueOf(i10)));
        }
    }

    public static void zza(@RecentlyNonNull Context context) {
        Iterator<WeakReference<MenuItem>> it = zzb.iterator();
        while (it.hasNext()) {
            MenuItem menuItem = it.next().get();
            if (menuItem != null) {
                try {
                    zzb(context, menuItem, null);
                } catch (IllegalArgumentException e10) {
                    zza.w("Unexpected exception when refreshing MediaRouteSelectors for Cast buttons", e10);
                }
            }
        }
        Iterator<WeakReference<MediaRouteButton>> it2 = zzc.iterator();
        while (it2.hasNext()) {
            MediaRouteButton mediaRouteButton = it2.next().get();
            if (mediaRouteButton != null) {
                zzc(context, mediaRouteButton, null);
            }
        }
    }

    private static void zzb(Context context, MenuItem menuItem, e eVar) {
        s0 mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) t.a(menuItem);
        if (mediaRouteActionProvider == null) {
            throw new IllegalArgumentException();
        }
        CastContext zza2 = CastContext.zza(context);
        if (zza2 == null || (mergedSelector = zza2.getMergedSelector()) == null) {
            return;
        }
        mediaRouteActionProvider.o(mergedSelector);
    }

    private static void zzc(Context context, MediaRouteButton mediaRouteButton, e eVar) {
        s0 mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastContext zza2 = CastContext.zza(context);
        if (zza2 == null || (mergedSelector = zza2.getMergedSelector()) == null) {
            return;
        }
        mediaRouteButton.setRouteSelector(mergedSelector);
    }

    public static void setUpMediaRouteButton(@RecentlyNonNull Context context, @RecentlyNonNull MediaRouteButton mediaRouteButton) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (mediaRouteButton != null) {
            zzc(context, mediaRouteButton, null);
            zzc.add(new WeakReference<>(mediaRouteButton));
        }
        com.google.android.gms.internal.cast.zzl.zzd(zzju.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
