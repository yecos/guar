package cn.bingoogolapple.bgabanner;

import a0.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import b0.c1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class BGABannerUtil {

    public static class LoadBitmapPair<S extends Throwable> extends d {
        public LoadBitmapPair(Bitmap bitmap, S s10) {
            super(bitmap, s10);
        }
    }

    private BGABannerUtil() {
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = 1;
        if (i10 != 0 && i11 != 0) {
            int i13 = options.outHeight;
            int i14 = options.outWidth;
            if (i13 > i11 || i14 > i10) {
                int i15 = i13 / 2;
                int i16 = i14 / 2;
                while (i15 / i12 >= i11 && i16 / i12 >= i10) {
                    i12 *= 2;
                }
            }
        }
        return i12;
    }

    public static int dp2px(Context context, float f10) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static LoadBitmapPair<Throwable> getImageFromResource(Context context, int i10, int i11, int i12) {
        LoadBitmapPair<Throwable> loadBitmapPair;
        InputStream openRawResource;
        LoadBitmapPair<Throwable> loadBitmapPair2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap.Config config = Bitmap.Config.RGB_565;
        InputStream inputStream = null;
        try {
            try {
                try {
                    if (i11 == 0 && i12 == 0) {
                        options.inPreferredConfig = config;
                        openRawResource = context.getResources().openRawResource(i10);
                        loadBitmapPair2 = new LoadBitmapPair<>(BitmapFactory.decodeStream(openRawResource, null, options), null);
                        openRawResource.close();
                    } else {
                        options.inJustDecodeBounds = true;
                        options.inPreferredConfig = config;
                        InputStream openRawResource2 = context.getResources().openRawResource(i10);
                        try {
                            BitmapFactory.decodeStream(openRawResource2, null, options);
                            openRawResource2.reset();
                            openRawResource2.close();
                            int i13 = options.outWidth;
                            int i14 = options.outHeight;
                            int resizedDimension = getResizedDimension(i11, i12, i13, i14);
                            int resizedDimension2 = getResizedDimension(i12, i11, i14, i13);
                            options.inJustDecodeBounds = false;
                            options.inSampleSize = calculateInSampleSize(options, resizedDimension, resizedDimension2);
                            options.inPreferredConfig = config;
                            openRawResource = context.getResources().openRawResource(i10);
                            Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
                            openRawResource.close();
                            if (decodeStream == null || (decodeStream.getWidth() <= resizedDimension && decodeStream.getHeight() <= resizedDimension2)) {
                                loadBitmapPair2 = new LoadBitmapPair<>(decodeStream, null);
                            } else {
                                LoadBitmapPair<Throwable> loadBitmapPair3 = new LoadBitmapPair<>(Bitmap.createScaledBitmap(decodeStream, resizedDimension, resizedDimension2, true), null);
                                decodeStream.recycle();
                                loadBitmapPair2 = loadBitmapPair3;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            context = openRawResource2;
                            e.printStackTrace();
                            loadBitmapPair = new LoadBitmapPair<>(null, e);
                            if (context != 0) {
                                try {
                                    context.close();
                                } catch (IOException e11) {
                                    e = e11;
                                    e.printStackTrace();
                                    return loadBitmapPair;
                                }
                            }
                            return loadBitmapPair;
                        } catch (OutOfMemoryError e12) {
                            e = e12;
                            context = openRawResource2;
                            e.printStackTrace();
                            loadBitmapPair = new LoadBitmapPair<>(null, e);
                            if (context != 0) {
                                try {
                                    context.close();
                                } catch (IOException e13) {
                                    e = e13;
                                    e.printStackTrace();
                                    return loadBitmapPair;
                                }
                            }
                            return loadBitmapPair;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = openRawResource2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        openRawResource.close();
                        return loadBitmapPair2;
                    } catch (IOException e15) {
                        e15.printStackTrace();
                        return loadBitmapPair2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = context;
                }
            } catch (Exception e16) {
                e = e16;
            } catch (OutOfMemoryError e17) {
                e = e17;
            }
        } catch (Exception e18) {
            e = e18;
            context = 0;
        } catch (OutOfMemoryError e19) {
            e = e19;
            context = 0;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static ImageView getItemImageView(Context context, int i10, BGALocalImageSize bGALocalImageSize, ImageView.ScaleType scaleType) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(getScaledImageFromResource(context, i10, bGALocalImageSize.getMaxWidth(), bGALocalImageSize.getMaxHeight(), bGALocalImageSize.getMinWidth(), bGALocalImageSize.getMinHeight()));
        imageView.setClickable(true);
        imageView.setScaleType(scaleType);
        return imageView;
    }

    public static int getResizedDimension(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0) {
            return i12;
        }
        if (i10 == 0) {
            double d10 = i11;
            double d11 = i13;
            Double.isNaN(d10);
            Double.isNaN(d11);
            double d12 = i12;
            Double.isNaN(d12);
            return (int) (d12 * (d10 / d11));
        }
        if (i11 == 0) {
            return i10;
        }
        double d13 = i13;
        double d14 = i12;
        Double.isNaN(d13);
        Double.isNaN(d14);
        double d15 = d13 / d14;
        double d16 = i10;
        Double.isNaN(d16);
        double d17 = i11;
        if (d16 * d15 <= d17) {
            return i10;
        }
        Double.isNaN(d17);
        return (int) (d17 / d15);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap getScaledImageFromResource(android.content.Context r2, int r3, int r4, int r5, float r6, float r7) {
        /*
        L0:
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r0 = getImageFromResource(r2, r3, r4, r5)
            if (r0 == 0) goto Lb
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto Lb
            goto L21
        Lb:
            int r4 = r4 / 2
            int r5 = r5 / 2
            if (r0 == 0) goto L21
            java.lang.Object r1 = r0.second
            boolean r1 = r1 instanceof java.lang.OutOfMemoryError
            if (r1 == 0) goto L21
            float r1 = (float) r4
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L21
            float r1 = (float) r5
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L0
        L21:
            if (r0 != 0) goto L25
            r2 = 0
            return r2
        L25:
            java.lang.Object r2 = r0.first
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bingoogolapple.bgabanner.BGABannerUtil.getScaledImageFromResource(android.content.Context, int, int, int, float, float):android.graphics.Bitmap");
    }

    public static boolean isCollectionEmpty(Collection collection, Collection... collectionArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        for (Collection collection2 : collectionArr) {
            if (collection2 == null || collection2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCollectionNotEmpty(Collection collection, Collection... collectionArr) {
        return !isCollectionEmpty(collection, collectionArr);
    }

    public static boolean isIndexNotOutOfBounds(int i10, Collection collection) {
        return isCollectionNotEmpty(collection, new Collection[0]) && i10 < collection.size();
    }

    public static void resetPageTransformer(List<? extends View> list) {
        if (list == null) {
            return;
        }
        for (View view : list) {
            view.setVisibility(0);
            c1.n0(view, 1.0f);
            c1.A0(view, view.getMeasuredWidth() * 0.5f);
            c1.B0(view, view.getMeasuredHeight() * 0.5f);
            c1.K0(view, 0.0f);
            c1.L0(view, 0.0f);
            c1.G0(view, 1.0f);
            c1.H0(view, 1.0f);
            c1.E0(view, 0.0f);
            c1.F0(view, 0.0f);
            c1.D0(view, 0.0f);
        }
    }

    public static int sp2px(Context context, float f10) {
        return (int) TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics());
    }
}
