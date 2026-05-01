package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;

/* loaded from: classes.dex */
public final class zzf extends AsyncTask<Uri, Long, Bitmap> {
    private static final Logger zza = new Logger("FetchBitmapTask");
    private final zzi zzb;
    private final zzb zzc;

    public zzf(Context context, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14, zzb zzbVar, byte[] bArr) {
        this.zzc = zzbVar;
        this.zzb = com.google.android.gms.internal.cast.zzm.zze(context.getApplicationContext(), this, new zze(this, null), i10, i11, false, 2097152L, 5, 333, 10000);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Bitmap doInBackground(Uri[] uriArr) {
        Uri uri;
        zzi zziVar;
        Uri[] uriArr2 = uriArr;
        if (uriArr2.length != 1 || (uri = uriArr2[0]) == null || (zziVar = this.zzb) == null) {
            return null;
        }
        try {
            return zziVar.zze(uri);
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "doFetch", zzi.class.getSimpleName());
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        zzb zzbVar = this.zzc;
        if (zzbVar != null) {
            zzbVar.zzb(bitmap2);
        }
    }
}
