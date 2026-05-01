package s;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a0 extends y {

    /* renamed from: h, reason: collision with root package name */
    public static Method f18609h;

    public a0(Drawable drawable) {
        super(drawable);
        g();
    }

    @Override // s.y
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f18624f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || androidx.appcompat.widget.o.a(drawable);
    }

    public final void g() {
        if (f18609h == null) {
            try {
                f18609h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        Rect dirtyBounds;
        dirtyBounds = this.f18624f.getDirtyBounds();
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f18624f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f18624f;
        if (drawable != null && (method = f18609h) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        this.f18624f.setHotspot(f10, f11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        this.f18624f.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // s.y, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // s.y, android.graphics.drawable.Drawable, s.w
    public void setTint(int i10) {
        if (c()) {
            super.setTint(i10);
        } else {
            this.f18624f.setTint(i10);
        }
    }

    @Override // s.y, android.graphics.drawable.Drawable, s.w
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f18624f.setTintList(colorStateList);
        }
    }

    @Override // s.y, android.graphics.drawable.Drawable, s.w
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f18624f.setTintMode(mode);
        }
    }

    public a0(b0 b0Var, Resources resources) {
        super(b0Var, resources);
        g();
    }
}
