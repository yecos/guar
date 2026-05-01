package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import q.h;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, Context context2, int i10) {
        return getDrawable(context, context2, i10, null);
    }

    private static Drawable loadDrawableV4(Context context, int i10, Resources.Theme theme) {
        return h.d(context.getResources(), i10, theme);
    }

    private static Drawable loadDrawableV7(Context context, int i10, Resources.Theme theme) {
        Resources resources;
        if (theme != null && Build.VERSION.SDK_INT >= 21) {
            g.d dVar = new g.d(context, theme);
            resources = theme.getResources();
            dVar.a(resources.getConfiguration());
            context = dVar;
        }
        return d.b.d(context, i10);
    }

    public static Drawable getDrawable(Context context, int i10, Resources.Theme theme) {
        return getDrawable(context, context, i10, theme);
    }

    private static Drawable getDrawable(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return p.a.getDrawable(context2, i10);
            }
            throw e10;
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i10, theme);
    }
}
