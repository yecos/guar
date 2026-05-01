package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.R;

/* loaded from: classes.dex */
public final class zzad extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    private Activity zzb;
    private int zzc;
    private boolean zzd;
    private IntroductoryOverlay.OnOverlayDismissedListener zze;
    private final zzac zzf;

    public zzad(IntroductoryOverlay.Builder builder, AttributeSet attributeSet, int i10) {
        super(builder.zzc(), null, i10);
        this.zzb = builder.zzc();
        this.zza = builder.zzh();
        this.zze = builder.zze();
        TypedArray obtainStyledAttributes = this.zzb.getTheme().obtainStyledAttributes(null, R.styleable.CastIntroOverlay, i10, R.style.CastIntroOverlay);
        if (builder.zzd() != null) {
            Rect rect = new Rect();
            builder.zzd().getGlobalVisibleRect(rect);
            zzac zzacVar = new zzac(null);
            this.zzf = zzacVar;
            zzacVar.zza = rect.centerX();
            zzacVar.zzb = rect.centerY();
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAlpha(0);
            paint.setXfermode(porterDuffXfermode);
            paint.setAntiAlias(true);
            zzacVar.zzc = paint;
            float zza = builder.zza();
            zzacVar.zzd = zza;
            if (zza == 0.0f) {
                zzacVar.zzd = obtainStyledAttributes.getDimension(R.styleable.CastIntroOverlay_castFocusRadius, 0.0f);
            }
        } else {
            this.zzf = null;
        }
        LayoutInflater.from(this.zzb).inflate(R.layout.cast_intro_overlay, this);
        int zzb = builder.zzb();
        this.zzc = zzb;
        if (zzb == 0) {
            this.zzc = obtainStyledAttributes.getColor(R.styleable.CastIntroOverlay_castBackgroundColor, Color.argb(0, 0, 0, 0));
        }
        TextView textView = (TextView) findViewById(R.id.textTitle);
        if (!TextUtils.isEmpty(builder.zzg())) {
            textView.setText(builder.zzg());
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastIntroOverlay_castTitleTextAppearance, 0);
            if (resourceId != 0) {
                textView.setTextAppearance(this.zzb, resourceId);
            }
        }
        String zzf = builder.zzf();
        zzf = TextUtils.isEmpty(zzf) ? obtainStyledAttributes.getString(R.styleable.CastIntroOverlay_castButtonText) : zzf;
        int color = obtainStyledAttributes.getColor(R.styleable.CastIntroOverlay_castButtonBackgroundColor, Color.argb(0, 0, 0, 0));
        Button button = (Button) findViewById(R.id.button);
        button.setText(zzf);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CastIntroOverlay_castButtonTextAppearance, 0);
        if (resourceId2 != 0) {
            button.setTextAppearance(this.zzb, resourceId2);
        }
        button.setOnClickListener(new zzaa(this));
        obtainStyledAttributes.recycle();
        setFitsSystemWindows(true);
    }

    public static /* bridge */ /* synthetic */ void zza(zzad zzadVar) {
        com.google.android.gms.cast.framework.zzas.zza(zzadVar.zzb);
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener = zzadVar.zze;
        if (onOverlayDismissedListener != null) {
            onOverlayDismissedListener.onOverlayDismissed();
            zzadVar.zze = null;
        }
        Activity activity = zzadVar.zzb;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(zzadVar);
            zzadVar.zzb = null;
        }
        zzadVar.zze = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        canvas2.drawColor(this.zzc);
        zzac zzacVar = this.zzf;
        if (zzacVar != null) {
            canvas2.drawCircle(zzacVar.zza, zzacVar.zzb, zzacVar.zzd, zzacVar.zzc);
        }
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        createBitmap.recycle();
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void remove() {
        Activity activity = this.zzb;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(this);
            this.zzb = null;
        }
        this.zze = null;
    }

    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void show() {
        Activity activity = this.zzb;
        if (activity == null || zzy.zzf(activity)) {
            return;
        }
        if (this.zza && com.google.android.gms.cast.framework.zzas.zzb(this.zzb)) {
            this.zzb = null;
            this.zze = null;
        } else {
            if (this.zzd) {
                return;
            }
            this.zzd = true;
            ((ViewGroup) this.zzb.getWindow().getDecorView()).addView(this);
        }
    }
}
