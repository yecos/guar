package com.titan.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
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
import java.io.FileInputStream;
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
                */
                public final void run() {
                    ThumbnailCallback thumbnailCallback;
                    String str2;
                    BitmapRegionDecoder bitmapRegionDecoder;
                    BitmapRegionDecoder bitmapRegionDecoder2;
                    BitmapRegionDecoder bitmapRegionDecoder3;
                    ThumbnailCallback thumbnailCallback2;
                    InputStream inputStream;
                    BitmapRegionDecoder bitmapRegionDecoder4;
                    InputStream inputStream2;
                    try {
                        PreviewUtil previewUtil = PreviewUtil.INSTANCE;
                        str2 = PreviewUtil.mCombineUrl;
                        if (!i.b(str2, str)) {
                            inputStream = PreviewUtil.mCombineIns;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            bitmapRegionDecoder4 = PreviewUtil.mDecoder;
                            if (bitmapRegionDecoder4 != null) {
                                bitmapRegionDecoder4.recycle();
                            }
                            PreviewUtil.mCombineIns = new FileInputStream(file);
                            inputStream2 = PreviewUtil.mCombineIns;
                            PreviewUtil.mDecoder = BitmapRegionDecoder.newInstance(inputStream2, false);
                            PreviewUtil.mCombineUrl = str;
                        }
                        bitmapRegionDecoder = PreviewUtil.mDecoder;
                        int width = bitmapRegionDecoder != null ? bitmapRegionDecoder.getWidth() : 0;
                        bitmapRegionDecoder2 = PreviewUtil.mDecoder;
                        int height = bitmapRegionDecoder2 != null ? bitmapRegionDecoder2.getHeight() : 0;
                        Rect rect = new Rect();
                        int intValue = ((Number) kVar.a()).intValue();
                        int intValue2 = ((Number) kVar.b()).intValue();
                        ThumbnailUtil thumbnailUtil = ThumbnailUtil.INSTANCE;
                        int mHorizontalCount = width / thumbnailUtil.getMHorizontalCount();
                        int mVerticalCount = height / thumbnailUtil.getMVerticalCount();
                        rect.set(intValue * mHorizontalCount, intValue2 * mVerticalCount, (intValue + 1) * mHorizontalCount, (intValue2 + 1) * mVerticalCount);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = false;
                        bitmapRegionDecoder3 = PreviewUtil.mDecoder;
                        Bitmap decodeRegion = bitmapRegionDecoder3 != null ? bitmapRegionDecoder3.decodeRegion(rect, options) : null;
                        if (decodeRegion == null || thumbnailCallback2 == null) {
                            return;
                        }
                        thumbnailCallback2.onBitmapPrepared(true, decodeRegion);
                    } catch (Exception e10) {
                        PreviewUtil previewUtil2 = PreviewUtil.INSTANCE;
                        thumbnailCallback = PreviewUtil.mThumbnailCallback;
                        if (thumbnailCallback != null) {
                            thumbnailCallback.onBitmapPrepared(false, null);
                        }
                        e10.printStackTrace();
                    }
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
