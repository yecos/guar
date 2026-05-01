package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.g;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzhh {
    private final g zza;

    public zzhh(g gVar) {
        this.zza = gVar;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri == null) {
            return null;
        }
        g gVar = (g) this.zza.get(uri.toString());
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(String.valueOf(str3)));
    }
}
