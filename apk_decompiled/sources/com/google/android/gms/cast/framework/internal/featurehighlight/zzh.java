package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b0.i;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.internal.cast.zzcr;
import com.google.android.gms.internal.cast.zzda;

/* loaded from: classes.dex */
public final class zzh extends ViewGroup {
    private final int[] zza;
    private final Rect zzb;
    private final Rect zzc;
    private final OuterHighlightDrawable zzd;
    private final InnerZoneDrawable zze;
    private View zzf;
    private Animator zzg;
    private final zzi zzh;
    private final i zzi;
    private i zzj;
    private zzg zzk;
    private boolean zzl;
    private HelpTextView zzm;

    public zzh(Context context) {
        super(context);
        this.zza = new int[2];
        this.zzb = new Rect();
        this.zzc = new Rect();
        setId(R.id.cast_featurehighlight_view);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(context);
        this.zze = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(context);
        this.zzd = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.zzh = new zzi(this);
        i iVar = new i(context, new zza(this));
        this.zzi = iVar;
        iVar.b(false);
        setVisibility(8);
    }

    public static /* synthetic */ Animator zzb(zzh zzhVar) {
        InnerZoneDrawable innerZoneDrawable = zzhVar.zze;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.0f, 1.1f).setDuration(500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.1f, 1.0f).setDuration(500L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, PropertyValuesHolder.ofFloat("pulseScale", 1.1f, 2.0f), PropertyValuesHolder.ofFloat("pulseAlpha", 1.0f, 0.0f)).setDuration(500L);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzda.zzb());
        animatorSet.setStartDelay(500L);
        zzcr.zzd(animatorSet, -1, null);
        return animatorSet;
    }

    private final void zzq(Animator animator) {
        Animator animator2 = this.zzg;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.zzg = animator;
        animator.start();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.save();
        this.zzd.draw(canvas);
        this.zze.draw(canvas);
        View view = this.zzf;
        if (view == null) {
            throw new IllegalStateException("Neither target view nor drawable was set");
        }
        if (view.getParent() != null) {
            Bitmap createBitmap = Bitmap.createBitmap(this.zzf.getWidth(), this.zzf.getHeight(), Bitmap.Config.ARGB_8888);
            this.zzf.draw(new Canvas(createBitmap));
            int zzc = this.zzd.zzc();
            int red = Color.red(zzc);
            int green = Color.green(zzc);
            int blue = Color.blue(zzc);
            for (int i10 = 0; i10 < createBitmap.getHeight(); i10++) {
                for (int i11 = 0; i11 < createBitmap.getWidth(); i11++) {
                    int pixel = createBitmap.getPixel(i11, i10);
                    if (Color.alpha(pixel) != 0) {
                        createBitmap.setPixel(i11, i10, Color.argb(Color.alpha(pixel), red, green, blue));
                    }
                }
            }
            Rect rect = this.zzb;
            canvas.drawBitmap(createBitmap, rect.left, rect.top, (Paint) null);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.zzf;
        if (view == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        if (view.getParent() != null) {
            int[] iArr = this.zza;
            View view2 = this.zzf;
            getLocationInWindow(iArr);
            int i14 = iArr[0];
            int i15 = iArr[1];
            view2.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i14;
            iArr[1] = iArr[1] - i15;
        }
        Rect rect = this.zzb;
        int[] iArr2 = this.zza;
        int i16 = iArr2[0];
        rect.set(i16, iArr2[1], this.zzf.getWidth() + i16, this.zza[1] + this.zzf.getHeight());
        this.zzc.set(i10, i11, i12, i13);
        this.zzd.setBounds(this.zzc);
        this.zze.setBounds(this.zzc);
        this.zzh.zza(this.zzb, this.zzc);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSize(View.MeasureSpec.getSize(i10), i10), View.resolveSize(View.MeasureSpec.getSize(i11), i11));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.zzl = this.zzb.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.zzl) {
            i iVar = this.zzj;
            if (iVar != null) {
                iVar.a(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.zzf.getParent() != null) {
                this.zzf.onTouchEvent(motionEvent);
            }
        } else {
            this.zzi.a(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.zzd || drawable == this.zze || drawable == null;
    }

    public final View zzc() {
        return this.zzm.asView();
    }

    public final InnerZoneDrawable zze() {
        return this.zze;
    }

    public final OuterHighlightDrawable zzg() {
        return this.zzd;
    }

    public final void zzi(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", 0.0f).setDuration(200L);
        duration.setInterpolator(zzda.zza());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zzd, PropertyValuesHolder.ofFloat("scale", 1.125f), PropertyValuesHolder.ofInt("alpha", 0));
        ofPropertyValuesHolder.setInterpolator(zzda.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200L);
        Animator zza = this.zze.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, zza);
        animatorSet.addListener(new zze(this, runnable));
        zzq(animatorSet);
    }

    public final void zzj(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", 0.0f).setDuration(200L);
        duration.setInterpolator(zzda.zza());
        float exactCenterX = this.zzb.exactCenterX();
        float zza = this.zzd.zza();
        float exactCenterY = this.zzb.exactCenterY();
        float zzb = this.zzd.zzb();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zzd, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofFloat("translationX", 0.0f, exactCenterX - zza), PropertyValuesHolder.ofFloat("translationY", 0.0f, exactCenterY - zzb), PropertyValuesHolder.ofInt("alpha", 0));
        ofPropertyValuesHolder.setInterpolator(zzda.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200L);
        Animator zza2 = this.zze.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, zza2);
        animatorSet.addListener(new zzf(this, runnable));
        zzq(animatorSet);
    }

    public final void zzk(View view, View view2, boolean z10, zzg zzgVar) {
        view.getClass();
        this.zzf = view;
        this.zzk = zzgVar;
        i iVar = new i(getContext(), new zzb(this, view, true, zzgVar));
        this.zzj = iVar;
        iVar.b(false);
        setVisibility(4);
    }

    public final void zzl(int i10) {
        this.zzd.zze(i10);
    }

    public final void zzm() {
        if (this.zzf == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", 0.0f, 1.0f).setDuration(350L);
        duration.setInterpolator(zzda.zzc());
        Animator zzd = this.zzd.zzd(this.zzb.exactCenterX() - this.zzd.zza(), this.zzb.exactCenterY() - this.zzd.zzb());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zze, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofInt("alpha", 0, 255));
        ofPropertyValuesHolder.setInterpolator(zzda.zzc());
        Animator duration2 = ofPropertyValuesHolder.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, zzd, duration2);
        animatorSet.addListener(new zzd(this));
        zzq(animatorSet);
    }

    public final void zzn(Runnable runnable) {
        addOnLayoutChangeListener(new zzc(this, null));
    }

    public final void zzp(HelpTextView helpTextView) {
        helpTextView.getClass();
        this.zzm = helpTextView;
        addView(helpTextView.asView(), 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
