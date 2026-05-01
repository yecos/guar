package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zal extends com.google.android.gms.internal.base.zaa {
    public zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zae(zak zakVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, zakVar);
        zad(1, zaa);
    }
}
