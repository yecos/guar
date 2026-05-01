package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public enum zzrt {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzoe.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zzrt(Object obj) {
        this.zzk = obj;
    }
}
