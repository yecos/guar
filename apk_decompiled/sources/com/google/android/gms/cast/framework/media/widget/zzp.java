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
import com.google.android.gms.cast.internal.Logger;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable zzd(android.widget.SeekBar r5) {
        /*
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBean()
            if (r0 != 0) goto L3a
            r0 = 0
            r1 = 0
            java.lang.Class<android.widget.AbsSeekBar> r2 = android.widget.AbsSeekBar.class
            java.lang.String r3 = "mThumb"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Exception -> L1d
            java.lang.Class r3 = r2.getType()     // Catch: java.lang.Exception -> L1d
            java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
            if (r3 != r4) goto L26
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Exception -> L1d
            goto L27
        L1d:
            com.google.android.gms.cast.internal.Logger r2 = com.google.android.gms.cast.framework.media.widget.zzp.zza     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = "Failed to get the thumb field of the SeekBar."
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L30
            r2.w(r3, r4)     // Catch: java.lang.Exception -> L30
        L26:
            r2 = r1
        L27:
            if (r2 == 0) goto L39
            java.lang.Object r5 = r2.get(r5)     // Catch: java.lang.Exception -> L30
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch: java.lang.Exception -> L30
            return r5
        L30:
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.framework.media.widget.zzp.zza
            java.lang.String r2 = "Failed to get the thumb of the SeekBar. The SeekBar might look incorrect"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r5.w(r2, r0)
        L39:
            return r1
        L3a:
            android.graphics.drawable.Drawable r5 = r5.getThumb()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.widget.zzp.zzd(android.widget.SeekBar):android.graphics.drawable.Drawable");
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
