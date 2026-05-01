package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class FixGifImageView extends androidx.appcompat.widget.q {
    public Map<Integer, View> _$_findViewCache;
    private FixGifStateDrawable fixDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixGifImageView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (isSelected()) {
            FixGifStateDrawable fixGifStateDrawable = this.fixDrawable;
            if (fixGifStateDrawable != null) {
                t9.i.d(fixGifStateDrawable);
                super.setImageDrawable(fixGifStateDrawable.getSelectDrawable());
                FixGifStateDrawable fixGifStateDrawable2 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable2);
                if (fixGifStateDrawable2.getNormalDrawable() instanceof GifDrawable) {
                    FixGifStateDrawable fixGifStateDrawable3 = this.fixDrawable;
                    t9.i.d(fixGifStateDrawable3);
                    Drawable normalDrawable = fixGifStateDrawable3.getNormalDrawable();
                    t9.i.e(normalDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                    ((GifDrawable) normalDrawable).stop();
                }
                FixGifStateDrawable fixGifStateDrawable4 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable4);
                if (fixGifStateDrawable4.getSelectDrawable() instanceof GifDrawable) {
                    FixGifStateDrawable fixGifStateDrawable5 = this.fixDrawable;
                    t9.i.d(fixGifStateDrawable5);
                    Drawable selectDrawable = fixGifStateDrawable5.getSelectDrawable();
                    t9.i.e(selectDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                    ((GifDrawable) selectDrawable).start();
                    return;
                }
                return;
            }
            return;
        }
        FixGifStateDrawable fixGifStateDrawable6 = this.fixDrawable;
        if (fixGifStateDrawable6 != null) {
            t9.i.d(fixGifStateDrawable6);
            super.setImageDrawable(fixGifStateDrawable6.getNormalDrawable());
            FixGifStateDrawable fixGifStateDrawable7 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable7);
            if (fixGifStateDrawable7.getNormalDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable8 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable8);
                Drawable normalDrawable2 = fixGifStateDrawable8.getNormalDrawable();
                t9.i.e(normalDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) normalDrawable2).start();
            }
            FixGifStateDrawable fixGifStateDrawable9 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable9);
            if (fixGifStateDrawable9.getSelectDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable10 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable10);
                Drawable selectDrawable2 = fixGifStateDrawable10.getSelectDrawable();
                t9.i.e(selectDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) selectDrawable2).stop();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FixGifStateDrawable fixGifStateDrawable = this.fixDrawable;
        if (fixGifStateDrawable != null) {
            t9.i.d(fixGifStateDrawable);
            if (fixGifStateDrawable.getNormalDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable2 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable2);
                Drawable normalDrawable = fixGifStateDrawable2.getNormalDrawable();
                t9.i.e(normalDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) normalDrawable).stop();
            }
            FixGifStateDrawable fixGifStateDrawable3 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable3);
            if (fixGifStateDrawable3.getSelectDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable4 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable4);
                Drawable selectDrawable = fixGifStateDrawable4.getSelectDrawable();
                t9.i.e(selectDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) selectDrawable).stop();
            }
        }
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (!(drawable instanceof FixGifStateDrawable)) {
            super.setImageDrawable(drawable);
            return;
        }
        FixGifStateDrawable fixGifStateDrawable = (FixGifStateDrawable) drawable;
        this.fixDrawable = fixGifStateDrawable;
        if (isSelected()) {
            super.setImageDrawable(fixGifStateDrawable.getSelectDrawable());
            FixGifStateDrawable fixGifStateDrawable2 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable2);
            if (fixGifStateDrawable2.getNormalDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable3 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable3);
                Drawable normalDrawable = fixGifStateDrawable3.getNormalDrawable();
                t9.i.e(normalDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) normalDrawable).stop();
            }
            FixGifStateDrawable fixGifStateDrawable4 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable4);
            if (fixGifStateDrawable4.getSelectDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable5 = this.fixDrawable;
                t9.i.d(fixGifStateDrawable5);
                Drawable selectDrawable = fixGifStateDrawable5.getSelectDrawable();
                t9.i.e(selectDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) selectDrawable).start();
                return;
            }
            return;
        }
        super.setImageDrawable(fixGifStateDrawable.getNormalDrawable());
        FixGifStateDrawable fixGifStateDrawable6 = this.fixDrawable;
        t9.i.d(fixGifStateDrawable6);
        if (fixGifStateDrawable6.getNormalDrawable() instanceof GifDrawable) {
            FixGifStateDrawable fixGifStateDrawable7 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable7);
            Drawable normalDrawable2 = fixGifStateDrawable7.getNormalDrawable();
            t9.i.e(normalDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
            ((GifDrawable) normalDrawable2).start();
        }
        FixGifStateDrawable fixGifStateDrawable8 = this.fixDrawable;
        t9.i.d(fixGifStateDrawable8);
        if (fixGifStateDrawable8.getSelectDrawable() instanceof GifDrawable) {
            FixGifStateDrawable fixGifStateDrawable9 = this.fixDrawable;
            t9.i.d(fixGifStateDrawable9);
            Drawable selectDrawable2 = fixGifStateDrawable9.getSelectDrawable();
            t9.i.e(selectDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
            ((GifDrawable) selectDrawable2).stop();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixGifImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixGifImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FixGifImageView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
