package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaUtils;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.images.WebImage;

/* loaded from: classes.dex */
public final class zzay extends UIController {
    private final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    private final View zzd;
    private final ImagePicker zze;
    private final com.google.android.gms.cast.framework.media.internal.zzb zzf;

    public zzay(ImageView imageView, Context context, ImageHints imageHints, int i10, View view) {
        this.zza = imageView;
        this.zzb = imageHints;
        this.zzc = i10 != 0 ? BitmapFactory.decodeResource(context.getResources(), i10) : null;
        this.zzd = view;
        CastContext zza = CastContext.zza(context);
        if (zza != null) {
            CastMediaOptions castMediaOptions = zza.getCastOptions().getCastMediaOptions();
            this.zze = castMediaOptions != null ? castMediaOptions.getImagePicker() : null;
        } else {
            this.zze = null;
        }
        this.zzf = new com.google.android.gms.cast.framework.media.internal.zzb(context.getApplicationContext());
    }

    private final void zzc() {
        View view = this.zzd;
        if (view != null) {
            view.setVisibility(0);
            this.zza.setVisibility(4);
        }
        Bitmap bitmap = this.zzc;
        if (bitmap != null) {
            this.zza.setImageBitmap(bitmap);
        }
    }

    private final void zzd() {
        Uri imageUri;
        WebImage onPickImage;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            zzc();
            return;
        }
        MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
        if (mediaInfo == null) {
            imageUri = null;
        } else {
            ImagePicker imagePicker = this.zze;
            imageUri = (imagePicker == null || (onPickImage = imagePicker.onPickImage(mediaInfo.getMetadata(), this.zzb)) == null || onPickImage.getUrl() == null) ? MediaUtils.getImageUri(mediaInfo, 0) : onPickImage.getUrl();
        }
        if (imageUri == null) {
            zzc();
        } else {
            this.zzf.zzd(imageUri);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zzf.zzc(new zzax(this));
        zzc();
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zzf.zza();
        zzc();
        super.onSessionEnded();
    }
}
