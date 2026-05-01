package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* loaded from: classes.dex */
public abstract class n {
    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList a(ImageView imageView) {
        ColorStateList imageTintList;
        if (Build.VERSION.SDK_INT >= 21) {
            imageTintList = imageView.getImageTintList();
            return imageTintList;
        }
        if (imageView instanceof h0) {
            return ((h0) imageView).getSupportImageTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode b(ImageView imageView) {
        PorterDuff.Mode imageTintMode;
        if (Build.VERSION.SDK_INT >= 21) {
            imageTintMode = imageView.getImageTintMode();
            return imageTintMode;
        }
        if (imageView instanceof h0) {
            return ((h0) imageView).getSupportImageTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        ColorStateList imageTintList;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21) {
            if (imageView instanceof h0) {
                ((h0) imageView).setSupportImageTintList(colorStateList);
                return;
            }
            return;
        }
        imageView.setImageTintList(colorStateList);
        if (i10 != 21 || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        imageTintList = imageView.getImageTintList();
        if (imageTintList != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        ColorStateList imageTintList;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21) {
            if (imageView instanceof h0) {
                ((h0) imageView).setSupportImageTintMode(mode);
                return;
            }
            return;
        }
        imageView.setImageTintMode(mode);
        if (i10 != 21 || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        imageTintList = imageView.getImageTintList();
        if (imageTintList != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }
}
