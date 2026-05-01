package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public enum zznf {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzje.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zznf(Object obj) {
        this.zzk = obj;
    }
}
