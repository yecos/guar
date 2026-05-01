package androidx.mediarouter.app;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ProgressBar;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$color;
import androidx.mediarouter.R$drawable;
import androidx.mediarouter.R$style;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2967a = R$color.mr_dynamic_dialog_icon_light;

    public static Context a(Context context) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, l(context));
        int p10 = p(contextThemeWrapper, R$attr.mediaRouteTheme);
        return p10 != 0 ? new ContextThemeWrapper(contextThemeWrapper, p10) : contextThemeWrapper;
    }

    public static Context b(Context context, int i10, boolean z10) {
        if (i10 == 0) {
            i10 = p(context, !z10 ? androidx.appcompat.R$attr.dialogTheme : androidx.appcompat.R$attr.alertDialogTheme);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        return p(contextThemeWrapper, R$attr.mediaRouteTheme) != 0 ? new ContextThemeWrapper(contextThemeWrapper, l(contextThemeWrapper)) : contextThemeWrapper;
    }

    public static int c(Context context) {
        int p10 = p(context, R$attr.mediaRouteTheme);
        return p10 == 0 ? l(context) : p10;
    }

    public static int d(Context context) {
        int o10 = o(context, 0, androidx.appcompat.R$attr.colorPrimary);
        return r.a.c(o10, o(context, 0, R.attr.colorBackground)) < 3.0d ? o(context, 0, androidx.appcompat.R$attr.colorAccent) : o10;
    }

    public static Drawable e(Context context) {
        return j(context, R$drawable.mr_cast_checkbox);
    }

    public static int f(Context context, int i10) {
        return r.a.c(-1, o(context, i10, androidx.appcompat.R$attr.colorPrimary)) >= 3.0d ? -1 : -570425344;
    }

    public static Drawable g(Context context) {
        return i(context, R$attr.mediaRouteDefaultIconDrawable);
    }

    public static float h(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    public static Drawable i(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i10});
        Drawable r10 = s.h.r(obtainStyledAttributes.getDrawable(0));
        if (r(context)) {
            s.h.n(r10, p.a.getColor(context, f2967a));
        }
        obtainStyledAttributes.recycle();
        return r10;
    }

    public static Drawable j(Context context, int i10) {
        Drawable r10 = s.h.r(p.a.getDrawable(context, i10));
        if (r(context)) {
            s.h.n(r10, p.a.getColor(context, f2967a));
        }
        return r10;
    }

    public static Drawable k(Context context) {
        return j(context, R$drawable.mr_cast_mute_button);
    }

    public static int l(Context context) {
        return r(context) ? f(context, 0) == -570425344 ? R$style.Theme_MediaRouter_Light : R$style.Theme_MediaRouter_Light_DarkControlPanel : f(context, 0) == -570425344 ? R$style.Theme_MediaRouter_LightControlPanel : R$style.Theme_MediaRouter;
    }

    public static Drawable m(Context context) {
        return i(context, R$attr.mediaRouteSpeakerIconDrawable);
    }

    public static Drawable n(Context context) {
        return i(context, R$attr.mediaRouteSpeakerGroupIconDrawable);
    }

    public static int o(Context context, int i10, int i11) {
        if (i10 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, new int[]{i11});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            if (color != 0) {
                return color;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId != 0 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
    }

    public static int p(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    public static Drawable q(Context context) {
        return i(context, R$attr.mediaRouteTvIconDrawable);
    }

    public static boolean r(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.appcompat.R$attr.isLightTheme, typedValue, true) && typedValue.data != 0;
    }

    public static void s(Context context, Dialog dialog) {
        dialog.getWindow().getDecorView().setBackgroundColor(p.a.getColor(context, r(context) ? R$color.mr_dynamic_dialog_background_light : R$color.mr_dynamic_dialog_background_dark));
    }

    public static void t(Context context, ProgressBar progressBar) {
        if (progressBar.isIndeterminate()) {
            progressBar.getIndeterminateDrawable().setColorFilter(p.a.getColor(context, r(context) ? R$color.mr_cast_progressbar_progress_and_thumb_light : R$color.mr_cast_progressbar_progress_and_thumb_dark), PorterDuff.Mode.SRC_IN);
        }
    }

    public static void u(Context context, View view, View view2, boolean z10) {
        int o10 = o(context, 0, androidx.appcompat.R$attr.colorPrimary);
        int o11 = o(context, 0, androidx.appcompat.R$attr.colorPrimaryDark);
        if (z10 && f(context, 0) == -570425344) {
            o11 = o10;
            o10 = -1;
        }
        view.setBackgroundColor(o10);
        view2.setBackgroundColor(o11);
        view.setTag(Integer.valueOf(o10));
        view2.setTag(Integer.valueOf(o11));
    }

    public static void v(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
        int color;
        int color2;
        if (r(context)) {
            color = p.a.getColor(context, R$color.mr_cast_progressbar_progress_and_thumb_light);
            color2 = p.a.getColor(context, R$color.mr_cast_progressbar_background_light);
        } else {
            color = p.a.getColor(context, R$color.mr_cast_progressbar_progress_and_thumb_dark);
            color2 = p.a.getColor(context, R$color.mr_cast_progressbar_background_dark);
        }
        mediaRouteVolumeSlider.b(color, color2);
    }

    public static void w(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider, View view) {
        int f10 = f(context, 0);
        if (Color.alpha(f10) != 255) {
            f10 = r.a.i(f10, ((Integer) view.getTag()).intValue());
        }
        mediaRouteVolumeSlider.a(f10);
    }
}
