package com.google.android.gms.cast.framework.media.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzq;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzbs;
import com.google.android.gms.internal.cast.zzbt;
import com.google.android.gms.internal.cast.zzbu;
import com.google.android.gms.internal.cast.zzbv;
import com.google.android.gms.internal.cast.zzju;
import java.util.Timer;

/* loaded from: classes.dex */
public abstract class ExpandedControllerActivity extends d implements ControlButtonsContainer {
    private View zzB;
    private View zzC;
    private ImageView zzD;
    private TextView zzE;
    private TextView zzF;
    private TextView zzG;
    private TextView zzH;
    private com.google.android.gms.cast.framework.media.internal.zzb zzI;
    private UIMediaController zzJ;
    private SessionManager zzK;
    private boolean zzL;
    private boolean zzM;
    private Timer zzN;
    private String zzO;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private TextView zzu;
    private SeekBar zzv;
    private CastSeekBar zzw;
    private ImageView zzx;
    private ImageView zzy;
    private int[] zzz;
    private final SessionManagerListener<CastSession> zza = new zzo(this, null);
    private final RemoteMediaClient.Listener zzb = new zzm(this, 0 == true ? 1 : 0);
    private ImageView[] zzA = new ImageView[4];

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteMediaClient zzl() {
        CastSession currentCastSession = this.zzK.getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return null;
        }
        return currentCastSession.getRemoteMediaClient();
    }

    private final void zzm(String str) {
        this.zzI.zzd(Uri.parse(str));
        this.zzC.setVisibility(8);
    }

    private final void zzn(View view, int i10, int i11, UIMediaController uIMediaController) {
        ImageView imageView = (ImageView) view.findViewById(i10);
        if (i11 == R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
            return;
        }
        if (i11 == R.id.cast_button_type_play_pause_toggle) {
            imageView.setBackgroundResource(this.zzc);
            Drawable zzb = zzp.zzb(this, this.zzq, this.zze);
            Drawable zzb2 = zzp.zzb(this, this.zzq, this.zzd);
            Drawable zzb3 = zzp.zzb(this, this.zzq, this.zzf);
            imageView.setImageDrawable(zzb2);
            uIMediaController.bindImageViewToPlayPauseToggle(imageView, zzb2, zzb, zzb3, null, false);
            return;
        }
        if (i11 == R.id.cast_button_type_skip_previous) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzp.zzb(this, this.zzq, this.zzg));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_prev));
            uIMediaController.bindViewToSkipPrev(imageView, 0);
            return;
        }
        if (i11 == R.id.cast_button_type_skip_next) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzp.zzb(this, this.zzq, this.zzh));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_next));
            uIMediaController.bindViewToSkipNext(imageView, 0);
            return;
        }
        if (i11 == R.id.cast_button_type_rewind_30_seconds) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzp.zzb(this, this.zzq, this.zzi));
            imageView.setContentDescription(getResources().getString(R.string.cast_rewind_30));
            uIMediaController.bindViewToRewind(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
            return;
        }
        if (i11 == R.id.cast_button_type_forward_30_seconds) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzp.zzb(this, this.zzq, this.zzj));
            imageView.setContentDescription(getResources().getString(R.string.cast_forward_30));
            uIMediaController.bindViewToForward(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
            return;
        }
        if (i11 == R.id.cast_button_type_mute_toggle) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzp.zzb(this, this.zzq, this.zzk));
            uIMediaController.bindImageViewToMuteToggle(imageView);
        } else if (i11 == R.id.cast_button_type_closed_caption) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzp.zzb(this, this.zzq, this.zzl));
            uIMediaController.bindViewToClosedCaption(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo(RemoteMediaClient remoteMediaClient) {
        MediaStatus mediaStatus;
        if (this.zzL || (mediaStatus = remoteMediaClient.getMediaStatus()) == null || remoteMediaClient.isBuffering()) {
            return;
        }
        this.zzG.setVisibility(8);
        this.zzH.setVisibility(8);
        AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
        if (currentAdBreakClip == null || currentAdBreakClip.getWhenSkippableInMs() == -1) {
            return;
        }
        if (!this.zzM) {
            zzk zzkVar = new zzk(this, remoteMediaClient);
            Timer timer = new Timer();
            this.zzN = timer;
            timer.scheduleAtFixedRate(zzkVar, 0L, 500L);
            this.zzM = true;
        }
        if (currentAdBreakClip.getWhenSkippableInMs() - remoteMediaClient.getApproximateAdBreakClipPositionMs() > 0.0f) {
            this.zzH.setVisibility(0);
            this.zzH.setText(getResources().getString(R.string.cast_expanded_controller_skip_ad_text, Integer.valueOf((int) Math.ceil(r10 / 1000.0f))));
            this.zzG.setClickable(false);
        } else {
            if (this.zzM) {
                this.zzN.cancel();
                this.zzM = false;
            }
            this.zzG.setVisibility(0);
            this.zzG.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp() {
        CastDevice castDevice;
        CastSession currentCastSession = this.zzK.getCurrentCastSession();
        if (currentCastSession != null && (castDevice = currentCastSession.getCastDevice()) != null) {
            String friendlyName = castDevice.getFriendlyName();
            if (!TextUtils.isEmpty(friendlyName)) {
                this.zzu.setText(getResources().getString(R.string.cast_casting_to_device, friendlyName));
                return;
            }
        }
        this.zzu.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzq() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        a supportActionBar;
        RemoteMediaClient zzl = zzl();
        if (zzl == null || !zzl.hasMediaSession() || (mediaInfo = zzl.getMediaInfo()) == null || (metadata = mediaInfo.getMetadata()) == null || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.w(metadata.getString(MediaMetadata.KEY_TITLE));
        supportActionBar.v(zzq.zza(metadata));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzr() {
        MediaStatus mediaStatus;
        String str;
        Drawable drawable;
        Bitmap bitmap;
        Bitmap zza;
        RemoteMediaClient zzl = zzl();
        if (zzl == null || (mediaStatus = zzl.getMediaStatus()) == null) {
            return;
        }
        String str2 = null;
        if (!mediaStatus.isPlayingAd()) {
            this.zzH.setVisibility(8);
            this.zzG.setVisibility(8);
            this.zzB.setVisibility(8);
            if (PlatformVersion.isAtLeastJellyBeanMR1()) {
                this.zzy.setVisibility(8);
                this.zzy.setImageBitmap(null);
                return;
            }
            return;
        }
        if (PlatformVersion.isAtLeastJellyBeanMR1() && this.zzy.getVisibility() == 8 && (drawable = this.zzx.getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && (zza = zzp.zza(this, bitmap, 0.25f, 7.5f)) != null) {
            this.zzy.setImageBitmap(zza);
            this.zzy.setVisibility(0);
        }
        AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
        if (currentAdBreakClip != null) {
            String title = currentAdBreakClip.getTitle();
            str2 = currentAdBreakClip.getImageUrl();
            str = title;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            zzm(str2);
        } else if (TextUtils.isEmpty(this.zzO)) {
            this.zzE.setVisibility(0);
            this.zzC.setVisibility(0);
            this.zzD.setVisibility(8);
        } else {
            zzm(this.zzO);
        }
        TextView textView = this.zzF;
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.cast_ad_label);
        }
        textView.setText(str);
        if (PlatformVersion.isAtLeastM()) {
            this.zzF.setTextAppearance(this.zzr);
        } else {
            this.zzF.setTextAppearance(this, this.zzr);
        }
        this.zzB.setVisibility(0);
        zzo(zzl);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    @RecentlyNonNull
    public final ImageView getButtonImageViewAt(int i10) {
        return this.zzA[i10];
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonSlotCount() {
        return 4;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonTypeAt(int i10) {
        return this.zzz[i10];
    }

    @RecentlyNonNull
    @Deprecated
    public SeekBar getSeekBar() {
        return this.zzv;
    }

    @RecentlyNonNull
    public TextView getStatusTextView() {
        return this.zzu;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    @RecentlyNonNull
    public UIMediaController getUIMediaController() {
        return this.zzJ;
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SessionManager sessionManager = CastContext.getSharedInstance(this).getSessionManager();
        this.zzK = sessionManager;
        if (sessionManager.getCurrentCastSession() == null) {
            finish();
        }
        UIMediaController uIMediaController = new UIMediaController(this);
        this.zzJ = uIMediaController;
        uIMediaController.setPostRemoteMediaClientListener(this.zzb);
        setContentView(R.layout.cast_expanded_controller_activity);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{R$attr.selectableItemBackgroundBorderless});
        this.zzc = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = obtainStyledAttributes(null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        this.zzq = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castButtonColor, 0);
        this.zzd = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castPlayButtonDrawable, 0);
        this.zze = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castPauseButtonDrawable, 0);
        this.zzf = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castStopButtonDrawable, 0);
        this.zzg = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castSkipPreviousButtonDrawable, 0);
        this.zzh = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castSkipNextButtonDrawable, 0);
        this.zzi = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castRewind30ButtonDrawable, 0);
        this.zzj = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castForward30ButtonDrawable, 0);
        this.zzk = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castMuteToggleButtonDrawable, 0);
        this.zzl = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castClosedCaptionsButtonDrawable, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castControlButtons, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            Preconditions.checkArgument(obtainTypedArray.length() == 4);
            this.zzz = new int[obtainTypedArray.length()];
            for (int i10 = 0; i10 < obtainTypedArray.length(); i10++) {
                this.zzz[i10] = obtainTypedArray.getResourceId(i10, 0);
            }
            obtainTypedArray.recycle();
        } else {
            int i11 = R.id.cast_button_type_empty;
            this.zzz = new int[]{i11, i11, i11, i11};
        }
        this.zzp = obtainStyledAttributes2.getColor(R.styleable.CastExpandedController_castExpandedControllerLoadingIndicatorColor, 0);
        this.zzm = getResources().getColor(obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelColor, 0));
        this.zzn = getResources().getColor(obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressTextColor, 0));
        this.zzo = getResources().getColor(obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelTextColor, 0));
        this.zzr = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelTextAppearance, 0);
        this.zzs = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressLabelTextAppearance, 0);
        this.zzt = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressText, 0);
        int resourceId2 = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castDefaultAdPosterUrl, 0);
        if (resourceId2 != 0) {
            this.zzO = getApplicationContext().getResources().getString(resourceId2);
        }
        obtainStyledAttributes2.recycle();
        View findViewById = findViewById(R.id.expanded_controller_layout);
        UIMediaController uIMediaController2 = this.zzJ;
        this.zzx = (ImageView) findViewById.findViewById(R.id.background_image_view);
        this.zzy = (ImageView) findViewById.findViewById(R.id.blurred_background_image_view);
        View findViewById2 = findViewById.findViewById(R.id.background_place_holder_image_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        uIMediaController2.bindImageViewToImageOfCurrentItem(this.zzx, new ImageHints(4, displayMetrics.widthPixels, displayMetrics.heightPixels), findViewById2);
        this.zzu = (TextView) findViewById.findViewById(R.id.status_text);
        ProgressBar progressBar = (ProgressBar) findViewById.findViewById(R.id.loading_indicator);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        int i12 = this.zzp;
        if (i12 != 0) {
            indeterminateDrawable.setColorFilter(i12, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController2.bindViewToLoadingIndicator(progressBar);
        TextView textView = (TextView) findViewById.findViewById(R.id.start_text);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.end_text);
        this.zzv = (SeekBar) findViewById.findViewById(R.id.seek_bar);
        CastSeekBar castSeekBar = (CastSeekBar) findViewById.findViewById(R.id.cast_seek_bar);
        this.zzw = castSeekBar;
        uIMediaController2.bindSeekBar(castSeekBar, 1000L);
        uIMediaController2.bindViewToUIController(textView, new zzbu(textView, uIMediaController2.zza()));
        uIMediaController2.bindViewToUIController(textView2, new zzbs(textView2, uIMediaController2.zza()));
        View findViewById3 = findViewById.findViewById(R.id.live_indicators);
        UIMediaController uIMediaController3 = this.zzJ;
        uIMediaController3.bindViewToUIController(findViewById3, new zzbt(findViewById3, uIMediaController3.zza()));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById.findViewById(R.id.tooltip_container);
        zzbv zzbvVar = new zzbv(relativeLayout, this.zzw, this.zzJ.zza());
        this.zzJ.bindViewToUIController(relativeLayout, zzbvVar);
        this.zzJ.zze(zzbvVar);
        ImageView[] imageViewArr = this.zzA;
        int i13 = R.id.button_0;
        imageViewArr[0] = (ImageView) findViewById.findViewById(i13);
        ImageView[] imageViewArr2 = this.zzA;
        int i14 = R.id.button_1;
        imageViewArr2[1] = (ImageView) findViewById.findViewById(i14);
        ImageView[] imageViewArr3 = this.zzA;
        int i15 = R.id.button_2;
        imageViewArr3[2] = (ImageView) findViewById.findViewById(i15);
        ImageView[] imageViewArr4 = this.zzA;
        int i16 = R.id.button_3;
        imageViewArr4[3] = (ImageView) findViewById.findViewById(i16);
        zzn(findViewById, i13, this.zzz[0], uIMediaController2);
        zzn(findViewById, i14, this.zzz[1], uIMediaController2);
        zzn(findViewById, R.id.button_play_pause_toggle, R.id.cast_button_type_play_pause_toggle, uIMediaController2);
        zzn(findViewById, i15, this.zzz[2], uIMediaController2);
        zzn(findViewById, i16, this.zzz[3], uIMediaController2);
        View findViewById4 = findViewById(R.id.ad_container);
        this.zzB = findViewById4;
        this.zzD = (ImageView) findViewById4.findViewById(R.id.ad_image_view);
        this.zzC = this.zzB.findViewById(R.id.ad_background_image_view);
        TextView textView3 = (TextView) this.zzB.findViewById(R.id.ad_label);
        this.zzF = textView3;
        textView3.setTextColor(this.zzo);
        this.zzF.setBackgroundColor(this.zzm);
        this.zzE = (TextView) this.zzB.findViewById(R.id.ad_in_progress_label);
        this.zzH = (TextView) findViewById(R.id.ad_skip_text);
        TextView textView4 = (TextView) findViewById(R.id.ad_skip_button);
        this.zzG = textView4;
        textView4.setOnClickListener(new zzi(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
            supportActionBar.t(R.drawable.quantum_ic_keyboard_arrow_down_white_36);
        }
        zzp();
        zzq();
        if (this.zzE != null && this.zzt != 0) {
            if (PlatformVersion.isAtLeastM()) {
                this.zzE.setTextAppearance(this.zzs);
            } else {
                this.zzE.setTextAppearance(getApplicationContext(), this.zzs);
            }
            this.zzE.setTextColor(this.zzn);
            this.zzE.setText(this.zzt);
        }
        com.google.android.gms.cast.framework.media.internal.zzb zzbVar = new com.google.android.gms.cast.framework.media.internal.zzb(getApplicationContext(), new ImageHints(-1, this.zzD.getWidth(), this.zzD.getHeight()));
        this.zzI = zzbVar;
        zzbVar.zzc(new zzh(this));
        com.google.android.gms.internal.cast.zzl.zzd(zzju.CAF_EXPANDED_CONTROLLER);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        this.zzI.zza();
        UIMediaController uIMediaController = this.zzJ;
        if (uIMediaController != null) {
            uIMediaController.setPostRemoteMediaClientListener(null);
            this.zzJ.dispose();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@RecentlyNonNull MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        CastContext.getSharedInstance(this).getSessionManager().removeSessionManagerListener(this.zza, CastSession.class);
        super.onPause();
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        CastContext.getSharedInstance(this).getSessionManager().addSessionManagerListener(this.zza, CastSession.class);
        CastSession currentCastSession = CastContext.getSharedInstance(this).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || (!currentCastSession.isConnected() && !currentCastSession.isConnecting())) {
            finish();
        }
        RemoteMediaClient zzl = zzl();
        boolean z10 = true;
        if (zzl != null && zzl.hasMediaSession()) {
            z10 = false;
        }
        this.zzL = z10;
        zzp();
        zzr();
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() ^ 2;
            if (PlatformVersion.isAtLeastJellyBean()) {
                systemUiVisibility ^= 4;
            }
            if (PlatformVersion.isAtLeastKitKat()) {
                systemUiVisibility ^= 4096;
            }
            getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
            if (PlatformVersion.isAtLeastJellyBeanMR2()) {
                setImmersive(true);
            }
        }
    }
}
