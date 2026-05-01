package com.google.android.gms.common.moduleinstall.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* loaded from: classes.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }

    public final void zae(zae zaeVar, ApiFeatureRequest apiFeatureRequest) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, zaeVar);
        com.google.android.gms.internal.base.zac.zad(zaa, apiFeatureRequest);
        zac(1, zaa);
    }

    public final void zaf(zae zaeVar, ApiFeatureRequest apiFeatureRequest) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, zaeVar);
        com.google.android.gms.internal.base.zac.zad(zaa, apiFeatureRequest);
        zac(3, zaa);
    }

    public final void zag(zae zaeVar, ApiFeatureRequest apiFeatureRequest, zah zahVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, zaeVar);
        com.google.android.gms.internal.base.zac.zad(zaa, apiFeatureRequest);
        com.google.android.gms.internal.base.zac.zae(zaa, zahVar);
        zac(2, zaa);
    }

    public final void zah(IStatusCallback iStatusCallback, ApiFeatureRequest apiFeatureRequest) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, iStatusCallback);
        com.google.android.gms.internal.base.zac.zad(zaa, apiFeatureRequest);
        zac(4, zaa);
    }

    public final void zai(IStatusCallback iStatusCallback, zah zahVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, iStatusCallback);
        com.google.android.gms.internal.base.zac.zae(zaa, zahVar);
        zac(6, zaa);
    }
}
