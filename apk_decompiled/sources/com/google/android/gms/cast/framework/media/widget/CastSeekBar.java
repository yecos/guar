package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CastSeekBar extends View {
    public zze zza;
    public zzc zzb;

    @RecentlyNullable
    public List<zzb> zzc;
    public zzd zzd;
    private boolean zze;
    private Integer zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;
    private final Paint zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private int[] zzq;
    private Point zzr;
    private Runnable zzs;

    public CastSeekBar(@RecentlyNonNull Context context) {
        this(context, null);
    }

    private final int zzf(int i10) {
        double d10 = i10;
        double measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        Double.isNaN(d10);
        Double.isNaN(measuredWidth);
        double d11 = d10 / measuredWidth;
        double d12 = this.zza.zzb;
        Double.isNaN(d12);
        return (int) (d11 * d12);
    }

    private final void zzg(Canvas canvas, int i10, int i11, int i12, int i13, int i14) {
        this.zzl.setColor(i14);
        float f10 = i12;
        float f11 = i13;
        float f12 = this.zzi;
        canvas.drawRect((i10 / f10) * f11, -f12, (i11 / f10) * f11, f12, this.zzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh(int i10) {
        zze zzeVar = this.zza;
        if (zzeVar.zzf) {
            this.zzf = Integer.valueOf(CastUtils.zza(i10, zzeVar.zzd, zzeVar.zze));
            zzd zzdVar = this.zzd;
            if (zzdVar != null) {
                zzdVar.zza(this, getProgress(), true);
            }
            Runnable runnable = this.zzs;
            if (runnable == null) {
                this.zzs = new Runnable() { // from class: com.google.android.gms.cast.framework.media.widget.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        CastSeekBar.this.sendAccessibilityEvent(4);
                    }
                };
            } else {
                removeCallbacks(runnable);
            }
            postDelayed(this.zzs, 200L);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi() {
        this.zze = true;
        zzd zzdVar = this.zzd;
        if (zzdVar != null) {
            zzdVar.zzb(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj() {
        this.zze = false;
        zzd zzdVar = this.zzd;
        if (zzdVar != null) {
            zzdVar.zzc(this);
        }
    }

    public int getMaxProgress() {
        return this.zza.zzb;
    }

    public int getProgress() {
        Integer num = this.zzf;
        return num != null ? num.intValue() : this.zza.zza;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Runnable runnable = this.zzs;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@RecentlyNonNull Canvas canvas) {
        int save = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        zzc zzcVar = this.zzb;
        if (zzcVar == null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = getMeasuredHeight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int progress = getProgress();
            int save2 = canvas.save();
            canvas.translate(0.0f, ((measuredHeight - paddingTop) - paddingBottom) / 2);
            zze zzeVar = this.zza;
            if (zzeVar.zzf) {
                int i10 = zzeVar.zzd;
                if (i10 > 0) {
                    zzg(canvas, 0, i10, zzeVar.zzb, measuredWidth, this.zzo);
                }
                zze zzeVar2 = this.zza;
                int i11 = zzeVar2.zzd;
                if (progress > i11) {
                    zzg(canvas, i11, progress, zzeVar2.zzb, measuredWidth, this.zzm);
                }
                zze zzeVar3 = this.zza;
                int i12 = zzeVar3.zze;
                if (i12 > progress) {
                    zzg(canvas, progress, i12, zzeVar3.zzb, measuredWidth, this.zzn);
                }
                zze zzeVar4 = this.zza;
                int i13 = zzeVar4.zzb;
                int i14 = zzeVar4.zze;
                if (i13 > i14) {
                    zzg(canvas, i14, i13, i13, measuredWidth, this.zzo);
                }
            } else {
                int max = Math.max(zzeVar.zzc, 0);
                if (max > 0) {
                    zzg(canvas, 0, max, this.zza.zzb, measuredWidth, this.zzo);
                }
                if (progress > max) {
                    zzg(canvas, max, progress, this.zza.zzb, measuredWidth, this.zzm);
                }
                int i15 = this.zza.zzb;
                if (i15 > progress) {
                    zzg(canvas, progress, i15, i15, measuredWidth, this.zzo);
                }
            }
            canvas.restoreToCount(save2);
            List<zzb> list = this.zzc;
            if (list != null && !list.isEmpty()) {
                this.zzl.setColor(this.zzp);
                int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight2 = getMeasuredHeight();
                int paddingTop2 = getPaddingTop();
                int paddingBottom2 = getPaddingBottom();
                int save3 = canvas.save();
                canvas.translate(0.0f, ((measuredHeight2 - paddingTop2) - paddingBottom2) / 2);
                for (zzb zzbVar : list) {
                    if (zzbVar != null) {
                        int min = Math.min(zzbVar.zza, this.zza.zzb);
                        int i16 = zzbVar.zzc ? zzbVar.zzb : 1;
                        float f10 = measuredWidth2;
                        float f11 = this.zza.zzb;
                        float f12 = (min * f10) / f11;
                        float f13 = ((min + i16) * f10) / f11;
                        float f14 = this.zzk;
                        if (f13 - f12 < f14) {
                            f13 = f12 + f14;
                        }
                        float f15 = f13 > f10 ? f10 : f13;
                        float f16 = f15 - f12 < f14 ? f15 - f14 : f12;
                        float f17 = this.zzi;
                        canvas.drawRect(f16, -f17, f15, f17, this.zzl);
                    }
                }
                canvas.restoreToCount(save3);
            }
            if (isEnabled() && this.zza.zzf) {
                this.zzl.setColor(this.zzm);
                int measuredWidth3 = getMeasuredWidth();
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int measuredHeight3 = getMeasuredHeight();
                int paddingTop3 = getPaddingTop();
                int paddingBottom3 = getPaddingBottom();
                int progress2 = getProgress();
                int i17 = this.zza.zzb;
                int save4 = canvas.save();
                Double.isNaN(progress2);
                Double.isNaN(i17);
                Double.isNaN((measuredWidth3 - paddingLeft) - paddingRight);
                canvas.drawCircle((int) ((r12 / r14) * r0), ((measuredHeight3 - paddingTop3) - paddingBottom3) / 2.0f, this.zzj, this.zzl);
                canvas.restoreToCount(save4);
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight4 = getMeasuredHeight();
            int paddingTop4 = getPaddingTop();
            int paddingBottom4 = getPaddingBottom();
            int save5 = canvas.save();
            canvas.translate(0.0f, ((measuredHeight4 - paddingTop4) - paddingBottom4) / 2);
            zzg(canvas, 0, zzcVar.zza, zzcVar.zzb, measuredWidth4, this.zzp);
            int i18 = zzcVar.zza;
            int i19 = zzcVar.zzb;
            zzg(canvas, i18, i19, i19, measuredWidth4, this.zzo);
            canvas.restoreToCount(save5);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSizeAndState((int) (this.zzg + getPaddingLeft() + getPaddingRight()), i10, 0), View.resolveSizeAndState((int) (this.zzh + getPaddingTop() + getPaddingBottom()), i11, 0));
    }

    @Override // android.view.View
    public boolean onTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        if (!isEnabled() || !this.zza.zzf) {
            return false;
        }
        if (this.zzr == null) {
            this.zzr = new Point();
        }
        if (this.zzq == null) {
            this.zzq = new int[2];
        }
        getLocationOnScreen(this.zzq);
        this.zzr.set((((int) motionEvent.getRawX()) - this.zzq[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.zzq[1]);
        int action = motionEvent.getAction();
        if (action == 0) {
            zzi();
            zzh(zzf(this.zzr.x));
            return true;
        }
        if (action == 1) {
            zzh(zzf(this.zzr.x));
            zzj();
            return true;
        }
        if (action == 2) {
            zzh(zzf(this.zzr.x));
            return true;
        }
        if (action != 3) {
            return false;
        }
        this.zze = false;
        this.zzf = null;
        zzd zzdVar = this.zzd;
        if (zzdVar != null) {
            zzdVar.zza(this, getProgress(), true);
            this.zzd.zzc(this);
        }
        postInvalidate();
        return true;
    }

    public final void zzd(@RecentlyNonNull List<zzb> list) {
        if (Objects.equal(this.zzc, list)) {
            return;
        }
        this.zzc = list == null ? null : new ArrayList(list);
        postInvalidate();
    }

    public final void zze(zze zzeVar) {
        if (this.zze) {
            return;
        }
        zze zzeVar2 = new zze();
        zzeVar2.zza = zzeVar.zza;
        zzeVar2.zzb = zzeVar.zzb;
        zzeVar2.zzc = zzeVar.zzc;
        zzeVar2.zzd = zzeVar.zzd;
        zzeVar2.zze = zzeVar.zze;
        zzeVar2.zzf = zzeVar.zzf;
        this.zza = zzeVar2;
        this.zzf = null;
        zzd zzdVar = this.zzd;
        if (zzdVar != null) {
            zzdVar.zza(this, getProgress(), false);
        }
        postInvalidate();
    }

    public CastSeekBar(@RecentlyNonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CastSeekBar(@RecentlyNonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.zzc = new ArrayList();
        setAccessibilityDelegate(new zzg(this, null));
        Paint paint = new Paint(1);
        this.zzl = paint;
        paint.setStyle(Paint.Style.FILL);
        this.zzg = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.zzh = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.zzi = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.zzj = context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.zzk = context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        zze zzeVar = new zze();
        this.zza = zzeVar;
        zzeVar.zzb = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.zzm = context.getResources().getColor(resourceId);
        this.zzn = context.getResources().getColor(resourceId2);
        this.zzo = context.getResources().getColor(resourceId3);
        this.zzp = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }
}
