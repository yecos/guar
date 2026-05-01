package com.google.android.gms.internal.cast;

import android.os.IInterface;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public interface zzq extends IInterface {
    com.google.android.gms.cast.framework.zzw zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzs zzsVar, Map map);

    com.google.android.gms.cast.framework.zzz zzf(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzt zztVar);

    com.google.android.gms.cast.framework.zzag zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    com.google.android.gms.cast.framework.zzaj zzh(String str, String str2, com.google.android.gms.cast.framework.zzar zzarVar);

    com.google.android.gms.cast.framework.media.internal.zzi zzi(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14);
}
