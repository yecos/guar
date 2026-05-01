package com.google.android.gms.internal.cast;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzm {
    private static final Logger zza = new Logger("CastDynamiteModule");

    public static com.google.android.gms.cast.framework.zzw zza(Context context, CastOptions castOptions, zzs zzsVar, Map<String, IBinder> map) {
        return zzf(context).zze(ObjectWrapper.wrap(context.getApplicationContext()), castOptions, zzsVar, map);
    }

    public static com.google.android.gms.cast.framework.zzz zzb(Context context, CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzt zztVar) {
        if (iObjectWrapper == null) {
            return null;
        }
        try {
            return zzf(context).zzf(castOptions, iObjectWrapper, zztVar);
        } catch (RemoteException | com.google.android.gms.cast.framework.zzat e10) {
            zza.d(e10, "Unable to call %s on %s.", "newCastSessionImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    public static com.google.android.gms.cast.framework.zzag zzc(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        if (iObjectWrapper != null && iObjectWrapper2 != null) {
            try {
                return zzf(service.getApplicationContext()).zzg(ObjectWrapper.wrap(service), iObjectWrapper, iObjectWrapper2);
            } catch (RemoteException | com.google.android.gms.cast.framework.zzat e10) {
                zza.d(e10, "Unable to call %s on %s.", "newReconnectionServiceImpl", zzq.class.getSimpleName());
            }
        }
        return null;
    }

    public static com.google.android.gms.cast.framework.zzaj zzd(Context context, String str, String str2, com.google.android.gms.cast.framework.zzar zzarVar) {
        try {
            return zzf(context).zzh(str, str2, zzarVar);
        } catch (RemoteException | com.google.android.gms.cast.framework.zzat e10) {
            zza.d(e10, "Unable to call %s on %s.", "newSessionImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    public static com.google.android.gms.cast.framework.media.internal.zzi zze(Context context, AsyncTask<Uri, Long, Bitmap> asyncTask, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) {
        try {
            return zzf(context.getApplicationContext()).zzi(ObjectWrapper.wrap(asyncTask), zzkVar, i10, i11, false, 2097152L, 5, 333, 10000);
        } catch (RemoteException | com.google.android.gms.cast.framework.zzat e10) {
            zza.d(e10, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    private static zzq zzf(Context context) {
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cast.framework.dynamite").instantiate("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (instantiate == null) {
                return null;
            }
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            return queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzp(instantiate);
        } catch (DynamiteModule.LoadingException e10) {
            throw new com.google.android.gms.cast.framework.zzat(e10);
        }
    }
}
