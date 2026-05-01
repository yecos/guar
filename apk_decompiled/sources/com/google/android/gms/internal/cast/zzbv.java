package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* loaded from: classes.dex */
public final class zzbv extends zzbp {
    private final RelativeLayout zza;
    private final TextView zzb;
    private final CastSeekBar zzc;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzd;

    public zzbv(RelativeLayout relativeLayout, CastSeekBar castSeekBar, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tooltip);
        this.zzb = textView;
        this.zzc = castSeekBar;
        this.zzd = zzaVar;
        TypedArray obtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarTooltipBackgroundColor, 0);
        obtainStyledAttributes.recycle();
        textView.getBackground().setColorFilter(textView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        super.onSessionEnded();
        zzd();
    }

    @Override // com.google.android.gms.internal.cast.zzbp
    public final void zza(boolean z10) {
        super.zza(z10);
        zzd();
    }

    @Override // com.google.android.gms.internal.cast.zzbp
    public final void zzb(long j10) {
        zzd();
    }

    public final void zzd() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || zzc()) {
            this.zza.setVisibility(8);
            return;
        }
        this.zza.setVisibility(0);
        TextView textView = this.zzb;
        com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar = this.zzd;
        textView.setText(zzaVar.zzl(this.zzc.getProgress() + zzaVar.zze()));
        int measuredWidth = (this.zzc.getMeasuredWidth() - this.zzc.getPaddingLeft()) - this.zzc.getPaddingRight();
        this.zzb.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth2 = this.zzb.getMeasuredWidth();
        double progress = this.zzc.getProgress();
        double maxProgress = this.zzc.getMaxProgress();
        Double.isNaN(progress);
        Double.isNaN(maxProgress);
        double d10 = progress / maxProgress;
        double d11 = measuredWidth;
        Double.isNaN(d11);
        int min = Math.min(Math.max(0, ((int) (d10 * d11)) - (measuredWidth2 / 2)), measuredWidth - measuredWidth2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zzb.getLayoutParams();
        layoutParams.leftMargin = min;
        this.zzb.setLayoutParams(layoutParams);
    }
}
