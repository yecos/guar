package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzju;

/* loaded from: classes.dex */
public class MiniControllerFragment extends Fragment implements ControlButtonsContainer {
    private static final Logger zza = new Logger("MiniControllerFragment");
    private boolean zzb;
    private int zzc;
    private int zzd;
    private TextView zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int[] zzj;
    private ImageView[] zzk = new ImageView[3];
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private UIMediaController zzy;

    private final void zza(UIMediaController uIMediaController, RelativeLayout relativeLayout, int i10, int i11) {
        ImageView imageView = (ImageView) relativeLayout.findViewById(i10);
        int i12 = this.zzj[i11];
        if (i12 == R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
            return;
        }
        if (i12 == R.id.cast_button_type_custom) {
            return;
        }
        if (i12 == R.id.cast_button_type_play_pause_toggle) {
            int i13 = this.zzm;
            int i14 = this.zzn;
            int i15 = this.zzo;
            if (this.zzl == 1) {
                i13 = this.zzp;
                i14 = this.zzq;
                i15 = this.zzr;
            }
            Drawable zzc = zzp.zzc(getContext(), this.zzi, i13);
            Drawable zzc2 = zzp.zzc(getContext(), this.zzi, i14);
            Drawable zzc3 = zzp.zzc(getContext(), this.zzi, i15);
            imageView.setImageDrawable(zzc2);
            ProgressBar progressBar = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(8, i10);
            layoutParams.addRule(6, i10);
            layoutParams.addRule(5, i10);
            layoutParams.addRule(7, i10);
            layoutParams.addRule(15);
            progressBar.setLayoutParams(layoutParams);
            progressBar.setVisibility(8);
            Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
            int i16 = this.zzh;
            if (i16 != 0 && indeterminateDrawable != null) {
                indeterminateDrawable.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
            }
            relativeLayout.addView(progressBar);
            uIMediaController.bindImageViewToPlayPauseToggle(imageView, zzc, zzc2, zzc3, progressBar, true);
            return;
        }
        if (i12 == R.id.cast_button_type_skip_previous) {
            imageView.setImageDrawable(zzp.zzc(getContext(), this.zzi, this.zzs));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_prev));
            uIMediaController.bindViewToSkipPrev(imageView, 0);
            return;
        }
        if (i12 == R.id.cast_button_type_skip_next) {
            imageView.setImageDrawable(zzp.zzc(getContext(), this.zzi, this.zzt));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_next));
            uIMediaController.bindViewToSkipNext(imageView, 0);
            return;
        }
        if (i12 == R.id.cast_button_type_rewind_30_seconds) {
            imageView.setImageDrawable(zzp.zzc(getContext(), this.zzi, this.zzu));
            imageView.setContentDescription(getResources().getString(R.string.cast_rewind_30));
            uIMediaController.bindViewToRewind(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
        } else if (i12 == R.id.cast_button_type_forward_30_seconds) {
            imageView.setImageDrawable(zzp.zzc(getContext(), this.zzi, this.zzv));
            imageView.setContentDescription(getResources().getString(R.string.cast_forward_30));
            uIMediaController.bindViewToForward(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
        } else if (i12 == R.id.cast_button_type_mute_toggle) {
            imageView.setImageDrawable(zzp.zzc(getContext(), this.zzi, this.zzw));
            uIMediaController.bindImageViewToMuteToggle(imageView);
        } else if (i12 == R.id.cast_button_type_closed_caption) {
            imageView.setImageDrawable(zzp.zzc(getContext(), this.zzi, this.zzx));
            uIMediaController.bindViewToClosedCaption(imageView);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    @RecentlyNonNull
    public final ImageView getButtonImageViewAt(int i10) {
        return this.zzk[i10];
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonSlotCount() {
        return 3;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonTypeAt(int i10) {
        return this.zzj[i10];
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    @RecentlyNullable
    public UIMediaController getUIMediaController() {
        return this.zzy;
    }

    @Override // androidx.fragment.app.Fragment
    @RecentlyNonNull
    public View onCreateView(@RecentlyNonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        UIMediaController uIMediaController = new UIMediaController(getActivity());
        this.zzy = uIMediaController;
        View inflate = layoutInflater.inflate(R.layout.cast_mini_controller, viewGroup);
        inflate.setVisibility(8);
        uIMediaController.bindViewVisibilityToMediaSession(inflate, 8);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.container_current);
        int i10 = this.zzf;
        if (i10 != 0) {
            relativeLayout.setBackgroundResource(i10);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon_view);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        if (this.zzc != 0) {
            textView.setTextAppearance(getActivity(), this.zzc);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.subtitle_view);
        this.zze = textView2;
        if (this.zzd != 0) {
            textView2.setTextAppearance(getActivity(), this.zzd);
        }
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progressBar);
        if (this.zzg != 0) {
            ((LayerDrawable) progressBar.getProgressDrawable()).setColorFilter(this.zzg, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController.bindTextViewToMetadataOfCurrentItem(textView, MediaMetadata.KEY_TITLE);
        uIMediaController.bindTextViewToSmartSubtitle(this.zze);
        uIMediaController.bindProgressBar(progressBar);
        uIMediaController.bindViewToLaunchExpandedController(relativeLayout);
        if (this.zzb) {
            uIMediaController.bindImageViewToImageOfCurrentItem(imageView, new ImageHints(2, getResources().getDimensionPixelSize(R.dimen.cast_mini_controller_icon_width), getResources().getDimensionPixelSize(R.dimen.cast_mini_controller_icon_height)), R.drawable.cast_album_art_placeholder);
        } else {
            imageView.setVisibility(8);
        }
        ImageView[] imageViewArr = this.zzk;
        int i11 = R.id.button_0;
        imageViewArr[0] = (ImageView) relativeLayout.findViewById(i11);
        ImageView[] imageViewArr2 = this.zzk;
        int i12 = R.id.button_1;
        imageViewArr2[1] = (ImageView) relativeLayout.findViewById(i12);
        ImageView[] imageViewArr3 = this.zzk;
        int i13 = R.id.button_2;
        imageViewArr3[2] = (ImageView) relativeLayout.findViewById(i13);
        zza(uIMediaController, relativeLayout, i11, 0);
        zza(uIMediaController, relativeLayout, i12, 1);
        zza(uIMediaController, relativeLayout, i13, 2);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        UIMediaController uIMediaController = this.zzy;
        if (uIMediaController != null) {
            uIMediaController.dispose();
            this.zzy = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        if (this.zzj == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CastMiniController, R.attr.castMiniControllerStyle, R.style.CastMiniController);
            this.zzb = obtainStyledAttributes.getBoolean(R.styleable.CastMiniController_castShowImageThumbnail, true);
            this.zzc = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castTitleTextAppearance, 0);
            this.zzd = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castSubtitleTextAppearance, 0);
            this.zzf = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castBackground, 0);
            int color = obtainStyledAttributes.getColor(R.styleable.CastMiniController_castProgressBarColor, 0);
            this.zzg = color;
            this.zzh = obtainStyledAttributes.getColor(R.styleable.CastMiniController_castMiniControllerLoadingIndicatorColor, color);
            this.zzi = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castButtonColor, 0);
            int i10 = R.styleable.CastMiniController_castPlayButtonDrawable;
            this.zzm = obtainStyledAttributes.getResourceId(i10, 0);
            int i11 = R.styleable.CastMiniController_castPauseButtonDrawable;
            this.zzn = obtainStyledAttributes.getResourceId(i11, 0);
            int i12 = R.styleable.CastMiniController_castStopButtonDrawable;
            this.zzo = obtainStyledAttributes.getResourceId(i12, 0);
            this.zzp = obtainStyledAttributes.getResourceId(i10, 0);
            this.zzq = obtainStyledAttributes.getResourceId(i11, 0);
            this.zzr = obtainStyledAttributes.getResourceId(i12, 0);
            this.zzs = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castSkipPreviousButtonDrawable, 0);
            this.zzt = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castSkipNextButtonDrawable, 0);
            this.zzu = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castRewind30ButtonDrawable, 0);
            this.zzv = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castForward30ButtonDrawable, 0);
            this.zzw = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castMuteToggleButtonDrawable, 0);
            this.zzx = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castClosedCaptionsButtonDrawable, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castControlButtons, 0);
            if (resourceId != 0) {
                TypedArray obtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                Preconditions.checkArgument(obtainTypedArray.length() == 3);
                this.zzj = new int[obtainTypedArray.length()];
                for (int i13 = 0; i13 < obtainTypedArray.length(); i13++) {
                    this.zzj[i13] = obtainTypedArray.getResourceId(i13, 0);
                }
                obtainTypedArray.recycle();
                if (this.zzb) {
                    this.zzj[0] = R.id.cast_button_type_empty;
                }
                this.zzl = 0;
                for (int i14 : this.zzj) {
                    if (i14 != R.id.cast_button_type_empty) {
                        this.zzl++;
                    }
                }
            } else {
                zza.w("Unable to read attribute castControlButtons.", new Object[0]);
                int i15 = R.id.cast_button_type_empty;
                this.zzj = new int[]{i15, i15, i15};
            }
            obtainStyledAttributes.recycle();
        }
        com.google.android.gms.internal.cast.zzl.zzd(zzju.CAF_MINI_CONTROLLER);
    }
}
