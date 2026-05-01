package com.google.android.gms.cast.framework;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzju;

/* loaded from: classes.dex */
public interface IntroductoryOverlay {

    public static class Builder {
        private final Activity zza;
        private final View zzb;
        private int zzc;
        private String zzd;
        private OnOverlayDismissedListener zze;
        private boolean zzf;
        private float zzg;
        private String zzh;

        public Builder(@RecentlyNonNull Activity activity, @RecentlyNonNull MenuItem menuItem) {
            this.zza = (Activity) Preconditions.checkNotNull(activity);
            this.zzb = ((MenuItem) Preconditions.checkNotNull(menuItem)).getActionView();
        }

        @RecentlyNonNull
        public IntroductoryOverlay build() {
            com.google.android.gms.internal.cast.zzl.zzd(zzju.INSTRUCTIONS_VIEW);
            return PlatformVersion.isAtLeastJellyBean() ? new com.google.android.gms.internal.cast.zzy(this) : new com.google.android.gms.internal.cast.zzad(this, null, R.attr.castIntroOverlayStyle);
        }

        @RecentlyNonNull
        public Builder setButtonText(@RecentlyNonNull String str) {
            this.zzh = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setFocusRadius(float f10) {
            this.zzg = f10;
            return this;
        }

        @RecentlyNonNull
        public Builder setFocusRadiusId(int i10) {
            this.zzg = this.zza.getResources().getDimension(i10);
            return this;
        }

        @RecentlyNonNull
        public Builder setOnOverlayDismissedListener(@RecentlyNonNull OnOverlayDismissedListener onOverlayDismissedListener) {
            this.zze = onOverlayDismissedListener;
            return this;
        }

        @RecentlyNonNull
        public Builder setOverlayColor(int i10) {
            this.zzc = this.zza.getResources().getColor(i10);
            return this;
        }

        @RecentlyNonNull
        public Builder setSingleTime() {
            this.zzf = true;
            return this;
        }

        @RecentlyNonNull
        public Builder setTitleText(@RecentlyNonNull String str) {
            this.zzd = str;
            return this;
        }

        public final float zza() {
            return this.zzg;
        }

        public final int zzb() {
            return this.zzc;
        }

        @RecentlyNonNull
        public final Activity zzc() {
            return this.zza;
        }

        @RecentlyNonNull
        public final View zzd() {
            return this.zzb;
        }

        @RecentlyNonNull
        public final OnOverlayDismissedListener zze() {
            return this.zze;
        }

        @RecentlyNonNull
        public final String zzf() {
            return this.zzh;
        }

        @RecentlyNonNull
        public final String zzg() {
            return this.zzd;
        }

        public final boolean zzh() {
            return this.zzf;
        }

        @RecentlyNonNull
        public Builder setButtonText(int i10) {
            this.zzh = this.zza.getResources().getString(i10);
            return this;
        }

        @RecentlyNonNull
        public Builder setTitleText(int i10) {
            this.zzd = this.zza.getResources().getString(i10);
            return this;
        }

        public Builder(@RecentlyNonNull Activity activity, @RecentlyNonNull MediaRouteButton mediaRouteButton) {
            this.zza = (Activity) Preconditions.checkNotNull(activity);
            this.zzb = (View) Preconditions.checkNotNull(mediaRouteButton);
        }
    }

    public interface OnOverlayDismissedListener {
        void onOverlayDismissed();
    }

    void remove();

    void show();
}
