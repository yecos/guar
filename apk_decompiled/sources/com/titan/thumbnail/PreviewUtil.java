package com.titan.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import h9.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import t9.i;

/* loaded from: classes3.dex */
public final class PreviewUtil {
    private static InputStream mCombineIns;
    private static BitmapRegionDecoder mDecoder;
    private static Handler mHandle;
    private static HandlerThread mHandlerThread;
    private static k mSnapshotPosition;
    private static ThumbnailCallback mThumbnailCallback;
    public static final PreviewUtil INSTANCE = new PreviewUtil();
    private static final String TAG = PreviewUtil.class.getSimpleName();
    private static String mCombineUrl = "";

    private PreviewUtil() {
    }

    private final InputStream bitmap2InputStream(Bitmap bitmap, int i10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, i10, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPartialImg(final File file, final String str, final k kVar) {
        Handler handler = mHandle;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = mHandle;
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: com.titan.thumbnail.PreviewUtil$loadPartialImg$1
                /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
                
                    r2 = com.titan.thumbnail.PreviewUtil.mThumbnailCallback;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void run() {
                    /*
                        r11 = this;
                        r0 = 0
                        r1 = 0
                        com.titan.thumbnail.PreviewUtil r2 = com.titan.thumbnail.PreviewUtil.INSTANCE     // Catch: java.lang.Exception -> Lab
                        java.lang.String r3 = com.titan.thumbnail.PreviewUtil.access$getMCombineUrl$p(r2)     // Catch: java.lang.Exception -> Lab
                        java.lang.String r4 = r1     // Catch: java.lang.Exception -> Lab
                        boolean r3 = t9.i.b(r3, r4)     // Catch: java.lang.Exception -> Lab
                        r4 = 1
                        r3 = r3 ^ r4
                        if (r3 == 0) goto L3e
                        java.io.InputStream r3 = com.titan.thumbnail.PreviewUtil.access$getMCombineIns$p(r2)     // Catch: java.lang.Exception -> Lab
                        if (r3 == 0) goto L1b
                        r3.close()     // Catch: java.lang.Exception -> Lab
                    L1b:
                        android.graphics.BitmapRegionDecoder r3 = com.titan.thumbnail.PreviewUtil.access$getMDecoder$p(r2)     // Catch: java.lang.Exception -> Lab
                        if (r3 == 0) goto L24
                        r3.recycle()     // Catch: java.lang.Exception -> Lab
                    L24:
                        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Exception -> Lab
                        java.io.File r5 = r2     // Catch: java.lang.Exception -> Lab
                        r3.<init>(r5)     // Catch: java.lang.Exception -> Lab
                        com.titan.thumbnail.PreviewUtil.access$setMCombineIns$p(r2, r3)     // Catch: java.lang.Exception -> Lab
                        java.io.InputStream r3 = com.titan.thumbnail.PreviewUtil.access$getMCombineIns$p(r2)     // Catch: java.lang.Exception -> Lab
                        android.graphics.BitmapRegionDecoder r3 = android.graphics.BitmapRegionDecoder.newInstance(r3, r1)     // Catch: java.lang.Exception -> Lab
                        com.titan.thumbnail.PreviewUtil.access$setMDecoder$p(r2, r3)     // Catch: java.lang.Exception -> Lab
                        java.lang.String r3 = r1     // Catch: java.lang.Exception -> Lab
                        com.titan.thumbnail.PreviewUtil.access$setMCombineUrl$p(r2, r3)     // Catch: java.lang.Exception -> Lab
                    L3e:
                        android.graphics.BitmapRegionDecoder r3 = com.titan.thumbnail.PreviewUtil.access$getMDecoder$p(r2)     // Catch: java.lang.Exception -> Lab
                        if (r3 == 0) goto L49
                        int r3 = r3.getWidth()     // Catch: java.lang.Exception -> Lab
                        goto L4a
                    L49:
                        r3 = 0
                    L4a:
                        android.graphics.BitmapRegionDecoder r5 = com.titan.thumbnail.PreviewUtil.access$getMDecoder$p(r2)     // Catch: java.lang.Exception -> Lab
                        if (r5 == 0) goto L55
                        int r5 = r5.getHeight()     // Catch: java.lang.Exception -> Lab
                        goto L56
                    L55:
                        r5 = 0
                    L56:
                        android.graphics.Rect r6 = new android.graphics.Rect     // Catch: java.lang.Exception -> Lab
                        r6.<init>()     // Catch: java.lang.Exception -> Lab
                        h9.k r7 = r3     // Catch: java.lang.Exception -> Lab
                        java.lang.Object r7 = r7.a()     // Catch: java.lang.Exception -> Lab
                        java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Exception -> Lab
                        int r7 = r7.intValue()     // Catch: java.lang.Exception -> Lab
                        h9.k r8 = r3     // Catch: java.lang.Exception -> Lab
                        java.lang.Object r8 = r8.b()     // Catch: java.lang.Exception -> Lab
                        java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Exception -> Lab
                        int r8 = r8.intValue()     // Catch: java.lang.Exception -> Lab
                        com.titan.thumbnail.ThumbnailUtil r9 = com.titan.thumbnail.ThumbnailUtil.INSTANCE     // Catch: java.lang.Exception -> Lab
                        int r10 = r9.getMHorizontalCount()     // Catch: java.lang.Exception -> Lab
                        int r3 = r3 / r10
                        int r9 = r9.getMVerticalCount()     // Catch: java.lang.Exception -> Lab
                        int r5 = r5 / r9
                        int r9 = r7 * r3
                        int r10 = r8 * r5
                        int r7 = r7 + r4
                        int r7 = r7 * r3
                        int r8 = r8 + r4
                        int r8 = r8 * r5
                        r6.set(r9, r10, r7, r8)     // Catch: java.lang.Exception -> Lab
                        android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> Lab
                        r3.<init>()     // Catch: java.lang.Exception -> Lab
                        r3.inJustDecodeBounds = r1     // Catch: java.lang.Exception -> Lab
                        android.graphics.BitmapRegionDecoder r5 = com.titan.thumbnail.PreviewUtil.access$getMDecoder$p(r2)     // Catch: java.lang.Exception -> Lab
                        if (r5 == 0) goto L9e
                        android.graphics.Bitmap r3 = r5.decodeRegion(r6, r3)     // Catch: java.lang.Exception -> Lab
                        goto L9f
                    L9e:
                        r3 = r0
                    L9f:
                        if (r3 == 0) goto Lba
                        com.titan.thumbnail.ThumbnailCallback r2 = com.titan.thumbnail.PreviewUtil.access$getMThumbnailCallback$p(r2)     // Catch: java.lang.Exception -> Lab
                        if (r2 == 0) goto Lba
                        r2.onBitmapPrepared(r4, r3)     // Catch: java.lang.Exception -> Lab
                        goto Lba
                    Lab:
                        r2 = move-exception
                        com.titan.thumbnail.PreviewUtil r3 = com.titan.thumbnail.PreviewUtil.INSTANCE
                        com.titan.thumbnail.ThumbnailCallback r3 = com.titan.thumbnail.PreviewUtil.access$getMThumbnailCallback$p(r3)
                        if (r3 == 0) goto Lb7
                        r3.onBitmapPrepared(r1, r0)
                    Lb7:
                        r2.printStackTrace()
                    Lba:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.titan.thumbnail.PreviewUtil$loadPartialImg$1.run():void");
                }
            });
        }
    }

    public final void loadPreview(final ImageView imageView, long j10) {
        i.h(imageView, "imageView");
        if (mHandle == null) {
            HandlerThread handlerThread = new HandlerThread("PreviewUtil", 10);
            mHandlerThread = handlerThread;
            handlerThread.start();
            HandlerThread handlerThread2 = mHandlerThread;
            mHandle = new Handler(handlerThread2 != null ? handlerThread2.getLooper() : null);
        }
        ThumbnailUtil thumbnailUtil = ThumbnailUtil.INSTANCE;
        final String combineUrl = thumbnailUtil.getCombineUrl(j10);
        mSnapshotPosition = thumbnailUtil.getSnapshotPosition(j10);
        imageView.setTag(combineUrl);
        Glide.with(imageView).downloadOnly().load(combineUrl).into((RequestBuilder<File>) new ThumbTarget(imageView, combineUrl) { // from class: com.titan.thumbnail.PreviewUtil$loadPreview$1
            @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable drawable) {
                ThumbnailCallback thumbnailCallback;
                PreviewUtil previewUtil = PreviewUtil.INSTANCE;
                thumbnailCallback = PreviewUtil.mThumbnailCallback;
                if (thumbnailCallback != null) {
                    thumbnailCallback.onBitmapPrepared(false, null);
                }
            }

            @Override // com.titan.thumbnail.ThumbTarget
            public void onResourceReadyUrl(File file, String str) {
                k kVar;
                k kVar2;
                i.h(file, "resource");
                i.h(str, "url");
                if (i.b(imageView.getTag(), str)) {
                    PreviewUtil previewUtil = PreviewUtil.INSTANCE;
                    kVar = PreviewUtil.mSnapshotPosition;
                    if (kVar != null) {
                        String str2 = combineUrl;
                        kVar2 = PreviewUtil.mSnapshotPosition;
                        if (kVar2 == null) {
                            i.q();
                        }
                        previewUtil.loadPartialImg(file, str2, kVar2);
                    }
                }
            }
        });
    }

    public final void recycle() {
        mCombineUrl = "";
        InputStream inputStream = mCombineIns;
        if (inputStream != null) {
            inputStream.close();
        }
        BitmapRegionDecoder bitmapRegionDecoder = mDecoder;
        if (bitmapRegionDecoder != null) {
            bitmapRegionDecoder.recycle();
        }
        Handler handler = mHandle;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        mHandle = null;
        mHandlerThread = null;
    }

    public final void setPreviewCallback(ThumbnailCallback thumbnailCallback) {
        mThumbnailCallback = thumbnailCallback;
    }
}
