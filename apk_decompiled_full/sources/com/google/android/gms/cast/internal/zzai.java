package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.internal.cast.zzch;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/* loaded from: classes.dex */
public final class zzai {
    public static final Api.ClientKey<zzw> zza = new Api.ClientKey<>();
    public static final Api.ClientKey<zzx> zzb = new Api.ClientKey<>();
    public static final Api.ClientKey<zzch> zzc = new Api.ClientKey<>();
    public static final Api.ClientKey<zzcf> zzd = new Api.ClientKey<>();
    public static final Api.ClientKey zze = new Api.ClientKey();
    public static final Api.ClientKey zzf = new Api.ClientKey();
    public static final Charset zzg;
    public static final String zzh;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
        }
        zzg = charset;
        zzh = CastUtils.zzc("com.google.cast.multizone");
    }
}
