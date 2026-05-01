package com.hpplay.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.hpplay.glide.load.engine.Resource;

/* loaded from: classes2.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T> {
    protected final T drawable;

    public DrawableResource(T t10) {
        if (t10 == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.drawable = t10;
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public final T get() {
        return (T) this.drawable.getConstantState().newDrawable();
    }
}
