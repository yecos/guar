package com.hpplay.sdk.source.mirror.yim.render;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.sdk.source.log.SourceLog;
import java.io.InputStream;

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
    */
    public static Drawable a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getAssets().open(str + ".png");
            try {
                try {
                    Drawable createFromStream = Drawable.createFromStream(inputStream, str);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e10) {
                            SourceLog.w(f7728c, e10);
                        }
                    }
                    return createFromStream;
                } catch (Exception e11) {
                    e = e11;
                    SourceLog.w(f7728c, e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                            SourceLog.w(f7728c, e12);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e13) {
                        SourceLog.w(f7728c, e13);
                    }
                }
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }
}
