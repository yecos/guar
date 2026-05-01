package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.os.Build;
import android.util.Property;

/* loaded from: classes.dex */
public abstract class g {
    public static ObjectAnimator a(Object obj, Property property, Path path) {
        ObjectAnimator ofObject;
        if (Build.VERSION.SDK_INT < 21) {
            return ObjectAnimator.ofFloat(obj, new i(property, path), 0.0f, 1.0f);
        }
        ofObject = ObjectAnimator.ofObject(obj, (Property<Object, V>) property, (TypeConverter) null, path);
        return ofObject;
    }
}
