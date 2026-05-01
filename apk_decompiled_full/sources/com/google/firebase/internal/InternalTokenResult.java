package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.hpplay.component.common.ParamsMap;

@KeepForSdk
/* loaded from: classes2.dex */
public class InternalTokenResult {
    private String zza;

    @KeepForSdk
    public InternalTokenResult(String str) {
        this.zza = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return Objects.equal(this.zza, ((InternalTokenResult) obj).zza);
        }
        return false;
    }

    @KeepForSdk
    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, this.zza).toString();
    }
}
