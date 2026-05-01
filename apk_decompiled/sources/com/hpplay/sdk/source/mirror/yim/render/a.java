package com.hpplay.sdk.source.mirror.yim.render;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f7726a = 1080;

    /* renamed from: b, reason: collision with root package name */
    private static final int f7727b = 1920;

    /* renamed from: c, reason: collision with root package name */
    private static final String f7728c = "DimensUtils";

    /* renamed from: d, reason: collision with root package name */
    private static int f7729d;

    /* renamed from: e, reason: collision with root package name */
    private static int f7730e;

    public static void a(Context context) {
        int[] relScreenSize = ScreenUtil.getRelScreenSize(context);
        f7730e = relScreenSize[0];
        f7729d = relScreenSize[1];
        SourceLog.i(f7728c, " mCurrentWidth  " + f7730e + " mCurrentHeight " + f7729d);
    }

    public static int b(int i10) {
        return (f7729d * i10) / f7727b;
    }

    public static int a(int i10) {
        return (f7730e * i10) / f7726a;
    }

    public static GradientDrawable a(int i10, int i11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i11);
        float a10 = a(30);
        gradientDrawable.setCornerRadii(new float[]{a10, a10, a10, a10, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setAlpha(160);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "DimensUtils"
            r1 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r2.<init>()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r2.append(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.String r3 = ".png"
            r2.append(r3)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.io.InputStream r4 = r4.open(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromStream(r4, r5)     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L3f
            if (r4 == 0) goto L2a
            r4.close()     // Catch: java.lang.Exception -> L26
            goto L2a
        L26:
            r4 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w(r0, r4)
        L2a:
            return r5
        L2b:
            r5 = move-exception
            goto L31
        L2d:
            r5 = move-exception
            goto L41
        L2f:
            r5 = move-exception
            r4 = r1
        L31:
            com.hpplay.sdk.source.log.SourceLog.w(r0, r5)     // Catch: java.lang.Throwable -> L3f
            if (r4 == 0) goto L3e
            r4.close()     // Catch: java.lang.Exception -> L3a
            goto L3e
        L3a:
            r4 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w(r0, r4)
        L3e:
            return r1
        L3f:
            r5 = move-exception
            r1 = r4
        L41:
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.lang.Exception -> L47
            goto L4b
        L47:
            r4 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w(r0, r4)
        L4b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mirror.yim.render.a.a(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }
}
