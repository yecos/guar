package androidx.mediarouter.app;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatSeekBar;

/* loaded from: classes.dex */
class MediaRouteVolumeSlider extends AppCompatSeekBar {

    /* renamed from: a, reason: collision with root package name */
    public final float f2726a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2727b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f2728c;

    /* renamed from: d, reason: collision with root package name */
    public int f2729d;

    /* renamed from: e, reason: collision with root package name */
    public int f2730e;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarStyle);
    }

    public void a(int i10) {
        b(i10, i10);
    }

    public void b(int i10, int i11) {
        if (this.f2729d != i10) {
            if (Color.alpha(i10) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i10));
            }
            this.f2729d = i10;
        }
        if (this.f2730e != i11) {
            if (Color.alpha(i11) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i11));
            }
            this.f2730e = i11;
        }
    }

    public void c(boolean z10) {
        if (this.f2727b == z10) {
            return;
        }
        this.f2727b = z10;
        super.setThumb(z10 ? null : this.f2728c);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i10 = isEnabled() ? 255 : (int) (this.f2726a * 255.0f);
        this.f2728c.setColorFilter(this.f2729d, PorterDuff.Mode.SRC_IN);
        this.f2728c.setAlpha(i10);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
            layerDrawable.findDrawableByLayerId(R.id.background).setColorFilter(this.f2730e, PorterDuff.Mode.SRC_IN);
            progressDrawable = findDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.f2729d, PorterDuff.Mode.SRC_IN);
        progressDrawable.setAlpha(i10);
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        this.f2728c = drawable;
        if (this.f2727b) {
            drawable = null;
        }
        super.setThumb(drawable);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2726a = i.h(context);
    }
}
