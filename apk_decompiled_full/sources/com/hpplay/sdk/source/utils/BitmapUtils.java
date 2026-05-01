package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.hpplay.common.log.LeLog;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class BitmapUtils {
    public static final String TAG = "BitmapUtils";

    public static Bitmap getBitmapById(Context context, Rect rect, int i10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
        try {
            InputStream openRawResource = context.getResources().openRawResource(i10);
            bitmap = BitmapFactory.decodeStream(openRawResource, rect, options);
            rect.left = options.outWidth / 2;
            rect.top = options.outHeight / 2;
            openRawResource.close();
            return bitmap;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return bitmap;
        }
    }

    public static Bitmap getBitmapByPath(Context context, Rect rect, String str) {
        return str.contains("file:///android_asset/") ? getBitmapFromAssets(context, rect, str.substring(22)) : getBitmapFromAbsolutePath(context, rect, str);
    }

    public static Bitmap getBitmapFromAbsolutePath(Context context, Rect rect, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            bitmap = BitmapFactory.decodeStream(fileInputStream, rect, options);
            rect.left = options.outWidth / 2;
            rect.top = options.outHeight / 2;
            fileInputStream.close();
            return bitmap;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return bitmap;
        }
    }

    public static Bitmap getBitmapFromAssets(Context context, Rect rect, String str) {
        AssetManager assets = context.getAssets();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
        try {
            InputStream open = assets.open(str);
            bitmap = BitmapFactory.decodeStream(open, rect, options);
            rect.left = options.outWidth / 2;
            rect.top = options.outHeight / 2;
            open.close();
            return bitmap;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return bitmap;
        }
    }

    public static Bitmap getNullBitmap(int i10, int i11) {
        return Bitmap.createBitmap(i10, i11, Bitmap.Config.RGB_565);
    }
}
