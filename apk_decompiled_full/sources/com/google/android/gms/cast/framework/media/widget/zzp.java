package com.google.android.gms.cast.framework.media.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.widget.AbsSeekBar;
import android.widget.SeekBar;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.reflect.Field;
import p.a;
import s.h;

/* loaded from: classes.dex */
public final class zzp {
    private static final Logger zza = new Logger("WidgetUtil");

    public static Bitmap zza(Context context, Bitmap bitmap, float f10, float f11) {
        Logger logger = zza;
        logger.d("Begin blurring bitmap %s, original width = %d, original height = %d.", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        int round = Math.round(bitmap.getWidth() * 0.25f);
        int round2 = Math.round(bitmap.getHeight() * 0.25f);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, createScaledBitmap.getConfig());
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(7.5f);
        create2.forEach(createTyped);
        createTyped.copyTo(createBitmap);
        create.destroy();
        logger.d("End blurring bitmap %s, original width = %d, original height = %d.", createScaledBitmap, Integer.valueOf(round), Integer.valueOf(round2));
        return createBitmap;
    }

    public static Drawable zzb(Context context, int i10, int i11) {
        return zze(context, i10, i11, 0, R.color.white);
    }

    public static Drawable zzc(Context context, int i10, int i11) {
        return zze(context, i10, i11, R.attr.colorForeground, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029 A[Catch: Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:9:0x0029, B:17:0x001d, B:5:0x0008, B:7:0x0018), top: B:4:0x0008, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable zzd(SeekBar seekBar) {
        Field field;
        if (PlatformVersion.isAtLeastJellyBean()) {
            return seekBar.getThumb();
        }
        try {
            try {
                field = AbsSeekBar.class.getDeclaredField("mThumb");
            } catch (Exception unused) {
                zza.w("Failed to get the thumb field of the SeekBar.", new Object[0]);
            }
        } catch (Exception unused2) {
            zza.w("Failed to get the thumb of the SeekBar. The SeekBar might look incorrect", new Object[0]);
        }
        if (field.getType() == Drawable.class) {
            field.setAccessible(true);
            if (field != null) {
                return (Drawable) field.get(seekBar);
            }
            return null;
        }
        field = null;
        if (field != null) {
        }
        return null;
    }

    private static Drawable zze(Context context, int i10, int i11, int i12, int i13) {
        int color;
        ColorStateList colorStateList;
        Drawable r10 = h.r(context.getResources().getDrawable(i11).mutate());
        h.p(r10, PorterDuff.Mode.SRC_IN);
        if (i10 != 0) {
            colorStateList = a.getColorStateList(context, i10);
        } else {
            if (i12 != 0) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i12});
                color = obtainStyledAttributes.getColor(0, 0);
                obtainStyledAttributes.recycle();
            } else {
                color = a.getColor(context, i13);
            }
            colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{color, r.a.m(color, 128)});
        }
        h.o(r10, colorStateList);
        return r10;
    }
}
